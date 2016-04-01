/**
 * 公文箱平铺模板
 */
ufgov.portal.portlet.FileBoxTileTemp = Ext.extend(Ext.Panel, {
	layout      : 'column',
    autoScroll  : true,
    cls         : 'x-portal',
    defaultType : 'fileBoxTileColumn'
});
Ext.reg('fileBoxTileTemp', ufgov.portal.portlet.FileBoxTileTemp);


ufgov.portal.portlet.FileBoxTileColumn = Ext.extend(Ext.Container, {
    layout: 'anchor',
    autoEl: 'div',
    defaultType: 'fileBoxTilePortlet',
    cls:'x-portal-column'
});
Ext.reg('fileBoxTileColumn', ufgov.portal.portlet.FileBoxTileColumn);

/**
 * @class ufgov.portal.Portlet
 * @extends Ext.Panel
 */

ufgov.portal.portlet.FileBoxTilePortlet = Ext.extend(Ext.Panel, {
    anchor: '100%',
    frame: true,
    collapsible: false,
    draggable: false,
    cls: 'x-portlet',
	height: 80
});
Ext.reg('fileBoxTilePortlet', ufgov.portal.portlet.FileBoxTilePortlet);