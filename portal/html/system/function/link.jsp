<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<html>
	<head>
		<script language="JavaScript">
		    var componame_l="AP_LINK";
		</script>
		<script type="text/javascript"  src="<%=path%>/script/system/function/Link.js"></script>
	</head>
	<body>
		<div id="linkContainer"  style="padding:5px;">
    		<div id="linkSearch" >
        		<div id="divLinkFast"  class="x-hide-display"></div>
        		<div id="divLinkAdv"  class="x-hide-display" ></div>
    		</div>
   			<div id="linkContent"></div>
		</div>
	</body>
</html>
