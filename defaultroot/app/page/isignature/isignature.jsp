<%
  String mServerName="/Service.jsp";
  String mHttpUrlName=request.getRequestURI();
  String mServerUrl = "http://"+request.getServerName()+":"+request.getServerPort()+"/GB/portal/page/isignature"+mServerName;
%>

<script type="text/javascript">
function DoJFSignature()
{
  //DocForm.SignatureControl.FieldsList="XYBH=Э����;BMJH=���ܼ���;JF=�׷�ǩ��;HZNR=��������;QLZR=Ȩ������;CPMC=��Ʒ����;DGSL=��������;DGRQ=��������"       //�������ֶ�
  var mx=event.clientX + document.body.scrollLeft - document.body.clientLeft;  //��ȡX����ֵ
  var my=event.clientY + document.body.scrollTop  - document.body.clientTop;   //��ȡY����ֵ
  DocForm.SignatureControl.Position(mx,my);                      //ǩ��λ�ã���Ļ����
  DocForm.SignatureControl.UserName="lyj";                         //�ļ���ǩ���û�
  DocForm.SignatureControl.RunSignature();                         //ִ��ǩ�²���
}

</script>

<form name="DocForm" method="post">
<script type="text/javascript">
	var plugin = '<OBJECT id="SignatureControl"  classid="clsid:D85C89BE-263C-472D-9B6B-5264CD85B36E" codebase="iSignatureHTML.cab#version=7,1,0,196" width=0 height=0 VIEWASTEXT>';
	plugin+='<input type="hidden" name="DocumentID" value="'+documentID+'">';
	plugin+='<param name="ServiceUrl" value="<%=mServerUrl%>">';
	plugin+='<param name="WebAutoSign" value="0">';
	plugin+='<param name="PrintControlType" value=2>';
	plugin+='</OBJECT>';
	document.write(plugin);
</script>
</form>

<script type="text/javascript">
window.onload=function(){
	DocForm.SignatureControl.ShowSignature(documentID);
	document.body.setAttribute("title","˫��ǩ��");
	document.body.ondblclick=DoJFSignature;
}
</script>