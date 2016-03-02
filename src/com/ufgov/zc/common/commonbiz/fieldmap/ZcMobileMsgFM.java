package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class ZcMobileMsgFM {
  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    fieldMap.put("CODE", "code");
    fieldMap.put("MOBILES", "mobiles");
    fieldMap.put("INPUTOR", "inputor");
    fieldMap.put("INPUT_DATE", "inputDate");
    fieldMap.put("INPUTOR_NAME", "inputorName");
    fieldMap.put("SEND_TIME", "sendTime");
    fieldMap.put("IS_SENDED", "isSended");
    fieldMap.put("CONTENT", "content");

  }
}
