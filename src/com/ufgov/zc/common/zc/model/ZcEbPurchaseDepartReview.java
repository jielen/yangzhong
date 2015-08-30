package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.util.Date;import java.util.List;import com.ufgov.zc.common.commonbiz.model.WfAware;public class ZcEbPurchaseDepartReview extends ZcBaseBill implements Serializable, WfAware {  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_ID   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String reviewId;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String reviewCode;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String projCode;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String projName;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.STATUS   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String status;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String zcCoCode;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String zcCoName;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_DATE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private Date editDate;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_ID   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String editUserId;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String editUserName;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.MEMO   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String memo;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PHONE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String zcCoPhone;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PERSON   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String zcCoPerson;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_LEADER   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String projLeader;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String proxyDepartName;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PERSON   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String proxyDepartPerson;  /**   * This field was generated by Abator for iBATIS.   * This field corresponds to the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PHONE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  private String proxyDepartPhone;  private List detail;  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_ID   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_ID   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getReviewId() {    return reviewId;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_ID   *   * @param reviewId the value for ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_ID   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setReviewId(String reviewId) {    this.reviewId = reviewId;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_CODE   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getReviewCode() {    return reviewCode;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_CODE   *   * @param reviewCode the value for ZC_EB_PURCHASE_DEPART_REVIEW.REVIEW_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setReviewCode(String reviewCode) {    this.reviewCode = reviewCode;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_CODE   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getProjCode() {    return projCode;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_CODE   *   * @param projCode the value for ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setProjCode(String projCode) {    this.projCode = projCode;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_NAME   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getProjName() {    return projName;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_NAME   *   * @param projName the value for ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setProjName(String projName) {    this.projName = projName;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.STATUS   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.STATUS   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getStatus() {    return status;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.STATUS   *   * @param status the value for ZC_EB_PURCHASE_DEPART_REVIEW.STATUS   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setStatus(String status) {    this.status = status;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_CODE   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getZcCoCode() {    return zcCoCode;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_CODE   *   * @param zcCoCode the value for ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_CODE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setZcCoCode(String zcCoCode) {    this.zcCoCode = zcCoCode;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_NAME   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getZcCoName() {    return zcCoName;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_NAME   *   * @param zcCoName the value for ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setZcCoName(String zcCoName) {    this.zcCoName = zcCoName;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_DATE   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_DATE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public Date getEditDate() {    return editDate;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_DATE   *   * @param editDate the value for ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_DATE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setEditDate(Date editDate) {    this.editDate = editDate;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_ID   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_ID   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getEditUserId() {    return editUserId;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_ID   *   * @param editUserId the value for ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_ID   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setEditUserId(String editUserId) {    this.editUserId = editUserId;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_NAME   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getEditUserName() {    return editUserName;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_NAME   *   * @param editUserName the value for ZC_EB_PURCHASE_DEPART_REVIEW.EDIT_USER_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setEditUserName(String editUserName) {    this.editUserName = editUserName;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.MEMO   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.MEMO   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getMemo() {    return memo;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.MEMO   *   * @param memo the value for ZC_EB_PURCHASE_DEPART_REVIEW.MEMO   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setMemo(String memo) {    this.memo = memo;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PHONE   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PHONE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getZcCoPhone() {    return zcCoPhone;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PHONE   *   * @param zcCoPhone the value for ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PHONE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setZcCoPhone(String zcCoPhone) {    this.zcCoPhone = zcCoPhone;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PERSON   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PERSON   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getZcCoPerson() {    return zcCoPerson;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PERSON   *   * @param zcCoPerson the value for ZC_EB_PURCHASE_DEPART_REVIEW.ZC_CO_PERSON   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setZcCoPerson(String zcCoPerson) {    this.zcCoPerson = zcCoPerson;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_LEADER   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_LEADER   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getProjLeader() {    return projLeader;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_LEADER   *   * @param projLeader the value for ZC_EB_PURCHASE_DEPART_REVIEW.PROJ_LEADER   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setProjLeader(String projLeader) {    this.projLeader = projLeader;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_NAME   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getProxyDepartName() {    return proxyDepartName;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_NAME   *   * @param proxyDepartName the value for ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_NAME   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setProxyDepartName(String proxyDepartName) {    this.proxyDepartName = proxyDepartName;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PERSON   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PERSON   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getProxyDepartPerson() {    return proxyDepartPerson;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PERSON   *   * @param proxyDepartPerson the value for ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PERSON   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setProxyDepartPerson(String proxyDepartPerson) {    this.proxyDepartPerson = proxyDepartPerson;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PHONE   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PHONE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public String getProxyDepartPhone() {    return proxyDepartPhone;  }  /**   * This method was generated by Abator for iBATIS.   * This method sets the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PHONE   *   * @param proxyDepartPhone the value for ZC_EB_PURCHASE_DEPART_REVIEW.PROXY_DEPART_PHONE   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */  public void setProxyDepartPhone(String proxyDepartPhone) {    this.proxyDepartPhone = proxyDepartPhone;  }  public List getDetail() {    return detail;  }  public void setDetail(List detail) {    this.detail = detail;  }  /**   * This method was generated by Abator for iBATIS.   * This method returns the value of the database column ZC_EB_PURCHASE_DEPART_REVIEW.PROCESS_INST_ID   *   * @return the value of ZC_EB_PURCHASE_DEPART_REVIEW.PROCESS_INST_ID   *   * @abatorgenerated Mon Jul 18 15:18:42 CST 2011   */}