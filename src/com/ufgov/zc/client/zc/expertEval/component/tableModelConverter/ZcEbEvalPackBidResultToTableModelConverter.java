/**   * @(#) project: Gk* @(#) file: ZcEbEvalPackBidResultToTableModelConverter.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.zc.expertEval.component.tableModelConverter;import java.util.List;import java.util.Vector;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.converter.zc.BaseEntryToTableModelConverter;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.zc.model.ZcEbPackEvalResult;/*** @ClassName: ZcEbEvalPackBidResultToTableModelConverter* @Description: 中标候选人结果表* @date: 2010-5-22 上午10:44:51* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ZcEbEvalPackBidResultToTableModelConverter extends BaseEntryToTableModelConverter {  protected Vector<String> getColumnName() {    Vector<String> names = new Vector<String>();    //    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_RESULT_ORD_INDX));    names.add("供应商报价");    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_RESULT_PROVIDER_NAME));    names.add(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_RESULT_EVAL_SCORE));    return names;  }  protected Vector<Object> getValue(List list) {    Vector<Object> values = new Vector<Object>();    if (null != list) {      for (int i = 0; i < list.size(); i++) {        values.add(toRowData((ZcEbPackEvalResult) list.get(i)));      }    }    return values;  }  private static Vector<Object> toRowData(ZcEbPackEvalResult zcEbPackEvalResult) {    Vector<Object> rowData = new Vector<Object>();    //    rowData.add(zcEbPackEvalResult.getIndx());    rowData.add(zcEbPackEvalResult.getProviderTotalPrice());    rowData.add(zcEbPackEvalResult.getProviderName());    rowData.add(zcEbPackEvalResult.getEvalScore());    return rowData;  }}