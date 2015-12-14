package com.ufgov.zc.server.zc.service;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.exception.BusinessException;import com.ufgov.zc.common.zc.model.ZcEbQuestionWithBLOBs;/** * @author wuwb */public interface IZCQuestionService {  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  ZcEbQuestionWithBLOBs selectByPrimaryKey(String code, RequestMeta requestMeta);  ZcEbQuestionWithBLOBs saveFN(ZcEbQuestionWithBLOBs inData, RequestMeta requestMeta) throws BusinessException;  void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs unAuditFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs untreadFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs auditFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs newCommitFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs callbackFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;}