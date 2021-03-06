/**
 * @class ufgov.portal.MainPage
 * @extends Object
 */

var pageId;
var menuId;
var portalArray;

ufgov.portal.MenuView = function(){
	return {
		init: function(){
			var top = this.createTopPanel();
			var menuTree = this.createMenuTree();
			var main = this.createMainPanel();
			var viewport = new Ext.Viewport({
		  	layout:'border',
		    items:[top,menuTree,main]
		  });
		  
		  this.initTopPanel();
		  
		},
		
		createTopPanel: function(){
			var	topPanel = new Ext.Panel({
				region: 'north',
				id: 'top',
				margins: '0 0 0 0',
				border: false,
				height: 30,
				items: [{
					border: false,
					region: 'center',
					id: 'navigation',
					//items: [navPanel]
					html: '<div id="navigation"></div>'
				}]
			});
			return topPanel;
		},
		
		createMainPanel: function(){
			var	mainPanel = new Ext.Panel({
				region:'center',
		    	id: 'mainFrame',
		      //title: 'center',
		      margins:'2 5 5 0',
		      style:'padding:10px 0 10px 5px',
		      html: '<div id="mainFrame"></div>'
			});
			
			Ext.Ajax.request({
				url: "getJsonData.action",
				params: {
					ruleID: 'portal-common.getGroupPage',
					pageId: pageId
				},
				success: function(response){
					var currentPageArray = Ext.util.JSON.decode(response.responseText);
					if(currentPageArray && currentPageArray.length > 0){
					    var config = {
							currentPageArray: currentPageArray[0],
		                    newMainPanel: 'mainFrame'
		                };
					    var ShowPagePortlet = new ufgov.portal.ShowPagePortlet(config);
					    ShowPagePortlet.getPagePortletInfo();
					}
				}
			});
			
			return mainPanel;
		},
		
		createMenuTree: function(){
			var menuTree = new Ext.tree.TreePanel({
							region:'west',
							width: 200,
            	minSize: 175,
            	maxSize: 400,
            	collapsible: true,
            	margins:'2 0 5 5',
            	cmargins:'2 5 5 5',
            	style:'padding:10px 0 10px 5px',
	            id: pageId + '_Panel',
	            header: true,
	            xtype: 'treepanel',
	            border: true,
	            autoScroll: true,
	            split: true,
	            loader: new Ext.tree.TreeLoader({
	                dataUrl: "getMenuTreeAction.action?pageId=" + pageId + "&isRemoveEmpty=true&isOnlyInMenu=true"
	            }),
	            rootVisible: false,
	            root: new Ext.tree.AsyncTreeNode({
	                id: pageId,
	                text: '根结点'
	            }),
	            listeners: {
	                click: function(node){
	                    if (node.isLeaf()) {
	                    	//debugger;
                    		alert('you click 2');
                        MenuView.execCompoUrl(node);
                    	}
                    	else {
                    		alert('you click');
                        node.toggle();
                    	}
	                },
									contextmenu: function(node, event){
									}
	            }
	        });
	        
	        menuTree.on('expandnode', function(node){
						if(node.isRoot){
	    				var childNodes = node.childNodes;
	      			if(childNodes){
	      				for(var i = 0; i < childNodes.length; i++){
	        				var vsNode = childNodes[i];
	        				if(vsNode.id == menuId){
	        					vsNode.expand(false);
	        				}
	        			}
	       			} 
	     			}
	        });
	        
	        new Ext.tree.TreeSorter(menuTree, {
    				folderSort: true,
    				dir: "asc",
    				//property:'displayOrder',
    				sortType: function(node) {
        			// sort by a custom, typed attribute:
        			return parseInt(node.attributes.ord_index, 10);
    				}
					});
			//menuTree.render();
			
			return menuTree;
		},
		
		execCompoUrl: function(node){
			var pageUrl = "";
			if (node.attributes.url != "#") {
				pageUrl = PF.processUrl(node.attributes.url);
			}
			else {
				pageUrl = PF.getMenuUrl(node.attributes.compo_id, node.attributes.isGotoEdit);
			}
			if (node.attributes.hrefTarget == '_blank') {
				window.open(pageUrl, '_blank', "menubar=no,scrollbars=yes,status=yes,toolbar=no,"
                		+ "resizable=yes,titlebar=no,scrollbars=yes,location=no,"
                		+ "height=" + (screen.availHeight - 30) + ",width="
                		+ (screen.availWidth - 10) + ",top=0,left=0");
			}
			else {
				var productCode = PF.getProductCode(node.attributes.compo_id);
				if (productCode == 'portal') {
					window.open(pageUrl, null, "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
					"resizable=yes,titlebar=no,scrollbars=yes,location=no," +
					"height=" + (screen.availHeight - 30) +
					",width=" + (screen.availWidth - 10) + ",top=0,left=0");
				}
				else {
					new Ext.Panel({
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
		
		initTopPanel: function(){
			var welcomeImg = 'html/themes/'+portalArray.theme_code+'/'+portalArray.welcome_img;
			if (Ext.isEmpty(welcomeImg)) {
				welcomeImg = 'html/themes/default/img/welcome.jpg';
			}
			var welcome = portalArray.welcome;
			if(welcome){
				welcome = PF.replaceWithSysVariables(welcome, false);
			}
			
			var navPanel = new Ext.Panel({
				border: false,
				baseCls: 'nav-panel',
				applyTo: 'navigation',
				tbar:[{text: welcome + "&nbsp;&nbsp;"}]
			});
			
			var funcLink = ["global,工作环境,img/global.png", "myaccount,我的账户,img/myaccount.png"];
			var funcJson = "";
			if (funcLink.length > 0) {
				funcJson = "[";
				for (var i = 0; i < funcLink.length; i++) {
					var temp = funcLink[i].split(',');
					if (funcJson.length > 1){ 
						funcJson += ",";
					}
					funcJson += "{";
					funcJson += "text:'<img src=\"" + "html/themes/" + portalArray.theme_code + "/" +temp[2] + "\" height=\"15\">',";
					funcJson += "id: '" + temp[0] + "',";
					funcJson += "handler: function(){var FuncLink = new ufgov.portal.FuncLink();FuncLink.doFuncLink('"+temp[0]+"');}";
					funcJson += "}"
				}
				funcJson += "]";
			}
			
			if(!Ext.isEmpty(funcJson)){
				navPanel.getTopToolbar().add('->',Ext.util.JSON.decode(funcJson));
			}
		}
	}
};

var MenuView = new ufgov.portal.MenuView();

Ext.onReady(function(){
	Ext.Ajax.request({
		url: "getJsonData.action",
		params: {
			ruleID: 'portal-common.getBasicConfig'
		},
		success: function(response){
			var result = Ext.util.JSON.decode(response.responseText);
			portalArray = result[0];
			if(document.title.length == 0){
				document.title = portalArray.portal_name;
			}
			//debugger;
			$import('html/themes/'+portalArray.theme_code+'/css/portal.css');
			MenuView.init();
		}
	});
	
});
