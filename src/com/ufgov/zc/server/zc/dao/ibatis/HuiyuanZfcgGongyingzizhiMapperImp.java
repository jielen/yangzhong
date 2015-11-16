package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper;

public class HuiyuanZfcgGongyingzizhiMapperImp extends SqlMapClientDaoSupport implements HuiyuanZfcgGongyingzizhiMapper {

  
  public int deleteByPrimaryKey(String guid) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper.deleteByPrimaryKey", guid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper#insert(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi)
   */
  
  public int insert(HuiyuanZfcgGongyingzizhi record) {
    // TODO Auto-generated method stub

    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper#insertSelective(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi)
   */
  
  public int insertSelective(HuiyuanZfcgGongyingzizhi record) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper#selectByPrimaryKey(java.lang.String)
   */
  
  public HuiyuanZfcgGongyingzizhi selectByPrimaryKey(String guid) {
    // TODO Auto-generated method stub
    return (HuiyuanZfcgGongyingzizhi) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper.selectByPrimaryKey", guid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi)
   */
  
  public int updateByPrimaryKeySelective(HuiyuanZfcgGongyingzizhi record) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper#updateByPrimaryKey(com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyingzizhi)
   */
  
  public int updateByPrimaryKey(HuiyuanZfcgGongyingzizhi record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper.updateByPrimaryKey", record);
  }
 
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub 
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper.selectMainDataLst", elementConditionDto);
  }

 
  public void updateAuditStatusFN(HuiyuanZfcgGongyingzizhi record) {
    // TODO Auto-generated method stub
    getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanZfcgGongyingzizhiMapper.updateAuditStatus", record);
  }
 

}
