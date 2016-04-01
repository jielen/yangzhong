/**
 * 变量MsgBoardView与工作频道ID必须一致，在主程序中调用
 */
ufgov.portal.portlet.MsgBoardView = Ext.extend(ufgov.portal.Base, {
	panel : null,
	gridPart : null,
	gridMsgBoardApp:null,
	portletId : 'myMsgBoardReply',
	portletTitle : '我的投诉',
	winMore : null,
	dsType: null, //留言类型下拉框DS的Field信息内容 
	dsGroup:null, //创建用户组类型下拉框的DS  	
	winEdit : null,
	pageSizeAll:20,
	scopeData : -1,
	dsStatus: new Ext.data.SimpleStore({
        fields: ["key", "val"],
        data: [['0', '待处理/待审核'], ['10', '审核没通过'], ['20', '审核过在经办中'],['30', '经办完成']]
    }),
    dsPart:null,
    dsAll:null,
    dsReplyType: new Ext.data.SimpleStore({
        fields: ["key", "val"],
        data: [['0', '了结'], ['10', '处理完毕'], ['20', '处理完毕并通知留言人'],['99', '缓办']]
    }),
	/*
	 * *createType
	 * 00:公共(显示)留言板
	 * 10:我的留言板
	 * 20:我的待审核/已审核留言板
	 * 30:我的待处理/已处理留言板
	 * 
	 */
	createType : 0,
	rowNum : 20,
	colJsonPart : null,
	colJsonAll : null,
	smMsgBoardApp : null,
	tbarMoreArray : null,
	gridBarItems : null,
	recordType : [{
				name : 'id',
				type : 'int'
			}, {
				name : 'title',
				type : 'string'
			}, {
				name : 'type',
				type : 'string'
			}, {
				name : 'ip',
				type : 'string'				
			}, {
				name : 'attachFileId',
				type : 'string'
			}, {
				name : 'attachFileName',
				type : 'string'
			}, {
				name : 'toGroup',
				type : 'string'
			}, {
				name : 'checkId',
				type : 'string'
			}, {
				name : 'checkTime',
				dateFormat : 'Y-m-d H:i:s',
				type : 'date'
			}, {
				name : 'toTransactorId',
				type : 'string'
			}, {
				name : 'toTransactorName',
				type : 'string'
			}, {
				name : 'planStartDate',
				dateFormat : 'Y-m-d H:i:s',
				type : 'date'
			}, {
				name : 'planEndDate',
				dateFormat : 'Y-m-d H:i:s',
				type : 'date'
			}, {
				name : 'createTime',
				dateFormat : 'Y-m-d H:i:s',
				type : 'date'
			}, {
				name : 'updateTime',
				dateFormat : 'Y-m-d H:i:s',
				type : 'date'
			}, {
				name : 'fromMail',
				type : 'string'
			}, {
				name : 'fromTel',
				type : 'string'
			}, {
				name : 'fromPersonId',
				type : 'string'
			}, {
				name : 'fromPersonName',
				type : 'string'
			}, {
				name : 'status',
				type : 'int'
			}, {
				name : 'replyDate',
				dateFormat : 'Y-m-d H:i:s',
				type : 'date'
			}, {
				name : 'replyType',
				type : 'int'
			}, {
				name : 'replyTitle',
				type : 'string'
			}, {
				name : 'replyFileId',
				type : 'string'
			}, {
				name : 'replyFileName',
				type : 'string'
			}, {
				name : 'securityLevel',
				type : 'int'
			}],

	init : function() {
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			this.portletId = this.constructor.arguments[0].portletId;
			this.portletTitle = this.constructor.arguments[0].portletTitle;
			this.createType = this.constructor.arguments[0].createType;
			this.createType = this.createType ? this.createType : 0;
		};
		var pThis=this;
		pThis.dsPart = pThis.getInitDs(pThis.recordType,
				    'apService.getListMsgBoardPageByPortletId',
				    'createType,userId,portletId,counter,start,limit,sort,dir,scopeData');
        pThis.dsAll = pThis.getInitDs(pThis.recordType,
		           'apService.getListMsgBoardPageByPortletId',
		            'createType,userId,portletId,counter,start,limit,sort,dir,scopeData');
		
	    var cmbType = [{
	        name: 'valId'
	    }, {
	        name: 'val'
	    }];
	    pThis.dsType = pThis.getDs(cmbType, "asService.getListByValsetId_AsVal", "valsetId", new ufgov.portal.common.Param('VS_AP_MESSAGEBOARD_TYPE', '', 'valsetId'));
		
	    var cmbGroup = [{
	        name: 'groupId'
	    }
	    , {
	        name: 'groupName'
	    }
	    , {
	        name: 'groupDesc'
	    }
	    ];
	    pThis.dsGroup = pThis.getDs(cmbGroup, 'asService.getList_AsGroup','');
		
		pThis.winEdit=new ufgov.portal.portlet.MsgBoardEdit({dsGroup:pThis.dsGroup,dsType:pThis.dsType});

		if (pThis.createType == 0 || pThis.createType == 10) {// 00:公共显示留言板  10:我的留言板
			pThis.colJsonPart = [{
				header : '状态',
				dataIndex : 'status',
				renderer : function(value) {
					return '<a   href= "#"     class= "article-grid-flag"> </a>';
				},
				width : 33
			}, {
				header : '编号',
				dataIndex : 'id',
				id : 'id',width : 40
			}, {
				header : '主题',
				dataIndex : 'title',
				id : 'title'
			}, {
				header : '投诉时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}];

			pThis.colJsonAll = [{
				header : '状态',
				dataIndex : 'status',
				renderer : function(value) {
					return '<a   href= "#"     class= "article-grid-flag"> </a>';
				},
				width : 33
			}, {
				header : '编号',
				dataIndex : 'id',
				id : 'id',width : 40
			}, {
				header : '类型',
				dataIndex : 'type',
				id : 'type',
			    renderer: function(value){
	               var index1 = pThis.dsType.find('valId', value, 0, false, false);
	               return (index1 < 0) ? '' : pThis.dsType.getAt(index1).data.val;
	            }				
			}, {
				header : '科别',
				dataIndex : 'toGroup',
				id : 'toGroup',
			    renderer: function(value){
	               var index1 = pThis.dsGroup.find('groupId', value, 0, false, false);
	               return (index1 < 0) ? '' : pThis.dsGroup.getAt(index1).data.groupName;
	            }				
			}, {
				header : '主题',
				dataIndex : 'title',
				id : 'title'
			}, {
				header : '投诉人',
				dataIndex : 'fromPersonName',
				id : 'fromPersonName'
			}, {
				header : '投诉时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : '回复标题',
				dataIndex : 'replyTitle',
				id : 'replyTitle'
			}, {
				header : '经办人',
				dataIndex : 'toTransactorName',
				id : 'toTransactorName'
			}, {
				header : '反馈类型',
				dataIndex : 'replyType',
				id : 'replyType',
			    renderer: function(value){
                   var index1 = pThis.dsReplyType.find('valId', value, 0, false, false);
                   return (index1 < 0) ? '' : pThis.dsReplyType.getAt(index1).data.val;
	            }				

			}, {
				header : '反馈时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : 'IP',
				dataIndex : 'ip',
				id : 'ip'
			}];
			if (pThis.createType == 10) {
				pThis.gridBarItems = ['-', 
					    {
							tooltip : '刪除',
							iconCls : 'new-tab',
							icon : '/style/img/gp5/ico/delete_style_g.jpg'
						},{
							tooltip : '新增',
							iconCls : 'new-tab',
							icon : '/style/img/gp5/ico/add_g.jpg',
							handler : function() {
								pThis.winEdit.showWindow({detailType:0,winTitle:'新增投诉反馈'});
							}
						}, {
							tooltip : '编辑',
							iconCls : 'new-tab',
							icon : '/style/img/gp5/ico/edit_g.jpg',
							handler : function() {
						        pThis.showEditWin(pThis.gridMsgBoardApp);
							}
						}];
					
			} else {
				pThis.gridBarItems = ['-', {
							tooltip : '新增',
							iconCls : 'new-tab',
							icon : '/style/img/gp5/ico/add_g.jpg',
							handler : function() {
							    pThis.winEdit.showWindow({detailType:0,winTitle:'新增投诉反馈'});
							}
						}]

			}

		} else if (pThis.createType == 20) {//20:我的待审核/已审核投诉反馈板
			pThis.scopeData = -1;
			pThis.colJsonPart = [{
				header : '状态',
				dataIndex : 'status',
				renderer : function(value) {
					return '<a   href= "#"     class= "article-grid-flag"> </a>';
				},
				width : 33
			}
			, {
				header : '编号',
				dataIndex : 'id',
				id : 'id',width : 40
			}, {
				header : '主题',
				dataIndex : 'title',
				id : 'title'
			}, {
				header : '投诉人',
				dataIndex : 'fromPersonName',
				id : 'fromPersonName'
			}, {
				header : '投诉时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : '经办人',
				dataIndex : 'toTransactorName',
				id : 'toTransactorName'
			}

			];
			// 创建复选框的列
			pThis.smMsgBoardApp = new Ext.grid.CheckboxSelectionModel();
			pThis.colJsonAll = [pThis.smMsgBoardApp, {
				header : '状态',
				dataIndex : 'status',
				renderer : function(value) {
					return '<a   href= "#"     class= "article-grid-flag"> </a>';
				},
				width : 33
			}, {
				header : '编号',
				dataIndex : 'id',
				id : 'id',width : 40
			}, {
				header : '类型',
				dataIndex : 'type',
				id : 'type',
			    renderer: function(value){
	               var index1 = pThis.dsType.find('valId', value, 0, false, false);
	               return (index1 < 0) ? '' : pThis.dsType.getAt(index1).data.val;
	            }				
			}, {
				header : '科别',
				dataIndex : 'toGroup',
				id : 'toGroup',
			    renderer: function(value){
	               var index1 = pThis.dsGroup.find('groupId', value, 0, false, false);
	               return (index1 < 0) ? '' : pThis.dsGroup.getAt(index1).data.groupName;
	            }				
				
			}, {
				header : '主题',
				dataIndex : 'title',
				id : 'title'
			}, {
				header : '投诉人',
				dataIndex : 'fromPersonName',
				id : 'fromPersonName'
			}, {
				header : '投诉时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : '经办人',
				dataIndex : 'toTransactorName',
				id : 'toTransactorName'
			}, {
				header : '经办期限',
				dataIndex : 'planEndDate',
				id : 'planEndDate',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : 'IP',
				dataIndex : 'ip',
				id : 'ip'
			}];
			
			pThis.tbarMoreArray = [{
						pressed : true,
						text : '未审',
						handler:function() {
				           pThis.loadGridData(pThis.dsAll,  pThis.pageSizeAll,true,-1);
						}   
					}, {
						pressed : true,
						text : '已审',
						handler:function() {
						   pThis.loadGridData(pThis.dsAll,  pThis.pageSizeAll,true,1);
						}   
					}, {
						pressed : true,
						text : '全部',
						handler:function() {
				           pThis.loadGridData(pThis.dsAll,  pThis.pageSizeAll,true,0);
						}   
					}
/*					
					, '-', {
						pressed : true,
						text : '通过'
					}, {
						pressed : true,
						text : '无效'
					}
*/
			];
			pThis.gridBarItems = ['-', {
				tooltip : '投诉审核',
				iconCls : 'new-tab',
				icon : '/style/img/gp5/ico/add_g.jpg',
				handler : function() {
				    pThis.showEditWin(pThis.gridMsgBoardApp);
				}
			}];
		} else if (pThis.createType == 30) {//30:我的待处理-已处理投诉反馈板
			pThis.scopeData = -1;
			pThis.colJsonPart = [{
				header : '状态',
				dataIndex : 'status',
				renderer : function(value) {
					return '<a   href= "#"     class= "article-grid-flag"> </a>';
				},
				width : 33
			}, {
				header : '编号',
				dataIndex : 'id',
				id : 'id',width : 40
			}, {
				header : '主题',
				dataIndex : 'title',
				id : 'title'
			}, {
				header : '投诉人',
				dataIndex : 'fromPersonName',
				id : 'fromPersonName'
			}, {
				header : '投诉时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : '审核人',
				dataIndex : 'checkName',
				id : 'checkName'
			}, {
				header : '审核时间',
				dataIndex : 'checkTime',
				id : 'checkTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}];
			// 创建复选框的列
			pThis.smMsgBoardApp = new Ext.grid.CheckboxSelectionModel();
			pThis.colJsonAll = [this.smMsgBoardApp, {
				header : '状态',
				dataIndex : 'status',
				renderer : function(value) {
					return '<a   href= "#"     class= "article-grid-flag"> </a>';
				},
				width : 33
			}, {
				header : '编号',
				dataIndex : 'id',
				id : 'id',width : 40
			}, {
				header : '类型',
				dataIndex : 'type',
				id : 'type',
			    renderer: function(value){
	               var index1 = pThis.dsType.find('valId', value, 0, false, false);
	               return (index1 < 0) ? '' : pThis.dsType.getAt(index1).data.val;
	            }				
			}, {
				header : '科别',
				dataIndex : 'toGroup',
				id : 'toGroup',
			    renderer: function(value){
	               var index1 = pThis.dsGroup.find('groupId', value, 0, false, false);
	               return (index1 < 0) ? '' : pThis.dsGroup.getAt(index1).data.groupName;
	            }				
			}, {
				header : '主题',
				dataIndex : 'title',
				id : 'title'
			}, {
				header : '投诉人',
				dataIndex : 'fromPersonName',
				id : 'fromPersonName'
			}, {
				header : '投诉时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : '审核人',
				dataIndex : 'checkName',
				id : 'checkName'
			}, {
				header : '审核时间',
				dataIndex : 'checkTime',
				id : 'checkTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : '经办期限',
				dataIndex : 'planEndDate',
				id : 'planEndDate',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : '回复标题',
				dataIndex : 'replyTitle',
				id : 'replyTitle'
			}, {
				header : '反馈类型',
				dataIndex : 'replyType',
				id : 'replyType'
			}, {
				header : '反馈时间',
				dataIndex : 'updateTime',
				id : 'updateTime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				width : 80
			}, {
				header : 'IP',
				dataIndex : 'ip',
				id : 'ip'
			}];
			pThis.tbarMoreArray = [{
						pressed : true,
						text : '未处理'
					}, {
						pressed : true,
						text : '已处理'
					}, {
						pressed : true,
						text : '全部'
					}];
			pThis.gridBarItems = ['-', {
				tooltip : '投诉反馈处理',
				iconCls : 'new-tab',
				icon : '/style/img/gp5/ico/add_g.jpg',
				handler : function() {
			       pThis.showEditWin(pThis.gridMsgBoardApp);
				}
			}];
	
		
		}

	},

	passParam : function(jsonParam) {
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}

		if (Boolean(jsonParam.portlet_id)) {
			this.portletId = jsonParam.portlet_id;
		}

		if (Boolean(jsonParam.title)) {
			this.portletTitle = jsonParam.title;
		}
		if (Boolean(jsonParam.record_size) && jsonParam.record_size > 0) {
			this.rowNum = jsonParam.record_size;
		}

		// this.destroy();

		var pThis = this;
		var colM = new Ext.grid.ColumnModel(pThis.colJsonPart);
		

		var template1 = new Ext.Template(
				'<div class="x-grid3" hidefocus="true">',
				'<div class="x-grid3-viewport">',
				'<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset">{header}</div></div><div class="x-clear"></div></div>',
				'<div class="x-grid3-scroller article-grid-body" ><div class="x-grid3-body">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>',
				"</div>", '<div class="x-grid3-resize-marker">&#160;</div>',
				'<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");

		var templates1 = {};
		templates1.master = template1;

		pThis.gridPart = new Ext.grid.GridPanel({
					autoScroll : true,
					title : '',
					cm : colM,
					ds : pThis.dsPart,
					//hideHeaders : true,
					resizable : true,
					bodyStyle : 'width:100%',
					autoWidth : true,
					autoExpandColumn : 'title',
					autoHeight:true,
					//height:150,
					viewConfig : {
						forceFit : false,
						scrollOffset : 2,
						templates : templates1
					}
				});

		// grid双击事件
		pThis.gridPart.on("rowdblclick", function(grid){
			 pThis.showEditWin(grid);
		 });

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
        var myTools=[{
			qtip : '更多信息......',
			id : 'more',
			handler : function(e, target, panel) {
				onOpenAll();
			}
		}, {
			qtip : '刷新数据',
			id : 'refresh',
			handler : function(e, target, panel) {
				pThis.loadGridData(pThis.dsPart, pThis.rowNum,
						false, pThis.scopeData);
			}
		}];
        
        if  (pThis.createType==0 || pThis.createType==10)  {
        	myTools.unshift({
    			qtip : '撰写投诉',
    			id : 'plus',
    			handler : function(e, target, panel) {
        			pThis.winEdit.showWindow({detailType:0,winTitle:'新增投诉'});
    			}
    		});
        };	
		// pThis.panel=pThis.gridPart;
		pThis.panel = new Ext.PanelUF({
					title : pThis.portletTitle,
					toolStyle : toolStyle1,
					tools :myTools ,
					border : false,
					autoScroll : true,
					standardSubmit : true,
					headerdblClick : function() {
						onOpenAll();
					},
					items : [pThis.gridPart]
				});

		pThis.loadGridData(pThis.dsPart, pThis.rowNum, false,
				pThis.scopeData);
		
		

		// 打开全部数据窗口
		function onOpenAll() {
			
			if (!pThis.gridMsgBoardApp) {
				// 复选的GridPortlet
			
				// 创建grid的列信息
				var colsMsgBoardApp = new Ext.grid.ColumnModel(pThis.colJsonAll);

				// 创建页面信息工具栏
				var barMsgBoardApp = new Ext.PagingToolbar({
							pageSize : pThis.pageSizeAll,
							store : pThis.dsAll,
							displayInfo : true,
							displayMsg : '显示第 {0} 条到 {1} 条数据，共 {2} 条',
							emptyMsg : '没有数据',
							items : pThis.gridBarItems
						})

				// 创建编辑Grid
				pThis.gridMsgBoardApp = new Ext.grid.GridPanel({
							ds : pThis.dsAll,
							cm : colsMsgBoardApp,
							sm : pThis.smMsgBoardApp,
							autoExpandColumn : 'title',
							resizable : true,
							autoWidth : true,
							//hideHeaders : true,
							viewConfig : {
								forceFit : false,
								templates : templates1
							},
							bbar : barMsgBoardApp
						});

				// grid双击事件
			
				pThis.gridMsgBoardApp.on("rowdblclick", function(grid){
					 pThis.showEditWin(grid);
				 });
				// more的window
				pThis.winMore = new Ext.Window({
							title : pThis.portletTitle,
							xtype : 'window',
							layout : 'fit',
							tbar : pThis.tbarMoreArray,
							modal : false,
							maximizable : true,
							minimizable : true,
							width : 550,
							height : 450,
							plain : true,
							closeAction : 'hide',
							bodyStyle : 'padding:5 5 0 5;text-align:left;',
							items : [pThis.gridMsgBoardApp]
						});
			}
			pThis.loadGridData(pThis.dsAll,  pThis.pageSizeAll,true,0);
			pThis.winMore.show();
		}
	}
	,loadGridData : function(store, pageSize, counter, scopeData) {
		store.baseParams.portletId = this.portletId;
		store.baseParams.createType = this.createType;
		try {
			store.baseParams.userId = userId;
		} 
		catch (e) {
			store.baseParams.userId = 'guest';
		}
		store.baseParams.counter = counter;
		store.baseParams.limit = pageSize;
		store.baseParams.scopeData = scopeData;
		store.load({
					params : {
						start : 0,
						dir : 'desc',
						sort : 'id'
					}
				});
	}
	,showEditWin:function(grid){
		var record = grid.getSelectionModel().getSelected();
		if (!record) {
			return;
		}
		
		/*
		 * *createType
		 * 00:公共(显示)投诉反馈板
		 * 10:我的投诉反馈板
		 * 20:我的待审核/已审核投诉反馈板
		 * 30:我的待处理/已处理投诉反馈板
		 * 
		 */
		/*
		 **detailType
		 ** 10：查看投诉反馈基本信息; * 20：查看投诉反馈全部信息; * 30: 审核投诉反馈; * 40: 处理投诉反馈; 00: 创建或者编辑投诉反馈
		 * 其他值同00
		 */
		var detailType=10;
		var winTitle='查看投诉反馈';
		if  (this.createType==30) {
			detailType=40;
			winTitle='投诉反馈处理';
		} else if 	(this.createType==20) {
			detailType=30;
			winTitle='投诉反馈审核';
		} else if 	(this.createType==10) {		
			detailType=0;
			winTitle='投诉反馈编辑';
		};	
		this.winEdit.showWindow({msgBoardId:record.get('id'),detailType:detailType,winTitle:winTitle});
	}	
	,destroy : function() {
		if (this.panel) {
			this.panel.destroy();
			this.panel = null;
		}
		if (this.winMore) {
			this.winMore.destroy();
			this.winMore = null;
		}
		if (this.winEdit) {
			this.winEdit.destroy();
			this.winEdit = null;
		}

		this.gridPart = null;
		this.gridMsgBoardApp = null;
	}

});
