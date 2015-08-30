/**   * @(#) project: Gk* @(#) file: IZcEbFormulaTemplateServiceDelegate.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.common.zc.publish;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.Publishable;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcEbFormulaTemplate;import com.ufgov.zc.common.zc.model.ZcEbFormulaTemplateItem;/*** @ClassName: IZcEbFormulaTemplateServiceDelegate* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2010-7-4 下午04:14:55* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public interface IZcEbFormulaTemplateServiceDelegate extends Publishable {  public List getZcEbFormulaTemplateList(ElementConditionDto dto, RequestMeta meta);  public ZcEbFormulaTemplate getZcEbFormulaTemplate(String templateCode, RequestMeta meta);  public List getZcEbFormulaTemplateItemList(Map map, ElementConditionDto dto, RequestMeta meta);  public List getZcEbFormulaTemplateItemByPcode(String templateCode, String pcode, RequestMeta meta);  public List getTemplateParamList(String templateCode, RequestMeta meta);  public ZcEbFormulaTemplateItem getZcEbFormulaTemplateItem(String itemCode, RequestMeta meta);  public void deleteListForZcEbFormulaTemplate(List zcEbFormulaTemplateList, RequestMeta meta);  public void deleteForZcEbFormulaTemplate(String templateCode, RequestMeta meta);  public void deleteForZcEbFormulaTemplateItem(String itemCode, RequestMeta meta);  public void deleteZcEbFormulaTemplateItemBytemplateCode(String templateCode, RequestMeta meta);  public ZcEbFormulaTemplate insertZcEbFormulaTemplate(ZcEbFormulaTemplate zcEbFormulaTemplate,  RequestMeta meta);  public ZcEbFormulaTemplateItem insertZcEbFormulaTemplateItem(  ZcEbFormulaTemplateItem zcEbFormulaTemplateItem, RequestMeta meta);  public ZcEbFormulaTemplate updateZcEbFormulaTemplate(ZcEbFormulaTemplate zcEbFormulaTemplate,  RequestMeta meta);  public ZcEbFormulaTemplateItem updateZcEbFormulaTemplateItem(  ZcEbFormulaTemplateItem zcEbFormulaTemplateItem, RequestMeta meta);  int isExistsByItemName(String formulaCode, String itemName, String itemCode, RequestMeta meta);  public void saveZcEbFormulaTemplateParam(List Params, String templateCode, RequestMeta meta);}