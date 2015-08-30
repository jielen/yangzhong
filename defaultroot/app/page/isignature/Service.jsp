
<%@page import="weblogic.jdbc.vendor.oracle.OracleThinBlob"%><%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.net.*"%>
<%@ page import="DBstep.*"%>
<%@ page import="oracle.sql.BLOB"%>
<%@ page import="oracle.jdbc.*"%>

<%
	iDBManager2000 ObjConnBean = new iDBManager2000();
	String mCommand;
	String mDocumentID = "";
	String mSignatureID = "";
	String mSignature = "";
	String mSignatures;

	String strSql;
	String mUserName;
	String mExtParam;

	boolean mResult;
	java.lang.String KeyName; //�ļ���
	java.io.File ObjFile; //�ļ�����
	java.io.FileReader ObjFileReader; //���ļ�����
	char[] ChrBuffer; //����
	int intLength; //ʵ�ʶ������ַ���

	byte[] SignatureBody = null;
	int mSignatureSize;

	String mSignatureName; //ӡ������
	String mSignatureUnit; //ǩ�µ�λ
	String mSignatureUser; //������
	String mSignatureSN; //ǩ��SN
	String mSignatureGUID; //ȫ��Ψһ��ʶ��

	String mMACHIP; //����IP
	String OPType; //������־
	String mKeySn; //KEY���к�
	mCommand = request.getParameter("COMMAND");
	mUserName = new String(request.getParameter("USERNAME").getBytes(
			"8859_1"));
	mExtParam = new String(request.getParameter("EXTPARAM").getBytes(
			"8859_1"));

	System.out.println("");
	System.out.println("ReadPackage");
	System.out.println(mCommand);

	if (mCommand.equalsIgnoreCase("SAVESIGNATURE")) {
		mDocumentID = new String(request.getParameter("DOCUMENTID")
				.getBytes("8859_1"));
		mSignatureID = new String(request.getParameter("SIGNATUREID")
				.getBytes("8859_1"));
		mSignature = new String(request.getParameter("SIGNATURE")
				.getBytes("8859_1"));
		SignatureBody = mSignature.getBytes();
		mSignatureSize = SignatureBody.length;
		strSql = "SELECT * from HTMLSignature Where SignatureID='"
				+ mSignatureID + "' and DocumentID='" + mDocumentID
				+ "'";
		try {
			if (ObjConnBean.OpenConnection()) {
				try {
					ResultSet result = ObjConnBean.ExecuteQuery(strSql);
					if (result.next()) {
						strSql = "update HTMLSignature set DocumentID=?,SIGNATUREID=?,SignatureSize=?,Signature=EMPTY_BLOB() Where SignatureID='"
								+ mSignatureID
								+ "' and DocumentID='"
								+ mDocumentID + "'";
					} else {
						strSql = "insert into HTMLSignature (DocumentID,SignatureID,SignatureSize,Signature) values (?,?,?,EMPTY_BLOB()) ";
						java.util.Date dt = new java.util.Date();
						long lg = dt.getTime();
						Long ld = new Long(lg);
						mSignatureID = ld.toString();
					}
					result.close();
				} catch (SQLException e) {
					System.out.println(e.toString());
				}
				java.sql.PreparedStatement prestmt = null;
				try {
					prestmt = ObjConnBean.Conn.prepareStatement(strSql);
					prestmt.setString(1, mDocumentID);
					prestmt.setString(2, mSignatureID);
					prestmt.setInt(3, mSignatureSize);
					ObjConnBean.Conn.setAutoCommit(true);
					prestmt.execute();
					ObjConnBean.Conn.commit();
					prestmt.close();
					Statement stmt = null;
					ObjConnBean.Conn.setAutoCommit(false);
					stmt = ObjConnBean.Conn.createStatement();
					ResultSet rs = stmt
							.executeQuery("select Signature from HTMLSignature Where SignatureID='"
									+ mSignatureID
									+ "' and DocumentID='"
									+ mDocumentID + "'" + " for update");
					oracle.jdbc.OracleResultSet update = (OracleResultSet) rs;

					if (update.next()) {
						try {
							//oracle.sql.BLOB Signature = (oracle.sql.BLOB) update
									//.getBLOB("Signature");
							//System.out.println(Signature);
							System.out.println("��ʼת��ΪOracleThinBlob-------------------------------");
							OracleThinBlob blob = (weblogic.jdbc.vendor.oracle.OracleThinBlob) rs.getBlob(1);
							System.out.println("ת���ɹ�-------------------------------");
							try {
								int vSize = SignatureBody.length;
								OutputStream outstream = blob.getBinaryOutputStream();
								outstream.write(SignatureBody, 0, vSize);
								outstream.flush();
								outstream.close();
							} catch (SQLException e) {
								System.out.println(e.toString());
							}
							
							
							
							
							
							//ObjConnBean.PutAtBlob(Signature,
							//		SignatureBody);
						} catch (IOException e) {
							System.out.println(e.toString());
						}
					}
					update.close();
					stmt.close();
					ObjConnBean.Conn.commit();
					SignatureBody = null;
				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		} finally {
			ObjConnBean.CloseConnection();
		}
		out.clear();
		out.print("SIGNATUREID=" + mSignatureID + "\r\n");
		out.print("RESULT=OK");
	}

	if (mCommand.equalsIgnoreCase("GETNOWTIME")) { //��ȡ������ʱ��
		java.sql.Date mDate;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		String mDateTime = formatter.format(cal.getTime());
		out.clear();
		out.print("NOWTIME=" + mDateTime + "\r\n");
		out.print("RESULT=OK");
	}
	if (mCommand.equalsIgnoreCase("DELESIGNATURE")) { //ɾ��ǩ��������Ϣ
		mDocumentID = request.getParameter("DOCUMENTID");
		mSignatureID = request.getParameter("SIGNATUREID");
		System.out.println("DocuemntID:" + mDocumentID);
		System.out.println("SignatureID:" + mSignatureID);
		if (ObjConnBean.OpenConnection()) {
			strSql = "SELECT * from HTMLSignature Where SignatureID='"
					+ mSignatureID + "' and DocumentID='" + mDocumentID
					+ "'";
			ResultSet rs = null;
			rs = ObjConnBean.ExecuteQuery(strSql);
			if (rs.next()) {
				try {
					strSql = "DELETE from HTMLSignature Where SignatureID='"
							+ mSignatureID
							+ "' and DocumentID='"
							+ mDocumentID + "'";
					ObjConnBean.ExecuteUpdate(strSql);
				} catch (Exception ex) {
					out.println(ex.toString());
				}
			}
			ObjConnBean.CloseConnection();
		}
		out.clear();
		out.print("RESULT=OK");
	}

	if (mCommand.equalsIgnoreCase("LOADSIGNATURE")) { //����ǩ��������Ϣ
		mDocumentID = request.getParameter("DOCUMENTID");
		mSignatureID = request.getParameter("SIGNATUREID");
		System.out.println("DocuemntID:" + mDocumentID);
		System.out.println("SignatureID:" + mSignatureID);
		if (ObjConnBean.OpenConnection()) {
			strSql = "SELECT Signature,SignatureSize from HTMLSignature Where SignatureID='"
					+ mSignatureID
					+ "' and DocumentID='"
					+ mDocumentID
					+ "'";
			ResultSet rs = null;
			rs = ObjConnBean.ExecuteQuery(strSql);
			if (rs.next()) {
				mSignatureSize = rs.getInt("SignatureSize");
				mSignature = ObjConnBean.GetAtBlob(rs
						.getBlob("Signature"), mSignatureSize);
				System.out.println(mSignature);

			}
			ObjConnBean.CloseConnection();
		}
		out.clear();
		out.print(mSignature + "\r\n");
		out.print("RESULT=OK");
	}

	if (mCommand.equalsIgnoreCase("SHOWSIGNATURE")) { //��ȡ��ǰǩ��SignatureID������SignatureID�����Զ���LOADSIGNATURE����
		mDocumentID = request.getParameter("DOCUMENTID");
		System.out.println("DocuemntID:" + mDocumentID);
		mSignatures = "";
		if (ObjConnBean.OpenConnection()) {
			strSql = "SELECT * from HTMLSignature Where DocumentID='"
					+ mDocumentID + "'";
			ResultSet rs = null;
			rs = ObjConnBean.ExecuteQuery(strSql);
			while (rs.next()) {
				mSignatures = mSignatures + rs.getString("SignatureID")
						+ ";";
			}
			ObjConnBean.CloseConnection();
		}
		out.clear();
		out.print("SIGNATURES=" + mSignatures + "\r\n");
		out.print("RESULT=OK");
	}

	//---------------------------------------------------------------------------------------
	if (mCommand.equalsIgnoreCase("GETSIGNATUREDATA")) { //����ǩ��ʱ����ȡ��Ҫ����������
		String mSignatureData = "";
		mDocumentID = request.getParameter("DOCUMENTID");
		System.out.println(new String(request
				.getParameter("FIELDSLIST").getBytes("8859_1")));
		System.out.println(request.getParameter("FIELDSNAME"));
		if (ObjConnBean.OpenConnection()) {
			strSql = "SELECT XYBH,BMJH,JF,YF,HZNR,QLZR,CPMC,DGSL,DGRQ  from HTMLDocument Where DocumentID='"
					+ mDocumentID + "'";
			ResultSet rs = null;
			rs = ObjConnBean.ExecuteQuery(strSql);
			if (rs.next()) {
				mSignatureData = mSignatureData + "XYBH="
						+ (rs.getString("XYBH")) + "\r\n";
				mSignatureData = mSignatureData + "BMJH="
						+ (rs.getString("BMJH")) + "\r\n";
				mSignatureData = mSignatureData + "JF="
						+ (rs.getString("JF")) + "\r\n";
				mSignatureData = mSignatureData + "YF="
						+ (rs.getString("YF")) + "\r\n";
				mSignatureData = mSignatureData + "HZNR="
						+ (rs.getString("HZNR")) + "\r\n";
				mSignatureData = mSignatureData + "QLZR="
						+ (rs.getString("QLZR")) + "\r\n";
				mSignatureData = mSignatureData + "CPMC="
						+ (rs.getString("CPMC")) + "\r\n";
				mSignatureData = mSignatureData + "DGSL="
						+ (rs.getString("DGSL")) + "\r\n";
				mSignatureData = mSignatureData + "DGRQ="
						+ (rs.getString("DGRQ")) + "\r\n";
			}
			mSignatureData = java.net.URLEncoder.encode(mSignatureData);
			ObjConnBean.CloseConnection();
		}
		out.clear();
		out.print("SIGNATUREDATA=" + mSignatureData + "\r\n");
		out.print("RESULT=OK");
	}

	if (mCommand.equalsIgnoreCase("PUTSIGNATUREDATA")) { //����ǩ��ʱ��д��ǩ������
		mDocumentID = new String(request.getParameter("DOCUMENTID")
				.getBytes("8859_1"));
		mSignature = new String(request.getParameter("SIGNATURE")
				.getBytes("8859_1"));
		SignatureBody = mSignature.getBytes();
		mSignatureSize = SignatureBody.length;
		if (ObjConnBean.OpenConnection()) {
			java.sql.PreparedStatement prestmt = null;
			try {
				//ȡ��Ψһֵ(mSignature)
				java.util.Date dt = new java.util.Date();
				long lg = dt.getTime();
				Long ld = new Long(lg);
				mSignatureID = ld.toString();
				System.out.println(mDocumentID);
				String Sql = "insert into HTMLSignature (DocumentID,SignatureID,SignatureSize,Signature) values (?,?,?,EMPTY_BLOB()) ";
				prestmt = ObjConnBean.Conn.prepareStatement(Sql);
				prestmt.setString(1, mDocumentID);
				prestmt.setString(2, mSignatureID);
				prestmt.setInt(3, mSignatureSize);

				System.out.println(mDocumentID);

				ObjConnBean.Conn.setAutoCommit(true);
				prestmt.execute();
				ObjConnBean.Conn.commit();
				prestmt.close();
				Statement stmt = null;
				ObjConnBean.Conn.setAutoCommit(false);
				stmt = ObjConnBean.Conn.createStatement();
				OracleResultSet update = (OracleResultSet) stmt
						.executeQuery("select Signature from HTMLSignature Where SignatureID='"
								+ mSignatureID
								+ "' and DocumentID='"
								+ mDocumentID + "'" + " for update");
				if (update.next()) {
					try {
						ObjConnBean.PutAtBlob(
								((oracle.jdbc.OracleResultSet) update)
										.getBLOB("Signature"),
								SignatureBody);
					} catch (IOException e) {
						System.out.println(e.toString());
					}
				}
				update.close();
				stmt.close();
				ObjConnBean.Conn.commit();
				SignatureBody = null;
				mResult = true;
			} catch (SQLException e) {
				System.out.println(e.toString());
				mResult = false;
			}
			ObjConnBean.CloseConnection();
		}
		out.clear();
		out.print("SIGNATUREID=" + mSignatureID + "\r\n");
		out.print("RESULT=OK");
	}

	//---------------------------------------------------------------------------------------

	if (mCommand.equalsIgnoreCase("SIGNATUREKEY")) {
		mUserName = new String(request.getParameter("USERNAME")
				.getBytes("8859_1"));
		String RealPath = mUserName + "\\" + mUserName + ".key";
		KeyName = application.getRealPath(RealPath);

		ObjFile = new java.io.File(KeyName); //�����ļ����� 
		ChrBuffer = new char[10];
		try {
			if (ObjFile.exists()) {//�ļ����� 
				InputStreamReader isr = new InputStreamReader(
						new FileInputStream(KeyName));
				//ObjFileReader = new java.io.FileReader(ObjFile); 		//�������ļ����� 
				//ObjFileReader.skip(1);
				//ObjFileReader.read(ChrBuffer, 0, 1);
				//System.out.println(ChrBuffer);
				while ((intLength = isr.read(ChrBuffer)) != -1) { //���ļ����� 
					out.write(ChrBuffer, 0, intLength);
				}
				out.write("\r\n");
				out.write("RESULT=OK");
				isr.close(); //�رն��ļ����� 
			} else {
				out.println("File Not Found" + KeyName); //�ļ������� 
			}
		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

	if (mCommand.equalsIgnoreCase("SAVEHISTORY")) { //����ǩ����ʷ��Ϣ
		mSignatureName = new String(request.getParameter(
				"SIGNATURENAME").getBytes("8859_1"));//ӡ������
		mSignatureUnit = new String(request.getParameter(
				"SIGNATUREUNIT").getBytes("8859_1"));//ӡ�µ�λ
		mSignatureUser = new String(request.getParameter(
				"SIGNATUREUSER").getBytes("8859_1"));//ӡ���û���
		mSignatureSN = new String(request.getParameter("SIGNATURESN")
				.getBytes("8859_1"));//ӡ�����к�
		mSignatureGUID = new String(request.getParameter(
				"SIGNATUREGUID").getBytes("8859_1"));//ȫ��Ψһ��ʶ
		mDocumentID = new String(request.getParameter("DOCUMENTID")
				.getBytes("8859_1"));//ҳ��ID
		mSignatureID = new String(request.getParameter("SIGNATUREID")
				.getBytes("8859_1"));//ǩ�����к�
		mMACHIP = new String(request.getParameter("MACHIP").getBytes(
				"8859_1"));//ǩ�»���IP
		OPType = new String(request.getParameter("LOGTYPE").getBytes(
				"8859_1"));//��־��־
		mKeySn = new String(request.getParameter("KEYSN").getBytes(
				"8859_1"));//KEY���к�
		if (ObjConnBean.OpenConnection()) {
			java.sql.PreparedStatement prestmt = null;
			try {
				java.sql.Date mDate;
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				String mDateTime = formatter.format(cal.getTime());

				strSql = "insert into HTMLHistory(SignatureName,SignatureUnit,SignatureUser,SignatureSN,";
				strSql = strSql
						+ "SignatureGUID,DocumentID,SignatureID,IP,LogType,KeySN)";
				strSql = strSql + " values(?,?,?,?,?,?,?,?,?,?)";
				prestmt = ObjConnBean.Conn.prepareStatement(strSql);

				prestmt.setString(1, mSignatureName);
				prestmt.setString(2, mSignatureUnit);
				prestmt.setString(3, mSignatureUser);
				prestmt.setString(4, mSignatureSN);
				prestmt.setString(5, mSignatureGUID);
				prestmt.setString(6, mDocumentID);
				prestmt.setString(7, mSignatureID);
				prestmt.setString(8, mMACHIP);
				//prestmt.setString(9,mDateTime);
				prestmt.setString(9, OPType);
				prestmt.setString(10, mKeySn);
				ObjConnBean.Conn.setAutoCommit(true);
				prestmt.execute();
				ObjConnBean.Conn.commit();
				prestmt.close();
				mResult = true;
			} catch (SQLException e) {
				System.out.println(e.toString());
				mResult = false;
			}
			ObjConnBean.CloseConnection();
		}
		out.clear();
		out.print("SIGNATUREID=" + mSignatureID + "\r\n");
		out.print("RESULT=OK");
	}
%>