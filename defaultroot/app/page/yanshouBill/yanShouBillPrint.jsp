<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.ufgov.zc.server.zc.web.form.ZcEbYanShouBillPrintForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html:html lang="true">
<head>
<title>���յ�</title>
<meta http-equiv="content-type" content="index/html; charset=gbk" />
<link href="../../css/stylesheet.css" type="text/css" rel="Stylesheet" />
<style type="text/css">
table {border:1px; }
td{border:"1px solid #000000"}
</style>
</head>
<body>
<P class=MsoNormal align=left style='text-align: left;'><u>�����ɹ���Ŀ</u>
</P>
<table cellpadding=0 cellspacing=0>
 <caption style='text-align: center >
 <b style='mso-bidi-font-weight: normal'>
 <span style='font-size: 22.0pt; font-family: ����; mso-ascii-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: ����; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin'>
				��    ��    ��<br><span style='font-size: 14.0pt; font-family: ����'>(�����ࡢ������50��Ԫ���ϡ�������100��Ԫ���ϣ�</span></br></span></b></caption>
				
 <tr>
 <td colspan=8  s style='text-align: right;border:0px;' >��λ��Ԫ
</td>
 </tr>
  <tr height=38 style='height:28.5pt'>
  <td height=38 width=140  colspan=1 style='height:28.5pt;border-bottom:0px;'>��Ŀ����</td>
  <td height=38 width=250  colspan=4 style='height:28.5pt;border-bottom:0px;border-left:0px;'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.projName" />&nbsp</td>
  <td height=38 width=100  colspan=1 style='height:28.5pt;border-bottom:0px;border-left:0px;'>��������</td>
  <td height=38 width=200  colspan=2 style='height:28.5pt;border-bottom:0px;border-left:0px;'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.billYanShouDate" format="yyyy��MM��dd��"/>&nbsp</td>
 </tr>
 <tr>
  <td height=38  colspan=1 style='height:28.5pt;border-bottom:0px'>�ɹ���λ</td>
  <td height=38  colspan=4 style='height:28.5pt;border-bottom:0px;border-left:0px;'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcCoName" />&nbsp</td>
  <td height=38   colspan=1 style='height:28.5pt;border-bottom:0px;border-left:0px;'>��ϵ��</td>
  <td height=38   colspan=2 style='height:28.5pt;border-bottom:0px;border-left:0px;'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcMakeLinkMan"/>&nbsp</td>
 </tr>
  <tr>
  <td height=38   colspan=1 style='height:28.5pt;border-bottom:0px'>��Ӧ��</td>
  <td height=38   colspan=4 style='height:28.5pt;border-left:0px;'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcSuName" />&nbsp</td>
  <td height=38   colspan=1 style='height:28.5pt;border-left:0px;'>������</td>
  <td height=38  colspan=2 style='height:28.5pt;border-left:0px;'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcSuLinkMan"/>&nbsp</td>
 </tr>
 <tr>
  <td height=90  colspan=1 style='height:100pt;'>��Ӧ���Լ����</td>
  <td height=90  colspan=4 style='height:100pt;border-right:0px;border-left:0px;border-top:0px'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcSuOpinion"/></td>
   <td height=90  colspan=3 style='height:100pt;border-left:0px;border-top:0px'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.providerFillDate" format="yyyy��MM��dd��"/>&nbsp</td>
 </tr>
  <tr>
  <td height=90   colspan=1 style='height:100pt;border-top:0px'>�ɹ����������</td>
  <td height=90   colspan=4 style='height:100pt;border-right:0px;border-left:0px;border-top:0px'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcCoOpinion" /></td>
   <td height=38   colspan=3 style='border-left:0px;border-top:0px'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.caigoRenFillDate" format="yyyy��MM��dd��"/>&nbsp</td>
 </tr>
  <tr>
  <td height=90  colspan=1 style='height:100pt;border-top:0px'>����С���Ա���</td>
  <td height=90  colspan=4 style='height:100pt;border-right:0px;border-left:0px;border-top:0px'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcYanShouTeamOpinion" /></td>
   <td height=38   colspan=3 valign=bottom style='border-left:0px;border-top:0px'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.yanShouTeamFillDate" format="yyyy��MM��dd��"/>&nbsp</td>
 </tr>
  <tr>
  <td height=90   colspan=1 style='height:100pt;border-top:0px;border-bottom:0px'>��֯���յ�λ���</td>
 <td height=90  colspan=4   style='height:100pt;border:0px'>
 <bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zcOrganizerOpinion"/></td>
   <td height=38   colspan=3  valign="bottom"  style='height:100pt;border-left:0px;border-top:0px;border-bottom:0px'><bean:write name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.zuzhiDanweiFillDate" format="yyyy��MM��dd��"/>
   &nbsp</td>
 </tr>
<tr>
  <td height=38   rowspan=2 colspan=1 >��Ʒ����</td>
  <td rowspan=2 colspan=1 style='border-left:0px;' ><center>����ͺż�����</center></td>
  <td rowspan=2 colspan=1 style='border-left:0px;'><center>��ͬ���</center></td>
  <td rowspan=2 colspan=1 style='border-left:0px;'><center>��ͬ����</center></td>
  <td rowspan=2 colspan=1 style='border-left:0px;'><center>ʵ������</center></td>
  <td rowspan=1 colspan=3 style='border-left:0px;'><center>���ͬƫ��</center></td>
</tr>
  <tr>
	<td style='border-left:0px;border-top:0px' ><center >����</center></td>
	<td style='border-left:0px;border-top:0px' colspan=2 ><center>���</center></td>
  </tr>
  <logic:iterate id="billItem" name="zcEbYanShouBillPrintForm" property="zbEbYanshouBill.itemList" type="com.ufgov.zc.common.zc.model.ZcEbYanShouBillItem" scope="request" indexId="indexid">   	
			<tr>
			    <td>
			    	<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p>
							<bean:write name="billItem" property="productName" /></o:p>
						</span>
					</p>
			    </td>
				<td width=132 valign=top>
					<p class=MsoNormal align=right style='text-align: right'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p><bean:write name="billItem" property="productParam" /></o:p>&nbsp
						</span>
					</p>
				</td>
				<td width=113 valign=top>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p><bean:write name="billItem" property="htAmount" format="#.00"/></o:p>&nbsp
						</span>
					</p>
				</td>
				<td width=76 valign=top>
					<p class=MsoNormal align=right style='text-align: right'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p><bean:write name="billItem" property="htNum"/></o:p>&nbsp
						</span>
					</p>
				</td>
				<td width=88 valign=top>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p><bean:write name="billItem" property="shiShouNum" /></o:p>&nbsp
						</span>
					</p>
				</td>
				<td width=88 valign=top>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p><bean:write name="billItem" property="pianChaNum" /></o:p>&nbsp
						</span>
					</p>
				</td>
				<td width=88 valign=top>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p><bean:write name="billItem" property="pianChaAmount" /></o:p>&nbsp
						</span>
					</p>
				</td>
				<td width=88 valign=top>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US
							style='mso-bidi-font-size: 10.5pt; font-family: ����_GB2312'><o:p><bean:write name="billItem" property="pianChaAmount" /></o:p>&nbsp
						</span>
					</p>
				</td>
			</tr>
</logic:iterate>
 <tr>
 <td colspan=8  style='text-align: left;border:0px;' >1������һʽ��ݡ��ɹ������ݣ�������˽�����ݣ�����Ӧ��һ�ݡ��ɹ�����һ�ݡ�
</td>
 </tr>
  <tr>
 <td colspan=8  style='text-align: left;border:0px;'>2�������յ��Բɹ��ˡ���Ӧ������Ϊ�����������������ʵ��д��ǩ�֡�����ȷ�ϡ�
</td>
 </tr>
  <tr>
 <td colspan=8  style='text-align: left;border:0px;'>3���ɹ�������Ϊ��֯������Э����
</td>
 </tr>
  <tr>
 <td colspan=8  style='text-align: left;border:0px;'  >4���������ɸ��ơ�
</b>
</td>
 </tr>
</table>
</body>
</html:html>