/**
 * 
 */
package com.ufgov.zc.client.component.zc;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.ufgov.smartclient.plaf.BigButtonSplitPaneUI;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.component.FileUploader;
import com.ufgov.zc.client.zc.activeztb.TbDocService;
import com.ufgov.zc.client.zc.ztb.util.FileChooseFilter;
import com.ufgov.zc.common.system.Guid;
import com.ufgov.zc.common.zc.model.HuiyuanAttachinfoStrorage;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

/**
 * 会员库里资质文件的上传、下载、删除控件
 * @author Administrator
 */
public class HuiyuanAttachFileUploader extends FileUploader {

  /**
   * 
   */
  private static final long serialVersionUID = -4524082765110151943L;

  private static final Logger logger = Logger.getLogger(HuiyuanAttachFileUploader.class);

  HuiyuanAttachinfoStrorage attachFile;

  private String attachGuid = "";

  IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

  public HuiyuanAttachFileUploader(boolean isDeleteOldFile, boolean isDownLoadFile) {
    // TODO Auto-generated constructor stub
    super(isDeleteOldFile, isDownLoadFile);
  }

  public HuiyuanAttachFileUploader() {
    super();
  }

  public HuiyuanAttachinfoStrorage getAttachFile() {
    return attachFile;
  }

  @Override
  protected void doUpload() {

    JFileChooser fileChooser = new JFileChooser();

    fileChooser.setApproveButtonText("上传");

    fileChooser.setApproveButtonToolTipText("上传所选文件");

    fileChooser.setDialogTitle("上传文件");

    fileChooser.setAcceptAllFileFilterUsed(isAllFileFilterUsed);

    if (this.fileExt != null && this.fileExt.length > 0) {

      for (String ext : this.fileExt) {

        if (ext != null && !"".equals(ext.trim())) {

          fileChooser.addChoosableFileFilter(new FileChooseFilter(ext.trim()));

        }

      }

    }

    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {

      File file = fileChooser.getSelectedFile();

      System.out.println("file.length() === " + file.length());

      FileInputStream fis = null;

      try {

        fis = new FileInputStream(file);

        BigDecimal available = new BigDecimal(fis.available());

        BigDecimal mByte = new BigDecimal(1024 * 1024);

        BigDecimal resultSize = available.divide(mByte, 2, BigDecimal.ROUND_HALF_UP);

        if (sizeLimit && resultSize.compareTo(maxSizeM) > 0) {
          JOptionPane.showMessageDialog(this, "文件限制在" + maxSizeM + "m以内,此文件大于这个数不能上传！", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }

        this.absoluteFile = file.getAbsolutePath();

        if (this.isDeleteOldFile) {
          doDelete();
        }

        byte[] content = new byte[available.intValue()];

        //byte[] content = new byte[1024 * 1024 * 100];

        long startTime = System.currentTimeMillis();

        fis.read(content);

        System.out.println("client read file time === " + (System.currentTimeMillis() - startTime) / 1000f);

        /* asFile = new AsFile();

         asFile.setFileContent(content);

         asFile.setFileName(file.getName());

         asFile.setMimeType(MimeMapping.getMimeType(getExtension(file)));

         startTime = System.currentTimeMillis();

         String fileId = baseDataServiceDelegate.uploadFile(asFile, requestMeta);

         System.out.println("upload file to server time === " + (System.currentTimeMillis() - startTime) / 1000f);

         asFile.setFileId(fileId);

         setText(file.getName());

         setToolTipText(file.getPath());*/
        String fileName = file.getName();
        String type = "";
        if (fileName.lastIndexOf('.') > 0) {
          type = fileName.substring(fileName.lastIndexOf('.') + 1);
        }

        attachFile = new HuiyuanAttachinfoStrorage();
        attachFile.setAttachguid(Guid.genID());
        //        attachFile.setClientguid(clientGuid);
        attachFile.setAttachfilename(fileName);
        attachFile.setContenttype(getExtension(file));
        attachFile.setContent(content);

        List lst = new ArrayList();
        lst.add(attachFile);
        zcEbBaseServiceDelegate.insertDataForObject("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.insert", attachFile, requestMeta);

        deleteButton.setVisible(true);
        downloadButton.setVisible(true);
        //        uploadButton.setVisible(this.isDeleteOldFile);
        uploadButton.setVisible(true);
        setText(file.getName());
        setToolTipText(file.getPath());
        setButtonEnable();

        fireValueChanged();

      } catch (Exception e) {

        e.printStackTrace();

        logger.error(e.getMessage(), e);

        JOptionPane.showMessageDialog(this, "上传文件失败！\n" + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);

      } finally {

        if (fis != null) {

          try {

            fis.close();

          } catch (IOException e) {

            logger.error(e.getMessage(), e);

          }

        }

      }

    }
  }

  @Override
  protected void doDelete() {

    if (attachFile != null && attachFile.getAttachguid() != null) {
      try {
        //        baseDataServiceDelegate.deleteFile(asFile.getFileId(), requestMeta);
        zcEbBaseServiceDelegate.deleteObject("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.deleteByPrimaryKey", attachFile.getAttachguid(), requestMeta);
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(true);
        attachFile = null;
        this.setText("");
        fireValueChanged();
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "删除文件失败！", "错误", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  @Override
  protected void openFile() {
    try {
      if (attachFile == null || attachFile.getAttachguid() == null || "".equals(attachFile.getAttachguid())) { return; }
      if (attachFile.getContent() == null || attachFile.getContent().length == 0) {
        attachFile = (HuiyuanAttachinfoStrorage) zcEbBaseServiceDelegate.queryObject("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.selectByPrimaryKey", attachFile.getAttachguid(),
          requestMeta);
      }
      if (isDownLoadFile) {
        File defaultFile = new File(defaultDownPath + attachFile.getAttachfilename());
        downLoad(defaultFile);
      } else {
        File dir = new File(defaultSavePath);
        TbDocService.deleteFile(dir);//将下载目录的文件夹清空
        if (!dir.exists()) {
          dir.mkdirs();
        }
        File defaultFile = new File(defaultSavePath + attachFile.getAttachfilename());
        defaultFile.delete();
        saveFileToLocal(defaultFile);
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      JOptionPane.showMessageDialog(this, "打开文件失败！", "错误", JOptionPane.ERROR_MESSAGE);

    }

  }

  @Override
  protected void downLoad(File defaultFile) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("下载文件");
    fileChooser.setApproveButtonText("保存");
    fileChooser.setApproveButtonToolTipText("保存文件");
    fileChooser.setSelectedFile(defaultFile);//
    int result = fileChooser.showSaveDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      if (selectedFile.exists()) {
        if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(this, selectedFile.getPath() + "已经存在\n您要覆盖原始文件吗？", "提示", JOptionPane.YES_NO_OPTION)) {
          downLoad(selectedFile);
          return;
        }
      }
      FileOutputStream os = null;
      try {
        os = new FileOutputStream(fileChooser.getSelectedFile());
        os.write(attachFile.getContent());
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        try {
          if (os != null) {
            os.close();
          }
        } catch (Exception e) {
          new RuntimeException(e.getMessage(), e);
        }
      }
      JOptionPane.showMessageDialog(this, "文件已被成功保存到" + selectedFile.getPath(), "提示", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  @Override
  protected void saveFileToLocal(File defaultFile) {
    int result = JFileChooser.APPROVE_OPTION; //fileChooser.showSaveDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = defaultFile;
      FileOutputStream os = null;
      try {
        os = new FileOutputStream(defaultFile);
        os.write(attachFile.getContent());
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        try {
          if (os != null) {
            os.close();
          }
        } catch (Exception e) {
          new RuntimeException(e.getMessage(), e);
        }
      }

      int yesNoResult = JOptionPane.YES_OPTION;
      if (yesNoResult == JOptionPane.YES_OPTION) {
        try {
          Desktop.getDesktop().open(defaultFile);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "抱歉！没有找到合适的程序来打开文件！", "提示", JOptionPane.INFORMATION_MESSAGE);
          return;
        }
      }
    }
  }

  public String getFileId() {
    String fileId = null;
    if (attachFile != null) {
      fileId = attachFile.getAttachguid();
    }
    return fileId;
  }

  public String getFileName() {
    String fileName = null;
    if (attachFile != null) {
      fileName = attachFile.getAttachfilename();
    }
    return fileName;
  }

  /* public void setFileId(final String fileId) {
     SwingUtilities.invokeLater(new Runnable() {
       public void run() {
         _setFileId(fileId);
       }
     });
   }

   private void _setFileId(String fileId) {
     deleteButton.setVisible(fileEditable);
     uploadButton.setVisible(fileEditable);
     if (fileId == null || fileId.trim().equals("")) {
       attachFile = null;
       this.setText("");
       this.setToolTipText(null);
       downloadButton.setVisible(false);
       setButtonEnable();
       return;
     }
      

     try {
       attachFile = (HuiyuanAttachinfoStrorage) zcEbBaseServiceDelegate.queryObject("com.ufgov.zc.server.zc.dao.HuiyuanAttachinfoStrorageMapper.selectByPrimaryKey", fileId, requestMeta);
       if (attachFile == null) {
         downloadButton.setVisible(false);
         System.out.println("没有找到id为" + fileId + "的文件\n" + "此文件可能已被删除！");
         return;
       }
       this.setText(attachFile.getAttachfilename());
       this.setToolTipText(attachFile.getAttachfilename());
       downloadButton.setVisible(true);
     } catch (Exception e) {
       logger.error(e.getMessage(), e);
       JOptionPane.showMessageDialog(this, "取文件信息时出现异常！", "错误", JOptionPane.ERROR_MESSAGE);
     }

   }*/

  public void setFileId(final String fileId, final String fileName, final boolean editable) {
    /* SwingUtilities.invokeLater(new Runnable() {
       public void run() {
         setFileId3(fileId, fileName, editable);
       }
     });*/

    if (fileId == null || fileId.trim().equals("")) {
      attachFile = null;
      this.setText("");
      this.setToolTipText(null);
      if (editable) {
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(true);
      } else {
        deleteButton.setVisible(false);
        downloadButton.setVisible(false);
        uploadButton.setVisible(false);
      }
      return;

    }

    attachFile = new HuiyuanAttachinfoStrorage();

    attachFile.setAttachguid(fileId);

    attachFile.setAttachfilename(fileName);

    this.setText(fileName);

    this.setToolTipText(fileName);

    if (editable) {

      deleteButton.setVisible(fileEditable);

      downloadButton.setVisible(fileEditable);

      //      uploadButton.setVisible(this.isDeleteOldFile);
      uploadButton.setVisible(fileEditable);

      setButtonEnable();

    } else {

      deleteButton.setVisible(false);

      downloadButton.setVisible(true);

      uploadButton.setVisible(false);

    }
  }

  /*
    protected void setFileId3(String fileId, String fileName, boolean editable) {

      if (fileId == null || fileId.trim().equals("")) {
        attachFile = null;
        this.setText("");
        this.setToolTipText(null);
        if (editable) {
          deleteButton.setVisible(false);
          downloadButton.setVisible(false);
          uploadButton.setVisible(true);
        } else {
          deleteButton.setVisible(false);
          downloadButton.setVisible(false);
          uploadButton.setVisible(false);
        }
        return;

      }

      attachFile = new HuiyuanAttachinfoStrorage();

      attachFile.setAttachfilename(fileId);

      attachFile.setAttachfilename(fileName);

      this.setText(fileName);

      this.setToolTipText(fileName);

      if (editable) {

        deleteButton.setVisible(fileEditable);

        downloadButton.setVisible(fileEditable);

        //      uploadButton.setVisible(this.isDeleteOldFile);
        uploadButton.setVisible(fileEditable);

        setButtonEnable();

      } else {

        deleteButton.setVisible(false);

        downloadButton.setVisible(true);

        uploadButton.setVisible(false);

      }

    }*/

  public static void main(String[] args) {
    HuiyuanAttachFileUploader fileField = new HuiyuanAttachFileUploader();
    UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());
    JFrame frame = new JFrame("frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 150);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new FlowLayout());
    frame.getContentPane().add(fileField);
    frame.setVisible(true);
  }
}
