package com.ufgov.zc.client.component.ui.conditionitem;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JComponent;import com.ufgov.zc.client.component.element.OriginComboBox;public class OriginComboboxConditionItem extends AbstractSearchConditionItem {  private String dataRuleId;  public OriginComboboxConditionItem(String displayName) {    init(displayName);  }  public OriginComboboxConditionItem(String displayName, String dataRuleId) {    this.dataRuleId = dataRuleId;    init(displayName);  }  private OriginComboBox originComboBox;  @Override  protected JComponent createEditorComponent() {    if (originComboBox == null) {      originComboBox = new OriginComboBox(dataRuleId);      originComboBox.initComboBox();      originComboBox.addActionListener(new ActionListener() {        public void actionPerformed(ActionEvent e) {          fireSearch();          fireValueChanged();        }      });    }    return originComboBox;  }  @Override  public void setValue(Object value) {    originComboBox.setSelectedItem(value);  }  @Override  public Object getValue() {    return originComboBox.getSelectedItem();  }}