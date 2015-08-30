/** * ZcEbPlanEditPanel.java * com.ufgov.gk.client.zc.zcebopenbidplan * Administrator * 2010-5-26 */package com.ufgov.zc.client.zc.project.integration.zbbook;import java.awt.Color;import java.awt.Component;import java.awt.Dimension;import java.awt.FlowLayout;import java.awt.Font;import java.awt.GridBagConstraints;import java.awt.GridBagLayout;import java.awt.Insets;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Date;import java.util.List;import java.util.Map;import javax.swing.BorderFactory;import javax.swing.JButton;import javax.swing.JComponent;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JTabbedPane;import javax.swing.JTable;import javax.swing.border.TitledBorder;import org.apache.log4j.Logger;import swing2swt.layout.BorderLayout;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.ZcEbPlanToTableModelConverter;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.JTablePanel;import com.ufgov.zc.client.component.table.celleditor.MoneyCellEditor;import com.ufgov.zc.client.component.table.celleditor.TextCellEditor;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.JDateTimeTextField.DateChangeEvent;import com.ufgov.zc.client.component.zc.fieldeditor.JDateTimeTextField.DateChangeListener;import com.ufgov.zc.client.component.zc.fieldeditor.NewLineFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.client.util.SwingUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.ztb.component.MainPanel;import com.ufgov.zc.client.zc.ztb.component.ProjectInfoPanel;import com.ufgov.zc.client.zc.ztb.component.SingleSeletionTree;import com.ufgov.zc.client.zc.ztb.component.service.CommonActionService;import com.ufgov.zc.client.zc.ztb.model.BusinessProject;import com.ufgov.zc.client.zc.ztb.model.SmartTreeNode;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.client.zc.ztb.util.PubFunction;import com.ufgov.zc.common.commonbiz.model.BillElement;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.DateUtil;import com.ufgov.zc.common.system.util.DigestUtil;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbPlan;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.common.zc.publish.IZcEbPlanServiceDelegate;import com.ufgov.zc.common.zc.publish.IZcEbProjServiceDelegate;/** * @author LEO */public class ZcEbPlanEditPanel extends AbstractMainSubEditPanel {  private static final Logger logger = Logger.getLogger(ZcEbPlanEditPanel.class);  private final IZcEbPlanServiceDelegate zcEbPlanServiceDelegate = (IZcEbPlanServiceDelegate) ServiceFactory.create(IZcEbPlanServiceDelegate.class,    "zcEbPlanServiceDelegate");  private final IZcEbProjServiceDelegate zcEbProjServiceDelegate = (IZcEbProjServiceDelegate) ServiceFactory.create(IZcEbProjServiceDelegate.class,    "zcEbProjServiceDelegate");  private final RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private final String compoId = "ZC_EB_PLAN";  private ZcEbPlan oldPlan;  private ZcEbPlan currPlan;  private final ZcEbPlanEditPanel self = this;  private final JFrame parent;  private final String projCode;  private final String projName;  private final MainPanel mainPanel;  private int reloadCnt = 0;  private final BillElementMeta billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(this.compoId);  private final JPanel btPanel = new JPanel();//底部放置按钮的panel  public ZcEbPlanEditPanel(JFrame parent, MainPanel mainPanel, Map<String, String> paras) {    super(ZcEbPlan.class, BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_PLAN"));    this.parent = parent;    this.colCount = 2;    this.projCode = paras.get("PROJCODE");    this.projName = paras.get("PROJNAME");    this.mainPanel = mainPanel;    init();    requestMeta.setCompoId(compoId);    refreshData();    updateFieldEditorsEditable();    addControlButtons();    setPlanEnabled();  }  private void addControlButtons() {    btPanel.setLayout(new FlowLayout());    JButton clearBt = new JButton("清 空");    clearBt.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doClear();      }    });    btPanel.add(clearBt);    JButton fillWordBt = new JButton("填充招标书模板");    fillWordBt.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        toFillWord();      }    });    btPanel.add(fillWordBt);    JButton okBt = new JButton("保 存");    okBt.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        boolean isSucc = doSave();        if (isSucc) {          self.parent.dispose();        }      }    });    btPanel.add(okBt);    JButton noBt = new JButton("退 出");    noBt.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doExit();      }    });    btPanel.add(noBt);    this.add(btPanel, BorderLayout.SOUTH);  }  public void setPlanEnabled() {    Component[] funcs = btPanel.getComponents();    for (Component func : funcs) {      func.setEnabled(mainPanel.canEdit);    }    tablePanel.getTable().setEnabled(mainPanel.canEdit);    updateFieldEditorsEditable(mainPanel.canEdit);  }  protected void updateFieldEditorsEditable(boolean enabled) {    for (AbstractFieldEditor fd : this.fieldEditors) {      if(!"openBidTime".equals(fd.getFieldName())){        fd.setEnabled(enabled);      }else{        fd.setEnabled(false);      }    }  }  private void toFillWord() {    if (mainPanel.getWordPane() == null) {      JOptionPane.showMessageDialog(null, "请先打开需要填充的Word文档，然后再试！");      return;    }    SingleSeletionTree sst = mainPanel.getSingleSeletionTree();    SmartTreeNode rootNode = (SmartTreeNode) sst.getTreeNode().getRoot();    SmartTreeNode projNode = PubFunction.getNeedingNodeInChildren(rootNode, GV.NODE_TYPE_PROJECT);    List<SmartTreeNode> packNodeList = new ArrayList<SmartTreeNode>();    PubFunction.doSearchAllMatchingNeedingNodeFromCurrNode(projNode, "nodeType", GV.NODE_TYPE_PACK, false, 2, packNodeList);    if (packNodeList.size() == 0) {      JOptionPane.showMessageDialog(null, "招标书中缺少必要的项目相关信息，例如标段等信息！");      return;    }    CommonActionService cas = new CommonActionService(GV.getCurrFrame());    cas.setMainPanel(mainPanel);    cas.executeFillMold(projCode, packNodeList.get(0).getNodeCode());  }  private void refreshData() {    ElementConditionDto dto = new ElementConditionDto();    dto.setProjCode(projCode);    dto.setManageCode(requestMeta.getSvUserID());    List list = zcEbPlanServiceDelegate.getZcEbPlan(dto, requestMeta);    if (list.size() > 0) {      currPlan = (ZcEbPlan) list.get(0);    }    if (!toCheckIsHaveValues(currPlan)) {      currPlan = zcEbPlanServiceDelegate.getHistoryZcEbPlan(dto, requestMeta);      if (currPlan == null) {        currPlan = new ZcEbPlan();      }      setDefaultValue(currPlan);    }    currPlan.setProjCode(projCode);    ZcEbProj proj = zcEbProjServiceDelegate.getZcEbProjByProjCode(projCode, requestMeta);    if (proj != null) {      String masterManager = proj.getManager();      String xiebanObj = zcEbProjServiceDelegate.getZcEbXiebanPerson(projCode, requestMeta);      if (xiebanObj != null && !"".equals(xiebanObj)) {        String minorManager = xiebanObj.split("@*@")[1];        currPlan.setDocSeller(masterManager + "、" + minorManager);      } else {        currPlan.setDocSeller(masterManager);      }    }    currPlan.setZcEbPlanPackList(this.zcEbPlanServiceDelegate.getZcEbPlanPackListByProjCode(projCode, requestMeta));    String title = "[" + this.projName + "]执行计划";    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(title),      TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 13), Color.BLUE));    this.setEditingObject(currPlan);    refreshSubTableData(currPlan.getZcEbPlanPackList());    setOldObject();  }  private boolean toCheckIsHaveValues(ZcEbPlan plan) {    if (plan == null) {      return false;    }    String addr = plan.getOpenBidAddress();    if (addr == null) {      return false;    }    return true;  }  private void setDefaultValue(ZcEbPlan plan) {    plan.setPlanCode(null);    plan.setBidEndTime(null);    plan.setSellStartTime(null);    plan.setSellEndTime(null);    plan.setOpenBidTime(null);    plan.setCreator(this.requestMeta.getSvUserName());    plan.setCreateDate(this.requestMeta.getSysDate());    plan.setNd(this.requestMeta.getSvNd());  }  private void setOldObject() {    oldPlan = (ZcEbPlan) ObjectUtil.deepCopy(currPlan);  }  private String getDefaultSDate() {    Date d = this.requestMeta.getSysDate();    return getDefaultSDate(d);  }  private String getDefaultSDate(Date d) {    String sDate = DateUtil.dateToSsString(getDefaultDate(d));    return sDate;  }  private Date getDefaultDate(Date d) {    long t24 = ZcSettingConstants.TIME_MM_PER_DAY;    long t8 = 28800 * 1000;    long dt = 60 * 1000;    return new Date(d.getTime() - (d.getTime() % t24) - t8 + t24 - dt);  }  private long getCurTime() {    long t24 = ZcSettingConstants.TIME_MM_PER_DAY;    Date d = this.requestMeta.getSysDate();    return d.getTime() % t24;  }  private Date buildOpenBidDate(Date d, long curTime) {    long t24 = ZcSettingConstants.TIME_MM_PER_DAY;    return new Date(d.getTime());  }  @Override  public List<AbstractFieldEditor> createFieldEditors() {    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();    Integer[] allowMinutes = { 0, 10, 20, 30, 40, 50 };    DateFieldEditor df = new DateFieldEditor("招标文件公告时间", "sellStartTime", DateFieldEditor.TimeTypeH24, allowMinutes, true);    df.getField().addDateChangeListener(new DateChangeListener() {      public void dateChanged(DateChangeEvent e) {        if (e.getDate() == null) {          return;        }        if (currPlan.getSellEndTime() == null) {          //          Date newTime = new Date(e.getDate().getTime() + 10 * 24 * 3600 * 1000);          currPlan.setSellEndTime(getDefaultDate(e.getDate()));          updateFieldByPropertyName("sellEndTime");        }      }    });    editorList.add(df);    df = new DateFieldEditor("报名截止时间", "sellEndTime", DateFieldEditor.TimeTypeH24, getDefaultSDate(), false, false, false);    df.getField().addDateChangeListener(new DateChangeListener() {      public void dateChanged(DateChangeEvent e) {        if (e.getDate() == null) {          return;        }        currPlan.setSellEndTime(e.getDate());      }    });    editorList.add(df);    //投标截止时间（上传标书截止时间）    df = new DateFieldEditor("投标截止时间", "bidEndTime", DateFieldEditor.TimeTypeH24, allowMinutes, true);    df.getField().addDateChangeListener(new DateChangeListener() {      public void dateChanged(DateChangeEvent e) {        if (e.getDate() == null) {          return;        }//        if (reloadCnt > 0) {          currPlan.setOpenBidTime(buildOpenBidDate(e.getDate(), 3600 * 1000));          updateFieldByPropertyName("openBidTime");//        }        reloadCnt++;      }    });    editorList.add(df);    df = new DateFieldEditor("开标时间", "openBidTime", DateFieldEditor.TimeTypeH24, allowMinutes, true);    df.setEnabled(false);    editorList.add(df);    TextAreaFieldEditor editor1;    //开标地点设置成值集的形式    AsValFieldEditor valFieldEditor = new AsValFieldEditor("开标地点", "openBidAddress", "VS_ZC_OPEN_ADDRESS");    //    TextAreaFieldEditor editor1 = new TextAreaFieldEditor("开标地点", "openBidAddress", 100, 1, 4);    editorList.add(valFieldEditor);    //    TextFieldEditor editor11 = new TextFieldEditor("标书价格", "docPrice");    //    editorList.add(editor11);    TextFieldEditor editor11 = new TextFieldEditor("联 系 人", "docSeller");    editorList.add(editor11);    editor11 = new TextFieldEditor("联系电话", "docSellPhone");    editorList.add(editor11);    //    editor1 = new TextAreaFieldEditor("备注", "remark", 200, 1, 4);    //    editorList.add(editor1);    editor11 = new TextFieldEditor("创建人", "creator");    editor11.setEnabled(false);    editorList.add(editor11);    DateFieldEditor editor6a = new DateFieldEditor("创建日期", "createDate");    editor6a.setEnabled(false);    editorList.add(editor6a);    return editorList;  }  @Override  protected void initFieldEditorPanel(Class billClass, BillElementMeta eleMeta) {    fieldEditors = createFieldEditors();    int row = 0;    int col = 0;    List<BillElement> notNullFields = eleMeta.getNotNullBillElement();    fieldEditorPanel.setLayout(new GridBagLayout());    for (int i = 0; i < fieldEditors.size(); i++) {      AbstractFieldEditor comp = fieldEditors.get(i);      if (comp.isVisible()) {        if (comp instanceof NewLineFieldEditor) {          row++;          col = 0;          continue;        } else if (comp instanceof TextAreaFieldEditor) {          // 转到新的一行          row++;          col = 0;          JLabel label = new JLabel(getLabelText(comp));          if (isNotNullField(billClass, comp.getFieldName(),          notNullFields)) {            label.setText(comp.getName() + "*");            if (comp.getMaxContentSize() != 9999) {              label.setText(comp.getName() + "("              + comp.getMaxContentSize() + "字内)" + "*");            }            label.setForeground(new Color(254, 70, 1));            label.setFont(new Font("宋体", Font.BOLD, preferredFontSize));          }          comp.setPreferredSize(new Dimension(150,          comp.getOccRow() * 26));          fieldEditorPanel.add(label, new GridBagConstraints(col,          row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST,          GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,          0));          fieldEditorPanel.add(comp, new GridBagConstraints(col + 1,          row, comp.getOccCol(), comp.getOccRow(), 1.0, 1.0,          GridBagConstraints.WEST,          GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4,          4), 0, 0));          // 将当前所占的行空间偏移量计算上          row += comp.getOccRow();          col = 0;          continue;        } else if (comp.getFieldName().equals("openBidAddress")) {          // 转到新的一行          row++;          col = 0;          JLabel label = new JLabel(getLabelText(comp));          if (isNotNullField(billClass, comp.getFieldName(),          notNullFields)) {            label.setText(comp.getName() + "*");            label.setForeground(new Color(254, 70, 1));            label.setFont(new Font("宋体", Font.BOLD, preferredFontSize));          }          comp.setPreferredSize(new Dimension(150,          comp.getOccRow() * 26));          fieldEditorPanel.add(label, new GridBagConstraints(col,          row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST,          GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,          0));          fieldEditorPanel.add(comp, new GridBagConstraints(col + 1,          row, 4, comp.getOccRow(), 1.0, 1.0,          GridBagConstraints.WEST,          GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4,          4), 0, 0));          // 将当前所占的行空间偏移量计算上          row += comp.getOccRow();          col = 0;          continue;        }        JLabel label = new JLabel(comp.getName());        if (isNotNullField(billClass, comp.getFieldName(),        notNullFields)) {          label.setText(comp.getName() + "*");          label.setForeground(new Color(254, 70, 1));          label.setFont(new Font("宋体", Font.BOLD, preferredFontSize));        }        comp.setPreferredSize(new Dimension(150, 23));        fieldEditorPanel.add(label, new GridBagConstraints(col, row, 1,        1, 1.0, 1.0, GridBagConstraints.EAST,        GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));        fieldEditorPanel.add(comp, new GridBagConstraints(col + 1, row,        1, 1, 1.0, 1.0, GridBagConstraints.WEST,        GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5),        0, 0));        if (col == colCount * 2 - 2) {          row++;          col = 0;        } else {          col += 2;        }      }    }  }  private void updateFieldByPropertyName(String property) {    for (AbstractFieldEditor currEditor : this.fieldEditors) {      if (property.equals(currEditor.getFieldName())) {        currEditor.setValue(currPlan);        return;      }    }  }  private final JTablePanel tablePanel = new JTablePanel();  @Override  public JComponent createSubBillPanel() {    JTabbedPane tabPane = new JTabbedPane();    tablePanel.init();    tablePanel.setTablePreferencesKey(this.getClass().getName() + "_table");    tablePanel.getTable().setShowCheckedColumn(false);    tablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 0));    tabPane.addTab("各分包明细", tablePanel);    return tabPane;  }  private void refreshSubTableData(List deList) {    tablePanel.setTableModel(ZcEbPlanToTableModelConverter.convertPlanPackToTableModel(deList));    ZcUtil.translateColName(tablePanel.getTable(), ZcEbPlanToTableModelConverter.getDetailTableColumnInfo());    setTableProperty(tablePanel.getTable());  }  private void setTableProperty(JTable table) {    SwingUtil.setTableCellEditor(table, "PACK_NAME", new TextCellEditor());    SwingUtil.setTableCellEditor(table, "PACK_DETAIL", new TextCellEditor());    SwingUtil.setTableCellEditor(table, "PACK_BUDGET", new MoneyCellEditor());    SwingUtil.setTableCellEditor(table, "PACK_BID_DOCPRICE", new MoneyCellEditor());    SwingUtil.setTableCellEditor(table, "PACK_BID_DEPOSIT", new MoneyCellEditor());  }  private void doClear() {    for (AbstractFieldEditor currEditor : this.fieldEditors) {      if ("creator".equals(currEditor.getFieldName()) || "createDate".equals(currEditor.getFieldName())) {        continue;      }      currEditor.setValue(null);    }  }  public void doExit() {    if (isDataChanged()) {      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);      if (num == JOptionPane.YES_OPTION) {        if (!doSave()) {          return;        }      }    }    this.parent.dispose();  }  public boolean doSave() {    if (!isDataChanged()) {      JOptionPane.showMessageDialog(self, "数据未发生变化，不需要保存！", "提示", JOptionPane.INFORMATION_MESSAGE);      return false;    }    ZcEbPlan plan = currPlan;    if (!checkBeforeSave()) {      return false;    }    SimpleDateFormat sdf = new SimpleDateFormat(ZcSettingConstants.SIMPLE_DATE_FORMAT_FULL);    StringBuffer buff = new StringBuffer();    buff.append("1、招标文件公告时间:");    buff.append(sdf.format(currPlan.getSellStartTime()));    buff.append(";\n");    buff.append("2、点击投标截止时间:");    buff.append(sdf.format(currPlan.getSellEndTime()));    buff.append(";\n");    buff.append("3、投标截止时间:");    buff.append(sdf.format(currPlan.getBidEndTime()));    buff.append(";\n");    buff.append("4、开标时间:");    buff.append(sdf.format(currPlan.getOpenBidTime()));    buff.append(";\n");    buff.append("5、开标地点:");    buff.append(currPlan.getOpenBidAddress());    buff.append(";\n");    buff.append("6、该计划前后历时共:【");    buff.append((currPlan.getOpenBidTime().getTime() - currPlan.getSellStartTime().getTime()) / (3600L * 1000 * 24));    buff.append("】天;\n\n");    buff.append("数据校验完成，确定提交？");    int sel = JOptionPane.showConfirmDialog(null, buff.toString(), "保存确认", JOptionPane.YES_NO_OPTION);    if (sel == JOptionPane.NO_OPTION) {      return false;    }    boolean success = true;    String errorInfo = "";    try {      if (plan.getCreateDate() == null) {        plan.setCreateDate(new Date());      }      if (plan.getCreator() == null) {        plan.setCreator(requestMeta.getEmpName());      }      plan = this.zcEbPlanServiceDelegate.save(plan, requestMeta);    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      JOptionPane.showMessageDialog(self, "数据保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.oldPlan = (ZcEbPlan) ObjectUtil.deepCopy(plan);      updateFieldEditorsEditable();      //      mainPanel.closeWordPane();      updateProjectInfoPanel();      setOldObject();      if(mainPanel instanceof ZBPanel){        ((ZBPanel)mainPanel).getPanel().refreshPlan(plan);      }      return true;    } else {      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);      return false;    }  }  private void updateProjectInfoPanel() {    BusinessProject bp = ProjectInfoPanel.getBusinessProject();    SimpleDateFormat sdf = new SimpleDateFormat(ZcSettingConstants.SIMPLE_DATE_FORMAT_FULL);    bp.setKbTime(sdf.format(currPlan.getOpenBidTime()));    bp.setkBidAddr(currPlan.getOpenBidAddress());    bp.setTbEndTime(sdf.format(currPlan.getBidEndTime()));    //增加招标项目负责人和电话显示    bp.setPhone(currPlan.getDocSellPhone());    bp.setManager(currPlan.getDocSeller());    if (mainPanel.getWordPane() == null || !mainPanel.getWordPane().isDocOpened()) {      ProjectInfoPanel.setMainPanel(mainPanel);      ProjectInfoPanel.updateObjectToFile(bp);    }  }  private boolean checkBeforeSave() {    ZcEbPlan plan = currPlan;    List notNullBillElementList = this.billElementMeta.getNotNullBillElement();    StringBuilder errorInfo = new StringBuilder();    String validateInfo = ZcUtil.validateBillElementNull(plan, notNullBillElementList);    if (validateInfo.length() != 0) {      errorInfo.append("").append(validateInfo.toString()).append("\n");    }    if (errorInfo.length() != 0) {      JOptionPane.showMessageDialog(this.parent, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);      return false;    }    Date sellStart = plan.getSellStartTime();    Date sellEnd = plan.getSellEndTime();    Date bidDate = plan.getBidEndTime();    Date openBidDate = plan.getOpenBidTime();    if (sellEnd.before(sellStart)) {      errorInfo.append("点击投标截止时间不能早于招标文件公告时间").append("\n");    }    if (bidDate.before(sellEnd)) {      errorInfo.append("投标截止时间不能早于点击投标截止时间").append("\n");    }    if (openBidDate.before(bidDate)) {      errorInfo.append("开标时间不能早于投标截止时间").append("\n");    }    if (errorInfo.length() != 0) {      JOptionPane.showMessageDialog(this.parent, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);      return false;    }    return true;  }  public boolean isDataChanged() {    if (this.tablePanel.getTable() != null) {      if (this.tablePanel.getTable().getCellEditor() != null) {        this.tablePanel.getTable().getCellEditor().stopCellEditing();      }    }    return !DigestUtil.digest(oldPlan).equals(DigestUtil.digest(currPlan));  }  @Override  public void initToolBar(JFuncToolBar toolBar) {  }}