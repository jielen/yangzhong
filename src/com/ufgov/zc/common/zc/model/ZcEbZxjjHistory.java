package com.ufgov.zc.common.zc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZcEbZxjjHistory   extends ZcBaseBill implements Serializable {
  
  public static final String COL_IS_WIN="ZC_EB_ZXJJ_HISTORY_IS_WIN"; // 是否中标
  public static final String COL_JJ_CODE="ZC_EB_ZXJJ_HISTORY_JJ_CODE"; // 竞价编号
  public static final String COL_JJ_QUOTE="ZC_EB_ZXJJ_HISTORY_JJ_QUOTE"; // 报价
  public static final String COL_JJ_QUOTER="ZC_EB_ZXJJ_HISTORY_JJ_QUOTER"; // 报价人
  public static final String COL_JJ_QUOTE_TIME="ZC_EB_ZXJJ_HISTORY_JJ_QUOTE_TIME"; // 报价时间
  public static final String COL_JJ_ROUND="ZC_EB_ZXJJ_HISTORY_JJ_ROUND"; // 竞价轮次

    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ZC_EB_ZXJJ_HISTORY.JJ_CODE
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	private BigDecimal jjCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ZC_EB_ZXJJ_HISTORY.JJ_ROUND
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	private Integer jjRound;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTE
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	private BigDecimal jjQuote;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTER
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	private String jjQuoter;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTE_TIME
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	private Date jjQuoteTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ZC_EB_ZXJJ_HISTORY.IS_WIN
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	private String isWin;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_CODE
	 * @return  the value of ZC_EB_ZXJJ_HISTORY.JJ_CODE
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public BigDecimal getJjCode() {
		return jjCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_CODE
	 * @param jjCode  the value for ZC_EB_ZXJJ_HISTORY.JJ_CODE
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public void setJjCode(BigDecimal jjCode) {
		this.jjCode = jjCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_ROUND
	 * @return  the value of ZC_EB_ZXJJ_HISTORY.JJ_ROUND
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public Integer getJjRound() {
		return jjRound;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_ROUND
	 * @param jjRound  the value for ZC_EB_ZXJJ_HISTORY.JJ_ROUND
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public void setJjRound(Integer jjRound) {
		this.jjRound = jjRound;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTE
	 * @return  the value of ZC_EB_ZXJJ_HISTORY.JJ_QUOTE
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public BigDecimal getJjQuote() {
		return jjQuote;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTE
	 * @param jjQuote  the value for ZC_EB_ZXJJ_HISTORY.JJ_QUOTE
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public void setJjQuote(BigDecimal jjQuote) {
		this.jjQuote = jjQuote;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTER
	 * @return  the value of ZC_EB_ZXJJ_HISTORY.JJ_QUOTER
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public String getJjQuoter() {
		return jjQuoter;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTER
	 * @param jjQuoter  the value for ZC_EB_ZXJJ_HISTORY.JJ_QUOTER
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public void setJjQuoter(String jjQuoter) {
		this.jjQuoter = jjQuoter;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTE_TIME
	 * @return  the value of ZC_EB_ZXJJ_HISTORY.JJ_QUOTE_TIME
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public Date getJjQuoteTime() {
		return jjQuoteTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ZC_EB_ZXJJ_HISTORY.JJ_QUOTE_TIME
	 * @param jjQuoteTime  the value for ZC_EB_ZXJJ_HISTORY.JJ_QUOTE_TIME
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public void setJjQuoteTime(Date jjQuoteTime) {
		this.jjQuoteTime = jjQuoteTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ZC_EB_ZXJJ_HISTORY.IS_WIN
	 * @return  the value of ZC_EB_ZXJJ_HISTORY.IS_WIN
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public String getIsWin() {
		return isWin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ZC_EB_ZXJJ_HISTORY.IS_WIN
	 * @param isWin  the value for ZC_EB_ZXJJ_HISTORY.IS_WIN
	 * @mbggenerated  Wed Sep 16 01:32:01 CST 2015
	 */
	public void setIsWin(String isWin) {
		this.isWin = isWin;
	}

	/**
   * 
   */
  private static final long serialVersionUID = 4756403459536931397L;
}