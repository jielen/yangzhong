package com.ufgov.zc.server.zc.service;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;

public interface IZcEbChangdiService {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  ZcEbChangdi selectByPrimaryKey(String code, RequestMeta requestMeta);

  ZcEbChangdi saveFN(ZcEbChangdi record, RequestMeta requestMeta) throws BusinessException;

  void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException;
}
