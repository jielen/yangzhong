<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String token = (String)session.getAttribute("current.user.token");
	String path = request.getContextPath();
%>

<html>
	<meta http-equiv="refresh" content="300">
	<script type="text/javascript" src="<%=path%>/script/common/PublicFunction.js"></script>
	<style type="text/css">
		<!--
		.font {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			font-weight: normal;
			line-height: normal;
		}
		body{background-color:#D5DFE9;	margin-left: 0px;	
	    font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			font-weight: normal;
			margin-top: 0px;
			margin-right: 0px;
		}
		-->
		</style>
	<script type="text/javascript">
	var req = false; 
    function getWorkTodoMessage() {
      if(window.XMLHttpRequest) {
      	req = new XMLHttpRequest();
      }
      else if(window.ActiveXObject) {
       	req = new ActiveXObject("Microsoft.XMLHttp");
      }
          
      if(req){
      	var vsUrl = "/admin/getWorklist.action?workType=workTodoList&maxRowNum=500&token=<%=token%>&compoList=&start=0&limit=10000";
        req.open("GET", vsUrl, true); 
        req.onreadystatechange = callback; 
        req.send(null); 
      }
    }
        
    function callback() {
      if(req.readyState == 4) {
        if(req.status == 200) {
          display(); 
        }else { 
            //alert("服务端返回状态" + req.statusText);
        }
      }else{
         //document .getElementById ("myTime").innerHTML ="数据加载中";
       }
     }        
     function display() {
     	 var result = eval('(' + req.responseText + ')');
     	 var content = "";
     	 if(null != result && null != result.count && parseInt(result.count) > 0){
     	 	//content += "<ul>";
     	 	for(var i = 0; i < result.data.length; i++){
         	 	var temp = result.data[i];
            content += "<li><a href=\"" + temp.url + "\" target='_blank'>" 
             	 			+ temp.compoName + "-" + temp.title;
            if(temp.brief){
            	content += "[" + temp.brief + "]"
            }
            content += "</a></li>";
         	 	
     	 	}	
     	 //	content += "</ul>";
     	 }else{
     	 	content = "<b><font color=\"#006699\">暂无消息提醒</font></b>";	
     	 }
     	 //debugger;
     	 document.getElementById ("content").innerHTML = content;
     }
     
    //function processMessage(vsUrl){
    // 	PF.openFullScreenWindow(vsUrl);
    //}		
	</script>
	<BODY bgcolor="#FFFFFF" style="margin:0" align="center" onload="getWorkTodoMessage()">
		<div align="center" style="position:relative;top:5;left:20; right:5; bottom:5">
	  		<marquee width="100%" height=120 onmouseover=stop() onmouseout=start() direction="up" scrollamount="2" behavior=scroll scrolldelay="120">
	  			
	  			<table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td  id="content" align="left" class="font">
					    </td>
				  </tr>
				</table>
	  		</marquee>
    	</div>
	</body>
	
</html>	