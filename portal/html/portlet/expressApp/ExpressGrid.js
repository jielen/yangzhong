
ufgov.portal.portlet.ExpressGrid = Ext.extend(ufgov.portal.Base, {
    panel: null,
    gridAll: null,
    recordSize:5,
    mainPanel:null,
    picPart:null,
    pgPletId:"0",
    userId:'',
    portletTitle:"快捷应用",
    passParam: function(jsonParam){
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}
		if(Ext.isEmpty(jsonParam.id)){
			alert("请传入必要参数pgPletId");
			return;
		}
		if(Ext.isEmpty(userId)){
			alert("请传入必要参数userId");
			return;
		}
		if(Ext.isEmpty(jsonParam.title)){
			alert("请传入必要参数title");
			return;
		}
		if(!Ext.isEmpty(jsonParam.record_size) && "number" == Ext.type(parseInt(jsonParam.record_size))){
			this.recordSize = jsonParam.record_size;
		}
		var pThis=this;
		this.pgPletId = jsonParam.id;
		this.userId = userId;
		this.portletTitle = jsonParam.title;
		
		function processUrl(vsUrl){
	        var result = "";
	        var url = vsUrl;
	        var first = url.indexOf("@");
	        var isCycle = true;
	        
	        if (first > -1) {
	            while ((first > -1) && isCycle) {
	                result += url.substring(0, first);
	                url = url.substr(first + 1);
	                var last = url.indexOf("@");
	                var param;
	                
	                if (last == -1) {
	                    param = url.substr(0, url.length);
	                    isCycle = false;
	                }
	                else {
	                    param = url.substring(0, last);
	                    url = url.substring(last + 1);
	                }
	                
	                if (param == "password") {
	                    var ns = new Array();
	                    var vs = new Array();
	                    ns[0] = "userId";
	                    vs[0] = document.getElementById("svUserId").getAttribute("value");
	                    var password = requestData("getpassword", "all", ns, vs);
	                    result += password.text;
	                }
	                else {
	                    value = document.getElementById(param).getAttribute("value");
	                    result += value;
	                }
	                
	                first = url.indexOf("@");
	                if (first < 0) 
	                    result += url;
	            }
	        }
	        else {
	            result = url;
	        }
	        if (result.indexOf("token") == -1) {
	            if (result.indexOf("?") < 0) {
	                result = result + "?token=" + token;
	            }
	            else {
	                result = result + "&token=" + token;
	            }
	        }
	        return result;
	    }
	       var colM = new Ext.grid.ColumnModel([ {
		    	header: '页面频道编号',
		        dataIndex: 'pgPletId',
		        id: 'pgPletId',
		        hidden: true,
	            sortable: true
		    },{
		        header: '用户名',
		        dataIndex: 'userId',
		        id: 'userId',
		        hidden: true,
	            sortable: true
		    }, {
		        header: '菜单编号',
		        dataIndex: 'menuId',
		        id:'menuId',
		        hidden: true,
	            sortable: true
		    }, {
		        header: '部件代码',
		        dataIndex: 'compoId',
		        hidden: true,
	            sortable: true
		    },{
		        header: '显示标题',
		        dataIndex: 'displayTitle',
		        id: 'displayTitle',
	            sortable: true
		    }, {
		        header: 'url',
		        dataIndex: 'url',
		        id:'url',
		        hidden: true,
	            sortable: true
		    }, {
		        header: '是否去编辑页面',
		        dataIndex: 'isGotoEdit',
		        id: 'isGotoEdit',
		        hidden: true,
	            sortable: true
		    }, {
		        header: '是否总是在新页面打开',
		        dataIndex: 'isAlwaysNew',
		        id: 'isAlwaysNew',
		        hidden: true,
	            sortable: true
		    }
		    ]);
		    
			var recordType = [{
		    	name:'pgPletId'
		    },{
		        name: 'userId'
		    }, {
		        name: 'menuId'
		    }, {
		        name: 'compoId'
		    }, {
		        name: 'displayTitle'
		    }, {
		        name: 'url'
		    }, {
		        name: 'isGotoEdit'
		    }, {
		        name: 'isAlwaysNew'
		  }];
    	var ds = ufgov.portal.portlet.ExpressApp.superclass.getInitDs(recordType, "apService.getListExpressAppPageByPortletId", "pgPletId,userId,start,limit");
	     
	     function onRefresh(){  
	     	var store = pThis.mainPanel.getStore();
	     	store.load({params:{pgPletId:pThis.pgPletId, userId:pThis.userId, start:0, limit:pThis.recordSize}});
		 }  
		 
		 if(jsonParam.content_bg_img){
			var picHtml = '<div><img src=\"' + jsonParam.content_bg_img + '\"></div>';
			this.picPart = new Ext.Panel({
				frame:false,
				//height:100,
				width:160,	
				bodyStyle: 'padding:5px 5px 5px 5px;border:0px solid',
				html:picHtml
			});
		}      
        ds.load({params:{pgPletId:pThis.pgPletId, start:0, limit:pThis.recordSize}});
        this.mainPanel = new Ext.grid.GridPanel({
            autoScroll: true,
            title: '',
            cm: colM,
            ds: ds,
            hideHeaders : true,
            resizable: true,
            bodyStyle: 'width:100%',
            autoWidth: true,
            //height: 150,
            autoExpandColumn:'displayTitle'
        });

        
        this.mainPanel.on("rowdblclick", function(grid){
            var record = grid.getSelectionModel().getSelected();
            var openUrl = null;
            var productCode = PF.getProductCode(record.data['compoId']);
            if(0 != record.data['url'].length && '' != record.data['url'] && null != record.data['url']){
            	openUrl = processUrl(record.data['url']);
            }else{
            	openUrl = "/" + productCode + "/getpage_" + record.data['compoId'] + ".action?function="
            	if('Y' == record.data['isGotoEdit']){
            		openUrl += "geteditpage&condition=1=0&";
            	}else{
            		openUrl += "getlistpage&condition=&"
            	}
            	openUrl += "componame=" + record.data['compoId'] + "&token=";
            	openUrl += token;
            }
            if("Y" == record.data['isAlwaysNew']){
            	window.open(openUrl, '_blank', '');
            }else{
            	window.open(openUrl, '', '');
            }
        })
        
        pThis.panel=new Ext.Panel({
			title:this.portletTitle,
			tools: [{
				qtip: '更多信息......',
				id: 'search',
				handler: function(e, target, panel){
					onOpenAll();
				}
			},
			{
				qtip: '刷新数据',
				//tooltip: '刷新数据',
				id: 'refresh',
				handler: function(e, target, panel){
					 onRefresh();
				}
			}
			],			
			border: false,
			autoScroll: true,
			standardSubmit: true,
			layout   : 'column',
			headerdblClick : function() {
				onOpenAll();
			},
			items: [{}]
		});
		if(pThis.picPart){
			pThis.panel.items.insert(0, pThis.picPart);
			pThis.panel.items.insert(1, pThis.mainPanel);
		}else{
			pThis.panel.items.insert(0, pThis.mainPanel);
		}
		
         //打开全部快捷应用窗口
    	function onOpenAll(){
			//创建grid的ds的域信息
		    var gridExpressAppRecordType = [{
		    	name:'pgPletId'
		    },{
		        name: 'userId'
		    }, {
		        name: 'menuId'
		    }, {
		        name: 'compoId'
		    }, {
		        name: 'displayTitle'
		    }, {
		        name: 'url'
		    }, {
		        name: 'isGotoEdit'
		    }, {
		        name: 'isAlwaysNew'
		  }];
    
			
            //复选的GridPortlet
            dsGrid = ufgov.portal.portlet.ExpressApp.superclass.getInitDs(gridExpressAppRecordType, "apService.getListExpressAppPageByPortletId", "pgPletId,userId,start,limit");
			
		    
		    //创建grid的列信息	
		    var colsExpressApp = new Ext.grid.ColumnModel([ {
		    	header: '页面频道编号',
		        dataIndex: 'pgPletId',
		        id: 'pgPletId',
		        width:60,
		        hidden: true,
	            sortable: true,
	            editor: new Ext.grid.GridEditor(new Ext.form.TextField({
		            allowBlank: false,maxLength:32
		        }))
		    },{
		        header: '用户名',
		        dataIndex: 'userId',
		        id: 'userId',
		        width:50,
		        hidden: true,
	            sortable: true,
	            editor: new Ext.grid.GridEditor(new Ext.form.TextField({
		            allowBlank: false,maxLength:32
		        }))
		    }, {
		        header: '菜单编号',
		        dataIndex: 'menuId',
		        id:'menuId',
		        width:60,
		        hidden: true,
	            sortable: true,
	            editor: new Ext.grid.GridEditor(new Ext.form.TextField({
		            allowBlank: false,maxLength:60
		        }))
		    }, {
		        header: '部件代码',
		        dataIndex: 'compoId',
		        width:60,
		        hidden: true,
	            sortable: true,
	            editor: new Ext.grid.GridEditor(new Ext.form.TextField({
		            allowBlank: false,maxLength:60
		        }))
		    },  {
		        header: '显示标题',
		        dataIndex: 'displayTitle',
		        id: 'displayTitle',
	            sortable: true,
	            editor: new Ext.grid.GridEditor(new Ext.form.TextField({
		            allowBlank: false,maxLength:200
		        }))
		    },{
		        header: 'url',
		        dataIndex: 'url',
		        id:'url',
		        hidden: true,
	            sortable: true
		    }, {
		        header: '是否去编辑页面',
		        dataIndex: 'isGotoEdit',
		        id: 'isGotoEdit',
		        hidden: true,
	            sortable: true
		    }, {
		        header: '是否总是在新页面打开',
		        dataIndex: 'isAlwaysNew',
		        id: 'isAlwaysNew',
		        hidden: true,
	            sortable: true
		    }
		    ]);
			
				
			//创建页面信息工具栏	
		    var barExpressApp = new Ext.PagingToolbar({
		        pageSize: 10,
		        store: dsGrid,
		        displayInfo: true,
		        displayMsg: '显示第 {0} 条到 {1} 条数据，共 {2} 条',
		        emptyMsg: '没有数据'
		    })
			
		    //创建编辑Grid
		    gridExpressApp = new Ext.grid.GridPanel({
		        ds: dsGrid,
		        cm: colsExpressApp,
		        hideHeaders : true,
		        autoExpandColumn: 'displayTitle',
		        resizable: true,
		        bbar: barExpressApp
		    });		
		    
		    gridExpressApp.on("rowdblclick", function(grid){
	            var record = grid.getSelectionModel().getSelected();
	            var openUrl = null;
	            var productCode = PF.getProductCode(record.data['compoId']);
	            if(0 != record.data['url'].length && '' != record.data['url'] && null != record.data['url']){
	            	openUrl = processUrl(record.data['url']);
	            }else{
	            	openUrl = "/" + productCode + "/getpage_" + record.data['compoId'] + ".action?function="
	            	if('Y' == record.data['isGotoEdit']){
	            		openUrl += "geteditpage&condition=1=0&";
	            	}else{
	            		openUrl += "getlistpage&condition=&"
	            	}
	            	openUrl += "componame=" + record.data['compoId'] + "&token=";
	            	openUrl += token;
	            }
	            if("Y" == record.data['isAlwaysNew']){
	            	window.open(openUrl, '_blank', '');
	            }else{
	            	window.open(openUrl, '', '');
	            }
	        })	
			
			//发布的window
			winMore=new Ext.Window({
	            title: '快捷应用',
	            xtype: 'window',
	            layout: 'fit',
	            modal: false,
	            maximizable:true,
	            minimizable:true,
	            width: 550,
	            height: 450,
	            plain: true,
	            closeAction: 'hide',
				bodyStyle: 'padding:15 5 0 5;',
	            items: [gridExpressApp]
             });
           winMore.show();
		   dsGrid.baseParams.limit = 10;
	       dsGrid.load({
	         params:{pgPletId:pThis.pgPletId, userId:pThis.userId, start:0, limit:10}
	       }); 
    	}
    	
    	
        
    },
   
    destroy: function(){
        if (this.panel) {
			this.panel.destroy();
			this.panel = null;
		}
		if (this.winMore) {
			this.winMore.destroy();
			this.winMore = null;
		}
		
		if (this.picPart){
			this.picPart.destroy();
			this.picPart = null;
		}
		
		this.mainPanel = null;
		this.gridExpressApp = null;
    }
  
});


Ext.reg('expressGrid', ufgov.portal.portlet.ExpressGrid);

