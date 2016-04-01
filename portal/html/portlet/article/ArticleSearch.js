/**
 * 变量articleApp与工作频道ID必须一致，在主程序中调用
 */
ufgov.portal.portlet.ArticleSearch = Ext.extend(ufgov.portal.Base, {
	panel : null,
	picPart: null,
	gridPart : null,
	gridArticleApp : null,
	pgPletId : '0',
	groupId:'',
	pageId : '',
	portletTitle : '搜索	',
	winMore : null,
	winDetail : null,
	rowNum : 20,
	columnStyle:true,
	hidePanelHeader:false,
	defaultCollapsedStatus:false,
	searchPgPletId:0,
	searchDs:null,
	pageSize:20,
	recordType : [{
				name : 'id',
				type : 'int'
			}, {
				name : 'title',
				type : 'string'
			}, {
				name : 'pubTime',
				type : 'date',
				dateFormat : 'Y-m-d H:i:s'
			}],

	init : function() {
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			this.pgPletId = this.constructor.arguments[0].pgPletId;
			this.portletTitle = this.constructor.arguments[0].portletTitle;
		   
			if  (this.constructor.arguments[0].columnStyle!=undefined) {
				this.columnStyle = this.constructor.arguments[0].columnStyle;
			}
			if  (this.constructor.arguments[0].hidePanelHeader!=undefined) {
				this.hidePanelHeader = this.constructor.arguments[0].hidePanelHeader;
			}
			if  (this.constructor.arguments[0].defaultCollapsedStatus!=undefined) {
				this.defaultCollapsedStatus = this.constructor.arguments[0].defaultCollapsedStatus;
			}
			if (!Ext.isEmpty(this.constructor.arguments[0].searchDs)){
				this.searchDs = this.constructor.arguments[0].searchDs;
			}
			
		};
		if (Ext.isEmpty(this.hidePanelHeader))this.hidePanelHeader=false;
		if (this.hidePanelHeader || Ext.isEmpty(this.defaultCollapseStatus))this.defaultCollapseStatus=false;
	},

	passParam : function(jsonParam) {
		this.embedWin=null;
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
		this.groupId = jsonParam.group_id;
		if  (jsonParam.searchPgPletId!=undefined) {
			this.searchPgPletId =jsonParam.searchPgPletId;
		}
		
		var pThis = this;
				
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
		};

		var dsSearchType =new Ext.data.SimpleStore( {
			fields : [ "key", "val" ],
			data : [
                 [ '0', '全部' ]
			  , [ '10', '标题' ]
			  , [ '20', '内容' ]
			  , [ '30', '附件名']
			]
		});

		var template1 = new Ext.Template(
				'<div class="x-grid3" hidefocus="true">',
				'<div class="x-grid3-viewport">',
				'<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset">{header}</div></div><div class="x-clear"></div></div>',
				'<div class="x-grid3-scroller article-grid-body" ><div class="x-grid3-body">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>',
				"</div>", '<div class="x-grid3-resize-marker">&#160;</div>',
				'<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");

		var templates1 = {};
		templates1.master = template1;
		
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
		
		//搜索方法
		function execSearch(){
			var htmls=Ext.query('[name=search_key]',pThis.panel.el.dom);
			var search_key=Ext.getCmp(htmls[0].id);
			var searchKey=search_key.getValue();
			
			
			if  (Ext.isEmpty(pThis.searchDs)) {
				if  (!searchKey || searchKey.indexOf('%')>-1 ) {
					 alert('搜索关键字为空，或包含非法关键字(如%)!');
					 search_key.focus(false);
					 return;
				}
			   onOpenAll();
			} else {
				if  (searchKey && searchKey.indexOf('%')>-1 ) {
					 alert('搜索关键字为空，或包含非法关键字(如%)!');
					 search_key.focus(false);
					 return;
				}
				pThis.query(pThis.searchDs);				
			}	
			if (Boolean(pThis.embedWin)) {
			   pThis.embedWin.hide();
			}
		} 	 
		
		//重置方法
		function resetSearch(){
			var htmls=Ext.query('[name=search_key]',pThis.panel.el.dom);
			var search_key=Ext.getCmp(htmls[0].id);
			search_key.setValue(null);
			
			htmls=Ext.query('[name=search_type]',pThis.panel.el.dom);
			var search_type=Ext.getCmp(htmls[0].id);
			search_type.setValue('0');
		} 	 
	
        if  (pThis.columnStyle) {   		
			pThis.panel = new Ext.PanelUF({
				title : pThis.portletTitle,
				toolStyle : toolStyle1,
				border : false,
				autoScroll : false,
				standardSubmit : true,
				collapsible:true,
				collapsed:pThis.defaultCollapsedStatus,
				header : ! pThis.hidePanelHeader,
				layout   : 'column',
				labelAlign :'left',
				labelWidth :70,
				bodyStyle :'padding:5 5 2 5',
				items : [{
					xtype :'combo',
					//hiddenName:'search_type',
					name:'search_type',
					fieldLabel :'搜索类型',
					valueField :'key',
					displayField :'val',
					width:90,
					allowBlank :false,
					value :0,
					anchor :'97%',
					triggerAction :'all',
					mode :'local',
					readOnly:true,
					typeAhead :true,
					store :dsSearchType,
					emptyText :'请选择搜索类型'
				}
				,
				{
					xtype :'label',
					html:'&nbsp;'
				}
				,
				{
					xtype :'textfield',
					name :'search_key',
					fieldLabel :'关键字',
					anchor :'97%'
				}
				,
				{
					xtype :'label',
					html:'&nbsp;&nbsp;&nbsp;&nbsp;'
				}				
				,
				{
					xtype :'button',
					width:30,
					getSize:function(){
					  return { x:0,y:0};
				    },
					handler :execSearch,
					text:'搜索'
				}
				,
				{
					xtype :'label',
					html:'&nbsp;'
				}
				,
				{
					xtype :'button',
					width:30,
					getSize:function(){
					  return { x:0,y:0};
				    },
					handler : resetSearch,    
					text:'重置'
				}
			]	
				
	       });    		
        } else {
			pThis.panel = new Ext.PanelUF({
				title : pThis.portletTitle,
				toolStyle : toolStyle1,
				border : false,
				autoScroll : true,
				standardSubmit : true,
				collapsible : false,
				collapsed:pThis.defaultCollapsedStatus,
				layout   : 'form',
				frame:true,
				header :! pThis.hidePanelHeader,
				labelAlign :'left',
				labelWidth :70,
				buttonAlign:'center',
				bodyStyle :'padding:5 5 2 5',
				items : [{
					xtype :'combo',
					name:'search_type',
					fieldLabel :'搜索类型',
					valueField :'key',
					displayField :'val',
					width:90,
					allowBlank :false,
					value :0,
					anchor :'97%',
					readOnly:true,
					triggerAction :'all',
					mode :'local',
					typeAhead :true,
					store :dsSearchType,
					emptyText :'请选择搜索类型'
				},
				{
					xtype :'textfield',
					name :'search_key',
					fieldLabel :'关键字',
					anchor :'97%'
				}
			    ],
			    buttons:[{
					text :'搜索',
					handler :execSearch		      
	            },{
					text :'重置',
					handler : resetSearch			      
	            }] 
	          
	       });    		
        	
        	
        	
        }	
	    
        

		// 打开全部数据窗口
		function onOpenAll() {
			if (!pThis.gridArticleApp) {
				// 复选的GridPortlet
				var dsGrid = pThis.getInitDs(pThis.recordType,
								"apService.getListArticlePageBypgPletId_Search",
								"groupId,pageId,searchPgPletId,counter,start,limit,searchType,searchKey");

				// 创建复选框的列
				var smArticleApp = new Ext.grid.CheckboxSelectionModel();

				// 创建grid的列信息
				var colsArticleApp = new Ext.grid.ColumnModel([smArticleApp, {
					header : '',
					dataIndex : 'icon',
					renderer : function(value) {
						return '<a    class= "article-grid-flag"> </a>';
					},
					width : 25
				}, {
					header :'<div align="center">标题</div>',
					dataIndex : 'title',
					renderer : function(value) {
						return '<div><a href="javascript:void(null);" class="article-grid-cell" title="'+value+'" >'+value+'</a></div>';
					},
					id : 'title'
				}, {
					header : '<div align="center">发布时间</div>',
					dataIndex : 'pubTime',
					id : 'pubTime',
					renderer : function(value) {
		        	    var  dt=Ext.util.Format.date(value,'Y-m-d h:i');
		        	    var  dt1=Ext.util.Format.date(value,'Y-m-d');
		        	    var  dtNow=Ext.util.Format.date(new Date(),'Y-m-d');
		        	    return (dt1==dtNow)?('<span>'+dt + '<a  class= "article-new-flag"></a></span>'):dt  ;
					},
					width : 112
				}]);

				// 创建页面信息工具栏
				var barArticleApp = new Ext.PagingToolbar({
							pageSize : pThis.pageSize,
							store : dsGrid,
							displayInfo : true,
							displayMsg : '显示第 {0} 条到 {1} 条数据，共 {2} 条',
							emptyMsg : '没有数据'
						});

				// 创建编辑Grid
				pThis.gridArticleApp = new Ext.grid.GridPanel({
							ds : dsGrid,
							cm : colsArticleApp,
							sm : smArticleApp,
							autoExpandColumn : 'title',
							resizable : true,
							autoWidth : true,
							//hideHeaders : true,
							viewConfig : {
								forceFit : false,
								templates : templates1
							},
							bbar : barArticleApp
						});
				
				// grid双击事件cellclick
				pThis.gridArticleApp.on('cellclick', function(grid,r,c,e) {
					if  (c !=2 ) return;
					var record = grid.getSelectionModel().getSelected();
					if (!record) {
						return;
					}
					onOpenDetail(record.get('id'),record.get('pubTime'));
				})

				// more的window
				pThis.winMore = new Ext.Window({
							title : pThis.portletTitle,
							xtype : 'window',
							layout : 'fit',
							modal : true,
							maximizable : true,
							minimizable : true,
							width : 550,
							height : 450,
							plain : true,
							closeAction : 'hide',
							bodyStyle : 'padding:5 5 5 5;text-align:left;',
							items : [pThis.gridArticleApp]
						});
			}
		
			
			pThis.query( pThis.gridArticleApp.getStore());
			pThis.winMore.show();
		}

		function onOpenDetail(id,pubTime) {
			pThis.showSaveProgressBar('正在查询,请稍候......');
			pThis.executeAjax(function(json) {
				pThis.hideSaveProgressBar();
				json.pubTime1=json.pubTime1=Ext.util.Format.date(pubTime,'Y-m-d h:i');
				json.path=path;
				json.logoHtml=logoHtml;
				window.articleJSON=json;
				window.open(context_g+"/html/portlet/article/article-detail.html",'maxwindow',"top=0,left=0,width="+screen.availWidth+",height="+ screen.availHeight+",scrollbars=yes,toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no"); 
				return;

						
						
						
/*						
						if (json.id) {
							var panelId=Ext.id();
							var addiFlag=Boolean(json.attatchBlobid) &&  json.attatchBlobid!='0';
							var myItems=[{
								xtype :'panel',
								fieldLabel :'',
								border:true,
								plain : true,
								id:panelId,
								style : 'padding:3 3 3 3;text-align:left',
								html :json.content,
								height:addiFlag?350:382,
								scripts:true,
								autoWidth :true,
								autoScroll:true
							}
						   ];
						   if  (addiFlag)  {
							   var buttonTitle='附件';
							   if (Boolean(json.attatch)) {
								   buttonTitle='附件('+json.attatch+')';
							   }	   
							   myItems.push({
								    xtype :'button',
									text:buttonTitle,
									handler:function(){
										var formObj = document.createElement("form");
										var inputObj = document.createElement("input");
										inputObj.name = 'fileid';
										inputObj.type = 'text';
										inputObj.value = json.attatchBlobid;
										formObj.action = path + '/fileDownload.action';
										formObj.target = '_blank';
										document.documentElement.appendChild(formObj);
										formObj.appendChild(inputObj)
										formObj.submit();
							        }
							   });
						   }	   
							
							pThis.winDetail = new Ext.Window( {
								title :json.title,
								closeAction :'hide',
								maximizable : true,
								modal : false,
								width : 550,
								height : 450,
								// plain : true,
								hidden : true,
								resizable :true,
								layout : 'fit',
								items : [{
									border :false,
									labelAlign :'left',
									labelWidth :70,
									style : 'padding:2 2 2 2',
									fileUpload :false, // 文件上传标志
									items :myItems
								}],
								buttons :[ {
									text :'关闭',
									handler : function() {
										pThis.winDetail.hide();
								    }
								}]
							});							
							
							pThis.winDetail.render(document.body);
							pThis.winDetail.on('resize', function() {
								var offH=Boolean(json.attatchBlobid) &&  json.attatchBlobid!='0'?100:70;
								Ext.getCmp(panelId).setHeight(pThis.winDetail.el.getSize().height-offH);
								Ext.getCmp(panelId).doLayout();
							});							
							
							
							pThis.winDetail.show();
						} else {
							alert(json.msg);
						}
					*/	
					}, 'apService.selectByPrimaryKey_ApArticle',
					new ufgov.portal.common.Param(id));
		}

	},
	query:function(ds,searchKey) {
		var htmls=Ext.query('[name=search_key]',this.panel.el.dom);
		var search_key=Ext.getCmp(htmls[0].id);
		htmls=Ext.query('[name=search_type]',this.panel.el.dom);
		var search_type=Ext.getCmp(htmls[0].id);
		
		ds.baseParams.searchKey =search_key.getValue();
		ds.baseParams.searchType = search_type.getValue();
		ds.baseParams.searchPgPletId =this.searchPgPletId;
		
		ds.baseParams.pageId = this.pageId;
		ds.baseParams.groupId = this.groupId;
		
		ds.baseParams.counter = true;
		ds.baseParams.limit = this.pageSize;
		ds.baseParams.dir = 'desc';
		ds.baseParams.sort = 'id';
		ds.load({
					params : {
						start : 0
					}
				});		
		
	},
    showPanel:function(){
		this.embedWin=new Ext.Window({
			title:'搜索',
			xtype : 'window',
			//layout : 'fit',
			modal : true,
			width:350,
			//frame:true,
			autoHeight:true,
			bodyStyle : 'padding:5 5 5 5;text-align:left;',
			plain : true,
			closeAction : 'close',
			items : [this.panel]
		});
		this.embedWin.show();
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
		
		
		
		this.gridAll = null;
		this.gridArticleApp = null;

	}

});
