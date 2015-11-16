/**
 * 
 */
package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class HuiyuanUnitcominfoFM {

  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("AREACODE","areacode");
    fieldMap.put("AREANAME","areaname");
    fieldMap.put("ASSISTANTITEM","assistantitem");
    fieldMap.put("ASSISTANTPRODUCT","assistantproduct");
    fieldMap.put("BUILDDATE","builddate");
    fieldMap.put("CHENLITIME","chenlitime");
    fieldMap.put("COMPANYDES","companydes");
    fieldMap.put("COMPANYTYPE","companytype");
    fieldMap.put("DANWEIGUID","danweiguid");
    fieldMap.put("DANWEINAME","danweiname");
    fieldMap.put("DANWEITYPE","danweitype");
    fieldMap.put("DENGJIJIGUAN","dengjijiguan");
    fieldMap.put("DISHUINO","dishuino");
    fieldMap.put("ENGLISHNAME","englishname");
    fieldMap.put("FAREN","faren");
    fieldMap.put("FARENLICENCENUM","farenlicencenum");
    fieldMap.put("FARENTEL","farentel");
    fieldMap.put("FARENZHICHENG","farenzhicheng");
    fieldMap.put("FARENZHIWU","farenzhiwu");
    fieldMap.put("GUOSHUINO","guoshuino");
    fieldMap.put("JINYINGFANWEI","jinyingfanwei");
    fieldMap.put("LICENCENUM","licencenum");
    fieldMap.put("MAINITEM","mainitem");
    fieldMap.put("MIANPRODUCT","mianproduct");
    fieldMap.put("NIANJIANJIEGUO","nianjianjieguo");
    fieldMap.put("QIYESHEBAOHAO","qiyeshebaohao");
    fieldMap.put("UNITJIANCHENG","unitjiancheng");
    fieldMap.put("UNITORGNUM","unitorgnum");
    fieldMap.put("WEBADDRESS","webaddress");
    fieldMap.put("YINGYEQIXIANFROM","yingyeqixianfrom");
    fieldMap.put("YINGYEQIXIANTO","yingyeqixianto");
    fieldMap.put("ZHUCEADDRESS","zhuceaddress");
    fieldMap.put("ZHUCETYPE","zhucetype");
    fieldMap.put("ZHUCEZIBEN","zhuceziben");

    fieldMap.put("AUDITSTATUS","zfcgGysInfo.auditstatus");
    fieldMap.put("STATUSCODE","zfcgGysInfo.statuscode");
    
    fieldMap.put("ACCOUNT","zfcgGysInfo.account"); 
    fieldMap.put("BANK","zfcgGysInfo.bank"); 
    fieldMap.put("GONGYINGSHANGTYPE","zfcgGysInfo.gongyingshangtype");
    fieldMap.put("JINCHUKOUQYPINO","zfcgGysInfo.jinchukouqypino");
    fieldMap.put("JINGYETYPE","zfcgGysInfo.jingyetype");
    fieldMap.put("LIANXIREN1","zfcgGysInfo.lianxiren1");
    fieldMap.put("LIANXIREN1ADDRESS","zfcgGysInfo.lianxiren1address");
    fieldMap.put("LIANXIREN1EMAIL","zfcgGysInfo.lianxiren1email");
    fieldMap.put("LIANXIREN1FAX","zfcgGysInfo.lianxiren1fax");
    fieldMap.put("LIANXIREN1MOBILE","zfcgGysInfo.lianxiren1mobile");
    fieldMap.put("LIANXIREN1TEL","zfcgGysInfo.lianxiren1tel");
    fieldMap.put("LIANXIREN1ZIP","zfcgGysInfo.lianxiren1zip");
    fieldMap.put("LIANXIREN2","zfcgGysInfo.lianxiren2");
    fieldMap.put("LIANXIREN2ADDRESS","zfcgGysInfo.lianxiren2address");
    fieldMap.put("LIANXIREN2EMAIL","zfcgGysInfo.lianxiren2email");
    fieldMap.put("LIANXIREN2FAX","zfcgGysInfo.lianxiren2fax");
    fieldMap.put("LIANXIREN2MOBLIE","zfcgGysInfo.lianxiren2moblie");
    fieldMap.put("LIANXIREN2TEL","zfcgGysInfo.lianxiren2tel");
    fieldMap.put("LIANXIREN2ZIP","zfcgGysInfo.lianxiren2zip");
    fieldMap.put("LOCALLIANXIREN","zfcgGysInfo.locallianxiren");
    fieldMap.put("LOCALMOBILE","zfcgGysInfo.localmobile");
    fieldMap.put("REMARK","zfcgGysInfo.remark"); 
    fieldMap.put("ZHUCEJIBIE","zfcgGysInfo.zhucejibie");


  }
}
