package com.ufgov.zc.common.commonbiz.fieldmap;import java.util.HashMap;import java.util.Map;public class ZcEmExpertEvaluationFM {  public static Map fieldMap = new HashMap();  static {    //fieldMap.putAll(BaseBillFM.fieldMap);    //fieldMap.put("EM_BILL_CODE", "emBillCode");    fieldMap.put("EM_EXPERT_CODE", "emExpert.emExpertCode");    fieldMap.put("EM_EXPERT_NAME", "emExpert.emExpertName");    fieldMap.put("EM_MOBILE", "emExpert.emMobile");    fieldMap.put("EM_TYPE_CODE", "emExpertType.emTypeCode");    fieldMap.put("EM_TYPE_NAME", "emExpertType.emTypeName");    fieldMap.put("EM_EXPERT_CO_NAME", "emExpert.emUnitName");  }}