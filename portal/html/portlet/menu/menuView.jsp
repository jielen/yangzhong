<%@page contentType="text/html; charset=utf-8"%>

<jsp:include page="/inc/inc.jsp" />

<script type="text/javascript" src="/portal/html/portlet/PageTemp.js"></script>
<script type="text/javascript" src="/portal/html/portlet/menu/MenuView.js"></script>
<script type="text/javascript" src="/portal/html/home_in/ShowPagePortlet.js"></script>
<script type="text/javascript" src="/portal/script/common/PublicFunction.js"></script>
<script type="text/javascript" src="/portal/html/home_in/FuncLink.js"></script>
<script type="text/javascript" src="/portal/html/portlet/myProfile/UserProfileEdit.js"></script>
<script language="VBScript" src="script/common/formenctype.vbs"></script> 

<script type="text/javascript">
	pageId = '<%=(String)request.getAttribute("pageId")%>';
	menuId = '<%=(String)request.getAttribute("menuId")%>';
	token = '<%=(String)session.getAttribute("current.user.token")%>';
	userId = '<%=(String)session.getAttribute("svUserID")%>';
	userName = '<%=(String)session.getAttribute("svUserName")%>';
</script>

<html>
	<head>
    	<title></title>
    </head>
	<body>
    	<div id="west"></div>
    	<div id="center"></div>
    	<div id="east"></div>
	</body>
</html>