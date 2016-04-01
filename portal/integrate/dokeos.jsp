<%@page contentType="text/html; charset=utf-8"%>
<%
	String userId = (String)session.getAttribute("svUserID");
	String token = (String)session.getAttribute("current.user.token");
	if(token == null){
		out.println("会话为空，请确认你已经登录而且没有超时！");
		return;
	}
	if(userId == null){
		out.println("用户名为空，请确认你已经登录而且没有超时！");
		return;
	}
	String serverName = request.getServerName();
%>
<html>
	<head>
		<title>集成远程教育系统</title>
	</head>
	<body onload="doLoad();">
		<div style="display:none;">
			<form  action="" method="post" name="formLogin" id="formLogin">
				<div><input size="15" name="login" type="text" /></div>
				<div><input size="15" name="password" type="password" /></div>
				<input name="_qf__formLogin" type="hidden" value="" />
			</form>
		</div>
	</body>
	<script>
		function doLoad(){
			document.all.login.value = '<%=userId%>';
			document.all.formLogin.action = "http://" + '<%=serverName%>' + "/dokeos/index.php";
			document.all.formLogin.submit();
		}
	</script>
</html>