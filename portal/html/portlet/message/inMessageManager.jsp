<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String token = (String) session.getAttribute("current.user.token");
	String userId = (String)request.getSession().getAttribute("svUserID");
	String userName = (String)request.getSession().getAttribute("svUserName");
%>
<jsp:include page="/inc/inc.jsp" />
<html>
	<head>
		<title>站内消息管理</title>
		<script type="text/javascript" src="html/portlet/message/MessageMainPanel.js"></script>
		<script type="text/javascript" src="html/portlet/message/MessageOper.js"></script>
		<script type="text/javascript" src="html/portlet/message/InMessageManager.js"></script>
		<script>
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
