/*
Ӧ��·����<script type="text/javascript" src="${base}/common_res/js/switch_tab_tag.js"></script>
���ܣ�����tab��ʽ��Ŀ���л�Ч��������ҳ��������߷���
���ߣ��쳿��
ʱ�䣺2009-09-14
*/

/*
���ܣ�����ͨ��iframe��ʾ���ݵ�tab
����˵����
index����ǰ������ǵڼ���tab
type����Ŀ��ҵ�����͡���ʡ������(sjgg)
frameName����ʾ���ݵ�iframe��id
url��iframe����Ҫ���õ�����
*/
function switchTabTag(index,type,frameName,url) {
	//ֻ��iframe�е�url��Ҫ�ı�ʱ��ִ�С�
	if(document.getElementById(frameName).src != url){
		/*���ȳ�ʼ������tab����ʽΪĬ����ʽ*/
		var maxElement = 1;//���Ԫ����
		while(true){
			if(document.getElementById(type + "bar" + maxElement)){
				document.getElementById(type + 'bar' + maxElement).className="tabTagBarR";
				document.getElementById(type + 'rec' + maxElement).className="tabTagRecRR";
				document.getElementById(type + 'Span'+ maxElement).className="tabTagSpanR";
			}else{
				break;
			}
			//��ֹ��ѭ��
			if(maxElement == 20){
				break;
			}
			maxElement++;
		}
		//���һ�����ӵ�Ԫ��
		document.getElementById(type + 'rec' + maxElement).className="tabTagRecRR";
		
		/*Ȼ��Ȼ��ı�ѡ��tab����ʽ*/
		document.getElementById(type + 'rec' + index).className="tabTagRecRB";
		document.getElementById(type + 'bar' + index).className="tabTagBarB";
		document.getElementById(type + 'rec' + (index + 1)).className="tabTagRecBR";
		document.getElementById(type + 'Span'+ index).className="tabTagSpanB";
		
		/*�������url*/
		document.getElementById(frameName).src = url;
	}
}

/*
���ܣ�����ͨ��div��ʾ���ݵ�tab
����˵����
index����ǰ������ǵڼ���tab
type����Ŀ��ҵ�����͡���ʡ������(sjgg)
divName����ʾ���ݵ�div��idǰ׺
*/		
function switchTabTagForDiv(index,type,divName) {
	/*���Ƚ�����tab�ĸ�Ϊ����ʾ����*/
	var maxElement = 1;//��ʼ�����Ԫ����
	while(true){
		if(document.getElementById(divName + maxElement)){
			document.getElementById(divName + maxElement).style.display = "none";
		}else{
			break;
		}
		//��ֹ��ѭ��
		if(maxElement == 20){
			break;
		}
		maxElement++;
	}
	/*���Ƚ�ѡ�е�tab��������ʾ*/
	document.getElementById(divName + index).style.display = "block";
	
	maxElement = 1;//��ʼ�����Ԫ����
	while(true){
		if(document.getElementById(type + "bar" + maxElement)){
			document.getElementById(type + 'bar' + maxElement).className="tabTagBarR";
			document.getElementById(type + 'rec' + maxElement).className="tabTagRecRR";
			document.getElementById(type + 'Span'+ maxElement).className="tabTagSpanR";
		}else{
			break;
		}
		//��ֹ��ѭ��
		if(maxElement == 20){
			break;
		}
		maxElement++;
	}
	//���һ�����ӵ�Ԫ��
	document.getElementById(type + 'rec' + maxElement).className="tabTagRecRR";
	
	document.getElementById(type + 'rec' + index).className="tabTagRecRB";
	document.getElementById(type + 'bar' + index).className="tabTagBarB";
	document.getElementById(type + 'rec' + (index + 1)).className="tabTagRecBR";
	document.getElementById(type + 'Span'+ index).className="tabTagSpanB";
}
