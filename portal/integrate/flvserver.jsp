<%@page contentType="text/html; charset=utf-8"%>

<%

String token = (String)session.getAttribute("current.user.token");
if(token == null){
	out.println("session为空，请确认你已经登录而且没有超时！");
	return;
}

response.sendRedirect("/flvserver/videoplayer.html");

%>
<html>
	<head>
		<title>集成视频播放系统</title>
	</head>
	<body>
	</body>
</html>