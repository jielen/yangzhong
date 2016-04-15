package com.ufgov.zc.server.zc.service;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcMobileMsg;

public interface IZcMobileMsgService {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  ZcMobileMsg updateFN(ZcMobileMsg qx, RequestMeta requestMeta) throws Exception;

  void deleteFN(ZcMobileMsg qx, RequestMeta requestMeta);

  ZcMobileMsg selectByPrimaryKey(String qxCode, RequestMeta requestMeta);

  ZcMobileMsg callbackFN(ZcMobileMsg qx, RequestMeta requestMeta);

}
