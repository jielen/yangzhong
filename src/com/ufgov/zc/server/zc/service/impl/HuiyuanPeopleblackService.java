package com.ufgov.zc.server.zc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.HuiyuanPeopleblack;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper;
import com.ufgov.zc.server.zc.service.IHuiyuanPeopleblackService;

public class HuiyuanPeopleblackService implements IHuiyuanPeopleblackService {


  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private HuiyuanPeopleblackMapper huiyuanPeopleblackMapper;
  
  public HuiyuanPeopleblackMapper getHuiyuanPeopleblackMapper() {
    return huiyuanPeopleblackMapper;
  }


  public void setHuiyuanPeopleblackMapper(HuiyuanPeopleblackMapper huiyuanPeopleblackMapper) {
    this.huiyuanPeopleblackMapper = huiyuanPeopleblackMapper;
  }


  
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




  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanPeopleblackMapper.getMainDataLst(elementConditionDto);
  }

  
  public HuiyuanPeopleblack selectByPrimaryKey(String guid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanPeopleblackMapper.selectByPrimaryKey(guid);
  }

  
  public HuiyuanPeopleblack saveFN(HuiyuanPeopleblack record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if(record.getBlguid()==null || record.getBlguid().trim().length()==0){
      record=insert(record,requestMeta);
    }else{
      record=update(record,requestMeta);
    }
//  createWfDraf(record,requestMeta);
    record.setDbDigest(record.digest());
    return record;
  }

  
  private HuiyuanPeopleblack update(HuiyuanPeopleblack record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanPeopleblackMapper.updateByPrimaryKey(record);
    return record;
  }


  private HuiyuanPeopleblack insert(HuiyuanPeopleblack record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    record.setBlguid(UUID.randomUUID().toString());
    huiyuanPeopleblackMapper.insert(record);    
    return record;
  }

  private void createWfDraf(HuiyuanPeopleblack record, RequestMeta requestMeta) {
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

  public void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanPeopleblackMapper.deleteByPrimaryKey(guid);
  }

  
  public HuiyuanPeopleblack unAuditFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanPeopleblack untreadFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanPeopleblack auditFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanPeopleblack newCommitFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanPeopleblack callbackFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }


}
