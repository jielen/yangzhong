/**
 * 
 */
package com.ufgov.zc.common.zc.publish;

import java.util.List;

import com.ufgov.zc.common.system.Publishable;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;

/**
 * @author Administrator
 *
 */
public interface IHuiyuanZfcgGongyinginfoDelegate extends Publishable {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo selectByPrimaryKey(String id, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo saveFN(HuiyuanZfcgGongyinginfo inData, RequestMeta requestMeta);

  void deleteByPrimaryKeyFN(String id, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo unAuditFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo untreadFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo auditFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta) throws Exception;

  HuiyuanZfcgGongyinginfo newCommitFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta);

  HuiyuanZfcgGongyinginfo callbackFN(HuiyuanZfcgGongyinginfo qx, RequestMeta requestMeta);

}
