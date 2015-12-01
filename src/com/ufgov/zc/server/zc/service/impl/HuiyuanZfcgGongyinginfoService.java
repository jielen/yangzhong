/**
 * 
 */
package com.ufgov.zc.server.zc.service.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper;
import com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService;
import com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService;

/**
 * @author Administrator
 *
 */
public class HuiyuanZfcgGongyinginfoService implements IHuiyuanZfcgGongyinginfoService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private IHuiyuanUnitcominfoService huiyuanUnitcominfoService;
  private HuiyuanZfcgGongyinginfoMapper huiyuanZfcgGongyinginfoMapper;
  

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public IWorkflowDao getWorkflowDao() {
    return workflowDao;
  }

  public void setWorkflowDao(IWorkflowDao workflowDao) {
    this.workflowDao = workflowDao;
  }

  public WFEngineAdapter getWfEngineAdapter() {
    return wfEngineAdapter;
  }

  public void setWfEngineAdapter(WFEngineAdapter wfEngineAdapter) {
    this.wfEngineAdapter = wfEngineAdapter;
  }

  public IHuiyuanUnitcominfoService getHuiyuanUnitcominfoService() {
    return huiyuanUnitcominfoService;
  }

  public void setHuiyuanUnitcominfoService(IHuiyuanUnitcominfoService huiyuanUnitcominfoService) {
    this.huiyuanUnitcominfoService = huiyuanUnitcominfoService;
  }

  public HuiyuanZfcgGongyinginfoMapper getHuiyuanZfcgGongyinginfoMapper() {
    return huiyuanZfcgGongyinginfoMapper;
  }

  public void setHuiyuanZfcgGongyinginfoMapper(HuiyuanZfcgGongyinginfoMapper huiyuanZfcgGongyinginfoMapper) {
    this.huiyuanZfcgGongyinginfoMapper = huiyuanZfcgGongyinginfoMapper;
  }

  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitcominfoService.getMainDataLst(elementConditionDto, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#selectByPrimaryKey(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo selectByPrimaryKey(String id, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    HuiyuanZfcgGongyinginfo gys=huiyuanZfcgGongyinginfoMapper.selectByPrimaryKey(id);
    if(gys==null)return null;
    
    HuiyuanUnitcominfo unit=huiyuanUnitcominfoService.selectByPrimaryKey(id, requestMeta);
    if(unit==null)return null;
    unit.setZfcgGysInfo(huiyuanZfcgGongyinginfoMapper.selectByPrimaryKey(id));
    
    return huiyuanZfcgGongyinginfoMapper.selectByPrimaryKey(id);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#saveFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo saveFN(HuiyuanZfcgGongyinginfo inData, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#updateAuditStatusFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void updateAuditStatusFN(HuiyuanZfcgGongyinginfo inData, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String id, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo unAuditFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo untreadFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#auditFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo auditFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta) throws Exception {
    // TCJLODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo newCommitFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo callbackFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

}
