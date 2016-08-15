package com.ufgov.zc.client.zc.question;import java.awt.BorderLayout;import java.awt.Color;import java.awt.DefaultKeyboardFocusManager;import java.awt.Dialog.ModalityType;import java.awt.Dimension;import java.awt.FlowLayout;import java.awt.Font;import java.awt.GridLayout;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.util.ArrayList;import java.util.List;import javax.swing.BorderFactory;import javax.swing.JButton;import javax.swing.JComponent;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.zc.ZCQuestionTableModelConverter;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.GkCommentDialog;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.JSaveableSplitPane;import com.ufgov.zc.client.component.JTablePanel;import com.ufgov.zc.client.component.button.AddButton;import com.ufgov.zc.client.component.button.CallbackButton;import com.ufgov.zc.client.component.button.DeleteButton;import com.ufgov.zc.client.component.button.EditButton;import com.ufgov.zc.client.component.button.ExitButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.button.NextButton;import com.ufgov.zc.client.component.button.PreviousButton;import com.ufgov.zc.client.component.button.SaveButton;import com.ufgov.zc.client.component.button.SendButton;import com.ufgov.zc.client.component.button.SubaddButton;import com.ufgov.zc.client.component.button.SubdelButton;import com.ufgov.zc.client.component.button.SubinsertButton;import com.ufgov.zc.client.component.button.SubmitZY;import com.ufgov.zc.client.component.button.SuggestAuditPassButton;import com.ufgov.zc.client.component.button.TraceButton;import com.ufgov.zc.client.component.button.UnauditButton;import com.ufgov.zc.client.component.button.UntreadButton;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.FileFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.NewLineFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.client.datacache.AsValDataCache;import com.ufgov.zc.client.zc.ButtonStatus;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.constants.ZcValSetConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.DigestUtil;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.system.util.Utils;import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;import com.ufgov.zc.common.zc.model.ZcEbPack;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.common.zc.model.ZcEbQuestion;import com.ufgov.zc.common.zc.model.ZcEbQuestionPack;import com.ufgov.zc.common.zc.model.ZcEbQuestionWithBLOBs;import com.ufgov.zc.common.zc.publish.IZcEbProjServiceDelegate;/** * @author wuwb */public class ZcEbQuestionEditPanel extends AbstractMainSubEditPanel {  private static final long serialVersionUID = 1L;  private static final Logger logger = Logger.getLogger(ZcEbQuestionEditPanel.class);  private final RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private final String compoId = "ZC_EB_QUESTION";  private final ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;  ElementConditionDto packDto = new ElementConditionDto();  private final JTablePanel packTablePanel = new JTablePanel();  protected ListCursor<ZcEbQuestion> listCursor;  protected ZcEbQuestionWithBLOBs oldZcQuestion;  private final String tabStatus;  List<AbstractFieldEditor> allFieldLst = new ArrayList<AbstractFieldEditor>();  List<AbstractFieldEditor> headFieldLst = new ArrayList<AbstractFieldEditor>();  List<AbstractFieldEditor> questionFieldLst = new ArrayList<AbstractFieldEditor>();  List<AbstractFieldEditor> answerFieldLst = new ArrayList<AbstractFieldEditor>();  //  List<AbstractFieldEditor> listEdit = new ArrayList<AbstractFieldEditor>();  //  List<AbstractFieldEditor> listEditable = new ArrayList<AbstractFieldEditor>();  private final ZcEbQuestionListPanel listPanel;  private final ZcEbQuestionEditPanel self = this;  private final GkBaseDialog parent;  private JPanel questionPanel = null;  private JPanel answerPanel;  private final JPanel clientTabbedPane = new JPanel();  private JPanel buttomPanel;  private TextAreaFieldEditor jbReasonField;  private FileFieldEditor jbFile;  // private FileFieldEditor dwFile;  private AsValFieldEditor mode;  private DateFieldEditor answerDateField;  /**   * 创建按钮   */  private final FuncButton addButton = new AddButton();  private final FuncButton saveButton = new SaveButton();  // 工作流送审  private final FuncButton sendButton = new SendButton();  // 工作流收回  private final FuncButton callbackButton = new CallbackButton();  // 工作流填写意见审核通过  private final FuncButton suggestPassButton = new SuggestAuditPassButton();  // 消审  private final FuncButton unAuditButton = new UnauditButton();  // 工作流退回  private final FuncButton unTreadButton = new UntreadButton();  // 工作流流程跟踪  private final FuncButton traceButton = new TraceButton();  // 提交质疑  private final FuncButton submitZY = new SubmitZY();  private final FuncButton deleteButton = new DeleteButton();  private final FuncButton previousButton = new PreviousButton();  private final FuncButton editButton = new EditButton();  private final FuncButton nextButton = new NextButton();  private final FuncButton exitButton = new ExitButton();  private final FuncButton helpButton = new HelpButton();  private final String projSqlMapSelectedId = "ZcEbProj.getZcEbProj";  private JFuncToolBar subPackTableToolbar;  IZcEbProjServiceDelegate zcEbProjectServiceDelegate = (IZcEbProjServiceDelegate) ServiceFactory.create(IZcEbProjServiceDelegate.class, "zcEbProjServiceDelegate");  private ZcEbQuestionWithBLOBs curObj = null;  /**   * 设置全局值以便获取和设置下面workpanel中的值得处理   */  private JSaveableSplitPane splitPane;  @SuppressWarnings("unchecked")  public ZcEbQuestionEditPanel(ZcEbQuestionDialog parent, ListCursor listCursor, String tabStatus, ZcEbQuestionListPanel listPanel) {    super(ZcEbQuestionWithBLOBs.class, BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_QUESTION"));    this.listCursor = listCursor;    this.listPanel = listPanel;    this.parent = parent;    this.tabStatus = tabStatus;    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate("ZC_EB_QUESTION"), TitledBorder.CENTER, TitledBorder.TOP,    new Font("宋体", Font.BOLD, 15), Color.BLUE));    this.colCount = 3;    init();    requestMeta.setCompoId(compoId);    refreshData();  }  protected void init() {    this.initToolBar(toolBar);    this.setLayout(new BorderLayout());    this.add(toolBar, BorderLayout.NORTH);    this.add(workPanel, BorderLayout.CENTER);    if (this.billClass != null && this.eleMeta != null) {      initFieldEditorPanel(this.billClass, this.eleMeta);    } else {      initFieldEditorPanel();    }    workPanel.setLayout(new BorderLayout());    JPanel p = new JPanel();    p.setLayout(new BorderLayout());    JPanel p1 = new JPanel();    p1.setLayout(new BorderLayout());    p1.add(fieldEditorPanel, BorderLayout.NORTH);    p.add(p1, BorderLayout.CENTER);    // p.add(fieldEditorPanel, BorderLayout.CENTER);    JPanel p2 = initPackPanel();    p.add(p2, BorderLayout.EAST);    workPanel.add(p, BorderLayout.NORTH);    JComponent subPanel = createSubBillPanel();    if (subPanel != null) {      workPanel.add(subPanel, BorderLayout.CENTER);    }  }  /**   * 刷新字段可编辑性   */  @Override  protected void updateFieldEditorsEditable() {    Long processInstId = curObj.getProcessInstId();    if (processInstId != null && processInstId.longValue() > 0) {      // 工作流的单据      wfCanEditFieldMap = BillElementMeta.getWfCanEditField(curObj, requestMeta);      if ("cancel".equals(this.oldZcQuestion.getStatus())) {// 撤销单据设置字段为不可编辑        wfCanEditFieldMap = null;      }      for (AbstractFieldEditor editor : allFieldLst) {        if (editor instanceof NewLineFieldEditor) {          continue;        }        // 工作流中定义可编辑的字段        if (wfCanEditFieldMap != null && wfCanEditFieldMap.containsKey(Utils.getDBColNameByFieldName(editor.getEditObject(), editor.getFieldName()))) {          isEdit = true;          this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;          editor.setEnabled(true);        } else {          editor.setEnabled(false);        }      }      //工作流中该节点选中了保存按钮可用，则当前状态当前人可用编辑      if (saveButton.isVisible() && saveButton.isEnabled()) {        isEdit = true;        this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;      }    } else {      for (AbstractFieldEditor editor : allFieldLst) {        if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {          if ("inputDate".equals(editor.getFieldName()) || "inputor".equals(editor.getFieldName()) || "status".equals(editor.getFieldName()) || "proj.projName".equals(editor.getFieldName())            || "zyUnitName".equals(editor.getFieldName()) || "proj.purType".equals(editor.getFieldName()) || "proj.attnName".equals(editor.getFieldName()) || "zyDate".equals(editor.getFieldName())            || "hyDate".equals(editor.getFieldName())) {            editor.setEnabled(false);          } else {            editor.setEnabled(true);          }          isEdit = true;        } else {          editor.setEnabled(false);        }      }    }  }  /**   * 项目信息栏字段   */  @Override  public List<AbstractFieldEditor> createFieldEditors() {    AsValFieldEditor zyType = new AsValFieldEditor(LangTransMeta.translate(ZcEbQuestionWithBLOBs.COL_ZY_TYPE), "zyType", "ZC_VS_QUES_TYPE");    String columNames[] = { "项目编号", "项目名称", "采购类型", "负责人" };    ZcEbProjFnHandler projHandler = new ZcEbProjFnHandler(columNames);    ElementConditionDto dto = new ElementConditionDto();    dto.setNd(WorkEnv.getInstance().getTransNd());    dto.setZcText3("forZhiYi");    ForeignEntityFieldEditor projCode = new ForeignEntityFieldEditor(this.projSqlMapSelectedId, dto, 20, projHandler, columNames, LangTransMeta.translate(ZcEbQuestionWithBLOBs.COL_PROJ_CODE),      "projCode");    TextFieldEditor projName = new TextFieldEditor(LangTransMeta.translate(ZcEbQuestionWithBLOBs.COL_PROJ_NAME), "projName");    TextFieldEditor zyUnitName = new TextFieldEditor(LangTransMeta.translate(ZcEbQuestionWithBLOBs.COL_ZY_UNIT_NAME), "zyUnitName");    TextFieldEditor zyLinkMan = new TextFieldEditor(LangTransMeta.translate(ZcEbQuestionWithBLOBs.COL_ZY_LINK_MAN), "zyLinkMan");    TextFieldEditor zyLinkTel = new TextFieldEditor(LangTransMeta.translate(ZcEbQuestionWithBLOBs.COL_ZY_LINK_TEL), "zyLinkTel");    AsValFieldEditor status = new AsValFieldEditor(LangTransMeta.translate(ZcEbQuestionWithBLOBs.COL_STATUS), "status", ZcEbQuestionWithBLOBs.ZC_VS_QUESTION_STATUS);    AsValFieldEditor zcPifuCgfs = new AsValFieldEditor("采购方式", "proj.purType", "ZC_VS_PITEM_OPIWAY");    TextFieldEditor projJbr = new TextFieldEditor("招标负责人", "proj.attnName");    TextFieldEditor zcMakeTel = new TextFieldEditor("负责人电话", "proj.phone");    headFieldLst.add(projCode);    headFieldLst.add(projName);    headFieldLst.add(status);    headFieldLst.add(zyType);    headFieldLst.add(zcPifuCgfs);    headFieldLst.add(projJbr);    headFieldLst.add(zyUnitName);    headFieldLst.add(zyLinkMan);    headFieldLst.add(zyLinkTel);    allFieldLst.addAll(headFieldLst);    return headFieldLst;  }  private JPanel initPackPanel() {    packTablePanel.init();    packTablePanel.getSearchBar().setVisible(false);    packTablePanel.setTablePreferencesKey(this.getClass().getName() + "pack_table");    packTablePanel.getTable().setShowCheckedColumn(false);    packTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 100));    // tablePanel.setTableModel(ZCQuestionTableModelConverter.convertPackDeToTableModel(zcQuestion.getListPack()));    //    // setTableProperty(tablePanel.getTable());    this.subPackTableToolbar = new JFuncToolBar();    JButton addBtn1 = new SubaddButton(false);    JButton insertBtn1 = new SubinsertButton(false);    JButton delBtn1 = new SubdelButton(false);    this.subPackTableToolbar.add(addBtn1);    // ((Container) this.subPackTableToolbar).add(insertBtn1);    this.subPackTableToolbar.add(delBtn1);    //    packTablePanel.add(this.subPackTableToolbar, BorderLayout.SOUTH);    addBtn1.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        if (curObj.getProjCode() == null) {          JOptionPane.showMessageDialog(self, "请先选择一个采购项目 ！", "提示", JOptionPane.INFORMATION_MESSAGE);          return;        }        ZcEbPack bean = new ZcEbPack();        ZcEbQuestionPack pack = new ZcEbQuestionPack();        pack.setZyCode(curObj.getZyCode());        addSub(packTablePanel, pack);      }    });    insertBtn1.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        if (curObj.getProjCode() == null) {          JOptionPane.showMessageDialog(self, "请先选择一个采购项目 ！", "提示", JOptionPane.INFORMATION_MESSAGE);          return;        }        ZcEbPack bean = new ZcEbPack();        ZcEbQuestionPack pack = new ZcEbQuestionPack();        pack.setZyCode(curObj.getZyCode());        insertSub(packTablePanel, pack);      }    });    delBtn1.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        deleteSub(packTablePanel);      }    });    packTablePanel.setPreferredSize(new Dimension(300, 150));    JPanel p = new JPanel();    p.setBorder(BorderFactory.createTitledBorder("相关分包"));    p.setLayout(new BorderLayout());    p.add(packTablePanel, BorderLayout.CENTER);    return p;  }  /**   * 创建标段选择器   */  @Override  public JComponent createSubBillPanel() {    /*     * JTabbedPane tabPane = new JTabbedPane(); JScrollPane wowPanel =     * createWoPanel(); tabPane.setMinimumSize(new Dimension(240, 50));     * wowPanel.setMinimumSize(new Dimension(240, 400)); splitPane = new     * JSaveableSplitPane(JSplitPane.VERTICAL_SPLIT, tabPane, wowPanel);     * splitPane.setDividerLocation(200); splitPane.setContinuousLayout(true);     * splitPane.setOneTouchExpandable(true); splitPane.setDividerSize(10);     * splitPane.setBackground(self.getBackground()); tabPane.setVisible(true);     */    createButtomPanel();    return buttomPanel;  }  /**   * 初始化工具栏   */  @Override  public void initToolBar(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    //    toolBar.add(addButton);    toolBar.add(editButton);    toolBar.add(saveButton);    toolBar.add(deleteButton);    toolBar.add(sendButton);    toolBar.add(suggestPassButton);    toolBar.add(callbackButton);    toolBar.add(unAuditButton);    toolBar.add(unTreadButton);    toolBar.add(traceButton);    toolBar.add(previousButton);    toolBar.add(nextButton);    toolBar.add(helpButton);    toolBar.add(submitZY);    toolBar.add(exitButton);    editButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doEdit();      }    });    deleteButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        // stopEditing();        doDelete();      }    });    saveButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        // stopEditing();        doSave();      }    });    sendButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopEditing();        doSend();      }    });    callbackButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopEditing();        doCallback();      }    });    suggestPassButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        stopEditing();        // 填写意见审核        doSuggestPass();      }    });    unAuditButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopEditing();        // 销审        doUnaudit();      }    });    unTreadButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopEditing();        // 退回        doUntread();      }    });    traceButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        // 流程跟踪        doTrace();      }    });    exitButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doExit();      }    });    helpButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doHelp();      }    });    submitZY.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doSend();      }    });  }  private void doEdit() {    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;    updateFieldEditorsEditable();    setButtonStatus();  }  private void doDelete() {    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);    if (num == JOptionPane.YES_OPTION) {      this.listPanel.getZcQuestionServiceDelegate().deleteByPrimaryKeyFN(curObj.getZyCode(), requestMeta);      JOptionPane.showMessageDialog(self, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.listPanel.refreshCurrentTabData();      doExit();    }  }  @SuppressWarnings("unchecked")  private boolean doSave() {    if (!checkBeforeSave()) {    return false;    }    if (!isDataChanged()) {      JOptionPane.showMessageDialog(this, "数据没有发生改变，不用保存.", "提示", JOptionPane.INFORMATION_MESSAGE);      return false;    }    boolean success = true;    String errorInfo = "";    try {      requestMeta.setFuncId(saveButton.getFuncId());      ZcEbQuestionWithBLOBs inData = (ZcEbQuestionWithBLOBs) ObjectUtil.deepCopy(curObj);      ZcEbQuestionWithBLOBs zcQuestion = this.listPanel.getZcQuestionServiceDelegate().saveFN(inData, requestMeta);      curObj = zcQuestion;      if (listCursor.getDataList() == null || listCursor.getDataList().size() == 0) {        List lst = new ArrayList();        lst.add(curObj);        this.listCursor.setDataList(lst, -1);      }      listCursor.setCurrentObject(curObj);    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;      this.listPanel.refreshCurrentTabData();      refreshData();    } else {      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }    return true;  }  private void doSend() {    if (!checkBeforeSave()) {    return;    }    boolean success = true;    ZcEbQuestionWithBLOBs zcQuestion = (ZcEbQuestionWithBLOBs) ObjectUtil.deepCopy(curObj);    try {      requestMeta.setFuncId(this.sendButton.getFuncId());      zcQuestion.setAuditorId(WorkEnv.getInstance().getCurrUserId());      zcQuestion.setComment("请予处理");      zcQuestion = this.listPanel.getZcQuestionServiceDelegate().newCommitFN(zcQuestion, requestMeta);      this.listPanel.refreshCurrentTabData();      refreshData();    } catch (Exception ex) {      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "操作成功！", "提示", JOptionPane.INFORMATION_MESSAGE);    }  }  private void doCallback() {    boolean success = true;    ZcEbQuestionWithBLOBs afterSaveBill = null;    String errorInfo = "";    try {      requestMeta.setFuncId(this.callbackButton.getFuncId());      ZcEbQuestionWithBLOBs zcQuestion = (ZcEbQuestionWithBLOBs) ObjectUtil.deepCopy(curObj);      zcQuestion.setAuditorId(WorkEnv.getInstance().getCurrUserId());      afterSaveBill = listPanel.getZcQuestionServiceDelegate().callbackFN(zcQuestion, requestMeta);    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      refreshData();      this.listPanel.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doSuggestPass() {    if (isDataChanged()) {      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);    } else {      boolean success = true;      ZcEbQuestionWithBLOBs afterSaveBill = null;      String errorInfo = "";      GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL);      if (commentDialog.cancel) {      return;      }      try {        requestMeta.setFuncId(this.callbackButton.getFuncId());        ZcEbQuestionWithBLOBs zcQuestion = (ZcEbQuestionWithBLOBs) ObjectUtil.deepCopy(curObj);        zcQuestion.setComment(commentDialog.getComment());        zcQuestion.setAuditorId(WorkEnv.getInstance().getCurrUserId());        afterSaveBill = listPanel.getZcQuestionServiceDelegate().auditFN(zcQuestion, requestMeta);      } catch (Exception e) {        success = false;        logger.error(e.getMessage(), e);        errorInfo += e.getMessage();      }      if (success) {        JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);        refreshData();        this.listPanel.refreshCurrentTabData();      } else {        JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      }    }  }  private void doUnaudit() {    boolean success = true;    ZcEbQuestionWithBLOBs afterSaveBill = null;    String errorInfo = "";    try {      requestMeta.setFuncId(this.callbackButton.getFuncId());      ZcEbQuestionWithBLOBs zcQuestion = (ZcEbQuestionWithBLOBs) ObjectUtil.deepCopy(curObj);      zcQuestion.setAuditorId(WorkEnv.getInstance().getCurrUserId());      afterSaveBill = listPanel.getZcQuestionServiceDelegate().unAuditFN(zcQuestion, requestMeta);// (zcQuestion,      // requestMeta);    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      refreshData();      this.listPanel.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doUntread() {    boolean success = true;    ZcEbQuestionWithBLOBs afterSaveBill = null;    String errorInfo = "";    try {      requestMeta.setFuncId(this.callbackButton.getFuncId());      ZcEbQuestionWithBLOBs zcQuestion = (ZcEbQuestionWithBLOBs) ObjectUtil.deepCopy(curObj);      zcQuestion.setAuditorId(WorkEnv.getInstance().getCurrUserId());      afterSaveBill = listPanel.getZcQuestionServiceDelegate().untreadFN(zcQuestion, requestMeta);    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      refreshData();      this.listPanel.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "退回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doTrace() {    if (curObj == null) {    return;    }    ZcUtil.showTraceDialog(curObj, compoId);  }  private void doExit() {    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {        return;        }      }    }    this.parent.dispose();  }  private void doHelp() {  }  private void stopEditing() {  }  private void refreshData() {    ZcEbQuestion ques = this.listCursor.getCurrentObject();    if (curObj == null && (ques == null || ques.getZyCode() == null)) {// 新增页面      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;      curObj = new ZcEbQuestionWithBLOBs();      setDefaultValue(curObj);    } else {      curObj = listPanel.getZcQuestionServiceDelegate().selectByPrimaryKey(ques.getZyCode(), requestMeta);      ZcEbProj proj = zcEbProjectServiceDelegate.getZcEbProjByProjCode(curObj.getProjCode(), requestMeta);      curObj.setProj(proj == null ? new ZcEbProj() : proj);      curObj.setDbDigest(null);      curObj.setDbDigest(curObj.digest());      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;      //掩饰内部处理状态，供应商看见不详细状态      if (ZcUtil.isGys()        && (!ZcEbQuestion.ZC_VS_QUESTION_STATUS_DRAFT.equals(curObj.getStatus()) && !ZcEbQuestion.ZC_VS_QUESTION_STATUS_DRAFT.equals(curObj.getStatus())          && !ZcEbQuestion.ZC_VS_QUESTION_STATUS_WAIT.equals(curObj.getStatus()) && !ZcEbQuestion.ZC_VS_QUESTION_STATUS_HUIFU.equals(curObj.getStatus()))) {        curObj.setStatus(ZcEbQuestion.ZC_VS_QUESTION_STATUS_PROCESSING);      }    }    refreshSubTableData(curObj);    this.setEditingObject(curObj);    setOldObject();    updateFieldEditorsEditable();    setButtonStatus();  }  private void setDefaultValue(ZcEbQuestionWithBLOBs zcQuestion) {    zcQuestion.setNd(requestMeta.getSvNd());    if (ZcUtil.isGys()) {      HuiyuanUnitcominfo unit = ZcUtil.getHuiYuan();      if (unit != null) {        zcQuestion.setZyUnit(unit.getDanweiguid());        zcQuestion.setZyUnitName(unit.getDanweiname());        zcQuestion.setZyLinkMan(unit.getZfcgGysInfo().getLocallianxiren());        zcQuestion.setZyLinkTel(unit.getZfcgGysInfo().getLocalmobile());      }    } else {      zcQuestion.setZyUnit(requestMeta.getSvCoCode());      zcQuestion.setZyUnitName(requestMeta.getSvCoName());      zcQuestion.setZyLinkMan(requestMeta.getEmpName());    }    zcQuestion.setStatus(ZcEbQuestion.ZC_VS_QUESTION_STATUS_DRAFT);    zcQuestion.setInputDate(requestMeta.getTransDate());    zcQuestion.setInputor(requestMeta.getSvUserID());    zcQuestion.setDbDigest(null);    zcQuestion.setDbDigest(zcQuestion.digest());  }  private void setOldObject() {    oldZcQuestion = (ZcEbQuestionWithBLOBs) ObjectUtil.deepCopy(curObj);  }  public boolean isDataChanged() {    return !DigestUtil.digest(oldZcQuestion).equals(DigestUtil.digest(curObj));  }  /**   * 创建招标部门意见   */  public void initAnswerPanel() {    jbReasonField = new TextAreaFieldEditor(LangTransMeta.translate(ZcEbQuestion.COL_HY_CONTENT), "hyContent");    jbFile = new FileFieldEditor(LangTransMeta.translate(ZcEbQuestion.COL_HY_FILE), "hyFile", "hyFileBlobid");    answerDateField = new DateFieldEditor(LangTransMeta.translate(ZcEbQuestion.COL_HY_DATE), "hyDate");    answerPanel = new JPanel();    answerPanel.setBorder(BorderFactory.createTitledBorder("回复意见"));    ZcEbQuestion q = listCursor.getCurrentObject();    if (ZcUtil.isGys() && (q == null || !ZcEbQuestion.ZC_VS_QUESTION_STATUS_HUIFU.equals(q.getStatus()))) {//在质疑没有终审的时候，供应商不能看见单位的回复部分      return;    }    answerPanel.setLayout(new BorderLayout());    JLabel l1 = new JLabel(LangTransMeta.translate(ZcEbQuestion.COL_HY_FILE));    JPanel p = new JPanel();    p.setLayout(new FlowLayout(FlowLayout.LEFT));    p.add(l1);    jbFile.setPreferredSize(new Dimension(300, 25));    p.add(jbFile);    JLabel l2 = new JLabel(LangTransMeta.translate(ZcEbQuestion.COL_HY_DATE));    p.add(l2);    p.add(answerDateField);    answerPanel.add(p, BorderLayout.SOUTH);    answerPanel.add(jbReasonField, BorderLayout.CENTER);    answerFieldLst.add(jbReasonField);    answerFieldLst.add(jbFile);    answerFieldLst.add(answerDateField);    allFieldLst.addAll(answerFieldLst);  }  /**   * 创建质疑意见   */  public void initQuestionPanel() {    TextAreaFieldEditor clientReason = new TextAreaFieldEditor(LangTransMeta.translate(ZcEbQuestion.COL_ZY_CONTENT), "zyContent");    FileFieldEditor clientFile = new FileFieldEditor(LangTransMeta.translate(ZcEbQuestion.COL_ZY_FILE), "zyFile", "zyFileBlobid");    DateFieldEditor clientSubmitZYDateField = new DateFieldEditor(LangTransMeta.translate(ZcEbQuestion.COL_ZY_DATE), "zyDate");    questionPanel = new JPanel();    questionPanel.setBorder(BorderFactory.createTitledBorder("质疑意见"));    questionPanel.setLayout(new BorderLayout());    JLabel l1 = new JLabel(LangTransMeta.translate(ZcEbQuestion.COL_ZY_FILE));    JPanel p = new JPanel();    p.setLayout(new FlowLayout(FlowLayout.LEFT));    p.add(l1);    clientFile.setPreferredSize(new Dimension(300, 25));    p.add(clientFile);    JLabel l2 = new JLabel(LangTransMeta.translate(ZcEbQuestion.COL_ZY_DATE));    p.add(l2);    p.add(clientSubmitZYDateField);    questionPanel.add(p, BorderLayout.SOUTH);    questionPanel.add(clientReason, BorderLayout.CENTER);    questionFieldLst.add(clientReason);    questionFieldLst.add(clientFile);    questionFieldLst.add(clientSubmitZYDateField);    allFieldLst.addAll(questionFieldLst);  }  @Override  protected void updateFieldEditors() {    for (AbstractFieldEditor editor : allFieldLst) {      editor.setEditObject(editingObject);    }  }  /**   * 创建下面意见栏目   */  private void createButtomPanel() {    buttomPanel = new JPanel();    GridLayout gridLayout = new GridLayout(1, 2);    buttomPanel.setLayout(gridLayout);    initAnswerPanel();    initQuestionPanel();    buttomPanel.add(questionPanel);    buttomPanel.add(answerPanel);  }  /**   * 保存前检查   */  protected boolean checkBeforeSave() {    List notNullField = this.eleMeta.getNotNullBillElement();    String biValidateInfo = ZcUtil.validateBillElementNull(curObj, notNullField);    if (biValidateInfo != null && biValidateInfo.length() > 0) {      JOptionPane.showMessageDialog(this, biValidateInfo, "提示", JOptionPane.WARNING_MESSAGE);      return false;    }    return true;  }  /**   * 是否改变对象检查   */  protected boolean dataChange() {    return !DigestUtil.digest(oldZcQuestion).equals(DigestUtil.digest(curObj));  }  private class ZcEbProjFnHandler implements IForeignEntityHandler {    private final String columNames[];    public ZcEbProjFnHandler(String columNames[]) {      this.columNames = columNames;    }    public boolean beforeSelect(ElementConditionDto dto) {      return true;    }    public void excute(List selectedDatas) {      for (Object object : selectedDatas) {        ZcEbProj proj = (ZcEbProj) object;        proj = zcEbProjectServiceDelegate.getZcEbProjByProjCode(proj.getProjCode(), requestMeta);        proj = proj == null ? new ZcEbProj() : proj;        curObj.setProj(proj);        curObj.setProjCode(proj.getProjCode());        curObj.setProjName(proj.getProjName());        curObj.setProjJbr(proj.getAttn());        setEditingObject(curObj);        curObj.getPackLst().clear();        if (proj.getPackList() != null) {          for (int i = 0; i < proj.getPackList().size(); i++) {            ZcEbPack pk = (ZcEbPack) proj.getPackList().get(i);            ZcEbQuestionPack d = new ZcEbQuestionPack();            d.setZyCode(curObj.getZyCode());            d.setPackCode(pk.getPackCode());            d.setPackName(pk.getPackName());            d.setPackContent(pk.getPurContent());            curObj.getPackLst().add(d);          }        }        refreshSubTableData(curObj);      }    }    public TableModel createTableModel(List showDatas) {      Object data[][] = new Object[showDatas.size()][columNames.length];      for (int i = 0; i < showDatas.size(); i++) {        ZcEbProj rowData = (ZcEbProj) showDatas.get(i);        int col = 0;        data[i][col++] = rowData.getProjCode();        data[i][col++] = rowData.getProjName();        data[i][col++] = AsValDataCache.getName(ZcValSetConstants.VS_ZC_VS_PITEM_OPIWAY, rowData.getPurType());        data[i][col++] = rowData.getAttnName();      }      MyTableModel model = new MyTableModel(data, columNames) {        @Override        public boolean isCellEditable(int row, int colum) {          return false;        }      };      return model;    }    public boolean isMultipleSelect() {      return false;    }    public void afterClear() {      curObj.setProj(new ZcEbProj());      curObj.setProjCode(null);      curObj.setProjName(null);      curObj.setProjJbr(null);      setEditingObject(curObj);      curObj.getPackLst().clear();      refreshSubTableData(curObj);    }  }  private void refreshSubTableData(ZcEbQuestionWithBLOBs zcQuestion) {    packTablePanel.setTableModel(ZCQuestionTableModelConverter.convertDetailToTableModel(zcQuestion.getPackLst()));    ZcUtil.translateColName(this.packTablePanel.getTable(), ZCQuestionTableModelConverter.getItemInfo());  }  protected void setButtonStatus() {    setButtonStatus(curObj, requestMeta, this.listCursor);    if (ZcUtil.isGys()) {      traceButton.setVisible(false);    }  }  public void setButtonStatusWithoutWf() {    if (this.btnStatusList.size() == 0) {      ButtonStatus bs = new ButtonStatus();      bs = new ButtonStatus();      bs.setButton(this.editButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.WF_STATUS_DRAFT);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.saveButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.exitButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.sendButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.suggestPassButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.callbackButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.unAuditButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.unTreadButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);    }    ZcUtil.setButtonEnable(this.btnStatusList, curObj.getStatus(), this.pageStatus, getCompoId(), curObj.getProcessInstId());  }}