/**
 * 
 */
package com.ufgov.zc.server.zc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanUserMapper;
import com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper;
import com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService;

/**
 * @author Administrator
 *
 */
public class HuiyuanUnitcominfoService implements IHuiyuanUnitcominfoService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private HuiyuanZfcgGongyinginfoMapper huiyuanZfcgGongyinginfoMapper;
  private HuiyuanUnitcominfoMapper huiyuanUnitcominfoMapper;
  private HuiyuanUserMapper huiyuanUserMapper;
  private HuiyuanUnitblackMapper huiyuanUnitblackMapper;
  private HuiyuanPeopleblackMapper huiyuanPeopleblackMapper;
  
  
  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
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

  public HuiyuanZfcgGongyinginfoMapper getHuiyuanZfcgGongyinginfoMapper() {
    return huiyuanZfcgGongyinginfoMapper;
  }

  public void setHuiyuanZfcgGongyinginfoMapper(HuiyuanZfcgGongyinginfoMapper huiyuanZfcgGongyinginfoMapper) {
    this.huiyuanZfcgGongyinginfoMapper = huiyuanZfcgGongyinginfoMapper;
  }

  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoMapper.getMainDataLst(elementConditionDto);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#selectByPrimaryKey(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo selectByPrimaryKey(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    HuiyuanUnitcominfo unit=huiyuanUnitcominfoMapper.selectByPrimaryKey(danweiguid);
    if(unit==null)return null;
    unit.setZfcgGysInfo(huiyuanZfcgGongyinginfoMapper.selectByPrimaryKey(danweiguid));
    ElementConditionDto dto=new ElementConditionDto();
    dto.setZcText1(danweiguid);
    unit.setUserLst(huiyuanUserMapper.getMainDataLst(dto));
    unit.setUnitBlackLst(huiyuanUnitblackMapper.getMainDataLst(dto));
    unit.setDbDigest(unit.digest());
    return unit;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#saveFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo saveFN(HuiyuanUnitcominfo record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if(record.getDanweiguid()==null || record.getDanweiguid().trim().length()==0){
      record=insert(record);
    }else{
      record=update(record);
    }
//    createWfDraf(record,requestMeta);
    record.setDbDigest(record.digest());
    return record;
  }

  private void createWfDraf(HuiyuanUnitcominfo record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if (record.getProcessInstId() == null || record.getProcessInstId().longValue() == -1) {
      Long draftid = workflowDao.createDraftId();
      record.setProcessInstId(draftid);
      AsWfDraft asWfDraft = new AsWfDraft();
      String userId = requestMeta.getSvUserID();
      String compoId = requestMeta.getCompoId();
      asWfDraft.setCompoId(compoId);
      asWfDraft.setWfDraftName(record.getDanweiname());
      asWfDraft.setUserId(userId);
      asWfDraft.setMasterTabId(compoId);
      asWfDraft.setWfDraftId(BigDecimal.valueOf(record.getProcessInstId().longValue()));
      workflowDao.insertAsWfdraft(asWfDraft);
    }  
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#updateAuditStatusFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  private HuiyuanUnitcominfo update(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub
    huiyuanUnitcominfoMapper.updateByPrimaryKey(record);
    if(record.getZfcgGysInfo()!=null){
      huiyuanZfcgGongyinginfoMapper.updateByPrimaryKey(record.getZfcgGysInfo());
    }
    return record;
  }

  private HuiyuanUnitcominfo insert(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub
    String uuid=UUID.randomUUID().toString();
    record.setDanweiguid(uuid);
    huiyuanUnitcominfoMapper.insert(record);
    if(record.getZfcgGysInfo()!=null){
      record.getZfcgGysInfo().setDanweiguid(uuid);
      huiyuanZfcgGongyinginfoMapper.insert(record.getZfcgGysInfo());
    }
    record.setDbDigest(record.digest());
    return record;
  }

  public HuiyuanUnitcominfo updateAuditStatusFN(HuiyuanUnitcominfo record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanZfcgGongyinginfoMapper.updateAuditStatusFN(record.getZfcgGysInfo());
    record.setDbDigest(record.digest());
    return record;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanUnitcominfoMapper.deleteByPrimaryKey(danweiguid);
    huiyuanZfcgGongyinginfoMapper.deleteByPrimaryKey(danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo unAuditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.rework(unit.getComment(), unit, requestMeta);
    return unit;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo untreadFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.untread(unit.getComment(), unit, requestMeta);
    return unit;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#auditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo auditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    unit=saveFN(unit, requestMeta);
    wfEngineAdapter.commit(unit.getComment(), unit, requestMeta);
    return selectByPrimaryKey(unit.getDanweiguid(),requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo newCommitFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.newCommit(unit.getComment(), unit, requestMeta);
    return selectByPrimaryKey(unit.getDanweiguid(),requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo callbackFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.callback(unit.getComment(), unit, requestMeta);
    return unit;
  }

  public HuiyuanUnitcominfoMapper getHuiyuanUnitcominfoMapper() {
    return huiyuanUnitcominfoMapper;
  }

  public void setHuiyuanUnitcominfoMapper(HuiyuanUnitcominfoMapper huiyuanUnitcominfoMapper) {
    this.huiyuanUnitcominfoMapper = huiyuanUnitcominfoMapper;
  }

  public HuiyuanUserMapper getHuiyuanUserMapper() {
    return huiyuanUserMapper;
  }

  public void setHuiyuanUserMapper(HuiyuanUserMapper huiyuanUserMapper) {
    this.huiyuanUserMapper = huiyuanUserMapper;
  }

  public HuiyuanUnitblackMapper getHuiyuanUnitblackMapper() {
    return huiyuanUnitblackMapper;
  }

  public void setHuiyuanUnitblackMapper(HuiyuanUnitblackMapper huiyuanUnitblackMapper) {
    this.huiyuanUnitblackMapper = huiyuanUnitblackMapper;
  }

  public HuiyuanPeopleblackMapper getHuiyuanPeopleblackMapper() {
    return huiyuanPeopleblackMapper;
  }

  public void setHuiyuanPeopleblackMapper(HuiyuanPeopleblackMapper huiyuanPeopleblackMapper) {
    this.huiyuanPeopleblackMapper = huiyuanPeopleblackMapper;
  }

}
