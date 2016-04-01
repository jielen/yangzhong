/**
 * @class ufgov.portal.PageTemp
 * @extends Ext.Panel
 */

ufgov.portal.Template = Ext.extend(Ext.Panel, {
	layout      : 'column',
    //autoScroll  : true,
    cls         : 'x-portal',
    defaultType : 'portletColumn',
    listeners:{resize: function(){
		if(!this.items){
			return;
		}
		var iLength = this.items.length;
		for(var i = 0; i < iLength; i++){
			try{				
				var portlet = this.items.itemAt(i);
				if(isNaN(portlet.columnWidth)){
					continue;
				}
				var w = portlet.columnWidth * this.getInnerWidth() - 5;
				var h = this.getInnerHeight();
				var iportletLength = portlet.items.length;
				for(var jj = 0; jj < iportletLength; jj++){
					//portlet.items.itemAt(jj).doLayout();
					//debugger;
					//portlet.items.itemAt(jj).setWidth(0);
					portlet.items.itemAt(jj).setWidth(w);
					portlet.items.itemAt(jj).syncSize();
				}
				
			}catch(e){
				//debugger;
			}
		}
	}}
});
Ext.reg('template', ufgov.portal.Template);

ufgov.portal.PortletColumn = Ext.extend(Ext.Container, {
    layout: 'anchor',
    autoEl: 'div',
    defaultType: 'portlet',
    cls:'x-portal-column'
});
Ext.reg('portletColumn', ufgov.portal.PortletColumn);

/**
 * @class ufgov.portal.Portlet
 * @extends Ext.Panel
 */

ufgov.portal.Portlet = Ext.extend(Ext.Panel, {
    anchor: '100%',
    frame: true,
    collapsible: false,
    draggable: false,
    cls: 'x-portlet',
    border: false,
	//Height: 80,
    listeners:{resize: function(){
//		if(!this.items){
//			return;
//		}
//		//debugger;
//		var iLength = this.items.length;
//		for(var i = 0; i < iLength; i++){
//			try{
//				var panel = this.items.itemAt(i);
//				//panel.setWidth(this.getInnerWidth());
//				//panel.syncSize();
//			}catch(e){
//			}
//		}
	}}
});
Ext.reg('portlet', ufgov.portal.Portlet);