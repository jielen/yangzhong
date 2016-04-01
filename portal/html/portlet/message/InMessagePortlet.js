/**
 * 站内消息频道
 * @author hemg
 * @date 2009-10-29
 * @class ufgov.portal.portlet.InMessagePortlet
 */
ufgov.portal.portlet.InMessagePortlet = function(){
};

Ext.extend(ufgov.portal.portlet.InMessagePortlet, ufgov.portal.Base, {
  panel: null,
  portletId: 'inMessage',
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
      id: 'messTitle',
      header: '标题',
      align: 'center',
      sortable: true,
      dataIndex: 'messTitle',
      renderer: function(value){
        return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
      }
    }, {
      id: 'sender',
      header: '发送人',
      align: 'center',
      width: 80,
      sortable: true,
      dataIndex: 'sender'
    }, {
      id: 'sendTime',
      header: '发送时间',
      align: 'center',
      width: 50,
      sortable: true,
      dataIndex: 'sendTime',
      renderer: function(value){
      
      }
    }]);
    colms.defaultSortable = true;
    var messageStore = new Ext.data.Store({
      proxy: new Ext.data.HttpProxy({
        url: 'getPageJsonData.action'
      }),
      baseParams: {
        ruleID: 'gmap-message.getReceiveMessageData',
        userId: userId,
				isNew: '1'
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
        name: 'sendTime',
        mapping: 'send_time'
      }])
    });
    messageStore.load({
      params: {
        start: 0,
        limit: this.recordSize
      }
    });
    var messagePanel = new Ext.grid.GridPanel({
      store: messageStore,
      cm: colms,
      id: 'message',
      bodyStyle: 'width:100%',
      autoExpandColumn: 'messTitle',
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
        qtip: '发消息......',
        id: 'gear',
        handler: function(){
          pThis.sendMessage();
        }
      }, {
        qtip: '更多信息......',
        id: 'more',
        handler: function(e, target, panel){
          window.open("messPageDispatcher.action?function=inMessage", "new", "left=0px,top=0px,width=" + (screen.availWidth - 10) + ",height=" + (screen.availHeight - 35) + ",menubar=no,scrollbars=no,status=no,toolbar=no,resizable=no");
        }
      }],
      items: messagePanel
    });
    // grid双击事件
    messagePanel.on("rowclick", function(grid){
//      var record = grid.getSelectionModel().getSelected();
//      if (!record) {
//        return;
//      }
      window.open("messPageDispatcher.action?function=inMessage", "new", "left=0px,top=0px,width=" + (screen.availWidth - 10) + ",height=" + (screen.availHeight - 35) + ",menubar=no,scrollbars=no,status=no,toolbar=no,resizable=no");
    });
  },
  sendMessage: function(){
    alert("请使用消息管理器发送");
  }
});
