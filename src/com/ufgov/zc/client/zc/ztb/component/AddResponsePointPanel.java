package com.ufgov.zc.client.zc.ztb.component;import com.ufgov.zc.client.zc.ztb.dao.ReadObjectFileToObjectDao;import com.ufgov.zc.client.zc.ztb.model.DetailsType;import com.ufgov.zc.client.zc.ztb.model.ResponsePoint;import com.ufgov.zc.client.zc.ztb.model.SmartTreeNode;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.client.zc.ztb.util.PubFunction;import com.ufgov.zc.common.system.Guid;import javax.swing.*;import java.awt.*;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.ItemEvent;import java.awt.event.ItemListener;import java.io.File;import java.util.*;import java.util.List;public class AddResponsePointPanel extends JPanel {  private List<ResponsePoint> allPoints = null;  private Map<String, ResponsePoint> pointsMap = null;  private JFrame currFrame = null;  private JComboBox responsePointsComboBox = new JComboBox();  private MainPanel mainPanel = null;  private JTextField nameField = new JTextField();  private JTextArea contentField = new JTextArea();  private JTextArea pathField = new JTextArea();  private JTextArea descField = new JTextArea();  private JLabel alertLabel = new JLabel();  private SmartTreeNode currNode = null;  public AddResponsePointPanel(JFrame cFrame, MainPanel mp) {    this.currFrame = cFrame;    this.mainPanel = mp;    this.currNode = mp.getResponsePointsTree().getCurrentNode();    if (init()) {      buildContents();      currFrame.setSize(new Dimension(460, 250));      currFrame.setAlwaysOnTop(true);      currFrame.setResizable(true);      currFrame.setAlwaysOnTop(true);      currFrame.setLocationRelativeTo(null);      currFrame.setIconImage(currFrame.getToolkit().getImage(GV.getImageUrl("windowicon.jpg")));      currFrame.setVisible(true);    }  }  /**   * 初始化相关内容   *   * @return   */  private boolean init() {    SmartTreeNode packNode = this.mainPanel.getOpenedPackNode();    if (packNode == null) {      packNode = PubFunction.getNeedingNodeInChildren(this.mainPanel.getSingleSeletionTree().getTreeNode(), GV.NODE_TYPE_PACK);    }    if (packNode == null) {      JOptionPane.showMessageDialog(null, GV.getSimpleMsg("openPackForAddingResponse"));      return false;    }    if (this.mainPanel.getWordPane() == null || this.mainPanel.getWordPane().getOpenFile() == null) {      String msg = GV.getSimpleMsg("onlyParentNodeCreatableWhileNoOpenWord");      return this.prepareOption(packNode, msg);    }    SmartTreeNode tbNode = PubFunction.getNeedingNodeInParent(this.mainPanel.getOpenedLeavesNode(), GV.NODE_TYPE_TB);    if (tbNode == null) {      String msg = GV.getSimpleMsg("onlyParentNodeCreatableUnderTBNode");      return this.prepareOption(packNode, msg);    }    if (!toCheckOpenFileNodeMatchPackNode()) {      String msg = GV.getSimpleMsg("onlyParentNodeCreatableWhileNotMatch");      return this.prepareOption(packNode, msg);    }    Map<String, String> res = this.mainPanel.getWordPane().getSelectedDocRange();    int end = Integer.parseInt(res.get("end"));    int start = Integer.parseInt(res.get("start"));    int sLen = end - start;    if (sLen < 1) {      String msg = GV.getSimpleMsg("onlyParentNodeCreatableWhileNotSelected");      return this.prepareOption(packNode, msg);    }    if (!toLoadData(packNode)) {      return false;    }    contentField.setText(GV.getSimpleMsg("currentSelectedLen") + sLen);    pathField.setText(this.mainPanel.getOpenedLeavesNode().getNodesFullPathWithExtIfExist());    alertLabel.setText(getColorText(GV.getSimpleMsg("mustInputTip")));    return true;  }  /**   * 检查当前选中区域所属的标段和当前响应点对应的标段是否一致   */  private boolean toCheckOpenFileNodeMatchPackNode() {    SmartTreeNode packNode = this.mainPanel.getOpenedPackNode();    SmartTreeNode currRPNode = this.mainPanel.getResponsePointsTree().getCurrentNode();    if (currRPNode == null || GV.NODE_TYPE_RP_ROOT.equals(currRPNode.getNodeType())) {      SmartTreeNode rpRoot = this.mainPanel.getResponsePointsTree().getTreeNode();      currRPNode = PubFunction.getNeedingNodeWithNodeCodeInChildren(rpRoot, GV.NODE_TYPE_PACK_RP, packNode.getNodeCode());      this.mainPanel.getResponsePointsTree().setCurrentNode(currRPNode);      this.currNode = currRPNode;    }    SmartTreeNode rpPackNode = PubFunction.getNeedingNodeInParent(currRPNode, GV.NODE_TYPE_PACK_RP);    if (rpPackNode == null || packNode == null) {      return false;    } else {      if (packNode.getNodeCode().equals(rpPackNode.getNodeCode())) {        return true;      }    }    return false;  }  /**   * 弹出操作请求询问框，根据用户的选择进行下一步操作   *   * @param packNode   * @param msg   * @return   */  private boolean prepareOption(SmartTreeNode packNode, String msg) {    int sel = JOptionPane.showConfirmDialog(null, msg, "询问", JOptionPane.YES_NO_OPTION);    if (sel == JOptionPane.NO_OPTION) {      this.currFrame.dispose();      return false;    } else {      toCreateCommonParentNode(packNode);      return false;    }  }  /**   * 加载指标项数据，作为基本响应点   *   * @param packNode   * @return   */  private boolean toLoadData(SmartTreeNode packNode) {    if (allPoints != null && allPoints.size() > 1) {      return true;    }    ReadObjectFileToObjectDao readObjectFileDao = ReadObjectFileToObjectDao.getInstance();    String xmlPath = GV.getImportFileDir_FromRoot().append(packNode.getNodesFullPath()).append(File.separator).append(GV.NODE_NAME_RESPONSE_POINT)      .append(GV.SUFFIX_XML).toString();    try {      insertSelfAddNode();      allPoints.addAll(readObjectFileDao.readListNodes(xmlPath));      pointsMap = new HashMap<String, ResponsePoint>();    } catch (Exception e) {      e.printStackTrace();      return false;    }    return true;  }  /**   * 创建普通类型的父节点   *   * @param packNode   */  private void toCreateCommonParentNode(SmartTreeNode packNode) {    String nodeName = getNodeName();    if (nodeName == null || "".equals(nodeName)) {      return;    }    ResponsePoint rp = new ResponsePoint();    rp.setPointName(nodeName);    rp.setPointTargerContent("");    rp.setPointTargerPath("");    rp.setPointDescription("");    rp.setPointID("PRP_" + ResponsePoint.getRP_COUNT());    rp.setPointTargerBookMark("");    rp.setPointMemo("");    SmartTreeNode tmpNode = new SmartTreeNode();    tmpNode.setNodeCode(rp.getPointID());    tmpNode.setNodeName(rp.getPointMemo());    tmpNode.setNodeType(GV.NODE_TYPE_RESPONSE_POINT);    tmpNode.setNodeDisplayName(rp.getPointName());    tmpNode.setNodeMemo(rp.getPointDescription());    tmpNode.setNodeDirPath(rp.getPointTargerPath());    tmpNode.setForExtention3(rp.getPointTargerContent());    tmpNode.setNodeGUID(Guid.genID());    tmpNode.setUserObject(rp);    currNode.add(tmpNode);    String xmlPath = toGetXmlPath(currNode, GV.NODE_NAME_RP_TREE);    try {      PubFunction.checkAndCreateDirOrFile(xmlPath, "F", true, true, this.removeDuplicationNodes(currNode));      mainPanel.refreshLeftResponsePointsTreePanel();    } catch (Exception e) {      e.printStackTrace();    }  }  /**   * 获得输入的响应点的名称   *   * @return   */  private String getNodeName() {    JTextField nameField = new JTextField();    Object[] message = { GV.getSimpleMsg("pleaseInputNodeName"), nameField };    int res = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);    if (res == JOptionPane.CANCEL_OPTION) {      return null;    }    String name = nameField.getText();    if (name == null || "".equals(name)) {      return getNodeName();    } else {      return name;    }  }  private void insertSelfAddNode() {    if (allPoints == null) {      allPoints = new ArrayList<ResponsePoint>();    }    ResponsePoint rp = new ResponsePoint();    rp.setPointID("SELF");    rp.setPointName("");    rp.setPointMemo(GV.getSimpleMsg("selfDefinePoint"));    allPoints.add(0, rp);  }  private void buildContents() {    this.setLayout(new BorderLayout());    JPanel panel = new JPanel();    panel.setLayout(new GridBagLayout());    GridBagConstraints c = new GridBagConstraints();    c.fill = GridBagConstraints.HORIZONTAL;    c.insets = new Insets(5, 5, 0, 5);    int gridy = 0;    c.gridx = 0;    c.gridy = gridy;    c.gridwidth = 1;    JLabel l1 = new JLabel(GV.getSimpleMsg("evalElements"));    panel.add(l1, c);    c.gridx = 1;    c.gridy = gridy;    c.gridwidth = 2;    responsePointsComboBox.setPreferredSize(new Dimension(280, 22));    Object selItem = responsePointsComboBox.getSelectedItem();    if (selItem != null) {      responsePointsComboBox.setToolTipText(selItem.toString());    }    responsePointsComboBox.setModel(getUserablePointItemsModel());    panel.add(responsePointsComboBox, c);    responsePointsComboBox.addItemListener(new ItemListener() {      public void itemStateChanged(ItemEvent arg0) {        String id = ((DetailsType) responsePointsComboBox.getSelectedItem()).getValue();        ResponsePoint rp = pointsMap.get(id);        nameField.setText(rp.getPointName());        descField.setText(rp.getPointDescription());      }    });    c.gridx = 0;    c.gridy = ++gridy;    c.gridwidth = 1;    JLabel l2 = new JLabel(getMustInputLabelText(GV.getSimpleMsg("responseName")));    panel.add(l2, c);    c.gridx = 1;    c.gridy = gridy;    c.gridwidth = 2;    panel.add(nameField, c);    c.gridx = 0;    c.gridy = ++gridy;    c.gridwidth = 1;    JLabel l3 = new JLabel(getMustInputLabelText(GV.getSimpleMsg("responseDesc")));    panel.add(l3, c);    c.gridx = 1;    c.gridy = gridy;    c.gridwidth = 4;    descField.setPreferredSize(new Dimension(280, 60));    descField.setLineWrap(true);    panel.add(descField, c);    c.gridx = 0;    c.gridy = ++gridy;    c.gridwidth = 6;    alertLabel.setPreferredSize(new Dimension(320, 60));    panel.add(alertLabel, c);    JButton button = new JButton(GV.getTranslate("addNew"));    button.setPreferredSize(new Dimension(80, 22));    addButtonActions(button);    JButton cancel = new JButton(GV.getTranslate("cancel"));    cancel.setPreferredSize(new Dimension(80, 22));    cancel.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent arg0) {        currFrame.setVisible(false);      }    });    JPanel btPanel = new JPanel();    btPanel.setLayout(new FlowLayout());    btPanel.add(cancel);    btPanel.add(button);    this.add(btPanel, BorderLayout.SOUTH);    this.add(panel, BorderLayout.CENTER);  }  private String getMustInputLabelText(String msg) {    StringBuffer buff = new StringBuffer("<html><a>");    buff.append(msg);    buff.append("<font size='3' color='red'>(*)</font>：<a></html>");    return buff.toString();  }  private String getColorText(String msg) {    StringBuffer buff = new StringBuffer("<html><a><font size='3' color='red'><b>提示:</b>");    buff.append(msg);    buff.append("</font><a></html>");    return buff.toString();  }  private DefaultComboBoxModel getUserablePointItemsModel() {    Vector<DetailsType> items = new Vector<DetailsType>();    for (int i = 0; i < allPoints.size(); i++) {      ResponsePoint rp = allPoints.get(i);      pointsMap.put(rp.getPointID(), rp);      DetailsType dt = new DetailsType(rp.getPointMemo(), rp.getPointID());      items.add(dt);    }    return new DefaultComboBoxModel(items);  }  private void addButtonActions(JButton button) {    button.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        if (toCheckData()) {          if (saveCurrPoint()) {            currFrame.setVisible(false);          }        }      }    });  }  private boolean toCheckData() {    StringBuffer buff = new StringBuffer();    if (currNode == null) {      buff.append(GV.getSimpleMsg("pleaseSelectParentNode"));      buff.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;");    }    if (nameField.getText() == null || nameField.getText().length() < 2) {      buff.append(GV.getSimpleMsg("nameTooSimple"));      buff.append("<br>&nbsp;&nbsp;&nbsp;&nbsp;");    }    if (descField.getText() == null || descField.getText().length() < 5) {      buff.append(GV.getSimpleMsg("descToolSimple"));    }    if (buff.length() > 0) {      alertLabel.setText(getColorText(buff.toString()));      return false;    } else {      alertLabel.setText(getColorText(GV.getSimpleMsg("mustInputTip")));      return true;    }  }  /**   * 保存新增的响应点   *   * @return   */  private boolean saveCurrPoint() {    DetailsType dt = (DetailsType) responsePointsComboBox.getSelectedItem();    ResponsePoint rp = new ResponsePoint();    rp.setPointName(nameField.getText().trim());    rp.setPointTargerContent(contentField.getText().trim());    rp.setPointTargerPath(pathField.getText().trim());    rp.setPointDescription(descField.getText());    rp.setPointID(dt.getValue() + "_");    rp.setPointTargerBookMark("RP_" + ResponsePoint.getRP_COUNT());    rp.setPointMemo(dt.getName());    SmartTreeNode tmpNode = new SmartTreeNode();    tmpNode.setNodeCode(rp.getPointID());    tmpNode.setNodeName(rp.getPointMemo());    tmpNode.setNodeType(GV.NODE_TYPE_RESPONSE_POINT);    tmpNode.setNodeDisplayName(rp.getPointName());    tmpNode.setNodeMemo(rp.getPointDescription());    tmpNode.setNodeDirPath(rp.getPointTargerPath());    tmpNode.setForExtention3(rp.getPointTargerContent());    tmpNode.setNodeGUID(rp.getPointTargerBookMark());    tmpNode.setUserObject(rp);    currNode.add(tmpNode);    System.out.println("Guid=" + rp.getPointTargerBookMark());    //在选中位置插入书签    boolean flag = this.mainPanel.getWordPane().insertBookMark(rp.getPointTargerBookMark());    if (!flag) {      currNode.remove(tmpNode);      return false;    }    SmartTreeNode rpPackNode = PubFunction.getNeedingNodeInParent(currNode, GV.NODE_TYPE_PACK_RP);    String xmlPath = toGetXmlPath(rpPackNode, GV.NODE_NAME_RP_TREE);    try {      PubFunction.checkAndCreateDirOrFile(xmlPath, "F", true, true, removeDuplicationNodes(currNode));      mainPanel.refreshLeftResponsePointsTreePanel();      mainPanel.setNodeVisibleWithNodeCode(mainPanel.getResponsePointsTree(), rpPackNode.getNodeCode(), true, true);    } catch (Exception e) {      e.printStackTrace();    }    return true;  }  private SmartTreeNode removeDuplicationNodes(SmartTreeNode currNode) throws Exception {    currNode = PubFunction.getNeedingNodeInParent(currNode, GV.NODE_TYPE_PACK_RP);    SmartTreeNode newNode = (SmartTreeNode) currNode.deepClone(currNode);    newNode.removeFromParent();    return newNode;  }  public String toGetXmlPath(SmartTreeNode node, String nodeName) {    return GV.getImportFileDir_FromRoot().append(node.getForExtention3()).toString();  }}