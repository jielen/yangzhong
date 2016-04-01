/**
 * 菜单频道
 * @class ufgov.portal.portlet.LoginPortlet
 */
ufgov.portal.portlet.MenuPortlet = Ext.extend(ufgov.portal.Base,{
	pageId: '',
	columnNum: 1,
	expand: false,
	portletTitle:'业务菜单',
	panel: null,
	init: function(){
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			this.expand = this.constructor.arguments[0].expand;
		}
	},
	passParam : function(jsonParam){
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}
		if(Ext.isEmpty(jsonParam.page_id)){
			alert("请传入必要参数pageId");
			return;
		}
		
		if (Boolean(jsonParam.title)) {
			this.portletTitle = jsonParam.title;
		}
		this.pageId = jsonParam.page_id;
		
		var pThis = this;
		this.panel = new Ext.Panel({
			title:pThis.portletTitle,
			border: false,
			width:'100%',
			defaults: {
				bodyStyle:'padding:1px'
    		},
			layout:"column",
			//layoutConfig:{
			//	columns:this.columnNum
			//},
			items:[
				{}
			]
		});	
		
		this.synchronize = true;
		
		function initPanel(jsonArr){
			//debugger;
			if(jsonArr == null || jsonArr.length == 0) return;
			
			jsonArr = PF.sortObject(jsonArr, "ord_index", "desc");
					  		
			for(var i = 0; i < jsonArr.length; i++){
				var tempItem = jsonArr[i];
				var itemTitle = "";
				var itemUrl = "";
				
				if(tempItem.compo_id){
					itemTitle = tempItem.compo_name;
					if(tempItem.url){
						itemUrl = PF.replaceWithSysVariables(tempItem.url);
					}else{
						var isGotoEdit = false;
						if(tempItem.is_goto_edit == "Y"){
							isGotoEdit = true;
						}
						itemUrl = PF.getMenuUrl(tempItem.compo_id, isGotoEdit);
					}
				}else{
					itemTitle = tempItem.menu_name;
					itemUrl = "portletDispatcher.action?function=menuView&pageId=" + pThis.pageId 
							+ "&menuId=" + tempItem.menu_id;
				}
				var vsAction = "PF.openFullScreenWindow('" + itemUrl + "')";
				var itemHtml = '<div align=\"center">'
				itemHtml += '<a href="javascript:void(0);" '
								 + ' onclick=\"' + vsAction + '\">';
				itemHtml += itemTitle;
				itemHtml += '</div>'
				alert(itemHtml);
				var panelItem = new Ext.Panel({
					//height:30,
					width:'100%',
					bodyStyle: 'padding:5px 0px 0px 0px;',
					html:itemHtml
				});
				pThis.panel.items.insert(0, panelItem);
				
			}
		};
		
		var url = "getMenuListAction.action?pageId=" + pThis.pageId 
				+ "&isRemoveEmpty=true&isOnlyInMenu=true&onlyShowRoot=true";
		pThis.ajaxRequest(initPanel, url);
	}
});
Ext.reg('menuPortlet', ufgov.portal.portlet.MenuPortlet);
