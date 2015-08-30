package com.ufgov.zc.client.zc.notice;import java.awt.Color;import java.awt.Container;import java.awt.DefaultKeyboardFocusManager;import java.awt.Dialog.ModalityType;import java.awt.Font;import java.awt.Window;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.util.ArrayList;import java.util.HashMap;import java.util.Iterator;import java.util.List;import java.util.Map;import javax.swing.BorderFactory;import javax.swing.JFrame;import javax.swing.JOptionPane;import javax.swing.SwingUtilities;import javax.swing.UIManager;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.DefaultInvokeHandler;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.smartclient.component.table.JGroupableTable;import com.ufgov.smartclient.plaf.BlueLookAndFeel;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.ParentWindowAware;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.zc.ZcEbNoticeToTableModelConverter;import com.ufgov.zc.client.component.GkCommentDialog;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.ui.AbstractDataDisplay;import com.ufgov.zc.client.component.ui.AbstractEditListBill;import com.ufgov.zc.client.component.ui.AbstractSearchConditionArea;import com.ufgov.zc.client.component.ui.MultiDataDisplay;import com.ufgov.zc.client.component.ui.SaveableSearchConditionArea;import com.ufgov.zc.client.component.ui.TableDisplay;import com.ufgov.zc.client.component.ui.conditionitem.AbstractSearchConditionItem;import com.ufgov.zc.client.component.ui.conditionitem.AsValComboboxConditionItem2;import com.ufgov.zc.client.component.ui.conditionitem.SearchConditionUtil;import com.ufgov.zc.client.print.PrintPreviewer;import com.ufgov.zc.client.print.PrintSettingDialog;import com.ufgov.zc.client.print.Printer;import com.ufgov.zc.client.util.ListUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.flowconsole.DataFlowConsoleCanvas;import com.ufgov.zc.common.commonbiz.model.SearchCondition;import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbNotice;import com.ufgov.zc.common.zc.publish.IZcEbNoticeServiceDelegate;public class ZcEbNoticeListPanel extends AbstractEditListBill implements ParentWindowAware {  private static final Logger logger = Logger.getLogger(ZcEbNoticeListPanel.class);  private ZcEbNoticeListPanel self = this;  private Window parentWindow;  public static final String compoId = "ZC_EB_NOTICE";  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private ElementConditionDto elementConditionDto = new ElementConditionDto();  private IZcEbNoticeServiceDelegate ZcEbNoticeServiceDelegate = (IZcEbNoticeServiceDelegate) ServiceFactory.create(IZcEbNoticeServiceDelegate.class,  "zcEbNoticeServiceDelegate");  private IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,  "baseDataServiceDelegate");  public Window getParentWindow() {    return parentWindow;  }  public void setParentWindow(Window parentWindow) {    this.parentWindow = parentWindow;  }  private final class DataDisplay extends MultiDataDisplay {    private DataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays, AbstractSearchConditionArea conditionArea,    boolean showConditionArea) {      super(displays, showingDisplays, conditionArea, showConditionArea, ZcSettingConstants.TAB_ID_ZC_EB_NOTICE);      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "中标通知书管理", TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",      Font.BOLD, 15), Color.BLUE));    }    protected void preprocessShowingTableDisplay(List<TableDisplay> showingTableDisplays) {      for (final TableDisplay d : showingTableDisplays) {        final JGroupableTable table = d.getTable();        table.addMouseListener(new MouseAdapter() {          public void mouseClicked(MouseEvent e) {            if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {              String tabStatus = d.getStatus();              JGroupableTable table = d.getTable();              MyTableModel model = (MyTableModel) table.getModel();              int row = table.getSelectedRow();              List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));              new ZcEbNoticeDialog(self, viewList, row, tabStatus);            }          }        });      }    }    @Override    protected void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems, final TableDisplay tableDisplay) {      elementConditionDto.setWfcompoId(compoId);      elementConditionDto.setExecutor(WorkEnv.getInstance().getCurrUserId());      elementConditionDto.setNd(WorkEnv.getInstance().getTransNd());      elementConditionDto.setStatus(tableDisplay.getStatus());      for (AbstractSearchConditionItem item : searchConditionItems) {        item.putToElementConditionDto(elementConditionDto);      }      final Container c = tableDisplay.getTable().getParent();      UIUtilities.asyncInvoke(new DefaultInvokeHandler<TableModel>() {        @Override        public void before() {          assert c != null;          installLoadingComponent(c);        }        @Override        public void after() {          assert c != null;          unInstallLoadingComponent(c);          c.add(tableDisplay.getTable());        }        @Override        public TableModel execute() throws Exception {          return ZcEbNoticeToTableModelConverter.convertToTableModel(self.ZcEbNoticeServiceDelegate.getZcEbNotice(elementConditionDto, requestMeta));        }        @Override        public void success(TableModel model) {          tableDisplay.setTableModel(model);          setButtonsVisiable();        }      });    }  }  static {    LangTransMeta.init("ZC%");  }  /**   * 构造函数   */  public ZcEbNoticeListPanel() {    UIUtilities.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {      @Override      public List<SearchCondition> execute() throws Exception {        List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance()        .getCurrUserId(), ZcSettingConstants.TAB_ID_ZC_EB_NOTICE);        return needDisplaySearchConditonList;      }      @Override      public void success(List<SearchCondition> needDisplaySearchConditonList) {        List<TableDisplay> showingDisplays = SearchConditionUtil.getNeedDisplayTableDisplay(needDisplaySearchConditonList);        init(createDataDisplay(showingDisplays), null);//调用父类方法        revalidate();        repaint();      }    });    requestMeta.setCompoId(compoId);  }  private AbstractSearchConditionArea topSearchConditionArea;  private AbstractSearchConditionArea createTopConditionArea() {    Map defaultValueMap = new HashMap();    topSearchConditionArea = new SaveableSearchConditionArea("", null, false, defaultValueMap, null);    AbstractSearchConditionItem item = this.topSearchConditionArea.getCondItemsByCondiFieldCode(null);    if (item != null) {      ((AsValComboboxConditionItem2) item).setValueByCode("0");    }    return topSearchConditionArea;  }  private AbstractDataDisplay createDataDisplay(List<TableDisplay> showingDisplays) {    return new DataDisplay(SearchConditionUtil.getAllTableDisplay(ZcSettingConstants.TAB_ID_ZC_P_PRO_MAKE), showingDisplays,    createTopConditionArea(), true);//true:显示收索条件区 false：不显示收索条件区  }  @Override  protected void addToolBarComponent(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    toolBar.add(addButton);    // toolBar.add(updateButton);    toolBar.add(deleteButton);    toolBar.add(helpButton);    toolBar.add(sendButton);//送审    //    toolBar.add(suggestPassButton);//填写意见审核通过    //    toolBar.add(auditFinalButton);    //    toolBar.add(callbackButton);//收回    //    toolBar.add(unTreadButton);//退回    //    toolBar.add(unAuditButton);//销审    //    toolBar.add(cancelButton);//撤销    toolBar.add(traceButton);    //toolBar.add(printButton);    //toolBar.add(isSendToNextButton);    toolBar.add(traceDataButton);    // 初始化按钮的action事件    // 初始化按钮的action事件    addButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doAdd();      }    });    sendButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doSend();      }    });    isSendToNextButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doSendNext();      }    });    deleteButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doDelete();      }    });    printButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrint();      }    });    printPreviewButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintPreview();      }    });    printSettingButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintSetting();      }    });    suggestPassButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doSuggestPass();      }    });    callbackButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doCallBack();      }    });    unTreadButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doUnTread();      }    });    unAuditButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doUnAudit();      }    });    traceButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doTrace();      }    });    cancelButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doCancel();      }    });    auditFinalButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doAuditFinal();      }    });    traceDataButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doTraceDataButton();      }    });  }  private void doAuditFinal() {    List beanList = getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.auditFinalButton.getFuncId());    executeAudit(beanList, ZcSettingConstants.IS_GOON_AUDIT_YES);  }  public void doCancel() {    boolean success = true;    requestMeta.setFuncId(this.cancelButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    int num = JOptionPane.showConfirmDialog(this, "确实要撤销计划？");    if (num == JOptionPane.YES_OPTION) {      try {        for (int i = 0; i < beanList.size(); i++) {          ZcEbNotice make = (ZcEbNotice) beanList.get(i);          make.setNoticeStatus("cancel");          this.getZcEbNoticeServiceDelegate().CancelMakeFN(make, requestMeta);        }      } catch (Exception ex) {        logger.error(ex.getMessage(), ex);        success = false;        UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());      }      if (success) {        JOptionPane.showMessageDialog(this, "撤销成功！", "提示", JOptionPane.INFORMATION_MESSAGE);        this.refreshCurrentTabData();      }    }  }  public void doUnAudit() {    boolean success = true;    String errorInfo = "";    requestMeta.setFuncId(this.unAuditButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        ZcEbNotice make = (ZcEbNotice) beanList.get(i);        make.setAuditorId(WorkEnv.getInstance().getCurrUserId());        this.getZcEbNoticeServiceDelegate().unAuditFN(make, requestMeta);      }    } catch (Exception ex) {      errorInfo += ex.getMessage();      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "销审成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "销审失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  public void doUnTread() {    boolean success = true;    requestMeta.setFuncId(this.unTreadButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),    ModalityType.APPLICATION_MODAL, "不同意");    if (commentDialog.cancel) {      return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        ZcEbNotice make = (ZcEbNotice) beanList.get(i);        make.setAuditorId(WorkEnv.getInstance().getCurrUserId());        make.setComment(commentDialog.getComment());        this.getZcEbNoticeServiceDelegate().untreadFN(make, requestMeta);      }    } catch (Exception ex) {      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "退回成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    }  }  public void doSuggestPass() {    boolean success = true;    requestMeta.setFuncId(this.suggestPassButton.getFuncId());    List beanList = this.getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),    ModalityType.APPLICATION_MODAL);    if (commentDialog.cancel) {      return;    }    try {      for (int i = 0; i < beanList.size(); i++) {        ZcEbNotice make = (ZcEbNotice) beanList.get(i);        make.setAuditorId(WorkEnv.getInstance().getCurrUserId());        make.setComment(commentDialog.getComment());        make.setIsGoonAudit(ZcSettingConstants.IS_GOON_AUDIT_NO);        this.getZcEbNoticeServiceDelegate().auditFN(make, requestMeta);      }    } catch (Exception ex) {      logger.error(ex.getMessage(), ex);      success = false;      UIUtilities.showStaickTraceDialog(ex, this, "错误", ex.getMessage());    }    if (success) {      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    }  }  /**   * 是否送主任审核   */  private void doSendNext() {    List beanList = getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.isSendToNextButton.getFuncId());    int sel = JOptionPane.showConfirmDialog(this, "是否送主任审核？");    if (sel == JOptionPane.OK_OPTION) {      executeAudit(beanList, ZcSettingConstants.IS_GOON_AUDIT_YES);    } else {      executeAudit(beanList, ZcSettingConstants.IS_GOON_AUDIT_NO);    }  }  private void executeAudit(List beanList, int isGoonAudit) {    GkCommentDialog commentDialog = new GkCommentDialog(DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),    ModalityType.APPLICATION_MODAL);    if (commentDialog.cancel) {      return;    }    boolean success = true;    String errorInfo = "";    try {      String comment = commentDialog.getComment();      for (int i = 0; i < beanList.size(); i++) {        ZcEbNotice report = (ZcEbNotice) beanList.get(i);        report.setIsGoonAudit(isGoonAudit);        report.setComment(comment);        report.setAuditorId(WorkEnv.getInstance().getCurrUserId());        this.getZcEbNoticeServiceDelegate().updateFN(report, requestMeta);      }      this.getZcEbNoticeServiceDelegate().commitFN(beanList, requestMeta);    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      errorInfo += e.getMessage();    }    if (success) {      refreshCurrentTabData();      JOptionPane.showMessageDialog(this, "审核成功！", "提示", JOptionPane.INFORMATION_MESSAGE);    } else {      JOptionPane.showMessageDialog(this, "审核失败 ！" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  public void refreshCurrentTabData() {    topSearchConditionArea.doSearch();  }  public void refreshCurrentTabData(List beanList) {    topDataDisplay.getActiveTableDisplay().getTable().setModel(ZcEbNoticeToTableModelConverter.convertToTableModel(beanList));  }  public List getCheckedList() {    List<ZcEbNotice> beanList = new ArrayList<ZcEbNotice>();    JGroupableTable table = topDataDisplay.getActiveTableDisplay().getTable();    MyTableModel model = (MyTableModel) table.getModel();    //Modal的数据    List list = model.getList();    Integer[] checkedRows = table.getCheckedRows();    for (Integer checkedRow : checkedRows) {      int accordDataRow = table.convertRowIndexToModel(checkedRow);      ZcEbNotice bean = (ZcEbNotice) list.get(accordDataRow);      beanList.add(bean);    }    return beanList;  }  private void doAdd() {    new ZcEbNoticeDialog(self, new ArrayList(1), -1, topDataDisplay.getActiveTableDisplay().getStatus());  }  private void doSend() {  }  private void doBatEdit() {  }  private void doDelete() {    List beanList = getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);    if (num == JOptionPane.NO_OPTION)      return;    boolean success = true;    ZcEbNotice zcEbNotice = null;    String errorInfo = "";    try {      requestMeta.setFuncId(deleteButton.getFuncId());      for (Iterator iterator = beanList.iterator(); iterator.hasNext();) {        zcEbNotice = (ZcEbNotice) iterator.next();        if (!"0".equals(zcEbNotice.getNoticeStatus()))          JOptionPane.showMessageDialog(this, "非编辑状态单据，不可以删除！", "提示", JOptionPane.ERROR_MESSAGE);        this.getZcEbNoticeServiceDelegate().deleteBeanListFN(beanList, this.requestMeta);      }    } catch (Exception e) {      logger.error(e.getMessage(), e);      success = false;      errorInfo += e.getMessage();    }    if (success) {      JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);      this.refreshCurrentTabData();    } else {      JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doBlankout() {  }  private void doTrace() {    List beanList = getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    if (beanList.size() > 1) {      JOptionPane.showMessageDialog(this, "只能选择一条数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    for (int i = 0; i < beanList.size(); i++) {      ZcEbNotice bean = (ZcEbNotice) beanList.get(i);      ZcUtil.showTraceDialog(bean, compoId);    }  }  private void doCallBack() {  }  private void doPrint() {    List printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    boolean success = true;    boolean printed = false;    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      if (Printer.print(printObject)) {        printed = true;      }    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }    if (success && printed) {    }  }  private void doGroupPrint() {  }  private void doPrintPreview() {    final List printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印预览的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printPreviewButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      PrintPreviewer previewer = new PrintPreviewer(printObject) {        protected void afterSuccessPrint() {        }      };      previewer.preview();    } catch (Exception e) {      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印预览出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doPrintPreviewGroup() {  }  private void doPrintSetting() {    requestMeta.setFuncId(this.printSettingButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    new PrintSettingDialog(requestMeta);  }  private void setButtonStatus() {  }  private void doTraceDataButton() {    List beanList = getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择一条要进行跟踪的数据！", "错误", JOptionPane.ERROR_MESSAGE);      return;    }    ZcEbNotice sh = (ZcEbNotice) beanList.get(0);    DataFlowConsoleCanvas dfc = new DataFlowConsoleCanvas(sh.getProjCode(), this.compoId);    dfc.showWindow();  }  public static void main(String[] args) throws Exception {    SwingUtilities.invokeLater(new Runnable() {      public void run() {        try {          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());          UIManager.setLookAndFeel(new BlueLookAndFeel());        } catch (Exception e) {          e.printStackTrace();        }        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());        ZcEbNoticeListPanel bill = new ZcEbNoticeListPanel();        JFrame frame = new JFrame("frame");        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        frame.setSize(800, 600);        frame.setLocationRelativeTo(null);        frame.getContentPane().add(bill);        frame.setVisible(true);      }    });  }  IZcEbNoticeServiceDelegate getZcEbNoticeServiceDelegate() {    return this.ZcEbNoticeServiceDelegate;  }  private BillElementMeta billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);  public BillElementMeta getBillElementMeta() {    return billElementMeta;  }}