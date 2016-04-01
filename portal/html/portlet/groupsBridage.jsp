<%@page contentType="text/html; charset=utf-8"%>
<%@page import="com.ufgov.gmap.context.ApplusContext"%>
<%
  	String path = request.getContextPath();
	String token = (String)session.getAttribute("current.user.token");
	String userId = (String)session.getAttribute("svUserID");
	String userName = (String)session.getAttribute("svUserName");
	if(token == null)response.sendRedirect(path + "/index.jsp");
	String loginTime = (new java.sql.Timestamp(System.currentTimeMillis())).toString();
	loginTime = loginTime.substring(0, loginTime.length() - 4);
	String groupId = request.getParameter("groupId");
	String groupName = request.getParameter("groupName");
	String pageId = request.getParameter("pageId");
	if(null == pageId){
		pageId = "";
	}

%>
<jsp:include page="/inc/inc.jsp" />

<%@page import="com.ufgov.gmap.domain.SessionUtils"%><html>
  	<head>
    	<title></title>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<script type="text/javascript" src="script/system/function/GroupPages.js"></script>
    	<script type="text/javascript">
    		window.moveTo(0,0);
    		window.resizeTo(window.screen.availWidth, window.screen.availHeight);
    		token = '<%=token%>';
    		userId = '<%=userId%>';
    		userName = '<%=userName%>';
    		groupId = '<%= groupId%>';
    		groupName = '<%= groupName%>';
    		pageId = '<%= pageId%>';
    		
    		var loginTime = '<%=loginTime%>';
		    
    	</script>
  	</head>
  
  	<body >
    	<div id="west"></div>
    	<div id="center"></div>
    	<div id="east"></div>
 	</body>
</html>
