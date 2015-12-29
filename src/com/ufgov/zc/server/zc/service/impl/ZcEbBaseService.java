package com.ufgov.zc.server.zc.service.impl;import java.math.BigDecimal;import java.util.Date;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcBaseBill;import com.ufgov.zc.common.zc.model.ZcPProBal;import com.ufgov.zc.common.zc.model.ZcPProBalBi;import com.ufgov.zc.common.zc.model.ZcPProMake;import com.ufgov.zc.common.zc.model.ZcPProMakeforF3;import com.ufgov.zc.common.zc.model.ZcPProMitemBi;import com.ufgov.zc.common.zc.model.ZcPayforF3;import com.ufgov.zc.common.zc.model.ZcVBiDetail;import com.ufgov.zc.server.system.dao.IWorkflowDao;import com.ufgov.zc.server.system.util.NumUtil;import com.ufgov.zc.server.system.workflow.WFEngineAdapter;import com.ufgov.zc.server.zc.dao.IZcEbBaseServiceDao;import com.ufgov.zc.server.zc.service.IZcEbBaseService;public class ZcEbBaseService implements IZcEbBaseService {  private IZcEbBaseServiceDao zcEbBaseServiceDao;  private WFEngineAdapter wfEngineAdapter;  private IWorkflowDao workflowDao;  /**   * @return the wfEngineAdapter   */  public WFEngineAdapter getWfEngineAdapter() {    return wfEngineAdapter;  }  /**   * @param wfEngineAdapter the wfEngineAdapter to set   */  public void setWfEngineAdapter(WFEngineAdapter wfEngineAdapter) {    this.wfEngineAdapter = wfEngineAdapter;  }  /**   * @return the workflowDao   */  public IWorkflowDao getWorkflowDao() {    return workflowDao;  }  /**   * @param workflowDao the workflowDao to set   */  public void setWorkflowDao(IWorkflowDao workflowDao) {    this.workflowDao = workflowDao;  }  public List getForeignEntitySelectedData(String sqlMapSelectId, ElementConditionDto dto, RequestMeta meta) {    return this.zcEbBaseServiceDao.getForeignEntitySelectedData(sqlMapSelectId, dto, meta);  }  public List queryDataForList(String sqlMapSelectId, Map parameter) {    return this.zcEbBaseServiceDao.queryDataForList(sqlMapSelectId, parameter);  }  public void setZcEbBaseServiceDao(IZcEbBaseServiceDao zcEbBaseServiceDao) {    this.zcEbBaseServiceDao = zcEbBaseServiceDao;  }  public IZcEbBaseServiceDao getZcEbBaseServiceDao() {    return zcEbBaseServiceDao;  }  public String getSequenceNextVal(String sequenceName) {    // TCJLODO Auto-generated method stub    return this.zcEbBaseServiceDao.getSequenceNextVal(sequenceName);  }  public List queryDataForList(String sqlMapSelectId, Object param) {    return this.zcEbBaseServiceDao.queryDataForList(sqlMapSelectId, param);  }  public Object queryObject(String sqlMapSelectId, Object param) {    return this.zcEbBaseServiceDao.queryObject(sqlMapSelectId, param);  }  public void insertDataForObject(String sqlMapSelectId, Object param) {    this.zcEbBaseServiceDao.insertDataForObject(sqlMapSelectId, param);  }  public void updateObjectList(String sqlMapUpdateId, List list) {    this.zcEbBaseServiceDao.updateObjectList(sqlMapUpdateId, list);  }  /**   * 工作流相关   */  public ZcBaseBill auditFN(ZcBaseBill bill, RequestMeta requestMeta) {    wfEngineAdapter.commit(bill.getComment(), bill, requestMeta);    return bill;  }  public ZcBaseBill callbackFN(ZcBaseBill bill, RequestMeta requestMeta) {    wfEngineAdapter.callback(bill.getComment(), bill, requestMeta);    return bill;  }  public ZcBaseBill newCommitFN(ZcBaseBill bill, RequestMeta requestMeta) {    wfEngineAdapter.newCommit(bill.getComment(), bill, requestMeta);    return bill;  }  public ZcBaseBill unauditFN(ZcBaseBill bill, RequestMeta requestMeta) {    wfEngineAdapter.unAudit(bill.getComment(), bill, requestMeta);    return bill;  }  public ZcBaseBill untreadFN(ZcBaseBill bill, RequestMeta requestMeta) {    wfEngineAdapter.untread(bill.getComment(), bill, requestMeta);    return bill;  }  public String chackBiMoney(ZcPProMake make) {    List biList = make.getBiList();    String info = "";    for (int i = 0; i < biList.size(); i++) {      ZcPProMitemBi bi = (ZcPProMitemBi) biList.get(i);      String biNo = bi.getZcBiNo();      BigDecimal biJhuaSum = bi.getZcBiJhuaSum();      if (biNo != null && !"".equals(biNo.trim())) {        List list = zcEbBaseServiceDao.getZcVBiDetail(biNo);        if (list != null && list.size() > 0) {          ZcVBiDetail detail = (ZcVBiDetail) list.get(0);          BigDecimal f3DoSum = detail.getZcBiDoSum();          if (biJhuaSum.compareTo(f3DoSum) > 0) {            info = info + "指标编号为[" + biNo + "]的预算使用金额已超预算！\n";          }        } else {          info = info + "指标编号为[" + biNo + "]的预算使用金额已超预算！\n";        }      }    }    return info;  }  public void insertF3Pay(ZcPProBal zcPProBal) {    List listBalBi = zcPProBal.getBiList();    for (int i = 0; i < listBalBi.size(); i++) {      ZcPProBalBi proBalBi = (ZcPProBalBi) listBalBi.get(i);      if (proBalBi.getZcBiNo() != null && !"".equals(proBalBi.getZcBiNo())) {        ZcPayforF3 payForF3 = new ZcPayforF3();        payForF3.setPayId(proBalBi.getZcBalBiId());        payForF3.setBranId(proBalBi.getZcHtCode());        payForF3.setPlanId(proBalBi.getZcProBiSeq());        payForF3.setBudgetId(proBalBi.getZcBiNo());        payForF3.setBranNo(proBalBi.getZcHtCode());        payForF3.setPayeeAccountName(zcPProBal.getZcSuAccName());        payForF3.setPayeeAccountNo(zcPProBal.getZcSuAccCode());        payForF3.setPayeeAccountBank(zcPProBal.getZcSuBankName());        payForF3.setDirCode(proBalBi.getZcCatalogueCode());        payForF3.setDirName(proBalBi.getZcCatalogueName());        payForF3.setPayMoney(proBalBi.getZcBiBcjsSum());        payForF3.setPkCode(proBalBi.getZcPaytypeCode());        payForF3.setPkName(proBalBi.getZcPaytypeName());        payForF3.setMkCode(proBalBi.getZcFundCode());        payForF3.setMkName(proBalBi.getZcFundName());        payForF3.setLastVer(new Date());        payForF3.setDownloadStatus("0");        payForF3.setPayStatus("0");        zcEbBaseServiceDao.insertF3Pay(payForF3);      }    }  }  public String getPayStatus(String balBiId) {    return zcEbBaseServiceDao.getPayStatus(balBiId);  }  public void insertF3ProMake(ZcPProMake proMake, Integer adjustWay) {    List biList = proMake.getBiList();    for (int i = 0; i < biList.size(); i++) {      ZcPProMitemBi bi = (ZcPProMitemBi) biList.get(i);      String biNo = bi.getZcBiNo();      if (biNo != null && !"".equals(biNo.trim())) {        ZcPProMakeforF3 zcPProMakeforF3 = new ZcPProMakeforF3();        zcPProMakeforF3.setPlanId(bi.getZcProBiSeq());        zcPProMakeforF3.setBudgetId(biNo);        zcPProMakeforF3.setPlanMoney(bi.getZcBiJhuaSum());        zcPProMakeforF3.setAdjustWay(adjustWay);        zcPProMakeforF3.setPlanNO(bi.getZcMakeCode());        zcPProMakeforF3.setLastVer(new Date());        zcPProMakeforF3.setDownloadStatus(0);        zcEbBaseServiceDao.insertF3ProMake(zcPProMakeforF3);      }    }  }  public List getCurrentOpenBidList(Map map, RequestMeta meta) {    return zcEbBaseServiceDao.getCurrentOpenBidList(map, meta);  }  public List getCurrentBidEndList(Map map, RequestMeta meta) {    return zcEbBaseServiceDao.getCurrentBidEndList(map, meta);  }  public void insertWithDelete(String delSqlId, Object delValueMap, String insertSqlId, Object insertValueMap, RequestMeta meta) {    // TCJLODO Auto-generated method stub    this.zcEbBaseServiceDao.delete(delSqlId, delValueMap);    this.zcEbBaseServiceDao.insertDataForObject(insertSqlId, insertValueMap);  }  public String getNextVal(String sequenceName) {    // TCJLODO Auto-generated method stub    return this.zcEbBaseServiceDao.getNextVal(sequenceName);  }  public String getCompoNo(String compoId, String noField, Object bill, RequestMeta meta) {    return NumUtil.getInstance().getNo(compoId, noField, bill);  }}