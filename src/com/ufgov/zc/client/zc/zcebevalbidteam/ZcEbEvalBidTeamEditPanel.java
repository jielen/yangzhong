/** * ZcEbOpenBidTeamEditPanel.java * com.ufgov.gk.client.zc.zcebopenbidteam * Administrator * 2010-5-26 */package com.ufgov.zc.client.zc.zcebevalbidteam;import java.awt.Color;import java.awt.Dimension;import java.awt.Font;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.util.ArrayList;import java.util.List;import javax.swing.BorderFactory;import javax.swing.JButton;import javax.swing.JComponent;import javax.swing.JOptionPane;import javax.swing.JTabbedPane;import javax.swing.border.TitledBorder;import org.apache.log4j.Logger;import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ListCursor;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.ZcEbEvalBidTeamToTableModelConverter;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.JTablePanel;import com.ufgov.zc.client.component.button.AuditButton;import com.ufgov.zc.client.component.button.DeleteButton;import com.ufgov.zc.client.component.button.EditButton;import com.ufgov.zc.client.component.button.ExitButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.button.NextButton;import com.ufgov.zc.client.component.button.OpenNotepadButton;import com.ufgov.zc.client.component.button.PreviousButton;import com.ufgov.zc.client.component.button.PrintButton;import com.ufgov.zc.client.component.button.SaveButton;import com.ufgov.zc.client.component.button.UnauditButton;import com.ufgov.zc.client.component.table.codecelleditor.AsValComboBoxCellEditor;import com.ufgov.zc.client.component.table.codecellrenderer.AsValCellRenderer;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;import com.ufgov.zc.client.component.zc.fieldeditor.ForeignEntityFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.client.util.SwingUtil;import com.ufgov.zc.client.zc.ButtonStatus;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.notepad.ZcNotepadDialog;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcElementConstants;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.DigestUtil;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbEvalBidTeam;import com.ufgov.zc.common.zc.model.ZcEbPack;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;import com.ufgov.zc.common.zc.publish.IZcEbEvalBidTeamServiceDelegate;import com.ufgov.zc.common.zc.publish.IZcEbProjServiceDelegate;/** * @author Administrator * */public class ZcEbEvalBidTeamEditPanel extends AbstractMainSubEditPanel {  private static final Logger logger = Logger.getLogger(ZcEbEvalBidTeamEditPanel.class);  private IZcEbEvalBidTeamServiceDelegate zcEbEvalBidTeamServiceDelegate = (IZcEbEvalBidTeamServiceDelegate) ServiceFactory.create(  IZcEbEvalBidTeamServiceDelegate.class, "zcEbEvalBidTeamServiceDelegate");  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  protected String compoId = "ZC_EB_EVALBIDTEAM";  private FuncButton saveButton = new SaveButton();  protected FuncButton deleteButton = new DeleteButton();  private FuncButton previousButton = new PreviousButton();  private FuncButton editButton = new EditButton();  private FuncButton nextButton = new NextButton();  private FuncButton exitButton = new ExitButton();  private FuncButton helpButton = new HelpButton();  private FuncButton auditButton = new AuditButton();  private FuncButton unAuditButton = new UnauditButton();  public FuncButton openNotepadButton = new OpenNotepadButton();  protected FuncButton printButton = new PrintButton();  protected ListCursor<ZcEbEvalBidTeam> listCursor;  protected ZcEbEvalBidTeam oldEvalBidTeam;  private String tabStatus;  protected ZcEbEvalBidTeamListPanel listPanel;  protected JTablePanel memberTablePanel = new JTablePanel("member");  private ZcEbEvalBidTeamEditPanel self = this;  private GkBaseDialog parent;  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;  protected JFuncToolBar subMemberTableToolbar;  protected ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();  boolean success = true;  TextFieldEditor projNameEditor = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PROJ_NAME), "projName");  public IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,  "zcEbBaseServiceDelegate");  protected IZcEbProjServiceDelegate zcEbProjServiceDelegate = (IZcEbProjServiceDelegate) ServiceFactory.create(IZcEbProjServiceDelegate.class,  "zcEbProjServiceDelegate");  ForeignEntityFieldEditor expertFe;  protected ElementConditionDto packDto = new ElementConditionDto();  public ZcEbEvalBidTeamEditPanel(GkBaseDialog parent, ListCursor<ZcEbEvalBidTeam> listCursor, String tabStatus, ZcEbEvalBidTeamListPanel listPanel) {    // TODO Auto-generated constructor stub    super(ZcEbEvalBidTeam.class, BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_EVALBIDTEAM"));    this.listCursor = listCursor;    this.tabStatus = tabStatus;    this.listPanel = listPanel;    this.parent = parent;    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate("评标小组管理"),    TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));    this.colCount = 2;    init();    requestMeta.setCompoId(compoId);    refreshData();    setButtonStatus();    updateFieldEditorsEditable();  }  /**   * 设置工具条上按钮的可用性   *    * Administrator   * 2010-5-15   */  protected void setButtonStatus() {    if (this.btnStatusList.size() == 0) {      ButtonStatus bs = new ButtonStatus();      bs.setButton(this.editButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.saveButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.auditButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.unAuditButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.exitButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.helpButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.previousButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);      bs = new ButtonStatus();      bs.setButton(this.nextButton);      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);      btnStatusList.add(bs);    }    ZcEbEvalBidTeam obj = (ZcEbEvalBidTeam) (this.listCursor.getCurrentObject());    ZcUtil.setButtonEnable(this.btnStatusList, ZcSettingConstants.BILL_STATUS_ALL, this.pageStatus, this.compoId, obj.getProcessInstId());    setSubTableButton();  }  /**   * 设置字表下面的按钮状态   *    * Administrator   * 2010-5-15   */  protected void setSubTableButton() {    if (this.subMemberTableToolbar != null) {      if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {        this.subMemberTableToolbar.setEnabled(true);      } else {        this.subMemberTableToolbar.setEnabled(false);      }    }  }  protected void refreshData() {    // TODO Auto-generated method stub    ZcEbEvalBidTeam team = (ZcEbEvalBidTeam) listCursor.getCurrentObject();    if (team == null) {//新增页面      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;      team = new ZcEbEvalBidTeam();      //      signup.setEvalBidTeamId(Guid.genID());      setDefualtValue(team, ZcSettingConstants.PAGE_STATUS_NEW);      List lst = new ArrayList();      lst.add(team);      this.listCursor.setDataList(lst, -1);      listCursor.setCurrentObject(team);    }    this.setEditingObject(team);    List memberList = new ArrayList();    List packrList = new ArrayList();    if (team != null) {      memberList = zcEbEvalBidTeamServiceDelegate.getEvalBidTeamMembers(team, requestMeta);      team.setTeamMembers(memberList);    }    refreshMemberTableData(team.getTeamMembers());    setOldObject();  }  private void setDefualtValue(ZcEbEvalBidTeam team, String pageStatus) {    if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {      team.setNd(this.requestMeta.getSvNd());    }  }  protected void refreshMemberTableData(List deList) {    ZcEbEvalBidTeamToTableModelConverter mc = new ZcEbEvalBidTeamToTableModelConverter();    memberTablePanel.setTableModel(mc.convertMembersToTableModel(deList));    setMemberTableProperty(memberTablePanel.getTable());  }  protected void updateFieldEditorsEditable() {    super.updateFieldEditors();    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW) || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {      for (AbstractFieldEditor fd : this.fieldEditors) {        if (fd.getFieldName() != null && (fd.getFieldName().equals("evalLeaderName"))) {          fd.setEnabled(true);        } else {          fd.setEnabled(false);        }      }      this.memberTablePanel.getTable().setEnabled(true);    } else if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {      for (AbstractFieldEditor fd : this.fieldEditors) {        fd.setEnabled(false);      }      this.memberTablePanel.getTable().setEnabled(false);    }  }  protected void setMemberTableProperty(JPageableFixedTable table) {    ZcUtil.translateColName(table, "ZC_EB_");    SwingUtil.setTableCellEditor(table, "SEX", new AsValComboBoxCellEditor("VS_SEX"));    SwingUtil.setTableCellRenderer(table, "SEX", new AsValCellRenderer("VS_SEX"));  }  protected void setOldObject() {    oldEvalBidTeam = (ZcEbEvalBidTeam) ObjectUtil.deepCopy(listCursor.getCurrentObject());  }  public List<AbstractFieldEditor> createFieldEditors() {    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();    TextFieldEditor editor0 = new TextFieldEditor("采购项目", "projCode");    editorList.add(editor0);    editorList.add(projNameEditor);    TextFieldEditor editor5 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_CODE), "packCode");    editorList.add(editor5);    editor5 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_TRANS_PACK_NAME), "packName");    editorList.add(editor5);    //String columNames[] = { "专家" };    //ExpertSelectHandler hd = new ExpertSelectHandler(columNames);    //expertFe = new ForeignEntityFieldEditor("ZcEbEvalBidTeam.getEvalBidTeamMemberByProj", dto, 60, hd, columNames, "评标组长", "evalLeaderName");    //editorList.add(expertFe);    return editorList;  }  @Override  public JComponent createSubBillPanel() {    JTabbedPane tabPane = new JTabbedPane();    memberTablePanel.init();    memberTablePanel.setTablePreferencesKey(this.getClass().getName() + "member_table");    memberTablePanel.getTable().setShowCheckedColumn(false);    memberTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 0));    tabPane.addTab("专家列表", memberTablePanel);    this.subMemberTableToolbar = new JFuncToolBar();    JButton addMemberBtn = new JButton("添加");    JButton insertMemberBtn = new JButton("插入");    JButton delMemberBtn = new JButton("删除");    this.subMemberTableToolbar.add(addMemberBtn);    this.subMemberTableToolbar.add(insertMemberBtn);    this.subMemberTableToolbar.add(delMemberBtn);    //memberTablePanel.add(this.subMemberTableToolbar, BorderLayout.SOUTH);    return tabPane;  }  protected void addMember(JTablePanel tablePanel) {  }  protected void deleteMember(JTablePanel tablePanel) {  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.zc.AbstractMainSubEditPanel#initToolBar(com.ufgov.gk.client.component.JFuncToolBar)   */  @Override  public void initToolBar(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    toolBar.add(editButton);    toolBar.add(saveButton);    //    toolBar.add(auditButton);    //    toolBar.add(unAuditButton);    toolBar.add(openNotepadButton);    toolBar.add(previousButton);    toolBar.add(nextButton);    toolBar.add(exitButton);    toolBar.add(helpButton);    editButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doEdit();      }    });    saveButton.addActionListener(new ActionListener() {      @Override      public void actionPerformed(ActionEvent e) {        // TODO Auto-generated method stub        doSave();      }    });    previousButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doPrevious();      }    });    nextButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doNext();      }    });    exitButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doExit();      }    });    helpButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doHelp();      }    });    openNotepadButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doOpenNotepad();      }    });  }  private void doOpenNotepad() {    ZcEbEvalBidTeam sheet = (ZcEbEvalBidTeam) this.listCursor.getCurrentObject();    String sn = fetchSn(sheet);    if (sn != null) {      new ZcNotepadDialog(sn, parent);    }  }  public String fetchSn(ZcEbEvalBidTeam sheet) {    String sn = null;    if (sheet.getProjCode() == null || "".equals(sheet.getProjCode())) {      JOptionPane.showMessageDialog(this, "项目为空不能记录相关信息 ！", "错误", JOptionPane.ERROR_MESSAGE);      return sn;    }    ZcEbProj proj = zcEbProjServiceDelegate.getZcEbProjByProjCode(sheet.getProjCode(), requestMeta);    if (proj == null) {      JOptionPane.showMessageDialog(this, "项目为空不能记录相关信息 ！", "错误", JOptionPane.ERROR_MESSAGE);      return sn;    }    List packs = proj.getPackList();    if (packs == null || packs.size() == 0 || ((ZcEbPack) (packs.get(0))).getEntrustCode() == null) {      JOptionPane.showMessageDialog(this, "请先创建标段信息，再记录相关信息 ！", "错误", JOptionPane.ERROR_MESSAGE);      return sn;    }    sn = ((ZcEbPack) (packs.get(0))).getEntrustCode();    return sn;  }  protected void doEdit() {    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;    updateFieldEditorsEditable();    ZcEbEvalBidTeam team = (ZcEbEvalBidTeam) listCursor.getCurrentObject();    ElementConditionDto dto = new ElementConditionDto();    dto.setDattr1(team.getProjCode());    dto.setDattr2(team.getPackCode());    this.expertFe.updateDto(dto);    setButtonStatus();  }  private void doPrevious() {    stopTableEditing(this.memberTablePanel);    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      } else {        listCursor.setCurrentObject(oldEvalBidTeam);      }    }    listCursor.previous();    refreshData();    setButtonStatus();  }  private void doNext() {    stopTableEditing(this.memberTablePanel);    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      } else {        listCursor.setCurrentObject(oldEvalBidTeam);      }    }    listCursor.next();    refreshData();    setButtonStatus();  }  public void doExit() {    stopTableEditing(this.memberTablePanel);    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      }    }    this.parent.dispose();  }  public boolean doSave() {    if (!isDataChanged()) {      JOptionPane.showMessageDialog(self, "数据未发生变化，不需要保存！", "提示", JOptionPane.INFORMATION_MESSAGE);      return false;    }    ZcEbEvalBidTeam team = (ZcEbEvalBidTeam) this.listCursor.getCurrentObject();    //    if (!validateData(team, this.compoId))    //      return false;    if (team.getTeamMembers() == null || team.getTeamMembers().size() == 0) {      JOptionPane.showMessageDialog(self, "小组成员不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);      return false;    }    if (!checkBeforeSave())      return false;    boolean success = true;    String errorInfo = "";    try {      team = this.zcEbEvalBidTeamServiceDelegate.saveFN(team, requestMeta);    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      this.listCursor.setCurrentObject(team);      this.oldEvalBidTeam = (ZcEbEvalBidTeam) ObjectUtil.deepCopy(team);      this.listPanel.refreshCurrentTabData();      JOptionPane.showMessageDialog(self, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;      updateFieldEditorsEditable();      setButtonStatus();      setOldObject();      return true;    } else {      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      return false;    }  }  protected boolean checkBeforeSave() {    return true;  }  public void doHelp() {  }  public void stopTableEditing(JTablePanel panel) {    JPageableFixedTable table = panel.getTable();    if (table.isEditing()) {      table.getCellEditor().stopCellEditing();    }  }  public boolean isDataChanged() {    stopTableEditing(this.memberTablePanel);    return !DigestUtil.digest(oldEvalBidTeam).equals(DigestUtil.digest(listCursor.getCurrentObject()));  }  public IZcEbEvalBidTeamServiceDelegate getZcEbEvalBidTeamServiceDelegate() {    return zcEbEvalBidTeamServiceDelegate;  }  public void setZcEbEvalBidTeamServiceDelegate(IZcEbEvalBidTeamServiceDelegate zcEbEvalBidTeamServiceDelegate) {    this.zcEbEvalBidTeamServiceDelegate = zcEbEvalBidTeamServiceDelegate;  }}