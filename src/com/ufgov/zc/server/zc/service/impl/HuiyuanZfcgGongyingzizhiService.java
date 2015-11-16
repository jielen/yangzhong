package com.ufgov.zc.server.zc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper;
import com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyingzizhiService;

public class HuiyuanZfcgGongyingzizhiService implements IHuiyuanZfcgGongyingzizhiService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private HuiyuanZfcgGongyingzizhiMapper huiyuanZfcgGongyingzizhiMapper;
  
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


  public HuiyuanZfcgGongyingzizhiMapper getHuiyuanZfcgGongyingzizhiMapper() {
    return huiyuanZfcgGongyingzizhiMapper;
  }


  public void setHuiyuanZfcgGongyingzizhiMapper(HuiyuanZfcgGongyingzizhiMapper huiyuanZfcgGongyingzizhiMapper) {
    this.huiyuanZfcgGongyingzizhiMapper = huiyuanZfcgGongyingzizhiMapper;
  }
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcgGongyingzizhiMapper.getMainDataLst(elementConditionDto);
  }

  
  public HuiyuanZfcgGongyingzizhi selectByPrimaryKey(String guid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcgGongyingzizhiMapper.selectByPrimaryKey(guid);
  }

  
  public HuiyuanZfcgGongyingzizhi saveFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }
  
  private HuiyuanZfcgGongyingzizhi update(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanZfcgGongyingzizhiMapper.updateByPrimaryKey(record);
    return record;
  }


  private HuiyuanZfcgGongyingzizhi insert(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    record.setZizhiguid(UUID.randomUUID().toString());
    huiyuanZfcgGongyingzizhiMapper.insert(record);    
    return record;
  }

  private void createWfDraf(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if (record.getProcessInstId() == null || record.getProcessInstId().longValue() == -1) {
      Long draftid = workflowDao.createDraftId();
      record.setProcessInstId(draftid);
      AsWfDraft asWfDraft = new AsWfDraft();
      String userId = requestMeta.getSvUserID();
      String compoId = requestMeta.getCompoId();
      asWfDraft.setCompoId(compoId);
      asWfDraft.setWfDraftName(record.getKechengdanyewu());
      asWfDraft.setUserId(userId);
      asWfDraft.setMasterTabId(compoId);
      asWfDraft.setWfDraftId(BigDecimal.valueOf(record.getProcessInstId().longValue()));
      workflowDao.insertAsWfdraft(asWfDraft);
    }  
  }
  
  public void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanZfcgGongyingzizhiMapper.deleteByPrimaryKey(guid);
  }

  
  public HuiyuanZfcgGongyingzizhi unAuditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi untreadFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi auditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi newCommitFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi callbackFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanZfcgGongyingzizhi updateAuditStatusFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
     huiyuanZfcgGongyingzizhiMapper.updateAuditStatusFN(record);
     record.setDbDigest(record.digest());
     return record;
  }

}
