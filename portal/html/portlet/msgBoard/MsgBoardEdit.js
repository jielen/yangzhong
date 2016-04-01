ufgov.portal.portlet.MsgBoardEdit = Ext.extend(ufgov.portal.Base, {
	winEdit :null, // 全部显示时使用的窗口
	winTitle :'留言信息编辑',
	msgBoardId :0,
	dsType :null,// 留言类型下拉框DS的Field信息内容
	dsGroup :null, // 创建用户组类型下拉框的DS
	dsStatus :new Ext.data.SimpleStore( {
		fields : [ "key", "val" ],
		data : [ [ '0', '待处理/待审核' ], [ '10', '审核没通过' ], [ '20', '审核过在经办中' ],
				[ '30', '经办完成' ] ]
	}),
	dsReplyType :new Ext.data.SimpleStore( {
		fields : [ "key", "val" ],
		data : [ [ '0', '了结' ], [ '10', '处理完毕' ], [ '20', '处理完毕并通知留言人' ],
				[ '99', '缓办' ] ]
	}),

	/*
	 * *detailType * 10：查看留言基本信息; * 20：查看留言全部信息; * 30: 审核留言; * 40: 处理留言; 00:
	 * 创建或者编辑留言 其他值同00
	 */
	detailType :0,
	idPub :null,
	init : function() {
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			this.dsType = this.constructor.arguments[0].dsType;
			this.dsGroup = this.constructor.arguments[0].dsGroup;
		}
		;

		if (!Boolean(this.dsType)) {
			var cmbType = [ {
				name :'valId'
			}, {
				name :'val'
			} ];
			this.dsType = this.getDs(cmbType,
					"asService.getListByValsetId_AsVal", "valsetId",
					new ufgov.portal.common.Param('VS_AP_MESSAGEBOARD_TYPE', '',
							'valsetId'));
		}

		if (!Boolean(this.dsGroup)) {
			var cmbGroup = [ {
				name :'groupId'
			}, {
				name :'groupName'
			}, {
				name :'groupDesc'
			}

			];
			this.dsGroup = this
					.getDs(cmbGroup, 'asService.getList_AsGroup', '');
		}
	},
	showWindow : function(jsonParam) {
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}
		
		var pThis = this;
		if (!Ext.isEmpty(jsonParam.detailType)) {
			this.detailType = jsonParam.detailType;
		}
	    
		pThis.msgBoardId = 0;
		if (!Ext.isEmpty(jsonParam.msgBoardId)) {
			pThis.msgBoardId = jsonParam.msgBoardId;
		}

		if (!Ext.isEmpty(jsonParam.winTitle)) {
			pThis.winTitle = jsonParam.winTitle;
		}

		
		if (pThis.detailType == 0 && pThis.msgBoardId == 0) {
			this.createWindow( {});
		} else {
			pThis.executeAjax( function(json) {
				pThis.createWindow(json);
			}, 'apService.getMsgBoardByPKAndRight', pThis.detailType,
					pThis.msgBoardId);
		}
	},
	createWindow : function(json) {
		var pThis = this;
		if (pThis.detailType > 0 && Boolean(json.msg)) {
			alert(json.msg);
			return;
		}

		var itemFields = null;
		var buttons = [ {
			text :'关闭',
			handler : function() {
				pThis.winEdit.hide();
			}
		} ];

		pThis.idPub = Ext.id();

	if (pThis.detailType == 10) { // 10：查看留言基本信息
	} else if (pThis.detailType == 20) { // 20：查看留言全部信息
	} else if (pThis.detailType == 30) { // 30：审核留言
		itemFields = [ {
			layout :'column',
			border :false,
			items : [ {
				columnWidth :.5,
				layout :'form',
				border :false,
				labelAlign :'left',
				labelWidth :70,
				items : [ {
					xtype :'textfield',
					name :'id_edit',
					id :pThis.idPub,
					fieldLabel :'编号',
					style :'background:orange',
					value :json.id,
					hidden :false,
					readOnly :true,
					anchor :'97%'
				}, {
					xtype :'combo',
					// id : 'toGroup_edit',
					fieldLabel :'发送科室',
					valueField :'groupId',
					displayField :'groupName',
					hiddenName :'toGroup_edit',
					allowBlank :false,
					value :json.toGroup,
					anchor :'97%',
					triggerAction :'all',
					mode :'local',
					typeAhead :true,
					store :pThis.dsGroup,
					emptyText :'请选择科室'
				}, {
					xtype :'textfield',
					name :'fromPersonName_edit',
					fieldLabel :'留言人姓名',
					value :json.fromPersonName,
					anchor :'97%'
				}

				]
			}, {
				columnWidth :.5,
				layout :'form',
				labelAlign :'left',
				labelWidth :70,
				border :false,
				items : [ {
					xtype :'combo',
					// id : 'type_edit',
					fieldLabel :'留言类型',
					valueField :'valId',
					displayField :'val',
					allowBlank :false,
					hiddenName :'type_edit',
					value :json.type,
					anchor :'97%',
					triggerAction :'all',
					mode :'local',
					typeAhead :true,
					store :pThis.dsType,
					emptyText :'请选择留言类型'
				}, {
					xtype :'textfield',
					name :'fromTel_edit',
					fieldLabel :'留言人电话',
					value :json.fromTel,
					anchor :'97%'
				}, {
					xtype :'textfield',
					name :'fromMail_edit',
					fieldLabel :'留言人邮件',
					value :json.fromMail,
					anchor :'97%'
				} ]
			} ]
		}, {
			xtype :'textfield',
			name :'title_edit',
			fieldLabel :'留言主题',
			allowBlank :false,
			value :json.title,
			anchor :'98%'
		}, {
			xtype :'panel',
			name :'content_edit',
			style:'padding:2 2 2 2',
			fieldLabel :'留言内容',
			html :json.content,
			height :120,
			anchor :'98%'
		}, {
			layout :'column',
			border :false,
			items : [ {
				columnWidth :.5,
				layout :'form',
				border :false,
				labelAlign :'left',
				labelWidth :70,
				items : [
				  {
						xtype :'checkbox',
						name :'status_edit',
						fieldLabel :'审核标志',
						value:json.status==20,
						disabled:Boolean(json.checkTime),
						style :Boolean(json.checkTime)?'':'background:blue;',
						anchor :'97%'
				  },
				  {
					xtype :'textfield',
					name :'toTransactorName_edit',
					fieldLabel :'经办人',
					value :json.toTransactorName,
					anchor :'97%'
				  }
				 ]
			}, {
				columnWidth :.5,
				layout :'form',
				labelAlign :'left',
				labelWidth :70,
				border :false,
				items : [ {
					xtype :'datefield',
					name :'planEndDate_edit',
					fieldLabel :'经办截止日',
					value :json.planEndDate,
					anchor :'97%'
				} ]
			} ]
		} ];
		buttons = [ {
			text :'保存',
			handler : function() {
			    
				saveData();
			}
		}, {
			text :'关闭',
			handler : function() {
				pThis.winEdit.hide();
			}
		} ];
	} else if (pThis.detailType == 40) { // 40：处理留言

	} else { // 创建或者编辑留言
		if (Boolean(userId)) {
			itemFields = [ {
				layout :'column',
				border :false,
				items : [ {
					columnWidth :.5,
					layout :'form',
					border :false,
					labelAlign :'left',
					labelWidth :70,
					items : [ {
						xtype :'textfield',
						name :'id_edit',
						id :pThis.idPub,
						fieldLabel :'编号',
						style :'background:orange',
						value :json.id,
						hidden :false,
						readOnly :true,
						anchor :'97%'
					}, {
						xtype :'combo',
						// id : 'toGroup_edit',
						fieldLabel :'发送科室',
						valueField :'groupId',
						displayField :'groupName',
						hiddenName :'toGroup_edit',
						allowBlank :false,
						value :json.toGroup,
						anchor :'97%',
						triggerAction :'all',
						mode :'local',
						typeAhead :true,
						store :pThis.dsGroup,
						emptyText :'请选择科室'
					} ]
				}, {
					columnWidth :.5,
					layout :'form',
					labelAlign :'left',
					labelWidth :70,
					border :false,
					items : [ {
						xtype :'combo',
						// id : 'type_edit',
						fieldLabel :'留言类型',
						valueField :'valId',
						displayField :'val',
						allowBlank :false,
						hiddenName :'type_edit',
						value :json.type,
						anchor :'97%',
						triggerAction :'all',
						mode :'local',
						typeAhead :true,
						store :pThis.dsType,
						emptyText :'请选择留言类型'
					}

					]
				} ]
			}, {
				xtype :'textfield',
				name :'title_edit',
				fieldLabel :'留言主题',
				allowBlank :false,
				value :json.title,
				anchor :'98%'
			}, {
				xtype :'htmleditor',
				name :'content_edit',
				fieldLabel :'留言内容',
				value :json.content,
				autoWidth :false,
				height :220
			} ];
		} else {
			itemFields = [ {
				layout :'column',
				border :false,
				items : [ {
					columnWidth :.5,
					layout :'form',
					border :false,
					labelAlign :'left',
					labelWidth :70,
					items : [ {
						xtype :'textfield',
						name :'id_edit',
						id :pThis.idPub,
						fieldLabel :'编号',
						style :'background:orange',
						value :json.id,
						hidden :false,
						readOnly :true,
						anchor :'97%'
					}, {
						xtype :'combo',
						// id : 'toGroup_edit',
						fieldLabel :'发送科室',
						valueField :'groupId',
						displayField :'groupName',
						hiddenName :'toGroup_edit',
						allowBlank :false,
						value :json.toGroup,
						anchor :'97%',
						triggerAction :'all',
						mode :'local',
						typeAhead :true,
						store :pThis.dsGroup,
						emptyText :'请选择科室'
					}, {
						xtype :'textfield',
						name :'fromPersonName_edit',
						fieldLabel :'留言人姓名',
						value :json.fromPersonName,
						anchor :'97%'
					}

					]
				}, {
					columnWidth :.5,
					layout :'form',
					labelAlign :'left',
					labelWidth :70,
					border :false,
					items : [ {
						xtype :'combo',
						// id : 'type_edit',
						fieldLabel :'留言类型',
						valueField :'valId',
						displayField :'val',
						allowBlank :false,
						hiddenName :'type_edit',
						value :json.type,
						anchor :'97%',
						triggerAction :'all',
						mode :'local',
						typeAhead :true,
						store :pThis.dsType,
						emptyText :'请选择留言类型'
					}, {
						xtype :'textfield',
						name :'fromTel_edit',
						fieldLabel :'留言人电话',
						value :json.fromTel,
						anchor :'97%'
					}, {
						xtype :'textfield',
						name :'fromMail_edit',
						fieldLabel :'留言人邮件',
						value :json.fromMail,
						anchor :'97%'
					} ]
				} ]
			}, {
				xtype :'textfield',
				name :'title_edit',
				fieldLabel :'留言主题',
				allowBlank :false,
				value :json.title,
				anchor :'98%'
			}, {
				xtype :'htmleditor',
				name :'content_edit',
				fieldLabel :'留言内容',
				value :json.content,
				autoWidth :false,
				height :220
			} ];

		};
		
		buttons = [ {
			text :'保存',
			handler : function() {
				saveData();
			}
		}, {
			text :'关闭',
			handler : function() {
				pThis.winEdit.hide();
			}
		} ];
	}
	if (Boolean(pThis.winEdit)) {
		pThis.winEdit.destroy();
	}

	pThis.winEdit = new Ext.Window( {
		title :pThis.winTitle,
		closeAction :'close',
		modal :true,
		width :620,
		resizable :false,
		defaults : {
			bodyStyle :'padding:15 0 5 15'
		},
		items : [ {
			border :false,
			xtype :'form',
			labelAlign :'left',
			labelWidth :70,
			id :'frmUpdate',
			fileUpload :false, // 文件上传标志
			items :itemFields
		} ],
		buttons :buttons
	});

	pThis.winEdit.on('show', function() {
		var idEl = Ext.get(pThis.idPub);
		if (idEl != null && !idEl.isVisible())
			idEl.up('.x-form-item').setDisplayed(false);
	})
	pThis.winEdit.show();

	// 保存
	function saveData() {
		var frm = Ext.getCmp('frmUpdate').getForm();
		pThis.showSaveProgressBar('保存过程中，请稍候...');
		frm.submit( {
			url :path + '/msgBoardEditAction.action' + '?detailType='
					+ pThis.detailType + '&msgBoardId=' + pThis.msgBoardId,
			success : function(form, action) {
				pThis.hideSaveProgressBar();
				if (!action || !action.result) {
					alert('保存失败！');
					return false;
				}
				alert(action.result.msg);
				pThis.msgBoardId = action.result.id;
				Ext.getCmp(pThis.idPub).setValue(pThis.msgBoardId);
			},
			failure : function() {
				pThis.hideSaveProgressBar();
				alert('系统错误，操作失败！');
			}
		});
	}
},
// 公共销毁函数
	destroy : function() {
		if (this.winEdit) {
			this.winEdit.destroy();
			this.winEdit = null;
		}
	}

});
