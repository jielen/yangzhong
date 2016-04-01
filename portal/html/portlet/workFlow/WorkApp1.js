/**
 * 变量workApp与工作频道ID必须一致，在主程序中调用
 */
ufgov.portal.portlet.WorkApp = Ext.extend(ufgov.portal.Base, {
    panel: null,
    gridPart: null,
    gridWorkApp: null,
    portletId: 'workTodo',
    pageId: '',
    portletTitle: '代办工作',
    workType: 'workDoneList',
    /**
     * 配置待办已办等是否按部件ID进行分组，形如：
     * isGroup: true 按部件分组
     * isGroup: false 不按部件分组
     * 也可以通过构造函数中传参数isGroup来配置
     */
    isGroup: true,
    
    winMore: null,
    rowNum: 20,
    winDetail: null,
    arrDoneUrl: ['/admin/getWorklist.action'],
    arrTodoUrl: ['/admin/getWorklist.action'],
    compoList: '',
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
		name: 'compoSize',
		type: 'string'
	}],
    
    init: function(){
        Ext.QuickTips.init();
        if (this.constructor.arguments.length > 0) {
            this.portletId = this.constructor.arguments[0].portletId;
            this.portletTitle = this.constructor.arguments[0].portletTitle;
            this.workType = this.constructor.arguments[0].workType;
            if (!Ext.isEmpty(this.constructor.arguments[0].isGroup)) {
                this.isGroup = this.constructor.arguments[0].isGroup;
            }
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
        var pThis = this;
        if (pThis.workType == 'workTodoList') {
            colmodel = new Ext.grid.ColumnModel([{
                header: '',
                dataIndex: 'lamp',
                renderer: pThis.getWfStatusLamp,
                width: 25,
                sortable: false
            }, {
                header: '标题',
                dataIndex: 'title',
                renderer: function(value){
                    return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                },
                width: 130,
                id: 'title',
                sortable: true
            }, {
                header: '摘要',
                dataIndex: 'brief',
                id: 'brief',
                sortable: true
            }, {
                header: '单据',
                dataIndex: 'compoName',
                width: 130,
                sortable: true
            }, {
                header: '发送人',
                dataIndex: 'wfCreatorName',
                id: 'wfCreatorName',
                width: 80,
                sortable: true
            }, {
                header: '发送时间',
                dataIndex: 'wfCreateTime',
                id: 'wfCreateTime',
                width: 100,
                renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                sortable: true
            }])
        }
        else if (pThis.workType == 'workDoneList') {
            colmodel = new Ext.grid.ColumnModel([{
                header: '',
                dataIndex: 'lamp',
                renderer: pThis.getWfStatusLamp,
                width: 25,
                sortable: false
            }, {
                header: '标题',
                dataIndex: 'title',
                renderer: function(value){
                    return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                },
                width: 130,
                id: 'title',
                sortable: true
            }, {
                header: '摘要',
                dataIndex: 'brief',
                id: 'brief',
                sortable: true
            }, {
                header: '单据',
                dataIndex: 'compoName',
                width: 170,
                sortable: true
            }, {
                header: '办理时间',
                dataIndex: 'wfExecuteTime',
                id: 'wfExecuteTime',
                width: 100,
                renderer: Ext.util.Format.dateRenderer('Y-m-d H:i'),
                sortable: true
            }])
        }
        else {
            colmodel = new Ext.grid.ColumnModel([{
                header: '',
                dataIndex: 'lamp',
                renderer: pThis.getWfStatusLamp,
                width: 25,
                sortable: false
            }, {
                header: '标题',
                dataIndex: 'title',
                renderer: function(value){
                    return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                },
                width: 130,
                id: 'title',
                sortable: true
            }, {
                header: '摘要',
                dataIndex: 'brief',
                id: 'brief',
                sortable: true
            }, {
                header: '单据',
                dataIndex: 'compoName',
                width: 170,
                sortable: true
            }])
        }
        if (this.isGroup) {
            colmodel.config[colmodel.config.length] = {
                hidden: true,
                dataIndex: 'compoId',
                groupRenderer: function(v, o, r, rowIndex, colIndex, store){
                    return r.get('compoName');
                }
            }
        }
        return colmodel;
    },
    getGridStore: function(){
        var store;
        var pThis = this;
        if (this.isGroup) {
            store = new Ext.data.GroupingStore({
                proxy: new Ext.data.HttpProxy({
                    url: pThis.getUrl()
                }),
                reader: new Ext.data.JsonReader({
                    totalProperty: 'totalCount',
                    root: 'dataList'
                }, pThis.recordType),
                sortInfo: {
                    field: 'compoId',
                    direction: "ASC"
                },
                groupField: 'compoId'
            });
        }
        else {
            store = new Ext.data.Store({
                proxy: new Ext.data.HttpProxy({
                    url: pThis.getUrl()
                }),
                reader: new Ext.data.JsonReader({
                    totalProperty: 'totalCount',
                    root: 'dataList'
                }, pThis.recordType)
            });
        }
        return store;
    },
    passParam: function(jsonParam){
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
        
        if (Boolean(jsonParam.record_size) && jsonParam.record_size > 0) {
            this.rowNum = jsonParam.record_size;
        }
        
        this.pageId = jsonParam.page_id;
        
        var storePart = this.getGridStore();
        storePart.load({
            params: {
                start: 0,
                limit: pThis.rowNum
            }
        });
        
        if (pThis.workType == 'workTodoList') {
            storePart.setDefaultSort('wfCreateTime', 'desc');//默认数据排序
        }
        else if (pThis.workType == 'workDoneList') {
            storePart.setDefaultSort('wfExecuteTime', 'desc');//默认数据排序
        }
        
        var templateMater = new Ext.Template('<div class="x-grid3" hidefocus="true">', '<div class="x-grid3-viewport">', '<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset">{header}</div></div><div class="x-clear"></div></div>', '<div class="x-grid3-scroller work-grid-body" ><div class="x-grid3-body">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>', "</div>", '<div class="x-grid3-resize-marker">&#160;</div>', '<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");
        
        templateHeader = new Ext.Template('<table border="0" cellspacing="0" cellpadding="0" style="{tstyle}">', '<thead><tr class="x-grid3-hd-row work-grid-header">{cells}</tr></thead>', "</table>");
        
        var templates1 = {};
        templates1.master = templateMater;
        templates1.header = templateHeader;
        
        
        var colM = pThis.getColumnModel();
        pThis.gridPart = new Ext.grid.GridPanel({
            autoScroll: true,
            title: '',
            cm: colM,
            ds: storePart,
            resizable: true,
            bodyStyle: 'width:100%',
            autoWidth: true,
            autoHeight: true,
            autoExpandColumn: 'brief'
        });
        
        if (pThis.isGroup) {
            pThis.gridPart.view = new Ext.grid.GroupingView({
                forceFit: true,
                scrollOffset: 2,
                templates: templates1,
                showGroupName: false,
				startCollapsed: true,
                groupTextTpl: '{text} ({[values.rs[0].get("compoSize")]} "项")'
            });
        }
        else {
            pThis.gridPart.viewConfig = {
                forceFit: true,
                scrollOffset: 2,
                templates: templates1
            };
        }
        
        // grid双击事件
        pThis.gridPart.on("rowclick", function(grid){
            var record = grid.getSelectionModel().getSelected();
            if (!record) {
                return;
            }
            pThis.showWin(record.get('url'));
        })
        
        var toolStyle1 = {};
        if (!Ext.isEmpty(jsonParam.title_bg_img)) {
            toolStyle1['background'] = 'url(html/themes/' + jsonParam.theme +
            '/' +
            jsonParam.title_bg_img +
            ')';
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
            title: pThis.portletTitle,
            toolStyle: toolStyle1,
            tools: [{
                qtip: '更多信息......',
                id: 'restore',
                handler: function(e, target, panel){
                    pThis.onOpenAll(templates1);
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
                pThis.onOpenAll(templates1);
            },
            items: [pThis.gridPart]
        });
        
        this.loadNum = 0;
        pThis.gridPart.getStore().on('load', function(){
            if (pThis.loadNum < 1 && pThis.gridPart.getStore().data.items.length == 0) {
                pThis.loadNum += 1;
                pThis.gridPart.getStore().reload();
            }
        })
    },
    // 打开全部数据窗口
    onOpenAll: function(templates){
        var pageSize = 10;
        var pThis = this;
        if (!pThis.gridWorkApp) {
            var dsGrid = pThis.getGridStore();
            dsGrid.load({
                params: {
                    start: 0,
                    limit: pageSize
                },
                callback: function(){
                    pThis.hideSaveProgressBar();
                }
            });
            dsGrid.on('beforeload', function(){
                pThis.showSaveProgressBar('正在加载数据，请稍后...');
            });
            dsGrid.on('load', function(){
                pThis.hideSaveProgressBar();
            });
            if (pThis.workType == 'workTodoList') {
                dsGrid.setDefaultSort('wfCreateTime', 'desc');//默认数据排序
            }
            else if (pThis.workType == 'workDoneList') {
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
            });
            if (this.isGroup) {
                barWorkApp.displayMsg = '每个部件每页显示 ' + pageSize + ' 条数据，共 {2} 条';
            }
            else {
                barWorkApp.displayMsg = '显示第 {0} 条到 {1} 条数据，共 {2} 条';
            }
            // 创建复选框的列
            var smWorkApp = new Ext.grid.CheckboxSelectionModel();
            // 创建grid的列信息
            var colsWorkApp = this.getColumnModel();
            
            // 创建编辑Grid
            pThis.gridWorkApp = new Ext.grid.GridPanel({
                ds: dsGrid,
                cm: colsWorkApp,
                sm: smWorkApp,
                autoExpandColumn: 'brief',
                resizable: true,
                autoWidth: true,
                bbar: barWorkApp
            });
            
            if (pThis.isGroup) {
                pThis.gridWorkApp.view = new Ext.grid.GroupingView({
                    forceFit: false,
                    templates: templates,
                    showGroupName: false,
					startCollapsed: true,
                    groupTextTpl: '{text} ({[values.rs[0].get("compoSize")]} "项")'
                });
            }
            else {
                pThis.gridWorkApp.viewConfig = {
                    forceFit: false,
                    templates: templates
                };
            }
            
            // grid双击事件
            pThis.gridWorkApp.on("rowdblclick", function(grid){
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
                width: 680,
                height: 450,
                plain: true,
                closeAction: 'hide',
                bodyStyle: 'padding:5 5 0 5;',
                items: [pThis.gridWorkApp]
            });
        }
        pThis.winMore.show();
        
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
                bodyStyle: 'padding:10 10 10 10',
                id: 'searchForm',
                items: [{
                    xtype: 'fieldset',
                    title: '发送时间',
                    autoHeight: true,
                    defaults: {
                        width: 200
                    },
                    defaultType: 'datefield',
                    items: [{
                        fieldLabel: '起始时间',
                        id: 'start_time',
                        name: 'start_time',
                        format: 'Y-m-d H:i:s',
                        emptyText: '请选择起始时间'
                    }, {
                        fieldLabel: '截止时间',
                        id: 'end_time',
                        name: 'end_time',
                        format: 'Y-m-d H:i:s',
                        emptyText: '请选择截止时间'
                    }]
                }],
                buttonAlign: 'center',
                buttons: [{
                    text: '搜索',
                    handler: function(){
                        if (Ext.getCmp('searchForm').getForm().isValid()) {
                            var startTime = Ext.getCmp("start_time");
                            var endTime = Ext.getCmp("end_time");
                            var ds = pThis.gridWorkApp.getStore();
                            ds.baseParams = {
                                startTime: Ext.util.Format.date(startTime.getValue(), 'YmdHis'),
                                endTime: Ext.util.Format.date(endTime.getValue(), 'YmdHis')
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
    
    showWin: function(url){
        if (Ext.isEmpty(url)) return;
        //url1='http://chenhonghuaibm:8001'+url1;
        window.open(url, 'maxwindow', "top=0,left=0,width=" + screen.availWidth + ",height=" + screen.availHeight + ",scrollbars=yes,toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
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
    },
    getWfStatusLamp: function(value){
        //if  thiss.workType =='workTodoList')  {
        if (value == '2') {
            return '<a   href= "#"     class= "work-grid-flag-remind"> </a>';
        }
        else if (value == '3') {
            return '<a   href= "#"     class= "work-grid-flag-expired"> </a>';
        }
        else {
            return '<a   href= "#"     class= "work-grid-flag-normal"> </a>';
        }
        //} else  {
        //  	return '<a   href= "#"     class= "work-grid-flag-invalid"> </a>';
        //}
    }
    
});
