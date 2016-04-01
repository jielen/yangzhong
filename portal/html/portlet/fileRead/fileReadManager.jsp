<%@page contentType="text/html; charset=utf-8"%>
<%
	String userId = (String)request.getSession().getAttribute("svUserID");
	String userName = (String)request.getSession().getAttribute("svUserName");
	String token = (String)request.getSession().getAttribute("current.user.token");
%>
<jsp:include page="/inc/inc.jsp" />
<html>
	<head>
		<title></title>
		<script type="text/javascript" src="html/portlet/fileRead/FileReadManager.js"></script>
		<script>
		    document.title = "文件传阅管理";
		    var token = '<%=token%>';
		    var userId = '<%=userId%>';
			var userName = '<%=userName%>';
		</script>
	</head>
	<body>
		<div id="west"></div>
  		<div id="center"></div>
	</body>
</html>
