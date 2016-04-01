<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	long rnd = (new java.util.Date()).getTime();
%>
<jsp:include page="/inc/inc.jsp" />
<html>
	<head>
		<title>选择人员</title>
		<script type="text/javascript" src="<%=path%>/html/portlet/message/GetOrgTree.js?rnd=<%=rnd%>"></script>
		<script type="text/javascript" src="<%=path%>/script/common/TreeCheckNodeUI.js"></script>
	</head>

	<body>

	</body>
</html>
