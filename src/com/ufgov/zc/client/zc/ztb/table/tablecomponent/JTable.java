package com.ufgov.zc.client.zc.ztb.table.tablecomponent;import com.ufgov.zc.client.zc.ztb.table.tablecomponent.checkbox.JTableCheckBoxEditor;import javax.swing.*;import javax.swing.table.DefaultTableCellRenderer;import javax.swing.table.JTableHeader;import javax.swing.table.TableColumn;import javax.swing.table.TableColumnModel;import java.awt.*;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;public class JTable extends javax.swing.JTable {  public JTable() {    initTable();  }  private void initTable() {    setRowHeight(26);    setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);    setIntercellSpacing(new Dimension(1, 1));    Dimension viewSize = new Dimension();    viewSize.width = getColumnModel().getTotalColumnWidth();    viewSize.height = 10 * getRowHeight();    setPreferredScrollableViewportSize(viewSize);    addTableHeaderRightMouseListener();    addTableRightMouseListener();    setTableHeaderRender();  }  protected void addTableHeaderRightMouseListener() {    getTableHeader().addMouseListener(new MouseAdapter() {      public void mouseClicked(MouseEvent e) {        showPopupMenu(e);      }    });  }  protected void addTableRightMouseListener() {    addMouseListener(new MouseAdapter() {      public void mouseClicked(MouseEvent e) {        showPopupMenu(e);      }    });  }  protected void setTableHeaderRender() {    JTableHeader tableHeader = getTableHeader();    tableHeader.setDefaultRenderer(new DefaultTableCellRenderer() {      @Override      public Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);        JTableHeader header = table.getTableHeader();        setHorizontalAlignment(JLabel.CENTER);        setForeground(header.getForeground());        setBackground(header.getBackground());        setFont(header.getFont());        setBorder(UIManager.getBorder("TableHeader.cellBorder"));        return this;      }    });  }  protected void showPopupMenu(MouseEvent e) {    if (1 == 1) {      return;//暂不做任何操作    }    if (SwingUtilities.isRightMouseButton(e)) {      JPopupMenu popupMenu = getPopupMenu();      if (popupMenu != null) {        popupMenu.show(e.getComponent(), e.getX(), e.getY());      }    }  }  protected JPopupMenu getPopupMenu() {    JPopupMenu popupMenu = new JPopupMenu();    JCheckBoxMenuItem menuItem;    TableColumnModel tableColumnModel = getColumnModel();    int columnCount = tableColumnModel.getColumnCount();    TableColumn tableColumn;    String name;    for (int i = 0; i < columnCount; i++) {      tableColumn = tableColumnModel.getColumn(i);      name = (String) tableColumn.getHeaderValue();      if (name == null || name.trim().length() == 0) {        continue;      }      menuItem = new JCheckBoxMenuItem(name);      if (tableColumn.getMaxWidth() == 0) {        menuItem.setSelected(false);      } else {        menuItem.setSelected(true);      }      menuItem.setActionCommand(String.valueOf(tableColumn.getIdentifier()));      menuItem.addActionListener(new RightMouseActionListener());      popupMenu.add(menuItem);    }    return popupMenu;  }  public int[] getCheckSelectRows() {    int allRows = getRowCount();    int[] rvTmp = new int[allRows];    int n = 0;    for (int i = 0; i < allRows; i++) {      if (JTableCheckBoxEditor.IS_SELECT_STAT.equals(getModel().getValueAt(convertRowIndexToModel(i),        getColumnModel().getColumnIndex("TABLE.CHECKBOX")))) {        rvTmp[n++] = i;      }    }    int[] checkSelectRows = new int[n];    System.arraycopy(rvTmp, 0, checkSelectRows, 0, n);    return checkSelectRows;  }  public void removeRow(int tableRowIndex) {    ((JTableModel) getModel()).removeRow(convertRowIndexToModel(tableRowIndex));  }  class RightMouseActionListener implements ActionListener {    public void actionPerformed(ActionEvent e) {      if (e.getSource() instanceof JCheckBoxMenuItem) {        JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();        if (menuItem.isSelected()) {          showColumn(getColumnModel().getColumnIndex(menuItem.getActionCommand()));        } else {          hideColumn(getColumnModel().getColumnIndex(menuItem.getActionCommand()));        }      }    }    public void hideColumn(int index) {      JTableColumn tableColumn = (JTableColumn) getColumnModel().getColumn(index);      tableColumn.setDefaultWidth(tableColumn.getWidth());      tableColumn.setMinWidth(0);      tableColumn.setMaxWidth(0);    }    public void showColumn(int index) {      JTableColumn tableColumn = (JTableColumn) getColumnModel().getColumn(index);      tableColumn.setMaxWidth(1000);      tableColumn.setMinWidth(15);      tableColumn.setPreferredWidth(tableColumn.getDefaultWidth());    }  }  public Object getValueAt(int row, int column) {    try {      return super.getValueAt(row, column);    } catch (Exception e) {      System.out.println("row:" + row);    }    return "";  }}