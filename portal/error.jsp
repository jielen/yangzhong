<%@page contentType="text/html; charset=utf-8"%>

<%@page import="com.ufgov.gmap.sso.SSOKeys"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>访问报错</title>
</head>
<%
	String result = (String) request.getAttribute("result");
	String beforeLoginUrl = (String)request.getAttribute(SSOKeys.KEY_BEFORE_LOGIN_URL);
	if(beforeLoginUrl == null){
		beforeLoginUrl = "index.jsp";
	}
%>
<body style="font: 12px;font-family:Times New Roman;text-align:center;">
<table width="492" border="0" cellspacing="0"  align=center cellpadding="0">
  <tr>
    <th scope="row"><img src="resources/mistake-top.gif" width="547" height="99"></th>
  </tr>
  <tr>
    <th scope="row"><img src="resources/mistake-mid.gif" width="547" height="107"></th>
  </tr>
  <tr>
    <td height="145" background="resources/mitake-bottom.gif" ><div align=center>
		<font color="#CC0000"><b><%=result %></b></font> <br>
请<a href="<%=beforeLoginUrl %>"><font color="#0000FF">重新登录</font></a></div></td>
  </tr>
</table>
</body>
</html>