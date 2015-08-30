package com.ufgov.zc.server.zc.dao.ibatis;import java.sql.SQLException;import java.util.HashMap;import java.util.List;import java.util.Map;import org.apache.log4j.Logger;import org.springframework.orm.ibatis.SqlMapClientCallback;import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;import com.ibatis.sqlmap.client.SqlMapExecutor;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcEbFormula;import com.ufgov.zc.common.zc.model.ZcEbFormulaItem;import com.ufgov.zc.common.zc.model.ZcEbFormulaPackPlain;import com.ufgov.zc.common.zc.model.ZcEbFormulaParam;import com.ufgov.zc.server.zc.dao.IZcEbFormulaDao;public class ZcEbFormulaDao extends SqlMapClientDaoSupport implements		IZcEbFormulaDao {	private static final Logger log = Logger.getLogger(ZcEbFormulaDao.class);	public List getZcEbFormulaList(ElementConditionDto dto) {		return this.getSqlMapClientTemplate().queryForList(				"ZcEbFormula.getZcEbFormulaList", dto);	}	public List getZcEbFormulaItemList(String formulaCode,			ElementConditionDto dto) {		return this.getSqlMapClientTemplate().queryForList(				"ZcEbFormula.getZcEbFormulaItemList", formulaCode);	}	public List getZcEbFormulaItemList(Map map) {		return this.getSqlMapClientTemplate().queryForList(				"ZcEbFormula.getZcEbFormulaItemList", map);	}	public List getZcEbFormulaParamList(String formulaCode) {		return this.getSqlMapClientTemplate().queryForList(				"ZcEbFormula.getZcEbFormulaParamList", formulaCode);	}	public int deleteZcEbFormulaById(String zcEbFormulaCode) {		return this.getSqlMapClientTemplate().delete(				"ZcEbFormula.deleteZcEbFormula", zcEbFormulaCode);	}	public int deleteZcEbFormulaItemById(String itemcode) {		return this.getSqlMapClientTemplate().delete(				"ZcEbFormula.deleteZcEbFormulaItem", itemcode);	}	public int deleteZcEbFormulaItemByFormulaCode(String formulaCode) {		return this.getSqlMapClientTemplate().delete(				"ZcEbFormula.deleteZcEbFormulaItemByFormulaCode", formulaCode);	}	public int deleteZcEbFormulaParamById(String formulaCode) {		return this.getSqlMapClientTemplate().delete(				"ZcEbFormula.deleteZcEbFormulaParam", formulaCode);	}	public ZcEbFormula getZcEbFormula(String packCode) {		return (ZcEbFormula) this.getSqlMapClientTemplate().queryForObject(				"ZcEbFormula.getZcEbFormula", packCode);	}	public ZcEbFormulaItem getZcEbFormulaItem(String formulaCode,			String itemCode) {		Map ParamaterMap = new HashMap();		ParamaterMap.put("formulaCode", formulaCode);		ParamaterMap.put("itemCode", itemCode);		return (ZcEbFormulaItem) this.getSqlMapClientTemplate().queryForObject(				"ZcEbFormula.getZcEbFormulaItem", ParamaterMap);	}	public ZcEbFormulaParam getZcEbFormulaParam(String formulaCode,			String paramCode) {		return null;	}	public void insertZcEbFormulaParam(ZcEbFormulaParam zcEbFormulaParam) {		this.getSqlMapClientTemplate().insert(				"ZcEbFormula.insertZcEbFormulaParam", zcEbFormulaParam);	}	public List getZcEbFormulaItemByPcode(String formulaCode, String pcode) {		Map ParamaterMap = new HashMap();		ParamaterMap.put("formulaCode", formulaCode);		ParamaterMap.put("pcode", pcode);		return this.getSqlMapClientTemplate().queryForList(				"ZcEbFormula.getZcEbFormulaItemListByPcode", ParamaterMap);	}	public ZcEbFormula updateZcEbFormula(ZcEbFormula zcEbFormula) {		this.getSqlMapClientTemplate().update("ZcEbFormula.updateZcEbFormula",				zcEbFormula);		return zcEbFormula;	}	public ZcEbFormulaItem updateZcEbFormulaItem(ZcEbFormulaItem zcEbFormulaItem) {		this.getSqlMapClientTemplate().update(				"ZcEbFormula.updateZcEbFormulaItem", zcEbFormulaItem);		return zcEbFormulaItem;	}	public void updateZcEbFormulaParam(ZcEbFormulaParam zcEbFormulaParam) {		this.getSqlMapClientTemplate().update(				"ZcEbFormula.updateZcEbFormulaParam", zcEbFormulaParam);	}	public ZcEbFormula insertZcEbFormula(ZcEbFormula zcEbFormula) {		this.getSqlMapClientTemplate().insert("ZcEbFormula.insertZcEbFormula",				zcEbFormula);		return zcEbFormula;	}	public ZcEbFormulaItem insertZcEbFormulaItem(ZcEbFormulaItem zcEbFormulaItem) {		this.getSqlMapClientTemplate().insert(				"ZcEbFormula.insertZcEbFormulaItem", zcEbFormulaItem);		return zcEbFormulaItem;	}	public ZcEbFormulaItem insertZcEbFormulaItemByTemplate(			ZcEbFormulaItem zcEbFormulaItem) {		this.getSqlMapClientTemplate().insert(				"ZcEbFormula.insertZcEbFormulaItemByTemplate", zcEbFormulaItem);		return zcEbFormulaItem;	}	public int isExistsByItemName(String formulaCode, String itemName,			String itemCode) {		Map ParamaterMap = new HashMap();		ParamaterMap.put("formulaCode", formulaCode);		ParamaterMap.put("itemName", itemName);		ParamaterMap.put("itemCode", itemCode);		List list = this.getSqlMapClientTemplate().queryForList(				"ZcEbFormula.getZcEbFormulaItemByName", ParamaterMap);		return list.size();	}	public ZcEbFormula getZcEbFormulaByPackCode(ElementConditionDto dto) {		return (ZcEbFormula) this.getSqlMapClientTemplate().queryForObject(				"ZcEbFormula.getZcEbFormulaByPackCode", dto);	}	public List getZcEbFormulaListByProjCode(ElementConditionDto dto) {		return this.getSqlMapClientTemplate().queryForList(				"ZcEbFormula.getZcEbFormulaByPackCode", dto);	}	/**	 * 	 * 	 * 	 * @Description: 批量插入评审指标项	 * 	 * @return void 返回类型	 * 	 * @since 1.0	 */	public void insertZcEbFormulaItemList(final List list,			final String formulaCode) {		if (list != null) {			this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {				public Object doInSqlMapClient(SqlMapExecutor executor)						throws SQLException {					executor.startBatch();					for (int i = 0; i < list.size(); i++) {						ZcEbFormulaItem item = (ZcEbFormulaItem) list.get(i);						item.setFormulaCode(formulaCode);						executor.insert("ZcEbFormula.insertZcEbFormulaItem",								list.get(i));					}					executor.executeBatch();					return null;				}			});		}	}	/**	 * 	 * 	 * 	 * @Description: 批量插入评审参数	 * 	 * @return void 返回类型	 * 	 * @since 1.0	 */	public void insertZcEbFormulaParamList(final List list,			final String formulaCode) {		if (list != null) {			this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {				public Object doInSqlMapClient(SqlMapExecutor executor)						throws SQLException {					executor.startBatch();					for (int i = 0; i < list.size(); i++) {						ZcEbFormulaParam param = (ZcEbFormulaParam) list.get(i);						param.setFormulaCode(formulaCode);						executor.insert("ZcEbFormula.insertZcEbFormulaParam",								list.get(i));					}					executor.executeBatch();					return null;				}			});		}	}	public int deleteZcEbFormulaByPackCode(String packCode) {		return this.getSqlMapClientTemplate().delete(				"ZcEbFormula.deleteZcEbFormulaByPackCode", packCode);	}	/**	 * <p>	 * 更新评标方法项目名称和代码：	 * </p>	 * 	 * @param formula	 * @see com.ufgov.zc.server.zc.dao.IZcEbFormulaDao#updateFormulaProj(com.ufgov.zc.common.zc.model.ZcEbFormula)	 * @author yuzz	 * @since Sep 22, 2012 3:33:29 PM	 */	public void updateFormulaProj(ZcEbFormula formula) {		this.getSqlMapClientTemplate().update(				"ZcEbFormula.updateZcEbFormulaProj", formula);	}	public int deleteFormulaPackPlain(HashMap map) {		// TODO Auto-generated method stub		return this.getSqlMapClientTemplate().delete(				"ZcEbFormula.deleteFormulaPackPlain", map);	}	public int deleteFormulaPackPlainByPackCode(String packCode) {		// TODO Auto-generated method stub		return this.getSqlMapClientTemplate().delete(				"ZcEbFormula.deleteFormulaPackPlainByPackCode", packCode);	}	public void insertFormulaPackPlain(ZcEbFormulaPackPlain p) {		// TODO Auto-generated method stub		this.getSqlMapClientTemplate().insert(				"ZcEbFormula.insertFormulaPackPlain", p);	}     public List getFormulaPackPlainList(String formulaCode) {    // TODO Auto-generated method stub    return this.getSqlMapClientTemplate().queryForList(      "ZcEbFormula.getFormulaPackPlainList", formulaCode);  } }