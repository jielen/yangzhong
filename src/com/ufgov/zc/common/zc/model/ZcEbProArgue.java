package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.util.Date;import java.util.List;import com.ufgov.zc.common.commonbiz.model.WfAware;public class ZcEbProArgue extends ZcBaseBill implements Serializable, WfAware {  /**   *    */  private static final long serialVersionUID = 2903295981740484885L;  private String argueId;  private String proCode;  private String proName;  private String proOrg;  private String leader;  private Date argueTime;  private String argueAddress;  private String argueOpinions;  private String argueAccessoriesName;  private String argueAccessoriesBlobid;  private String memo;  private List detail;  private boolean newAdd;  private String auditorId;  private String titleField;  private String status;  private String orgPersons;  private String agencyPersons;  private String orgOpinions;  public String getStatus() {    return status;  }  public void setStatus(String status) {    this.status = status;  }  public String getProCode() {    return proCode;  }  public void setProCode(String proCode) {    this.proCode = proCode;  }  public String getProName() {    return proName;  }  public void setProName(String proName) {    this.proName = proName;  }  public String getProOrg() {    return proOrg;  }  public void setProOrg(String proOrg) {    this.proOrg = proOrg;  }  public String getLeader() {    return leader;  }  public void setLeader(String leader) {    this.leader = leader;  }  public Date getArgueTime() {    return argueTime;  }  public void setArgueTime(Date argueTime) {    this.argueTime = argueTime;  }  public String getArgueAddress() {    return argueAddress;  }  public void setArgueAddress(String argueAddress) {    this.argueAddress = argueAddress;  }  public String getArgueOpinions() {    return argueOpinions;  }  public void setArgueOpinions(String argueOpinions) {    this.argueOpinions = argueOpinions;  }  public String getArgueAccessoriesName() {    return argueAccessoriesName;  }  public void setArgueAccessoriesName(String argueAccessoriesName) {    this.argueAccessoriesName = argueAccessoriesName;  }  public String getArgueAccessoriesBlobid() {    return argueAccessoriesBlobid;  }  public void setArgueAccessoriesBlobid(String argueAccessoriesBlobid) {    this.argueAccessoriesBlobid = argueAccessoriesBlobid;  }  public String getMemo() {    return memo;  }  public void setMemo(String memo) {    this.memo = memo;  }  public List getDetail() {    return detail;  }  public void setDetail(List detail) {    this.detail = detail;  }  public boolean isNewAdd() {    return newAdd;  }  public void setNewAdd(boolean newAdd) {    this.newAdd = newAdd;  }  public String getAuditorId() {    return auditorId;  }  public void setAuditorId(String auditorId) {    this.auditorId = auditorId;  }  public String getTitleField() {    return titleField;  }  public void setTitleField(String titleField) {    this.titleField = titleField;  }  public String getArgueId() {    return argueId;  }  public void setArgueId(String argueId) {    this.argueId = argueId;  }  public String getOrgPersons() {    return orgPersons;  }  public void setOrgPersons(String orgPersons) {    this.orgPersons = orgPersons;  }  public String getAgencyPersons() {    return agencyPersons;  }  public void setAgencyPersons(String agencyPersons) {    this.agencyPersons = agencyPersons;  }  public String getOrgOpinions() {    return orgOpinions;  }  public void setOrgOpinions(String orgOpinions) {    this.orgOpinions = orgOpinions;  }}