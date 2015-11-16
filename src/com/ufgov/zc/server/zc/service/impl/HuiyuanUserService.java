package com.ufgov.zc.server.zc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanUserMapper;
import com.ufgov.zc.server.zc.service.IHuiyuanUserService;

public class HuiyuanUserService implements IHuiyuanUserService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private HuiyuanUserMapper huiyuanUserMapper;
  
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


  public HuiyuanUserMapper getHuiyuanUserMapper() {
    return huiyuanUserMapper;
  }


  public void setHuiyuanUserMapper(HuiyuanUserMapper huiyuanUserMapper) {
    this.huiyuanUserMapper = huiyuanUserMapper;
  }


  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserMapper.getMainDataLst(elementConditionDto);
  }

  
  public HuiyuanUser selectByPrimaryKey(String userguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserMapper.selectByPrimaryKey(userguid);
  }

  
  public HuiyuanUser saveFN(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if(record.getUserguid()==null || record.getUserguid().trim().length()==0){
      record=insert(record,requestMeta);
    }else{
      record=update(record,requestMeta);
    }
//  createWfDraf(record,requestMeta);
    record.setDbDigest(record.digest());
    return record;
  }

  
  private HuiyuanUser update(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanUserMapper.updateByPrimaryKey(record);
    return record;
  }


  private HuiyuanUser insert(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    record.setUserguid(UUID.randomUUID().toString());
    huiyuanUserMapper.insert(record);    
    return record;
  }

  private void createWfDraf(HuiyuanUser record, RequestMeta requestMeta) {
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

  public void deleteByPrimaryKeyFN(String userguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanUserMapper.deleteByPrimaryKey(userguid);
  }

  
  public HuiyuanUser unAuditFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser untreadFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser auditFN(HuiyuanUser unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser newCommitFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser callbackFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUser updateAuditStatusFN(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
     huiyuanUserMapper.updateAuditStatusFN(record);
     record.setDbDigest(record.digest());
     return record;
  }

}
