package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class ZcEbChangdiFM {
  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("ADDRESS","address");
    fieldMap.put("AREA","area");
    fieldMap.put("CHANGDIGUID","changdiguid");
    fieldMap.put("CHANGDINAME","changdiname");
    fieldMap.put("CHANGDITYPE","changditype");
    fieldMap.put("COMPUTERNUM","computernum");
    fieldMap.put("DIANZIBAIBANNUM","dianzibaibannum");
    fieldMap.put("ISONLINEPINGBIAO","isonlinepingbiao");
    fieldMap.put("ORGCODE","orgcode");
    fieldMap.put("REMARK","remark");
    fieldMap.put("RONGNAIRENSHU","rongnairenshu");
    fieldMap.put("SCALE","scale");
    fieldMap.put("TOUYINGYINUM","touyingyinum");
    fieldMap.put("WIREDMICROPHONENUM","wiredmicrophonenum");
    fieldMap.put("WIRELESSMICROPHONENUM","wirelessmicrophonenum");
    fieldMap.put("STATUS","status");

  }
}
