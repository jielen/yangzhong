<link id=skin_style00 href="../../css/default.css" type="text/css" rel="stylesheet" />
<link id=skin_style10 href="../../css/search.css" type="text/css" rel="stylesheet" />
<link id=skin_style20 href="../../css/menu.css" type="text/css" rel="stylesheet" />
<link id=skin_style30 href="../../css/foot.css" type="text/css" rel="stylesheet" />
<link href="../../css/head.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="/portal/favicon.ico" />
<script type="text/javascript" src="../../js/switch_tab_tag.js"></script>
<script type="text/javascript" src="../../js/xmlextras.js"></script>
<script type="text/javascript" src="../../js/cms2_comm.js"></script>
<script type="text/javascript" src="../../js/skin.js"></script>
<script type="text/javascript">
	var sdate = new Date().getTime();
	var r_count = 0; 
	function document.onkeydown(){
		//F5��ctrl+R
		if(event.keyCode == 116 || (event.ctrlKey && event.keyCode == 82) ){
			if(document.readyState == "complete"){
				var curdate = new Date().getTime();
				r_count++;
				if(curdate - sdate <= 2000){
					event.keyCode = 0;
					return false;
				}else{
					if(r_count >= 2){
						event.keyCode = 0;
						alert("�벻Ҫ�ڶ�ʱ�����ظ�ˢ�£�");
						sdate = new Date().getTime();
						r_count = 0;
						return false;
					}
				}
			}
		}
	}
</script> 
<script type="text/javascript">
	function searchFormSubmit() {
	if(document.getElementById('headSearchKey').value==''){
		alert('��������������');
		return false;
	 }
	document.getElementById('searchForm').submit();	
    }
    
    function gettime(){
		var day="";
		var month="";
		var ampm="";
		var ampmhour="";
		var myweekday="";
		var year="";
		mydate=new Date();
		myweekday=mydate.getDay();
		mymonth=mydate.getMonth()+1;
		myday= mydate.getDate();
		year= mydate.getFullYear();
		if(myweekday == 0)
		weekday=" ������ ";
		else if(myweekday == 1)
		weekday=" ����һ ";
		else if(myweekday == 2)
		weekday=" ���ڶ� ";
		else if(myweekday == 3)
		weekday=" ������ ";
		else if(myweekday == 4)
		weekday=" ������ ";
		else if(myweekday == 5)
		weekday=" ������ ";
		else if(myweekday == 6)
		weekday=" ������ ";
		document.getElementById('time').innerHTML= year+"��"+mymonth+"��"+myday+"�� "+weekday;
		}

	function init(){
	    //gettime();
//	    changeimages('default');
	    //setTimeout("getWebOnline('/new', document.URL)",3000);
	    //getWebOnline('/new', document.URL);
	    //ajaxReq("/new","����");
    }
    

	  function viladateFormy(){
		var a = document.getElementById("search").value;
		if(a=="����ؼ���"){
		  alert("������ؼ��֣�");
		  return;
		}
		if(check_space(a)){
		   document.getElementById("formy").submit();
		}
	 }

	 function check_space(str){
		var re = "/^\s+$/";
		if(re.exec(str)||str.length<1) {
			 document.getElementById("search").focus();
			 return false;
		}else{
			return true;
		}
	}
</script>