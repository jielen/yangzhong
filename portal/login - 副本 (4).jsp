<meta http-equiv="Content-Type" content="text/html;charset=gb2312"/>
<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="com.anyi.gp.domain.Group"%>
<%
	String result = (String) request.getAttribute("fail");
	String groupId = request.getParameter("groupId");
	String openUrl = request.getParameter("url");
	openUrl = null == openUrl || "".equals(openUrl) ? "/portalDispatcher.action?" : openUrl;
%>

<html>
	<head>
  	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
		<TITLE>丹徒区政府采购</TITLE>
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
		    filter:progid:DXImageTransform.microsoft.alphaimageloader(src='/portal/resources/back.jpg',sizingmethod='scale');
		    /*background:url(resources/login4.jpg);*/
		}
			#loft_win {border:#0066FF 1px solid;}
	#loft_win_min {border:#0066FF 1px solid;}
	.loft_win_head {color: #FFFFFF; font-size:13px; background-color:#0066FF; height:25px; padding:0,5,0,5;}
	#contentDiv {background-color:#FFFFFF; border:#0066FF 1px solid; border-left-style:none; border-right-style:none;}
	a { font-size:12px; color:#000000;}
	a:link {font-size:12px; color:#999999; text-decoration:none;}
	a:visited { font-size:12px; color:#999999; text-decoration:none;}
	a:hover {font-size:13px; color:#999999; text-decoration:none; border:#FF9900 1px dashed; border-left-style:none; border-right-style:none; border-top-style:none;}
	a:actived {font-size:12px; color:#000000; text-decoration:none;}
		-->
		</style>
		<script type="text/javascript">
    		window.moveTo(0,0);
    		window.resizeTo(window.screen.availWidth, window.screen.availHeight);
    		var result = "null";
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
		function loginca(){
		  	window.location.href='/portal/html/home_in/ca/ca_userlogin.jsp';
		}
		function init(){
		  	document.getElementById("userTxt").focus();
		  	clearAllTxt();
			 Top = parseInt(document.getElementById("loft_win").style.top,10);
			divLeft = parseInt(document.getElementById("loft_win").style.left,10);
			divHeight = parseInt(document.getElementById("loft_win").offsetHeight,10);
			divWidth = parseInt(document.getElementById("loft_win").offsetWidth,10);
			docWidth = document.body.clientWidth;
			docHeight = document.body.clientHeight;
			document.getElementById("loft_win").style.top = parseInt(document.body.scrollTop,10) + docHeight + 10;// divHeight
			document.getElementById("loft_win").style.left = parseInt(document.body.scrollLeft,10) + docWidth - divWidth;
			document.getElementById("loft_win").style.visibility="visible";
			//objTimer = window.setInterval("moveDiv()",10);
		}

		function clearAllTxt(){
		  	document.getElementById("userTxt").value="";
		  	document.getElementById("passwordTxt").value="";
		}
    	</script>
    	<script type="text/javascript">
<!--
	<!--右下脚弹出窗口开始-->
	<!--
	window.onresize = resizeDiv;
	window.onerror = function(){}
	var divTop,divLeft,divWidth,divHeight,docHeight,docWidth,objTimer,i = 0;
	-->
	

	
	//初始化位置
	function resizeDiv()
	{
		i+=1;
		if(i>0) closeDiv() //想不用自动消失由用户来自己关闭所以屏蔽这句
		try
		{
			divHeight = parseInt(document.getElementById("loft_win").offsetHeight,10);
			divWidth = parseInt(document.getElementById("loft_win").offsetWidth,10);
			docWidth = document.body.clientWidth;
			docHeight = document.body.clientHeight;
			document.getElementById("loft_win").style.top = docHeight - divHeight + parseInt(document.body.scrollTop,10);
			document.getElementById("loft_win").style.left = docWidth - divWidth + parseInt(document.body.scrollLeft,10);
		}
		catch(e){}
	}
	
	//最小化
	function minsizeDiv()
	{
		i+=1
		//if(i>300) closeDiv() //想不用自动消失由用户来自己关闭所以屏蔽这句
		try
		{
			divHeight = parseInt(document.getElementById("loft_win_min").offsetHeight,10);
			divWidth = parseInt(document.getElementById("loft_win_min").offsetWidth,10);
			docWidth = document.body.clientWidth;
			docHeight = document.body.clientHeight;
			document.getElementById("loft_win_min").style.top = docHeight - divHeight + parseInt(document.body.scrollTop,10);
			document.getElementById("loft_win_min").style.left = docWidth - divWidth + parseInt(document.body.scrollLeft,10);
		}
		catch(e){}
	}
	
	//移动
	function moveDiv()
	{
	try
	{
		if(parseInt(document.getElementById("loft_win").style.top,10) <= (docHeight - divHeight + parseInt(document.body.scrollTop,10)))
		{
			window.clearInterval(objTimer);
			objTimer = window.setInterval("resizeDiv()",1);
		}
		divTop = parseInt(document.getElementById("loft_win").style.top,10);
		document.getElementById("loft_win").style.top = divTop -1;
	}
		catch(e){}
	}
	
	function minDiv()
	{
		closeDiv();
		document.getElementById('loft_win_min').style.visibility='visible';
		objTimer = window.setInterval("minsizeDiv()",1);
	}
	
	function maxDiv()
	{
		document.getElementById('loft_win_min').style.visibility='hidden';
		document.getElementById('loft_win').style.visibility='visible';
		objTimer = window.setInterval("resizeDiv()",1);
		//resizeDiv()
		getMsg();
	}
	
	function closeDiv()
	{
		document.getElementById('loft_win').style.visibility='hidden';
		document.getElementById('loft_win_min').style.visibility='hidden';
		if(objTimer) window.clearInterval(objTimer);
	}
	<!--右下脚弹出窗口结束-->
	-->
</script>

	</head>
	<body  leftMargin="0" rightMargin="0" topMargin="0" >
	<!--提示窗口代码开始-->
	<!--初状态-->
	<DIV id="loft_win" style="Z-INDEX:99999; LEFT: 0px; VISIBILITY: hidden;WIDTH: 250px; POSITION: absolute; TOP: 0px; HEIGHT: 250px;">
		<TABLE cellSpacing=0 cellPadding=0 width="100%" bgcolor="#FFFFFF" border=0>
			<TR>
				<td width="100%" valign="middle" align="center">
					<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="70" class="loft_win_head">更新日志</td>
							<td width="26" class="loft_win_head"> </td>
							<td align="right" class="loft_win_head">
								<span style="CURSOR: hand;font-size:12px;font-weight:bold;margin-right:4px;" title=最小化 onclick=minDiv() >- </span><span style="CURSOR: hand;font-size:12px;font-weight:bold;margin-right:4px;" title=关闭 onclick=closeDiv() >×</span>
							</td>
						</tr>
					</table>
				</td>
			</TR>
			<TR>
				<TD height="30" align="middle" valign="middle" colSpan=3>
					<div id="contentDiv">
						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="center" height="100%">
									<div>
										<a>更新内容</a>

									</div>
								</td>
							</tr>

						</table>
					</div>
				</TD>
			</TR>
			<TR>
				<TD height="30" align="center" valign="middle" colSpan=0>
					<div id="contentDiv">
						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="left" height="100%">
									<!--<div style="width:100px;overflow: hidden; word-break:keep-all;white-space:nowrap;text-overflow:ellipsis;" >-->
										<div>
		           								<!--<a href="http://www.sohu.com" target="_blank">那我走了lashljbldasjgqqqqqqqqqq！</a></div>-->
												<a  target="_blank"><font color="red">1.采购单位请使用新的预算单位代码登录，新代码从陕西省政府采购网站，下载专区中下载
</font></a>
								</td>
							</tr>

						</table>
					</div>
				</TD>		
			</TR>
			<TR>
				<TD height="30" align="center" valign="middle" colSpan=0>

						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="left" height="100%">
								<!--<div style="width:100px;overflow: hidden; word-break:keep-all;white-space:nowrap;text-overflow:ellipsis;" >-->
										<div>
		           								<!--<a href="http://www.sohu.com" target="_blank">那我走了lashljbldasjgqqqqqqqqqq！</a></div>-->
												<a  target="_blank">2.系统待办增加声音提示，5分钟提示一次</a>
								</td>
							</tr>
						</table>
				</TD>		
			</TR>	
			<TR>
				<TD height="30" align="center" valign="middle" colSpan=0>

						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="left" height="100%">
								<!--<div style="width:100px;overflow: hidden; word-break:keep-all;white-space:nowrap;text-overflow:ellipsis;" >-->
										<div>
		           								<!--<a href="http://www.sohu.com" target="_blank">那我走了lashljbldasjgqqqqqqqqqq！</a></div>-->
												<a  target="_blank">3.本系统的《采购单位使用手册》，已更新至陕西省政府采购网站，可在下载专区中下载</a>
								</td>
							</tr>
						</table>
				</TD>		
			</TR>	
			<TR>
				<TD height="30" align="center" valign="middle" colSpan=0>

						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="left" height="100%">
								<!--<div style="width:100px;overflow: hidden; word-break:keep-all;white-space:nowrap;text-overflow:ellipsis;" >-->
										<div>
		           								<!--<a href="http://www.sohu.com" target="_blank">那我走了lashljbldasjgqqqqqqqqqq！</a></div>-->
												<a  target="_blank">4.增加“验收单”相关功能</a>
								</td>
							</tr>
						</table>
				</TD>		
			</TR>	
			<TR>
				<TD height="30" align="center" valign="middle" colSpan=0>

						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="left" height="100%">
								<!--<div style="width:100px;overflow: hidden; word-break:keep-all;white-space:nowrap;text-overflow:ellipsis;" >-->
										<div>
		           								<!--<a href="http://www.sohu.com" target="_blank">那我走了lashljbldasjgqqqqqqqqqq！</a></div>-->
												<a  target="_blank">5.完善“打印”相关功能</a>
								</td>
							</tr>
						</table>
				</TD>		
			</TR>	
			<!--<TR>
				<TD height="30" align="center" valign="middle" colSpan=0>

						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="center" height="100%">
								<!--<div style="width:100px;overflow: hidden; word-break:keep-all;white-space:nowrap;text-overflow:ellipsis;" >-->
										<div>
		           								<!--<a href="http://www.sohu.com" target="_blank">那我走了lashljbldasjgqqqqqqqqqq！</a></div>
												<a  target="_blank">那我<br>走了11！</a>
								</td>
							</tr>
						</table>
				</TD>		
			</TR> -->
				<td>
					<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="100%" class="loft_win_head" align="right">			
						<!--<a href="http://www.sohu.com" target="_blank">更多</td></a>-->
						     <a target="_blank">《更多》</td></a>
							</td>
						</tr>
					</table>
				<td>			
		</TABLE>
	</DIV>

	<!--最小化状态-->
	<DIV id="loft_win_min" style="Z-INDEX:99999; LEFT: 0px; VISIBILITY: hidden;WIDTH: 250px; POSITION: absolute; TOP: 0px;">
		<TABLE cellSpacing=0 cellPadding=0 width="100%" bgcolor="#FFFFFF" border=0>
			<TR>
				<td width="100%" valign="top" align="center">
					<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="70" class="loft_win_head">提示窗口</td>
							<td width="26" class="loft_win_head"> </td>
							<td align="right" class="loft_win_head">
								<span title=还原 style="CURSOR: hand;font-size:12px;font-weight:bold;margin-right:4px;" onclick=maxDiv() >□</span><span title=关闭 style="CURSOR: hand;font-size:12px;font-weight:bold;margin-right:4px;" onclick=closeDiv() >×</span>
							</td>
						</tr>
					</table>
				</td>
			</TR>
		</TABLE>
	</DIV>
	<!--提示窗口代码结束-->
		<form id="formName" name="fLogin" method="POST" action="/portal/login.action">
			<input type="hidden" name="url" value="/portalDispatcher.action?" />
			<input type="hidden" name="iparray" value="" />
			<table class="login" width="100%" height="100%" cellspacing="0" cellpadding="0" align="center" border="0">
				<tr><td>
					<div style="position:relative;">
					<table width="1000" height="600" cellspacing="0" cellpadding="0" align="center" valign="middle" border="0" background="/portal/resources/logindantu.jpg">
						<tr><td colspan="5" height="290">&nbsp;</td></tr>
						<tr><td width="400" height="22"></td>
							<td width="95"><input type="text" onkeypress="moveFocus()" style="height:19;width:95;border:0;" size="15" value="" name="username" id="userTxt"></td>
							<td width="28" rowspan="3">&nbsp;</td>
							<td width="40" onclick="login(fLogin);" style="cursor:hand" rowspan="3">&nbsp;</td>
							<td rowspan="3">&nbsp;</td>
						</tr>
						<tr><td height="10" colspan="2"></td>
							<td></td>
						</tr>
						<tr><td height="21">&nbsp;</td>
							<td><input id="passwordTxt" name="password" type="password" value="" size="15" style="height:19;width:95;border:0;"  onkeypress="enterLogin()"></td>
						</tr>
						<tr><td colspan="5" height="15">&nbsp;</td></tr>
						<tr>
							<td width="400" height="22"></td>
							<td width="95" style="cursor:hand" onclick="loginca()"></td>
							<td colspan="3" >&nbsp;</td>
						</tr>
						<tr><td colspan="5">&nbsp;</td></tr>
					</table>
					</div>
				<tr><td>
				</td></tr>
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
