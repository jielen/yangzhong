package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate;
import com.ufgov.zc.server.zc.service.IHuiyuanUserService;

public class HuiyuanUserDelegate implements IHuiyuanUserDelegate {

  private IHuiyuanUserService huiyuanUserService;
  
  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.getMainDataLst(elementConditionDto, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#selectByPrimaryKey(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUser selectByPrimaryKey(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.selectByPrimaryKey(danweiguid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#saveFN(com.ufgov.zc.common.zc.model.HuiyuanUser, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUser saveFN(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.saveFN(record, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanUserService.deleteByPrimaryKeyFN(danweiguid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanUser, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUser unAuditFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.unAuditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanUser, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUser untreadFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.untreadFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#auditFN(com.ufgov.zc.common.zc.model.HuiyuanUser, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUser auditFN(HuiyuanUser unit, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return huiyuanUserService.auditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanUser, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUser newCommitFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.newCommitFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanUser, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUser callbackFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.callbackFN(unit, requestMeta);
  }

  public HuiyuanUser updateAuditStatusFN(HuiyuanUser record, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.updateAuditStatusFN(record, requestMeta);
  }

  public IHuiyuanUserService getHuiyuanUserService() {
    return huiyuanUserService;
  }


  public void setHuiyuanUserService(IHuiyuanUserService huiyuanUserService) {
    this.huiyuanUserService = huiyuanUserService;
  }
 
  public HuiyuanUser upateAccountStatusFN(HuiyuanUser unit, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanUserService.upateAccountStatusFN(unit, requestMeta) ;
  }

}
