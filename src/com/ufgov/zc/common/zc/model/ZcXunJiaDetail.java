package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.math.BigDecimal;import java.util.Date;public class ZcXunJiaDetail extends ZcBaseBill implements Serializable {  private static final long serialVersionUID = 319988237219792068L;  private String xjCode;  private BigDecimal spPrice;  private String spName;  private int spNum;  private BigDecimal spTotalSum;  private String haveXianHuo;  private Date gongHuoDate;  private String bjDetailCode;  private String remark;  private String projCode;  private String packCode;  private String providerCode;  private String providerName;  //是否成交  private String isClosedDeal;  //单位  private String unit;  private String tempId;  private String tech;  public String getTempId() {    return tempId;  }  public void setTempId(String tempId) {    this.tempId = tempId;  }  public String getXjCode() {    return xjCode;  }  public void setXjCode(String xjCode) {    this.xjCode = xjCode;  }  public BigDecimal getSpPrice() {    return spPrice;  }  public void setSpPrice(BigDecimal spPrice) {    this.spPrice = spPrice;  }  public String getSpName() {    return spName;  }  public void setSpName(String spName) {    this.spName = spName;  }  public int getSpNum() {    return spNum;  }  public void setSpNum(int spNum) {    this.spNum = spNum;  }  public BigDecimal getSpTotalSum() {    return spTotalSum;  }  public void setSpTotalSum(BigDecimal spTotalSum) {    this.spTotalSum = spTotalSum;  }  public String getHaveXianHuo() {    return haveXianHuo;  }  public void setHaveXianHuo(String haveXianHuo) {    this.haveXianHuo = haveXianHuo;  }  public Date getGongHuoDate() {    return gongHuoDate;  }  public void setGongHuoDate(Date gongHuoDate) {    this.gongHuoDate = gongHuoDate;  }  public String getBjDetailCode() {    return bjDetailCode;  }  public void setBjDetailCode(String bjDetailCode) {    this.bjDetailCode = bjDetailCode;  }  public String getRemark() {    return remark;  }  public void setRemark(String remark) {    this.remark = remark;  }  public String getProjCode() {    return projCode;  }  public void setProjCode(String projCode) {    this.projCode = projCode;  }  public String getPackCode() {    return packCode;  }  public void setPackCode(String packCode) {    this.packCode = packCode;  }  public String getProviderCode() {    return providerCode;  }  public void setProviderCode(String providerCode) {    this.providerCode = providerCode;  }  public String getProviderName() {    return providerName;  }  public void setProviderName(String providerName) {    this.providerName = providerName;  }  public String getIsClosedDeal() {    return isClosedDeal;  }  public void setIsClosedDeal(String isClosedDeal) {    this.isClosedDeal = isClosedDeal;  }  public String getUnit() {    return unit;  }  public void setUnit(String unit) {    this.unit = unit;  }  public String getTech() {    return tech;  }  public void setTech(String tech) {    this.tech = tech;  }}