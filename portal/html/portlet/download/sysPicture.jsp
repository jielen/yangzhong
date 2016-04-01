<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="com.ufgov.gmap.context.ApplusContext"%>
<%@page import="com.ufgov.gmap.db.base.BaseDao"%>
<%@page import="com.ufgov.gmap.resource.ResourceKeys"%>

<%@page import="java.io.File"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%! 
	public boolean isPic(String resName) {
		String lastName = resName.substring(resName.lastIndexOf(".") + 1);
		
		if("jpg".equals(lastName.toLowerCase()) || "png".equals(lastName.toLowerCase())
			|| "gif".equals(lastName.toLowerCase()) || "bmp".equals(lastName.toLowerCase())
			 || "jpeg".equals(lastName.toLowerCase())) {
			 return true;
		} else {
			return false;
		}
	}
	
	public List getResourcesInfo(HttpServletRequest request) {
		final String GET_UPLOAD_RESOURCES = "portal-common.getUploadResources";
		String pagePortletId = request.getParameter("pagePortletId");
	
		BaseDao dao = (BaseDao)ApplusContext.getBean("baseDao");
		Map paraMap = new HashMap();
		paraMap.put("pagePortletId", pagePortletId);
		paraMap.put("resourceType", "02");
		List apUploadMaps = null;
		try{
			apUploadMaps = dao.queryForList(GET_UPLOAD_RESOURCES, paraMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apUploadMaps;
	}
	
	public Map getFlashParams(HttpServletRequest request) {
		String pictures = "";
		String links = "";
		String texts = "";
		boolean success = false;
		String errorMessage = "您还没有发布图片到此频道，请发布资源后再试!";
		List apUploadMaps = getResourcesInfo(request);
		if(null != apUploadMaps && apUploadMaps.size() != 0) {
			for(int i = 0; i < apUploadMaps.size() && i < 5; i++) {
				Map apUpload = (Map)apUploadMaps.get(i);
				if(null != apUpload){
					String name = apUpload.get("FILE_NAME") == null ? "" : apUpload.get("FILE_NAME").toString();
					String linkUrl = apUpload.get("LINK_URL") == null ? "../../../resources/" + name + "|" : apUpload.get("LINK_URL").toString();
					File tempFile = new File(ApplusContext.getEnvironmentConfig().get(ResourceKeys.CONF_RESOURCE_UPLOAD_PATH) + "/" + name);
					//System.out.println(ApplusContext.getEnvironmentConfig().get(ResourceKeys.CONF_RESOURCE_UPLOAD_PATH) + "/" + name);
		    		if(tempFile.exists() && isPic(name)){
		    			success = true;
		    			pictures += "sysPictureDownload.action?fileid=" + name + "|";
		 				texts += "*|";
		 				links += linkUrl + "|";
		    		} else {
		    			errorMessage = "发布的图片源文件丢失或文件格式错误！";
		    		}
				}
			}
		}
		if(success){
			pictures = pictures.substring(0, pictures.length() - 1);
			texts = texts.substring(0, texts.length() - 1);
			links = links.substring(0, links.length() - 1);
			errorMessage = "";
		}
		System.out.println(pictures);
		Map resMap = new HashMap();
		resMap.put("pictures", pictures);
		resMap.put("texts", texts);
		resMap.put("links", links);
		resMap.put("success", Boolean.valueOf(success));
		resMap.put("errorMessage", errorMessage);
		return resMap;
	}
 %>
<%
	Map paraMap = getFlashParams(request);
	final int focus_width = 375;
	final int focus_height = 400;
	final int text_height=0;
	final int swf_height = focus_height+text_height;
	
%>


<html>
	<head></head>
	<BODY bgcolor="#FFFFFF" style="margin:0" align="center" >
		<div align="center" style="position:relative;top:0;left:0;">
		<% if(((Boolean)paraMap.get("success")).booleanValue()) { 
			String pictures = paraMap.get("pictures").toString();
			String links = paraMap.get("links").toString();
			String texts = paraMap.get("texts").toString();
		%>
			<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="<%= focus_width %>" height="<%= swf_height %>">
 				<param name="allowScriptAccess" value="sameDomain">
 				<param name="movie" value="../../../resources/picChange.swf">
 				<param name="quality" value="high">
 				<param name="bgcolor" value="#F0F0F0">
 				<param name="menu" value="false">
 				<param name="wmode" value="opaque">
 				<param name="FlashVars" value="pics=<%=pictures %>&texts=<%=texts %>&links=<%=links %>&borderwidth=225&borderheight=150&textheight=0">
 				<embed src="../../../resources/picChange.swf" wmode="opaque" FlashVars="pics=<%=pictures %>&texts=<%=texts %>&links=<%=links %>&borderwidth=225&borderheight=150&textheight=0" menu="false" bgcolor="#F0F0F0" quality="high" width="225" height="150" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />  
 			</object>
		<% } else { 
			String errorMessage = paraMap.get("errorMessage").toString();
		%>
	  		<table style="width:100%;height:100%" border="0" cellspacing="0" background=""><tr><td><%= errorMessage %></td></tr></table>
    	<% } %>
    	</div>
	</body>
	
</html>	