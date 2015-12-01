package com.ufgov.zc.server.zc.service.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;
import com.ufgov.zc.server.zc.dao.ZcEbChangdiUsedMapper;
import com.ufgov.zc.server.zc.service.IZcEbChangdiUsedService;

public class ZcEbChangdiUsedService implements IZcEbChangdiUsedService {

  private ZcEbChangdiUsedMapper zcEbChangdiUsedMapper;
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    return zcEbChangdiUsedMapper.getMainDataLst(elementConditionDto);
  }

  
  public ZcEbChangdiUsed selectByPrimaryKey(String code, RequestMeta requestMeta) {
    // TCJLODO Auto-generated method stub
    ZcEbChangdiUsed rtn= zcEbChangdiUsedMapper.selectByPrimaryKey(code);
    rtn.setDbDigest(rtn.digest());
    return rtn;
  }

  
  public ZcEbChangdiUsed saveFN(ZcEbChangdiUsed record, RequestMeta requestMeta) throws BusinessException {
    // TCJLODO Auto-generated method stub
    if(record.getChangdiusedid()==null || record.getChangdiusedid().trim().length()==0){
      record.setChangdiusedid(UUID.randomUUID().toString());
      zcEbChangdiUsedMapper.insert(record);
    }else{
      zcEbChangdiUsedMapper.updateByPrimaryKey(record);
    }
    return selectByPrimaryKey(record.getChangdiusedid(), requestMeta);
  }

  
  public void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException {
    // TCJLODO Auto-generated method stub
    zcEbChangdiUsedMapper.deleteByPrimaryKey(code);
  }


  public ZcEbChangdiUsedMapper getZcEbChangdiUsedMapper() {
    return zcEbChangdiUsedMapper;
  }


  public void setZcEbChangdiUsedMapper(ZcEbChangdiUsedMapper zcEbChangdiUsedMapper) {
    this.zcEbChangdiUsedMapper = zcEbChangdiUsedMapper;
  }

}
