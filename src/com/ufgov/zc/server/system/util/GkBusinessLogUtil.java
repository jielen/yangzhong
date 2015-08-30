package com.ufgov.zc.server.system.util;import java.util.ArrayList;import java.util.Date;import java.util.HashMap;import java.util.List;import java.util.Map;import com.ufgov.zc.common.bi.model.BiTrack;import com.ufgov.zc.common.commonbiz.model.BaseBill;import com.ufgov.zc.common.cp.model.CpApply;import com.ufgov.zc.common.cp.model.CpPlanAgentRelation;import com.ufgov.zc.common.cp.model.CpPlanClearRelation;import com.ufgov.zc.common.cp.model.CpVoucher;import com.ufgov.zc.common.dp.model.DpDetail;import com.ufgov.zc.common.system.Guid;import com.ufgov.zc.common.system.model.GkBusinessLog;import com.ufgov.zc.server.system.SpringContext;import com.ufgov.zc.server.system.dao.IGkBusinessLogDao;public class GkBusinessLogUtil {  private static IGkBusinessLogDao gkBusinessLogDao = (IGkBusinessLogDao) SpringContext  .getBean("gkBusinessLogDao");  private static Map classTableMap = new HashMap();  static {    classTableMap.put(DpDetail.class.getName(), "DP_DETAIL");    classTableMap.put(CpVoucher.class.getName(), "CP_VOUCHER");    classTableMap.put(CpApply.class.getName(), "CP_APPLY");    classTableMap.put(BiTrack.class.getName(), "BI_TRACK");    classTableMap.put(CpPlanClearRelation.class.getName(), "DP_DETAIL");    classTableMap.put(CpPlanAgentRelation.class.getName(), "DP_DETAIL");  }  public static String getTableName(Class clazz) {    return (String) classTableMap.get(clazz.getName());  }  public static void saveGkBusinessLog(List list) {    List logList = new ArrayList();    for (int i = 0; i < list.size(); i++) {      logList.add(createGkBusinessLog((BaseBill) list.get(i)));    }    gkBusinessLogDao.saveGkBusinessLog(logList);  }  public static void saveGkBusinessLog(BaseBill bill) {    gkBusinessLogDao.saveGkBusinessLog(createGkBusinessLog(bill));  }  private static GkBusinessLog createGkBusinessLog(BaseBill bill) {    GkBusinessLog gkBusinessLog = new GkBusinessLog();    gkBusinessLog.setOid(Guid.genID());    gkBusinessLog.setUserId(RequestMetaUtil.getSvUserID());    gkBusinessLog.setCoCode(RequestMetaUtil.getSvCoCode());    gkBusinessLog.setOrgCode(RequestMetaUtil.getSvOrgCode());    gkBusinessLog.setPosiCode(RequestMetaUtil.getSvPoCode());    gkBusinessLog.setOperTime(new Date());    gkBusinessLog.setBillId(bill.getId());    gkBusinessLog.setTableName(getTableName(bill.getClass()));    gkBusinessLog.setMoney(bill.getCurMoney());    gkBusinessLog.setCompoId(RequestMetaUtil.getCompoId());    gkBusinessLog.setFuncId(RequestMetaUtil.getFuncId());    gkBusinessLog.setRemark(bill.getComment());    gkBusinessLog.setNd(RequestMetaUtil.getSvNd());    //    gkBusinessLog.setDsignedData(bill.getDSignedData());    return gkBusinessLog;  }}