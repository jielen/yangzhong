package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class HuiyuanUnitblackFM {


  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("BLACKFENLEI","blackfenlei");
    fieldMap.put("BLACKTYPE","blacktype");
    fieldMap.put("BLGUID","blguid");
    fieldMap.put("CHAXUNJIEGUO","chaxunjieguo");
    fieldMap.put("CHUFADUIXIANG","chufaduixiang");
    fieldMap.put("CHUFAREASON","chufareason");
    fieldMap.put("CHUFATYPE","chufatype");
    fieldMap.put("DANWEIGUID","danweiguid");
    fieldMap.put("DANWEINAME","danweiname");
    fieldMap.put("ENDDATE","enddate");
    fieldMap.put("FROMDATE","fromdate");
    fieldMap.put("INREASON","inreason");
    fieldMap.put("PUNISHDEPARTMENT","punishdepartment");
    fieldMap.put("QIANJIAOALLMONEY","qianjiaoallmoney");
    fieldMap.put("QIANJIAOMONEY","qianjiaomoney");
    fieldMap.put("REMARK","remark");
    fieldMap.put("UNITORGNUM","unitorgnum");
    fieldMap.put("WFPJCHUFADUIXIANG","wfpjchufaduixiang");
    fieldMap.put("ZHIXINGQINGKUANG","zhixingqingkuang");

  }
}
