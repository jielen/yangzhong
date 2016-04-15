package com.ufgov.zc.common.zc.model;

import java.util.Date;

public class ZcEbChangdiUsed extends ZcBaseBill {
  /**
   * 
   */
  private static final long serialVersionUID = 2180868643479272281L;

  public static final String TAB_ID = "ZC_EB_CHANGDI_USED_Tab";

  public static final String V_ZC_CHANGDI_USED_USEDTYPE = "V_ZC_CHANGDI_USED_USEDTYPE";

  public static final String V_ZC_CHANGDI_USED_USEDTYPE_KAI_BIAO = "1";

  public static final String V_ZC_CHANGDI_USED_USEDTYPE_PING_BIAO = "2";

  public static final String V_ZC_CHANGDI_USED_USEDTYPE_DA_YI = "3";

  public static final String V_ZC_CHANGDI_USED_USEDTYPE_MEETING = "4";

  public static final String V_ZC_CHANGDI_USED_USEDTYPE_OTHER = "99";

  public static final String COL_CHANGDIGUID = "ZC_EB_CHANGDI_USED_CHANGDIGUID"; // 场地唯一ID

  public static final String COL_CHANGDIUSEDID = "ZC_EB_CHANGDI_USED_CHANGDIUSEDID"; // 场地使用情况唯一ID

  public static final String COL_ENDDATE = "ZC_EB_CHANGDI_USED_ENDDATE"; // 结束时间

  public static final String COL_ND = "ZC_EB_CHANGDI_USED_ND"; // 年度

  public static final String COL_REQUESTGUID = "ZC_EB_CHANGDI_USED_REQUESTGUID"; // 场地申请唯一ID

  public static final String COL_REQUESTPEOPLE = "ZC_EB_CHANGDI_USED_REQUESTPEOPLE"; // 使用人

  public static final String COL_REQUESTPEOPLEGUID = "ZC_EB_CHANGDI_USED_REQUESTPEOPLEGUID"; // 使用人ID

  public static final String COL_REQUESTUNIT = "ZC_EB_CHANGDI_USED_REQUESTUNIT"; // 使用单位

  public static final String COL_REQUESTUNITGUID = "ZC_EB_CHANGDI_USED_REQUESTUNITGUID"; // 使用单位ID

  public static final String COL_STARTDATE = "ZC_EB_CHANGDI_USED_STARTDATE"; // 开始时间

  public static final String COL_USEDCONTENT = "ZC_EB_CHANGDI_USED_USEDCONTENT"; // 使用内容

  public static final String COL_USEDTYPE = "ZC_EB_CHANGDI_USED_USEDTYPE"; // 使用类型

  public static final String COL_CHANGDINAME = "ZC_EB_CHANGDI_USED_CHANGDINAME"; // 场地名称

  public static final String COL_PROJCODE = "ZC_EB_CHANGDI_USED_PROJCODE"; // 招标编号

  public static final String COL_PROJNAME = "ZC_EB_CHANGDI_USED_PROJNAME"; // 招标名称

  public static final String COL_PLANCODE = "ZC_EB_CHANGDI_USED_PLANCODE"; // 招标执行计划ID

  private ZcEbChangdi changdi = new ZcEbChangdi();

  private String projcode;

  private String projname;

  private String plancode;

  private String changdiname;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.CHANGDIUSEDID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String changdiusedid;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.REQUESTGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String requestguid;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.CHANGDIGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String changdiguid;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.USEDCONTENT
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String usedcontent;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.STARTDATE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private Date startdate;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.ENDDATE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private Date enddate;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.REQUESTPEOPLE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String requestpeople;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.USEDTYPE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String usedtype;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.REQUESTUNIT
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String requestunit;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.REQUESTPEOPLEGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String requestpeopleguid;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to
   * the database column ZC_EB_CHANGDI_USED.REQUESTUNITGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  private String requestunitguid;

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.CHANGDIUSEDID
   * @return the value of ZC_EB_CHANGDI_USED.CHANGDIUSEDID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getChangdiusedid() {
    return changdiusedid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.CHANGDIUSEDID
   * @param changdiusedid the value for ZC_EB_CHANGDI_USED.CHANGDIUSEDID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setChangdiusedid(String changdiusedid) {
    this.changdiusedid = changdiusedid;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.REQUESTGUID
   * @return the value of ZC_EB_CHANGDI_USED.REQUESTGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getRequestguid() {
    return requestguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.REQUESTGUID
   * @param requestguid the value for ZC_EB_CHANGDI_USED.REQUESTGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setRequestguid(String requestguid) {
    this.requestguid = requestguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.CHANGDIGUID
   * @return the value of ZC_EB_CHANGDI_USED.CHANGDIGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getChangdiguid() {
    return changdiguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.CHANGDIGUID
   * @param changdiguid the value for ZC_EB_CHANGDI_USED.CHANGDIGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setChangdiguid(String changdiguid) {
    this.changdiguid = changdiguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.USEDCONTENT
   * @return the value of ZC_EB_CHANGDI_USED.USEDCONTENT
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getUsedcontent() {
    return usedcontent;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.USEDCONTENT
   * @param usedcontent the value for ZC_EB_CHANGDI_USED.USEDCONTENT
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setUsedcontent(String usedcontent) {
    this.usedcontent = usedcontent;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.STARTDATE
   * @return the value of ZC_EB_CHANGDI_USED.STARTDATE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public Date getStartdate() {
    return startdate;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.STARTDATE
   * @param startdate the value for ZC_EB_CHANGDI_USED.STARTDATE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setStartdate(Date startdate) {
    this.startdate = startdate;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.ENDDATE
   * @return the value of ZC_EB_CHANGDI_USED.ENDDATE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public Date getEnddate() {
    return enddate;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.ENDDATE
   * @param enddate the value for ZC_EB_CHANGDI_USED.ENDDATE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setEnddate(Date enddate) {
    this.enddate = enddate;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.REQUESTPEOPLE
   * @return the value of ZC_EB_CHANGDI_USED.REQUESTPEOPLE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getRequestpeople() {
    return requestpeople;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.REQUESTPEOPLE
   * @param requestpeople the value for ZC_EB_CHANGDI_USED.REQUESTPEOPLE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setRequestpeople(String requestpeople) {
    this.requestpeople = requestpeople;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.USEDTYPE
   * @return the value of ZC_EB_CHANGDI_USED.USEDTYPE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getUsedtype() {
    return usedtype;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.USEDTYPE
   * @param usedtype the value for ZC_EB_CHANGDI_USED.USEDTYPE
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setUsedtype(String usedtype) {
    this.usedtype = usedtype;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.REQUESTUNIT
   * @return the value of ZC_EB_CHANGDI_USED.REQUESTUNIT
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getRequestunit() {
    return requestunit;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.REQUESTUNIT
   * @param requestunit the value for ZC_EB_CHANGDI_USED.REQUESTUNIT
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setRequestunit(String requestunit) {
    this.requestunit = requestunit;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.REQUESTPEOPLEGUID
   * @return the value of ZC_EB_CHANGDI_USED.REQUESTPEOPLEGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getRequestpeopleguid() {
    return requestpeopleguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.REQUESTPEOPLEGUID
   * @param requestpeopleguid the value for ZC_EB_CHANGDI_USED.REQUESTPEOPLEGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setRequestpeopleguid(String requestpeopleguid) {
    this.requestpeopleguid = requestpeopleguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the
   * value of the database column ZC_EB_CHANGDI_USED.REQUESTUNITGUID
   * @return the value of ZC_EB_CHANGDI_USED.REQUESTUNITGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public String getRequestunitguid() {
    return requestunitguid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value
   * of the database column ZC_EB_CHANGDI_USED.REQUESTUNITGUID
   * @param requestunitguid the value for ZC_EB_CHANGDI_USED.REQUESTUNITGUID
   * @mbggenerated Fri Nov 20 03:51:34 CST 2015
   */
  public void setRequestunitguid(String requestunitguid) {
    this.requestunitguid = requestunitguid;
  }

  public ZcEbChangdi getChangdi() {
    return changdi;
  }

  public void setChangdi(ZcEbChangdi changdi) {
    this.changdi = changdi;
  }

  public String getChangdiname() {
    return changdiname;
  }

  public void setChangdiname(String changdiname) {
    this.changdiname = changdiname;
  }

  public String getProjcode() {
    return projcode;
  }

  public void setProjcode(String projcode) {
    this.projcode = projcode;
  }

  public String getProjname() {
    return projname;
  }

  public void setProjname(String projname) {
    this.projname = projname;
  }

  public String getPlancode() {
    return plancode;
  }

  public void setPlancode(String plancode) {
    this.plancode = plancode;
  }
}