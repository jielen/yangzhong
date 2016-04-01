<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<html>
	<head>
		<script language="JavaScript">
		     //var componame_l="AP_LINK";
		</script>
		<script type="text/javascript" src="<%=path%>/script/system/function/OnlineMaintain.js"></script>
	</head>
	<body>
	<div id="maintainContainer"  style="padding:5px;">
	    <div id="maintainSearch" >
	        <div id="divMaintainFast"  class="x-hide-display"></div>
	        <div id="divMaintainAdv"  class="x-hide-display" ></div>
	    </div>
	   	<div id="maintainContent"  ></div>
	</div>
	</body>
</html>
