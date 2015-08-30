/**   * @(#) project: ZFCG* @(#) file: ZcEbZbFilePanel.java* * Copyright 2011 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.client.zc.zbfile;import java.awt.BorderLayout;import java.awt.Dimension;import java.awt.Point;import java.awt.Rectangle;import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.io.File;import java.io.FileInputStream;import java.io.IOException;import java.io.InputStream;import java.util.Enumeration;import java.util.HashMap;import java.util.Map;import java.util.Set;import javax.swing.JDialog;import javax.swing.JOptionPane;import javax.swing.JProgressBar;import javax.swing.tree.TreeModel;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.zc.activeztb.TbDocService;import com.ufgov.zc.client.zc.ztb.JobThreads;import com.ufgov.zc.client.zc.ztb.component.MainPanel;import com.ufgov.zc.client.zc.ztb.fileResumeBroken.fileOperate.MD5Util;import com.ufgov.zc.client.zc.ztb.model.SmartTreeNode;import com.ufgov.zc.client.zc.ztb.service.FileExportService;import com.ufgov.zc.client.zc.ztb.service.ReadTbFileService;import com.ufgov.zc.client.zc.ztb.util.ActionMaps;import com.ufgov.zc.client.zc.ztb.util.EventPropertyName;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.common.commonbiz.publish.IBaseDataServiceDelegate;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.ZcEbProjZbFile;import com.ufgov.zc.common.zc.publish.IZcEbZbFileServiceDelegate;/*** @ClassName: ZcEbZbFilePanel* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2011-3-18 下午02:28:49* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ZcEbZbFilePanel extends MainPanel {  //下载的招投标文件路径  private String filePath;  private ZcEbProjZbFile zcEbProjZbFile;  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  //解压招标文件之后的项目信息的.xml文件路径。  private String fileName;  private static JProgressBar progressBar = null;  private TreeModel oldTreeModel;  private Map oldZbFileMap = new HashMap<String, String>();  private Map zbFileMap = new HashMap<String, String>();  public IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,  "baseDataServiceDelegate");  private IZcEbZbFileServiceDelegate zcEbZbFileServiceDelegate = (IZcEbZbFileServiceDelegate) ServiceFactory  .create(IZcEbZbFileServiceDelegate.class, "zcEbZbFileServiceDelegate");  private FileExportService tbFileService = new FileExportService();  public ZcEbZbFilePanel(ZcEbProjZbFile zcEbProjZbFile) throws Exception {    this.zcEbProjZbFile = zcEbProjZbFile;    isZbFileAudit = true;    //下载并解压招标文件    downLoadFile();    //汇总招标文件显示panel  }  public ZcEbZbFilePanel(String projCode) throws Exception {    this.zcEbProjZbFile = zcEbZbFileServiceDelegate.getZcebZbFileByProjCode(projCode, requestMeta);    isZbFileAudit = true;    //下载并解压招标文件    downLoadFile();    //汇总招标文件显示panel  }  private void downLoadFile() {    //清除本地临时文件目录    deleteZbFile();    TbDocService tbDocService = new TbDocService();    tbDocService.addPathPrex(zcEbProjZbFile.getProjCode() + File.separator + "ZB" + File.separator);    filePath = tbDocService.getFileDownloadPath();    fileName = filePath + zcEbProjZbFile.getProjCode() + File.separator + zcEbProjZbFile.getProjCode() + ".xml";    tbDocService.downloadFile(zcEbProjZbFile.getProjCode(), zcEbProjZbFile.getFileId(), "DB");    if (leftPane == null) {      System.out.println("---------inintPanel:");      ActionMaps.initZbAudit(filePath, zcEbProjZbFile.getProjCode());      initPanel();    } else {      System.out.println("---------refreshPanel:");      refreshPanel();    }    Set<String> set = ActionMaps.getActionsMap().keySet();    for (String key : set) {      Object obj = ActionMaps.getActionsMap().get(key);      if (obj instanceof zbCommonAction) {        ((zbCommonAction) obj).setComponent(singleSeletionTree);      }    }    oldTreeModel = (TreeModel) ObjectUtil.deepCopy(singleSeletionTree.getTree().getModel());    digestZbFile(oldZbFileMap);  }  public void refreshPanel() {    try {      refreshLeftFilesTreePanel();    } catch (Exception e) {      e.printStackTrace();    }    expandOrClose(true, true);    splitPane.revalidate();    splitPane.repaint();  }  public void refreshLeftFilesTreePanel() {    initLeftFilesTreePanel();  }  @Override  public void initLeftFilesTreePanel() {    if (null == fileName || "".equals(fileName)) {      return;    }    if (!checkFileExits(fileName)) {      return;    }    ReadTbFileService readTbFileService = new ReadTbFileService();    System.out.println("初始化树");    singleSeletionTree = readTbFileService.createZTBSTreePanel(fileName, this);    singleSeletionTree.getTree().setRootVisible(true);    singleSeletionTree.addPropertyChangeListener(EventPropertyName.MOUSE_DBCLICK_PROPERTY_NAME, new PropertyChangeListener() {      public void propertyChange(PropertyChangeEvent evt) {        showTreeNodeInfo(getFilePath() + File.separator + singleSeletionTree.getCurrentNode().getNodesFullPath()        + singleSeletionTree.getCurrentNode().getFileExtension());      }    });  }  public void refreshData(ZcEbProjZbFile zcEbProjZbFile) {    this.zcEbProjZbFile = zcEbProjZbFile;    downLoadFile();    splitPane.revalidate();    splitPane.repaint();  }  protected String getFilePath() {    return filePath;  }  private boolean checkFileExits(String fileName) {    File file = new File(fileName);    if (file.exists()) {      return true;    }    return false;  }  @Override  public void paintPanel() {    this.setLayout(new BorderLayout());    this.add(this.splitPane, BorderLayout.CENTER);  }  public void updateZbFileToDb() {    closePackDetailsNode();    saveTableBuilderData();    SmartTreeNode currNode = (SmartTreeNode) singleSeletionTree.getTree().getModel().getRoot();    String content = currNode.getNodeName();    String meg = GV.getOperateMsg("uploadProject.confirm", content);    if (GV.showConfirmDialog(singleSeletionTree.getRootPane(), meg, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {      //导出项目是在项目节点上      startUploadProjectThread(currNode, content);    }  }  public void saveZbFile() {    closePackDetailsNode();    saveTableBuilderData();  }  public void startUploadProjectThread(final SmartTreeNode currNode, final String content) {    final JDialog progressDialog = new JDialog();    progressDialog.add(getProgressBar(0));    progressDialog.setSize(new Dimension(500, 20));    progressDialog.setLocation(new Point(300, 700));    progressDialog.setUndecorated(true);    progressDialog.setAlwaysOnTop(true);    progressDialog.setVisible(true);    Thread worker = new Thread(new Runnable() {      public void run() {        boolean rlt = false;        String expInfo = "";        try {          String ps = GV.getFileOperatorCN(GV.PROGRESS_STATUS_EXPORT_READY);          JobThreads.publishProgressMsg(ps);          //导出文件的路径：          String exportPath = filePath + "YASUO" + File.separator;          //把招标文件导出成ztb文件          String ztbPath = tbFileService.exportProject(currNode, filePath + zcEbProjZbFile.getProjCode(), exportPath, true);          ps = GV.getFileOperatorCN(GV.PROGRESS_STATUS_UPLOAD_READY);          JobThreads.publishProgressMsg(ps);          File file = new File(ztbPath);          long len = file.length();          long maxLen = 50 * 1024 * 1024;          if (len > maxLen) {            throw new Exception("单个上传文件大小不能超过50M！");          }          byte[] bytes = new byte[(int) len];          InputStream inputStream = new FileInputStream(file);          int r = inputStream.read(bytes);          if (r != len) {            throw new IOException("读取文件不正确");          }          inputStream.close();          AsFile asFile = baseDataServiceDelegate.getAsFileById(zcEbProjZbFile.getFileId(), requestMeta);          asFile.setFileContent(bytes);          baseDataServiceDelegate.updateAsFileById(asFile, requestMeta);          ps = GV.getFileOperatorCN(GV.PROGRESS_STATUS_UPLOAD_OK);          JobThreads.publishProgressMsg(ps);          rlt = true;        } catch (Exception e) {          rlt = false;          expInfo = e.getMessage();          e.printStackTrace();        }        String tigMeg;        if (rlt) {          tigMeg = GV.getOperateMsg("uploadProject.success", content);        } else {          tigMeg = GV.getOperateMsg("uploadProject.failure", content);        }        GV.showMessageDialog(singleSeletionTree.getRootPane(), tigMeg + expInfo);        progressDialog.dispose();      }    });    worker.start();  }  private static JProgressBar getProgressBar(int len) {    if (len == 0) {      len = 100;    }    if (progressBar == null) {      progressBar = new JProgressBar(0, len);      progressBar.setStringPainted(true);      progressBar.setBounds(new Rectangle(101, 305, 420, 30));    }    return progressBar;  }  public void digestZbFile(Map<String, String> zbFileDigestMap) {    SmartTreeNode currNode = (SmartTreeNode) singleSeletionTree.getTree().getModel().getRoot();    digestNodeFile(currNode, zbFileDigestMap);  }  public void digestNodeFile(SmartTreeNode currNode, Map<String, String> zbFileDigestMap) {    File srcFile;    if (currNode.getFileExtension() != null && !currNode.getFileExtension().equals("dir")) {      srcFile = new File(getFilePath() + File.separator + currNode.getNodesFullPath() + currNode.getFileExtension());    } else {      srcFile = new File(getFilePath() + File.separator + currNode.getNodesFullPath());    }    if (!srcFile.exists()) {      return;    }    if (srcFile.isFile()) {      FileInputStream fis = null;      Long s = new Long(srcFile.length());      try {        fis = new FileInputStream(srcFile);        byte[] buffer = new byte[s.intValue()];        zbFileDigestMap.put(currNode.getNodesFullPath(), (new MD5Util()).getMD5String(buffer));      } catch (IOException e) {        e.printStackTrace();      } finally {        try {          fis.close();        } catch (IOException e) {          e.printStackTrace();        }      }    } else if (srcFile.isDirectory()) {      Enumeration enumeration = currNode.children();      if (enumeration == currNode.EMPTY_ENUMERATION) {        return;      } else {        while (enumeration.hasMoreElements()) {          SmartTreeNode childNode = (SmartTreeNode) enumeration.nextElement();          digestNodeFile(childNode, zbFileDigestMap);        }      }    }  }  public void deleteZbFile() {    File file = new File(TbDocService.getDownloadFilePath());    deleteFile(file);  }  private void deleteFile(File file) {    if (null != file) {      if (file.isDirectory()) {        File files[] = file.listFiles();        for (File f : files) {          //          System.out.println(f.getAbsolutePath());          deleteFile(f);        }        file.delete();      } else {        file.delete();      }    }  }  public boolean isZbFileChanged() {    //    treeModel = singleSeletionTree.getTree().getModel();    //    if (!DigestUtil.digest(treeModel).equals(DigestUtil.digest(oldTreeModel))) {    //      return true;    //    }    digestZbFile(zbFileMap);    Set<String> keyset1 = zbFileMap.keySet();    Set<String> keyset2 = oldZbFileMap.keySet();    if (keyset1.size() != keyset2.size()) {      return true;    } else {      for (String key : keyset2) {        if (!zbFileMap.containsKey(key)) {          return true;        } else {          if (!zbFileMap.get(key).equals(oldZbFileMap.get(key))) {            return true;          }        }      }    }    return false;  }}