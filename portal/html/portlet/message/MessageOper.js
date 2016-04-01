/**
 * 消息操作，增、改
 */
ufgov.portal.portlet.MessageOper = function(){
}

Ext.extend(ufgov.portal.portlet.MessageOper, ufgov.portal.Base, {
  parentObject: null,
  newOrEditMessage: function(messId, parentComp){
    if (!Ext.isEmpty(parentComp)) {
      this.parentObject = parentComp;
    }
    var pThis = this;
    var action = "insert";
    if (!Ext.isEmpty(messId)) {
      action = "update";
    }
    if (!this.newWin) {
      var fileGrid = this.getFileGrid(messId);
      var receiveGrid = this.getReceiveGrid(messId);
      this.newWin = new Ext.Window({
        height: 600,
        width: 820,
        layout: 'fit',
        id: 'newMessageWindow',
        closable: true,
        title: "写消息",
        items: new Ext.form.FormPanel({
          id: 'newMessageForm',
          border: false,
          layout: 'table',
          defaults: {
            bodyStyle: Ext.isIE ? 'padding:10px ' : 'padding:8px '
          },
          layoutConfig: {
            columns: 2
          },
          buttonAlign: 'center',
          items: [{
            layout: 'form',
            colspan: 2,
            border: false,
            items: {
              border: false,
              layout: 'table',
              layoutConfig: {
                columns: 4
              },
              items: [{
                border: false,
                width: 110,
                html: '<span style="font-size:12px;">接收人：</span>'
              }, {
                border: false,
                layout: 'fit',
                items: receiveGrid
              }, {
                border: false,
                width: 20
              }, {
                border: false,
                layout: 'fit',
                items: fileGrid
              }]
            }
          }, {
            layout: 'form',
            border: false,
            colspan: 2,
            items: [{
              xtype: 'textfield',
              fieldLabel: "消息标题",
              labelStyle: 'text-align:left;',
              name: 'messTitle',
              id: 'messTitle',
              allowBlank: false,
              width: 600
            }, {
              xtype: 'hidden',
              name: 'messId',
              id: 'messId'
            }]
          }, {
            layout: 'form',
            border: false,
            colspan: 2,
            items: {
              xtype: 'htmleditor',
              fieldLabel: "消息内容",
              labelStyle: 'text-align:left;',
              name: 'messContent',
              id: 'messContent',
              enableSourceEdit: true,
              width: 600,
              height: 280
            }
          }],
          buttons: [{
            text: '保存',
            id: 'saveMessage',
            handler: function(){
							Ext.getCmp("receiveGrid").getSelectionModel().selectAll();
              pThis.saveMessage(action, "1");
            }
          }, {
            text: '发送',
            id: 'sendMessage',
            handler: function(){
							Ext.getCmp("receiveGrid").getSelectionModel().selectAll();
							var selectReceiverRecord = Ext.getCmp("receiveGrid").getSelectionModel().getSelections();
							if(selectReceiverRecord.length == 0){
								alert("请选择接收人！");
								return false;
							}
              pThis.saveMessage(action, "2");
            }
          }]
        })
      });
    }
    this.newWin.show();
    this.newWin.center();
    this.newWin.on('beforeclose', function(){
      if (pThis.parentObject != null) {
        pThis.parentObject.getStore().reload();
      }
    })
    this.newWin.on('close', function(){
      pThis.newWin = null;
    })
    if (!Ext.isEmpty(messId)) {
      Ext.Ajax.request({
        url: 'getMessage.action',
        params: {
          ruleID: 'gmap-message.getMessageByParams',
          messId: messId
        },
        callback: function(o, success, res){
          if (success) {
            var result = Ext.util.JSON.decode(res.responseText);
            if (result.length > 0) {
              Ext.getCmp('messId').setValue(result[0].messId);
              Ext.getCmp('messTitle').setValue(result[0].messTitle);
              Ext.getCmp('messContent').setValue(result[0].messCont);
            }
          }
        }
      })
    }
  },
  getFileGrid: function(messId){
    var pThis = this;
    var sm = new Ext.grid.CheckboxSelectionModel();
    var colms = new Ext.grid.ColumnModel([sm, {
      id: 'fileName',
      header: '附件',
      align: 'center',
      sortable: true,
      dataIndex: 'fileName',
      renderer: function(v, cellmeta, record, rowIndex, columnIndex, store){
        return "<a href='downloadFile.action?fileId=" + record.get('fileId') + "'>" + v + "</a>"
      }
    }]);
    colms.defaultSortable = true;
    var fileStore = new Ext.data.JsonStore({
      url: 'getJsonData.action',
      baseParams: {
        messId: messId === null ? "" : messId,
        ruleID: 'gmap-message.getMessageFile'
      },
      fields: [{
        name: 'messId',
        mapping: 'mess_id'
      }, {
        name: 'fileId',
        mapping: 'file_id'
      }, {
        name: 'fileName',
        mapping: 'file_name'
      }, {
        name: 'operType'
      }]
    });
    if (!Ext.isEmpty(messId)) {
      fileStore.load();
    }
    var bar = new Ext.Toolbar({
      items: [{
        text: '添加附件',
        iconCls: 'new-tab',
        icon: path + '/resources/image_add.png',
        handler: function(){
          pThis.onAddFile(pThis);
        }
      }, {
        iconCls: 'new-tab',
        icon: path + '/resources/feed_delete.png',
        text: '删除附件',
        handler: onDeleteRecord
      }]
    });
    var editFilePanel = new Ext.grid.EditorGridPanel({
      store: fileStore,
      cm: colms,
      sm: sm,
      id: 'editFileGrid',
      autoExpandColumn: 'fileName',
      height: 158,
      width: 320,
      frame: false,
      clicksToEdit: 1, //2-双击进入编辑状态，1-单击进入编辑状态
      bbar: bar
    });
    function onDeleteRecord(){
      var selectRecord = editFilePanel.getSelectionModel().getSelections();
      if (Ext.isEmpty(selectRecord) || selectRecord.length === 0) {
        alert('请选择要删除的记录');
        return;
      }
      Ext.Msg.confirm('系統提示', '确认删除吗?(注意,该删除不可恢复！)', function(btn){
        if (btn != 'yes') return;
        //debugger;
        var jsonString = "";
        for (var i = 0; i < selectRecord.length; i++) {
          if (!Ext.isEmpty(jsonString)) {
            jsonString += ",";
          }
          jsonString += selectRecord[i].data.fileId;
        }
        Ext.Ajax.request({
          url: 'doMessageOper.action',
          params: {
            deleteString: jsonString,
            ruleID: 'gmap-message.deleteMessageFile',
            action: "delete"
          },
          success: function(response){
            var result = Ext.util.JSON.decode(response.responseText);
            alert(result.sign);
            for (var i = 0; i < selectRecord.length; i++) {
              var record = selectRecord[i];
              editFilePanel.getStore().remove(record);
            }
            editFilePanel.getSelectionModel().selectAll();
          }
        })
      })
    }
    return editFilePanel;
  },
  getReceiveGrid: function(messId){
    var pThis = this;
    var sm = new Ext.grid.CheckboxSelectionModel();
    var colms = new Ext.grid.ColumnModel([sm, {
      id: 'empName',
      header: '接收人',
      align: 'center',
      sortable: true,
      dataIndex: 'empName'
    }]);
    colms.defaultSortable = true;
    var receiveStore = new Ext.data.JsonStore({
      url: 'getJsonData.action',
      fields: [{
        name: 'receiver',
        mapping: 'receiver'
      }, {
        name: 'empName',
        mapping: 'emp_name'
      }]
    });
    if (!Ext.isEmpty(messId)) {
      receiveStore.baseParams = {
        ruleID: 'gmap-message.getMessageReceiver',
        messId: messId
      };
      receiveStore.load();
    }
    var bar = new Ext.Toolbar({
      items: [{
        text: '选择人员',
        iconCls: 'new-tab',
        icon: path + '/resources/image_add.png',
        handler: function(){
          var retValue = window.showModalDialog("messPageDispatcher.action?function=orgTree", window, "status:no;resizable:yes;help:no;dialogHeight:400px;dialogWidth:300px");
          if (retValue != null && retValue.length > 0) {
            for (var i = 0; i < retValue.length; i++) {
              var isExist = false;
              for (var m = 0; m < receiveStore.getCount(); m++) {
                var Record = receiveStore.getAt(m);
                if (Record.get("receiver") == retValue[i].id) {
                  isExist = true;
                  break;
                }
              }
              if (isExist) continue;
							pThis.addEmpToGrid(retValue[i].id, retValue[i].showName);
            }
          }
        }
      }, {
        text: '删除人员',
        iconCls: 'new-tab',
        icon: path + '/resources/feed_delete.png',
        handler: function(){
          var selectRecord = receivePanel.getSelectionModel().getSelections();
          if (Ext.isEmpty(selectRecord) || selectRecord.length === 0) {
            alert('请选择要删除的记录');
            return;
          }
          for (var i = 0; i < selectRecord.length; i++) {
            var record = selectRecord[i];
            receivePanel.getStore().remove(record);
          }
        }
      }]
    });
    var receivePanel = new Ext.grid.GridPanel({
      store: receiveStore,
      cm: colms,
      sm: sm,
      id: 'receiveGrid',
      autoExpandColumn: 'empName',
      height: 158,
      width: 254,
      frame: false,
      bbar: bar
    });
    return receivePanel;
  },
  addEmpToGrid: function(empCode, empName){
		var receiveStore = Ext.getCmp('receiveGrid').getStore();
    var initVal = {
      receiver: empCode,
      empName: empName
    }
    var Record = new Ext.data.Record.create([{
      name: 'empName'
    }, {
      name: 'receiver'
    }])
    var record = new Record(initVal);
    receiveStore.insert(0, record);
  },
  addNewFileToGrid: function(editFilePanel, fileName, fileId){
    var initVal = {
      fileId: fileId,
      fileName: fileName,
      operType: 'add'
    }
    var Record = new Ext.data.Record.create([{
      name: 'fileId',
      mapping: 'file_id'
    }, {
      name: 'fileName',
      mapping: 'file_name'
    }, {
      name: 'operType'
    }])
    var record = new Record(initVal);
    var nIdNew = 0;
    editFilePanel.getStore().insert(nIdNew, record);
    
    record.dirty = true;
    record.modified = initVal;
    if (editFilePanel.getStore().modified.indexOf(record) == -1) {
      editFilePanel.getStore().modified.push(record);
    }
  },
  onAddFile: function(pThis){
    var filewin = new Ext.Window({
      height: 120,
      width: 450,
      id: 'fileWindow',
      layout: 'fit',
      closable: true,
      hideBorders: true,
      defaults: {
        bodyStyle: 'padding:10px '
      },
      title: '添加附件',
      items: new Ext.form.FormPanel({
        id: 'fileForm',
        border: false,
        layout: 'table',
        fileUpload: true,
        layoutConfig: {
          columns: 2
        },
        items: [{
          border: false,
          width: 90,
          html: '&nbsp;&nbsp;&nbsp;&nbsp;<font size="2">文件名：</font>'
        }, {
          layout: 'form',
          border: false,
          items: [{
            xtype: 'fileuploadfield',
            hideLabel: true,
            labelStyle: 'text-align:right;',
            name: 'file',
            id: 'file',
            width: 320,
            buttonText: '浏览...',
            listeners: {
              'fileselected': function(fb, v){
                var fileName = "";
                if (Ext.isWindows) {
                  fileName = v.substring(v.lastIndexOf('\\') + 1, v.length);
                }
                else {
                  fileName = v.substring(v.lastIndexOf('/') + 1, v.length);
                }
                Ext.getCmp('fileName').setValue(fileName);
              }
            }
          }, {
            xtype: 'hidden',
            name: 'fileName',
            id: 'fileName'
          }]
        }],
        buttonAlign: 'center',
        buttons: [{
          text: '确定',
          handler: function(){
            var fileName = Ext.getCmp('fileName').getValue();
            if (Ext.isEmpty(fileName)) {
              alert('请选择文件！');
              return;
            }
            var form = Ext.getCmp('fileForm');
            form.getForm().submit({
              url: 'uploadMessageFile.action',
              waitMsg: '正在上传文件，请稍候...',
              success: function(form, response){
                if (response.result.success) {
                  var grid = Ext.getCmp('editFileGrid');
                  var fileName = Ext.getCmp('fileName').getValue();
                  var fileId = response.result.id;
                  filewin.close();
                  pThis.addNewFileToGrid(grid, fileName, fileId);
                }
              }
            })
          }
        }]
      })
    });
    filewin.show();
    filewin.center();
  },
  saveMessage: function(action, messState){
    var pThis = this;
    var form = Ext.getCmp('newMessageForm');
    if (form.getForm().isValid()) {
      Ext.getCmp("editFileGrid").getSelectionModel().selectAll();
      var selectFileRecord = Ext.getCmp("editFileGrid").getSelectionModel().getSelections();
      var selectReceiverRecord = Ext.getCmp("receiveGrid").getSelectionModel().getSelections();
      var fileString = "";
      for (var i = 0; i < selectFileRecord.length; i++) {
        if (!Ext.isEmpty(fileString)) {
          fileString += ",";
        }
        fileString += selectFileRecord[i].get("fileId");
      }
      var receiverString = "";
      for (var i = 0; i < selectReceiverRecord.length; i++) {
        if (!Ext.isEmpty(receiverString)) {
          receiverString += ",";
        }
        receiverString += selectReceiverRecord[i].get("receiver");
      }
      form.getForm().submit({
        url: 'saveMessage.action',
        params: {
          action: action,
          receiverString: receiverString,
          fileString: fileString,
          messState: messState
        },
        waitMsg: '正在保存数据，请稍候...',
        success: function(form, o){
          pThis.showMsg('提示信息', o.result.sign);
          pThis.newWin.close();
        }
      });
    }
  },
  messageShow: function(jsonParams){
		var pThis = this;
    var messId = jsonParams.messId;
		var sender = jsonParams.sender;
    var empName = jsonParams.empName;
    var sendTime = jsonParams.sendTime;
		var flag = jsonParams.flag;
    var win = new Ext.Window({
      height: 450,
      width: 820,
      layout: 'fit',
      id: 'messageWindow',
      closable: true,
      tbar: [{
        text: '回复',
        iconCls: 'new-tab',
        icon: path + '/resources/icon-add.gif',
        handler: function(){
					var messTitle = Ext.get('messTitle').dom.innerHTML;
          win.close();
          pThis.newOrEditMessage();
					pThis.addEmpToGrid(sender, empName);
					Ext.getCmp('messTitle').setValue('Re: ' + messTitle);
        }
      }],
      items: {
        layout: 'fit',
        border: false,
        items: {
          layout: 'table',
          border: false,
          defaults: {
            bodyStyle: Ext.isIE ? 'padding:10px ' : 'padding:8px '
          },
          layoutConfig: {
            columns: 1
          },
          items: [{
            border: false,
            height: 25,
            html: '<span style="font-size:11px">发&nbsp;&nbsp;送&nbsp;&nbsp;人：&nbsp;&nbsp;' + empName + '</span>'
          }, {
            border: false,
            height: 25,
            html: '<span style="font-size:11px">发送时间：&nbsp;&nbsp;' + sendTime.substring(0, 19) + '</span>'
          }, {
            border: false,
            height: 25,
            html: '<div style="font-size:11px">主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：&nbsp;&nbsp;<span id="messTitle"></span></div>'
          }, {
            border: false,
            items: {
              html: '<div id="messCont" style="font-size:11px;overflow:auto;width:780px;height:250px;"></div>'
            }
          }, {
            border: false,
            height: 25,
            html: '<div style="font-size:11px">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件：&nbsp;&nbsp;<span id="messFile"></span></div>'
          }]
        }
      }
    });
		win.show();
    Ext.Ajax.request({
      url: 'getMessage.action',
      params: {
        ruleID: 'gmap-message.getMessageByParams',
        messId: messId
      },
      callback: function(o, success, res){
        if (success) {
          var result = Ext.util.JSON.decode(res.responseText);
          Ext.get('messTitle').dom.innerHTML = result[0].messTitle;
          Ext.get('messCont').dom.innerHTML = result[0].messCont;
          //Ext.getCmp('messCont').setValue(result[0].messCont);
          Ext.getCmp('messageWindow').setTitle(result[0].messTitle);
        }
      }
    });
    Ext.Ajax.request({
      url: 'getJsonData.action',
      params: {
        ruleID: 'gmap-message.getMessageFile',
        messId: messId
      },
      callback: function(o, success, res){
        if (success) {
          var result = Ext.util.JSON.decode(res.responseText);
          var messCont = "";
          if (result.length > 0) {
            for (var i = 0; i < result.length; i++) {
              if (!Ext.isEmpty(messCont)) {
                messCont += "&nbsp;&nbsp;";
              }
              messCont += "<a href='downloadMessageFile.action?fileId=" + result[0].file_id + "' target=_blank>";
              messCont += result[0].file_name;
              messCont += "</a>";
            }
            Ext.get('messFile').dom.innerHTML = messCont;
          }
        }
      }
    })
  }
})
var MessageOper = new ufgov.portal.portlet.MessageOper();
