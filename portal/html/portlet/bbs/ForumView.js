
ufgov.portal.portlet.ForumView = Ext.extend(ufgov.portal.Base, {
	panel : null,
	gridPart : null,
	gridWorkApp : null,
	portletId : 'forumView',
	pageId : '',
	portletTitle : '论坛版块',
	winMore : null,
	rowNum : 20,
	winDetail : null,
	panelWidth : 325,
	getTopicUrl : [
			'/javabb/getTopicListByForum.jbb'
			],
	recordType: [{
        name: 'id',type : 'string'
    }, {
        name: 'title',type : 'string'
    }, {
        name: 'author',type : 'string'
    }, {
        name: 'answer',type : 'string'
    }, {
        name: 'postTime',type : 'string'
    }
   ],		
 
	init : function() {
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			this.portletId = this.constructor.arguments[0].portletId;
			this.portletTitle = this.constructor.arguments[0].portletTitle;
		};
	},

	passParam : function(jsonParam) {
		var pThis = this;
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}

		if (!Boolean(jsonParam.page_id)) {
			alert("必须存在jsonParam.page_id参数");
			return;
		}

		if (Boolean(jsonParam.title)) {
			this.portletTitle = jsonParam.title;
		}

	
		if (Boolean(jsonParam.title)) {
			this.portletTitle = jsonParam.title;
		}		
		
		if (Boolean(jsonParam.record_size) && jsonParam.record_size > 0) {
			this.rowNum = jsonParam.record_size;
		}
		
		if (Boolean(jsonParam.panelWidth) && jsonParam.panelWidth > 0) {
			this.panelWidth = jsonParam.panelWidth;
		}
		
		// this.destroy();
		this.pageId = jsonParam.page_id;
		
        var privColsInfo = [{
	        	header : '图标',
				dataIndex : 'icon',
				renderer : function(value) {
					return '<a  class= "article-grid-flag"> </a>';
				},
				width : 25
			},{
				header : '主题',
				dataIndex : 'title',
				renderer : function(value) {
					return '<a href="javascript:void(null);" class="article-grid-cell" title="'+value+'" >'+value+'</a>';
				},
				width : 200,
				id : 'title',
				sortable : true
			}
			];
        
        if(this.panelWidth > 425){
        	privColsInfo[privColsInfo.length] = {
    				header : '作者',
    				dataIndex : 'author',
    				id:'author',
    				width : 100,
    				sortable : true	
    		};
        }
        if(this.panelWidth > 525){
        	privColsInfo[privColsInfo.length] = {
				header : '回复/点击',
				dataIndex : 'answer',
				id:'answer',
				width : 100,
				sortable : true	
			};
        }
        privColsInfo[privColsInfo.length] = {
			header : '最后回复',
			dataIndex : 'postTime',
			id:'postTime',
			width : 100,
			////renderer : Ext.util.Format.dateRenderer('Y-m-d H:i'),
			sortable : true	
		}
        
		var storePart = new Ext.data.Store({
			proxy : new Ext.data.MemoryProxy([]),
			reader : new Ext.data.JsonReader({},pThis.recordType)
		});
		
		function onRefresh(myGrid, max) {
			var store1 = myGrid.getStore();
			store1.removeAll();
			var arrUrl= pThis.getTopicUrl;
			var arrUrlTmp = arrUrl.slice(0);
			
			function ajaxFunc(jsonArr) {
				if (jsonArr && Ext.isEmpty(jsonArr.ret)) {
					store1.loadData(jsonArr,
							(arrUrlTmp.length + 1) != arrUrl.length);
				};
				if (arrUrlTmp.length > 0) {
					var url = arrUrlTmp.shift() + "?_forumName=" + encodeURIComponent(pThis.portletTitle);
					//+ "&page=" + max;
					//debugger;
					pThis.ajaxRequest(ajaxFunc, url);
				} else {
					
				}	
			}
			ajaxFunc(null);
		}

		var templateMater = new Ext.Template(
				'<div class="x-grid3" hidefocus="true">',
				'<div class="x-grid3-viewport">',
				'<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset">{header}</div></div><div class="x-clear"></div></div>',
				'<div class="x-grid3-scroller work-grid-body" ><div class="x-grid3-body">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>',
				"</div>", '<div class="x-grid3-resize-marker">&#160;</div>',
				'<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");
				
	   templateHeader = new Ext.Template(
                    '<table border="0" cellspacing="0" cellpadding="0" style="{tstyle}">',
                    '<thead><tr class="x-grid3-hd-row work-grid-header">{cells}</tr></thead>',
                    "</table>"
                    );

		var templates1 = {};
		templates1.master = templateMater;
        templates1.header = templateHeader;
		
		
        var colM = new Ext.grid.ColumnModel(privColsInfo);
		pThis.gridPart = new Ext.grid.GridPanel({
					autoScroll : true,
					title : '',
					cm : colM,
					ds : storePart,
					//hideHeaders : true,
					resizable : true,
					bodyStyle : 'width:100%',
					autoWidth : true,
					autoHeight : true,
					//height : 150,
					autoExpandColumn : 'title',
					//autoExpandMax:280,
					viewConfig : {
						forceFit : false,
						//autoFill:true,
						scrollOffset:2,
						templates : templates1
					}
				});

		// grid双击事件
		pThis.gridPart.on("rowclick", function(grid) {
					var record = grid.getSelectionModel().getSelected();
					if (!record) {
						return;
					}
					showWin(record.get('title'),record.get('id'));
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
					tools : [
					       {
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
									onRefresh(pThis.gridPart, pThis.rowNum);
								}
							}],
					border : false,
					autoScroll : true,
					standardSubmit : true,
					headerdblClick : function() {
						onOpenAll();
					},
					items : [pThis.gridPart]
				});
      
		onRefresh(pThis.gridPart, pThis.rowNum);

		// 打开全部数据窗口
		function onOpenAll() {
			var pageSize = 2;
			if (!pThis.gridWorkApp) {
				var dsGrid = new Ext.data.Store({
					proxy : new Ext.data.MemoryProxy([]),
					reader : new Ext.data.JsonReader({},pThis.recordType)
				});
						
				// 创建复选框的列
				var smWorkApp = new Ext.grid.CheckboxSelectionModel();

				// 创建grid的列信息
				var colsInfoArr=privColsInfo.slice(0);
				colsInfoArr.unshift(smWorkApp);
				var colsWorkApp = new Ext.grid.ColumnModel(colsInfoArr);

				// 创建页面信息工具栏
				var barWorkApp = new Ext.PagingToolbar({
					pageSize : pageSize,
					store : dsGrid,
					displayInfo : true,
					displayMsg : '显示第 {0} 条到 {1} 条数据，共 {2} 条',
					emptyMsg : '没有数据'
				})

				// 创建编辑Grid
				pThis.gridWorkApp = new Ext.grid.GridPanel({
					ds : dsGrid,
					cm : colsWorkApp,
					sm : smWorkApp,
					autoExpandColumn : 'title',
					resizable : true,
					autoWidth : true,
					//bbar : barWorkApp,
					// hideHeaders : true,
					viewConfig : {
						forceFit : false,
						templates : templates1
					}
					
				});

				// grid双击事件
				pThis.gridWorkApp.on("rowdblclick", function(grid) {
					var record = grid.getSelectionModel().getSelected();
					if (!record) {
						return;
					}
					showWin(record.get('title'),record.get('id'));
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
					height : 450,
					plain : true,
					closeAction : 'hide',
					bodyStyle : 'padding:5 5 0 5;',
					items : [pThis.gridWorkApp]
				});
			}

			onRefresh(pThis.gridWorkApp, -1);
			pThis.winMore.show();

		}

		function showWin(title1, id) {
			var originalUrl = '/javabb/viewtopic.jbb?t=' + id;
			var url = "/portal/integrate/javabb.jsp?originalUrl=" + originalUrl + "";
			//window.location.href = url;
			window.open(url,'maxwindow',"top=0,left=0,width="+screen.availWidth+",height="+ screen.availHeight+",scrollbars=yes,toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no"); 
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
		if (this.winDetail) {
			this.winDetail.destroy();
			this.winDetail = null;
		}
		this.gridPart = null;
		this.gridWorkApp = null;
	}
	 
});
