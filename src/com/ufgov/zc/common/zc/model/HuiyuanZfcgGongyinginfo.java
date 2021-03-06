package com.ufgov.zc.common.zc.model;

public class HuiyuanZfcgGongyinginfo extends ZcBaseBill {
    /**
   * 
   */
  private static final long serialVersionUID = -622252298431457028L;
  
  public static final String TAB_ID="HUIYUAN_ZFCG_GONGYINGINFO_Tab";
  
  
  public static final String COL_ACCOUNT="HUIYUAN_ZFCG_GONGYINGINFO_ACCOUNT"; // 开户帐号
  public static final String COL_AUDITSTATUS="HUIYUAN_ZFCG_GONGYINGINFO_AUDITSTATUS"; // 审核状态
  public static final String COL_BANK="HUIYUAN_ZFCG_GONGYINGINFO_BANK"; // 开户银行
  public static final String COL_DANWEIGUID="HUIYUAN_ZFCG_GONGYINGINFO_DANWEIGUID"; // 单位唯一标识
  public static final String COL_GONGYINGSHANGTYPE="HUIYUAN_ZFCG_GONGYINGINFO_GONGYINGSHANGTYPE"; // 供应商类别
  public static final String COL_JINCHUKOUQYPINO="HUIYUAN_ZFCG_GONGYINGINFO_JINCHUKOUQYPINO"; // 进出口企业批准文号
  public static final String COL_JINGYETYPE="HUIYUAN_ZFCG_GONGYINGINFO_JINGYETYPE"; // 经营类别
  public static final String COL_LIANXIREN1="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN1"; // 联系人1姓名
  public static final String COL_LIANXIREN1ADDRESS="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN1ADDRESS"; // 联系人1通信地址
  public static final String COL_LIANXIREN1EMAIL="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN1EMAIL"; // 联系人1邮件
  public static final String COL_LIANXIREN1FAX="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN1FAX"; // 联系人1传真号码
  public static final String COL_LIANXIREN1MOBILE="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN1MOBILE"; // 联系人1手机
  public static final String COL_LIANXIREN1TEL="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN1TEL"; // 联系人1电话
  public static final String COL_LIANXIREN1ZIP="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN1ZIP"; // 联系人1通信邮编
  public static final String COL_LIANXIREN2="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN2"; // 联系人2姓名
  public static final String COL_LIANXIREN2ADDRESS="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN2ADDRESS"; // 联系人2通信地址
  public static final String COL_LIANXIREN2EMAIL="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN2EMAIL"; // 联系人2邮件
  public static final String COL_LIANXIREN2FAX="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN2FAX"; // 联系人2传真号码
  public static final String COL_LIANXIREN2MOBLIE="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN2MOBLIE"; // 联系人2手机
  public static final String COL_LIANXIREN2TEL="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN2TEL"; // 联系人2电话
  public static final String COL_LIANXIREN2ZIP="HUIYUAN_ZFCG_GONGYINGINFO_LIANXIREN2ZIP"; // 联系人2通信邮编
  public static final String COL_LOCALLIANXIREN="HUIYUAN_ZFCG_GONGYINGINFO_LOCALLIANXIREN"; // 联系人
  public static final String COL_LOCALMOBILE="HUIYUAN_ZFCG_GONGYINGINFO_LOCALMOBILE"; // 联系电话
  public static final String COL_REMARK="HUIYUAN_ZFCG_GONGYINGINFO_REMARK"; // 备注
  public static final String COL_STATUSCODE="HUIYUAN_ZFCG_GONGYINGINFO_STATUSCODE"; // 帐号状态
  public static final String COL_ZHUCEJIBIE="HUIYUAN_ZFCG_GONGYINGINFO_ZHUCEJIBIE"; // 注册级别

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.DANWEIGUID
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String danweiguid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.AUDITSTATUS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String auditstatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.STATUSCODE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String statuscode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.REMARK
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.JINCHUKOUQYPINO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String jinchukouqypino;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.JINGYETYPE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String jingyetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.GONGYINGSHANGTYPE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String gongyingshangtype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.ZHUCEJIBIE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String zhucejibie;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LOCALLIANXIREN
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String locallianxiren;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LOCALMOBILE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String localmobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.ACCOUNT
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.BANK
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String bank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1EMAIL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren1email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2EMAIL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren2email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1MOBILE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren1mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2MOBLIE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren2moblie;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1TEL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren1tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2TEL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren2tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1FAX
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren1fax;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2FAX
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren2fax;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ADDRESS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren1address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ADDRESS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren2address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ZIP
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren1zip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ZIP
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    private String lianxiren2zip;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.DANWEIGUID
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.DANWEIGUID
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getDanweiguid() {
        return danweiguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.DANWEIGUID
     *
     * @param danweiguid the value for HUIYUAN_ZFCG_GONGYINGINFO.DANWEIGUID
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setDanweiguid(String danweiguid) {
        this.danweiguid = danweiguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.AUDITSTATUS
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.AUDITSTATUS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getAuditstatus() {
        return auditstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.AUDITSTATUS
     *
     * @param auditstatus the value for HUIYUAN_ZFCG_GONGYINGINFO.AUDITSTATUS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.STATUSCODE
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.STATUSCODE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getStatuscode() {
        return statuscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.STATUSCODE
     *
     * @param statuscode the value for HUIYUAN_ZFCG_GONGYINGINFO.STATUSCODE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.REMARK
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.REMARK
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.REMARK
     *
     * @param remark the value for HUIYUAN_ZFCG_GONGYINGINFO.REMARK
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.JINCHUKOUQYPINO
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.JINCHUKOUQYPINO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getJinchukouqypino() {
        return jinchukouqypino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.JINCHUKOUQYPINO
     *
     * @param jinchukouqypino the value for HUIYUAN_ZFCG_GONGYINGINFO.JINCHUKOUQYPINO
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setJinchukouqypino(String jinchukouqypino) {
        this.jinchukouqypino = jinchukouqypino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.JINGYETYPE
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.JINGYETYPE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getJingyetype() {
        return jingyetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.JINGYETYPE
     *
     * @param jingyetype the value for HUIYUAN_ZFCG_GONGYINGINFO.JINGYETYPE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setJingyetype(String jingyetype) {
        this.jingyetype = jingyetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.GONGYINGSHANGTYPE
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.GONGYINGSHANGTYPE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getGongyingshangtype() {
        return gongyingshangtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.GONGYINGSHANGTYPE
     *
     * @param gongyingshangtype the value for HUIYUAN_ZFCG_GONGYINGINFO.GONGYINGSHANGTYPE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setGongyingshangtype(String gongyingshangtype) {
        this.gongyingshangtype = gongyingshangtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.ZHUCEJIBIE
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.ZHUCEJIBIE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getZhucejibie() {
        return zhucejibie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.ZHUCEJIBIE
     *
     * @param zhucejibie the value for HUIYUAN_ZFCG_GONGYINGINFO.ZHUCEJIBIE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setZhucejibie(String zhucejibie) {
        this.zhucejibie = zhucejibie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LOCALLIANXIREN
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LOCALLIANXIREN
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLocallianxiren() {
        return locallianxiren;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LOCALLIANXIREN
     *
     * @param locallianxiren the value for HUIYUAN_ZFCG_GONGYINGINFO.LOCALLIANXIREN
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLocallianxiren(String locallianxiren) {
        this.locallianxiren = locallianxiren;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LOCALMOBILE
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LOCALMOBILE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLocalmobile() {
        return localmobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LOCALMOBILE
     *
     * @param localmobile the value for HUIYUAN_ZFCG_GONGYINGINFO.LOCALMOBILE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLocalmobile(String localmobile) {
        this.localmobile = localmobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.ACCOUNT
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.ACCOUNT
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.ACCOUNT
     *
     * @param account the value for HUIYUAN_ZFCG_GONGYINGINFO.ACCOUNT
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.BANK
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.BANK
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getBank() {
        return bank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.BANK
     *
     * @param bank the value for HUIYUAN_ZFCG_GONGYINGINFO.BANK
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren1() {
        return lianxiren1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1
     *
     * @param lianxiren1 the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren1(String lianxiren1) {
        this.lianxiren1 = lianxiren1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren2() {
        return lianxiren2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2
     *
     * @param lianxiren2 the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren2(String lianxiren2) {
        this.lianxiren2 = lianxiren2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1EMAIL
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1EMAIL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren1email() {
        return lianxiren1email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1EMAIL
     *
     * @param lianxiren1email the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1EMAIL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren1email(String lianxiren1email) {
        this.lianxiren1email = lianxiren1email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2EMAIL
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2EMAIL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren2email() {
        return lianxiren2email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2EMAIL
     *
     * @param lianxiren2email the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2EMAIL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren2email(String lianxiren2email) {
        this.lianxiren2email = lianxiren2email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1MOBILE
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1MOBILE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren1mobile() {
        return lianxiren1mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1MOBILE
     *
     * @param lianxiren1mobile the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1MOBILE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren1mobile(String lianxiren1mobile) {
        this.lianxiren1mobile = lianxiren1mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2MOBLIE
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2MOBLIE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren2moblie() {
        return lianxiren2moblie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2MOBLIE
     *
     * @param lianxiren2moblie the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2MOBLIE
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren2moblie(String lianxiren2moblie) {
        this.lianxiren2moblie = lianxiren2moblie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1TEL
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1TEL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren1tel() {
        return lianxiren1tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1TEL
     *
     * @param lianxiren1tel the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1TEL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren1tel(String lianxiren1tel) {
        this.lianxiren1tel = lianxiren1tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2TEL
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2TEL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren2tel() {
        return lianxiren2tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2TEL
     *
     * @param lianxiren2tel the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2TEL
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren2tel(String lianxiren2tel) {
        this.lianxiren2tel = lianxiren2tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1FAX
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1FAX
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren1fax() {
        return lianxiren1fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1FAX
     *
     * @param lianxiren1fax the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1FAX
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren1fax(String lianxiren1fax) {
        this.lianxiren1fax = lianxiren1fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2FAX
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2FAX
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren2fax() {
        return lianxiren2fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2FAX
     *
     * @param lianxiren2fax the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2FAX
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren2fax(String lianxiren2fax) {
        this.lianxiren2fax = lianxiren2fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ADDRESS
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ADDRESS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren1address() {
        return lianxiren1address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ADDRESS
     *
     * @param lianxiren1address the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ADDRESS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren1address(String lianxiren1address) {
        this.lianxiren1address = lianxiren1address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ADDRESS
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ADDRESS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren2address() {
        return lianxiren2address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ADDRESS
     *
     * @param lianxiren2address the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ADDRESS
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren2address(String lianxiren2address) {
        this.lianxiren2address = lianxiren2address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ZIP
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ZIP
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren1zip() {
        return lianxiren1zip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ZIP
     *
     * @param lianxiren1zip the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN1ZIP
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren1zip(String lianxiren1zip) {
        this.lianxiren1zip = lianxiren1zip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ZIP
     *
     * @return the value of HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ZIP
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public String getLianxiren2zip() {
        return lianxiren2zip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ZIP
     *
     * @param lianxiren2zip the value for HUIYUAN_ZFCG_GONGYINGINFO.LIANXIREN2ZIP
     *
     * @mbggenerated Fri Nov 13 03:01:27 CST 2015
     */
    public void setLianxiren2zip(String lianxiren2zip) {
        this.lianxiren2zip = lianxiren2zip;
    }
}