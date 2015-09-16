package com.ufgov.zc.server.zc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.common.zc.model.ZcEbZxjj;
import com.ufgov.zc.common.zc.model.ZcEbZxjjHistory;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.ZcSUtil;
import com.ufgov.zc.server.zc.dao.IZcEbZxjjDao;
import com.ufgov.zc.server.zc.dao.IZcEbZxjjHistoryDao;
import com.ufgov.zc.server.zc.dao.ibatis.ZcEbZxjjDao;
import com.ufgov.zc.server.zc.dao.ibatis.ZcEbZxjjHistoryDao;
import com.ufgov.zc.server.zc.service.IZcEbZxjjService;

public class ZcEbZxjjService implements IZcEbZxjjService {

  private IWorkflowDao workflowDao;
  private WFEngineAdapter wfEngineAdapter;
  private IZcEbZxjjDao zxjjMapper;
  private IZcEbZxjjHistoryDao zxjjHistoryMapper;
  
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


  public IZcEbZxjjDao getZxjjMapper() {
    return zxjjMapper;
  }


  public void setZxjjMapper(IZcEbZxjjDao zxjjMapper) {
    this.zxjjMapper = zxjjMapper;
  }


  public IZcEbZxjjHistoryDao getZxjjHistoryMapper() {
    return zxjjHistoryMapper;
  }


  public void setZxjjHistoryMapper(IZcEbZxjjHistoryDao zxjjHistoryMapper) {
    this.zxjjHistoryMapper = zxjjHistoryMapper;
  }


  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return getZxjjMapper().getMainDataLst(elementConditionDto);
  }

  
  public ZcEbZxjj selectByPrimaryKey(BigDecimal id, RequestMeta requestMeta) {
    // TODO Auto-generated method stu
    ZcEbZxjj rtn=getZxjjMapper().selectByPrimaryKey(id);
    if(rtn==null)return null;
    ElementConditionDto dto=new ElementConditionDto();
    dto.setNormalId(id);
    rtn.setHistoryList(getZxjjHistoryMapper().selectByJjCode(dto));
    rtn.setDbDigest(rtn.digest());
    return rtn;
  }

  
  public ZcEbZxjj saveFN(ZcEbZxjj inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if (inData.getJjCode()==null ) {

      BigDecimal id=new BigDecimal(ZcSUtil.getNextVal(ZcEbZxjj.SEQ_NAME));
      inData.setJjCode(id);  

      boolean isDraft = false;
      String userId = requestMeta.getSvUserID();
      String compoId = requestMeta.getCompoId();
      
      if (inData.getProcessInstId() == null || inData.getProcessInstId().longValue() == -1) {
        Long draftid = workflowDao.createDraftId();
        inData.setProcessInstId(draftid);
        isDraft = true;
      }      
      insert(inData,requestMeta);
      if (isDraft) {
        AsWfDraft asWfDraft = new AsWfDraft();
        asWfDraft.setCompoId(compoId);
        asWfDraft.setWfDraftName(inData.getProjCode());
        asWfDraft.setUserId(userId);
        asWfDraft.setMasterTabId(compoId);
        asWfDraft.setWfDraftId(BigDecimal.valueOf(inData.getProcessInstId().longValue()));
        workflowDao.insertAsWfdraft(asWfDraft);
      }
   }else{
     update(inData,requestMeta);
   }
   return inData;
  }


  private void insert(ZcEbZxjj inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    getZxjjMapper().insert(inData);
    if(inData.getHistoryList()!=null){
      for(int i=0;i<inData.getHistoryList().size();i++){
        ZcEbZxjjHistory m=(ZcEbZxjjHistory) inData.getHistoryList().get(i);
        m.setJjCode(inData.getJjCode());
  
        getZxjjHistoryMapper().insert(m);
      }
    } 
  }

  private void update(ZcEbZxjj inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    getZxjjMapper().updateByPrimaryKey(inData);
    
    getZxjjHistoryMapper().deleteByPrimaryKey(inData.getJjCode());
    if(inData.getHistoryList()!=null){
      for(int i=0;i<inData.getHistoryList().size();i++){
        ZcEbZxjjHistory m=(ZcEbZxjjHistory) inData.getHistoryList().get(i);
        m.setJjCode(inData.getJjCode());
  
        getZxjjHistoryMapper().insert(m);
      }
    }
   
    
  }
  
  public void deleteByPrimaryKeyFN(BigDecimal id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    getZxjjHistoryMapper().deleteByPrimaryKey(id);
    getZxjjMapper().deleteByPrimaryKey(id);
  }

  
  public ZcEbZxjj unAuditFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.rework(qx.getComment(), qx, requestMeta);
    return qx;
  }

  
  public ZcEbZxjj untreadFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.untread(qx.getComment(), qx, requestMeta);
    return qx;
  }

  
  public ZcEbZxjj auditFN(ZcEbZxjj qx, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    qx=saveFN(qx, requestMeta);
    wfEngineAdapter.commit(qx.getComment(), qx, requestMeta);
    return selectByPrimaryKey(qx.getJjCode(),requestMeta);
  }

  
  public ZcEbZxjj newCommitFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.newCommit(qx.getComment(), qx, requestMeta);
    return selectByPrimaryKey(qx.getJjCode(),requestMeta);
  }

  
  public ZcEbZxjj callbackFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.callback(qx.getComment(), qx, requestMeta);
    return qx;
  }


}
