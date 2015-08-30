package com.ufgov.zc.client.component.zc.dataexchange.model;import java.io.Serializable;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;/** * 每一个实例对象都将对应一个页签，页签内的行数据则在dataList中存放 * @author LEO * */public interface IBaseData extends Serializable {    public static final String EXPORT="OUT";    public static final String IMPORT="IN";  /**   * 必要时可以获得列头部   * @return   */  Map<String, String> getColumnHeadersMap();  /**   * 获得日志操作对象，该对象提供写日志和查询日志功能   * @return   */  ExchangeDataLogModel getExchangeDataLogModel();  /**   * 业务数据数组   * @return   */  List getDataList();  /**   * 业务数据对应的附件数据，必须支持每行数据里面有任意个附件的情况,每行对应一个Map，   * 以行记录唯一标识为key，每个Map里面以属性名称为key，对应一个AttachmentFile对象   * @return   */  Map<String, Map<String, AttachmentFile>> getAttachmentDataMap();  /**   * 1、先抓取数据库中的数据，获得的数据存放在dataList数组中   * 2、接着抓取相关的文件数据,需要检验本地是否存在响应的文件，或者是否从服务器中将文件下载到本地   * 3、完成数据抓取后，交给框架去压缩加密；   * @param dto   * @param meta   * @param saveRootPath 将抓取的文件存放到的目录   * @return 返回导出记录条数   */  int doExportData(ElementConditionDto dto, RequestMeta meta, String saveRootPath);  /**   * 导入时将数据保存到数据库中   * @param dto   * @param meta   * @return 返回导入的记录条数   */  int doImportData(ElementConditionDto dto, RequestMeta meta, String readRootPath);  /**   * 数据导出完成后，做一些善后处理工作，例如：修改被导出数据的状态   * @param dto   * @param meta   * @return   */  int doModifyDataStatus(ElementConditionDto dto, RequestMeta meta, String standby);}