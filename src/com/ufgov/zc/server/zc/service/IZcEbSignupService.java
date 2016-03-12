package com.ufgov.zc.server.zc.service;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.common.zc.model.ZcEbSignup;import com.ufgov.zc.common.zc.model.ZcEbSignupPackDetail;public interface IZcEbSignupService {  ZcEbSignup getZcEbSignupByInfo(ElementConditionDto dto);  ZcEbSignup getZcEbSignupForU(ElementConditionDto dto);  List getZcEbSignup(ElementConditionDto dto, RequestMeta meta);  List getZcEbSignupList(ElementConditionDto dto, RequestMeta meta);  ZcEbSignup getZcEbSignupByID(String signupId);  List getZcEbSignupPackDetail(ElementConditionDto dto, RequestMeta meta);  void updateZcEbSignup(ZcEbSignup signup, RequestMeta requestMeta);  void updateZcEbSignupProperty(ZcEbSignup signup);  void updateZcEbSignupIfImport(ZcEbSignup zcEbSignup, String packId);  void updateZcEbSignupPackProperty(ZcEbSignupPackDetail signupDetail);  ZcEbSignup insertZcEbSignup(ZcEbSignup signup, RequestMeta requestMeta);  ZcEbSignup save(ZcEbSignup signup, RequestMeta requestMeta);  boolean delete(ZcEbSignup signup, RequestMeta requestMeta);  ZcEbSignup getZcEbSignupByIDProvider(ZcEbSignup curObj, RequestMeta requestMeta);  List getZcEbBid(ElementConditionDto elementConditionDto, RequestMeta meta);  Map updateRelationDataForTBFileUpload(Map parasMap);  List getSignupProjListForToubiao(Map parameterMap);  List getEcbjProjListForQuotation(Map parameterMap);  // 获取项目标段  List getProjPack(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  // 获取项目  ZcEbProj getProj(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  Map getSignupProjList(String userID);  public ZcEbSignup updateStatusFN(ZcEbSignup signup, RequestMeta requestMeta);  public List getZcEbSignupSubmit(ElementConditionDto dto, RequestMeta meta);  public void unBidZcEbSignupFN(ZcEbSignup signup, RequestMeta requestMeta);  List getRealMessageSignupList(ElementConditionDto dto, RequestMeta meta);  List getZcEbSignupListWithNums(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  /**   * 获取供应商报名情况,只显示多3家，少于3家，   * @param elementConditionDto   * @param requestMeta   * @return   */  public List getZcEbSignupListWithInfo(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  List querySignupExportsDatas(ElementConditionDto dto, RequestMeta meta);  String importSignupDataFN(ZcEbSignup bill, RequestMeta meta);  public PrintObject getSignupSuppliersPrintObject(ZcEbSignup bill, RequestMeta meta);}