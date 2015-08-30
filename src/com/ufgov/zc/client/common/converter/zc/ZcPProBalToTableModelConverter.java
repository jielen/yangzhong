/**   * @(#) project: zcxa* @(#) file: ZcPProBalToTableModelConverter.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.common.converter.zc;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import java.util.Vector;import javax.swing.table.DefaultTableModel;import javax.swing.table.TableModel;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.component.table.BeanTableModel;import com.ufgov.zc.client.component.table.ColumnBeanPropertyPair;import com.ufgov.zc.client.datacache.AsValDataCache;import com.ufgov.zc.client.datacache.CompanyDataCache;import com.ufgov.zc.common.system.Guid;import com.ufgov.zc.common.system.constants.ZcPProBalConstants;import com.ufgov.zc.common.zc.model.ZcPProBal;import com.ufgov.zc.common.zc.model.ZcPProBalBi;/*** @ClassName: ZcPProBalToTableModelConverter* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2010-8-2 下午03:05:58* @version: V1.0 * @since: 1.0* @author: Administrator* @modify: */public class ZcPProBalToTableModelConverter {  public static DefaultTableModel convertToTableModel(List entrustList) {    MyTableModel tableModel = null;    Vector<String> names = new Vector<String>();    Vector<Vector<Comparable>> values = new Vector<Vector<Comparable>>();//    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_ID));////    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_CO_CODE));////    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_CO_CODE_ND));//////    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_STATUS));    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_CO_NAME));    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_MAKE_NAME));    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_SU_NAME));    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_SUM));    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_HT_CODE));    names.add(LangTransMeta.translate(ZcPProBalConstants.FIELD_TRANS_ZC_HT_NAME));    if (entrustList != null && entrustList.size() > 0) {      for (int i = 0; i < entrustList.size(); i++) {        Vector<Comparable> rowData = new Vector<Comparable>();        ZcPProBal zcPProBal = (ZcPProBal) entrustList.get(i);//        rowData.add(zcPProBal.getZcBalId());        //rowData.add(zcPProBal.getZcCoName());//        rowData.add(zcPProBal.getCoCode());////        rowData.add(zcPProBal.getNd());////        rowData.add(zcPProBal.getZcBalStatus());////        rowData.add(AsValDataCache.getName("VS_ZC_P_PRO_BAL", zcPProBal.getZcBalStatus()));        rowData.add(CompanyDataCache.getName(zcPProBal.getCoCode()));        rowData.add(zcPProBal.getZcMakeName());        rowData.add(zcPProBal.getZcSuName());        rowData.add(zcPProBal.getZcBalSum());        rowData.add(zcPProBal.getZcHtCode());        rowData.add(zcPProBal.getZcHtName());        values.add(rowData);      }    }    tableModel = new MyTableModel(values, names) {      public Class getColumnClass(int column) {        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      public boolean isCellEditable(int row, int colum) {        return false;      }    };    tableModel.setList(entrustList);    return tableModel;  }  private static Map<String, Boolean> BiColNotEditable = new HashMap<String, Boolean>();  static {    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_FUND_CODE, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_PAYTYPE_CODE, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ORIGIN_NAME, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_BI_NO, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_BI_SUM, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_BI_BCSY_SUM, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_BI_BCJS_SUM, true);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_BI_YJJS_SUM, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_AM_BILL_NO, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_AM_BILL_NO, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_AM_BILL_NO, false);        BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_B_ACC_NAME, false);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_OUTLAY_NAME, true);    BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_SENDDOC_NAME, false);        BiColNotEditable.put(ZcPProBalConstants.FIELD_TRANS_FUND_NAME, false);  }  private static List<ColumnBeanPropertyPair> biInfo = new ArrayList<ColumnBeanPropertyPair>();  static {    /*     * 指标编号     */    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_BI_NO, "zcBiNo", LangTransMeta    .translate(ZcPProBalConstants.FIELD_TRANS_ZC_BI_NO)));    /*     * 资金性质     */    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_FUND_NAME, "zcFundName", LangTransMeta    .translate(ZcPProBalConstants.FIELD_TRANS_FUND_NAME)));    /*     * 支付方式     *///    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_PAYTYPE_CODE, "zcPaytypeCode", LangTransMeta////    .translate(ZcPProBalConstants.FIELD_TRANS_PAYTYPE_CODE)));    /*     * 指标来源     */    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ORIGIN_NAME, "zcOriginName", LangTransMeta    .translate(ZcPProBalConstants.FIELD_TRANS_ORIGIN_NAME)));    biInfo.add(new ColumnBeanPropertyPair("ZC_P_PRO_BAL_SENDDOC_NAME", "sendDocName", "指标文号"));//    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_BIS_NAME, "zcBisName", "预算项目"));    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_B_ACC_NAME, "zcBAccName", "功能科目"));    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_OUTLAY_NAME, "outLayName", "经济科目"));    /*     * 指标金额     */    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_BI_SUM, "zcBiSum", "预算金额"));    /*     * 合同使用金额     */    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_BI_BCSY_SUM, "zcBiBcsySum", LangTransMeta    .translate(ZcPProBalConstants.FIELD_TRANS_ZC_BI_BCSY_SUM)));    /*     * 本次结算金额     */    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_BI_BCJS_SUM, "zcBiBcjsSum", LangTransMeta    .translate(ZcPProBalConstants.FIELD_TRANS_ZC_P_PRO_BAL_BI_BCJS_SUM)));    /*     * 支付单据号     *///    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_AM_BILL_NO, "zcAmBillNo", LangTransMeta////    .translate(ZcPProBalConstants.FIELD_TRANS_ZC_AM_BILL_NO)));    /*     * 已经结算金额     */    biInfo.add(new ColumnBeanPropertyPair(ZcPProBalConstants.FIELD_TRANS_ZC_BI_YJJS_SUM, "zcBiYjjsSum", LangTransMeta    .translate(ZcPProBalConstants.FIELD_TRANS_ZC_BI_YJJS_SUM)));  }  public static TableModel convertSubBiTableData(List<ZcPProBalBi> biList) {    BeanTableModel<ZcPProBalBi> tm = new BeanTableModel<ZcPProBalBi>() {      private static final long serialVersionUID = 6888363838628062064L;      @Override      public boolean isCellEditable(int row, int col) {        return BiColNotEditable.get(this.getColumnIdentifier(col));      }      @Override      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {        super.setValueAt(aValue, rowIndex, columnIndex);      }    };    tm.setOidFieldName("tempId");    for (Object o : biList) {      ((ZcPProBalBi) o).setTempId(Guid.genID());    }    tm.setDataBean(biList, biInfo);    return tm;  }  public static List<ColumnBeanPropertyPair> getBiInfo() {    return biInfo;  }  public static void setBiInfo(List<ColumnBeanPropertyPair> biInfo) {    ZcPProBalToTableModelConverter.biInfo = biInfo;  }}