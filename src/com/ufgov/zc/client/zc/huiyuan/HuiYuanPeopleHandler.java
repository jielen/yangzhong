/**
 * 
 */
package com.ufgov.zc.client.zc.huiyuan;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.TableModel;

import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;
import com.ufgov.zc.common.zc.model.HuiyuanUser;

/**
 * @author Administrator
 *
 */
public abstract class HuiYuanPeopleHandler implements IForeignEntityHandler {

  private boolean isMultipleSelect;
  private String sqlId = "com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.selectMainDataLst";
  
  private String columNames[] = {"单位","姓名","身份证","办公电话","手机号码"};
  public HuiYuanPeopleHandler() {
    this(false);
  }

  public HuiYuanPeopleHandler(boolean isMultipleSelect) {
    this.isMultipleSelect = isMultipleSelect;
  }

  @SuppressWarnings("unchecked")
  public abstract void excute(List selectedDatas);

  @SuppressWarnings("unchecked")
  public TableModel createTableModel(List showDatas) {

    Object data[][] = new Object[showDatas.size()][columNames.length];
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    for (int i = 0; i < showDatas.size(); i++) {
      HuiyuanUser rowData = (HuiyuanUser) showDatas.get(i);
      int col = 0;
      data[i][col++] = rowData.getDanweiname();
      data[i][col++] = rowData.getDisplayname();
      data[i][col++] = rowData.getIdcard();
      data[i][col++] = rowData.getCompanyphone();
      data[i][col++] = rowData.getMobilephone();
    }

    MyTableModel model = new MyTableModel(data, columNames) {
      private static final long serialVersionUID = 5069824753340617654L;
      public boolean isCellEditable(int row, int colum) {
        return false;
      }
    };
    return model;
  }

  public boolean isMultipleSelect() {
    return this.isMultipleSelect;
  }

  public String[] getColumNames() {
    return columNames;
  }

  public void setColumNames(String[] columNames) {
    this.columNames = columNames;
  }

  public String getSqlId() {
    return sqlId;
  }

  public void setSqlId(String sqlId) {
    this.sqlId = sqlId;
  }

}
