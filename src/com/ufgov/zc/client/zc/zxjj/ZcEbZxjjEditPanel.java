package com.ufgov.zc.client.zc.zxjj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.common.UIUtilities;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;
import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.common.converter.zc.ZcEbZxjjToTableModelConverter;
import com.ufgov.zc.client.component.DateField;
import com.ufgov.zc.client.component.GkBaseDialog;
import com.ufgov.zc.client.component.GkCommentDialog;
import com.ufgov.zc.client.component.GkCommentUntreadDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.JTablePanel;
import com.ufgov.zc.client.component.MoneyField;
import com.ufgov.zc.client.component.button.AddButton;
import com.ufgov.zc.client.component.button.CallbackButton;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.EditButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.ImportButton;
import com.ufgov.zc.client.component.button.NextButton;
import com.ufgov.zc.client.component.button.PreviousButton;
import com.ufgov.zc.client.component.button.PrintButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.SaveSendButton;
import com.ufgov.zc.client.component.button.SendButton;
import com.ufgov.zc.client.component.button.SendGkButton;
import com.ufgov.zc.client.component.button.SubaddButton;
import com.ufgov.zc.client.component.button.SubdelButton;
import com.ufgov.zc.client.component.button.SubinsertButton;
import com.ufgov.zc.client.component.button.SuggestAuditPassButton;
import com.ufgov.zc.client.component.button.TraceButton;
import com.ufgov.zc.client.component.button.UnauditButton;
import com.ufgov.zc.client.component.button.UntreadButton;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.IntFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.datacache.CompanyDataCache;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.commonbiz.model.Company;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.WFConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.system.util.Utils;
import com.ufgov.zc.common.zc.model.ZcBaseBill;
import com.ufgov.zc.common.zc.model.ZcEbZxjj;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbZxjjServiceDelegate;

public class ZcEbZxjjEditPanel extends AbstractMainSubEditPanel {

  /**
   * 
   */
  private static final long serialVersionUID = -3432371310612565726L;

  private static final Logger logger = Logger.getLogger(ZcEbZxjjEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "ZC_EB_ZXJJ";

  protected FuncButton saveButton = new SaveButton();

  protected FuncButton addButton = new AddButton();

  protected FuncButton editButton = new EditButton();

  private FuncButton traceButton = new TraceButton();

  protected FuncButton callbackButton = new CallbackButton();

  protected FuncButton deleteButton = new DeleteButton();

  private FuncButton previousButton = new PreviousButton();

  private FuncButton nextButton = new NextButton();

  private FuncButton exitButton = new ExitButton();

  private FuncButton saveAndSendButton = new SaveSendButton();

  protected FuncButton sendButton = new SendButton();

  public FuncButton printButton = new PrintButton();

  public FuncButton importButton = new ImportButton();

  //送国库
  private FuncButton sendGkButton = new SendGkButton();

  // 工作流填写意见审核通过
  protected FuncButton suggestPassButton = new SuggestAuditPassButton();

  // 工作流销审
  protected FuncButton unAuditButton = new UnauditButton();

  // 工作流退回
  protected FuncButton unTreadButton = new UntreadButton();

  protected ListCursor<ZcEbZxjj> listCursor;

  private ZcEbZxjj oldZcEbZxjj;

  public ZcEbZxjjListPanel listPanel;

  protected JTablePanel historyTablePanel = new JTablePanel();

  protected ZcEbZxjjEditPanel self = this;

  protected GkBaseDialog parent;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_ZXJJ");

  private BillElementMeta biBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd("ZC_EB_ZXJJ_HISTORY");

  protected IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,

  "zcEbBaseServiceDelegate");

  public IZcEbZxjjServiceDelegate zcEbZxjjServiceDelegate = (IZcEbZxjjServiceDelegate) ServiceFactory.create(IZcEbZxjjServiceDelegate.class,

  "zcEbZxjjServiceDelegate");

  JLabel labelSs = new JLabel("00", JLabel.CENTER);

  JLabel labelFf = new JLabel("00", JLabel.CENTER);

  JLabel labelMm = new JLabel("00", JLabel.CENTER);

  public ZcEbZxjjEditPanel(ZcEbZxjjDialog parent, ListCursor listCursor, String tabStatus, ZcEbZxjjListPanel listPanel) {
    // TCJLODO Auto-generated constructor stub
    super(ZcEbZxjjEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId), TitledBorder.CENTER, TitledBorder.TOP,
      new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.listCursor = listCursor;

    this.listPanel = listPanel;

    this.parent = parent;

    this.colCount = 2;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
  }

  private void refreshData() {
    // TCJLODO Auto-generated method stub

    ZcEbZxjj jj = (ZcEbZxjj) listCursor.getCurrentObject();

    if (jj.getJjCode() != null) {//已经存在竞价code了

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      jj = zcEbZxjjServiceDelegate.selectByPrimaryKey(jj.getJjCode(), this.requestMeta);

      jj.setCoName(CompanyDataCache.getNameByCode(jj.getCoCode()));

      listCursor.setCurrentObject(jj);
    } else {//未保存竞价初始化数据的情况进入，还没有竞价code

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;

      jj.setCoName(CompanyDataCache.getNameByCode(jj.getCoCode()));

      setDefaultValue(jj);

    }

    this.setEditingObject(jj);

    refreshSubData(jj);

    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();

  }

  protected void updateFieldEditorsEditable() {

    ZcEbZxjj jj = (ZcEbZxjj) listCursor.getCurrentObject();

    Long processInstId = jj.getProcessInstId();

    if (processInstId != null && processInstId.longValue() > 0) {

      // 工作流的单据

      wfCanEditFieldMap = BillElementMeta.getWfCanEditField(jj, requestMeta);

      if ("cancel".equals(this.oldZcEbZxjj.getStatus())) {// 撤销单据设置字段为不可编辑

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
          if ("zheRangLv".equals(editor.getFieldName()) || "qxName".equals(editor.getFieldName()) || "remark".equals(editor.getFieldName()) || "suLinkMan".equals(editor.getFieldName())
            || "suLinkTel".equals(editor.getFieldName()) || "wxDate".equals(editor.getFieldName()) || "coLinkMan".equals(editor.getFieldName()) || "coCode".equals(editor.getFieldName())) {
            editor.setEnabled(true);
          } else {
            editor.setEnabled(false);
          }
          isEdit = true;
        } else {
          editor.setEnabled(false);
        }
        //        logger.debug("===" + editor.getFieldName() + "=" + editor.isEnabled());
      }
    }

    setWFSubTableEditable(historyTablePanel, isEdit);

  }

  private void setDefaultValue(ZcEbZxjj jj) {
    // TCJLODO Auto-generated method stub
    jj.setStatus(ZcSettingConstants.WF_STATUS_DRAFT);
    jj.setNd(this.requestMeta.getSvNd());
    jj.setInputDate(this.requestMeta.getSysDate());
    jj.setExecutor(requestMeta.getSvUserID());
    jj.setHistoryList(new ArrayList());
    jj.setJjAllRounds(3);
    jj.setJjCurRound(1);
    jj.setJjTimeLen(new BigDecimal(10));

  }

  protected void setButtonStatus() {
    ZcEbZxjj jj = (ZcEbZxjj) listCursor.getCurrentObject();
    if (WFConstants.AUDIT_TAB_STATUS_CANCEL.equals(jj.getStatus())) {
      setCancelStatus(listCursor);
    } else {
      setButtonStatus(jj, requestMeta, this.listCursor);
    }
  }

  public void setButtonStatusWithoutWf() {

    if (this.btnStatusList.size() == 0) {

      ButtonStatus bs = new ButtonStatus();

      bs.setButton(this.addButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs.setButton(this.editButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.WF_STATUS_DRAFT);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.saveButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.exitButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.sendButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.suggestPassButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.callbackButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.unAuditButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.unTreadButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      bs = new ButtonStatus();

      bs.setButton(this.printButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.sendGkButton);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_AUDITED);

      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.importButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      btnStatusList.add(bs);

    }

    ZcEbZxjj jj = (ZcEbZxjj) this.listCursor.getCurrentObject();

    String billStatus = jj.getStatus();

    ZcUtil.setButtonEnable(this.btnStatusList, billStatus, this.pageStatus, getCompoId(), jj.getProcessInstId());

  }

  protected void setOldObject() {

    oldZcEbZxjj = (ZcEbZxjj) ObjectUtil.deepCopy(listCursor.getCurrentObject());

  }

  private void refreshSubData(ZcEbZxjj jj) {
    // TCJLODO Auto-generated method stub
    historyTablePanel.setTableModel(new ZcEbZxjjToTableModelConverter().convertDetailTableData(jj.getHistoryList()));

    ZcUtil.translateColName(historyTablePanel.getTable(), ZcEbZxjjToTableModelConverter.getDetailInfo());

    // 设置从表属性 

    setTablePorperty();

  }

  protected void hideCol(JTable table, String colName) {

    TableColumn tc = table.getColumn(colName);

    table.getColumnModel().removeColumn(tc);

  }

  private void setTablePorperty() {
    // TCJLODO Auto-generated method stub
    //
    //    addBiTableLisenter(biTablePanel.getTable());
    //
    setBiTableEditor(historyTablePanel.getTable());
  }

  private void setBiTableEditor(JPageableFixedTable table) {
    // TCJLODO Auto-generated method stub
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

    /*toolBar.add(editButton);

    toolBar.add(saveButton);

    toolBar.add(sendButton);

    toolBar.add(saveAndSendButton);

    toolBar.add(suggestPassButton); 

    toolBar.add(unAuditButton);

    toolBar.add(unTreadButton);

    toolBar.add(callbackButton);

    toolBar.add(deleteButton); 

    toolBar.add(printButton);

    toolBar.add(traceButton);

    toolBar.add(previousButton);

    toolBar.add(nextButton);*/

    toolBar.add(exitButton);

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

  protected void doSend() {

    boolean success = true;

    ZcEbZxjj afterSaveBill = null;

    if (this.isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    try {

      requestMeta.setFuncId(this.sendButton.getFuncId());

      ZcEbZxjj jj = (ZcEbZxjj) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      jj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = zcEbZxjjServiceDelegate.newCommitFN(jj, requestMeta);

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

        listCursor.setCurrentObject(oldZcEbZxjj);

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

        listCursor.setCurrentObject(oldZcEbZxjj);

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

      ZcEbZxjj inData = (ZcEbZxjj) this.listCursor.getCurrentObject();

      //      System.out.println("before=" + inData.getCoCode() + inData.getCoName());

      ZcEbZxjj jj = zcEbZxjjServiceDelegate.saveFN(inData, this.requestMeta);

      listCursor.setCurrentObject(jj);

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

  /**
   * 保存前校验
   * @param cpApply
   * @return
   */

  protected boolean checkBeforeSave() {

    List mainNotNullList = mainBillElementMeta.getNotNullBillElement();

    List biNotNullList = biBillElementMeta.getNotNullBillElement();

    ZcEbZxjj jj = (ZcEbZxjj) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    String mainValidateInfo = ZcUtil.validateBillElementNull(jj, mainNotNullList);

    String biValidateInfo = ZcUtil.validateDetailBillElementNull(jj.getHistoryList(), biNotNullList, false);

    if (mainValidateInfo.length() != 0) {

      errorInfo.append("\n").append(mainValidateInfo.toString()).append("\n");

    }

    if (biValidateInfo.length() != 0 && ZcUtil.isYsdw()) {

      errorInfo.append("报价历史：\n").append(biValidateInfo.toString()).append("\n");

    }

    if (errorInfo.length() != 0) {

      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);

      return false;

    }
    return true;
  }

  protected void doDelete() {

    requestMeta.setFuncId(deleteButton.getFuncId());

    ZcEbZxjj jj = (ZcEbZxjj) this.listCursor.getCurrentObject();

    if (jj.getJjCode() == null) {

      JOptionPane.showMessageDialog(this, "尚未保存到数据库，无需删除！", "提示", JOptionPane.ERROR_MESSAGE);

      return;

    }

    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      boolean success = true;

      String errorInfo = "";

      try {

        requestMeta.setFuncId(deleteButton.getFuncId());

        zcEbZxjjServiceDelegate.deleteByPrimaryKeyFN(jj.getJjCode(), this.requestMeta);

      } catch (Exception e) {

        logger.error(e.getMessage(), e);

        success = false;

        errorInfo += e.getMessage();

      }

      if (success) {

        this.listCursor.removeCurrentObject();

        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

        this.refreshData();

        this.listPanel.refreshCurrentTabData();

      } else {

        JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

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

    ZcEbZxjj afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.callbackButton.getFuncId());

      ZcEbZxjj jj = (ZcEbZxjj) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      jj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = zcEbZxjjServiceDelegate.callbackFN(jj, requestMeta);

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

    ZcEbZxjj jj = (ZcEbZxjj) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    requestMeta.setFuncId(this.suggestPassButton.getFuncId());

    executeAudit(jj, ZcSettingConstants.IS_GOON_AUDIT_YES, null);

  }

  protected void executeAudit(ZcEbZxjj ht, int isGoonAudit, String defaultMsg) {

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

      ht = zcEbZxjjServiceDelegate.auditFN(ht, requestMeta);

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
    /**
     * 合同备案，销审添加校验,做了支付申请确认单和验收单的，不让销审。
     */
    ZcEbZxjj jj = (ZcEbZxjj) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    boolean success = true;

    ZcEbZxjj afterSaveBill = null;

    String errorInfo = "";

    int i = JOptionPane.showConfirmDialog(this, "是否确定消审？", "确认", JOptionPane.INFORMATION_MESSAGE);

    if (i != 0) {

    return;

    }

    try {

      requestMeta.setFuncId(unAuditButton.getFuncId());

      jj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = zcEbZxjjServiceDelegate.unAuditFN(jj, requestMeta);

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

    JPageableFixedTable biTable = this.historyTablePanel.getTable();

    if (biTable.isEditing()) {

      biTable.getCellEditor().stopCellEditing();

    }

  }

  public boolean isDataChanged() {

    stopTableEditing();
    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) { return false; }

    return !DigestUtil.digest(oldZcEbZxjj).equals(DigestUtil.digest(listCursor.getCurrentObject()));

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

    ZcEbZxjj afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(unTreadButton.getFuncId());

      ZcEbZxjj jj = (ZcEbZxjj) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      jj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      jj.setComment(commentDialog.getComment());

      afterSaveBill = zcEbZxjjServiceDelegate.untreadFN(jj, requestMeta);

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

    updateFieldEditorsEditable();

    setButtonStatus();

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createFieldEditors()
   */
  @Override
  public List<AbstractFieldEditor> createFieldEditors() {

    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();

    AsValFieldEditor qxStatus = new AsValFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_STATUS), "status", ZcEbZxjj.ZC_VS_ZXJJ_STATUS);

    TextFieldEditor projCode = new TextFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_PROJ_CODE), "projCode");

    TextAreaFieldEditor purContent = new TextAreaFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_PUR_CONTENT), "purContent", -1, 2, 3);

    TextFieldEditor coCode = new TextFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_CO_CODE), "coName");

    TextFieldEditor inputor = new TextFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_INPUTOR), "inputor");

    DateFieldEditor beginTime = new DateFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_BEGIN_TIME), "beginTime", DateField.TimeTypeH24, "2015-01-01 00:00:00", true, true, true);

    MoneyFieldEditor jjTimeLen = new MoneyFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_JJ_TIME_LEN), "jjTimeLen");

    IntFieldEditor jjAllRounds = new IntFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_JJ_ALL_ROUNDS), "jjAllRounds");

    IntFieldEditor jjCurRound = new IntFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_JJ_CUR_ROUND), "jjCurRound");

    MoneyFieldEditor jjCurQuote = new MoneyFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_JJ_CUR_QUOTE), "jjCurQuote");

    TextFieldEditor jjCurQuoter = new TextFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_JJ_CUR_QUOTER), "jjCurQuoter");

    TextAreaFieldEditor failReason = new TextAreaFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_FAIL_REASON), "failReason", -1, 1, 3);

    TextAreaFieldEditor remark = new TextAreaFieldEditor(LangTransMeta.translate(ZcEbZxjj.COL_REMARK), "remark", -1, 1, 3);

    editorList.add(projCode);
    editorList.add(coCode);

    editorList.add(purContent);

    editorList.add(beginTime);
    editorList.add(jjTimeLen);

    editorList.add(jjAllRounds);
    editorList.add(jjCurRound);

    editorList.add(jjCurQuote);
    editorList.add(jjCurQuoter);

    editorList.add(qxStatus);

    editorList.add(failReason);
    editorList.add(remark);

    return editorList;

  }

  protected void selectCompany(Company company) {
    // TCJLODO Auto-generated method stub
    ZcEbZxjj jj = (ZcEbZxjj) listCursor.getCurrentObject();
    jj.setCoCode(company.getCode());
    jj.setCoName(company.getName());
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createSubBillPanel()
   */
  @Override
  public JComponent createSubBillPanel() {
    // TCJLODO Auto-generated method stub 

    JTabbedPane biTabPane = new JTabbedPane();

    historyTablePanel.init();

    historyTablePanel.getSearchBar().setVisible(false);

    historyTablePanel.setTablePreferencesKey(this.getClass().getName() + "_biTable");

    historyTablePanel.getTable().setShowCheckedColumn(true);

    historyTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(60, 0));

    biTabPane.addTab("竞价价格", historyTablePanel);

    JFuncToolBar bottomToolBar1 = new JFuncToolBar();

    FuncButton addBtn1 = new SubaddButton(false);

    JButton insertBtn1 = new SubinsertButton(false);

    JButton delBtn1 = new SubdelButton(false);

    bottomToolBar1.add(addBtn1);

    bottomToolBar1.add(insertBtn1);

    bottomToolBar1.add(delBtn1);

    biTabPane.setMinimumSize(new Dimension(240, 300));

    return biTabPane;
  }

  public void doExit() {
    // TCJLODO Auto-generated method stub

    if (isDataChanged()) {

      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);

      if (num == JOptionPane.YES_OPTION) {

        if (!doSave()) {

        return;

        }

      }

    }

    this.parent.dispose();

  }

  protected void init() {

    this.initToolBar(toolBar);

    this.setLayout(new BorderLayout());

    this.add(toolBar, BorderLayout.NORTH);

    this.add(workPanel, BorderLayout.CENTER);

    if (this.billClass != null && this.eleMeta != null) {

      initFieldEditorPanel(this.billClass, this.eleMeta);

    } else {

      initFieldEditorPanel();

    }

    JPanel djsPanel = initTimePanel();

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    topPanel.add(fieldEditorPanel, BorderLayout.CENTER);
    topPanel.add(djsPanel, BorderLayout.EAST);

    workPanel.setLayout(new BorderLayout());

    workPanel.add(topPanel, BorderLayout.NORTH);

    JComponent tabTable = createSubBillPanel();

    if (tabTable != null) {

      workPanel.add(tabTable, BorderLayout.CENTER);

    }

  }

  //倒计时牌
  private JPanel initTimePanel() {
    // TCJLODO Auto-generated method stub
    JPanel p = new JPanel();
    p.setMinimumSize(new Dimension(400, 200));
    p.setPreferredSize(new Dimension(400, 200));
    //    p.setLayout(new GridBagLayout());
    p.setLayout(null);

    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "竞价倒计时", TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));

    /*JLabel labelS = new JLabel("<html><font face=\"宋体\";style=font:15pt>" + "时" + "</font>");
    JLabel labelF = new JLabel("<html><font face=\"宋体\";style=font:15pt>" + "分" + "</font>");
    JLabel labelM = new JLabel("<html><font face=\"宋体\";style=font:15pt>" + "秒" + "</font>");*/

    int w = 100, h = 50, x = 30, y = 30, margin = 10;
    JLabel labelS = new JLabel("时", JLabel.CENTER);
    labelS.setBounds(x, y, w, h);
    //    labelS.setBackground(Color.red);

    labelS.setOpaque(true);
    labelS.setBackground(Color.green); //  设置背景的颜色
    labelS.setForeground(Color.red); //设置前景色
    labelS.setFont(new Font("宋体", Font.BOLD, 28)); //设置字体  

    x = x + w + margin;
    JLabel labelF = new JLabel("分", JLabel.CENTER);
    labelF.setBounds(x, y, w, h);
    labelF.setBackground(Color.green);
    labelF.setForeground(Color.red); //设置前景色
    labelF.setFont(new Font("宋体", Font.BOLD, 28)); //设置字体  
    labelF.setOpaque(true);

    JLabel labelM = new JLabel("秒", JLabel.CENTER);
    x = x + w + margin;
    labelM.setBounds(x, y, w, h);
    labelM.setBackground(Color.green);
    labelM.setForeground(Color.red); //设置前景色
    labelM.setFont(new Font("宋体", Font.BOLD, 28)); //设置字体  
    labelM.setOpaque(true);

    /* p.add(labelS, new GridBagConstraints(0,0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
       GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,0));
     
     p.add(labelF, new GridBagConstraints(1,0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
       GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,0));
     
     p.add(labelM, new GridBagConstraints(2,0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
       GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,0));*/
    p.add(labelS);
    p.add(labelF);
    p.add(labelM);

    y = y + h + margin;
    x = 30;
    h = 80;
    //  “dialog”代表字体，1代表样式(1是粗体，0是平常的）15是字号 
    labelSs.setForeground(Color.red);
    labelSs.setBounds(x, y, w, h);
    labelSs.setBackground(Color.gray);
    labelSs.setFont(new Font("宋体", Font.BOLD, 38)); //设置字体  
    labelSs.setOpaque(true);

    x = x + w + margin;
    labelFf.setForeground(Color.red);
    labelFf.setBounds(x, y, w, h);
    labelFf.setBackground(Color.gray);
    labelFf.setFont(new Font("宋体", Font.BOLD, 38)); //设置字体  
    labelFf.setOpaque(true);

    x = x + w + margin;
    labelMm.setForeground(Color.red);
    labelMm.setBounds(x, y, w, h);
    labelMm.setBackground(Color.gray);
    labelMm.setFont(new Font("宋体", Font.BOLD, 38)); //设置字体  
    labelMm.setOpaque(true);

    /*p.add(labelSs, new GridBagConstraints(0,1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
      GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,0));
    
    p.add(labelFf, new GridBagConstraints(1,1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
      GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,0));
    
    p.add(labelMm, new GridBagConstraints(2,1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
      GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0,0));*/

    p.add(labelSs);
    p.add(labelFf);
    p.add(labelMm);

    margin = 10;
    y = y + h + 50;
    x = 30;
    h = 30;

    JButton beginBtn = new JButton("开始竞价"), cancelBtn = new JButton("废    标"), bidBtn = new JButton("提    交 ");

    if (ZcUtil.isGys()) {
      JLabel labelPrice = new JLabel("我要竞价(元)", JLabel.RIGHT);
      labelPrice.setBounds(x, y, w, h);

      x = x + w + margin;

      MoneyField priceFd = new MoneyField();
      //      priceFd.setPreferredSize(new Dimension(100, 30));
      priceFd.setBounds(x, y, w, h);

      x = x + w + margin;
      bidBtn.setBounds(x, y, w, h);

      p.add(labelPrice);
      p.add(priceFd);
      p.add(bidBtn);
    } else {
      beginBtn.setBounds(x, y, w, h);
      x = x + w + margin;
      cancelBtn.setBounds(x, y, w, h);
      p.add(beginBtn);
      p.add(cancelBtn);
    }

    return p;
  }

}