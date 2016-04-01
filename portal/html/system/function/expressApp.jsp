<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<html>
	<head>
		<script language="JavaScript">
     		var componame_l="AP_EXPRESS_APP";
		</script>
		<script type="text/javascript" src="<%=path%>/script/system/function/ExpressApp.js"></script>
	</head>
	<body>
		<div id="expressContainer" style="padding: 5px;">
			<div id="expressSearch">
				<div id="divExpressFast" class="x-hide-display" ></div>
				<div id="divExpressAdv" class="x-hide-display" ></div>
			</div>
			<div id="expressContent"></div>
		</div>
	</body>
</html>
