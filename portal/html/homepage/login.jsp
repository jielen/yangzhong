<%@ page contentType="text/html; charset=utf-8"%>
<%
	String result = (String) request.getAttribute("fail");
%>
<html>
	<head>
		<TITLE>登录</TITLE>
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
		    filter:progid:DXImageTransform.microsoft.alphaimageloader(src='resources/back.jpg',sizingmethod='scale');
		    /*background:url(resources/login4.jpg);*/
		}
		-->
		</style>
		<script type="text/javascript">
    		window.moveTo(0,0);
    		window.resizeTo(window.screen.availWidth, window.screen.availHeight);
    		var result = "<%=result%>";
			if(result != "null" && result != "" && result != null){
				alert(result);
			}
    	</script>
		<script type="text/javascript">
    	function trim(str){  //去除字符串中间的空格
  			var oldstr = str;
  			for(var i=0;i<oldstr.length;i++)
    			str =  str.replace(" ","");
			return str;
		}

		function getIEVersion(){
			var ua = navigator.userAgent;
			var IEOffset = ua.indexOf("MSIE ");
			return parseInt(ua.substr(IEOffset + 5,1));
		}
		function joinArr(arrayData){
			var res = "";
			for(var i=0; i<arrayData.length; i++){
				for(var j=0; j<arrayData[i].length; j++){
					res += arrayData[i][j] + ',';
				}
			}
			return res;
		}

		function login(formName){ //登录
			var version = navigator.appVersion;
			if ((navigator.appVersion.indexOf("MSIE") == -1) ||
							(getIEVersion() < 6)){
		            if(confirm("此软件不能在您现在的浏览器上运行，请升级到IE 6.0以上！\n" +
		            "确定要升级吗？")){
		              open("http://www.microsoft.com/downloads/details.aspx?displaylang=zh-cn&FamilyID=1e1550cb-5e5d-48f5-b02b-20b602228de6", "ie6setup_sp1",
		              		"menubar=yes,scrollbars=yes,status=yes,toolbar=yes,"
		                  + "resizable=yes,titlebar=yes,scrollbars=yes,location=yes");
		            }
								return;
			}
			var iparray = joinArr(ipData);
			document.getElementById("formName").iparray.value = iparray;
  			transSA();
  			var formElement = formName.elements;
  			var username = trim(document.getElementById("userTxt").value);
  			if(username == ''){ //若用户名与密码都输入时的处理.
    			alert("请输入登陆帐号！");
    			document.getElementById("userTxt").focus();
    			return false;
  			}
  			formName.submit();
		}

		function transSA(){
  			var tmpUser = document.getElementById("userTxt").value;
  			if(tmpUser.toLowerCase() == "sa"){
    			document.getElementById("userTxt").value = "sa";
  			}
		}

		function enterLogin(){
  			if(event.keyCode == 13){
    			var userName = document.getElementById("userTxt").value;
    			var formName = document.getElementById("formName");
    			if(userName){
      				login(formName);
    			}else{
      				alert("请输入登陆帐号！");
      				document.getElementById("userTxt").focus();
    			}
  			}
		}

		function moveFocus(){
		  	if(event.keyCode == 13){
		    	var userName = document.getElementById("userTxt").value;
		    	if(userName == null || userName.length == 0){
		      		alert("请输入登陆帐号！");
		      		document.getElementById("userTxt").focus();
		    	}else{
		      		document.getElementById("passwordTxt").focus();
		    	}
		  	}
		}

		function init(){
		  	document.getElementById("userTxt").focus();
		  	clearAllTxt();
		}

		function clearAllTxt(){
		  	document.getElementById("userTxt").value="";
		  	document.getElementById("passwordTxt").value="";
		}
    	</script>

	</head>
	<body leftMargin="0" rightMargin="0" topMargin="0" onload="init();">
		<form id="formName" name="fLogin" method="POST" action="<%=request.getContextPath()%>/login.action">
			<input type="hidden" name="url" value="portalDispatcher.action" />
			<input type="hidden" name="iparray" value="" />
			<table border=0 cellpadding="0" cellspacing="0" width=100% height=100% background="/style/img/login/loginbk.jpg">
				<tr><td height="20">&nbsp;</td></tr>
				<tr>
					<td align=center valign=center>
						<table border=0 cellpadding="0" cellspacing="0">
							<tr>
								<td colspan="3"><img src="/style/img/login/logintop1.gif"></td>
							</tr>
							<tr>
								<td colspan="3"><img src="/style/img/login/logintop.jpg"></td>
							</tr>
							<tr>
								<td colspan="3" background="/style/img/login/login22.jpg" width="610" align=center>
									<table border="0">
										<tr>
											<td align="center" valign=center class="unChangedFontSize">登录帐号:</td>
											<td><input id="userTxt" type="text" name="username" value="" size="14" tabindex="1" islist="true" list="0" style="border: 1 solid #6398E6;" onkeypress="moveFocus()"></td>
											<td width=10></td>
											<td valign=center class="unChangedFontSize">密&nbsp;&nbsp;码:</td>
											<td>
												<input id="passwordTxt" type="password" name="password" size="14" tabindex="2" onkeypress="enterLogin()" style="border: 1 solid #6398E6;">
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td width="107"><img src="/style/img/login/login31.jpg"></td>
								<td background="/style/img/login/login32bk.jpg" width="420" align=center>
									<table border="0">
										<tr>
											<td class="unChangedFontSize" width=40></td>
											<td align="right">
												<img src="/style/img/login/ok.gif" style="cursor: hand" onClick="login(fLogin)" alt="登录">
											</td>
											<td class="unChangedFontSize" width=70>&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td>
												<img src="/style/img/login/cancel.gif" style="cursor: hand" onClick="fLogin.reset();" alt="清空">
											</td>
										</tr>
									</table>
								</td>
								<td width="83"><img src="/style/img/login/login33.jpg"></td>
							</tr>
							<tr>
								<td colspan="3"><img src="/style/img/login/loginbottom.gif"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script language=javascript event=OnObjectReady(objObject,objAsyncContext) for=foo> 
		if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true){
			var rowData = new Array();
		    if(objObject.MACAddress != null && objObject.MACAddress != "undefined")
		    	rowData[0] = objObject.MACAddress;
		    if(objObject.IPEnabled && objObject.IPAddress(0) != null && objObject.IPAddress(0) != "undefined")
		    	rowData[1] = objObject.IPAddress(0);
		    ipData[ipData.length] = rowData;
	    }
	</script>
	<object id=locator classid=CLSID:76A64158-CB41-11D1-8B02-00600806D9B6 VIEWASTEXT></object>
	<object id=foo classid=CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223></object>
	<SCRIPT language=JScript>
		var service = locator.ConnectServer();
		var MACAddr;
		var IPAddr;
		var ipData = [];
		service.Security_.ImpersonationLevel=3;
		service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
	</SCRIPT>
</html>
