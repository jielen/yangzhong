package com.ufgov.zc.common.bi.model;import java.io.Serializable;import java.math.BigDecimal;import com.ufgov.zc.common.commonbiz.model.BaseBill;import com.ufgov.zc.common.commonbiz.model.BiBalance;import com.ufgov.zc.common.system.util.BeanUtil;public class BcDetail extends BaseBill implements Serializable {  private static final long serialVersionUID = 1L;  private String bcDetailId;  private BigDecimal amMoney = new BigDecimal("0");//拨款金额  private BigDecimal coSelfMoney = new BigDecimal("0");//单位自筹  private BigDecimal bankLoanMoney = new BigDecimal("0");//银行贷款  private BigDecimal useMoney = new BigDecimal("0");//已用金额  private String other;//其他  private String fundAttribute;//资金属性  private String fundAttributeName;  private String kind;//种类  private String kindName;  private String ndrcSenddocCode;//国家发改委文件号  private String ndrcSenddocCodeName;  private String armySenddocCode;//兵团发改委文号  private String armySenddocCodeName;  private BiBalance biBalance;//指标项  private BigDecimal currentMoney;  private BigDecimal balanceMoney;  private String isAppropriate;  private BigDecimal tag = new BigDecimal(0);  private String isForArm = null;  /**   * @return the currentMoney   */  public BigDecimal getCurrentMoney() {    //    if (this.currentMoney == null) {    //      return this.getBalanceMoney();    //    }    return currentMoney;  }  public double getCurrentMoneyDoubleValue() {    return this.getCurrentMoney().doubleValue();  }  /**   * @param currentMoney the currentMoney to set   */  public void setCurrentMoney(BigDecimal currentMoney) {    this.currentMoney = currentMoney;  }  public BigDecimal getAmMoney() {    return amMoney;  }  public void setAmMoney(BigDecimal amMoney) {    this.amMoney = amMoney;  }  public String getArmySenddocCode() {    return armySenddocCode;  }  public void setArmySenddocCode(String armySenddocCode) {    this.armySenddocCode = armySenddocCode;  }  public BigDecimal getBankLoanMoney() {    return bankLoanMoney;  }  public void setBankLoanMoney(BigDecimal bankLoanMoney) {    this.bankLoanMoney = bankLoanMoney;  }  public String getBcDetailId() {    return bcDetailId;  }  public void setBcDetailId(String bcDetailId) {    this.id = bcDetailId;    this.bcDetailId = bcDetailId;  }  public BigDecimal getCoSelfMoney() {    return coSelfMoney;  }  public void setCoSelfMoney(BigDecimal coSelfMoney) {    this.coSelfMoney = coSelfMoney;  }  public String getFundAttribute() {    return fundAttribute;  }  public void setFundAttribute(String fundAttribute) {    this.fundAttribute = fundAttribute;  }  public String getKind() {    return kind;  }  public void setKind(String kind) {    this.kind = kind;  }  public String getNdrcSenddocCode() {    return ndrcSenddocCode;  }  public void setNdrcSenddocCode(String ndrcSenddocCode) {    this.ndrcSenddocCode = ndrcSenddocCode;  }  public String getOther() {    return other;  }  public void setOther(String other) {    this.other = other;  }  public BigDecimal getUseMoney() {    return useMoney;  }  public void setUseMoney(BigDecimal useMoney) {    this.useMoney = useMoney;  }  /**   * @return the biBalance   */  public BiBalance getBiBalance() {    return biBalance;  }  /**   * @param biBalance the biBalance to set   */  public void setBiBalance(BiBalance biBalance) {    this.biBalance = biBalance;  }  public Object get(String name) {    return BeanUtil.get(name, this);  }  public void set(String name, Object value) {    BeanUtil.set(name, value, this);  }  public BigDecimal getBalanceMoney() {    if (this.balanceMoney == null) {      return amMoney.subtract(this.useMoney);    }    return balanceMoney;  }  public String getIsAppropriate() {    return isAppropriate;  }  public void setIsAppropriate(String isAppropriate) {    this.isAppropriate = isAppropriate;  }  public BigDecimal getTag() {    return tag;  }  public void setTag(BigDecimal tag) {    this.tag = tag;  }  public String getIsForArm() {    return isForArm;  }  public void setIsForArm(String isForArm) {    this.isForArm = isForArm;  }  public String getKindName() {    return kindName;  }  public void setKindName(String kindName) {    this.kindName = kindName;  }  public String getFundAttributeName() {    return fundAttributeName;  }  public void setFundAttributeName(String fundAttributeName) {    this.fundAttributeName = fundAttributeName;  }  public String getNdrcSenddocCodeName() {    return ndrcSenddocCodeName;  }  public void setNdrcSenddocCodeName(String ndrcSenddocCodeName) {    this.ndrcSenddocCodeName = ndrcSenddocCodeName;  }  public String getArmySenddocCodeName() {    return armySenddocCodeName;  }  public void setArmySenddocCodeName(String armySenddocCodeName) {    this.armySenddocCodeName = armySenddocCodeName;  }}