<%@ page contentType="text/html;charset=utf-8"%>
<html>
<%
	String userId = (String)session.getAttribute("svUserID");
	String userName = (String)session.getAttribute("svUserName");
	String dailytype = request.getParameter("dailytype");
%>
<head>
  
<LINK href="calendar.css" rel=stylesheet>
<SCRIPT language="javascript" src="tip.js"></SCRIPT>
<SCRIPT language="javascript" src="openurl.js"></SCRIPT>
<script language="javascript">
	var svUserName = '<%=userName%>';
	var svUserId = '<%=userId%>';
	document.oncontextmenu= function(){event.returnValue= false;};
	function showTooltip(object, e, tipContent, backcolor, bordercolor, textcolor, displaytime, delaytime){
		if(delaytime==null) delaytime='600';
		window.clearTimeout(tipTimer);

		tipContent=escape(tipContent);
		tipTimer=window.setTimeout("PopupDiv('"+object+"' ,'"+e.x+"' ,\""+tipContent+"\" ,'"+backcolor+"' ,'"+bordercolor+"' ,'"+textcolor+"' ,'"+displaytime+"','"+event.clientX+"','"+event.clientY+"')", delaytime);
	}

	function call_editPageMouseOver(){
	}
	function call_editPageMouseOut(){
	}
	function month_calendar(daynum){
		window.location.href = "myCalendar.jsp?dailytype=1&planday=" + daynum + "&svuserid=" + svUserId;
	}

	function month_change(daynum){
		window.location.href = "myCalendar.jsp?dailytype=<%=dailytype%>&planday=" + daynum  + "&svuserid=" + svUserId;
	}

	function planedit(tempcon){
		tempcon = tempcon.replace("'","");
		tempcon = tempcon.replace("'","");
		parent.dailyPlanDetailCRUD(tempcon,false);
		/*
  		var d = new Date();		
 		// var condition = URLEncoding("OA_ID="+tempcon);	
		tempcon = tempcon.replace("'","");
		tempcon = tempcon.replace("'","");
		
		window.open("/OA/getpage_OA_DAILY_PLAN.action?function=geteditpage&componame=OA_DAILY_PLAN&tablename=OA_DAILY_PLAN&condition=OA_ID="+tempcon,"_blank","height=330,width=650");
		*/	
	}

	function planadd(){
		parent.dailyPlanDetailCRUD('',false);
  		//window.open("/OA/getpage_OA_DAILY_PLAN.action?function=geteditpage&componame=OA_DAILY_PLAN&tablename=OA_DAILY_PLAN&condition=1%3D0","_blank","height=330,width=650");
	}
	function fhelp(){
		window.open("/OA/help/OA/OA_DAILY_PLAN.htm","","top=0,left=465,height=400,width=320,scrollbars=yes");
	}
</script>
</head>

<body style="margin:0">
  <table border=0 cellpadding=0 cellspacing=0 width=100%>
	<tr>
	  <td>
		<table border=0 cellpadding=0 cellspacing=0 align=right>
		  <tr>
			<td><img id="fcommit_leftImg" src="images/left_behind.gif"></td>
	         <td id="fcommit_midBk" background="images/mid_behind.jpg" valign=center align=center nowrap>
	        	<input type="button" name="fcommit" value="新增安排" id="fcommitID" shortCutKey="" isCtrl="n" isShift="n" isAlt="n" title="" class="clsListCallEdit" onMouseOver="call_editPageMouseOver()" onMouseOut="call_editPageMouseOut()" onclick="javascript:planadd();">
	         </td>
			 <td><img id="fcommit_rightImg" src="images/right_behind.gif"></td>
			 <td><img id="fcommit_leftImg" src="images/left_behind.gif"></td>
	         <td id="fcommit_midBk" background="images/mid_behind.jpg" valign=center align=center nowrap>
	        	<input type="button" name="fcommit" value="按月显示" id="fcommitID" shortCutKey="" isCtrl="n" isShift="n" isAlt="n" title="" class="clsListCallEdit" onMouseOver="call_editPageMouseOver()" onMouseOut="call_editPageMouseOut()" onclick="javascript:window.location='myCalendar.jsp?dailytype=3' + '&svuserid=' + svUserId;">
	         </td>
			 <td><img id="fcommit_rightImg" src="images/right_behind.gif"></td>
			 <td><img id="fcommit_leftImg" src="images/left_behind.gif"></td>
	         <td id="fcommit_midBk" background="images/mid_behind.jpg" valign=center align=center nowrap>
	        	<input type="button" name="fcommit" value="按周显示" id="fcommitID" shortCutKey="" isCtrl="n" isShift="n" isAlt="n" title="" class="clsListCallEdit" onMouseOver="call_editPageMouseOver()" onMouseOut="call_editPageMouseOut()" onclick="javascript:window.location='myCalendar.jsp?dailytype=2' + '&svuserid=' + svUserId;">
	         </td>
			 <td><img id="fcommit_rightImg" src="images/right_behind.gif"></td>
			 <td><img id="fcommit_leftImg" src="images/left_behind.gif"></td>
	         <td id="fcommit_midBk" background="images/mid_behind.jpg" valign=center align=center nowrap>
	        	<input type="button" name="fcommit" value="按天显示" id="fcommitID" shortCutKey="" isCtrl="n" isShift="n" isAlt="n" title="" class="clsListCallEdit" onMouseOver="call_editPageMouseOver()" onMouseOut="call_editPageMouseOut()" onclick="javascript:window.location='myCalendar.jsp?dailytype=1' + '&svuserid=' + svUserId;">
	         </td>
			 <td><img id="fcommit_rightImg" src="images/right_behind.gif"></td> 		 		 
		  </tr>
		</table>
	  </td>
	  <td align=center></td>
	  <td align=center></td>
	  <td align=center></td>
	</tr>
  </table>
  <table border=0 cellpadding=0 cellspacing=0 width=99% align=center>
	<tr>
  	  <td valign="top"> 
    	<center>
			<br>
			<jsp:useBean id="personalDailyPlan" scope="page" class="com.ufgov.portal.portlet.calendar.PersonalDailyPlan" />
			<jsp:setProperty name="personalDailyPlan" property="dailytype" />
			<jsp:setProperty name="personalDailyPlan" property="planday" />
			<jsp:setProperty name="personalDailyPlan" property="svuserid" />
			<% personalDailyPlan.printDailyPlan(out);%>
            <br>
		</center>
	  </td>
		  <%
		  //if("3".equals(dailytype))
		  {
		  %>
     <td width=23% valign="top"><br>
			<% personalDailyPlan.printMonthshow(out);%>
     </td>
		  <%
		  }
		  %>
	</tr>
  </table>
</body>
</html>
