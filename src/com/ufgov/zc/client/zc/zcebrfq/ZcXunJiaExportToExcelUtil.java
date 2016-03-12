/**
 * 
 */
package com.ufgov.zc.client.zc.zcebrfq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Alignment;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;

import com.ufgov.zc.common.system.dto.MainSubBill;

/**
 * 开标结果导出到excel
 * @author Administrator
 */
public class ZcXunJiaExportToExcelUtil {

  private static final Logger logger = Logger.getLogger(ZcXunJiaExportToExcelUtil.class);

  /**
   * @param args
   */
  public static void main(String[] args) {

  }

  public void exportToExcel(final JComponent parent, final MainSubBill mainSubBill, final int gysSum) {

    List list = new ArrayList();

    final List selectedRowsList = list;

    JFileChooser fileChooser = new JFileChooser() {

      private boolean approveConfirm(File file) {

        if (file.exists()) {

          if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, file

          .getPath()

          + "已经存在\n您要覆盖原始文件吗？", "提示", JOptionPane.YES_NO_OPTION)) {

            return true;

          } else {

            return false;

          }

        } else {

          return true;

        }

      }

      public void approveSelection() {

        if (!approveConfirm(this.getSelectedFile())) {

        return;

        }

        super.approveSelection();

      }

    };
    HashMap<String, String> mainMap = (HashMap<String, String>) mainSubBill.getMainBill();
    //    List<HashMap> subLst = mainSubBill.getSubBillList();
    String projCode = mainMap.get("PROJ_CODE");

    DateFormat ssFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

    //    String defaultFileName = "C:/商品报价汇总对照评议表" + ssFormat.format(new Date()) + ".xls";//默认的导出文件名
    String defaultFileName = "C:/商品报价汇总对照评议表(" + projCode + ").xls";//默认的导出文件名

    File defaultFile = new File(defaultFileName);

    fileChooser.setSelectedFile(defaultFile);

    fileChooser.setDialogTitle("导出excel");

    fileChooser.setMultiSelectionEnabled(false);

    fileChooser.setFileFilter(new FileFilter() {

      public boolean accept(File f) {

        return f.getAbsolutePath().toLowerCase().endsWith(".xls");

      }

      public String getDescription() {

        return "Excel文档(*.xls)";

      }

    });

    if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {

      final File selectedFile = fileChooser.getSelectedFile();

      String selecteFileName = selectedFile.getPath();

      if (!selecteFileName.toLowerCase().endsWith(".xls"))

      selecteFileName += ".xls";

      final String fileName = selecteFileName;

      SwingUtilities.invokeLater(new Runnable() {

        public void run() {

          try {

            boolean rtn = _export(parent, mainSubBill, gysSum, fileName);
            /*  if (!rtn) {
                //              JOptionPane.showMessageDialog(parent, "抱歉！导出excel失败.", "提示", JOptionPane.INFORMATION_MESSAGE);
                return;
              }
              int yesNoResult = JOptionPane.showConfirmDialog(parent, "文件已被成功保存到" + selectedFile.getPath() + "\n您要打开此文件吗？", "提示", JOptionPane.YES_NO_OPTION);

              if (yesNoResult == JOptionPane.YES_OPTION) {

                try {

                  Desktop.getDesktop().open(selectedFile);

                } catch (Exception e) {

                  JOptionPane.showMessageDialog(parent, "抱歉！没有找到合适的程序来打开文件！", "提示",

                  JOptionPane.INFORMATION_MESSAGE);

                  return;

                }

              }*/

          } catch (Exception e) {

            logger.error(e);

            JOptionPane.showMessageDialog(parent, "导出失败！", "错误",

            JOptionPane.ERROR_MESSAGE);

          }

        }

      });

    }

  }

  private boolean _export(JComponent parent, MainSubBill mainSubBill, int gysSum, String fileName) {
    int baseColums = 7;//序号 商品名称  品牌规格型号  单位  数量 成交金额 成交供应商
    int allColums = baseColums + gysSum;//全部列数
    int curRow = 0, curCol = 0;//代表当前行和列，单元格的计算，
    HashMap<String, String> mainMap = (HashMap<String, String>) mainSubBill.getMainBill();
    List<HashMap> subLst = mainSubBill.getSubBillList();
    //    String projCode=mainMap.get("PROJ_CODE");
    OutputStream os = null;
    WritableWorkbook ww = null;
    WritableWorkbook book = null;
    boolean success = false;
    String errorInfo = "";
    File file = new File(fileName);
    try {
      os = new FileOutputStream(file);
      book = Workbook.createWorkbook(os);
      WritableSheet sheet = book.createSheet("商品报价汇总对照评议表", 0);
      /* for (int i = 1; i < allColums; i++) {
         CellView cellView = new CellView();
         cellView.setAutosize(true); //设置自动大小  
         sheet.setColumnView(i, cellView);//根据内容自动设置列宽  
       }
      */

      jxl.write.WritableCellFormat txtFmt = new jxl.write.WritableCellFormat();
      jxl.write.WritableCellFormat numFmt = new jxl.write.WritableCellFormat();
      jxl.write.WritableCellFormat titleFmt = new jxl.write.WritableCellFormat();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

      DecimalFormat df = new DecimalFormat("#0.00");

      txtFmt.setBorder(Border.ALL, BorderLineStyle.THIN);

      txtFmt.setAlignment(Alignment.LEFT);

      numFmt.setBorder(Border.ALL, BorderLineStyle.THIN);

      numFmt.setAlignment(Alignment.RIGHT);

      //titleFmt.setAlignment(Alignment.CENTRE);

      /*      WritableFont fontFmt1 = new WritableFont(WritableFont.ARIAL, 8, WritableFont.BOLD, true);

            WritableFont fontFmt = new WritableFont(WritableFont.ARIAL, 20, WritableFont.BOLD, true);

            WritableCellFormat font = new WritableCellFormat(fontFmt);

            WritableCellFormat font1 = new WritableCellFormat(fontFmt1);

            font.setAlignment(Alignment.CENTRE);
            font.setVerticalAlignment(VerticalAlignment.CENTRE);

            font1.setBorder(Border.ALL, BorderLineStyle.THIN);*/

      WritableCellFormat cellFormatBigTitle = new WritableCellFormat();
      //设置水平居中
      cellFormatBigTitle.setAlignment(jxl.format.Alignment.CENTRE);
      //设置垂直居中
      cellFormatBigTitle.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      //设置显示的字体样式，字体，字号，是否粗体，字体颜色 
      cellFormatBigTitle.setFont(new WritableFont(WritableFont.createFont("仿宋"), 20, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK));
      //设置边框
      cellFormatBigTitle.setBorder(Border.ALL, BorderLineStyle.THIN);
      //设置自动换行
      cellFormatBigTitle.setWrap(true);

      WritableCellFormat cellFormatTitle = new WritableCellFormat();
      cellFormatTitle.setAlignment(jxl.format.Alignment.CENTRE);
      cellFormatTitle.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      cellFormatTitle.setFont(new WritableFont(WritableFont.createFont("仿宋"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK));
      cellFormatTitle.setBorder(Border.ALL, BorderLineStyle.THIN);
      cellFormatTitle.setWrap(true);

      WritableCellFormat cellFormatTitle_l = new WritableCellFormat();
      cellFormatTitle_l.setAlignment(jxl.format.Alignment.LEFT);
      cellFormatTitle_l.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      cellFormatTitle_l.setFont(new WritableFont(WritableFont.createFont("仿宋"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK));
      cellFormatTitle_l.setBorder(Border.ALL, BorderLineStyle.THIN);
      cellFormatTitle_l.setWrap(true);

      WritableCellFormat cellFormatTitle_r = new WritableCellFormat();
      cellFormatTitle_r.setAlignment(jxl.format.Alignment.RIGHT);
      cellFormatTitle_r.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      cellFormatTitle_r.setFont(new WritableFont(WritableFont.createFont("仿宋"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK));
      cellFormatTitle_r.setBorder(Border.ALL, BorderLineStyle.THIN);
      cellFormatTitle_r.setWrap(true);

      WritableCellFormat cellFormatTitle_lt = new WritableCellFormat();
      cellFormatTitle_lt.setAlignment(jxl.format.Alignment.LEFT);
      cellFormatTitle_lt.setVerticalAlignment(jxl.format.VerticalAlignment.TOP);
      cellFormatTitle_lt.setFont(new WritableFont(WritableFont.createFont("仿宋"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK));
      cellFormatTitle_lt.setBorder(Border.ALL, BorderLineStyle.THIN);
      cellFormatTitle_lt.setWrap(true);

      WritableCellFormat cellFormatContent = new WritableCellFormat();
      cellFormatContent.setAlignment(jxl.format.Alignment.CENTRE);
      cellFormatContent.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      cellFormatContent.setFont(new WritableFont(WritableFont.createFont("仿宋"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK));
      cellFormatContent.setBorder(Border.ALL, BorderLineStyle.THIN);
      cellFormatContent.setWrap(true);

      sheet.setRowView(0, 800);
      sheet.setColumnView(0, 6);
      sheet.setColumnView(1, 20);
      sheet.setColumnView(2, 20);
      sheet.setColumnView(3, 6);
      sheet.setColumnView(4, 6);
      curCol = 4;
      for (int i = 1; i <= gysSum; i++) {
        curCol += 1;
        sheet.setColumnView(curCol, 15);
      }
      sheet.setColumnView(curCol + 1, 10);
      sheet.setColumnView(curCol + 2, 15);
      curCol = 0;
      //合并单元格 通过writablesheet.mergeCells(int x,int y,int m,int n);来实现的
      //表示将从第x+1列，y+1行到m+1列，n+1行合并 (四个点定义了两个坐标，左上角和右下角)
      //结果是合并了m-x+1行，n-y+1列，两者乘积就是合并的单元格数量。
      //标题
      sheet.mergeCells(0, 0, allColums - 1, 0);//标题
      //      sheet.mergeCells(0, 0, 20, 0);//标题
      Label title = new Label(0, 0, "商品报价汇总对照评议表", cellFormatBigTitle);
      sheet.addCell(title);
      //简要信息部分
      curRow += 1;
      sheet.mergeCells(0, 1, 1, 1);//招标编号
      sheet.mergeCells(2, 1, 4, 1);//招标编号 值
      sheet.mergeCells(0, 2, 1, 2);//开标时间
      sheet.mergeCells(2, 2, 4, 2);//开标时间 值
      sheet.mergeCells(5, 1, 6, 1);//委托单号
      //      sheet.mergeCells(7, 1, 9, 1);//委托单号 值
      sheet.mergeCells(7, 1, allColums - 1, 1);//委托单号 值
      sheet.mergeCells(5, 2, 6, 2);//采购单位
      //      sheet.mergeCells(7, 2, 9, 2);//采购单位 值 
      sheet.mergeCells(7, 2, allColums - 1, 2);//采购单位 值  
      Label zbbh = new Label(0, 1, "招标编号", cellFormatTitle);
      Label zbbhv = new Label(2, 1, mainMap.get("PROJ_CODE"), cellFormatTitle);
      Label kbsj = new Label(0, 2, "开标时间", cellFormatTitle);
      Label kbsjv = new Label(2, 2, mainMap.get("OPEN_BID_TIME"), cellFormatTitle);
      Label wtdh = new Label(5, 1, "委托单号", cellFormatTitle);
      Label wtdhv = new Label(7, 1, mainMap.get("MAKE_CODE"), cellFormatTitle_l);
      Label cgdw = new Label(5, 2, "采购单位", cellFormatTitle);
      Label cgdwv = new Label(7, 2, mainMap.get("CO_NAME"), cellFormatTitle_l);
      sheet.addCell(zbbh);
      sheet.addCell(zbbhv);
      sheet.addCell(kbsj);
      sheet.addCell(kbsjv);
      sheet.addCell(wtdh);
      sheet.addCell(wtdhv);
      sheet.addCell(cgdw);
      sheet.addCell(cgdwv);

      HashMap<String, Integer> colWidthMap = new HashMap<String, Integer>();
      //表格的表头部分,表头部分含有两行
      curRow += 2;
      curCol = 0;
      sheet.mergeCells(curCol, curRow, curCol, curRow + 1);//序号
      Label xh = new Label(curCol, curRow, "序号", cellFormatTitle);
      sheet.addCell(xh);
      colWidthMap.put("" + curCol, new Integer("序号".length()));

      curCol += 1;
      sheet.mergeCells(curCol, curRow, curCol, curRow + 1);//商品名称
      Label spmc = new Label(curCol, curRow, "商品名称", cellFormatTitle);
      sheet.addCell(spmc);
      colWidthMap.put("" + curCol, new Integer("商品名称".length()));

      curCol += 1;
      sheet.mergeCells(curCol, curRow, curCol, curRow + 1);//品牌规格型号
      Label ggxh = new Label(curCol, curRow, "品牌规格型号", cellFormatTitle);
      sheet.addCell(ggxh);
      colWidthMap.put("" + curCol, new Integer("品牌规格型号".length()));

      curCol += 1;
      sheet.mergeCells(curCol, curRow, curCol, curRow + 1);//单位
      Label dw = new Label(curCol, curRow, "单位", cellFormatTitle);
      sheet.addCell(dw);
      colWidthMap.put("" + curCol, new Integer("单位".length()));

      curCol += 1;
      sheet.mergeCells(curCol, curRow, curCol, curRow + 1);//数量
      Label sl = new Label(curCol, curRow, "数量", cellFormatTitle);
      sheet.addCell(sl);
      colWidthMap.put("" + curCol, new Integer("数量".length()));

      curCol += 1;
      sheet.mergeCells(curCol, curRow, curCol + gysSum - 1, curRow);//报价单位 商品报价（元）品牌
      Label bj = new Label(curCol, curRow, "报价单位 商品报价（元）", cellFormatTitle);
      sheet.addCell(bj);

      curCol += gysSum;
      sheet.mergeCells(curCol, curRow, curCol + 1, curRow);//成交结果 
      Label cjjg = new Label(curCol, curRow, "成交结果", cellFormatTitle);
      sheet.addCell(cjjg);

      curCol = 5;
      curRow += 1;
      for (int i = 1; i <= gysSum; i++) {
        String gysName = mainMap.get("GYS_" + i);
        Label gys = new Label(curCol, curRow, gysName, cellFormatContent);
        sheet.addCell(gys);
        colWidthMap.put("" + curCol, new Integer(gysName.length()));
        curCol += 1;
      }
      Label cjje = new Label(curCol, curRow, "成交金额", cellFormatTitle);
      sheet.addCell(cjje);
      colWidthMap.put("" + curCol, new Integer("成交金额".length()));
      curCol += 1;
      Label cjgys = new Label(curCol, curRow, "成交供应商", cellFormatTitle);
      sheet.addCell(cjgys);
      //设置列宽

      /* for (int i = 1; i < allColums; i++) {

         CellView cellView = new CellView();
         cellView.setAutosize(true); //设置自动大小  
         sheet.setColumnView(i, cellView);//根据内容自动设置列宽  
       }*/
      //表主体，数据内容
      curRow += 1;
      curCol = 0;
      for (int i = 0; i < subLst.size(); i++) {
        HashMap rowMap = subLst.get(i);
        Label INDX = new Label(curCol, curRow, (String) rowMap.get("INDX"), cellFormatContent);
        sheet.addCell(INDX);

        curCol += 1;
        Label MER_NAME = new Label(curCol, curRow, (String) rowMap.get("MER_NAME"), cellFormatContent);
        sheet.addCell(MER_NAME);

        curCol += 1;
        Label MER_SPEC = new Label(curCol, curRow, (String) rowMap.get("MER_SPEC"), cellFormatContent);
        sheet.addCell(MER_SPEC);

        curCol += 1;
        Label UNIT = new Label(curCol, curRow, (String) rowMap.get("UNIT"), cellFormatContent);
        sheet.addCell(UNIT);

        curCol += 1;
        Label NUM = new Label(curCol, curRow, (String) rowMap.get("NUM"), cellFormatContent);
        sheet.addCell(NUM);

        for (int j = 1; j <= gysSum; j++) {
          curCol += 1;
          Object temp = rowMap.get("GYS_SUM_" + j);
          String tempStr = "";
          if (temp instanceof Double) {
            Double dd = (Double) temp;
            if (dd.doubleValue() > 0.0) {
              tempStr = "" + dd.doubleValue();
            }
          } else {
            tempStr = "" + temp;
          }
          Label gys = new Label(curCol, curRow, "" + tempStr, cellFormatContent);
          //          Double d = (Double) rowMap.get("GYS_SUM_" + j);
          //          Label gys = new Label(curCol, curRow, "" + d.doubleValue(), cellFormatContent);
          sheet.addCell(gys);
        }

        curCol += 1;
        Object o = rowMap.get("WIN_SUM");
        String wsStr = "";
        if (o instanceof Double) {
          Double dd = (Double) o;
          if (dd.doubleValue() > 0.0) {
            wsStr = "" + dd.doubleValue();
          }
        } else {
          wsStr = "" + o;
        }
        Label WIN_SUM = new Label(curCol, curRow, wsStr, cellFormatContent);
        sheet.addCell(WIN_SUM);

        curCol += 1;
        String winGys = (String) rowMap.get("WIN_GYS");
        Label WIN_GYS = new Label(curCol, curRow, winGys, cellFormatContent);
        sheet.addCell(WIN_GYS);
        colWidthMap.put("" + curCol, new Integer(winGys.length()));

        curCol = 0;
        curRow += 1;
      }
      /* for (int i = 0; i < allColums; i++) {
         Integer w = colWidthMap.get("" + i);
         sheet.setColumnView(i, w.intValue());
       }*/
      //尾部
      curCol = 0;
      sheet.mergeCells(curCol, curRow, allColums - 1, curRow);//评价意见：依据最低价成交原则 
      Label yijian = new Label(curCol, curRow, "评价意见：依据最低价成交原则", cellFormatTitle_lt);
      sheet.addCell(yijian);
      sheet.setRowView(curRow, 800);

      curRow += 1;
      sheet.mergeCells(curCol, curRow, allColums - 1, curRow);//询价小组签名： 
      Label qianming = new Label(curCol, curRow, "询价小组签名：", cellFormatTitle_lt);
      sheet.addCell(qianming);
      sheet.setRowView(curRow, 800);

      /*for (int i = 1; i < allColums; i++) {
        CellView cellView = new CellView();
        cellView.setAutosize(true); //设置自动大小  
        sheet.setColumnView(i, cellView);//根据内容自动设置列宽  
      }*/

      success = true;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      errorInfo = e.getMessage();
    } finally {
      try {
        book.write();
        book.close();
        os.flush();
        os.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    if (success) {
      JOptionPane.showMessageDialog(parent, "导出【询价投标信息】成功！\n", "导出成功", JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(parent, "导出【询价投标信息】出错！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
    }
    return success;
  }
}
