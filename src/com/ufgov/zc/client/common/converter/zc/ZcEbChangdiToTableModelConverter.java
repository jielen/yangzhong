package com.ufgov.zc.client.common.converter.zc;

import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;

public class ZcEbChangdiToTableModelConverter {

  public static TableModel convertMainLst(List mainLst) {
    // TODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();

    names.add(LangTransMeta.translate(ZcEbChangdi.COL_CHANGDINAME)); 
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_RONGNAIRENSHU)); 
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_ADDRESS)); 
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_ISONLINEPINGBIAO)); 
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_COMPUTERNUM)); 
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_TOUYINGYINUM));  
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_DIANZIBAIBANNUM));  
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_WIREDMICROPHONENUM));  
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_WIRELESSMICROPHONENUM)); 
    names.add(LangTransMeta.translate(ZcEbChangdi.COL_STATUS)); 
    if (mainLst != null && mainLst.size() > 0) {

      for (int i = 0; i < mainLst.size(); i++) {
        Vector rowData = new Vector();
        ZcEbChangdi agreement = (ZcEbChangdi) mainLst.get(i);
        rowData.add(agreement.getChangdiname()); 
        rowData.add(agreement.getRongnairenshu()); 
        rowData.add(agreement.getAddress()); 
        rowData.add(AsValDataCache.getName(ZcSettingConstants.V_Y_N,agreement.getIsonlinepingbiao())); 
        rowData.add(agreement.getComputernum()); 
        rowData.add(agreement.getTouyingyinum()); 
        rowData.add(agreement.getDianzibaibannum()); 
        rowData.add(agreement.getWiredmicrophonenum()); 
        rowData.add(agreement.getWirelessmicrophonenum());
        rowData.add(AsValDataCache.getName(ZcEbChangdi.V_ZC_EB_CHANGDI_STATUS,agreement.getStatus()));  
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
