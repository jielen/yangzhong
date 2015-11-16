/**
 * 
 */
package com.ufgov.zc.common.zc.publish;

import java.util.List;

import com.ufgov.zc.common.system.Publishable;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUser;

/**
 * @author Administrator
 *
 */
public interface IHuiyuanUserDelegate extends Publishable {


  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanUser selectByPrimaryKey(String danweiguid, RequestMeta requestMeta);

  HuiyuanUser saveFN(HuiyuanUser record, RequestMeta requestMeta);

  HuiyuanUser updateAuditStatusFN(HuiyuanUser record, RequestMeta requestMeta);

  void deleteByPrimaryKeyFN(String danweiguid, RequestMeta requestMeta);

  HuiyuanUser unAuditFN(HuiyuanUser unit, RequestMeta requestMeta);

  HuiyuanUser untreadFN(HuiyuanUser unit, RequestMeta requestMeta);

  HuiyuanUser auditFN(HuiyuanUser unit, RequestMeta requestMeta) throws Exception;

  HuiyuanUser newCommitFN(HuiyuanUser unit, RequestMeta requestMeta);

  HuiyuanUser callbackFN(HuiyuanUser unit, RequestMeta requestMeta);
}
