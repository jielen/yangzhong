<%@page contentType="text/html; charset=utf-8"%>
<%
	String originalUrl = request.getParameter("originalUrl");
	String token = com.ufgov.gmap.domain.SessionUtils.getToken(request);
	
	String url = null;
	if(token != null){
		com.anyi.gp.domain.User user = com.ufgov.gmap.domain.SessionUtils.getCurrentUser(request);
		url = "/javabb/verifylogin.jbb?token=" + token + "&user.user=" + user.getUserCode()
			+ "&user.passwordHash=" + user.getPassword() + "&encoded=Y";
		if(originalUrl != null){
			url += "&jbbUrlBeforeLogin='" + originalUrl + "'";
		}
	}else{
		token = "";
		url = originalUrl;
	}
	//System.out.println(url);
	//response.sendRedirect(url);
%>
<script language="javascript">
	String.prototype.endWith = function(oString){  
		var reg = new RegExp(oString + "$");  
		return reg.test(this);
	}
	 
	if("" != "<%=token%>" && opener){
		//debugger;
		var openerUrl = opener.window.location.href;
		if(openerUrl.endWith("portal/index.jsp") || openerUrl.endWith("portal/") || openerUrl.endWith("portal")){
			opener.window.location.href = "/portal/portalDispatcher.action?groupId=guest";
		}
		window.location.href = "<%=url%>";
	}else{
		window.location.href = "<%=url%>";
	}
</script>
<html>
	<head>
		<title>集成论坛系统</title>
	</head>
	<body>
	</body>
</html>