<%@ page contentType="text/html; charset=utf-8"%>
<%
	String SESSION_ID = com.ufgov.gmap.pub.AppServer.getSessionIdKey();
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			String tempuid_1 = cookies[i].getName();
			if (tempuid_1.equals(SESSION_ID)) {
				cookies[i].setMaxAge(0);
				cookies[i].setValue(null);
				cookies[i].setPath("/");
				response.addCookie(cookies[i]);
				//System.out.println("sdfsf");
			}
		}
	}
	String result = (String) request.getAttribute("fail");
%>
<jsp:include page="/inc/inc.jsp" />
<html>
	<head>
		<TITLE>登录</TITLE>
		<script type="text/javascript" src="userLogin.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/script/common/PublicFunction.js"></script>
		<script type="text/javascript">
			var result = "<%=result%>";
		  if (result != "null" && result != "" && result != null) {
		    alert(result);
		  }
		</script>
		<style type="text/css">
		<!--
		.AnyiTitle {
			font-family: "宋体";
			font-size: 18px;
			font-weight: bold;
		}
		
		.unChangedFontSize {
			font-family: "宋体";
			font-size: 12px;
		}
		
		.sffocus {
			BORDER-RIGHT: #f90 1px solid;
			BORDER-TOP: #f90 1px solid;
			BACKGROUND: #fff;
			BORDER-LEFT: #f90 1px solid;
			COLOR: blue;
			BORDER-BOTTOM: #f90 1px solid
		}
		
		.login {
			filter: progid : DXImageTransform.microsoft.alphaimageloader (src =    
				     'resources/back.jpg', sizingmethod = 'scale' );
		}
		
		.selectedStyle{background-Color:#0000FF;color:#FFFFFF}
		-->
		</style>

	</head>
	<body leftMargin="0" rightMargin="0" topMargin="0">
		<form id="formName" name="fLogin" method="POST"
			action="<%=request.getContextPath()%>/login.action">
			<input type="hidden" name="url" value="portalDispatcher.action" />
			<input type="hidden" name="iparray" value />
		<table class="login" width="100%" height="100%" cellspacing="0"
			cellpadding="0" align="center" border="0">
			<tr>
				<td>
				<table width="1005" height="600" cellspacing="0" cellpadding="0"
					align="center" valign="middle" border="0"
					background="resources/login4.jpg">
					<tr>
						<td colspan="5" height="290">
						<div align="right"><a style="FONT-SIZE: 12px; COLOR: red"
							href="/download/平台应用控件.exe">平台应用控件下载</a></div>
						</td>
					</tr>
					<tr>
						<td height="17" width="381"></td>
						<td width="86"><div id="userTxt"></div></td>
						<td rowspan="4" width="5"></td>
						<td rowspan="4" width="65" style="cursor: hand" onClick="login(fLogin);"></td>
						<td rowspan="4" width="442"></td>
					</tr>
		
					<tr>
						<td height="12" colspan="2"></td>
					</tr>
					<tr>
						<td height="18" width="381"></td>
						<td width="109"><div id="passTxt"></div></td>
					</tr>
					<tr>
						<td colspan="5"></td>
					</tr>
				</table>
				</td>
				</tr>
				<tr>
					<td></td>
				</tr>
		</table>
		</form>
	</body>
	<script language=javascript
		event=OnObjectReady(objObject,objAsyncContext) for=foo> 
			if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true){
				var rowData = new Array();
			    if(objObject.MACAddress != null && objObject.MACAddress != "undefined")
			    	rowData[0] = objObject.MACAddress;
			    if(objObject.IPEnabled && objObject.IPAddress(0) != null && objObject.IPAddress(0) != "undefined")
			    	rowData[1] = objObject.IPAddress(0);
			    ipData[ipData.length] = rowData;
		    }
		</script>
	<object id=locator style="display:none" classid=CLSID:76A64158-CB41-11D1-8B02-00600806D9B6
		VIEWASTEXT></object>
	<object id=foo style="display:none" classid=CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223></object>
	<SCRIPT language=JScript>
			var service = locator.ConnectServer();
			var MACAddr;
			var IPAddr;
			var ipData = [];
			service.Security_.ImpersonationLevel=3;
			service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
		</SCRIPT>
	<div id="userListDiv" style="position:absolute;display:none;overflow:auto;background:#ffffff">
		<table id="userList" border="0" cellspacing="0" cellpadding="0" width="100%">
		</table>
	</div>
</html>
