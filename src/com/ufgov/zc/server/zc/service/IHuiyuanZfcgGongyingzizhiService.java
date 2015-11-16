package com.ufgov.zc.server.zc.service;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi;

public interface IHuiyuanZfcgGongyingzizhiService {


  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi selectByPrimaryKey(String guid, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi saveFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta); 

  void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi unAuditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi untreadFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi auditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) throws Exception;

  HuiyuanZfcgGongyingzizhi newCommitFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi callbackFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);
  
  HuiyuanZfcgGongyingzizhi updateAuditStatusFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta);
}
