package com.ufgov.zc.client.zc.huiyuan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.common.UIUtilities;
import com.ufgov.smartclient.component.table.JGroupableTable;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;
import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.common.converter.zc.HuiyuanUnitcominfoToTableModelConverter;
import com.ufgov.zc.client.component.GkBaseDialog;
import com.ufgov.zc.client.component.GkCommentDialog;
import com.ufgov.zc.client.component.GkCommentUntreadDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.JTablePanel;
import com.ufgov.zc.client.component.button.AddButton;
import com.ufgov.zc.client.component.button.CallbackButton;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.EditButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.NextButton;
import com.ufgov.zc.client.component.button.PreviousButton;
import com.ufgov.zc.client.component.button.PrintButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.SendButton;
import com.ufgov.zc.client.component.button.SuggestAuditPassButton;
import com.ufgov.zc.client.component.button.TraceButton;
import com.ufgov.zc.client.component.button.UnauditButton;
import com.ufgov.zc.client.component.button.UntreadButton;
import com.ufgov.zc.client.component.button.zc.CommonButton;
import com.ufgov.zc.client.component.table.celleditor.DateCellEditor;
import com.ufgov.zc.client.component.table.celleditor.HuiYuanAttachFileCellEditor;
import com.ufgov.zc.client.component.table.celleditor.TextCellEditor;
import com.ufgov.zc.client.component.table.cellrenderer.DateCellRenderer;
import com.ufgov.zc.client.component.table.codecelleditor.AsValComboBoxCellEditor;
import com.ufgov.zc.client.component.table.codecellrenderer.AsValCellRenderer;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.NewLineFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.util.ListUtil;
import com.ufgov.zc.client.util.SwingUtil;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.commonbiz.model.BillElement;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.WFConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.system.util.Utils;
import com.ufgov.zc.common.zc.model.HuiyuanAttachinfo;
import com.ufgov.zc.common.zc.model.HuiyuanPeopleblack;
import com.ufgov.zc.common.zc.model.HuiyuanUnitblack;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.common.zc.model.HuiyuanZfcgGongyinginfo;
import com.ufgov.zc.common.zc.model.ZcBaseBill;
import com.ufgov.zc.common.zc.publish.IHuiyuanPeopleblackDelegate;
import com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate;
import com.ufgov.zc.common.zc.publish.IHuiyuanUnitcominfoDelegate;
import com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

public class HuiyuanUnitcominfoEditPanel extends AbstractMainSubEditPanel {

  /**
   * 
   */
  private static final long serialVersionUID = -3660381854525115379L;

  private static final Logger logger = Logger.getLogger(HuiyuanUnitcominfoEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "ZC_HUIYUAN_ZFCG_GONGYINGINFO";

  protected FuncButton saveButton = new SaveButton();

  protected FuncButton addButton = new AddButton();

  protected FuncButton editButton = new EditButton();

  private FuncButton traceButton = new TraceButton();

  protected FuncButton callbackButton = new CallbackButton();

  protected FuncButton deleteButton = new DeleteButton();

  private FuncButton previousButton = new PreviousButton();

  private FuncButton nextButton = new NextButton();

  private FuncButton exitButton = new ExitButton();

  protected FuncButton sendButton = new SendButton();

  public FuncButton printButton = new PrintButton();

  // 工作流填写意见审核通过
  protected FuncButton suggestPassButton = new SuggestAuditPassButton();

  // 工作流销审
  protected FuncButton unAuditButton = new UnauditButton();

  // 工作流退回
  protected FuncButton unTreadButton = new UntreadButton();

  //退回
  protected FuncButton frebackBtn = new CommonButton("freback", null);

  //审核通过
  protected FuncButton fpassBtn = new CommonButton("fpass", null);

  //审核不通过
  protected FuncButton funpassBtn = new CommonButton("funpass", null);

  //作废
  protected FuncButton fdestroyBtn = new CommonButton("fdestroy", null);

  //注销
  protected FuncButton fzhuxiaoBtn = new CommonButton("fzhuxiao", null);

  //启用
  protected FuncButton fqiyongBtn = new CommonButton("fqiyong", null);

  //暂停
  protected FuncButton fzantingBtn = new CommonButton("fzanting", null);

  protected ListCursor<HuiyuanUnitcominfo> listCursor;

  private HuiyuanUnitcominfo oldHuiyuanUnitcominfo;

  public HuiyuanUnitcominfoListPanel listPanel;

  protected HuiyuanUnitcominfoEditPanel self = this;

  protected GkBaseDialog parent;

  private ArrayList<ButtonStatus> auditBtnStatusList = new ArrayList<ButtonStatus>();

  private ArrayList<ButtonStatus> accountBtnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMetaZfcg = BillElementMeta.getBillElementMetaWithoutNd("ZC_HUIYUAN_ZFCG_GONGYINGINFO");

  private BillElementMeta mainBillElementMetaUnit = BillElementMeta.getBillElementMetaWithoutNd("HUIYUAN_UNITCOMINFO");

  protected IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  public IHuiyuanUnitcominfoDelegate huiyuanUnitcominfoServiceDelegate = (IHuiyuanUnitcominfoDelegate) ServiceFactory.create(IHuiyuanUnitcominfoDelegate.class, "huiyuanUnitcominfoDelegate");

  private IHuiyuanUserDelegate huiyuanUserServiceDelegate = (IHuiyuanUserDelegate) ServiceFactory.create(IHuiyuanUserDelegate.class, "huiyuanUserDelegate");

  private IHuiyuanUnitblackDelegate huiyuanUnitblackDelegate = (IHuiyuanUnitblackDelegate) ServiceFactory.create(IHuiyuanUnitblackDelegate.class, "huiyuanUnitblackDelegate");

  private IHuiyuanPeopleblackDelegate huiyuanPeopleblackDelegate = (IHuiyuanPeopleblackDelegate) ServiceFactory.create(IHuiyuanPeopleblackDelegate.class, "huiyuanPeopleblackDelegate");

  List<AbstractFieldEditor> unitEditorList = new ArrayList<AbstractFieldEditor>();

  List<AbstractFieldEditor> zfcgEditorList = new ArrayList<AbstractFieldEditor>();

  JPanel unitComInfoPanel = new JPanel(), zfcgGysInfoPanel = new JPanel();

  JTablePanel userTablePanel = new JTablePanel();

  JTablePanel zizhiTablePanel = new JTablePanel();

  JTablePanel unitBlackTablePanel = new JTablePanel();

  JTablePanel peopleBlackTablePanel = new JTablePanel();

  JTablePanel attchInfoTablePanel = new JTablePanel();

  public HuiyuanUnitcominfoEditPanel(HuiyuanUnitcominfoDialog parent, ListCursor listCursor, String tabStatus, HuiyuanUnitcominfoListPanel listPanel) {
    // TCJLODO Auto-generated constructor stub
    super(HuiyuanUnitcominfoEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId), TitledBorder.CENTER, TitledBorder.TOP,

    new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.listCursor = listCursor;

    this.listPanel = listPanel;

    this.parent = parent;

    this.colCount = 3;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
  }

  private void refreshData() {
    // TCJLODO Auto-generated method stub

    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) listCursor.getCurrentObject();

    if (qx != null && !"".equals(ZcUtil.safeString(qx.getDanweiguid()))) {//列表页面双击进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      qx = huiyuanUnitcominfoServiceDelegate.selectByPrimaryKey(qx.getDanweiguid(), this.requestMeta);

      listCursor.setCurrentObject(qx);
      this.setEditingObject(qx);
    } else {//新增按钮进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;

      qx = new HuiyuanUnitcominfo();

      setDefaultValue(qx);

      listCursor.getDataList().add(qx);

      listCursor.setCurrentObject(qx);

      this.setEditingObject(qx);

    }

    refreshSubData(qx);

    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();

  }

  protected void updateFieldEditorsEditable() {

    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) listCursor.getCurrentObject();

    Long processInstId = qx.getProcessInstId();

    if (processInstId != null && processInstId.longValue() > 0) {

      // 工作流的单据

      wfCanEditFieldMap = BillElementMeta.getWfCanEditField(qx, requestMeta);

      if ("cancel".equals(this.oldHuiyuanUnitcominfo.getZfcgGysInfo().getAuditstatus())) {// 撤销单据设置字段为不可编辑

        wfCanEditFieldMap = null;

      }

      for (AbstractFieldEditor editor : fieldEditors) {

        // 工作流中定义可编辑的字段

        if (wfCanEditFieldMap != null && wfCanEditFieldMap.containsKey(Utils.getDBColNameByFieldName(editor.getEditObject(), editor.getFieldName()))) {

          isEdit = true;
          this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;

          editor.setEnabled(true);

        } else {

          editor.setEnabled(false);

        }

      }
      //工作流中该节点选中了保存按钮可用，则当前状态当前人可用编辑
      if (saveButton.isVisible() && saveButton.isEnabled()) {
        isEdit = true;
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;

      }

    } else {
      for (AbstractFieldEditor editor : fieldEditors) {
        if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
          if ("zfcgGysInfo.auditstatus".equals(editor.getFieldName()) || "zfcgGysInfo.statuscode".equals(editor.getFieldName())) {
            editor.setEnabled(false);
          } else {
            editor.setEnabled(true);
          }
          isEdit = true;
        } else {
          editor.setEnabled(false);
        }
      }
    }

    setWFSubTableEditable(attchInfoTablePanel, isEdit);
    //
    //    setWFSubTableEditable(itemTablePanel, isEdit);

  }

  private void setDefaultValue(HuiyuanUnitcominfo qx) {
    // TCJLODO Auto-generated method stub
    qx.getZfcgGysInfo().setAuditstatus(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_DRAFT);
    qx.getZfcgGysInfo().setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZAN_TING);
    qx.setDanweitype(ZcSettingConstants.V_HUI_YUAN_DAN_WEI_TYPE_GONG_YING_SHANG);
    /*   qx.setStatus(ZcSettingConstants.WF_STATUS_DRAFT);
       qx.setNd(this.requestMeta.getSvNd());
       qx.setInputDate(this.requestMeta.getSysDate());
       qx.setExcutor(requestMeta.getSvUserID());
       qx.setExcutorName(requestMeta.getSvUserName());

       qx.setSupplier(requestMeta.getSvUserID());
       qx.setSupplierName(requestMeta.getSvUserName());*/

  }

  protected void setButtonStatus() {
    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) listCursor.getCurrentObject();
    if (WFConstants.AUDIT_TAB_STATUS_CANCEL.equals(qx.getZfcgGysInfo().getAuditstatus())) {
      setCancelStatus(listCursor);
    } else {
      setButtonStatus(qx, requestMeta, this.listCursor);
    }
  }

  public void setButtonStatusWithoutWf() {
    setAuditBtnStatus();
    setAccountBtnStatus();
  }

  /**
   * 设置审核相关按钮状态s
   */
  private void setAuditBtnStatus() {

    if (this.auditBtnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();

      bs.setButton(this.addButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.editButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.saveButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addPageStatus(ZcSettingConstants.BILL_STATUS_ALL);

      auditBtnStatusList.add(bs);
      bs = new ButtonStatus();
      bs.setButton(this.deleteButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("1");//编辑中
      bs.addBillStatus("2");//待审核
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.exitButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.sendButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.suggestPassButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.callbackButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.unAuditButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.unTreadButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      bs = new ButtonStatus();
      bs.setButton(this.printButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      auditBtnStatusList.add(bs);

      //----
      bs = new ButtonStatus();
      bs.setButton(this.fpassBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("1");//编辑中
      bs.addBillStatus("2");//待审核
      bs.addBillStatus("4");//审核不通过
      bs.addBillStatus("5");//作废
      bs.addBillStatus("7");//退回
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.funpassBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("1");//编辑中
      bs.addBillStatus("2");//待审核 
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.fdestroyBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("1");//编辑中
      auditBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.frebackBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("1");//编辑中
      auditBtnStatusList.add(bs);
    }

    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    String billStatus = qx.getZfcgGysInfo().getAuditstatus();
    ZcUtil.setButtonEnable(this.auditBtnStatusList, billStatus, this.pageStatus, getCompoId(), qx.getProcessInstId());
  }

  /**
   * 设置审核相关按钮状态s
   */
  private void setAccountBtnStatus() {

    if (this.accountBtnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();
      //----
      bs = new ButtonStatus();
      bs.setButton(this.fqiyongBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("1");//注销 
      bs.addBillStatus("3");//暂停
      bs.addBillStatus("4");//处罚中 
      accountBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.fzantingBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("2");//启用 
      accountBtnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.fzhuxiaoBtn);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus("2");//启用
      bs.addBillStatus("3");//暂停
      bs.addBillStatus("4");//处罚中 
      accountBtnStatusList.add(bs);
    }

    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    String billStatus = qx.getZfcgGysInfo().getStatuscode();
    ZcUtil.setButtonEnable(this.accountBtnStatusList, billStatus, this.pageStatus, getCompoId(), qx.getProcessInstId());
  }

  protected void setOldObject() {

    oldHuiyuanUnitcominfo = (HuiyuanUnitcominfo) ObjectUtil.deepCopy(listCursor.getCurrentObject());

  }

  private void refreshSubData(HuiyuanUnitcominfo qx) {
    // TCJLODO Auto-generated method stub
    HuiyuanUnitcominfoToTableModelConverter convert = new HuiyuanUnitcominfoToTableModelConverter();
    userTablePanel.setTableModel(convert.convertUserTableData(qx.getUserLst()));
    unitBlackTablePanel.setTableModel(convert.convertUnitBlackTableData(qx.getUnitBlackLst()));
    peopleBlackTablePanel.setTableModel(convert.convertPeopleBlackTableData(qx.getPeopleBlackLst()));
    refreshAttachFileTable(qx);
  }

  private void refreshAttachFileTable(HuiyuanUnitcominfo qx) {

    HuiyuanUnitcominfoToTableModelConverter convert = new HuiyuanUnitcominfoToTableModelConverter();
    if (ZcSettingConstants.PAGE_STATUS_BROWSE.equals(pageStatus)) {
      attchInfoTablePanel.setTableModel(convert.convertAttachInfoTableData2(qx.getAttachInfoLst()));
      // 设置分包需求明细列类型
      setAttachTableProperty2(attchInfoTablePanel.getTable());
    } else {
      attchInfoTablePanel.setTableModel(convert.convertAttachInfoTableData(qx.getAttachInfoLst()));
      // 设置分包需求明细列类型
      setAttachTableProperty(attchInfoTablePanel.getTable());
    }
    ZcUtil.translateColName(attchInfoTablePanel.getTable(), convert.getAtachInfo());
  }

  private void setAttachTableProperty(JPageableFixedTable table) {

    table.setDefaultEditor(String.class, new TextCellEditor());

    HuiYuanAttachFileCellEditor fileCellEditor = new HuiYuanAttachFileCellEditor("attachguid", true);//itemAttachBlobid
    //    fileCellEditor.setDeleteFileEnable(false);
    //    fileCellEditor.setUploadFileEnable(false);
    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_ATTACHFILENAME, fileCellEditor);

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_MODULETYPE, new AsValComboBoxCellEditor(HuiyuanAttachinfo.VS_HUIYUAN_ATTACH_TYPE));
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_MODULETYPE, new AsValCellRenderer(HuiyuanAttachinfo.VS_HUIYUAN_ATTACH_TYPE));

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_ISREALZUOFEI, new AsValComboBoxCellEditor(HuiyuanAttachinfo.VS_HUIYUAN_SHI_FOU_ZUO_FEI));
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_ISREALZUOFEI, new AsValCellRenderer(HuiyuanAttachinfo.VS_HUIYUAN_SHI_FOU_ZUO_FEI));

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_AUDITSTATUS, new AsValComboBoxCellEditor(HuiyuanAttachinfo.VS_HUIYUAN_AUDIT_STATUS));
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_AUDITSTATUS, new AsValCellRenderer(HuiyuanAttachinfo.VS_HUIYUAN_AUDIT_STATUS));

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_UPLOADDATETIME, new DateCellEditor());
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_UPLOADDATETIME, new DateCellRenderer());
  }

  private void setAttachTableProperty2(JPageableFixedTable table) {

    table.setDefaultEditor(String.class, new TextCellEditor());

    HuiYuanAttachFileCellEditor fileCellEditor = new HuiYuanAttachFileCellEditor("attachguid", true);//itemAttachBlobid
    fileCellEditor.setDeleteFileEnable(false);
    fileCellEditor.setUploadFileEnable(false);
    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_ATTACHFILENAME, fileCellEditor);

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_MODULETYPE, new AsValComboBoxCellEditor(HuiyuanAttachinfo.VS_HUIYUAN_ATTACH_TYPE));
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_MODULETYPE, new AsValCellRenderer(HuiyuanAttachinfo.VS_HUIYUAN_ATTACH_TYPE));

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_AUDITSTATUS, new AsValComboBoxCellEditor(HuiyuanAttachinfo.VS_HUIYUAN_AUDIT_STATUS));
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_AUDITSTATUS, new AsValCellRenderer(HuiyuanAttachinfo.VS_HUIYUAN_AUDIT_STATUS));

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_ISREALZUOFEI, new AsValComboBoxCellEditor(HuiyuanAttachinfo.VS_HUIYUAN_SHI_FOU_ZUO_FEI));
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_ISREALZUOFEI, new AsValCellRenderer(HuiyuanAttachinfo.VS_HUIYUAN_SHI_FOU_ZUO_FEI));

    SwingUtil.setTableCellEditor(table, HuiyuanAttachinfo.COL_UPLOADDATETIME, new DateCellEditor());
    SwingUtil.setTableCellRenderer(table, HuiyuanAttachinfo.COL_UPLOADDATETIME, new DateCellRenderer());
  }

  protected void hideCol(JTable table, String colName) {

    TableColumn tc = table.getColumn(colName);

    table.getColumnModel().removeColumn(tc);

  }

  private void setTablePorperty() {

  }

  public String getCompoId() {
    // TCJLODO Auto-generated method stub
    return compoId;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#initToolBar(com.ufgov.zc.client.component.JFuncToolBar)
   */
  @Override
  public void initToolBar(JFuncToolBar toolBar) {
    // TCJLODO Auto-generated method stub

    toolBar.setModuleCode("ZC");

    toolBar.setCompoId(getCompoId());

    toolBar.add(editButton);

    toolBar.add(saveButton);

    //    toolBar.add(sendButton);

    //    toolBar.add(suggestPassButton); 

    //    toolBar.add(unAuditButton);

    //    toolBar.add(unTreadButton);

    //    toolBar.add(callbackButton);

    //    toolBar.add(printButton);

    //    toolBar.add(traceButton);

    //    toolBar.add(previousButton);

    //    toolBar.add(nextButton);

    toolBar.add(fpassBtn);
    toolBar.add(funpassBtn);
    //    toolBar.add(frebackBtn);
    //    toolBar.add(fdestroyBtn);
    toolBar.add(deleteButton);
    toolBar.add(fqiyongBtn);
    toolBar.add(fzantingBtn);
    toolBar.add(fzhuxiaoBtn);

    toolBar.add(exitButton);

    fzhuxiaoBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doZhuxiao();

      }

    });

    fzantingBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doZanting();

      }

    });

    fqiyongBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doQiyong();

      }

    });

    fpassBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPass();

      }

    });
    funpassBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doUnPass();

      }

    });
    frebackBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doReback();

      }

    });
    fdestroyBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doDestroy();

      }

    });

    editButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doEdit();

      }

    });

    sendButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doSend();

      }

    });

    previousButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPrevious();

      }

    });

    nextButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doNext();

      }

    });

    exitButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doExit();

      }

    });

    saveButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doSave();

      }

    });

    deleteButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doDelete();

      }

    });

    traceButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doTrace();

      }

    });

    callbackButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        doCallback();

      }

    });

    suggestPassButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {

        // 填写意见审核

        doSuggestPass();

      }

    });

    unAuditButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 销审

        //        doUnAudit();

      }

    });

    unTreadButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        // 退回

        doUnTread();

      }

    });

    printButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doPrintButton();

      }

    });
  }

  protected void doQiyong() {
    HuiyuanUnitcominfo inData = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    if (!inData.getZfcgGysInfo().getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
      JOptionPane.showMessageDialog(this, "只有审核通过的供应商才可以启用！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    updateAccountStatus("启用", fqiyongBtn);
  }

  private void updateAccountStatus(String opreation, FuncButton btn) {
    // TCJLODO Auto-generated method stub
    int num = JOptionPane.showConfirmDialog(this, "确定要" + opreation + "吗?", opreation + "确认", 0);

    if (num == JOptionPane.NO_OPTION) { return; }

    boolean success = true;
    String errorInfo = "";
    HuiyuanUnitcominfo inData = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    try {
      requestMeta.setFuncId(btn.getFuncId());
      HuiyuanUnitcominfo qx = huiyuanUnitcominfoServiceDelegate.upateAccountStatusFN(inData, this.requestMeta);
      listCursor.setCurrentObject(qx);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      success = false;
      errorInfo += e.getMessage();
    }
    if (success) {
      JOptionPane.showMessageDialog(this, opreation + "成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      refreshData();
      this.listPanel.refreshCurrentTabData();
    } else {
      JOptionPane.showMessageDialog(this, opreation + "失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
    }
  }

  protected void doZanting() {
    // TCJLODO Auto-generated method stub
    HuiyuanUnitcominfo inData = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    if (!inData.getZfcgGysInfo().getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
      JOptionPane.showMessageDialog(this, "只有审核通过的供应商才可以暂停！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    updateAccountStatus("暂停", fzantingBtn);
  }

  protected void doZhuxiao() {
    // TCJLODO Auto-generated method stub
    HuiyuanUnitcominfo inData = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    if (!inData.getZfcgGysInfo().getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
      JOptionPane.showMessageDialog(this, "只有审核通过的供应商才可以注销！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    updateAccountStatus("注销", fzhuxiaoBtn);
  }

  protected void doDestroy() {
    // TCJLODO Auto-generated method stub
    updateAuditStatus(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_DESTROY);
  }

  protected void doReback() {
    // TCJLODO Auto-generated method stub
    updateAuditStatus(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_BACK);

  }

  protected void doUnPass() {
    // TCJLODO Auto-generated method stub
    updateAuditStatus(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_UNPASS);
  }

  protected void doPass() {
    // TCJLODO Auto-generated method stub
    updateAuditStatus(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS);
  }

  protected void doSend() {

    boolean success = true;

    HuiyuanUnitcominfo afterSaveBill = null;

    if (this.isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    try {

      requestMeta.setFuncId(this.sendButton.getFuncId());

      HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUnitcominfoServiceDelegate.newCommitFN(qx, requestMeta);

    } catch (Exception ex) {

      logger.error(ex.getMessage(), ex);

      success = false;

      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());

    }

    if (success) {
      this.listCursor.setCurrentObject(afterSaveBill);
      refreshData();

      JOptionPane.showMessageDialog(this, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    }

  }

  protected void doPrevious() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

        return;

        }

      } else {

        listCursor.setCurrentObject(oldHuiyuanUnitcominfo);

      }

    }

    listCursor.previous();

    refreshData();

  }

  protected void doNext() {

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

        return;

        }

      } else {

        listCursor.setCurrentObject(oldHuiyuanUnitcominfo);

      }

    }

    listCursor.next();

    refreshData();

  }

  public boolean doSave() {

    if (!isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据没有发生改变，不用保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return true;

    }

    if (!checkBeforeSave()) {

    return false;

    }

    boolean success = true;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(saveButton.getFuncId());

      HuiyuanUnitcominfo inData = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();

      //      System.out.println("before=" + inData.getCoCode() + inData.getCoName());

      HuiyuanUnitcominfo qx = huiyuanUnitcominfoServiceDelegate.saveFN(inData, this.requestMeta);

      //      System.out.println("after=" + qx.getCoCode() + qx.getCoName());

      listCursor.setCurrentObject(qx);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

    return success;

  }

  private boolean updateAuditStatus(String auditStatus) {

    boolean success = true;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(saveButton.getFuncId());

      HuiyuanUnitcominfo inData = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();

      inData.getZfcgGysInfo().setAuditstatus(auditStatus);

      HuiyuanUnitcominfo qx = huiyuanUnitcominfoServiceDelegate.updateAuditStatusFN(inData, this.requestMeta);

      //      System.out.println("after=" + qx.getCoCode() + qx.getCoName());

      listCursor.setCurrentObject(qx);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, "操作成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "操作失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

    return success;

  }

  /**
   * 保存前校验
   * @param cpApply
   * @return
   */

  protected boolean checkBeforeSave() {

    List mainNotNullList = mainBillElementMetaZfcg.getNotNullBillElement();

    List unitNotNullList = mainBillElementMetaUnit.getNotNullBillElement();

    mainNotNullList.addAll(unitNotNullList);

    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    String mainValidateInfo = ZcUtil.validateBillElementNull(qx, mainNotNullList);

    if (mainValidateInfo.length() != 0) {

      errorInfo.append("\n").append(mainValidateInfo.toString()).append("\n");

    }

    if (errorInfo.length() != 0) {

      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);

      return false;

    }

    return true;
  }

  protected void doDelete() {
    requestMeta.setFuncId(deleteButton.getFuncId());
    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();

    int num = JOptionPane.showConfirmDialog(this, "是否删除吗", "删除确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      String errorInfo = "";
      try {
        requestMeta.setFuncId(deleteButton.getFuncId());
        huiyuanUnitcominfoServiceDelegate.deleteByPrimaryKeyFN(qx.getDanweiguid(), this.requestMeta);
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        success = false;
        errorInfo += e.getMessage();
      }

      if (success) {
        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        this.listPanel.refreshCurrentTabData();
        parent.closeDialog();
      } else {
        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  /*

   * 流程跟踪

   */

  private void doTrace() {

    ZcBaseBill bean = (ZcBaseBill) this.listCursor.getCurrentObject();

    if (bean == null) {

    return;

    }

    ZcUtil.showTraceDialog(bean, compoId);

  }

  /*

   * 收回

   */

  protected void doCallback() {

    boolean success = true;

    HuiyuanUnitcominfo afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.callbackButton.getFuncId());

      HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUnitcominfoServiceDelegate.callbackFN(qx, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      refreshData();

      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  protected void doSuggestPass() {

    if (!checkBeforeSave()) {

    return;

    }

    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    requestMeta.setFuncId(this.suggestPassButton.getFuncId());

    executeAudit(qx, ZcSettingConstants.IS_GOON_AUDIT_YES, null);

  }

  protected void executeAudit(HuiyuanUnitcominfo ht, int isGoonAudit, String defaultMsg) {

    GkCommentDialog commentDialog = null;

    if (defaultMsg == null) {

      commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),

      ModalityType.APPLICATION_MODAL);

    } else {

      commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),

      ModalityType.APPLICATION_MODAL, defaultMsg);

    }

    if (commentDialog.cancel) {

    return;

    }

    boolean success = true;

    String errorInfo = "";

    try {

      ht.setComment(commentDialog.getComment());

      ht.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      //      huiyuanUnitcominfoServiceDelegate.updateFN(ht, requestMeta);

      ht = huiyuanUnitcominfoServiceDelegate.auditFN(ht, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshData();

      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  /*

   * 销审

   */

  protected void doUnAudit() {
    HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    boolean success = true;

    HuiyuanUnitcominfo afterSaveBill = null;

    String errorInfo = "";

    int i = JOptionPane.showConfirmDialog(this, "是否确定消审？", "确认", JOptionPane.INFORMATION_MESSAGE);

    if (i != 0) {

    return;

    }

    try {

      requestMeta.setFuncId(unAuditButton.getFuncId());

      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUnitcominfoServiceDelegate.unAuditFN(qx, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.listCursor.setCurrentObject(afterSaveBill);

      refreshData();

      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  private void stopTableEditing() {

  }

  public boolean isDataChanged() {

    stopTableEditing();
    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) { return false; }

    return !DigestUtil.digest(oldHuiyuanUnitcominfo).equals(DigestUtil.digest(listCursor.getCurrentObject()));

  }

  /*

   * 退回

   */

  protected void doUnTread() {

    GkCommentUntreadDialog commentDialog = new GkCommentUntreadDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),

    ModalityType.APPLICATION_MODAL);

    if (commentDialog.cancel) {

    return;

    }

    boolean success = true;

    HuiyuanUnitcominfo afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(unTreadButton.getFuncId());

      HuiyuanUnitcominfo qx = (HuiyuanUnitcominfo) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      qx.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      qx.setComment(commentDialog.getComment());

      afterSaveBill = huiyuanUnitcominfoServiceDelegate.untreadFN(qx, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.listCursor.setCurrentObject(afterSaveBill);

      refreshData();

      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      this.listPanel.refreshCurrentTabData();

    } else {

      JOptionPane.showMessageDialog(this, "退回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  private void doPrintButton() {

  }

  private void doEdit() {

    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;

    HuiyuanUnitcominfo inData = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();

    refreshAttachFileTable(inData);

    updateFieldEditorsEditable();

    setButtonStatus();

  }

  private List<AbstractFieldEditor> createUnitFieldEditor() {

    TextFieldEditor unitName = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_DANWEINAME), "danweiname");
    AsValFieldEditor gysAuditStatus = new AsValFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_AUDITSTATUS), "zfcgGysInfo.auditstatus", ZcSettingConstants.V_HUI_YUAN_AUDIT_STATUS);
    AsValFieldEditor gysStatusCode = new AsValFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_STATUSCODE), "zfcgGysInfo.statuscode", ZcSettingConstants.V_HUI_YUAN_ACCOUNT_STATUS);
    TextFieldEditor unitAreaCode = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_AREACODE), "areacode");
    TextFieldEditor unitAreaName = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_AREANAME), "areaname");

    TextFieldEditor unitUnitOrgNum = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_UNITORGNUM), "unitorgnum");
    AsValFieldEditor unitCompanyType = new AsValFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_COMPANYTYPE), "companytype", ZcSettingConstants.V_HUI_YUAN_COMPANY_TYPE);
    DateFieldEditor unitChenLiTime = new DateFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_CHENLITIME), "chenlitime");

    TextFieldEditor unitFaRen = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_FAREN), "faren");
    TextFieldEditor unitFaRenZhiWu = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_FARENZHIWU), "farenzhiwu");
    AsValFieldEditor unitFaRenZhiCheng = new AsValFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_FARENZHICHENG), "farenzhicheng", ZcSettingConstants.V_HUI_YUAN_ZHI_CHENG);

    TextFieldEditor unitWebAddress = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_WEBADDRESS), "webaddress");
    TextFieldEditor unitFaRenTel = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_FARENTEL), "farentel");
    TextFieldEditor unitLicenceNum = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_LICENCENUM), "licencenum");

    MoneyFieldEditor unitzhuceziben = new MoneyFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_ZHUCEZIBEN), "zhuceziben");
    TextFieldEditor unitZhuCeType = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_ZHUCETYPE), "zhucetype");
    //    TextFieldEditor unitZhuCeAddress = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_ZHUCEADDRESS), "zhuceaddress");
    TextAreaFieldEditor unitZhuCeAddressAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_ZHUCEADDRESS), "zhuceaddress", 240, 1, 7);

    //    TextFieldEditor unitJinYingFanWei = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_JINYINGFANWEI), "jinyingfanwei");
    TextAreaFieldEditor unitJinYingFanWeiAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_JINYINGFANWEI), "jinyingfanwei", 500, 2, 7);
    DateFieldEditor unitYingYeQiXianFrom = new DateFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_YINGYEQIXIANFROM), "yingyeqixianfrom");
    DateFieldEditor unitYingYeQiXianTo = new DateFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_YINGYEQIXIANTO), "yingyeqixianto");

    TextAreaFieldEditor unitCompanyDesAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_COMPANYDES), "companydes", -1, 5, 7);
    DateFieldEditor unitBuildDate = new DateFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_BUILDDATE), "builddate");
    TextAreaFieldEditor unitMainItemAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_MAINITEM), "mainitem", 1500, 5, 7);

    TextAreaFieldEditor unitMianProductAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_MIANPRODUCT), "mianproduct", 1500, 5, 7);
    TextAreaFieldEditor unitAssistantItemAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_ASSISTANTITEM), "assistantitem", 1500, 2, 7);
    TextAreaFieldEditor unitAssistantProductAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_ASSISTANTPRODUCT), "assistantproduct", 1500, 2, 7);

    TextFieldEditor unitGuoShuiNo = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_GUOSHUINO), "guoshuino");
    TextFieldEditor unitDiShuiNO = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_DISHUINO), "dishuino");
    TextFieldEditor unitFaRenLicenceNum = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_FARENLICENCENUM), "farenlicencenum");

    TextFieldEditor unitEnglishName = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_ENGLISHNAME), "englishname");
    TextFieldEditor unitUnitJianCheng = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_UNITJIANCHENG), "unitjiancheng");
    AsValFieldEditor unitDanWeiType = new AsValFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_DANWEITYPE), "danweitype", ZcSettingConstants.V_HUI_YUAN_DAN_WEI_TYPE);

    TextFieldEditor unitDengJiJiGuan = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_DENGJIJIGUAN), "dengjijiguan");
    TextFieldEditor unitQiYeSheBaoHao = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_QIYESHEBAOHAO), "qiyeshebaohao");
    TextFieldEditor unitNianjianjieguo = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitcominfo.COL_NIANJIANJIEGUO), "nianjianjieguo");

    unitEditorList.add(unitName);
    unitEditorList.add(unitUnitJianCheng);
    unitEditorList.add(gysAuditStatus);
    unitEditorList.add(gysStatusCode);

    unitEditorList.add(unitAreaCode);
    unitEditorList.add(unitAreaName);
    unitEditorList.add(unitUnitOrgNum);
    unitEditorList.add(unitChenLiTime);

    unitEditorList.add(unitFaRen);
    unitEditorList.add(unitFaRenZhiWu);
    unitEditorList.add(unitFaRenZhiCheng);
    unitEditorList.add(unitFaRenTel);

    unitEditorList.add(unitzhuceziben);
    unitEditorList.add(unitZhuCeType);
    //    unitEditorList.add(unitGuoShuiNo);
    //    unitEditorList.add(unitDiShuiNO);

    //    unitEditorList.add(unitLicenceNum);
    //    unitEditorList.add(unitFaRenLicenceNum);
    unitEditorList.add(unitYingYeQiXianFrom);
    unitEditorList.add(unitYingYeQiXianTo);

    unitEditorList.add(unitDengJiJiGuan);
    unitEditorList.add(unitCompanyType);
    unitEditorList.add(unitDanWeiType);
    unitEditorList.add(unitQiYeSheBaoHao);

    unitEditorList.add(unitNianjianjieguo);
    unitEditorList.add(unitBuildDate);
    unitEditorList.add(unitEnglishName);
    unitEditorList.add(unitWebAddress);

    unitEditorList.add(unitCompanyDesAreaField);
    unitEditorList.add(unitZhuCeAddressAreaField);
    unitEditorList.add(unitJinYingFanWeiAreaField);
    unitEditorList.add(unitMainItemAreaField);
    unitEditorList.add(unitMianProductAreaField);
    unitEditorList.add(unitAssistantItemAreaField);
    unitEditorList.add(unitAssistantProductAreaField);

    return unitEditorList;
  }

  private List<AbstractFieldEditor> createZfcgGysFieldEditor() {

    TextAreaFieldEditor gysRemarkAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_REMARK), "zfcgGysInfo.remark", 500, 2, 7);

    TextFieldEditor gysJinchukouqypino = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_JINCHUKOUQYPINO), "zfcgGysInfo.jinchukouqypino");
    AsValFieldEditor gysJingYeType = new AsValFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_JINGYETYPE), "zfcgGysInfo.jingyetype", ZcSettingConstants.V_HUI_YUAN_JING_YING_TYPE);
    AsValFieldEditor gysGongYingShangType = new AsValFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_GONGYINGSHANGTYPE), "zfcgGysInfo.gongyingshangtype",
      ZcSettingConstants.V_HUI_YUAN_GYS_TYPE);

    AsValFieldEditor gysZhuCeJiBie = new AsValFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_ZHUCEJIBIE), "zfcgGysInfo.zhucejibie", ZcSettingConstants.V_HUI_YUAN_ZHU_CE_JI_BIE);

    TextFieldEditor gysLocalLianXiRen = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LOCALLIANXIREN), "zfcgGysInfo.locallianxiren");
    TextFieldEditor gysLocalMobile = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LOCALMOBILE), "zfcgGysInfo.localmobile");
    TextFieldEditor gysAccount = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_ACCOUNT), "zfcgGysInfo.account");

    TextFieldEditor gysBank = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_BANK), "zfcgGysInfo.bank");
    TextFieldEditor gysLianXiRen1 = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN1), "zfcgGysInfo.lianxiren1");
    TextFieldEditor gysLianXiRen2 = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN2), "zfcgGysInfo.lianxiren2");

    TextFieldEditor gysLianXiRen1Email = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN1EMAIL), "zfcgGysInfo.lianxiren1email");
    TextFieldEditor gysLianXiRen2Email = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN2EMAIL), "zfcgGysInfo.lianxiren2email");
    TextFieldEditor gysLianXiRen1Mobile = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN1MOBILE), "zfcgGysInfo.lianxiren1mobile");

    TextFieldEditor gysLianXiRen2Moblie = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN2MOBLIE), "zfcgGysInfo.lianxiren2moblie");
    TextFieldEditor gysLianXiRen1Tel = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN1TEL), "zfcgGysInfo.lianxiren1tel");
    TextFieldEditor gysLianXiRen2Tel = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN2TEL), "zfcgGysInfo.lianxiren2tel");

    TextFieldEditor gysLianXiRen1Fax = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN1FAX), "zfcgGysInfo.lianxiren1fax");
    TextFieldEditor gysLianXiRen2Fax = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN2FAX), "zfcgGysInfo.lianxiren2fax");
    TextFieldEditor gysLianXiRen1Address = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN1ADDRESS), "zfcgGysInfo.lianxiren1address");

    TextFieldEditor gysLianXiRen2Address = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN2ADDRESS), "zfcgGysInfo.lianxiren2address");
    TextFieldEditor gysLianXiRen1Zip = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN1ZIP), "zfcgGysInfo.lianxiren1zip");
    TextFieldEditor gysLianXiRen2Zip = new TextFieldEditor(LangTransMeta.translate(HuiyuanZfcgGongyinginfo.COL_LIANXIREN2ZIP), "zfcgGysInfo.lianxiren2zip");

    zfcgEditorList.add(gysGongYingShangType);
    zfcgEditorList.add(gysZhuCeJiBie);
    zfcgEditorList.add(gysLocalLianXiRen);
    zfcgEditorList.add(gysLocalMobile);

    zfcgEditorList.add(gysBank);
    zfcgEditorList.add(gysAccount);
    zfcgEditorList.add(gysJinchukouqypino);
    zfcgEditorList.add(new NewLineFieldEditor());

    zfcgEditorList.add(gysLianXiRen1);
    zfcgEditorList.add(gysLianXiRen1Mobile);
    zfcgEditorList.add(gysLianXiRen1Tel);
    zfcgEditorList.add(gysLianXiRen1Email);

    zfcgEditorList.add(gysLianXiRen1Fax);
    zfcgEditorList.add(gysLianXiRen1Zip);
    zfcgEditorList.add(gysLianXiRen1Address);
    zfcgEditorList.add(new NewLineFieldEditor());

    zfcgEditorList.add(gysLianXiRen2);
    zfcgEditorList.add(gysLianXiRen2Moblie);
    zfcgEditorList.add(gysLianXiRen2Tel);
    zfcgEditorList.add(gysLianXiRen2Email);

    zfcgEditorList.add(gysLianXiRen2Fax);
    zfcgEditorList.add(gysLianXiRen2Zip);
    zfcgEditorList.add(gysLianXiRen2Address);
    zfcgEditorList.add(new NewLineFieldEditor());

    zfcgEditorList.add(gysRemarkAreaField);

    return zfcgEditorList;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createFieldEditors()
   */
  @Override
  public List<AbstractFieldEditor> createFieldEditors() {

    fieldEditors = new ArrayList<AbstractFieldEditor>();

    fieldEditors.addAll(createUnitFieldEditor());
    fieldEditors.addAll(createZfcgGysFieldEditor());

    return fieldEditors;

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createSubBillPanel()
   */
  @Override
  public JComponent createSubBillPanel() {

    JTabbedPane tb = new JTabbedPane();

    JScrollPane js = new JScrollPane(zfcgGysInfoPanel);
    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    initUserPanel();
    initUnitBlackPanel();
    initPeopleBlackPanel();
    initAttachInfoPanel();

    tb.addTab("其他信息", js);
    tb.addTab("相关资质文件", attchInfoTablePanel);
    tb.addTab("用户信息", userTablePanel);
    tb.addTab("单位不良行为记录", unitBlackTablePanel);
    tb.addTab("个人不良行为记录", peopleBlackTablePanel);

    return tb;
  }

  private void initAttachInfoPanel() {

    // TCJLODO Auto-generated method stub
    attchInfoTablePanel.init();
    attchInfoTablePanel.setPanelId("attchInfoTablePanel");
    attchInfoTablePanel.getSearchBar().setVisible(true);

    attchInfoTablePanel.setTablePreferencesKey(this.getClass().getName() + "_attchInfoTable");

    attchInfoTablePanel.getTable().setShowCheckedColumn(true);

    attchInfoTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(60, 0));

    JFuncToolBar bottomToolBar1 = new JFuncToolBar();

    //    FuncButton addBtn = new CommonButton("fadd", "新增", null);
    JButton addBtn1 = new JButton("添加");
    JButton insertBtn1 = new JButton("插入");
    JButton delBtn1 = new JButton("删除");
    bottomToolBar1.add(addBtn1);
    bottomToolBar1.add(insertBtn1);
    bottomToolBar1.add(delBtn1);

    attchInfoTablePanel.add(bottomToolBar1, BorderLayout.SOUTH);

    /* addBtn.addActionListener(new ActionListener() {

       public void actionPerformed(ActionEvent e) {
         HuiyuanUnitcominfo unit = (HuiyuanUnitcominfo) listCursor.getCurrentObject();
         if (unit.getDanweiguid() == null || unit.getDanweiguid().trim().length() == 0) {
           JOptionPane.showMessageDialog(self, "请先保存供应商的单位信息后，再添加附件信息.", "提示", JOptionPane.INFORMATION_MESSAGE);
           return;
         }
         if (!unit.getZfcgGysInfo().getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
           JOptionPane.showMessageDialog(self, "只有审核通过供应商信息后，才可以添加附件信息.", "提示", JOptionPane.INFORMATION_MESSAGE);
           return;
         }
         HuiyuanAttachinfo peopleBlack = new HuiyuanAttachinfo();
         peopleBlack.setDanweiguid(unit.getDanweiguid());
         peopleBlack.setClientguid(unit.getDanweiguid());
         List beanList = new ArrayList();
         beanList.add(peopleBlack);
         new HuiyuanPeopleblackDialog(self, beanList, 0);
       }

     });*/

    addBtn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        HuiyuanUnitcominfo bill = (HuiyuanUnitcominfo) listCursor.getCurrentObject();
        HuiyuanAttachinfo detail = new HuiyuanAttachinfo();
        detail.setDanweiguid(bill.getDanweiguid());
        detail.setClientguid(bill.getDanweiguid());
        addSub(attchInfoTablePanel, detail);
      }
    });

    insertBtn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        HuiyuanUnitcominfo bill = (HuiyuanUnitcominfo) listCursor.getCurrentObject();
        HuiyuanAttachinfo detail = new HuiyuanAttachinfo();
        detail.setDanweiguid(bill.getDanweiguid());
        detail.setClientguid(bill.getDanweiguid());
        insertSub(attchInfoTablePanel, detail);
      }
    });

    delBtn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteSub(attchInfoTablePanel);
      }
    });
    /*
    attchInfoTablePanel.getTable().addMouseListener(new MouseAdapter() {

      public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
          JGroupableTable table = attchInfoTablePanel.getTable();
          MyTableModel model = (MyTableModel) table.getModel();
          int row = table.getSelectedRow();
          List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));
          new HuiyuanPeopleblackDialog(self, viewList, 0);
        }
      }
    });*/
    attchInfoTablePanel.setMinimumSize(new Dimension(240, 150));
  }

  private void initPeopleBlackPanel() {
    // TCJLODO Auto-generated method stub
    peopleBlackTablePanel.init();
    peopleBlackTablePanel.setPanelId("peopleBlackTablePanel");
    peopleBlackTablePanel.getSearchBar().setVisible(true);

    peopleBlackTablePanel.setTablePreferencesKey(this.getClass().getName() + "_peopleBlackTable");

    peopleBlackTablePanel.getTable().setShowCheckedColumn(true);

    peopleBlackTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(60, 0));

    JFuncToolBar bottomToolBar1 = new JFuncToolBar();

    FuncButton addBtn = new CommonButton("fadd", "新增", null);

    bottomToolBar1.add(addBtn);
    peopleBlackTablePanel.add(bottomToolBar1, BorderLayout.SOUTH);

    if (ZcUtil.haveFunc("HUIYUAN_UNITBLACK", "fadd", requestMeta)) {
      addBtn.setVisible(true);
    }

    addBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        HuiyuanUnitcominfo unit = (HuiyuanUnitcominfo) listCursor.getCurrentObject();
        if (unit.getDanweiguid() == null || unit.getDanweiguid().trim().length() == 0) {
          JOptionPane.showMessageDialog(self, "请先保存供应商的单位信息后，再添加单位人员的不良行为.", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        if (!unit.getZfcgGysInfo().getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
          JOptionPane.showMessageDialog(self, "只有审核通过供应商信息后，才可以添加其单位人员的不良行为.", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        HuiyuanPeopleblack peopleBlack = new HuiyuanPeopleblack();
        peopleBlack.setDanweiguid(unit.getDanweiguid());
        peopleBlack.setDanweiname(unit.getDanweiname());
        List beanList = new ArrayList();
        beanList.add(peopleBlack);
        new HuiyuanPeopleblackDialog(self, beanList, 0);
      }

    });
    peopleBlackTablePanel.getTable().addMouseListener(new MouseAdapter() {

      public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
          JGroupableTable table = peopleBlackTablePanel.getTable();
          MyTableModel model = (MyTableModel) table.getModel();
          int row = table.getSelectedRow();
          List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));
          new HuiyuanPeopleblackDialog(self, viewList, 0);
        }
      }
    });
    peopleBlackTablePanel.setMinimumSize(new Dimension(240, 150));
  }

  private void initUnitBlackPanel() {
    // TCJLODO Auto-generated method stub

    unitBlackTablePanel.init();
    unitBlackTablePanel.setPanelId("unitBlackTablePanel");
    unitBlackTablePanel.getSearchBar().setVisible(true);

    unitBlackTablePanel.setTablePreferencesKey(this.getClass().getName() + "_unitBlackTable");

    unitBlackTablePanel.getTable().setShowCheckedColumn(true);

    unitBlackTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(60, 0));

    JFuncToolBar bottomToolBar1 = new JFuncToolBar();

    FuncButton addBtn = new CommonButton("fadd", "新增", null);

    bottomToolBar1.add(addBtn);
    unitBlackTablePanel.add(bottomToolBar1, BorderLayout.SOUTH);

    if (ZcUtil.haveFunc("HUIYUAN_UNITBLACK", "fadd", requestMeta)) {
      addBtn.setVisible(true);
    }

    addBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        HuiyuanUnitcominfo unit = (HuiyuanUnitcominfo) listCursor.getCurrentObject();
        if (unit.getDanweiguid() == null || unit.getDanweiguid().trim().length() == 0) {
          JOptionPane.showMessageDialog(self, "请先保存供应商的单位信息后，再添加本单位的不良行为.", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        if (!unit.getZfcgGysInfo().getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
          JOptionPane.showMessageDialog(self, "只有审核通过供应商信息后，才可以添加其单位的不良行为.", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        HuiyuanUnitblack unitBlack = new HuiyuanUnitblack();
        unitBlack.setDanweiguid(unit.getDanweiguid());
        unitBlack.setDanweiname(unit.getDanweiname());
        unitBlack.setUnitorgnum(unit.getUnitorgnum());
        List beanList = new ArrayList();
        beanList.add(unitBlack);
        new HuiyuanUnitblackDialog(self, beanList, 0);
      }

    });
    unitBlackTablePanel.getTable().addMouseListener(new MouseAdapter() {

      public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
          JGroupableTable table = unitBlackTablePanel.getTable();
          MyTableModel model = (MyTableModel) table.getModel();
          int row = table.getSelectedRow();
          List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));
          new HuiyuanUnitblackDialog(self, viewList, 0);
        }
      }
    });
    unitBlackTablePanel.setMinimumSize(new Dimension(240, 150));

  }

  private void initUserPanel() {
    // TCJLODO Auto-generated method stub

    userTablePanel.init();
    userTablePanel.setPanelId("userTablePanel");
    userTablePanel.getSearchBar().setVisible(true);

    userTablePanel.setTablePreferencesKey(this.getClass().getName() + "_userTable");

    userTablePanel.getTable().setShowCheckedColumn(true);

    userTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(60, 0));

    JFuncToolBar bottomToolBar1 = new JFuncToolBar();

    FuncButton addBtn = new CommonButton("fadd", "新增", null);

    bottomToolBar1.add(addBtn);
    userTablePanel.add(bottomToolBar1, BorderLayout.SOUTH);

    if (ZcUtil.haveFunc("HUIYUAN_USER", "fadd", requestMeta)) {
      addBtn.setVisible(true);
    }

    addBtn.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        HuiyuanUnitcominfo unit = (HuiyuanUnitcominfo) listCursor.getCurrentObject();
        if (unit.getDanweiguid() == null || unit.getDanweiguid().trim().length() == 0) {
          JOptionPane.showMessageDialog(self, "请先保存供应商的单位信息后，再添加本单位的用户.", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        if (!unit.getZfcgGysInfo().getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
          JOptionPane.showMessageDialog(self, "只有审核通过供应商信息后，才可以添加其单位人员信息.", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        if (!unit.getZfcgGysInfo().getStatuscode().equals(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_QI_YONG)) {
          JOptionPane.showMessageDialog(self, "只有处于启用状态的供应商，才可以添加其单位人员信息.", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        HuiyuanUser user = new HuiyuanUser();
        user.setDanweiguid(unit.getDanweiguid());
        user.setDanweiname(unit.getDanweiname());
        List beanList = new ArrayList();
        beanList.add(user);
        new HuiyuanUserDialog(self, beanList, 0);
      }

    });
    userTablePanel.getTable().addMouseListener(new MouseAdapter() {

      public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
          JGroupableTable table = userTablePanel.getTable();
          MyTableModel model = (MyTableModel) table.getModel();
          int row = table.getSelectedRow();
          List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));
          new HuiyuanUserDialog(self, viewList, 0);
        }
      }
    });
    userTablePanel.setMinimumSize(new Dimension(240, 150));

  }

  protected void init() {

    this.initToolBar(toolBar);

    this.setLayout(new BorderLayout());

    this.add(toolBar, BorderLayout.NORTH);

    this.add(workPanel, BorderLayout.CENTER);

    createFieldEditors();

    ZcUtil zcutil = new ZcUtil();

    List<BillElement> zfcgNotNullFields = mainBillElementMetaZfcg.getNotNullBillElement();
    List<BillElement> unitNotNullFields = mainBillElementMetaUnit.getNotNullBillElement();

    if (unitNotNullFields != null) {
      unitComInfoPanel = zcutil.initFieldEditorPanel(HuiyuanUnitcominfo.class, unitNotNullFields, unitEditorList, 4);
      zfcgGysInfoPanel = zcutil.initFieldEditorPanel(HuiyuanUnitcominfo.class, zfcgNotNullFields, zfcgEditorList, 4);
    } else {
      unitComInfoPanel = zcutil.initFieldEditorPanel(unitEditorList, 4);
      zfcgGysInfoPanel = zcutil.initFieldEditorPanel(zfcgEditorList, 4);
    }

    workPanel.setLayout(new BorderLayout());

    JScrollPane js = new JScrollPane(unitComInfoPanel);
    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    Double dd = new Double(unitComInfoPanel.getPreferredSize().getWidth());
    int w = dd.intValue() + 1;
    js.setPreferredSize(new Dimension(w, 300));
    workPanel.add(js, BorderLayout.NORTH);

    JComponent tabPanel = createSubBillPanel();

    if (tabPanel != null) {

      workPanel.add(tabPanel, BorderLayout.CENTER);

    }

  }

  public void doExit() {
    // TCJLODO Auto-generated method stub

    /* if (isDataChanged()) {

       int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

       if (num == JOptionPane.YES_OPTION) {

         if (!doSave()) {

         return;

         }

       }

     }*/

    this.parent.dispose();

  }

  public void refreshSubData(ZcBaseBill obj) {
    HuiyuanUnitcominfo unit = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    if (obj instanceof HuiyuanUser) {
      ElementConditionDto dto = new ElementConditionDto();
      dto.setZcText1(unit.getDanweiguid());
      List userLst = huiyuanUserServiceDelegate.getMainDataLst(dto, requestMeta);
      unit.setUserLst(userLst);
      userTablePanel.setTableModel(new HuiyuanUnitcominfoToTableModelConverter().convertUserTableData(unit.getUserLst()));
    } else if (obj instanceof HuiyuanUnitblack) {
      ElementConditionDto dto = new ElementConditionDto();
      dto.setZcText1(unit.getDanweiguid());
      List unitBlackLst = huiyuanUnitblackDelegate.getMainDataLst(dto, requestMeta);
      unit.setUnitBlackLst(unitBlackLst);
      unitBlackTablePanel.setTableModel(new HuiyuanUnitcominfoToTableModelConverter().convertUnitBlackTableData(unit.getUnitBlackLst()));
    } else if (obj instanceof HuiyuanPeopleblack) {
      ElementConditionDto dto = new ElementConditionDto();
      dto.setZcText1(unit.getDanweiguid());
      List peopleBlackLst = huiyuanPeopleblackDelegate.getMainDataLst(dto, requestMeta);
      unit.setPeopleBlackLst(peopleBlackLst);
      peopleBlackTablePanel.setTableModel(new HuiyuanUnitcominfoToTableModelConverter().convertPeopleBlackTableData(unit.getPeopleBlackLst()));
    }
  }

  public Window getParentWindow() {
    return parent;
  }

  public HuiyuanUnitcominfo getCurHuiyuanUnit() {
    HuiyuanUnitcominfo unit = (HuiyuanUnitcominfo) this.listCursor.getCurrentObject();
    return unit;
  }
}