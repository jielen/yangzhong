<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
%>

<html>
	<head>
		<script language="JavaScript">
	     var componame_l="AS_Upload";
		</script>
		<script type="text/javascript" src="<%=path%>/script/system/function/Upload.js"></script>
	</head>
	<body>
		<div id="uploadContainer" style="padding: 5px;">
			<div id="uploadSearch">
				<div id="divUploadFast" class="x-hide-display"></div>
				<div id="divUploadAdv" class="x-hide-display"></div>
			</div>
			<div id="uploadContent"></div>
			<div id="uploadEdit">
				<div id="divUploadEditor" class="x-hide-display">
					<div id="fi-basic"></div>
				</div>
			</div>
		</div>
	</body>
</html>
