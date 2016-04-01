/**
 * 变量down与工作频道ID必须一致，在主程序中调用
 */
ufgov.portal.portlet.Download = Ext.extend(ufgov.portal.Base, {
	panel : null,
	gridPart : null,
	gridDownApp : null,
	pgPletId : 'download',
	pageId : '',
	portletTitle : '下载',
	winMore : null,
	winDetail : null,
	rowNum : 20,
	recordType: [{
	        name: 'fileId',type : 'string'
	    }, {
	        name: 'fileName',type : 'string'
	    }, {
	        name: 'fileDesc',type : 'string'
	    }, {
	        name: 'fileUploadtime',type : 'date',dateFormat : 'Y-m-d H:i:s'
	    }, {
	        name: 'fileCreator',type : 'string'
	    }
	],
    init : function() {
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			this.pgPletId = this.constructor.arguments[0].pgPletId;
			this.portletTitle = this.constructor.arguments[0].portletTitle;
		};
	 },

	passParam : function(jsonParam) {
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}

		if (Ext.isEmpty(jsonParam.page_id)) {
			alert("必须存在jsonParam.page_id参数");
			return;
		}

		if (!Ext.isEmpty(jsonParam.id)) {
			this.pgPletId = jsonParam.id;
		}

		if (!Ext.isEmpty(jsonParam.title)) {
			this.portletTitle = jsonParam.title;
		}
		if (!Ext.isEmpty(jsonParam.record_size) && jsonParam.record_size > 0) {
			this.rowNum = jsonParam.record_size;
		}

		// this.destroy();
		this.pageId = jsonParam.page_id;
		var pThis = this;

		 //在grid里生成下载按钮
	      function renderDownBtn(value, cellmeta, record, rowIndex, columnIndex, store) {
	       var
		    str = "<input type='button' value='附件' onclick='ufgov.portal.portlet.Download.execDownload(" 
		    +record.get('fileId')+
	        ");'>";
	       return str;
	     }		
		
		//grid的列信息
        var colM = new Ext.grid.ColumnModel([{
	    	header : '',
			dataIndex : 'icon',
			renderer : function(value) {
				return '<a  class= "down-grid-flag"> </a>';
		    },
		    width : 25
        }, {        	
            header: '描述',
            dataIndex: 'fileDesc',
            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
				return '<div><a href="javascript:void(null);" class="article-grid-cell" >'+(Ext.isEmpty(value)?record.get('fileName'):value)+'</a></div>';
			},
            id: 'fileDesc'
        }
/*        
        , {
            header: '操作',
            dataIndex: 'bnDown',
            id: 'bnDown',
			renderer:renderDownBtn,
            width: 50
        }
*/        
		]);
       
    	//grid的JsonStore，调用base类的标准方法生成
    	var ds = pThis.getInitDs(pThis.recordType,"asService.getListUploadPageByPgPletId",
				"pageId,pgPletId,counter,start,limit");

		function onRefresh() {
			var store = pThis.gridPart.getStore();
			store.load({
						params : {
							pgPletId : pThis.pgPletId,
							pageId : pThis.pageId,
							start : 0,
							counter:false,
							limit : pThis.rowNum
						}
					});
		}

		var template1 = new Ext.Template(
				'<div class="x-grid3" hidefocus="true">',
				'<div class="x-grid3-viewport">',
				'<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset">{header}</div></div><div class="x-clear"></div></div>',
				'<div class="x-grid3-scroller down-grid-body" ><div class="x-grid3-body">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>',
				"</div>", '<div class="x-grid3-resize-marker">&#160;</div>',
				'<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");

		var templates1 = {};
		templates1.master = template1;

		this.gridPart = new Ext.grid.GridPanel({
			autoScroll : true,
			title : '',
			cm : colM,
			ds : ds,
			hideHeaders : true,
			resizable : true,
			bodyStyle : 'width:100%',
			autoWidth : true,
			autoExpandColumn : 'fileDesc',
			viewConfig : {
				forceFit : false,
				scrollOffset:2,
				templates : templates1
			}
		});
				
		// grid双击事件rowdblclick
		pThis.gridPart.on('cellclick', function(grid,r,c,e) {
			if  (c !=1 ) return;
			var record = grid.getSelectionModel().getSelected();
			if (!record) {
				return;
			}
			ufgov.portal.portlet.Download.execDownload(record.get('fileId'));
		})				
		
		var toolStyle1 = {};
		if (!Ext.isEmpty(jsonParam.title_bg_img)) {
			toolStyle1['background'] = 'url(html/themes/' + jsonParam.theme
					+ '/' + jsonParam.title_bg_img + ')';
		}
		if (!Ext.isEmpty(jsonParam.title_font_color)) {
			toolStyle1['color'] = jsonParam.title_font_color;
		}
		if (!Ext.isEmpty(jsonParam.title_font_size)) {
			toolStyle1['font-size'] = jsonParam.title_font_size;
		}

		if (!Ext.isEmpty(jsonParam.title_bg_color)) {
			toolStyle1['bgcolor'] = jsonParam.title_bg_color;
		}

		// pThis.panel=pThis.gridPart;
		pThis.panel = new Ext.PanelUF({
			title : pThis.portletTitle,
			toolStyle : toolStyle1,
			tools : [{
						qtip : '更多信息......',
						id : 'more',
						handler : function(e, target, panel) {
							onOpenAll();
						}
					},
					{
						qtip : '刷新数据',
						// tooltip: '刷新数据',
						id : 'refresh',
						handler : function(e, target, panel) {
							onRefresh();
						}
					}],
			border : false,
			autoScroll : true,
			standardSubmit : true,
			// toolTemplate:tt,
			headerdblClick : function() {
				onOpenAll();
			},
			items : [pThis.gridPart]
		});

		onRefresh();

		// 打开全部数据窗口
		function onOpenAll() {
			var pageSize = 20;
			if (!pThis.gridDownApp) {
                //复选的GridPortlet
            	var dsGrid = pThis.getInitDs(pThis.recordType,"asService.getListUploadPageByPgPletId",
				"pageId,pgPletId,counter,start,limit");
            	

				// 创建复选框的列
				var smDownApp = new Ext.grid.CheckboxSelectionModel();

				// 创建grid的列信息
			    var colsDownApp = new Ext.grid.ColumnModel([smDownApp,{
				    	header : '',
						dataIndex : 'icon',
						renderer : function(value) {
							return '<a class= "down-grid-flag"> </a>';
					    },
					    width : 25
	                 }, {
			            header: '描述',
			            dataIndex: 'fileDesc',
			            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
							return '<div><a href="javascript:void(null);" class="article-grid-cell" >'+(Ext.isEmpty(value)?record.get('fileName'):value)+'</a></div>';
						},
			            id: 'fileDesc'			            	
		             }, {
			            header: '文件名',
			            dataIndex: 'fileName',
			            id: 'fileName',
					    width : 180
			        },
/*		        
		        , {
			            header: '操作',
						dataIndex: 'bnDown',
	                    id: 'bnDown',
						renderer:renderDownBtn,
			            width: 60
			        }
*/			        
		        {
			            header: '上传时间',
			            dataIndex: 'fileUploadtime',
			            id: 'fileUploadtime',
			            renderer : Ext.util.Format.dateRenderer('Y-m-d H:m'),
			            width: 100
			        }
			   ]);

			   
			      
				// 创建页面信息工具栏
				var barDownApp = new Ext.PagingToolbar({
							pageSize : pageSize,
							store : dsGrid,
							displayInfo : true,
							displayMsg : '显示第 {0} 条到 {1} 条数据，共 {2} 条',
							emptyMsg : '没有数据'
				})

				// 创建编辑Grid
				pThis.gridDownApp = new Ext.grid.EditorGridPanel({
							ds : dsGrid,
							cm : colsDownApp,
							sm : smDownApp,
							autoExpandColumn : 'fileDesc',
							resizable : true,
							autoWidth : true,
							hideHeaders : false,
							viewConfig : {
								forceFit : false,
								templates : templates1
							},
							bbar : barDownApp
						});

/*				
				//grid双击事件rowdblclick
				pThis.gridDownApp.on('rowdblclick', function(grid) {
					var record = grid.getSelectionModel().getSelected();
					if (!record) {
						return;
					}
					ufgov.portal.portlet.Download.execDownload(record.get('fileId'));
				})
*/
				
				// grid双击事件rowdblclick
				pThis.gridDownApp.on('cellclick', function(grid,r,c,e) {
					if  (c !=2 ) return;
					var record = grid.getSelectionModel().getSelected();
					if (!record) {
						return;
					}
					ufgov.portal.portlet.Download.execDownload(record.get('fileId'));
				})				
				
				
				// more的window
				pThis.winMore = new Ext.Window({
							title : pThis.portletTitle,
							xtype : 'window',
							layout : 'fit',
							modal : false,
							maximizable : true,
							minimizable : true,
							width : 680,
							height : 500,
							plain : true,
							closeAction : 'hide',
							bodyStyle : 'padding:5 5 5 5;text-align:left;',
							items : [pThis.gridDownApp]
						});
			}

			var dsGrid1 = pThis.gridDownApp.getStore();
			dsGrid1.baseParams.pgPletId = pThis.pgPletId;
			dsGrid1.baseParams.pageId = pThis.pageId;

			dsGrid1.baseParams.counter = true;
			dsGrid1.baseParams.limit = pageSize;
			dsGrid1.load({
				params : {
					start : 0
				}
			});
			
			pThis.winMore.show();
		}
	},
	destroy : function() {
		if (this.panel) {
			this.panel.destroy();
			this.panel = null;
		}
		
		if (this.winMore) {
			this.winMore.destroy();
			this.winMore = null;
		}

		this.gridPart = null;
		this.gridAll = null;
		this.gridDownApp = null;
	}

});


//执行文件下载,sumit弹出页面，系统无法拦截该submit页面
ufgov.portal.portlet.Download.execDownload=function(fileId) {
 	var formObj = document.createElement("form");
    var inputObj = document.createElement("input");
    inputObj.name = 'fileid';
    inputObj.type = 'text';
    inputObj.value =fileId;
        
    formObj.action = path + '/fileDownload.action';
    formObj.target = '_blank';
    document.documentElement.appendChild(formObj);
    formObj.appendChild(inputObj)
    formObj.submit();
}
