/**
 * 草稿箱
 */
ufgov.portal.portlet.DraftBoxMessage = function(){
}

Ext.extend(ufgov.portal.portlet.DraftBoxMessage, ufgov.portal.Base, {
  pageSize: 20,
  createMainFrame: function(){
    var pThis = this;
    var sm = new Ext.grid.CheckboxSelectionModel();
    var colms = new Ext.grid.ColumnModel([sm, {
      id: 'messTitle',
      header: '标题',
      align: 'center',
      sortable: true,
      dataIndex: 'messTitle'
    }, {
      id: 'createTime',
      header: '创建日期',
      align: 'center',
      width: 120,
      sortable: true,
      dataIndex: 'createTime',
      renderer: function(v){
        if (v.length > 19) {
          return v.substring(0, 19);
        }
      }
    }]);
    colms.defaultSortable = true;
    var messageStore = new Ext.data.Store({
      proxy: new Ext.data.HttpProxy({
        url: 'getPageJsonData.action'
      }),
      baseParams: {
        ruleID: 'gmap-message.getSendMessageData',
        userId: userId,
        messState: '1'
      },
      reader: new Ext.data.JsonReader({
        totalProperty: 'totalCount',
        root: 'dataList'
      }, [{
        name: 'messId',
        mapping: 'id'
      }, {
        name: 'messTitle',
        mapping: 'mess_title'
      }, {
        name: 'createTime',
        mapping: 'create_time'
      }])
    });
    messageStore.load({
      params: {
        start: 0,
        limit: this.pageSize
      }
    });
    var draftMessageGridPanel = new Ext.grid.GridPanel({
      store: messageStore,
      cm: colms,
      sm: sm,
      id: 'draftMessageGridPanel',
      autoExpandColumn: 'messTitle',
      resizable: true,
      autoWidth: true,
      border: false,
      listeners: {
        rowdblclick: function(grid, rowIndex, event){
          var Record = grid.getStore().getAt(rowIndex);
          MessageOper.newOrEditMessage(Record.get("messId"), Ext.getCmp('draftMessageGridPanel'));
        }
      }
    });
    var messageFooter = new Ext.PagingToolbar({
      pageSize: this.pageSize,
      store: messageStore,
      displayInfo: true,
      displayMsg: '显示第 {0} 条到 {1} 条数据，共 {2} 条',
      emptyMsg: '没有数据',
      items: ['-', {
        tooltip: '刪除消息',
        iconCls: 'new-tab',
        icon: '/style/img/gp5/ico/delete_style_g.jpg',
        handler: function(){
          var selections = draftMessageGridPanel.getSelectionModel().getSelections();
          if (selections.length === 0) {
            alert("请选择要删除的记录！");
            return;
          }
          Ext.Msg.confirm('系統提示', '确认删除吗?(注意,该删除不可恢复！)', function(btn){
            if (btn != 'yes') return;
            var jsonDelArr = "";
            for (var i = 0; i < selections.length; i++) {
              var record = selections[i];
              if (!Ext.isEmpty(jsonDelArr)) {
                jsonDelArr += ',';
              }
              jsonDelArr += record.get('messId');
            }
            Ext.Ajax.request({
              url: 'doMessageOper.action',
              params: {
                ruleID: 'gmap-message.deleteMessage',
                deleteString: jsonDelArr,
                action: 'delete'
              },
              callback: function(option, success, response){
                if (success) {
                  var result = Ext.util.JSON.decode(response.responseText);
                  pThis.showMsg('温馨提示', result.sign);
                  messageStore.reload();
                }
              }
            });
          });
        }
      }]
    });
    var mainPanel = new Ext.Panel({
      applyTo: 'DraftBox-Main',
      layout: 'border',
      border: false,
      items: [{
        region: 'center',
        border: false,
        layout: 'fit',
        items: draftMessageGridPanel,
        bbar: messageFooter
      }]
    })
    Ext.getCmp('messageMainPanel').on('resize', function(){
      mainPanel.setWidth(Ext.getCmp('messageMainPanel').getInnerWidth());
      mainPanel.syncSize();
    })
  }
})
Ext.onReady(function(){
	Ext.QuickTips.init();
	var main = new ufgov.portal.portlet.DraftBoxMessage();
	main.createMainFrame();
});