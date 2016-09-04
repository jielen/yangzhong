package com.ufgov.zc.client.component.zc.fieldeditor.emexperttype;import java.awt.Dialog;import java.util.ArrayList;import java.util.Enumeration;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.swing.JTree;import javax.swing.tree.DefaultMutableTreeNode;import javax.swing.tree.DefaultTreeModel;import javax.swing.tree.TreeNode;import javax.swing.tree.TreePath;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.component.JButtonTextField;import com.ufgov.zc.client.component.JTreeSelectDialog;import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.EmExpertTypeSelection;import com.ufgov.zc.common.zc.model.TreeNodeValueObject;import com.ufgov.zc.common.zc.publish.IZcEmExpertSelectionServiceDelegate;public class EmExpertTypeSelectionTreeSelectDialog extends JTreeSelectDialog {  protected TextFieldEditor triggerFieldName;  private boolean expand = false;  public EmExpertTypeSelectionTreeSelectDialog(Dialog dialog, boolean modal, JButtonTextField triggerField) {    super(dialog, modal, triggerField);    this.triggerFieldName = triggerFieldName;  }  public EmExpertTypeSelectionTreeSelectDialog(Dialog owner, boolean modal, EmExpertTypeSelectionTreeSelectField triggerField, boolean expandAll) {    super(owner, modal, triggerField);    this.triggerFieldName = triggerFieldName;    this.expand = expandAll;    // TODO Auto-generated constructor stub  }  private static final long serialVersionUID = -4407933154954926841L;  public void initTitle() {    LangTransMeta.init("ZC%");    this.setTitle("专家类别");  }  @SuppressWarnings("unchecked")  protected void initDataBufferList() {    IZcEmExpertSelectionServiceDelegate delegate = (IZcEmExpertSelectionServiceDelegate) ServiceFactory    .create(IZcEmExpertSelectionServiceDelegate.class, "zcEmExpertSelectionServiceDelegate");    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();    ElementConditionDto dto = new ElementConditionDto();    dataBufferList = delegate.getEmExpertTypeSelectionList(dto, requestMeta);    for (int i = 0; i < dataBufferList.size(); i++) {      EmExpertTypeSelection rowData = (EmExpertTypeSelection) dataBufferList.get(i);      this.triggerField.dataMap.put(rowData.getEmExpertType().getEmTypeCode(), rowData);    }    this.triggerField.filteredDataList = dataBufferList;  }  private List genTreeData() {    List filteredList = dataBufferList;    Map map = new HashMap();    for (Object o : filteredList) {      EmExpertTypeSelection cpy = (EmExpertTypeSelection) o;      map.put(cpy.getCode(), cpy);    }    List rootEmExpertTypeSelectionList = new ArrayList();    List childrenEmExpertTypeSelectionList = new ArrayList();    for (Object o : filteredList) {      TreeNodeValueObject cpy = (TreeNodeValueObject) o;      if (map.get(cpy.getParentCode()) == null) {        rootEmExpertTypeSelectionList.add(cpy);      } else {        childrenEmExpertTypeSelectionList.add(cpy);      }    }    Map childrenMap = new HashMap();    for (int i = 0; i < childrenEmExpertTypeSelectionList.size(); i++) {      TreeNodeValueObject child = (TreeNodeValueObject) childrenEmExpertTypeSelectionList.get(i);      List childrenList = (List) childrenMap.get(child.getParentCode());      if (childrenList != null) {        childrenList.add(child);      } else {        List tempList = new ArrayList();        tempList.add(child);        childrenMap.put(child.getParentCode(), tempList);      }    }    for (int i = 0; i < rootEmExpertTypeSelectionList.size(); i++) {      EmExpertTypeSelection company = (EmExpertTypeSelection) rootEmExpertTypeSelectionList.get(i);      this.setEmExpertTypeSelectionChildren(company, childrenMap);    }    return rootEmExpertTypeSelectionList;  }  protected void initSelectTree() {    DefaultMutableTreeNode root = new DefaultMutableTreeNode("专家类别");    initDataBufferList();    this.triggerField.filteredDataList = dataBufferList;//this.genFilterDataList()    List expertTypeTreeList = genTreeData();    treeNodeMap.clear();    for (Object o : expertTypeTreeList) {      TreeNodeValueObject nodeValueObj = (TreeNodeValueObject) o;      DefaultMutableTreeNode node = new DefaultMutableTreeNode(nodeValueObj);      root.add(node);      treeNodeMap.put(nodeValueObj, node);      this.setChildNode(nodeValueObj, node);    }    this.getSelectTree().setModel(new DefaultTreeModel(root));    if (expand) {      expandAll(getSelectTree(), new TreePath(root), expand);    }  }  private void setEmExpertTypeSelectionChildren(EmExpertTypeSelection company, Map childrenMap) {    List childrenList = (List) childrenMap.get(company.getCode());    if (childrenList != null) {      company.setChildrenList(childrenList);      for (int i = 0; i < childrenList.size(); i++) {        EmExpertTypeSelection c = (EmExpertTypeSelection) childrenList.get(i);        setEmExpertTypeSelectionChildren(c, childrenMap);      }    }  }  private void setChildNode(TreeNodeValueObject nodeValueObj, DefaultMutableTreeNode node) {    if (nodeValueObj.getChildrenList().size() > 0) {      for (Object o : nodeValueObj.getChildrenList()) {        TreeNodeValueObject c = (TreeNodeValueObject) o;        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(c);        node.add(childNode);        treeNodeMap.put(c, childNode);        setChildNode(c, childNode);      }    }  }  // 展开树的所有节点的方法  private static void expandAll(JTree tree, TreePath parent, boolean expand) {    TreeNode node = (TreeNode) parent.getLastPathComponent();    if (node.getChildCount() >= 0) {      for (Enumeration e = node.children(); e.hasMoreElements();) {        TreeNode n = (TreeNode) e.nextElement();        TreePath path = parent.pathByAddingChild(n);        expandAll(tree, path, expand);      }    }    if (expand) {      tree.expandPath(parent);    } else {      tree.collapsePath(parent);    }  }}