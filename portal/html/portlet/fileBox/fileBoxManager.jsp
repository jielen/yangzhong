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
		<script type="text/javascript" src="html/portlet/fileBox/FileBoxManager.js"></script>
		<script type="text/javascript" src="html/portlet/fileBox/FileBoxTileTemp.js"></script>
		<script>
		    document.title = "公文箱管理";
		    var token = '<%=token%>';
		    var userId = '<%=userId%>';
			var userName = '<%=userName%>';
		</script>
	</head>
	<body>
		<div id="west"></div>
  		<div id="north"></div>
  		<div id="center"></div>
  		<div id="south"></div>
	</body>
</html>
