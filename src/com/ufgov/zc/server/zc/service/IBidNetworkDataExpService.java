package com.ufgov.zc.server.zc.service;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;public interface IBidNetworkDataExpService {  public List getZcEbOpenbidTeam(String projectCode);  public List getZcEbOpenbidTeamMember(List teamCodes);  public List getZcEbOpenbidteamPack(String projectCode);  public List getZcEbPackExpert(String projectCode);  public List getExpertIdCard(String projectCode);  //--评审专家对象的平台表  public List getAsUser(List userIds);  public List getAsUserGroup(List userIds);  public List getAsEmp(List userIds);  public List getAsEmpPosition(List empCodes);  public List getZcEbProjectLivingChange(String projectCode);  public List getZcEbProjChg(String projectCode);  public List getZcEbEcbjPlan(String projectCode);  public List getZcEbEcbjItem(String projectCode);  public List getAsFile(List fileId);  public List getZcEbExpertOpinion(String projectCode);  public List getZcEbEvalResult(String projectCode);  public List getZcEbEvalReport(String projectCode);  public List getZcEbPackEvalResult(String projectCode);  public List getZcEbEvalParam(String projectCode);  public List getAsNumTool(String numToolId);  public List getAsNoRule(String compoId);  public List getZcEbProj(String projectCode);  public List getZcEbPack(String projCode);  public List getZcEbSignup(String projCode, RequestMeta meta);  public List getZcEbSignupPack(List signupId);}