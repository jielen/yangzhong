<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="com.ufgov.gmap.context.ApplusContext"%>
<%@page import="com.ufgov.portal.tools.service.ApService"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSONArray"%>
<%
	//System.out.println("############:" + request.getQueryString());
	if(request.getQueryString() == null){
		return;
	}
	String token = (String)session.getAttribute("current.user.token");
	long pagePortletId = Long.valueOf(request.getParameter("pagePortletId")).longValue();
	String groupId = request.getParameter("groupId");
	String pageId = request.getParameter("pageId");
	
	ApService service = (ApService)ApplusContext.getBean("apService");
	String result = service.getListArticlePageBypgPletId_Search(groupId, pageId, pagePortletId, false, 0, 10000,10,"");
	
%>

<html>
	<head></head>
	<script type="text/javascript">
	var req = false;
	var vsPubTime = ''; 
    function getDetailMessage(articleId, pubTime) {
      if(window.XMLHttpRequest) {
      	req = new XMLHttpRequest();
      }
      else if(window.ActiveXObject) {
       	req = new ActiveXObject("Microsoft.XMLHttp");
      }
          
      if(req){
    	vsPubTime = pubTime;  
        var paramJSONArray = "[{\"index\":0,\"value\":" + articleId + ",\"jsValueIsArray\":false,\"wrapperTypes\":\"\",\"clsId\":\"ufgov.portal.common.Param\"}]";  
      	var vsUrl = "remoteCallServiceAction.action?serviceMethodName=apService.selectByPrimaryKey_ApArticle"
          		  + "&paramReflectType=manual&paramJSONArray=" + paramJSONArray;
        req.open("GET", vsUrl, true); 
        req.onreadystatechange = callback; 
        req.send(null); 
      }
    }
        
    function callback() {
      if(req.readyState == 4) {
        if(req.status == 200) {
        	displayDetail(); 
        }else { 
            //alert("服务端返回状态" + req.statusText);
        }
      }else{
         //document .getElementById ("myTime").innerHTML ="数据加载中";
       }
     }
    function displayDetail(){
        //debugger;
    	window.articleJSON = eval("(" + req.responseText + ')');
    	window.articleJSON.pubTime1 = vsPubTime;
    	if(parent && parent.logoHtml){
    	  window.articleJSON.logoHtml = parent.logoHtml;
    	}else{
    		window.articleJSON.logoHtml = '';
    	}
		window.open("<%=request.getContextPath()%>/html/portlet/article/article-detail.html"
				,'maxwindow',"top=0,left=0,width="+screen.availWidth+",height="+ screen.availHeight+",scrollbars=yes,toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no"); 
    }
    
    </script>
	<BODY bgcolor="#FFFFFF" style="margin:0" align=center >
		<div align=center style="position:relative;top:5;left:5; right:5; bottom:5">
	  		<marquee width="90%" height=300 onmouseover=stop() onmouseout=start() direction="up" scrollamount="2" behavior=scroll scrolldelay="120">
	  			<div id="content" align="center">
	  			<%
	  				String detailUrl = request.getContextPath() + "/html/portlet/article/article-detail.html";
	  				JSONObject json = JSONObject.fromObject(result);
	  				JSONArray arrayResult = json.getJSONArray("datas");
	  				int size = arrayResult.size();
	  				for(int i = 0; i < size; i++){
	  					JSONObject obj = arrayResult.getJSONObject(i);
	  			%>
	  					<a href="javascript:void(0);" onclick="getDetailMessage('<%=obj.get("id")%>','<%=obj.get("pubTime")%>')">
	  						<b><font color="#006699"><%=obj.get("title")%></font></b>
	  					</a>
	  			<%		
	  				}
	  				if(size == 0){
	  					out.println("<b><font color=\"#006699\">暂无信息</font></b>");
	  				}
	  			%>
	  			</div>
	  		</marquee>
    	</div>
	</body>
	
</html>	