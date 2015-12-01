/**
 * 
 */
package com.ufgov.zc.server.zc.publish.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcEbZxjj;
import com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate;
import com.ufgov.zc.server.zc.service.IZcEbZxjjService;

/**
 * @author Administrator
 *
 */
public class ZcEbZxjjServiceDelegate implements IZcEbZxjjServiceDelegate {

  private IZcEbZxjjService zcEbZxjjService;
  
  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.getMainDataLst(elementConditionDto, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#selectByPrimaryKey(java.math.BigDecimal, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public ZcEbZxjj selectByPrimaryKey(BigDecimal id, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.selectByPrimaryKey(id, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#saveFN(com.ufgov.zc.common.zc.model.ZcEbZxjj, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public ZcEbZxjj saveFN(ZcEbZxjj inData, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.saveFN(inData, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#deleteByPrimaryKeyFN(java.math.BigDecimal, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(BigDecimal id, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    zcEbZxjjService.deleteByPrimaryKeyFN(id, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#unAuditFN(com.ufgov.zc.common.zc.model.ZcEbZxjj, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public ZcEbZxjj unAuditFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.unAuditFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#untreadFN(com.ufgov.zc.common.zc.model.ZcEbZxjj, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public ZcEbZxjj untreadFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.untreadFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#auditFN(com.ufgov.zc.common.zc.model.ZcEbZxjj, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public ZcEbZxjj auditFN(ZcEbZxjj qx, RequestMeta requestMeta) throws Exception {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.auditFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#newCommitFN(com.ufgov.zc.common.zc.model.ZcEbZxjj, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public ZcEbZxjj newCommitFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.newCommitFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate#callbackFN(com.ufgov.zc.common.zc.model.ZcEbZxjj, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public ZcEbZxjj callbackFN(ZcEbZxjj qx, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbZxjjService.callbackFN(qx, requestMeta);
  }

  public IZcEbZxjjService getZcEbZxjjService() {
    return zcEbZxjjService;
  }

  public void setZcEbZxjjService(IZcEbZxjjService zcEbZxjjService) {
    this.zcEbZxjjService = zcEbZxjjService;
  }

}
