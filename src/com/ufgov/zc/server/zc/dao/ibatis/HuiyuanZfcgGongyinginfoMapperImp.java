/**
 * 
 */
package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper;

/**
 * @author Administrator
 *
 */
public class HuiyuanZfcgGongyinginfoMapperImp extends SqlMapClientDaoSupport  implements HuiyuanZfcgGongyinginfoMapper {

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#deleteByPrimaryKey(java.lang.String)
   */
  
  public int deleteByPrimaryKey(String danweiguid) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper.deleteByPrimaryKey", danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#insert(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo)
   */
  
  public int insert(HuiyuanZfcgGongyinginfo record) {
    // TCJLODO Auto-generated method stub

    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#insertSelective(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo)
   */
  
  public int insertSelective(HuiyuanZfcgGongyinginfo record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#selectByPrimaryKey(java.lang.String)
   */
  
  public HuiyuanZfcgGongyinginfo selectByPrimaryKey(String danweiguid) {
    // TCJLODO Auto-generated method stub
    return (HuiyuanZfcgGongyinginfo) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper.selectByPrimaryKey", danweiguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo)
   */
  
  public int updateByPrimaryKeySelective(HuiyuanZfcgGongyinginfo record) {
    // TCJLODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper#updateByPrimaryKey(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo)
   */
  
  public int updateByPrimaryKey(HuiyuanZfcgGongyinginfo record) {
    // TCJLODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper.updateByPrimaryKey", record);
  }
 
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TCJLODO Auto-generated method stub 
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper.selectMainDataLst", elementConditionDto);
  }

 
  public void updateAuditStatusFN(HuiyuanZfcgGongyinginfo record) {
    // TCJLODO Auto-generated method stub
    getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyinginfoMapper.updateAuditStatus", record);
  }

}
