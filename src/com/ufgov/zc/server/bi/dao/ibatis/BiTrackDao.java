package com.ufgov.zc.server.bi.dao.ibatis;import java.math.BigDecimal;import java.sql.SQLException;import java.util.HashMap;import java.util.List;import java.util.Map;import org.springframework.orm.ibatis.SqlMapClientCallback;import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;import com.ibatis.sqlmap.client.SqlMapExecutor;import com.ufgov.zc.common.bi.model.BiTrack;import com.ufgov.zc.common.system.constants.NumLimConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.server.bi.dao.IBiTrackDao;import com.ufgov.zc.server.system.util.NumLimUtil;import com.ufgov.zc.server.system.util.OrderColumnsUtil;import com.ufgov.zc.server.system.util.RequestMetaUtil;public class BiTrackDao extends SqlMapClientDaoSupport implements IBiTrackDao {  public BiTrack getBiTrackById(String id) {    return (BiTrack) this.getSqlMapClientTemplate().queryForObject("BiTrack.getBiTrackById", id);  }  public List getBiTrackForQueryData(BiTrack biTrack) {    return this.getSqlMapClientTemplate().queryForList("BiTrack.selectBitrackByPrimaryKey", biTrack);  }  public List getBiTrackForQueryData(ElementConditionDto conditionDto) {    return this.getSqlMapClientTemplate().queryForList("BiTrack.getBitrackForAm", conditionDto);  }  public void insertBiTrack(List biTrackList) {    final List list = biTrackList;    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {        executor.startBatch();        for (int i = 0; i < list.size(); i++) {          executor.insert("BiTrack.insertBiTrack", list.get(i));        }        executor.executeBatch();        return null;      }    });  }  public void insertBiTrack(BiTrack biTrack) {    this.getSqlMapClientTemplate().insert("BiTrack.insertBiTrack", biTrack);  }  public void updateBiTrack(BiTrack biTrack) {    this.getSqlMapClientTemplate().update("BiTrack.updateBiTrack", biTrack);  }  public List getBitrackForBc(ElementConditionDto elementConditionDto) {    return this.getSqlMapClientTemplate().queryForList("BiTrack.getBitrackForBc", elementConditionDto);  }  public void increasePrintTimes(String biTrackId) {    Map map = new HashMap();    map.put("biTrackId", biTrackId);    this.getSqlMapClientTemplate().update("BiTrack.updateBiTrackPrintTimes", map);  }  public List getBiTrackForDbiTbiCtrlAudit(ElementConditionDto elementConditionDto) {//    elementConditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(////    elementConditionDto.getNumLimCompoId(), NumLimConstants.FWATCH));    elementConditionDto.setOrderColumns(OrderColumnsUtil.getInstance().getOrderColumns(    RequestMetaUtil.getCompoId()));    return this.getSqlMapClientTemplate().queryForList("BiTrack.getBiTrackForDbiTbiCtrlAudit",    elementConditionDto);  }  public void updateBiTrackForAudit(BiTrack biTrack) {    this.getSqlMapClientTemplate().update("BiTrack.updateBiTrackForAudit", biTrack);  }  public void invalidateBiTrackForBiAudit(BiTrack biTrack) {    this.getSqlMapClientTemplate().update("BiTrack.validBiTrackForBiAudit", biTrack);  }  public int updateSelfBiTrackForInvalidate(String strValue, String biTrackId) {    Map map = new HashMap();    map.put("strValue", strValue);    map.put("biTrackId", biTrackId);    return this.getSqlMapClientTemplate().update("BiTrack.updateSelfBiTrackForValid", map);  }  public int updateBiTrackAstatusCode(String astatusCode, String biTrackId) {    Map map = new HashMap();    map.put("astatusCode", astatusCode);    map.put("biTrackId", biTrackId);    return this.getSqlMapClientTemplate().update("BiTrack.updateBiTrackAstatusCode", map);  }  public void rewriteBiBalanceIdToBiTrack(String biBalanceId, String biTrackId) {    Map map = new HashMap();    map.put("biBalanceId", biBalanceId);    map.put("biTrackId", biTrackId);    this.getSqlMapClientTemplate().update("BiTrack.rewriteBiBalanceIdToBiTrack", map);  }  public List getBiTrackForDbiTbiEdit(ElementConditionDto dto) {//    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getNumLimCompoId(),////    NumLimConstants.FWATCH));    dto.setOrderColumns(OrderColumnsUtil.getInstance().getOrderColumns(RequestMetaUtil.getCompoId()));    return this.getSqlMapClientTemplate().queryForList("BiTrack.getBiTrackForDbiTbiEdit", dto);  }  public int deleteBiTrack(BiTrack biTrack) {    return this.getSqlMapClientTemplate().delete("BiTrack.deleteBiTrack", biTrack);  }  public void updateBiTrackForBiBalanceIdToNull(BiTrack biTrack) {    this.getSqlMapClientTemplate().update("BiTrack.updateBiTrackForBiBalanceIdToNull", biTrack);  }  public List getAbiTrackList(ElementConditionDto dto) {//    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getNumLimCompoId(),////    NumLimConstants.FWATCH));    //dto.setOrderColumns(OrderColumnsUtil.getInstance().getOrderColumns(RequestMetaUtil.getCompoId()));    return this.getSqlMapClientTemplate().queryForList("BiTrack.getAbiTrackList", dto);  }  public List getBiTrackListByTargetBalanceId(String targetBalanceId) {    return this.getSqlMapClientTemplate().queryForList("BiTrack.getBiTrackListByTargetBalanceId",    targetBalanceId);  }  public void deleteBiTrackForAdj(final List bitracks) {    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {        BiTrack track = null;        executor.startBatch();        for (int i = 0; i < bitracks.size(); i++) {          track = (BiTrack) bitracks.get(i);          BiTrackDao.this.getSqlMapClientTemplate().delete("BiTrack.deleteByInputGroupId",          track.getInputGroupId());        }        executor.executeBatch();        return null;      }    });  }  public void updateBiTrackForAdj(final List bitracks) {    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {        // TCJLODO Auto-generated method stub        BiTrack track = null;        BigDecimal sumMoney = new BigDecimal(0);        executor.startBatch();        for (int i = 0; i < bitracks.size(); i++) {          track = (BiTrack) bitracks.get(i);          BiTrackDao.this.getSqlMapClientTemplate().update("BiTrack.updateBiTrackForAdjAsc", track);          sumMoney = sumMoney.add(track.getCurMoney());        }        track.setCurMoney(sumMoney);        BiTrackDao.this.getSqlMapClientTemplate().update("BiTrack.updateBiTrackForAdjDec", track);        executor.executeBatch();        return null;      }    });  }  public List getBiTrackForAdjAsc(String groupId) {    List result = this.getSqlMapClientTemplate().queryForList("BiTrack.getBiTrackForAdjAsc", groupId);    return result;  }  public List getBiTrackForXbiAdjAudit(ElementConditionDto dto) {    return this.getSqlMapClientTemplate().queryForList("BiTrack.getBiTrackForXbiAdjAudit", dto);  }  public List getAllBiTrack(ElementConditionDto conditionDto) {//    conditionDto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(////    conditionDto.getNumLimCompoId(), NumLimConstants.FWATCH));    conditionDto    .setOrderColumns(OrderColumnsUtil.getInstance().getOrderColumns(RequestMetaUtil.getCompoId()));    return this.getSqlMapClientTemplate().queryForList("BiTrack.getAllBiTrack", conditionDto);  }  public BiTrack getBiTrackByTargetBalanceId(String balanceId) {    return (BiTrack) this.getSqlMapClientTemplate().queryForObject("BiTrack.getBiTrackByTargetBalanceId", balanceId);  }  public BigDecimal getHasAdjuseMoney(String balanceId) {    return (BigDecimal) this.getSqlMapClientTemplate().queryForObject("BiTrack.getHasAdjuseMoney", balanceId);  }}