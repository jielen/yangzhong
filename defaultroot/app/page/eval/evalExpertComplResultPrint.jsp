<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.ufgov.zc.server.zc.web.form.EvalResultPrintForm"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcEbPackEvalResult"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
   EvalResultPrintForm rp = (EvalResultPrintForm)request.getAttribute("evalResultPrintForm");
   Map detal = rp.getExpertDetal();
   Map expertCol = rp.getExpertCol();
   List evalPackSumResult=rp.getEvalPackSumResult();
   DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);

%>
<html:html lang="true">
<head>
<title> �б���Ŀר�ҷ�����������ܱ� </title>
<meta http-equiv="content-type" content="index/html; charset=gbk" />
<link href="../../css/stylesheet.css" type="text/css" rel="Stylesheet" />
</head>
<body>
<table border=0 cellpadding=0 cellspacing=0 >
 <tr height=38 style='mso-height-source:userset;height:28.5pt'>
  <td height=38 class=xl74 width="100%" colspan="100" style='height:28.5pt;width:100%'> �б���Ŀר�ҷ�����������ܱ� </td>
 </tr>
 <tr height=37 style='mso-height-source:userset;height:27.75pt'>
  <td height=37 class=xl65 colspan=2 style='height:27.75pt;mso-ignore:colspan'>��Ŀ���ƣ�<bean:write name="evalResultPrintForm" property="zcEbProj.projName" /></td>
  </tr>  
   <tr> 
    <td height=37 class=xl65 colspan=2 style='height:27.75pt;mso-ignore:colspan'>��Σ�<bean:write name="evalResultPrintForm" property="zcEbPack.packName" /></td>
   </tr>
 <tr class=xl69 height=40 style='mso-height-source:userset;height:21.75pt'>
  <td class=xl70 height=29 width=30 style='height:21.75pt;width:40'>���</td>
  <td class=xl70 width=100 style='border-left:none;width:100'><center>Ͷ�굥λ</center></td>
  <% for (Iterator iterator = expertCol.keySet().iterator(); iterator.hasNext();) {  %>
  <td class=xl70 style='border-left:none'><%out.print(expertCol.get(iterator.next()));%></td>
  <% }%>
  <td class=xl70 width=120 style='border-left:none'><center>������������</center></td>
 </tr>
 <% 
 for(int i=0;i<evalPackSumResult.size();i++){
	 ZcEbPackEvalResult result=(ZcEbPackEvalResult)evalPackSumResult.get(i);
	 %>
	<tr>
	   <td class=xl71 height=29 width=30 style='border-top:none;height:21.75pt;width:30pt'><center><%=(i+1)%></center></td>
	     <td class=xl70  width=120 style='border-top:none;border-left:none;width:380'><center><%= result.getProviderName()%></center></td>
	   <% for (Iterator iterator = expertCol.keySet().iterator(); iterator.hasNext();) {  %>
 		 <td class=xl70 style='border-top:none;border-left:none'><center><%
 		 out.print("1".equals(detal.get(result.getProviderCode()+iterator.next()))?"&radic;"
		          : "&times;");%></center></td>
  <% }%>
    <td class=xl70 style='border-top:none;border-left:none'>
  	 <% 
  	out.print("1".equals(result.getComplianceEvalValue())?"ͨ��":"��ͨ��"); %> 
  </tr>
	 <% 
 } 
	 %>

 <tr height=20 style='mso-height-source:userset;height:12.5pt'>
  <td height=20 class=xl65 style='height:10.5pt'></td>
 </tr>
 <tr height=20 style='height:14.25pt'>
  <td height=20 class=xl65 colspan=3 style='height:14.25pt;mso-ignore:colspan' align="left">����ίԱ�ᣨ̸��С�飩ȫ���Աǩ�֣�</td>
 </tr>
 <tr height=20 style='mso-height-source:userset;height:10.5pt'>
  <td height=20 class=xl65 style='height:10.5pt'></td>
 </tr>
 <tr>
 </tr>
 <tr height=20 style='height:14.25pt'>
  <td height=20 class=xl65 colspan=3 style='height:14.25pt;mso-ignore:colspan' align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;�ڣ�
  <%=df.format(new Date()) %>
  </td>
 </tr>
 <tr height=20 style='mso-height-source:userset;height:10.5pt'>
  <td height=20 class=xl65 style='height:10.5pt'></td>
 </tr>
 <!--  
 <tr height=20 style='height:14.25pt'>
  <td height=20 class=xl65 colspan=3 style='height:14.25pt;mso-ignore:colspan' align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ʡʡ����λ�����ɹ�����</td>
 </tr>
 -->
</table>
</body>
</html:html>