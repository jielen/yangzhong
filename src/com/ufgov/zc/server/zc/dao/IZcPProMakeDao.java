package com.ufgov.zc.server.zc.dao;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcPProMake;import com.ufgov.zc.common.zc.model.ZcPProMakeExample;public interface IZcPProMakeDao {  int countByExample(ZcPProMakeExample example);  int deleteByExample(ZcPProMakeExample example);  int deleteByPrimaryKey(String zcMakeCode);  void insert(ZcPProMake record);  void insertSelective(ZcPProMake record);  List selectByExample(ElementConditionDto dto, RequestMeta meta);  List selectByExampleXieYi(ElementConditionDto dto, RequestMeta meta);  ZcPProMake selectByPrimaryKey(String zcMakeCode);  int updateByExampleSelective(ZcPProMake record, ZcPProMakeExample example);  int updateByExample(ZcPProMake record, ZcPProMakeExample example);  int updateByPrimaryKeySelective(ZcPProMake record);  int updateByPrimaryKey(ZcPProMake record);  int updatePrimaryKeyByTempCode(ZcPProMake record);  Long getInstanceIdByMakeCode(String makeCode);  int updateAttrsByPrimaryKey(ZcPProMake make);  String getWfActionLastUser(String ProcessInstId);//add shijia 20111031  List getWfActionDescription(Long id);  List queryExportsDatas(ElementConditionDto dto);}