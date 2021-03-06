package com.ufgov.zc.common.zc.publish;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;

public interface IZcEbChangdiUsedServiceDelegate {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  ZcEbChangdiUsed selectByPrimaryKey(String code, RequestMeta requestMeta);

  ZcEbChangdiUsed saveFN(ZcEbChangdiUsed record, RequestMeta requestMeta) throws BusinessException;

  void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException;

}
