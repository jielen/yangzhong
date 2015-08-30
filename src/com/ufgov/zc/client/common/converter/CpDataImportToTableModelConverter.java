package com.ufgov.zc.client.common.converter;import java.util.List;import java.util.Vector;import javax.swing.table.DefaultTableModel;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.util.CodeNameHandler;import com.ufgov.zc.common.cp.model.CpImpRecord;import com.ufgov.zc.common.system.constants.CpElementConstants;public class CpDataImportToTableModelConverter {  public static DefaultTableModel convertDataImportToTableModelListPage(List cpImpRecordList,  String billElementId) {    BillElementMeta bem = BillElementMeta.getBillElementMeta(billElementId);    return convertDataImportToTableModelForListPage(cpImpRecordList, bem);  }  public static DefaultTableModel convertDataImportToTableModelForListPage(List cpImpRecordList,  BillElementMeta bem) {    CodeNameHandler.handleNames(cpImpRecordList);    MyTableModel importTableModel = null;    Vector names = new Vector();    Vector values = new Vector();    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ND));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_BILLDATE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_CO_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_CO_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ORG_MONEY));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ORG_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ORG_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_FUND_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_FUND_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_B_ACC_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_B_ACC_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_OUTLAY_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_OUTLAY_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PAYOUT_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PAYOUT_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_MANAGE_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_MANAGE_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_BAL_MODE_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_BAL_MODE_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PROJECT_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PROJECT_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_RECE_ACCNAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_RECE_BANKACCCODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_RECE_BANKNODENAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PAY_ACCNAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PAY_BANKNODENAMEE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_NAME_PAY_BANKACCCODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_REMARK));    if (cpImpRecordList != null && cpImpRecordList.size() > 0) {      for (int i = 0; i < cpImpRecordList.size(); i++) {        Vector rowData = new Vector();        CpImpRecord cpImpRecord = (CpImpRecord) cpImpRecordList.get(i);        rowData.add(cpImpRecord.getNd());        rowData.add(cpImpRecord.getBillDate());        rowData.add(cpImpRecord.getCoCode());        rowData.add(cpImpRecord.getCoName());        rowData.add(cpImpRecord.getOrgMoney());        rowData.add(cpImpRecord.getOrgCode());        rowData.add(cpImpRecord.getOrgName());        rowData.add(cpImpRecord.getFundCode());        rowData.add(cpImpRecord.getFundName());        rowData.add(cpImpRecord.getBaccCode());        rowData.add(cpImpRecord.getBaccName());        rowData.add(cpImpRecord.getOutlayCode());        rowData.add(cpImpRecord.getOutlayName());        rowData.add(cpImpRecord.getPayoutCode());        rowData.add(cpImpRecord.getPayoutName());        rowData.add(cpImpRecord.getManageCode());        rowData.add(cpImpRecord.getManageName());        rowData.add(cpImpRecord.getBalModeCode());        rowData.add(cpImpRecord.getBalModeName());        rowData.add(cpImpRecord.getProjectCode());        rowData.add(cpImpRecord.getProjectName());        rowData.add(cpImpRecord.getReceAccName());        rowData.add(cpImpRecord.getReceBankAccCode());        rowData.add(cpImpRecord.getReceBankNodeName());        rowData.add(cpImpRecord.getPayAccName());        rowData.add(cpImpRecord.getPayBankAccCode());        rowData.add(cpImpRecord.getPayBankNodeName());        rowData.add(cpImpRecord.getRemark());        values.add(rowData);      }    }    importTableModel = new MyTableModel(values, names) {      @Override      public Class getColumnClass(int column) {        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {          for (int row = 0; row < this.getRowCount(); row++) {            if (getValueAt(row, column) != null) {              return getValueAt(row, column).getClass();            }          }        }        return Object.class;      }      @Override      public boolean isCellEditable(int row, int colum) {        return false;      }    };    importTableModel.setList(cpImpRecordList);    return importTableModel;  }}