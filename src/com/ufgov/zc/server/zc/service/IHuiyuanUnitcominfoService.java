/**
 * 
 */
package com.ufgov.zc.server.zc.service;

import java.util.List;

import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.exception.BusinessException;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;

/**
 * @author Administrator
 *
 */
public interface IHuiyuanUnitcominfoService {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanUnitcominfo selectByPrimaryKey(String danweiguid, RequestMeta requestMeta);

  HuiyuanUnitcominfo saveFN(HuiyuanUnitcominfo record, RequestMeta requestMeta) throws BusinessException; 

  void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta);

  HuiyuanUnitcominfo unAuditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);

  HuiyuanUnitcominfo untreadFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);

  HuiyuanUnitcominfo auditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) throws Exception;

  HuiyuanUnitcominfo newCommitFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);

  HuiyuanUnitcominfo callbackFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);
  
  HuiyuanUnitcominfo updateAuditStatusFN(HuiyuanUnitcominfo record, RequestMeta requestMeta);

  HuiyuanUnitcominfo upateAccountStatusFN(HuiyuanUnitcominfo inData, RequestMeta requestMeta);
}
