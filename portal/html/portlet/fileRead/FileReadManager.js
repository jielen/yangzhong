/**
 * 文件传阅管理器
 */
ufgov.portal.portlet.FileReadManager = function(){

};
Ext.extend(ufgov.portal.portlet.FileReadManager, ufgov.portal.Base, {
    createMainFrame: function(){
        var treeMenu = this.getFileClass();
        //debugger;
        new Ext.Viewport({
            layout: 'border',
            items: [{
                region: 'west',
                id: 'fileBoxMenu',
                title: '当前用户：<font color="#ff0000">' + userName + '</font>',
                split: true,
                width: 180,
                minSize: 150,
                maxSize: 300,
                collapsible: true,
                margins: '5 0 0 0',
                items: [treeMenu]
            }, {
                region: 'center',
                margins: '5 0 0 0',
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
    getFileClass: function(){
        var pThis = this;
        var noReadFile = new Ext.tree.TreeNode({
            id: 'noReadFile',
            text: '未读文件',
            leaf: true,
            isWatch: 'N'
        });
        var readFile = new Ext.tree.TreeNode({
            id: 'readFile',
            text: '已读文件',
            leaf: true,
            isWatch: 'Y'
        });
        var root = new Ext.tree.TreeNode({
            id: 'root',
            text: '根结点'
        });
        root.appendChild(noReadFile);
        root.appendChild(readFile);
        var fileClassTree = new Ext.tree.TreePanel({
            id: 'treePanel',
            xtype: 'treepanel',
            border: false,
            autoScroll: true,
            split: true,
            useArrows: true,
            loader: new Ext.tree.TreeLoader({}),
            rootVisible: false,
            root: root,
            listeners: {
                click: function(node){
                    pThis.getFileReadData(node, userId);
                }
            }
        });
        return fileClassTree;
    },
    getFileReadData: function(node, userId){
		var pageSize = 20;
        var sm = new Ext.grid.CheckboxSelectionModel();
        var colms = new Ext.grid.ColumnModel([sm, {
            id: 'fileTitle',
            header: '标题',
            align: 'center',
            sortable: true,
            dataIndex: 'fileTitle',
            renderer: function(value){
                return '<div><a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a></div>';
            }
        }, {
            id: 'fileTime',
            header: '发送日期',
            align: 'center',
            width: 100,
            sortable: true,
            dataIndex: 'fileTime'
        }]);
        colms.defaultSortable = true;
        var fileReadStore = new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({
                url: 'getPageJsonData.action'
            }),
            baseParams: {
                ruleID: 'portlet-info.getFileReadData',
                userId: userId,
                isWatch: node.attributes.isWatch,
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
		fileReadStore.load({
            params: {
                start: 0,
                limit: pageSize
            }
        });
        var fileReadGridPanel = new Ext.grid.GridPanel({
            store: fileReadStore,
            cm: colms,
            sm: sm,
            id: 'fileRead',
            autoExpandColumn: 'fileTitle',
            resizable: true,
            autoWidth: true,
            border: false,
            viewConfig: {
                forceFit: false,
                scrollOffset: 2
            },
            listeners: {
                cellclick: function(grid, rowIndex, cellIndex, event){
                    if (cellIndex == 1) {
                        var record = grid.getSelectionModel().getSelected();
                        if (!record) {
                            return;
                        }
                        FileReadManager.updateReadFile(record.get('id'));
                        var url = "/OA/getpage_OA_MESSAGE_FOR_SENDWORD.action?function=geteditpage&componame=OA_MESSAGE_FOR_SENDWORD&tablename=OA_MESSAGE_ACCEPTMEN&condition=OA_NUMBER=" + record.get('id');
                        window.open(url, 'maxwindow', 'toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no,width=' + (screen.availWidth - 20) + ',height=' + (screen.availHeight - 10));
                    }
                }
            }
        });
        var fileReadFooter = new Ext.PagingToolbar({
            pageSize: pageSize,
            store: fileReadStore,
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条数据，共 {2} 条',
            emptyMsg: '没有数据',
            items: ['-', {
                tooltip: '刪除局内来文信息',
                iconCls: 'new-tab',
                icon: '/style/img/gp5/ico/delete_style_g.jpg',
                handler: function(){
                    var selections = fileReadGridPanel.getSelectionModel().getSelections();
                    if (selections.length === 0) {
                        alert("请选择要删除的记录！");
                        return;
                    }
                    Ext.Msg.confirm('系統提示', '确认删除吗?(注意,该删除不可恢复！)', function(btn){
                        if (btn != 'yes') 
                            return;
                        var jsonDelArr = "";
                        for (var i = 0; i < selections.length; i++) {
                            var record = selections[i];
                            if (!Ext.isEmpty(jsonDelArr)) {
                                jsonDelArr += ',';
                            }
                            jsonDelArr += record.get('id');
                        }
                        Ext.Ajax.request({
                            url: 'deleteFileBox.action',
                            params: {
                                ruleID: 'portlet-info.deleteFileReadData',
                                fileBoxIds: jsonDelArr
                            },
                            callback: function(option, success, response){
                                if (success) {
                                    var result = Ext.util.JSON.decode(response.responseText);
                                    FileReadManager.showMsg('温馨提示', result.sign);
                                    fileReadStore.reload();
                                }
                            }
                        });
                    });
                }
            }]
        });
        new Ext.Panel({
            border: false,
            layout: 'fit',
            applyTo: 'fileMainPanel',
            items: {
                border: false,
                layout: 'fit',
                items: fileReadGridPanel,
                bbar: fileReadFooter
            }
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
var FileReadManager = new ufgov.portal.portlet.FileReadManager();

Ext.onReady(function(){
    Ext.QuickTips.init();
    FileReadManager.createMainFrame();
});
