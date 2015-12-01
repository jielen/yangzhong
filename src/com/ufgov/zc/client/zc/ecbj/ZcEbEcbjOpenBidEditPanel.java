/** * ZcEbOpenBidEditPanel.java * com.ufgov.gk.client.zc.openbid * Administrator * 2010-5-22 */package com.ufgov.zc.client.zc.ecbj;import java.awt.Color;import java.awt.Dimension;import java.awt.Font;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.io.File;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import javax.swing.BorderFactory;import javax.swing.JComponent;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JTabbedPane;import javax.swing.border.TitledBorder;import org.apache.log4j.Logger;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.button.EditButton;import com.ufgov.zc.client.component.button.ExitButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.button.NextButton;import com.ufgov.zc.client.component.button.OpenBidButton;import com.ufgov.zc.client.component.button.PreviousButton;import com.ufgov.zc.client.component.button.SaveButton;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.client.zc.ButtonStatus;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.activeztb.TbDocService;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.util.DigestUtil;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbEcbjItem;/** * @author Administrator * 二次报价管理 * */public class ZcEbEcbjOpenBidEditPanel extends AbstractMainSubEditPanel {  /**   *    */  private static final long serialVersionUID = -7096834819505641043L;  private static final Logger logger = Logger.getLogger(ZcEbEcbjOpenBidEditPanel.class);  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private String compoId = "ZC_EB_ECBJ_OPENBID";  private FuncButton saveButton = new SaveButton();  private FuncButton previousButton = new PreviousButton();  private FuncButton editButton = new EditButton();  private FuncButton nextButton = new NextButton();  private FuncButton exitButton = new ExitButton();  private FuncButton helpButton = new HelpButton();  private FuncButton openBidButton = new OpenBidButton();  private final ListCursor listCursor;  private ZcEbEcbjItem oldZcEcbjItem;  private ZcEbEcbjOpenBidList listPanel;  private ZcEbEcbjOpenBidEditPanel self = this;  private GkBaseDialog parent;  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;  JTabbedPane tabPane = new JTabbedPane();  private final String tabTitle = "投标一览表";  private String ecbjFileDownLoadPath;  private JPanel summaryPanel;  HashMap<String, JPanel> sumarryPanelCach = new HashMap<String, JPanel>();  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();  private TextFieldEditor openFailReason;  /**   * 招投标文件下载及解压处理类。   */  private TbDocService tb = new TbDocService();  public ZcEbEcbjOpenBidEditPanel(ZcEbEcbjOpenBidDialog parent, ListCursor listCursor, String tabStatus, ZcEbEcbjOpenBidList listPanel) {    this.listCursor = listCursor;    this.listPanel = listPanel;    this.parent = parent;    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate("二次报价开标管理"),    TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));    this.colCount = 2;    init();    requestMeta.setCompoId(compoId);    refreshData();    setButtonStatus();    updateFieldEditorsEditable();  }  public List<AbstractFieldEditor> createFieldEditors() {    // TCJLODO Auto-generated method stub    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();    TextFieldEditor editor0 = new TextFieldEditor("项目代码", "projCode");    editorList.add(editor0);    editor0 = new TextFieldEditor("项目名称", "projName");    editorList.add(editor0);    editor0 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_CODE), "packCode");    editorList.add(editor0);    editor0 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_NAME), "packName");    editorList.add(editor0);    editor0 = new TextFieldEditor("投标人", "providerName");    editorList.add(editor0);    editor0 = new TextFieldEditor("投标金额", "bjSumMask");    editorList.add(editor0);    editor0 = new TextFieldEditor("报价次数", "bjNo");    editorList.add(editor0);    openFailReason = new TextFieldEditor("开标失败原因", "openFailReason");    editorList.add(openFailReason);    AsValFieldEditor editor8 = new AsValFieldEditor("开标状态", "status", "ZC_VS_OPEN_BID_STATUS");    editorList.add(editor8);    return editorList;  }  @Override  public JComponent createSubBillPanel() {    this.tabPane = new JTabbedPane();    this.tabPane.addTab(this.tabTitle, new JPanel());    return this.tabPane;  }  private JPanel getSummaryPn(ZcEbEcbjItem ecbjItem) {    if (ecbjItem.getStatus() != null && (ecbjItem.getStatus().equals(ZcSettingConstants.FIELD_TRANS_ZC_BJ_OPEN))) {      final String key = ecbjItem.getFileId() + "_" + ecbjItem.getPackCode();      if (this.sumarryPanelCach.containsKey(key)) {        return this.sumarryPanelCach.get(key);      }      createSummaryPn(ecbjItem);    } else {      this.summaryPanel = new JPanel();      this.summaryPanel.setPreferredSize(new Dimension(600, 300));    }    return this.summaryPanel;  }  private JPanel createSummaryPn(ZcEbEcbjItem ecbjItem) {    File file = new File(tb.getFileDownloadPath() + File.separator + ecbjItem.getFileId());    if (!file.exists()) {      //获取报价金额            File asFile = tb.downLoadEcBjFile(ecbjItem.getFileId());      if (asFile == null) {        JPanel panel = new JPanel();        String info = "因为数据库中缺少对应的再次报价表文件数据，此次无法显示具体报价情况...";        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), info, TitledBorder.CENTER, TitledBorder.TOP, new Font(        "宋体", Font.BOLD, 15), Color.RED));        panel.setPreferredSize(new Dimension(600, 300));        return panel;      }      ecbjItem.setBjSum(tb.getEcbjSum(file));      ecbjItem.setPromiseWorkDate(tb.getWorkDate(file));    }    List<String> paramList = new ArrayList<String>();    paramList.add(ecbjItem.getProjName());    paramList.add(ecbjItem.getPackName());    paramList.add(GV.NODE_NAME_TBYLB);    paramList.add("Y");    summaryPanel = tb.getEcbjSummaryTable(file, paramList);    sumarryPanelCach.put(ecbjItem.getFileId() + "_" + ecbjItem.getPackCode(), summaryPanel);    return summaryPanel;  }  public void deleteFile(File file) {    if (null != file) {      if (file.isDirectory()) {        File files[] = file.listFiles();        for (File f : files) {          System.out.println(f.getAbsolutePath());          deleteFile(f);        }        file.delete();      } else {        file.delete();      }    }  }  /**   * 设置工具条上按钮的可用性   *    * Administrator   * 2010-5-15   */  private void setButtonStatus() {    if (this.btnStatusList.size() == 0) {      ButtonStatus bs = new ButtonStatus();      bs.setButton(this.editButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus("1");      bs.addBillStatus("2");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.saveButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);      bs.addBillStatus("1");      bs.addBillStatus("2");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.openBidButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus("0");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.exitButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.helpButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.previousButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.nextButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);    }    ZcEbEcbjItem obj = (ZcEbEcbjItem) (this.listCursor.getCurrentObject());    String billStatus = obj.getStatus();    ZcUtil.setButtonEnable(this.btnStatusList, billStatus, this.pageStatus, this.compoId, obj.getProcessInstId());  }  private void refreshData() {    ZcEbEcbjItem item = (ZcEbEcbjItem) listCursor.getCurrentObject();    this.setEditingObject(item);    ecbjFileDownLoadPath = item.getProjCode() + File.separator + item.getPackCode() + File.separator + tb.TB_DOC_TYPE_ECBJ + File.separator    + item.getProviderName() + File.separator;    tb.setFileDownloadPath(tb.getDownloadFilePath() + File.separator + ecbjFileDownLoadPath);    //成功开标，显示投标金额    if (item.getStatus().equals(ZcSettingConstants.FIELD_TRANS_ZC_BJ_OPEN) && item.getBjSum() != null) {      item.setBjSumMask(item.getBjSum().toString());    }    if (item != null && item.getFileId() != null && item.getFileId().trim().length() > 0) {      refreshSubTableData(item);    }    setOldObject();  }  private void setOldObject() {    this.oldZcEcbjItem = (ZcEbEcbjItem) ObjectUtil.deepCopy(listCursor.getCurrentObject());  }  private void refreshSubTableData(ZcEbEcbjItem ecbjItem) {    if (ecbjItem.getStatus() == null)      return;    //开标成功的，显示开标一览表    if (ecbjItem.getStatus().equals("1")) {      //      this.tabPane.remove(this.summaryPanel);      this.tabPane.removeAll();      this.tabPane.addTab(this.tabTitle, createSummaryPn(ecbjItem));      this.tabPane.repaint();    }  }  protected void updateFieldEditorsEditable() {    super.updateFieldEditors();    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {      for (AbstractFieldEditor fd : this.fieldEditors) {        if (fd.getFieldName() != null && (fd.getFieldName().equals("status")) || (fd.getFieldName().equals("openFailReason"))) {          fd.setEnabled(true);        } else {          fd.setEnabled(false);        }      }    } else if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {      for (AbstractFieldEditor fd : this.fieldEditors) {        fd.setEnabled(false);      }    }  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.zc.AbstractMainSubEditPanel#initToolBar(com.ufgov.gk.client.component.JFuncToolBar)   */  @Override  public void initToolBar(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    toolBar.add(editButton);    toolBar.add(saveButton);    toolBar.add(openBidButton);    toolBar.add(previousButton);    toolBar.add(nextButton);    toolBar.add(exitButton);    toolBar.add(helpButton);    editButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doEdit();      }    });    saveButton.addActionListener(new ActionListener() {      @Override      public void actionPerformed(ActionEvent e) {        // TCJLODO Auto-generated method stub        doSave();      }    });    openBidButton.addActionListener(new ActionListener() {      @Override      public void actionPerformed(ActionEvent e) {        // TCJLODO Auto-generated method stub        doOpenBid();      }    });    previousButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doPrevious();      }    });    nextButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doNext();      }    });    exitButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doExit();      }    });    helpButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doHelp();      }    });  }  private void doEdit() {    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;    updateFieldEditorsEditable();    setButtonStatus();  }  private void doOpenBid() {    ZcEbEcbjItem ecbjItem = null;    ecbjItem = (ZcEbEcbjItem) this.listCursor.getCurrentObject();    ecbjItem.setStatus(ZcSettingConstants.FIELD_TRANS_ZC_BJ_OPEN);    saveButton.setEnabled(false);    openBidButton.setEnabled(false);    ecbjItem.setOpenBidTime(requestMeta.getSysDate());    this.tabPane.removeAll();    this.tabPane.addTab(this.tabTitle, getSummaryPn(ecbjItem));    ecbjItem.setBjSumMask(ecbjItem.getBjSum().toString());    ecbjItem.setOrgCode(requestMeta.getSvOrgCode());    ecbjItem.setAgency(requestMeta.getSvCoCode());    ecbjItem.setNd(requestMeta.getSvNd());    ecbjItem.setExecutor(requestMeta.getSvUserID());    ecbjItem.setExecuteDate(requestMeta.getSysDate());    this.tabPane.repaint();    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;    updateFieldEditorsEditable();    setButtonStatus();  }  private void doPrevious() {    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      } else {        listCursor.setCurrentObject(oldZcEcbjItem);      }    }    listCursor.previous();    refreshData();    setButtonStatus();  }  private void doNext() {    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      } else {        listCursor.setCurrentObject(oldZcEcbjItem);      }    }    listCursor.next();    refreshData();    setButtonStatus();  }  public void doExit() {    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存?", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      }    }    if (tb != null) {      String filePath = tb.getFileDownloadPath();      File file = new File(filePath);      System.out.println("开始删除目录文件" + tb.getFileDownloadPath());      deleteFile(file);    }    this.parent.dispose();  }  public boolean doSave() {    if (!isDataChanged()) {      JOptionPane.showMessageDialog(self, "数据未发生变化，不需要保存！", "提示", JOptionPane.INFORMATION_MESSAGE);      return false;    }    ZcEbEcbjItem ecbjItem = (ZcEbEcbjItem) this.listCursor.getCurrentObject();    if (!checkBeforeSave())      return false;    boolean success = true;    String errorInfo = "";    try {      requestMeta.setFuncId(this.saveButton.getFuncId());      ecbjItem = listPanel.zcEbEcbjServiceDelegate.saveFN(ecbjItem, requestMeta);    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      this.listCursor.setCurrentObject(ecbjItem);      this.oldZcEcbjItem = (ZcEbEcbjItem) ObjectUtil.deepCopy(ecbjItem);      this.listPanel.refreshCurrentTabData();      JOptionPane.showMessageDialog(self, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;      updateFieldEditorsEditable();      setButtonStatus();      return true;    } else {      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      return false;    }  }  private boolean checkBeforeSave() {    ZcEbEcbjItem ecbjItem = (ZcEbEcbjItem) this.listCursor.getCurrentObject();    if (ecbjItem.getStatus() != null && ecbjItem.getStatus().equals(ZcSettingConstants.FIELD_TRANS_ZC_BJ_NO_OPEN)) {      JOptionPane.showMessageDialog(this.parent, "已经唱价不能将开标状态修改成等待开标", "提示", JOptionPane.WARNING_MESSAGE);      return false;    }    if (ecbjItem.getStatus() != null && ecbjItem.getStatus().equals(ZcSettingConstants.FIELD_TRANS_ZC_BJ_FAIL)) {      if (ecbjItem.getOpenFailReason() == null || ecbjItem.getOpenFailReason().trim().length() == 0) {        JOptionPane.showMessageDialog(this.parent, "请填写开标失败原因", "提示", JOptionPane.WARNING_MESSAGE);        this.openFailReason.setFocusable(true);        return false;      }    }    return true;  }  public void doHelp() {    setButtonStatus();  }  public boolean isDataChanged() {    return !DigestUtil.digest(oldZcEcbjItem).equals(DigestUtil.digest(listCursor.getCurrentObject()));  }}