package com.ufgov.zc.client.common.converter.zc;import java.util.List;import java.util.Vector;import javax.swing.table.DefaultTableModel;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.component.ui.conditionitem.ConditionFieldConstants;import com.ufgov.zc.client.datacache.AsValDataCache;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.zc.model.ZcEbProtocol;public class ZcEbProtocolToTableModelConverter {  public static DefaultTableModel convertToTableModel(List protocolList) {    MyTableModel tableModel = null;    Vector<String> names = new Vector<String>();    Vector values = new Vector();    //names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PROT_CODE));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_TRANS_SN));    //names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_NAME));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_SIGN_DATE));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_STATUS));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_REMARK));    names.add("委托项目名称");    //names.add(LangTransMeta.translate(ZcElementConstants.FIELD_PROCESS_INST_ID));    if (protocolList != null && protocolList.size() > 0) {      for (int i = 0; i < protocolList.size(); i++) {        Vector rowData = new Vector();        ZcEbProtocol zcEbProtocol = (ZcEbProtocol) protocolList.get(i);        //rowData.add(zcEbProtocol.getProtCode());        rowData.add(zcEbProtocol.getZcEbEntrust().getZcMakeCode());        //rowData.add(zcEbProtocol.getName());        rowData.add(zcEbProtocol.getSignDate());        rowData.add(AsValDataCache.getName(ConditionFieldConstants.ZC_VS_PROTOCOL_STATUS, zcEbProtocol        .getStatus()));        rowData.add(zcEbProtocol.getRemark());        //rowData.add(zcEbProtocol.getProcessInstId());        rowData.add(zcEbProtocol.getZcEbEntrust().getZcMakeName());        values.add(rowData);      }    }    tableModel = new MyTableModel(values, names) {      public Class getColumnClass(int column) {        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      public boolean isCellEditable(int row, int colum) {        return false;      }    };    tableModel.setList(protocolList);    return tableModel;  }}