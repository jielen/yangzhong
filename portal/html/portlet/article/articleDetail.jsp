<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.ufgov.gmap.context.ApplusContext"%>
<%@page import="com.ufgov.gmap.db.base.BaseDao"%>
<%@page import="com.ufgov.portal.tools.ap.domain.ApArticle"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%
	final String GET_ARTICLE_DETAIL = "portal-common.getArticleDetail";
	BaseDao dao = (BaseDao) ApplusContext.getBean("baseDao");
	Map paraMap = new HashMap();

	String articleId = null == request.getParameter("articleId") ? ""
			: request.getParameter("articleId");
	paraMap.put("articleId", articleId);
	ApArticle article = (ApArticle) dao.queryForObject(GET_ARTICLE_DETAIL, paraMap);

	String pubTime = null == request.getParameter("pubTime") ? "2009-12-25"	: request.getParameter("pubTime");
	String title = "无标题";
	String content = "";
	String mendor = "";
	if (null != article) {
		title = null == article.getTitle() ? title : article.getTitle();
		mendor = null == article.getMendor() ? (article.getCreator() == null ? mendor : article.getCreator()) : article.getMendor();
		content = null == article.getContent() ? content : article.getContent();
	}
%>

<html>
	<head>
		<title><%=title%></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/portal.css" />
		<style type="text/css">
		<!--
		body {
			background-image: url(main_bg.jpg);
			background-repeat: repeat-x;
			background-attachment: fixed;
			background-position: bottom;
			background-color: #eaf4fe;
			margin: 0 0 0 0;
		}
		.STYLE1 {
			font-size: 14px;
			color: #990033;
		}
		.font1 {
			font-size: 14px;
			color: #000000;
		}
		a.article:link {color: #000000;text-decoration: none;} /*未访问的链接 */
		a.article:visited {color:#000000;text-decoration: none;} /*已访问的链接*/
		a.article:hover{color: #ff0000;text-decoration: underline;} /*鼠标在链接上 */
		a.article:active {color: #ff0000;text-decoration:none;} /*点击激活链接*/
		-->
		</style>
		<script type="text/javascript" src="<%=request.getContextPath()%>/script/common/Ajax.js"></script>
		<script type="text/javascript">
		function changeFont(oper){
			if(oper === 'add'){
				var fontsize = document.getElementById('content').style.fontSize;
				var newfont = (parseInt(fontsize.substring(0, fontsize.length-2))+2) + "px";
				document.getElementById('content').style.fontSize = newfont;
			}
			if(oper === 'sub'){
				var fontsize = document.getElementById('content').style.fontSize;
				var newfont = (parseInt(fontsize.substring(0, fontsize.length-2))-2) + "px";
				if(newfont > 0)document.getElementById('content').style.fontSize = newfont;
			}
		}
		function getArticleAttach(){
			var ruleID = "portal-publish.getArticleAttachByParams";
			var ajax = new Ajax();
			ajax.request(function(resultText){
				var resultObject = eval('(' + resultText + ')');
                if (resultObject && resultObject.length > 0) {
                    document.getElementById('attachDiv').style.display = "";
                    for(var i = 0 ; i < resultObject.length ; i++){
                    	var table = document.getElementById('articleAttach');
                    	newRow = table.insertRow(-1);
                    	newCell = newRow.insertCell(-1);
                    		newCell.height = "25";
                    		newCell.width = "150px";
                    		newCell.innerHTML = "&nbsp;";
                    	newCell = newRow.insertCell(-1);
                    		newCell.className = "font1";
                    		newCell.height = "25";
                    		newCell.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class='article' style='cursor:hand' href=\"downloadFile.action?attachId="+resultObject[i].attach_id+"\">"+(i+1)+".&nbsp;"+resultObject[i].attach_name+"</a>";
                    }
                }
			}, "getJsonData.action", "ruleID="+ruleID+"&articleId=<%=articleId%>");
		}
		function getMendorName(){
			var ruleID = "portal-common.getMendorName";
			var ajax = new Ajax();
			ajax.request(function(resultText){
				var resultObject = eval('(' + resultText + ')');
        if(resultObject &&  resultObject.length > 0){
        	document.getElementById('mendor').innerHTML = resultObject[0].user_name;
        }else{
        	document.getElementById('mendor').innerHTML = "办公室";
        }
			}, "getJsonData.action", "ruleID="+ruleID+"&userId=<%=mendor%>");
		}
		window.onload = function(){
			getArticleAttach();
			getMendorName();
		};
		</script>
	</head>
	<body style="overflow: auto;">
<table width="980" border=0 align="center" cellpadding="0"
	cellspacing="1" bgcolor="#6DB3F8">
	<tr>
		<td bgcolor="#FFFFFF">
		<table width="100%" border=0 align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td bgcolor="#FFFFFF"><img src="/portal/resources/logo2.jpg"
					width="980"></td>
			</tr>
			<tr>
				<td bgcolor="#ffffff" align="center">
				<table width="100%" align="center" border=0 cellpadding="0" cellspacing="0" height="80">
					<tr>
						<td align="center" background="<%=request.getContextPath()%>/resources/art_bg.jpg">
							<font color="#ff0000"> <span style="font-size:18px"><%=title%></span> </font>
						</td>
					</tr>
				</table>
				<table width="100%" border=0 cellpadding="0" cellspacing="0"
					bgcolor="#E1E1E1" class="font1">
					<tr>
						<td align="right" width="70%" height="25">发布日期：<span id="articlePubTime"><%=pubTime%></span></td>
						<td align="center" width="15%">&nbsp;&nbsp;&nbsp;&nbsp;<button
							style="cursor: hand" onclick="changeFont('sub');">减小字体</button>&nbsp;&nbsp;
						<button style="cursor: hand" onclick="changeFont('add');">增大字体</button></td>
						<td align="left" width="15%">&nbsp;&nbsp;&nbsp;&nbsp;发布人：<span id="mendor"></span></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td bgcolor="#f1f1f1" width="95%" align="left">
				<div id="articleDiv" style="width:100%;height:470;overflow-y:scroll;">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="150"></td>
							<td id="content" style="font-size:14px;">&nbsp;&nbsp;<%=content%>&nbsp;&nbsp;</td>
							<td width="150"></td>
						</tr>
					</table>
					<div id="attachDiv" style="display:none;">
						<div style="height:25px;font-size:14px;margin-left:150px;">附件:</div>
						<div style="margin-left:0px;">
							<table id="articleAttach" width="100%" border="0" cellspacing="0" cellpadding="0" class="font1">
							</table>
						</div>
					</div>
				</div>
				</td>
			</tr>
			<tr>
				<td>
				<table width="100%" bgColor="#FFDA99" border="0" cellspacing="3" cellpadding="2" class="font1">
					<tr>
						<td align="right">
						【<a href="#" onClick="javascript:window.print()">打印本页</a>】&nbsp;&nbsp;&nbsp;&nbsp;
						【<a href="#" onClick="window.close()">关闭本页</a>】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

</body>
</html>