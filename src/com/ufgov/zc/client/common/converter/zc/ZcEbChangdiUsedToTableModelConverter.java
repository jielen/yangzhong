package com.ufgov.zc.client.common.converter.zc;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;

public class ZcEbChangdiUsedToTableModelConverter {

  public static TableModel convertMainLst(List mainLst) {
    // TODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();
    
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_CHANGDINAME)); 
    names.add(LangTransMeta.translate(ZcEbChangdiUsed.COL_USEDCONTENT)); 
    names.add(LangTransMeta.translate(ZcEbChangdiUsed.COL_USEDTYPE));  
    names.add(LangTransMeta.translate(ZcEbChangdiUsed.COL_STARTDATE));  
    names.add(LangTransMeta.translate(ZcEbChangdiUsed.COL_ENDDATE)); 
    names.add(LangTransMeta.translate(ZcEbChangdiUsed.COL_REQUESTUNIT));    
    names.add(LangTransMeta.translate(ZcEbChangdiUsed.COL_REQUESTPEOPLE));   
    if (mainLst != null && mainLst.size() > 0) {

      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      for (int i = 0; i < mainLst.size(); i++) {
        Vector rowData = new Vector();
        ZcEbChangdiUsed agreement = (ZcEbChangdiUsed) mainLst.get(i);
        rowData.add(agreement.getChangdiname());
        rowData.add(agreement.getUsedcontent());
        rowData.add(AsValDataCache.getName(ZcEbChangdiUsed.V_ZC_CHANGDI_USED_USEDTYPE,agreement.getUsedtype()));
        rowData.add(agreement.getStartdate() == null ? null : df.format(agreement.getStartdate()));
        rowData.add(agreement.getEnddate() == null ? null : df.format(agreement.getEnddate()));
        rowData.add(agreement.getRequestunit());
        rowData.add(agreement.getRequestpeople());
        values.add(rowData);
      }
    }

    tableModel = new MyTableModel(values, names) {
      public Class getColumnClass(int column) {
        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {
          for (int row = 0; row < this.getRowCount(); row++) {
            if (getValueAt(row, column) != null) {
              return getValueAt(row, column).getClass();
            }
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
