ufgov.portal.portlet.BlankPortlet = Ext.extend(ufgov.portal.Base,{
	portletTitle: '',
	panle:null,
	init: function(){
		Ext.QuickTips.init();
		if (this.constructor.arguments.length > 0) {
			
		}
	},
	passParam : function(jsonParam){
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}
		
		if (Boolean(jsonParam.title)) {
			this.portletTitle = jsonParam.title;
		}
		
		var vsUrl = "";
		var vsHeight = 0;
		
		if(this.portletTitle == "即时通讯" || this.portletTitle == "goCom"){
			vsHeight = 30;
			vsUrl = "/portal/html/portlet/other/goComPortlet.jsp";
		}else if(this.portletTitle == "在线服务" || this.portletTitle == "onService"){
			vsUrl = "/portal/html/portlet/other/onServicePortlet.jsp";
			vsHeight = 30;
		}
		
		var config = {
			border: false,
			width:'100%'
		};
		if(vsHeight > 0){
			config.height= vsHeight;  
		}
		config.html = '<iframe src=' + vsUrl + ' frameborder="0" id="blank" name="blank" scrolling="auto" style="width:100%;height:100%"></iframe>';
		
		this.panel = new Ext.Panel(config);
		
	}
	});
Ext.reg('blankPortlet', ufgov.portal.portlet.BlankPortlet);