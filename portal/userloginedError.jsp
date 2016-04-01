<%@page contentType="text/html; charset=utf-8"%>

<%@page import="com.ufgov.gmap.sso.SSOKeys"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>访问报错</title>
</head>
<body>
<script language=javascript>
	window.onload = function(){		
		var confValue = confirm("当前会话存在登录的账号，请关闭浏览器重新登录！\n点击【确定】按钮关闭浏览器！");
		if(confValue){
			window.close();
		}else{
		}		
	}
</script>

<div align="center">
当前会话存在登录的账号，请关闭浏览器重新登录！
</div>
</body>
</html>