package com.ufgov.zc.client.component.table.cellrenderer;import java.awt.Component;import javax.swing.JLabel;import javax.swing.JTable;import javax.swing.table.DefaultTableCellRenderer;import javax.swing.table.TableCellRenderer;public class TopAlignTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {  private static final long serialVersionUID = 6661718059329644534L;  public TopAlignTableCellRenderer() {    this.setVerticalAlignment(JLabel.TOP);  }  public Component getTableCellRendererComponent(final JTable table, Object value,  boolean isSelected, boolean hasFocus, final int row, int column) {    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  }}