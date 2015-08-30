package com.ufgov.zc.server.commonbiz.dao.ibatis;import java.math.BigDecimal;import java.sql.SQLException;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import org.springframework.orm.ibatis.SqlMapClientCallback;import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;import com.ibatis.sqlmap.client.SqlMapExecutor;import com.ufgov.zc.common.commonbiz.model.MaElementRelationRule;import com.ufgov.zc.common.commonbiz.model.MaElementRelationRuleDetail;import com.ufgov.zc.common.commonbiz.model.MaElementRelationRuleEntry;import com.ufgov.zc.server.commonbiz.dao.IMaElementRelationRuleDao;public class MaElementRelationRuleDao extends SqlMapClientDaoSupport implements IMaElementRelationRuleDao {  public List getElementRelationRule(String compoId, String handleType, String ruleType) {    Map params = new HashMap();    params.put("compoId", compoId);    params.put("handleType", handleType);    params.put("ruleType", ruleType);    return this.getSqlMapClientTemplate().queryForList("MaElementRelationRule.getElementRelationRule", params);  }  public List getElementRelationRuleDetail(List ruleIdList) {    if (ruleIdList.size() == 0) {      return new ArrayList();    }    Map params = new HashMap();    params.put("relationRuleId", ruleIdList);    return this.getSqlMapClientTemplate().queryForList("MaElementRelationRule.getElementRelationRuleDetail", params);  }  public void deleteElementRelationRuleById(final String ruleId) {    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {        executor.startBatch();        executor.delete("MaElementRelationRule.deleteElementRelationRuleById", ruleId);        executor.delete("MaElementRelationRule.deleteRelationEntryByRuleId", ruleId);        executor.executeBatch();        return null;      }    });  }  public void deleteRelationEntryByEntryId(final String entryId) {    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {        executor.startBatch();        executor.delete("MaElementRelationRule.deleteRelationEntryByEntryId", entryId);        executor.executeBatch();        return null;      }    });  }  public void insertElementRelationRule(MaElementRelationRule relationRule) {    this.getSqlMapClientTemplate().insert("MaElementRelationRule.insertElementRelationRule", relationRule);  }  public void updateElementRelationRule(MaElementRelationRule relationRule) {    this.getSqlMapClientTemplate().update("MaElementRelationRule.updateElementRealtionRule", relationRule);  }  public String getElementRelationId() {    BigDecimal relationId = (BigDecimal) getSqlMapClientTemplate().queryForObject(    "MaElementRelationRule.getElementRelationId");    return relationId.toString();  }  public String getElementEntryId() {    BigDecimal relationId = (BigDecimal) getSqlMapClientTemplate().queryForObject(    "MaElementRelationRule.getElementEntityId");    return relationId.toString();  }  public void insertElementRelationEntry(final MaElementRelationRuleEntry ruleEntry) {    // TODO Auto-generated method stub    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {        // TODO Auto-generated method stub        List details = new ArrayList();        details.addAll(ruleEntry.getSrcElementList());        details.addAll(ruleEntry.getDestElementList());        executor.startBatch();        MaElementRelationRuleDetail detail = null;        for (int i = 0; i < details.size(); i++) {          detail = (MaElementRelationRuleDetail) details.get(i);          executor.insert("MaElementRelationRule.insertElementRelationDetail", detail);        }        executor.executeBatch();        return null;      }    });  }  public void updateElementRelationEntry(MaElementRelationRuleEntry ruleEntry) {    // TODO Auto-generated method stub    deleteRelationEntryByEntryId(ruleEntry.getEntryId());    insertElementRelationEntry(ruleEntry);  }}