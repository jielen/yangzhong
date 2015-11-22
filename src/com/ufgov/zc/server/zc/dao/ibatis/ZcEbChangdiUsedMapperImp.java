package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcEbChangdi;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.ZcEbChangdiUsedMapper;

public class ZcEbChangdiUsedMapperImp extends SqlMapClientDaoSupport implements ZcEbChangdiUsedMapper {

  
  public int deleteByPrimaryKey(String changdiusedid) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.ZcEbChangdiUsedMapper.deleteByPrimaryKey", changdiusedid);
  }

  
  public int insert(ZcEbChangdiUsed record) {
    // TODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.ZcEbChangdiUsedMapper.insert", record);
    return 1;
  }

  
  public ZcEbChangdiUsed selectByPrimaryKey(String changdiusedid) {
    // TODO Auto-generated method stub
    return (ZcEbChangdiUsed) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.ZcEbChangdiUsedMapper.selectByPrimaryKey", changdiusedid);    
    
  }

  
  public int updateByPrimaryKey(ZcEbChangdiUsed record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.ZcEbChangdiUsedMapper.updateByPrimaryKey", record);
  }

  
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.ZcEbChangdiUsedMapper.selectMainDataLst", elementConditionDto);
  }

}
