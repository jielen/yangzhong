package com.ufgov.zc.client.component.ui.conditionitem;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JComboBox;import javax.swing.JComponent;import com.ufgov.zc.common.system.dto.ElementConditionDto;public class CreateTypeComboBoxConditionItem extends AbstractSearchConditionItem {  private static final long serialVersionUID = -2555370855456075787L;  private JComboBox comboBox;  public CreateTypeComboBoxConditionItem(String displayName) {    init(displayName);  }  public CreateTypeComboBoxConditionItem(String displayName, Object defaultValue) {    init(displayName);    if (defaultValue != null)      setValue(defaultValue);  }  @Override  protected JComponent createEditorComponent() {    if (comboBox == null) {      comboBox = new JComboBox();      comboBox.addItem("调整");      comboBox.addItem("往来");      comboBox.addItem("预拨");    }    comboBox.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        fireSearch();        fireValueChanged();      }    });    return comboBox;  }  @Override  public Object getValue() {    return comboBox.getSelectedItem();  }  @Override  public void setValue(Object value) {    comboBox.setSelectedItem(value);  }  // 待处理  public void putToElementConditionDto(ElementConditionDto element) {    String type = getValue().toString();    //    if(type.equals("调整"))    //      element.setIsCreateVou(null);    //    else if(type.equals("往来"))    //      element.setIsCreateVou("1");    //    else if(type.equals("预拨"))    //      element.setIsCreateVou("0");  }}