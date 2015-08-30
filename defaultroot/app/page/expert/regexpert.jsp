<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
  String path = request.getContextPath();
  String homePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    	<title>ר��ע����Ϣ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<link href="./../../css/supplier_style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="./../../js/DateTimeCalendar.js"></script>
   <script>
   var rowNum=1;
   var maxRowAllow = 11;
   var flag;
    function openOrClose(eleID){
				var thiz = document.getElementById(eleID);
				if(thiz.style.display=='none'){
					thiz.style.display="block";
				}else{
					thiz.style.display="none";
				}
		   }
	 function addRow(tabID){//��ӱ���һ��
	  var idTB = document.getElementById(tabID);
	  if(idTB.rows.length>=maxRowAllow){
		alert("��ǰ���ֻ�����"+(maxRowAllow-1)+"��ƷĿ��ϸ...");
		return;
	  }
	  var oTR=idTB.insertRow(idTB.rows.length);
	  makeCols(oTR,oTR.rowIndex);
	  idLast.innerText=idTB.rows.length-1;
	  if(idTB.rows.length>=1)
		idFirst.innerText='1';
	  return true;
	}
	function makeCols(oTR,rowNum){
				var i = 0;
				var oTD=oTR.insertCell(i++);
				oTD.innerHTML="<a onclick='openwindow("+rowNum+")'>"+(rowNum)+"</a>";
				oTD=oTR.insertCell(i++);
				oTD.innerHTML="<input type='text' name='licenseNo' onclick='openwindow("+rowNum+")' id='expertId'/>";
				oTD=oTR.insertCell(i++);
				oTD.innerHTML="<input type='text' name='licenseName' readonly='true' onclick='openwindow("+rowNum+")'/>";
				oTD=oTR.insertCell(i++);
				
				
			}
	
	function delRow(tabID,delLineID){//ɾ������һ��
				var info = "0(���п�ɾ)";
				var idTB = document.getElementById(tabID);
				var idIndex = document.getElementById(delLineID);
				var sIndex=idIndex.value;
				if(sIndex==''){
					sIndex=idTB.rows.length-1;
				}else{
					sIndex=parseInt(sIndex);
				}
				//������ɾ����ͷ
				if(sIndex <= 0 || sIndex > idTB.rows.length){
					idLast.innerText=info;
					return;
				}
				idTB.deleteRow(sIndex);
				if(idTB.rows.length<=1){
					idLast.innerText=info;
				}else{
					idLast.innerText=idTB.rows.length-1;
				}
				if(idTB.rows.length==1){
					idFirst.innerText="0";
				}
			}
	
	var newWindow;
	//���´���		
	function openwindow(rowNum){
	
		newWindow=window.open ('regexpertQuery.do?rowNum='+rowNum,'newwindow', 'height=400, width=600, top=0,left=0 ,scrollbars=yes, resizable=yes')
		newWindow.rowNum=rowNum;
	// window.open ('newWindow.jsp', 'newwindow', 'height=600, width=800, top=0,left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no') 
	}	
	
	 function subExpert(){
	 if(!checkContent("fullname","\n������������Ϊ��")
							||!checkContent("zjhm","\n��֤�����롱����Ϊ��")||!checkContent("unitname","\n�����ڵ�λ������Ϊ��")
							||!checkContent("getJobDate","\n����ȡְ��ʱ�䡱����Ϊ��")||!checkContent("zsmc","\n��ִҵ�ʸ�֤�����ơ�����Ϊ��")
							||!checkContent("mobile","\n���ֻ����롱����Ϊ��")||!checkContent("phone","\n����λ�绰������Ϊ��")
							||!checkContent("expertId","\n��ר�����͡�����Ϊ��,�������!")){
	 }else{
	 	confirm('��ȷ�ϱ��������?');
		document.forms[0].submit(); 
	 }
	 }
	 
	 function checkContent(eid,msg){
		var srcObj = document.getElementById(eid);
		var re = new RegExp('^\S+$');
		//alert(srcObj);
		if(srcObj==undefined || srcObj.value==undefined){
		    alert("���������ƷĿ��ϸ!");
		    return;
		}else if(srcObj.value!='' && !re.test(srcObj.value)){
		}else{
			//alert(msg);
			document.getElementById(eid+"_1").innerHTML = "<font color='red'>"+msg+"</font>";
			srcObj.focus();
			return false;
		}
		return true;
	  }
	 
	 //�п�
	function notnull(str,strname){
		if(str.value.replace(/\s/g,"") == ""){
			  //alert(strname+"����Ϊ��");
			  document.getElementById(str.id+"_1").innerHTML = "<font color='red'>"+strname+"����Ϊ��!</font>";
			  return false;
			}else{
				document.getElementById(str.id+"_1").innerHTML = "";
				return true;
				}
		}
		
//��֤����
			
			function isWhiteWpace (s){
				var whitespace = " \t\n\r";
				var i;
				for (i = 0; i < s.length; i++){   
				var c = s.charAt(i);
				if (whitespace.indexOf(c) >= 0) {
				return true;
				}
				}
				return false;
			}

			function checkPassword(pwd){
				var password = pwd.value;
				if( password.length<6 || password.length>16 ) {
				//alert("\��������ȷ������,�û�������Ϊ6-16λ��")
				document.getElementById(pwd.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,���볤��Ϊ6-16λ��</font>";
				
				return false;
				}
				else if (isWhiteWpace(password)){
				//alert("\��������ȷ������,�û����в��ܰ����ո�")
				document.getElementById(pwd.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,���벻�ܰ����ո�</font>";
				
				return false;
               }else{
            	   document.getElementById(pwd.id+"_1").innerHTML ="";
            	   return true;
                   }
			}

			function checkPassword2(pwd2){
				var password2 = pwd2.value;
				if( password2.length<6 || password2.length>16 ) {
				//alert("\��������ȷ������,�û�������Ϊ6-16λ��")
				document.getElementById(pwd2.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,�û�������Ϊ6-16λ��</font>";
				return false;
				}
				else if (isWhiteWpace(password2)){
				//alert("\��������ȷ������,�û����в��ܰ����ո�")
				document.getElementById(pwd2.id+"_1").innerHTML = "<font color='red'>\��������ȷ������,�û����в��ܰ����ո�</font>";
				return false;
				}
				else if (password2 != document.getElementById("password").value){
					//alert("\ �������벻һ�£�")
					document.getElementById(pwd2.id+"_1").innerHTML = "<font color='red'>\ �������벻һ�£�</font>";
					return false;

					}else{
						document.getElementById(pwd2.id+"_1").innerHTML ="";
						return true;
						}
			}
			

		
   </script>
  </head>
  
  <body>
  <table align="center" style="width:90%"> <tr><td width="100%" align="center">
  <table  width="100%" align="center">
    <tr><td width="100%" align="center">
      <html:form action="/portal/page/expert/regexpertSave.do" method="post" >
    <div class="group-frame">
    <html:messages id="error" message="true">
				   <font color="red" size="4"><bean:write name="error"/></font>
			</html:messages>
		<div class="group-down" onClick="openOrClose('part2')">ר����Ϣ</div>
			<div id="part2" style="display: block">
			   <table width="100%" border="0">
			    <tr>
			    <td width="12%" class="itda" >��¼����</td>
					<td width="20%" class="itdb">
						<html:text property="user.userId" title="��¼����"  onblur="notnull(uname,title)" styleId="uname"/>
						<font color="red" size="4">*</font>
						<a id="uname_1"></a>
					</td>
			      <td width="12%" class="itda">����</td>
			      <td width="25%" class="itdb">
			      <html:text property="expertpo.em_expert_name" title="����" styleId="fullname" onblur="notnull(fullname,title)"></html:text>
			      <font color="red" size="4">*</font>
			      <a id="fullname_1"></a>
			      </td>
			    	<td width="10%" class="itda">�Ա�</td>
			      <td width="25%" class="itdb">
			      <html:select property="expertpo.em_expert_sex" styleId="sex">
			      <html:optionsCollection property="sexList" value="id" label="label" />
			      </html:select>
			      <font color="red" size="4">*</font>
			      </td>
			    </tr>
			      <tr>
			      <td width="12%" class="itda">��¼����</td>
					<td width="20%" class="itdb" >
					    <html:password property="user.password" title="��¼����"  onblur="checkPassword(password)" styleId="password"/>
						<font color="red" size="4">*</font>
						<a id="password_1"></a>
					</td>
					<td width="12%" class="itda">ȷ������</td>
					<td width="25%" class="itdb" >
						<input id="confirm_txt" type="password" title="ȷ������"  onblur="checkPassword2(confirm_txt)"/>
						<font color="red" size="4">*</font>
						<a id="confirm_txt_1"></a>
					</td>
			        <td width="10%" class="itda">��������</td>
			      <td width="25%" class="itdb">
			       <input id="birthDate" title="����ʱ��" name="birthDate" onClick="calendar();"/>
			      </td>
			    </tr>
			       <tr>
			        <td width="12%" class="itda">֤������</td>
			      <td width="20%" class="itdb">
			      <html:select property="expertpo.em_id_type">
			      <html:optionsCollection property="peopleList" value="id" label="label" />
			      <font color="red" size="4">*</font>
			      </html:select>
			      </td>
			      <td width="12%" class="itda">֤������</td>
			      <td width="25%" class="itdb">
			       <html:text property="expertpo.em_id_no" styleId="zjhm" title="֤������" onblur="notnull(zjhm,title)"/>
			      <font color="red" size="4">*</font>
			      <a id="zjhm_1"></a>
			      </td>
			      <td width="10%" class="itda">���ѧ��</td>
			      <td width="25%" class="itdb">
			      <html:text property="expertpo.em_diploma"></html:text>
			      </td>
			    </tr>
			   
			     <tr>
			       <td width="12%" class="itda">��ҵԺУ</td>
			      <td width="20%" class="itdb">
			      <html:text property="expertpo.em_university"></html:text>
			      </td>
			       <td width="12%" class="itda">��ҵʱ��</td>
			      <td width="25%" class="itdb">
			      <input id="graduateDate" title="��ҵʱ��" name="graduateDate" onClick="calendar();"/>
			      </td>
			      <td width="10%" class="itda">�μӹ���ʱ��</td>
			      <td width="25%" class="itdb">
			     <input id="workDate" title="�μӹ���ʱ��" name="workDate" onClick="calendar();"/>
			      </td>
			    </tr>
			    <!-- 
			    <tr>
			    <td class="itda">
			         ʡ
			    </td>
			    <td class="itdb">
			    <html:text property="expertpo.em_province"></html:text>
			    </td>
			     <td class="itda">
			           �У��ݣ�
			    </td>
			    <td class="itdb">
			    <html:text property="expertpo.em_city"></html:text>
			    </td>
			     <td class="itda">
			           �أ�����
			    </td>
			    <td class="itdb">
			     <html:text property="expertpo.em_county"></html:text>
			    </td>
			    </tr>
			      -->
			  <tr>
			     <td width="12%" class="itda">��ʼרҵʱ��</td>
			      <td width="20%" class="itdb">
			       <input id="beginDate" title="��ʼרҵʱ��" name="beginDate" onClick="calendar();"/>
			      </td>
			      <td width="12%" class="itda">��������</td>
			      <td width="25%" class="itdb">
			      <html:text property="expertpo.em_email"></html:text>
			      </td>
			    <td width="10%" class="itda">
			        ��λ����			    </td>
			    <td width="25%" class="itdb">
			    <html:select property="expertpo.em_unit_type">
			      <html:optionsCollection property="comList" value="id" label="label" />
			      </html:select>
			    </td>
			    </tr>
			    <tr>
			       <td width="12%" class="itda">
			           ���ڵ�λ			    </td>
			    <td width="20%" class="itdb">
			    <html:text property="expertpo.em_unit_name" styleId="unitname" title="���ڵ�λ" onblur="notnull(unitname,title)"></html:text>
			    <font color="red" size="4">*</font>
			    <a id="unitname_1"></a>
			    </td>
			     <td width="12%" class="itda">
			         ְλ			    </td>
			    <td width="25%" class="itdb">
			     <html:select property="expertpo.em_principalship">
			      <html:optionsCollection property="positionList" value="id" label="label" />
			      </html:select>
			    </td>
			    <td width="10%" class="itda">
			        ְ��			    </td>
			    <td width="25%" class="itdb">
			    <html:select property="expertpo.em_expert_protitle">
			      <html:optionsCollection property="callList" value="id" label="label" />
			      </html:select>
			   <font color="red" size="4">*</font>
			    </td>
			    </tr>
			    <tr>
			     <td width="12%" class="itda">
			           ��ȡְ��ʱ��			    </td>
			    <td width="20%" class="itdb">
			    <input id="getJobDate" title="��ȡְ��ʱ��" name="getJobDate" onClick="calendar();" onBlur="notnull(getJobDate,title)"/>
			    <font color="red" size="4">*</font>
			    <a id="getJobDate_1"></a>
			    </td>
			     <td width="12%" class="itda">
			         ִҵ�ʸ�֤������			    </td>
			    <td width="25%" class="itdb">
			     <html:text property="expertpo.em_zhiy_zgmc" styleId="zsmc" title="ִҵ�ʸ�֤������" onblur="notnull(zsmc,title)"></html:text>
			     <font color="red" size="4">*</font>
			     <a id="zsmc_1"></a>
			    </td>
			    <td width="10%" class="itda">
			       ��ͥ��ַ			    </td>
			    <td width="25%" class="itdb">
			    <html:text property="expertpo.em_home_addr"></html:text>
			    </td>
			    </tr>
			       <tr>
			          <td width="12%" class="itda">
			           ��ͥ�绰			    </td>
			    <td width="20%" class="itdb">
			    <html:text property="expertpo.em_home_phone"></html:text>
			    </td>
			     <td width="12%" class="itda">
			         �ֻ�����			    </td>
			    <td width="25%" class="itdb">
			     <html:text property="expertpo.em_mobile" styleId="mobile" title="�ֻ�����" onblur="notnull(mobile,title)"></html:text>
			    <font color="red" size="4">*</font>
			    <a id="mobile_1"></a>
			    </td>
			    <td width="10%" class="itda">
			        ��λ�绰			    </td>
			    <td width="25%" class="itdb">
			    <html:text property="expertpo.em_unit_phone" styleId="phone" title="��λ�绰" onblur="notnull(phone,title)"></html:text>
			    <font color="red" size="4">*</font>
			    <a id="phone_1"></a>
			    </td>
			
			    </tr>
			     <tr>
			       <td width="12%" class="itda">
			           ��λ��ַ			    </td>
			    <td width="20%" class="itdb">
			    <html:text property="expertpo.em_unit_addr"></html:text>
			    </td>
			     <td width="12%" class="itda">
			       ��λ�ʱ�			    </td>
			    <td width="25%" class="itdb">
			     <html:text property="expertpo.em_unit_postcode"></html:text>
			    </td>
			    <td width="10%" class="itda">
			       ״̬			    </td>
			    <td width="25%">
			     <html:select property="expertpo.em_exp_status" disabled="true">
			      <html:optionsCollection property="stateList" value="id" label="label" />
			      </html:select>
			    </td>
			    </tr>
			    <tr>
			    <td width="12%" class="itda" >
			        ��Ҫ��������			    </td>
			    <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_gongz_jingl" cols="60" rows="3"></html:textarea>
			    </td>
			     <td width="25%" class="itda" >
			     ��Ҫ�о��ɹ���ҵ��			    </td>
			     <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_chengguo" cols="60" rows="3"></html:textarea>
			    </td>
			    </tr>
			    <tr>
			    <td width="12%" class="itda" >
			        �μӺ���Э�ἰ���κ�ְ��			    </td>
			    <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_xiehui" cols="60" rows="3"></html:textarea>
			    </td>
			     <td width="25%" class="itda" >
			        ���κ��ּ���ָ��������			    </td>
			     <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_guwen" cols="60" rows="3"></html:textarea>
			    </td>
			    </tr>
			     <tr>
			    <td width="12%" class="itda" >
			        ����ʵ������			    </td>
			    <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_pingb_jingy" cols="60" rows="3"></html:textarea>
			    </td>
			     <td width="25%" class="itda" >
			         ��ע			    </td>
			     <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_beizhu" cols="60" rows="3"></html:textarea>
			    </td>
			    </tr>
			     <!-- 
			    <tr >
			   
			    <td class="itda">
			         ���
			    </td>
			    <td class="itdb" >nd
			    <html:text property="expertpo.em_input_code"></html:text>
			    </td>
			     <td class="itda">
			           �ʱ��
			    </td>
			    <td class="itdb">
			    <input id="inputDate" title="�ʱ��"  onclick="calendar();"/>
			    </td>
			     <td class="itda">
			        ���λ  
			    </td>
			    <td class="itdb">
			     <html:text property="expertpo.em_co_code"></html:text>
			    </td>
			    </tr>
			     -->
			     <tr>
			    <td width="12%" class="itda" >
			        ����/�ָ�ԭ����ʷ��			    </td>
			    <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_remark_content" cols="60" rows="3" disabled="true"></html:textarea>
			    </td>
			     <td width="25%" class="itda" >
			        ����/�ָ�ԭ�򣨱��Σ�			    </td>
			     <td class="itdb" colspan="2">
			     <html:textarea property="expertpo.em_remark_content_new" cols="60" rows="3" disabled="true"></html:textarea>
			    </td>
			    </tr>
			    <tr>
			    <td width="12%" class="itda">����</td>
			    <td class="itdb" colspan="5">
			    <html:textarea property="expertpo.em_expert_remark" cols="60" rows="3" disabled="true"></html:textarea>
			    </td>     
			    </tr>
			   </table>
			   
			</div>
	</div>
	<div class="group-frame">
				<div class="group-down" onClick="openOrClose('part3')">����ƷĿ��ϸ<a id="expertId_1"></a></div>
			    <div id="part3" style="display: block">
			    <table width="100%"><tr><td>
				<table  border="0" id="qualifiesTab" align="left" style="font-size:14px">
				<tr>
				 <td>���</td>
				 <td>ר�����ʹ���</td>
				 <td>ר����������</td>
				</tr>
				<logic:iterate id="a" name="expertForm" property="list" type="com.ufgov.zc.server.zc.web.form.ExpertActionForm">
				<tr onClick="openwindow(0)">
				<td >
				<bean:write name="a" property="seqNum"/>
				</td>
				<td>
				<html:text property="em_type_code" name="a"></html:text>
				</td>
				<td>
				<html:text property="em_type_name" name="a" readonly="true"></html:text>
				</td>
				</tr>
				</logic:iterate>
				</table>
				</td></tr>
				<tr><td>
				
				<table  cellpadding="1" cellspacing="1" width="100%">
						<tr>
							<td >
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" class="pbutton" style="width:60;" value="���һ��" name="savejz" onClick="addRow('qualifiesTab');"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" class="pbutton" value="ɾ  ��" style="width:60;" name="savejz" onClick="delRow('qualifiesTab','deleteTarger');"/>
								<font size="2">��</font>
								<input style="width:60;" id="deleteTarger" type="text"  onKeyPress="changeBgcolor('qualifiesTab',this.value);"/><font size="2">��(<a id="idFirst">1</a>~<a id="idLast">1</a>)</font>
							</td>
						</tr>
				  </table>
				  </td></tr></table>
				</div>
	</div>
	 <table id="operatorTab"  cellpadding="1" cellspacing="2" align="center">
				<tr>
					<td align="center" colspan="4">
						<br>
						<input type="button" class="pbutton" value="��  ��" style="width:100%;height:22px;" onClick="subExpert()"/>
					</td>
				</tr>	
		  </table>
	
   </html:form>
   </td></tr></table>

  </td></tr></table>
  </body>
</html>
