package com.ufgov.zc.server.zc.publish.impl;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.zc.publish.IDljgJczwDataExpDelegate;import com.ufgov.zc.server.zc.service.IDljgJczwDataExpService;public class DljgJczwDataExpDelegate implements IDljgJczwDataExpDelegate {  private IDljgJczwDataExpService dljgJczwDataExpService;  public IDljgJczwDataExpService getDljgJczwDataExpService() {    return dljgJczwDataExpService;  }  public void setDljgJczwDataExpService(IDljgJczwDataExpService dljgJczwDataExpService) {    this.dljgJczwDataExpService = dljgJczwDataExpService;  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getWorkFlowInforData(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getWorkFlowInforData(List instanceIds, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getWorkFlowInforData(instanceIds);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbAuditSheetData(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbAuditSheetData(List sheetIds, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbAuditSheetData(sheetIds);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbRequirementData(java.util.List)   */  public List getZcEbRequirementData(List reqCodes) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbRequirementData(reqCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbRequirementDetailData(java.util.List)   */  public List getZcEbRequirementDetailData(List reqCode) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbRequirementDetailData(reqCode);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getAsFile(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getAsFile(List fileIds, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getAsFile(fileIds);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbBidCondition(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbBidCondition(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbBidCondition(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbBulletin(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbBulletin(List bulletinIdIds, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbBulletin(bulletinIdIds);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbEvalReport(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbEvalReport(List zcEbEvalReportIds, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbEvalReport(zcEbEvalReportIds);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbFormula(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbFormula(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbFormula(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbFormulaItem(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbFormulaItem(List formulaCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbFormulaItem(formulaCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbFormulaParam(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbFormulaParam(List formulaCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbFormulaParam(formulaCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbPack(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbPack(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbPack(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbPackReq(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbPackReq(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbPackReq(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbPlan(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbPlan(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbPlan(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbProj(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbProj(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbProj(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbProjZbfile(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbProjZbfile(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbProjZbfile(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbProtocol(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbProtocol(List protCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbProtocol(protCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbRequirementData(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbRequirementData(List reqCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbRequirementData(reqCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbRequirementDetailData(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbRequirementDetailData(List reqCode, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbRequirementDetailData(reqCode);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbXunJia(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbXunJia(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbXunJia(projCodes);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbEntrustData(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbEntrustData(List snList, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbEntrustData(snList);  }  /* (non-Javadoc)   * @see com.ufgov.gk.server.zc.publish.impl.IDljgJczwDataExpDelegate#getZcEbEntrustDetailData(java.util.List, com.ufgov.gk.common.system.RequestMeta)   */  public List getZcEbEntrustDetailData(List entrustSnList, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbEntrustDetailData(entrustSnList);  }  public List getZcPProMakeData(List zcMakeCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcPProMakeData(zcMakeCodes);  }  public List getZcPProMitem(List zcMakeCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcPProMitem(zcMakeCodes);  }  public List getZcPProMitemBi(List zcMakeCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcPProMitemBi(zcMakeCodes);  }  public List getZcPProMitemMer(List zcMakeCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcPProMitemMer(zcMakeCodes);  }  public List getZcEbPackReqDetail(List detailCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEbPackReqDetail(detailCodes);  }  public List getZcEbPackEvalResult(List packCodes, RequestMeta requestMeta) {    return dljgJczwDataExpService.getZcEbPackEvalResult(packCodes);  }  public List getZcEbSignupPackDetailData(List signupId, RequestMeta requestMeta) {    return dljgJczwDataExpService.getZcEbSignupPackDetailData(signupId);  }  public List getZcEbSignupData(List projCodes, RequestMeta requestMeta) {    return dljgJczwDataExpService.getZcEbSignupData(projCodes, requestMeta);  }  public Map getZcXmcgHtData(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcXmcgHtData(projCodes);  }  public List getZcEntrustCancelData(List projCodes, RequestMeta requestMeta) {    // TCJLODO Auto-generated method stub    return dljgJczwDataExpService.getZcEntrustCancelData(projCodes, requestMeta);  }}