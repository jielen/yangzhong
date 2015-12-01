/**
 * 
 */
package com.ufgov.zc.server.zc.dao.ibatis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcEbZxjjHistory;
import com.ufgov.zc.server.zc.dao.IZcEbZxjjHistoryDao;

/**
 * @author Administrator
 *
 */
public class ZcEbZxjjHistoryDao extends SqlMapClientDaoSupport implements IZcEbZxjjHistoryDao {

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjHistoryDao#insert(com.ufgov.zc.common.zc.model.ZcEbZxjjHistory)
   */
  
  public int insert(ZcEbZxjjHistory record) {
    // TCJLODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.ZcEbZxjjHistoryMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjHistoryDao#insertSelective(com.ufgov.zc.common.zc.model.ZcEbZxjjHistory)
   */
  
  public int insertSelective(ZcEbZxjjHistory record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  
  public int deleteByPrimaryKey(BigDecimal jjCode) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.ZcEbZxjjHistoryMapper.deleteByPrimaryKey", jjCode);
    
  }

  
  public ZcEbZxjjHistory selectByPrimaryKey(BigDecimal jjCode) {
    // TCJLODO Auto-generated method stub
    return (ZcEbZxjjHistory) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.ZcEbZxjjHistoryMapper.selectByPrimaryKey", jjCode);
  }

  
  public int updateByPrimaryKeySelective(ZcEbZxjjHistory record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  
  public int updateByPrimaryKey(ZcEbZxjjHistory record) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.ZcEbZxjjHistoryMapper.updateByPrimaryKey", record);
  
  }

  
  public List selectByJjCode(ElementConditionDto dto) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.ZcEbZxjjHistoryMapper.selectByJjCode", dto);
  }

}
