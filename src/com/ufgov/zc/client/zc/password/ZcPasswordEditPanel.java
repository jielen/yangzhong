package com.ufgov.zc.client.zc.password;

import java.awt.Color;
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
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.button.DeleteButton;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.button.zc.CommonButton;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.PasswordFieldEditor;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.zc.ButtonStatus;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.model.User;
import com.ufgov.zc.common.system.model.ZcUser;
import com.ufgov.zc.common.system.util.DigestUtil;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

public class ZcPasswordEditPanel extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(ZcPasswordEditPanel.class);

  protected String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  protected RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private static String compoId = "ZC_PASSWORD";

  protected FuncButton saveButton = new SaveButton();

  protected FuncButton deleteButton = new DeleteButton();

  private FuncButton exitButton = new ExitButton();

  protected FuncButton sendButton = new CommonButton("fsend", "发送", "send.jpg");

  protected ListCursor<User> listCursor;

  private User oldUser;

  private List<String> mobileLst = new ArrayList<String>();

  public ZcPasswordListPanel listPanel;

  protected ZcPasswordEditPanel self = this;

  protected GkBaseDialog parent;

  ZcUser curBill = new ZcUser();

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  protected IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  public ZcPasswordEditPanel(ZcPasswordDialog parent, ListCursor listCursor, String tabStatus, ZcPasswordListPanel listPanel) {
    // TCJLODO Auto-generated constructor stub
    super(ZcPasswordEditPanel.class, BillElementMeta.getBillElementMetaWithoutNd(compoId));

    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId), TitledBorder.CENTER, TitledBorder.TOP,

    new Font("宋体", Font.BOLD, 15), Color.BLUE));

    this.listCursor = listCursor;

    this.listPanel = listPanel;

    this.parent = parent;

    this.colCount = 1;

    init();

    requestMeta.setCompoId(getCompoId());

    refreshData();
  }

  private void refreshData() {
    // TCJLODO Auto-generated method stub

    User user = (User) listCursor.getCurrentObject();

    curBill.setUserId(user.getUserId());
    curBill.setUserName(user.getUserName());
    curBill.setPassword(user.getPassword());
    this.setEditingObject(curBill);
    this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

    setOldObject();

    setButtonStatus();

    updateFieldEditorsEditable();

  }

  protected void updateFieldEditorsEditable() {

    User user = (User) listCursor.getCurrentObject();
    for (AbstractFieldEditor editor : fieldEditors) {
      if ("passwordNew".equals(editor.getFieldName()) || "passwordConfirm".equals(editor.getFieldName())) {
        editor.setEnabled(true);
      } else {
        editor.setEnabled(false);
      }
    }

  }

  private void setDefaultValue(User user) {

  }

  protected void setButtonStatus() {

  }

  public void setButtonStatusWithoutWf() {

  }

  protected void setOldObject() {
    oldUser = (User) ObjectUtil.deepCopy(listCursor.getCurrentObject());
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

    toolBar.add(saveButton);
    toolBar.add(exitButton);

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

  }

  protected void doSave() {

    boolean success = true;

    User afterSaveBill = null;

    if (!checkBeforeSave()) { return; }

    try {

      requestMeta.setFuncId(this.sendButton.getFuncId());

      User user = (User) ObjectUtil.deepCopy(this.listCursor.getCurrentObject());
      String msg = "";
      if (curBill.getPasswordNew() == null || curBill.getPasswordNew().trim().length() == 0) {
        user.setPassword("");
        msg = "确定清空密码吗?";
      } else {
        user.setPassword(ZcUtil.recodePwd(curBill.getPasswordNew()));
        msg = "确定重设密码吗?";
      }
      int num = JOptionPane.showConfirmDialog(this, msg, "确认", 0);
      if (num == JOptionPane.NO_OPTION) { return; }
      List lst = new ArrayList();
      lst.add(user);
      zcEbBaseServiceDelegate.updateObjectList("User.updateUserPwd", lst, requestMeta);
    } catch (Exception ex) {

      logger.error(ex.getMessage(), ex);

      success = false;

      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());

    }

    if (success) {
      JOptionPane.showMessageDialog(this, "操作成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      this.listPanel.refreshCurrentTabData();
    }

  }

  /**
   * 保存前校验
   * @param cpApply
   * @return
   */

  protected boolean checkBeforeSave() {

    User user = (User) this.listCursor.getCurrentObject();

    StringBuilder errorInfo = new StringBuilder();

    if (curBill.getPasswordNew() == null) {
      if (curBill.getPasswordConfirm() != null) {
        errorInfo.append("新密码和确认密码不一致");
      }
    } else {
      if (!curBill.getPasswordNew().equals(curBill.getPasswordConfirm())) {
        errorInfo.append("新密码和确认密码不一致");
      }
    }

    if (errorInfo.length() != 0) {

      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);

      return false;

    }

    return true;
  }

  public boolean isDataChanged() {

    if (!this.saveButton.isVisible() || !saveButton.isEnabled()) { return false; }

    return !DigestUtil.digest(oldUser).equals(DigestUtil.digest(listCursor.getCurrentObject()));

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
    TextFieldEditor inputor = new TextFieldEditor("用户", "userName");
    PasswordFieldEditor passwordFd = new PasswordFieldEditor("原密码", "password");
    PasswordFieldEditor passwordNewFd = new PasswordFieldEditor("新密码", "passwordNew");
    PasswordFieldEditor passwordConfirmFd = new PasswordFieldEditor("确认密码", "passwordConfirm");
    editorList.add(inputor);
    editorList.add(passwordFd);
    editorList.add(passwordNewFd);
    editorList.add(passwordConfirmFd);

    return editorList;

  }

  /* (non-Javadoc)
   * @see com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel#createSubBillPanel()
   */
  @Override
  public JComponent createSubBillPanel() {
    return null;
  }

  public void doExit() {
    // TCJLODO Auto-generated method stub

    this.parent.dispose();

  }
}
