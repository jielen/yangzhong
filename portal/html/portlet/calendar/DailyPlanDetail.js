ufgov.portal.portlet.DailyPlanDetail = Ext.extend(ufgov.portal.Base, {
	winEdit : null, // 全部显示时使用的窗口
	winPwd : null,
	winTitle : '日程信息编辑',
	dailyPlanId : '',
	callbackFunc:null,
	dsCmb:null,
	init : function() {
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			this.dailyPlanId = this.constructor.arguments[0].dailyPlanId;
		};
	},
	passParam : function(callbackFunc) {
			var pThis = this;
			this.callbackFunc=callbackFunc;
			//下拉框DS的Field信息内容 
			var cmbRecordType = [{
					name : 'valId'
				 }, {
					name : 'val'
			     }];

			pThis.dsCmb = pThis.getDs(cmbRecordType
					, 'asService.getListByValsetId_AsVal'
					,'valsetId'
					, new ufgov.portal.common.Param('VS_AP_DAILY_PLAN_TYPE', '','valsetId')
			);
			
			//增加ds的beforeload事件
			pThis.dsCmb.on('load', function() {
				if (Ext.isEmpty(pThis.dailyPlanId)) {
					pThis.createWin({});
				} else {
					pThis.showSaveProgressBar('执行过程中，请稍候...');
					pThis.executeAjax(function(json) {
						        pThis.hideSaveProgressBar();
						        if (json.ret==false && json.message) {
						        	alert(json.message);
						        	return;
						        }	
								pThis.createWin(json);
							}, "apService.selectByPrimaryKey_ApDailyPlan", pThis.dailyPlanId);
				    }		
			   });
	       }
	// 创建编辑窗口
	,
	createWin : function(json) {
		var pThis = this;
		// 保存
		var updateFrom=null;
		function  deleteData() {
			pThis.showSaveProgressBar('删除过程中，请稍候...');
			pThis.executeAjax(function(json) {
				pThis.hideSaveProgressBar();
   			     if (json.ret==false && json.message) {
   			        alert(json.message);
   			        return;
   			     }	
   			   
   			     pThis.dailyPlanId='';
   				 if (typeof pThis.callbackFunc == 'function') {
   					pThis.callbackFunc(pThis.dailyPlanId,true);
     			 } else {
     				  alert('删除成功!');
     			 }	 
   				 pThis.winEdit.hide();
				}, "apService.deleteByPrimaryKey_ApDailyPlan", pThis.dailyPlanId);					    	         
		}	
		
		function saveData() {
			
			if (Ext.isEmpty(updateFrom.getValues().title)) {
				alert("请输入标题!" );
				updateFrom.findField('title').focus();
				return;
			}	
			
		
			if (Ext.isEmpty(updateFrom.getValues().type)) {
				alert("请选择类型!" );
				updateFrom.findField('typeName').focus();
				return;
			}	
			
				
			if (Ext.isEmpty(updateFrom.getValues().startDate)) {
				alert("请选择开始时间!" );
				updateFrom.findField('startDate').focus();
				return;
			}
			
			if (Ext.isEmpty(updateFrom.getValues().endDate)) {
				alert("请选择结束时间!" );
				updateFrom.findField('endDate').focus();
				return;
			}
			
			if (!Ext.isEmpty(updateFrom.getValues().endDate) && updateFrom.getValues().endDate<= updateFrom.getValues().startDate) {
				alert("结束时间必须大于开始时间!" );
				updateFrom.findField('endDate').focus();
				return;
			}
			if (updateFrom.getValues().awoke=='yes') {
				if (Ext.isEmpty(updateFrom.getValues().awokeTime)) {	
					alert("请选择提醒时间!" );
					updateFrom.findField('awokeTime').focus();
					return;
				} else {
					if (!Ext.isEmpty(updateFrom.getValues().awokeTime) && updateFrom.getValues().awokeTime<= updateFrom.getValues().startDate) {
						alert("提醒时间必须大于开始时间!" );
						updateFrom.findField('awokeTime').focus();
						return;
					}	
				}	
			}
			
			pThis.showSaveProgressBar('保存过程中，请稍候...');
			
			pThis.submitAjax(function(sucess,form, action) {
				pThis.hideSaveProgressBar();
				if (!sucess || !action || !action.result) {
					alert('保存失败！');
					return false;
				};

				pThis.dailyPlanId = action.result.id;
				if (typeof pThis.callbackFunc == 'function') {
					pThis.callbackFunc(pThis.dailyPlanId,true);
				} else {
					alert(action.result.msg);					
				}	

				
			},updateFrom, "apService.saveApDailyPlan", 0
			    ,new ufgov.portal.common.Param('', 'com.ufgov.portal.tools.ap.domain.ApDailyPlan','apDailyPlan')
			);
			
			
		}
		
		
		
		pThis.winEdit = new Ext.Window({
					labelAlign : 'top',
					title : pThis.winTitle,
					closeAction : 'close',
					modal : true,
					width : 520,
					items : [{
						layout : 'form',
						xtype:'form',
						id: 'frmUpdate',
						labelAlign : 'right',
						labelWidth : 85,
						border : false,
						items : [{
									xtype : 'textfield',
									fieldLabel : 'id',
									name : 'id',
									value : Ext.isEmpty(json.id)?0:json.id,
								    allowBlank: true,
									anchor : '92%'
								},{
									xtype : 'textfield',
									fieldLabel : '标题',
									name : 'title',
									value : json.title,
								    allowBlank: false,
									anchor : '92%'
								}, {
									xtype : 'combo',
									fieldLabel : '类型',
									dataIndex : 'typeName',
									store : pThis.dsCmb,
									valueField : 'valId',
									displayField : 'val',
									typeAhead : true,
									mode : 'local',
									triggerAction : 'all',
									editable : false,
									emptyText : '请选择...',
									value : json.type,
									hiddenName : 'type',
									allowBlank: false,
									anchor : '92%'

								}, {
									xtype : 'datefield',
									fieldLabel : '开始时间',
									name : 'startDate',
									value : json.startDate?json.startDate.substring(0,16):'',
									format : 'Y-m-d H:i',
									anchor : '92%',
									menu : new DatetimeMenu(),
									readOnly : true,
									allowBlank: false,
									showToday : true
								}, {
									xtype : 'datefield',
									fieldLabel : '结束时间',
									name : 'endDate',
									value : json.endDate?json.endDate.substring(0,16):'',
									menu : new DatetimeMenu(),
									format : 'Y-m-d H:i',
									anchor : '92%',
									readOnly : true,
									allowBlank: false,
									showToday : false
								}

								, {
									xtype : 'fieldset',
									layout : 'table',
									border : false,
									//autoHeight : true,
									height:30,
									items : [{
												xtype : 'label',
												html : '提醒设置:',
												width : 72

											}, {
												xtype : 'label',
												html : '&nbsp;',
												width : 20
											}, {
												xtype : 'radio',
												boxLabel : '不提醒',
												name : 'awoke',
												dataIndex:'awoke0',
												checked : json.awoke != 'yes',
												inputValue : 'no',
												handler:function() {
													if (updateFrom.getValues().awoke=='no') {
														 updateFrom.setValues({awokeTime:''});
													}	
												},
												width : 140

											}, {
												xtype : 'radio',
												boxLabel : '提醒',
												checked : json.awoke == 'yes',
												name : 'awoke',
												dataIndex:'awoke1',
												inputValue : 'yes',
												width : 60
											}, {
												xtype : 'datefield',
												fieldLabel : '提醒时间',
												name : 'awokeTime',
												menu : new DatetimeMenu({
												    onSelected:function(menu,date, pickek){
													    updateFrom.setValues({awoke1:'yes'}); 
												    }
												}),
												value : json.awoke == 'yes' && !Ext.isEmpty(json.awokeTime)?json.awokeTime.substring(0,16):null,
												format : 'Y-m-d H:i',
												readOnly : true,
												showToday : false,
												width : 173
											}

									]
								}
							, {
									xtype : 'textarea',
									fieldLabel : '事由',
									name : 'content',
									value : json.content,
									height : 150,
									anchor : '92%'
							}
						]

					}],

					buttons : [
					       {
								text : '删除',
								handler : function() {
					    	       if(Ext.isEmpty(pThis.dailyPlanId)) {
					    	    	   alert('新增日程中，没必要删除！');
					    	       } else { 	
					    	    	   Ext.Msg.confirm('系统提示', '确认删除吗？',
										function(btn) {
											if (btn != 'yes') return;
											  deleteData();
										})
					    	    	   
					    	       }
								}
							},{
								text : '保存',
								handler : function() {
									saveData();
								}
							}, {
								text : '关闭',
								handler : function() {
									pThis.winEdit.hide();
								}
							}]
				});

		 pThis.winEdit.on('show',function(){
			   var ids=Ext.query('[name=id]',pThis.winEdit.el.dom);
			   Ext.get(ids[0].id).up('.x-form-item').setDisplayed(false);
			})
		pThis.winEdit.show();
		updateFrom = Ext.getCmp('frmUpdate').getForm();
		
		
		
		
		
		
		var el =updateFrom.findField('endDate').el;
		new Ext.KeyMap(el, {
		    key: Ext.EventObject.DELETE, 
		    fn: function(){
			updateFrom.findField('endDate').setValue("");
			}
		});
		el =updateFrom.findField('awokeTime').el;
		new Ext.KeyMap(el, {
		    key: Ext.EventObject.DELETE, 
		    fn: function(){
				updateFrom.findField('awokeTime').setValue("");
			}
		});
		
	}
	,// 公共销毁函数
	destroy : function() {
		if (this.winEdit) {
			this.winEdit.destroy();
			this.winEdit = null;
		}
	}

});

function dailyPlanDetailCRUD(id,isDel,callbackFunc) {
	if  (isDel==true) {
		if  (Ext.isEmpty(id)) {
			alert('id不能为空!');
			return;
		}
		
		base.showSaveProgressBar('删除过程中，请稍候...');
		base.executeAjax(function(json) {
			base.hideSaveProgressBar();
			     if (json.ret==false && json.message) {
			        alert(json.message);
			        return;
			     }	
			     alert('删除成功!');
					if (typeof callbackFunc == 'function') {
						callbackFunc(id,true);
  				     }		

			        
				}, "apService.deleteByPrimaryKey_ApDailyPlan", id);
		return ;
		
	}	
	window.dailyPlanDetail = new ufgov.portal.portlet.DailyPlanDetail({
		dailyPlanId : id
	});
	window.dailyPlanDetail.passParam(callbackFunc);
}