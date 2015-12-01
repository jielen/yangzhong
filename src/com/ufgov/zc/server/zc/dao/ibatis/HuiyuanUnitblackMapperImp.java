package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitblack;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper;

public class HuiyuanUnitblackMapperImp extends SqlMapClientDaoSupport implements HuiyuanUnitblackMapper {

  
  public int deleteByPrimaryKey(String guid) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper.deleteByPrimaryKey", guid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper#insert(com.ufgov.zc.common.zc.model.HuiyuanUnitblack)
   */
  
  public int insert(HuiyuanUnitblack record) {
    // TCJLODO Auto-generated method stub

    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper#insertSelective(com.ufgov.zc.common.zc.model.HuiyuanUnitblack)
   */
  
  public int insertSelective(HuiyuanUnitblack record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper#selectByPrimaryKey(java.lang.String)
   */
  
  public HuiyuanUnitblack selectByPrimaryKey(String guid) {
    // TCJLODO Auto-generated method stub
    return (HuiyuanUnitblack) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper.selectByPrimaryKey", guid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.HuiyuanUnitblack)
   */
  
  public int updateByPrimaryKeySelective(HuiyuanUnitblack record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper#updateByPrimaryKey(com.ufgov.zc.common.zc.model.HuiyuanUnitblack)
   */
  
  public int updateByPrimaryKey(HuiyuanUnitblack record) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper.updateByPrimaryKey", record);
  }
 
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TCJLODO Auto-generated method stub 
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanUnitblackMapper.selectMainDataLst", elementConditionDto);
  }

  

}
