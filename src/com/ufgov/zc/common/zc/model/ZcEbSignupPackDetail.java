/** * ZcEbSignupPackDetail.java com.ufgov.gk.common.zc.model Administrator 2010-5-4 */package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.math.BigDecimal;import java.util.ArrayList;import java.util.Date;import java.util.List;/** * @author Administrator */public class ZcEbSignupPackDetail extends ZcBaseBill implements Serializable {  /**   * 未报价 VS_ZC_SP_STATUS   */  public static String BAOJIA_STATUS_NO = "1";  /**   * 报价 VS_ZC_SP_STATUS   */  public static String BAOJIA_STATUS_YES = "2";  /**   * 撤回报价 VS_ZC_SP_STATUS   */  public static String BAOJIA_STATUS_CANCEL = "3";  /**   * 报名   */  public static String BAOMING_YES = "1";  /**   * 不报名   */  public static String BAOMING_NO = "0";  /**   * 报名审核通过   */  public static String BAOMING_AUDIT_YES = "1";  /**   * 报名审核不通过   */  public static String BAOMING_AUDIT_NO = "0";  /**   *    */  private static final long serialVersionUID = 9072243404452788019L;  /**   * 分包代码   */  private String packCode;  /**   * 分包名称   */  private String packName;  /**   * 报名分包ID   */  private String signupPackId;  /**   * 报名id   */  private String signupId;  /**   * 保证金状态   */  private String isPayGuarantee;  /**   * 保证金处理描述   */  private String guaranteeDesc;  /**   * 保证金   */  private BigDecimal bidDeposit;  /**   * 投标金额   */  private String bidSum;  /**   * 投标金额掩藏码   */  private String bidSumMask;  /**   * 开标状态   */  private String openBidStatus;  /**   * 是否提交了标书   */  private String isSubmitBidDoc;  /**   * 提交标书方式   */  private String submitBidDocType;  /**   * 提交标书次数   */  private String submitNums;  /**   * 提交标书时间   */  private Date submitBidDocDate;  private String bidDocId;  private String bidDocName;  private String openBidRemark;  private Date openBidDate;  private String packDesc;  private String purContent;  private String projCode;  private String tbylbFileName;  private String tbylbFileId;  private BigDecimal ecbjSum;  private String checkResult;  /*   * 询价报价时用于显示当前分包的状态，开标、延期、结束等   */  private String packStatus;  private String docPrice;  /*   * 报名状态、报名时间   */  private String spStatus;  private Date spDate;  private String qualificationRequire;  private String isCheckQualification;  //分包的具体采购要求  类型是ZcEbPackReq  private List requirementDetailList = new ArrayList();  public String getSpStatus() {    return spStatus;  }  public void setSpStatus(String spStatus) {    this.spStatus = spStatus;  }  public Date getSpDate() {    return spDate;  }  public void setSpDate(Date spDate) {    this.spDate = spDate;  }  public String getPackDesc() {    return packDesc;  }  public void setPackDesc(String packDesc) {    this.packDesc = packDesc;  }  public String getPurContent() {    return purContent;  }  public void setPurContent(String purContent) {    this.purContent = purContent;  }  private List xunJiaBaoJiaList = new ArrayList();  /**   * @return the packCode   */  public String getPackCode() {    return packCode;  }  /**   * @param packCode the packCode to set   */  public void setPackCode(String packCode) {    this.packCode = packCode;  }  /**   * @return the packName   */  public String getPackName() {    return packName;  }  /**   * @param packName the packName to set   */  public void setPackName(String packName) {    this.packName = packName;  }  /**   * @return the signupPackId   */  public String getSignupPackId() {    return signupPackId;  }  /**   * @param signupPackId the signupPackId to set   */  public void setSignupPackId(String signupPackId) {    this.signupPackId = signupPackId;  }  /**   * @return the signupId   */  public String getSignupId() {    return signupId;  }  /**   * @param signupId the signupId to set   */  public void setSignupId(String signupId) {    this.signupId = signupId;  }  /**   * @return the isPayGuarantee   */  public String getIsPayGuarantee() {    return isPayGuarantee;  }  /**   * @param isPayGuarantee the isPayGuarantee to set   */  public void setIsPayGuarantee(String isPayGuarantee) {    this.isPayGuarantee = isPayGuarantee;  }  /**   * @return the guaranteeDesc   */  public String getGuaranteeDesc() {    return guaranteeDesc;  }  /**   * @param guaranteeDesc the guaranteeDesc to set   */  public void setGuaranteeDesc(String guaranteeDesc) {    this.guaranteeDesc = guaranteeDesc;  }  /**   * @return the bidDeposit   */  public BigDecimal getBidDeposit() {    return bidDeposit;  }  /**   * @param bidDeposit the bidDeposit to set   */  public void setBidDeposit(BigDecimal bidDeposit) {    this.bidDeposit = bidDeposit;  }  /**   * @return the bidSum   */  public String getBidSum() {    return bidSum;  }  /**   * @param bidSum the bidSum to set   */  public void setBidSum(String bidSum) {    this.bidSum = bidSum;  }  /**   * @return the bidSumMask   */  public String getBidSumMask() {    return bidSumMask;  }  /**   * @param bidSumMask the bidSumMask to set   */  public void setBidSumMask(String bidSumMask) {    this.bidSumMask = bidSumMask;  }  /**   * @return the openBidStatus   */  public String getOpenBidStatus() {    return openBidStatus;  }  /**   * @param openBidStatus the openBidStatus to set   */  public void setOpenBidStatus(String openBidStatus) {    this.openBidStatus = openBidStatus;  }  /**   * @return the serialversionuid   */  public static long getSerialversionuid() {    return serialVersionUID;  }  /**   * @return the isSubmitBidDoc   */  public String getIsSubmitBidDoc() {    return isSubmitBidDoc;  }  /**   * @param isSubmitBidDoc the isSubmitBidDoc to set   */  public void setIsSubmitBidDoc(String isSubmitBidDoc) {    this.isSubmitBidDoc = isSubmitBidDoc;  }  /**   * @return the submitBidDocType   */  public String getSubmitBidDocType() {    return submitBidDocType;  }  /**   * @param submitBidDocType the submitBidDocType to set   */  public void setSubmitBidDocType(String submitBidDocType) {    this.submitBidDocType = submitBidDocType;  }  /**   * @return the submitNums   */  public String getSubmitNums() {    return submitNums;  }  /**   * @param submitNums the submitNums to set   */  public void setSubmitNums(String submitNums) {    this.submitNums = submitNums;  }  /**   * @return the bidDocId   */  public String getBidDocId() {    return bidDocId;  }  /**   * @param bidDocId the bidDocId to set   */  public void setBidDocId(String bidDocId) {    this.bidDocId = bidDocId;  }  /**   * @return the bidDocName   */  public String getBidDocName() {    return bidDocName;  }  /**   * @param bidDocName the bidDocName to set   */  public void setBidDocName(String bidDocName) {    this.bidDocName = bidDocName;  }  public void setOpenBidRemark(String openBidRemark) {    this.openBidRemark = openBidRemark;  }  public String getOpenBidRemark() {    return openBidRemark;  }  public void setOpenBidDate(Date openBidDate) {    this.openBidDate = openBidDate;  }  public Date getOpenBidDate() {    return openBidDate;  }  public void setXunJiaBaoJiaList(List xunJiaBaoJiaList) {    this.xunJiaBaoJiaList = xunJiaBaoJiaList;  }  public List getXunJiaBaoJiaList() {    return xunJiaBaoJiaList;  }  public void setProjCode(String projCode) {    this.projCode = projCode;  }  public String getProjCode() {    return projCode;  }  public void setPackStatus(String packStatus) {    this.packStatus = packStatus;  }  public String getPackStatus() {    return packStatus;  }  public void setSubmitBidDocDate(Date submitBidDocDate) {    this.submitBidDocDate = submitBidDocDate;  }  public Date getSubmitBidDocDate() {    return submitBidDocDate;  }  public String getTbylbFileName() {    return tbylbFileName;  }  public void setTbylbFileName(String tbylbFileName) {    this.tbylbFileName = tbylbFileName;  }  public String getTbylbFileId() {    return tbylbFileId;  }  public void setTbylbFileId(String tbylbFileId) {    this.tbylbFileId = tbylbFileId;  }  public BigDecimal getEcbjSum() {    return ecbjSum;  }  public void setEcbjSum(BigDecimal ecbjSum) {    this.ecbjSum = ecbjSum;  }  public String getCheckResult() {    return checkResult;  }  public void setCheckResult(String checkResult) {    this.checkResult = checkResult;  }  public String getDocPrice() {    return docPrice;  }  public void setDocPrice(String docPrice) {    this.docPrice = docPrice;  }  private List supplierPriceDetail = new ArrayList();  public List getSupplierPriceDetail() {    return supplierPriceDetail;  }  public void setSupplierPriceDetail(List supplierPriceDetail) {    this.supplierPriceDetail = supplierPriceDetail;  }  public String toString() {    return this.getPackName() + "[" + this.getPackCode() + "]";  }  public String getQualificationRequire() {    return qualificationRequire;  }  public void setQualificationRequire(String qualificationRequire) {    this.qualificationRequire = qualificationRequire;  }  public String getIsCheckQualification() {    return isCheckQualification;  }  public void setIsCheckQualification(String isCheckQualification) {    this.isCheckQualification = isCheckQualification;  }  public List getRequirementDetailList() {    return requirementDetailList;  }  public void setRequirementDetailList(List requirementDetailList) {    this.requirementDetailList = requirementDetailList;  }}