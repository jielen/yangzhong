Ext.tree.TreeNodeRichUI=function(){this.checkModel="none";this.checkStyle="checkbox";this.onlyLeafCheckable=false;this.checkedOnDblClick=false;Ext.tree.TreeNodeRichUI.superclass.constructor.apply(this,arguments)};Ext.extend(Ext.tree.TreeNodeRichUI,Ext.tree.TreeNodeUI,{renderElements:function(e,l,i,m){var o=e.getOwnerTree();this.checkModel=o.checkModel||e.checkModel||this.checkModel;this.checkStyle=o.checkStyle||e.checkStyle||this.checkStyle;this.onlyLeafCheckable=o.onlyLeafCheckable||false;this.checkedOnDblClick=o.checkedOnDblClick||false;this.indentMarkup=e.parentNode?e.parentNode.ui.getChildIndent():"";var f=(this.checkModel!="none")&&(!this.onlyLeafCheckable||l.leaf);var k=f?(this.checkModel!="none"&&this.checkStyle=="radio"?true:false):"";var j;if(k){if(this.checkModel=="single"){if(!o.inputName){j=Ext.id();o.inputName=j}else{j=o.inputName}}else{j=Ext.id()}}var c=l.href?l.href:Ext.isGecko?"":"";var d=['<li class="x-tree-node"><div ext:tree-node-id="',e.id,'" class="x-tree-node-el x-tree-node-leaf x-unselectable ',l.cls,'" unselectable="on">','<span class="x-tree-node-indent">',this.indentMarkup,"</span>",'<img src="',this.emptyIcon,'" class="x-tree-ec-icon x-tree-elbow" />','<img src="',l.icon||this.emptyIcon,'" class="x-tree-node-icon',(l.icon?" x-tree-node-inline-icon":""),(l.iconCls?" "+l.iconCls:""),'" unselectable="on" />',f?(k?'<input class="x-tree-node-cb" type="radio" name="'+j+'" ':'<input class="x-tree-node-cb" type="checkbox" ')+(l.checked?'checked="checked" />':"/>"):"",'<a hidefocus="on" class="x-tree-node-anchor" href="',c,'" tabIndex="1" ',l.hrefTarget?' target="'+l.hrefTarget+'"':"",'><span unselectable="on">',e.text,"</span></a></div>",'<ul class="x-tree-node-ct" style="display:none;"></ul>',"</li>"].join("");var b;if(m!==true&&e.nextSibling&&(b=e.nextSibling.ui.getEl())){this.wrap=Ext.DomHelper.insertHtml("beforeBegin",b,d)}else{this.wrap=Ext.DomHelper.insertHtml("beforeEnd",i,d)}this.elNode=this.wrap.childNodes[0];this.ctNode=this.wrap.childNodes[1];var h=this.elNode.childNodes;this.indentNode=h[0];this.ecNode=h[1];this.iconNode=h[2];var g=3;if(f){this.checkbox=h[3];Ext.fly(this.checkbox).on("click",this.checkboxclick.createDelegate(this,[null]));g++}this.anchor=h[g];this.textNode=h[g].firstChild},onDblClick:function(a){a.preventDefault();if(this.disabled){return}if(this.checkbox&&this.checkedOnDblClick){if(this.checkStyle=="checkbox"){this.toggleCheck()}else{this.check(true)}}if(!this.animating&&this.node.hasChildNodes()){this.node.toggle()}this.fireEvent("dblclick",this.node,a)},checkboxclick:function(){if(this.checkStyle=="radio"){this.check(this.checkModel=="single"?true:!this.node.attributes.checked)}else{this.check(null)}},check:function(b){var c=this.node;var a=c.getOwnerTree();this.checkStyle=a.checkStyle||c.checkStyle||this.checkStyle;if(b===null){b=this.checkbox.checked}else{if(this.checkStyle=="checkbox"){this.checkbox.checked=b}else{if(this.checkModel!="single"){this.checkbox.checked=b}}}c.attributes.checked=b;a.fireEvent("check",c,b)},childCheck:function(f){var b=f.attributes;var d=f.getOwnerTree();if(!b.leaf){var e=f.childNodes;var g;for(var c=0;c<e.length;c++){g=e[c].getUI();if(g.checkbox.checked^b.checked){g.check(b.checked)}}}},leafCheck:function(e){var b=e.attributes;if(!b.leaf){var d=e.childNodes;var f;for(var c=0;c<d.length;c++){if(d[c].leaf){f=d[c].getUI();if(f.checkbox.checked^b.checked){f.check(b.checked)}}}}},parentCheck:function(c,b){var d=c.getUI().checkbox;if(typeof d=="undefined"){return}if(!(b^d.checked)){return}if(!b&&this.childHasChecked(c)){return}d.checked=b;c.attributes.checked=b;c.getOwnerTree().fireEvent("check",c,b);var a=c.parentNode;if(a!==null){this.parentCheck(a,b)}},childHasChecked:function(b){var c=b.childNodes;if(c||c.length>0){for(var a=0;a<c.length;a++){if(c[a].getUI().checkbox.checked){return true}}}return false},toggleCheck:function(c){var a=this.checkbox;if(a){var b=(c===undefined?!a.checked:c);this.check(b)}}});Ext.tree.TreeEventModel.prototype.delegateClick=function(b,a){if(!this.beforeEvent(b)){return}if(b.getTarget("input[type=checkbox]",1)){this.onCheckboxClick(b,this.getNode(b))}else{if(b.getTarget("input[type=radio]",1)){this.onCheckboxClick(b,this.getNode(b))}else{if(b.getTarget(".x-tree-ec-icon",1)){this.onIconClick(b,this.getNode(b))}else{if(this.getNodeTarget(b)){this.onNodeClick(b,this.getNode(b))}}}}};