/**
 * 收件箱-未读
 */
ufgov.portal.portlet.ReceiveBoxMessage = function(){
}

Ext.extend(ufgov.portal.portlet.ReceiveBoxMessage, ufgov.portal.Base, {
  pageSize: 20,
  createMainFrame: function(){
    var pThis = this;
    var sm = new Ext.grid.CheckboxSelectionModel();
    var colms = new Ext.grid.ColumnModel([sm, {
			id: 'flag',
			header: '',
			align: 'center',
			width: 50,
			renderer: function(value, cellmeta, record, rowIndex, columnIndex, store){
				if (record.get('isNew') == '1') {
					return "<img src='resources/article-new-flag.gif'>";
				}
			}
		}, {
      id: 'messTitle',
      header: '标题',
      align: 'left',
      sortable: true,
      dataIndex: 'messTitle',
			renderer: function(value, cellmeta, record, rowIndex, columnIndex, store){
				if(record.get('isNew') == '1'){
					return "<b>" + value + "</b>";
				}else{
					return value;
				}
			}
    }, {
      id: 'empName',
      header: '发送人',
      align: 'center',
      width: 120,
      sortable: true,
      dataIndex: 'empName',
			renderer: function(value, cellmeta, record, rowIndex, columnIndex, store){
				if(record.get('isNew') == '1'){
					return "<b>" + value + "</b>";
				}else{
					return value;
				}
			}
    }, {
      id: 'sendTime',
      header: '发送日期',
      align: 'center',
      width: 120,
      sortable: true,
      dataIndex: 'sendTime',
      renderer: function(v){
        if (v.length > 19) {
          return v.substring(0, 19);
        }else{
					return v;
				}
      }
    }]);
    colms.defaultSortable = true;
    var messageStore = new Ext.data.Store({
      proxy: new Ext.data.HttpProxy({
        url: 'getPageJsonData.action'
      }),
      baseParams: {
        ruleID: 'gmap-message.getReceiveMessageData',
        userId: userId
      },
      reader: new Ext.data.JsonReader({
        totalProperty: 'totalCount',
        root: 'dataList'
      }, [{
        name: 'messId',
        mapping: 'mess_id'
      }, {
        name: 'messTitle',
        mapping: 'mess_title'
      }, {
        name: 'sender',
        mapping: 'sender'
      }, {
        name: 'empName',
        mapping: 'emp_name'
      }, {
        name: 'sendTime',
        mapping: 'send_time'
      }, {
				name: 'isNew',
				mapping: 'is_new'
			}])
    });
    messageStore.load({
      params: {
        start: 0,
        limit: this.pageSize
      }
    });
    var receiveMessageGridPanel = new Ext.grid.GridPanel({
      store: messageStore,
      cm: colms,
      sm: sm,
      id: 'receiveMessageGridPanel',
      autoExpandColumn: 'messTitle',
      resizable: true,
      autoWidth: true,
      border: false,
      listeners: {
        rowdblclick: function(grid, rowIndex, event){
          var Record = grid.getStore().getAt(rowIndex);
					var jsonParams = {
						messId: Record.get('messId'),
						sender: Record.get('sender'),
						empName: Record.get('empName'),
						sendTime: Record.get('sendTime')
					};
          MessageOper.messageShow(jsonParams);
					if(Record.get('isNew') == '1'){
						Ext.Ajax.request({
							url: 'doMessageOper.action',
							params: {
								ruleID: 'gmap-message.updateMessageReceiver',
								messId: Record.get('messId'),
								receiver: userId,
								isNew: '0',
								action: 'update'
							},
							callback: function(o,success,res){
								if(success){
									messageStore.reload();
								}
							}
						})
					}
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
          var selections = receiveMessageGridPanel.getSelectionModel().getSelections();
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
      applyTo: 'ReceiveBox-Main',
      layout: 'border',
      border: false,
      items: [{
        region: 'center',
        border: false,
        layout: 'fit',
        items: receiveMessageGridPanel,
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
	var main = new ufgov.portal.portlet.ReceiveBoxMessage();
	main.createMainFrame();
});