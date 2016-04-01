<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="com.ufgov.gmap.context.ApplusContext"%>
<%@page import="com.ufgov.portal.tools.service.ApService"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSONArray"%>
<%
	if(request.getQueryString() == null){
		return;
	}
	String token = (String)session.getAttribute("current.user.token");
	long pagePortletId = 0;
	if(request.getParameter("pagePortletId") != null){
		pagePortletId = Long.valueOf(request.getParameter("pagePortletId")).longValue();
	}
	String groupId = request.getParameter("groupId");
	String pageId = request.getParameter("pageId");
	String height = request.getParameter("height");
	int scrollHeight = 100;
	if(height != null){
		scrollHeight = Integer.parseInt(height);
	}
	ApService service = (ApService)ApplusContext.getBean("apService");
	String result = service.getListArticlePageBypgPletId_Search(groupId, pageId, pagePortletId, false, 0, 10000,10,"");
	
%>
<jsp:include page="/inc/inc.jsp"></jsp:include>
<html>
	<head></head>
	<style>
			a.article:link {color: #ff0000;text-decoration: none;} 
			a.article:visited {color: #ff0000;text-decoration: none;} 
			a.article:hover {color: #6699CC;text-decoration: underline;} 
			a.article:active {color: #6699CC;text-decoration: none;} 
		</style>
	<script type="text/javascript">
    function getDetailMessage(articleId, pubTime) {
      window.open("<%=request.getContextPath()%>/html/portlet/article/articleDetail.jsp?articleId="+articleId+"&pubTime="+pubTime
				,'maxwindow',"top=0,left=0,width="+screen.availWidth+",height="+ screen.availHeight+",scrollbars=yes,toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no"); 
    }
        
    </script>
	<BODY bgcolor="#ECECEC" style="margin:0" align=center >
		<div align=left style="position:relative;top:5;left:5; right:0; bottom:5">
	  		<marquee width="95%" height=<%=scrollHeight-30%> onmouseover="this.stop()" onmouseout="this.start()" direction="up" scrollamount="1" behavior="scroll" scrolldelay="100">
	  				<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
	  			<%
	  				String detailUrl = request.getContextPath() + "/html/portlet/article/article-detail.html";
	  				JSONObject json = JSONObject.fromObject(result);
	  				JSONArray arrayResult = json.getJSONArray("datas");
	  				int size = arrayResult.size();
	  				for(int i = 0; i < size; i++){
	  					JSONObject obj = arrayResult.getJSONObject(i);
	  					String title = obj.get("title") + "";
	  					String showTitle = "";
	  					if(title != null && title.length() > 13){
	  						showTitle = title.substring(0,11) + "……";
	  					}else{
	  						showTitle = title;
	  					}
	  			%>
	  						
              <tr height="20">
              	<td width="100%">
	  					● &nbsp;<a class="article" title="<%=title%>" style="cursor:hand;" href="javascript:void(0);" onclick="getDetailMessage('<%=obj.get("id")%>','<%=obj.get("pubTime")%>')">
	  						<font color="#FF0000"><%=showTitle%></font>
	  					</a>
	  						</td>
              </tr>
	  			<%		
	  				}
	  			%>
	  			</table>
	  		</marquee>
    	</div>
	</body>
	
</html>	