/**
 * 
 */
package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate;
import com.ufgov.zc.server.zc.service.IHuiyuanUnitcominfoService;

/**
 * @author Administrator
 *
 */
public class HuiyuanUnitcominfoDelegate implements IHuiyuanUnitcominfoDelegate {
  
  private IHuiyuanUnitcominfoService huiyuanUnitcominfoService;

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.getMainDataLst(elementConditionDto, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#selectByPrimaryKey(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo selectByPrimaryKey(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.selectByPrimaryKey(danweiguid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#saveFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo saveFN(HuiyuanUnitcominfo record, RequestMeta requestMeta) throws BusinessException{
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.saveFN(record, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanUnitcominfoService.deleteByPrimaryKeyFN(danweiguid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo unAuditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.unAuditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo untreadFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.untreadFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#auditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo auditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.auditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo newCommitFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.newCommitFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitcominfo callbackFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.callbackFN(unit, requestMeta);
  }

  public IHuiyuanUnitcominfoService getHuiyuanUnitcominfoService() {
    return huiyuanUnitcominfoService;
  }

  public void setHuiyuanUnitcominfoService(IHuiyuanUnitcominfoService huiyuanUnitcominfoService) {
    this.huiyuanUnitcominfoService = huiyuanUnitcominfoService;
  }
 
  public HuiyuanUnitcominfo updateAuditStatusFN(HuiyuanUnitcominfo record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.updateAuditStatusFN(record, requestMeta);
  }

   
  public HuiyuanUnitcominfo upateAccountStatusFN(HuiyuanUnitcominfo inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUnitcominfoService.upateAccountStatusFN(inData, requestMeta);
  }

}
