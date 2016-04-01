/**
 * oa中收文发文的待办，暂存于此，以后移至OA.war中
 */
ufgov.portal.portlet.OAFileWorkApp = Ext.extend(ufgov.portal.Base, {
    panel: null,
    gridPart: null,
    gridWorkApp: null,
    portletId: 'workTodo',
    pageId: '',
    portletTitle: '代办工作',
    workType: 'workDoneList',
    winMore: null,
    rowNum: 20,
    winDetail: null,
    arrDoneUrl: ['/OA/getWorklist.action'],
    arrTodoUrl: ['/OA/getWorklist.action'],
    compoList: 'OA_RECEIVE_FILE',
    
    recordType: [{
        name: 'lamp',
        type: 'string'
    }, {
        name: 'title',
        type: 'string'
    }, {
        name: 'brief',
        type: 'string'
    }, {
        name: 'processInsId',
        type: 'string'
    }, {
        name: 'compoId',
        type: 'string'
    }, {
        name: 'compoName',
        type: 'string'
    }, {
        name: 'url',
        type: 'string'
    }, {
        name: 'coName',
        type: 'string'
    }, {
        name: 'orgName',
        type: 'string'
    }, {
        name: 'urgencyGrade',
        type: 'string'
    }, {
        name: 'wfCreatorName',
        type: 'string'
    }, {
        name: 'wfCreateTime',
        type: 'date',
        dateFormat: 'YmdHis'
    }, {
        name: 'wfExecuteTime',
        type: 'date',
        dateFormat: 'YmdHis'
    }, {
        name: 'fileNum',
        type: 'string'
    }, {
        name: 'receiveNum',
        type: 'string'
    }],
    init: function(){
        Ext.QuickTips.init();
        if (this.constructor.arguments.length > 0) {
            this.portletId = this.constructor.arguments[0].portletId;
            this.portletTitle = this.constructor.arguments[0].portletTitle;
            this.workType = this.constructor.arguments[0].workType;
            this.compoList = this.constructor.arguments[0].compoList;
        }
    },
    getUrl: function(){
        var arrUrl = this.workType == 'workDoneList' ? this.arrDoneUrl : this.arrTodoUrl;
        var arrUrlTmp = arrUrl.slice(0);
        var url = "";
        if (arrUrlTmp.length > 0) {
            url = arrUrlTmp.shift();
            url += "?workType=" + this.workType + "&token=" + token + "&compoList=" + this.compoList;
        }
        return url;
    },
    getColumnModel: function(){
        var colmodel;
        if (this.compoList == 'OA_RECEIVE_FILE') {
            if (this.workType == 'workDoneList') {//收文已办
                colmodel = new Ext.grid.ColumnModel([{
                    header: '',
                    dataIndex: 'lamp',
                    renderer: this.getWfStatusLamp,
                    width: 25
                }, {
                    header: '收文编号',
                    dataIndex: 'fileNum',
                    id: 'fileNum',
                    width: 100,
                    sortable: true
                }, {
                    header: '标题',
                    dataIndex: 'title',
                    id: 'title',
                    sortable: true,
                    renderer: function(value){
                        return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                    }
                }, {
                    header: '单位名称',
                    dataIndex: 'coName',
                    id: 'coName',
                    width: 100,
                    sortable: true
                }, {
                    header: '来文字号',
                    dataIndex: 'receiveNum',
                    id: 'receiveNum',
                    width: 100,
                    sortable: true
                }, {
                    header: '紧急度',
                    dataIndex: 'urgencyGrade',
                    id: 'urgencyGrade',
                    width: 50,
                    sortable: true
                }, {
                    header: '办理时间',
                    dataIndex: 'wfExecuteTime',
                    id: 'wfExecuteTime',
                    width: 100,
                    renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                    sortable: true
                }]);
            }
            else {//------------收文待办
                colmodel = new Ext.grid.ColumnModel([{
                    header: '',
                    dataIndex: 'lamp',
                    renderer: this.getWfStatusLamp,
                    width: 25
                }, {
                    header: '标题',
                    dataIndex: 'title',
                    id: 'title',
                    sortable: true,
                    renderer: function(value){
                        return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                    }
                }, {
                    header: '单位名称',
                    dataIndex: 'coName',
                    id: 'coName',
                    width: 100,
                    sortable: true
                }, {
                    header: '紧急度',
                    dataIndex: 'urgencyGrade',
                    id: 'urgencyGrade',
                    width: 50,
                    sortable: true
                }, {
                    header: '摘要',
                    dataIndex: 'brief',
                    id: 'brief',
                    hidden: true,
                    sortable: true
                }, {
                    header: '发送人',
                    dataIndex: 'wfCreatorName',
                    id: 'wfCreatorName',
                    width: 50,
                    sortable: true
                }, {
                    header: '发送时间',
                    dataIndex: 'wfCreateTime',
                    id: 'wfCreateTime',
                    width: 100,
                    renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                    sortable: true
                }]);
            }
        }
        else 
            if (this.compoList == 'OA_DISPATCH_FILE') {
                if (this.workType == 'workDoneList') {//发文已办
                    colmodel = new Ext.grid.ColumnModel([{
                        header: '',
                        dataIndex: 'lamp',
                        renderer: this.getWfStatusLamp,
                        width: 25
                    }, {
                        header: '发文编号',
                        dataIndex: 'fileNum',
                        id: 'fileNum',
                        width: 100,
                        sortable: true
                    }, {
                        header: '标题',
                        dataIndex: 'title',
                        id: 'title',
                        sortable: true,
                        renderer: function(value){
                            return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                        }
                    }, {
                        header: '科室名称',
                        dataIndex: 'orgName',
                        id: 'orgName',
                        width: 100,
                        sortable: true
                    }, {
                        header: '紧急度',
                        dataIndex: 'urgencyGrade',
                        id: 'urgencyGrade',
                        width: 50,
                        sortable: true
                    }, {
                        header: '办理时间',
                        dataIndex: 'wfExecuteTime',
                        id: 'wfExecuteTime',
                        width: 100,
                        renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                        sortable: true
                    }]);
                }
                else {//----------------------------发文待办
                    colmodel = new Ext.grid.ColumnModel([{
                        header: '',
                        dataIndex: 'lamp',
                        renderer: this.getWfStatusLamp,
                        width: 25
                    }, {
                        header: '标题',
                        dataIndex: 'title',
                        id: 'title',
                        sortable: true,
                        renderer: function(value){
                            return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                        }
                    }, {
                        header: '科室名称',
                        dataIndex: 'orgName',
                        id: 'orgName',
                        width: 100,
                        sortable: true
                    }, {
                        header: '紧急度',
                        dataIndex: 'urgencyGrade',
                        id: 'urgencyGrade',
                        width: 50,
                        sortable: true
                    }, {
                        header: '摘要',
                        dataIndex: 'brief',
                        id: 'brief',
                        hidden: true,
                        sortable: true
                    }, {
                        header: '发送人',
                        dataIndex: 'wfCreatorName',
                        id: 'wfCreatorName',
                        width: 50,
                        sortable: true
                    }, {
                        header: '发送时间',
                        dataIndex: 'wfCreateTime',
                        id: 'wfCreateTime',
                        width: 100,
                        renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                        sortable: true
                    }]);
                }
            }
            else {
                if (this.workType == 'workDoneList') {//其他已办
                    colmodel = new Ext.grid.ColumnModel([{
                        header: '',
                        dataIndex: 'lamp',
                        renderer: this.getWfStatusLamp,
                        width: 25
                    }, {
                        header: '标题',
                        dataIndex: 'compoName',
                        id: 'title',
                        sortable: true,
                        renderer: function(value){
                            return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                        }
                    }, {
                        header: '单位名称',
                        dataIndex: 'coName',
                        id: 'coName',
                        width: 100,
                        sortable: true
                    }, {
                        header: '科室名称',
                        dataIndex: 'orgName',
                        id: 'orgName',
                        width: 100,
                        sortable: true
                    }, {
                        header: '紧急度',
                        dataIndex: 'urgencyGrade',
                        id: 'urgencyGrade',
                        width: 50,
                        sortable: true
                    }, {
                        header: '办理时间',
                        dataIndex: 'wfExecuteTime',
                        id: 'wfExecuteTime',
                        width: 100,
                        renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                        sortable: true
                    }]);
                }
                else {//---------------------------其他待办
                    colmodel = new Ext.grid.ColumnModel([{
                        header: '',
                        dataIndex: 'lamp',
                        renderer: this.getWfStatusLamp,
                        width: 25
                    }, {
                        header: '标题',
                        dataIndex: 'compoName',
                        id: 'title',
                        sortable: true,
                        renderer: function(value){
                            return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                        }
                    }, {
                        header: '单位名称',
                        dataIndex: 'coName',
                        id: 'coName',
                        width: 100,
                        sortable: true
                    }, {
                        header: '科室名称',
                        dataIndex: 'orgName',
                        id: 'orgName',
                        width: 100,
                        sortable: true
                    }, {
                        header: '紧急度',
                        dataIndex: 'urgencyGrade',
                        id: 'urgencyGrade',
                        width: 50,
                        sortable: true
                    }, {
                        header: '摘要',
                        dataIndex: 'brief',
                        id: 'brief',
                        hidden: true,
                        sortable: true
                    }, {
                        header: '发送人',
                        dataIndex: 'wfCreatorName',
                        id: 'wfCreatorName',
                        width: 50,
                        sortable: true
                    }, {
                        header: '发送时间',
                        dataIndex: 'wfCreateTime',
                        id: 'wfCreateTime',
                        width: 100,
                        renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                        sortable: true
                    }]);
                }
            }
        return colmodel;
    },
    getWfStatusLamp: function(value){
        if (this.workType == 'workTodoList') {
            if (value == '2') {
                return '<a href= "#" class= "work-grid-flag-remind"> </a>';
            }
            else 
                if (value == '3') {
                    return '<a href= "#" class= "work-grid-flag-expired"> </a>';
                }
                else {
                    return '<a href= "#" class= "work-grid-flag-normal"> </a>';
                }
        }
        else {
            return '<a href= "#" class= "work-grid-flag-invalid"> </a>';
        }
    },
    passParam: function(jsonParam){
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
        if (Boolean(jsonParam.record_size) && jsonParam.record_size > 0) {
            this.rowNum = jsonParam.record_size;
        }
        var pThis = this;
        this.pageId = jsonParam.page_id;
        
        var url = this.getUrl();
        var storePart = new Ext.data.Store({
            autoLoad: true,
            proxy: new Ext.data.HttpProxy({
                url: url
            }),
			baseParams: {
				start: 0,
                limit: pThis.rowNum
			},
            reader: new Ext.data.JsonReader({
                totalProperty: 'totalCount',
                root: 'dataList'
            }, pThis.recordType)
        });
        
        if (pThis.workType == 'workTodoList') {
            storePart.setDefaultSort('wfCreateTime', 'desc');//默认数据排序
        }
        else 
            if (pThis.workType == 'workDoneList') {
                storePart.setDefaultSort('wfExecuteTime', 'desc');//默认数据排序
            }
        
        var templateMater = new Ext.Template('<div class="x-grid3" hidefocus="true">', '<div class="x-grid3-viewport">', '<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset">{header}</div></div><div class="x-clear"></div></div>', '<div class="x-grid3-scroller work-grid-body" ><div class="x-grid3-body">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>', "</div>", '<div class="x-grid3-resize-marker">&#160;</div>', '<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");
        templateHeader = new Ext.Template('<table border="0" cellspacing="0" cellpadding="0" style="{tstyle}">', '<thead><tr class="x-grid3-hd-row work-grid-header">{cells}</tr></thead>', "</table>");
        var templates1 = {};
        templates1.master = templateMater;
        templates1.header = templateHeader;
        var colM = this.getColumnModel();
        this.gridPart = new Ext.grid.GridPanel({
            autoScroll: true,
			id: pThis.compoList + "_" + pThis.workType,
            title: '',
            cm: colM,
            store: storePart,
            resizable: true,
            bodyStyle: 'width:100%',
            autoWidth: true,
            autoHeight: true,
            autoExpandColumn: 'title',
            viewConfig: {
                forceFit: false,
                scrollOffset: 2,
                templates: templates1
            }
        });
        // grid双击事件
        this.gridPart.on("rowclick", function(grid){
            var record = grid.getSelectionModel().getSelected();
            if (!record) {
                return;
            }
            pThis.showWin(record.get('url'));
        })
        var toolStyle1 = {};
        if (!Ext.isEmpty(jsonParam.title_bg_img)) {
            toolStyle1['background'] = 'url(html/themes/' + jsonParam.theme + '/' + jsonParam.title_bg_img + ')';
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
        pThis.panel = new Ext.PanelUF({
            title: pThis.portletTitle,
            toolStyle: toolStyle1,
            tools: [{
                qtip: '更多信息......',
                id: 'more',
                handler: function(e, target, panel){
                    pThis.openMoreInfoWin(templates1);
                }
            }, {
                qtip: '刷新数据',
                id: 'refresh',
                handler: function(e, target, panel){
                    pThis.gridPart.getStore().reload();
                }
            }],
            border: false,
            autoScroll: true,
            headerdblClick: function(){
                pThis.openMoreInfoWin(templates1);
            },
            items: [pThis.gridPart]
        });
		this.loadNum = 0;
		pThis.gridPart.getStore().on('load',function(){
			if (pThis.loadNum < 1 && pThis.gridPart.getStore().data.items.length == 0) {
				pThis.loadNum += 1;
				pThis.gridPart.getStore().reload();
			}
		})
		
    },
    openMoreInfoWin: function(templates){
        var pageSize = 50;
        var pThis = this;
        if (!this.gridWorkApp) {
            // 创建复选框的列
            var smWorkApp = new Ext.grid.CheckboxSelectionModel();
            // 创建grid的列信息
            var colsWorkApp = this.getColumnModel();
            var url = this.getUrl();
            var dsGrid = new Ext.data.Store({
                proxy: new Ext.data.HttpProxy({
                    url: url
                }),
                reader: new Ext.data.JsonReader({
                    totalProperty: 'totalCount',
                    root: 'dataList'
                }, this.recordType),
                listeners: {
                    beforeload: function(){
                        pThis.showSaveProgressBar('正在加载数据，请稍后...');
                    },
                    load: function(){
                        pThis.hideSaveProgressBar();
                    }
                }
            });
            dsGrid.load({
                params: {
                    start: 0,
                    limit: pageSize
                },
                callback: function(){
                    pThis.hideSaveProgressBar();
                }
            });
            if (this.workType == 'workTodoList') {
                dsGrid.setDefaultSort('wfCreateTime', 'desc');//默认数据排序
            }
            else 
                if (this.workType == 'workDoneList') {
                    dsGrid.setDefaultSort('wfExecuteTime', 'desc');//默认数据排序
                }
            // 创建页面信息工具栏
            var barWorkApp = new Ext.PagingToolbar({
                pageSize: pageSize,
                store: dsGrid,
                items: ['-', {
                    tooltip: '搜索',
                    iconCls: 'new-tab',
                    icon: '/style/img/gp5/ico/watch_g.jpg',
                    handler: function(){
                        pThis.searchWorkList(dsGrid);
                    }
                }],
                displayInfo: true,
                displayMsg: '显示第 {0} 条到 {1} 条数据，共 {2} 条',
                emptyMsg: '没有数据'
            })
            // 创建编辑Grid
            this.gridWorkApp = new Ext.grid.GridPanel({
                ds: dsGrid,
                cm: colsWorkApp,
                sm: smWorkApp,
                autoExpandColumn: 'title',
                resizable: true,
                autoWidth: true,
                bbar: barWorkApp,
                viewConfig: {
                    forceFit: false,
                    templates: templates
                }
            });
            
            // grid双击事件
            this.gridWorkApp.on("rowclick", function(grid){
                var record = grid.getSelectionModel().getSelected();
                if (!record) {
                    return;
                }
                pThis.showWin(record.get('url'));
            })
            
            // more的window
            pThis.winMore = new Ext.Window({
                title: pThis.portletTitle,
                xtype: 'window',
                layout: 'fit',
                modal: false,
                maximizable: true,
                minimizable: true,
                width: 720,
                height: 450,
                plain: true,
                closeAction: 'hide',
                bodyStyle: 'padding:5 5 5 5;',
                items: [pThis.gridWorkApp]
            });
            pThis.winMore.show();
            pThis.showSaveProgressBar('正在加载数据，请稍后...');
        }
        else {
            pThis.winMore.show();
        }
    },
    showWin: function(url){
        if (Ext.isEmpty(url)) 
            return;
        var width = screen.availWidth;
        var height = screen.availHeight;
        window.open(url, 'maxwindow', "top=0,left=0,width=" + width + ",height=" + height +
        ",scrollbars=yes,toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes," +
        "resizable=yes,status=no");
    },
	searchWorkList: function(){
		var pThis = this;
        var searchWin = new Ext.Window({
			title: '搜索',
			modal: true,
            width: 400,
			height: 300,
            bodyStyle: 'padding:5 5 5 5',
            plain: true,
			layout: 'fit',
            closeAction: 'close',
			items: new Ext.form.FormPanel({
				bodyStyle:'padding:10 10 10 10',
				id: 'searchForm',
				items: [{
					xtype: 'fieldset',
					title: '发送时间',
					autoHeight:true,
            		defaults: {width: 200},
            		defaultType: 'datefield',
					items: [{
						fieldLabel: '起始时间',
						id: 'start_time',
                    	name: 'start_time',
						format: 'Y-m-d H:i:s',
						emptyText: '请选择起始时间'
					},{
						fieldLabel: '截止时间',
						id: 'end_time',
                    	name: 'end_time',
						format: 'Y-m-d H:i:s',
						emptyText: '请选择截止时间'
					}]
				},{
					xtype: 'fieldset',
					autoHeight:true,
					title: '其它条件',
            		defaults: {width: 200},
					items: [{
						xtype: 'textfield',
	                    id: 'search_title',
	                    name: 'search_title',
	                    fieldLabel: '标题',
						width: 200
					},{
						xtype: 'textfield',
	                    id: 'search_org',
	                    name: 'search_org',
	                    fieldLabel: (pThis.compoList == 'OA_DISPATCH_FILE')?'科室名称':'单位名称',
						width: 200
					}]
				}],
				buttonAlign: 'center',
				buttons: [{
					text: '搜索',
					handler: function(){
						if (Ext.getCmp('searchForm').getForm().isValid()) {
							var startTime = Ext.getCmp("start_time");
							var endTime = Ext.getCmp("end_time");
							var searchTitle = Ext.getCmp("search_title");
							var searchOrg = Ext.getCmp("search_org");
							var ds = pThis.gridWorkApp.getStore();
							ds.baseParams = {
								startTime: Ext.util.Format.date(startTime.getValue(), 'YmdHis'),
								endTime: Ext.util.Format.date(endTime.getValue(), 'YmdHis'),
								searchTitle: searchTitle.getValue(),
								searchOrg: searchOrg.getValue()
							}
							ds.reload();
							searchWin.close();
						}
					}
				}, {
					text: '重置',
					handler: function(){
						Ext.getCmp('searchForm').getForm().reset();
					}
				}, {
					text: '关闭',
					handler: function(){
						searchWin.close();
					}
				}]
			})
		});
		searchWin.show();
		searchWin.center();
    },
    destroy: function(){
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
