package com.ufgov.zc.server.zc.service;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUser;

public interface IHuiyuanUserService {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanUser selectByPrimaryKey(String danweiguid, RequestMeta requestMeta);

  HuiyuanUser saveFN(HuiyuanUser record, RequestMeta requestMeta); 

  void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta);

  HuiyuanUser unAuditFN(HuiyuanUser unit, RequestMeta requestMeta);

  HuiyuanUser untreadFN(HuiyuanUser unit, RequestMeta requestMeta);

  HuiyuanUser auditFN(HuiyuanUser unit, RequestMeta requestMeta) throws Exception;

  HuiyuanUser newCommitFN(HuiyuanUser unit, RequestMeta requestMeta);

  HuiyuanUser callbackFN(HuiyuanUser unit, RequestMeta requestMeta);
  
  HuiyuanUser updateAuditStatusFN(HuiyuanUser record, RequestMeta requestMeta);
}
