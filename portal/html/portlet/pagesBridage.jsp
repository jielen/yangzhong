<%@page contentType="text/html; charset=utf-8"%>
<jsp:include page="/inc/inc.jsp" />

<%
	String path = request.getContextPath();
	String groupId = request.getParameter("groupId");
	String pageId = request.getParameter("pageId");
	if(pageId == null){
		pageId = "";
	}
	if(groupId == null){
		groupId = "";
	}
%>

<html>
  	<head>
  		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title></title>
    	<script type="text/javascript" src="<%=path%>/MainPageOut.js"></script>
    	<script type="text/javascript">
    		pageId = '<%=pageId%>';
    		groupId = '<%=groupId%>';
    	</script>
  	</head>
  	<body style="text-align:center;overflow:auto;">
  	<div style="text-align:left;" id="top"></div>
   	<div style="text-align:left;" id="navigation"></div>
   	<div style="text-align:left;" id="center"></div>
   	<div style="text-align:left;" id="bottom"></div>
 	</body>
</html>

