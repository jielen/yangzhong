package com.ufgov.zc.client.component;import java.awt.BorderLayout;import java.awt.Container;import java.awt.Dialog;import java.awt.FlowLayout;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.KeyAdapter;import java.awt.event.KeyEvent;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.awt.event.WindowAdapter;import java.awt.event.WindowEvent;import java.util.ArrayList;import java.util.List;import javax.swing.JButton;import javax.swing.JLabel;import javax.swing.JPanel;import javax.swing.JScrollPane;import javax.swing.JTable;import javax.swing.JTextField;import javax.swing.JToolBar;import javax.swing.table.DefaultTableModel;import javax.swing.table.TableRowSorter;import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.util.GkPreferencesStore;import com.ufgov.zc.client.util.SwingUtil;import com.ufgov.zc.common.commonbiz.model.DpBalance;import com.ufgov.zc.common.commonbiz.publish.IDpBalanceServiceDelegate;import com.ufgov.zc.common.system.RequestMeta;public abstract class AbstractDpBalanceSelectDialog extends GkBaseDialog {  protected Dialog dialogOwner;  protected AbstractDpBalanceSelectDialog self = this;  protected JTextField searchField = new JTextField(30);  private TableRowSorter selectTableSorter;  protected JPageableFixedTable selectTable = SwingUtil.createTable(JPageableFixedTable.class);  protected JScrollPane selectTablePane = new JScrollPane();  private JLabel searchLabel = new JLabel("查找");  protected JPanel bottomPanel = new JPanel();  protected JButton okButton = new JButton("确定");  protected JButton clearButton = new JButton("清空");  protected JButton cancelButton = new JButton("取消");  protected List dataBufferList = new ArrayList();  protected List tableDataList = new ArrayList();  public AbstractDpBalanceSelectDialog(Dialog superDialog, boolean modal) {    super(superDialog, modal);    dialogOwner = superDialog;    init();  }  private void init() {    initDataBufferList();    initSelectTable();    this.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        selectTable.savePreferences();      }    });    Container contentPane = this.getContentPane();    contentPane.setLayout(new BorderLayout());    this.initSearchBar();    selectTablePane.getViewport().add(selectTable);    this.initBottomPanel();    contentPane.add(searchBar, BorderLayout.NORTH);    contentPane.add(selectTablePane, BorderLayout.CENTER);    contentPane.add(bottomPanel, BorderLayout.SOUTH);    this.setSize(500, 380);    this.setVisible(true);    moveToScreenCenter();  }  protected JToolBar searchBar = new JToolBar() {    {      this.setFloatable(false);      this.setLayout(new FlowLayout(FlowLayout.LEFT));    }  };  private void initSearchBar() {    searchBar.add(searchLabel);    searchBar.add(searchField);    searchField.addKeyListener(new KeyAdapter() {      public void keyReleased(KeyEvent e) {        selectTableSorter.setRowFilter(new SimpleRowFilter(searchField.getText()));        self.repaint();      }    });  }  private void initBottomPanel() {    bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));    bottomPanel.add(okButton);    bottomPanel.add(cancelButton);    cancelButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        closeDialog();      }    });    okButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        self.doOK();      }    });  }  protected void initDataBufferList() {    String dpBalanceServiceName = "dpBalanceService";    IDpBalanceServiceDelegate dpBalanceService = (IDpBalanceServiceDelegate) ServiceFactory.create(    IDpBalanceServiceDelegate.class, dpBalanceServiceName);    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();    dataBufferList = dpBalanceService.getDpBalance(requestMeta);  }  private List genTableData() {    return dataBufferList;  }  private void initSelectTable() {    String[] names = { "计划余额表ID", "计划可用金额", "功能分类名称", "预算单位名称", "资金性质名称", "管理类型名称",    "科处室名称", "指标来源名称", "经费分类名称", "支出类型名称", "支付方式名称", "项目名称", "项目类别名称" };    Object[][] data = null;    tableDataList = this.genTableData();    data = new Object[tableDataList.size()][names.length];    for (int i = 0; i < tableDataList.size(); i++) {      DpBalance rowData = (DpBalance) tableDataList.get(i);      int col = 0;      data[i][col++] = rowData.getDpBalanceId();      data[i][col++] = rowData.getBalance();      data[i][col++] = rowData.getBaccName();      data[i][col++] = rowData.getCoName();      data[i][col++] = rowData.getFundName();      data[i][col++] = rowData.getManageName();      data[i][col++] = rowData.getOrgName();      data[i][col++] = rowData.getOriginName();      data[i][col++] = rowData.getOutlayName();      data[i][col++] = rowData.getPayoutName();      data[i][col++] = rowData.getPaytypeName();      data[i][col++] = rowData.getProjectName();      data[i][col++] = rowData.getProjectTypeCode();    }    DefaultTableModel model = new DefaultTableModel(data, names) {      public boolean isCellEditable(int row, int colum) {        return false;      }    };    selectTable.setPreferencesKey(this.getClass().getName() + "_selectTable");    selectTable.setPreferenceStore(GkPreferencesStore.preferenceStore());    selectTable.setModel(model);    this.selectTableSorter = new TableRowSorter(selectTable.getModel());    this.selectTable.setRowSorter(selectTableSorter);    selectTable.addMouseListener(new MouseAdapter() {      public void mouseClicked(MouseEvent e) {        if (e.getClickCount() == 2) {          doOK();        }      }    });    selectTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  }  public void closeDialog() {    self.setVisible(false);    self.dispose();  }  protected abstract void doOK();}