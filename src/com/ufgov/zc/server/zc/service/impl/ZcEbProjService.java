package com.ufgov.zc.server.zc.service.impl;import java.math.BigDecimal;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Calendar;import java.util.Date;import java.util.HashMap;import java.util.HashSet;import java.util.Iterator;import java.util.List;import java.util.Map;import java.util.Set;import com.kingdrive.workflow.context.WorkflowContext;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.NumLimConstants;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.common.system.model.AsWfDraft;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcBAgency;import com.ufgov.zc.common.zc.model.ZcEbFormula;import com.ufgov.zc.common.zc.model.ZcEbFormulaPack;import com.ufgov.zc.common.zc.model.ZcEbPack;import com.ufgov.zc.common.zc.model.ZcEbPackQua;import com.ufgov.zc.common.zc.model.ZcEbPackReq;import com.ufgov.zc.common.zc.model.ZcEbPackSupplier;import com.ufgov.zc.common.zc.model.ZcEbPlan;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;import com.ufgov.zc.common.zc.model.ZcEbXunJia;import com.ufgov.zc.server.system.dao.IWorkflowDao;import com.ufgov.zc.server.system.dao.ibatis.AsValDao;import com.ufgov.zc.server.system.util.AsOptionUtil;import com.ufgov.zc.server.system.util.AsValDataUtil;import com.ufgov.zc.server.system.util.NumLimUtil;import com.ufgov.zc.server.system.util.NumUtil;import com.ufgov.zc.server.system.workflow.WFEngineAdapter;import com.ufgov.zc.server.zc.ZcSUtil;import com.ufgov.zc.server.zc.dao.IZcEbPlanDao;import com.ufgov.zc.server.zc.dao.IZcEbProjDao;import com.ufgov.zc.server.zc.dao.ibatis.BaseDao;import com.ufgov.zc.server.zc.service.IZcEbFormulaService;import com.ufgov.zc.server.zc.service.IZcEbProjService;import com.ufgov.zc.server.zc.web.ylbTable.ChangeRMB;/** *  * @ClassName: ZcEbProjService * @Description: TODO(这里用一句话描述这个类的作用) * @date: Sep 10, 2012 5:03:13 AM * @version: V1.0 * @since: 1.0 * @author: Administrator * @modify: */public class ZcEbProjService implements IZcEbProjService {  private IZcEbProjDao zcEbProjDao;  private BaseDao baseDao;  private IWorkflowDao workflowDao;  private WFEngineAdapter wfEngineAdapter;  private IZcEbPlanDao zcEbPlanDao;  private AsValDao asValDao;  private IZcEbFormulaService zcEbFormulaService;  public BaseDao getBaseDao() {    return baseDao;  }  public void setBaseDao(BaseDao baseDao) {    this.baseDao = baseDao;  }  public WFEngineAdapter getWfEngineAdapter() {    return wfEngineAdapter;  }  public void setWfEngineAdapter(WFEngineAdapter wfEngineAdapter) {    this.wfEngineAdapter = wfEngineAdapter;  }  public IWorkflowDao getWorkflowDao() {    return workflowDao;  }  public void setWorkflowDao(IWorkflowDao workflowDao) {    this.workflowDao = workflowDao;  }  public IZcEbProjDao getZcEbProjDao() {    return zcEbProjDao;  }  public void setZcEbProjDao(IZcEbProjDao zcEbProjDao) {    this.zcEbProjDao = zcEbProjDao;  }  public List getZcEbProj(ElementConditionDto dto, RequestMeta meta) {    return zcEbProjDao.getZcEbProj(dto, meta);  }  public IZcEbFormulaService getZcEbFormulaService() {    return zcEbFormulaService;  }  public void setZcEbFormulaService(IZcEbFormulaService zcEbFormulaService) {    this.zcEbFormulaService = zcEbFormulaService;  }  public ZcEbProj readByProjCode(String projCode) {    Map m = new HashMap();    m.put("PROJ_CODE", projCode);    ZcEbProj p = (ZcEbProj) baseDao.read("ZcEbProj.readByProjCode", m);    p.setPackList(getZcEbPackListByProjCode(projCode));    p.setPlan(this.getPlan(projCode));    return p;  }  public ZcEbProj getZcEbProjMasterByProjCode(String projCode) {    return this.zcEbProjDao.getOriginZcEbProjByProjId(projCode);  }  public ZcEbPack getZcEbPackByPackCode(String packCode) {    return this.zcEbProjDao.getZcEbPackByPackCode(packCode);  }  public ZcEbPlan getPlan(String projcode) {    List planList = this.zcEbPlanDao.getZcEbPlanByProjCode(projcode);    if (planList != null && planList.size() > 0) {      return (ZcEbPlan) planList.get(0);    } else {      return null;    }  }  public List getZcEbPackListByProjCode(String projCode) {    List packList = zcEbProjDao.getZcEbPackListByProjCode(projCode);    List packReqList = zcEbProjDao.getZcEbPackReqListByProjCode(projCode);    List packSupList = zcEbProjDao.getZcEbPackSupListByProjCode(projCode);    // 组装标段bean,设置每个标段信息对应的需求    Map packMap = new HashMap();    for (int i = 0; i < packList.size(); i++) {      packMap.put(((ZcEbPack) packList.get(i)).getPackCode(), (ZcEbPack) packList.get(i));    }    if (packMap.size() > 0) {      ZcEbPackReq temp;      for (int j = 0; j < packReqList.size(); j++) {        temp = (ZcEbPackReq) packReqList.get(j);        ZcEbPack pack = (ZcEbPack) packMap.get(temp.getPackCode());        if (pack != null) {          pack.getRequirementDetailList().add(temp);        }      }      ZcEbPackSupplier sup;      for (int j = 0; j < packSupList.size(); j++) {        sup = (ZcEbPackSupplier) packSupList.get(j);        ZcEbPack pack = (ZcEbPack) packMap.get(sup.getPackCode());        if (pack != null) {          pack.getSupplierList().add(sup);        }      }    }    // 获取标段对应当询价单    ZcEbPackQua para = new ZcEbPackQua();    para.setProjCode(projCode);    for (int i = 0; i < packList.size(); i++) {      ZcEbPack pack = (ZcEbPack) packList.get(i);//      if (ZcSettingConstants.PITEM_OPIWAY_XJ.equals(pack.getPurType())) {////        ElementConditionDto dto = new ElementConditionDto();////        dto.setZcText0(projCode);////        dto.setZcText1(pack.getPackCode());////        List xunJiaLst = this.zcEbProjDao.getXunJia(dto);////        ((ZcEbPack) packList.get(i)).setXunJiaList(xunJiaLst);////      } else         if (ZcSettingConstants.PITEM_OPIWAY_XJ.equals(pack.getPurType())) {        para.setPackCode(pack.getPackCode());        List qua = baseDao.query("ZcEbRequirement.selectQuaByPack", para);        if (qua != null) {          pack.setPackQua(qua);        } else {          pack.setPackQua(new ArrayList());        }      }    }    // 获取标段对应的资质条件    for (int i = 0; i < packList.size(); i++) {      ZcEbPack pack = (ZcEbPack) packList.get(i);      ElementConditionDto dto = new ElementConditionDto();      dto.setZcText0(projCode);      dto.setZcText1(pack.getPackCode());      List bidConLst = this.zcEbProjDao.getBidConditions(dto);      ((ZcEbPack) packList.get(i)).setBidConditions(bidConLst);    }    return packList;  }  public ZcEbProj saveFN(ZcEbProj proj, RequestMeta requestMeta) {    saveBill(proj, requestMeta);    // 从新计算摘要    proj.setDbDigest(this.getOriginalZcEbProjByProjCode(proj.getProjCode()).digest());    return proj;  }  private void saveBill(ZcEbProj proj, RequestMeta requestMeta) {    if (proj.getProjCode() == null || "".equals(proj.getProjCode()) || proj.getProjCode().equals("自动编号")) {            insertZcEbProj(proj, requestMeta);    } else {      updateZcEbProj(proj);    }  }  private void updateZcEbProj(ZcEbProj proj) {    // 检查摘要    // checkConsistency(proj);    zcEbProjDao.updateZcEbProj(proj);    zcEbProjDao.deleteZcEbPackByProjCode(proj.getProjCode());    // zcEbProjDao.deleteProjFileByProjCode(proj.getProjCode());    insertZcEbPackInfo(proj);        if(!ZcSettingConstants.PITEM_OPIWAY_XJ.equals(proj.getPurType())){        //this.insertZcEbProjFile(proj);        this.updateFormula(proj);    	    }          updatePlan(proj);     }  private String checkConsistency(ZcEbProj proj) {    return ZcSUtil.checkConsistency(proj, getOriginalZcEbProjByProjCode(proj.getProjCode()), "projCode");  }  private void insertZcEbProj(ZcEbProj proj, RequestMeta requestMeta) {    String userId = requestMeta.getSvUserID();    String compoId = requestMeta.getCompoId();    String projCode = NumUtil.getInstance().getNo(compoId, "PROJ_CODE", proj);    Long draftid = workflowDao.createDraftId();    proj.setProjCode(projCode);    proj.setProcessInstId(draftid);    this.zcEbProjDao.insertZcEbProj(proj);    AsWfDraft asWfDraft = new AsWfDraft();    asWfDraft.setCompoId(compoId);    asWfDraft.setWfDraftName(projCode);    asWfDraft.setUserId(userId);    asWfDraft.setMasterTabId(compoId);    asWfDraft.setWfDraftId(BigDecimal.valueOf(draftid.longValue()));    workflowDao.insertAsWfdraft(asWfDraft);    this.insertZcEbPackInfo(proj);        if(!ZcSettingConstants.PITEM_OPIWAY_XJ.equals(proj.getPurType())){        this.insertZcEbProjFile(proj);        this.updateFormula(proj);    	    }    this.updatePlan(proj);  }  // 不需要自动编号的新增项目方式，不用产生草稿  public void insertZcEbProjHasProjCode(ZcEbProj proj) {    this.zcEbProjDao.insertZcEbProj(proj);    this.insertZcEbPackInfo(proj);    this.insertZcEbProjFile(proj);    updatePlan(proj);  }  private void insertZcEbProjFile(ZcEbProj proj) {    this.zcEbProjDao.deleteProjFileByProjCode(proj.getProjCode());    this.zcEbProjDao.insertZcEbProjFile(proj);  }  private void insertZcEbPackInfo(ZcEbProj proj) {    zcEbProjDao.insertZcEbPackInfo(proj);  }  private ZcEbProj getOriginalZcEbProjByProjCode(String projCode) {    ZcEbProj originalBean = this.getZcEbProjByProjCode(projCode);    // 清空摘要    originalBean.setDbDigest(null);    return originalBean;  }  public ZcEbProj getZcEbProjByProjCode(String projCode) {    ZcEbProj proj = this.zcEbProjDao.getOriginZcEbProjByProjId(projCode);    List packList = this.getZcEbPackListByProjCode(projCode);    proj.setPackList(packList);    if (packList != null && packList.size() > 0) {      ZcEbPack pack = (ZcEbPack) packList.get(0);      if (pack.getEntrust() != null) {        proj.setZcMakeLinkman(pack.getEntrust().getZcMakeLinkman());      }    }    proj.setPlan(this.getPlan(projCode));        proj.setProjFileList(getZbFile(proj.getProjCode()));    proj.setDbDigest(proj.digest());        return proj;  }  private List getZbFile(String projCode) {    // TODO Auto-generated method stub    return zcEbProjDao.getProjFileByProjCode(projCode);  }  public void deleteFN(String projCode) {    zcEbProjDao.deleteZcEbProjByProjCode(projCode);    zcEbProjDao.deleteZcEbPackByProjCode(projCode);    ZcEbProjZbFile zbFileResult = (ZcEbProjZbFile) baseDao.read("ZcEbProjZbFile.getZcEbProjFileByeProjCode", projCode);    if (zbFileResult != null) {      zcEbProjDao.deleteProjFileByProjCode(projCode);      if (zbFileResult.getFileId() != null) {        baseDao.delete("AsFile.deleteAsFileById", zbFileResult.getFileId());      }    }    zcEbPlanDao.deletePlanByProjcode(projCode);    // 注释掉,原因：现在评标方法是在需求模块划分，立项模块不涉及评标方法的增删改的操作，立项模块根据标段引用评标方法     zcEbFormulaService.deleteForZcEbFormulaByProjCode(projCode);  }  public ZcEbProj newCommitFN(ZcEbProj proj, RequestMeta requestMeta) {    // saveBill(proj);    wfEngineAdapter.newCommit(proj.getComment(), proj, requestMeta);    return getZcEbProjByProjCode(proj.getProjCode());  }  public ZcEbProj auditFN(ZcEbProj proj, RequestMeta requestMeta) {    zcEbProjDao.updateZcEbProj(proj);    // String fuzhuren =    // AsOptionUtil.getInstance().getOptionById("CG_HT_AUDIT_CGZX_FZR").getOptVal();    // String zhuren =    // AsOptionUtil.getInstance().getOptionById("CG_HT_AUDIT_CGZX_ZR").getOptVal();    // if (fuzhuren != null &&    // fuzhuren.equalsIgnoreCase(requestMeta.getSvPoCode())) {    // if (proj.getIsGoonAudit() == null || proj.getIsGoonAudit().intValue()    // != 1) {//不送主任审批，那就经办人    // sendToStartMan(proj);    // return getZcEbProjByProjCode(proj.getProjCode());    // }    // }    //    // if (zhuren != null &&    // zhuren.equalsIgnoreCase(requestMeta.getSvPoCode())) {//如果是主任审批，那就经办人    // sendToStartMan(proj);    // return getZcEbProjByProjCode(proj.getProjCode());    // }    wfEngineAdapter.commit(proj.getComment(), proj, requestMeta);    return getZcEbProjByProjCode(proj.getProjCode());  }  public void sendToStartMan(ZcEbProj proj, RequestMeta requestMeta) {    String userId = (String) baseDao.read("ZcEbRequirement.getNodeCgzxUserId", proj.getProcessInstId());    WorkflowContext workflowContext = wfEngineAdapter.genCommonWFC(proj.getComment(), proj, requestMeta);    List result = new ArrayList();    result.add(userId);    workflowContext.setNextExecutor(result);    wfEngineAdapter.commit(workflowContext);  }  public ZcEbProj unAuditFN(ZcEbProj proj, RequestMeta requestMeta) throws Exception {    Integer temp = (Integer) baseDao.read("ZcEbBulletin.checkPublished", proj.getProjCode());    int count = temp == null ? 0 : temp.intValue();    if (count > 0) {      throw new Exception("该项目已发布公告，不能消审");    }    wfEngineAdapter.rework(proj.getComment(), proj, requestMeta);    return getZcEbProjByProjCode(proj.getProjCode());  }  public ZcEbProj untreadFN(ZcEbProj proj, RequestMeta requestMeta) {    wfEngineAdapter.untread(proj.getComment(), proj, requestMeta);    return getZcEbProjByProjCode(proj.getProjCode());  }  public ZcEbProj callbackFN(ZcEbProj proj, RequestMeta requestMeta) {    wfEngineAdapter.unAudit(proj.getComment(), proj, requestMeta);    return getZcEbProjByProjCode(proj.getProjCode());  }  public void updateZcEbPack(ZcEbPack pack) {    this.zcEbProjDao.upZcEbPack(pack);    if (ZcSettingConstants.PACK_STATUS_EVAL_COMPLETE.equals(pack.getStatus())) {      List packList = zcEbProjDao.getZcEbPackListByProjCode(pack.getProjCode());      for (int i = 0; i < packList.size(); i++) {        ZcEbPack p = (ZcEbPack) packList.get(i);        if (!ZcSettingConstants.PACK_STATUS_EVAL_COMPLETE.equals(p.getStatus()) && !ZcSettingConstants.PACK_STATUS_CANCEL.equals(p.getStatus())) {          return;        }      }      Map para = new HashMap();      para.put("PROJ_CODE", pack.getProjCode());      ZcEbProj pj = this.zcEbProjDao.getZcEbProjByProjCode(para);      pj.setStatus("finish");      this.zcEbProjDao.updateZcEbProj(pj);    } else if (ZcSettingConstants.PACK_STATUS_OPEN_BID.equals(pack.getStatus())) {      baseDao.update("ZcEbProj.updateZcEbPackOpenBidTime", pack);    }  }  private void updateFormula(ZcEbProj pj) {    zcEbFormulaService.updateFormulaProj(pj);  }  private void updatePlan(ZcEbProj pj) {    if (pj.getPlan() != null) {      this.zcEbPlanDao.deletePlanByProjcode(pj.getProjCode());      pj.getPlan().setProjCode(pj.getProjCode());      pj.getPlan().setProjName(pj.getProjName());      if (pj.getPlan().getPlanCode() == null) {        String planCode = NumUtil.getInstance().getNo("ZC_EB_PLAN", "PLAN_CODE", pj.getPlan());        pj.getPlan().setPlanCode(planCode);      }      pj.getPlan().setNd(pj.getNd());      this.zcEbPlanDao.insertZcEbPlan(pj.getPlan());    } else {      ZcEbPlan plan = new ZcEbPlan();      pj.setPlan(plan);            pj.getPlan().setProjCode(pj.getProjCode());      pj.getPlan().setNd(pj.getNd());      pj.getPlan().setProjName(pj.getProjName());      String planCode = NumUtil.getInstance().getNo("ZC_EB_PLAN", "PLAN_CODE", pj.getPlan());      pj.getPlan().setPlanCode(planCode);      if (ZcSettingConstants.PITEM_OPIWAY_XJ.equals(pj.getPurType())) {        Calendar cd = Calendar.getInstance();        cd.setTime(pj.getPlan().getOpenBidTime());//        cd.add(Calendar.HOUR_OF_DAY, -1);        pj.getPlan().setBidEndTime(cd.getTime());        pj.getPlan().setSellEndTime(cd.getTime());      }      this.zcEbPlanDao.insertZcEbPlan(pj.getPlan());    }  }  public List getProjXunJia(ElementConditionDto dto) {    return this.zcEbProjDao.getProjXunJia(dto);  }  public List getBidConditions(String projCode) {    return this.zcEbProjDao.getBidConditions(projCode);  }  public void setZcEbPlanDao(IZcEbPlanDao zcEbPlanDao) {    this.zcEbPlanDao = zcEbPlanDao;  }  public IZcEbPlanDao getZcEbPlanDao() {    return zcEbPlanDao;  }  public List auditFN(List beanList, RequestMeta requestMeta) {    List list = new ArrayList();    for (int i = 0; i < beanList.size(); i++) {      ZcEbProj proj = ((ZcEbProj) beanList.get(i));      wfEngineAdapter.commit(proj.getComment(), proj, requestMeta);      list.add(getZcEbProjByProjCode(proj.getProjCode()));    }    return list;  }  public List save(List beanList) {    List list = new ArrayList();    for (int i = 0; i < beanList.size(); i++) {      ZcEbProj proj = ((ZcEbProj) beanList.get(i));      this.zcEbProjDao.updateZcEbProj(proj);      list.add(getZcEbProjByProjCode(proj.getProjCode()));    }    return list;  }  public List getZcEbProjForDecoded(ElementConditionDto dto) {    return zcEbProjDao.getZcEbProjForDecoded(dto);  }  public Map getProjInfoWithView(String projCode) {    return zcEbProjDao.getProjInfoWithView(projCode);  }  public List getPackesInfoWithView(String projCode) {    return zcEbProjDao.getPackesInfoWithView(projCode);  }  public List getProjListWithView(Map paras) {    return zcEbProjDao.getProjListWithView(paras);  }  public Map getProjPackDetailsWithView(Map paras) {    return zcEbProjDao.getProjPackDetailsWithView(paras);  }  public List getProjPackReqDetailFileInfoWithView(Map paras) {    return zcEbProjDao.getProjPackReqDetailFileInfoWithView(paras);  }  public AsFile getXunJiaWordContent(ZcEbProj zcEbProj, String fileID, boolean isWaitFrelease) {    AsFile fileContent = new AsFile();    List templateList = baseDao.query("AsFile.getAsFileById", fileID);    AsFile template = new AsFile();    if (templateList != null && templateList.size() > 0) {      template = (AsFile) templateList.get(0);    }    Map xieyi = new HashMap();    ZcEbProj project = zcEbProjDao.getOriginZcEbProjByProjId(zcEbProj.getProjCode());    xieyi.put("project", project);    List planList = baseDao.query("ZcEbPlan.getZcEbPlanByProjCode", zcEbProj.getProjCode());    ZcEbPlan plan = null;    if (planList != null && planList.size() > 0) {      plan = (ZcEbPlan) planList.get(0);      xieyi.put("plan", planList.get(0));    } else {      plan = new ZcEbPlan();      xieyi.put("plan", new ZcEbPlan());    }    ElementConditionDto cond = new ElementConditionDto();    cond.setZcText0(zcEbProj.getProjCode());    List xunjiList = baseDao.query("ZcEbXunJia.getXunJia", cond);    AsValDataUtil xunUtil = AsValDataUtil.getInstance();    for (Iterator iterator = xunjiList.iterator(); iterator.hasNext();) {      ZcEbXunJia it = (ZcEbXunJia) iterator.next();      it.setUnit(xunUtil.getName("V_SP_UNIT", it.getUnit()));    }    xieyi.put("xunjiList", xunjiList);    SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");    if (isWaitFrelease) {// 如果是待发布状态      xieyi.put("fabuSj", simFormat.format(new Date()));    } else {      xieyi.put("fabuSj", "");    }    if (plan.getBidEndTime() != null) {      SimpleDateFormat simFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      xieyi.put("bidEndTime", simFormat2.format(plan.getBidEndTime()));    }    List ageList = baseDao.query("ZC_B_AGENCY.getZcBAgencyById", project.getAgency());    ZcBAgency age = new ZcBAgency();    if (ageList != null && ageList.size() > 0) {      age = ((ZcBAgency) ageList.get(0));    }    xieyi.put("agency", age);    BigDecimal totalMoney = getXunJiaTotalMoney(xunjiList);    BigDecimal zero = new BigDecimal("0");    if (totalMoney.compareTo(zero) == 0) {      xieyi.put("totalMoney", "");      xieyi.put("chineseMoney", "");    } else {      xieyi.put("totalMoney", totalMoney);      ChangeRMB changeRmb = new ChangeRMB();      String cm = changeRmb.doChange(totalMoney.toString());      xieyi.put("chineseMoney", cm);    }    xieyi.put("url", AsOptionUtil.getInstance().getOptionVal("XUN_JIA_NEED_URL"));    byte[] protocolByte = null;    try {      protocolByte = evaluateFileContext(xieyi, template.getFileContent());    } catch (Exception e) {      e.printStackTrace();    }    fileContent.setFileContent(protocolByte);    return fileContent;  }  private BigDecimal getXunJiaTotalMoney(List xunjiList) {    BigDecimal zero = new BigDecimal("0");    BigDecimal totalMoney = zero;    for (Iterator iterator = xunjiList.iterator(); iterator.hasNext();) {      ZcEbXunJia xj = (ZcEbXunJia) iterator.next();      if (xj.getSpName() == null) {        xj.setSpName("");      }      if (xj.getSpBrand() == null) {        xj.setSpBrand("");      }      if (xj.getSpTech() == null) {        xj.setSpTech("");      }      if (xj.getSpPrice() == null) {        xj.setSpPrice(zero);      }      BigDecimal dj = xj.getSpPrice();      dj = dj == null ? zero : dj;      int sl = xj.getSpNum();      totalMoney = totalMoney.add(new BigDecimal(dj.doubleValue() * sl));    }    return totalMoney;  }  private byte[] evaluateFileContext(Map xieyi, byte[] fileContent) throws Exception {    Map contextMap = new HashMap();    contextMap.put("xieyi", xieyi);    return ZcSUtil.evaluate(contextMap, fileContent, "xieyi", ZcSUtil.ENCODING_DEFAULT);  }  public List getZcEbProjWithPacks(ElementConditionDto dto, RequestMeta requestMeta) {    List list = this.getZcEbProj(dto, requestMeta);    for (int i = 0; i < list.size(); i++) {      ZcEbProj proj = (ZcEbProj) list.get(i);      if (proj == null) {        continue;      }      List packList = this.getZcEbPackListByProjCode(proj.getProjCode());      proj.setPackList(packList);    }    return list;  }  public AsValDao getAsValDao() {    return asValDao;  }  public void setAsValDao(AsValDao asValDao) {    this.asValDao = asValDao;  }  public String getZcEbXiebanPerson(String projCode) {    return zcEbProjDao.getZcEbXiebanPerson(projCode);  }  /**   * 获取改项目下的所有评标方法的信息   */  public List getFormulaPackListByProjCode(String projCode) {    List packList = baseDao.query("ZcEbProj.getZcEbPackListByProjCode", projCode);    Set set = new HashSet();    List zcEbFormulaPackList = new ArrayList();    for (int i = 0; i < packList.size(); i++) {      ZcEbPack pack = (ZcEbPack) packList.get(i);      ElementConditionDto dto = new ElementConditionDto();      dto.setPackCode(pack.getPackCode());      ZcEbFormula formula = (ZcEbFormula) baseDao.read("ZcEbFormula.getZcEbFormulaByPackCode", dto);      if (formula != null) {        pack.setZcEbFormula(formula);        set.add(formula.getFormulaCode());      }    }    Iterator keys = set.iterator();    while (set.iterator().hasNext()) {      Object obj = set.iterator().next();      String formulaCode = (String) obj;      ZcEbFormulaPack zcEbFormulaPack = new ZcEbFormulaPack();      zcEbFormulaPack.setFormulaCode(formulaCode);      List packFomrulaList = new ArrayList();      for (int j = 0; j < packList.size(); j++) {        ZcEbPack pack = (ZcEbPack) packList.get(j);        if (pack.getZcEbFormula() != null) {          if (pack.getZcEbFormula().getFormulaCode().equals(formulaCode)) {            ZcEbPack formulaPack = (ZcEbPack) ObjectUtil.deepCopy(pack);            packFomrulaList.add(formulaPack);          }        }      }      zcEbFormulaPack.setPackList(packFomrulaList);      zcEbFormulaPack.setZcEbFormula(((ZcEbPack) packFomrulaList.get(0)).getZcEbFormula());      zcEbFormulaPackList.add(zcEbFormulaPack);    }    return zcEbFormulaPackList;  }  public List getZcEbSignupProj(ElementConditionDto dto) {    return zcEbProjDao.getZcEbSignupProj(dto);  }  public List getZcEbProjPackVO(ElementConditionDto dto, RequestMeta meta) {    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getWfcompoId(), NumLimConstants.FWATCH));    return baseDao.query("ZcEbProj.getZcEbPackForZcEbProjPackVO", dto);  }  public boolean checkStatus(ZcEbPack pack) {    // TODO Auto-generated method stub    Integer temp = (Integer) baseDao.read("ZcEbProj.getPackStatus", pack);    int t = temp == null ? -1 : temp.intValue();    return t == 0;  }    public List queryExportsDatas(ElementConditionDto dto, RequestMeta meta) {    // TODO Auto-generated method stub    List plst=baseDao.query("ZcEbProj.getZcEbProjByProjCodes", dto);    List rtn=new ArrayList();    if(plst!=null){      for(int i=0;i<plst.size();i++){        ZcEbProj p=(ZcEbProj) plst.get(i);        p=getZcEbProjByProjCode(p.getProjCode());        if(p==null)continue;        getWorkFlowInfo(p);        rtn.add(p);            }    }    return rtn;  }  //获取工作流审批信息  private void getWorkFlowInfo(ZcEbProj p) {    // TODO Auto-generated method stub    ZcSUtil u=new ZcSUtil();    u.getWorkFlowInfo(p);  }     public String importTransDatasFN(ZcEbProj proj, RequestMeta meta) {    // TODO Auto-generated method stub    zcEbProjDao.deleteZcEbProjByProjCode(proj.getProjCode());    zcEbProjDao.insertZcEbProj(proj);    zcEbProjDao.deleteZcEbPackByProjCode(proj.getProjCode());    insertZcEbPackInfo(proj);      zcEbProjDao.deleteProjFileByProjCode(proj.getProjCode());    insertZcEbProjFile(proj);      zcEbPlanDao.deletePlan(proj.getPlan());    zcEbPlanDao.insertZcEbPlan(proj.getPlan());     ZcSUtil u=new ZcSUtil();    u.insertWorkFlowInfo(proj, meta);       return "导入招标项目成功"+proj.getProjCode()+proj.getProjName();  }     public List getExportsZbFile(ElementConditionDto dto, RequestMeta meta) {    // TODO Auto-generated method stub    List plst=baseDao.query("ZcEbProjZbFile.getZcEbProjFileByeProjCodes", dto);    return plst;  }}