package com.ufgov.zc.server.zc.fileResumeBroken.serverFileOperate;import java.util.HashMap;import java.util.Map;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.server.system.SpringContext;import com.ufgov.zc.server.system.service.IAsFileService;public class FileInDatabase {  private Map parameterMap = new HashMap();  private Map returnMap = new HashMap();  public Map getParameterMap() {    return parameterMap;  }  public void setParameterMap(Map parameterMap) {    this.parameterMap = parameterMap;  }  public Map getReturnMap() {    return returnMap;  }  public void setReturnMap(Map returnMap) {    this.returnMap = returnMap;  }  public FileInDatabase(Map parameterMap, String functionDo) {    setParameterMap(parameterMap);  }  public void start() {    String fileId = (String) parameterMap.get("FILEID");    String filePath = (String) parameterMap.get("FILEPATH");    String fileName = (String) parameterMap.get("FILENAME");    IAsFileService asFileService = (IAsFileService) SpringContext.getBean("asFileService");    AsFile asFile = asFileService.getLargeAsFileById(fileId);    if (asFile == null) {      asFile = new AsFile();      asFile.setFileId(fileId);      asFile.setFileName(fileName);      asFile.setFilePath(filePath);      asFileService.insertAsFileDirectory(asFile);    }    returnMap.put("IFSUCCESS", "Y");  }}