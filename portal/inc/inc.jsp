<%@page contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String sessionIdKey = com.ufgov.gmap.pub.AppServer.getSessionIdKey();
%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
<script>
	context_g = path = '<%=path%>';
	fckBasePath = '/fckeditor/fckeditor/';
	var sessionIdKey = '<%=sessionIdKey%>';
	document.oncontextmenu = function(){return false;};
</script>

<link rel="stylesheet" type="text/css" href="/extjs/ext/resources/css/ext-all.css" />
<link id="themes" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/portal.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/file-upload.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/datetime.css" />

<script type="text/javascript" src="/extjs/ext/ext/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext/ext-all.js"></script>
<script type="text/javascript" src="/extjs/ext/locale/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/PanelUF.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/FileUploadField.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/TreeNodeRichUI.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/Datetime.js"></script>

<script type="text/javascript" src="<%=path%>/script/common/Base.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/Param.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/Menu.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/Import.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/ConnectCrossDomain.js"></script>
<script type="text/javascript" src="/fckeditor/fckeditor/fckeditor.js"></script>

<script type="text/javascript">
<!--
Ext.Ajax.request({
	url: "getJsonData.action",
	params: {
		ruleID: "portal-common.getTheme"
	},
	success: function(res){
		var result = Ext.util.JSON.decode(res.responseText);
		var themeCss = "xtheme-" + result[0].theme_code + ".css";
		var themeUrl = path + "/html/themes/" + result[0].theme_code + "/css/" + themeCss;
		Ext.util.CSS.swapStyleSheet("themes", themeUrl);
	}
});
//-->
</script>

<span id="svStdCurrency" value='<%=session.getAttribute("svStdCurrency")%>'></span>
<span id="svFiscalPeriod" value='<%=session.getAttribute("svFiscalPeriod")%>'></span>
<span id="svNd" value='<%=session.getAttribute("svNd")%>'></span>
<span id="svFiscalYear" value='<%=session.getAttribute("svFiscalYear") %>'></span>
<span id="svTransDate" value='<%=session.getAttribute("svTransDate") %>'></span>
<span id="svSysDate" value='<%=session.getAttribute("svSysDate")%>'></span>
<span id="svUserId" value='<%=session.getAttribute("svUserID") %>'></span>
<span id="svUserName" value='<%=session.getAttribute("svUserName") %>'></span>
<span id="svCoCode" value='<%=session.getAttribute("svCoCode") %>'></span>
<span id="svCoName" value='<%=session.getAttribute("svCoName") %>'></span>
<span id="svAccountId" value='<%=session.getAttribute("svAccountId") %>'></span>
<span id="svAccountName" value='<%=session.getAttribute("svAccountName") %>'></span>
<span id="svOrgCode" value='<%=session.getAttribute("svOrgCode")%>'></span>
<span id="svOrgName" value='<%=session.getAttribute("svOrgName") %>'></span>
<span id="svEmpCode" value='<%=session.getAttribute("svEmpCode") %>'></span>
<span id="svPoCode" value='<%=session.getAttribute("svPoCode") %>'></span>
<span id="svPoName" value='<%=session.getAttribute("svPoName") %>'></span>
<span id="svRpType" value='<%=session.getAttribute("svRpType") %>'></span>
<span id="svRpTypeName" value='<%=session.getAttribute("svRpTypeName") %>'></span>
<span id="svBankCode" value='<%=session.getAttribute("svBankCode") %>'></span>
<span id="svBankNodeCode" value='<%=session.getAttribute("svBankNodeCode") %>'></span>
<span id="checkID" value='<%=session.getAttribute("checkID") %>'></span>