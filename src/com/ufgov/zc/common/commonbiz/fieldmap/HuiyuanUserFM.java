package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class HuiyuanUserFM {

  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("AUDITSTATUS","auditstatus");
    fieldMap.put("BIRTHDAY","birthday");
    fieldMap.put("CERTSUBJECTKEYID","certsubjectkeyid");
    fieldMap.put("CERTYOUXIAOQI","certyouxiaoqi");
    fieldMap.put("COMADDRESS","comaddress");
    fieldMap.put("COMPANYPHONE","companyphone");
    fieldMap.put("COMZIP","comzip");
    fieldMap.put("DANWEIGUID","danweiguid");
    fieldMap.put("DANWEINAME","danweiname");
    fieldMap.put("DEVICENUM","devicenum");
    fieldMap.put("DISPLAYNAME","displayname");
    fieldMap.put("DOGNUM","dognum");
    fieldMap.put("EMAIL","email");
    fieldMap.put("IDCARD","idcard");
    fieldMap.put("JIAOYANNO","jiaoyanno");
    fieldMap.put("LOGINID","loginid");
    fieldMap.put("MOBILEPHONE","mobilephone");
    fieldMap.put("PASSWD","passwd");
    fieldMap.put("REMARK","remark");
    fieldMap.put("SEX","sex");
    fieldMap.put("STATUSCODE","statuscode");
    fieldMap.put("USERGUID","userguid");
    fieldMap.put("USERTYPE","usertype");
    fieldMap.put("YXQ","yxq");
    fieldMap.put("ZHAOPIAN","zhaopian");
    fieldMap.put("ZHENGSHUTYPE","zhengshutype");
    
  }
}
