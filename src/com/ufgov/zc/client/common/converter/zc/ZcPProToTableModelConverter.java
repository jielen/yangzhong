package com.ufgov.zc.client.common.converter.zc;import java.util.List;import java.util.Vector;import javax.swing.table.DefaultTableModel;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.common.zc.model.ZcPPro;public class ZcPProToTableModelConverter {  public static DefaultTableModel convertToTableModel(List entrustList) {    MyTableModel tableModel = null;    Vector<String> names = new Vector<String>();    Vector<Vector<Comparable>> values = new Vector<Vector<Comparable>>();    names.add("采购项目");    names.add("预算单位");    names.add("项目分类");//    names.add("创建人");//    names.add("创建时间");//    names.add("作业时间");    if (entrustList != null && entrustList.size() > 0) {      for (int i = 0; i < entrustList.size(); i++) {        Vector<Comparable> rowData = new Vector<Comparable>();        ZcPPro zcPPro = (ZcPPro) entrustList.get(i);        rowData.add(zcPPro.getChrName());        rowData.add(zcPPro.getEnName());        rowData.add(zcPPro.getBiName());//        rowData.add(zcPPro.getCreateUser());//        rowData.add(zcPPro.getCreateDate());////        rowData.add(zcPPro.getNd());        values.add(rowData);      }    }    tableModel = new MyTableModel(values, names) {      public Class getColumnClass(int column) {        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      public boolean isCellEditable(int row, int colum) {        return false;      }    };    tableModel.setList(entrustList);    return tableModel;  }}