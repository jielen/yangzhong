package com.ufgov.zc.client.zc.ztb.component;import javax.swing.event.TreeModelEvent;import javax.swing.event.TreeModelListener;public class CheckBoxSeletionTreeModelListener implements TreeModelListener {  private CheckBoxSeletionTree checkBoxSeletionTree;  public CheckBoxSeletionTreeModelListener(CheckBoxSeletionTree checkBoxSeletionTree) {    this.checkBoxSeletionTree = checkBoxSeletionTree;  }  @Override  public void treeNodesInserted(TreeModelEvent e) {  }  @Override  public void treeNodesRemoved(TreeModelEvent e) {  }  @Override  public void treeStructureChanged(TreeModelEvent e) {  }  @Override  public void treeNodesChanged(TreeModelEvent e) {  }}