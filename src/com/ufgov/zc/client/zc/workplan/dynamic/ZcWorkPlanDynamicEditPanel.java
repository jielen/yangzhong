package com.ufgov.zc.client.zc.workplan.dynamic;import java.awt.BorderLayout;import java.awt.Color;import java.awt.DefaultKeyboardFocusManager;import java.awt.Dimension;import java.awt.Font;import java.awt.Dialog.ModalityType;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.util.ArrayList;import java.util.Arrays;import java.util.Date;import java.util.List;import javax.swing.BorderFactory;import javax.swing.JButton;import javax.swing.JComponent;import javax.swing.JOptionPane;import javax.swing.JTabbedPane;import javax.swing.JTable;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.zc.ZcWorkDynamicToTableModelConverter;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.GkCommentDialog;import com.ufgov.zc.client.component.GkCommentUntreadDialog;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.JTablePanel;import com.ufgov.zc.client.component.WorkflowTrace;import com.ufgov.zc.client.component.button.AddButton;import com.ufgov.zc.client.component.button.AuditButton;import com.ufgov.zc.client.component.button.CallbackButton;import com.ufgov.zc.client.component.button.DeleteButton;import com.ufgov.zc.client.component.button.EditButton;import com.ufgov.zc.client.component.button.ExitButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.button.NextButton;import com.ufgov.zc.client.component.button.PreviousButton;import com.ufgov.zc.client.component.button.SaveButton;import com.ufgov.zc.client.component.button.SendButton;import com.ufgov.zc.client.component.button.SuggestAuditPassButton;import com.ufgov.zc.client.component.button.TraceButton;import com.ufgov.zc.client.component.button.UnauditButton;import com.ufgov.zc.client.component.button.UntreadButton;import com.ufgov.zc.client.component.table.BeanTableModel;import com.ufgov.zc.client.component.table.celleditor.DateCellEditor;import com.ufgov.zc.client.component.table.celleditor.TextCellEditor;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.client.datacache.AsValDataCache;import com.ufgov.zc.client.util.SwingUtil;import com.ufgov.zc.client.zc.ButtonStatus;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.DigestUtil;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;import com.ufgov.zc.common.zc.model.ZcBaseBill;import com.ufgov.zc.common.zc.model.ZcWorkPlan;import com.ufgov.zc.common.zc.model.ZcWorkPlanDetail;import com.ufgov.zc.common.zc.model.ZcWorkPlanDynamic;import com.ufgov.zc.common.zc.model.ZcWorkPlanDynamicDetail;import com.ufgov.zc.common.zc.publish.IZcEbPlanServiceDelegate;/** * @author LEO * */public class ZcWorkPlanDynamicEditPanel extends AbstractMainSubEditPanel {  private static final Logger logger = Logger.getLogger(ZcWorkPlanDynamicEditPanel.class);  private IZcEbPlanServiceDelegate zcEbPlanServiceDelegate = (IZcEbPlanServiceDelegate) ServiceFactory  .create(IZcEbPlanServiceDelegate.class, "zcEbPlanServiceDelegate");  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private String compoId = "ZC_WORK_DYNAMIC";  private String workPlanSqlMapID = "ZcWorkPlan.getWorkPlansForDynamic";  private FuncButton addButton = new AddButton();  private FuncButton saveButton = new SaveButton();  // 工作流送审  private FuncButton sendButton = new SendButton();  // 工作流收回  private FuncButton callbackButton = new CallbackButton();  // 工作流填写意见审核通过  private FuncButton suggestPassButton = new SuggestAuditPassButton();  //工作流审核通过  private FuncButton auditPassButton = new AuditButton();  //消审  private FuncButton unAuditButton = new UnauditButton();  // 工作流退回  private FuncButton unTreadButton = new UntreadButton();  // 工作流流程跟踪  private FuncButton traceButton = new TraceButton();  private FuncButton deleteButton = new DeleteButton();  private FuncButton previousButton = new PreviousButton();  private FuncButton editButton = new EditButton();  private FuncButton nextButton = new NextButton();  private FuncButton exitButton = new ExitButton();  private FuncButton helpButton = new HelpButton();  private final ListCursor listCursor;  private ZcWorkPlanDynamic oldWorkPlan;  private ZcWorkPlanDynamicListPanel listPanel;  private JTablePanel tablePanel = new JTablePanel();  private ZcWorkPlanDynamicEditPanel self = this;  private GkBaseDialog parent;  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;  private JFuncToolBar subPlanDetailTableToolbar;  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();  ElementConditionDto packDto = new ElementConditionDto();  public ZcWorkPlanDynamicEditPanel(ZcWorkPlanDynamicDialog parent, ListCursor listCursor, String tabStatus,  ZcWorkPlanDynamicListPanel listPanel) {    this.listCursor = listCursor;    this.listPanel = listPanel;    this.parent = parent;    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),    LangTransMeta.translate("工作动态编辑"), TitledBorder.CENTER, TitledBorder.TOP,    new Font("宋体", Font.BOLD, 15), Color.BLUE));    this.colCount = 3;    init();    requestMeta.setCompoId(compoId);    refreshData();    setButtonStatus();  }  /**   * 设置工具条上按钮的可用性   *    * Administrator   * 2010-5-15   */  private void setButtonStatus() {    if (this.btnStatusList.size() == 0) {      ButtonStatus bs = new ButtonStatus();      bs.setButton(this.addButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.editButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus("0");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.saveButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);      bs.addBillStatus("0");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.deleteButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus("0");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.auditPassButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus("0");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.unAuditButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus("1");      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.exitButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.helpButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.previousButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.nextButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);    }    ZcWorkPlanDynamic obj = (ZcWorkPlanDynamic) (this.listCursor.getCurrentObject());    String billStatus = obj.getZcWorkPlan().getPlanStatus();    ZcUtil.setButtonEnable(this.btnStatusList, billStatus, this.pageStatus, this.compoId, obj    .getProcessInstId());    setSubTableButton();  }  /**   * 设置字表下面的按钮状态   *    * Administrator   * 2010-10-22   */  private void setSubTableButton() {    if (this.subPlanDetailTableToolbar != null) {      if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)      || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {        this.subPlanDetailTableToolbar.setEnabled(true);        ZcWorkDynamicToTableModelConverter.isTableEditable = true;      } else {        this.subPlanDetailTableToolbar.setEnabled(false);        ZcWorkDynamicToTableModelConverter.isTableEditable = false;      }    }  }  private void refreshData() {    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) listCursor.getCurrentObject();    if (plan == null) {//新增页面      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;      ZcWorkDynamicToTableModelConverter.isTableEditable = true;      plan = new ZcWorkPlanDynamic();      plan.getZcWorkPlan().setPlanStatus(ZcSettingConstants.PACK_STATUS_DRAFT);      List lst = new ArrayList();      lst.add(plan);      this.listCursor.setDataList(lst, -1);      listCursor.setCurrentObject(plan);    }    this.setEditingObject(plan);    refreshSubTableData(plan.getWorkDynamicDetailList());    setOldObject();  }  private void refreshSubTableData(List deList) {    tablePanel.setTableModel(ZcWorkDynamicToTableModelConverter.convertWorkDynamicDetailToTableModel(deList));    ZcUtil.translateColName(tablePanel.getTable(), ZcWorkDynamicToTableModelConverter    .getDetailTableColumnInfo());    setTableProperty(tablePanel.getTable());  }  private void setTableProperty(JTable table) {    SwingUtil.setTableCellEditor(table, "PLAN_CONTENT", new TextCellEditor());    SwingUtil.setTableCellEditor(table, "PLAN_START_TIME", new DateCellEditor());    SwingUtil.setTableCellEditor(table, "PLAN_END_TIME", new DateCellEditor());    SwingUtil.setTableCellEditor(table, "LEADER_EVALUTION", new TextCellEditor());    SwingUtil.setTableCellEditor(table, "DYNAMIC_FINISH_DESC", new TextCellEditor());    SwingUtil.setTableCellEditor(table, "DYNAMIC_LEADER_EVALUTION", new TextCellEditor());  }  private void setOldObject() {    oldWorkPlan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(listCursor.getCurrentObject());  }  public List<AbstractFieldEditor> createFieldEditors() {    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();    String columNames[] = { "计划ID", "计划名称", "部门", "计划类型", "计划状态", "录入人", "录入时间", "备注" };    ZcWorkPlanFnHandler planHandler = new ZcWorkPlanFnHandler(columNames);    ForeignEntityFieldEditor editor0 = new ForeignEntityFieldEditor(this.workPlanSqlMapID, 20, planHandler,    columNames, "计划名称", "zcWorkPlan.planName");    editorList.add(editor0);    TextFieldEditor editor4 = new TextFieldEditor("部门", "zcWorkPlan.belongDepartment");    editor4.setEnabled(false);    editorList.add(editor4);    AsValFieldEditor editor8 = new AsValFieldEditor("计划类型", "zcWorkPlan.planType", "VS_ZC_WORKPLAN_TYPE");    editor8.setEnabled(false);    editorList.add(editor8);    AsValFieldEditor editor7 = new AsValFieldEditor("计划状态", "zcWorkPlan.planStatus", "VS_ZC_WORKPLAN_STATUS");    editor7.setEnabled(false);    editorList.add(editor7);    TextFieldEditor remark = new TextFieldEditor("备注", "zcWorkPlan.remark");    remark.setEnabled(false);    editorList.add(remark);    TextFieldEditor inputer = new TextFieldEditor("计划录入人", "zcWorkPlan.plannerName");    inputer.setEnabled(false);    editorList.add(inputer);    DateFieldEditor inputTime = new DateFieldEditor("计划录入时间", "zcWorkPlan.inputDate");    inputTime.setEnabled(false);    editorList.add(inputTime);    return editorList;  }  public JComponent createSubBillPanel() {    JTabbedPane tabPane = new JTabbedPane();    tablePanel.init();    tablePanel.setTablePreferencesKey(this.getClass().getName() + "_table");    tablePanel.getTable().setShowCheckedColumn(false);    tablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 0));    tabPane.addTab("动态明细", tablePanel);    this.subPlanDetailTableToolbar = new JFuncToolBar();    JButton addBtn = new JButton("添加");    JButton insertBtn = new JButton("插入");    JButton delBtn = new JButton("删除");    this.subPlanDetailTableToolbar.add(addBtn);    this.subPlanDetailTableToolbar.add(insertBtn);    this.subPlanDetailTableToolbar.add(delBtn);    tablePanel.add(this.subPlanDetailTableToolbar, BorderLayout.SOUTH);    addBtn.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        addSub(tablePanel);      }    });    insertBtn.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        insertSub(tablePanel);      }    });    delBtn.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        deleteSub(tablePanel);      }    });    return tabPane;  }  protected Integer[] deleteSub(JTablePanel tablePanel) {    JPageableFixedTable table = tablePanel.getTable();    stopTableEditing();    int[] selectedRows = table.getSelectedRows();    if (selectedRows.length == 0) {      JOptionPane.showMessageDialog(self, "没有选择数据！", "提示", JOptionPane.INFORMATION_MESSAGE);      return null;    }    BeanTableModel tableModel = ((BeanTableModel) table.getModel());    int[] selRows = new int[selectedRows.length];    for (int i = 0; i < selRows.length; i++) {      selRows[i] = table.convertRowIndexToModel(selectedRows[i]);    }    Arrays.sort(selRows);    for (int i = selRows.length - 1; i >= 0; i--) {      tableModel.deleteRow(selRows[i]);    }    return null;  }  private void insertSub(JTablePanel tablePanel) {    stopTableEditing();    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) listCursor.getCurrentObject();    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();    ZcWorkPlanDynamicDetail bean = new ZcWorkPlanDynamicDetail();    bean.setDynamicID(plan.getId());    int selectedRow = tablePanel.getTable().getSelectedRow();    if (selectedRow != -1) {      editTableModel.insertRow(selectedRow + 1, bean);    } else {      editTableModel.insertRow(editTableModel.getRowCount(), bean);    }  }  private void addSub(JTablePanel tablePanel) {    tablePanel.getTable().clearSelection();    stopTableEditing();    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();    ZcWorkPlanDynamicDetail bean = new ZcWorkPlanDynamicDetail();    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) listCursor.getCurrentObject();    bean.setDynamicID(plan.getId());    editTableModel.insertRow(editTableModel.getRowCount(), bean);    setTableProperty(tablePanel.getTable());  }  public void initToolBar(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    toolBar.add(addButton);    toolBar.add(editButton);    toolBar.add(saveButton);    toolBar.add(deleteButton);    toolBar.add(sendButton);    toolBar.add(suggestPassButton);    toolBar.add(auditPassButton);    toolBar.add(callbackButton);    toolBar.add(unAuditButton);    toolBar.add(unTreadButton);    toolBar.add(traceButton);    toolBar.add(previousButton);    toolBar.add(nextButton);    toolBar.add(exitButton);    toolBar.add(helpButton);    addButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        doAdd();      }    });    editButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doEdit();      }    });    deleteButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        doDelete();      }    });    saveButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        doSave();      }    });    sendButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        doSend();      }    });    callbackButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        doCallback();      }    });    suggestPassButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        stopTableEditing();        // 填写意见审核        doSuggestPass();      }    });    auditPassButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        // 审核        doAudit();      }    });    unAuditButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        // 销审        doUnaudit();      }    });    unTreadButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        stopTableEditing();        // 退回        doUntread();      }    });    traceButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        // 流程跟踪        doTrace();      }    });    previousButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doPrevious();      }    });    nextButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doNext();      }    });    exitButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doExit();      }    });    helpButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doHelp();      }    });  }  private void doAdd() {    this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;    ZcWorkDynamicToTableModelConverter.isTableEditable = true;    ZcWorkPlanDynamic plan = new ZcWorkPlanDynamic();    listCursor.setCurrentObject(plan);    setEditingObject(plan);    refreshData();    setButtonStatus();  }  private void doEdit() {    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;    ZcWorkDynamicToTableModelConverter.isTableEditable = true;    setButtonStatus();  }  private void doDelete() {    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) this.listCursor.getCurrentObject();    int num = JOptionPane.showConfirmDialog(this, "确认删除当前数据？", "删除确认", 0);    if (num == JOptionPane.YES_OPTION) {      boolean success = true;      String errorInfo = "";      try {        ElementConditionDto dto = new ElementConditionDto();        dto.getPmAdjustCodeList().add(plan.getId());        this.zcEbPlanServiceDelegate.deleteWorkPlans(dto, this.requestMeta);      } catch (Exception e) {        logger.error(e.getMessage(), e);        success = false;        errorInfo += e.getMessage();      }      if (success) {        JOptionPane.showMessageDialog(self, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;        ZcWorkDynamicToTableModelConverter.isTableEditable = false;        listCursor.removeCurrentObject();        refreshData();        this.listPanel.refreshCurrentTabData();        setButtonStatus();      } else {        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      }    }  }  private void doAudit() {    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) this.listCursor.getCurrentObject();    boolean success = true;    String errorInfo = "";    try {      this.zcEbPlanServiceDelegate.auditFN(plan, this.requestMeta);    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      this.listPanel.refreshCurrentTabData();      this.oldWorkPlan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(plan);      JOptionPane.showMessageDialog(self, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      setButtonStatus();    } else {      JOptionPane.showMessageDialog(this, "审核失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doUnaudit() {    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) this.listCursor.getCurrentObject();    plan.getZcWorkPlan().setPlanStatus("0");    boolean success = true;    String errorInfo = "";    try {      this.zcEbPlanServiceDelegate.unAuditFN(plan, this.requestMeta);    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      this.listPanel.refreshCurrentTabData();      this.oldWorkPlan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(plan);      JOptionPane.showMessageDialog(self, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      setButtonStatus();    } else {      JOptionPane.showMessageDialog(this, "审核失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doTrace() {    ZcBaseBill bean = (ZcBaseBill) this.listCursor.getCurrentObject();    if (bean == null) {      return;    }    ZcUtil.showTraceDialog(bean, compoId);  }  private void doPrevious() {    stopTableEditing();    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      } else {        listCursor.setCurrentObject(oldWorkPlan);      }    }    listCursor.previous();    refreshData();    setButtonStatus();  }  private void doNext() {    stopTableEditing();    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      } else {        listCursor.setCurrentObject(oldWorkPlan);      }    }    listCursor.next();    refreshData();    setButtonStatus();  }  public void doExit() {    stopTableEditing();    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      }    }    this.parent.dispose();  }  public boolean doSave() {    if (!isDataChanged()) {      JOptionPane.showMessageDialog(self, "数据未发生变化，不需要保存！", "提示", JOptionPane.INFORMATION_MESSAGE);      return false;    }    if (!checkDataOK()) {      return false;    }    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) this.listCursor.getCurrentObject();    boolean success = true;    String errorInfo = "";    try {      if (plan.getId() != null && !"".equals(plan.getId())) {        plan.getZcWorkPlan().setUpdateDate(new Date());        this.zcEbPlanServiceDelegate.updateWorkPlanDynamic(plan, requestMeta);      } else {        this.zcEbPlanServiceDelegate.saveWorkPlanDynamic(plan, requestMeta);      }    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      this.listCursor.setCurrentObject(plan);      this.oldWorkPlan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(plan);      this.listPanel.refreshCurrentTabData();      JOptionPane.showMessageDialog(self, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;      ZcWorkDynamicToTableModelConverter.isTableEditable = false;      setButtonStatus();      setOldObject();      return true;    } else {      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      return false;    }  }  private boolean checkDataOK() {    ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) this.listCursor.getCurrentObject();    StringBuffer buff = new StringBuffer();    List list = plan.getWorkDynamicDetailList();    for (int i = 0; i < list.size(); i++) {      ZcWorkPlanDynamicDetail detail = (ZcWorkPlanDynamicDetail) list.get(i);      if (detail.getPlanStartTime().getTime() >= detail.getPlanEndTime().getTime()) {        buff.append("计划明细第");        buff.append(i + 1);        buff.append("条记录【起始时间】晚于【结束时间】;\n");      }    }    if (buff.length() > 0) {      buff.append("请检查修正后再提交...");      JOptionPane.showMessageDialog(this, buff.toString(), "提示", JOptionPane.INFORMATION_MESSAGE);      return false;    }    return true;  }  private void doSend() {    boolean success = true;    ZcWorkPlanDynamic savedPlan = null;    String errorInfo = "";    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager    .getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL);    if (commentDialog.cancel) {      return;    }    try {      requestMeta.setFuncId(this.sendButton.getFuncId());      ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());      plan.setAuditorId(WorkEnv.getInstance().getCurrUserId());      plan.setComment(commentDialog.getComment());      savedPlan = this.zcEbPlanServiceDelegate.newCommitFN(plan, false, requestMeta);    } catch (Exception ex) {      errorInfo += ex.getMessage();      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      this.refreshAll(savedPlan, true);      JOptionPane.showMessageDialog(this, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.listPanel.refreshCurrentTabData();    }  }  private void doCallback() {    boolean success = true;    ZcWorkPlanDynamic savedPlan = null;    String errorInfo = "";    try {      requestMeta.setFuncId(this.callbackButton.getFuncId());      ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());      plan.setAuditorId(WorkEnv.getInstance().getCurrUserId());      savedPlan = this.zcEbPlanServiceDelegate.callbackFN(plan, requestMeta);    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      this.refreshAll(savedPlan, true);      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.listPanel.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doSuggestPass() {    if (isDataChanged()) {      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager    .getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL);    if (commentDialog.cancel) {      return;    }    boolean success = true;    ZcWorkPlanDynamic savedPlan = null;    String errorInfo = "";    try {      requestMeta.setFuncId(this.suggestPassButton.getFuncId());      ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());      plan.setComment(commentDialog.getComment());      plan.setAuditorId(WorkEnv.getInstance().getCurrUserId());      savedPlan = this.zcEbPlanServiceDelegate.auditFN(plan, requestMeta);    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      this.refreshAll(savedPlan, true);      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.listPanel.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doUntread() {    if (isDataChanged()) {      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    GkCommentUntreadDialog commentDialog = new GkCommentUntreadDialog(DefaultKeyboardFocusManager    .getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL);    if (commentDialog.cancel) {      return;    }    boolean success = true;    ZcWorkPlanDynamic savedPlan = null;    String errorInfo = "";    try {      requestMeta.setFuncId(unTreadButton.getFuncId());      ZcWorkPlanDynamic plan = (ZcWorkPlanDynamic) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());      plan.setAuditorId(WorkEnv.getInstance().getCurrUserId());      plan.setComment(commentDialog.getComment());      savedPlan = this.zcEbPlanServiceDelegate.untreadFN(plan, requestMeta);    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      this.refreshAll(savedPlan, true);      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.listPanel.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "退回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  public void doHelp() {    setButtonStatus();  }  private void stopTableEditing() {    JPageableFixedTable table = this.tablePanel.getTable();    if (table.isEditing()) {      table.getCellEditor().stopCellEditing();    }  }  private void refreshAll(ZcWorkPlanDynamic plan, boolean isRefreshButton) {    this.listCursor.setCurrentObject(plan);    refreshData();    if (isRefreshButton) {      setButtonStatus(plan, requestMeta, this.listCursor);    }  }  public boolean isDataChanged() {    return !DigestUtil.digest(oldWorkPlan).equals(DigestUtil.digest(listCursor.getCurrentObject()));  }  /**   * 计划选择部件   * @author Administrator   */  private class ZcWorkPlanFnHandler implements IForeignEntityHandler {    private String columNames[];    public ZcWorkPlanFnHandler(String columNames[]) {      this.columNames = columNames;    }    public void excute(List selectedDatas) {      for (Object object : selectedDatas) {        ZcWorkPlan plan = (ZcWorkPlan) object;        ZcWorkPlanDynamic dynamic = (ZcWorkPlanDynamic) listCursor.getCurrentObject();        dynamic.setZcWorkPlan(plan);        dynamic.getWorkDynamicDetailList().clear();        ElementConditionDto dto = new ElementConditionDto();        dto.setInputGroupId(plan.getId());        List list = zcEbPlanServiceDelegate.getZcWorkPlanDetailsWithWorkPlanID(dto, requestMeta);        for (int i = 0; i < list.size(); i++) {          ZcWorkPlanDetail pd = (ZcWorkPlanDetail) list.get(i);          ZcWorkPlanDynamicDetail dd = new ZcWorkPlanDynamicDetail();          dd.setPlanContent(pd.getPlanContent());          dd.setLeaderEvalution(pd.getLeaderEvalution());          dd.setPlanStartTime(pd.getPlanStartTime());          dd.setPlanEndTime(pd.getPlanEndTime());          dynamic.getWorkDynamicDetailList().add(dd);        }        setEditingObject(dynamic);        refreshSubTableData(dynamic.getWorkDynamicDetailList());      }    }    //{ "计划ID", "计划名称", "部门", "计划类型", "计划状态", "录入人", "录入时间", "备注" }    public TableModel createTableModel(List showDatas) {      Object data[][] = new Object[showDatas.size()][columNames.length];      for (int i = 0; i < showDatas.size(); i++) {        ZcWorkPlan rowData = (ZcWorkPlan) showDatas.get(i);        int col = 0;        data[i][col++] = rowData.getId();        data[i][col++] = rowData.getPlanName();        data[i][col++] = rowData.getBelongDepartment();        data[i][col++] = AsValDataCache.getName("ZC_WORK_PLAN_TYPE", rowData.getPlanType());        data[i][col++] = AsValDataCache.getName("ZC_WORK_PLAN_STATUS", rowData.getPlanStatus());        data[i][col++] = rowData.getPlannerName();        data[i][col++] = rowData.getInputDate();        data[i][col++] = rowData.getRemark();      }      MyTableModel model = new MyTableModel(data, columNames) {        public boolean isCellEditable(int row, int colum) {          return false;        }      };      return model;    }    public boolean isMultipleSelect() {      return false;    }  }}