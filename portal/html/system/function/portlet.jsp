<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
%>

<html>
	<head>
		<script language="JavaScript">
     		var componame_l="AS_Portlet";
		</script>
		<script type="text/javascript" src="<%=path%>/script/system/function/Portlet.js"></script>
	</head>
	<body>
		<div id="portletContainer" style="padding: 5px;">
			<div id="portletSearch">
				<div id="divPortletFast" class="x-hide-display"></div>
				<div id="divPortletAdv" class="x-hide-display"></div>
			</div>
			<div id="portletContent"></div>
		</div>

	</body>
</html>
