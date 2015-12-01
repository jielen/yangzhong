package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitblack;
import com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate;
import com.ufgov.zc.server.zc.service.IHuiyuanUnitblackService;

public class HuiyuanUnitblackDelegate  implements IHuiyuanUnitblackDelegate {

  private IHuiyuanUnitblackService huiyuanUnitblackService;
  
  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.getMainDataLst(elementConditionDto, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#selectByPrimaryKey(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public IHuiyuanUnitblackService getHuiyuanUnitblackService() {
    return huiyuanUnitblackService;
  }

  public void setHuiyuanUnitblackService(IHuiyuanUnitblackService huiyuanUnitblackService) {
    this.huiyuanUnitblackService = huiyuanUnitblackService;
  }

  public HuiyuanUnitblack selectByPrimaryKey(String guid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.selectByPrimaryKey(guid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#saveFN(com.ufgov.zc.common.zc.model.HuiyuanUnitblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitblack saveFN(HuiyuanUnitblack record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.saveFN(record, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    huiyuanUnitblackService.deleteByPrimaryKeyFN(guid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitblack unAuditFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.unAuditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanUnitblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitblack untreadFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.untreadFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#auditFN(com.ufgov.zc.common.zc.model.HuiyuanUnitblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitblack auditFN(HuiyuanUnitblack unit, RequestMeta requestMeta) throws Exception {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.auditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanUnitblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitblack newCommitFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.newCommitFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanUnitblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanUnitblack callbackFN(HuiyuanUnitblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanUnitblackService.callbackFN(unit, requestMeta);
  }
  

}
