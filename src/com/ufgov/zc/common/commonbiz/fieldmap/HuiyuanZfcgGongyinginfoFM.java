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
public class HuiyuanZfcgGongyinginfoFM {
  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("ACCOUNT","account");
    fieldMap.put("AUDITSTATUS","auditstatus");
    fieldMap.put("BANK","bank");
    fieldMap.put("DANWEIGUID","danweiguid");
    fieldMap.put("GONGYINGSHANGTYPE","gongyingshangtype");
    fieldMap.put("JINCHUKOUQYPINO","jinchukouqypino");
    fieldMap.put("JINGYETYPE","jingyetype");
    fieldMap.put("LIANXIREN1","lianxiren1");
    fieldMap.put("LIANXIREN1ADDRESS","lianxiren1address");
    fieldMap.put("LIANXIREN1EMAIL","lianxiren1email");
    fieldMap.put("LIANXIREN1FAX","lianxiren1fax");
    fieldMap.put("LIANXIREN1MOBILE","lianxiren1mobile");
    fieldMap.put("LIANXIREN1TEL","lianxiren1tel");
    fieldMap.put("LIANXIREN1ZIP","lianxiren1zip");
    fieldMap.put("LIANXIREN2","lianxiren2");
    fieldMap.put("LIANXIREN2ADDRESS","lianxiren2address");
    fieldMap.put("LIANXIREN2EMAIL","lianxiren2email");
    fieldMap.put("LIANXIREN2FAX","lianxiren2fax");
    fieldMap.put("LIANXIREN2MOBLIE","lianxiren2moblie");
    fieldMap.put("LIANXIREN2TEL","lianxiren2tel");
    fieldMap.put("LIANXIREN2ZIP","lianxiren2zip");
    fieldMap.put("LOCALLIANXIREN","locallianxiren");
    fieldMap.put("LOCALMOBILE","localmobile");
    fieldMap.put("REMARK","remark");
    fieldMap.put("STATUSCODE","statuscode");
    fieldMap.put("ZHUCEJIBIE","zhucejibie");

  }

}
