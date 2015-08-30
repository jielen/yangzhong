package com.ufgov.zc.server.zc.web.form;import java.util.ArrayList;import java.util.HashMap;import java.util.LinkedHashMap;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.util.ObjectUtil;import com.ufgov.zc.common.zc.model.EvalItemType;import com.ufgov.zc.common.zc.model.ZcEbExpertEvalResult;import com.ufgov.zc.common.zc.model.ZcEbFormulaItem;import com.ufgov.zc.common.zc.model.ZcEbPack;import com.ufgov.zc.common.zc.model.ZcEbProj;import com.ufgov.zc.server.system.SpringContext;import com.ufgov.zc.server.zc.service.IZcEbEvalService;import com.ufgov.zc.server.zc.service.IZcEbFormulaService;import com.ufgov.zc.server.zc.service.IZcEbProjService;public class EvalResultPrintForm extends AbstractActionForm {	private static final long serialVersionUID = -127140804047344129L;	private List evalPackSumResult;	private List evalResultSCList;	public List getEvalResultSCList() {		return evalResultSCList;	}	public void setEvalResultSCList(List evalResultSCList) {		this.evalResultSCList = evalResultSCList;	}	private Map expertDetal;	private Map expertCol;	private Map levelMap;	private int maxLevel;	private List complFormulaItemList;	public List getComplFormulaItemList() {		return complFormulaItemList;	}	public void setComplFormulaItemList(List complFormulaItemList) {		this.complFormulaItemList = complFormulaItemList;	}	public int getMaxLevel() {		return maxLevel;	}	public void setMaxLevel(int maxLevel) {		this.maxLevel = maxLevel;	}	public Map getLevelMap() {		return levelMap;	}	public void setLevelMap(Map levelMap) {		this.levelMap = levelMap;	}	private ZcEbProj zcEbProj;	private ZcEbPack zcEbPack;	// 专家姓名，在显示具体专家评审明细时用于显示专家姓名。	private String expertName;	private String zcAgeyName;	public String getExpertName() {		return expertName;	}	public void setExpertName(String expertName) {		this.expertName = expertName;	}	public String getZcAgeyName() {		return zcAgeyName;	}	public void setZcAgeyName(String zcAgeyName) {		this.zcAgeyName = zcAgeyName;	}	public ZcEbProj getZcEbProj() {		return zcEbProj;	}	public void setZcEbProj(ZcEbProj zcEbProj) {		this.zcEbProj = zcEbProj;	}	public ZcEbPack getZcEbPack() {		return zcEbPack;	}	public void setZcEbPack(ZcEbPack zcEbPack) {		this.zcEbPack = zcEbPack;	}	public Map getExpertDetal() {		return expertDetal;	}	public void setExpertDetal(Map expertDetal) {		this.expertDetal = expertDetal;	}	public Map getExpertCol() {		return expertCol;	}	public void setExpertCol(Map expertCol) {		this.expertCol = expertCol;	}	public List getEvalPackSumResult() {		return evalPackSumResult;	}	public void setEvalPackSumResult(List evalPackSumResult) {		this.evalPackSumResult = evalPackSumResult;	}	// 打分分值汇总结果节目	public String toEvalExpertResultPrint() {		System.out.println("打印专家评分汇总结果");		try {			String projCode = this.getRequest().getParameter("projCode");			String packCode = this.getRequest().getParameter("packCode");			String zcAgeyName = this.getRequest().getParameter("zcAgeyName");			Map param = new HashMap();			param.put("PROJ_CODE", projCode);			param.put("PACK_CODE", packCode);			param.put("IS_COMPLIANCE_RESULT", "N");			param.put("ITEM_CODE", "SC");			IZcEbEvalService zcEbEvalService = (IZcEbEvalService) SpringContext.getBean("zcEbEvalService");			IZcEbProjService zcEbProjService = (IZcEbProjService) SpringContext.getBean("zcEbProjService");			ZcEbProj zcEbProj = zcEbProjService					.getZcEbProjMasterByProjCode(projCode);			ZcEbPack zcEbPack = zcEbProjService.getZcEbPackByPackCode(packCode);			List evalPackSumResultList = zcEbEvalService					.getZcEbEvalPackSumResult(param, null);			List evalResultList = zcEbEvalService.getZcEbEvalResult(param);			Map tempExpertDetal = new HashMap();			LinkedHashMap tempExpertCol = new LinkedHashMap();			for (int i = 0; i < evalResultList.size(); i++) {				ZcEbExpertEvalResult zcEbExpertEvalResult = (ZcEbExpertEvalResult) evalResultList						.get(i);				String providerCode = zcEbExpertEvalResult.getProviderCode();				String evalExpertCode = zcEbExpertEvalResult.getExpertCode();				tempExpertDetal.put(providerCode + evalExpertCode,						zcEbExpertEvalResult.getEvalResult());				if (tempExpertCol.get(evalExpertCode) == null) {					tempExpertCol.put(evalExpertCode,							zcEbExpertEvalResult.getExpertName());				}			}			setZcAgeyName(zcAgeyName);			setZcEbPack(zcEbPack);			setZcEbProj(zcEbProj);			setExpertDetal(tempExpertDetal);			setExpertCol(tempExpertCol);			setEvalPackSumResult(evalPackSumResultList);			this.getRequest().setAttribute("detal", this.getExpertDetal());			this.getRequest().setAttribute("expertCol", this.getExpertCol());			this.getRequest().setAttribute("evalPackSumResult",					this.getEvalPackSumResult());			this.getRequest().setAttribute("zcEbPack", this.getZcEbPack());			this.getRequest().setAttribute("zcEbProj", this.getZcEbProj());			this.getRequest().setAttribute("zcAgeyName", this.getZcAgeyName());			this.getRequest().setAttribute("expertName", this.getExpertName());			return SUCCESS;		} catch (Exception e) {			e.printStackTrace();			throw new RuntimeException(e);		}	}	// 具体某个专家打分的结果	public String toEvalExpertResultDetailPrint() {		System.out.println("打印专家评分结果");		try {			String projCode = this.getRequest().getParameter("projCode");			String packCode = this.getRequest().getParameter("packCode");			String expertCode = this.getRequest().getParameter("expertCode");			expertName = this.getRequest().getParameter("expertName");			String zcAgeyName = this.getRequest().getParameter("zcAgeyName");			Map param = new HashMap();			param.put("PROJ_CODE", projCode);			param.put("PACK_CODE", packCode);			param.put("IS_COMPLIANCE_RESULT", "N");			param.put("ITEM_CODE", "SC");			param.put("ITEM_TYPE", EvalItemType.SCORE);			param.put("EVAL_EXPERT_CODE", expertCode);			IZcEbEvalService zcEbEvalService = (IZcEbEvalService) this					.getApplicationContext().getBean("zcEbEvalService");			IZcEbProjService zcEbProjService = (IZcEbProjService) this					.getApplicationContext().getBean("zcEbProjService");			ZcEbProj zcEbProj = zcEbProjService					.getZcEbProjMasterByProjCode(projCode);			ZcEbPack zcEbPack = zcEbProjService.getZcEbPackByPackCode(packCode);			// 指标项层数			int maxLevel = 0;			// 每层的指标项数据			Map levelMap = new LinkedHashMap();			// 最顶层的指标项数据			Map levelDataMap = new LinkedHashMap();			// 评分指标项			List formulaItemList = zcEbEvalService					.getZcEbEvalFormulaItemReportList(param);			for (int i = 0; i < formulaItemList.size(); i++) {				ZcEbFormulaItem zcEbFormulaItem = (ZcEbFormulaItem) formulaItemList						.get(i);				if (maxLevel < zcEbFormulaItem.getLevels().intValue()) {					maxLevel = zcEbFormulaItem.getLevels().intValue();				}				if (levelMap.get(zcEbFormulaItem.getLevels().toString()) != null) {					List list = (List) levelMap.get(zcEbFormulaItem.getLevels()							.toString());					list.add(zcEbFormulaItem);				} else {					List list = new ArrayList();					list.add(zcEbFormulaItem);					levelMap.put(zcEbFormulaItem.getLevels().toString(), list);				}				if (zcEbFormulaItem.getLeafcount() == 1) {					levelDataMap.put(zcEbFormulaItem.getItemCode(), " ");				}			}			/**			 * 			 * 取编号为SC的评审结果：编号为SC的评审结果是总分			 */			List evalResultSCList = zcEbEvalService.getZcEbEvalResult(param);			param.remove("ITEM_CODE");			/**			 * 			 * 取明细的评审结果			 */			List evalResultList = zcEbEvalService.getZcEbEvalResult(param);			Map tempExpertDetal = new HashMap();			for (int i = 0; i < evalResultList.size(); i++) {				ZcEbExpertEvalResult zcEbExpertEvalResult = (ZcEbExpertEvalResult) evalResultList						.get(i);				String providerCode = zcEbExpertEvalResult.getProviderCode();				if (tempExpertDetal.get(providerCode) != null) {					Map levelDataMapCopy = (Map) tempExpertDetal							.get(providerCode);					if (" ".equals(levelDataMapCopy.get(zcEbExpertEvalResult							.getItemCode()))) {						levelDataMapCopy.put(								zcEbExpertEvalResult.getItemCode(),								zcEbExpertEvalResult.getEvalResult());					}				} else {					Map levelDataMapCopy = (Map) ObjectUtil							.deepCopy(levelDataMap);					if (" ".equals(levelDataMapCopy.get(zcEbExpertEvalResult							.getItemCode()))) {						levelDataMapCopy.put(								zcEbExpertEvalResult.getItemCode(),								zcEbExpertEvalResult.getEvalResult());					}					tempExpertDetal.put(providerCode, levelDataMapCopy);				}			}			setZcEbPack(zcEbPack);			setZcAgeyName(zcAgeyName);			setZcEbProj(zcEbProj);			setLevelMap(levelMap);			setMaxLevel(maxLevel);			setExpertDetal(tempExpertDetal);			setEvalResultSCList(evalResultSCList);			this.getRequest().setAttribute("levelMap", this.getLevelMap());			this.getRequest().setAttribute("maxLevel", "" + this.getMaxLevel());			this.getRequest().setAttribute("detal", this.getExpertDetal());			this.getRequest().setAttribute("expertCol", this.getExpertCol());			this.getRequest().setAttribute("evalResultSCList",					this.getEvalResultSCList());			this.getRequest().setAttribute("zcEbPack", this.getZcEbPack());			this.getRequest().setAttribute("zcEbProj", this.getZcEbProj());			this.getRequest().setAttribute("zcAgeyName", this.getZcAgeyName());			this.getRequest().setAttribute("expertName", this.getExpertName());			return SUCCESS;		} catch (Exception e) {			e.printStackTrace();			throw new RuntimeException(e);		}	}	// 符合性评审汇总结果打印	public String toEvalExpertComplResultPrint() {		try {			String projCode = this.getRequest().getParameter("projCode");			String packCode = this.getRequest().getParameter("packCode");			String zcAgeyName = this.getRequest().getParameter("zcAgeyName");			Map param = new HashMap();			param.put("PROJ_CODE", projCode);			param.put("PACK_CODE", packCode);			param.put("IS_COMPLIANCE_RESULT", "Y");			param.put("ITEM_CODE", "CP");			IZcEbEvalService zcEbEvalService = (IZcEbEvalService)SpringContext.getBean("zcEbEvalService");			IZcEbProjService zcEbProjService = (IZcEbProjService) SpringContext.getBean("zcEbProjService");			ZcEbProj zcEbProj = zcEbProjService					.getZcEbProjMasterByProjCode(projCode);			ZcEbPack zcEbPack = zcEbProjService.getZcEbPackByPackCode(packCode);			List evalPackSumResultList = zcEbEvalService					.getZcEbEvalPackSumResult(param, null);			List evalResultList = zcEbEvalService.getZcEbEvalResult(param);			Map tempExpertDetal = new HashMap();			LinkedHashMap tempExpertCol = new LinkedHashMap();			for (int i = 0; i < evalResultList.size(); i++) {				ZcEbExpertEvalResult zcEbExpertEvalResult = (ZcEbExpertEvalResult) evalResultList						.get(i);				String providerCode = zcEbExpertEvalResult.getProviderCode();				String evalExpertCode = zcEbExpertEvalResult.getExpertCode();				tempExpertDetal.put(providerCode + evalExpertCode,						zcEbExpertEvalResult.getComplianceResult());				if (tempExpertCol.get(evalExpertCode) == null) {					tempExpertCol.put(evalExpertCode,							zcEbExpertEvalResult.getExpertName());				}			}			setZcEbPack(zcEbPack);			setZcAgeyName(zcAgeyName);			setZcEbProj(zcEbProj);			setExpertDetal(tempExpertDetal);			setExpertCol(tempExpertCol);			setEvalPackSumResult(evalPackSumResultList);			this.getRequest().setAttribute("evalPackSumResult",					this.getEvalPackSumResult());			this.getRequest()					.setAttribute("expertDetal", this.getExpertDetal());			this.getRequest().setAttribute("expertCol", this.getExpertCol());			this.getRequest().setAttribute("zcEbPack", this.getZcEbPack());			this.getRequest().setAttribute("zcEbProj", this.getZcEbProj());			this.getRequest().setAttribute("zcAgeyName", this.getZcAgeyName());			this.getRequest().setAttribute("expertName", this.getExpertName());			return SUCCESS;		} catch (Exception e) {			e.printStackTrace();			throw new RuntimeException(e);		}	}	// 具体到某个专家的符合性评审情况	public String toEvalExpertComplResultDetailPrint() {		try {			String projCode = this.getRequest().getParameter("projCode");			String packCode = this.getRequest().getParameter("packCode");			String expertCode = this.getRequest().getParameter("expertCode");			expertName = this.getRequest().getParameter("expertName");			String zcAgeyName = this.getRequest().getParameter("zcAgeyName");			Map param = new HashMap();			param.put("PROJ_CODE", projCode);			param.put("PACK_CODE", packCode);			param.put("IS_COMPLIANCE_RESULT", "Y");			param.put("ITEM_CODE", "CP");			param.put("ITEM_TYPE", EvalItemType.COMPLIANICE);			param.put("EVAL_EXPERT_CODE", expertCode);			IZcEbEvalService zcEbEvalService = (IZcEbEvalService) SpringContext.getBean("zcEbEvalService");			IZcEbFormulaService zcEbFormulaService = (IZcEbFormulaService) SpringContext.getBean("zcEbFormulaService");			IZcEbProjService zcEbProjService = (IZcEbProjService) SpringContext.getBean("zcEbProjService");			ZcEbProj zcEbProj = zcEbProjService					.getZcEbProjMasterByProjCode(projCode);			ZcEbPack zcEbPack = zcEbProjService.getZcEbPackByPackCode(packCode);			ElementConditionDto dto = new ElementConditionDto();			dto.setProjCode(projCode);			setZcAgeyName(zcAgeyName);			dto.setPackCode(packCode);			Map map1 = new HashMap();			String formulaCode = zcEbFormulaService.getZcEbFormulaByPackCode(					dto).getFormulaCode();			map1.put("formulaCode", formulaCode);			map1.put("itemType", EvalItemType.COMPLIANICE);			List formulaItemList = zcEbFormulaService					.getZcEbFormulaItemList(map1);			List noChildList = new ArrayList();			for (int i = 0; i < formulaItemList.size(); i++) {				ZcEbFormulaItem item = (ZcEbFormulaItem) formulaItemList.get(i);				if (!isHaveChild(item.getItemCode(), formulaItemList)) {					noChildList.add(item);				}			}			/**			 * 			 * 汇总的符合性评审结果集合			 */			List evalResultSCList = zcEbEvalService.getZcEbEvalResult(param);			param.remove("ITEM_CODE");			/**			 * 			 * 评审结果子项			 */			List evalResultList = zcEbEvalService.getZcEbEvalResult(param);			Map tempExpertDetal = new HashMap();			for (int j = 0; j < evalResultSCList.size(); j++) {				ZcEbExpertEvalResult zcEbExpertEvalResult = (ZcEbExpertEvalResult) evalResultSCList						.get(j);				StringBuffer unPassReason = new StringBuffer();				Map complEvalResultDetail = new HashMap();				String providerCode = zcEbExpertEvalResult.getProviderCode();				for (int i = 0; i < evalResultList.size(); i++) {					ZcEbExpertEvalResult result = (ZcEbExpertEvalResult) evalResultList							.get(i);					if (providerCode.equals(result.getProviderCode())) {						if (result.getUnPassReason() != null								&& !"".equals(result.getUnPassReason())) {							unPassReason.append(result.getUnPassReason() + ";");						}						complEvalResultDetail.put(result.getItemCode(),								result.getComplianceResult());					}				}				tempExpertDetal.put(providerCode, complEvalResultDetail);				zcEbExpertEvalResult.setUnPassReason(unPassReason.toString());			}			setZcEbPack(zcEbPack);			setZcEbProj(zcEbProj);			setExpertDetal(tempExpertDetal);			setEvalResultSCList(evalResultSCList);			setComplFormulaItemList(noChildList);			this.getRequest().setAttribute("formulaItemList",					this.getComplFormulaItemList());			this.getRequest().setAttribute("evalResultList",					this.getEvalResultSCList());			this.getRequest()					.setAttribute("expertDetal", this.getExpertDetal());			this.getRequest().setAttribute("zcEbPack", this.getZcEbPack());			this.getRequest().setAttribute("zcEbProj", this.getZcEbProj());			this.getRequest().setAttribute("zcAgeyName", this.getZcAgeyName());			this.getRequest().setAttribute("expertName", this.getExpertName());			return SUCCESS;		} catch (Exception e) {			e.printStackTrace();			throw new RuntimeException(e);		}	}	public boolean isHaveChild(String itemCode, List itemList) {		for (int i = 0; i < itemList.size(); i++) {			ZcEbFormulaItem item = (ZcEbFormulaItem) itemList.get(i);			if (item.getParentItemCode().equals(itemCode)) {				return true;			}		}		return false;	}}