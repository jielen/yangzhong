/**   * @(#) project: ZFCG_ST* @(#) file: ZcEbRfqPackToTableModelConverter.java* * Copyright 2011 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.common.converter.zc;import java.text.SimpleDateFormat;import java.util.List;import java.util.Vector;import javax.swing.table.DefaultTableModel;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.datacache.AsValDataCache;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.zc.model.ZcEbRfqPack;/*** @ClassName: ZcEbRfqPackToTableModelConverter* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2011-9-16 下午04:41:19* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ZcEbRfqPackToTableModelConverter {  @SuppressWarnings({ "unchecked", "serial" })  public static DefaultTableModel convertToTableModel(List billList) {    MyTableModel tableModel = null;    Vector names = new Vector();    Vector values = new Vector();    names.add(LangTransMeta.translate("ZC_EB_FIELD_PROJ_CODE"));    names.add(LangTransMeta.translate("ZC_EB_FIELD_PROJ_NAME"));    names.add(LangTransMeta.translate("ZC_EB_FIELD_PROJ_MANAGER"));    names.add(LangTransMeta.translate("ZC_EB_FIELD_PACK_NAME"));    names.add(LangTransMeta.translate("ZC_EB_FIELD_PACK_BUDGET"));    names.add("单据状态");    names.add("开标时间");    names.add("中标供应商");    if (billList != null && billList.size() > 0) {      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");      for (int i = 0; i < billList.size(); i++) {        Vector rowData = new Vector();        ZcEbRfqPack bill = (ZcEbRfqPack) billList.get(i);        rowData.add(bill.getProjCode());        rowData.add(bill.getProjName());        rowData.add(bill.getCreator());        rowData.add(bill.getPackName());        rowData.add(bill.getPackBudget());        rowData.add(AsValDataCache.getName(ZcElementConstants.VS_ZC_EB_RFQ_OPEN_BID_STATUS, bill.getOpenBidStatus()));        rowData.add(sdf.format(bill.getOpenBidDate()));        rowData.add(bill.getWinBidProviderName());        values.add(rowData);      }    }    tableModel = new MyTableModel(values, names) {      @Override      public Class getColumnClass(int column) {        if (column >= 0 && column < getColumnCount() && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      @Override      public boolean isCellEditable(int row, int colum) {        return false;      }    };    tableModel.setList(billList);    return tableModel;  }}