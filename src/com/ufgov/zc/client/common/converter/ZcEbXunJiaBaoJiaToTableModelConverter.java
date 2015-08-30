/** * ZcEbXunJiaBaoJiaToTableModelConverter.java * com.ufgov.gk.client.common.converter * Administrator * 2010-10-24 */package com.ufgov.zc.client.common.converter;import java.util.ArrayList;import java.util.List;import java.util.Vector;import javax.swing.table.DefaultTableModel;import javax.swing.table.TableModel;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.component.table.BeanTableModel;import com.ufgov.zc.client.component.table.ColumnBeanPropertyPair;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.common.zc.model.ZcEbXunJiaBaoJia;import com.ufgov.zc.common.zc.model.ZcEbXunJiaBaoJiaDetail;/** * @author Administrator * */public class ZcEbXunJiaBaoJiaToTableModelConverter {  public DefaultTableModel convertToTableModel(List baojiaLst) {    MyTableModel tableModel = null;    Vector names = new Vector();    Vector values = new Vector();    names.add("项目编号");    names.add("项目名称");    names.add("报价截止时间 ");    names.add("供应商");    //    names.add("状态");    names.add("录入时间 ");    if (baojiaLst != null && baojiaLst.size() > 0) {      for (int i = 0; i < baojiaLst.size(); i++) {        Vector rowData = new Vector();        ZcEbXunJiaBaoJia bj = (ZcEbXunJiaBaoJia) baojiaLst.get(i);        rowData.add(bj.getProjCode());        rowData.add(bj.getProjName());        rowData.add(bj.getStopDate());        rowData.add(bj.getSupplierName());        //        rowData.add(AsValDataCache.getName("ZC_VS_XUNJIA_BAOJIA_STATUS", bj.getStatus()));        rowData.add(bj.getInputDate());        values.add(rowData);      }    }    tableModel = new MyTableModel(values, names) {      public Class getColumnClass(int column) {        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      public boolean isCellEditable(int row, int colum) {        return false;      }    };    tableModel.setList(baojiaLst);    return tableModel;  }  /**   * @param deList   * @return   * Administrator   * 2010-5-25   */  private BeanTableModel createModel(List deList) {    BeanTableModel tm = new BeanTableModel() {      @Override      public boolean isCellEditable(int row, int column) {        String identifier = this.getColumnIdentifier(column);        if ("SP_STATUS".equals(identifier)) {          String v = (String) getValueAt(row, getBeanPropertyColIndex("openBidStatus"));          if (!"0".equals(v)) {            return false;          }          return super.isCellEditable(row, column);        }        return false;      }    };    tm.setOidFieldName("tempId");    return tm;  }  private List<ColumnBeanPropertyPair> createColumnBeanPropertyPairs(String[] colums, String[] names) {    List<ColumnBeanPropertyPair> pairList = new ArrayList<ColumnBeanPropertyPair>();    for (int i = 0; i < colums.length; i++) {      ColumnBeanPropertyPair pair = new ColumnBeanPropertyPair();      pair.setColumnIdentifier(colums[i]);      pair.setBeanPropertyName(names[i]);      pairList.add(pair);    }    return pairList;  }  public TableModel convertSignupPackDeToTableModel(List deList) {    BeanTableModel tm = createModel(deList);    tm.setOidFieldName("packCode");    String[] colums = new String[] { "PACK_NAME", "PACK_DESC", "SP_STATUS", "SP_DATE", "END_DATE", "OPEN_BID_STATUS" };    String[] names = new String[] { "packName", "packDesc", "spStatus", "spDate", "submitBidDocDate", "openBidStatus" };    tm.setDataBean(deList, createColumnBeanPropertyPairs(colums, names));    return tm;  }  public TableModel convertXunJiaBaoJiaToTableModel(List xunJiaBaoJiaList) {    BeanTableModel tm = new BeanTableModel() {      @Override      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {        ZcEbXunJiaBaoJiaDetail bean = (ZcEbXunJiaBaoJiaDetail) getDataBeanList().get(rowIndex);        if ("SP_TECH_FILE_NAME".equals(this.getColumnIdentifier(columnIndex))) {          if (aValue == null) {            bean.setSpTechFileName(null);            bean.setSpTechFileId(null);          } else {            bean.setSpTechFileName(((AsFile) aValue).getFileName());            bean.setSpTechFileId(((AsFile) aValue).getFileId());          }          putEditedData(bean);          fireTableCellUpdated(rowIndex, columnIndex);        } else {          super.setValueAt(aValue, rowIndex, columnIndex);        }      }      public boolean isCellEditable(int row, int column) {        String columnId = this.getColumnIdentifier(column);        if ("SP_NAME".equals(columnId) || "SP_BRAND".equals(columnId) || "SP_TECH".equals(columnId) || "SP_NUM".equals(columnId)          || "SP_UNIT".equals(columnId) //          || "SP_TECH_FILE_NAME".equals(columnId)           || "SP_TOTAL_SUM".equals(columnId)) {          return false;        }        return super.isCellEditable(row, column);      }    };    tm.setOidFieldName("bjDetailCode");    //    //    List<String> everEditableColumns = new ArrayList<String>();    //    //    everEditableColumns.add("SP_TECH_FILE_NAME");    //    //    everEditableColumns.add("SP_UNIT");    //    //    tm.setEverEditableColunms(everEditableColumns);    String[] colums = new String[] { "SP_NAME", "SP_BRAND", "SP_TECH", "SP_TECH_FILE_NAME", "SP_NUM", "SP_PRICE", "SP_TOTAL_SUM",    "GONG_HUO_DATE", "REMARK"//    , "SP_UNIT"     };    String[] names = new String[] { "spName", "spBrand", "spTech", "spTechFileName", "spNum", "spPrice", "spTotalSum", "gongHuoDate",    "remark"//      , "unit"     };    tm.setDataBean(xunJiaBaoJiaList, createColumnBeanPropertyPairs(colums, names));    return tm;  }}