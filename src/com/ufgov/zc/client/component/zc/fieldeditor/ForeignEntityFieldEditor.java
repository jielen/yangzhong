/** * ForeignEntityFieldPanel.java com.ufgov.gk.client.component.zc.fieldeditor * Administrator 2010-5-4 */package com.ufgov.zc.client.component.zc.fieldeditor;import java.awt.event.KeyAdapter;import java.awt.event.KeyEvent;import javax.swing.JComponent;import com.ufgov.zc.client.component.event.ValueChangeListener;import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.BeanUtil;import com.ufgov.zc.common.zc.foreignentity.IForeignEntityHandler;import com.ufgov.zc.common.zc.model.ZcBaseBill;/** * @author Administrator * */public class ForeignEntityFieldEditor extends AbstractFieldEditor {  protected String[] columNames;  protected int col;  protected ForeignEntityField field;  protected String name;  public ForeignEntityField getField() {    return field;  }  public ForeignEntityFieldEditor(String sqlMapSelectedId, int col, IForeignEntityHandler handler, String[] columNames, String name, String fieldName) {    super(name, sqlMapSelectedId, handler);    this.name = name;    this.sqlMapSelectedId = sqlMapSelectedId;    this.col = col;    this.columNames = columNames;    this.fieldName = fieldName;    field.setEditable(false);  }  public ForeignEntityFieldEditor(String sqlMapSelectedId, int col, IForeignEntityHandler handler, String[] columNames, String name, String fieldName, boolean canInput) {    super(name, sqlMapSelectedId, handler);    this.name = name;    this.sqlMapSelectedId = sqlMapSelectedId;    this.col = col;    this.columNames = columNames;    this.fieldName = fieldName;    field.setEditable(canInput);  }  public ForeignEntityFieldEditor(String sqlMapSelectedId, ElementConditionDto elementCondtiontDto, int col, IForeignEntityHandler handler,  String[] columNames, String name, String fieldName) {    super(name, sqlMapSelectedId, elementCondtiontDto, handler);    this.name = name;    this.sqlMapSelectedId = sqlMapSelectedId;    this.col = col;    this.columNames = columNames;    this.fieldName = fieldName;    field.setEditable(false);  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#createEditorComponent()   */  @Override  protected JComponent createEditorComponent() {    // TCJLODO Auto-generated method stub    //    System.out.println("createEditorComponent "+this.sqlMapSelectedId);    this.field = new ForeignEntityField(this.sqlMapSelectedId, this.elementConditionDto, this.col, this.handler, this.columNames, this.dialogTitle);    field.addKeyListener(new KeyAdapter() {      public void keyReleased(KeyEvent e) {        syncEditObject();      }    });    // 外部实体，编辑框中不允许输入，只有通过按钮选择。    field.setEditable(false);    return this.field;  }  protected void syncEditObject() {    if (getEditObject() != null) {      BeanUtil.set(fieldName, field.getText(), getEditObject());    }    this.fireEditSynced();  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#getValue()   */  @Override  public Object getValue() {    // TCJLODO Auto-generated method stub    return this.field.getText();  }  /* (non-Javadoc)   * @see com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor#setValue(java.lang.Object)   */  @Override  public void setValue(Object value) {//在选择的上面的行发生改变的时候所触发的事件    if (value == null) {      field.setText(null);      field.setToolTipText(null);    } else if (value instanceof ZcBaseBill) {      String v = (String) BeanUtil.get(fieldName, value);      field.setText(v);      if (v == null || v.trim().equals("")) {        field.setToolTipText(null);      } else {        field.setToolTipText(v);      }    }  }  public void updateDto(ElementConditionDto dto) {    this.field.updateDto(dto);    this.elementConditionDto = dto;  }  public void addValueChangeListener(ValueChangeListener valueChangeListener) {    // TCJLODO Auto-generated method stub    this.field.addValueChangeListener(valueChangeListener);  }  public void setEditable(boolean enabled) {    field.setEditable(enabled);  }  public void setEnabled(boolean enabled) {    //    field.setEditable(enabled);    field.chooseButton.setEnabled(enabled);    field.chooseButton.setVisible(enabled);  }}