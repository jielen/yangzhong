package com.ufgov.zc.common.zc.model;

import java.math.BigDecimal;

public class ZcEbChangdi extends ZcBaseBill {
  /**
   * 
   */
  private static final long serialVersionUID = -8580040571929437727L;

  public static final String TAB_ID = "ZC_EB_CHANGDI_Tab";

  public static final String V_ZC_EB_CHANGDI_STATUS = "V_ZC_EB_CHANGDI_STATUS";

  /**
   * 停用
   */
  public static final String V_ZC_EB_CHANGDI_STATUS_DISABLE = "disable";

  /**
   * 启用
   */
  public static final String V_ZC_EB_CHANGDI_STATUS_ENABLE = "enable";

  public static final String COL_ADDRESS = "ZC_EB_CHANGDI_ADDRESS"; // 地点位置

  public static final String COL_AREA = "ZC_EB_CHANGDI_AREA"; // 场地面积

  public static final String COL_CHANGDIGUID = "ZC_EB_CHANGDI_CHANGDIGUID"; // 场地唯一ID

  public static final String COL_CHANGDINAME = "ZC_EB_CHANGDI_CHANGDINAME"; // 场地名称

  public static final String COL_CHANGDITYPE = "ZC_EB_CHANGDI_CHANGDITYPE"; // 场地类型

  public static final String COL_COMPUTERNUM = "ZC_EB_CHANGDI_COMPUTERNUM"; // 电脑数量

  public static final String COL_DIANZIBAIBANNUM = "ZC_EB_CHANGDI_DIANZIBAIBANNUM"; // 电子白板

  public static final String COL_ISONLINEPINGBIAO = "ZC_EB_CHANGDI_ISONLINEPINGBIAO"; // 支持电子开评标

  public static final String COL_ORGCODE = "ZC_EB_CHANGDI_ORGCODE"; // 所属部门

  public static final String COL_REMARK = "ZC_EB_CHANGDI_REMARK"; // 备注

  public static final String COL_RONGNAIRENSHU = "ZC_EB_CHANGDI_RONGNAIRENSHU"; // 容纳人数

  public static final String COL_SCALE = "ZC_EB_CHANGDI_SCALE"; // 规模

  public static final String COL_TOUYINGYINUM = "ZC_EB_CHANGDI_TOUYINGYINUM"; // 投影仪

  public static final String COL_WIREDMICROPHONENUM = "ZC_EB_CHANGDI_WIREDMICROPHONENUM"; // 有线麦克风

  public static final String COL_WIRELESSMICROPHONENUM = "ZC_EB_CHANGDI_WIRELESSMICROPHONENUM"; // 无线麦克风

  public static final String COL_STATUS = "ZC_EB_CHANGDI_STATUS"; // 是否启用

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.CHANGDIGUID
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String changdiguid;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.CHANGDINAME
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String changdiname;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.RONGNAIRENSHU
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private Integer rongnairenshu;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.COMPUTERNUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private Integer computernum;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.TOUYINGYINUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private Integer touyingyinum;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.DIANZIBAIBANNUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private Integer dianzibaibannum;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.WIREDMICROPHONENUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private Integer wiredmicrophonenum;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.WIRELESSMICROPHONENUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private Integer wirelessmicrophonenum;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.ORGCODE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String orgcode;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.CHANGDITYPE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String changditype;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.SCALE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String scale;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.AREA
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private BigDecimal area;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.ADDRESS
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String address;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.REMARK
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String remark;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.ISONLINEPINGBIAO
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String isonlinepingbiao;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI.STATUS
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  private String status;

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.CHANGDIGUID
   * @return the value of ZC_EB_CHANGDI.CHANGDIGUID
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getChangdiguid() {
    return changdiguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.CHANGDIGUID
   * @param changdiguid the value for ZC_EB_CHANGDI.CHANGDIGUID
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setChangdiguid(String changdiguid) {
    this.changdiguid = changdiguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.CHANGDINAME
   * @return the value of ZC_EB_CHANGDI.CHANGDINAME
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getChangdiname() {
    return changdiname;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.CHANGDINAME
   * @param changdiname the value for ZC_EB_CHANGDI.CHANGDINAME
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setChangdiname(String changdiname) {
    this.changdiname = changdiname;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.RONGNAIRENSHU
   * @return the value of ZC_EB_CHANGDI.RONGNAIRENSHU
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public Integer getRongnairenshu() {
    return rongnairenshu;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.RONGNAIRENSHU
   * @param rongnairenshu the value for ZC_EB_CHANGDI.RONGNAIRENSHU
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setRongnairenshu(Integer rongnairenshu) {
    this.rongnairenshu = rongnairenshu;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.COMPUTERNUM
   * @return the value of ZC_EB_CHANGDI.COMPUTERNUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public Integer getComputernum() {
    return computernum;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.COMPUTERNUM
   * @param computernum the value for ZC_EB_CHANGDI.COMPUTERNUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setComputernum(Integer computernum) {
    this.computernum = computernum;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.TOUYINGYINUM
   * @return the value of ZC_EB_CHANGDI.TOUYINGYINUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public Integer getTouyingyinum() {
    return touyingyinum;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.TOUYINGYINUM
   * @param touyingyinum the value for ZC_EB_CHANGDI.TOUYINGYINUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setTouyingyinum(Integer touyingyinum) {
    this.touyingyinum = touyingyinum;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.DIANZIBAIBANNUM
   * @return the value of ZC_EB_CHANGDI.DIANZIBAIBANNUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public Integer getDianzibaibannum() {
    return dianzibaibannum;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.DIANZIBAIBANNUM
   * @param dianzibaibannum the value for ZC_EB_CHANGDI.DIANZIBAIBANNUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setDianzibaibannum(Integer dianzibaibannum) {
    this.dianzibaibannum = dianzibaibannum;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.WIREDMICROPHONENUM
   * @return the value of ZC_EB_CHANGDI.WIREDMICROPHONENUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public Integer getWiredmicrophonenum() {
    return wiredmicrophonenum;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.WIREDMICROPHONENUM
   * @param wiredmicrophonenum the value for ZC_EB_CHANGDI.WIREDMICROPHONENUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setWiredmicrophonenum(Integer wiredmicrophonenum) {
    this.wiredmicrophonenum = wiredmicrophonenum;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.WIRELESSMICROPHONENUM
   * @return the value of ZC_EB_CHANGDI.WIRELESSMICROPHONENUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public Integer getWirelessmicrophonenum() {
    return wirelessmicrophonenum;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.WIRELESSMICROPHONENUM
   * @param wirelessmicrophonenum the value for
   *          ZC_EB_CHANGDI.WIRELESSMICROPHONENUM
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setWirelessmicrophonenum(Integer wirelessmicrophonenum) {
    this.wirelessmicrophonenum = wirelessmicrophonenum;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.ORGCODE
   * @return the value of ZC_EB_CHANGDI.ORGCODE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getOrgcode() {
    return orgcode;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.ORGCODE
   * @param orgcode the value for ZC_EB_CHANGDI.ORGCODE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setOrgcode(String orgcode) {
    this.orgcode = orgcode;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.CHANGDITYPE
   * @return the value of ZC_EB_CHANGDI.CHANGDITYPE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getChangditype() {
    return changditype;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.CHANGDITYPE
   * @param changditype the value for ZC_EB_CHANGDI.CHANGDITYPE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setChangditype(String changditype) {
    this.changditype = changditype;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.SCALE
   * @return the value of ZC_EB_CHANGDI.SCALE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getScale() {
    return scale;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.SCALE
   * @param scale the value for ZC_EB_CHANGDI.SCALE
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setScale(String scale) {
    this.scale = scale;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.AREA
   * @return the value of ZC_EB_CHANGDI.AREA
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public BigDecimal getArea() {
    return area;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.AREA
   * @param area the value for ZC_EB_CHANGDI.AREA
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setArea(BigDecimal area) {
    this.area = area;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.ADDRESS
   * @return the value of ZC_EB_CHANGDI.ADDRESS
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getAddress() {
    return address;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.ADDRESS
   * @param address the value for ZC_EB_CHANGDI.ADDRESS
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.REMARK
   * @return the value of ZC_EB_CHANGDI.REMARK
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getRemark() {
    return remark;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.REMARK
   * @param remark the value for ZC_EB_CHANGDI.REMARK
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setRemark(String remark) {
    this.remark = remark;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.ISONLINEPINGBIAO
   * @return the value of ZC_EB_CHANGDI.ISONLINEPINGBIAO
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getIsonlinepingbiao() {
    return isonlinepingbiao;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.ISONLINEPINGBIAO
   * @param isonlinepingbiao the value for ZC_EB_CHANGDI.ISONLINEPINGBIAO
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setIsonlinepingbiao(String isonlinepingbiao) {
    this.isonlinepingbiao = isonlinepingbiao;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI.STATUS
   * @return the value of ZC_EB_CHANGDI.STATUS
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public String getStatus() {
    return status;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI.STATUS
   * @param status the value for ZC_EB_CHANGDI.STATUS
   * @mbggenerated Fri Nov 20 01:14:19 CST 2015
   */
  public void setStatus(String status) {
    this.status = status;
  }
}