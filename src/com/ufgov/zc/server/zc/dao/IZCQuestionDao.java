package com.ufgov.zc.server.zc.dao;import java.util.List;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcEbQuestion;import com.ufgov.zc.common.zc.model.ZcEbQuestionWithBLOBs;public interface IZCQuestionDao {  /**   * This method was generated by MyBatis Generator. This method corresponds to   * the database table SF_DOSSIER   * @mbggenerated Fri Jan 23 00:45:31 CST 2015   */  int deleteByPrimaryKey(String code);  /**   * This method was generated by MyBatis Generator. This method corresponds to   * the database table SF_DOSSIER   * @mbggenerated Fri Jan 23 00:45:31 CST 2015   */  int insert(ZcEbQuestionWithBLOBs record);  /**   * This method was generated by MyBatis Generator. This method corresponds to   * the database table SF_DOSSIER   * @mbggenerated Fri Jan 23 00:45:31 CST 2015   */  ZcEbQuestionWithBLOBs selectByPrimaryKey(String code);  /**   * This method was generated by MyBatis Generator. This method corresponds to   * the database table SF_DOSSIER   * @mbggenerated Fri Jan 23 00:45:31 CST 2015   */  int updateByPrimaryKeyWithBLOBs(ZcEbQuestionWithBLOBs record);  int updateByPrimaryKey(ZcEbQuestion record);  List getMainDataLst(ElementConditionDto elementConditionDto);}