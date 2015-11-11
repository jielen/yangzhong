package com.ufgov.zc.client.zc;import java.awt.Component;import java.awt.Desktop;import java.awt.Dimension;import java.awt.GraphicsConfiguration;import java.awt.GraphicsDevice;import java.awt.GraphicsEnvironment;import java.awt.Insets;import java.awt.Toolkit;import java.io.BufferedInputStream;import java.io.File;import java.io.FileInputStream;import java.io.IOException;import java.io.Serializable;import java.lang.reflect.Field;import java.lang.reflect.Method;import java.math.BigDecimal;import java.net.URI;import java.text.DecimalFormat;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Arrays;import java.util.Date;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.swing.JOptionPane;import javax.swing.JTable;import javax.swing.table.TableColumn;import javax.swing.table.TableColumnModel;import org.apache.poi.hssf.usermodel.HSSFCell;import org.apache.poi.hssf.usermodel.HSSFDateUtil;import org.apache.poi.hssf.usermodel.HSSFRow;import org.apache.poi.hssf.usermodel.HSSFSheet;import org.apache.poi.hssf.usermodel.HSSFWorkbook;import org.apache.poi.poifs.filesystem.POIFSFileSystem;import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;import com.ufgov.zc.client.common.AsOptionMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.JTablePanel;import com.ufgov.zc.client.component.WorkflowTrace;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.table.BeanTableModel;import com.ufgov.zc.client.component.table.ColumnBeanPropertyPair;import com.ufgov.zc.client.component.ui.AbstractEditListBill;import com.ufgov.zc.common.commonbiz.fieldmap.FieldMapRegister;import com.ufgov.zc.common.commonbiz.model.BillElement;import com.ufgov.zc.common.commonbiz.model.WfAware;import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.system.constants.ZcEvalFiled;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.BeanUtil;import com.ufgov.zc.common.zc.model.ZcBaseBill;import com.ufgov.zc.common.zc.model.ZcQb;import com.ufgov.zc.common.zc.model.ZcQbBi;import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;public class ZcUtil {  private static final String ZC_FIELD_TRANS = "ZC_FIELD_";  public static final String dir = AsOptionMeta.getOptVal("OPT_ZC_FILE_TEMP");  //  public static final String attachPath = AsOptionMeta.getOptVal("OPT_ZC_ATTACH_PATCH");  /**   * 招投标书文件存放目录   */  public static final String ZTB_FILE_DIR = "ztb";  public static String getZcFileTempDir() {    File file = new File(dir);    try {      if (!file.exists()) {        file.mkdirs();      }    } catch (Exception ex) {      ex.printStackTrace();    }    return file.getAbsolutePath();  }  public static void showTraceDialog(List beanList, AbstractEditListBill comp) {    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(comp, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    if (beanList.size() > 1) {      JOptionPane.showMessageDialog(comp, "只能选择一条数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    WfAware bean = (WfAware) beanList.get(0);    //    WorkflowTrace.showTraceDialog(bean.getProcessInstId());    showTraceDialog(bean, comp.getToolBar().getCompoId());  }  public static void showTraceDialog(WfAware bean, String compoId) {    Map params = new HashMap();    params.put("compoId", compoId);    params.put("instanceId", bean.getProcessInstId());    params.put("sn", fetchMethodValue(bean, "getSn"));    params.put("projCode", fetchMethodValue(bean, "getProjCode"));//    System.out.println(params);    //    WorkflowTrace.showTraceDialog(params);    WorkflowTrace.showTraceDialog(bean.getProcessInstId());  }  public static Object fetchMethodValue(Object o, String methodName) {    try {      Method m = o.getClass().getMethod(methodName);      return m.invoke(o);    } catch (Exception e) {      System.out.println(e.getMessage());      return null;    }  }  public static Object fetchFieldValue(Object o, String fieldName) {    try {      Field f = o.getClass().getDeclaredField(fieldName);      return f.get(o);    } catch (Exception e) {      e.printStackTrace();      return null;    }  }  private static String translate(String identifier, String prefix) {    return LangTransMeta.translate(prefix + identifier);  }  public static void translateColName(JTable table, String prefix) {    TableColumnModel tcm = table.getColumnModel();    for (int i = 0; i < tcm.getColumnCount(); i++) {      TableColumn tableColumn = tcm.getColumn(i);      String identifier = (String) tableColumn.getIdentifier();      tableColumn.setHeaderValue(translate(identifier, prefix));      tableColumn.setIdentifier(identifier);    }  }  public static void translateColName(JTable table, List<ColumnBeanPropertyPair> columnBeans) {    table.getTableHeader().setReorderingAllowed(false);    for (ColumnBeanPropertyPair c : columnBeans) {      TableColumn tableColumn = table.getColumn(c.getColumnIdentifier());      tableColumn.setHeaderValue(c.getHeaderValue());      tableColumn.setIdentifier(c.getColumnIdentifier());    }  }  /**   *   * @Description: 编辑表格字段翻译。  * @return void   * @since 1.0   */  public static void translateColName(JTable table) {    TableColumnModel tcm = table.getColumnModel();    for (int i = 0; i < tcm.getColumnCount(); i++) {      TableColumn tableColumn = tcm.getColumn(i);      String identifier = (String) tableColumn.getIdentifier();      tableColumn.setHeaderValue(translate(identifier));      tableColumn.setIdentifier(identifier);      if (ZcEvalFiled.FIELD_NAME_ITEM_NAME.equals(identifier)) {        tableColumn.setPreferredWidth(200);      }      if (ZcEvalFiled.FIELD_NAME_DESCRIPTION.equals(identifier)) {        tableColumn.setPreferredWidth(300);      }    }  }  public static String translate(String identifier) {    return LangTransMeta.translate(ZC_FIELD_TRANS + identifier);  }  public static String safeString(Object o) {    return o == null ? "" : o.toString();  }  /**   * 校验要素字段   * @param notNullField (BillElement)   * @param obj   * @return true 校验失败   */  public static String validateBillElementNull(Object bill, List notNullField) {    StringBuilder returnInfo = new StringBuilder();    BillElement billelement = null;    for (int i = 0; i < notNullField.size(); i++) {      billelement = (BillElement) notNullField.get(i);      String fieldName = null;      Object result = null;      try {        fieldName = (String) FieldMapRegister.get(bill.getClass()).get(billelement.getElementCode());        result = BeanUtil.get(fieldName, bill);      } catch (RuntimeException e) {        fieldName = ZcUtil.convertColumnToField(billelement.getElementCode());        result = BeanUtil.get(fieldName, bill);      } catch (Exception e) {        throw new RuntimeException("没有找到字段" + fieldName + "对应的Bean属性");      }      String resName = billelement.getElementName();      if (billelement.getElementCode().equalsIgnoreCase("PAYTYPE_CODE") || billelement.getElementCode().equalsIgnoreCase("FUND_CODE")      || billelement.getElementCode().equalsIgnoreCase("ORIGIN_CODE")) {        if (result.toString().trim().equals("1")) {          returnInfo.append("[").append(resName).append("] ").append("不允许为空！\n");        }      }      //采购组织形式不允许为空的判断 update  humina      if (billelement.getElementCode().equalsIgnoreCase("ZC_MAKE_SEQUENCE")) {        if (result.toString().trim().equals("4")) {          returnInfo.append("[").append(resName).append("] ").append("不允许为空！\n");        }      }      if (result == null || result.toString().trim().equals("")) {        //暂时通过手工设置的方法取消对以下两个字段的非空检验        if (!(billelement.getElementId().equals("ZC_P_PRO_MAKE_ZC_FGKZBFS_SMWJ") || billelement.getElementId().equals("ZC_P_PRO_MAKE_ZC_AGEY_CODE"))) {          returnInfo.append("[").append(resName).append("] ").append("不允许为空！\n");        }      } else {        if (result instanceof BigDecimal) {          if (((BigDecimal) result).signum() == 0) {            returnInfo.append("[").append(resName).append("] ").append("不能为零！\n");          }        } else if (result instanceof Integer) {          if (((Integer) result).intValue() == 0) {            returnInfo.append("[").append(resName).append("] ").append("不能为零！\n");          }        }      }    }    return returnInfo.toString();  }  public static String validateDetailBillElementNull(List detailData, List notNullField, boolean isAllowEmpty) {    String returnInfo = new String();    if (!isAllowEmpty && (detailData == null || detailData.size() == 0)) {      returnInfo = "必须填写记录！";    } else {      for (Object bill : detailData) {        returnInfo = validateBillElementNull(bill, notNullField);        if (returnInfo.length() != 0) {          break;        }      }    }    return returnInfo;  }  /**  * @Description: (FieldToMod:数据库字段转JAVA字段)  * @return String 返回类型  * @since 1.0  */  public static String convertColumnToField(String inColumn) {    String field = "";    String[] strVals = inColumn.split("_");    for (String str : strVals) {      field += str.substring(0, 1) + str.substring(1).toLowerCase();    }    return (field.substring(0, 1).toLowerCase() + field.substring(1));  }  /**   * @Description: (FieldToMod:JAVA字段转数据库字段)   * @return String 返回类型   * @since 1.0   */  public static String convertFieldToColumn(String inField) {    String field = "";    for (int i = 0; i < inField.length(); i++) {      char c = inField.charAt(i);      if (Character.isUpperCase(c)) {        field = field.concat("_" + String.valueOf(c));      } else {        field = field.concat(String.valueOf(c));      }    }    return field.toUpperCase();  }  /**   * 设置编辑界面上按钮的不同页面状态和单据业务状态下的可用性，目前不支持对工作流按钮的可用性控制   * @param btnStatusList 按钮状态对象集合   * @param billStatus 单据的当前业务状态   * @param pageStatus 单据的当前页面状态   * @param compoId 部件名称   * @param processInstId 工作流示例id   * chenjl   * 2010-5-14   */  public static synchronized void setButtonEnable(ArrayList<ButtonStatus> btnStatusList, String billStatus, String pageStatus, String compoId,  Long processInstId) {    if (btnStatusList == null)      return;    for (ButtonStatus bt : btnStatusList) {      boolean funcEnabled = false;      //没有设置页面状态或者设置成全部页面状态或者包含有当前的页面状态，则设置为可用      if (bt.getPageStatus().size() == 0 || bt.getPageStatus().contains(ZcSettingConstants.PAGE_STATUS_ALL)      || bt.getPageStatus().contains(pageStatus)) {        funcEnabled = true;      }      //设置了单据状态并且页面状态满足并且单据状态没有设置成“全部单据状态”才判断单据状态的条件      if (bt.getBillStats().size() > 0 && !bt.getBillStats().contains(ZcSettingConstants.BILL_STATUS_ALL) && funcEnabled) {        funcEnabled = bt.getBillStats().contains(billStatus);      }      bt.getButton().setEnabled(funcEnabled);      //      if (funcEnabled) {      //        //bt.getButton().setVisible(true); // 先注释掉，框架的按钮是由权限，和工作流控制，此处加入显示功能，会影响很多模块的按钮 updated by wangwei 2011-10-17      //      } else {      //        bt.getButton().setVisible(false);      //      }    }  }  public static void setWfNodeEnableFunc(JFuncToolBar toolBar, List enableFuncs, long processInstId, RequestMeta requestMeta) {    if (toolBar != null) {      String funcId;      IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,      "baseDataServiceDelegate");      boolean isEnd = baseDataServiceDelegate.isFinalAudit(processInstId, requestMeta);      for (Component button : toolBar.getComponents()) {        funcId = ((FuncButton) button).getFuncId();        // 不参与控制的按钮        if (funcId == null || "".equals(funcId.trim()) || "fprint_preview".equals(funcId) || "fprn_tpl_set".equals(funcId) || "fprint".equals(funcId)        || "fjingJiaGongGao".equals(funcId) || "fconfirmsup".equals(funcId) || "fchengJiaoGongGao".equals(funcId) || "fchengjiao".equals(funcId)          || "fprint_xunjia_total_preview".equals(funcId) || "fprint_xunjia_detail_preview".equals(funcId) || "fview".equals(funcId)          || "fdelayBid".equals(funcId) || "frejectBid".equals(funcId) || "fforceOpenBid".equals(funcId) || "fsendAuditTrashPrice".equals(funcId)          || "fsendAuditConstraintOpPri".equals(funcId) || "fdisplay".equals(funcId) || "fopenNotepad".equals(funcId)) {          continue;        }        if (isEnd && !"fshowinstancetrace".equals(funcId) && !"funaudit".equals(funcId)) {          button.setVisible(false);          continue;        }        // 流程跟踪永远显示        if ("fshowinstancetrace" == funcId) {          button.setVisible(true);          continue;        }        if (enableFuncs.contains(funcId)) {          button.setVisible(true);        } else {          button.setVisible(false);        }      }      FuncButton callbackButton = toolBar.getButtonByFuncId("fcallback");      if (callbackButton != null) {        if (enableFuncs.contains("fnewcommit") || enableFuncs.contains("fautocommit") || enableFuncs.contains("fmanualcommit")        || enableFuncs.contains("fagreecommit") || enableFuncs.contains("fsendtoxieban") || enableFuncs.contains("fsendprocuunit")        || enableFuncs.contains("fsendrecord") || enableFuncs.contains("fauditfinal")) {          // 如果【送审按钮】、【手动提交】、【自动提交】存在，就隐藏【收回按钮】          callbackButton.setVisible(false);        } else {          if (isEnd) {            callbackButton.setVisible(false);          }        }      }      FuncButton unAuditButton = toolBar.getButtonByFuncId("funaudit");      if (unAuditButton != null) {        if (!isEnd) {          unAuditButton.setVisible(false);        }      }    }  }  public static void translateColName(JTable table, Map nameMap) {    TableColumnModel tcm = table.getColumnModel();    for (int i = 0; i < tcm.getColumnCount(); i++) {      TableColumn tableColumn = tcm.getColumn(i);      String identifier = (String) tableColumn.getIdentifier();      tableColumn.setHeaderValue(nameMap.get(identifier));      tableColumn.setIdentifier(identifier);    }  }  /**   * 获取序列的下一个值   * @param sequenceName 序列名称，如果为空，则从通用序列中获取   * @return   * Administrator   * 2010-10-23   */  public static synchronized String getSequenceNextVal(String sequenceName) {    if (sequenceName == null || sequenceName.trim().equals("")) {      sequenceName = ZcSettingConstants.SEQUENCE_ZC_BASE;    }    IZcEbBaseServiceDelegate baseDataServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,    "zcEbBaseServiceDelegate");    return baseDataServiceDelegate.getSequenceNextVal(sequenceName, WorkEnv.getInstance().getRequestMeta());  }  /**   * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位   *    * @author patriotlml   * @param String   *            origin, 原始字符串   * @param int   *            len, 截取长度(一个汉字长度按2算的)   * @return String, 返回的字符串   */  public static String substring(String origin, int len) {    return substring(origin, len, null);  }  public static String substring(String origin, int len, String fix) {    if (origin == null || origin.equals("") || len < 1)      return "";    byte[] strByte = new byte[len];    if (len >= length(origin)) {      return origin;    }    System.arraycopy(origin.getBytes(), 0, strByte, 0, len);    int count = 0;    for (int i = 0; i < len; i++) {      int value = (int) strByte[i];      if (value < 0) {        count++;      }    }    if (count % 2 != 0) {      len = (len == 1) ? ++len : --len;    }    return new String(strByte, 0, len) + fix;  }  /**   * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）   *    * @param char   *            c, 需要判断的字符   * @return boolean, 返回true,Ascill字符   */  public static boolean isLetter(char c) {    int k = 0x80;    return c / k == 0 ? true : false;  }  /**   * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1   *    * @param String   *            s ,需要得到长度的字符串   * @return int, 得到的字符串长度   */  public static int length(String s) {    if (s == null)      return 0;    char[] c = s.toCharArray();    int len = 0;    for (int i = 0; i < c.length; i++) {      len++;      if (!isLetter(c[i])) {        len++;      }    }    return len;  }  public static boolean browse(URI uri) throws IOException {    try {      Desktop desktop = Desktop.getDesktop();      desktop.browse(uri);      return true;    } catch (SecurityException e) {      e.printStackTrace();    }    return false;  }  public static void exec(String comd) throws IOException {    Runtime.getRuntime().exec(comd);  }  public static boolean anyBrowse(String url) {    System.out.println("url=" + url);    String osName = System.getProperty("os.name");    try {      if (osName.startsWith("Mac OS")) {        Class fileMgr = Class.forName("com.apple.eio.FileManager");        Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] { String.class });        openURL.invoke(null, new Object[] { url });      } else if (osName.startsWith("Windows")) {        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);      } else { // assume Unix or Linux            String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };        String browser = null;        for (int count = 0; count < browsers.length && browser == null; count++) {          if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0) {            browser = browsers[count];          }        }        if (browser == null) {          throw new Exception("Could not find web browser");        } else {          Runtime.getRuntime().exec(new String[] { browser, url });        }      }      return true;    } catch (Exception ex) {      System.out.println("打开浏览器时出错:" + ex.getMessage());      JOptionPane.showMessageDialog(null, "打开浏览器时出错:" + ex.getLocalizedMessage());      return false;    }  }  /**   *   * @Description: 工具方法：将Component移到屏幕中央  * @return void 返回类型  * @since 1.0   */  public static void moveComponentToScreenCenter(Component component) {    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();    Dimension frameSize = component.getSize();    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();    GraphicsDevice gs = ge.getDefaultScreenDevice();    GraphicsConfiguration gc = gs.getDefaultConfiguration();    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);    if (frameSize.height > screenSize.height) {      frameSize.height = screenSize.height;    }    if (frameSize.width > screenSize.width) {      frameSize.width = screenSize.width;    }    component.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - insets.bottom - frameSize.height) / 2);  }  /**   *   * @Description: 工具方法 设置Component最大化显示  * @return void 返回类型  * @since 1.0   */  public static void setMaxSizeWindow(Component component) {    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();    GraphicsDevice gs = ge.getDefaultScreenDevice();    GraphicsConfiguration gc = gs.getDefaultConfiguration();    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();    component.setSize(screenSize.getSize().width, screenSize.getSize().height - insets.bottom);  }  /**   *    * @param oriAuditFlag   * @param opflag      具体操作，0同意，1,不同意   * @param requestMeta   * @return   */  public static int getAuditFlagValue(Integer oriAuditFlag, int opflag, RequestMeta requestMeta) {    oriAuditFlag = oriAuditFlag == null ? 0 : oriAuditFlag;    int flag = oriAuditFlag;    String jianduzhuren = AsOptionMeta.getOptVal("OPT_JIANDU_ZR");    if (opflag == 0) {//同意      if (requestMeta.getSvUserID().equals(jianduzhuren)) {//监审主任，用十位        if (flag / 10 == 0) {          flag = flag + 10;        }      } else {//主管主任，用个位        if (flag % 10 == 0) {          flag += 1;        }      }    } else {//不同意      if (requestMeta.getSvUserID().equals(jianduzhuren)) {//监审主任，用十位        if (flag / 10 == 1) {          flag = flag - 10;        }      } else {//主管主任，用个位        if (flag % 10 == 1) {          flag = flag / 10 * 10;        }      }    }    return flag;  }  public static void fitColumnWidth(JPageableFixedTable table) {    for (int j = 0; j < table.getColumnModel().getColumnCount(); j++) {      table.getTableHeader().fitColumnWidth(j);    }  }  /*   * 从表的添加行方法   */  public static int addSub(JTablePanel tablePanel, Serializable bean) {    tablePanel.getTable().clearSelection();    if (tablePanel.getTable().isEditing()) {      tablePanel.getTable().getCellEditor().stopCellEditing();    }    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable()    .getModel();    editTableModel.insertRow(editTableModel.getRowCount(), bean);    fitColumnWidth(tablePanel.getTable());    return editTableModel.getRowCount() - 1;  }  /*   * 从表的插入行方法   */  public static int insertSub(JTablePanel tablePanel, Serializable bean) {    if (tablePanel.getTable().isEditing()) {      tablePanel.getTable().getCellEditor().stopCellEditing();    }    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable()    .getModel();    int selectedRow = tablePanel.getTable().getSelectedRow();    if (selectedRow != -1) {      editTableModel.insertRow(selectedRow + 1, bean);      selectedRow = selectedRow + 1;    } else {      editTableModel.insertRow(editTableModel.getRowCount(), bean);      selectedRow = editTableModel.getRowCount() - 1;    }    fitColumnWidth(tablePanel.getTable());    return selectedRow;  }  /*   * 从表的删除行方法   */  public static Integer[] deleteSub(JTablePanel tablePanel, Component parentComponent) {    JPageableFixedTable table = tablePanel.getTable();    Integer[] checkedRows;    // 是否显示行选择框    if (tablePanel.getTable().isShowCheckedColumn()) {      checkedRows = table.getCheckedRows();    } else {      int[] selectedRows = table.getSelectedRows();      checkedRows = new Integer[selectedRows.length];      for (int i = 0; i < checkedRows.length; i++) {        checkedRows[i] = selectedRows[i];      }    }    if (checkedRows.length == 0) {      JOptionPane.showMessageDialog(parentComponent, "没有选择数据！", "提示",      JOptionPane.INFORMATION_MESSAGE);    } else {      if (table.isEditing()) {        table.getCellEditor().stopCellEditing();      }      BeanTableModel tableModel = (BeanTableModel) table.getModel();      int[] selRows = new int[checkedRows.length];      for (int i = 0; i < selRows.length; i++) {        selRows[i] = table.convertRowIndexToModel(checkedRows[i]);      }      Arrays.sort(selRows);      for (int i = selRows.length - 1; i >= 0; i--) {        tableModel.deleteRow(selRows[i]);      }    }    fitColumnWidth(tablePanel.getTable());    return checkedRows;  }  //获取当前服务器的时间  public static Date getServerSysDate(RequestMeta requestMeta) {    IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,      "baseDataServiceDelegate");    Date sysDate = baseDataServiceDelegate.getSysDate(requestMeta);    return sysDate;  }  /**   * 返回当前用户是否供应商   * @return   */  public static boolean isGys() {    if (WorkEnv.getInstance().containRole(ZcSettingConstants.ROLE_GYS_HUIYUAN)      || WorkEnv.getInstance().containRole(ZcSettingConstants.ROLE_GYS_NORMAL)) {      return true;    }    return false;  }  /**   * 返回当前用户是否预算单位   * @return   */  public static boolean isYsdw() {    if (WorkEnv.getInstance().containRole(ZcSettingConstants.ROLE_YSDWJB) || WorkEnv.getInstance().containRole(ZcSettingConstants.ROLE_YSDWFZ)) {      return true;    }    return false;  }  public static boolean useBudget() {    return "Y".equalsIgnoreCase(AsOptionMeta.getOptVal(ZcSettingConstants.OPT_ZC_USE_BUDGET_INTERFACE));  }  public static boolean usePay() {    return "Y".equalsIgnoreCase(AsOptionMeta.getOptVal(ZcSettingConstants.OPT_ZC_USE_PAY_INTERFACE));  }  public static String[][] getExcelData(File excelFile, int ignoreRows) throws IOException {    List<String[]> result = new ArrayList<String[]>();    int rowSize = 0;    BufferedInputStream in = new BufferedInputStream(new FileInputStream(    excelFile));    // 打开HSSFWorkbook    POIFSFileSystem fs = new POIFSFileSystem(in);    HSSFWorkbook wb = new HSSFWorkbook(fs);    HSSFCell cell = null;    for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {      HSSFSheet st = wb.getSheetAt(sheetIndex);      // 第一行为标题，不取      for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {        HSSFRow row = st.getRow(rowIndex);        if (row == null) {          continue;        }        int tempRowSize = row.getLastCellNum() + 1;        if (tempRowSize > rowSize) {          rowSize = tempRowSize;        }        String[] values = new String[rowSize];        Arrays.fill(values, "");        boolean hasValue = false;        for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {          String value = "";          cell = row.getCell(columnIndex);          if (cell != null) {            // 注意：一定要设成这个，否则可能会出现乱码            cell.setEncoding(HSSFCell.ENCODING_UTF_16);            switch (cell.getCellType()) {            case HSSFCell.CELL_TYPE_STRING:              value = cell.getStringCellValue();              break;            case HSSFCell.CELL_TYPE_NUMERIC:              if (HSSFDateUtil.isCellDateFormatted(cell)) {                Date date = cell.getDateCellValue();                if (date != null) {                  value = new SimpleDateFormat("yyyy-MM-dd")                  .format(date);                } else {                  value = "";                }              } else {                value = new DecimalFormat("0").format(cell                .getNumericCellValue());              }              break;            case HSSFCell.CELL_TYPE_FORMULA:              // 导入时如果为公式生成的数据则无值              if (!cell.getStringCellValue().equals("")) {                value = cell.getStringCellValue();              } else {                value = cell.getNumericCellValue() + "";              }              break;            case HSSFCell.CELL_TYPE_BLANK:              break;            case HSSFCell.CELL_TYPE_ERROR:              value = "";              break;            case HSSFCell.CELL_TYPE_BOOLEAN:              value = (cell.getBooleanCellValue() == true ? "Y"              : "N");              break;            default:              value = "";            }          }          if (columnIndex == 0 && value.trim().equals("")) {            break;          }          values[columnIndex] = value == null ? null : value.trim();          hasValue = true;        }        if (hasValue) {          result.add(values);        }      }    }    in.close();    String[][] returnArray = new String[result.size()][rowSize];    for (int i = 0; i < returnArray.length; i++) {      returnArray[i] = (String[]) result.get(i);    }    return returnArray;  }  public static BigDecimal tranToBigdecimal(String str) {    // TODO Auto-generated method stub    if(str==null)return BigDecimal.ZERO;    return new BigDecimal(str);  }}