/**
 * 
 */
package com.ufgov.zc.server.zc.dao.ibatis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.ZcEbZxjj;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.IZcEbZxjjDao;

/**
 * @author Administrator
 *
 */
public class ZcEbZxjjDao extends SqlMapClientDaoSupport implements IZcEbZxjjDao {

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjDao#deleteByPrimaryKey(java.lang.String)
   */
  
  public int deleteByPrimaryKey(BigDecimal jjCode) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.ZcEbZxjjMapper.deleteByPrimaryKey", jjCode);
    
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjDao#insert(com.ufgov.zc.common.zc.model.ZcEbZxjj)
   */
  
  public int insert(ZcEbZxjj record) {
    // TCJLODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.ZcEbZxjjMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjDao#insertSelective(com.ufgov.zc.common.zc.model.ZcEbZxjj)
   */
  
  public int insertSelective(ZcEbZxjj record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjDao#selectByPrimaryKey(java.lang.String)
   */
  
  public ZcEbZxjj selectByPrimaryKey(BigDecimal jjCode) {
    // TCJLODO Auto-generated method stub
    return (ZcEbZxjj) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.ZcEbZxjjMapper.selectByPrimaryKey", jjCode);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjDao#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.ZcEbZxjj)
   */
  
  public int updateByPrimaryKeySelective(ZcEbZxjj record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.IZcEbZxjjDao#updateByPrimaryKey(com.ufgov.zc.common.zc.model.ZcEbZxjj)
   */
  
  public int updateByPrimaryKey(ZcEbZxjj record) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.ZcEbZxjjMapper.updateByPrimaryKey", record);
  }

  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TCJLODO Auto-generated method stub
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.ZcEbZxjjMapper.selectMainDataLst", elementConditionDto);
  }

}
