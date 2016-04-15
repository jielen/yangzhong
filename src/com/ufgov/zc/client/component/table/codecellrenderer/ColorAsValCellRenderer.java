/**
 * ColorAsValCellRenderer.java
 * com.ufgov.gk.client.component.table.codecellrenderer Administrator Jul 6,
 * 2012
 */
package com.ufgov.zc.client.component.table.codecellrenderer;

import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;

import javax.swing.JTable;

import com.ufgov.zc.client.component.table.cellrenderer.LineWrapCellRenderer;
import com.ufgov.zc.client.datacache.AsValDataCache;

/**
 * 根据值集显示不同颜色
 * @author Administrator
 */
public class ColorAsValCellRenderer extends LineWrapCellRenderer {

  private String valSetId = null;

  private Hashtable<String, Color> colors = null;

  /**
   * @param valSetId
   * @param colors,颜色值集Hashtable，Hashtable的key是值集的val，Hashtable的value是颜色
   */
  public ColorAsValCellRenderer(String valSetId, Hashtable<String, Color> colors) {
    this.valSetId = valSetId;
    this.colors = colors;
  }

  private static final long serialVersionUID = 3184261311169929819L;

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    String name = null;
    Color foreGround = null;
    Color backGround = null;
    if (value != null) {
      name = AsValDataCache.getName(valSetId, value.toString());
      backGround = colors.get(value.toString());
      setBackground(backGround);
      this.setToolTipText("[" + value + "]" + name);
    } else {
      this.setToolTipText(null);
    }
    return super.getTableCellRendererComponentWithColor(table, name, isSelected, hasFocus, row, column, foreGround, backGround);
  }
}
