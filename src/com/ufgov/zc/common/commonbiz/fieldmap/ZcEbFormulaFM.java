/**   * @(#) project: GK* @(#) file: ZcEbFormulaFM.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.common.commonbiz.fieldmap;import java.util.HashMap;import java.util.Map;public class ZcEbFormulaFM {  public static Map fieldMap = new HashMap();  static {    fieldMap.putAll(ZcBaseBillFM.fieldMap);    fieldMap.put("FORMULA_CODE", "formulaCode");    fieldMap.put("EXECUTE_DATE", "executeDate");  }}