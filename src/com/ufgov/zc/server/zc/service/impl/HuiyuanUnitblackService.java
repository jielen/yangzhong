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
import com.ufgov.zc.common.zc.model.HuiyuanUnitblack;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper;
import com.ufgov.zc.server.zc.service.IHuiyuanUnitblackService;

/**
 * @author Administrator
 *
 */
public class HuiyuanUnitblackService  implements IHuiyuanUnitblackService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private HuiyuanUnitblackMapper huiyuanUnitblackMapper;
  
  public HuiyuanUnitblackMapper getHuiyuanUnitblackMapper() {
    return huiyuanUnitblackMapper;
  }


  public void setHuiyuanUnitblackMapper(HuiyuanUnitblackMapper huiyuanUnitblackMapper) {
    this.huiyuanUnitblackMapper = huiyuanUnitblackMapper;
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
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackMapper.getMainDataLst(elementConditionDto);
  }

  
  public HuiyuanUnitblack selectByPrimaryKey(String guid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackMapper.selectByPrimaryKey(guid);
  }

  
  public HuiyuanUnitblack saveFN(HuiyuanUnitblack record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    if(record.getBlguid()==null || record.getBlguid().trim().length()==0){
      record=insert(record,requestMeta);
    }else{
      record=update(record,requestMeta);
    }
//  createWfDraf(record,requestMeta);
    record.setDbDigest(record.digest());
    return record;
  }

  
  private HuiyuanUnitblack update(HuiyuanUnitblack record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    huiyuanUnitblackMapper.updateByPrimaryKey(record);
    return record;
  }


  private HuiyuanUnitblack insert(HuiyuanUnitblack record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    record.setBlguid(UUID.randomUUID().toString());
    huiyuanUnitblackMapper.insert(record);    
    return record;
  }

  private void createWfDraf(HuiyuanUnitblack record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
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
    // TCJLODO Auto-generated method stub
    huiyuanUnitblackMapper.deleteByPrimaryKey(guid);
  }

  
  public HuiyuanUnitblack unAuditFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUnitblack untreadFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUnitblack auditFN(HuiyuanUnitblack unit, RequestMeta requestMeta) throws Exception {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUnitblack newCommitFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

  
  public HuiyuanUnitblack callbackFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return null;
  }

   

}
