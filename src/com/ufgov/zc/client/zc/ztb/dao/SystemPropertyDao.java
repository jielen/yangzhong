package com.ufgov.zc.client.zc.ztb.dao;import com.ufgov.zc.client.zc.ztb.model.DBProperty;import com.ufgov.zc.client.zc.ztb.util.GV;import com.ufgov.zc.client.zc.ztb.util.PubFunction;import java.io.*;public class SystemPropertyDao extends ZTbFileDao {  private static SystemPropertyDao dbPropertyDao = new SystemPropertyDao();  private SystemPropertyDao() {    super();  }  private synchronized void createFile(String fileName, String content, String encodType) throws IOException {    File file = new File(fileName);    if (!file.exists()) {      file.getParentFile().mkdirs();      file.createNewFile();    }    FileOutputStream writerStream = new FileOutputStream(fileName);    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, encodType));    writer.write(content);    writer.close();  }  public synchronized void createXMLFile(DBProperty dBProperty) throws IOException {    String xmls = xstreamW.toXML(dBProperty);    String filePath = getConfigXmlPath();    createFile(filePath, "<?xml version=\"1.0\" encoding=\"" + GV.XML_CHAR_CODE + "\"?>\n" + xmls, GV.XML_CHAR_CODE);  }  public synchronized DBProperty readDBPropertyOnly() throws Exception {    String filePath = getConfigXmlPath();    if (!PubFunction.checkAndCreateDirOrFile(filePath, "F", false, false, null)) {      return null;    }    FileInputStream fis = new FileInputStream(filePath);    DBProperty dbProperty = (DBProperty) xstreamR.fromXML(new InputStreamReader(fis, GV.XML_CHAR_CODE));    fis.close();    return dbProperty;  }  public synchronized DBProperty readDBProperty() throws Exception {    String filePath = getConfigXmlPath();    PubFunction.checkAndCreateDirOrFile(filePath, "F", true, false, new DBProperty());    FileInputStream fis = new FileInputStream(filePath);    DBProperty dbProperty = (DBProperty) xstreamR.fromXML(new InputStreamReader(fis, GV.XML_CHAR_CODE));    fis.close();    return dbProperty;  }  private String getConfigXmlPath() {//    return GV.DEFAULT_CONFIG_DIR + File.separator + GV.DB_CONFIG_XML;	  return GV.DEFAULT_CONFIG_DIR + GV.DB_CONFIG_XML;  }  public static SystemPropertyDao getInstance() {    return dbPropertyDao;  }  public boolean toDeleteOldConfigFile() {    File file = new File(getConfigXmlPath());    if (file.isFile() && file.exists()) {      return file.delete();    }    return true;  }}