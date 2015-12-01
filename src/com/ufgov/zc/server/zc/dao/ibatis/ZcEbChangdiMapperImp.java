package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper;

public class ZcEbChangdiMapperImp extends SqlMapClientDaoSupport implements ZcEbChangdiMapper {

  
  public int deleteByPrimaryKey(String changdiguid) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper.deleteByPrimaryKey", changdiguid);
  }

  
  public int insert(ZcEbChangdi record) {
    // TCJLODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper.insert", record);
    return 1;
  }

  
  public ZcEbChangdi selectByPrimaryKey(String changdiguid) {
    // TCJLODO Auto-generated method stub
    return (ZcEbChangdi) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper.selectByPrimaryKey", changdiguid);    
  }

  
  public int updateByPrimaryKey(ZcEbChangdi record) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper.updateByPrimaryKey", record);
  }

  
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TCJLODO Auto-generated method stub
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.ZcEbChangdiMapper.selectMainDataLst", elementConditionDto);
  }

}
