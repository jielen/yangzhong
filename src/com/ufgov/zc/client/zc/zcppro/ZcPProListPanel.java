package com.ufgov.zc.client.zc.zcppro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import com.ufgov.zc.client.common.BillElementMeta;
import com.ufgov.zc.client.common.LangTransMeta;
import com.ufgov.zc.client.common.MyTableModel;
import com.ufgov.zc.client.common.ParentWindowAware;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.common.converter.zc.ZcPProToTableModelConverter;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.ui.AbstractDataDisplay;
import com.ufgov.zc.client.component.ui.AbstractEditListBill;
import com.ufgov.zc.client.component.ui.AbstractSearchConditionArea;
import com.ufgov.zc.client.component.ui.MultiDataDisplay;
import com.ufgov.zc.client.component.ui.SaveableSearchConditionArea;
import com.ufgov.zc.client.component.ui.TableDisplay;
import com.ufgov.zc.client.component.ui.conditionitem.AbstractSearchConditionItem;
import com.ufgov.zc.client.component.ui.conditionitem.SearchConditionUtil;
import com.ufgov.zc.client.util.ListUtil;
import com.ufgov.zc.common.commonbiz.model.SearchCondition;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.ZcSettingConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.util.ObjectUtil;
import com.ufgov.zc.common.zc.model.ZcPPro;
import com.ufgov.zc.common.zc.publish.IZcPProDelegate;

public class ZcPProListPanel extends AbstractEditListBill implements ParentWindowAware {

  private static final Logger logger = Logger.getLogger(ZcPProListPanel.class);

  private ZcPProListPanel self = this;

  private Window parentWindow;

  private String compoId = "ZC_P_PRO";

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private ElementConditionDto elementConditionDto = new ElementConditionDto();

  private IZcPProDelegate zcPProDelegate = (IZcPProDelegate) ServiceFactory.create(IZcPProDelegate.class,
    "zcPProDelegate");

  public Window getParentWindow() {
    return parentWindow;
  }

  public void setParentWindow(Window parentWindow) {
    this.parentWindow = parentWindow;
  }

  private final class DataDisplay extends MultiDataDisplay {
    private DataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays, AbstractSearchConditionArea conditionArea,
      boolean showConditionArea) {
      super(displays, showingDisplays, conditionArea, showConditionArea, ZcSettingConstants.TAB_ID_ZC_P_PRO);
      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta
        .translate(ZcSettingConstants.FIELD_TRANS_ZC_P_PRO_TITLE), TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15),
        Color.BLUE));
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
              new ZcPProDialog(self, viewList, row, tabStatus);
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
      elementConditionDto.setCoCode(requestMeta.getSvCoCode());
      elementConditionDto.setZcText0(requestMeta.getEmpCode());
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

          return ZcPProToTableModelConverter.convertToTableModel(self.zcPProDelegate.getZcPPro(elementConditionDto, requestMeta));

        }

        @Override
        public void success(TableModel model) {
          tableDisplay.setTableModel(model);
          setButtonsVisiable();
        }
      });
    }
  }

  static {
    LangTransMeta.init("ZC%");
  }

  /**
   * 构造函数
   */
  public ZcPProListPanel() {
    UIUtilities.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {
      @Override
      public List<SearchCondition> execute() throws Exception {
        List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance()
          .getCurrUserId(), ZcSettingConstants.TAB_ID_ZC_P_PRO);
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

  private AbstractSearchConditionArea topSearchConditionArea;

  private AbstractSearchConditionArea createTopConditionArea() {
    Map defaultValueMap = new HashMap();
    topSearchConditionArea = new SaveableSearchConditionArea(ZcSettingConstants.CONDITION_ID_ZC_P_PRO, null, false, defaultValueMap, null);
    return topSearchConditionArea;
  }

  private AbstractDataDisplay createDataDisplay(List<TableDisplay> showingDisplays) {
    return new DataDisplay(SearchConditionUtil.getAllTableDisplay(ZcSettingConstants.TAB_ID_ZC_P_PRO), showingDisplays, createTopConditionArea(),
      true);//true:显示收索条件区 false：不显示收索条件区
  }

  @Override
  protected void addToolBarComponent(JFuncToolBar toolBar) {
    toolBar.setModuleCode("ZC");
    toolBar.setCompoId(compoId);
    toolBar.add(addButton);
//    toolBar.add(editButton);
    toolBar.add(deleteButton);
    toolBar.add(helpButton);

    // 初始化按钮的action事件

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doAdd();
      }
    });

    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doDelete();
      }
    });

  }

  public void refreshCurrentTabData() {
    topSearchConditionArea.doSearch();
  }

  public List<ZcPPro> getCheckedList() {
    List<ZcPPro> beanList = new ArrayList<ZcPPro>();
    JGroupableTable table = topDataDisplay.getActiveTableDisplay().getTable();
    MyTableModel model = (MyTableModel) table.getModel();
    //Modal的数据
    List list = model.getList();
    Integer[] checkedRows = table.getCheckedRows();
    for (Integer checkedRow : checkedRows) {
      int accordDataRow = table.convertRowIndexToModel(checkedRow);
      ZcPPro bean = (ZcPPro) list.get(accordDataRow);
      beanList.add(bean);
    }
    return beanList;
  }

  private void doAdd() {
    new ZcPProDialog(self, new ArrayList(1), -1, topDataDisplay.getActiveTableDisplay().getStatus());
  }

  private void doDelete() {
    List beanList = this.getCheckedList();
    if (beanList.size() == 0) {
      JOptionPane.showMessageDialog(this, "没有选择数据！", "提示", JOptionPane.ERROR_MESSAGE);
      return;
    }
    int num = JOptionPane.showConfirmDialog(this, "是否删除当前单据", "删除确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      ZcPPro zcPPro = null;
      String errorInfo = "";
      try {
        requestMeta.setFuncId(deleteButton.getFuncId());
        for (int i = 0; i < beanList.size(); i++) {
          zcPPro = (ZcPPro) beanList.get(i);
          this.self.zcPProDelegate.deleteZcPPro(zcPPro.getChrId(), requestMeta);
        }
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        success = false;
        errorInfo += e.getMessage();
      }
      if (success) {
        JOptionPane.showMessageDialog(this, "删除成功 ！\n", "提示", JOptionPane.INFORMATION_MESSAGE);

        this.refreshCurrentTabData();
      } else {
        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
      }
    }
  }


  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          UIManager.setLookAndFeel(new BlueLookAndFeel());
        } catch (Exception e) {
          e.printStackTrace();
        }
        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());
        ZcPProListPanel bill = new ZcPProListPanel();
        JFrame frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(bill);
        frame.setVisible(true);
      }
    });

  }

  public void setButtonsVisiable() {
	  this.addButton.setVisible(true);
	  this.editButton.setVisible(true);
	  this.deleteButton.setVisible(true);
  }

  private BillElementMeta billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(compoId);

  public BillElementMeta getBillElementMeta() {
    return billElementMeta;
  }

}
