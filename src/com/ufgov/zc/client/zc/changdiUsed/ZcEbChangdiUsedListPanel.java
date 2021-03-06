package com.ufgov.zc.client.zc.changdiUsed;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.common.DefaultInvokeHandler;
import com.ufgov.smartclient.common.UIUtilities;
import com.ufgov.smartclient.component.table.JGroupableTable;
import com.ufgov.smartclient.plaf.BlueLookAndFeel;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.ParentWindowAware;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.common.converter.zc.ZcEbChangdiUsedToTableModelConverter;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.ui.AbstractDataDisplay;
import com.ufgov.zc.client.component.ui.AbstractEditListBill;
import com.ufgov.zc.client.component.ui.AbstractSearchConditionArea;
import com.ufgov.zc.client.component.ui.MultiDataDisplay;
import com.ufgov.zc.client.component.ui.SaveableSearchConditionArea;
import com.ufgov.zc.client.component.ui.TableDisplay;
import com.ufgov.zc.client.component.ui.conditionitem.AbstractSearchConditionItem;
import com.ufgov.zc.client.component.ui.conditionitem.SearchConditionUtil;
import com.ufgov.zc.client.print.PrintPreviewer;
import com.ufgov.zc.client.print.PrintSettingDialog;
import com.ufgov.zc.client.print.Printer;
import com.ufgov.zc.client.util.ListUtil;
import com.ufgov.zc.client.zc.ZcUtil;
import com.ufgov.zc.common.commonbiz.model.SearchCondition;
import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.WFConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.dto.PrintObject;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.model.ZcEbChangdiUsed;
import com.ufgov.zc.common.zc.publish.IZcEbChangdiUsedServiceDelegate;

public class ZcEbChangdiUsedListPanel extends AbstractEditListBill implements ParentWindowAware {

  /**
   * 
   */
  private static final long serialVersionUID = -8118801757771272634L;

  public static final Logger logger = Logger.getLogger(ZcEbChangdiUsedListPanel.class);

  private ZcEbChangdiUsedListPanel self = this;

  private Window parentWindow;

  public static final String compoId = "ZC_EB_CHANGDI_USED";

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private ElementConditionDto elementConditionDto = new ElementConditionDto();

  private IZcEbChangdiUsedServiceDelegate zcEbChangdiUsedServiceDelegate;

  private IBaseDataServiceDelegate baseDataServiceDelegate;

  public Window getParentWindow() {

    return parentWindow;

  }

  public void setParentWindow(Window parentWindow) {

    this.parentWindow = parentWindow;

  }

  public ZcEbChangdiUsedListPanel() {
    baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
    zcEbChangdiUsedServiceDelegate = (IZcEbChangdiUsedServiceDelegate) ServiceFactory.create(IZcEbChangdiUsedServiceDelegate.class, "zcEbChangdiUsedServiceDelegate");

    UIUtilities.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {

      @Override
      public List<SearchCondition> execute() throws Exception {

        List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance()

        .getCurrUserId(), ZcEbChangdiUsed.TAB_ID);

        return needDisplaySearchConditonList;

      }

      @Override
      public void success(List<SearchCondition> needDisplaySearchConditonList) {

        List<TableDisplay> showingDisplays = SearchConditionUtil.getNeedDisplayTableDisplay(needDisplaySearchConditonList);

        init(createDataDisplay(showingDisplays), null);//调用父类方法

        revalidate();

        repaint();

      }

    });

    requestMeta.setCompoId(compoId);
  }

  private AbstractDataDisplay createDataDisplay(List<TableDisplay> showingDisplays) {

    return new DataDisplay(SearchConditionUtil.getAllTableDisplay(ZcEbChangdiUsed.TAB_ID), showingDisplays,

    createTopConditionArea(), false);//true:显示收索条件区 false：不显示收索条件区

  }

  private AbstractSearchConditionArea topSearchConditionArea;

  private AbstractSearchConditionArea createTopConditionArea() {

    Map defaultValueMap = new HashMap();

    topSearchConditionArea = new SaveableSearchConditionArea("", null, false, defaultValueMap, null);

    AbstractSearchConditionItem item = this.topSearchConditionArea.getCondItemsByCondiFieldCode(null);

    return topSearchConditionArea;

  }

  private final class DataDisplay extends MultiDataDisplay {

    private DataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays, AbstractSearchConditionArea conditionArea,

    boolean showConditionArea) {

      super(displays, showingDisplays, conditionArea, showConditionArea, ZcEbChangdiUsed.TAB_ID);

      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId), TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",

      Font.BOLD, 15), Color.BLUE));

    }

    protected void preprocessShowingTableDisplay(List<TableDisplay> showingTableDisplays) {

      for (final TableDisplay d : showingTableDisplays) {

        final JGroupableTable table = d.getTable();

        table.addMouseListener(new MouseAdapter() {

          public void mouseClicked(MouseEvent e) {

            if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {

              String tabStatus = d.getStatus();

              JGroupableTable table = d.getTable();

              MyTableModel model = (MyTableModel) table.getModel();

              int row = table.getSelectedRow();

              List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));

              new ZcEbChangdiUsedDialog(parentWindow, viewList, row, tabStatus, self);

            }

          }

        });

      }

    }

    @Override
    protected void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems, final TableDisplay tableDisplay) {

      elementConditionDto.setWfcompoId(compoId);

      elementConditionDto.setExecutor(WorkEnv.getInstance().getCurrUserId());

      elementConditionDto.setNd(WorkEnv.getInstance().getTransNd());

      elementConditionDto.setStatus(tableDisplay.getStatus());
      setZhouCondition(tableDisplay.getStatus());

      for (AbstractSearchConditionItem item : searchConditionItems) {

        item.putToElementConditionDto(elementConditionDto);

      }

      final Container c = tableDisplay.getTable().getParent();

      UIUtilities.asyncInvoke(new DefaultInvokeHandler<TableModel>() {

        @Override
        public void before() {

          assert c != null;

          installLoadingComponent(c);

        }

        @Override
        public void after() {

          assert c != null;

          unInstallLoadingComponent(c);

          c.add(tableDisplay.getTable());

        }

        @Override
        public TableModel execute() throws Exception {

          return ZcEbChangdiUsedToTableModelConverter.convertMainLst(self.zcEbChangdiUsedServiceDelegate.getMainDataLst(elementConditionDto, requestMeta));

        }

        @Override
        public void success(TableModel model) {

          tableDisplay.setTableModel(model);

          //        setButtonsVisiable();
          setButtonStatus();

        }

      });

    }

  }

  static {

    LangTransMeta.init("ZC%");

  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

      public void run() {

        try {

          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

          UIManager.setLookAndFeel(new BlueLookAndFeel());

        } catch (Exception e) {

          e.printStackTrace();

        }
        ZcEbChangdiUsedListPanel bill = new ZcEbChangdiUsedListPanel();

        JFrame frame = new JFrame("frame");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(bill);

        frame.setVisible(true);

      }

    });

  }

  public void setZhouCondition(String tabStatus) {
    Date today = requestMeta.getSysDate();

    GregorianCalendar gc = new GregorianCalendar();
    gc.setTime(today);
    Calendar beginDate = Calendar.getInstance();
    beginDate.setTime(today);
    Calendar endDate = Calendar.getInstance();
    endDate.setTime(today);
    int weekDay = gc.get(Calendar.DAY_OF_WEEK);
    if (tabStatus.equals("benzhou")) {
      switch (weekDay) {
      case 1://星期天
        beginDate.add(Calendar.DAY_OF_YEAR, -6);
      case 2://星期一 
        endDate.add(Calendar.DAY_OF_YEAR, 6);
      case 3://星期二 
        beginDate.add(Calendar.DAY_OF_YEAR, -1);
        endDate.add(Calendar.DAY_OF_YEAR, 5);
      case 4://星期三b
        beginDate.add(Calendar.DAY_OF_YEAR, -2);
        endDate.add(Calendar.DAY_OF_YEAR, 4);
      case 5://星期四
        beginDate.add(Calendar.DAY_OF_YEAR, -3);
        endDate.add(Calendar.DAY_OF_YEAR, 3);
      case 6://星期五 
        beginDate.add(Calendar.DAY_OF_YEAR, -4);
        endDate.add(Calendar.DAY_OF_YEAR, 2);
      case 7://星期六 
        beginDate.add(Calendar.DAY_OF_YEAR, -5);
        endDate.add(Calendar.DAY_OF_YEAR, 1);
      }
    } else if (tabStatus.equals("shangzhou")) {
      switch (weekDay) {
      case 1://星期天
        beginDate.add(Calendar.DAY_OF_YEAR, -13);
        endDate.add(Calendar.DAY_OF_YEAR, -7);
      case 2://星期一 
        beginDate.add(Calendar.DAY_OF_YEAR, -7);
        endDate.add(Calendar.DAY_OF_YEAR, -1);
      case 3://星期二 
        beginDate.add(Calendar.DAY_OF_YEAR, -8);
        endDate.add(Calendar.DAY_OF_YEAR, -2);
      case 4://星期三
        beginDate.add(Calendar.DAY_OF_YEAR, -9);
        endDate.add(Calendar.DAY_OF_YEAR, -3);
      case 5://星期四
        beginDate.add(Calendar.DAY_OF_YEAR, -10);
        endDate.add(Calendar.DAY_OF_YEAR, -4);
      case 6://星期五 
        beginDate.add(Calendar.DAY_OF_YEAR, -11);
        endDate.add(Calendar.DAY_OF_YEAR, -5);
      case 7://星期六 
        beginDate.add(Calendar.DAY_OF_YEAR, -12);
        endDate.add(Calendar.DAY_OF_YEAR, -6);
      }
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar t1 = Calendar.getInstance(), t2 = Calendar.getInstance();
    t1.set(beginDate.get(Calendar.YEAR), beginDate.get(Calendar.MONTH), beginDate.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    t2.set(endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH), endDate.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
    //    System.out.println("begin" + sdf.format(t1.getTime()));
    //    System.out.println("end" + sdf.format(t2.getTime()));
    elementConditionDto.setBankStartDate(t1.getTime());
    elementConditionDto.setBankEndDate(t2.getTime());

  }

  public void setButtonsVisiable() {

    String panelId = WFConstants.AUDIT_TAB_STATUS_TODO;

    if (topDataDisplay != null && topDataDisplay.getActiveTableDisplay() != null) {

      panelId = topDataDisplay.getActiveTableDisplay().getStatus();

    }

    if (WFConstants.AUDIT_TAB_STATUS_TODO.equalsIgnoreCase(panelId) && !ZcUtil.isYsdw()) {//代办

      auditPassButton.setVisible(true);

      suggestPassButton.setVisible(true);

      isSendToNextButton.setVisible(true);

      unTreadButton.setVisible(true);

      sendButton.setVisible(false);

      deleteButton.setVisible(false);

      addButton.setVisible(false);

      addReChangeButton.setVisible(false);

      callbackButton.setVisible(false);

      traceButton.setVisible(true);

      editButton.setVisible(false);

      unAuditButton.setVisible(false);

      cancelButton.setVisible(true);

    } else if (WFConstants.AUDIT_TAB_STATUS_DONE.equalsIgnoreCase(panelId)) {//已办

      auditPassButton.setVisible(false);

      isSendToNextButton.setVisible(false);

      unTreadButton.setVisible(false);

      sendButton.setVisible(false);

      deleteButton.setVisible(false);

      addButton.setVisible(false);

      addReChangeButton.setVisible(false);

      callbackButton.setVisible(true);

      traceButton.setVisible(true);

      suggestPassButton.setVisible(false);

      editButton.setVisible(false);

      unAuditButton.setVisible(true);

      cancelButton.setVisible(false);

    } else if (WFConstants.AUDIT_TAB_STATUS_ALL.equalsIgnoreCase(panelId)) {//全部

      auditPassButton.setVisible(false);

      isSendToNextButton.setVisible(false);

      unTreadButton.setVisible(false);

      sendButton.setVisible(false);

      deleteButton.setVisible(false);

      addButton.setVisible(false);

      addReChangeButton.setVisible(false);

      callbackButton.setVisible(false);

      traceButton.setVisible(true);

      suggestPassButton.setVisible(false);

      editButton.setVisible(false);

      unAuditButton.setVisible(false);

      cancelButton.setVisible(false);

    } else if (WFConstants.EDIT_TAB_STATUS_EXEC.equalsIgnoreCase(panelId)) {//终审

      auditPassButton.setVisible(false);

      isSendToNextButton.setVisible(false);

      unTreadButton.setVisible(false);

      sendButton.setVisible(false);

      deleteButton.setVisible(false);

      addButton.setVisible(false);

      addReChangeButton.setVisible(false);

      callbackButton.setVisible(false);

      suggestPassButton.setVisible(false);

      editButton.setVisible(false);

      unAuditButton.setVisible(false);

      cancelButton.setVisible(false);

    } else if (WFConstants.EDIT_TAB_STATUS_DRAFT.equalsIgnoreCase(panelId)) {//草稿

      auditPassButton.setVisible(false);

      isSendToNextButton.setVisible(false);

      unTreadButton.setVisible(false);

      sendButton.setVisible(true);

      deleteButton.setVisible(true);

      addButton.setVisible(true);

      addReChangeButton.setVisible(true);

      callbackButton.setVisible(false);

      suggestPassButton.setVisible(false);

      editButton.setVisible(true);

      unAuditButton.setVisible(false);

      cancelButton.setVisible(true);

    } else if ("cancel".equalsIgnoreCase(panelId)) {

      traceButton.setVisible(false);

      sendButton.setVisible(false);

      suggestPassButton.setVisible(false);

      unTreadButton.setVisible(false);

      addButton.setVisible(false);

      deleteButton.setVisible(false);

      printButton.setVisible(false);

      printPreviewButton.setVisible(false);

      printSettingButton.setVisible(false);

      callbackButton.setVisible(false);

      unAuditButton.setVisible(false);

      cancelButton.setVisible(false);

    }

  }

  @Override
  protected void addToolBarComponent(JFuncToolBar toolBar) {

    toolBar.setModuleCode("ZC");

    toolBar.setCompoId(compoId);

    toolBar.add(addButton);

    // toolBar.add(updateButton);

    //    toolBar.add(deleteButton);

    toolBar.add(helpButton);

    //    toolBar.add(sendButton);//送审

    //    toolBar.add(suggestPassButton);//填写意见审核通过

    //    toolBar.add(auditFinalButton);

    //    toolBar.add(callbackButton);//收回

    //    toolBar.add(unTreadButton);//退回

    //    toolBar.add(unAuditButton);//销审

    //    toolBar.add(cancelButton);//撤销

    //    toolBar.add(traceButton);

    //toolBar.add(printButton);

    //toolBar.add(isSendToNextButton);

    //    toolBar.add(traceDataButton);

    toolBar.add(printButton);

    toolBar.add(printPreviewButton);

    toolBar.add(printSettingButton);

    // 初始化按钮的action事件

    // 初始化按钮的action事件

    addButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        doAdd();

      }

    });

    printButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {

        doPrint();

      }

    });

    printPreviewButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {

        doPrintPreview();

      }

    });

    printSettingButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {

        doPrintSetting();

      }

    });

  }

  public void refreshCurrentTabData() {

    topSearchConditionArea.doSearch();

  }

  public void refreshCurrentTabData(List beanList) {

    topDataDisplay.getActiveTableDisplay().getTable().setModel(ZcEbChangdiUsedToTableModelConverter.convertMainLst(beanList));

  }

  public List getCheckedList() {

    List<ZcEbChangdiUsed> beanList = new ArrayList<ZcEbChangdiUsed>();

    JGroupableTable table = topDataDisplay.getActiveTableDisplay().getTable();

    MyTableModel model = (MyTableModel) table.getModel();

    //Modal的数据

    List list = model.getList();

    Integer[] checkedRows = table.getCheckedRows();

    for (Integer checkedRow : checkedRows) {

      int accordDataRow = table.convertRowIndexToModel(checkedRow);

      ZcEbChangdiUsed bean = (ZcEbChangdiUsed) list.get(accordDataRow);

      beanList.add(bean);

    }

    return beanList;

  }

  private void doAdd() {

    new ZcEbChangdiUsedDialog(parentWindow, new ArrayList(1), -1, topDataDisplay.getActiveTableDisplay().getStatus(), self);

  }

  private void doSend() {

  }

  private void doBatEdit() {

  }

  private void doBlankout() {

  }

  private void doTrace() {

    List beanList = getCheckedList();

    if (beanList.size() == 0) {

      JOptionPane.showMessageDialog(this, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    if (beanList.size() > 1) {

      JOptionPane.showMessageDialog(this, "只能选择一条数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    for (int i = 0; i < beanList.size(); i++) {

      ZcEbChangdiUsed bean = (ZcEbChangdiUsed) beanList.get(i);

      ZcUtil.showTraceDialog(bean, compoId);

    }

  }

  private void doCallBack() {

  }

  private void doPrint() {

    List printList = getCheckedList();

    if (printList.size() == 0) {

      JOptionPane.showMessageDialog(this, "请选择需要打印的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    requestMeta.setFuncId(this.printButton.getFuncId());

    requestMeta.setPageType(this.compoId + "_L");

    boolean success = true;

    boolean printed = false;

    try {

      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);

      if (Printer.print(printObject)) {

        printed = true;

      }

    } catch (Exception e) {

      success = false;

      logger.error(e.getMessage(), e);

      JOptionPane.showMessageDialog(this, "打印出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);

    }

    if (success && printed) {

    }

  }

  private void doGroupPrint() {

  }

  private void doPrintPreview() {

    final List printList = getCheckedList();

    if (printList.size() == 0) {

      JOptionPane.showMessageDialog(this, "请选择需要打印预览的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);

      return;

    }

    requestMeta.setFuncId(this.printPreviewButton.getFuncId());

    requestMeta.setPageType(this.compoId + "_L");

    try {

      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);

      PrintPreviewer previewer = new PrintPreviewer(printObject) {

        protected void afterSuccessPrint() {

        }

      };

      previewer.preview();

    } catch (Exception e) {

      logger.error(e.getMessage(), e);

      JOptionPane.showMessageDialog(this, "打印预览出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  private void doPrintPreviewGroup() {

  }

  private void doPrintSetting() {

    requestMeta.setFuncId(this.printSettingButton.getFuncId());

    requestMeta.setPageType(this.compoId + "_L");

    new PrintSettingDialog(requestMeta);

  }

  private void setButtonStatus() {
    //    addButton.setVisible(SfUtil.canNew(compoId, null));
  }

  public String getcompoId() {
    // TCJLODO Auto-generated method stub
    return compoId;
  }

}
