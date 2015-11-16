/**
 * 
 */
package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper;

/**
 * @author Administrator
 *
 */
public class HuiyuanUnitcominfoMapperImp extends SqlMapClientDaoSupport implements HuiyuanUnitcominfoMapper {


  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#deleteByPrimaryKey(java.lang.String)
   */
  
  public int deleteByPrimaryKey(String danweiguid) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.deleteByPrimaryKey", danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#insert(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */
  
  public int insert(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub

    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#insertSelective(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */
  
  public int insertSelective(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#selectByPrimaryKey(java.lang.String)
   */
  
  public HuiyuanUnitcominfo selectByPrimaryKey(String danweiguid) {
    // TODO Auto-generated method stub
    return (HuiyuanUnitcominfo) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.selectByPrimaryKey", danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */
  
  public int updateByPrimaryKeySelective(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper#updateByPrimaryKey(com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo)
   */
  
  public int updateByPrimaryKey(HuiyuanUnitcominfo record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.updateByPrimaryKey", record);
  }
 
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub 
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanUnitcominfoMapper.selectMainDataLst", elementConditionDto);
  }


}
