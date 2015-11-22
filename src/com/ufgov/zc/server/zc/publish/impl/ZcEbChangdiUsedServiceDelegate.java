package com.ufgov.zc.server.zc.publish.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;
import com.ufgov.zc.common.zc.publish.IZcEbChangdiUsedServiceDelegate;
import com.ufgov.zc.server.zc.service.IZcEbChangdiUsedService;

public class ZcEbChangdiUsedServiceDelegate implements IZcEbChangdiUsedServiceDelegate {

  private IZcEbChangdiUsedService zcEbChangdiUsedService;
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return zcEbChangdiUsedService.getMainDataLst(elementConditionDto, requestMeta);
  }

  
  public ZcEbChangdiUsed selectByPrimaryKey(String code, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return zcEbChangdiUsedService.selectByPrimaryKey(code, requestMeta);
  }

  
  public ZcEbChangdiUsed saveFN(ZcEbChangdiUsed record, RequestMeta requestMeta) throws BusinessException {
    // TODO Auto-generated method stub
    return zcEbChangdiUsedService.saveFN(record, requestMeta);
  }

  
  public void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException {
    // TODO Auto-generated method stub
    zcEbChangdiUsedService.deleteByPrimaryKeyFN(code, requestMeta);
  }


  public IZcEbChangdiUsedService getZcEbChangdiUsedService() {
    return zcEbChangdiUsedService;
  }


  public void setZcEbChangdiUsedService(IZcEbChangdiUsedService zcEbChangdiUsedService) {
    this.zcEbChangdiUsedService = zcEbChangdiUsedService;
  }

}
