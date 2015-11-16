package com.ufgov.zc.server.zc.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.system.constants.NumLimConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.server.system.util.NumLimUtil;
import com.ufgov.zc.server.zc.dao.HuiyuanUserMapper;

public class HuiyuanUserMapperImp extends SqlMapClientDaoSupport implements HuiyuanUserMapper {

  
  public int deleteByPrimaryKey(String userguid) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.deleteByPrimaryKey", userguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUserMapper#insert(com.ufgov.zc.common.zc.model.HuiyuanUser)
   */
  
  public int insert(HuiyuanUser record) {
    // TODO Auto-generated method stub

    getSqlMapClientTemplate().insert("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.insert", record);
    return 1;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUserMapper#insertSelective(com.ufgov.zc.common.zc.model.HuiyuanUser)
   */
  
  public int insertSelective(HuiyuanUser record) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUserMapper#selectByPrimaryKey(java.lang.String)
   */
  
  public HuiyuanUser selectByPrimaryKey(String userguid) {
    // TODO Auto-generated method stub
    return (HuiyuanUser) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.selectByPrimaryKey", userguid);
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUserMapper#updateByPrimaryKeySelective(com.ufgov.zc.common.zc.model.HuiyuanUser)
   */
  
  public int updateByPrimaryKeySelective(HuiyuanUser record) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.server.zc.dao.HuiyuanUserMapper#updateByPrimaryKey(com.ufgov.zc.common.zc.model.HuiyuanUser)
   */
  
  public int updateByPrimaryKey(HuiyuanUser record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.updateByPrimaryKey", record);
  }
 
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub 
    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(elementConditionDto.getWfcompoId(), NumLimConstants.FWATCH));

    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.selectMainDataLst", elementConditionDto);
  }

 
  public void updateAuditStatusFN(HuiyuanUser record) {
    // TODO Auto-generated method stub
    getSqlMapClientTemplate().update("com.ufgov.zc.server.zc.dao.HuiyuanUserMapper.updateAuditStatus", record);
  }

  public int updateByPrimaryKeyWithBLOBs(HuiyuanUser record) {
    // TODO Auto-generated method stub
    return 0;
  }


}
