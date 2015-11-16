package com.ufgov.zc.common.zc.model;

import java.util.Date;

public class HuiyuanUser extends ZcBaseBill {
    /**
   * 
   */
  private static final long serialVersionUID = 9188065394565962303L;
  
  public static final String TAB_ID="HUIYUAN_USER_Tab";
  
  public static final String COL_AUDITSTATUS="HUIYUAN_USER_AUDITSTATUS"; // 审核状态
  public static final String COL_BIRTHDAY="HUIYUAN_USER_BIRTHDAY"; // 出生日期
  public static final String COL_CERTSUBJECTKEYID="HUIYUAN_USER_CERTSUBJECTKEYID"; // 使用者密钥标识符
  public static final String COL_CERTYOUXIAOQI="HUIYUAN_USER_CERTYOUXIAOQI"; // 锁有效期
  public static final String COL_COMADDRESS="HUIYUAN_USER_COMADDRESS"; // 通讯地址
  public static final String COL_COMPANYPHONE="HUIYUAN_USER_COMPANYPHONE"; // 办公电话
  public static final String COL_COMZIP="HUIYUAN_USER_COMZIP"; // 邮政编码
  public static final String COL_DANWEIGUID="HUIYUAN_USER_DANWEIGUID"; // 单位唯一标识
  public static final String COL_DANWEINAME="HUIYUAN_USER_DANWEINAME"; // 单位名称
  public static final String COL_DEVICENUM="HUIYUAN_USER_DEVICENUM"; // 锁硬件号
  public static final String COL_DISPLAYNAME="HUIYUAN_USER_DISPLAYNAME"; // 使用者
  public static final String COL_DOGNUM="HUIYUAN_USER_DOGNUM"; // 证书号
  public static final String COL_EMAIL="HUIYUAN_USER_EMAIL"; // 电子邮箱
  public static final String COL_IDCARD="HUIYUAN_USER_IDCARD"; // 身份证号码
  public static final String COL_JIAOYANNO="HUIYUAN_USER_JIAOYANNO"; // 校验码
  public static final String COL_LOGINID="HUIYUAN_USER_LOGINID"; // 登陆帐号名
  public static final String COL_MOBILEPHONE="HUIYUAN_USER_MOBILEPHONE"; // 手机号码
  public static final String COL_PASSWD="HUIYUAN_USER_PASSWD"; // 密码
  public static final String COL_REMARK="HUIYUAN_USER_REMARK"; // 备注
  public static final String COL_SEX="HUIYUAN_USER_SEX"; // 性别
  public static final String COL_STATUSCODE="HUIYUAN_USER_STATUSCODE"; // 帐号状态
  public static final String COL_USERGUID="HUIYUAN_USER_USERGUID"; // 人员唯一编号
  public static final String COL_USERTYPE="HUIYUAN_USER_USERTYPE"; // 用户类型
  public static final String COL_YXQ="HUIYUAN_USER_YXQ"; // 有效期
  public static final String COL_ZHAOPIAN="HUIYUAN_USER_ZHAOPIAN"; // 照片
  public static final String COL_ZHENGSHUTYPE="HUIYUAN_USER_ZHENGSHUTYPE"; // 主副锁类型
  

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.USERGUID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String userguid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.DANWEIGUID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String danweiguid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.DOGNUM
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String dognum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.LOGINID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String loginid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.PASSWD
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String passwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.STATUSCODE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String statuscode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.DISPLAYNAME
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String displayname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.BIRTHDAY
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.SEX
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.IDCARD
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String idcard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.COMPANYPHONE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String companyphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.MOBILEPHONE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String mobilephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.EMAIL
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.COMADDRESS
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String comaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.COMZIP
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String comzip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.AUDITSTATUS
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String auditstatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.REMARK
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.USERTYPE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String usertype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.YXQ
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private Date yxq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.DEVICENUM
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String devicenum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.JIAOYANNO
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String jiaoyanno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.CERTYOUXIAOQI
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private Date certyouxiaoqi;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.CERTSUBJECTKEYID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String certsubjectkeyid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.ZHENGSHUTYPE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String zhengshutype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.DANWEINAME
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private String danweiname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HUIYUAN_USER.ZHAOPIAN
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    private byte[] zhaopian;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.USERGUID
     *
     * @return the value of HUIYUAN_USER.USERGUID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getUserguid() {
        return userguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.USERGUID
     *
     * @param userguid the value for HUIYUAN_USER.USERGUID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setUserguid(String userguid) {
        this.userguid = userguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.DANWEIGUID
     *
     * @return the value of HUIYUAN_USER.DANWEIGUID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getDanweiguid() {
        return danweiguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.DANWEIGUID
     *
     * @param danweiguid the value for HUIYUAN_USER.DANWEIGUID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setDanweiguid(String danweiguid) {
        this.danweiguid = danweiguid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.DOGNUM
     *
     * @return the value of HUIYUAN_USER.DOGNUM
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getDognum() {
        return dognum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.DOGNUM
     *
     * @param dognum the value for HUIYUAN_USER.DOGNUM
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setDognum(String dognum) {
        this.dognum = dognum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.LOGINID
     *
     * @return the value of HUIYUAN_USER.LOGINID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getLoginid() {
        return loginid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.LOGINID
     *
     * @param loginid the value for HUIYUAN_USER.LOGINID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.PASSWD
     *
     * @return the value of HUIYUAN_USER.PASSWD
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.PASSWD
     *
     * @param passwd the value for HUIYUAN_USER.PASSWD
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.STATUSCODE
     *
     * @return the value of HUIYUAN_USER.STATUSCODE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getStatuscode() {
        return statuscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.STATUSCODE
     *
     * @param statuscode the value for HUIYUAN_USER.STATUSCODE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.DISPLAYNAME
     *
     * @return the value of HUIYUAN_USER.DISPLAYNAME
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getDisplayname() {
        return displayname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.DISPLAYNAME
     *
     * @param displayname the value for HUIYUAN_USER.DISPLAYNAME
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.BIRTHDAY
     *
     * @return the value of HUIYUAN_USER.BIRTHDAY
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.BIRTHDAY
     *
     * @param birthday the value for HUIYUAN_USER.BIRTHDAY
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.SEX
     *
     * @return the value of HUIYUAN_USER.SEX
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.SEX
     *
     * @param sex the value for HUIYUAN_USER.SEX
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.IDCARD
     *
     * @return the value of HUIYUAN_USER.IDCARD
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.IDCARD
     *
     * @param idcard the value for HUIYUAN_USER.IDCARD
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.COMPANYPHONE
     *
     * @return the value of HUIYUAN_USER.COMPANYPHONE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getCompanyphone() {
        return companyphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.COMPANYPHONE
     *
     * @param companyphone the value for HUIYUAN_USER.COMPANYPHONE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setCompanyphone(String companyphone) {
        this.companyphone = companyphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.MOBILEPHONE
     *
     * @return the value of HUIYUAN_USER.MOBILEPHONE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.MOBILEPHONE
     *
     * @param mobilephone the value for HUIYUAN_USER.MOBILEPHONE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.EMAIL
     *
     * @return the value of HUIYUAN_USER.EMAIL
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.EMAIL
     *
     * @param email the value for HUIYUAN_USER.EMAIL
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.COMADDRESS
     *
     * @return the value of HUIYUAN_USER.COMADDRESS
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getComaddress() {
        return comaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.COMADDRESS
     *
     * @param comaddress the value for HUIYUAN_USER.COMADDRESS
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.COMZIP
     *
     * @return the value of HUIYUAN_USER.COMZIP
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getComzip() {
        return comzip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.COMZIP
     *
     * @param comzip the value for HUIYUAN_USER.COMZIP
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setComzip(String comzip) {
        this.comzip = comzip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.AUDITSTATUS
     *
     * @return the value of HUIYUAN_USER.AUDITSTATUS
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getAuditstatus() {
        return auditstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.AUDITSTATUS
     *
     * @param auditstatus the value for HUIYUAN_USER.AUDITSTATUS
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.REMARK
     *
     * @return the value of HUIYUAN_USER.REMARK
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.REMARK
     *
     * @param remark the value for HUIYUAN_USER.REMARK
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.USERTYPE
     *
     * @return the value of HUIYUAN_USER.USERTYPE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.USERTYPE
     *
     * @param usertype the value for HUIYUAN_USER.USERTYPE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.YXQ
     *
     * @return the value of HUIYUAN_USER.YXQ
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public Date getYxq() {
        return yxq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.YXQ
     *
     * @param yxq the value for HUIYUAN_USER.YXQ
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setYxq(Date yxq) {
        this.yxq = yxq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.DEVICENUM
     *
     * @return the value of HUIYUAN_USER.DEVICENUM
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getDevicenum() {
        return devicenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.DEVICENUM
     *
     * @param devicenum the value for HUIYUAN_USER.DEVICENUM
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.JIAOYANNO
     *
     * @return the value of HUIYUAN_USER.JIAOYANNO
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getJiaoyanno() {
        return jiaoyanno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.JIAOYANNO
     *
     * @param jiaoyanno the value for HUIYUAN_USER.JIAOYANNO
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setJiaoyanno(String jiaoyanno) {
        this.jiaoyanno = jiaoyanno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.CERTYOUXIAOQI
     *
     * @return the value of HUIYUAN_USER.CERTYOUXIAOQI
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public Date getCertyouxiaoqi() {
        return certyouxiaoqi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.CERTYOUXIAOQI
     *
     * @param certyouxiaoqi the value for HUIYUAN_USER.CERTYOUXIAOQI
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setCertyouxiaoqi(Date certyouxiaoqi) {
        this.certyouxiaoqi = certyouxiaoqi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.CERTSUBJECTKEYID
     *
     * @return the value of HUIYUAN_USER.CERTSUBJECTKEYID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getCertsubjectkeyid() {
        return certsubjectkeyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.CERTSUBJECTKEYID
     *
     * @param certsubjectkeyid the value for HUIYUAN_USER.CERTSUBJECTKEYID
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setCertsubjectkeyid(String certsubjectkeyid) {
        this.certsubjectkeyid = certsubjectkeyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.ZHENGSHUTYPE
     *
     * @return the value of HUIYUAN_USER.ZHENGSHUTYPE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getZhengshutype() {
        return zhengshutype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.ZHENGSHUTYPE
     *
     * @param zhengshutype the value for HUIYUAN_USER.ZHENGSHUTYPE
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setZhengshutype(String zhengshutype) {
        this.zhengshutype = zhengshutype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.DANWEINAME
     *
     * @return the value of HUIYUAN_USER.DANWEINAME
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public String getDanweiname() {
        return danweiname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.DANWEINAME
     *
     * @param danweiname the value for HUIYUAN_USER.DANWEINAME
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setDanweiname(String danweiname) {
        this.danweiname = danweiname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HUIYUAN_USER.ZHAOPIAN
     *
     * @return the value of HUIYUAN_USER.ZHAOPIAN
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public byte[] getZhaopian() {
        return zhaopian;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HUIYUAN_USER.ZHAOPIAN
     *
     * @param zhaopian the value for HUIYUAN_USER.ZHAOPIAN
     *
     * @mbggenerated Fri Nov 13 02:53:27 CST 2015
     */
    public void setZhaopian(byte[] zhaopian) {
        this.zhaopian = zhaopian;
    }
}