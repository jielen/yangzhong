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
import com.ufgov.zc.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.model.HuiyuanUnitblack;
import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;
import com.ufgov.zc.common.zc.model.ZcBaseBill;
import com.ufgov.zc.common.zc.publish.IHuiyuanUnitblackDelegate;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

public class HuiyuanUnitblackEditPanel extends AbstractMainSubEditPanel {

  /**
   * 
   */
  private static final long serialVersionUID = -6247354150917309961L;


  private static final Logger logger = Logger.getLogger(HuiyuanUnitblackEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "HUIYUAN_UNITBLACK";

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

  protected ListCursor<HuiyuanUnitblack> listCursor;

  private HuiyuanUnitblack oldObj; 
 
  protected HuiyuanUnitblackEditPanel self = this;

  protected GkBaseDialog parent; 

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta mainBillElementMeta = BillElementMeta.getBillElementMetaWithoutNd("HUIYUAN_UNITBLACK");  
 

  private IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,"zcEbBaseServiceDelegate");

  private IHuiyuanUnitblackDelegate huiyuanUnitblackDelegate = (IHuiyuanUnitblackDelegate) ServiceFactory.create(IHuiyuanUnitblackDelegate.class,"huiyuanUnitblackDelegate"); 

  private HuiyuanUnitcominfoEditPanel unitPanel;
  
  private HuiyuanUnitcominfo unit=new HuiyuanUnitcominfo();

 

  public HuiyuanUnitblackEditPanel(HuiyuanUnitblackDialog parent, HuiyuanUnitcominfoEditPanel unitPanel, ListCursor listCursor2) {
    // TCJLODO Auto-generated constructor stub
    super(HuiyuanUnitblackEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));
    
    this.unitPanel=unitPanel;
    this.listCursor=listCursor2;
    this.parent=parent;

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId),
      TitledBorder.CENTER, TitledBorder.TOP,new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.colCount = 3;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
  }
  private void refreshData() {


    HuiyuanUnitblack curObj = (HuiyuanUnitblack) listCursor.getCurrentObject();

    if (curObj != null && !"".equals(ZcUtil.safeString(curObj.getBlguid()))) {//列表页面双击进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

      curObj = huiyuanUnitblackDelegate.selectByPrimaryKey(curObj.getBlguid(), this.requestMeta);
 
      listCursor.setCurrentObject(curObj);
      this.setEditingObject(curObj);
    } else {//新增按钮进入

      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
 

      setDefaultValue(curObj);

      listCursor.getDataList().add(curObj);

      listCursor.setCurrentObject(curObj);

      this.setEditingObject(curObj);

    } 
    refreshSubData(curObj);

    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();
  }

  protected void updateFieldEditorsEditable() {

    HuiyuanUnitblack curObj = (HuiyuanUnitblack) listCursor.getCurrentObject();

     
      for (AbstractFieldEditor editor : fieldEditors) {
        if (pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
          if ("danweiname".equals(editor.getFieldName())) {
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
  private void setOldObject() {
    // TCJLODO Auto-generated method stub
    oldObj = (HuiyuanUnitblack) ObjectUtil.deepCopy(listCursor.getCurrentObject());
  }
  private void refreshSubData(HuiyuanUnitblack curObj) {
    // TCJLODO Auto-generated method stub
    
  }
  private void setDefaultValue(HuiyuanUnitblack curObj) {
    // TCJLODO Auto-generated method stub 
    //以下属性不知道省库如何设置，暂时设定为1
    curObj.setBlacktype("1");
    curObj.setBlackfenlei("1");
    curObj.setChufatype("1");
    
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
    
//    toolBar.add(fpassBtn);
//    toolBar.add(funpassBtn);
//    toolBar.add(frebackBtn);
//    toolBar.add(fdestroyBtn);
    toolBar.add(deleteButton);

    toolBar.add(exitButton);

   /* fpassBtn.addActionListener(new ActionListener() {

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

    }); */
 
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

    HuiyuanUnitblack afterSaveBill = null;

    HuiyuanUnitblack curObj = (HuiyuanUnitblack) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    if (this.isDataChanged()) {

      JOptionPane.showMessageDialog(this, "数据发生改变，请先保存.", "提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    try {

      requestMeta.setFuncId(this.sendButton.getFuncId());

      curObj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUnitblackDelegate.newCommitFN(curObj, requestMeta);

    } catch (Exception ex) {

      logger.error(ex.getMessage(), ex);

      success = false;

      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());

    }

    if (success) {
      this.listCursor.setCurrentObject(afterSaveBill);
      refreshData();

      JOptionPane.showMessageDialog(this, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUnitblack) this.listCursor.getCurrentObject());

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

        listCursor.setCurrentObject(oldObj);

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

        listCursor.setCurrentObject(oldObj);

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


    HuiyuanUnitblack inData = (HuiyuanUnitblack) this.listCursor.getCurrentObject();
    
    try {

      requestMeta.setFuncId(saveButton.getFuncId());

      HuiyuanUnitblack curObj = huiyuanUnitblackDelegate.saveFN(inData, this.requestMeta); 
      
      listCursor.setCurrentObject(curObj);

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      success = false;

      errorInfo += e.getMessage();

    }

    if (success) {

      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      refreshData();
      unitPanel.refreshSubData((HuiyuanUnitblack) this.listCursor.getCurrentObject());

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
    
    HuiyuanUnitblack curObj = (HuiyuanUnitblack) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    String mainValidateInfo = ZcUtil.validateBillElementNull(curObj, mainNotNullList);
 

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

    HuiyuanUnitblack curObj = (HuiyuanUnitblack) this.listCursor.getCurrentObject();

    if (curObj.getBlguid() == null || "".equalsIgnoreCase(curObj.getBlguid())) {

      JOptionPane.showMessageDialog(this, "尚未保存到数据库，无需删除！", "提示", JOptionPane.ERROR_MESSAGE);

      return;

    }

    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);

    if (num == JOptionPane.YES_OPTION) {

      boolean success = true;

      String errorInfo = "";

      try {

        requestMeta.setFuncId(deleteButton.getFuncId());

        huiyuanUnitblackDelegate.deleteByPrimaryKeyFN(curObj.getBlguid(), this.requestMeta);

      } catch (Exception e) {

        logger.error(e.getMessage(), e);

        success = false;

        errorInfo += e.getMessage();

      }

      if (success) {
        this.listCursor.removeCurrentObject(); 
        unitPanel.refreshSubData(new HuiyuanUnitblack());
        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
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

    HuiyuanUnitblack afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(this.callbackButton.getFuncId());

      HuiyuanUnitblack curObj = (HuiyuanUnitblack) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      curObj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUnitblackDelegate.callbackFN(curObj, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      refreshData();

      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUnitblack) this.listCursor.getCurrentObject());


    } else {

      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  protected void doSuggestPass() {

    if (!checkBeforeSave()) {

      return;

    }

    HuiyuanUnitblack curObj = (HuiyuanUnitblack) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

    requestMeta.setFuncId(this.suggestPassButton.getFuncId());

    executeAudit(curObj, ZcSettingConstants.IS_GOON_AUDIT_YES, null);

  }

  protected void executeAudit(HuiyuanUnitblack ht, int isGoonAudit, String defaultMsg) {

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

      //      huiyuanUnitblackDelegate.updateFN(ht, requestMeta);

      ht = huiyuanUnitblackDelegate.auditFN(ht, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.refreshData();

      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUnitblack) this.listCursor.getCurrentObject());

    } else {

      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }
 
 

  /*

   * 销审

   */

  protected void doUnAudit() { 
    HuiyuanUnitblack curObj = (HuiyuanUnitblack) ObjectUtil.deepCopy(this.listCursor.getCurrentObject()); 

    boolean success = true;

    HuiyuanUnitblack afterSaveBill = null;

    String errorInfo = "";

    int i = JOptionPane.showConfirmDialog(this, "是否确定消审？", "确认", JOptionPane.INFORMATION_MESSAGE);

    if (i != 0) {

      return;

    }

    try {

      requestMeta.setFuncId(unAuditButton.getFuncId());

      curObj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      afterSaveBill = huiyuanUnitblackDelegate.unAuditFN(curObj, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.listCursor.setCurrentObject(afterSaveBill);

      refreshData();

      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUnitblack) this.listCursor.getCurrentObject());


    } else {

      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  private void stopTableEditing() {

    

  }

  public boolean isDataChanged() {

    stopTableEditing();
    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) {
      return false;
    }

    return !DigestUtil.digest(oldObj).equals(DigestUtil.digest(listCursor.getCurrentObject()));

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

    HuiyuanUnitblack afterSaveBill = null;

    String errorInfo = "";

    try {

      requestMeta.setFuncId(unTreadButton.getFuncId());

      HuiyuanUnitblack curObj = (HuiyuanUnitblack) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());

      curObj.setAuditorId(WorkEnv.getInstance().getCurrUserId());

      curObj.setComment(commentDialog.getComment());

      afterSaveBill = huiyuanUnitblackDelegate.untreadFN(curObj, requestMeta);

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      errorInfo += e.getMessage();

    }

    if (success) {

      this.listCursor.setCurrentObject(afterSaveBill);

      refreshData();

      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);

      unitPanel.refreshSubData((HuiyuanUnitblack) this.listCursor.getCurrentObject());


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
    HuiyuanUnitblack curObj = (HuiyuanUnitblack) listCursor.getCurrentObject();
    setButtonStatus(curObj, requestMeta, this.listCursor);
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

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();

      bs.setButton(this.saveButton);
      
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);      
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);      
      bs.addPageStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.deleteButton);      
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);   
      bs.addPageStatus(ZcSettingConstants.BILL_STATUS_ALL);
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
      //----


      bs = new ButtonStatus();

      bs.setButton(this.fpassBtn);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs); 

      bs = new ButtonStatus();

      bs.setButton(this.funpassBtn);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs); 

      bs = new ButtonStatus();

      bs.setButton(this.fdestroyBtn);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs); 

      bs = new ButtonStatus();

      bs.setButton(this.frebackBtn);

      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);

      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);

      btnStatusList.add(bs);  

    }

    HuiyuanUnitblack curObj = (HuiyuanUnitblack) this.listCursor.getCurrentObject();

    String billStatus = "";

    ZcUtil.setButtonEnable(this.btnStatusList, billStatus, this.pageStatus, getCompoId(), curObj.getProcessInstId());

  }
  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createFieldEditors()
   */
  @Override
  public List<AbstractFieldEditor> createFieldEditors() {
    // TCJLODO Auto-generated method stub
    
    TextFieldEditor unitBlDanWeiName = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_DANWEINAME), "danweiname");
    TextAreaFieldEditor unitBlReMarkAreaFd = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_REMARK), "remark", 500, 2, 7); 
    DateFieldEditor unitBlFromDate = new DateFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_FROMDATE), "fromdate");
    DateFieldEditor unitBlEndDate = new DateFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_ENDDATE), "enddate"); 
    TextFieldEditor unitBlChuFaDuiXiang = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_CHUFADUIXIANG), "chufaduixiang");
    TextAreaFieldEditor unitBlChuFaReasonAreaFd = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_CHUFAREASON), "chufareason", 240, 2, 7);
    TextAreaFieldEditor unitBlZhiXingQingKuangAreaFd = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_ZHIXINGQINGKUANG), "zhixingqingkuang", 500, 4, 7);  
    MoneyFieldEditor unitBlQianJiaoAllMoney = new MoneyFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_QIANJIAOALLMONEY), "qianjiaoallmoney");  
    MoneyFieldEditor unitBlQianJiaoMoney = new MoneyFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_QIANJIAOMONEY), "qianjiaomoney");
    TextAreaFieldEditor unitBlChaXunJieGuoAreaFd = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_CHAXUNJIEGUO), "chaxunjieguo", 50, 1, 7);
    TextAreaFieldEditor unitBlWFPJChuFaDuiXiangAreaFd = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_WFPJCHUFADUIXIANG), "wfpjchufaduixiang", 50, 1, 7);
    TextAreaFieldEditor unitBlInReasonAreaFd = new TextAreaFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_INREASON), "inreason", 500, 5, 7);
    TextFieldEditor unitBlPunishDepartment = new TextFieldEditor(LangTransMeta.translate(HuiyuanUnitblack.COL_PUNISHDEPARTMENT), "punishdepartment"); 
    
    fieldEditors=new ArrayList<AbstractFieldEditor>();
    
    fieldEditors.add(unitBlDanWeiName); 
    fieldEditors.add(unitBlFromDate);
    fieldEditors.add(unitBlEndDate);
    fieldEditors.add(unitBlChuFaDuiXiang);
    fieldEditors.add(unitBlQianJiaoAllMoney);
    fieldEditors.add(unitBlQianJiaoMoney);
    fieldEditors.add(unitBlPunishDepartment);
    fieldEditors.add(unitBlChaXunJieGuoAreaFd);
    fieldEditors.add(unitBlChuFaReasonAreaFd);
    fieldEditors.add(unitBlZhiXingQingKuangAreaFd);
    fieldEditors.add(unitBlWFPJChuFaDuiXiangAreaFd);
    fieldEditors.add(unitBlInReasonAreaFd);
    fieldEditors.add(unitBlReMarkAreaFd); 
    
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

}
