package com.ufgov.zc.common.zc.publish;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanPeopleblack;

public interface IHuiyuanPeopleblackDelegate {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanPeopleblack selectByPrimaryKey(String guid, RequestMeta requestMeta);

  HuiyuanPeopleblack saveFN(HuiyuanPeopleblack record, RequestMeta requestMeta); 

  void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta);

  HuiyuanPeopleblack unAuditFN(HuiyuanPeopleblack record, RequestMeta requestMeta);

  HuiyuanPeopleblack untreadFN(HuiyuanPeopleblack record, RequestMeta requestMeta);

  HuiyuanPeopleblack auditFN(HuiyuanPeopleblack record, RequestMeta requestMeta) throws Exception;

  HuiyuanPeopleblack newCommitFN(HuiyuanPeopleblack record, RequestMeta requestMeta);

  HuiyuanPeopleblack callbackFN(HuiyuanPeopleblack record, RequestMeta requestMeta);
}
