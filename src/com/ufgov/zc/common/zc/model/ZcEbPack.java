package com.ufgov.zc.common.zc.model;import java.math.BigDecimal;import java.util.ArrayList;import java.util.Date;import java.util.List;/*** @ClassName: ZcEbPack* @Description: TODO(这里用一句话描述这个类的作用)* @date: Sep 5, 2012 6:39:03 AM* @version: V1.0 * @since: 1.0* @author: Administrator* @modify: */public class ZcEbPack extends ZcBaseBill {  private static final long serialVersionUID = 4881701877248508897L;  private String packCode;  private String packName;  private String projCode;  private String projName;  private String tempId;  private String purType;  private BigDecimal bidSum;  private String openBidStatus;  private String isSubmitBidDoc;  private String bidDocId;  private String bidDocName;  private String purContent;  private BigDecimal packBudget;  private String entrustCode;  private String isCheckQualification;  private String analyseType;  private String bidLocation;  private BigDecimal bidDocPrice;  private BigDecimal bidDeposit;  private String isFailed;  private String techRequire;  private String qualificationRequire;  private String packDesc;  private String status;  private String isSeleSupplier;  private String seleType;  private Integer seleNum;  private String isShowBudget;  private String failedReason;  private String lastStatus;  private String attn;  private String attnName;  private String attnEmail;  private String attnPhone;  private String attnFax;  private String manager;  private String managerName;  private String managerPhone;  private String managerEmail;  private String managerFax;  private String reqCode;  private ZcEbEntrust entrust = new ZcEbEntrust();  private List requirementDetailList = new ArrayList();  private List xunJiaList = new ArrayList();  private List supplierList = new ArrayList();  private List packQua = new ArrayList();  /**   * 报名前的资质要求条件   */  private List bidConditions = new ArrayList();  private ZcEbFormula zcEbFormula;  private ZcEbRequirementConfirm zcEbRequirementConfirm;  private String reqFileId;  private String reqFileName;  private String formulaFileId;  private String formulaFileName;  private Date openBidTime;  private BigDecimal packMaxPrice;  public BigDecimal getPackMaxPrice() {    return packMaxPrice;  }  public void setPackMaxPrice(BigDecimal packMaxPrice) {    this.packMaxPrice = packMaxPrice;  }  public Date getOpenBidTime() {    return openBidTime;  }  public void setOpenBidTime(Date openBidTime) {    this.openBidTime = openBidTime;  }  public String getReqCode() {    return reqCode;  }  public void setReqCode(String reqCode) {    this.reqCode = reqCode;  }  /**   * @return the reqFileId   */  public String getReqFileId() {    return reqFileId;  }  /**   * @param reqFileId the reqFileId to set   */  public void setReqFileId(String reqFileId) {    this.reqFileId = reqFileId;  }  /**   * @return the reqFileName   */  public String getReqFileName() {    return reqFileName;  }  /**   * @param reqFileName the reqFileName to set   */  public void setReqFileName(String reqFileName) {    this.reqFileName = reqFileName;  }  /**   * @return the formulaFileId   */  public String getFormulaFileId() {    return formulaFileId;  }  /**   * @param formulaFileId the formulaFileId to set   */  public void setFormulaFileId(String formulaFileId) {    this.formulaFileId = formulaFileId;  }  /**   * @return the formulaFileName   */  public String getFormulaFileName() {    return formulaFileName;  }  /**   * @param formulaFileName the formulaFileName to set   */  public void setFormulaFileName(String formulaFileName) {    this.formulaFileName = formulaFileName;  }  /**   * @return the zcEbRequirementConfirm   */  public ZcEbRequirementConfirm getZcEbRequirementConfirm() {    return zcEbRequirementConfirm;  }  /**   * @param zcEbRequirementConfirm the zcEbRequirementConfirm to set   */  public void setZcEbRequirementConfirm(ZcEbRequirementConfirm zcEbRequirementConfirm) {    this.zcEbRequirementConfirm = zcEbRequirementConfirm;  }  /**   * @return the entrust   */  public ZcEbEntrust getEntrust() {    return entrust;  }  /**   * @param entrust the entrust to set   */  public void setEntrust(ZcEbEntrust entrust) {    this.entrust = entrust;  }  /**   * @return the purContent   */  public String getPurContent() {    return purContent;  }  /**   * @param purContent the purContent to set   */  public void setPurContent(String purContent) {    this.purContent = purContent;  }  /**   * @return the packBudget   */  public BigDecimal getPackBudget() {    return packBudget;  }  /**   * @param packBudget the packBudget to set   */  public void setPackBudget(BigDecimal packBudget) {    this.packBudget = packBudget;  }  /**   * @return the entrustCode   */  public String getEntrustCode() {    return entrustCode;  }  /**   * @param entrustCode the entrustCode to set   */  public void setEntrustCode(String entrustCode) {    this.entrustCode = entrustCode;  }  /**   * @return the isCheckQualification   */  public String getIsCheckQualification() {    return isCheckQualification;  }  /**   * @param isCheckQualification the isCheckQualification to set   */  public void setIsCheckQualification(String isCheckQualification) {    this.isCheckQualification = isCheckQualification;  }  /**   * @return the purType   */  public String getPurType() {    return purType;  }  /**   * @param purType the purType to set   */  public void setPurType(String purType) {    this.purType = purType;  }  /**   * @return the analyseType   */  public String getAnalyseType() {    return analyseType;  }  /**   * @param analyseType the analyseType to set   */  public void setAnalyseType(String analyseType) {    this.analyseType = analyseType;  }  /**   * @return the bidLocation   */  public String getBidLocation() {    return bidLocation;  }  /**   * @param bidLocation the bidLocation to set   */  public void setBidLocation(String bidLocation) {    this.bidLocation = bidLocation;  }  public BigDecimal getBidDocPrice() {    return bidDocPrice;  }  public void setBidDocPrice(BigDecimal bidDocPrice) {    this.bidDocPrice = bidDocPrice;  }  /**   * @return the bidDeposit   */  public BigDecimal getBidDeposit() {    return bidDeposit;  }  /**   * @param bidDeposit the bidDeposit to set   */  public void setBidDeposit(BigDecimal bidDeposit) {    this.bidDeposit = bidDeposit;  }  /**   * @return the isFailed   */  public String getIsFailed() {    return isFailed;  }  /**   * @param isFailed the isFailed to set   */  public void setIsFailed(String isFailed) {    this.isFailed = isFailed;  }  /**   * @return the techRequire   */  public String getTechRequire() {    return techRequire;  }  /**   * @param techRequire the techRequire to set   */  public void setTechRequire(String techRequire) {    this.techRequire = techRequire;  }  /**   * @return the qualificationRequire   */  public String getQualificationRequire() {    return qualificationRequire;  }  /**   * @param qualificationRequire the qualificationRequire to set   */  public void setQualificationRequire(String qualificationRequire) {    this.qualificationRequire = qualificationRequire;  }  /**   * @return the packDesc   */  public String getPackDesc() {    return packDesc;  }  /**   * @param packDesc the packDesc to set   */  public void setPackDesc(String packDesc) {    this.packDesc = packDesc;  }  /**   * @return the status   */  public String getStatus() {    return status;  }  /**   * @param status the status to set   */  public void setStatus(String status) {    this.status = status;  }  /**   * @return the isSeleSupplier   */  public String getIsSeleSupplier() {    return isSeleSupplier;  }  /**   * @param isSeleSupplier the isSeleSupplier to set   */  public void setIsSeleSupplier(String isSeleSupplier) {    this.isSeleSupplier = isSeleSupplier;  }  /**   * @return the seleType   */  public String getSeleType() {    return seleType;  }  /**   * @param seleType the seleType to set   */  public void setSeleType(String seleType) {    this.seleType = seleType;  }  /**   * @return the seleNum   */  public Integer getSeleNum() {    return seleNum;  }  /**   * @param seleNum the seleNum to set   */  public void setSeleNum(Integer seleNum) {    this.seleNum = seleNum;  }  /**   * @return the isShowBudget   */  public String getIsShowBudget() {    return isShowBudget;  }  /**   * @param isShowBudget the isShowBudget to set   */  public void setIsShowBudget(String isShowBudget) {    this.isShowBudget = isShowBudget;  }  public List getRequirementDetailList() {    return requirementDetailList;  }  public void setRequirementDetailList(List requirementDetailList) {    this.requirementDetailList = requirementDetailList;  }  /**   * @return the packCode   */  public String getPackCode() {    return packCode;  }  /**   * @param packCode the packCode to set   */  public void setPackCode(String packCode) {    this.packCode = packCode;  }  /**   * @return the packName   */  public String getPackName() {    return packName;  }  /**   * @param packName the packName to set   */  public void setPackName(String packName) {    this.packName = packName;  }  public void setTempId(String tempId) {    this.tempId = tempId;  }  public String getTempId() {    return tempId;  }  public void setProjCode(String projCode) {    this.projCode = projCode;  }  public String getProjCode() {    return projCode;  }  /**   * @return the bidSum   */  public BigDecimal getBidSum() {    return bidSum;  }  /**   * @param bidSum the bidSum to set   */  public void setBidSum(BigDecimal bidSum) {    this.bidSum = bidSum;  }  /**   * @return the openBidStatus   */  public String getOpenBidStatus() {    return openBidStatus;  }  /**   * @param openBidStatus the openBidStatus to set   */  public void setOpenBidStatus(String openBidStatus) {    this.openBidStatus = openBidStatus;  }  /**   * @return the isSubmitBidDoc   */  public String getIsSubmitBidDoc() {    return isSubmitBidDoc;  }  /**   * @param isSubmitBidDoc the isSubmitBidDoc to set   */  public void setIsSubmitBidDoc(String isSubmitBidDoc) {    this.isSubmitBidDoc = isSubmitBidDoc;  }  /**   * @return the bidDocId   */  public String getBidDocId() {    return bidDocId;  }  /**   * @param bidDocId the bidDocId to set   */  public void setBidDocId(String bidDocId) {    this.bidDocId = bidDocId;  }  /**   * @return the bidDocName   */  public String getBidDocName() {    return bidDocName;  }  /**   * @param bidDocName the bidDocName to set   */  public void setBidDocName(String bidDocName) {    this.bidDocName = bidDocName;  }  /**   * @return the failedReason   */  public String getFailedReason() {    return failedReason;  }  /**   * @param failedReason the failedReason to set   */  public void setFailedReason(String failedReason) {    this.failedReason = failedReason;  }  public void setXunJiaList(List xunJiaList) {    this.xunJiaList = xunJiaList;  }  public List getXunJiaList() {    return xunJiaList;  }  public void setBidConditions(List bidConditions) {    this.bidConditions = bidConditions;  }  public List getBidConditions() {    return bidConditions;  }  /**   * @return the zcEbFormula   */  public ZcEbFormula getZcEbFormula() {    return zcEbFormula;  }  /**   * @param zcEbFormula the zcEbFormula to set   */  public void setZcEbFormula(ZcEbFormula zcEbFormula) {    this.zcEbFormula = zcEbFormula;  }  /**   * @return the lastStatus   */  public String getLastStatus() {    return lastStatus;  }  /**   * @param lastStatus the lastStatus to set   */  public void setLastStatus(String lastStatus) {    this.lastStatus = lastStatus;  }  public String getAttn() {    return attn;  }  public void setAttn(String attn) {    this.attn = attn;  }  public String getAttnName() {    return attnName;  }  public void setAttnName(String attnName) {    this.attnName = attnName;  }  public String getAttnEmail() {    return attnEmail;  }  public void setAttnEmail(String attnEmail) {    this.attnEmail = attnEmail;  }  public String getAttnPhone() {    return attnPhone;  }  public void setAttnPhone(String attnPhone) {    this.attnPhone = attnPhone;  }  public String getAttnFax() {    return attnFax;  }  public void setAttnFax(String attnFax) {    this.attnFax = attnFax;  }  public String getManager() {    return manager;  }  public void setManager(String manager) {    this.manager = manager;  }  public String getManagerName() {    return managerName;  }  public void setManagerName(String managerName) {    this.managerName = managerName;  }  public String getManagerPhone() {    return managerPhone;  }  public void setManagerPhone(String managerPhone) {    this.managerPhone = managerPhone;  }  public String getManagerEmail() {    return managerEmail;  }  public void setManagerEmail(String managerEmail) {    this.managerEmail = managerEmail;  }  public String getManagerFax() {    return managerFax;  }  public void setManagerFax(String managerFax) {    this.managerFax = managerFax;  }  public List getSupplierList() {    return supplierList;  }  public void setSupplierList(List supplierList) {    this.supplierList = supplierList;  }  public List getPackQua() {    return packQua;  }  public void setPackQua(List packQua) {    this.packQua = packQua;  }  public String getProjName() {    return projName;  }  public void setProjName(String projName) {    this.projName = projName;  }}