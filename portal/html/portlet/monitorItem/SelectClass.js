ufgov.portal.portlet.SelectClass = function(){
	
};
Ext.extend(ufgov.portal.portlet.SelectClass, ufgov.portal.Base, {
	pageInit: function(){
		this.createMainFrame();
	},
	createMainFrame: function(){
		var receiveFileBox = this.getFileClass('receiveFile', '收文类别', '02', userId);
		new Ext.Viewport({
	    	layout:'border',
	        items:[{ 
                region: 'west',
                id: 'fileBoxMenu',
				title : '当前用户：<font color="#ff0000">' + userName + '</font>',
                split:true,
                width: 180,
                minSize: 150,
                maxSize: 300,
                collapsible: true,
                margins:'5 0 5 0',
                layout:'accordion',
                layoutConfig:{
                    animate:true
                },
                items: [receiveFileBox]
            },{
				region: 'center',
				margins: '5 0 5 0',
				layout: 'fit',
				items: {
					border: false,
					layout: 'fit',
					id: 'contentPanel',
					items: {
						id: 'fileMainPanel',
						border: false,
						html: '<div id="fileMainPanel"></div>'
					}
				}
			}]
	    });
	},
	getFileClass: function(treeId, treeTitle, rootId, userId){
		var pThis = this;
		var fileClassTree = new Ext.tree.TreePanel({
            id: treeId + '_Panel',
            title: treeTitle,
            xtype: 'treepanel',
            iconCls: 'nav',
            border: false,
            autoScroll: true,
            split: true,
            singleExpand: true,
			hideCollapseTool: true,
            useArrows: true,
            loader: new Ext.tree.TreeLoader({
                dataUrl: 'getFileClass.action?userId='+userId
            }),
            rootVisible: false,
            root: new Ext.tree.AsyncTreeNode({
                id: rootId,
                text: '根结点'
            }),
            listeners: {
				click: function(node){
					pThis.createMainPanel(node, userId);
				}
			}
        });
        return fileClassTree;
	},
	createMainPanel: function(node, userId){
		var pThis = this;
		new Ext.Panel({
			border: false,
			layout: 'fit',
			applyTo: 'fileMainPanel',
			items: new Ext.form.FormPanel({
				border: false,
				id: 'fileClassForm',
				layout: 'table',
				defaults: {
			    	bodyStyle:'padding:5px'
			    },
				layoutConfig: {
					columns: 1
				},
				buttonAlign: 'center',
				items: {
					border: false,
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '收文类别',
						labelStyle: 'text-align:right',
						name: 'fileClass',
						value: node.attributes.text,
						width: 200
					},{
						xtype: 'hidden',
						name: 'classId',
						value: node.attributes.id
					},{
						xtype: 'hidden',
						name: 'fileTitle',
						value: fileTitle
					},{
						xtype: 'hidden',
						name: 'fileUrl',
						value: fileUrl
					},{
						xtype: 'hidden',
						name: 'fileStatus',
						value: fileStatus
					},{
						xtype: 'hidden',
						name: 'oaFileType',
						value: oaFileType
					},{
						xtype: 'hidden',
						name: 'userId',
						value: userId
					}]
				},
				buttons: [{
					text: '保存',
					width: 150,
					handler: function(){
						if(!Ext.get('classId').dom.value) {
							alert('请先选择收文类别');
							return false;
						}
						Ext.Ajax.request({
							url: 'getJsonData.action',
							params: {
								ruleID: 'portlet-info.isExistRecord',
								userId: userId,
								fileUrl: fileUrl,
								fileTitle: fileTitle,
								classId: node.attributes.id,
								oaFileType: oaFileType
							},
							callback: function(option, success, res){
								if(success){
									var result = Ext.util.JSON.decode(res.responseText);
									if(result[0].recordnum != '0'){
										alert('已经添加过，不能重复添加');
									}else{
										var form = Ext.getCmp('fileClassForm');
										if(form.getForm().isValid()){
											form.getForm().submit({
												url: 'doBasicOper.action',
												params:{
													ruleID: 'portlet-info.insertFileBoxData',
													action: 'insert'
												},
												waitMsg: '正在保存数据，请稍候...',
												success: function(form, response){
													pThis.showMsg("提示信息", response.result.sign);
												},
												failure: function(form, response){
													pThis.showMsg("提示信息", response.result.sign);
												}
											});
										}
									}
								}
							}
						});
					}
				}]
			})
		});
	}
});

Ext.onReady(function(){
	Ext.QuickTips.init();
	var SelectClass = new ufgov.portal.portlet.SelectClass();
	SelectClass.pageInit();
});