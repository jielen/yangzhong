/**
 * 
 */
package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;
import com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate;
import com.ufgov.zc.server.zc.service.IHuiyuanZfcgGongyinginfoService;

/**
 * @author Administrator
 *
 */
public class HuiyuanZfcgGongyinginfoDelegate implements IHuiyuanZfcgGongyinginfoDelegate {

  private IHuiyuanZfcgGongyinginfoService huiyuanZfcginfoService;
  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#getMainDataLst(com.ufgov.zc.common.system.dto.ElementConditionDto, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.getMainDataLst(elementConditionDto, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#selectByPrimaryKey(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo selectByPrimaryKey(String id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.selectByPrimaryKey(id, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#saveFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo saveFN(HuiyuanZfcgGongyinginfo inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.saveFN(inData, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#deleteByPrimaryKeyFN(java.lang.String, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public void deleteByPrimaryKeyFN(String id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    huiyuanZfcginfoService.deleteByPrimaryKeyFN(id, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#unAuditFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo unAuditFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.unAuditFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#untreadFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo untreadFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.untreadFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#auditFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo auditFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.auditFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#newCommitFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo newCommitFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.newCommitFN(qx, requestMeta);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.common.zc.publish.IHuiyuanZfcgGongyinginfoDelegate#callbackFN(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo, com.ufgov.zc.common.system.RequestMeta)
   */
  
  public HuiyuanZfcgGongyinginfo callbackFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return huiyuanZfcginfoService.callbackFN(qx, requestMeta);
  }

  public IHuiyuanZfcgGongyinginfoService getHuiyuanZfcginfoService() {
    return huiyuanZfcginfoService;
  }

  public void setHuiyuanZfcginfoService(IHuiyuanZfcgGongyinginfoService huiyuanZfcginfoService) {
    this.huiyuanZfcginfoService = huiyuanZfcginfoService;
  }

}
