//����ҪЧ�����м�id="nc"
//��Ҫ������ҳ�ж���highlightcolor��clickcolor��ֵ
//���δ����ʹ��Ĭ����ɫ

try{
	if(!highlightcolor){var highlightcolor='#666';}//��꾭��Ĭ�ϱ���ɫ
}catch (ex){}
try{
	if(!clickcolor){var clickcolor='orange';}//���ѡ��Ĭ�ϱ���ɫ
}catch (ex){}
var lastCs;//�����ϴ�ѡ�еĶ���
FixPrototypeForGecko();
function  changeto(event){
    event = (event)?event:window.event;
	try{
		source=event.srcElement?event.srcElement:event.target;
		if  (source.tagName=="TR"||source.tagName=="TABLE")
		return;
		while(source.tagName!="TD")
			source=source.parentElement?source.parentElement:source.parentNode;
		source=source.parentElement?source.parentElement:source.parentNode;
		cs  =  source.children?source.children:source.childNodes;
		//alert(cs.length);
		if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor=highlightcolor;
		}
	}catch (ex){}
}
function  changeback(event){
    event = (event)?event:window.event;
	try{
		if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
		return
		if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
		//source.style.backgroundColor=originalcolor
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor="";
		}
	}catch (ex){}
}
function  clickto(event){
    event = (event)?event:window.event;
	try{
		source=event.srcElement?event.srcElement:event.target;
		if  (source.tagName=="TR"||source.tagName=="TABLE")
		return;
		while(source.tagName!="TD")
			source=source.parentElement?source.parentElement:source.parentNode;
		source=source.parentElement?source.parentElement:source.parentNode;
		cs  =  source.children?source.children:source.childNodes;
		//alert(cs.length);
		if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc"){
			for(i=0;i<cs.length;i++){
				cs[i].style.backgroundColor=clickcolor;
			}
			if(lastCs&&lastCs!=cs)//��ѡ��һ�е�ʵ��
			for(i=0;i<lastCs.length;i++){
				lastCs[i].style.backgroundColor="";
			}
			lastCs=cs;
		}
		else
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor="";
		}
	}catch (ex){}
}
//�������� IE/FireFox �� event �� event �� srcElement��fromElement��toElement ����----start   
function  FixPrototypeForGecko()  {
  if(!!window.find){
    HTMLElement.prototype.contains = function(B){
     return this.compareDocumentPosition(B) - 19 > 0
    }
    HTMLElement.prototype.__defineGetter__("runtimeStyle",element_prototype_get_runtimeStyle);     
    window.constructor.prototype.__defineGetter__("event",window_prototype_get_event);     
    Event.prototype.__defineGetter__("srcElement",event_prototype_get_srcElement);     
    Event.prototype.__defineGetter__("fromElement",  element_prototype_get_fromElement);     
    Event.prototype.__defineGetter__("toElement", element_prototype_get_toElement);
  }     
}
function  element_prototype_get_runtimeStyle() { return  this.style; }     
function  window_prototype_get_event() { return  SearchEvent(); }     
function  event_prototype_get_srcElement() { return  this.target; }     
function element_prototype_get_fromElement() {     
  var node;     
  if(this.type == "mouseover") node = this.relatedTarget;     
  else if (this.type == "mouseout") node = this.target;     
  if(!node) return;     
  while (node.nodeType != 1)    
      node = node.parentNode;     
  return node;     
}
function  element_prototype_get_toElement() {     
    var node;     
    if(this.type == "mouseout")  node = this.relatedTarget;     
    else if (this.type == "mouseover") node = this.target;     
    if(!node) return;     
    while (node.nodeType != 1)     
     node = node.parentNode;     
    return node;     
}
function  SearchEvent() {     
  if(document.all) return  window.event;     
  func = SearchEvent.caller;     
  while(func!=null){     
      var  arg0=func.arguments[0];     
      if(arg0 instanceof Event) {     
          return  arg0;     
      }     
     func=func.caller;     
  }
  return   null;     
}