ufgov.portal.portlet.Link = Ext.extend(ufgov.portal.Base, {
	columnNum:2,
	recordSize:5,
	portletId:'link',
    portletTitle:'相关链接',
    widthEl:300,
	passParam:function(jsonParam){
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}
		if(Ext.isEmpty(jsonParam.portlet_id)){
			alert("请传入必要参数portletId");
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
		this.portletId = jsonParam.portlet_id;
		this.portletTitle = jsonParam.title;
		var pThis = this;
		this.panel=new Ext.Panel({
			title:pThis.portletTitle,
			border: false,
			//height:150,
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
		var panelLink=new Ext.Panel({
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
				var itemHtml = '<div style=\"float:left;position:relative;height:25;top:0;\">'
										 
			  if(tempItem.img){ 
			  		itemHtml += '<div style=\"float:left;position:relative;height:25;top:0;left:10;\">'
					itemHtml += '<a href=\"' + tempItem.url + '\" target=\"_blank\" >';
					itemHtml += '<img src=\"' + tempItem.img + '\"></div>';
				}
				if(tempItem.title){
					itemHtml += '<div style=\"float:left;position:relative;height:25;top:4;left:10;\">'
					itemHtml += '<a href=\"' + tempItem.url + '\" target=\"_blank\" >';
					itemHtml += tempItem.title;
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
				
				var linkItem = new Ext.Panel({
					frame:false,
					height:30,
					width:200,
					
					bodyStyle: 'padding:5px 0px 0px 0px;border:0px solid',
					html:itemHtml
				});
				
				panelLink.items.insert(0, linkItem);
			}
			
		};
		this.executeAjax(createPanel, 'apService.getListPage_ApLink', new ufgov.portal.common.Param(Ext.util.JSON.encode(new Object()), '', 'conditions'), new ufgov.portal.common.Param(0, '', 'start'), new ufgov.portal.common.Param(10, '', 'limit'), new ufgov.portal.common.Param('ordIndex','', 'sort'), new ufgov.portal.common.Param('','', 'dir'));
		
		winLinkMore=new Ext.Window({
	        title: '相关链接',
	        xtype: 'window',
	        layout: 'fit',
	        modal: false,
	        maximizable:false,
	        minimizable:true,
	        width: 600,
	        height: 500,
	        closeAction: 'hide',
	        items: [panelLink]
        });
        function onOpenAll(){
        	winLinkMore.show();
        };
	}
	
});

Ext.reg('link', ufgov.portal.portlet.Link);
