package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class HuiyuanZfcgGongyingzizhiFM {
  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("AUDITSTATUS","auditstatus");
    fieldMap.put("DANWEIGUID","danweiguid");
    fieldMap.put("DEADLINEDATE","deadlinedate");
    fieldMap.put("FAZHENGORG","fazhengorg");
    fieldMap.put("ISMAIN","ismain");
    fieldMap.put("KECHENGDANYEWU","kechengdanyewu");
    fieldMap.put("SHOWZY","showzy");
    fieldMap.put("ZHENGSHUNO","zhengshuno");
    fieldMap.put("ZIZHICODE","zizhicode");
    fieldMap.put("ZIZHIGUID","zizhiguid");

  }
}
