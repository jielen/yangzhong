package com.ufgov.zc.server.zc.service;import com.ufgov.zc.common.zc.model.WorkflowImpModel;public interface IWorkFlowImpExpService {  public WorkflowImpModel getWorkFlowInforByInsId(Long instanceId);  public void impWorkFlowInfor(WorkflowImpModel wim);}