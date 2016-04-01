<%@ page contentType="text/html;charset=utf-8"%>
<%
	String fileName = request.getParameter("fileName");
	fileName = new String(fileName.getBytes("iso8859-1"), "utf-8");
	String fullFileName = "../../../resources/" + fileName;
	String description = request.getParameter("description");
	description = new String(description.getBytes("iso8859-1"), "utf-8");
%>
<html>
	<head>
		<title><%=description%></title>
		<script type="text/javascript">
			var fullFileName = "<%=fullFileName%>";
			window.onload = function(){
				var showPic = document.getElementById("pic");
				var picWidth = showPic.width;
				var picHeight = showPic.height;
				var showPicWidth, showPicHeight;
				if(picWidth > document.body.offsetWidth && picHeight > document.body.offsetHeight){
					if(picWidth > picHeight){
						showPicHeight = document.body.offsetHeight - 10;
						showPicWidth = parseFloat(showPicHeight) * picWidth / picHeight;
					}else if(picWidth < picHeight){
						showPicWidth = document.body.offsetWidth - 30;
						showPicHeight = parseFloat(showPicWidth) * picHeight / picWidth;
					}
				}else if(picWidth < document.body.offsetWidth && picHeight < document.body.offsetHeight){
					showPicHeight = picHeight;
					showPicWidth = picWidth;
				}else if(picWidth > document.body.offsetWidth && picHeight < document.body.offsetHeight){
					showPicHeight = picHeight;
					showPicWidth = parseFloat(showPicHeight) * picWidth / picHeight;
				}else if(picWidth < document.body.offsetWidth && picHeight > document.body.offsetHeight){
					showPicWidth = picWidth;
					showPicHeight = parseFloat(showPicWidth) * picHeight / picWidth;
				}
				document.getElementById("pic").style.width = showPicWidth;
				document.getElementById("pic").style.height = showPicHeight;
			}
		</script>
	</head>
	<body style="margin: 0 0 0 0">
		<table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
			<tr>
				<td align="center">
					<img src="<%=fullFileName%>" id="pic">
				</td>
			</tr>
		</table>
	</body>
</html>