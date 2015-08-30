package com.ufgov.zc.client.zc.project.control;import java.awt.Color;import java.awt.Container;import java.awt.Font;import java.awt.Window;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.swing.BorderFactory;import javax.swing.JFrame;import javax.swing.JOptionPane;import javax.swing.SwingUtilities;import javax.swing.UIManager;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.DefaultInvokeHandler;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.smartclient.component.table.JGroupableTable;import com.ufgov.smartclient.plaf.BlueLookAndFeel;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.ParentWindowAware;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.zc.ZcEbProjectControlToTableModelConverter;import com.ufgov.zc.client.common.converter.zc.ZcEbProjectToTableModelConverter;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.button.FuncButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.button.PrintButton;import com.ufgov.zc.client.component.button.PrintPreviewButton;import com.ufgov.zc.client.component.button.PrintSettingButton;import com.ufgov.zc.client.component.button.TraceButton;import com.ufgov.zc.client.component.ui.AbstractDataDisplay;import com.ufgov.zc.client.component.ui.AbstractEditListBill;import com.ufgov.zc.client.component.ui.AbstractSearchConditionArea;import com.ufgov.zc.client.component.ui.MultiDataDisplay;import com.ufgov.zc.client.component.ui.SaveableSearchConditionArea;import com.ufgov.zc.client.component.ui.TableDisplay;import com.ufgov.zc.client.component.ui.conditionitem.AbstractSearchConditionItem;import com.ufgov.zc.client.component.ui.conditionitem.SearchConditionUtil;import com.ufgov.zc.client.print.PrintPreviewer;import com.ufgov.zc.client.print.PrintSettingDialog;import com.ufgov.zc.client.print.Printer;import com.ufgov.zc.client.util.ListUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.flowconsole.DataFlowConsoleCanvas;import com.ufgov.zc.common.commonbiz.model.SearchCondition;import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbProjPackVO;import com.ufgov.zc.common.zc.publish.IZcEbProjServiceDelegate;/** * @ClassName: ZcEbProjectListPanel * @Description: 项目控制 * @date: 2010-10-13 上午10:44:50 * @version: V1.0 * @since: 1.0 * @author: LEO * @modify: */@SuppressWarnings({ "serial", "unchecked" })public class ZcEbProjectControlListPanel extends AbstractEditListBill implements ParentWindowAware {  private static final Logger logger = Logger.getLogger(ZcEbProjectControlListPanel.class);  private Window parentWindow;  public static final String compoId = "ZC_EB_PROJ_CTRL";  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private BillElementMeta billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);  public BillElementMeta getBillElementMeta() {    return billElementMeta;  }  public RequestMeta getRequestMeta() {    return requestMeta;  }  private ElementConditionDto elementConditionDto = new ElementConditionDto();  public IZcEbProjServiceDelegate zcEbProjectServiceDelegate = (IZcEbProjServiceDelegate) ServiceFactory.create(IZcEbProjServiceDelegate.class,    "zcEbProjServiceDelegate");  public IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,    "baseDataServiceDelegate");  public Window getParentWindow() {    return parentWindow;  }  public void setParentWindow(Window parentWindow) {    this.parentWindow = parentWindow;  }  private final class DataDisplay extends MultiDataDisplay {    private DataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays, AbstractSearchConditionArea conditionArea,      boolean showConditionArea) {      super(displays, showingDisplays, conditionArea, showConditionArea, "ZcEbProjCtrl_ProjTab");      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "项目控制", TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",        Font.BOLD, 15), Color.BLUE));    }    protected void preprocessShowingTableDisplay(List<TableDisplay> showingTableDisplays) {      for (final TableDisplay d : showingTableDisplays) {        final JGroupableTable table = d.getTable();        table.addMouseListener(new MouseAdapter() {          public void mouseClicked(MouseEvent e) {            if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {              if (ZcEbProjectControlEditSubDialog.getInstanceCount() >= 1) {                return;              }              JGroupableTable table = d.getTable();              MyTableModel model = (MyTableModel) table.getModel();              List data = model.getList();              int row = table.getSelectedRow();              List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(data, table));              new ZcEbProjectControlEditSubDialog(ZcEbProjectControlListPanel.this, viewList, row, "0");            }          }        });      }    }    @Override    protected void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems, final TableDisplay tableDisplay) {      elementConditionDto.setWfcompoId(compoId);      elementConditionDto.setExecutor(WorkEnv.getInstance().getCurrUserId());      elementConditionDto.setNd(WorkEnv.getInstance().getTransNd());      elementConditionDto.setStatus(tableDisplay.getStatus());      for (AbstractSearchConditionItem item : searchConditionItems) {        item.putToElementConditionDto(elementConditionDto);      }      final Container c = tableDisplay.getTable().getParent();      UIUtilities.asyncInvoke(new DefaultInvokeHandler<TableModel>() {        @Override        public void before() {          assert c != null;          installLoadingComponent(c);        }        @Override        public void after() {          assert c != null;          unInstallLoadingComponent(c);          c.add(tableDisplay.getTable());        }        @Override        public TableModel execute() throws Exception {          List list = zcEbProjectServiceDelegate.getZcEbProjPackVO(elementConditionDto, requestMeta);          return ZcEbProjectControlToTableModelConverter.convertToTableModel(list);        }        @Override        public void success(TableModel model) {          tableDisplay.setTableModel(model);        }      });    }  }  static {    LangTransMeta.init("ZC%");  }  public ZcEbProjectControlListPanel() {    UIUtilities.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {      @Override      public List<SearchCondition> execute() throws Exception {        List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance()          .getCurrUserId(), "ZcEbProjCtrl_ProjTab");        return needDisplaySearchConditonList;      }      @Override      public void success(List<SearchCondition> needDisplaySearchConditonList) {        List<TableDisplay> showingDisplays = SearchConditionUtil.getNeedDisplayTableDisplay(needDisplaySearchConditonList);        init(createDataDisplay(showingDisplays), null);//调用父类方法        revalidate();        repaint();      }    });    requestMeta.setCompoId(compoId);  }  private AbstractSearchConditionArea topSearchConditionArea;  private AbstractSearchConditionArea createTopConditionArea() {    Map defaultValueMap = new HashMap();    topSearchConditionArea = new SaveableSearchConditionArea("ZcEbProjCtrl_Proj", null, true, defaultValueMap, null);    return topSearchConditionArea;  }  private AbstractDataDisplay createDataDisplay(List<TableDisplay> showingDisplays) {    return new DataDisplay(SearchConditionUtil.getAllTableDisplay("ZcEbProjCtrl_ProjTab"), showingDisplays, createTopConditionArea(), true);//true:显示收索条件区 false：不显示收索条件区  }  private FuncButton printButton = new PrintButton();  private FuncButton printPreviewButton = new PrintPreviewButton();  private PrintSettingButton printSettingButton = new PrintSettingButton();  private FuncButton traceButton = new TraceButton();  private HelpButton helpButton = new HelpButton();  @Override  protected void addToolBarComponent(JFuncToolBar toolBar) {    toolBar.setModuleCode("ZC");    toolBar.setCompoId(compoId);    //    toolBar.add(traceButton);    //toolBar.add(printButton);    //toolBar.add(printPreviewButton);    //toolBar.add(printSettingButton);    toolBar.add(helpButton);    toolBar.add(traceDataButton);    traceButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        doTrace();      }    });    printButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrint();      }    });    printPreviewButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintPreview();      }    });    printSettingButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doPrintSetting();      }    });    traceDataButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        doTraceDataButton();      }    });  }  public void refreshCurrentTabData() {    topSearchConditionArea.doSearch();  }  public void refreshCurrentTabData(List beanList) {    topDataDisplay.getActiveTableDisplay().getTable().setModel(ZcEbProjectToTableModelConverter.convertToTableModel(beanList));  }  public List<ZcEbProjPackVO> getCheckedList() {    List<ZcEbProjPackVO> beanList = new ArrayList<ZcEbProjPackVO>();    JGroupableTable table = topDataDisplay.getActiveTableDisplay().getTable();    MyTableModel model = (MyTableModel) table.getModel();    List<ZcEbProjPackVO> list = model.getList();    Integer[] checkedRows = table.getCheckedRows();    for (Integer checkedRow : checkedRows) {      int accordDataRow = table.convertRowIndexToModel(checkedRow);      ZcEbProjPackVO bean = list.get(accordDataRow);      beanList.add(bean);    }    return beanList;  }  private void doTrace() {    ZcUtil.showTraceDialog(getCheckedList(), this);  }  private void doPrint() {    List<ZcEbProjPackVO> printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printButton.getFuncId());    requestMeta.setPageType(ZcEbProjectControlListPanel.compoId + "_L");    boolean success = true;    boolean printed = false;    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      if (Printer.print(printObject)) {        // ZcUtil.browse(URI.create("http://www.sina.com"));        printed = true;      }    } catch (Exception e) {      success = false;      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }    if (success && printed) {    }  }  private void doPrintPreview() {    final List<ZcEbProjPackVO> printList = getCheckedList();    if (printList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择需要打印预览的数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    }    requestMeta.setFuncId(this.printPreviewButton.getFuncId());    requestMeta.setPageType(ZcEbProjectControlListPanel.compoId + "_L");    try {      PrintObject printObject = this.baseDataServiceDelegate.genMainBillPrintObjectFN(printList, requestMeta);      PrintPreviewer previewer = new PrintPreviewer(printObject) {        protected void afterSuccessPrint() {        }      };      previewer.preview();    } catch (Exception e) {      logger.error(e.getMessage(), e);      JOptionPane.showMessageDialog(this, "打印预览出错！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);    }  }  private void doPrintSetting() {    requestMeta.setFuncId(this.printSettingButton.getFuncId());    requestMeta.setPageType(ZcEbProjectControlListPanel.compoId + "_L");    new PrintSettingDialog(requestMeta);  }  private void doTraceDataButton() {    List beanList = getCheckedList();    if (beanList.size() == 0) {      JOptionPane.showMessageDialog(this, "请选择一条要进行跟踪的数据！", "错误", JOptionPane.ERROR_MESSAGE);      return;    }    ZcEbProjPackVO sh = (ZcEbProjPackVO) beanList.get(0);    DataFlowConsoleCanvas dfc = new DataFlowConsoleCanvas(sh.getProjCode(), this.compoId);    dfc.showWindow();  }  public static void main(String[] args) {    SwingUtilities.invokeLater(new Runnable() {      public void run() {        try {          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());          UIManager.setLookAndFeel(new BlueLookAndFeel());        } catch (Exception e) {          e.printStackTrace();        }        ZcEbProjectControlListPanel bill = new ZcEbProjectControlListPanel();        JFrame frame = new JFrame("frame");        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        frame.setSize(800, 600);        frame.setLocationRelativeTo(null);        frame.getContentPane().add(bill);        frame.setVisible(true);      }    });  }}