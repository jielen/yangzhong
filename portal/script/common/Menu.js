ufgov.portal.common.Menu=Ext.extend(ufgov.portal.Base,{
    createMenuTree:function(e,a,b,f,d){
        var c=new Ext.tree.TreePanel({
            id:e+"_Panel",title:a,xtype:"treepanel",iconCls:"nav",border:false,autoScroll:true,split:true,singleExpand:true,useArrows:true,loader:new Ext.tree.TreeLoader({
                dataUrl:f
            }),rootVisible:b,root:new Ext.tree.AsyncTreeNode({
                id:e,text:"根结点"
            }),listeners:{
                click:d
            }
            
        });
        return c
    }
    ,treeNodeClick:function(c){
        if(c.isLeaf()){
            if(c.attributes.url!="#"){
                var e=c.attributes.url;
                if(c.attributes.hrefTarget!="_blank"){
                    if(e.indexOf("http://")===0){
                        window.open(c.attributes.url,"new","")
                    }
                    else{
                        var a=Ext.get("main");
                        var d=a.getUpdater();
                        d.update({
                            url:c.attributes.url,scripts:true,text:"数据装载中，请稍候..."
                        })
                    }
                    
                }
                else{
                    window.open(c.attributes.url,"_blank","")
                }
                
            }
            else{
                if(c.attributes.hrefTarget!="_blank"){
                    a=Ext.get("mainFrame");
                    d=a.getUpdater();
                    d.update({
                        url:"dispatcher.action",scripts:true,params:"function="+c.attributes.compo_id,text:"数据装载中，请稍候...",callback:function(i,j,g,h){
                            var f=g.responseText;
                            i.dom.innerHTML=f
                        }
                        
                    })
                }
                else{
                    var b="dispatcher.action?function="+c.attributes.compo_id;
                    window.open(b,"_blank","")
                }
                
            }
            
        }
        else{
            c.toggle()
        }
        
    }
    ,getRowMenuItem:function(a,c){
        var b="{";
        b+="listeners:{";
        b+="  beforeshow:function(){             ";
        b+="    if(this.items.length === 0){     ";
        b+="      var theMenu = this;            ";
        b+="      Ext.Ajax.request({             ";
        b+="        url: 'getMenuListAction.action',   ";
        b+="	      params: {                    ";
        b+="	        pageId: '"+a+"',  ";
        b+="	        isRemoveEmpty: 'true',     ";
        b+="	        isOnlyInMenu: 'true'       ";
        b+="	      },                           ";
        b+="	      callback: function(option, success, response){";
        b+="	        if(success){               ";
        b+="	          var result = Ext.util.JSON.decode(response.responseText);";
        b+="	          var Menu = new ufgov.portal.common.Menu();";
        b+="	          var menuItem = Menu.getMenuItem(result, '"+a+"', '"+c+"');";
        b+="	          for(var i = 0; i< menuItem.length; i++){";
        b+="	            if(menuItem[i] == '-'){";
        b+="	              theMenu.addSeparator();";
        b+="	            }else{";
        b+="	              var item = new Ext.menu.Item(menuItem[i]);";
        b+="	              theMenu.addItem(item);";
        b+="	            }";
        b+="	          }";
        b+="	        }                           ";
        b+="	      }                             ";
        b+="	    })                              ";
        b+="	  }";
        b+="	}";
        b+=" }";
        b+="}";
        return b
    }
    ,createRowPage:function(groupId,panel,execUrl,afterExecUrl,pageId,forceShow){
        if(!pageId){
            pageId=""
        }
        Ext.Ajax.request({
            url:"getPageListAction.action",params:{
                groupId:groupId,rootCode:pageId
            }
            ,callback:function(option,success,response){
                if(success){
                    var result=Ext.util.JSON.decode(response.responseText);
                    var restArray=new Array();
                    for(var i=result.length-1;
                    i>=0;
                    i--){
                        restArray[restArray.length]=result[i]
                    }
                    var pageArray=new Array();
                    for(i=restArray.length-1;
                    i>=0;
                    i--){
                        if(restArray[i].parent_id==groupId){
                            if(restArray[i].is_display=="Y"||forceShow){
                                pageArray[pageArray.length]=restArray[i]
                            }
                            restArray.remove(restArray[i])
                        }
                        
                    }
                    if(pageArray.length==0){
                        Ext.Msg.alert("温馨提示","还没有定制栏目或栏目设置为不显示！");
                        return false
                    }
                    if(pageArray.length>1||forceShow){
                        try{
                            MainPageIn.center.items.get(0).setHeight(30);
                            MainPageIn.center.render()
                        }
                        catch(e){}var toolJson="[";
                        if(restArray.length===0){
                            for(i=0;
                            i<pageArray.length;
                            i++){
                                if(toolJson.length>1){
                                    toolJson+=', "-" ,'
                                }
                                var menuOrient=pageArray[i].menu_orient;
                                var pageId=pageArray[i].page_id;
                                toolJson+="{";
                                if(menuOrient=="1"){
                                    var Menu=new ufgov.portal.common.Menu();
                                    var menuPanel=Menu.getRowMenuItem(pageId,execUrl);
                                    toolJson+='xtype: "tbsplit",';
                                    toolJson+='text: "'+pageArray[i].page_title+'",';
                                    toolJson+="menu: "+menuPanel+",";
                                    toolJson+="handler: function(){"+execUrl+"('"+Ext.util.JSON.encode(pageArray[i])+"')}";
                                    toolJson+="}"
                                }
                                else{
                                    toolJson+='text: "'+pageArray[i].page_title+'",';
                                    toolJson+="handler: function(){"+execUrl+"('"+Ext.util.JSON.encode(pageArray[i])+"')}";
                                    toolJson+="}"
                                }
                                
                            }
                            
                        }
                        else{
                            var Menu=new ufgov.portal.common.Menu();
                            for(i=0;
                            i<pageArray.length;
                            i++){
                                if(toolJson.length>1){
                                    toolJson+=', "-" ,'
                                }
                                var menuOrient=pageArray[i].menu_orient;
                                pageInfo="pageId="+pageArray[i].page_id+",pageTitle="+pageArray[i].page_title;
                                pageInfo+=",pageUrl="+pageArray[i].page_url+",isAlwaysNew="+pageArray[i].is_always_new;
                                pageInfo+=",menuOrient="+menuOrient;
                                toolJson+="{";
                                if(menuOrient=="1"){
                                    var menuPanel=Menu.getRowMenuItem(pageArray[i].page_id,execUrl);
                                    toolJson+='xtype: "tbsplit",';
                                    toolJson+='text: "'+pageArray[i].page_title.trim()+'",';
                                    toolJson+="menu: "+menuPanel+",";
                                    toolJson+="handler: function(){"+execUrl+"('"+Ext.util.JSON.encode(pageArray[i])+"')}";
                                    toolJson+="}"
                                }
                                else{
                                    if(restArray.length>0){
                                        var retResult=Menu.getRecursionPage(pageArray[i].page_id,restArray,execUrl);
                                        restArray=retResult[1];
                                        if(!Ext.isEmpty(retResult[0])){
                                            toolJson+='xtype: "tbsplit",';
                                            toolJson+="menu: {items:["+retResult[0]+"]},"
                                        }
                                        toolJson+='text: "'+pageArray[i].page_title+'",';
                                        toolJson+="handler: function(){"+execUrl+"('"+Ext.util.JSON.encode(pageArray[i])+"')}";
                                        toolJson+="}"
                                    }
                                    
                                }
                                
                            }
                            
                        }
                        toolJson+="]";
                        var tool=Ext.util.JSON.decode(toolJson);
                        if(tool.length==0){
                            Ext.Msg.alert("温馨提示","还没有定制栏目或栏目设置为不显示！");
                            return false
                        }
                        if(this.menu){
                            this.menu.tbar.remove()
                        }
                        this.menu=new Ext.Panel({
                            applyTo:panel,border:false,bodyStyle:"padding:0 0 0 0;text-align:left;",height:8,tbar:[{
                                xtype:"tbsplit",iconCls:"add"
                            }
                            ]
                        });
                        var level=0;
                        var restMenuItem=new Array();
                        for(var i=0;
                        i<tool.length;
                        i++){
                            var tempWidth=this.menu.tbar.getWidth();
                            if(tempWidth>Ext.get("mainPanel").dom.offsetWidth){
                                level=i-2;
                                break
                            }
                            else{
                                this.menu.getTopToolbar().add(tool[i])
                            }
                            
                        }
                        if(level==0){
                            level=tool.length-1
                        }
                        this.menu.tbar.remove();
                        this.menu=new Ext.Panel({
                            applyTo:panel,border:false,height:8,tbar:[]
                        });
                        for(var m=0;
                        m<tool.length;
                        m++){
                            if(m>level){
                                restMenuItem[restMenuItem.length]=tool[m]
                            }
                            else{
                                this.menu.getTopToolbar().add(tool[m])
                            }
                            
                        }
                        if(restMenuItem.length>0){
                            this.menu.getTopToolbar().add("->",{
                                xtype:"tbsplit",iconCls:"add",id:"moreTool",menu:restMenuItem
                            })
                        }
                        
                    }
                    if(afterExecUrl&&pageArray.length>0){
                        var menuOrient=pageArray[0].menu_orient;
                        if(menuOrient=="2"){
                            eval(execUrl)(Ext.util.JSON.encode(pageArray[0]))
                        }
                        else{
                            eval(afterExecUrl)(Ext.util.JSON.encode(pageArray[0]))
                        }
                        
                    }
                    
                }
                
            }
            
        })
    }
    ,getRecursionPage:function(b,m,c){
        var g=new Array();
        var f="";
        if(m.length>0){
            var h=m.length-1;
            for(;
            h>=0;
            ){
                if(m[h].parent_id==b){
                    var d=m[h].page_id;
                    var k=m[h].page_title;
                    var e=m[h].page_url;
                    var a=m[h].is_always_new;
                    var n=m[h].menu_orient;
                    var o="pageId="+d+",pageTitle="+k;
                    o+=",pageUrl="+e+",isAlwaysNew="+a;
                    o+=",menuOrient="+n;
                    if(f.length>1){
                        f+=', "-" ,'
                    }
                    f+="{";
                    if(n=="1"){
                        var l=new ufgov.portal.common.Menu();
                        var j=l.getRowMenuItem(d,c);
                        f+='xtype: "tbsplit",';
                        f+='iconCls: "nav",';
                        f+='text: "'+k+'",';
                        f+="menu: "+j+",";
                        f+="handler: function(){"+c+"('"+Ext.util.JSON.encode(m[h])+"')}";
                        f+="}"
                    }
                    else{
                        g=this.getRecursionPage(d,m,c);
                        m=g[1];
                        if(!Ext.isEmpty(g[0])){
                            f+='xtype: "tbsplit",';
                            f+="menu: {items:["+g[0]+"]},"
                        }
                        f+='text: "'+k+'",';
                        f+='iconCls: "nav",';
                        f+="handler: function(){"+c+"('"+Ext.util.JSON.encode(m[h])+"')}";
                        f+="}"
                    }
                    
                }
                h--
            }
            
        }
        g[0]=f;
        g[1]=m;
        return g
    }
    ,getMenuItem:function(a,c,d){
        var e;
        var f="[";
        if(a.length>0){
            var b=this.getRecursionMenu(c,a,d);
            f+=b
        }
        f+="]";
        e=Ext.util.JSON.decode(f);
        return e
    }
    ,getRecursionMenu:function(a,m,b){
        var g="";
        var j=0;
        for(;
        j<m.length;
        j++){
            var e=m[j];
            if(e.parent_id&&e.parent_id==a){
                if(g.length>1){
                    g+=', "-" ,'
                }
                g+="{";
                var l=e.menu_id;
                var c=e.menu_name;
                var h=this.getRecursionMenu(l,m,b);
                g+='xtype: "tbsplit",';
                g+='iconCls: "add",';
                g+='text: "'+c+'",';
                g+="menu: {items:["+h+"]}";
                g+="}"
            }
            else{
                if(e.compo_id&&e.menu_id==a){
                    if(g.length>1){
                        g+=', "-" ,'
                    }
                    g+="{";
                    var k=e.compo_id;
                    var d=e.compo_name;
                    var f=Ext.util.JSON.encode(e);
                    g+='iconCls: "grid",';
                    g+='text: "'+d+'",';
                    g+="handler: function(){"+b+"('"+f+'\', "1")}';
                    g+="}"
                }
                
            }
            
        }
        return g
    }
    ,getPageInfo:function(groupId,panel,execUrl,afterExecUrl){
        Ext.Ajax.request({
            url:"getJsonData.action",params:{
                ruleID:"portal-common.getGroupPage",groupId:groupId
            }
            ,callback:function(option,success,response){
                if(success){
                    var result=Ext.util.JSON.decode(response.responseText);
                    var toolJson="[";
                    if(result.length>0){
                        for(var i=0;
                        i<result.length;
                        i++){
                            if(toolJson.length>1){
                                toolJson+=', "-" ,'
                            }
                            toolJson+="{";
                            toolJson+='text: "'+result[i].page_title+'",';
                            toolJson+="handler: function(){"+execUrl+"('"+Ext.util.JSON.encode(result[i])+"')}";
                            toolJson+="}"
                        }
                        
                    }
                    toolJson+="]";
                    var tool=Ext.util.JSON.decode(toolJson);
                    if(this.menu){
                        this.menu.tbar.remove()
                    }
                    this.menu=new Ext.Panel({
                        applyTo:panel,border:false,tbar:tool
                    });
                    if(afterExecUrl){
                        eval(afterExecUrl)(Ext.util.JSON.encode(result[0]))
                    }
                    
                }
                
            }
            
        })
    }
    ,createCellPage:function(groupId,rootCode,panel,execUrl,rightClickUrl){
        var pageTree=new Ext.tree.TreePanel({
            id:groupId+"_Panel",header:false,xtype:"treepanel",border:false,autoScroll:true,el:panel,split:true,singleExpand:true,hideCollapseTool:true,useArrows:true,loader:new Ext.tree.TreeLoader({
                dataUrl:"getPageTreeAction.action?groupId="+groupId+"&rootCode="+rootCode
            }),rootVisible:false,root:new Ext.tree.AsyncTreeNode({
                id:groupId,text:"根结点"
            }),listeners:{
                click:function(node){
                    eval(execUrl)(node)
                }
                ,contextmenu:function(node,event){
                    if(node.attributes.isMenu){
                        event.preventDefault();
                        if(rightClickUrl){
                            eval(rightClickUrl)(node,event)
                        }
                        
                    }
                    
                }
                
            }
            
        });
        pageTree.on("beforeload",function(node){
            if(node.attributes.menuOrient=="2"||node.attributes.isMenu){
                pageTree.loader.dataUrl="getMenuTreeAction.action";
                pageTree.loader.baseParams.pageId=node.attributes.id;
                pageTree.loader.baseParams.isRemoveEmpty=true;
                pageTree.loader.baseParams.isOnlyInMenu=true
            }
            else{
                pageTree.loader.dataUrl="getPageTreeAction.action?groupId="+groupId+"&rootCode="+rootCode
            }
            
        });
        pageTree.render();
        var rootNode=pageTree.getRootNode();
        rootNode.on("expand",function(){
            var firstNode=rootNode.firstChild;
            eval(execUrl)(firstNode)
        })
    }
    ,createListPage:function(groupId,panel,execUrl,funcLink){
        var pThis=this;
        Ext.Ajax.request({
            url:"getPageListAction.action",params:{
                groupId:groupId,rootCode:""
            }
            ,success:function(response){
                var rootMenu=Ext.util.JSON.decode(response.responseText);
                if(this.panel!=null){
                    for(var p=this.panel.items.length;
                    p>0;
                    p--){
                        this.panel.remove(this.panel.items.items[p-1])
                    }
                    
                }
                if(rootMenu.length>0){
                    var menuTree=new Array();
                    for(var i=0;
                    i<rootMenu.length-1;
                    i++){
                        menuTree[i]=pThis.createTreePanel(rootMenu[i+1].page_id,rootMenu[i+1].page_title,true,"getMenuTreeAction.action?pageId="+rootMenu[i+1].page_id,"MainPageIn.execCellPageUrl","")
                    }
                    var menuTreePanel=new Ext.Panel({
                        id:"treePanel",layout:"accordion",autoScroll:true,layoutConfig:{
                            animate:false
                        }
                        ,items:menuTree
                    });
                    var funcLinks=pThis.getMenuButtonItems(funcLink);
                    funcLinks[0]=menuTreePanel;
                    var itemNum=funcLinks.length-1;
                    if(itemNum>5){
                        itemNum=5
                    }
                    var panelItems=new Array();
                    for(var i=0;
                    i<itemNum+1;
                    i++){
                        panelItems[i]=funcLinks[i]
                    }
                    this.Panel=new Ext.Panel({
                        id:"leftMenuPanel",applyTo:panel,items:panelItems
                    });
                    menuTreePanel.setHeight(this.Panel.getInnerHeight()-itemNum*25);
                    var defaultRoot=menuTree[0].getRootNode();
                    eval(execUrl)(defaultRoot)
                }
                
            }
            
        })
    }
    ,getMenuButtonItems:function(a){
        var f=this.getFuncLinkArray(a);
        var e=new Array();
        for(var d=0,c=0;
        d<f.length&&c<5;
        d++){
            var b=f[d].split(",");
            if(b[0]=="system"&&userId!="sa"){
                continue
            }
            e[c+1]=new Ext.Panel({
                header:false,height:25,html:'<div style="height:100%;weigth:100%;cursor:hand;background:#d9e7f8" valign="middle" onclick="new ufgov.portal.FuncLink().doFuncLink(\''+b[0]+'\')">&nbsp;&nbsp;<img align="middle" src="/portal/resources/cog.png"> &nbsp;&nbsp;'+b[1]+"</div>"
            });
            c++
        }
        return e
    }
    ,getFuncLinkArray:function(a){
        var b=new Array();
        if(a.indexOf("@")>0){
            b=a.split("@")
        }
        else{
            b[0]=a
        }
        return b
    }
    ,createCellMenu:function(pageId,panel,execUrl,rightClickUrl,afterExecUrl,newMainFrame){
        var menuTree=new Ext.tree.TreePanel({
            id:pageId+"_Panel",xtype:"treepanel",header:false,border:false,autoScroll:true,el:panel,split:true,singleExpand:false,bodyStyle:"background: url(resources/left_bg.jpg)",hideCollapseTool:true,useArrows:true,loader:new Ext.tree.TreeLoader({
                dataUrl:"getMenuTreeAction.action",baseParams:{
                    pageId:pageId,isRemoveEmpty:true,isOnlyInMenu:true
                }
                
            }),rootVisible:false,root:new Ext.tree.AsyncTreeNode({
                id:pageId,text:"根结点"
            }),listeners:{
                click:function(node){
                    if(node.isLeaf()){
                    	alert('click leaf');
                        eval(execUrl)(node)
                    }
                    else{
                    	alert('click node');
                        node.toggle()
                    }
                    
                }
                ,contextmenu:function(node,event){
                    event.preventDefault();
                    if(rightClickUrl){
                        eval(rightClickUrl)(node,event)
                    }
                    
                }
                
            }
            
        });
        menuTree.render();
        if(afterExecUrl){
            eval(afterExecUrl)("",newMainFrame)
        }
        
    }
    ,createTreePanel:function(treeId,treeTitle,isShowRoot,dataUrl,nodeClickFun,rightClickFunc){
        var treePanel=new Ext.tree.TreePanel({
            id:treeId+"_Panel",title:treeTitle,xtype:"treepanel",header:true,iconCls:"nav",border:false,autoScroll:true,split:true,singleExpand:true,useArrows:true,loader:new Ext.tree.TreeLoader({
                dataUrl:dataUrl,baseParams:{
                    isRemoveEmpty:true,isOnlyInMenu:true
                }
                
            }),rootVisible:isShowRoot,root:new Ext.tree.AsyncTreeNode({
                id:treeId,text:"根结点"
            }),listeners:{
                click:function(node){
                    eval(nodeClickFun)(node)
                }
                ,contextmenu:function(node,event){
                    if(node.attributes.isMenu){
                        event.preventDefault();
                        if(rightClickFunc){
                            eval(rightClickFunc)(node,event)
                        }
                        
                    }
                    
                }
                
            }
            
        });
        treePanel.on("beforeload",function(node){
            if(node.attributes.menuOrient=="2"||node.attributes.isMenu){
                treePanel.loader.dataUrl="getMenuTreeAction.action";
                treePanel.loader.baseParams.pageId=node.attributes.id;
                treePanel.loader.baseParams.isRemoveEmpty=true;
                treePanel.loader.baseParams.isOnlyInMenu=true
            }
            
        });
        var rootNode=treePanel.getRootNode();
        treePanel.on("beforeexpand",function(node){
            eval(nodeClickFun)(rootNode)
        });
        return treePanel
    }
    ,processUrl:function(a){
        return PF.processUrl(a)
    }
    
});