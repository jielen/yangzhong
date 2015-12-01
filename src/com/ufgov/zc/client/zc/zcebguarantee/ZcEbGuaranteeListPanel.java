/** * ZcebGuaranteeListPanel.java * com.ufgov.gk.client.zc.zcebguarantee * Administrator * 2010-4-21 */package com.ufgov.zc.client.zc.zcebguarantee;import java.awt.Color;import java.awt.Container;import java.awt.Font;import java.awt.Window;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.swing.BorderFactory;import javax.swing.JFrame;import javax.swing.JOptionPane;import javax.swing.SwingUtilities;import javax.swing.UIManager;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.DefaultInvokeHandler;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.smartclient.component.table.JGroupableTable;import com.ufgov.smartclient.plaf.BlueLookAndFeel;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.ParentWindowAware;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.zc.ZcEbGuaranteeToTableModelConverter;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.button.AddButton;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.button.PrintButton;import com.ufgov.zc.client.component.button.PrintPreviewButton;import com.ufgov.zc.client.component.button.PrintSettingButton;import com.ufgov.zc.client.component.ui.AbstractDataDisplay;import com.ufgov.zc.client.component.ui.AbstractEditListBill;import com.ufgov.zc.client.component.ui.AbstractSearchConditionArea;import com.ufgov.zc.client.component.ui.MultiDataDisplay;import com.ufgov.zc.client.component.ui.SaveableSearchConditionArea;import com.ufgov.zc.client.component.ui.TableDisplay;import com.ufgov.zc.client.component.ui.conditionitem.AbstractSearchConditionItem;import com.ufgov.zc.client.component.ui.conditionitem.SearchConditionUtil;import com.ufgov.zc.client.print.PrintPreviewer;import com.ufgov.zc.client.print.PrintSettingDialog;import com.ufgov.zc.client.print.Printer;import com.ufgov.zc.client.util.BalanceUtil;import com.ufgov.zc.client.util.ListUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.common.commonbiz.model.SearchCondition;import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbGuarantee;import com.ufgov.zc.common.zc.publish.IZcEbGuaranteeServiceDelegate;/** * @author Administrator * */public class ZcEbGuaranteeListPanel extends AbstractEditListBill implements ParentWindowAware {  private static final Logger logger = Logger.getLogger(ZcEbGuaranteeListPanel.class);  private Window parentWindow;  private ZcEbGuaranteeListPanel self = this;  private String compoId = "ZC_EB_GUARANTEE";  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private ElementConditionDto elementConditionDto = new ElementConditionDto();  private IZcEbGuaranteeServiceDelegate zcEbGuaranteeServiceDelegate = (IZcEbGuaranteeServiceDelegate) ServiceFactory.create(  IZcEbGuaranteeServiceDelegate.class, "zcEbGuaranteeServiceDelegate");  private IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,  "baseDataServiceDelegate");  private AbstractSearchConditionArea topSearchConditionArea;  @Override  public Window getParentWindow() {    // TCJLODO Auto-generated method stub    return parentWindow;  }  @Override  public void setParentWindow(Window window) {    // TCJLODO Auto-generated method stub    this.parentWindow = window;  }  private final class DataDisplay extends MultiDataDisplay {    private DataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays, AbstractSearchConditionArea conditionArea,    boolean showConditionArea) {      super(displays, showingDisplays, conditionArea, showConditionArea, ZcSettingConstants.TAB_ID_ZC_EB_GUARANTEE);      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "投标保证金管理", TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",      Font.BOLD, 15), Color.BLUE));    }    @Override    protected void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems, final TableDisplay tableDisplay) {      elementConditionDto.setWfcompoId(compoId);      elementConditionDto.setExecutor(WorkEnv.getInstance().getCurrUserId());      elementConditionDto.setNd(WorkEnv.getInstance().getTransNd());      elementConditionDto.setStatus(tableDisplay.getStatus());      elementConditionDto.setMonth(BalanceUtil.getMonthIdBySysOption());      for (AbstractSearchConditionItem item : searchConditionItems) {        item.putToElementConditionDto(elementConditionDto);      }      final Container c = tableDisplay.getTable().getParent();      UIUtilities.asyncInvoke(new DefaultInvokeHandler<TableModel>() {        @Override        public void before() {          assert c != null;          installLoadingComponent(c);        }        @Override        public void after() {          assert c != null;          unInstallLoadingComponent(c);          c.add(tableDisplay.getTable());        }        @Override        public TableModel execute() throws Exception {          return ZcEbGuaranteeToTableModelConverter.convertToTableModel(self.zcEbGuaranteeServiceDelegate.getZcEbGuarantee(elementConditionDto,          requestMeta));        }        @Override        public void success(TableModel model) {          tableDisplay.setTableModel(model);          setButtonStatus();        }      });    }    @Override    protected void preprocessShowingTableDisplay(List<TableDisplay> showingTableDisplays) {      for (final TableDisplay d : showingTableDisplays) {        final JGroupableTable table = d.getTable();        table.addMouseListener(new MouseAdapter() {          public void mouseClicked(MouseEvent e) {            if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {              String tabStatus = d.getStatus();              JGroupableTable table = d.getTable();              MyTableModel model = (MyTableModel) table.getModel();              int row = table.getSelectedRow();              List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));              new ZcEbGuaranteeDialog(self, viewList, row, tabStatus);            }          }        });      }    }  }  static {    LangTransMeta.init("ZC%");  }  /**   * 构造函数   */  public ZcEbGuaranteeListPanel() {    UIUtilities.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {      @Override      public List<SearchCondition> execute() throws Exception {        List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance()        .getCurrUserId(), ZcSettingConstants.TAB_ID_ZC_EB_GUARANTEE);        return needDisplaySearchConditonList;      }      @Override      public void success(List<SearchCondition> needDisplaySearchConditonList) {        List<TableDisplay> showingDisplays = SearchConditionUtil.getNeedDisplayTableDisplay(needDisplaySearchConditonList);        init(createDataDisplay(showingDisplays), null);//调用父类方法        revalidate();        repaint();      }    });    requestMeta.setCompoId(compoId);  }  private void setButtonStatus() {  }  private AbstractDataDisplay createDataDisplay(List<TableDisplay> showingDisplays) {    return new DataDisplay(SearchConditionUtil.getAllTableDisplay(ZcSettingConstants.TAB_ID_ZC_EB_GUARANTEE), showingDisplays,    createTopConditionArea(), true);//true:显示收索条件区 false：不显示收索条件区  }  private AbstractSearchConditionArea createTopConditionArea() {    Map defaultValueMap = new HashMap();    topSearchConditionArea = new SaveableSearchConditionArea(ZcSettingConstants.CONDITION_ID_ZC_EB_GUARANTEE, null, true, defaultValueMap, null);    return topSearchConditionArea;  }  private AddButton addButton = new AddButton();  private PrintButton printButton = new PrintButton();  private FuncButton printPreviewButton = new PrintPreviewButton();  private PrintSettingButton printSettingButton = new PrintSettingButton();  private HelpButton helpButton = new HelpButton();  @Override  protected void addToolBarComponent(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    toolBar.add(addButton);    //    toolBar.add(printButton);    //    //    toolBar.add(printPreviewButton);    //    //    toolBar.add(printSettingButton);    toolBar.add(helpButton);    // 初始化按钮的action事件    addButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doAdd();      }    });    printButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrint();      }    });    printPreviewButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintPreview();      }    });    printSettingButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintSetting();      }    });  }  public void refreshCurrentTabData() {    topSearchConditionArea.doSearch();  }  public void refreshCurrentTabData(List beanList) {    topDataDisplay.getActiveTableDisplay().getTable().setModel(ZcEbGuaranteeToTableModelConverter.convertToTableModel(beanList));  }  public List getCheckedList() {    List<ZcEbGuarantee> beanList = new ArrayList<ZcEbGuarantee>();    JGroupableTable table = topDataDisplay.getActiveTableDisplay().getTable();    MyTableModel model = (MyTableModel) table.getModel();    //Modal的数据    List list = model.getList();    Integer[] checkedRows = table.getCheckedRows();    for (Integer checkedRow : checkedRows) {      int accordDataRow = table.convertRowIndexToModel(checkedRow);      ZcEbGuarantee bean = (ZcEbGuarantee) list.get(accordDataRow);      beanList.add(bean);    }    return beanList;  }  private void doAdd() {  }  private void doSend() {  }  private void doBatEdit() {  }  private void doEdit() {  }  private void doDelete() {  }  private void doBlankout() {  }  private void doTrace() {    List beanList = getCheckedList();    ZcUtil.showTraceDialog(beanList, this);  }  private void doCallBack() {  }  private void doPrint() {    List printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    boolean success = true;    boolean printed = false;    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      if (Printer.print(printObject)) {        printed = true;      }    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }    if (success && printed) {    }  }  private void doGroupPrint() {  }  private void doPrintPreview() {    final List printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印预览的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printPreviewButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      PrintPreviewer previewer = new PrintPreviewer(printObject) {        protected void afterSuccessPrint() {        }      };      previewer.preview();    } catch (Exception e) {      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印预览出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doPrintPreviewGroup() {  }  private void doPrintSetting() {    requestMeta.setFuncId(this.printSettingButton.getFuncId());    requestMeta.setPageType(this.compoId + "_L");    new PrintSettingDialog(requestMeta);  }  public static void main(String[] args) throws Exception {    SwingUtilities.invokeLater(new Runnable() {      public void run() {        try {          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());          UIManager.setLookAndFeel(new BlueLookAndFeel());        } catch (Exception e) {          e.printStackTrace();        }        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());        ZcEbGuaranteeListPanel bill = new ZcEbGuaranteeListPanel();        JFrame frame = new JFrame("frame");        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        frame.setSize(800, 600);        frame.setLocationRelativeTo(null);        frame.getContentPane().add(bill);        frame.setVisible(true);      }    });  }  IZcEbGuaranteeServiceDelegate getGuaranteServiceDelegate() {    return this.zcEbGuaranteeServiceDelegate;  }}