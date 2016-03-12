Ext.ns("ufgov","ufgov.portal","ufgov.portal.common","ufgov.portal.system","ufgov.portal.portlet");Ext.data.Store.prototype.applySort=function(){if(this.sortInfo&&!this.remoteSort){var c=this.sortInfo,d=c.field;var a=this.fields.get(d).sortType;var b=function(f,e){var h=a(f.data[d]),g=a(e.data[d]);if(typeof(h)=="string"){return h.localeCompare(g)}return h>g?1:(h<g?-1:0)};this.data.sort(c.direction,b);if(this.snapshot&&this.snapshot!=this.data){this.snapshot.sort(c.direction,b)}}};ufgov.portal.Base=function(a){this.main=a;this.init();this.saveProgressBar=null};ufgov.portal.Base.prototype={init:Ext.emptyFn,showMsg:function(b,a){Ext.Msg.show({title:b,msg:a,minWidth:200,modal:true,icon:Ext.Msg.INFO,buttons:Ext.Msg.OK})},DateDiff:function(a,f){var e,c,b,d;e=a.split("-");c=new Date(e[1]+"-"+e[2]+"-"+e[0]);e=f.split("-");b=new Date(e[1]+"-"+e[2]+"-"+e[0]);d=parseInt(Math.abs(c-b)/1000/60/60/24);return d}};ufgov.portal.Base.prototype.synchronize=false;ufgov.portal.Base.prototype.ajaxRequest=function(b,a,h){var d=this.synchronize;this.synchronize=false;var g=Ext.Ajax.request({url:a,synchronize:d,params:h,timeout:90000,success:function(i){var j;try{if(i.responseText){j=Ext.decode(i.responseText)}}catch(k){alert("ufgov.portal.Base.ajaxRequest.decode Error-"+k.name+": "+k.message+",responseText:"+i.responseText);return}if(typeof b=="function"){try{b(j)}catch(k){alert("ufgov.portal.Base.ajaxRequest.success参数无效,ServiceName:"+h.serviceMethodName+","+k.name+": "+k.message)}}else{alert(j.message)}},failure:function(i){var j=new Object();j.ret=false;j.message="系统错误！";j.ajaxMessage=i.responseText;j.ajaxError=true;if(typeof b=="function"){try{b(j)}catch(k){alert("ufgov.portal.Base.ajaxRequest.failure参数无效,"+k.name+": "+k.message)}}else{alert(i.responseText)}}});if(d){var c;try{c=Ext.decode(g.conn.responseText)}catch(f){alert("synchronize ufgov.portal.Base.ajaxRequest.decode Error-"+f.name+": "+f.message+",responseText:"+g.conn.responseText);return}if(typeof b=="function"){try{b(c)}catch(f){alert("synchronize ufgov.portal.Base.ajaxRequest.success参数无效,"+f.name+": "+f.message)}}else{alert(c.message)}}};ufgov.portal.Base.prototype.executeAjax=function(b,c){if(arguments.length<2){alert("executeAjax至少传入2个参数");return}var a=[];for(ii=2;ii<arguments.length;ii++){var e=null;if(arguments[ii]&&arguments[ii].clsId==ufgov.portal.common.ParamClass){e=arguments[ii]}else{e=new ufgov.portal.common.Param(arguments[ii])}e.index=(ii-2);a.push(e)}var d={};d.serviceMethodName=c;d.paramJSONArray=Ext.encode(a);d.paramReflectType="manual";this.ajaxRequest(b,context_g+"/remoteCallServiceAction.action",d)};ufgov.portal.Base.prototype.submitAjax=function(b,d,c,g){if(arguments.length<4){alert("submitAjax至少传入4个参数");return}var a=[];for(ii=4;ii<arguments.length;ii++){var f=null;if(arguments[ii]&&arguments[ii].clsId==ufgov.portal.common.ParamClass){f=arguments[ii]}else{f=new ufgov.portal.common.Param(arguments[ii])}f.index=(ii-4);a.push(f)}var e={};e.serviceMethodName=c;e.paramJSONArray=Ext.encode(a);e.paramReflectType="form";e.formMapParamIdx=g;d.submit({url:context_g+"/remoteCallServiceAction.action",params:e,success:function(h,i){if(typeof b=="function"){try{b(true,h,i)}catch(j){alert("ufgov.portal.Base.submitAjax.success参数无效,ServiceName:"+e.serviceMethodName+","+j.name+": "+j.message)}}else{alert(i.result.message)}},failure:function(h,i){if(typeof b=="function"){try{b(false,h,i)}catch(j){alert("ufgov.portal.Base.submitAjax.success参数无效,ServiceName:"+e.serviceMethodName+","+j.name+": "+j.message)}}else{alert("ufgov.portal.Base.submitAjax.failure,ServiceName:"+e.serviceMethodName)}}})};ufgov.portal.Base.prototype.getDsInner=function(){var b=arguments[0];if(b.length<3){alert("getDsInner至少传入三个参数");return null}var d=new Object();for(ii=3;ii<b.length;ii++){if(!b[ii]||b[ii].clsId!=ufgov.portal.common.ParamClass){alert("参数不能为空，且必须是ufgov.portal.common.Param类型");return null}if(!b[ii].name){alert("半自动方式必须提供参数的唯一的名字");return null}d[b[ii].name]=b[ii].value}var a=context_g+"/remoteCallServiceAction.action";var c=new Ext.data.Store({proxy:new Ext.data.HttpProxy({url:a}),reader:new Ext.data.JsonReader({totalProperty:"maxDatasSize",id:"id",root:"datas"},b[0]),remoteSort:true});d.serviceMethodName=b[1];d.paramReflectType="semiAuto";d.paramNameList=b[2];c.baseParams=d;return c};ufgov.portal.Base.prototype.getInitDs=function(c,a,b){return this.getDsInner(arguments)};ufgov.portal.Base.prototype.getDs=function(d,b,c){var a=this.getDsInner(arguments);a.load();return a};ufgov.portal.Base.prototype.getTreeLoaderInner=function(f,e){if(arguments.length<2){alert("getTreeLoaderInner至少不正确的参数");return null}var b=e;var d=f==0?2:3;if(b.length<d){alert("getTreeLoaderInner.params参数不正确");return null}var g=new Object();for(ii=d;ii<b.length;ii++){if(!b[ii]||b[ii].clsId!=ufgov.portal.common.ParamClass){alert("参数不能为空，且必须是ufgov.portal.common.Param类型");return null}if(!b[ii].name){alert("半自动方式必须提供参数的唯一的名字");return null}g[b[ii].name]=b[ii].value}g.serviceMethodName=b[d-2];g.paramReflectType="semiAuto";g.paramNameList=b[d-1];var c=context_g+"/remoteCallServiceAction.action";var a=null;if(f==2){a=new Ext.tree.TreeLoader({dataUrl:c,baseParams:g,baseAttrs:{uiProvider:Ext.tree.TreeNodeRichUI}})}else{a=new Ext.tree.TreeLoader({dataUrl:c,baseParams:g})}if(f>0&&typeof b[0]=="function"){a.processResponse=function(i,l,n){try{var j=Ext.util.JSON.decode(i.responseText);try{var k=b[0];k(a,l,j)}catch(m){alert("getInitTreeLoader参数无效,"+m.name+": "+m.message)}if(typeof n=="function"){n(this,l)}}catch(h){this.handleFailure(i)}}}return a};ufgov.portal.Base.prototype.getDefaultTreeLoader=function(a,b){return this.getTreeLoaderInner(0,arguments)};ufgov.portal.Base.prototype.getDefaultTreeLoaderWithCallback=function(c,a,b){return this.getTreeLoaderInner(1,arguments)};ufgov.portal.Base.prototype.getCustomTreeLoader=function(c,a,b){return this.getTreeLoaderInner(2,arguments)};ufgov.portal.Base.prototype.showSaveProgressBar=function(c){c=c?c:"正在保存,请稍候...";var b=c?Ext.MessageBox.INFO:"ext-mb-download";var a=Ext.MessageBox.show({msg:c,title:"运行中...",width:350,wait:true,waitConfig:{interval:500},icon:b});setTimeout(function(){a.hide()},120000);this.saveProgressBar=a};ufgov.portal.Base.prototype.hideSaveProgressBar=function(){if(!this.saveProgressBar){return}if(!this.saveProgressBar.isVisible()){return}this.saveProgressBar.hide()};Ext.BLANK_IMAGE_URL="/extjs/ext/resources/images/vista/s.gif";