
<%@page import="com.ufgov.gmap.license.LicenseManager"%>
<%@page import="com.ufgov.gmap.domain.SessionUtils"%>
<%@page import="com.anyi.gp.domain.User"%>
<%@page import="com.anyi.gp.domain.Group"%>
<%@page import="com.ufgov.gmap.pub.Pub" %>
<%
  	String path = request.getContextPath();
	String token = (String)session.getAttribute("current.user.token");
	String userId = (String)session.getAttribute("svUserID");
	String userName = (String)session.getAttribute("svUserName");
	if(token == null)response.sendRedirect(path + "/index.jsp");
	String loginTime = (new java.sql.Timestamp(System.currentTimeMillis())).toString();
	loginTime = loginTime.substring(0, loginTime.length() - 4);
	LicenseManager licenseManager = (LicenseManager)ApplusContext.getBean("licenseManager");
  	String titleMessage = licenseManager.getTitleMessage(userId);
  	String alertMessage = licenseManager.getLoginMessage();
  	int groupNum = 0;
  	String groupId = request.getParameter("groupId");//显示特定用户组
  	if(groupId == null) {
  		if(null != SessionUtils.getCurrentUser(request)) {
  			List groupList = ((User)SessionUtils.getCurrentUser(request)).getGroupList();
  			groupNum = groupList.size();
  			if(null != groupList && groupList.size() > 0) {
  				for (int i = 0; i < groupList.size(); i++){
		  			Group defaultGroup = (Group)groupList.get(i);
		  			if(!"sa".equals(defaultGroup.getId())) {
		  				groupId = defaultGroup.getId();
		  				break;
		  			}
		  		}
	  		}
  		}
  		else {
  			groupId = "";
  		}
  	}

  	String tShowFuncLink = request.getParameter("showFuncLink");
  	if(tShowFuncLink == null || tShowFuncLink.trim().length() == 0){
  		showFuncLink = true;
  	}else{
  		showFuncLink = Pub.parseBool(tShowFuncLink);//是否显示功能区
  	}
  	
  	String tForceShowPage = request.getParameter("forceShowPage");
  	boolean forceShowPage = false;
  	if(tForceShowPage == null || tForceShowPage.trim().length() == 0){
  		forceShowPage = true;
  	}else{
  		forceShowPage = Pub.parseBool(tForceShowPage);//强制显示页面栏目(不管是否设置为显示与否)
  	}
  	boolean onlyOneLoginPerMachine = Pub.parseBool(ApplusContext.getEnvironmentConfig()
			.get("onlyOneLoginPerMachine"));
%>
<jsp:include page="/inc/inc.jsp" />
<html>
  	<head>
  	  <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
  		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title></title>
    	<script type="text/javascript" src="html/home_in/MainPageIn.js"></script>
    	<script language="VBScript" src="script/common/formenctype.vbs"></script>

    	<script type="text/javascript">
    		window.moveTo(0,0);
    		window.resizeTo(window.screen.availWidth, window.screen.availHeight);
    		token = '<%=token%>';
    		userId = '<%=userId%>';
    		userName = '<%=userName%>';
    		groupId = '<%=groupId%>';
    		showFuncLink = <%=showFuncLink%>;
    		forceShowPage = <%=forceShowPage%>;
    		pageId = '<%=pageId%>';
    		showLogoPanel = true;
    		groupNum = <%= groupNum%>;
    		
    		var serverScheme = '<%=request.getScheme()%>';   
        var serverIp = '<%=request.getServerName()%>';   
        var serverPort = '<%=request.getServerPort()%>';  
    		var loginTime = '<%=loginTime%>';
    		var titleMessage = "<%=titleMessage%>";
			var loginMessage = "<%=alertMessage%>";
			var onlyOneLoginPerMachine = <%=onlyOneLoginPerMachine%>;
			
		    function closeMess(){
		    	Ext.Ajax.request({
					url: 'logout.action',
					success: function(){							
					}
				})
		    }
		    function doLoad(){
		    	//checkRegister();
		    	var checkID = document.getElementById("checkID").getAttribute("value");
		    	if("1" == checkID && "false" != PF.getCookie("showGlobal")){
		    		var FuncLink = new ufgov.portal.FuncLink();
		    		FuncLink.setGlobal();
		    	}
		    	if(onlyOneLoginPerMachine){
		    		document.applets[0].setLogined(true);
		    	}
		    }
		    function checkRegister(){
				if (loginMessage.length > 0){
					alert(loginMessage);
				}
				if (titleMessage.length > 0) {
					document.title = titleMessage;
				}
			}
    	</script>
  	</head>

  	<body  onLoad="doLoad();">
    	<div id="west"></div>
    	<div id="center"></div>
    	<div id="east"></div>
		
 	</body>
 	<body>
 	<%if(onlyOneLoginPerMachine) {%>
	<applet id="loginValidateApplet" code="com.ufgov.login.LoginValidateApplet.class" codebase="/portal/applet/" height="0" width="0" archive="LoginValidate.jar">
		<param name="autoLogout" value="true">
	</applet>
	<%} %>
	
</body>
</html>
<SCRIPT LANGUAGE="JavaScript">
<!--
Ext.onReady(function(){
	Ext.useShims = true;
    Ext.ufgovW = {};
	Ext.ufgovW.QuickTips = {
		win : null,
		show : function(x,y,msg){
			if(Ext.ufgovW.QuickTips.win != null) Ext.ufgovW.QuickTips.win.close();
			Ext.ufgovW.QuickTips.win=new Ext.Window({
				title:'系统提示',
				width:290,
				height:170,
				closeAction:'close',
				constrain:false,
				html : "<div id='windowContent'>" + msg + "</div>",
				pageX : x - 200,
				pageY : y * 1 + 20,
				resizable :true,
				autoScroll :true 
			});
			Ext.ufgovW.QuickTips.win.show(); 
		},
		showContent:function(msg){
			if(document.getElementById("windowContent")){
				document.getElementById("windowContent").innerHTML = msg;
			}
		},
		close: function(){
			if(Ext.ufgovW.QuickTips.win != null) {
				Ext.ufgovW.QuickTips.win.close();
				Ext.ufgovW.QuickTips.win = null;
			};
		}
	}
	
	Ext.ufgovW.showMsg= function(msg){
		var x = window.screen.width - 130;
		var y = 0;
	    Ext.ufgovW.QuickTips.show(x,y,msg);
	} 

	
	function getMessageFromServer(){
		Ext.Ajax.request({
			url: '/GB/portal/message/NoticeMessageAction.do',
			params: {userId:'<%=userId%>'},
			success: function(response){
				eval("var temp = " + response.responseText);
				var textArr = [];
				for(var i = 0;i < temp.length;i++){
					textArr.push("有 【" + temp[i].count + "】条【" + temp[i].name + "】需要审核；");
				}
				if(textArr.length > 0){
					if(Ext.ufgovW.QuickTips.win != null){
						Ext.ufgovW.QuickTips.showContent("您" + textArr.join("<br/>"));
					}else{
					    Ext.ufgovW.showMsg("您" + textArr.join("<br/>"));
					}
					setTimeout(getMessageFromServer,1000*30);
				}
				
			}
		});
	}

	
	//setTimeout( getMessageFromServer,1000);
});
//-->
</SCRIPT>
