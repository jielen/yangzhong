/**
 * 
 */
package com.ufgov.zc.client.zc.huiyuan;

import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.common.UIUtilities;
import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.ListCursor;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.component.GkBaseDialog;
import com.ufgov.zc.client.component.GkCommentDialog;
import com.ufgov.zc.client.component.GkCommentUntreadDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
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
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.WFConstants;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.system.util.Utils;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.HuiyuanUser;
import com.ufgov.zc.common.zc.model.ZcBaseBill;
import com.ufgov.zc.common.zc.publish.IHuiyuanUserDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

/**
 * @author Administrator
 */
public class HuiyuanUserEditPanel extends AbstractMainSubEditPanel {

  /**
   * 
   */
  private static final long serialVersionUID = -6247354150917309961L;

  private static final Logger logger = Logger.getLogger(HuiyuanUserEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "HUIYUAN_USER";

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

  protected ListCursor<HuiyuanUser> listCursor;

  private HuiyuanUser oldHuiyuanUser;

  protected HuiyuanUserEditPanel self = this;

  protected GkBaseDialog parent;

  private ArrayList<ButtonStatus> auditBtnStatusList = new ArrayList<ButtonStatus>();

  private ArrayList<ButtonStatus> accountBtnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd("HUIYUAN_USER");

  private IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  private IHuiyuanUserDelegate huiyuanUserServiceDelegate = (IHuiyuanUserDelegate) ServiceFactory.create(IHuiyuanUserDelegate.class, "huiyuanUserDelegate");

  private HuiyuanUnitcominfoEditPanel unitPanel;

  private HuiyuanUnitcominfo unit = new HuiyuanUnitcominfo();

  public HuiyuanUserEditPanel(HuiyuanUserDialog parent, HuiyuanUnitcominfoEditPanel unitPanel, ListCursor listCursor2) {
    // TCJLODO Auto-generated constructor stub
    super(HuiyuanUserEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));

    this.unitPanel = unitPanel;
    this.listCursor = listCursor2;
    this.parent = parent;

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId), TitledBorder.CENTER, TitledBorder.TOP,
      new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.colCount = 4;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
  }

  private void refreshData() {

    HuiyuanUser user = (HuiyuanUser) listCursor.getCurrentObject();

    if (user != null && !"".equals(ZcUtil.safeString(user.getUserguid()))) {//列表页面双击进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      user = huiyuanUserServiceDelegate.selectByPrimaryKey(user.getUserguid(), this.requestMeta);

      listCursor.setCurrentObject(user);
      this.setEditingObject(user);
    } else {//新增按钮进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;

      setDefaultValue(user);

      listCursor.getDataList().add(user);

      listCursor.setCurrentObject(user);

      this.setEditingObject(user);

    }
    refreshSubData(user);

    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();
  }

  protected void updateFieldEditorsEditable() {

    HuiyuanUser user = (HuiyuanUser) listCursor.getCurrentObject();

    Long processInstId = user.getProcessInstId();

    if (processInstId != null && processInstId.longValue() > 0) {

      // 工作流的单据

      wfCanEditFieldMap = BillElementMeta.getWfCanEditField(user, requestMeta);

      if ("cancel".equals(this.oldHuiyuanUser.getAuditstatus())) {// 撤销单据设置字段为不可编辑

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
          if ("auditstatus".equals(editor.getFieldName()) || "statuscode".equals(editor.getFieldName())) {
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

    //    setWFSubTableEditable(biTablePanel, isEdit);
    //
    //    setWFSubTableEditable(itemTablePanel, isEdit);

  }

  private void setOldObject() {
    // TCJLODO Auto-generated method stub
    oldHuiyuanUser = (HuiyuanUser) ObjectUtil.deepCopy(listCursor.getCurrentObject());
  }

  private void refreshSubData(HuiyuanUser user) {
    // TCJLODO Auto-generated method stub

  }

  private void setDefaultValue(HuiyuanUser user) {
    // TCJLODO Auto-generated method stub
    user.setAuditstatus(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_DRAFT);
    user.setStatuscode(ZcSettingConstants.HUI_YUAN_ACCOUNT_STATUS_ZAN_TING);
    user.setUsertype("1");//这个用户类型值集不知，数据库需要填，目前默认用1
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
    //    
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

    HuiyuanUser afterSaveBill = null;

    HuiyuanUser user = (HuiyuanUser) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    if (this.isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    try {

      requestMeta.setFuncId(this.sendButton.getFuncId());

      user.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUserServiceDelegate.newCommitFN(user, requestMeta);

    } catch (Exception ex) {

      logger.error(ex.getMessage(), ex);

      success = false;

      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());

    }

    if (success) {
      this.listCursor.setCurrentObject(afterSaveBill);
      refreshData();

      JOptionPane.showMessageDialog(this, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());

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

        listCursor.setCurrentObject(oldHuiyuanUser);

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

        listCursor.setCurrentObject(oldHuiyuanUser);

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

    HuiyuanUser inData = (HuiyuanUser) this.listCursor.getCurrentObject();

    try {

      requestMeta.setFuncId(saveButton.getFuncId());

      HuiyuanUser user = huiyuanUserServiceDelegate.saveFN(inData, this.requestMeta);

      listCursor.setCurrentObject(user);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();
      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());

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

      HuiyuanUser inData = (HuiyuanUser) this.listCursor.getCurrentObject();

      inData.setAuditstatus(auditStatus);

      HuiyuanUser user = huiyuanUserServiceDelegate.updateAuditStatusFN(inData, this.requestMeta);

      System.out.println("after=" + user.getCoCode() + user.getCoName());

      listCursor.setCurrentObject(user);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, "操作成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();
      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());

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

    List mainNotNullList = mainBillElementMeta.getNotNullBillElement();

    HuiyuanUser user = (HuiyuanUser) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    String mainValidateInfo = ZcUtil.validateBillElementNull(user, mainNotNullList);

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
    HuiyuanUser qx = (HuiyuanUser) this.listCursor.getCurrentObject();

    int num = JOptionPane.showConfirmDialog(this, "是否删除吗", "删除确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      String errorInfo = "";
      try {
        requestMeta.setFuncId(deleteButton.getFuncId());
        huiyuanUserServiceDelegate.deleteByPrimaryKeyFN(qx.getUserguid(), this.requestMeta);
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        success = false;
        errorInfo += e.getMessage();
      }

      if (success) {
        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());
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

    HuiyuanUser afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.callbackButton.getFuncId());

      HuiyuanUser user = (HuiyuanUser) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      user.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUserServiceDelegate.callbackFN(user, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      refreshData();

      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());

    } else {

      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  protected void doSuggestPass() {

    if (!checkBeforeSave()) {

    return;

    }

    HuiyuanUser user = (HuiyuanUser) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    requestMeta.setFuncId(this.suggestPassButton.getFuncId());

    executeAudit(user, ZcSettingConstants.IS_GOON_AUDIT_YES, null);

  }

  protected void executeAudit(HuiyuanUser ht, int isGoonAudit, String defaultMsg) {

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

      //      huiyuanUserServiceDelegate.updateFN(ht, requestMeta);

      ht = huiyuanUserServiceDelegate.auditFN(ht, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshData();

      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());

    } else {

      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  /*

   * 销审

   */

  protected void doUnAudit() {
    HuiyuanUser user = (HuiyuanUser) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    boolean success = true;

    HuiyuanUser afterSaveBill = null;

    String errorInfo = "";

    int i = JOptionPane.showConfirmDialog(this, "是否确定消审？", "确认", JOptionPane.INFORMATION_MESSAGE);

    if (i != 0) {

    return;

    }

    try {

      requestMeta.setFuncId(unAuditButton.getFuncId());

      user.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUserServiceDelegate.unAuditFN(user, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.listCursor.setCurrentObject(afterSaveBill);

      refreshData();

      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());

    } else {

      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  private void stopTableEditing() {

  }

  public boolean isDataChanged() {

    stopTableEditing();
    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) { return false; }

    return !DigestUtil.digest(oldHuiyuanUser).equals(DigestUtil.digest(listCursor.getCurrentObject()));

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

    HuiyuanUser afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(unTreadButton.getFuncId());

      HuiyuanUser user = (HuiyuanUser) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      user.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      user.setComment(commentDialog.getComment());

      afterSaveBill = huiyuanUserServiceDelegate.untreadFN(user, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.listCursor.setCurrentObject(afterSaveBill);

      refreshData();

      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());

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

  protected void setButtonStatus() {
    HuiyuanUser user = (HuiyuanUser) listCursor.getCurrentObject();
    if (WFConstants.AUDIT_TAB_STATUS_CANCEL.equals(user.getAuditstatus())) {
      setCancelStatus(listCursor);
    } else {
      setButtonStatus(user, requestMeta, this.listCursor);
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

    HuiyuanUser qx = (HuiyuanUser) this.listCursor.getCurrentObject();
    String billStatus = qx.getAuditstatus();
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

    HuiyuanUser qx = (HuiyuanUser) this.listCursor.getCurrentObject();
    String billStatus = qx.getStatuscode();
    ZcUtil.setButtonEnable(this.accountBtnStatusList, billStatus, this.pageStatus, getCompoId(), qx.getProcessInstId());
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createFieldEditors()
   */
  @Override
  public List<AbstractFieldEditor> createFieldEditors() {
    // TCJLODO Auto-generated method stub

    TextFieldEditor userDogNum = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_DOGNUM), "dognum");
    TextFieldEditor userLoginID = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_LOGINID), "loginid");
    AsValFieldEditor userAuditStatus = new AsValFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_AUDITSTATUS), "auditstatus", ZcSettingConstants.V_HUI_YUAN_AUDIT_STATUS);
    AsValFieldEditor userStatusCode = new AsValFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_STATUSCODE), "statuscode", ZcSettingConstants.V_HUI_YUAN_ACCOUNT_STATUS);

    TextFieldEditor userDisplayName = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_DISPLAYNAME), "displayname");
    DateFieldEditor userBirthDay = new DateFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_BIRTHDAY), "birthday");
    AsValFieldEditor userSex = new AsValFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_SEX), "sex", ZcSettingConstants.V_HUI_YUAN_SEX);

    TextFieldEditor userIDCard = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_IDCARD), "idcard");
    TextFieldEditor userCompanyPhone = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_COMPANYPHONE), "companyphone");
    TextFieldEditor userMobilePhone = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_MOBILEPHONE), "mobilephone");
    TextFieldEditor userEMail = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_EMAIL), "email");
    TextAreaFieldEditor userComAddressAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_COMADDRESS), "comaddress", 200, 1, 7);
    TextFieldEditor userComZip = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_COMZIP), "comzip");
    TextAreaFieldEditor userRemarkAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_REMARK), "remark", 240, 2, 7);
    DateFieldEditor userYXQ = new DateFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_YXQ), "yxq");
    TextFieldEditor userDeviceNum = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_DEVICENUM), "devicenum");
    TextFieldEditor userJiaoYanNo = new TextFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_JIAOYANNO), "jiaoyanno");
    DateFieldEditor userCertYouXiaoQi = new DateFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_CERTYOUXIAOQI), "certyouxiaoqi");
    TextAreaFieldEditor userCertSubjectKeyIDAreaField = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUser.COL_CERTSUBJECTKEYID), "certsubjectkeyid", 2000, 5, 7);

    fieldEditors = new ArrayList<AbstractFieldEditor>();

    fieldEditors.add(userDisplayName);
    fieldEditors.add(userLoginID);
    fieldEditors.add(userAuditStatus);
    fieldEditors.add(userStatusCode);

    fieldEditors.add(userIDCard);
    fieldEditors.add(userBirthDay);
    fieldEditors.add(userSex);
    fieldEditors.add(userYXQ);

    fieldEditors.add(userCompanyPhone);
    fieldEditors.add(userMobilePhone);
    fieldEditors.add(userEMail);
    fieldEditors.add(userComZip);

    fieldEditors.add(userComAddressAreaField);

    fieldEditors.add(userDogNum);
    fieldEditors.add(userDeviceNum);
    fieldEditors.add(userJiaoYanNo);
    fieldEditors.add(userCertYouXiaoQi);

    fieldEditors.add(userCertSubjectKeyIDAreaField);
    fieldEditors.add(userRemarkAreaField);

    return fieldEditors;
  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createSubBillPanel()
   */
  @Override
  public JComponent createSubBillPanel() {
    // TCJLODO Auto-generated method stub
    return null;
  }

  protected void doQiyong() {
    HuiyuanUser inData = (HuiyuanUser) this.listCursor.getCurrentObject();
    if (!inData.getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
      JOptionPane.showMessageDialog(this, "只有审核通过的用户才可以启用！", "提示", JOptionPane.INFORMATION_MESSAGE);
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
    HuiyuanUser inData = (HuiyuanUser) this.listCursor.getCurrentObject();
    try {
      requestMeta.setFuncId(btn.getFuncId());
      HuiyuanUser qx = huiyuanUserServiceDelegate.upateAccountStatusFN(inData, this.requestMeta);
      listCursor.setCurrentObject(qx);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      success = false;
      errorInfo += e.getMessage();
    }
    if (success) {
      JOptionPane.showMessageDialog(this, opreation + "成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      refreshData();
      unitPanel.refreshSubData((HuiyuanUser) this.listCursor.getCurrentObject());
    } else {
      JOptionPane.showMessageDialog(this, opreation + "失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
    }
  }

  protected void doZanting() {
    // TCJLODO Auto-generated method stub 
    HuiyuanUser inData = (HuiyuanUser) this.listCursor.getCurrentObject();
    if (!inData.getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
      JOptionPane.showMessageDialog(this, "只有审核通过的用户才可以暂停！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    updateAccountStatus("暂停", fzantingBtn);
  }

  protected void doZhuxiao() {
    // TCJLODO Auto-generated method stub 
    HuiyuanUser inData = (HuiyuanUser) this.listCursor.getCurrentObject();
    if (!inData.getAuditstatus().equals(ZcSettingConstants.HUI_YUAN_AUDIT_STATUS_PASS)) {
      JOptionPane.showMessageDialog(this, "只有审核通过的用户才可以注销！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    updateAccountStatus("注销", fzhuxiaoBtn);
  }
}
