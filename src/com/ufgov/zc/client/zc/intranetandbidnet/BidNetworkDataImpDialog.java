package com.ufgov.zc.client.zc.intranetandbidnet;import java.awt.BorderLayout;import java.awt.Container;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.io.File;import java.util.Iterator;import java.util.List;import java.util.Map;import javax.swing.JButton;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JScrollPane;import javax.swing.JTextField;import javax.swing.SwingUtilities;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.StringToModel;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.component.zc.dataexchange.model.CommonDataExchangeOperator;import com.ufgov.zc.client.zc.ztb.component.ProgressGlassPane;import com.ufgov.zc.client.zc.ztb.util.PubFunction;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.zc.publish.IBidNetworkDataImpDelegate;public class BidNetworkDataImpDialog extends IntrantAndBidnetAbstractDialog {  /**   *    */  private static final long serialVersionUID = 7420369849420569046L;  private IBidNetworkDataImpDelegate bidNetworkDataImpDelegate = (IBidNetworkDataImpDelegate) ServiceFactory.create(IBidNetworkDataImpDelegate.class,  "bidNetworkDataImpDelegate");  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();  private JButton jButtonExec;  public BidNetworkDataImpDialog() {    Container container = self.getContentPane();    container.setLayout(new BorderLayout(6, 6));    container.removeAll();    JPanel middle = new JPanel(new BorderLayout());    JPanel inner = new JPanel(new BorderLayout(4, 4));    JPanel panel2 = new JPanel(new BorderLayout(4, 4));    panel2.add(new JLabel("导入位置:"), BorderLayout.WEST);    final JTextField savePathTF = new JTextField();    savePathTF.setName("pathTextField");    panel2.add(savePathTF, BorderLayout.CENTER);    JButton jButton = makeBrowerButton(savePathTF, false);    panel2.add(jButton, BorderLayout.EAST);    container.add(panel2, BorderLayout.NORTH);    JScrollPane scrollPane = this.makeTextAreaScrollPanel();    middle.add(scrollPane, BorderLayout.CENTER);    container.add(middle, BorderLayout.CENTER);    JPanel panel4 = new JPanel();    jButtonExec = new JButton("执行导入");    jButtonExec.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        if (savePathTF.getText() == null || "".equals(savePathTF.getText())) {          JOptionPane.showMessageDialog(self, "请指定导入文件的存放位置...", "提示", JOptionPane.OK_OPTION);          return;        }        if (!CommonDataExchangeOperator.checkFilePath(savePathTF.getText())) {          JOptionPane.showMessageDialog(self, "路径中存在非法字符，请检查...", "提示", JOptionPane.OK_OPTION);          return;        }        makeProgressGlassPane(savePathTF.getText(), null, false);      }    });    panel4.add(jButtonExec);    container.add(panel4, BorderLayout.SOUTH);  }  public void impExecute(String path, ProgressGlassPane glassPane) {    String targetPath = null;    try {      glassPane.getTimer().start();      isJobRunning = true;      jButtonExec.setEnabled(false);      progressText.append("文件开始读取\n");      targetPath = unZip2Path(path);      String flagFilePath = targetPath + File.separator + FLAG_FILE_NAME + ".xml";      File flagFile = new File(flagFilePath);      if (!flagFile.isFile()) {        progressText.append("系统不能确定，您要导入的文件来自哪个系统，导入失败！\n");        publishProgressText();        glassPane.getTimer().stop();        glassPane.setVisible(false);        isJobRunning = false;        jButtonExec.setEnabled(true);        return;      }      Map<String, String> map = (Map<String, String>) CommonDataExchangeOperator.readXmlFileToObject(flagFile.getAbsolutePath());      String value = (String) map.get(FLAG_KEY);      if (!INTRANET_DATA_FLAG.equals(value)) {        progressText.append("您要导入的文件不是内网系统导出数据，不能导入评标专网系统！\n");        publishProgressText();        glassPane.getTimer().stop();        glassPane.setVisible(false);        isJobRunning = false;        jButtonExec.setEnabled(true);        return;      }      File dir = new File(targetPath);      File[] fList = dir.listFiles();      for (int i = 0; i < fList.length; i++) {        if ((FLAG_FILE_NAME + ".xml").equals(fList[i].getName())) {          continue;        }        String name = fList[i].getName();        String msg = getTransName(name.substring(0, name.length() - ".xml".length()));        progressText.append(msg + "文件开始解析\n");        Object o = CommonDataExchangeOperator.readXmlFileToObject(fList[i].getAbsolutePath());        progressText.append(msg + "文件开始导入\n");        if (o instanceof List) {          List list = (List) o;          int j = 1;          for (Iterator iterator = list.iterator(); iterator.hasNext();) {            Object object = (Object) iterator.next();            if (object == null)              continue;            StringToModel.invokeMethod(bidNetworkDataImpDelegate, "insert", new Object[] { object, requestMeta });            progressText.append(msg + "插入第" + j + "条记录\n");            j++;          }        } else {          StringToModel.invokeMethod(bidNetworkDataImpDelegate, "insert", new Object[] { o, requestMeta });          progressText.append(msg + " 记录导入完毕\n");        }        progressText.append(msg + "文件导入完毕\n");      }      //CommonDataExchangeOperator.deleteFiles(targetPath);      progressText.append("所有文件导入完毕\n");      publishProgressText();      glassPane.getTimer().stop();      glassPane.getProgressBar().setValue(100);      glassPane.getProgressInfo().setHorizontalAlignment(SwingUtilities.CENTER);      glassPane.setVisible(false);      isJobRunning = false;      jButtonExec.setEnabled(true);      PubFunction.deleteFile(targetPath, false);    } catch (Exception e) {      // TODO Auto-generated catch block      e.printStackTrace();      progressText.append(e.getMessage() + "\n程序导入终止！");      publishProgressText();      glassPane.getTimer().stop();      glassPane.setVisible(false);      isJobRunning = false;      jButtonExec.setEnabled(true);      if (targetPath != null) {        PubFunction.deleteFile(targetPath, false);      }    }  }}