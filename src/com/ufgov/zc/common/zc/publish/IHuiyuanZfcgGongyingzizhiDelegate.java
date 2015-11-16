package com.ufgov.zc.common.zc.publish;

import java.util.List;

import com.ufgov.zc.common.system.Publishable;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi;

public interface IHuiyuanZfcgGongyingzizhiDelegate  extends Publishable {


  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi selectByPrimaryKey(String guid, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi saveFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi updateAuditStatusFN(HuiyuanZfcgGongyingzizhi record, RequestMeta requestMeta);

  void deleteByPrimaryKeyFN(String guid, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi unAuditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi untreadFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi auditFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta) throws Exception;

  HuiyuanZfcgGongyingzizhi newCommitFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);

  HuiyuanZfcgGongyingzizhi callbackFN(HuiyuanZfcgGongyingzizhi unit, RequestMeta requestMeta);
}
