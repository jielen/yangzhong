<%@page contentType="text/html; charset=utf-8"%>
<%
	String userId = (String)request.getSession().getAttribute("svUserID");
	String userName = (String)request.getSession().getAttribute("svUserName");
	String token = (String)request.getSession().getAttribute("current.user.token");
	String fileTitle = request.getParameter("fileTitle");
	String fileUrl = request.getParameter("fileUrl");
	String fileStatus = request.getParameter("fileStatus");
	fileTitle = new String(fileTitle.getBytes("iso8859-1"),"gbk");
%>
<jsp:include page="/inc/inc.jsp" />
<html>
	<head>
		<title></title>
		<script type="text/javascript" src="SelectClass.js"></script>
		<script>
		    document.title = "选择督办文件类别";
		    var token = '<%=token%>';
		    var userId = '<%=userId%>';
			var userName = '<%=userName%>';
			var fileTitle = '<%=fileTitle%>';
			var fileUrl = '<%=fileUrl%>';
			fileUrl = decodeURIComponent(fileUrl);
			var fileStatus = '<%=fileStatus%>';
			var oaFileType = '02';
		</script>
	</head>
	<body>
		<div id="west"></div>
  		<div id="center"></div>
	</body>
</html>