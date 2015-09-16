/**
 * 
 */
package com.ufgov.zc.common.zc.publish;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.system.Publishable;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcEbZxjj;

/**
 * @author Administrator
 *
 */
public interface IZcEbZxjjServiceDelegate extends Publishable {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  ZcEbZxjj selectByPrimaryKey(BigDecimal id, RequestMeta requestMeta);

  ZcEbZxjj saveFN(ZcEbZxjj inData, RequestMeta requestMeta);

  void deleteByPrimaryKeyFN(BigDecimal id, RequestMeta requestMeta);

  ZcEbZxjj unAuditFN(ZcEbZxjj qx, RequestMeta requestMeta);

  ZcEbZxjj untreadFN(ZcEbZxjj qx, RequestMeta requestMeta);

  ZcEbZxjj auditFN(ZcEbZxjj qx, RequestMeta requestMeta) throws Exception;

  ZcEbZxjj newCommitFN(ZcEbZxjj qx, RequestMeta requestMeta);

  ZcEbZxjj callbackFN(ZcEbZxjj qx, RequestMeta requestMeta);


}
