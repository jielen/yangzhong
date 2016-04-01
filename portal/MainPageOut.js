/**
 * @class ufgov.portal.MainPageOut
 * 
 */
var portalJson;
var portalArray;
var groupId;
var pageId;
var portletInfo;
var currentPageArray;
var logoHtml="";
$import('script/common/File.js');
$import('script/common/PublicFunction.js');
$import('html/portlet/PageTemp.js');
$import('html/portlet/login/LoginPortlet.js');
$import('html/portlet/link/Link.js');
$import('html/portlet/download/Download.js');
$import('html/portlet/msgBoard/MsgBoardView.js');
$import('html/portlet/msgBoard/MsgBoardEdit.js');
$import('html/portlet/article/ArticleSearch.js');
$import('html/portlet/article/ArticleApp.js');
$import('html/portlet/bbs/ForumView.js');
$import('html/portlet/other/BlankPortlet.js');
$import('html/portlet/calendar/CalendarApp.js');
$import('html/portlet/calendar/DailyPlanDetail.js');
ufgov.portal.MainPageOut = function(){
	var portalWidth = 800;
	return {
		pageInit: function(){
			var tempPortalWidth = portalArray[0].pre_width;
			if (tempPortalWidth === '') {
				portalWidth = 800;
			}
			else if (tempPortalWidth.indexOf('%') > 0) {
				tempPortalWidth = tempPortalWidth.substring(0, tempPortalWidth.indexOf('%')) / 100.0;
				portalWidth = Ext.getBody().getWidth() * tempPortalWidth;
			}
			else {
				portalWidth = tempPortalWidth;
			}
			Ext.get('top').setWidth(portalWidth);
			Ext.get('navigation').setWidth(portalWidth);
			Ext.get('center').setWidth(portalWidth);
			Ext.get('bottom').setWidth(portalWidth);
			
			this.createTopPanel();
			this.createCenterPanel();
			this.createBottomPanel();
			this.getMenuPanel();
			//Ext.get('navigation').setHeight(10);
			//debugger;
		},
		createTopPanel: function(){
			var logoUrl = portalArray[0].logo_url;
			logoUrl = "html/themes/" + portalArray[0].theme_code + "/" + logoUrl;
			var logo;
			var width, height;
			if(logoUrl.indexOf('|') > 0){
				var logoUrlArray = logoUrl.split('|');
				logo = logoUrlArray[0];
				if(logoUrlArray[1]){
					width = logoUrlArray[1];
				}else{
					width = portalWidth;
				}
				if(logoUrlArray[2]){
					height = logoUrlArray[2];
				}else{
					height = 100;
				}
			}else{
				logo = logoUrl;
				height = 100;
			}
			var top;
			logo=path+'/'+logo;
			if (logo && logo.substring(logo.lastIndexOf('.') + 1) == 'swf') {
				top = "<embed src='" + logo + "'";
				top += " width='"+width+"' height='"+height+"' quality='high' pluginspage='http://www.macromedia.com/go/getflashplayer' ";
				top += "type='application/x-shockwave-flash' wmode='transparent'></embed>";
			}
			else if (!Ext.isEmpty(logo)) {
				top = "<img src=\""+logo+"\" width=\"100%\" height=\"" + height + "\">";
			} else {
				top = '<img src="'+path+'/resources/top.jpg" width="100%" height="100">';
			}
			logoHtml=top;
			var topPanel = new Ext.Panel({
				applyTo: 'top',
				border: false,
				height: height,
				html: top
			});
		},
		createCenterPanel: function(){
			new Ext.Panel({
				layout: 'fit',
				applyTo: 'center',
				id: 'centerPanel',
				autoHeight: true,
				//height: 500,
				border: false,
				items: {
					layout: 'fit',
					border: false,
					html: '<div id="mainPanel"></div>'
				}
			})
		},
		createBottomPanel: function(){
			var copyright = portalArray[0].copyright;
			var bottomTable = '<table border="0" align="center" height="30" width="100%">';
			bottomTable += '<tr><td class="thbody" align="center">';
			bottomTable += copyright;
			bottomTable += '</td></tr></table>';
			new Ext.Panel({
				layout: 'fit',
				applyTo: 'bottom',
				height: 30,
				border: false,
				html: bottomTable
			})
		},
		getMenuPanel: function(){
			//debugger;
			var Menu = new ufgov.portal.common.Menu();
			Menu.createRowPage(groupId, 'navigation', 'MainPageOut.execRowPageUrl', 'MainPageOut.execRowPageUrl', pageId, true);
		},
		/**************栏目横向显示时，单击事件执行函数*****************/
		execRowPageUrl: function(pageInfo, menuOrient){
			currentPageArray = Ext.util.JSON.decode(pageInfo);
			var hasChildren = currentPageArray.has_children;
			//debugger;
			if(hasChildren){
				MainPageOut.getPagePortletInfo(pageInfo);
				//var Menu = new ufgov.portal.common.Menu();
				//MainPageIn.createNewMainPanel(pageTitle);
				//Menu.createCellPage(groupId, pageId, 'menuTree', 'MainPageOut.execCellPageUrl', null);
				////MainPageIn.getPagePortletInfo("", "mainFrame");
			}else{
				//没有菜单，此时直接显示频道
				MainPageOut.getPagePortletInfo(pageInfo);
			}
		},
		getPagePortletInfo: function(pageInfo){
			currentPageArray = Ext.util.JSON.decode(pageInfo);
			pageId = currentPageArray.page_id;
			Ext.Ajax.request({
				url: 'getJsonData.action',
				params: {
					ruleID: 'portal-common.getPagePortlet',
					pageId: pageId
				},
				success: function(response){
					portletInfo = Ext.util.JSON.decode(response.responseText);
//					for (var i = 0; i < portletInfo.length; i++) {
//						var portletUrl = portletInfo[i].portlet_url;
//						var ext = String(portletUrl.match(/[^\.]+$/));
//						if (ext && ext.toLowerCase() == 'js') {
//							$import(portletUrl);
//						}
//					}
					MainPageOut.getReadyState('MainPageOut.createMainPanel');
				},
				failure: function(response){
					var result = Ext.util.JSON.decode(response.responseText);
					var Base = new ufgov.portal.Base();
					Base.showMsg('温馨提示', result);
				}
			})
		},
		getReadyState: function(execFunc){
			if(document.readyState != undefined){
				if (document.readyState == "complete") {
					eval(execFunc)();
				}
				else {
					window.setTimeout(this.getReadyState(execFunc),2);
				}
			}else{
				eval(execFunc)();
			}
		},
		createMainPanel: function(){
			var pageUrl = currentPageArray.page_url;
			var isAlwaysNew = currentPageArray.is_always_new;
			if (Ext.isEmpty(pageUrl)) {
				var columnCount = currentPageArray.column_count;
				var columnRatio = currentPageArray.column_ratio;
				var columnWidth = new Array();
				if (columnCount > 1) {
					if (!Ext.isEmpty(columnRatio)) {
						columnWidth = columnRatio.split(',');
					}
					else {
						columnWidth[columnWidth.length] = (100 / columnCount) / 100.0;
					}
				}
				MainPageOut.showPortletColumn(columnCount, columnWidth, pageId);
			}
			else {
				if (isAlwaysNew == 'Y') {
					window.open(pageUrl, '_blank', '');
				}
				else {
					if(pageUrl.indexOf('/') == 0){
						pageUrl = 'html/homepage' + pageUrl;
					}else{
						pageUrl = 'html/homepage' + '/' + pageUrl;
					}
					/**
					 * 销毁以前的面板
					 */
					MainPageOut.destroyPanel(MainPageOut.pageContPanel);
					MainPageOut.destroyPanel(MainPageOut.jspPanel);
					
					MainPageOut.jspPanel = new Ext.Panel({
						applyTo: 'mainPanel',
						border: false,
						autoHeight: true,
						id: 'jspPanel',
						items: {
							border: false,
							html: '<div id="newJspPanel"></div>'
						}
					})
					var main = Ext.get("newJspPanel");
					main.load({
						url: pageUrl,
						scripts: true,
						text: "数据装载中，请稍候..."
					});
				}
			}
		},
		showPortletColumn: function(columnCount, columnWidth, pageId){
			if (columnCount > 1) {
				var pagePortletColumn = '[';
				for (var i = 0; i < columnCount; i++) {
					pagePortletColumn += '{';
					pagePortletColumn += 'columnWidth:';
					if (columnWidth.length > 1) {
						pagePortletColumn += columnWidth[i];
					}
					else {
						pagePortletColumn += columnWidth[0];
					}
					pagePortletColumn += ',';
					if (i == columnCount - 1) {
						pagePortletColumn += 'style: "padding:0px 0px 5px 0px"';
					}
					else {
						pagePortletColumn += 'style: "padding:0px 5px 5px 0px"';
					}
					pagePortletColumn += '}';
					pagePortletColumn += ',';
				}
				if (pagePortletColumn.indexOf(',') > 0) {
					pagePortletColumn = pagePortletColumn.substring(0, pagePortletColumn.length - 1);
				}
				pagePortletColumn += ']';
				pagePortletColumn = Ext.util.JSON.decode(pagePortletColumn);
			}
			else {
				var pagePortletColumn = '[';
				pagePortletColumn += '{';
				pagePortletColumn += 'style: "padding:0px 0px 5px 0px"';
				pagePortletColumn += '}';
				pagePortletColumn += ']';
				pagePortletColumn = Ext.util.JSON.decode(pagePortletColumn);
			}
			/**
			 * 销毁以前的面板
			 */
			MainPageOut.destroyPanel(MainPageOut.pageContPanel);
			MainPageOut.destroyPanel(MainPageOut.jspPanel);

			MainPageOut.pagePortletPanel = new ufgov.portal.Template({
					border: false,
					items: pagePortletColumn
				});
			MainPageOut.pageContPanel = new Ext.Panel({
				applyTo: 'mainPanel',
				id: 'pageContPanel',
				autoHeight: true,
				border: false,
				items: MainPageOut.pagePortletPanel
			});
			
			this.showPortlet();
		},
		showPortlet: function(){
			var ppanel = MainPageOut.pagePortletPanel;
			var m = 0;
			for (var i = 0; i < portletInfo.length; i++) {
				var portletId = portletInfo[i].portlet_id;
				var portletUrl = portletInfo[i].portlet_url.trim();
				var portletClassName = portletInfo[i].portlet_class.trim();
				var ext = String(portletUrl.match(/[^\.]+$/));
				var portlet;
				if (portletInfo[i].col_no >= ppanel.items.items.length) {
					continue;
				}
				
				
				var panelWidth = ppanel.getInnerWidth();
				var tmpColumnWidth = ppanel.items.itemAt(portletInfo[i].col_no).columnWidth;
				if(tmpColumnWidth){
					panelWidth = panelWidth * tmpColumnWidth;
				}
				
				var showTitle = true;
				if(portletId == 'blank'){
					showTitle = false;
				}
				var portletHeight = 0;
				try{
					portletHeight = parseInt(portletInfo[i].portlet_height);
				}catch(ex){
				}
				var File = new ufgov.portal.common.File();
				if (ext && ext.toLowerCase() == 'js') {
					if (!Ext.isEmpty(portletClassName)) {
						var item = {};
						var title = "";
						try {
							var portletObj;//频道类对象
							
							if  ((' '+portletClassName).indexOf(' new ')==0) {
								   //Ext.log(portletClassName);
									portletObj= eval('('+portletClassName+')');
							} else {	
									var portletClass = eval(portletClassName);
									portletObj = new portletClass();
							}
							portletInfo[i].theme=portalArray[0].theme_code;
							portletInfo[i].panelWidth = panelWidth;
							if(portletObj && portletObj.passParam ){
								portletObj.passParam(portletInfo[i]);
							}
							if(!Ext.isEmpty(portletObj)){
								item = portletObj.panel ? portletObj.panel : {};
							}
							if (item.title) {
								item.setTitle(portletInfo[i].title);
								title = "";
							}
							else {
								title = portletInfo[i].title;
							}
							
							
							var conf = {
								border: false,
								//autoHeight: true,
								//title: title,
								items: item
							};
							if(portletHeight > 0){
								conf.height = portletHeight;
							}else{ 
								conf.autoHeight = true;
							}
							
							if(showTitle){
								conf.title = title;
							}
							
							portlet = new ufgov.portal.Portlet(conf);
						} 
						catch (e) {
							portlet = new ufgov.portal.Portlet({
								border: true,
								autoHeight: true,
								title: portletInfo[i].title,
								html: '出现异常，可能是该频道对应的js文件没有定义类名，或者是没有正确导入js文件'
							});
						}
						
					}
					else {
						portlet = new ufgov.portal.Portlet({
							border: true,
							autoHeight: true,
							title: portletInfo[i].title,
							html: '没有定义该频道js文件对应的类名，请在数据库中添加'
						});
					}
				}
				else {
					portletUrl = PF.addParameterToUrl(portletUrl, "pageId", pageId);
			        portletUrl = PF.addParameterToUrl(portletUrl, "pagePortletId", portletInfo[i].id);
					conf = {
						border: true,
						title: portletInfo[i].title,
						html: '<iframe src=' + portletUrl + ' frameborder="0" id="mainFrame" name="mainFrame" scrolling="auto" style="width:100%;height:100%"></iframe>'
					};
					if(portletHeight > 0){
						conf.height = portletHeight;
					}else{ 
						conf.autoHeight = true;
					}
					portlet = new ufgov.portal.Portlet(conf);
				}
				
				ppanel.items.itemAt(portletInfo[i].col_no).add(portlet);
				m++;
			}
			ppanel.doLayout();
			try{
				Ext.get('username').focus();
			}catch(e){
			}
		},
		destroyPanel: function(panel){
			if (panel) {
				if (panel.items) {
					for (var p = panel.items.length; p > 0; p--) {
						panel.remove(panel.items.items[p - 1]);
					}
				}
				if (panel.tbar) {
					panel.tbar.remove();
				}
				if (panel.tools && panel.tools.items) {
					for (var i = panel.tools.items.length; i > 0; i--) {
						panel.tools.remove(panel.tools.items.items[i - 1]);
					}
				}
				if (panel.header) {
					panel.header.remove();
				}
			}
		}
	}
};
var MainPageOut = new ufgov.portal.MainPageOut();
Ext.onReady(function(){
	Ext.Ajax.request({
		url: "getJsonData.action",
		params: {
			ruleID: 'portal-common.getBasicConfig'
		},
		success: function(response){
			var result = Ext.util.JSON.decode(response.responseText);
			portalArray = result;
			groupId = groupId == null ? 'guest' : groupId;
			document.title = portalArray[0].portal_name;
			MainPageOut.pageInit();
		}
	})
});