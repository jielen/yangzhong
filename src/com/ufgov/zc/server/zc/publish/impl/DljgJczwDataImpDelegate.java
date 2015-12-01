package com.ufgov.zc.server.zc.publish.impl;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.common.zc.model.ZcEbAuditSheet;import com.ufgov.zc.common.zc.model.ZcEbBidCondition;import com.ufgov.zc.common.zc.model.ZcEbBulletin;import com.ufgov.zc.common.zc.model.ZcEbEntrust;import com.ufgov.zc.common.zc.model.ZcEbEntrustCancel;import com.ufgov.zc.common.zc.model.ZcEbEntrustDetail;import com.ufgov.zc.common.zc.model.ZcEbEvalReport;import com.ufgov.zc.common.zc.model.ZcEbFormula;import com.ufgov.zc.common.zc.model.ZcEbFormulaItem;import com.ufgov.zc.common.zc.model.ZcEbFormulaParam;import com.ufgov.zc.common.zc.model.ZcEbPack;import com.ufgov.zc.common.zc.model.ZcEbPackEvalResult;import com.ufgov.zc.common.zc.model.ZcEbPackReq;import com.ufgov.zc.common.zc.model.ZcEbPackReqDetail;import com.ufgov.zc.common.zc.model.ZcEbPlan;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.common.zc.model.ZcEbProjChange;import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;import com.ufgov.zc.common.zc.model.ZcEbProtocol;import com.ufgov.zc.common.zc.model.ZcEbRequirement;import com.ufgov.zc.common.zc.model.ZcEbRequirementDetail;import com.ufgov.zc.common.zc.model.ZcEbSignup;import com.ufgov.zc.common.zc.model.ZcEbSignupPackDetail;import com.ufgov.zc.common.zc.model.ZcEbXunJia;import com.ufgov.zc.common.zc.model.ZcPProMake;import com.ufgov.zc.common.zc.model.ZcPProMitem;import com.ufgov.zc.common.zc.model.ZcPProMitemBi;import com.ufgov.zc.common.zc.model.ZcPProMitemMer;import com.ufgov.zc.common.zc.model.ZcTBchtItem;import com.ufgov.zc.common.zc.model.ZcXmcgHt;import com.ufgov.zc.common.zc.publish.IDljgJczwDataImpDelegate;import com.ufgov.zc.server.zc.service.IDljgJczwDataImpService;public class DljgJczwDataImpDelegate implements IDljgJczwDataImpDelegate {  private IDljgJczwDataImpService dljgJczwDataImpService;  public IDljgJczwDataImpService getDljgJczwDataImpService() {    return dljgJczwDataImpService;  }  public void setDljgJczwDataImpService(IDljgJczwDataImpService dljgJczwDataImpService) {    this.dljgJczwDataImpService = dljgJczwDataImpService;  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbEntrust, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbEntrust po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbEntrustDetail, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbEntrustDetail po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbAuditSheet, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbAuditSheet po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbRequirement, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbRequirement po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbRequirementDetail, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbRequirementDetail po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbProtocol, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbProtocol po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbProj, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbProj po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbPack, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbPack po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbPackReq, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbPackReq po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbBidCondition, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbBidCondition po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbXunJia, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbXunJia po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbProjZbFile, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbProjZbFile po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbPlan, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbPlan po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbFormula, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbFormula po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbFormulaItem, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbFormulaItem po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbFormulaParam, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbFormulaParam po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.zc.model.ZcEbBulletin, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(ZcEbBulletin bu, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(bu);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#saveWorkFlowData(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public void saveWorkFlowData(List list, RequestMeta requestMeta) {    dljgJczwDataImpService.saveWorkFlowData(list);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataImpDelegate#insert(com.ufgov.gk.common.system.model.AsFile, com.ufgov.gk.common.system.RequestMeta)   */  public void insert(AsFile po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  public void insert(ZcPProMake po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public void insert(ZcPProMitem po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public void insert(ZcPProMitemBi po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public void insert(ZcPProMitemMer po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public void insert(ZcEbEvalReport po, RequestMeta requestMeta) {    dljgJczwDataImpService.insert(po);  }  public void insert(ZcEbPackReqDetail po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public void insert(ZcEbSignup po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public void insert(ZcEbSignupPackDetail po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public void insert(ZcEbPackEvalResult po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public String checkZcEbEntrust(List list, RequestMeta requestMeta) {    return dljgJczwDataImpService.checkZcEbEntrust(list);  }  public String insert(ZcEbProjChange po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataImpService.insert(po);  }  public void insert(ZcXmcgHt po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po, requestMeta);  }  public void insert(ZcTBchtItem po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    dljgJczwDataImpService.insert(po);  }  public String insert(ZcEbEntrustCancel po, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataImpService.insert(po);  }}