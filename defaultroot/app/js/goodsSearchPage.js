//�������а汾�������ԣ�ʹIframe����Ӧ�߶�
function reSetIframe(name){
	var iframe = document.getElementById(name); 
	try{ 
		var bHeight = iframe.contentWindow.document.body.scrollHeight; //iframe���ݸ߶�
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight; //iframe��ǰ�߶�
		var height = Math.max(bHeight,dHeight); //ȡ�ϴ�ֵ�����ݸ������
		iframe.height = height; 
	}catch (ex){} 

}

//�Ѽ���IE��FF
function reSetIframeXH(){
	var iframe = document.getElementById('xh'); 
	try{ 
		var bHeight = iframe.contentWindow.document.body.scrollHeight; //iframe���ݸ߶�
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height;
		if(bHeight!=0){					
			height =bHeight;
		}else{
			height =dHeight;
		}
		iframe.height = height; 
	}catch (ex){} 						
}
window.setInterval("reSetIframeXH()",200);//�ظ�����IDΪXH��Iframe�ĸ߶�

function reSetIframeSearchRseult(){
	var iframe = document.getElementById('searchRseult'); 
	try{ 
		var bHeight = iframe.contentWindow.document.body.scrollHeight; //iframe���ݸ߶�					
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height;
		if(bHeight!=0){					
			height =bHeight;
		}else{
			height =dHeight;
		}
		if(height<580)height=580;
		iframe.height = height; 
	}catch (ex){} 						
}
window.setInterval("reSetIframeSearchRseult()",200);//�ظ�����IDΪsearchRseult��Iframe�ĸ߶�
	
function getElementsByName(name){  //��ЩIE�汾��֧��getElementsByName���Լ�д 
	var all = document.all;   
	var result = [];   
	for(var i=0;i<all.length;i++)   
	if(all[i]["name"]==name)   
	result[result.length] = all[i];   
	return result;   
}

//ѡһ��
function chooseOne(mod){
	var checkID;
	if(mod=="true") checkID = "ImgTrue";
	else if(mod=="false") checkID = "ImgFalse";
	else checkID = "ImgNo";
	var cb=document.getElementById(checkID);     
	//��ȡ��ͬname��chekcBox�ļ���      
	var obj = document.all?getElementsByName("ImgMod"):document.getElementsByName("ImgMod");      
	for (i=0; i<obj.length; i++){      
 		//�ж�obj�����е�iԪ���Ƿ�Ϊcb���������ʾδ��ѡ��      
 		if (obj[i]!=cb) obj[i].checked = false;      
 		//���� ��ԭ��δ��ѡ�� ����ѡ�У���֮ ���Ϊδ��ѡ      
 		//else  obj[i].checked = cb.checked;      
 		//��Ҫ���ٹ�ѡһ���Ļ��������������else�õ���������������      
         		else obj[i].checked = true;      
     		}      
}
 
var toImg = GetCookie("ResultImgMod");
function switchShowMod(mod){
	SetCookieForYear("ResultImgMod",mod) 
	toImg=mod;
	chooseOne(toImg);
	document.getElementById('searchRseult').src=orderURL+"&toImg="+toImg;
}
var imgBaseSrc="../../img/";
var imgBaseName="pl";
var imgBaseId="pic";
function orderPic(baseCode){//
	var orderCode = baseCode;//+orderCodeSc;
	var orderValue = "";
	//orderCodeSc=(orderCodeSc+1)%2;
	var obj = document.all?getElementsByName("orders"):document.getElementsByName("orders");
	try{
		var orders = parseInt(baseCode);
		obj[orders-1].checked = true;
		orderValue = obj[orders-1].value;
		document.getElementById("order"+baseCode).selected = true;
	}catch (ex){}
	document.getElementById('searchRseult').src=orderURL+"&orders="+orderValue+"&toImg="+toImg;

	for(i=0;i<3;i++){//����3������ͼƬ
		var curimgObj=document.getElementById(imgBaseId+(i+1));
		if(i==orders-1){
			curimgObj.src=imgBaseSrc+imgBaseName+(i+1)+".gif";
		}else{
			curimgObj.src=imgBaseSrc+imgBaseName+(i+1)+"1.gif";
		}
	}
}

function initOrderImg(){
	for(i=1;i<4;i++){
		document.getElementById(imgBaseId+(i)).src=imgBaseSrc+imgBaseName+(i)+"1.gif";
	}
}