/**
 * 
 */
package com.ufgov.zc.common.zc.publish;

import java.util.List;

import com.ufgov.zc.common.system.Publishable;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;

/**
 * @author Administrator
 *
 */
public interface IHuiyuanUnitcominfoDelegate extends Publishable {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanUnitcominfo selectByPrimaryKey(String danweiguid, RequestMeta requestMeta);

  HuiyuanUnitcominfo saveFN(HuiyuanUnitcominfo record, RequestMeta requestMeta);

  HuiyuanUnitcominfo updateAuditStatusFN(HuiyuanUnitcominfo record, RequestMeta requestMeta);

  void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta);

  HuiyuanUnitcominfo unAuditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);

  HuiyuanUnitcominfo untreadFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);

  HuiyuanUnitcominfo auditFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta) throws Exception;

  HuiyuanUnitcominfo newCommitFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);

  HuiyuanUnitcominfo callbackFN(HuiyuanUnitcominfo unit, RequestMeta requestMeta);

}
