package com.ufgov.zc.common.zc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZcEbZxjj  extends ZcBaseBill implements Serializable{
    /**
   * 
   */
  private static final long serialVersionUID = 1658028344516639535L;
  
  public static final String ZC_VS_ZXJJ_STATUS="ZC_VS_ZXJJ_STATUS";
  /**
   * 页签
   */
  public static final String TAB_ID = "ZcEbZxjj_Tab";
  /**
   * 搜索
   */
  public static final String SEARCH_ID = "ZcEbZxjj_Search";

  public static final String STATUS_WAIT = "0";//等待开始

  public static final String STATUS_QUOTING = "1";//竞价中

  public static final String STATUS_QUOTE_SUSPEND = "2";//等待下轮

  public static final String STATUS_COMPLETED = "3";//竞价结束

  public static final String STATUS_FAIL = "4";//废标

  public static final String SEQ_NAME = "ZC_SEQ_ZXJJ_CODE";
  
  public static final String COL_BEGIN_TIME="ZC_EB_ZXJJ_BEGIN_TIME"; // 竞价开始时间
  public static final String COL_CO_CODE="ZC_EB_ZXJJ_CO_CODE"; // 采购单位代码
  public static final String COL_FAIL_REASON="ZC_EB_ZXJJ_FAIL_REASON"; // 废标原因
  public static final String COL_INPUTOR="ZC_EB_ZXJJ_INPUTOR"; // 录入人
  public static final String COL_INPUT_DATE="ZC_EB_ZXJJ_INPUT_DATE"; // 录入时间
  public static final String COL_JJ_ALL_ROUNDS="ZC_EB_ZXJJ_JJ_ALL_ROUNDS"; // 竞价轮数
  public static final String COL_JJ_CODE="ZC_EB_ZXJJ_JJ_CODE"; // 竞价编号
  public static final String COL_JJ_CUR_QUOTE="ZC_EB_ZXJJ_JJ_CUR_QUOTE"; // 最低价
  public static final String COL_JJ_CUR_QUOTER="ZC_EB_ZXJJ_JJ_CUR_QUOTER"; // 报价人
  public static final String COL_JJ_CUR_ROUND="ZC_EB_ZXJJ_JJ_CUR_ROUND"; // 当前轮次
  public static final String COL_JJ_TIME_LEN="ZC_EB_ZXJJ_JJ_TIME_LEN"; // 每轮竞价时长
  public static final String COL_PACK_CODE="ZC_EB_ZXJJ_PACK_CODE"; // 分包编号
  public static final String COL_PROJ_CODE="ZC_EB_ZXJJ_PROJ_CODE"; // 采购编号
  public static final String COL_PUR_CONTENT="ZC_EB_ZXJJ_PUR_CONTENT"; // 采购内容
  public static final String COL_REMARK="ZC_EB_ZXJJ_REMARK"; // 备注
  public static final String COL_STATUS="ZC_EB_ZXJJ_STATUS"; // 状态

  
  private List historyList = new ArrayList();//报价历史
  
  private String packName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.JJ_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private BigDecimal jjCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.PROJ_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String projCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.PACK_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String packCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.CO_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String coCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.PUR_CONTENT
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String purContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.BEGIN_TIME
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private Date beginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.JJ_TIME_LEN
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private BigDecimal jjTimeLen;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.JJ_ALL_ROUNDS
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private Integer jjAllRounds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.JJ_CUR_ROUND
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private Integer jjCurRound;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.STATUS
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.REMARK
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.FAIL_REASON
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String failReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.JJ_CUR_QUOTE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private BigDecimal jjCurQuote;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.JJ_CUR_QUOTER
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String jjCurQuoter;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.INPUTOR
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private String inputor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZC_EB_ZXJJ.INPUT_DATE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    private Date inputDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.JJ_CODE
     *
     * @return the value of ZC_EB_ZXJJ.JJ_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public BigDecimal getJjCode() {
        return jjCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.JJ_CODE
     *
     * @param jjCode the value for ZC_EB_ZXJJ.JJ_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setJjCode(BigDecimal jjCode) {
        this.jjCode = jjCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.PROJ_CODE
     *
     * @return the value of ZC_EB_ZXJJ.PROJ_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getProjCode() {
        return projCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.PROJ_CODE
     *
     * @param projCode the value for ZC_EB_ZXJJ.PROJ_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setProjCode(String projCode) {
        this.projCode = projCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.PACK_CODE
     *
     * @return the value of ZC_EB_ZXJJ.PACK_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getPackCode() {
        return packCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.PACK_CODE
     *
     * @param packCode the value for ZC_EB_ZXJJ.PACK_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.CO_CODE
     *
     * @return the value of ZC_EB_ZXJJ.CO_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getCoCode() {
        return coCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.CO_CODE
     *
     * @param coCode the value for ZC_EB_ZXJJ.CO_CODE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setCoCode(String coCode) {
        this.coCode = coCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.PUR_CONTENT
     *
     * @return the value of ZC_EB_ZXJJ.PUR_CONTENT
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getPurContent() {
        return purContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.PUR_CONTENT
     *
     * @param purContent the value for ZC_EB_ZXJJ.PUR_CONTENT
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setPurContent(String purContent) {
        this.purContent = purContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.BEGIN_TIME
     *
     * @return the value of ZC_EB_ZXJJ.BEGIN_TIME
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.BEGIN_TIME
     *
     * @param beginTime the value for ZC_EB_ZXJJ.BEGIN_TIME
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.JJ_TIME_LEN
     *
     * @return the value of ZC_EB_ZXJJ.JJ_TIME_LEN
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public BigDecimal getJjTimeLen() {
        return jjTimeLen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.JJ_TIME_LEN
     *
     * @param jjTimeLen the value for ZC_EB_ZXJJ.JJ_TIME_LEN
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setJjTimeLen(BigDecimal jjTimeLen) {
        this.jjTimeLen = jjTimeLen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.JJ_ALL_ROUNDS
     *
     * @return the value of ZC_EB_ZXJJ.JJ_ALL_ROUNDS
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public Integer getJjAllRounds() {
        return jjAllRounds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.JJ_ALL_ROUNDS
     *
     * @param jjAllRounds the value for ZC_EB_ZXJJ.JJ_ALL_ROUNDS
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setJjAllRounds(Integer jjAllRounds) {
        this.jjAllRounds = jjAllRounds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.JJ_CUR_ROUND
     *
     * @return the value of ZC_EB_ZXJJ.JJ_CUR_ROUND
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public Integer getJjCurRound() {
        return jjCurRound;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.JJ_CUR_ROUND
     *
     * @param jjCurRound the value for ZC_EB_ZXJJ.JJ_CUR_ROUND
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setJjCurRound(Integer jjCurRound) {
        this.jjCurRound = jjCurRound;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.STATUS
     *
     * @return the value of ZC_EB_ZXJJ.STATUS
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.STATUS
     *
     * @param status the value for ZC_EB_ZXJJ.STATUS
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.REMARK
     *
     * @return the value of ZC_EB_ZXJJ.REMARK
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.REMARK
     *
     * @param remark the value for ZC_EB_ZXJJ.REMARK
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.FAIL_REASON
     *
     * @return the value of ZC_EB_ZXJJ.FAIL_REASON
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.FAIL_REASON
     *
     * @param failReason the value for ZC_EB_ZXJJ.FAIL_REASON
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.JJ_CUR_QUOTE
     *
     * @return the value of ZC_EB_ZXJJ.JJ_CUR_QUOTE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public BigDecimal getJjCurQuote() {
        return jjCurQuote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.JJ_CUR_QUOTE
     *
     * @param jjCurQuote the value for ZC_EB_ZXJJ.JJ_CUR_QUOTE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setJjCurQuote(BigDecimal jjCurQuote) {
        this.jjCurQuote = jjCurQuote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.JJ_CUR_QUOTER
     *
     * @return the value of ZC_EB_ZXJJ.JJ_CUR_QUOTER
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getJjCurQuoter() {
        return jjCurQuoter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.JJ_CUR_QUOTER
     *
     * @param jjCurQuoter the value for ZC_EB_ZXJJ.JJ_CUR_QUOTER
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setJjCurQuoter(String jjCurQuoter) {
        this.jjCurQuoter = jjCurQuoter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.INPUTOR
     *
     * @return the value of ZC_EB_ZXJJ.INPUTOR
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public String getInputor() {
        return inputor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.INPUTOR
     *
     * @param inputor the value for ZC_EB_ZXJJ.INPUTOR
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setInputor(String inputor) {
        this.inputor = inputor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZC_EB_ZXJJ.INPUT_DATE
     *
     * @return the value of ZC_EB_ZXJJ.INPUT_DATE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZC_EB_ZXJJ.INPUT_DATE
     *
     * @param inputDate the value for ZC_EB_ZXJJ.INPUT_DATE
     *
     * @mbggenerated Wed Sep 16 00:26:34 CST 2015
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public List getHistoryList() {
      return historyList;
    }

    public void setHistoryList(List historyList) {
      this.historyList = historyList;
    }

    public String getPackName() {
      return packName;
    }

    public void setPackName(String packName) {
      this.packName = packName;
    }
}