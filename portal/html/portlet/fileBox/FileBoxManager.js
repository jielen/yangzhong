/**
 * 公文箱管理器
 */
var currentNode;
var showStyleNum = '1';
ufgov.portal.portlet.FileBoxManager = function(){

};
Ext.extend(ufgov.portal.portlet.FileBoxManager, ufgov.portal.Base, {
    pageInit: function(){
        this.createMainFrame();
        this.createToolBarPanel();
    },
    createMainFrame: function(){
        var sendFileBox = this.getFileClass('sendFile', '发文公文箱', '01', 'pThis.getFileBoxData', userId);
        var receiveFileBox = this.getFileClass('receiveFile', '收文公文箱', '02', 'pThis.getFileBoxData', userId);
        var otherFileBox = this.getFileClass('otherFile', '其他公文箱', '03', 'pThis.getFileBoxData', userId);
        new Ext.Viewport({
            layout: 'border',
            items: [{
                region: 'north',
                contentEl: 'north',
                height: 27,
                items: {
                    border: false,
                    id: 'toolBarPanel',
                    html: '<div id="toolBarPanel"></div>'
                }
            }, new Ext.BoxComponent({
                region: 'south',
                el: 'south',
                height: 20
            }), {
                region: 'west',
                id: 'fileBoxMenu',
                title: '当前用户：<font color="#ff0000">' + userName + '</font>',
                split: true,
                width: 180,
                minSize: 150,
                maxSize: 300,
                collapsible: true,
                margins: '5 0 5 0',
                layout: 'accordion',
                layoutConfig: {
                    animate: true
                },
                items: [receiveFileBox, sendFileBox, otherFileBox]
            }, {
                region: 'center',
                margins: '5 0 5 0',
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
    createToolBarPanel: function(){
        new Ext.Panel({
            border: false,
            applyTo: 'toolBarPanel',
            tbar: [{
                iconCls: 'grid',
                text: '查看',
                tooltip: '选择查看样式',
                menu: {
                    items: [{
                        text: '详细信息',
                        checked: true,
                        group: 'showStyle',
                        checkHandler: function(){
                            FileBoxManager.showStyleClick('1');
                        }
                    }, {
                        text: '平铺',
                        checked: false,
                        group: 'showStyle',
                        checkHandler: function(){
                            FileBoxManager.showStyleClick('2');
                        }
                    }, {
                        text: '列表',
                        checked: false,
                        group: 'showStyle',
                        checkHandler: function(){
                            FileBoxManager.showStyleClick('3');
                        }
                    }, {
                        text: '图标',
                        checked: false,
                        group: 'showStyle',
                        checkHandler: function(){
                            FileBoxManager.showStyleClick('4');
                        }
                    }]
                }
            }]
        });
    },
    showStyleClick: function(num){
        showStyleNum = num;
        if (currentNode) {
            FileBoxManager.getFileBoxData(currentNode, userId);
        }
    },
    getFileClass: function(treeId, treeTitle, rootId, nodeClick, userId){
        var pThis = this;
        var fileClassTree = new Ext.tree.TreePanel({
            id: treeId + '_Panel',
            title: treeTitle,
            xtype: 'treepanel',
            iconCls: 'nav',
            border: false,
            autoScroll: true,
            split: true,
            ddGroup: 'fileBoxGroup',
            enableDD: true,
            singleExpand: true,
            hideCollapseTool: true,
            useArrows: true,
            tools: [{
                id: 'plus',
                qtip: '添加' + treeTitle + '类别...',
                handler: function(event, toolEl, panel){
                    pThis.doFileClass(fileClassTree.getRootNode(), 'add', userId);
                }
            }, {
                id: 'refresh',
                qtip: '重新排序',
                handler: function(event, toolEl, panel){
                    pThis.sortFileClass(fileClassTree.getRootNode(), userId);
                }
            }],
            loader: new Ext.tree.TreeLoader({
                dataUrl: 'getFileClass.action?userId=' + userId
            }),
            rootVisible: false,
            root: new Ext.tree.AsyncTreeNode({
                id: rootId,
                text: '根结点'
            }),
            listeners: {
                click: function(node){
                    currentNode = node;
                    eval(nodeClick)(node, userId);
                },
                contextmenu: function(node, event){
                    event.preventDefault();
                    var rightClick = new Ext.menu.Menu({
                        id: 'rightClickCont',
                        items: [{
                            id: 'newFileClass',
                            text: '添加公文类别',
                            iconCls: 'add',
                            handler: function(){
                                pThis.doFileClass(node, 'add', userId);
                            }
                        }, {
                            id: 'editFileClass',
                            text: '编辑公文类别',
                            iconCls: 'grid',
                            handler: function(){
                                if (node.attributes.user == '*') {
                                    pThis.showMsg('温馨提示', '您不能编辑系统内置类别!');
                                    return false;
                                }
                                pThis.doFileClass(node, 'edit', userId);
                            }
                        }, {
                            id: 'deleteFileClass',
                            text: '删除公文类别',
                            iconCls: 'delete',
                            handler: function(){
                                if (node.attributes.user == '*') {
                                    pThis.showMsg('温馨提示', '您不能删除系统内置类别!');
                                    return false;
                                }
                                pThis.deleteFileClass(node);
                            }
                        }, {
                            id: 'sortFileClass',
                            text: '公文类别排序',
                            iconCls: 'grid',
                            handler: function(){
                                pThis.sortFileClass(node, userId);
                            }
                        }]
                    });
                    rightClick.showAt(event.getXY());
                }
            }
        });
        return fileClassTree;
    },
    doFileClass: function(node, oper, userId){
        var pThis = this;
        var action;
        var title;
        var parentId = node.attributes.id;
        if (oper == 'edit') {
            action = 'editFileClass';
            title = '编辑公文类别信息';
        }
        else {
            action = 'addFileClass';
            title = '添加公文类别信息';
        }
        var win = new Ext.Window({
            title: title,
            width: 600,
            height: 150,
            layout: 'fit',
            closable: true,
            border: true,
            items: new Ext.form.FormPanel({
                id: 'fileClassForm',
                border: false,
                layout: 'table',
                defaults: {
                    bodyStyle: 'padding:5px'
                },
                layoutConfig: {
                    columns: 2
                },
                buttonAlign: 'center',
                items: [{
                    layout: 'form',
                    border: false,
                    items: {
                        xtype: 'textfield',
                        fieldLabel: "类别代码",
                        labelStyle: 'text-align:right;',
                        name: 'classId',
                        readOnly: true,
                        value: (new Date()).getTime(),
                        width: 150
                    }
                }, {
                    layout: 'form',
                    border: false,
                    items: [{
                        xtype: 'textfield',
                        fieldLabel: "类别名称",
                        labelStyle: 'text-align:right;',
                        name: 'className',
                        width: 150
                    }, {
                        xtype: 'hidden',
                        name: 'parentId',
                        value: parentId
                    }]
                }, {
                    layout: 'form',
                    border: false,
                    colspan: 2,
                    items: [{
                        xtype: 'textfield',
                        fieldLabel: "类别序号",
                        labelStyle: 'text-align:right;',
                        name: 'ordIndex',
                        width: 150
                    }]
                }],
                buttons: [{
                    text: '保存',
                    handler: function(){
                        var form = Ext.getCmp('fileClassForm');
                        if (form.getForm().isValid()) {
                            if (Ext.get('className').dom.value === "") {
                                alert("类别名称不能为空");
                                return false;
                            }
                            form.getForm().submit({
                                url: 'saveFileClass.action',
                                params: {
                                    action: action,
                                    userId: userId
                                },
                                waitMsg: '正在保存数据，请稍候...',
                                success: function(form, response){
                                    pThis.showMsg("提示信息", response.result.sign);
                                    if (oper == 'edit') {
                                        try {
                                            node.parentNode.reload();
                                        } 
                                        catch (e) {
                                            node.reload();
                                        }
                                    }
                                    else {
                                        node.reload();
                                    }
                                    win.close();
                                },
                                failure: function(form, response){
                                    pThis.showMsg("提示信息", response.result.sign);
                                    win.close();
                                }
                            });
                        }
                    }
                }, {
                    text: '关闭',
                    handler: function(){
                        win.close();
                    }
                }]
            })
        });
        win.show();
        win.center();
        if (oper == 'edit') {
            Ext.get('className').dom.value = node.attributes.text;
            Ext.get('classId').dom.value = node.attributes.id;
            Ext.get('ordIndex').dom.value = node.attributes.ordIndex;
        }
    },
    deleteFileClass: function(node){
        Ext.Msg.confirm("确认删除", "删除该结点将同时删除所有该结点的子结点，确实要删除该结点吗？", function(result){
            if (result == 'yes') {
                Ext.Ajax.request({
                    url: 'saveFileClass.action?action=deleteFileClass&classId=' + node.attributes.id + '&userId=' + node.attributes.user,
                    success: function(response){
                        var result = Ext.util.JSON.decode(response.responseText);
                        node.remove();
                        alert(result.sign);
                    },
                    failure: function(response){
                        var result = response.responseText;
                        alert(result.sign);
                    }
                });
            }
        });
    },
    sortFileClass: function(node, userId){
        var pThis = this;
        var win = new Ext.Window({
            title: '公文类别重新排序',
            width: 550,
            height: 400,
            layout: 'fit',
            id: 'sortPanel',
            defaults: {
                bodyStyle: 'padding:0px'
            },
            border: false,
            items: new Ext.grid.EditorGridPanel({
                store: new Ext.data.JsonStore({
                    autoLoad: true,
                    url: "getJsonData.action",
                    baseParams: {
                        ruleID: 'portlet-info.getSubFileClass',
                        userId: userId,
                        parentId: node.attributes.id
                    },
                    fields: [{
                        name: 'class_id'
                    }, {
                        name: 'class_name'
                    }, {
                        name: 'ord_index'
                    }]
                }),
                columns: [{
                    id: 'classId',
                    header: '类别代码',
                    align: 'center',
                    width: 100,
                    sortable: true,
                    dataIndex: 'class_id'
                }, {
                    id: 'className',
                    header: '类别名称',
                    align: 'center',
                    width: 200,
                    sortable: true,
                    dataIndex: 'class_name'
                }, {
                    id: 'ordIndex',
                    header: '排序',
                    align: 'center',
                    sortable: true,
                    dataIndex: 'ord_index',
                    editor: new Ext.form.TextField({
                        allowBlank: false
                    })
                }],
                id: 'sortGrid',
                viewConfig: {
                    forceFit: true
                },
                frame: false,
                clicksToEdit: 2,//2-双击进入编辑状态，1-单击进入编辑状态
                buttonAlign: 'center',
                buttons: [{
                    id: 'saveSort',
                    text: '保存',
                    handler: function(){
                        var record = Ext.getCmp('sortGrid').getStore().getModifiedRecords();
                        if (record.length > 0) {
                            var jsonString = "[";
                            for (var p = 0; p < record.length; p++) {
                                var temp = "{classId: '" + record[p].data.class_id + "',";
                                temp += "ordIndex: '" + record[p].data.ord_index + "'}";
                                jsonString += temp + ",";
                            }
                            if (jsonString.length > 1) {
                                jsonString = jsonString.substring(0, jsonString.length - 1);
                            }
                            jsonString += "]";
                            Ext.Ajax.request({
                                url: 'saveFileClass.action',
                                params: {
                                    action: 'sortFileClass',
                                    jsonData: jsonString
                                },
                                success: function(response){
                                    var result = Ext.util.JSON.decode(response.responseText);
                                    alert(result.sign);
                                    win.close();
                                    node.reload();
                                }
                            });
                        }
                        else {
                            pThis.showMsg('提示信息', '类别没有修改信息，不用保存！');
                        }
                    }
                }, {
                    text: '关闭',
                    handler: function(){
                        win.close();
                    }
                }]
            })
        });
        win.show();
        win.center();
    },
    getFileBoxData: function(node, userId){
        if (showStyleNum == '1') {
            //详细信息
            FileBoxManager.getFileBoxGridData(node, userId);
        }
        else 
            if (showStyleNum == '2') {
                //平铺
                FileBoxManager.getFileBoxTileData(node, userId);
            }
            else 
                if (showStyleNum == '3') {
                //列表
                }
                else 
                    if (showStyleNum == '4') {
                    //图标
                    //alert('显示样式='+showStyleNum);
                    }
    },
    getFileBoxGridData: function(node, userId){
		var pageSize = 20;
        var sm = new Ext.grid.CheckboxSelectionModel();
        var colms = new Ext.grid.ColumnModel([sm, {
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
            id: 'fileTime',
            header: '添加时间',
            align: 'center',
            width: 120,
            sortable: true,
            dataIndex: 'fileTime'
        }, {
            id: 'fileStatus',
            header: '状态',
            align: 'center',
            width: 50,
            sortable: true,
            dataIndex: 'fileStatus',
            renderer: function(value){
                return value;
            }
        }]);
        colms.defaultSortable = true;
        var fileBoxStore = new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({
                url: 'getPageJsonData.action'
            }),
            baseParams: {
                ruleID: 'portlet-info.getFileBoxData',
                classId: node.attributes.id,
                userId: userId,
                oaFileType: '01'
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
                name: 'fileTime',
                mapping: 'file_time'
            }, {
                name: 'fileUrl',
                mapping: 'file_url'
            }, {
                name: 'classId',
                mapping: 'class_id'
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
                limit: pageSize
            }
        });
        var fileBoxGridPanel = new Ext.grid.GridPanel({
            store: fileBoxStore,
            cm: colms,
            sm: sm,
            id: 'fileBox',
            enableDragDrop: true,
            ddGroup: 'fileBoxGroup',
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
                        window.open(record.get('fileUrl'), 'maxwindow', 'toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no');
                    }
                }
            }
        });
        var fileBoxFooter = new Ext.PagingToolbar({
            pageSize: pageSize,
            store: fileBoxStore,
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条数据，共 {2} 条',
            emptyMsg: '没有数据',
            items: ['-', {
                tooltip: '刪除公文箱信息',
                iconCls: 'new-tab',
                icon: '/style/img/gp5/ico/delete_style_g.jpg',
                handler: function(){
                    var selections = fileBoxGridPanel.getSelectionModel().getSelections();
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
                            jsonDelArr += record.get('fileBoxId');
                        }
                        Ext.Ajax.request({
                            url: 'deleteFileBox.action',
                            params: {
                                ruleID: 'portlet-info.deleteFileBoxData',
                                fileBoxIds: jsonDelArr,
                                oaFileType: '01'
                            },
                            callback: function(option, success, response){
                                if (success) {
                                    var result = Ext.util.JSON.decode(response.responseText);
                                    FileBoxManager.showMsg('温馨提示', result.sign);
                                    fileBoxStore.reload();
                                }
                            }
                        });
                    });
                }
            }]
        });
        /**
         * 销毁原面板
         */
        FileBoxManager.destroyPanel(FileBoxManager.fileBoxTilePanel);
        FileBoxManager.destroyPanel(FileBoxManager.fileBoxDetailPanel);
        /**
         * 创建新面板
         */
        FileBoxManager.fileBoxDetailPanel = new Ext.Panel({
            border: false,
            layout: 'fit',
            applyTo: 'fileMainPanel',
            items: {
                border: false,
                layout: 'fit',
                items: fileBoxGridPanel,
                bbar: fileBoxFooter
            }
        });
        
        Ext.getCmp('fileMainPanel').on('resize', function(){
            FileBoxManager.fileBoxDetailPanel.setWidth(Ext.getCmp('fileMainPanel').getInnerWidth());
            FileBoxManager.fileBoxDetailPanel.syncSize();
        });
    },
    getFileBoxTileData: function(node, userId){
        FileBoxManager.fileBoxTileColumn = new ufgov.portal.portlet.FileBoxTileTemp({
            border: false,
            items: [{
                style: "padding:10px 0px 10px 0px",
                columnWidth: 0.25
            }, {
                style: "padding:10px 0px 10px 0px",
                columnWidth: 0.25
            }, {
                style: "padding:10px 0px 10px 0px",
                columnWidth: 0.25
            }, {
                style: "padding:10px 0px 10px 0px",
                columnWidth: 0.25
            }]
        });
        /**
         * 销毁原面板
         */
        FileBoxManager.destroyPanel(FileBoxManager.fileBoxTilePanel);
        //FileBoxManager.destroyPanel(FileBoxManager.fileBoxDetailPanel);
        /**
         * 创建平铺新面板
         */
        FileBoxManager.fileBoxTilePanel = new Ext.Panel({
            border: false,
            layout: 'fit',
            applyTo: 'fileMainPanel',
            items: {
                border: false,
                items: FileBoxManager.fileBoxTileColumn
            }
        });
        this.showFileBoxTilePortlet();
    },
    showFileBoxTilePortlet: function(){
        var ppanel = FileBoxManager.fileBoxTileColumn;
        Ext.Ajax.request({
            url: 'getJsonData.action',
            params: {
                ruleID: 'portlet-info.getFileBoxData',
                classId: currentNode.attributes.id,
                userId: userId,
                oaFileType: '01'
            },
            success: function(response){
            
            }
        })
    },
    destroyPanel: function(panel){
        if (panel) {
            if (panel.items) {
                for (var p = panel.items.length; p > 0; p--) {
                    panel.remove(panel.items.items[p - 1]);
                }
            }
            if (panel.tbar) {
                panel.tbar.remove();
            }
            if (panel.tools.items) {
                for (var i = panel.tools.items.length; i > 0; i--) {
                    panel.tools.remove(panel.tools.items.items[i - 1]);
                }
            }
            if (panel.header) {
                panel.header.remove();
            }
        }
    }
});
var FileBoxManager = new ufgov.portal.portlet.FileBoxManager();

Ext.onReady(function(){
    Ext.QuickTips.init();
    FileBoxManager.pageInit();
});
