ufgov.portal.portlet.CalendarApp = Ext.extend(ufgov.portal.Base, {
	portletId:'calendar',
    portletTitle:'日历',
    panel:null,
    widthEl:300,
    passParam:function(jsonParam){
		if (Ext.isEmpty(jsonParam)) {
			alert("请传入jsonParam参数");
			return;
		}
		if(Ext.isEmpty(jsonParam.portlet_id)){
			alert("请传入必要参数portletId");
			return;
		}
		if(Ext.isEmpty(jsonParam.title)){
			alert("请传入必要参数title");
			return;
		}
		if(!Ext.isEmpty(jsonParam.panelWidth) && "number" == Ext.type(parseInt(jsonParam.panelWidth))){
			this.widthEl = jsonParam.panelWidth;
		}
		this.portletId = jsonParam.portlet_id;
		this.portletTitle = jsonParam.title;
		var pThis = this;
		Date.dayNames = ["日", "一", "二", "三", "四", "五", "六"];
		var dateitem = new Ext.apply(Ext.DatePicker.prototype, {
		   width:pThis.widthEl,
		   minText : "日期在最小日期之前",
		   maxText : "日期在最大日期之后",
		   disabledDaysText : "",
		   disabledDatesText : "",
		   monthNames : Date.monthNames,
		   dayNames : Date.dayNames,
		   todayTip:"",
		   nextText : '下月 (Control+Right)',
		   prevText : '上月 (Control+Left)',
		   monthYearText : '选择一个月 (Control+Up/Down 来改变年)',
		   format : "y年m月d日"
		 });
		this.panel = new Ext.Panel({
			title: pThis.portletTitle,
			border: false,
			layout: 'fit',
			height: 220,
			bodyStyle: 'padding:0px 0px 0px 0px;border:0px solid',
			items: dateitem
		});
	},
	destroy : function() {
		if(this.panel != null){
			this.panel.destory();
			this.panel = null;
		}
	}
});

Ext.reg('calendar', ufgov.portal.portlet.CalendarApp);