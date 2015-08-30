package com.ufgov.zc.client.component.ui.fieldeditor;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JComponent;import com.ufgov.zc.client.common.BillElementMeta;import com.ufgov.zc.client.component.element.OrgComboBox;import com.ufgov.zc.common.commonbiz.model.BaseBill;import com.ufgov.zc.common.commonbiz.model.Org;import com.ufgov.zc.common.cp.model.CpApply;public class OrgFieldEditor extends AbstractFieldEditor {  private static final long serialVersionUID = 1L;  private OrgComboBox orgField;  public OrgFieldEditor(String name) {    super(name);  }  public OrgFieldEditor(String name, boolean isEnabled) {    super(name);    orgField.setEnabled(isEnabled);  }  public OrgFieldEditor(Object curData, BillElementMeta preBem, BillElementMeta curBem, String name,  boolean isEnabled) {    super(name, curData, preBem);    orgField.setEnabled(isEnabled);  }  protected JComponent createEditorComponent() {    orgField = new OrgComboBox();    orgField.initComboBox();    orgField.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        syncObject();      }    });    return orgField;  }  /**   * 同步到对象   */  private void syncObject() {    if (getEditObject() instanceof BaseBill) {      BaseBill bill = (BaseBill) getEditObject();      if (bill != null) {        Org value = orgField.getSelectedOrg();        bill.setOrgCode(value == null ? null : value.getCode());      }    }    if (getEditObject() instanceof CpApply) {      CpApply bill = (CpApply) getEditObject();      if (bill != null) {        Org value = orgField.getSelectedOrg();        bill.setCounterSigner(value == null ? null : value.getCode());      }    }    this.fireEditSynced();  }  public Object getValue() {    return orgField.getSelectedOrg();  }  public void setValue(Object value) {    if (value == null) {      orgField.setSelectedItem(null);    } else if (value instanceof BaseBill) {      BaseBill bill = (BaseBill) value;      orgField.setSelectedOrgByCode(bill.getOrgCode());    } else if (value instanceof CpApply) {      CpApply bill = (CpApply) value;      orgField.setSelectedOrgByCode(bill.getCounterSigner());    }  }  public void setFieldEditorCode() {    this.FieldEditorCode = FieldEditorCodeConstants.ORG_CODE;  }}