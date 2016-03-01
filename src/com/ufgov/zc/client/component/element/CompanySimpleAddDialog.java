/**
 * 
 */
package com.ufgov.zc.client.component.element;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ufgov.smartclient.plaf.BlueLookAndFeel;
import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.client.component.GkBaseDialog;
import com.ufgov.zc.client.component.JFuncToolBar;
import com.ufgov.zc.client.component.button.ExitButton;
import com.ufgov.zc.client.component.button.FuncButton;
import com.ufgov.zc.client.component.button.SaveButton;
import com.ufgov.zc.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.zc.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.zc.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.zc.client.datacache.CompanyDataCache;
import com.ufgov.zc.common.commonbiz.model.Company;
import com.ufgov.zc.common.commonbiz.model.MaCompany;
import com.ufgov.zc.common.system.Guid;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

/**
 * 简单的增加预算单位的对话框
 * @author Administrator
 */
public class CompanySimpleAddDialog extends GkBaseDialog {

  /**
   * 
   */
  private static final long serialVersionUID = -5963292181343773268L;

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  protected CompanyTreeSelectDialog companyeTreeDialog;

  public CompanySimpleAddDialog(CompanyTreeSelectDialog companyTreeSelectDialog) {

    super(companyTreeSelectDialog);
    this.companyeTreeDialog = companyTreeSelectDialog;

    CompanyInfoPanel editPanel = new CompanyInfoPanel(this);

    setLayout(new BorderLayout());

    add(editPanel);

    this.setTitle("新增单位");

    this.setSize(400, 150);

    this.moveToScreenCenter();

    this.setVisible(true);
  }

  private class CompanyInfoPanel extends AbstractMainSubEditPanel {

    private FuncButton saveButton = new SaveButton();

    private FuncButton exitButton = new ExitButton();

    private GkBaseDialog parent = null;

    TextFieldEditor coField = new TextFieldEditor("单位名称", "coName");

    public CompanyInfoPanel(GkBaseDialog parent) {
      workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "新增单位", TitledBorder.CENTER, TitledBorder.TOP,

      new Font("宋体", Font.BOLD, 15), Color.BLUE));

      this.colCount = 3;

      this.parent = parent;

      requestMeta.setCompoId("ZC_EB_ENTRUST");

      //    initFieldEditors();

      init();
    }

    @Override
    public void initToolBar(JFuncToolBar toolBar) {

      //      toolBar.setModuleCode("ZC");

      //      toolBar.setCompoId("ZC_EB_ENTRUST");

      toolBar.add(exitButton);

      toolBar.add(saveButton);
      saveButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // 保存
          doSave();
        }
      });

      exitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          doExit();
        }
      });

    }

    protected void doExit() {
      parent.dispose();
    }

    protected void doSave() {
      String name = (String) coField.getValue();
      if (name == null || name.trim().length() == 0) {
        JOptionPane.showMessageDialog(this, "名称不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
        return;
      }
      IZcEbBaseServiceDelegate zcEbBaseServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class, "zcEbBaseServiceDelegate");

      if (existSameName(zcEbBaseServiceDelegate, name)) {
        JOptionPane.showMessageDialog(this, "存在同名的单位！", "提示", JOptionPane.INFORMATION_MESSAGE);
        return;
      }
      int num = JOptionPane.showConfirmDialog(this, "确定增加单位：" + name + "?", "确认", 0);

      if (num == JOptionPane.NO_OPTION) { return; }
      //1.增加单位 ma_company,默认编号以990开头，6位编码
      ElementConditionDto dto = new ElementConditionDto();
      dto.setNd(requestMeta.getSvNd());
      HashMap maxCodeMap = (HashMap) zcEbBaseServiceDelegate.queryObject("selectPage.selectMaxCoCode", dto, requestMeta);
      int code = 990001;
      if (maxCodeMap != null && !maxCodeMap.isEmpty()) {
        String codeStr = (String) maxCodeMap.get("COCODE");
        if (codeStr != null) {
          code = Integer.parseInt(codeStr) + 1;
        }
      }
      MaCompany company = new MaCompany();
      company.setNd(new BigDecimal(requestMeta.getSvNd()));
      company.setCoCode("" + code);
      company.setCoName(name);
      company.setCoFullna(name);
      company.setCoTypeCode("02");
      company.setIsUsed("Y");
      company.setfOrgCode("600");
      company.setIsSelf("N");
      company.setProvince("*");
      company.setCity("*");
      company.setIsLowest("Y");
      company.setFinaLevel("01");
      company.setTransDate(requestMeta.getSysDate());
      company.setIsNeedSendBankSl("N");
      company.setCanGetbill("Y");
      company.setCanCharge("Y");
      company.setGuid(Guid.genID());
      company.setTriggerEnable(new Short("1"));
      zcEbBaseServiceDelegate.insertDataForObject("MA_COMPANY.ibatorgenerated_insert", company, requestMeta);

      //下面的插入通过触发器TRIGGER_ZC_MA_COMPANY进行
      //2.增加内部机构 as_org        

      //3.as_org_position

      //4.as_emp

      //5.as_emp_position

      //6.as_user

      //7.as_user_group
      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      CompanyDataCache.refreshData();
      doExit();
      Company c = new Company();
      c.setCode(company.getCoCode());
      c.setName(company.getCoName());
      CompanySimpleAddDialog.this.companyeTreeDialog.getTheNewAddCompany(c);
    }

    private boolean existSameName(IZcEbBaseServiceDelegate zcEbBaseServiceDelegate, String name) {
      ElementConditionDto dto = new ElementConditionDto();
      dto.setZcText0(name);
      dto.setNd(requestMeta.getSvNd());
      HashMap m = (HashMap) zcEbBaseServiceDelegate.queryObject("selectPage.getSameCompany", dto, requestMeta);
      if (m != null && !m.isEmpty()) {
        BigDecimal dd = (BigDecimal) m.get("MT");
        if (dd != null) {
          if (dd.intValue() > 0) { return true; }
        }
      }
      return false;
    }

    @Override
    public List<AbstractFieldEditor> createFieldEditors() {

      List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();
      editorList.add(coField);
      return editorList;
    }

    @Override
    public JComponent createSubBillPanel() {
      return null;
    }

  }

  public static void main(String[] args) throws Exception {

    SwingUtilities.invokeLater(new Runnable() {

      public void run() {

        try {

          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

          UIManager.setLookAndFeel(new BlueLookAndFeel());

        } catch (Exception e) {

          e.printStackTrace();

        }

        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());

        CompanySimpleAddDialog bill = new CompanySimpleAddDialog(null);
        //
        //        JFrame frame = new JFrame("frame");
        //
        //        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        //        frame.setSize(800, 600);
        //
        //        frame.setLocationRelativeTo(null);
        //
        //        frame.getContentPane().add(bill);
        //
        //        frame.setVisible(true);

      }

    });

  }
}
