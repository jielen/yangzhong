/**
 * 
 */
package com.ufgov.zc.client.common.converter.zc;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.datacache.AsValDataCache;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.zc.model.HuiyuanPeopleblack;
import com.ufgov.zc.common.zc.model.HuiyuanUnitblack;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi;

/**
 * @author Administrator
 *
 */
public class HuiyuanUnitcominfoToTableModelConverter {

  public static TableModel convertToTableModel(List mainDataLst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();
    names.add(LangTransMeta.translate(HuiyuanUnitcominfo.COL_DANWEINAME));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_AUDITSTATUS));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_STATUSCODE));
    if (mainDataLst != null && mainDataLst.size() > 0) {
      for (int i = 0; i < mainDataLst.size(); i++) {
        Vector rowData = new Vector();
        HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) mainDataLst.get(i);
        rowData.add(qx.getDanweiname());
        rowData.add(AsValDataCache.getName(ZcSettingConstants.V_HUI_YUAN_AUDIT_STATUS,qx.getZfcgGysInfo().getAuditstatus())); 
        rowData.add(AsValDataCache.getName(ZcSettingConstants.V_HUI_YUAN_ACCOUNT_STATUS,qx.getZfcgGysInfo().getStatuscode())); 
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

    tableModel.setList(mainDataLst);

    return tableModel;
  }

  public TableModel convertUserTableData(List userLst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();
    names.add(LangTransMeta.translate(HuiyuanUser.COL_DISPLAYNAME));
    names.add(LangTransMeta.translate(HuiyuanUser.COL_LOGINID));
    names.add(LangTransMeta.translate(HuiyuanUser.COL_DOGNUM));
    names.add(LangTransMeta.translate(HuiyuanUser.COL_COMPANYPHONE));
    names.add(LangTransMeta.translate(HuiyuanUser.COL_MOBILEPHONE));
    names.add(LangTransMeta.translate(HuiyuanUser.COL_AUDITSTATUS));
    names.add(LangTransMeta.translate(HuiyuanUser.COL_STATUSCODE));
//    names.add(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_AUDITSTATUS));  

    if (userLst != null && userLst.size() > 0) {
      for (int i = 0; i < userLst.size(); i++) {
        Vector rowData = new Vector();
        HuiyuanUser qx = (HuiyuanUser) userLst.get(i);
        rowData.add(qx.getDisplayname());
        rowData.add(qx.getLoginid());
        rowData.add(qx.getDognum());
        rowData.add(qx.getCompanyphone());
        rowData.add(qx.getMobilephone());
        rowData.add(AsValDataCache.getName(ZcSettingConstants.V_HUI_YUAN_AUDIT_STATUS,qx.getAuditstatus())); 
        rowData.add(AsValDataCache.getName(ZcSettingConstants.V_HUI_YUAN_ACCOUNT_STATUS,qx.getStatuscode()));    
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

    tableModel.setList(userLst);

    return tableModel;
  }

  public TableModel convertZizhiTableData(List lst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyingzizhi.COL_ZIZHICODE));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyingzizhi.COL_ZHENGSHUNO));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyingzizhi.COL_ISMAIN));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyingzizhi.COL_FAZHENGORG));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyingzizhi.COL_DEADLINEDATE));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyingzizhi.COL_SHOWZY));
    names.add(LangTransMeta.translate(HuiyuanZfcgGongyingzizhi.COL_AUDITSTATUS));
//    names.add(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_AUDITSTATUS));  

    if (lst != null && lst.size() > 0) {
      for (int i = 0; i < lst.size(); i++) {
        Vector rowData = new Vector();
        HuiyuanUser qx = (HuiyuanUser) lst.get(i);
        rowData.add(qx.getLoginid());
        rowData.add(qx.getDisplayname());
        rowData.add(qx.getCompanyphone());
        rowData.add(qx.getMobilephone());
        rowData.add(AsValDataCache.getName(ZcSettingConstants.V_HUI_YUAN_AUDIT_STATUS,qx.getAuditstatus())); 
        rowData.add(AsValDataCache.getName(ZcSettingConstants.V_HUI_YUAN_ACCOUNT_STATUS,qx.getStatuscode()));    
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

    tableModel.setList(lst);

    return tableModel;
  }

  public TableModel convertUnitBlackTableData(List unitBlackLst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();
    names.add(LangTransMeta.translate(HuiyuanUnitblack.COL_PUNISHDEPARTMENT)); 
    names.add(LangTransMeta.translate(HuiyuanUnitblack.COL_FROMDATE)); 
    names.add(LangTransMeta.translate(HuiyuanUnitblack.COL_ENDDATE)); 
    names.add(LangTransMeta.translate(HuiyuanUnitblack.COL_CHUFAREASON));  
//    names.add(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_AUDITSTATUS));  

    if (unitBlackLst != null && unitBlackLst.size() > 0) {
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      for (int i = 0; i < unitBlackLst.size(); i++) {
        Vector rowData = new Vector();
        HuiyuanUnitblack obj = (HuiyuanUnitblack) unitBlackLst.get(i);
        rowData.add(obj.getPunishdepartment()); 
        rowData.add(obj.getFromdate() == null ? null : df.format(obj.getFromdate()));
        rowData.add(obj.getEnddate() == null ? null : df.format(obj.getEnddate()));
        rowData.add(obj.getChufareason());     
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

    tableModel.setList(unitBlackLst);

    return tableModel;
  }


  public TableModel convertPeopleBlackTableData(List peopleBlackLst) {
    // TCJLODO Auto-generated method stub

    MyTableModel tableModel = null;
    Vector names = new Vector();
    Vector values = new Vector();
    names.add(LangTransMeta.translate(HuiyuanPeopleblack.COL_PNAME));  
    names.add(LangTransMeta.translate(HuiyuanPeopleblack.COL_FROMDATE));  
    names.add(LangTransMeta.translate(HuiyuanPeopleblack.COL_ENDDATE));  
    names.add(LangTransMeta.translate(HuiyuanPeopleblack.COL_CHUFAREASON));  
    names.add(LangTransMeta.translate(HuiyuanPeopleblack.COL_CHULIJIGUAN));  

    if (peopleBlackLst != null && peopleBlackLst.size() > 0) {
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      for (int i = 0; i < peopleBlackLst.size(); i++) {
        Vector rowData = new Vector();
        HuiyuanPeopleblack obj = (HuiyuanPeopleblack) peopleBlackLst.get(i);
        rowData.add(obj.getPname()); 
        rowData.add(obj.getFromdate() == null ? null : df.format(obj.getFromdate()));
        rowData.add(obj.getEnddate() == null ? null : df.format(obj.getEnddate()));
        rowData.add(obj.getChufareason());   
        rowData.add(obj.getChulijiguan());       
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

    tableModel.setList(peopleBlackLst);

    return tableModel;
  }

}
