<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.ufgov.zc.server.zc.web.form.EvalResultPrintForm"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcEbExpertEvalResult"%>
<%@page import="com.ufgov.zc.common.zc.model.ZcEbFormulaItem"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
   EvalResultPrintForm rp = (EvalResultPrintForm)request.getAttribute("evalResultPrintForm");
   Map levelMap = rp.getLevelMap();
   int maxLevel = rp.getMaxLevel();
   Map detal = rp.getExpertDetal();
   Map expertCol = rp.getExpertCol();
   List evalResultSCList = rp.getEvalResultSCList();
   Map expertDetal = rp.getExpertDetal();
%>
<html:html lang="true">
<head>
<title> �б���Ŀר��������ϸ�� </title>
<meta http-equiv="content-type" content="index/html; charset=gbk" />
<link href="../../css/stylesheet.css" type="text/css" rel="Stylesheet" />
</head>
<body>
<table border=0 width="90%" cellpadding=0 cellspacing=0 >
 <tr height=38 style='mso-height-source:userset;height:28.5pt'>
  <td height=38 class=xl74 width="100%" colspan="100" style='height:28.5pt;width:100%'><center> �б���Ŀר��������ϸ�� </center></td>
 </tr>
</table>
<table border=0 cellpadding=0 cellspacing=0> 
 <tr height=37 style='mso-height-source:userset;height:27.75pt'>
  <td height=37 class=xl65 colspan=100 style='height:27.75pt;mso-ignore:colspan'>��Ŀ���ƣ�<bean:write name="evalResultPrintForm" property="zcEbProj.projName" />(<bean:write name="evalResultPrintForm" property="zcEbPack.packName" />)</td>
 </tr>
  <tr height=37 style='mso-height-source:userset;height:27.75pt'>
  <td height=37 class=xl65 colspan=100 style='height:27.75pt;mso-ignore:colspan'>����ר�ң�<bean:write name="evalResultPrintForm" property="expertName" /></td>
 </tr>
</table>

 <table border=0 cellpadding=0 cellspacing=0 >
 <% 
   for (int i=0;i<maxLevel;i++){
     if (i==0){
 %>
 <tr>
  <td rowspan=<%=maxLevel%> class=xl70 width=40>���</td>
  <td rowspan=<%=maxLevel%> class=xl70 width=240 style='border-left:none;'><center>Ͷ�굥λ</center></td>
  <% 
     List list = (List)levelMap.get("1");
     for (int j=0;j<list.size();j++) {
       ZcEbFormulaItem zcEbFormulaItem = (ZcEbFormulaItem)list.get(j);
  %>
  <td class=xl70 width=110 rowspan=<% if(zcEbFormulaItem.getLeafcount() == 1){ 
	  out.print(maxLevel); } else { out.print((maxLevel - zcEbFormulaItem.getLevels().intValue())); }%> colspan=<%=zcEbFormulaItem.getLeafcount()%> style='border-left:none'><%out.print(zcEbFormulaItem.getName());%><%
	  if(zcEbFormulaItem.getStandardScore()!=null){out.print("("+zcEbFormulaItem.getStandardScore()+"��)");}%></td>
  <% } %>
  <td rowspan=<%=maxLevel%> class=xl70 width=40 style='border-left:none'>�ܷ�</td>
  <!-- 
  <td rowspan=<%=maxLevel%> class=xl70 width=40 style='border-left:none'>����</td>
   -->
 </tr>
 <%
     } else {
%>
 <tr class=xl69 height=29 style='mso-height-source:userset;height:21.75pt'>
  <% 
     List list = (List)levelMap.get(""+(i+1));
     for (int j=0;j<list.size();j++) {
        ZcEbFormulaItem zcEbFormulaItem = (ZcEbFormulaItem)list.get(j); 
  %>
  <td class=xl71 rowspan=<%=(maxLevel - zcEbFormulaItem.getLevels().intValue() + 1 )%> colspan=<%=zcEbFormulaItem.getLeafcount()%> style='border-left:none;border-top: none;'>
  <% 
    if(zcEbFormulaItem.getIsleaf() == 0){
        out.print(zcEbFormulaItem.getName()); 
        if(zcEbFormulaItem.getStandardScore()!=null){
       	out.print("("+zcEbFormulaItem.getStandardScore()+"��)");
        }
    } else {
    	if(zcEbFormulaItem.getStandardScore()!=null){
      out.print(zcEbFormulaItem.getStandardScore()); 
      }
    }
  %>
  </td>
  <% } %>
 </tr>
<%  
     }
  }
  for(int i=0;i<evalResultSCList.size();i++) {
    ZcEbExpertEvalResult zcEbExpertEvalResult = (ZcEbExpertEvalResult)evalResultSCList.get(i);
%>
<tr class=xl69 height=29 style='mso-height-source:userset;height:21.75pt'>
  <td class=xl71 rowspan=1 colspan=1 style='border-top: none;'><%=(i+1)%></td>
  <td class=xl71 rowspan=1 colspan=1 style='border-left:none;border-top: none;'><%=zcEbExpertEvalResult.getProviderName()%></td>
  <% 
     Map dataMap = (Map)expertDetal.get(zcEbExpertEvalResult.getProviderCode());
     for (Iterator iterator = dataMap.keySet().iterator(); iterator.hasNext();) {
    	 Object key=iterator.next();
  %>
  <td class=xl71 rowspan=1 colspan=1 style='border-left:none;border-top: none;'><%=dataMap.get(key)==null? "0":dataMap.get(key)%></td>
  <% 
     }
  %>
  <td class=xl71 rowspan=1 colspan=1 style='border-left:none;border-top: none;'><b><%=zcEbExpertEvalResult.getEvalResult()%></b></td>
</tr>
<% 
  }
%>
</table>

<table border=0 cellpadding=0 cellspacing=0 >
 <tr height=20 style='mso-height-source:userset;height:12.5pt'>
  <td height=20 class=xl65 style='height:10.5pt'></td>
 </tr>
 <tr height=20 style='height:14.25pt'>
  <td height=20 class=xl65 colspan=3 style='height:14.25pt;mso-ignore:colspan' align="left">&nbsp;&nbsp;&nbsp;ר��ǩ�֣�</td>
 </tr>
 <tr height=20 style='mso-height-source:userset;height:10.5pt'>
  <td height=20 class=xl65 style='height:10.5pt'></td>
 </tr>
 <tr height=20 style='height:14.25pt'>
  <td height=20 class=xl65 colspan=3 style='height:14.25pt;mso-ignore:colspan' align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ڣ�</td>
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