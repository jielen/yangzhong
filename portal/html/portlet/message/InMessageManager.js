/**
 * @author hemg
 * @date 2009-10-28
 * @title 站内消息管理器
 */
ufgov.portal.portlet.InMessageManager = function(){
};

Ext.extend(ufgov.portal.portlet.InMessageManager, ufgov.portal.Base, {
  createMainFrame: function(){
    var pThis = this;
    var treeMenu = this.getMessageClass();
    new Ext.Viewport({
      layout: 'border',
      items: [{
        region: 'west',
        id: 'messageMenu',
        title: '当前用户：<font color="#ff0000">' + userName + '</font>',
        split: true,
        width: 180,
        minSize: 150,
        maxSize: 300,
        collapsible: true,
        margins: '5 0 5 5',
        tbar: [{
          text: '写消息',
          iconCls: 'new-tab',
          icon: path + '/resources/icon-add.gif',
          handler: function(){
            MessageOper.newOrEditMessage();
          }
        }],
        items: [treeMenu]
      }, {
        region: 'center',
        margins: '5 5 5 0',
        layout: 'fit',
        items: {
          border: false,
          layout: 'fit',
          id: 'contentPanel',
          items: new Ext.TabPanel({
            baseCls: 'x-plain',
            activeTab: 0,
            border: false,
            id: 'messageMainPanel',
            resizeTabs: false,
            minTabWidth: 115,
            tabWidth: 200,
            enableTabScroll: true,
            autoScroll: true,
            items: [{
              title: '首页'
            }]
          })
        }
      }]
    });
		var receiveBox = new Ext.tree.TreeNode({
      id: 'ReceiveBox',
      text: '收件箱',
      leaf: true
    });
		pThis.getMessageData(receiveBox, userId);
  },
  getMessageClass: function(){
    var pThis = this;
    var receiveBox = new Ext.tree.TreeNode({
      id: 'ReceiveBox',
      text: '收件箱',
      leaf: true
    });
    var sendBox = new Ext.tree.TreeNode({
      id: 'SendBox',
      text: '发件箱',
      leaf: true
    });
    var draftBox = new Ext.tree.TreeNode({
      id: 'DraftBox',
      text: '草稿箱',
      leaf: true
    });
    var root = new Ext.tree.TreeNode({
      id: 'root',
      text: '根结点'
    });
    root.appendChild(receiveBox);
    root.appendChild(sendBox);
    root.appendChild(draftBox);
    var messageClassTree = new Ext.tree.TreePanel({
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
					if (node.isLeaf()) {
						pThis.getMessageData(node, userId);
					}
        }
      }
    });
    return messageClassTree;
  },
  getMessageData: function(node, userId){
    var mainFrame = Ext.getCmp("messageMainPanel");
    if (!Ext.getCmp(node.attributes.id)) {
      var panel = new Ext.Panel({
        title: node.attributes.text,
        id: node.attributes.id,
        closable: true,
        autoLoad: {
          url: "messPageDispatcher.action?function=messageMainPanel",
          params: {
						subId: node.attributes.id
					},
          scripts: true,
          text: "数据装载中，请稍候...",
          nocache: true
        }
      });
      mainFrame.add(panel);
      mainFrame.activate(panel);
    }
    else {
      var panel = mainFrame.findById(node.attributes.id);
      mainFrame.activate(panel);
    }
  }
});

Ext.onReady(function(){
  Ext.QuickTips.init();
  var InMessageManager = new ufgov.portal.portlet.InMessageManager();
  InMessageManager.createMainFrame();
});
