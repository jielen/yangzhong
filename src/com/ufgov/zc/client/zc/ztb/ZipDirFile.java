/** * @(#) project: FA52 * @(#) file: ZipDirFile.java * * Copyright 2010 UFGOV, Inc. All rights reserved. * UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. * */package com.ufgov.zc.client.zc.ztb;import java.io.File;import java.io.FileInputStream;import java.io.FileNotFoundException;import java.io.FileOutputStream;import java.io.IOException;import java.util.Iterator;import java.util.Map;import org.apache.tools.zip.ZipEntry;import org.apache.tools.zip.ZipOutputStream;/** * @ClassName: ZipDirFile * @Description:把一个目录下的文件压缩到一个压缩包中。 * @date: 2010-4-11 上午12:33:47 * @version: V1.0 * @since: 1.0 * @author: tianly1 * @modify: */public class ZipDirFile {  public static void zip(Map<String, String> files, String destFullPath, String zipFileName) {    if (files == null) {      return;    }    Iterator<String> it = files.keySet().iterator();    while (it.hasNext()) {      String key = it.next();      zip(new File(files.get(key)), new File(destFullPath), zipFileName);    }  }  public static void zip(String source, String destination, String zipFileName) throws Exception {    zip(new File(source), new File(destination), zipFileName);  }  public static void zip(File source, File destination, String zipFileName) {    ZipOutputStream out = null;    try {      out = new ZipOutputStream(new FileOutputStream(destination));      out.setEncoding("GBK");      zip(source, out, zipFileName);    } catch (FileNotFoundException e) {      e.printStackTrace();    } catch (Exception e) {      e.printStackTrace();    } finally {      try {        out.close();      } catch (IOException e) {        // TCJLODO Auto-generated catch block        e.printStackTrace();      }    }  }  private static void zip(File source, ZipOutputStream destination, String base) throws Exception {    if (source.isDirectory()) {      File[] children = source.listFiles();      base = (base == null || base.length() == 0) ? "" : base + File.separator;      for (int i = 0; i < children.length; i++) {        zip(children[i], destination, base + children[i].getName());      }    } else {      destination.putNextEntry(new ZipEntry(base));      FileInputStream in = new FileInputStream(source);      int b = -1;      byte[] buffer = new byte[1024];      while ((b = in.read(buffer)) != -1) {        destination.write(buffer, 0, b);      }      in.close();    }  }  public static void main(String args[]) throws Exception {    String sourceDir = "D:\\data_UFIDA_COMPO\\20110525";    String destination = "D:\\data_UFIDA_COMPO\\20110525.zip";    ZipDirFile.zip(sourceDir, destination, "abc");  }}