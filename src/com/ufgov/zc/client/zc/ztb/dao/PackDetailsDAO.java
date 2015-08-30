package com.ufgov.zc.client.zc.ztb.dao;import com.ufgov.zc.client.zc.ztb.util.GV;import java.io.File;public class PackDetailsDAO extends ZTbFileDao {  private static PackDetailsDAO packDetailsDAO = new PackDetailsDAO();  private PackDetailsDAO() {    super();  }  public synchronized void createPackDetailsDocFile(String filePath) throws Exception {    filePath = GV.getImportFileDir_FromRoot().append(File.separator).append(filePath).toString();    File file = new File(filePath);    if (!file.getParentFile().exists()) {      boolean flag = file.getParentFile().mkdirs();      if (!flag) {        throw new Exception(GV.getSimpleMsg("directoryCreateErr"));      }    }    File wfile = new File(filePath);    if (!wfile.exists()) {      if (wfile.createNewFile()) {      } else {        throw new Exception(GV.getSimpleMsg("fileCreatedErrAndRestartToTry") + filePath);      }    }  }  public static PackDetailsDAO getInstance() {    return packDetailsDAO;  }}