/**   * @(#) project: zcxa* @(#) file: IZcSuppleMentPProMakeServiceDelegate.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.common.zc.publish;import java.math.BigDecimal;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.Publishable;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcSupplementPProMake;/*** @ClassName: IZcSuppleMentPProMakeServiceDelegate* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2010-7-29 下午01:59:38* @version: V1.0 * @since: 1.0* @author: Administrator* @modify: */public interface IZcSuppleMentPProMakeServiceDelegate extends Publishable {  /**   *   * @Description: 在追加资金流程表里面添加一条记录，开始走工作流。  * @return ZcSupplementPProMake 返回类型  * @since 1.0   */  public ZcSupplementPProMake updateZcSupplementPProMakeFN(ZcSupplementPProMake zcSupplementPProMake, RequestMeta requestMeta) throws Exception;  public void deleteZcSupplementPProMakeFN(ZcSupplementPProMake zcSupplementPProMake, RequestMeta requestMeta) throws Exception;  public ZcSupplementPProMake getZcSupplementPProMake(String zcSuppleMentCode, RequestMeta requestMeta) throws Exception;  public List getZcSupplementPProMakeList(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  public ZcSupplementPProMake addMoneyFN(ZcSupplementPProMake zcSupplementPProMake, RequestMeta requestMeta) throws Exception;  /*   * 资金追加工作流   */  public ZcSupplementPProMake newCommitFN(ZcSupplementPProMake currentObject, RequestMeta requestMeta) throws Exception;  public ZcSupplementPProMake untreadFN(ZcSupplementPProMake make, RequestMeta requestMeta);  public ZcSupplementPProMake unAuditFN(ZcSupplementPProMake make, RequestMeta requestMeta);  public ZcSupplementPProMake auditFN(ZcSupplementPProMake make, RequestMeta requestMeta);  public ZcSupplementPProMake callbackFN(ZcSupplementPProMake make, RequestMeta requestMeta);  public BigDecimal getSumSuppleMentAmountSum(Map map, RequestMeta requestMeta);}