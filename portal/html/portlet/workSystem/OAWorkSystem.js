/**
 * 工作制度频道
 */
ufgov.portal.portlet.OAWorkSystemPortlet = function(){

};
Ext.extend(ufgov.portal.portlet.OAWorkSystemPortlet, ufgov.portal.Base, {
    panel: null,
    portletId: 'workSystem',
    pageId: '',
    showStyleNum: 1,
    portletTitle: '工作制度',
    recordSize: 10,
    passParam: function(jsonParam){
        if (Ext.isEmpty(jsonParam)) {
            alert("请传入必要的参数");
            return;
        }
        if (!Boolean(jsonParam.page_id)) {
            alert("必须存在jsonParam.page_id参数");
            return;
        }
        if (Boolean(jsonParam.portlet_id)) {
            this.portletId = jsonParam.portlet_id;
        }
        if (Boolean(jsonParam.title)) {
            this.portletTitle = jsonParam.title;
        }
        if (!Ext.isEmpty(jsonParam.record_size) && "number" == Ext.type(parseInt(jsonParam.record_size))) {
            this.recordSize = jsonParam.record_size;
        }
        var pThis = this;
        var sm = new Ext.grid.CheckboxSelectionModel();
        var colms = new Ext.grid.ColumnModel([{
            header: '图标',
            dataIndex: 'icon',
            width: 25,
            renderer: function(value){
                return '<a  class= "article-grid-flag"> </a>';
            }
        }, {
            id: 'OATitle',
            header: '标题',
            align: 'left',
            sortable: true,
            dataIndex: 'OATitle',
            renderer: function(value, cellmeta, record, rowIndex, columnIndex, store){
                var time = record.get('OANotifyTime');
                var date = new Date();
                var date1 = time.substring(0, 10);
                var date2 = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
                var diff = pThis.DateDiff(date1, date2);
                if (diff > 1) {
                    return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
                }
                else {
                    return '<a href="javascript:void(null);" class="notify-grid-cell" title="' + value + '" >' + value + '</a>';
                }
                
            }
        }, {
            id: 'OANotifyTime',
            header: '发布时间',
            align: 'left',
            width: 80,
            sortable: true,
            dataIndex: 'OANotifyTime',
            renderer: function(value){
                return value.substring(0, 10);
            }
        }]);
        colms.defaultSortable = true;
        var workSystemStore = new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({
                url: 'getPageJsonData.action'
            }),
            baseParams: {
                ruleID: 'portlet-info.getWorkSystemData',
                oaNotifyState: '1'
            },
            reader: new Ext.data.JsonReader({
                totalProperty: 'totalCount',
                root: 'dataList'
            }, [{
                name: 'OAId',
                mapping: 'oa_id'
            }, {
                name: 'OATitle',
                mapping: 'oa_title'
            }, {
                name: 'OANotifyState',
                mapping: 'oa_notify_state'
            }, {
                name: 'OANotifyTime',
                mapping: 'oa_notify_time'
            }, {
                name: 'OADraftPerson',
                mapping: 'oa_draft_person'
            }, {
                name: 'OADraftPersonName',
                mapping: 'oa_draft_person_name'
            }])
        });
        workSystemStore.load({
            params: {
                start: 0,
                limit: this.recordSize
            }
        });
        var workSystemPanel = new Ext.grid.GridPanel({
            store: workSystemStore,
            cm: colms,
            id: 'workSystem',
            bodyStyle: 'width:100%',
            autoExpandColumn: 'OATitle',
            resizable: true,
            autoWidth: true,
            autoHeight: true,
            frame: false,
            viewConfig: {
                forceFit: false,
                scrollOffset: 2
            }
        });
        this.panel = new Ext.Panel({
            title: this.portletTitle,
            border: false,
            tools: [{
                qtip: '更多信息......',
                id: 'more',
                handler: function(e, target, panel){
                    onOpenAll();
                }
            }],
            headerdblClick: function(){
                //pThis.showMoreInfo();
            },
            items: workSystemPanel
        });
        // grid双击事件
        workSystemPanel.on("rowclick", function(grid){
            var record = grid.getSelectionModel().getSelected();
            if (!record) {
                return;
            }
            var url = "/OA/getpage_OA_WORK_SYSTEM.action?function=geteditpage&componame=OA_WORK_SYSTEM&tablename=OA_WORK_SYSTEM&condition=OA_ID=" + record.get('OAId') + ";txtUserID=" + userId;
            window.open(url, 'maxwindow', 'toolbar=no,location=no,left=0,top=0,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no,width=' + (screen.availWidth - 20) + ',height=' + (screen.availHeight - 10));
        });
        
        // 打开全部数据窗口
        function onOpenAll(){
            var pageSize = 20;
            if (!pThis.gridWorkSystem) {
                // 创建复选框的列
                var smWorkSystem = new Ext.grid.CheckboxSelectionModel();
                
                // 创建grid的列信息
                var colsWorkSystem = new Ext.grid.ColumnModel([smWorkSystem, {
                    header: '标题',
                    dataIndex: 'OATitle',
                    align: 'left',
                    renderer: function(value){
                        return '<div><a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a></div>';
                    },
                    id: 'title'
                }, {
                    header: '通知下发时间',
                    dataIndex: 'OANotifyTime',
                    align: 'left',
                    id: 'OANotifyTime',
                    width: 120,
                    renderer: function(value){
                        return value.substring(0, 10);
                    }
                }, {
                    header: '发布人姓名',
                    dataIndex: 'OADraftPersonName',
                    align: 'left',
                    renderer: function(value){
                        return '<div><a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a></div>';
                    },
                    id: 'OADraftPersonName'
                }]);
                
                var workSystemStore = new Ext.data.Store({
                    proxy: new Ext.data.HttpProxy({
                        url: 'getPageJsonData.action'
                    }),
                    baseParams: {
                        ruleID: 'portlet-info.getWorkSystemData',
                        oaNotifyState: '1'
                    },
                    reader: new Ext.data.JsonReader({
                        totalProperty: 'totalCount',
                        root: 'dataList'
                    }, [{
                        name: 'OAId',
                        mapping: 'oa_id'
                    }, {
                        name: 'OATitle',
                        mapping: 'oa_title'
                    }, {
                        name: 'OANotifyState',
                        mapping: 'oa_notify_state'
                    }, {
                        name: 'OANotifyTime',
                        mapping: 'oa_notify_time'
                    }, {
                        name: 'OADraftPerson',
                        mapping: 'oa_draft_person'
                    }, {
                        name: 'OADraftPersonName',
                        mapping: 'oa_draft_person_name'
                    }])
                });
				workSystemStore.load({
		            params: {
		                start: 0,
		                limit: pageSize
		            }
		        });
                
                // 创建页面信息工具栏
                var barWorkSystem = new Ext.PagingToolbar({
                    pageSize: pageSize,
                    store: workSystemStore,
                    displayInfo: true,
                    displayMsg: '显示第 {0} 条到 {1} 条数据，共 {2} 条',
                    emptyMsg: '没有数据'
                })
                
                // 创建编辑Grid
                pThis.gridWorkSystem = new Ext.grid.GridPanel({
                    ds: workSystemStore,
                    cm: colsWorkSystem,
                    sm: smWorkSystem,
                    autoExpandColumn: 'title',
                    resizable: true,
                    autoWidth: true,
                    //hideHeaders : true,
                    viewConfig: {
                        forceFit: false
                        //templates: templates1
                    },
                    bbar: barWorkSystem
                });
                
                // grid双击事件rowclick
                pThis.gridWorkSystem.on('rowclick', function(grid){
                    var record = grid.getSelectionModel().getSelected();
                    if (!record) {
                        return;
                    }
                    var url = "/OA/getpage_OA_WORK_SYSTEM.action?function=geteditpage&componame=OA_WORK_SYSTEM&tablename=OA_WORK_SYSTEM&condition=OA_ID=" + record.get('OAId') + ";txtUserID=" + userId;
                    window.open(url, 'maxwindow', 'toolbar=no,location=no,directories=no,left=0,top=0,menubar=no,scrollbars=yes,resizable=yes,status=no,width=' + (screen.availWidth - 20) + ',height=' + (screen.availHeight - 10));
                })
                
                // more的window
                pThis.winMore = new Ext.Window({
                    title: pThis.portletTitle,
                    xtype: 'window',
                    layout: 'fit',
                    modal: false,
                    maximizable: true,
                    minimizable: true,
                    width: 650,
                    height: 500,
                    plain: true,
                    closeAction: 'hide',
                    bodyStyle: 'padding:5 5 5 5;text-align:left;',
                    items: [pThis.gridWorkSystem]
                });
            }
            pThis.winMore.show();
        }
    }
    
});
