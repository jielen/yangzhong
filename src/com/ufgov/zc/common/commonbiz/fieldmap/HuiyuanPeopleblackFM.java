package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class HuiyuanPeopleblackFM {

  public static Map fieldMap = new HashMap();
  
  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("BLGUID","blguid");
    fieldMap.put("CHAXUNJIEGUO","chaxunjieguo");
    fieldMap.put("CHUFADUIXIANG","chufaduixiang");
    fieldMap.put("CHUFAREASON","chufareason");
    fieldMap.put("CHUFATYPE","chufatype");
    fieldMap.put("CHUFAYIJU","chufayiju");
    fieldMap.put("CHULIJIGUAN","chulijiguan");
    fieldMap.put("DANWEIGUID","danweiguid");
    fieldMap.put("DANWEINAME","danweiname");
    fieldMap.put("ENDDATE","enddate");
    fieldMap.put("FROMDATE","fromdate");
    fieldMap.put("IDCARD","idcard");
    fieldMap.put("INREASON","inreason");
    fieldMap.put("PGUID","pguid");
    fieldMap.put("PNAME","pname");
    fieldMap.put("REMARK","remark");
    fieldMap.put("RYCHUFATYPE","rychufatype");
    fieldMap.put("ZHIXINGQINGKUANG","zhixingqingkuang");
    
  }

}
