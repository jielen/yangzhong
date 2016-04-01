ufgov.portal.portlet.UserProfileEdit = Ext.extend(ufgov.portal.Base, {
    winEdit: null, //全部显示时使用的窗口
    winPwd : null,   
    winTitle:'用户信息编辑',
	userId:'',
	empCode:'',
    init: function(){
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
           this.userId = this.constructor.arguments[0].userId;
        } ;
		
        var pThis = this;
	    var recordTypePosition=[
			{
		        name: 'coCode'
 			}, {
		        name: 'coName'	
 			}, {
		        name: 'orgCode'							
		    }, {
		        name: 'orgName'
 			}, {
		        name: 'posiCode'				
		    }, {
		        name: 'posiName'
		    }
		];
		
        var dsPosition = ufgov.portal.portlet.UserProfileEdit.superclass.getInitDs(recordTypePosition, "asService.getListPageByUserCode_AsEmpPosition", "userCode,nd");

        var colPosition = new Ext.grid.ColumnModel([
		{
            header: '单位',
            dataIndex: 'coCode'
        }, {
            header: '单位名称',
            dataIndex: 'coName',
            id: 'coName'
 		}, {
            header: '科处室代码',
            dataIndex: 'orgCode'
 		}, {
            header: '科处室名称',
            dataIndex: 'orgName'
 		}, {
            header: '职位码',
            dataIndex: 'posiCode'
 		}, {
            header: '职位名称',
            dataIndex: 'posiName',
            id: 'posiName'
        }
		]);
		
        var gridPosition = new Ext.grid.GridPanel({
            autoScroll: true,
            title: '',
            cm: colPosition,
            ds: dsPosition,
            resizable: true,
            bodyStyle: 'width:100%',
            height:183,
            autoWidth: true,
            autoExpandColumn: 'posiName'
        });
		
       var recordTypeGroup=[
			{
		        name: 'groupId'
 			}, {
		        name: 'groupName'	
 			}, {
		        name: 'groupDesc'							
		    }
	   ];
       var dsGroup = ufgov.portal.portlet.UserProfileEdit.superclass.getInitDs(recordTypeGroup, "asService.getListPageByUserCode_asUserGroup", "userCode");
	   
	   var colGroup = new Ext.grid.ColumnModel([
		{
            header: '组代码',
            dataIndex: 'groupId'
        }, {
            header: '组名称',
            dataIndex: 'groupName',
            id: 'groupName'
 		}
		, {
            header: '备注',
            dataIndex: 'groupDesc',
            id: 'groupDesc'
 		}
		]);
       var gridGroup = new Ext.grid.GridPanel({
            autoScroll: true,
            title: '',
            cm: colGroup,
            ds: dsGroup,
            resizable: true,
            bodyStyle: 'width:100%;',
            height:183,
            autoWidth: true,
            autoExpandColumn: 'groupDesc'
        });
		
		pThis.winPwd = new Ext.Window({
	        labelAlign: 'top',
	        title: '密码修改',
			closeAction: 'hide',
		    modal: true,
	        width: 300,
	        resizable :false,
			layout: 'form',
			 bodyStyle:'padding:5 0 0 15',
			labelWidth: 100,
	        items: [
			        {
	                    xtype:'textfield',
	                    fieldLabel: '请输入旧密码',
	                    name: 'oldPwd',
						inputType:'password',
	                    anchor:'95%'
	                },
			        {
	                    xtype:'textfield',
	                    fieldLabel: '请输入新密码',
	                    name: 'newPwd',
						inputType:'password',
	                    anchor:'95%'
	                },
			        {
	                    xtype:'textfield',
	                    fieldLabel: '请再输入新密码',
	                    name: 'newPwdTry',
						inputType:'password',						
	                    anchor:'95%'
	                }
				],
	        buttons: [
			{
	             text: '确定'
				,handler:function () {
				   if(!Boolean(Ext.get('newPwd').dom.value)) {
				   	  alert('请输入新密码');
				   	  Ext.get('newPwd').focus();
				   	  return  ;
				   }
				   if(Ext.get('newPwd').dom.value!=Ext.get('newPwdTry').dom.value) {
				   	  alert('两次新密码输入不一致');
				   	  Ext.get('newPwdTry').focus();
				   	  return  ;
				   }
		            pThis.showSaveProgressBar('执行过程中，请稍候...');
		            pThis.executeAjax(function(json){
		                pThis.hideSaveProgressBar();
		                alert(json.message);
		                if (json.success) {
							pThis.winPwd.hide();
		                }
		             }
					 , "asService.updateUserPwd",Ext.get('empCode').dom.value ,Ext.get('oldPwd').dom.value,Ext.get('newPwd').dom.value);
				   
				   
 		        }
	        }
			,{
	            text: '取消'
				,handler:function () {
				   		  pThis.winPwd.hide();
 		        }
	        }
			]
       });
	   
       pThis.executeAjax(function(json){
    	   pThis.empCode=json.empCode;
		   pThis.winEdit = new Ext.Window({
		       labelAlign: 'top',
		       title: pThis.winTitle,
			   closeAction: 'close',
			   modal: true,
			   resizable :false,
		       width: 700,
		       items: [{
		            layout:'column',
					border:false,
					xtype:'form',
					id: 'frmUpdate',
					fileUpload: true, //文件上传标志
					defaults:{bodyStyle:'padding:15 0 0 15'},
		            items:[{
		                columnWidth:.4,
						labelWidth: 60,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    fieldLabel: 'ID',
		                    name: 'empCode',
							value:json.empCode,
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    fieldLabel: '姓名',
		                    name: 'empName',
							value:json.empName,
		                    anchor:'95%'
		                }, {
		                    xtype:'textfield',
		                    fieldLabel: '职称',
		                    name: 'titleTech',
							value:json.titleTech,
		                    anchor:'95%'
		                }, {
		                    xtype:'textfield',
		                    fieldLabel: 'email',
							vtype:'email',
		                    name: 'email',
							value:json.email,
		                    anchor:'95%'
						}, {
		                    xtype:'combo',
		                    fieldLabel: '允许登录',
		                    name: 'isLogin',
							store: new Ext.data.SimpleStore({
					            fields: ["key", "val"],
					            data: [['Y', '是'], ['N', '否']]
					        }),		
							valueField: "key",
					        displayField: "val",
					        disabled: true,
					        typeAhead: true,
					        mode: 'local',
					        triggerAction: 'all',
					        editable: false,
					        emptyText: '请选择...',
							value:json.isLogin,	
							hiddenName: 'isLogin',
		                    anchor:'95%'
						}, {
		                    xtype:'textfield',
		                    fieldLabel: '帐号代码',
		                    name: 'userId',
							value:json.userId,
							readOnly:true,
		                    anchor:'95%'
						}, {
		                    xtype:'textfield',
		                    fieldLabel: '人员排序',
		                    name: 'empIndex',
							value:json.empIndex,
		                    anchor:'95%'
		                }
						]
		            },{
		                columnWidth:.6,
						labelWidth: 60,
		                layout: 'form',
		                border:false,
		                items: [{
 							xtype:'combo',
		                    fieldLabel: '性别',
		                    name: 'sex',
							store: new Ext.data.SimpleStore({
					            fields: ["key", "val"],
					            data: [['1', '男'], ['0', '女']]
					        }),		
							valueField: "key",
					        displayField: "val",
					        typeAhead: true,
							hiddenName: 'sex',
					        mode: 'local',
					        triggerAction: 'all',
					        editable: false,
							value:json.sex,	
					        emptyText: '请选择...',							
		                    anchor:'95%'		                    
		                },{
		                    xtype:'textfield',
		                    fieldLabel: '电话',
		                    name: 'phone',
							value:json.phone,							
		                    anchor:'95%'
		 				},{
		                    xtype:'textfield',
		                    fieldLabel: '身份证号',
		                    name: 'identityCard',
							value:json.identityCard,							
		                    anchor:'95%'
						},{
		                    xtype:'textfield',
		                    fieldLabel: '内部qq',
		                    name: 'rtxuin',
							value:json.rtxuin,							
		                    anchor:'95%'			
						},{
		                    xtype:'textfield',
		                    fieldLabel: '证书序号',
		                    name: 'caSerial',
							value:json.caSerial,								
		                    anchor:'95%'		
						},{
		                    xtype:'fieldset',
							layout:'table',
							border: false,
							height:35,
		                    items:[
								{
				                    xtype:'label',
				                    text: '照片:',
									width:58,
				                    anchor:'95%'		
						        },{
				                    xtype:'fileuploadfield',
									buttonText:'浏览...',
				                    id: 'photo',
									width:280,
									hidden:Boolean(json.photoBlobid),
									value:'',
				                    anchor:'95%'		
						        },{
				                    xtype:'button',
				                    id: 'bnDelPhoto',
								    text:'删除',
								
				                    anchor:'95%',
								    handler:function () {
										
					   					if (Ext.getCmp('photo').isVisible()) {
											Ext.get('photo').dom.value='';
											return;
										}	
										delPhoteFromDb(json.empCode);
										
	 		        				}
						        },{
				                    xtype:'button',
				                    id: 'bnViewPhoto',
									text:'查看',
									hidden:!Boolean(json.photoBlobid),
									listeners:{
										'click':function(){
											bnViewPhoto_click();
										}
									},	   
				                    anchor:'95%'		
						        },{
				                    xtype:'textfield',
				                    id: 'photoFileName',
									width:280,
									inputType: 'hidden',
									value:''
						        },
								{
				                    xtype:'textfield',
				                    id: 'photoBlobid',
									width:1,
									value:json.photoBlobid,
									inputType: 'hidden'
						        }
								
							]
		                }]
		            }]
		        },{
		            xtype:'tabpanel',
		            plain:true,
		            activeTab: 0,
		            height:235,
		            defaults:{bodyStyle:'padding:10px'},
		            items:[{
		                title:'任职情况',
		                layout:'form',
		                defaults: {width: '100%'},
		                items: [gridPosition]
		            },{
		                title:'用户组',
		                layout:'form',
		                items: [gridGroup]
		            }]
		        }],
		
		        buttons: [
				{
	              text: '密码修改'
				  ,handler:function () {
				  	          var oldPwd=Ext.getDom("oldPwd");
							  if (Boolean(oldPwd))   oldPwd.value='';
							  
				  	          var newPwd=Ext.getDom("newPwd");
							  if (Boolean(newPwd))   newPwd.value='';
				  	
				  	          var newPwdTry=Ext.getDom("newPwdTry");
							  if (Boolean(newPwdTry))   newPwdTry.value='';
							  
					   		  pThis.winPwd.show();
	 		               }
		        }
				,{
		            text: '保存'
				    ,handler:function () {
					   saveData();	
	 		         }					
		        }
				,{
		            text: '关闭'
				    ,handler:function () {
					   	pThis.winEdit.hide();
	 		        }
		       }
			   ]
	       });
		   
		   pThis.winEdit.on('show',function(){
			   var empCodes=Ext.query('[name=empCode]',pThis.winEdit.el.dom);
			   Ext.get(empCodes[0].id).up('.x-form-item').setDisplayed(false);
			})
		   pThis.winEdit.show();
		  
		   dsPosition.load({  params: {userCode: pThis.empCode,nd:document.getElementById("svNd").getAttribute("value")} });	
		   dsGroup.load({  params: {userCode: pThis.userId}    });	
        }, "asService.selectByUserId_AsEmp", pThis.userId);
		
		//保存
		function saveData(){
			var frm=Ext.getCmp('frmUpdate').getForm();
			Ext.get('photoFileName').dom.value='';
			if (Ext.get('photo').isVisible()) {
				var fileName = Ext.get('photo').dom.value;
				if (Boolean(fileName)){
					var ext = String(fileName.match(/[^\.]+$/));
					if (!ext || ext.toLowerCase() != 'jpg' &&　ext.toLowerCase() != 'bmp' &&　ext.toLowerCase() != 'gif' && 　ext.toLowerCase() != 'png') {
	                    alert('文件:\''+fileName+'\'不是照片类型！');
						return ;
					}
					
					var index = fileName.lastIndexOf("\\");
					Ext.get('photoFileName').dom.value=encodeURIComponent(fileName.substring(index + 1));
				}
				
			}
			//alert(frm.getEl().dom.enctype);
			//frm.getEl().dom.enctype =  'multipart/form-data';
		    pThis.showSaveProgressBar('保存过程中，请稍候...');
			frm.submit({
				url: path + '/userProfileEditAction.action',
				success: function(form, action){
					pThis.hideSaveProgressBar();
					if (!action || ! action.result) {
                    	alert('保存失败！');
                    	return false;
                	}
					alert(action.result.msg);
					Ext.get('photoBlobid').dom.value=action.result.photoBlobid;
					Ext.get('photo').dom.value='';
					Ext.get('photo').setVisibilityMode(Ext.Element.VISIBILITY);
					Ext.getCmp('photo').setVisible(!Boolean(action.result.photoBlobid))
 					Ext.getCmp('bnViewPhoto').setVisible(Boolean(action.result.photoBlobid))					
				},
				failure: function(){
					pThis.hideSaveProgressBar();
					alert("系统错误，操作失败！");
				}
			});
			
		}
		
		//删除附件
        function delPhoteFromDb(empCode) {
			Ext.Msg.confirm("系統提示", "确认删除照片吗?", function(btn){
            if (btn != 'yes')    return;
            pThis.showSaveProgressBar('正在删除照片，请稍候...');
            pThis.executeAjax(function(json){
                pThis.hideSaveProgressBar();
                alert(json.message);
                if (json.success) {
					Ext.get('photoBlobid').dom.value='';
					Ext.get('photo').setVisibilityMode(Ext.Element.VISIBILITY);
					Ext.getCmp('photo').setVisible(true);
					Ext.get('photo').dom.value='';
 					Ext.getCmp('bnViewPhoto').setVisible(false);
                }
             }
			 , "asService.updateClearAsEmpPhoto",empCode);
          })
		}
		
		//文件查看
    	function bnViewPhoto_click(){
	        var formObj = document.createElement("form");
	        var inputObj = document.createElement("input");
	        inputObj.name = 'fileid';
	        inputObj.type = 'text';
	        inputObj.value =Ext.get('photoBlobid').dom.value;
	        
	        formObj.action = path + '/fileDownload.action';
	        formObj.target = '_blank';
	        document.documentElement.appendChild(formObj);
	        formObj.appendChild(inputObj)
	        formObj.submit();
        }
		
		
		
    }
	//公共销毁函数
    ,destroy: function(){
		if (this.winEdit) {
			this.winEdit.destroy();
			this.winEdit=null;
		}
    }
    
});

Ext.reg('userProfileEdit', ufgov.portal.portlet.UserProfileEdit);

