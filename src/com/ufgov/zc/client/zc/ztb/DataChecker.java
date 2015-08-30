package com.ufgov.zc.client.zc.ztb;import com.ufgov.zc.client.zc.ztb.component.ProjectInfoPanel;import com.ufgov.zc.client.zc.ztb.model.SmartTreeNode;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.client.zc.ztb.util.PubFunction;import javax.swing.*;/** * 该类主要是对关键数据进行检查校验 * * @author LEO */public class DataChecker {  /**   * 招标书导出前检验相关数据是否完整   *   * @return   */  public static boolean toCheckKeyMsgInZTBFile() {    boolean havingPubKey = toCheckIsHavingPubKeyInfo();    if (DataChecker.isNeedToCheckPubKeyInfo() && !havingPubKey) {      String info = GV.getSimpleMsg("lackingMainMinorPubKey");      int sel = JOptionPane.showConfirmDialog(null, info, "提示", 2);      if (sel == JOptionPane.OK_OPTION) {        PubFunction.doFetchMainAndMinorPubKey();      } else {        return false;      }    }    String serverURL = ProjectInfoPanel.readWebServerIPAddr();    if (null == serverURL || "".equals(serverURL)) {      String info = GV.getSimpleMsg("lackingServerURL");      int sel = JOptionPane.showConfirmDialog(null, info, "提示", 2);      if (sel == JOptionPane.OK_OPTION) {        ProjectInfoPanel.getWebServerIPAddr();      } else {        return false;      }    }    return true;  }  /**   * 检查标书中是否已经导入过主辅key的公钥信息；   *   * @return   */  public static boolean toCheckIsHavingPubKeyInfo() {    String mainPubKey = ProjectInfoPanel.readCA_PUB_KEY(ProjectInfoPanel.MAIN_PUB_KEY);    String minorPubKey = ProjectInfoPanel.readCA_PUB_KEY(ProjectInfoPanel.MINOR_PUB_KEY);    if (null == mainPubKey || "".equals(mainPubKey) || null == minorPubKey || "".equals(minorPubKey)) {      return false;    }    return true;  }  public static boolean isNeedToCheckPubKeyInfo() {    return "Y".equalsIgnoreCase(JobThreads.toGetCodedDemand().get("ISMASTERMUSTCODED"));  }  /**   * 1、在刚导入招标书时，检验招标书的公钥信息是否正确；   * <p/>   * 2、在供应商制作投标书完成后，进行导出前，对公钥信息进行校验；   *   * @return   */  public static boolean toCheckZTBFilePubKey() {    if (!isNeedToCheckPubKeyInfo()) {      return true;    }    if (!doCheckPubKeyByMD5(ProjectInfoPanel.MAIN_PUB_KEY) || !doCheckPubKeyByMD5(ProjectInfoPanel.MINOR_PUB_KEY)) {      JOptionPane.showMessageDialog(null, GV.getSimpleMsg("pubKeyModifyShouldRefetch"));      return false;    }    return true;  }  public static boolean doCheckPubKeyByMD5(String currKey) {    String pubKey = ProjectInfoPanel.readCA_PUB_KEY(currKey);    String keySign = ProjectInfoPanel.readCA_PUB_KEY(currKey + "_MD5");    String tempSign = null;    try {      tempSign = PubFunction.getMD5DigestHexStr(pubKey.getBytes());    } catch (Exception e) {      e.printStackTrace();    }    if (!tempSign.equals(keySign)) {      return false;    }    return true;  }  /**   * 检查投标书中关键节点是否存在   *   * @param packNode   * @return   */  public static boolean toCheckTBFileValuePointWhileExp(SmartTreeNode packNode) {    SmartTreeNode tbNode = PubFunction.getNeedingNodeInChildren(packNode, GV.NODE_TYPE_TB);    if (tbNode == null) {      showAlert(packNode.getNodeDisplayName() + GV.getSimpleMsg("missingTbFileNodeUnderPack"));      return false;    }    SmartTreeNode priceTbNode = PubFunction.getNeedingNodeInChildren(tbNode, GV.NODE_TYPE_TBYLB);    if (priceTbNode == null) {      showAlert(packNode.getNodeDisplayName() + GV.getSimpleMsg("missingTBYLBUnderTbFileNode"));      return false;    }    return true;  }  /**   * 检查招标书中关键节点是否存在   *   * @param packNode   * @return   */  public static boolean toCheckZTBFileValuePoint(SmartTreeNode packNode) {    SmartTreeNode zbNode = PubFunction.getNeedingNodeInChildren((SmartTreeNode) packNode.getParent(), GV.NODE_TYPE_ZB);    if (zbNode == null) {      showAlert(GV.getSimpleMsg("missingZbNodeUnderProject"));      return false;    }    SmartTreeNode tbNode = PubFunction.getNeedingNodeInChildren(packNode, GV.NODE_TYPE_TB);    if (tbNode == null) {      showAlert(GV.getSimpleMsg("missingTbFileNodeUnderPack"));      return false;    }    SmartTreeNode priceTbNode = PubFunction.getNeedingNodeInChildren(tbNode, GV.NODE_TYPE_TBYLB);    if (priceTbNode == null) {      showAlert(GV.getSimpleMsg("missingTBYLBUnderTbFileNode"));      return false;    }    return true;  }  /**   * 检查招标书中必须有的节点   *   * @param projNode   * @return   */  public static boolean doCheckImportantMsgForZbBook(SmartTreeNode projNode) {    StringBuffer buff = new StringBuffer();    if (!DataChecker.toCheckKeyMsgInZTBFile()) {      return false;    }    SmartTreeNode node = PubFunction.getNeedingNodeInChildren(projNode, GV.NODE_TYPE_ZB);    if (node == null) {      buff.append("招标书中缺少【" + getZbNodeName() + "】节点;\n");    }    SmartTreeNode node1 = PubFunction.getNeedingNodeInChildren(projNode, GV.NODE_TYPE_TB);    if (node1 == null) {      buff.append("招标书中缺少【" + getTbNodeName() + "】节点;\n");    }    SmartTreeNode node2 = PubFunction.getNeedingNodeInChildren(projNode, GV.NODE_TYPE_TBYLB);    if (node2 == null) {      buff.append("招标书中缺少【开标一览表】节点;\n");    }    if (buff.length() > 1) {      GV.showMessageDialog(null, buff.toString());      return false;    }    return true;  }  public static String getZbNodeName() {    String purType = ProjectInfoPanel.getBusinessProject().getPurType();    if (purType.indexOf("公开") != -1) {      return GV.getPurType("gongkaizhaobiao");    } else if (purType.indexOf("单一") != -1) {      return GV.getPurType("danyilaiyuan");    } else if (purType.indexOf("竞争") != -1) {      return GV.getPurType("jingzhengxingtanpan");    } else if (purType.indexOf("二次") != -1) {      return GV.getPurType("xieyigonghuo");    } else {      return GV.getPurType("gongkaizhaobiao");    }  }  public static String getTbNodeName() {    String purType = ProjectInfoPanel.getBusinessProject().getPurType();    if (purType.indexOf("公开") != -1) {      return GV.getSimpleMsg("toubiaofile");    } else if (purType.indexOf("单一") != -1) {      return GV.getSimpleMsg("xiangyingfile");    } else if (purType.indexOf("竞争") != -1) {      return GV.getSimpleMsg("xiangyingfile");    } else if (purType.indexOf("二次") != -1) {      return GV.getSimpleMsg("xiangyingfile");    } else {      return GV.getSimpleMsg("toubiaofile");    }  }  /**   * 通过MD5码来校验文件是否被修改过   *   * @param filePath   * @param md5   * @return true if modified,false if not modified, if @param md5 is null or empty,   *         <p/>   *         return false, means not modify,if the system running this method has no md5 getting method,   *         <p/>   *         return false too.   */  public static boolean toCheckFileIsModified(String filePath, String md5) {    if (md5 == null || "".equals(md5)) {      return false;    }    String fileMD5 = null;    try {      fileMD5 = PubFunction.getFileMD5DigestHexStr(filePath);    } catch (Exception e) {      e.printStackTrace();      return false;    }    return !md5.equals(fileMD5);  }  /**   * 版本检测实现方案：   * <p/>   * 1、在招标书制作软件中的配置文件添加一个版本号项（需要将版本号写入到一个ini文件中，并将该文件打包进jar包中）；   * <p/>   * 2、同样对投标书制作软件的配置文件中添加一个版本号项（需要将版本号写入到一个ini文件中，并将该文件打包进jar包中）；   * <p/>   * 3、发布招标书时，将该版本号加密后写入到招标书中；   * <p/>   * 4、供应商导入招标书时，首先对招标书进行解压，解压后获取招标书中指定的被版本号，并对版本号进行解密；   * <p/>   * 5、获取当前投标制作软件的版本号，和第4步得到的版本号进行比较：   * <p/>   * a、如果投标书制作软件的版本号低于招标书中要求的版本号，那么终止招标书导入过程，同时提示用户进行软件升级；   * <p/>   * b、如果投标书制作软件的版本号高于或等于招标书中要求的版本号，那么继续后续的招标书导入过程；   *   * @param askVersionNO   * @param beCheckVersionNO   * @return   */  public static boolean toCheckVersionMatch(String askVersionNO, String beCheckVersionNO) {    VersionControler vc = new VersionControler();    int res = vc.versionComparor(askVersionNO, beCheckVersionNO, true);    if (res == 1) {      return true;    }    showAlert(vc.translateNumToCN(res));    return false;  }  /**   * 通过网络在线获取该软件的最新版本   *   * @param url   * @return   */  public static String toCheckNewestVersion(String url) {    return "";  }  public static void showAlert(String msg) {    JOptionPane.showMessageDialog(null, msg);  }}