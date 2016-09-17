package com.ufgov.zc.client.zc.expertselection;import java.awt.BorderLayout;import java.awt.Color;import java.awt.Container;import java.awt.DefaultKeyboardFocusManager;import java.awt.Dialog.ModalityType;import java.awt.Dimension;import java.awt.Font;import java.awt.GridBagConstraints;import java.awt.GridBagLayout;import java.awt.Insets;import java.awt.Window;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.swing.BorderFactory;import javax.swing.JButton;import javax.swing.JDialog;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JPasswordField;import javax.swing.SwingUtilities;import javax.swing.UIManager;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.DefaultInvokeHandler;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.smartclient.component.table.JGroupableTable;import com.ufgov.smartclient.plaf.BlueLookAndFeel;import com.ufgov.zc.client.common.AsOptionMeta;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.ParentWindowAware;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.ZcEmExpertSelectionToTableModelConverter;import com.ufgov.zc.client.component.GkBaseDialog;import com.ufgov.zc.client.component.GkCommentDialog;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.button.AddButton;import com.ufgov.zc.client.component.button.CallbackButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.button.PrintButton;import com.ufgov.zc.client.component.button.PrintPreviewButton;import com.ufgov.zc.client.component.button.PrintSettingButton;import com.ufgov.zc.client.component.button.SendButton;import com.ufgov.zc.client.component.button.SuggestAuditPassButton;import com.ufgov.zc.client.component.button.TraceButton;import com.ufgov.zc.client.component.button.UnauditButton;import com.ufgov.zc.client.component.button.UntreadButton;import com.ufgov.zc.client.component.button.zc.CommonButton;import com.ufgov.zc.client.component.ui.AbstractDataDisplay;import com.ufgov.zc.client.component.ui.AbstractEditListBill;import com.ufgov.zc.client.component.ui.AbstractSearchConditionArea;import com.ufgov.zc.client.component.ui.MultiDataDisplay;import com.ufgov.zc.client.component.ui.SaveableSearchConditionArea;import com.ufgov.zc.client.component.ui.TableDisplay;import com.ufgov.zc.client.component.ui.conditionitem.AbstractSearchConditionItem;import com.ufgov.zc.client.component.ui.conditionitem.SearchConditionUtil;import com.ufgov.zc.client.print.PrintPreviewer;import com.ufgov.zc.client.print.PrintSettingDialog;import com.ufgov.zc.client.print.Printer;import com.ufgov.zc.client.util.BalanceUtil;import com.ufgov.zc.client.util.ListUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.zcppromake.ZcPProMakeListPanel;import com.ufgov.zc.common.commonbiz.model.SearchCondition;import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.WFConstants;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.EmExpertSelectionBill;import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;import com.ufgov.zc.common.zc.publish.IZcEmExpertSelectionServiceDelegate;public class ZcEmExpertSelectionListPanel extends AbstractEditListBill implements ParentWindowAware {  private static final long serialVersionUID = -9080177197515854628L;  static {    LangTransMeta.init("ZC%");  }  private static final Logger logger = Logger.getLogger(ZcPProMakeListPanel.class);  private ZcEmExpertSelectionListPanel self = this;  private Window parentWindow;  public String compoId = "ZC_EM_EXPERT_SELECTION";  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private ElementConditionDto elementConditionDto = new ElementConditionDto();  private AbstractSearchConditionArea topSearchConditionArea;  private IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");  private IZcEbBaseServiceDelegate zcbaseDataServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");  private HelpButton helpButton = new HelpButton();  private AddButton fnewBtn = new AddButton();  //工作流送审  private SendButton sendButton = new SendButton();  // 工作流填写意见审核通过  private FuncButton suggestPassButton = new SuggestAuditPassButton();  // 工作流收回  private FuncButton callbackButton = new CallbackButton();  // 工作流退回  private FuncButton unTreadButton = new UntreadButton();  // 工作流销审  private FuncButton unAuditButton = new UnauditButton();  private PrintButton printButton = new PrintButton();  private FuncButton printPreviewButton = new PrintPreviewButton();  private PrintSettingButton printSettingButton = new PrintSettingButton();  private FuncButton traceButton = new TraceButton();  private FuncButton setPassWdBtn = new CommonButton("fsetPwd", "设置密码", null);  GkBaseDialog pwdDialog;  JPasswordField oldPwdFd;  JPasswordField newPwdFd;  JPasswordField confirmPwdFd;  private String listTabId = ZcSettingConstants.TAB_ID_ZC_EM_EXPERT_SELECTION;  private String listConditionId = ZcSettingConstants.CONDITION_ID_ZC_EM_EXPERT_SELECTION;  private IZcEmExpertSelectionServiceDelegate zcEmExpertSelectionServiceDelegate = (IZcEmExpertSelectionServiceDelegate) ServiceFactory.create(IZcEmExpertSelectionServiceDelegate.class,  "zcEmExpertSelectionServiceDelegate");  public ZcEmExpertSelectionListPanel() {    UIUtilities.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {      @Override      public List<SearchCondition> execute() throws Exception {        List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance().getCurrUserId(), listTabId);        return needDisplaySearchConditonList;      }      @Override      public void success(List<SearchCondition> needDisplaySearchConditonList) {        List<TableDisplay> showingDisplays = SearchConditionUtil.getNeedDisplayTableDisplay(needDisplaySearchConditonList);        init(createDataDisplay(showingDisplays), null);//调用父类方法        revalidate();        repaint();      }    });    requestMeta.setCompoId(compoId);  }  protected AbstractDataDisplay createDataDisplay(List<TableDisplay> showingDisplays) {    return new DataDisplay(SearchConditionUtil.getAllTableDisplay(listTabId), showingDisplays, createTopConditionArea(), false);//true:显示收索条件区 false：不显示收索条件区  }  @SuppressWarnings("unchecked")  protected AbstractSearchConditionArea createTopConditionArea() {    Map defaultValueMap = new HashMap();    topSearchConditionArea = new SaveableSearchConditionArea(listConditionId, null, true, defaultValueMap, null);    return topSearchConditionArea;  }  @Override  protected void addToolBarComponent(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    toolBar.add(fnewBtn);    if (isNeedPwd()) {      toolBar.add(setPassWdBtn);    }    //    toolBar.add(sendButton);//送审    //    //    toolBar.add(suggestPassButton);//填写意见审核通过    //    //    toolBar.add(callbackButton);//收回    //    //    toolBar.add(unTreadButton);//退回    //    //    toolBar.add(unAuditButton);//销审    //    //    toolBar.add(traceButton);//跟踪    //    toolBar.add(printButton);    //    toolBar.add(printPreviewButton);    //    toolBar.add(printSettingButton);    //    toolBar.add(helpButton);    setPassWdBtn.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doSetPwd();      }    });    fnewBtn.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doAdd();      }    });    sendButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doSend();      }    });    suggestPassButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doSuggestPass();      }    });    callbackButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doCallBack();      }    });    unTreadButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doUnTread();      }    });    unAuditButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doUnAudit();      }    });    traceButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doTrace();      }    });    printButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrint();      }    });    printPreviewButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintPreview();      }    });    printSettingButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintSetting();      }    });  }  protected void doSetPwd() {    JPanel p = new JPanel();    p.setLayout(new GridBagLayout());    JLabel oldPwdlb = new JLabel("原密码:");    oldPwdFd = new JPasswordField();    JLabel newPwdlb = new JLabel(" 新密码:");    newPwdFd = new JPasswordField();    JLabel confirmPwdlb = new JLabel("确认密码:");    confirmPwdFd = new JPasswordField();    int row = 0;    int col = 0;    p.add(oldPwdlb, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0, 0));    col++;    oldPwdFd.setPreferredSize(new Dimension(150, 20));    p.add(oldPwdFd, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0, 0));    row++;    col = 0;    p.add(newPwdlb, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0, 0));    col++;    newPwdFd.setPreferredSize(new Dimension(150, 20));    p.add(newPwdFd, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0, 0));    row++;    col = 0;    p.add(confirmPwdlb, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0, 0));    col++;    confirmPwdFd.setPreferredSize(new Dimension(150, 20));    p.add(confirmPwdFd, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4, 0, 4, 4), 0, 0));    JButton okbtn = new JButton("确定");    okbtn.setPreferredSize(new Dimension(60, 24));    JButton cancelBtn = new JButton("取消");    cancelBtn.setPreferredSize(new Dimension(60, 24));    JPanel br = new JPanel();    br.add(okbtn);    br.add(cancelBtn);    okbtn.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doUpdatePwd();      }    });    cancelBtn.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doCancelPwd();      }    });    JPanel contentPanel = new JPanel();    contentPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "设置专家抽取密码", TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));    pwdDialog = new GkBaseDialog(this.getParentWindow());    contentPanel.setLayout(new BorderLayout());    contentPanel.add(p, BorderLayout.CENTER);    contentPanel.add(br, BorderLayout.SOUTH);    JPanel pp = new JPanel();    pp.setLayout(new BorderLayout());    pp.add(contentPanel, BorderLayout.CENTER);    JLabel lb = new JLabel("第一次设置时，原密码为空.");    pp.add(lb, BorderLayout.SOUTH);    pwdDialog.setTitle("设置专家抽取密码");    pwdDialog.getContentPane().add(pp);    pwdDialog.setMinimumSize(new Dimension(300, 230));    pwdDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);    pwdDialog.setVisible(true);    pwdDialog.moveToScreenCenter();  }  protected void doCancelPwd() {    pwdDialog.dispose();  }  protected void doUpdatePwd() {    String oldPwd = AsOptionMeta.getOptVal(EmExpertSelectionBill.OPT_ZC_EXPERT_SELECT_PASSWD);    if (oldPwd == null) {      oldPwd = EmExpertSelectionBill.OPT_ZC_EXPERT_SELECT_DEFAULT_PASSWD;    } else {      oldPwd = ZcUtil.recodePwd(oldPwd);    }    char[] oldPwd2 = oldPwdFd.getPassword();    oldPwd2 = oldPwd2 == null ? new char[] {} : oldPwd2;    char[] newPwd = newPwdFd.getPassword();    newPwd = newPwd == null ? new char[] {} : newPwd;    char[] confirmPwd = confirmPwdFd.getPassword();    confirmPwd = confirmPwd == null ? new char[] {} : confirmPwd;    String oldPwdStr = new String(oldPwd2);    String newPwdStr = new String(newPwd);    String confirmPwdStr = new String(confirmPwd);    if (!oldPwd.equals(oldPwdStr.trim())) {      JOptionPane.showMessageDialog(pwdDialog, "原密码错误.", "提示", JOptionPane.ERROR_MESSAGE);      return;    }    if (!newPwdStr.trim().equals(confirmPwdStr.trim())) {      JOptionPane.showMessageDialog(pwdDialog, "新密码和确认密码不一致.", "提示", JOptionPane.ERROR_MESSAGE);      return;    }    //    System.out.println(newPwdStr);    newPwdStr = ZcUtil.encodePwd(newPwdStr);    //    System.out.println(newPwdStr);    //    newPwdStr = ZcUtil.recodePwd(newPwdStr);    //    System.out.println(newPwdStr);    AsOptionMeta.updateOptVal(EmExpertSelectionBill.OPT_ZC_EXPERT_SELECT_PASSWD, newPwdStr);    JOptionPane.showMessageDialog(pwdDialog, "密码设置成功.", "提示", JOptionPane.INFORMATION_MESSAGE);    pwdDialog.dispose();  }  /**   * 扬中交易中心的专家抽取，在点击抽取时，弹出一个密码对话框，要求输入密码，系统用这个选项来设定是否会弹出这个密码，Y 会；N 不会   * @return   */  public boolean isNeedPwd() {    String need = AsOptionMeta.getOptVal(EmExpertSelectionBill.OPT_ZC_EXPERT_SELECT_NEED_PASSWD);    if (need != null && need.equalsIgnoreCase("Y")) { return true; }    return false;  }  public List getCheckedList() {    List<EmExpertSelectionBill> beanList = new ArrayList<EmExpertSelectionBill>();    JGroupableTable table = topDataDisplay.getActiveTableDisplay().getTable();    MyTableModel model = (MyTableModel) table.getModel();    //Modal的数据    List list = model.getList();    Integer[] checkedRows = table.getCheckedRows();    for (Integer checkedRow : checkedRows) {      int accordDataRow = table.convertRowIndexToModel(checkedRow);      EmExpertSelectionBill bean = (EmExpertSelectionBill) list.get(accordDataRow);      beanList.add(bean);    }    return beanList;  }  @SuppressWarnings("unchecked")  protected void doAdd() {    //    JOptionPane    //    //      .showMessageDialog(    //    //        this,    //    //        "<html><br /><br /><br /><br /><br /><br /><br /><br /><br /><b><font size='20'><b>西安市电子化政府采购系统评审专家抽取平台&nbsp;&nbsp;<br /></font><br /><br /><br />&nbsp;&nbsp;&nbsp;&nbsp;<font size='20' color='red'>请按工作程序执行，遵守抽取纪律，<br />相关人员履行各自职责！</font></b><br /><br /><br /><br /><br /><br /><br /></html>",    //    //        "提示", JOptionPane.INFORMATION_MESSAGE);    //JOptionPane.showMessageDialog(this, "<html><b>西安市电子化政府采购系统评审专家抽取平台<br />&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请按工作程序执行，遵守抽取纪律，相关人员履行各自职责！</font></b></html>", "提示", JOptionPane.INFORMATION_MESSAGE);    openEditDialog(new ArrayList(1), -1, topDataDisplay.getActiveTableDisplay().getStatus());  }  private void doSend() {    boolean success = true;    String errorInfo = "";    requestMeta.setFuncId(this.sendButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        EmExpertSelectionBill make = (EmExpertSelectionBill) beanList.get(i);        make.setAuditorId(WorkEnv.getInstance().getCurrUserId());        this.getZcEmExpertSelectionServiceDelegate().newCommitFN(make, true, requestMeta);      }    } catch (Exception ex) {      errorInfo += ex.getMessage();      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "送审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    }  }  private void doSuggestPass() {    boolean success = true;    String errorInfo = "";    requestMeta.setFuncId(this.suggestPassButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL);    if (commentDialog.cancel) {    return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        EmExpertSelectionBill make = (EmExpertSelectionBill) beanList.get(i);        make.setAuditorId(WorkEnv.getInstance().getCurrUserId());        make.setComment(commentDialog.getComment());        this.getZcEmExpertSelectionServiceDelegate().auditFN(make, requestMeta);      }    } catch (Exception ex) {      errorInfo += ex.getMessage();      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    }  }  private void doCallBack() {    boolean success = true;    String errorInfo = "";    requestMeta.setFuncId(this.callbackButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        EmExpertSelectionBill bill = (EmExpertSelectionBill) beanList.get(i);        bill.setAuditorId(WorkEnv.getInstance().getCurrUserId());        this.getZcEmExpertSelectionServiceDelegate().callbackFN(bill, requestMeta);      }    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      JOptionPane.showMessageDialog(this, "收回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "收回失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doUnTread() {    boolean success = true;    String errorInfo = "";    requestMeta.setFuncId(this.unTreadButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(), ModalityType.APPLICATION_MODAL, "不同意");    if (commentDialog.cancel) {    return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        EmExpertSelectionBill bill = (EmExpertSelectionBill) beanList.get(i);        bill.setAuditorId(WorkEnv.getInstance().getCurrUserId());        bill.setComment(commentDialog.getComment());        this.getZcEmExpertSelectionServiceDelegate().untreadFN(bill, requestMeta);      }    } catch (Exception ex) {      errorInfo += ex.getMessage();      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    }  }  private void doUnAudit() {    boolean success = true;    String errorInfo = "";    requestMeta.setFuncId(this.unAuditButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        EmExpertSelectionBill bill = (EmExpertSelectionBill) beanList.get(i);        bill.setAuditorId(WorkEnv.getInstance().getCurrUserId());        this.getZcEmExpertSelectionServiceDelegate().unAuditFN(bill, requestMeta);      }    } catch (Exception ex) {      errorInfo += ex.getMessage();      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    }  }  private void doTrace() {    List beanList = getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    if (beanList.size() > 1) {      JOptionPane.showMessageDialog(this, "只能选择一条数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    for (int i = 0; i < beanList.size(); i++) {      EmExpertSelectionBill bill = (EmExpertSelectionBill) beanList.get(i);      ZcUtil.showTraceDialog(bill, compoId);    }  }  private void doPrint() {    List printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    boolean success = true;    boolean printed = false;    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      if (Printer.print(printObject)) {        printed = true;      }    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }    if (success && printed) {    }  }  private void doPrintPreview() {    final List printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印预览的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printPreviewButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      PrintPreviewer previewer = new PrintPreviewer(printObject) {        protected void afterSuccessPrint() {        }      };      previewer.preview();    } catch (Exception e) {      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印预览出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doPrintSetting() {    requestMeta.setFuncId(this.printSettingButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    new PrintSettingDialog(requestMeta);  }  @SuppressWarnings("unchecked")  protected TableModel doExecute() {    ZcEmExpertSelectionToTableModelConverter mc = new ZcEmExpertSelectionToTableModelConverter();    return mc.convertToTableModel(zcEmExpertSelectionServiceDelegate.getList(elementConditionDto, requestMeta));  }  protected void doSuccess(TableModel model) {    topDataDisplay.getActiveTableDisplay().setTableModel(model);    setButtonStatus();  }  protected void doLeftClick(MouseEvent e) {  }  @SuppressWarnings("unchecked")  protected void doLeftDbClick(MouseEvent e) {    JGroupableTable table = topDataDisplay.getActiveTableDisplay().getTable();    MyTableModel model = (MyTableModel) table.getModel();    int row = table.getSelectedRow();    List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));    openEditDialog(viewList, row, topDataDisplay.getActiveTableDisplay().getStatus());  }  @SuppressWarnings("unchecked")  protected void openEditDialog(List viewList, int row, String status) {    new ZcEmExpertSelectionDialog(self, viewList, row, status);  }  protected void setButtonStatus() {    String panelId = WFConstants.AUDIT_TAB_STATUS_TODO;    if (topDataDisplay != null && topDataDisplay.getActiveTableDisplay() != null) {      panelId = topDataDisplay.getActiveTableDisplay().getStatus();    }    if (WFConstants.EDIT_TAB_STATUS_DRAFT.equalsIgnoreCase(panelId)) {      traceButton.setVisible(false);      suggestPassButton.setVisible(false);      unTreadButton.setVisible(false);      sendButton.setVisible(true);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(false);      unAuditButton.setVisible(false);    } else if (WFConstants.AUDIT_TAB_STATUS_TODO.equalsIgnoreCase(panelId)) {      traceButton.setVisible(true);      sendButton.setVisible(false);      suggestPassButton.setVisible(true);      unTreadButton.setVisible(true);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(false);      unAuditButton.setVisible(false);    } else if (WFConstants.AUDIT_TAB_STATUS_DONE.equalsIgnoreCase(panelId)) {      traceButton.setVisible(true);      sendButton.setVisible(false);      suggestPassButton.setVisible(false);      unTreadButton.setVisible(false);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(true);      unAuditButton.setVisible(true);    } else if ("exec".equalsIgnoreCase(panelId)) {      traceButton.setVisible(true);      sendButton.setVisible(false);      suggestPassButton.setVisible(false);      unTreadButton.setVisible(false);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(false);      unAuditButton.setVisible(true);    } else if (WFConstants.AUDIT_TAB_STATUS_ALL.equalsIgnoreCase(panelId)) {      traceButton.setVisible(true);      sendButton.setVisible(false);      suggestPassButton.setVisible(false);      unTreadButton.setVisible(false);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(false);      unAuditButton.setVisible(false);    } else if (WFConstants.AUDIT_TAB_STATUS_SELECTFINISH.equalsIgnoreCase(panelId)) {      traceButton.setVisible(true);      sendButton.setVisible(false);      suggestPassButton.setVisible(false);      unTreadButton.setVisible(false);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(false);      unAuditButton.setVisible(true);    } else if (WFConstants.AUDIT_TAB_STATUS_SELECTWAITING.equalsIgnoreCase(panelId)) {      traceButton.setVisible(true);      sendButton.setVisible(false);      suggestPassButton.setVisible(false);      unTreadButton.setVisible(false);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(false);      unAuditButton.setVisible(false);    } else if (WFConstants.AUDIT_TAB_STATUS_SELECTPAUSE.equalsIgnoreCase(panelId)) {      traceButton.setVisible(true);      sendButton.setVisible(false);      suggestPassButton.setVisible(false);      unTreadButton.setVisible(false);      fnewBtn.setVisible(true);      printButton.setVisible(true);      printPreviewButton.setVisible(true);      printSettingButton.setVisible(true);      callbackButton.setVisible(false);      unAuditButton.setVisible(false);    }  }  public void refreshCurrentTabData() {    topSearchConditionArea.doSearch();  }  public static void main(String[] args) throws Exception {    SwingUtilities.invokeLater(new Runnable() {      public void run() {        try {          //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());          UIManager.setLookAndFeel(new BlueLookAndFeel());        } catch (Exception e) {          e.printStackTrace();        }        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());        ZcEmExpertSelectionListPanel bill = new ZcEmExpertSelectionListPanel();        JFrame frame = new JFrame("frame");        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        frame.setSize(800, 600);        frame.setLocationRelativeTo(null);        frame.getContentPane().add(bill);        frame.setVisible(true);      }    });  }  @SuppressWarnings("unchecked")  public void refreshCurrentTabData(List dataList) {    ZcEmExpertSelectionToTableModelConverter mc = new ZcEmExpertSelectionToTableModelConverter();    topDataDisplay.getActiveTableDisplay().getTable().setModel(mc.convertToTableModel(dataList));  }  private BillElementMeta billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);  public BillElementMeta getBillElementMeta() {    return billElementMeta;  }  protected String getTitle() {    return LangTransMeta.translate(compoId);  }  public Window getParentWindow() {    return parentWindow;  }  public void setParentWindow(Window parentWindow) {    this.parentWindow = parentWindow;  }  public IZcEmExpertSelectionServiceDelegate getZcEmExpertSelectionServiceDelegate() {    return zcEmExpertSelectionServiceDelegate;  }  public IZcEbBaseServiceDelegate getZcEbBaseServiceDelegate() {    return zcbaseDataServiceDelegate;  }  public void setZcEmExpertSelectionServiceDelegate(IZcEmExpertSelectionServiceDelegate zcEmExpertSelectionServiceDelegate) {    this.zcEmExpertSelectionServiceDelegate = zcEmExpertSelectionServiceDelegate;  }  protected final class DataDisplay extends MultiDataDisplay {    private static final long serialVersionUID = 8838123294320983836L;    private DataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays, AbstractSearchConditionArea conditionArea, boolean showConditionArea) {      super(displays, showingDisplays, conditionArea, showConditionArea, listTabId);      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), getTitle(), TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));    }    protected void preprocessShowingTableDisplay(List<TableDisplay> showingTableDisplays) {      for (final TableDisplay d : showingTableDisplays) {        final JGroupableTable table = d.getTable();        table.addMouseListener(new MouseAdapter() {          public void mouseClicked(MouseEvent e) {            if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {              doLeftDbClick(e);            } else if (e.getClickCount() == 1 && SwingUtilities.isLeftMouseButton(e)) {              doLeftClick(e);            }          }        });      }    }    @Override    protected void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems, final TableDisplay tableDisplay) {      elementConditionDto.setWfcompoId(compoId);      elementConditionDto.setExecutor(WorkEnv.getInstance().getCurrUserId());      elementConditionDto.setNd(WorkEnv.getInstance().getTransNd());      elementConditionDto.setStatus(tableDisplay.getStatus());      elementConditionDto.setMonth(BalanceUtil.getMonthIdBySysOption());      for (AbstractSearchConditionItem item : searchConditionItems) {        item.putToElementConditionDto(elementConditionDto);      }      final Container c = tableDisplay.getTable().getParent();      UIUtilities.asyncInvoke(new DefaultInvokeHandler<TableModel>() {        @Override        public void before() {          assert c != null;          installLoadingComponent(c);        }        @Override        public void after() {          assert c != null;          unInstallLoadingComponent(c);          c.add(tableDisplay.getTable());        }        @Override        public TableModel execute() throws Exception {          return doExecute();        }        @Override        public void success(TableModel model) {          doSuccess(model);          setButtonStatus();        }      });    }  }}