package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanPeopleblack;
import com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate;
import com.ufgov.zc.server.zc.service.IHuiyuanPeopleblackService;

public class HuiyuanPeopleblackDelegate implements IHuiyuanPeopleblackDelegate {

  private IHuiyuanPeopleblackService huiyuanPeopleblackService;
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.getMainDataLst(elementConditionDto, requestMeta);
  }


  public HuiyuanPeopleblack selectByPrimaryKey(String guid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.selectByPrimaryKey(guid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate#saveFN(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanPeopleblack saveFN(HuiyuanPeopleblack record, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.saveFN(record, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    huiyuanPeopleblackService.deleteByPrimaryKeyFN(guid, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanPeopleblack unAuditFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.unAuditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanPeopleblack untreadFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.untreadFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate#auditFN(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanPeopleblack auditFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) throws Exception {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.auditFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanPeopleblack newCommitFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.newCommitFN(unit, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanPeopleblack callbackFN(HuiyuanPeopleblack unit, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return huiyuanPeopleblackService.callbackFN(unit, requestMeta);
  }
  


  public IHuiyuanPeopleblackService getHuiyuanPeopleblackService() {
    return huiyuanPeopleblackService;
  }


  public void setHuiyuanPeopleblackService(IHuiyuanPeopleblackService huiyuanPeopleblackService) {
    this.huiyuanPeopleblackService = huiyuanPeopleblackService;
  }

}
