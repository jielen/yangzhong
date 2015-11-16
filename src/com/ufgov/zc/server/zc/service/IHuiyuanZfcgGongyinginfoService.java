/**
 * 
 */
package com.ufgov.zc.server.zc.service;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;

/**
 * @author Administrator
 *
 */
public interface IHuiyuanZfcgGongyinginfoService {


  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo selectByPrimaryKey(String id, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo saveFN(HuiyuanZfcgGongyinginfo inData, RequestMeta requestMeta);

  void updateAuditStatusFN(HuiyuanZfcgGongyinginfo inData, RequestMeta requestMeta);

  void deleteByPrimaryKeyFN(String id, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo unAuditFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo untreadFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo auditFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta) throws Exception;

  HuiyuanZfcgGongyinginfo newCommitFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo callbackFN(HuiyuanZfcgGongyinginfo gys, RequestMeta requestMeta);

}
