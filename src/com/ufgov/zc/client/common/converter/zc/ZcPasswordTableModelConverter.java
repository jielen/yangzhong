package com.ufgov.zc.client.common.converter.zc;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.common.system.model.User;

public class ZcPasswordTableModelConverter {

  public static TableModel convertToTableModel(List mainLst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add("登陆账号");
    names.add("用户");
    if (mainLst != null && mainLst.size() > 0) {

      for (int i = 0; i < mainLst.size(); i++) {
        Vector rowData = new Vector();
        User user = (User) mainLst.get(i);
        rowData.add(user.getUserId());
        rowData.add(user.getUserName());
        values.add(rowData);
      }
    }

    tableModel = new MyTableModel(values, names) {
      public Class getColumnClass(int column) {
        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {
          for (int row = 0; row < this.getRowCount(); row++) {
            if (getValueAt(row, column) != null) { return getValueAt(row, column).getClass(); }
          }
        }
        return Object.class;
      }

      public boolean isCellEditable(int row, int colum) {
        return false;
      }
    };
    tableModel.setList(mainLst);
    return tableModel;
  }

}
