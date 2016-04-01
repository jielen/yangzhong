/**
 * @author hemg
 */
ufgov.portal.portlet.GetOrgTree = function(){
  this.showMainWindow();
};
Ext.extend(ufgov.portal.portlet.GetOrgTree, ufgov.portal.Base, {
  getOrgTree: function(){
    var loader = new Ext.tree.TreeLoader({
      dataUrl: "getComOrgTree.action",
      baseAttrs: {
        uiProvider: Ext.tree.TreeCheckNodeUI
      },
      listeners: {
        beforeload: function(treeLoader, node){
          treeLoader.baseParams.nodeSign = node.attributes.nodeSign;
					if(node.attributes.nodeSign == '2'){
						treeLoader.baseParams.coCode = node.attributes.coCode;
					}
        }
      }
    });
    var treePanel = new Ext.tree.TreePanel({
      id: 'tree_Panel',
      header: false,
      xtype: 'treepanel',
      border: false,
      autoScroll: true,
      split: true,
      singleExpand: true,
      hideCollapseTool: true,
      useArrows: true,
      loader: loader,
      checkModel: 'childCascade',
      onlyLeafCheckable: false
    });
    var root = null;
    var cocode = document.getElementById('svCoCode');
    var coname = document.getElementById('svCoName');
//    if (cocode.getAttribute('value') !== "") {
//      root = new Ext.tree.AsyncTreeNode({
//        id: cocode.getAttribute('value'),
//        text: coname.getAttribute('value'),
//        nodeSign: '1'
//      });
//      treePanel.setRootNode(root);
//      root.expand();
//    }
//    else {
      root = new Ext.tree.AsyncTreeNode({
        id: 'root',
        text: '��Ŀ¼'
      });
      root.ui = new Ext.tree.RootTreeNodeUI(root);
      root.renderChildren();
      treePanel.setRootNode(root);
//    }
    return treePanel;
  },
  showMainWindow: function(){
    var treePanel = this.getOrgTree();
    new Ext.Panel({
      layout: 'fit',
      applyTo: Ext.getBody(),
      tbar: [{
        text: '确定',
        iconCls: 'save',
        icon: 'resources/save.gif',
        handler: function(){
          var checkArray = treePanel.getChecked();
          var popWin = new Array();
          if (checkArray.length > 0) {
            for (var i = 0; i < checkArray.length; i++) {
              var item = checkArray[i].attributes.id;
              var itemName = checkArray[i].attributes.text;
              var itemType = checkArray[i].attributes.nodeSign;
              var retValue = new Object();
              if (itemType === '3') {
                if (itemName.indexOf("【") > 0) {
                  itemName = itemName.substring(0, itemName.indexOf("【"));
                }
                retValue.showName = itemName;
								retValue.id = item;
                popWin[popWin.length] = retValue;
              }
            }
          }
          window.returnValue = popWin;
          window.close();
        }
      }, {
        text: '关闭',
        iconCls: 'close',
        icon: 'resources/close.gif',
        handler: function(){
          window.close();
        }
      }],
      items: [treePanel]
    });
  }
});
Ext.onReady(function(){
  Ext.QuickTips.init();
  new ufgov.portal.portlet.GetOrgTree();
})
