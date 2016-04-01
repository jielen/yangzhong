<%@page contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String treeId = request.getParameter("id");
	response.setHeader("Pragma","no-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader ("Expires", 0);
	long rnd = (new java.util.Date()).getTime();
%>
<html>
	<head>
		<title>定制菜单信息</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/portal.css" />
		<script type="text/javascript" src="<%=path%>/script/system/function/MenuEditConf.js?rnd=<%=rnd%>"></script>
		<script type="text/javascript">
			var treeId = '<%=treeId%>';
		</script>
	</head>
	<body>
		<div id="selectedNodeInfo" style="height:20px;padding:10px;"></div>
		<div id="editMenuDiv" style="width:100%;"></div>
  	</body>
</html>
