/**   * @(#) project: GK* @(#) file: ZcEbPackSumResByNoMaxAndMinAvg.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.server.zc.service.impl.calculator;import com.ufgov.zc.common.zc.model.ZcEbExpertEvalResult;import com.ufgov.zc.common.zc.model.ZcEbPackEvalResult;import java.math.BigDecimal;/*** @ClassName: ZcEbPackSumResByNoMaxAndMinAvg* @Description: 去掉最高分和最低分加权平均* @date: 2010-6-25 下午07:46:37* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ZcEbPackSumResByNoMaxAndMinAvg extends ZcEbPackBaseSumRes {  /* (non-Javadoc)  * <p>Title: genProviderPackSumResult</p>  * <p>Description: </p>  * @param param  * @return  * @see com.ufgov.gk.server.zc.service.impl.calculator.IZcEbPackExpertEvalResSumCalculator#genProviderPackSumResult(com.ufgov.gk.server.zc.service.impl.calculator.CalculatorParam)  */  public ZcEbPackEvalResult genProviderPackSumResult(CalculatorParam param) {    int expertEvalResCount = param.getExpertEvalPackResList().size();    BigDecimal totalScore = new BigDecimal(0);    totalScore.setScale(2, 5);    BigDecimal maxScore = new BigDecimal(0);    maxScore.setScale(2, 5);    BigDecimal minScore = new BigDecimal(0);    minScore.setScale(2, 5);    for (int i = 0; i < expertEvalResCount; i++) {      ZcEbExpertEvalResult result = (ZcEbExpertEvalResult) param.getExpertEvalPackResList().get(i);      if (i == 0) {        maxScore = result.getScoreEvalResult().setScale(2, 5);        minScore = result.getScoreEvalResult().setScale(2, 5);      } else {        maxScore = max(maxScore, result.getScoreEvalResult());        minScore = min(minScore, result.getScoreEvalResult());      }      totalScore = totalScore.add(result.getScoreEvalResult());    }    ZcEbPackEvalResult sumResult = new ZcEbPackEvalResult();    BigDecimal finalEvalScore = null;    if (expertEvalResCount <= 3) {      BigDecimal expertCount = new BigDecimal(expertEvalResCount);      expertCount.setScale(2, 5);      finalEvalScore = totalScore.divide(expertCount, 2);    } else {      BigDecimal expertCount = new BigDecimal(expertEvalResCount - 2);      expertCount.setScale(2, 5);      finalEvalScore = (totalScore.subtract(maxScore).subtract(minScore)).divide(expertCount, 2);    }    finalEvalScore.setScale(2, 5);    sumResult.setEvalScore(finalEvalScore);    sumResult.setIsComplianceResult("Y");    return sumResult;  }}