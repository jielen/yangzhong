package com.ufgov.zc.client.common.converter.zc;import java.util.ArrayList;import java.util.Iterator;import java.util.List;import java.util.Map;import java.util.Vector;import javax.swing.table.DefaultTableModel;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.StringToModel;import com.ufgov.zc.client.component.zc.dataexchange.model.ABaseData;@SuppressWarnings("unchecked")public class DataExchangeToTableModelConverter {  private static void readyColumnHeader(Map<String, String> columns, Vector<String> names) {    Iterator<String> it = columns.keySet().iterator();    while (it.hasNext()) {      names.add(it.next() + "");    }  }  public static DefaultTableModel convertToTableModel(ABaseData data, List list) {    MyTableModel tableModel = null;    Vector values = new Vector();    Vector<String> names = new Vector<String>();    if (data != null) {      Map NVmap = data.getColumnHeadersMap();      readyColumnHeader(NVmap, names);      if (list != null) {        for (int i = 0; i < list.size(); i++) {          Vector<Object> rowData = new Vector<Object>();          toLoadObjectData(rowData, NVmap, names, list.get(i));          values.add(rowData);        }      }    } else {      list = new ArrayList();    }    tableModel = new MyTableModel(values, names) {      private static final long serialVersionUID = 3123244681117334262L;      public Class getColumnClass(int column) {        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      public boolean isCellEditable(int row, int colum) {        return false;      }    };    tableModel.setList(list);    return tableModel;  }  /**   * 自动并按照对应的次序将行数据装入到对应的列中   * @param rowData   * @param NVmap   * @param fieldChNames   * @param currObj   */  public static void toLoadObjectData(Vector<Object> rowData, Map NVmap, Vector<String> fieldChNames,  Object currObj) {    for (int i = 0; i < fieldChNames.size(); i++) {      rowData.add(StringToModel.getPropertyValue(currObj, (NVmap.get(fieldChNames.get(i)) + "")));    }  }}