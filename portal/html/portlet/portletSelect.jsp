<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String svUserID = (String)session.getAttribute("svUserID");
	String action = request.getParameter("action");
	if(action == null){
		action = "/portal/publishToArticle.action";
	}
	String articleId = request.getParameter("id");
	String title = request.getParameter("title");
	String srcFile = request.getParameter("srcFile");
	String deleteSrcFile = request.getParameter("deleteSrcFile");
	String type = request.getParameter("type");
	if(type == null){
		type = "2";
	}
	//String srcFile = "E:/test/doc2html.doc";
%>
<script>
	context_g = path = '<%=path%>';
	document.oncontextmenu = function(){return false;};
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/extjs/ext/resources/css/ext-all.css" />
<script type="text/javascript" src="/extjs/ext/ext/ext-base.js"></script>
<script type="text/javascript" src="/extjs/ext/ext-all.js"></script>
<script type="text/javascript" src="/extjs/ext/locale/ext-lang-zh_CN.js"></script>

<script type="text/javascript" src="<%=path%>/script/common/TreeNodeRichUI.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/Base.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/Param.js"></script>
<script type="text/javascript" src="<%=path%>/script/common/ConnectCrossDomain.js"></script>

<title>页面频道选择</title>
</head>
<body>
	<div id="main"></div>
</body>
<script type="text/javascript">
	var publishOK = true;
	var firstArticleId = '<%=articleId%>';
	var base = new ufgov.portal.Base();
	var treePanel = null;
	
	function drawNode(loader, node, json){
	    if (Boolean(json.msg)) {
	        alert(json.msg);
	        return;
	    }
	    node.beginUpdate();
	    
	    for (ii = 0; ii < json.length; ii++) {
	        var no = loader.createNode(json[ii]);
	        if (no) {
	            if (json[ii].pgPletIdFlag) {
	                no.checkModel = 'multiple';
	                no.checkStyle = 'checkbox';
	                no.attributes.checked = json[ii].portletCheck;
	                no.on('checkchange', function(){
	                    var nodeTmp = no.parentNode;
	                    while (nodeTmp != treePanel.root) {
	                        if (nodeTmp.checkStyle == 'radio') {
	                            nodeTmp.getUI().toggleCheck(true);
	                        }
	                        nodeTmp = nodeTmp.parentNode;
	                    }
	                })
	                
	            }
	            else 
	                if (node == treePanel.root) {
	                    no.checkModel = 'multiple';
	                    no.checkStyle = 'radio';
	                }
	            node.appendChild(no);
	        }
	    }
	    node.endUpdate();	    
	}

	function getCheckedNodes(node, onlyLeaf, onlyRadio){
        var checked = [];
        if ((!onlyLeaf || node.isLeaf()) && node.getUI().isChecked() &&
        node.checkStyle != 'radio') {
            checked.push(node);
        }
        if (!node.isLeaf()) {
            for (var i = 0; i < node.childNodes.length; i++) {
                if (!onlyRadio || node.childNodes[i].checkStyle == 'radio' && node.childNodes[i].getUI().isChecked()) {
                    checked = checked.concat(getCheckedNodes(node.childNodes[i], onlyLeaf, false));
                }
            }
        }
        return checked;
    }
    
	function publish(checkedPagePortlets){
		//debugger;
		var target = [];
		for(var i = 0; i < checkedPagePortlets.length; i++){
			var tmp = {pagePortletId: checkedPagePortlets[i].id};
			target.push(tmp);
		}
		var src = {};
		src.title = "<%=title%>";
		src.id = '<%=articleId%>';
		src.srcFile = '<%=srcFile%>';
		src.deleteSrcFile = '<%=deleteSrcFile%>';
		src.type = '<%=type%>';
		
		var params = {};
		params.target = Ext.encode(target);
		params.src = Ext.encode(src);
		
		base.synchronize = true;
		base.showSaveProgressBar(publishOK ? '正在发布中，请稍候...' : '正在取消发布中，请稍候...');
		base.ajaxRequest(function(json){
            base.hideSaveProgressBar();
            window.returnValue = json.message;
            window.close();
        }, '<%=action%>', params);
	}
	
	Ext.onReady(function(){
		treePanel = new Ext.tree.TreePanel({
            id: 'portlet_treePanel',
            header: true,
            border: true,
            autoScroll: true,
            split: true,
            singleExpand: false,
            useArrows: true,
            renderTo: Ext.getBody(),
            title: publishOK ? '请选择发布的目的频道(允许多选)' : '请选择取消发布的目的频道(允许多选)',    
            height: 500,
            hideCollapseTool: true,
            tools: [{
                id: 'refresh',
                handler: function(event, toolEl, panel){
                
                }
            }],
            loader: base.getCustomTreeLoader(drawNode, 'apService.getApPagePortletBeans', 'node,articleFileId,portletType,menuId,compoId,userId', new ufgov.portal.common.Param(firstArticleId, '', 'articleFileId'), new ufgov.portal.common.Param('01', '', 'portletType'), new ufgov.portal.common.Param('', '', 'menuId'), new ufgov.portal.common.Param('', '', 'compoId'), new ufgov.portal.common.Param('<%=svUserID%>', '', 'userId')),
            rootVisible: true,
            root: new Ext.tree.AsyncTreeNode({
                id: '0',
                text: '全部'
            }),
            buttons: [{
            	text: '确定',
                handler: function(){
            		var checkedPagePortlets = getCheckedNodes(treePanel.root, true, true);
                	if (checkedPagePortlets.length == 0) {
                    	alert('至少选中一个栏目！');
                    	return;
                	}
                
                	Ext.Msg.confirm('系统提示', publishOK ? '确认发布这些选择的文章到选中的频道吗?' : '确认取消选中的频道里已发布的这些文章吗?', function(btn){
                    	if (btn != 'yes') 
                        	return;
                    	publish(checkedPagePortlets);
                	})
                }
            },
            {
            	text: '返回',
                handler: function(){
                    window.close();
                }
            }]
        });

		//treePanel.show();
	});
</script>
</html>