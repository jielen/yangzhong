/**   * @(#) project: GK* @(#) file: ZcEbEvalDao.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.server.zc.dao;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.exception.BaseException;import com.ufgov.zc.common.zc.model.ZcEbCalWay;import com.ufgov.zc.common.zc.model.ZcEbEvalBidTeamMember;import com.ufgov.zc.common.zc.model.ZcEbEvalItemResult;import com.ufgov.zc.common.zc.model.ZcEbEvalPack;import com.ufgov.zc.common.zc.model.ZcEbEvalReport;import com.ufgov.zc.common.zc.model.ZcEbFormula;import com.ufgov.zc.common.zc.model.ZcEbPackEvalResult;import java.util.List;import java.util.Map;/*** @ClassName: ZcEbEvalDao* @Description: 评标模块取数接口。* @date: 2010-4-21 下午03:39:42* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public interface IZcEbEvalDao {  /**   *   * @Description: 取评标报告对象列表。  * @return List 评标报告列表，如果存在符合条件的对象；否则返回空。  * @since 1.0   */  List getZcEbEvalReportList(ElementConditionDto dto);  /**   *   * @Description: 取评标标段对象列表。  * @return List 评标标段对象列表，如果存在符合条件的对象；否则返回空。  * @since 1.0   */  public List getZcEbEvalPackList(ElementConditionDto dto);  /**   *   * @Description: 取评标指标项结果对象列表。  * @return List 评标指标项结果对象列表，如果存在符合条件的对象；否则返回空。  * @since 1.0   */  public List getZcEbEvalItemResultList(Map map);  /**   *   * @Description: 取评标指标项对象列表。  * @return List 评标指标项对象列表，如果存在符合条件的对象；否则返回空。  * @since 1.0   */  public List getZcEbEvalFormulaItemList(Map map);  /**   *   * @Description: 根据项代码、指标集代码、评审专家代码、供应商代码等取专家评审指标项结果对象。  * @return ZcEbEvalItemResult 返回类型  * @since 1.0   */  public ZcEbEvalItemResult getZcEbEvalItemResult(Map map);  /**   *   * @Description: 根据项目代码、标段代码取对应供应商列表。  * @return List 符合条件的 EvalPackProvider 对象列表。  * @since 1.0   */  List getListEvalPackProvider(Map map);  /**   *   * @Description:取评标参数列表。  * @return List ZcEbEvalParam对象列表。  * @since 1.0   */  List getEvalParamResultList(Map map);  /**   *   * @Description:取评标参数列表。  * @return List ZcEbEvalParam对象列表。  * @since 1.0   */  List getEvalParamList(Map map);  /**   *   * @Description: 插入评标参数结果对象列表。  * @return void 返回类型  * @since 1.0   */  void insertEvalParamResultList(List list);  /**   *   * @Description: 更新评标参数结果对象列表。  * @return void 返回类型  * @since 1.0   */  void updateEvalParamResultList(List list);  /**   *   * @Description: 读取专家评审结果明细。  * @return List 专家评审得出的指标明细项结果列表。  * @since 1.0   */  List getZcEbExpertEvalResultList(ElementConditionDto dto);  /**   *   * @Description: 获得评标结果  * @return List 返回类型  * @since 1.0   */  List getZcEbPackEvalList(ElementConditionDto dto);  public void insertZcEbEvalReport(ZcEbEvalReport zcEbEvalReport);  public void updateZcEbEvalReport(ZcEbEvalReport zcEbEvaReport);  public ZcEbEvalReport getZcEbEvalReport(String reportCode);  public int deleteZcEbEvalReport(ZcEbEvalReport zcEbEvaReport);  String genExpertSumResult(Map map);  List getExpertEvalPackResList(Map map);  /**   *   * @Description: 汇总专家评审结果为最终结果。  * @since 1.0   */  void insertParckFinalSumResult(ZcEbPackEvalResult result);  /**   *   * @Description: 根据计算方式取得对应的计算处理实现类。  * @return ZcEbCalWay 计算实现方式对象。  * @since 1.0   */  ZcEbCalWay getCalculatorWay(String calWayID);  /**   *   * @Description: 根据项目代码、标段代码及供应商代码删除对应标段汇总结果。  * @since 1.0   */  int deleteZcEbPackSumRes(Map map);  /**   *   * @Description: 根据指标集代码取得对应的符合性指标评审通过比例。  * @return String 符合性指标评审通过比例。  * @since 1.0   */  ZcEbFormula getZcEbFormula(String formulaCode);  /**   *   * @Description: 更新供应商标段评审汇总结果。  * @return void 返回类型  * @since 1.0   */  void updateZcEbPackEvalFinalSumResult(List list);  void deleteZcEbPackEvalFinalSumResult(Map map);  boolean isExisParentResult(Map map);  List getZcEbEvalResult(Map map);  /**  * @Description: TODO(这里用一句话描述这个方法的作用)  * @return List 返回类型  * @since 1.0  */  List getZcEbPackList(ElementConditionDto dto);  /**  * @Description: TODO(这里用一句话描述这个方法的作用)  * @return List 返回类型  * @since 1.0  */  List getZcEbEvalPackSumResult(Map map);  List getZcEbEvalFormulaItemReportList(Map map);  //获得评标组成员。  ZcEbEvalBidTeamMember getZcEbEvalMemer(ZcEbEvalPack evalPack);  //保存评审指标项  void insertEvalItemResultList(List list);  void updatePackEvalResult(ZcEbEvalReport report) throws BaseException;}