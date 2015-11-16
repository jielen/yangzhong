package com.ufgov.zc.common.zc.publish;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitblack;

public interface IHuiyuanUnitblackDelegate {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanUnitblack selectByPrimaryKey(String guid, RequestMeta requestMeta);

  HuiyuanUnitblack saveFN(HuiyuanUnitblack record, RequestMeta requestMeta); 

  void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta);

  HuiyuanUnitblack unAuditFN(HuiyuanUnitblack record, RequestMeta requestMeta);

  HuiyuanUnitblack untreadFN(HuiyuanUnitblack record, RequestMeta requestMeta);

  HuiyuanUnitblack auditFN(HuiyuanUnitblack record, RequestMeta requestMeta) throws Exception;

  HuiyuanUnitblack newCommitFN(HuiyuanUnitblack record, RequestMeta requestMeta);

  HuiyuanUnitblack callbackFN(HuiyuanUnitblack record, RequestMeta requestMeta);
}
