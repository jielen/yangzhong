package com.ufgov.zc.client.component.ui.fieldeditor;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JComponent;import com.ufgov.zc.client.component.element.DAttrComboBox;import com.ufgov.zc.common.commonbiz.model.BaseBill;import com.ufgov.zc.common.commonbiz.model.DAttr;public class DAttrComboBoxFieldEditor extends AbstractFieldEditor {  private static final long serialVersionUID = -4691003073875144404L;  private DAttrComboBox editField;  private String dattrType;  private String compoId;  public DAttrComboBoxFieldEditor(String name) {    init(name);  }  public DAttrComboBoxFieldEditor(String name, String dattrType, String compoId) {    this.dattrType = dattrType;    this.compoId = compoId;    init(name);  }  public DAttrComboBoxFieldEditor(String name, boolean isEnabled) {    init(name);    editField.setEnabled(isEnabled);    editField.setEditable(isEnabled);  }  protected JComponent createEditorComponent() {    editField = new DAttrComboBox(this.dattrType, compoId);    editField.initComboBox();    editField.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        syncObject();      }    });    return editField;  }  /**   * 同步到对象   */  private void syncObject() {    if (getEditObject() instanceof BaseBill) {      BaseBill bill = (BaseBill) getEditObject();      if (bill != null) {        DAttr dAttr = editField.getSelectedDAttr();        String dAttrCode = dAttr == null ? null : dAttr.getCode();        if ("01".equals(dattrType)) {          bill.setDattr1(dAttrCode);        } else if ("02".equals(dattrType)) {          bill.setDattr2(dAttrCode);        } else if ("03".equals(dattrType)) {          bill.setDattr3(dAttrCode);        } else if ("04".equals(dattrType)) {          bill.setDattr4(dAttrCode);        } else if ("05".equals(dattrType)) {          bill.setDattr5(dAttrCode);        }      }    }    this.fireEditSynced();  }  public Object getValue() {    return editField.getSelectedDAttr();  }  public void setValue(Object value) {    if (value == null) {      editField.setSelectedItem(null);    } else if (value instanceof BaseBill) {      BaseBill bill = (BaseBill) value;      String code = null;      if ("01".equals(dattrType)) {        code = bill.getDattr1();      } else if ("02".equals(dattrType)) {        code = bill.getDattr2();      } else if ("03".equals(dattrType)) {        code = bill.getDattr3();      } else if ("04".equals(dattrType)) {        code = bill.getDattr4();      } else if ("05".equals(dattrType)) {        code = bill.getDattr5();      }      editField.setSelectedDAttrByCode(code);    }  }  public void setPrefix(String prefix) {    editField.setPrefix(prefix);  }  public void setCtrlLevelNum(int ctrlLevelNum) {    editField.setCtrlLevelNum(ctrlLevelNum);  }  public void setRandomEdit(boolean randomEdit) {    editField.setRandomEdit(randomEdit);  }  public String getDattrType() {    return editField.getDattrType();  }  public void setBillForRelation(BaseBill bill) {    if (editField != null) {      editField.setBill(bill);    }  }  @Override  public void setFieldEditorCode() {    if ("01".equals(dattrType)) {      this.FieldEditorCode = FieldEditorCodeConstants.D_ATTR1;    } else if ("02".equals(dattrType)) {      this.FieldEditorCode = FieldEditorCodeConstants.D_ATTR2;    } else if ("03".equals(dattrType)) {      this.FieldEditorCode = FieldEditorCodeConstants.D_ATTR3;    } else if ("04".equals(dattrType)) {      this.FieldEditorCode = FieldEditorCodeConstants.D_ATTR4;    } else if ("05".equals(dattrType)) {      this.FieldEditorCode = FieldEditorCodeConstants.D_ATTR5;    }  }}