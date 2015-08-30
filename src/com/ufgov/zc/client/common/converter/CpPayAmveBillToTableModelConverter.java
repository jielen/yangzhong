package com.ufgov.zc.client.common.converter;import java.util.List;import java.util.Map;import java.util.Vector;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.util.CodeNameHandler;import com.ufgov.zc.common.commonbiz.model.MaTzdSumElement;import com.ufgov.zc.common.cp.model.CpPayTransferVou;import com.ufgov.zc.common.system.constants.CpElementConstants;public class CpPayAmveBillToTableModelConverter {  public static Vector getCpPayAmveBillColumns(Map billSumElement) {    Vector names = new Vector();    MaTzdSumElement element = null;    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_BILL_NO));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_A_STATUS_CODE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_AGENT_BANK_NAME));    element = (MaTzdSumElement) billSumElement.get(CpElementConstants.FIELD_NAME_FUND_CODE);    if (element != null) {      if ("1".equals(element.getIsSum())) {        names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_FUND_NAME));      }    }    element = (MaTzdSumElement) billSumElement.get(CpElementConstants.FIELD_NAME_OPERATION_TYPE_CODE);    if (element != null) {      if ("1".equals(element.getIsSum())) {        names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_OPERATION_TYPE_NAME));      }    }    element = (MaTzdSumElement) billSumElement.get(CpElementConstants.FIELD_NAME_ORIGIN_CODE);    if (element != null) {      if ("1".equals(element.getIsSum())) {        names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_ORIGIN_NAME));      }    }    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_SUM_MONEY));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PROC_DATE));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_INPUTOR_ID));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PAY_BANK_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PAY_ACCNAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_PAY_ACC_NO));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_RECE_BANK_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_RECE_ACC_NAME));    names.add(LangTransMeta.translate(CpElementConstants.FIELD_TRANS_RECE_ACC_NO));    return names;  }  public static Vector getCpPayAmveBillRecords(Map billSumElement, List cpAmveBillList) {    Vector values = new Vector();    CpPayTransferVou bill = null;    MaTzdSumElement element = null;    CodeNameHandler.handleNames(cpAmveBillList);    for (int i = 0; i < cpAmveBillList.size(); i++) {      bill = (CpPayTransferVou) cpAmveBillList.get(i);      Vector rowData = new Vector();      rowData.add(bill.getVouNo());      rowData.add(bill.getAstatusName());      rowData.add(bill.getAgentBankName());      element = (MaTzdSumElement) billSumElement.get(CpElementConstants.FIELD_NAME_FUND_CODE);      if (element != null) {        if ("1".equals(element.getIsSum())) {          rowData.add(bill.getFundName());        }      }      element = (MaTzdSumElement) billSumElement.get(CpElementConstants.FIELD_NAME_OPERATION_TYPE_CODE);      if (element != null) {        if ("1".equals(element.getIsSum())) {          rowData.add(bill.getOperationTypeName());        }      }      element = (MaTzdSumElement) billSumElement.get(CpElementConstants.FIELD_NAME_ORIGIN_CODE);      if (element != null) {        if ("1".equals(element.getIsSum())) {          rowData.add(bill.getOriginName());        }      }      rowData.add(bill.getSumMoney());      rowData.add(bill.getProcDate());      rowData.add(bill.getInputorId());      rowData.add(bill.getPayBankName());      rowData.add(bill.getPayAccName());      rowData.add(bill.getPayAccNo());      rowData.add(bill.getReceBankName());      rowData.add(bill.getReceAccName());      rowData.add(bill.getReceAccNo());      values.add(rowData);    }    return values;  }}