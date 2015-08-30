package com.ufgov.zc.client.zc.bulletinmold;import java.awt.BorderLayout;import java.awt.Color;import java.awt.Dialog;import java.awt.Dimension;import java.awt.Font;import java.awt.GridLayout;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.ComponentAdapter;import java.awt.event.ComponentEvent;import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.util.ArrayList;import java.util.Iterator;import java.util.List;import javax.swing.BorderFactory;import javax.swing.JButton;import javax.swing.JComponent;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JTabbedPane;import javax.swing.border.TitledBorder;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.UIConstants;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.zc.ZcEbBulletinWordMoldToTableModelConverter;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.JTablePanel;import com.ufgov.zc.client.component.button.BlankOutButton;import com.ufgov.zc.client.component.button.EditButton;import com.ufgov.zc.client.component.button.EnableButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.NextButton;import com.ufgov.zc.client.component.button.PreviousButton;import com.ufgov.zc.client.component.button.SaveButton;import com.ufgov.zc.client.component.event.ValueChangeEvent;import com.ufgov.zc.client.component.event.ValueChangeListener;import com.ufgov.zc.client.component.table.BeanTableModel;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.SelectFileFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.client.zc.WordFileUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.ztb.activex.WordPane;import com.ufgov.zc.common.system.Guid;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.WFConstants;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.exception.BaseException;import com.ufgov.zc.common.system.exception.OtherException;import com.ufgov.zc.common.system.util.DigestUtil;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbBulletin;import com.ufgov.zc.common.zc.model.ZcEbBulletinWordMold;import com.ufgov.zc.common.zc.model.ZcEbBulletinWordMoldParam;import com.ufgov.zc.common.zc.publish.IZcEbBulletinWordMoldServiceDelegate;public class ZcEbBulletinWordMoldEditDialog extends GkBaseDialog {  private static final Logger logger = Logger.getLogger(ZcEbBulletinWordMoldEditDialog.class);  private static final long serialVersionUID = 1L;  private ZcEbBulletinWordMoldEditDialog self = this;  private ZcEbBulletinWordMoldEditPanel editPanel;  private String dialogType = "";  private ZcEbBulletinWordMoldListPanel parentPanel;  private boolean yesConfirmed = true;  private WordPane wordPane;  public ZcEbBulletinWordMoldEditDialog(ZcEbBulletinWordMoldListPanel listPanel, List beanList, int editingRow, String tabStatus, String dialogType) {    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);    WordFileUtil.setDir("mold");    this.parentPanel = listPanel;    this.dialogType = dialogType;    editPanel = new ZcEbBulletinWordMoldEditPanel(new ListCursor(beanList, editingRow), tabStatus);    setLayout(new BorderLayout());    add(editPanel);    this.setTitle("模版维护");    this.setSize(UIConstants.DIALOG_2_LEVEL_WIDTH, UIConstants.DIALOG_2_LEVEL_HEIGHT);    this.moveToScreenCenter();    this.setVisible(true);  }  protected boolean dialogIsClosing() {    if (editPanel.isDataChanged() && yesConfirmed) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        return editPanel.doSave();      } else {        yesConfirmed = false;      }    }    this.parentPanel.refreshCurrentTabData();    //    if (this.wordPane != null) {    //      this.wordPane.close(false);    //    }    return true;  }  private class ZcEbBulletinWordMoldEditPanel extends AbstractMainSubEditPanel {    private IZcEbBulletinWordMoldServiceDelegate zcEbBulletinWordMoldServiceDelegate = (IZcEbBulletinWordMoldServiceDelegate) ServiceFactory.create(    IZcEbBulletinWordMoldServiceDelegate.class, "zcEbBulletinWordMoldServiceDelegate");    protected IZcEbBulletinWordMoldServiceDelegate getIZcEbBulletinWordMoldServiceDelegate() {      return this.zcEbBulletinWordMoldServiceDelegate;    }    private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();    private String compoId = "ZC_EB_BULLETIN_WORD_MOLD";    private String fileName = "";    private JTabbedPane tabPane;    private JTablePanel paramTablePanel = new JTablePanel("paramTablePanel");    JFuncToolBar paramToolBar = new JFuncToolBar();    /**     * 保存     */    private FuncButton saveButton = new SaveButton();    /**     * 修改按钮     */    private FuncButton editButton = new EditButton();    /**     * 启用按钮     */    private EnableButton enableButton = new EnableButton();    /**     * 作废按钮     */    private BlankOutButton unableButton = new BlankOutButton();    /**     * 上一条按钮     */    private FuncButton previousButton = new PreviousButton();    /**     * 下一条     */    private FuncButton nextButton = new NextButton();    private ListCursor listCursor;    private ZcEbBulletin editingObject = null;    private ZcEbBulletinWordMold oldBulletinWordMold;    private String tabStatus;    private TextFieldEditor fieldBulletinMoldCode = null;    private TextFieldEditor fieldBulletinMoldName = null;    private AsValFieldEditor fieldStatus = null;    private AsValFieldEditor fieldBulletinMoldType = null;    private SelectFileFieldEditor fieldFileName = null;    private TextFieldEditor fieldInputorName = null;    private DateFieldEditor fieldInputDate = null;    private TextFieldEditor fieldRemark = null;    private TextFieldEditor dataView = null;    public ZcEbBulletinWordMoldEditPanel(ListCursor listCursor, String tabStatus) {      this.listCursor = listCursor;      this.tabStatus = tabStatus;      this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "公告模板", TitledBorder.CENTER, TitledBorder.TOP,      new Font("宋体", Font.BOLD, 15), Color.BLUE));      init();      requestMeta.setCompoId(compoId);      refreshData();      if (self.dialogType.equalsIgnoreCase(ZcSettingConstants.PAGE_STATUS_NEW)) {        setNewButtonStatus();        setEditFieldStatus();      } else {        setDefaultButtonStatus();        setDefaultFieldStatus();      }    }    private void setOldObject() {      oldBulletinWordMold = (ZcEbBulletinWordMold) ObjectUtil.deepCopy(listCursor.getCurrentObject());    }    public boolean isDataChanged() {      return !DigestUtil.digest(oldBulletinWordMold).equals(DigestUtil.digest(listCursor.getCurrentObject()));    }    private void refreshData() {      ZcEbBulletinWordMold zcEbBulletinWordMold = (ZcEbBulletinWordMold) listCursor.getCurrentObject();      List paramList = zcEbBulletinWordMoldServiceDelegate.getZcEbBulletinWordMoldParam(this.requestMeta, zcEbBulletinWordMold.getBulletinMoldCode());      zcEbBulletinWordMold.setParamList(paramList);      this.setEditingObject(zcEbBulletinWordMold);      String fileID = null;      if (zcEbBulletinWordMold != null && !"".equals(ZcUtil.safeString(zcEbBulletinWordMold.getBulletinMoldCode()))) {        paramTablePanel.setTableModel(ZcEbBulletinWordMoldToTableModelConverter.convertSubParamTableData(zcEbBulletinWordMold.getParamList()));        fileID = zcEbBulletinWordMold.getFileID();      } else {        paramTablePanel.setTableModel(ZcEbBulletinWordMoldToTableModelConverter.convertSubParamTableData(new ArrayList()));      }      // 翻译从表表头列      ZcUtil.translateColName(paramTablePanel.getTable(), ZcEbBulletinWordMoldToTableModelConverter.getParamInfo());      setOldObject();      if (self.isShowing()) {        refreshSubTableData(fileID);      }    }    private void refreshSubTableData(String fileID) {      if (wordPane.isDocOpened()) {        wordPane.close();      }      if (fileID != null && !fileID.equals("")) {        this.fileName = WordFileUtil.loadMold(fileID);        wordPane.open(this.fileName);      } else {        this.fileName = WordFileUtil.loadDefaultMold();        wordPane.open(this.fileName);      }    }    public List<AbstractFieldEditor> createFieldEditors() {      List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();      fieldBulletinMoldCode = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_BULLETIN_MOLD_CODE), "bulletinMoldCode");      editorList.add(fieldBulletinMoldCode);      fieldBulletinMoldCode.setEnabled(false);      fieldBulletinMoldType = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_BULLETIN_MOLD_TYPE), "bulletinMoldType",      "VS_ZC_EB_BULLETIN_MOLD_TYPE");      editorList.add(fieldBulletinMoldType);      fieldBulletinMoldType.setEnabled(false);      fieldStatus = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_STATUS), "status", "ZC_EB_BULLETIN_MOLD_STATUS");      editorList.add(fieldStatus);      fieldStatus.setEnabled(false);      fieldBulletinMoldName = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_BULLETIN_MOLD_NAME), "bulletinMoldName");      editorList.add(fieldBulletinMoldName);      fieldBulletinMoldName.setEnabled(false);      fieldFileName = new SelectFileFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_FILE_NAME), "fileName", "fileID", true);      editorList.add(fieldFileName);      fieldFileName.addValueChangeListener(new ValueChangeListener() {        @Override        public void valueChanged(ValueChangeEvent e) {          String fileID = fieldFileName.getFileUploader().getFileId();          refreshSubTableData(fileID);        }      });      fieldFileName.setEnabled(false);      dataView = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_DATA_VIEW), "dataView");      editorList.add(dataView);      dataView.setEnabled(false);      fieldInputorName = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_INPUTOR_NAME), "inputorName");      editorList.add(fieldInputorName);      fieldInputorName.setEnabled(false);      fieldInputDate = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_INPUT_DATE), "inputDate");      editorList.add(fieldInputDate);      fieldInputDate.setEnabled(false);      fieldRemark = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_REMARK), "remark");      editorList.add(fieldRemark);      fieldRemark.setEnabled(false);      return editorList;    }    @Override    public JComponent createSubBillPanel() {      tabPane = new JTabbedPane();      addSubPane();      paramTablePanel.init();      paramTablePanel.getSearchBar().setVisible(false);      paramTablePanel.setTablePreferencesKey(this.getClass().getName() + "_table");      paramTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(100, 450));      tabPane.addTab("参数配置", paramTablePanel);      JButton exportBtn = new JButton("从数据源导出");      JButton addBtn1 = new JButton("添加");      JButton insertBtn1 = new JButton("插入");      JButton delBtn1 = new JButton("删除");      paramToolBar.add(exportBtn);      paramToolBar.add(addBtn1);      paramToolBar.add(insertBtn1);      paramToolBar.add(delBtn1);      paramTablePanel.add(paramToolBar, BorderLayout.SOUTH);      exportBtn.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          exportFromDataView(fieldBulletinMoldCode.getValue().toString());        }      });      addBtn1.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          ZcEbBulletinWordMoldParam zcEbBulletinWordMoldParam = new ZcEbBulletinWordMoldParam();          zcEbBulletinWordMoldParam.setBulletinParamID(Guid.genID());          zcEbBulletinWordMoldParam.setBulletinMoldCode(fieldBulletinMoldCode.getValue().toString());          addSub(paramTablePanel, zcEbBulletinWordMoldParam);        }      });      insertBtn1.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          ZcEbBulletinWordMoldParam zcEbBulletinWordMoldParam = new ZcEbBulletinWordMoldParam();          zcEbBulletinWordMoldParam.setBulletinParamID(Guid.genID());          zcEbBulletinWordMoldParam.setBulletinMoldCode(fieldBulletinMoldCode.getValue().toString());          insertSub(paramTablePanel, zcEbBulletinWordMoldParam);        }      });      delBtn1.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          deleteSub(paramTablePanel);        }      });      JPanel panel = new JPanel(new GridLayout(1, 1));      panel.add(tabPane);      return panel;    }    private void addSubPane() {      //下面一句是为了打开word后刷新窗口      self.setSize(self.getSize().width + 1, self.getSize().height + 1);      if (self.wordPane == null) {        self.wordPane = new WordPane();      }      tabPane.addTab("公告模板内容", wordPane);      wordPane.addPropertyChangeListener(WordPane.EVENT_NAME_OPEN_CALLBACK, new PropertyChangeListener() {        public void propertyChange(PropertyChangeEvent evt) {          //打开文件完成之后的回调函数          boolean isSuccess = (Boolean) evt.getNewValue();          if (isSuccess) {            //下面一句是为了打开word后刷新窗口            self.setSize(self.getSize().width - 1, self.getSize().height - 1);          }        }      });      self.addComponentListener(new ComponentAdapter() {        public void componentShown(ComponentEvent e) {          ZcEbBulletinWordMold zcEbBulletinWordMold = (ZcEbBulletinWordMold) listCursor.getCurrentObject();          if (zcEbBulletinWordMold != null && zcEbBulletinWordMold.getFileID() != null) {            refreshSubTableData(zcEbBulletinWordMold.getFileID());          }        }      });    }    @Override    public void initToolBar(JFuncToolBar toolBar) {      toolBar.setModuleCode("ZC");      toolBar.setCompoId(compoId);      addButtonMenu(this.tabStatus);      saveButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doSave();        }      });      editButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doEdit();        }      });      enableButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doEnable();        }      });      unableButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doUnable();        }      });      previousButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doPrevious();        }      });      nextButton.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          doNext();        }      });    }    private boolean saveBulletinContent() {      boolean flag = false;      if (fileName != null && fileName.length() != 0) {        WordFileUtil.updateAsFileContent(fileName, fieldFileName.getFileUploader().getFileId());        flag = true;      }      return flag;    }    public boolean checkDataBeforSave(ZcEbBulletinWordMold bulletinWordMold) {      boolean ifCanSave = true;      if (bulletinWordMold.getBulletinMoldName() == null || bulletinWordMold.getBulletinMoldName().equalsIgnoreCase("")) {        JOptionPane.showMessageDialog(self, "模板名称不能为空，请输入模板名称！", "错误", JOptionPane.ERROR_MESSAGE);        this.fieldBulletinMoldName.setFocusable(true);        ifCanSave = false;      }      StringBuffer errorInfo = new StringBuffer();      List subList = bulletinWordMold.getParamList();      //      if (subList == null || subList.size() == 0) {      //        JOptionPane.showMessageDialog(self, "没有为模板添加参数信息，请在参数配置页添加参数信息！", "错误", JOptionPane.ERROR_MESSAGE);      //        ifCanSave = false;      //      }      if (subList != null) {        for (int i = 0; i < subList.size(); i++) {          ZcEbBulletinWordMoldParam zcEbBulletinWordMoldParam = (ZcEbBulletinWordMoldParam) subList.get(i);          if (zcEbBulletinWordMoldParam.getParamName() == null || zcEbBulletinWordMoldParam.getParamName().length() == 0) {            errorInfo.append("第" + (i + 1) + "行参数名称不能为空");            break;          }          if (zcEbBulletinWordMoldParam.getFieldName() == null || zcEbBulletinWordMoldParam.getFieldName().length() == 0) {            errorInfo.append("第" + (i + 1) + "行字段名称不能为空");            break;          }          if (zcEbBulletinWordMoldParam.getParamType() == null || zcEbBulletinWordMoldParam.getParamType().length() == 0) {            errorInfo.append("第" + (i + 1) + "行参数类型不能为空");            break;          }        }      }      if (errorInfo.toString().length() > 0) {        UIUtilities.showStaickTraceDialog(new BaseException(), this, "错误", errorInfo.toString());        ifCanSave = false;      }      return ifCanSave;    }    public void exportFromDataView(String moldCode) {      if (paramTablePanel.getTable().getRowCount() > 0) {        int num = JOptionPane.showConfirmDialog(this.paramTablePanel, "参数信息已经存在，重新导出将会覆盖原来的参数信息！", "重新导出", 0);        if (num != JOptionPane.YES_OPTION)          return;        else {          BeanTableModel tableModel = ((BeanTableModel) paramTablePanel.getTable().getModel());          for (int i = paramTablePanel.getTable().getRowCount() - 1; i >= 0; i--) {            tableModel.deleteRow(i);          }        }      }      try {        List bulletinMoldParamList = zcEbBulletinWordMoldServiceDelegate        .getZcEbDataViewCol(requestMeta, dataView.getValue().toString().toUpperCase());        System.out.println(bulletinMoldParamList.size() + "" + dataView.getValue().toString().toUpperCase());        if (bulletinMoldParamList == null || bulletinMoldParamList.size() == 0) {          JOptionPane.showMessageDialog(self, "没有找到数据源对应参数,查看录入的数据源名称是否正确！", "提示", JOptionPane.ERROR_MESSAGE);          return;        }        for (Iterator it = bulletinMoldParamList.iterator(); it.hasNext();) {          ZcEbBulletinWordMoldParam bulletinMoldParam = (ZcEbBulletinWordMoldParam) it.next();          bulletinMoldParam.setBulletinParamID(Guid.genID());          bulletinMoldParam.setBulletinMoldCode(moldCode);          addSub(paramTablePanel, bulletinMoldParam);        }      } catch (BaseException ex) {        logger.error(ex.getStackTraceMessage(), ex);        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      } catch (OtherException ex) {        logger.error(ex.getStackTraceMessage(), ex);        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      } catch (Exception ex) {        logger.error(ex.getMessage(), ex);        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      }    }    public boolean doSave() {      //      if (!isDataChanged()) {      //        JOptionPane.showMessageDialog(self, "数据未发生变化，不需要保存！", "提示", JOptionPane.INFORMATION_MESSAGE);      //        setDefaultFieldStatus();      //        setDefaultButtonStatus();      //        return false;      //      }      ZcEbBulletinWordMold bulletinWordMold = (ZcEbBulletinWordMold) listCursor.getCurrentObject();      if (!checkDataBeforSave(bulletinWordMold))        return false;      if (bulletinWordMold.getFileName() == null || bulletinWordMold.getFileName().equalsIgnoreCase("")) {        bulletinWordMold.setFileID("");      } else {        bulletinWordMold.setFileID(fieldFileName.getFileUploader().getFileId());        WordFileUtil.delete(fileName);        wordPane.save(this.fileName);        saveBulletinContent();      }      // 模板状态      if (bulletinWordMold.getStatus() == null || "".equals(bulletinWordMold.getStatus())) {        bulletinWordMold.setStatus("1");      }      boolean success = true;      String errorInfo = "";      try {        requestMeta.setFuncId(saveButton.getFuncId());        if (dialogType.equalsIgnoreCase(ZcSettingConstants.PAGE_STATUS_EDIT)) {          this.getIZcEbBulletinWordMoldServiceDelegate().updateFN(bulletinWordMold, requestMeta);        } else {          this.getIZcEbBulletinWordMoldServiceDelegate().insertFN(bulletinWordMold, requestMeta);          self.dialogType = ZcSettingConstants.PAGE_STATUS_EDIT;          //refreshData();        }      } catch (Exception e) {        logger.error(e.getMessage(), e);        success = false;        errorInfo += e.getMessage();      }      if (success) {        this.listCursor.setCurrentObject(bulletinWordMold);        this.oldBulletinWordMold = (ZcEbBulletinWordMold) ObjectUtil.deepCopy(bulletinWordMold);        self.parentPanel.refreshCurrentTabData();        JOptionPane.showMessageDialog(self, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);        setDefaultFieldStatus();        setDefaultButtonStatus();        return true;      } else {        JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);        return false;      }    }    public void doEdit() {      setEditFieldStatus();      setEditButtonStatus();    }    public void doUnable() {      ZcEbBulletinWordMold bulletinWordMold = (ZcEbBulletinWordMold) this.getEditingObject();      if (bulletinWordMold == null)        bulletinWordMold = (ZcEbBulletinWordMold) listCursor.getCurrentObject();      boolean success = true;      try {        requestMeta.setFuncId(enableButton.getFuncId());        bulletinWordMold.setStatus("0");        this.getIZcEbBulletinWordMoldServiceDelegate().updateWordMoldFN(bulletinWordMold, requestMeta);      } catch (BaseException ex) {        success = false;        logger.error(ex.getStackTraceMessage(), ex);        success = false;        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      } catch (OtherException ex) {        success = false;        logger.error(ex.getStackTraceMessage(), ex);        success = false;        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      } catch (Exception ex) {        success = false;        logger.error(ex.getMessage(), ex);        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      }      if (success) {        JOptionPane.showMessageDialog(this, "处理成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      }    }    public void doEnable() {      ZcEbBulletinWordMold bulletinWordMold = (ZcEbBulletinWordMold) this.getEditingObject();      if (bulletinWordMold == null)        bulletinWordMold = (ZcEbBulletinWordMold) listCursor.getCurrentObject();      boolean success = true;      try {        requestMeta.setFuncId(enableButton.getFuncId());        bulletinWordMold.setStatus("2");        this.getIZcEbBulletinWordMoldServiceDelegate().updateWordMoldFN(bulletinWordMold, requestMeta);      } catch (BaseException ex) {        success = false;        logger.error(ex.getStackTraceMessage(), ex);        success = false;        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      } catch (OtherException ex) {        success = false;        logger.error(ex.getStackTraceMessage(), ex);        success = false;        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      } catch (Exception ex) {        success = false;        logger.error(ex.getMessage(), ex);        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      }      if (success) {        JOptionPane.showMessageDialog(this, "处理成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      }    }    public void doPrint() {      // System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa       "+fieldFileName.getFileUploader().getFileId());    }    public void doPrintPreview() {    }    public void doPrintSetting() {    }    public void doPrevious() {      listCursor.previous();      setDefaultButtonStatus();      refreshData();    }    public void doNext() {      listCursor.next();      setDefaultButtonStatus();      refreshData();    }    private void addButtonMenu(String tabStatus) {      if (tabStatus.equalsIgnoreCase(WFConstants.EDIT_TAB_STATUS_EDIT)) {        toolBar.add(editButton);        toolBar.add(saveButton);      } else if (tabStatus.equalsIgnoreCase(WFConstants.EDIT_TAB_STATUS_ENABLE)) {        toolBar.add(unableButton);      } else if (tabStatus.equalsIgnoreCase(WFConstants.EDIT_TAB_STATUS_UNABLE)) {        toolBar.add(enableButton);        toolBar.add(editButton);        toolBar.add(saveButton);      }      //新增页面不需要显示前一页后一页      if (!self.dialogType.endsWith(ZcSettingConstants.PAGE_STATUS_NEW)) {        toolBar.add(previousButton);        toolBar.add(nextButton);      }    }    private void setDefaultButtonStatus() {      this.paramTablePanel.getTable().setEnabled(false);      wordPane.setEnabled(false);      setSubButtonEnabled(paramToolBar, false);      editButton.setEnabled(true);      saveButton.setEnabled(false);      enableButton.setEnabled(true);      unableButton.setEnabled(true);      previousButton.setEnabled(true);      nextButton.setEnabled(true);    }    private void setEditButtonStatus() {      this.paramTablePanel.getTable().setEnabled(true);      wordPane.setEnabled(true);      setSubButtonEnabled(paramToolBar, true);      editButton.setEnabled(false);      saveButton.setEnabled(true);      enableButton.setEnabled(false);      unableButton.setEnabled(false);      previousButton.setEnabled(false);      nextButton.setEnabled(false);    }    private void setNewButtonStatus() {      this.paramTablePanel.setEnabled(true);      wordPane.setEnabled(true);      setSubButtonEnabled(paramToolBar, true);      saveButton.setEnabled(true);      enableButton.setEnabled(false);      unableButton.setEnabled(false);      editButton.setEnabled(false);      previousButton.setEnabled(false);      nextButton.setEnabled(false);    }    private void setEditFieldStatus() {      for (int i = 0; i < fieldEditors.size(); i++) {        if (!fieldEditors.get(i).getFieldName().equalsIgnoreCase("bulletinMoldCode")        && !fieldEditors.get(i).getFieldName().equalsIgnoreCase("status") && !fieldEditors.get(i).getFieldName().equalsIgnoreCase("inputDate")        && !fieldEditors.get(i).getFieldName().equalsIgnoreCase("inputorName")) {          fieldEditors.get(i).setEnabled(true);        }      }    }    private void setDefaultFieldStatus() {      for (int i = 0; i < fieldEditors.size(); i++) {        fieldEditors.get(i).setEnabled(false);      }    }    private void setSubButtonEnabled(JFuncToolBar toolBar, boolean ifEnabled) {      for (int i = 0; i < toolBar.getComponentCount(); i++) {        JButton button = (JButton) toolBar.getComponent(i);        button.setEnabled(ifEnabled);      }    }  }}