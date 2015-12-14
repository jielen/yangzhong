package com.ufgov.zc.common.zc.publish;import java.util.List;import com.ufgov.zc.common.system.Publishable;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.exception.BusinessException;import com.ufgov.zc.common.zc.model.ZcEbQuestionWithBLOBs;public interface IZCQuestionServiceDelegate extends Publishable {  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  ZcEbQuestionWithBLOBs selectByPrimaryKey(String code, RequestMeta requestMeta);  ZcEbQuestionWithBLOBs saveFN(ZcEbQuestionWithBLOBs inData, RequestMeta requestMeta) throws BusinessException;  void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs unAuditFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs untreadFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs auditFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs newCommitFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;  ZcEbQuestionWithBLOBs callbackFN(ZcEbQuestionWithBLOBs record, RequestMeta requestMeta) throws BusinessException;}