/**
 * @class ufgov.portal.ShowPagePortlet
 * @extends Object
 * @author hmgkevin
 */
ufgov.portal.ShowPagePortlet = function(config){
    this.config = config;
}

ufgov.portal.ShowPagePortlet = Ext.extend(ufgov.portal.ShowPagePortlet, {
    pageContPanel: null,
    noHeaderPortlets: ["blank", "sysPicture"],
	/**
	 * @param {Object} config 参数配置器，可以包含currentPageArray或node
	 * @example config = {
	 * 				currentPageArray: currentPageArray,
	 * 				newMainPanel: newMainPanel  
	 * 			}
	 * or config = {
	 * 		node: node
	 * }
	 * @param {Object} portletInfo
	 */
    showPortletColumn: function(portletInfo){
        var currentPageArray = this.config.currentPageArray;
        var newMainPanel = this.config.newMainPanel;
		//debugger;
		if(Ext.isEmpty(newMainPanel) || Ext.isEmpty(Ext.getCmp(newMainPanel))){
			if(Ext.getCmp('mainFrame')){
				newMainPanel = 'mainFrame';
			}else if(Ext.getCmp('mainPanel')){
				newMainPanel = 'mainPanel';
			}
		}
		if(Ext.isEmpty(currentPageArray)){
			if (!Ext.isEmpty(this.config.node)) {
				currentPageArray = Ext.util.JSON.decode("{\"page_id\":\"\",\"column_ratio\":\"\",\"page_url\":\"\",\"page_title\":\"\",\"page_desc\":\"\",\"page_order\":\"\",\"menu_orient\":\"\",\"parent_id\":\"\",\"page_title_img\":\"\",\"is_always_new\":\"\",\"column_count\":\"\",\"group_id\":\"\"}");
				currentPageArray.page_id = node.attributes.id;
				currentPageArray.page_title = node.attributes.text;
				currentPageArray.page_url = node.attributes.url;
				currentPageArray.column_ratio = node.attributes.columnRatio;
				currentPageArray.column_count = node.attributes.columnCount;
				currentPageArray.is_always_new = node.attributes.isAlwaysNew;
				currentPageArray.menu_orient = node.attributes.menuOrient;
			}
			else {
				alert("传入参数不全，请传入页面参数！");
				return false;
			}
		}
        
        var columnCount = currentPageArray.column_count;
        var columnRatio = currentPageArray.column_ratio;
        var columnWidth = new Array();
        if (columnCount > 0) {
            if (!Ext.isEmpty(columnRatio)) {
                columnWidth = columnRatio.split(',');
            }
            else {
                columnWidth[columnWidth.length] = (100 / columnCount) / 100.0;
            }
        }
        var style = "";
        if (columnCount > 1) {
        	var factor = "0.984";//y方向有滚动条的系数因子
            var pagePortletColumn = '[';
            for (var i = 0; i < columnCount; i++) {
                if (newMainPanel == 'mainPanel' || Ext.isEmpty(newMainPanel)) {
                    if (i == columnCount - 1) {
                        style = 'style: "padding:0px 0px 0px 0px"';
                    }
                    else {
                        style = 'style: "padding:0px 5px 0px 0px"';
                    }
                }
                else {
                    if (i == columnCount - 1) {
                        style = 'style: "padding:0px 5px 0px 0px"';
                    }
                    else {
                        style = 'style: "padding:0px 5px 0px 0px"';
                    }
                }
                pagePortletColumn += '{';
                pagePortletColumn += 'columnWidth:';
                if (columnWidth.length > 1) {
                    pagePortletColumn += columnWidth[i] * factor;
                }
                else {
                    pagePortletColumn += columnWidth[0] * factor;
                }
                pagePortletColumn += ',';
                pagePortletColumn += style;
                pagePortletColumn += '}';
                pagePortletColumn += ',';
            }
            if (pagePortletColumn.indexOf(',') > 0) {
                pagePortletColumn = pagePortletColumn.substring(0, pagePortletColumn.length - 1);
            }
            pagePortletColumn += ']';
            pagePortletColumn = Ext.util.JSON.decode(pagePortletColumn);
        }
        else {
            if (newMainPanel == 'mainPanel' || Ext.isEmpty(newMainPanel)) {
                style = 'style: "padding:0px 0px 0px 0px"';
            }
            else {
                style = 'style: "padding:0px 5px 0px 0px"';
            }
            var pagePortletColumn = '[';
            pagePortletColumn += '{';
            pagePortletColumn += style;
			pagePortletColumn += ',';
			pagePortletColumn += 'columnWidth: 1.0'
            pagePortletColumn += '}';
            pagePortletColumn += ']';
            pagePortletColumn = Ext.util.JSON.decode(pagePortletColumn);
        }
        
        this.pagePortletPanel = new ufgov.portal.Template({
            border: false,
            bodyStyle:"overflow-y:scroll",
            items: pagePortletColumn
        });
        //debugger;
        this.pageContPanel = new Ext.Panel({
            applyTo: newMainPanel,
            id: 'pageContPanel',
            bodyStyle: "padding:0px 0px 0px 0px",
            border: false,
            header: false,
            layout: 'fit',
            items: this.pagePortletPanel
        });
        //debugger;
        this.showPortlet(portletInfo);
    },
    showPortlet: function(portletInfo){
        var ppanel = this.pagePortletPanel;
        var tabContainer = null;
        var tmpColumnTemplate = null;
        var m = 0;
        for (var i = 0; i < portletInfo.length; i++) {
            var portletId = portletInfo[i].portlet_id;
            var portletUrl = portletInfo[i].portlet_url.trim();
            var portletClassName = portletInfo[i].portlet_class.trim();
            var ext = String(portletUrl.match(/[^\.]+$/));
            var portlet;
            if (portletInfo[i].col_no >= ppanel.items.items.length) {
                continue;
            }
            var showTitle = true;
            if (!this.iscontainedHeader(portletId) || portletInfo[i].tab_index > 0 ) {
                showTitle = false;
            }
            
            var panelWidth = ppanel.getInnerWidth();
            var tmpColumnWidth = ppanel.items.itemAt(portletInfo[i].col_no).columnWidth;
            if (tmpColumnWidth) {
                panelWidth = panelWidth * tmpColumnWidth;
            }
            
            if (ext && ext.toLowerCase() == 'js') {
                if (!Ext.isEmpty(portletClassName)) {
                    var item = {};
                    var title = ""; 
                    var portletHeight = 0;
					try{
						portletHeight = parseInt(portletInfo[i].portlet_height);
					}catch(ex){
					}
                    try {
                        var portletObj;//频道类对象
                        if ((' ' + portletClassName).indexOf(' new ') == 0) {
                            portletObj = eval('(' + portletClassName + ')');
                        }
                        else {
                            var portletClass = eval(portletClassName);
                            portletObj = new portletClass();
                        }
                        portletInfo[i].theme = portalArray[0].theme_code;
                        portletInfo[i].panelWidth = panelWidth;
                        if (portletObj && portletObj.passParam) {
                            portletObj.passParam(portletInfo[i]);
                            
                        }
                        if((portletInfo[i].tab_index <= 0)
                        		 && portletObj.panel && portletObj.panel.onRefresh){
                        	portletObj.panel.onRefresh();
                        }
                        if (!Ext.isEmpty(portletObj)) {
                            item = portletObj.panel ? portletObj.panel : {};
                        }
                        if (item.title) {
                            item.setTitle(portletInfo[i].title);
                            title = "";
                        }
                        else {
                            title = portletInfo[i].title;
                        }
                        var conf = {
													border: false,
													//title: title,
													items: item
												};
												if(portletHeight > 0){
													conf.height = portletHeight;
												}else{ 
													conf.autoHeight = true;
												}
												if(showTitle){
													conf.title = title;
												}
                        portlet = new ufgov.portal.Portlet(conf);
                    } 
                    catch (e) {
                        portlet = new ufgov.portal.Portlet({
                            border: true,
                            autoHeight: true,
                            title: portletInfo[i].title,
                            html: '出现异常，可能是该频道对应的js文件没有定义类名，或者是没有正确导入js文件'
                        });
                    }
                    
                }
                else {
                    portlet = new ufgov.portal.Portlet({
                        border: true,
                        autoHeight: true,
                        title: portletInfo[i].title,
                        html: '没有定义该频道js文件对应的类名，请在数据库中添加'
                    });
                }
            }
            else {
                if (portletInfo[i].portlet_id == 'popNews') {
                	//debugger;
                    portletUrl = PF.processUrl(portletUrl);
                    try{
                    	portletUrl = PF.addParameterToUrl(portletUrl, "groupId", groupId);
                    }catch(e){
                    	
                    }
                    portletUrl = PF.addParameterToUrl(portletUrl, "pageId", pageId);
                    portletUrl = PF.addParameterToUrl(portletUrl, "pagePortletId", portletInfo[i].id);
                    //portletUrl = PF.addParameterToUrl(portletUrl, sessionIdKey, sessionid);
                    //debugger;
                    var popNewsWin = new Ext.Window({
                        title: portletInfo[i].title,
                        xtype: 'window',
                        layout: 'fit',
                        modal: false,
                        maximizable: true,
                        minimizable: true,
                        width: 450,
                        height: 350,
                        plain: true,
                        closeAction: 'hide',
                        bodyStyle: 'padding:5 5 5 5;text-align:left;',
                        html: '<iframe src=' + portletUrl + ' frameborder="0" id="mainFrame" name="mainFrame" scrolling="no" style="width:100%;height:100%"></iframe>'
                    });
                    popNewsWin.show();
                    
                    continue;
                }
                
                portletUrl = PF.processUrl(portletUrl);
                try{
                	portletUrl = PF.addParameterToUrl(portletUrl, "groupId", groupId);//增加groupId参数
                	portletUrl = PF.addParameterToUrl(portletUrl, "pageId", pageId);
                  portletUrl = PF.addParameterToUrl(portletUrl, "pagePortletId", portletInfo[i].id);
                	if (!Ext.isEmpty(portletInfo[i].portlet_height)) {
										portletUrl = PF.addParameterToUrl(portletUrl, "height", portletInfo[i].portlet_height);
									} else if(!Ext.isEmpty(portletInfo[i].record_size)){
										portletUrl = PF.addParameterToUrl(portletUrl, "height", portletInfo[i].record_size);
									} else {
										portletUrl = PF.addParameterToUrl(portletUrl, "height", 100);
									}
                }catch(e){
                }
                //portletUrl = PF.addParameterToUrl(portletUrl, sessionIdKey, sessionid);
                var config = {
                    border: false,
					layout: 'fit',
                    //title: portletInfo[i].title,
                    html: '<iframe src=' + portletUrl + ' frameborder="0" id="mainFrame" name="mainFrame" scrolling="auto" style="width:100%;height:100%"></iframe>'
                };
                if (showTitle) {
                    config.title = portletInfo[i].title;
                }
                var recordSize = 0;
                var portletHeight = 0;
								try{
									recordSize = parseInt(portletInfo[i].record_size);
									portletHeight = parseInt(portletInfo[i].portlet_height);
								}catch(e){
								}
								if(portletHeight > 0){
									config.height = portletHeight;
								}else{ 
									if(recordSize > 0){
										config.height = recordSize;
									}else{
										config.autoHeight = true;
									}
								}
								   
								portlet = new ufgov.portal.Portlet(config);
            }
            
            var portletObject = null;
            var createTab = true;
            if(portletInfo[i].tab_index && portletInfo[i].tab_index > 0
            		&& !Ext.isEmpty(portletInfo[i].tab_sign)){
            	if(tabContainer && tabContainer.items && tabContainer.items.length > 0){
            		if(tabContainer.rowNo && tabContainer.colNo
            		  && (tabContainer.rowNo == portletInfo[i].rowno)
            		  && (tabContainer.colNo == portletInfo[i].col_no)
            		  && (tabContainer.tabSign == portletInfo[i].tab_sign)){
            			createTab = false;
					}
            	}
            	if(createTab){
            		tabContainer = this.createTabContainer(portletInfo[i].col_no, portletInfo[i].rowno
            				, portletInfo[i].tab_sign);
            		portletObject = tabContainer;
            	}
            	
            	portlet.title = portletInfo[i].title;
            	portlet.on("activate", function(panel){
            		try{
            			panel.items.itemAt(0).onRefresh();
            			//debugger;
            			panel.findParentByType().setActiveTab(panel);
            			panel.findParentByType().doLayout();
            		}catch(e){
            		}
            	});
            	
            	tabContainer.add(portlet);
            }else{
            	portletObject = portlet;
            }
            
            portlet.on('resize', function(){
        		//debugger;
            	if(!this.items){
            		return;
            	}
        		var iLength = this.items.length;
        		for(var i = 0; i < iLength; i++){
        			try{
        				var panel = this.items.itemAt(i);
        				panel.setWidth(this.getInnerWidth());
        				panel.syncSize();
        			}catch(e){
        			}
        		}
            });
            //debugger;
            //增加列向模板
            var createTemplate = false;
            if(portletObject){
            	if(tmpColumnTemplate && tmpColumnTemplate.rowNo == portletInfo[i].rowno
            			&& tmpColumnTemplate.colNo == portletInfo[i].col_no){
            		//debugger;
            		var colSize = tmpColumnTemplate.items.length;
            		for(var ii = 0; ii < colSize; ii++){
            			var item = tmpColumnTemplate.items.itemAt(ii);
            			if(!item.items){
            				item.add(portletObject);
            				break;
            			}
            		}
            		//tmpColumnTemplate.items.itemAt(1).add(portletObject);
            		continue;
            	}
            	if(!Ext.isEmpty(portletInfo[i].col_ratio) 
            			&& (portletInfo[i].col_ratio > 0 && portletInfo[i].col_ratio < 1)){
            		tmpColumnTemplate = this.createPortalTemplate(portletInfo[i].col_no
                			, portletInfo[i].rowno, portletInfo[i].col_ratio, i, portletInfo);
                		tmpColumnTemplate.items.itemAt(0).add(portletObject);
                		createTemplate = true;
            	}
            	
            	if(tmpColumnTemplate && createTemplate){
            		ppanel.items.itemAt(portletInfo[i].col_no).add(tmpColumnTemplate);
            	}else{
            		ppanel.items.itemAt(portletInfo[i].col_no).add(portletObject);
            	}
            }
            m++;
        };
        
        ppanel.doLayout();
    },
    /**
     * 创建页签式的portlet
     */
    createTabContainer: function(colNo, rowNo, tabSign){
    	ufgov.portal.portlet.tabContainer = Ext.extend(Ext.TabPanel,{
    		rowNo:0
    	});
    	
    	var tabPortlet = new ufgov.portal.portlet.tabContainer({
            //renderTo:'tabs',
    		border:false,
    		activeTab: 0,
            //resizeTabs:true, // turn on tab resizing
            minTabWidth: 60,
            tabWidth:80,
            //plain:true,
            //enableTabScroll:true,
            defaults: {autoScroll:true},
            colNo: colNo,
            rowNo: rowNo,
            tabSign: tabSign
        });
    	var tools = [{
    		qtip : '更多信息......',
			//id : 'more',
			text: '更多', 
			handler : function(e, target, panel) {
    			try{
    				panel.getActiveTab().items.itemAt(0).onOpenAll();
    			}catch(e){
    				alert(e);
    			}
			}	
    	}];
    	
    	tabPortlet.tools = tools;
//    	tabPortlet.on('resize', function(){
//    		//debugger;
//    		if(!this.items){
//    			return;
//    		}
//    		var iLength = this.items.length;
//    		for(var i = 0; i < iLength; i++){
//    			try{
//    				var panel = this.items.itemAt(i);
//    				panel.setWidth(this.getInnerWidth());
//    				panel.syncSize();
//    			}catch(e){
//    			}
//    		}
//    	});
    	return tabPortlet;
    },
    
    /**
     * 创建列模板
     */
    createPortalTemplate: function(colNo, rowNo, colRatio, index, portletInfo){
    	var noRatioColNumber = 0;
    	var sumColRatio = 0;
    	var colIndexes = [];
    	var tabSignList = [];
    	var hasTabPortlet = false;//页签式的portlet仅作为一个处理
    	if(colRatio < 1){
    	  for(var i = index; i < portletInfo.length; i++){
    		var setColumn = false;
    		if(portletInfo[i].rowno == rowNo && portletInfo[i].col_no == colNo){
    			if(portletInfo[i].tab_index && portletInfo[i].tab_index > 0
    					&& !Ext.isEmpty(portletInfo[i].tab_sign)){
    				//if(!hasTabPortlet){
    				//	setColumn = true;
    				//}
    				//hasTabPortlet = true;
    				//if(tabSignList.length == 0){
    				//	tabSignList[tabSignList.length] = portletInfo[i].tab_sign;
    				//}else{
    					var contain = false;
    					for(var jj = 0; jj < tabSignList.length; jj++){
    						if(tabSignList[jj] == portletInfo[i].tab_sign){
    							contain = true;
    							break;
    						}
    					}
    					if(!contain){
    						setColumn = true;
    						tabSignList[tabSignList.length] = portletInfo[i].tab_sign;
    					}
    				//}
    			}else{
    				setColumn = true;
    			}
    			if(setColumn){
    				if(i != index){
    					colIndexes[colIndexes.length] = i;
    				}
					if(portletInfo[i].col_ratio){
						sumColRatio += parseFloat(portletInfo[i].col_ratio);
					}else{
						noRatioColNumber++;
					}
    			}
    		}else{
    			break;
    		}
    	  }
    	}
    	
    	var pagePortletColumn = '[';
        pagePortletColumn += '{';
        pagePortletColumn += 'style: "padding:0px 0px 0px 0px"';
		pagePortletColumn += ',';
		pagePortletColumn += 'columnWidth: ' + colRatio;
        pagePortletColumn += '}';
        
        var colWidth = 0;
        if(noRatioColNumber > 0){
        	//debugger;
        	colWidth = (100 - sumColRatio*100)/(noRatioColNumber*100);
        }
        for(var i = 0; i < colIndexes.length; i++){
        	var tmpRatio = portletInfo[colIndexes[i]].col_ratio;
        	pagePortletColumn += ',{style: "padding:0px 0px 0px 5px"';
        	if(!tmpRatio){
        		tmpRatio = colWidth;
        	}
        	pagePortletColumn += ',columnWidth: ' + tmpRatio + '}';
        }
        
        pagePortletColumn += ']';
        pagePortletColumn = Ext.util.JSON.decode(pagePortletColumn);

        var portalTemplate = new ufgov.portal.Template({
        	border: false,
        	//bodyStyle:"overflow-y:scroll",
        	colNo: colNo,
        	rowNo: rowNo,
        	items: pagePortletColumn
        });
        
        return portalTemplate;
    },
    destroyPanel: function(panel){
        if (panel) {
            if (panel.items) {
                for (var p = panel.items.length; p > 0; p--) {
                    panel.remove(panel.items.items[p - 1]);
                }
            }
            if (panel.tbar) {
                panel.tbar.remove();
            }
            if (panel.tools.items) {
                for (var i = panel.tools.items.length; i > 0; i--) {
                    panel.tools.remove(panel.tools.items.items[i - 1]);
                }
            }
            if (panel.header) {
                panel.header.remove();
            }
        }
    },
    getPagePortletInfo: function(){
		var pThis = this;
		if(!this.config.currentPageArray){
			alert("传入的参数不够，请传入页面信息");
			return false;
		}
        Ext.Ajax.request({
            url: 'getJsonData.action',
            params: {
                ruleID: 'portal-common.getPagePortlet',
                pageId: this.config.currentPageArray.page_id
            },
            success: function(response){
                var portletInfo = Ext.util.JSON.decode(response.responseText);
                if(portletInfo.length > 0){
                	pThis.showPortletColumn(portletInfo);
                }
            },
            failure: function(response){
                var result = Ext.util.JSON.decode(response.responseText);
                alert(result);
            }
        })
    },
    iscontainedHeader: function(portletId){
    	if(null != this.noHeaderPortlets) {
    		for (var i = 0; i < this.noHeaderPortlets.length; i++) {
    			if(portletId == this.noHeaderPortlets[i]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
});
