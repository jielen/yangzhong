package com.ufgov.zc.client.datacache;import java.util.Collections;import java.util.HashMap;import java.util.List;import java.util.Map;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.common.commonbiz.model.BAcc;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;public class NyBAccDataCache {  private static List dataList;  private static Map dataMap;  public static synchronized void refreshData() {    int nd = WorkEnv.getInstance().getTransNd();    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();    ElementConditionDto dto = new ElementConditionDto();    dto.setNd(nd + 1);    dataList = Collections.unmodifiableList(Util.baseDataServiceDelegate.getBAcc(dto, requestMeta));    Map tempMap = new HashMap();    for (Object o : dataList) {      BAcc temp = (BAcc) o;      tempMap.put(temp.getCode(), temp);    }    dataMap = Collections.unmodifiableMap(tempMap);  }  private static void getData() {    if (dataList == null) {      refreshData();    }  }  public static List getBAcc() {    getData();    return dataList;  }  public static String getName(String code) {    getData();    BAcc value = (BAcc) dataMap.get(code);    if (value != null) {      return value.getName();    }    return code;  }}