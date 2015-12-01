package com.ufgov.zc.client.zc.zcebsignup;import java.awt.Color;import java.awt.Container;import java.awt.Font;import java.awt.Window;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.swing.BorderFactory;import javax.swing.JFrame;import javax.swing.JOptionPane;import javax.swing.SwingUtilities;import javax.swing.UIManager;import javax.swing.border.TitledBorder;import javax.swing.table.TableModel;import org.apache.log4j.Logger;import com.ufgov.smartclient.common.DefaultInvokeHandler;import com.ufgov.smartclient.common.UIUtilities;import com.ufgov.smartclient.component.table.JGroupableTable;import com.ufgov.smartclient.plaf.BlueLookAndFeel;import com.ufgov.zc.client.common.AsOptionMeta;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.common.MyTableModel;import com.ufgov.zc.client.common.ParentWindowAware;import com.ufgov.zc.client.common.ServiceFactory;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.client.common.converter.ZcEbSignupToTableModelConverter;import com.ufgov.zc.client.component.JFuncToolBar;import com.ufgov.zc.client.component.button.DeleteButton;import com.ufgov.zc.client.component.button.EditButton;import com.ufgov.zc.client.component.button.HelpButton;import com.ufgov.zc.client.component.ui.AbstractDataDisplay;import com.ufgov.zc.client.component.ui.AbstractEditListBill;import com.ufgov.zc.client.component.ui.AbstractSearchConditionArea;import com.ufgov.zc.client.component.ui.MultiDataDisplay;import com.ufgov.zc.client.component.ui.SaveableSearchConditionArea;import com.ufgov.zc.client.component.ui.TableDisplay;import com.ufgov.zc.client.component.ui.conditionitem.AbstractSearchConditionItem;import com.ufgov.zc.client.component.ui.conditionitem.SearchConditionUtil;import com.ufgov.zc.client.util.BalanceUtil;import com.ufgov.zc.client.util.ListUtil;import com.ufgov.zc.client.zc.ZcUtil;import com.ufgov.zc.client.zc.flowconsole.DataFlowConsoleCanvas;import com.ufgov.zc.common.commonbiz.model.SearchCondition;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.WFConstants;import com.ufgov.zc.common.system.constants.ZcSettingConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.HuiyuanUnitcominfo;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.common.zc.model.ZcEbSignup;import com.ufgov.zc.common.zc.model.ZcEbSupplier;import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;import com.ufgov.zc.common.zc.publish.IZcEbSignupServiceDelegate;/** *  * @ClassName: ZcEbSignupListPanel *  * @Description: TODO供应商报名列表 *  * @date: Apr 21, 2010 3:48:57 PM *  * @version: V1.0 *  * @since: 1.0 *  * @author: xiaofei *  * @modify: */public class ZcEbSignupListPanel extends AbstractEditListBill implements		ParentWindowAware {	private static final Logger logger = Logger			.getLogger(ZcEbSignupListPanel.class);	private ZcEbSignupListPanel self = this;	private Window parentWindow;	private String compoId = "ZC_EB_SIGNUP";	private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();	private ElementConditionDto elementConditionDto = new ElementConditionDto();	private IZcEbSignupServiceDelegate zcEbSignupServiceDelegate = (IZcEbSignupServiceDelegate) ServiceFactory			.create(IZcEbSignupServiceDelegate.class,"zcEbSignupServiceDelegate");		private IZcEbBaseServiceDelegate baseDelegate=(IZcEbBaseServiceDelegate)ServiceFactory			.create(IZcEbBaseServiceDelegate.class,"zcEbBaseServiceDelegate");			public Window getParentWindow() {		return parentWindow;	}	public void setParentWindow(Window parentWindow) {		this.parentWindow = parentWindow;	}	private final class DataDisplay extends MultiDataDisplay {		private DataDisplay(List<TableDisplay> displays,				List<TableDisplay> showingDisplays,				AbstractSearchConditionArea conditionArea,				boolean showConditionArea) {			super(displays, showingDisplays, conditionArea, showConditionArea,					ZcSettingConstants.TAB_ID_ZC_EB_SIGNUP,AsOptionMeta.getOptVal(ZcSettingConstants.ZC_OPTON_SIGNUP_HELP_MSG));			setBorder(BorderFactory.createTitledBorder(					BorderFactory.createEtchedBorder(),  LangTransMeta.translate("ZC_SUPPLIER_SIGNUP_TITLE"),					TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",					Font.BOLD, 15), Color.BLUE));		}		protected void preprocessShowingTableDisplay(				List<TableDisplay> showingTableDisplays) {			for (final TableDisplay d : showingTableDisplays) {				final JGroupableTable table = d.getTable();				table.addMouseListener(new MouseAdapter() {					public void mouseClicked(MouseEvent e) {						if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {							String tabStatus = d.getStatus();							JGroupableTable table = d.getTable();							MyTableModel model = (MyTableModel) table.getModel();							List viewList = viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));							int row = table.getSelectedRow();							if(tabStatus.equals("biding")){								ZcEbProj proj=(ZcEbProj) viewList.get(row);								ZcEbSignup signup=getSignuped(proj.getProjCode(),requestMeta.getSvUserID());								if(signup==null){									signup=createNewSignup(proj);								}								viewList.clear();								viewList.add(signup);							}else if(tabStatus.equals("opened")){								 JOptionPane.showMessageDialog(self, "项目已经过了报名截止时间！", "提示", JOptionPane.INFORMATION_MESSAGE);								 return;							}							new ZcEbSignupDialog(self, viewList, row, tabStatus);						}					}				});			}		}		//根据项目和当前登录入（供应商）获取已经报名的情况		protected ZcEbSignup getSignuped(String projCode, String svUserID) {			// TCJLODO Auto-generated method stub			ElementConditionDto dto=new ElementConditionDto();			dto.setProjCode(projCode);			dto.setZcText1(svUserID);			List signupLst=zcEbSignupServiceDelegate.getZcEbSignupList(dto,requestMeta);			if(signupLst!=null && signupLst.size()>0){				return (ZcEbSignup) signupLst.get(0);			}			return null;		}		protected ZcEbSignup createNewSignup(ZcEbProj proj) {			// TCJLODO Auto-generated method stub			ZcEbSignup signup=new ZcEbSignup();			signup.setProjCode(proj.getProjCode());			signup.setProjName(proj.getProjName());		      signup.setSignupDate(requestMeta.getSysDate());		      signup.setNd(requestMeta.getSvNd());		      signup.setStatus("0");		      signup.setSignupManner("0");		      signup.setIsPayGuarantee("0");		      		      signup.setPurType(proj.getPurType());		      HuiyuanUnitcominfo unit=ZcUtil.getHuiYuan();		      if(unit!=null){		        signup.setAddress(unit.getZhuceaddress());		        signup.setLinkMan(unit.getZfcgGysInfo().getLocallianxiren());		        signup.setPhone(unit.getFarentel());		        signup.setMobilePhone(unit.getZfcgGysInfo().getLocalmobile());	          signup.setProviderCode(unit.getDanweiguid());	          signup.setProviderName(unit.getDanweiname());		      }else{	          signup.setProviderCode(requestMeta.getSvUserID());	          signup.setProviderName(requestMeta.getSvUserName());		        		      }		      signup.setPlan(proj.getPlan());			return signup;		}		@Override		protected void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems,	final TableDisplay tableDisplay) {			elementConditionDto.setWfcompoId(compoId);			elementConditionDto.setExecutor(WorkEnv.getInstance().getCurrUserId());			elementConditionDto.setNd(WorkEnv.getInstance().getTransNd());			elementConditionDto.setStatus(tableDisplay.getStatus());			elementConditionDto.setMonth(BalanceUtil.getMonthIdBySysOption());			// if			// (WorkEnv.getInstance().containRole(AsOptionMeta.getOptVal("OPT_ZC_GYS_NORMAL_ROLE")))			// {			// elementConditionDto.setZcText0(WorkEnv.getInstance().getCurrUserId());			// }//改成用角色数值权限控制数据可见性			for (AbstractSearchConditionItem item : searchConditionItems) {				item.putToElementConditionDto(elementConditionDto);			}			final Container c = tableDisplay.getTable().getParent();			UIUtilities.asyncInvoke(new DefaultInvokeHandler<TableModel>() {				@Override				public void before() {					assert c != null;					installLoadingComponent(c);				}				@Override				public void after() {					assert c != null;					unInstallLoadingComponent(c);					c.add(tableDisplay.getTable());				}				@Override				public TableModel execute() throws Exception {					ZcEbSignupToTableModelConverter mc = new ZcEbSignupToTableModelConverter();					if (tableDisplay.getStatus().equals("todo")//我参与的项目							|| tableDisplay.getStatus().equals("cancel")) {//我撤销报名的项目						  return mc.convertToTableModel(self.zcEbSignupServiceDelegate.getZcEbSignupList(elementConditionDto,requestMeta));					}else if (tableDisplay.getStatus().equals("audit")){            return mc.convertToTableModel(self.zcEbSignupServiceDelegate.getZcEbSignupList(elementConditionDto,requestMeta));					}else {//tableDisplay.getStatus().equals("opened") or tableDisplay.getStatus().equals("biding")//获取正在招标和招标结束的项目  					  if(ZcUtil.isGys()){  					    return mc.convertProjWithPlan(baseDelegate.queryDataForList("ZcEbProj.getProjWithPlan", elementConditionDto,requestMeta));  					  }else{//显示当前投标报名的供应商数量  					    return mc.convertProjWithNums(zcEbSignupServiceDelegate.getZcEbSignupListWithNums(elementConditionDto,requestMeta));  					  }					}				}				@Override				public void success(TableModel model) {					tableDisplay.setTableModel(model);					setButtonStatus();				}			});		}	}	static {		LangTransMeta.init("ZC%");	}	/**	 * 	 * 构造函数	 */	public ZcEbSignupListPanel() {		UIUtilities				.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {					@Override					public List<SearchCondition> execute() throws Exception {						List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil								.getNeedDisplaySearchConditonList(WorkEnv										.getInstance()										.getCurrUserId(),										ZcSettingConstants.TAB_ID_ZC_EB_SIGNUP);						return needDisplaySearchConditonList;					}					@Override					public void success(							List<SearchCondition> needDisplaySearchConditonList) {						List<TableDisplay> showingDisplays = SearchConditionUtil								.getNeedDisplayTableDisplay(needDisplaySearchConditonList);						init(createDataDisplay(showingDisplays), null);// 调用父类方法						revalidate();						repaint();					}				});		requestMeta.setCompoId(compoId);	}	private AbstractSearchConditionArea topSearchConditionArea;	private AbstractSearchConditionArea createTopConditionArea() {		Map defaultValueMap = new HashMap();		topSearchConditionArea = new SaveableSearchConditionArea(				ZcSettingConstants.CONDITION_ID_ZC_EB_SIGNUP, null, true,				defaultValueMap, null);		return topSearchConditionArea;	}	private AbstractDataDisplay createDataDisplay(			List<TableDisplay> showingDisplays) {		return new DataDisplay(				SearchConditionUtil						.getAllTableDisplay(ZcSettingConstants.TAB_ID_ZC_EB_SIGNUP),				showingDisplays, createTopConditionArea(),				false);// true:显示收索条件区 false：不显示收索条件区	}	private EditButton editButton = new EditButton();	private DeleteButton deleteButton = new DeleteButton();	private HelpButton helpButton = new HelpButton();	@Override	protected void addToolBarComponent(JFuncToolBar toolBar) {		toolBar.setModuleCode("ZC");		toolBar.setCompoId(compoId);//		toolBar.add(addButton);		// toolBar.add(editButton);		// toolBar.add(deleteButton);		toolBar.add(helpButton);//		toolBar.add(traceDataButton);		// 初始化按钮的action事件		addButton.addActionListener(new ActionListener() {			public void actionPerformed(ActionEvent e) {				doAdd();			}		});		editButton.addActionListener(new ActionListener() {			public void actionPerformed(ActionEvent e) {				doEdit();			}		});		deleteButton.addActionListener(new ActionListener() {			public void actionPerformed(ActionEvent e) {				doDelete();			}		});		traceDataButton.addActionListener(new ActionListener() {			public void actionPerformed(ActionEvent arg0) {				doTraceDataButton();			}		});	}	public void refreshCurrentTabData() {		topSearchConditionArea.doSearch();	}	public List getCheckedList() {		List<ZcEbSignup> beanList = new ArrayList<ZcEbSignup>();		JGroupableTable table = topDataDisplay.getActiveTableDisplay()				.getTable();		MyTableModel model = (MyTableModel) table.getModel();		// Modal的数据		List list = model.getList();		Integer[] checkedRows = table.getCheckedRows();		for (Integer checkedRow : checkedRows) {			int accordDataRow = table.convertRowIndexToModel(checkedRow);			ZcEbSignup bean = (ZcEbSignup) list.get(accordDataRow);			beanList.add(bean);		}		return beanList;	}	private void doAdd() {		new ZcEbSignupDialog(self, new ArrayList(), this.topDataDisplay				.getActiveTableDisplay().getTable().getRowCount(),				topDataDisplay				.getActiveTableDisplay().getStatus());	}	private void doEdit() {	}	private void doDelete() {	}	private void setButtonStatus() {		String pageStatus = topDataDisplay.getActiveTableDisplay().getStatus();		if (WFConstants.AUDIT_TAB_STATUS_CANCEL.equals(pageStatus)) {			this.addButton.setVisible(false);			this.traceButton.setVisible(false);		} else {			this.addButton.setVisible(true);			this.traceButton.setVisible(true);		}	}	public static void main(String[] args) throws Exception {		SwingUtilities.invokeLater(new Runnable() {			public void run() {				try {					UIManager.setLookAndFeel(UIManager							.getSystemLookAndFeelClassName());					UIManager.setLookAndFeel(new BlueLookAndFeel());				} catch (Exception e) {					e.printStackTrace();				}				// UIManager.getDefaults().put("SplitPaneUI",				// BigButtonSplitPaneUI.class.getName());				ZcEbSignupListPanel bill = new ZcEbSignupListPanel();				JFrame frame = new JFrame("frame");				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				frame.setSize(800, 600);				frame.setLocationRelativeTo(null);				frame.getContentPane().add(bill);				frame.setVisible(true);			}		});	}	public void refreshCurrentTabData(List dataList) {		ZcEbSignupToTableModelConverter mc = new ZcEbSignupToTableModelConverter();		topDataDisplay.getActiveTableDisplay().getTable()				.setModel(mc.convertToTableModel(dataList));	}	private void doTraceDataButton() {		List beanList = getCheckedList();		if (beanList.size() == 0) {			JOptionPane.showMessageDialog(this, "请选择一条要进行跟踪的数据！", "错误",					JOptionPane.ERROR_MESSAGE);			return;		}		ZcEbSignup sh = (ZcEbSignup) beanList.get(0);		DataFlowConsoleCanvas dfc = new DataFlowConsoleCanvas(sh.getProjCode(),				this.compoId);		dfc.showWindow();	}	  public ZcEbSupplier fetchZcEbSupplier() {		    ZcEbSupplier sup = new ZcEbSupplier();		    List supplierList = baseDelegate.queryDataForList("ZcEbSupplier.getZcEbSupplierById", requestMeta.getSvUserID(), requestMeta);		    if (supplierList != null && supplierList.size() > 0)		      sup = (ZcEbSupplier) supplierList.get(0);		    return sup;		  }}