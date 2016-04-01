/** * ForeignEntityDialog.java com.ufgov.gk.client.component.zc.fieldeditor * Administrator 2010-4-30 */package com.ufgov.zc.client.component.zc.fieldeditor;import java.awt.Dialog;import java.awt.Dimension;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.util.ArrayList;import java.util.List;import javax.swing.JOptionPane;import javax.swing.JTable;import javax.swing.SwingUtilities;import javax.swing.table.TableRowSorter;import org.apache.commons.beanutils.MethodUtils;import org.apache.log4j.Logger;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.component.JButtonTextField;import com.ufgov.zc.client.component.JTableSelectDialog;import com.ufgov.zc.client.util.GkPreferencesStore;import com.ufgov.zc.client.zc.zcebsupplier.ZcEbSupplierDialog;import com.ufgov.zc.client.zc.zcpromakeouter.ZcEbProMakeOuterDialog;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.BeanUtil;import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;import com.ufgov.zc.common.zc.model.ZcBaseBill;import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;/** * @author Administrator */public class ForeignEntityDialog extends JTableSelectDialog {  private String fieldName;  private Logger log = Logger.getLogger(ForeignEntityDialog.class);  private int openAddDialogType = ZcSettingConstants.FOREIGNENTITY_BASE;  /**   *    */  private static final long serialVersionUID = -5603007275009072098L;  private IForeignEntityHandler handler;  public ForeignEntityDialog(Dialog dialog, boolean modal, JButtonTextField triggerField, IForeignEntityHandler handler, String sqlMapSelectedId,  String title) {    super(dialog, modal, triggerField, sqlMapSelectedId, title);    //    System.out.println("the title is "+title);    this.handler = handler;    // TCJLODO Auto-generated constructor stub  }  public ForeignEntityDialog(Dialog dialog, boolean modal, JButtonTextField triggerField, IForeignEntityHandler handler, String sqlMapSelectedId,  ElementConditionDto elementConditionDto, String title) {    super(dialog, modal, triggerField, sqlMapSelectedId, elementConditionDto, title);    this.handler = handler;  }  public ForeignEntityDialog(Dialog dialog, boolean modal, ForeignEntityField triggerField, IForeignEntityHandler handler, String sqlMapSelectedId,  ElementConditionDto elementConditionDto, String title, int dialogType) {    super(dialog, modal, triggerField, sqlMapSelectedId, elementConditionDto, title, dialogType);    this.handler = handler;    this.openAddDialogType = dialogType;  }  public ForeignEntityDialog(Dialog dialog, boolean modal, ForeignEntityField triggerField, IForeignEntityHandler handler, String sqlMapSelectedId,  ElementConditionDto elementConditionDto, String title, String fieldName) {    super(dialog, modal, triggerField, sqlMapSelectedId, elementConditionDto, title);    this.fieldName = fieldName;    this.handler = handler;    this.elementConditionDto = elementConditionDto;  }  /**   * 新增构造方法，数据集合通过传递而来，不需要查询。   */  public ForeignEntityDialog(Dialog dialog, boolean modal, ForeignEntityField triggerField, IForeignEntityHandler handler, String title, String fieldName, List dataBufferList) {    super(dialog, modal, triggerField, null, null, title);    this.dataBufferList = dataBufferList;    this.numLimDataList = dataBufferList;    this.fieldName = fieldName;    this.handler = handler;  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.JTableSelectDialog#doOK()   */  @Override  public void doOK() {    // TCJLODO Auto-generated method stub    int selectedRowCount = 0;    if (this.handler.isMultipleSelect()) {      selectedRowCount = selectTable.getCheckedRows().length;    } else {      selectedRowCount = selectTable.getSelectedRowCount();    }    if (selectedRowCount == 0) {      JOptionPane.showMessageDialog(self, "请选数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    } else if (selectedRowCount > 1 && !this.handler.isMultipleSelect()) {      JOptionPane.showMessageDialog(self, "只能选择一条数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);      return;    } else {      List selectedDatas = new ArrayList();      if (this.handler.isMultipleSelect()) {        Integer[] selectedRows = selectTable.getCheckedRows();        for (int i = 0; i < selectedRows.length; i++) {          selectedDatas.add(tableDataList.get(selectTable.convertRowIndexToModel(selectedRows[i])));        }      } else {        int selectedRow = selectTable.convertRowIndexToModel(selectTable.getSelectedRow());        Object obj = tableDataList.get(selectedRow);        if (fieldName != null) {          triggerField.setValue(BeanUtil.get(fieldName, obj));        } else {          triggerField.setValue(obj);        }        selectedDatas.add(obj);      }      this.handler.excute(selectedDatas);    }    this.closeDialog();  }  @Override  public void doClear() {    this.triggerField.setValue(null);    this.selectTable.clearSelection();    try {      // 反射调用handler实现类的afterClear方法，为了兼容以前的接口!      // afterClear方法主要是在实现类中做清空后的操作。      MethodUtils.invokeMethod(this.handler, "afterClear", null);    } catch (Exception ex) {    }    this.closeDialog();  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.JTableSelectDialog#initTitle()   */  @Override  public void initTitle() {    //    LangTransMeta.init("ZC%");  }  public void initDataBufferList() {    if (this.sqlMapSelectedId == null) { return; }    int nd = WorkEnv.getInstance().getTransNd();    IZcEbBaseServiceDelegate baseDataServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,    "zcEbBaseServiceDelegate");    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();    if (this.elementConditionDto == null) {      this.elementConditionDto = new ElementConditionDto();      this.elementConditionDto.setNd(nd);    }    this.dataBufferList = baseDataServiceDelegate.getForeignEntitySelectedData(this.sqlMapSelectedId, this.elementConditionDto, requestMeta);    if (this.elementConditionDto.getNumLimitStr() == null && this.elementConditionDto.getDataRuleCondiStr() == null) {      numLimDataList = dataBufferList;    } else {      numLimDataList = baseDataServiceDelegate.getForeignEntitySelectedData(this.sqlMapSelectedId, this.elementConditionDto, requestMeta);    }  }  private List genTableData() {    return dataBufferList;  }  public void initSelectTable() {    tableDataList = genTableData();    selectTable.setPreferencesKey(this.getClass().getName() + "_selectTable");    selectTable.setPreferenceStore(GkPreferencesStore.preferenceStore());    selectTable.setShowCheckedColumn(this.handler.isMultipleSelect());    selectTable.getTableRowHeader().setPreferredSize(new Dimension(80, 0));    selectTable.setModel(this.handler.createTableModel(genTableData()));    this.fitTable(selectTable);    if (selectTable.getMouseListeners().length <= 2) {      selectTable.addMouseListener(new MouseAdapter() {        public void mouseClicked(MouseEvent e) {          if (e.getClickCount() == 2) {            doOK();          }        }      });    }    selectTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  }  public void updateDto(ElementConditionDto dto) {    // TCJLODO Auto-generated method stub    this.elementConditionDto = dto;    this.initDataBufferList();  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.JTableSelectDialog#openAddDialog()   */  @Override  protected void openAddDialog() {    // TCJLODO Auto-generated method stub    if (this.openAddDialogType == ZcSettingConstants.FOREIGNENTITY_NEW_SUPPLIER) {      new ZcEbSupplierDialog(new ArrayList(), 1, "", this);    } else if (this.openAddDialogType == ZcSettingConstants.FOREIGNENTITY_NEW_PROMAKE) {      new ZcEbProMakeOuterDialog(new ArrayList(), 1, "", this);    }  }  /**   * 在选择时，通过新增按钮来新增一个时，更新当前的数据   * @param newValue Administrator 2010-5-18   */  public void refresh(ZcBaseBill newValue) {    this.initDataBufferList();    this.initSelectTable();    this.searchField.setText("");    this.selectTableSorter = new TableRowSorter(selectTable.getModel());    this.selectTable.setRowSorter(selectTableSorter);    //   System.out.println(this.tableDataList.contains(newValue));    selectTable.clearSelection();    if (newValue != null) {      //     tableDataList.add(newValue);      //     this.selectTable.setModel(this.handler.createTableModel(tableDataList));      //     this.selectTableSorter = new TableRowSorter(selectTable.getModel());      //     this.selectTable.setRowSorter(selectTableSorter);      int row = tableDataList.indexOf(newValue);      if (row >= 0) {        selectTable.addRowSelectionInterval(row, row);        SwingUtilities.invokeLater(new Runnable() {          public void run() {            scrollToRow(selectTable.getSelectedRow());          }        });      }    }  }}