/**
 * @class ufgov.portal.MainPage
 * @extends Object
 */
var portalJson, portalArray;
var groupId, pageId, pageOrient;
var currentPageArray;
var token, userId, userName;
var logoHtml = "";
var sessionid = null;
var showFuncLink,forceShowPage,showLogoPanel,groupNum;

$import('script/common/File.js');
$import('script/common/PublicFunction.js');
$import('html/portlet/PageTemp.js');
$import('html/home_in/FuncLink.js');
$import('html/home_in/ShowPagePortlet.js');
$import('html/portlet/myProfile/UserProfileEdit.js');
$import('html/portlet/workFlow/WorkApp.js');
$import('html/portlet/download/Download.js');
$import('html/portlet/download/EducationOnLine.js');
$import('html/portlet/msgBoard/MsgBoardEdit.js');
$import('html/portlet/msgBoard/MsgBoardView.js');
$import('html/portlet/expressApp/ExpressApp.js');
$import('html/portlet/link/Link.js');
$import('html/portlet/login/LoginPortlet.js');
$import('html/portlet/calendar/CalendarApp.js');
$import('html/portlet/calendar/DailyPlanDetail.js');
$import('html/portlet/search/Search.js');
$import('html/portlet/article/ArticleApp.js');
$import('html/portlet/article/ArticleSearch.js');
$import('html/portlet/workFlow/OAFileWorkApp.js');
$import('html/portlet/fileBox/FileBoxPortlet.js');
$import('html/portlet/monitorItem/MonitorItemPortlet.js');
$import('html/portlet/fileRead/FileReadPortlet.js');
$import('html/portlet/menu/MenuPortlet.js');
$import('html/portlet/other/BlankPortlet.js');
$import('html/portlet/bbs/ForumView.js');
$import('html/portlet/message/InMessagePortlet.js');
$import('html/portlet/workSystem/OAWorkSystem.js');

ufgov.portal.MainPageIn = function(){
	var FuncLink = null;
    return {
        pageInit: function(){
         //	alert("MainPageIn");
            this.createMainFrame();
            this.getBottomPanel();
            this.getMenuPanel();
						if(groupId != 'guest'){
							this.setStatusScroll();
						}
        },
        createTopPanel: function(){
            var logoUrl = portalArray[0].logo_in_url;
            logoUrl = "html/themes/" + portalArray[0].theme_code + "/" + logoUrl;
            var logo;
            var width, height;
            if (logoUrl) {
                if (logoUrl.indexOf('|') > 0) {
                    var logoUrlArray = logoUrl.split('|');
                    logo = logoUrlArray[0];
                    if (logoUrlArray[1]) {
                        width = logoUrlArray[1];
                    }
                    else {
                        width = portalWidth;
                    }
                    if (logoUrlArray[2]) {
                        height = logoUrlArray[2];
                    }
                    else {
                        height = 100;
                    }
                }
                else {
                    logo = logoUrl;
                    height = 100;
                }
            }
            else {
                logo = "resources/top.jpg";
                height = 100;
            }
            var top;
            logo = path + '/' + logo;
            if (logo && logo.substring(logo.lastIndexOf('.') + 1) == 'swf') {
                top = "<embed src='" + logo + "'";
                top += " width='" + width + "' height='" + height + "' quality='high' pluginspage='http://www.macromedia.com/go/getflashplayer' ";
                top += "type='application/x-shockwave-flash' wmode='transparent'></embed>";
            }
            else 
                if (!Ext.isEmpty(logo)) {
                    top = "<img src=\"" + logo + "\" width=\"100%\" height=\"" + height + "\">";
                }
                else {
                    top = '<img src="' + path + '/resources/top.jpg" width="100%" height="100">';
                }
            logoHtml = top;
            var nav = {
                border: false,
                region: 'center',
                id: 'navigation',
                html: '<div id="navigation"></div>'
            };
            var logo = {
                border: false,
                region: 'north',
                split: true,
                layout: 'fit',
                collapsible: true,
                height: height,
                html: top
            };
            var topPanel = new Ext.Panel({
                region: 'north',
                id: 'top',
                margins: '0 0 0 0',
                border: false,
                height: 0
            });
            //debugger;
            if(showLogoPanel) {
            	topPanel.add(logo);
            	topPanel.height += (parseInt(height));
            }
            if(showFuncLink || userId === 'sa'){
            	topPanel.add(nav);
            	topPanel.height += 22; 
            }
            
            return topPanel;
        },
        createCenterPanel: function(orient){
            if (this.center) {
                for (var p = this.center.items.length; p > 0; p--) {
                    this.center.remove(this.center.items.items[p - 1]);
                }
            }
            if (orient === '2' || orient === '3') {
                this.center = new Ext.Panel({
                    layout: 'border',
                    applyTo: 'center',
                    border: false,
                    items: {
                        border: false,
                        region: 'center',
                        id: 'mainPanel',
                        html: '<div id="mainPanel"></div>'
                    }
                });
            }
            else {
                this.center = new Ext.Panel({
                    layout: 'border',
                    applyTo: 'center',
                    border: false,
                    items: [{
                        border: false,
                        region: 'north',
                        //height: 30,//填充数据时设置高度2009-04-11
                        id: 'menuPanel',
                        html: '<div id="menuPanel"></div>'
                    }, {
                        border: false,
                        region: 'center',
                        id: 'mainPanel',
                        html: '<div id="mainPanel"></div>'
                    }]
                });
            }
            return center;
        },
        createBlankBox: function(region, portalWidth){
            var box = new Ext.BoxComponent({
                region: region,
                el: region,
                margins: '0 0 0 0',
                style: 'background-image:url(resources/main_bg.jpg);background-repeat:repeat',
                width: (Ext.getBody().getWidth() - portalWidth) / 2,
                id: region,
                html: ''
            });
            return box;
        },
        createMainFrame: function(){
        	var portalWidth = portalArray[0].suf_width;
            if (portalWidth === '') {
                portalWidth = '100%';
            }
            if (portalWidth === 'fullScreen') {
                var fullScreen = screen.width - 20 ;
                portalWidth  = fullScreen.toString();
            }
            if (portalWidth.indexOf('%') > 0) {
                portalWidth = portalWidth.substring(0, portalWidth.indexOf('%')) / 100.0;
            }
            if (portalWidth <= 1) 
                portalWidth = Ext.getBody().getWidth() * portalWidth;
            var west = this.createBlankBox('west', portalWidth);
            var east = this.createBlankBox('east', portalWidth);
            var top = this.createTopPanel();
            var mainFrame = new Ext.Panel({
                region: 'center',
                contentEl: 'center',
                border: false,
                layout: 'border',
                margins: '0 0 0 0',
                items: [ {
                    region: 'south',
                    margins: '5 0 0 0',
                    height: 30,
                    id: 'bottom',
                    html: '<div id="bottom"></div>'
                }, {
                    region: 'center',
                    id: 'center',
                    margins: '0 0 0 0',
                    html: '<div id="center"></div>'
                }]
            });
            if(showFuncLink || showLogoPanel || userId === 'sa') {
            	mainFrame.add(top);
            }
            new Ext.Viewport({
                layout: 'border',
                items: [west, east, mainFrame]
            });
            window.onresize = function(){
                west.setWidth(0);
                west.setWidth((Ext.getBody().getWidth() - portalWidth) / 2);
                west.syncSize();
                east.setWidth(0);
                east.setWidth((Ext.getBody().getWidth() - portalWidth) / 2);
                east.syncSize();
            }
        },
        getMenuPanel: function(){
          if(showFuncLink || userId === 'sa'){
            FuncLink = new ufgov.portal.FuncLink();
            FuncLink.createNavigation(portalArray[0]);
            var arVersion = navigator.appVersion.split("MSIE");
            var version = parseFloat(arVersion[1]);
            if ((version >= 5.5) && (version < 7)) {
                FuncLink.correctPNG4IE6();
            }
            FuncLink.store.on({
                'load': function(store, record, option){
                    var groupName = null;
                    if (groupId) {
                        for (var tt = 0; tt < record.length; tt++) {
                            if (groupId == record[tt].data.groupId) {
                                groupName = record[tt].data.groupName;
                                pageOrient = record[tt].data.pageOrient;
                                break;
                            }
                        }
                        
                    }
                    else {
                        groupId = record[0].data.groupId;
                        groupName = record[0].data.groupName;
                        pageOrient = record[0].data.pageOrient;
                    }
                    Ext.getCmp('userGroupCombo').setValue(groupId);
                    MainPageIn._getMenuPanel(pageOrient, groupName);
                }
            })
            FuncLink.userGroup.on({
                'select': {
                    fn: function(combo, record, index){
                        if (groupId != record.data.groupId) {
                            groupId = record.data.groupId;
                            var groupName = record.data.groupName;
                            pageOrient = record.data.pageOrient;
                            MainPageIn._getMenuPanel(pageOrient, groupName);
                        }
                    },
                    scope: this
                }
            });
          }else{
        	  if(!groupId){
        		  return;
        	  }
        	  
        	  Ext.Ajax.request({
        	        url: "getJsonData.action",
        	        params: {
        		  		ruleID: 'portal-common.getGroup',
        		  		userId: document.getElementById('svUserId').getAttribute('value'),
        		  		groupId: groupId
        	        },
        	        success: function(response){
        	            var result = Ext.util.JSON.decode(response.responseText);
        	            if(result && result.length > 0){
        	            	MainPageIn._getMenuPanel(result[0].pageorient, result[0].groupname);
        	            }
        	        }
        	    });
          }
        },
        
        _getMenuPanel: function(pageOrient, groupName){
        	if (Ext.isEmpty(pageOrient) || pageOrient == '0') {//没有栏目
                pageOrient = '1';//默认为横向栏目
            }
            MainPageIn.createCenterPanel(pageOrient);
            var Menu = new ufgov.portal.common.Menu();
            
            if (pageOrient == '1') {//横向栏目
                Menu.createRowPage(groupId, 'menuPanel', 'MainPageIn.execRowPageUrl', 'MainPageIn.createMainPanel', "", forceShowPage);
            }
            else{ 
                if (pageOrient == '2') {//纵向栏目
                    MainPageIn.createNewMainPanel(groupName);
                    Menu.createCellPage(groupId, groupId, 'menuTree', 'MainPageIn.execCellPageUrl', 'MainPageIn.nodeRightClickUrl');
                }
                else 
                    if (pageOrient == '3') {//列表栏目
                        MainPageIn.createNewMainPanel(groupName);
                        Menu.createListPage(groupId, 'menuTree', 'MainPageIn.execCellPageUrl', portalArray[0].func_link);
                    }
            }
        },
        createNewMainPanel: function(menuTitle){
            /**
             * 前一个动作是创建新面板，销毁后，重新创建
             */
            MainPageIn.destroyPanel(MainPageIn.newMainPanel);
            /**
             * 前一个动作是jsp，需要销毁
             */
            MainPageIn.destroyPanel(MainPageIn.jspPanel);
            /**
             * 前一个动作是横向菜单单击事件处理界面
             */
            MainPageIn.destroyPanel(MainPageIn.rowPageRowMenu);
            /**
             * 前一个动作是在mainPanel中嵌入频道面板，需要销毁
             */
            MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
            
            var panel = new Ext.Panel({
                layout: 'border',
                border: false,
                items: [{
                    region: 'west',
                    title: menuTitle,
                    id: 'menuRegion',
                    border: true,
                    split: true,
                    layout: 'fit',
                    collapsible: true,
                    margins: '0 0 5 0',
                    minSize: 200,
                    maxSize: 300,
                    width: 200,
                    items: {
                        id: 'menuTree',
                        border: false
                    }
                }, {
                    region: 'center',
                    header: false,
                    layout: 'fit',
                    border: false,
                    margins: '0 0 5 0',
                    items: {
                        id: 'mainFrame',
                        header: false,
                        border: false,
                        html: '<div id="mainFrame" style="width:100%"></div>'
                    }
                }]
            });
            MainPageIn.newMainPanel = new Ext.Panel({
                layout: 'fit',
                id: 'newMainPanel',
                applyTo: 'mainPanel',
                header: false,
                border: false,
                items: panel
            });
            this.onMainFrameResize();
        },
        /**************栏目横向显示时，单击事件执行函数*****************/
        execRowPageUrl: function(pageInfo, menuOrient){
            if (menuOrient && menuOrient == '1') {
                MainPageIn.execRowPageRowMenu(pageInfo);
            }
            else {
                currentPageArray = Ext.util.JSON.decode(pageInfo);
                pageId = currentPageArray.page_id;
                var pageTitle = currentPageArray.page_title;
                var groupId = currentPageArray.group_id;
                var menu = currentPageArray.menu_orient;
                if (menu && menu == '2') {//有菜单
                    //menuOrient=2,菜单纵向显示
                    var Menu = new ufgov.portal.common.Menu();
                    MainPageIn.createNewMainPanel(pageTitle);
                    Menu.createCellMenu(pageId, 'menuTree', 'MainPageIn.execCellMenuUrl', 'MainPageIn.nodeRightClickUrl', 'MainPageIn.createMainPanel', 'mainFrame');
                }
                else {
                    var hasChildren = currentPageArray.has_children;
                    if (hasChildren) {
                        var Menu = new ufgov.portal.common.Menu();
                        MainPageIn.createNewMainPanel(pageTitle);
                        Menu.createCellPage(groupId, pageId, 'menuTree', 'MainPageIn.execCellPageUrl', 'MainPageIn.nodeRightClickUrl');
                        ////MainPageIn.createMainPanel("", "mainFrame");
                    }
                    else {
                        //没有菜单，此时直接显示频道
                        MainPageIn.createMainPanel();
                    }
                }
            }
        },
        /**
         * 横向栏目横向菜单单击处理函数
         * @param {Object} menuInfo
         */
        execRowPageRowMenu: function(menuInfo){
            var menu = Ext.util.JSON.decode(menuInfo);
            
            /**
             * 下面添加菜单单击事件执行函数
             */
            var pageUrl = "";
            if (menu.url != "") {
                var Menu = new ufgov.portal.common.Menu();
                pageUrl = Menu.processUrl(menu.url);
            }
            else {
                var isGotoEdit = (menu.is_goto_edit == 'Y') ? true : false;
                pageUrl = MainPageIn.getMenuUrl(menu.compo_id, isGotoEdit);
            }
            var productCode = PF.getProductCode(menu.compo_id);
            
            if (menu.is_always_new == 'Y' || menu.is_always_new == 'y' || productCode == 'portal') {
            	if(productCode == 'PD'){
            		MainPageIn.openPDCompo(pageUrl);
            	}else{
                window.open(pageUrl, '_blank', "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
                "resizable=yes,titlebar=no,scrollbars=yes,location=no,height=" +
                (screen.availHeight - 30) +
                ",width=" +
                (screen.availWidth - 10) +
                ",top=0,left=0");
            	}
            }
            else {
                /*
                if (productCode == 'portal') {
                    window.open(pageUrl, null, "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
                    "resizable=yes,titlebar=no,scrollbars=yes,location=no,height=" +
                    (screen.availHeight - 30) +
                    ",width=" +
                    (screen.availWidth - 10) +
                    ",top=0,left=0");
                }
                else*/ 
                {
                	/**
                     * 前一个动作是创建新面板
                     */
                    MainPageIn.destroyPanel(MainPageIn.newMainPanel);
                    /**
                     * 前一个动作是jsp，需要销毁
                     */
                    MainPageIn.destroyPanel(MainPageIn.jspPanel);
                    /**
                     * 前一个动作是横向菜单单击事件处理界面
                     */
                    MainPageIn.destroyPanel(MainPageIn.rowPageRowMenu);
                    /**
                     * 前一个动作是在mainPanel中嵌入频道面板，需要销毁
                     */
                    MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
                    pageUrl = PF.processUrl(pageUrl);
                    pageUrl = PF.addParameterToUrl(pageUrl, "groupId", groupId);//增加groupId参数
                    pageUrl = PF.addParameterToUrl(pageUrl, sessionIdKey, sessionid);
                    MainPageIn.rowPageRowMenu = new Ext.Panel({
                        applyTo: 'mainPanel',
                        border: false,
                        header: false,
                        layout: 'fit',
                        autoScroll: false,
                        id: 'rowPageRowMenu',
                        items: {
                            border: false,
                            header: false,
                            autoScroll: false,
                            html: '<iframe frameborder="0" src="' + pageUrl + '" id="mainFrame" name="mainFrame" scrolling="auto" style="width:100%;height:100%"></iframe>'
                        }
                    })
                }
            }
        },
        /**
         * 纵向菜单右键单击事件处理函数
         * @param {Object} node
         * @param {Object} event
         */
        nodeRightClickUrl: function(node, event){
            if (!node.isLeaf()) 
                return;
            var jsonPubCompoArr = [];
            jsonPubCompoArr.push(node.attributes.compo_id);
            jsonPubCompoArr.push(node.parentNode.id);
            jsonPubCompoArr.push(document.getElementById("svUserId").getAttribute("value"));
            jsonPubCompoArr.push(node.text)
            var base = new ufgov.portal.Base();
            var rightMenu = new Ext.menu.Menu({
                id: 'rightClickCont',
                items: [{
                    id: 'rMenu1',
                    text: '添加到快捷应用',
                    handler: function(){
                        winPublish.show();
                    }
                }]
            });
            
            function drawNode(loader, node, json){
                if (Boolean(json.msg)) {
                    alert(json.msg);
                    return;
                }
                node.beginUpdate();
                for (ii = 0; ii < json.length; ii++) {
                    var no = loader.createNode(json[ii]);
                    
                    if (no) {
                        if (json[ii].pgPletIdFlag) {
                            no.checkModel = 'multiple';
                            no.checkStyle = 'checkbox';
                            no.attributes.checked = json[ii].portletCheck;
                            //if (json[ii].portletFlag) 
                            //    no.attributes.checked = json[ii].portletCheck;
                            no.on('checkchange', function(){
                                var nodeTmp = no.parentNode;
                                while (nodeTmp != treePanel.root) {
                                    if (nodeTmp.checkStyle == 'radio') {
                                        nodeTmp.getUI().toggleCheck(true);
                                    }
                                    nodeTmp = nodeTmp.parentNode;
                                }
                            })
                        }
                        else 
                            if (node == treePanel.root) {
                                no.checkModel = 'multiple';
                                no.checkStyle = 'radio';
                            }
                        node.appendChild(no);
                        
                    }
                }
                node.endUpdate();
                
            }
            
            function getCheckedNodes(node, onlyLeaf){
                var checked = [];
                if ((!onlyLeaf || node.isLeaf()) && node.getUI().isChecked()) {
                    checked.push(node);
                }
                if (!node.isLeaf()) {
                    for (var i = 0; i < node.childNodes.length; i++) {
                        checked = checked.concat(getCheckedNodes(node.childNodes[i], onlyLeaf));
                    }
                }
                return checked;
            };
            var treePanel = new Ext.tree.TreePanel({
                id: 'portlet_treePanel',
                header: false,
                border: false,
                autoScroll: true,
                split: true,
                singleExpand: false,
                useArrows: true,
                height: 500,
                hideCollapseTool: true,
                tools: [{
                    id: 'refresh',
                    handler: function(event, toolEl, panel){
                    
                    }
                }],
                loader: base.getCustomTreeLoader(drawNode, 'apService.getApPagePortletBeans', 'node,articleFileId,portletType,menuId,compoId,userId', new ufgov.portal.common.Param('05', '', 'portletType'), new ufgov.portal.common.Param(node.id, '', 'compoId'), new ufgov.portal.common.Param(node.parentNode.id, '', 'menuId'), new ufgov.portal.common.Param(document.getElementById("svUserId").getAttribute("value"), '', 'userId'), new ufgov.portal.common.Param('express', '', 'articleFileId')),
                rootVisible: false,
                root: new Ext.tree.AsyncTreeNode({
                    id: '0',
                    text: '全部'
                })
            });
            winPublish = new Ext.Window({
                title: '请选择快捷应用',
                xtype: 'window',
                layout: 'fit',
                modal: 'true',
                width: 450,
                height: 450,
                closeAction: 'close',
                bodyStyle: 'padding:5 5 0 5;',
                items: [treePanel],
                buttons: [{
                    text: '保存',
                    handler: function(){
                        var checkedPagePortlets = getCheckedNodes(treePanel.root);
                        Ext.Msg.confirm("系統提示", checkedPagePortlets.length == 0 ? "没有选中快捷应用,确认取消发布这个选择的部件吗?" : "确认发布这个选择的部件到选中的快捷应用吗(注意，以前这个选择的部件发布将无效)?", function(btn){
                            if (btn != 'yes') 
                                return;
                            onPublishCompo(jsonPubCompoArr, checkedPagePortlets);
                        })
                    }
                }, {
                    text: '返回',
                    handler: function(){
                        winPublish.hide();
                    }
                }]
            });
            
            function onPublishCompo(jsonPubCompoArr, checkedPagePortlets){
                var jsonPubPagePortletArr = [];
                var jsonPubPageArr = [];
                for (var i = 0; i < checkedPagePortlets.length; i++) {
                    var node = checkedPagePortlets[i];
                    jsonPubPagePortletArr.push(node.attributes.id);
                    jsonPubPageArr.push(node.attributes.parentId);
                }
                base.showSaveProgressBar('正在发布/取消中，请稍候...');
                
                base.executeAjax(function(json){
                    base.hideSaveProgressBar();
                    alert(json.message);
                }, "apService.updatePublishCompo", new ufgov.portal.common.Param(jsonPubCompoArr, "0:java.lang.String"), new ufgov.portal.common.Param(jsonPubPagePortletArr, "0:java.lang.String"), new ufgov.portal.common.Param(jsonPubPageArr, "0:java.lang.String"));
            }
            
            rightMenu.showAt(event.getXY());
        },
        /**
         * 纵向菜单的处理函数
         * @param {Object} node
         */
        execCellMenuUrl: function(node){
            
            /**
             * 下面添加菜单单击事件执行函数
             */
            var pageUrl = "";
            if (node.attributes.url != "#") {
                var Menu = new ufgov.portal.common.Menu();
                pageUrl = Menu.processUrl(node.attributes.url);
            }
            else {
                pageUrl = MainPageIn.getMenuUrl(node.attributes.compo_id, node.attributes.isGotoEdit);
            }
            var productCode = PF.getProductCode(node.attributes.compo_id);
            
            if (node.attributes.hrefTarget == '_blank' || productCode == 'portal') {
            	if(productCode == 'PD'){
            		MainPageIn.openPDCompo(pageUrl);
            	}else{
                window.open(pageUrl, '_blank', "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
                "resizable=yes,titlebar=no,scrollbars=yes,location=no," +
                "height=" +
                (screen.availHeight - 30) +
                ",width=" +
                (screen.availWidth - 10) +
                ",top=0,left=0");
            	}
            }
            else {
                /*
                if (productCode == 'portal') {
                    window.open(pageUrl, null, "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
                    "resizable=yes,titlebar=no,scrollbars=yes,location=no," +
                    "height=" +
                    (screen.availHeight - 30) +
                    ",width=" +
                    (screen.availWidth - 10) +
                    ",top=0,left=0");
                }
                else */
            	{
            		/**
                     * 前一个面板是jsp面板，创建前需要销毁
                     */
                    MainPageIn.destroyPanel(MainPageIn.jspPanel);
                    /**
                     * 前一个面板是纵向菜单处理界面
                     */
                    MainPageIn.destroyPanel(MainPageIn.cellMenu);
                    /**
                     * 前一个面板是新panel（newMainFrame），需要销毁
                     */
                    MainPageIn.destroyPanel(MainPageIn.newMainFrame);
                    /**
                     * 前一个动作是在mainFrame中嵌入频道，需要销毁频道panel
                     */
                    MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
                    
                    pageUrl = PF.processUrl(pageUrl);
                    pageUrl = PF.addParameterToUrl(pageUrl, "groupId", groupId);//增加groupId参数
                    pageUrl = PF.addParameterToUrl(pageUrl, sessionIdKey, sessionid);
                    MainPageIn.cellMenu = new Ext.Panel({
                        applyTo: 'mainFrame',
                        border: false,
                        header: false,
                        layout: 'fit',
                        autoScroll: false,
                        id: 'cellMenu',
                        items: {
                            border: false,
                            id: 'menuFrame',
                            header: false,
                            autoScroll: false,
                            html: '<iframe frameborder="0" src="' + pageUrl + '" id="mainFrame" name="mainFrame" scrolling="yes" style="width:100%;height:100%"></iframe>'
                        }
                    })
                }
            }
        },
        /**
         * 纵向栏目横向菜单单击事件处理函数
         * @param {Object} menuInfo
         */
        execCellPageRowMenu: function(menuInfo){
            //debugger;
            var menu = Ext.util.JSON.decode(menuInfo);
            
            var pageUrl = "";
            if (!Ext.isEmpty(menu.url)) {
                var Menu = new ufgov.portal.common.Menu();
                pageUrl = Menu.processUrl(menu.url);
            }
            else {
                var isGotoEdit = (menu.is_goto_edit == 'Y') ? true : false;
                pageUrl = MainPageIn.getMenuUrl(menu.compo_id, isGotoEdit);
            }
            var productCode = PF.getProductCode(menu.compo_id);
            
            if (menu.is_always_new.toLowerCase() == 'y' || productCode == 'portal') {
            	if(productCode == 'PD'){
            		MainPageIn.openPDCompo(pageUrl);
            	}else{
                window.open(pageUrl, '_blank', "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
                "resizable=yes,titlebar=no,scrollbars=yes,location=no," +
                "height=" +
                (screen.availHeight - 30) +
                ",width=" +
                (screen.availWidth - 10) +
                ",top=0,left=0");
            	}
            }
            else {
            	/**
                 * 前一个动作是纵向栏目横向菜单单击事件处理界面，需要销毁
                 */
                MainPageIn.destroyPanel(MainPageIn.cellPageRowMenu);
                /**
                 * 前一个动作是在newPanel中嵌入频道Panel，需要销毁
                 */
                MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
                /*
                if (productCode == 'portal') {
                    window.open(pageUrl, null, "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
                    "resizable=yes,titlebar=no,scrollbars=yes,location=no," +
                    "height=" +
                    (screen.availHeight - 30) +
                    ",width=" +
                    (screen.availWidth - 10) +
                    ",top=0,left=0");
                }
                else */
                {
                    pageUrl = PF.processUrl(pageUrl);
                    pageUrl = PF.addParameterToUrl(pageUrl, "groupId", groupId);//增加groupId参数
                    pageUrl = PF.addParameterToUrl(pageUrl, sessionIdKey, sessionid);
                    MainPageIn.cellPageRowMenu = new Ext.Panel({
                        applyTo: 'newPanel',
                        border: false,
                        header: false,
                        layout: 'fit',
                        autoScroll: false,
                        id: 'cellPageRowMenu',
                        items: {
                            border: false,
                            id: 'rowMenuFrame',
                            header: false,
                            html: '<iframe frameborder="0" src="' + pageUrl + '" id="mainFrame" name="mainFrame" scrolling="yes" style="width:100%;height:100%"></iframe>'
                        }
                    })
                }
            }
        },
        getMenuUrl: function(componame, isGotoEdit){
            var actionType = "getlistpage";
            var vsCond = "";
            if (isGotoEdit) {
                actionType = "geteditpage";
                vsCond = "1=0";
            }
            
            var vsURL = "";
            var productCode = PF.getProductCode(componame);
            
            if (PF.isV51Product(productCode)) {
                vsURL = "/" + productCode + "/Proxy?function=" + actionType + "&condition=" + vsCond +
                "&componame=" + componame + "&fieldvalue=" + componame + "_E&unique=&token=" + token;
            }
            else 
                if (productCode == 'portal') {
                    vsURL = "/" + productCode + "/dispatcher.jsp?componame=" + componame + "&title=" + document.title;
                }
                else {
                    vsURL = "/" + productCode + "/getpage_" + componame + ".action?function=" + actionType +
                    "&condition=" + vsCond + "&componame=" + componame + "&token=" + token;
                }
            return vsURL;
        },
        /**************栏目纵向显示时，单击事件处理函数*************************************/
        execCellPageUrl: function(node){
            if (node.attributes.isMenu) {//单击结点是菜单，此时执行菜单单击事件
                if (node.isLeaf()) {
                    MainPageIn.execCellMenuUrl(node);
                }
                else {
                    node.toggle();
                }
            }
            else {//单击结点是栏目，此时查询频道以及判断菜单是否横向显示
                pageId = node.attributes.id;
                if (!currentPageArray) {
                    currentPageArray = Ext.util.JSON.decode("{\"page_id\":\"\",\"column_ratio\":\"\",\"page_url\":\"\",\"page_title\":\"\",\"page_desc\":\"\",\"page_order\":\"\",\"menu_orient\":\"\",\"parent_id\":\"\",\"page_title_img\":\"\",\"is_always_new\":\"\",\"column_count\":\"\",\"group_id\":\"\"}");
                }
                currentPageArray.page_id = node.attributes.id;
                currentPageArray.page_title = node.attributes.text;
                currentPageArray.page_url = node.attributes.url;
                currentPageArray.column_ratio = node.attributes.columnRatio;
                currentPageArray.column_count = node.attributes.columnCount;
                currentPageArray.is_always_new = node.attributes.isAlwaysNew;
                currentPageArray.menu_orient = node.attributes.menuOrient;
                
                if (node.attributes.menuOrient == '1') {
                    MainPageIn.createRowMenuPanel();
                }
                else {
                    MainPageIn.createMainPanel("", 'mainFrame');
                }
            }
        },
        /**
         * 列表页面（栏目）单击事件处理函数
         * @param {Object} pageId
         */
        execListPageUrl: function(pageInfo, menuOrient){
            currentPageArray = pageInfo;
            pageId = currentPageArray.page_id;
            if (menuOrient && menuOrient == '1') {
                MainPageIn.createRowMenuPanel();
            }
            else {
                MainPageIn.createMainPanel("", 'mainFrame');
            }
        },
        /***************栏目纵向菜单横向时的主面板************************/
        createRowMenuPanel: function(){
            /******************创建面板前，先销毁原有的面板**********************/
            /**
             * 前一个面板是jsp页面，需要销毁
             */
            MainPageIn.destroyPanel(MainPageIn.jspPanel);
            /**
             * 前一个面板是纵向栏目横向菜单面板，需要销毁
             */
            MainPageIn.destroyPanel(MainPageIn.newMainFrame);
            /**
             * 前一个面板是频道面板，需要销毁
             */
            MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
            /**
             * 前一个面板是纵向菜单单击事件处理页面，需要销毁
             */
            MainPageIn.destroyPanel(MainPageIn.cellMenu);
            /*****************销毁面板完毕****************************/
            
            var panel = new Ext.Panel({
                layout: 'border',
                border: false,
                items: [{
                    region: 'north',
                    id: 'rowMenuRegion',
                    header: false,
                    border: false,
                    height: 30,
                    tbar: [{
                        xtype: 'tbsplit',
                        iconCls: 'add'
                    }]
                }, {
                    region: 'center',
                    header: false,
                    layout: 'fit',
                    border: false,
                    margins: '0 0 0 0',
                    items: {
                        id: 'newPanel',
                        header: false,
                        border: false,
                        html: '<div id="newPanel" style="width:100%"></div>'
                    }
                }]
            });
            MainPageIn.newMainFrame = new Ext.Panel({
                applyTo: 'mainFrame',
                header: false,
                border: false,
                id: 'newMainFrame',
                layout: 'fit',
                items: panel
            })
            
            MainPageIn.createMainPanel("", 'newPanel');
            
            Ext.Ajax.request({
                url: 'getMenuListAction.action',
                params: {
                    pageId: pageId,
                    isRemoveEmpty: true,
                    isOnlyInMenu: true
                },
                callback: function(option, success, response){
                    if (success) {
                        var result = Ext.util.JSON.decode(response.responseText);
                        var Menu = new ufgov.portal.common.Menu();
                        var menuItem = Menu.getMenuItem(result, pageId, "MainPageIn.execCellPageRowMenu");
                        var restMenuItem = new Array();
                        //debugger;
                        
                        if (menuItem.length > 0) {
                            var level = 0;
                            for (var i = 0; i < menuItem.length; i++) {
                                var tempWidth = Ext.getCmp('rowMenuRegion').tbar.getWidth();
                                if (tempWidth > panel.getInnerWidth()) {
                                    level = i - 2;
                                    break;
                                }
                                else {
                                    Ext.getCmp('rowMenuRegion').getTopToolbar().add(menuItem[i]);
                                }
                            }
                            if (level == 0) {
                                level = menuItem.length - 1;
                            }
                            
                            Ext.getCmp('rowMenuRegion').tbar.remove();
                            var newMenu = new Ext.Panel({
                                applyTo: 'rowMenuRegion',
                                border: false,
                                id: 'newRowMenu',
                                tbar: []
                            })
                            for (var m = 0; m < menuItem.length; m++) {
                                if (m > level) {
                                    restMenuItem[restMenuItem.length] = menuItem[m];
                                }
                                else {
                                    Ext.getCmp('newRowMenu').getTopToolbar().add(menuItem[m]);
                                }
                            }
                            
                            if (restMenuItem.length > 0) {
                                Ext.getCmp('newRowMenu').getTopToolbar().add('->', {
                                    xtype: 'tbsplit',
                                    iconCls: 'add',
                                    id: 'moreTool',
                                    menu: restMenuItem
                                });
                            }
                        }
                        else {
                            Ext.getCmp('rowMenuRegion').tbar.remove();
                            Ext.getCmp('rowMenuRegion').destroy();
                        }
                    }
                }
            })
        },
        getBottomPanel: function(){
            var copyright = portalArray[0].copyright;
            var bottomTable = '<table border="0" align="center" height="30" width="100%">';
            bottomTable += '<tr><td class="thbody" align="center">';
            bottomTable += copyright;
            bottomTable += '</td></tr></table>';
            new Ext.Panel({
                layout: 'fit',
                applyTo: 'bottom',
                border: false,
                html: bottomTable
            })
        },
        createMainPanel: function(pageInfo, newMainPanel){
			if (!Ext.isEmpty(pageInfo)) {
                currentPageArray = Ext.util.JSON.decode(pageInfo);
				pageId = currentPageArray.page_id;
            }
            var pageUrl = currentPageArray.page_url;
            var isAlwaysNew = currentPageArray.is_always_new;
            if (!Ext.isEmpty(pageUrl) && isAlwaysNew == 'Y') {
            	pageUrl = PF.processUrl(pageUrl);
                window.open(pageUrl, 'new', "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
                "resizable=yes,titlebar=no,scrollbars=yes,location=no," +
                "height=" +
                (screen.availHeight - 30) +
                ",width=" +
                (screen.availWidth - 10) +
                ",top=0,left=0");
                return;
            }
            
            if (pageOrient == '1') {//栏目横向显示时
                
                if (Ext.isEmpty(newMainPanel)) {
					/**
	                 * 前一个动作是在mainPanel中嵌入频道Panel，需要销毁前面的Panel
	                 */
	                MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
	                /**
	                 *  前一个动作是在mainPanel中嵌入新面板
	                 */
	                MainPageIn.destroyPanel(MainPageIn.newMainPanel);
	                /**
	                 * 前一个动作是在mainPanel中嵌入jsp
	                 */
	                MainPageIn.destroyPanel(MainPageIn.jspPanel);
	                /**
	                 * 前一个动作是执行菜单功能
	                 */
	                MainPageIn.destroyPanel(MainPageIn.rowPageRowMenu);
                    newMainPanel = 'mainPanel';
                }
            }
            else {//栏目纵向显示时
                if (newMainPanel != 'newPanel') {
                    /**
                     * 前一个动作是在mainFrame中嵌入频道Panel，需要销毁
                     */
                    MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
                    /**
                     * 前一个动作是在mainFrame中嵌入jsp页面，需要销毁
                     */
                    MainPageIn.destroyPanel(MainPageIn.jspPanel);
                    /**
                     * 前一个动作是执行列向菜单事件，需要销毁
                     */
                    MainPageIn.destroyPanel(MainPageIn.cellMenu);
                    /**
                     * 前一个动作是新建Panel（newMainFrame），需要销毁
                     */
                    MainPageIn.destroyPanel(MainPageIn.newMainFrame);
                }
                else {
                    /**
                     * 前一个动作是在newPanel中嵌入频道Panel，需要销毁
                     */
                    MainPageIn.destroyPanel(Ext.getCmp('pageContPanel'));
                    /**
                     * 前一个动作是执行横向菜单单击事件，需要销毁
                     */
                    MainPageIn.destroyPanel(MainPageIn.cellPageRowMenu);
                }
            }
            if (Ext.isEmpty(pageUrl)) {
                var config = {
                    currentPageArray: currentPageArray,
                    newMainPanel: newMainPanel
                };
                var ShowPagePortlet = new ufgov.portal.ShowPagePortlet(config);
				ShowPagePortlet.getPagePortletInfo();
            }
            else if(isAlwaysNew != 'Y'){
                //else 
                {
                    MainPageIn.jspPanel = new Ext.Panel({
                        applyTo: newMainPanel,
                        border: false,
                        id: 'jspPanel',
                        items: {
                            border: false,
                            html: '<div id="newJspPanel"></div>'
                        }
                    })
                    if (pageUrl.indexOf('/') == 0 || pageUrl.indexOf('http://') == 0) {
                        pageUrl = PF.processUrl(pageUrl);
                        pageUrl = PF.addParameterToUrl(pageUrl, "groupId", groupId);//增加groupId参数
                        pageUrl = PF.addParameterToUrl(pageUrl, sessionIdKey, sessionid);
                        MainPageIn.jspPanel = new Ext.Panel({
                            applyTo: newMainPanel,
                            border: false,
                            id: 'jspPanel',
                            items: {
                                border: false,
                                height: 400,
                                html: '<iframe frameborder="0" src="' + pageUrl + '" id="newJspPanel" name="newJspPanel" scrolling="yes" style="width:100%;height:100%"></iframe>'
                            }
                        })
                    }
                    else {
                        pageUrl = 'html/themes/' + portalArray[0].theme_code + '/' + pageUrl;
                        MainPageIn.jspPanel = new Ext.Panel({
                            applyTo: newMainPanel,
                            border: false,
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
            }
        },
        destroyPanel: function(panel){
			try {
				if (panel) {
					if (panel.items) {
						for (var p = panel.items.length; p > 0; p--) {
							panel.remove(panel.items.items[p - 1]);
						}
					}
					if (panel.tbar) {
						panel.tbar.remove();
					}
					if (panel.tools.items) {
						for (var i = panel.tools.items.length; i > 0; i--) {
							panel.tools.remove(panel.tools.items.items[i - 1]);
						}
					}
					if (panel.header) {
						panel.header.remove();
					}
				}
			} catch (e){}
        },
        setStatusScroll: function(){
            var statusText = "";
			
            var svOrgCode = document.getElementById("svOrgCode").getAttribute("value");
            var svOrgName = document.getElementById("svOrgName").getAttribute("value");
            if (!Ext.isEmpty(svOrgCode)) {
                statusText += "   " + "内部机构:[" + svOrgCode + "]" + svOrgName;
            }
            var svAccountId = document.getElementById("svAccountId").getAttribute("value");
            var svAccountName = document.getElementById("svAccountName").getAttribute("value");
            if (!Ext.isEmpty(svAccountId)) {
                statusText += "   " + "账套:[" + svAccountId + "]" + svAccountName;
            }
            var svTransDate = document.getElementById("svTransDate").getAttribute("value");
            if (!Ext.isEmpty(svTransDate)) {
                statusText += "   " + "业务日期:" + svTransDate;
            }
            var svFiscalPeriod = document.getElementById("svFiscalPeriod").getAttribute("value");
            if (!Ext.isEmpty(svFiscalPeriod)) {
                statusText += "   " + "会计期间:" + svFiscalPeriod;
            }
            var svNd = document.getElementById("svNd").getAttribute("value");
            if (!Ext.isEmpty(svNd)) {
                statusText += "   " + "年度:" + svNd;
            }
            var svRpType = document.getElementById("svRpType").getAttribute("value");
            var svRpTypeName = document.getElementById("svRpTypeName").getAttribute("value");
            if (!Ext.isEmpty(svRpType)) {
                statusText += "   " + "表套:[" + svRpType + "]" + svRpTypeName;
            }
            var svPoCode = document.getElementById("svPoCode").getAttribute("value");
            var svPoName = document.getElementById("svPoName").getAttribute("value");
            if (!Ext.isEmpty(svPoCode)) {
                statusText += "   " + "职位:[" + svPoCode + "]" + svPoName;
            }
            PF.statusScroll(statusText);
        },
        onMainFrameResize: function(){
            Ext.getCmp('mainFrame').on('resize', function(){
                try {
                    Ext.getCmp('menuFrame').setWidth(0);
                    Ext.getCmp('menuFrame').setWidth(Ext.getCmp('mainFrame').getInnerWidth());
                    Ext.getCmp('menuFrame').syncSize();
                } 
                catch (e) {
                    try {
                        Ext.getCmp('jspPanel').setWidth(Ext.getCmp('mainFrame').getInnerWidth());
                        Ext.getCmp('jspPanel').syncSize();
                    } 
                    catch (e) {
                        try {
							Ext.getCmp('pageContPanel').setWidth(Ext.getCmp('mainFrame').getInnerWidth());
							Ext.getCmp('pageContPanel').syncSize();
						} catch(e){}
                    }
                }
            });
        },
        getFuncLink: function(){
        	return FuncLink;
        },
        openPDCompo:function(compoUrl){
        
        	var ie = new ActiveXObject("InternetExplorer.Application");
        	ie.left = 00;
        	ie.top = 00;
        	ie.width = screen.availWidth;
        	ie.height = screen.availWidth;
        	ie.menubar = 0;
        	ie.toolbar = 0;
        	
        	//Set the browser to a URL
        	if(compoUrl.indexOf(serverScheme) == 0) {
        		ie.navigate(compoUrl); 
        	}else{ 
        		ie.navigate(serverScheme + "://" + serverIp + ":" + serverPort +  compoUrl); 
        	}
        	
        	//Show the browser
        	ie.visible=1;
        	
        }
    }
};

var MainPageIn = new ufgov.portal.MainPageIn();

Ext.onReady(function(){
    Ext.Ajax.request({
        url: "getJsonData.action",
        params: {
            ruleID: 'portal-common.getBasicConfig'
        },
        success: function(response){
            var result = Ext.util.JSON.decode(response.responseText);
            portalArray = result;
            if (document.title.length == 0) {
                document.title = portalArray[0].portal_name;
            }
            $import('html/themes/' + portalArray[0].theme_code + '/css/portal.css');
            MainPageIn.pageInit();
            sessionid = PF.getCookie(sessionIdKey);
        }
    });
});
