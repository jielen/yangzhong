<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String token = (String) session.getAttribute("current.user.token");
	String userId = (String)request.getSession().getAttribute("svUserID");
	String userName = (String)request.getSession().getAttribute("svUserName");
	String subId = request.getParameter("subId");
	String src = "html/portlet/message/" + subId + "Message.js";
	String subMainId = subId + "-Main";
%>
<html>
	<head>
		<title></title>
		<script type="text/javascript" src="<%=src%>"></script>
		<script>
		  var token = '<%=token%>';
		  var userId = '<%=userId%>';
			var userName = '<%=userName%>';
		</script>
	</head>

	<body>
	<div id="<%=subMainId%>" style="width:100%;height:100%"></div>
	</body>
</html>
