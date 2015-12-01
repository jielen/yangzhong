package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class ZcEbQuesFM {
  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);

    fieldMap.put("AGENCY", "agency");
    fieldMap.put("CLIENT_FILENAME", "clientFilename");
    fieldMap.put("CLIENT_REASON", "clientReason");
    fieldMap.put("CLIENT_SUBMIT_TSDATE", "clientSubmitTsdate");
    fieldMap.put("CLIENT_SUBMIT_ZYDATE", "clientSubmitZydate");
    fieldMap.put("CO_CODE", "coCode");
    fieldMap.put("CREATEDATE", "createdate");
    fieldMap.put("DW_FILENAME", "dwFilename");
    fieldMap.put("HANDLE_MODE", "handleMode");
    fieldMap.put("ID", "id");
    fieldMap.put("JB_DODATE", "jbDodate");
    fieldMap.put("JB_FILENAME", "jbFilename");
    fieldMap.put("JB_PERSON", "jbPerson");
    fieldMap.put("JB_REASON", "jbReason");
    fieldMap.put("ND", "nd");
    fieldMap.put("ORG_CODE", "orgCode");
    fieldMap.put("PERSON", "person");
    fieldMap.put("PERSONORG", "personorg");
    fieldMap.put("PERSON_TEL", "personTel");
    fieldMap.put("PROCESS_INST_ID", "processInstId");
    fieldMap.put("PROJ", "proj");
    fieldMap.put("QUES_ID", "quesId");
    fieldMap.put("QUES_TYPE", "quesType");
    fieldMap.put("SENUSER", "senuser");
    fieldMap.put("STATE", "state");
    fieldMap.put("TEMP", "temp");
    fieldMap.put("TEMP1", "temp1");
    fieldMap.put("TEMP2", "temp2");
    fieldMap.put("TEMP3", "temp3");

  }

}
