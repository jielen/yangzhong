package com.ufgov.zc.client.component.ui.conditionitem;import javax.swing.JComponent;import com.ufgov.zc.client.component.element.ProjectTableSelectField;import com.ufgov.zc.client.component.event.ValueChangeEvent;import com.ufgov.zc.client.component.event.ValueChangeListener;import com.ufgov.zc.common.commonbiz.model.Company;import com.ufgov.zc.common.commonbiz.model.Project;public class ProjectTableSelectFieldConditionItem extends AbstractSearchConditionItem {  private String compoId;  public ProjectTableSelectFieldConditionItem(String displayName) {    init(displayName);  }  public ProjectTableSelectFieldConditionItem(String displayName, String compoId) {    this.compoId = compoId;    init(displayName);  }  private ProjectTableSelectField projectTableSelectField;  protected JComponent createEditorComponent() {    if (projectTableSelectField == null) {      projectTableSelectField = new ProjectTableSelectField(20, compoId);      projectTableSelectField.addValueChangeListener(new ValueChangeListener() {        public void valueChanged(ValueChangeEvent e) {          Project value = projectTableSelectField.getProject();          String code = null;          if (value != null) {            code = value.getCode();          }          fireSearch();          fireValueChanged();        }      });    }    return projectTableSelectField;  }  public void setCompany(Company company) {    if (projectTableSelectField != null) {      projectTableSelectField.setCompany(company);    }  }  @Override  public void setValue(Object value) {    projectTableSelectField.setProject((Project) value);  }  @Override  public Object getValue() {    return projectTableSelectField.getProject();  }}