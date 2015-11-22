package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class ZcEbChangdiUsedFM {
  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("CHANGDIGUID","changdiguid");
    fieldMap.put("CHANGDIUSEDID","changdiusedid");
    fieldMap.put("ENDDATE","enddate");
    fieldMap.put("ND","nd");
    fieldMap.put("REQUESTGUID","requestguid");
    fieldMap.put("REQUESTPEOPLE","requestpeople");
    fieldMap.put("REQUESTPEOPLEGUID","requestpeopleguid");
    fieldMap.put("REQUESTUNIT","requestunit");
    fieldMap.put("REQUESTUNITGUID","requestunitguid");
    fieldMap.put("STARTDATE","startdate");
    fieldMap.put("USEDCONTENT","usedcontent");
    fieldMap.put("USEDTYPE","usedtype");
    fieldMap.put("CHANGDINAME","changdiname");
    fieldMap.put("PROJCODE","projcode");
    fieldMap.put("PROJNAME","projname");
    fieldMap.put("PLANCODE","plancode");

  }

}
