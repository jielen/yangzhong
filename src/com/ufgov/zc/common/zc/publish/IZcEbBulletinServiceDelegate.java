package com.ufgov.zc.common.zc.publish;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.Publishable;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.exception.BusinessException;import com.ufgov.zc.common.zc.model.ZcEbBulletin;import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;import com.ufgov.zc.common.zc.model.ZcJingJiaModel;public interface IZcEbBulletinServiceDelegate extends Publishable {	/**	 * 	 * 获得招标公告列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinBid(ElementConditionDto dto, RequestMeta meta);	public List getZcEbBulletinBidForExp(ElementConditionDto dto,			RequestMeta meta);	/**	 * 	 * 获得招标公告领导审核列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinBidDir(ElementConditionDto dto, RequestMeta meta);	/**	 * 	 * 获得变更公告列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinChg(ElementConditionDto dto, RequestMeta meta);	/**	 * 	 * 获得变更公告领导审核列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinChgDir(ElementConditionDto dto, RequestMeta meta);	/**	 * 	 * 获得暂停公告列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinSpd(ElementConditionDto dto, RequestMeta meta);	/**	 * 	 * 获得暂停公告领导审核列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinSpdDir(ElementConditionDto dto, RequestMeta meta);	/**	 * 	 * 获得中标公告列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinWid(ElementConditionDto dto, RequestMeta meta);	/**	 * 	 * 获得中标公告领导审核列表	 * 	 * @param dto	 * 	 * @param meta	 */	public List getZcEbBulletinWidDir(ElementConditionDto dto, RequestMeta meta);	/**	 * 	 * 新建批量送审	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void newCommitFN(List bulletinList, RequestMeta meta);	/**	 * 	 * 批量送审	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void commitFN(List bulletinList, RequestMeta meta);	/**	 * 	 * 批量发布	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void publishBeanListFN(List bulletinList, RequestMeta meta,			String status);	/**	 * 	 * 批量删除	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void deleteBeanListFN(List bulletinList, RequestMeta meta);	/**	 * 	 * 新建送审	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void newCommitFN(ZcEbBulletin bulletin, RequestMeta meta);	/**	 * 	 * 送审	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void commitFN(ZcEbBulletin bulletin, RequestMeta meta);	/**	 * 	 * 批量消审	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void unAuditFN(List bulletinList, RequestMeta meta);	/**	 * 	 * 消审	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void unAudit(ZcEbBulletin bulletin, RequestMeta meta);	/**	 * 	 * 新增	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public ZcEbBulletin insertFN(ZcEbBulletin bulletin, RequestMeta meta)  throws BusinessException;	/**	 * 	 * 更新	 * 	 * @param bulletinList	 * 	 * @param meta	 */	public void updateFN(ZcEbBulletin bulletin, RequestMeta meta)  throws BusinessException;	/**	 * 	 * 删除	 * 	 * @param bulletin	 * 	 * @param meta	 */	public void deleteFN(ZcEbBulletin bulletin, RequestMeta meta);	/**	 * 	 * 发布公告到外网	 */	public boolean pubBulletinFN(String title, String creator, String href,			String pletIDs, RequestMeta meta, ZcEbBulletin tin);	public ZcEbProjZbFile getZcEbProjZbFile(String projCode, String type,			RequestMeta meta);	public List findTransData(ElementConditionDto dto, RequestMeta meta);	public String importTransData(Object o, RequestMeta meta);	public void updateFN(List beanList, RequestMeta requestMeta);	public ZcEbBulletin auditFN(ZcEbBulletin bulletin, RequestMeta requestMeta)			throws Exception;	public ZcEbBulletin callbackFN(ZcEbBulletin make, RequestMeta requestMeta);	public ZcEbBulletin untreadFN(ZcEbBulletin make, RequestMeta requestMeta);	public ZcEbBulletin unAuditFN(ZcEbBulletin make, RequestMeta requestMeta);	public ZcEbBulletin CancelMakeFN(ZcEbBulletin make, RequestMeta requestMeta);	public List getZcEbBulletinList(ElementConditionDto elementConditionDto,			RequestMeta requestMeta);	public List getZcEbBulletinProjList(			ElementConditionDto elementConditionDto, RequestMeta requestMeta);	public ZcEbBulletin sendRecordFN(ZcEbBulletin ht, RequestMeta requestMeta);	public ZcEbBulletin publishBulletinFN(ZcEbBulletin tin, String dir,			Map option, RequestMeta meta) throws Exception;	public ZcEbBulletin getZcEbBulletinByKey(String key, RequestMeta requestMeta);	public void updateIsExtrac(ZcEbBulletin bulletin, RequestMeta meta);	public String getRoleCodeById(String id, RequestMeta requestMeta);	public ZcJingJiaModel getZcJingJiaModel(String projCode, String fileId,			RequestMeta meta);}