package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.util.Date;import java.util.List;public class ZcEbBulletin extends ZcBaseBill implements Serializable {  /*   * 单一来源招标公告   */  public static final String ZHAOBIAO_DYLY = "zhaobiao_dyly";  /*   * 公开招标招标公告   */  public static final String ZHAOBIAO_GKZB = "zhaobiao_gkzb";  /*   * 竞争性谈判招标公告   */  public static final String ZHAOBIAO_JZXTP = "zhaobiao_jzxtp";  /*   * 其他招标公告   */  public static final String ZHAOBIAO_QT = "zhaobiao_qt";  /*   * 询价招标公告   */  public static final String ZHAOBIAO_XJ = "zhaobiao_xj";  /*   * 邀请招标招标公告   */  public static final String ZHAOBIAO_YQZB = "zhaobiao_yqzb";  /*   * 征求意见公告   */  public static final String ZHENGQIUYIJIAN = "zhenqiuyijian";  /*   * 公开招标中标公告   */  public static final String ZHONGBIAO_GKZB = "zhongbiao_gkzb";  /*   * 竞争性谈判中标公告   */  public static final String ZHONGBIAO_JZXTP = "zhongbiao_jzxtp";  /*   * 邀请招标中标公告   */  public static final String ZHONGBIAO_YQZB = "zhongbiao_yqzb";  /*   * 询价中标公告   */  public static final String ZHONGBIAO_XJ = "zhongbiao_xj";  /*   * 单一来源招标公告   */  public static final String ZHONGBIAO_DYLY = "zhongbiao_dyly";  /*   * 其他招标中标公告   */  public static final String ZHONGBIAO_QT = "zhongbiao_qt";  /*   * 变更公告   */  public static final String BIANGENG = "biangeng";  /*   * 变更公告(询价)   */  public static final String BIANGENG_XJ = "biangeng_xj";  /*   * 中标通知书   */  public static final String ZHONGBIAO_NOTICE = "zhongbiao_notice";  /*   * 在线竞价招标公告   */  public static final String ZHAOBIAO_ZXJJ = "zhaobiao_zxjj";  /**   *    */  private static final long serialVersionUID = -4289450435481040444L;  private String bulletinID;  private String projCode;  private String projName;  private String bulletinType;  private String bulletinStatus;  private Date effectiveDate;  private String moldName;  private String fileID;  private String remark;  private int isExported;  private ZcEbProj zcEbProj = new ZcEbProj();  private ZcEbPlan zcEbPlan = new ZcEbPlan();  private ZcEbPackPlan packPlan = new ZcEbPackPlan();  private ZcPProMake zcPProMake = new ZcPProMake();  private String moldCode;  private String fileId1;  private String fileName1;  private String fileId2;  private String fileName2;  private Date failureDate;  private String cgtype;  private String fileContent;  private StringBuffer file;  private String downLoad;  private String bulname;  private Date openBidTime;  private String roleCode;  private String packName;  private String isExtrac;  private List packList;  private String packCode;  private String projectCode;  private Date bullPublishDate;  private String wordZbFileName;  private String wordZbFileId;  public List getPackList() {    return packList;  }  public void setPackList(List packList) {    this.packList = packList;  }  public String getIsExtrac() {    return isExtrac;  }  public void setIsExtrac(String isExtrac) {    this.isExtrac = isExtrac;  }  public String getPackName() {    return packName;  }  public void setPackName(String packName) {    this.packName = packName;  }  public String getRoleCode() {    return roleCode;  }  public void setRoleCode(String roleCode) {    this.roleCode = roleCode;  }  public Date getOpenBidTime() {    return openBidTime;  }  public void setOpenBidTime(Date openBidTime) {    this.openBidTime = openBidTime;  }  public String getBulname() {    return bulname;  }  public void setBulname(String bulname) {    this.bulname = bulname;  }  public String getDownLoad() {    return downLoad;  }  public void setDownLoad(String downLoad) {    this.downLoad = downLoad;  }  public StringBuffer getFile() {    return file;  }  public void setFile(StringBuffer file) {    this.file = file;  }  public String getFileContent() {    return fileContent;  }  public void setFileContent(String fileContent) {    this.fileContent = fileContent;  }  public String getCgtype() {    return cgtype;  }  public void setCgtype(String cgtype) {    this.cgtype = cgtype;  }  public Date getFailureDate() {    return failureDate;  }  public void setFailureDate(Date failureDate) {    this.failureDate = failureDate;  }  public String getRemark() {    return remark;  }  public void setRemark(String remark) {    this.remark = remark;  }  public String getMoldName() {    return moldName;  }  public void setMoldName(String moldName) {    this.moldName = moldName;  }  public String getBulletinID() {    return bulletinID;  }  public void setBulletinID(String bulletinID) {    this.bulletinID = bulletinID;  }  public String getProjCode() {    return projCode;  }  public void setProjCode(String projCode) {    this.projCode = projCode;  }  public String getProjName() {    return projName;  }  public void setProjName(String projName) {    this.projName = projName;  }  public String getBulletinType() {    return bulletinType;  }  public void setBulletinType(String bulletinType) {    this.bulletinType = bulletinType;  }  public String getBulletinStatus() {    return bulletinStatus;  }  public void setBulletinStatus(String bulletinStatus) {    this.bulletinStatus = bulletinStatus;  }  public Date getEffectiveDate() {    return effectiveDate;  }  public void setEffectiveDate(Date effectiveDate) {    this.effectiveDate = effectiveDate;  }  public Date getExecuteDate() {    return executeDate;  }  public void setExecuteDate(Date executeDate) {    this.executeDate = executeDate;  }  public String getFileID() {    return fileID;  }  public void setFileID(String fileID) {    this.fileID = fileID;  }  public int getIsExported() {    return isExported;  }  public void setIsExported(int isExported) {    this.isExported = isExported;  }  public ZcEbProj getZcEbProj() {    return zcEbProj;  }  public void setZcEbProj(ZcEbProj zcEbProj) {    this.zcEbProj = zcEbProj;  }  public ZcEbPlan getZcEbPlan() {    return zcEbPlan;  }  public void setZcEbPlan(ZcEbPlan zcEbPlan) {    this.zcEbPlan = zcEbPlan == null ? new ZcEbPlan() : zcEbPlan;  }  public ZcPProMake getZcPProMake() {    return zcPProMake;  }  public void setZcPProMake(ZcPProMake zcPProMake) {    this.zcPProMake = zcPProMake;  }  public String getMoldCode() {    return moldCode;  }  public void setMoldCode(String moldCode) {    this.moldCode = moldCode;  }  /**   * @return the fileId1   */  public String getFileId1() {    return fileId1;  }  /**   * @param fileId1 the fileId1 to set   */  public void setFileId1(String fileId1) {    this.fileId1 = fileId1;  }  /**   * @return the fileName1   */  public String getFileName1() {    return fileName1;  }  /**   * @param fileName1 the fileName1 to set   */  public void setFileName1(String fileName1) {    this.fileName1 = fileName1;  }  /**   * @return the fileId2   */  public String getFileId2() {    return fileId2;  }  /**   * @param fileId2 the fileId2 to set   */  public void setFileId2(String fileId2) {    this.fileId2 = fileId2;  }  /**   * @return the fileName2   */  public String getFileName2() {    return fileName2;  }  /**   * @param fileName2 the fileName2 to set   */  public void setFileName2(String fileName2) {    this.fileName2 = fileName2;  }  /**   * @return the packPlan   */  public ZcEbPackPlan getPackPlan() {    return packPlan;  }  /**   * @param packPlan the packPlan to set   */  public void setPackPlan(ZcEbPackPlan packPlan) {    this.packPlan = packPlan;  }  /**   * @return the projectCode   */  public String getProjectCode() {    return projectCode;  }  /**   * @param projectCode the projectCode to set   */  public void setProjectCode(String projectCode) {    this.projectCode = projectCode;  }  /**   * @return the bullPublishDate   */  public Date getBullPublishDate() {    return bullPublishDate;  }  /**   * @param bullPublishDate the bullPublishDate to set   */  public void setBullPublishDate(Date bullPublishDate) {    this.bullPublishDate = bullPublishDate;  }  public String getWordZbFileName() {    if (getZcEbProj() != null && getZcEbProj().getProjFileList() != null && getZcEbProj().getProjFileList().size() > 0) {      ZcEbProjZbFile zf = (ZcEbProjZbFile) getZcEbProj().getProjFileList().get(0);      //      wordZbFileName = zf.getFileName();      wordZbFileName = "招标文件.doc";    }    return wordZbFileName;  }  public void setWordZbFileName(String wordZbFileName) {    this.wordZbFileName = wordZbFileName;  }  public String getWordZbFileId() {    if (getZcEbProj() != null && getZcEbProj().getProjFileList() != null && getZcEbProj().getProjFileList().size() > 0) {      ZcEbProjZbFile zf = (ZcEbProjZbFile) getZcEbProj().getProjFileList().get(0);      wordZbFileId = zf.getWordFileId();    }    return wordZbFileId;  }  public void setWordZbFileId(String wordZbFileId) {    this.wordZbFileId = wordZbFileId;    if (getZcEbProj() != null && getZcEbProj().getProjFileList() != null && getZcEbProj().getProjFileList().size() > 0) {      ZcEbProjZbFile zf = (ZcEbProjZbFile) getZcEbProj().getProjFileList().get(0);      zf.setWordFileId(wordZbFileId);    }  }}