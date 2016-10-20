/**
 * 
 */
package com.ufgov.zc.server.zc.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ufgov.zc.common.system.model.AsFile;
import com.ufgov.zc.server.system.SpringContext;
import com.ufgov.zc.server.system.service.IAsFileService;

/**
 * 下载文件
 * @author Administrator
 */
public class LoadFile extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = -2686065593379301874L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String fileId = request.getParameter("fileId");

    System.out.println(fileId);

    //    IZcEbProjService projService = (IZcEbProjService) SpringContext.getBean("zcEbProjService");
    boolean find = true;
    String errMsg = "";
    if (fileId == null || fileId.trim().length() == 0) {
      errMsg = "非法的文件ID!";
      find = false;
    } else {
      IAsFileService asFileService = (IAsFileService) SpringContext.getBean("asFileService");
      AsFile af = asFileService.getAsFileById(fileId);
      if (af != null && af.getFileContent() != null) {
        ByteArrayInputStream bi = new ByteArrayInputStream(af.getFileContent());
        OutputStream o = response.getOutputStream();
        byte b[] = new byte[1024];
        response.setHeader("Content-disposition", "attachment;filename=" + fileId + ".doc");
        response.setContentType("text/html");
        long fileLength = af.getFileContent().length;
        String length = String.valueOf(fileLength);
        response.setHeader("Content_Length", length);
        int n = 0;
        while ((n = bi.read(b)) != -1) {
          o.write(b, 0, n);
        }
      } else {
        errMsg = "招标文件不存在！\nfileId=" + fileId;
        find = false;
      }
    }
    if (!find) {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      String title = "无法获取招标文件";

      String docType = "<!DOCTYPE html>\n";
      out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
      out.println("<h1>无法获取" + fileId + "的招标文件</h1>");
      out.println("<h2>" + errMsg + "</h2>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doGet(request, response);
  }
}