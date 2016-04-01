/**
 * 公文箱频道
 */
ufgov.portal.portlet.FileReadPortlet = function(){

};
Ext.extend(ufgov.portal.portlet.FileReadPortlet, ufgov.portal.Base, {
    panel: null,
    portletId: 'fileRead',
    pageId: '',
    showStyleNum: 1,
    portletTitle: '局内来文',
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
            header: '',
            dataIndex: 'lamp',
            width: 25,
            renderer: function(v){
                return '<a href= "#" class= "fileReadClass"> </a>';
            }
        }, {
            id: 'fileTitle',
            header: '标题',
            align: 'center',
            sortable: true,
            dataIndex: 'fileTitle',
            renderer: function(value, cellmeta, record, rowIndex, columnIndex, store){
                var time = record.get('fileTime');
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
            id: 'fileTime',
            header: '发送日期',
            align: 'center',
            width: 100,
            sortable: true,
            dataIndex: 'fileTime',
			renderer: function(v){
				return v.substring(0, 10);
			}
        }]);
        colms.defaultSortable = true;
        var fileBoxStore = new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({
                url: 'getPageJsonData.action'
            }),
            baseParams: {
                ruleID: 'portlet-info.getFileReadData',
                userId: userId,
                isWatch: 'N',
                messageType: '文件传阅'
            },
            reader: new Ext.data.JsonReader({
                totalProperty: 'totalCount',
                root: 'dataList'
            }, [{
                name: 'id',
                mapping: 'oa_number'
            }, {
                name: 'fileTitle',
                mapping: 'oa_title'
            }, {
                name: 'fileUrl',
                mapping: 'oa_url'
            }, {
                name: 'fileTime',
                mapping: 'oa_send_time'
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
                    window.open("portletDispatcher.action?function=fileRead", "new", "left=0px,top=0px,width=800,height=600,menubar=no,scrollbars=no,status=no,toolbar=no,resizable=yes");
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
            pThis.updateReadFile(record.get('id'));
            var url = "/OA/getpage_OA_MESSAGE_FOR_SENDWORD.action?function=geteditpage&componame=OA_MESSAGE_FOR_SENDWORD&tablename=OA_MESSAGE_ACCEPTMEN&condition=OA_NUMBER=" + record.get('id');
            window.open(url, 'maxwindow', 'toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no,width=' + (screen.availWidth - 20) + ',height=' + (screen.availHeight - 10));
        });
    },
    updateReadFile: function(id){
        Ext.Ajax.request({
            url: 'doBasicOper.action',
            params: {
                ruleID: 'portlet-info.updateFileReadData',
                fileId: id,
                action: 'update'
            }
        })
    }
});

