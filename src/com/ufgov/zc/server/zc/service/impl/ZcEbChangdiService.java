package com.ufgov.zc.server.zc.service.impl;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.system.util.UUID;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;
import com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper;
import com.ufgov.zc.server.zc.service.IZcEbChangdiService;

public class ZcEbChangdiService implements IZcEbChangdiService {

  private ZcEbChangdiMapper zcEbChangdiMapper;
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return zcEbChangdiMapper.getMainDataLst(elementConditionDto);
  }

  
  public ZcEbChangdi selectByPrimaryKey(String code, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    ZcEbChangdi rtn= zcEbChangdiMapper.selectByPrimaryKey(code);
    rtn.setDbDigest(rtn.digest());
    return rtn;
  }

  
  public ZcEbChangdi saveFN(ZcEbChangdi record, RequestMeta requestMeta) throws BusinessException {
    // TODO Auto-generated method stub
    if(record.getChangdiguid()==null || record.getChangdiguid().trim().length()==0){
      record.setChangdiguid(UUID.randomUUID().toString());
      zcEbChangdiMapper.insert(record);
    }else{
      zcEbChangdiMapper.updateByPrimaryKey(record);
    }
    
    return selectByPrimaryKey(record.getChangdiguid(), requestMeta);
  }

  
  public void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException {
    // TODO Auto-generated method stub
    //判断是否已经使用，如果已经使用，则不让删除，抛出异常
    
    if(isUsed(code)){
      throw new BusinessException("该场地数据已被使用，不能删除,如果不再使用，可以停用它。");
    }
    
    zcEbChangdiMapper.deleteByPrimaryKey(code);
  }


  private boolean isUsed(String code) {
    // TODO Auto-generated method stub
    return false;
  }


  public ZcEbChangdiMapper getZcEbChangdiMapper() {
    return zcEbChangdiMapper;
  }


  public void setZcEbChangdiMapper(ZcEbChangdiMapper zcEbChangdiMapper) {
    this.zcEbChangdiMapper = zcEbChangdiMapper;
  }

}
