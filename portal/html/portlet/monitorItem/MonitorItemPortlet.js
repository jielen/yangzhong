/**
 * 督办事项频道
 */
ufgov.portal.portlet.MonitorItemPortlet = function(){

};
Ext.extend(ufgov.portal.portlet.MonitorItemPortlet, ufgov.portal.Base, {
    panel: null,
    portletId: 'fileBox',
    pageId: '',
    showStyleNum: 1,
    portletTitle: '公文箱',
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
            id: 'fileTitle',
            header: '标题',
            align: 'center',
            sortable: true,
            dataIndex: 'fileTitle',
            renderer: function(value){
                return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
            }
        }, {
            id: 'classId',
            header: '公文类别',
            align: 'center',
            width: 80,
            sortable: true,
            dataIndex: 'className'
        }, {
            id: 'fileStatus',
            header: '状态',
            align: 'center',
            width: 50,
            sortable: true,
            dataIndex: 'fileStatus',
            renderer: function(value){
            
            }
        }]);
        colms.defaultSortable = true;
        var fileBoxStore = new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({
                url: 'getPageJsonData.action'
            }),
            baseParams: {
                ruleID: 'portlet-info.getFileBoxData',
                userId: userId,
                oaFileType: '02'
            },
            reader: new Ext.data.JsonReader({
                totalProperty: 'totalCount',
                root: 'dataList'
            }, [{
                name: 'fileBoxId',
                mapping: 'id'
            }, {
                name: 'fileTitle',
                mapping: 'file_title'
            }, {
                name: 'classId',
                mapping: 'class_id'
            }, {
                name: 'fileUrl',
                mapping: 'file_url'
            }, {
                name: 'className',
                mapping: 'class_name'
            }, {
                name: 'fileStatus',
                mapping: 'file_status'
            }])
        });
        fileBoxStore.load({
            params: {
                start: 0,
                limit: this.recordSize
            }
        });
        var fileBoxPanel = new Ext.grid.GridPanel({
            store: fileBoxStore,
            cm: colms,
            id: 'fileBox',
            bodyStyle: 'width:100%',
            autoExpandColumn: 'fileTitle',
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
                    window.open("portletDispatcher.action?function=monitorItem", "new", "left=0px,top=0px,width=" + (screen.availWidth - 10) + ",height=" + (screen.availHeight) + ",menubar=no,scrollbars=no,status=no,toolbar=no,resizable=no");
                }
            }],
            headerdblClick: function(){
                //pThis.showMoreInfo();
            },
            items: fileBoxPanel
        });
        // grid双击事件
        fileBoxPanel.on("rowdblclick", function(grid){
            var record = grid.getSelectionModel().getSelected();
            if (!record) {
                return;
            }
            window.open(record.get('fileUrl'), 'maxwindow', 'toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no');
        });
    }
    
});


