ufgov.portal.portlet.ExpressApp = Ext.extend(ufgov.portal.Base, {
	columnNum:2,
	recordSize:5,
	pgPletId:'0',
	userId:'',
    portletTitle:'快捷应用',
    widthEl:300,
	passParam:function(jsonParam){
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}
		if(Ext.isEmpty(jsonParam.id)){
			alert("请传入必要参数ppgPletId");
			return;
		}
		if(Ext.isEmpty(userId)){
			alert("请传入必要参数userId");
			return;
		}
		if(Ext.isEmpty(jsonParam.title)){
			alert("请传入必要参数title");
			return;
		}
		if(!Ext.isEmpty(jsonParam.record_size) && "number" == Ext.type(parseInt(jsonParam.record_size))){
			this.recordSize = jsonParam.record_size;
		}
		if(!Ext.isEmpty(jsonParam.panelWidth) && "number" == Ext.type(parseInt(jsonParam.panelWidth))){
			this.widthEl = Math.round(jsonParam.panelWidth/this.columnNum)-10;
		}
		this.pgPletId = jsonParam.id;
		this.userId = userId;
		this.portletTitle = jsonParam.title;
		var pThis = this;
		this.panel=new Ext.Panel({
			title:pThis.portletTitle,
			border: false,
			tools: [{
				qtip: '更多信息......',
				id: 'search',
				handler: function(e, target, panel){
					onOpenAll();
				}
			}],
			items:[{
				//border: false,
				layout:"table",
				layoutConfig:{
					columns:this.columnNum
				},
				items:[
					{}
				]
			}]
		});	
		var panelExpress=new Ext.Panel({
			layout:"table",
			
			layoutConfig:{
				columns:3
			},
			items:[
				{bodyStyle: 'padding:0px 0px 0px 0px;border:0px solid;border-width:0 0 0 0'}
			]
		});
		var resData = null;
		
		this.synchronize=true;
		function createPanel(jsondata){
		    if(null == jsondata.datas || 0 == jsondata.datas.length) return;
		    resData = jsondata.datas;
			for(var i=0; i<jsondata.datas.length; i++){
				var tempItem = jsondata.datas[i];
				var openUrl = null;
	            var productCode = PF.getProductCode(tempItem.compoId);
	            if(!Ext.isEmpty(tempItem.url)){
	            	openUrl = PF.processUrl(tempItem.url);
	            }else{
	            	openUrl = "/" + productCode + "/getpage_" + tempItem.compoId + ".action?function="
	            	if('Y' == tempItem.isGotoEdit){
	            		openUrl += "geteditpage&condition=1=0&";
	            	}else{
	            		openUrl += "getlistpage&condition=&"
	            	}
	            	openUrl += "componame=" + tempItem.compoId + "&token=";
	            	openUrl += token;
	            }
	            
				var itemHtml = '<div style=\"float:left;position:relative;height:25;top:0;\">'
										 
				if(!Ext.isEmpty(tempItem.displayTitle)){
					itemHtml += '<div style=\"float:left;position:relative;height:25;top:4;left:10;\">'
					itemHtml += '<a href=\"' + openUrl + '\" target=\"_blank\" >';
					itemHtml += tempItem.displayTitle;
					itemHtml += '</div>'
				} 
				itemHtml += '</div>';
				
				if( pThis.recordSize > i ){
					var panelItem = new Ext.Panel({
						height:30,
						width:pThis.widthEl,
						bodyStyle: 'padding:5px 0px 0px 0px;',
						html:itemHtml
					});
					pThis.panel.items.get(0).items.insert(0, panelItem);
				}
				
				var expressItem = new Ext.Panel({
					frame:false,
					height:30,
					width:200,
					bodyStyle: 'padding:5px 0px 0px 0px;border:0px solid',
					html:itemHtml
				});
				
				panelExpress.items.insert(0, expressItem);
			}
			
		};
		this.executeAjax(createPanel, 'apService.getListExpressAppPageByPortletId', new ufgov.portal.common.Param(pThis.pgPletId, '', 'conditions'), new ufgov.portal.common.Param(pThis.userId, '', 'conditions'), new ufgov.portal.common.Param(0, '', 'start'), new ufgov.portal.common.Param(10, '', 'limit'));
		
		winExpressMore=new Ext.Window({
	        title: '快捷应用',
	        xtype: 'window',
	        layout: 'fit',
	        modal: false,
	        maximizable:false,
	        minimizable:true,
	        width: 600,
	        height: 500,
	        closeAction: 'hide',
	        items: [panelExpress]
        });
        function onOpenAll(){
        	winExpressMore.show();
        };
	}
	
});

Ext.reg('expressApp', ufgov.portal.portlet.ExpressApp);
