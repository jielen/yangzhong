package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;
import com.ufgov.zc.common.zc.publish.IZcEbChangdiServiceDelegate;
import com.ufgov.zc.server.zc.service.IZcEbChangdiService;

public class ZcEbChangdiServiceDelegate implements IZcEbChangdiServiceDelegate {

  private IZcEbChangdiService zcEbChangdiService;
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbChangdiService.getMainDataLst(elementConditionDto, requestMeta);
  }

  
  public ZcEbChangdi selectByPrimaryKey(String code, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbChangdiService.selectByPrimaryKey(code, requestMeta);
  }

  
  public ZcEbChangdi saveFN(ZcEbChangdi record, RequestMeta requestMeta) throws BusinessException {
    // TCJLODO Auto-generated method stub
    return zcEbChangdiService.saveFN(record, requestMeta);
  }

  
  public void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException {
    // TCJLODO Auto-generated method stub
    zcEbChangdiService.deleteByPrimaryKeyFN(code, requestMeta);
  }


  public IZcEbChangdiService getZcEbChangdiService() {
    return zcEbChangdiService;
  }


  public void setZcEbChangdiService(IZcEbChangdiService zcEbChangdiService) {
    this.zcEbChangdiService = zcEbChangdiService;
  }

}
