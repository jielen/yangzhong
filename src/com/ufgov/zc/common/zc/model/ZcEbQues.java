package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.util.Date;import java.util.List;public class ZcEbQues extends ZcBaseBill implements Serializable {  /**   *    */  private static final long serialVersionUID = 2201487443241375471L;  /**   *    */  // 质疑单据处理状态  public static final String ZC_VS_QUES_STATE = "ZC_VS_QUES_STATE";  // 新增质疑  public static final String ZC_VS_QUES_STATE_new = "1";  // 质疑已回复  public static final String ZC_VS_QUES_STATE_completed = "exec";  // 质疑处理状态  public static final String ZC_VS_QUES_ALL_MODE = "ZC_VS_QUES_ALL_MODE";  // 质疑中  public static final String ZC_VS_QUES_ALL_MODE_zhiyizhong = "1";  // 已回复  public static final String ZC_VS_QUES_ALL_MODE_yihuifu = "2";  public static final String COL_AGENCY = "ZC_EB_QUESTION_AGENCY"; // 代理机构  public static final String COL_CLIENT_FILENAME = "ZC_EB_QUESTION_CLIENT_FILENAME"; // 相关文件  public static final String COL_CLIENT_REASON = "ZC_EB_QUESTION_CLIENT_REASON"; // 质疑意见  public static final String COL_CLIENT_SUBMIT_TSDATE = "ZC_EB_QUESTION_CLIENT_SUBMIT_TSDATE"; // TSDATE  public static final String COL_CLIENT_SUBMIT_ZYDATE = "ZC_EB_QUESTION_CLIENT_SUBMIT_ZYDATE"; // 提交日期  public static final String COL_CO_CODE = "ZC_EB_QUESTION_CO_CODE"; // 采购单位代码  public static final String COL_CREATEDATE = "ZC_EB_QUESTION_CREATEDATE"; // 创建日期  public static final String COL_DW_FILENAME = "ZC_EB_QUESTION_DW_FILENAME"; // 采购单位相关文件  public static final String COL_HANDLE_MODE = "ZC_EB_QUESTION_HANDLE_MODE"; // 质疑状态  public static final String COL_ID = "ZC_EB_QUESTION_ID"; // 质疑主键ID  public static final String COL_JB_DODATE = "ZC_EB_QUESTION_JB_DODATE"; // 回复日期  public static final String COL_JB_FILENAME = "ZC_EB_QUESTION_JB_FILENAME"; // 相关文件  public static final String COL_JB_PERSON = "ZC_EB_QUESTION_JB_PERSON"; // 招标负责  public static final String COL_JB_REASON = "ZC_EB_QUESTION_JB_REASON"; // 回复意见  public static final String COL_ND = "ZC_EB_QUESTION_ND"; // 年度  public static final String COL_ORG_CODE = "ZC_EB_QUESTION_ORG_CODE"; // 招标负责部门  public static final String COL_PERSON = "ZC_EB_QUESTION_PERSON"; // 供应商联系人  public static final String COL_PERSONORG = "ZC_EB_QUESTION_PERSONORG"; // 供应商名称  public static final String COL_PERSON_TEL = "ZC_EB_QUESTION_PERSON_TEL"; // 供应商电话  public static final String COL_PROCESS_INST_ID = "ZC_EB_QUESTION_PROCESS_INST_ID"; // PROCESS_INST_ID  public static final String COL_PROJ = "ZC_EB_QUESTION_PROJ"; // 项目代码  public static final String COL_QUES_ID = "ZC_EB_QUESTION_QUES_ID"; // 质疑ID  public static final String COL_QUES_TYPE = "ZC_EB_QUESTION_QUES_TYPE"; // 质疑类型  public static final String COL_SENUSER = "ZC_EB_QUESTION_SENUSER"; // SENUSER  public static final String COL_STATE = "ZC_EB_QUESTION_STATE"; // 审批状态  public static final String COL_TEMP = "ZC_EB_QUESTION_TEMP"; // 采购单位意见  public static final String COL_TEMP1 = "ZC_EB_QUESTION_TEMP1"; // TEMP1  public static final String COL_TEMP2 = "ZC_EB_QUESTION_TEMP2"; // TEMP2  public static final String COL_TEMP3 = "ZC_EB_QUESTION_TEMP3"; // 质疑录入人id  private ZcEbProj zcEbProj = new ZcEbProj();  /**   * 质疑/投诉人员单位   */  private String personOrg;  /**   * 质疑人员/投诉人员姓名   */  private String personName;  /**   * 电话   */  private String personTel;  /**   * 创建日期   */  private Date createDate;  /**   * 质疑提交日期   */  private Date clientSubmitZYDate;  private String clientReason;  private String clientFileName;  private String jbPerson;  private String jbReason;  private String jbFileName;  private Date jbDoDate;  private List listPack;  private String temp1;  private String temp2;  private String temp3;  private String temp;  public ZcEbProj getZcEbProj() {    return zcEbProj;  }  public void setZcEbProj(ZcEbProj zcEbProj) {    this.zcEbProj = zcEbProj;  }  public String getPersonOrg() {    return personOrg;  }  public void setPersonOrg(String personOrg) {    this.personOrg = personOrg;  }  public String getPersonName() {    return personName;  }  public void setPersonName(String personName) {    this.personName = personName;  }  public String getPersonTel() {    return personTel;  }  public void setPersonTel(String personTel) {    this.personTel = personTel;  }  public Date getCreateDate() {    return createDate;  }  public void setCreateDate(Date createDate) {    this.createDate = createDate;  }  public Date getClientSubmitZYDate() {    return clientSubmitZYDate;  }  public void setClientSubmitZYDate(Date clientSubmitZYDate) {    this.clientSubmitZYDate = clientSubmitZYDate;  }  public String getClientReason() {    return clientReason;  }  public void setClientReason(String clientReason) {    this.clientReason = clientReason;  }  public String getClientFileName() {    return clientFileName;  }  public void setClientFileName(String clientFileName) {    this.clientFileName = clientFileName;  }  public String getJbPerson() {    return jbPerson;  }  public void setJbPerson(String jbPerson) {    this.jbPerson = jbPerson;  }  public String getJbReason() {    return jbReason;  }  public void setJbReason(String jbReason) {    this.jbReason = jbReason;  }  public String getJbFileName() {    return jbFileName;  }  public void setJbFileName(String jbFileName) {    this.jbFileName = jbFileName;  }  public Date getJbDoDate() {    return jbDoDate;  }  public void setJbDoDate(Date jbDoDate) {    this.jbDoDate = jbDoDate;  }  public List getListPack() {    return listPack;  }  public void setListPack(List listPack) {    this.listPack = listPack;  }  public String getTemp1() {    return temp1;  }  public void setTemp1(String temp1) {    this.temp1 = temp1;  }  public String getTemp2() {    return temp2;  }  public void setTemp2(String temp2) {    this.temp2 = temp2;  }  public String getTemp3() {    return temp3;  }  public void setTemp3(String temp3) {    this.temp3 = temp3;  }  public String getTemp() {    return temp;  }  public void setTemp(String temp) {    this.temp = temp;  }}