package com.ufgov.zc.client.zc.ztb.model;import java.math.BigDecimal;public class ProjectBag {  private String id;  private String no;  private String name;  private String packDesc;  private String type;  private String item;  private BigDecimal bidSum;  public String getId() {    return id;  }  public void setId(String id) {    this.id = id;  }  public String getNo() {    return no;  }  public void setNo(String no) {    this.no = no;  }  public String getName() {    if (name == null) {      name = "";    }    return name;  }  public void setName(String name) {    this.name = name;  }  public String getPackDesc() {    if (this.packDesc == null) {      this.packDesc = "";    }    return packDesc;  }  public void setPackDesc(String packDesc) {    this.packDesc = packDesc;  }  public String getType() {    return type;  }  public void setType(String type) {    this.type = type;  }  public String getItem() {    return item;  }  public void setItem(String item) {    this.item = item;  }  public void setBidSum(BigDecimal bidSum) {    this.bidSum = bidSum;  }  public BigDecimal getBidSum() {    return bidSum;  }}