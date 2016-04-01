/**
 * 登录频道
 * @class ufgov.portal.portlet.LoginPortlet
 */
ufgov.portal.portlet.LoginPortlet = Ext.extend(ufgov.portal.Base,{
	panel: null,
	init: function(){
		try{
			if (token) {
				this.panel = new Ext.Panel({
					border: false,
					title: '用户信息',
					items: {
						border: false,
						layout: 'table',
						defaults: {
							bodyStyle: 'padding:5px'
						},
						layoutConfig: {
							columns: 2
						},
						items:[{
							border: false,
							html: '登录用户：'
						},{
							border: false,
							html: document.getElementById("svUserName").getAttribute("value")
						},
						{
							border: false,
							html: '部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：'
						},{
							border: false,
							html: document.getElementById("svOrgName").getAttribute("value")
						},
						{
							border: false,
							html: '登录时间：'
						},{
							border: false,
							html: loginTime
						}]
					}
				});
			}else{
				this.initLoginPanel();
			}
		}
		catch(e) {
			this.initLoginPanel();
		}
	},
	initLoginPanel: function(){
		//debugger;
		var pThis = this;
		var iparray = PF.joinArray(ipData);
		var userList = this.getUserList();
		var userArray = this.userListAware(userList);
		var userStore = new Ext.data.SimpleStore({
			fields: ['users'],
			data : userArray
		});
		this.panel = new Ext.form.FormPanel({
			border: false,
			id: 'loginForm',
			title: "用户登录",
			standardSubmit: true,
			items: {
				border: false,
				layout: 'table',
				defaults: {
					bodyStyle: 'padding:5px'
				},
				layoutConfig: {
					columns: 1
				},
				items: [{
					layout: 'form',
					border: false,
					labelWidth: 80,
					items: {
						xtype: 'combo',
						labelStyle: 'text-align: right;',
						fieldLabel: '用户名',
						store: userStore,
			            valueField:'users',      // option.value
			            typeAhead: true,
			            name:'username',
			            displayField: 'users',      // option.text
			            triggerAction: 'all',
			            emptyText:'请输入用户名',
			            mode: 'local',
			            //selectOnFocus:true,
			            enableKeyEvents: true,
						width: 120,
						listeners: {
							keydown: function(thisField, e){
								if(e.keyCode == '13'){
									Ext.get('password').focus();
								}
							}
						}
						
					}
				}, {
					layout: 'form',
					border: false,
					labelWidth: 80,
					items: [{
						xtype: 'textfield',
						fieldLabel: '密&nbsp;&nbsp;&nbsp;码',
						labelStyle: 'text-align: right;',
						inputType: 'password',
						name: 'password',
						width: 120,
						enableKeyEvents: true,
						listeners: {
							keydown: function(thisField, e){
								if(e.keyCode == '13'){
									Ext.getCmp('loginButton').fireEvent('click');
								}
							}
						}
					}, {
						xtype: 'hidden',
						name: 'url',
						value: 'portalDispatcher.action'
					}, {
						xtype: 'hidden',
						name: 'iparray',
						value: iparray
					}, {
						xtype: 'hidden',
						name: 'caSerialNo',
						value: caSerialNo
					}]
				}]
			},
			buttons: [{
				text: '登录',
				id: 'loginButton',
				listeners: {
					click: function(){
						if (Ext.getCmp('loginForm').getForm().isValid()) {
							if (Ext.get('username').dom.value === '') {
								alert('用户名不能为空');
								Ext.get('username').focus();
								return false;
							}
							userList = pThis.insertUser(userList, Ext.get('username').dom.value);
							pThis.jointCookieStr(userList);
							Ext.getCmp('loginForm').getForm().getEl().dom.action = "login.action";
							Ext.getCmp('loginForm').getForm().getEl().dom.method = "POST";
							Ext.getCmp('loginForm').getForm().submit();
						}
					}
				}
			}]
		});
	},
	getUserList: function(){
		if(null == document.cookie) return new Array();
		var value = PF.getCookie("username");
		if(value){
			return value.split(",");
		}
		return new Array();
	},
	insertUser: function(userList, userName){
		for(var i = 0; i < userList.length; i++){
			if(userName.trim() == userList[i].trim())
				return userList;
		}
		userList.push(userName);
		userList.sort();
		return userList;
	},
	jointCookieStr: function(userList){
		PF.setCookie("username", userList);
	},
	userListAware: function(userList){
			var resArray = [];
			for(var i = 0; i < userList.length; i++){
				var rowArray = new Array();
				rowArray[0] = userList[i];
				resArray[resArray.length] = rowArray;
			}
			return resArray;
	}
});

