package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanPeopleblack;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper;

public class HuiyuanPeopleblackMapperImp extends SqlMapClientDaoSupport implements HuiyuanPeopleblackMapper {

  
  public int deleteByPrimaryKey(String guid) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper.deleteByPrimaryKey", guid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper#insert(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack)
   */
  
  public int insert(HuiyuanPeopleblack record) {
    // TCJLODO Auto-generated method stub

    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper#insertSelective(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack)
   */
  
  public int insertSelective(HuiyuanPeopleblack record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper#selectByPrimaryKey(java.lang.String)
   */
  
  public HuiyuanPeopleblack selectByPrimaryKey(String guid) {
    // TCJLODO Auto-generated method stub
    return (HuiyuanPeopleblack) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper.selectByPrimaryKey", guid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack)
   */
  
  public int updateByPrimaryKeySelective(HuiyuanPeopleblack record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper#updateByPrimaryKey(com.ufgov.zc.common.zc.model.HuiyuanPeopleblack)
   */
  
  public int updateByPrimaryKey(HuiyuanPeopleblack record) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper.updateByPrimaryKey", record);
  }
 
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TCJLODO Auto-generated method stub 
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanPeopleblackMapper.selectMainDataLst", elementConditionDto);
  }

  

}
