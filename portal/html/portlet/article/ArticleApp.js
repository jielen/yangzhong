/**
 * 变量articleApp与工作频道ID必须一致，在主程序中调用
 */
ufgov.portal.portlet.ArticleApp = Ext.extend(ufgov.portal.Base, {
  panel: null,
  picPart: null,
  gridPart: null,
  gridArticleApp: null,
  dsGridApp: null,
  pgPletId: '100',
  pageId: '',
  portletTitle: '新闻',
  winMore: null,
  winDetail: null,
  rowNum: 20,
  searchButton: true,
  panelWidth: 275,
  showTools: true,
  recordType: [{
    name: 'id',
    type: 'int'
  }, {
    name: 'title',
    type: 'string'
  }, {
    name: 'pubTime',
    type: 'date',
    dateFormat: 'Y-m-d H:i:s'
  }],
  
  init: function(){
    Ext.QuickTips.init();
    if (this.constructor.arguments.length > 0) {
      this.pgPletId = this.constructor.arguments[0].pgPletId;
      this.portletTitle = this.constructor.arguments[0].portletTitle;
      if (this.constructor.arguments[0].searchButton != undefined) {
        this.searchButton = this.constructor.arguments[0].searchButton;
      }
    };
      },
  
  passParam: function(jsonParam){
    if (Ext.isEmpty(jsonParam)) {
      alert("请传入jsonParam参数");
      return;
    }
    
    if (Ext.isEmpty(jsonParam.page_id)) {
      alert("必须存在jsonParam.page_id参数");
      return;
    }
    
    if (Boolean(jsonParam.id)) {
      this.pgPletId = jsonParam.id;
    }
    
    if (!Ext.isEmpty(jsonParam.title)) {
      this.portletTitle = jsonParam.title;
    }
    if (!Ext.isEmpty(jsonParam.record_size) && jsonParam.record_size > 0) {
      this.rowNum = jsonParam.record_size;
    }
    if (Boolean(jsonParam.panelWidth) && jsonParam.panelWidth > 0) {
      this.panelWidth = jsonParam.panelWidth;
    }
    //debugger;
    if (Boolean(jsonParam.tab_index) && jsonParam.tab_index > 0 &&
    !Ext.isEmpty(jsonParam.tab_sign)) {
      this.showTools = false;
    }
    
    // this.destroy();
    this.pageId = jsonParam.page_id;
    var pThis = this;
    
    var tmpColumnArray = [{
      header: '图标',
      dataIndex: 'icon',
      renderer: function(value){
        return '<a  class= "article-grid-flag"> </a>';
      },
      width: 25
    }, {
      header: '标题',
      dataIndex: 'title',
      renderer: function(value){
        return '<a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a>';
      },
      id: 'title',
      width: 250
    }];
    
    if (this.panelWidth > 375) {
      tmpColumnArray[tmpColumnArray.length] = {
        header: '发布时间',
        dataIndex: 'pubTime',
        id: 'pubTime',
        renderer: function(value){
          var dt = Ext.util.Format.date(value, 'Y-m-d H:i');
          var dt1 = Ext.util.Format.date(value, 'Y-m-d');
          var dtNow = Ext.util.Format.date(new Date(), 'Y-m-d');
          return (dt1 == dtNow) ? ('<span>' + dt + '<a  class= "article-new-flag"></a></span>') : dt;
        },
        width: 100
      };
    }
    
    var colM = new Ext.grid.ColumnModel(tmpColumnArray);
    
    ds = pThis.getInitDs(pThis.recordType, "apService.getListArticlePageBypgPletId_Search", "groupId,pageId,searchPgPletId,counter,start,limit,searchType,searchKey");
    
    
    if (jsonParam.content_bg_img) {
      var picHtml = '<div><img src=\"' + jsonParam.content_bg_img + '\"></div>';
      this.picPart = new Ext.Panel({
        frame: false,
        //height:100,
        width: 150,
        autoHeight: true,
        bodyStyle: 'padding:5px 5px 5px 5px;border:0px solid',
        html: picHtml
      });
    }
    
    var template1 = new Ext.Template('<div class="x-grid3" hidefocus="true">', '<div class="x-grid3-viewport">', '<div class="x-grid3-header"><div class="x-grid3-header-inner"><div class="x-grid3-header-offset">{header}</div></div><div class="x-clear"></div></div>', '<div class="x-grid3-scroller article-grid-body" ><div class="x-grid3-body">{body}</div><a href="#" class="x-grid3-focus" tabIndex="-1"></a></div>', "</div>", '<div class="x-grid3-resize-marker">&#160;</div>', '<div class="x-grid3-resize-proxy">&#160;</div>', "</div>");
    
    var templates1 = {};
    templates1.master = template1;
    
    pThis.gridPart = new Ext.grid.GridPanel({
      autoScroll: true,
      title: '',
      cm: colM,
      ds: ds,
      hideHeaders: true,
      resizable: true,
      bodyStyle: 'width:100%',
      autoWidth: true,
      autoExpandColumn: 'title',
      viewConfig: {
        forceFit: false,
        scrollOffset: 2,
        templates: templates1
      }
    });
    
    /*		
     // grid双击事件rowdblclick
     this.gridPart.on('rowclick', function(grid) {
     var record = grid.getSelectionModel().getSelected();
     if (!record) {
     return;
     }
     onOpenDetail(record.get('id'));
     })
     */
    // grid双击事件cellclick
    pThis.gridPart.on('cellclick', function(grid, r, c, e){
      if (c != 1) return;
      var record = grid.getSelectionModel().getSelected();
      if (!record) {
        return;
      }
      onOpenDetail(record.id, record.get('pubTime'));
    })
    
    //pThis.gridPart.query(pThis.gridPart)article-grid-cell
    
    
    
    
    var toolStyle1 = {};
    if (!Ext.isEmpty(jsonParam.title_bg_img)) {
      toolStyle1['background'] = 'url(html/themes/' + jsonParam.theme +
      '/' +
      jsonParam.title_bg_img +
      ')';
    }
    
    if (!Ext.isEmpty(jsonParam.title_font_color)) {
      toolStyle1['color'] = jsonParam.title_font_color;
    }
    
    if (!Ext.isEmpty(jsonParam.title_font_size)) {
      toolStyle1['font-size'] = jsonParam.title_font_size;
    }
    
    if (!Ext.isEmpty(jsonParam.title_bg_color)) {
      toolStyle1['bgcolor'] = jsonParam.title_bg_color;
    }
    var tools = null;
    
    if (pThis.searchButton) {
      tools = [{
        qtip: '搜索......',
        id: 'search',
        handler: function(e, target, panel){
          pThis.searchArticle(null);
        }
      }, {
        qtip: '更多信息......',
        id: 'more',
        handler: function(e, target, panel){
          panel.onOpenAll();
        }
      }, {
        qtip: '刷新数据',
        // tooltip: '刷新数据',
        id: 'refresh',
        handler: function(e, target, panel){
          panel.onRefresh();
        }
      }];
    }
    else {
      tools = [{
        qtip: '更多信息......',
        id: 'more',
        handler: function(e, target, panel){
          panel.onOpenAll();
        }
      }, {
        qtip: '刷新数据',
        // tooltip: '刷新数据',
        id: 'refresh',
        handler: function(e, target, panel){
          panel.onRefresh();
        }
      }];
      
    }
    
    // pThis.panel=pThis.gridPart;
    var panelConf = {
      //title : pThis.portletTitle,
      toolStyle: toolStyle1,
      //tools :tools,
      border: false,
      autoScroll: true,
      standardSubmit: true,
      // toolTemplate:tt,
      layout: 'column',
      headerdblClick: function(){
        pThis.panel.onOpenAll();
      },
      items: [{}],
      onRefresh: function(){
        var store = pThis.gridPart.getStore();
        
        store.baseParams.searchType = 10;
        store.baseParams.searchKey = '';
        
        store.baseParams.searchPgPletId = pThis.pgPletId;
        store.baseParams.pageId = pThis.pageId;
        store.baseParams.groupId = pThis.groupId;
        store.baseParams.counter = false;
        store.baseParams.limit = pThis.rowNum;
        store.baseParams.dir = 'desc';
        store.baseParams.sort = 'id';
        store.load({
          params: {
            start: 0
          }
        });
        //debugger;						
      },
      // 打开全部数据窗口
      onOpenAll: function(){
        var pageSize = 20;
        if (!pThis.gridArticleApp) {
          // 复选的GridPortlet
          
          pThis.dsGridApp = pThis.getInitDs(pThis.recordType, "apService.getListArticlePageBypgPletId_Search", "groupId,pageId,searchPgPletId,counter,start,limit,searchType,searchKey");
          // 创建复选框的列
          var smArticleApp = new Ext.grid.CheckboxSelectionModel();
          
          // 创建grid的列信息
          var colsArticleApp = new Ext.grid.ColumnModel([smArticleApp, {
            header: '',
            dataIndex: 'icon',
            renderer: function(value){
              return '<a   href= "#"     class= "article-grid-flag"> </a>';
            },
            width: 25
          }, {
            header: '<div align="center">标题</div>',
            dataIndex: 'title',
            renderer: function(value){
              return '<div><a href="javascript:void(null);" class="article-grid-cell" title="' + value + '" >' + value + '</a></div>';
            },
            id: 'title'
          }, {
            header: '<div align="center">发布时间</div>',
            dataIndex: 'pubTime',
            id: 'pubTime',
            renderer: function(value){
              var dt = Ext.util.Format.date(value, 'Y-m-d H:i');
              var dt1 = Ext.util.Format.date(value, 'Y-m-d');
              var dtNow = Ext.util.Format.date(new Date(), 'Y-m-d');
              return (dt1 == dtNow) ? ('<span>' + dt + '<a  class= "article-new-flag"></a></span>') : dt;
            },
            width: 112
          }]);
          
          // 创建页面信息工具栏
          var barArticleApp = new Ext.PagingToolbar({
            pageSize: pageSize,
            store: pThis.dsGridApp,
            items: ['-', {
              tooltip: '搜索',
              iconCls: 'new-tab',
              icon: '/style/img/gp5/ico/watch_g.jpg',
              handler: function(){
                pThis.searchArticle(pThis.dsGridApp);
              }
            }],
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条数据，共 {2} 条',
            emptyMsg: '没有数据'
          })
          
          // 创建编辑Grid
          pThis.gridArticleApp = new Ext.grid.GridPanel({
            ds: pThis.dsGridApp,
            cm: colsArticleApp,
            sm: smArticleApp,
            autoExpandColumn: 'title',
            resizable: true,
            autoWidth: true,
            //hideHeaders : true,
            viewConfig: {
              forceFit: false,
              templates: templates1
            },
            bbar: barArticleApp
          });
          
          // grid双击事件rowdblclick
          pThis.gridArticleApp.on('cellclick', function(grid, r, c, e){
            if (c != 2) return;
            var record = grid.getSelectionModel().getSelected();
            if (!record) {
              return;
            }
            onOpenDetail(record.id, record.get('pubTime'));
          })
          
          // more的window
          pThis.winMore = new Ext.Window({
            title: pThis.portletTitle,
            xtype: 'window',
            layout: 'fit',
            modal: false,
            maximizable: true,
            minimizable: true,
            width: 650,
            height: 500,
            plain: true,
            closeAction: 'hide',
            bodyStyle: 'padding:5 5 5 5;text-align:left;',
            items: [pThis.gridArticleApp]
          });
        }
        
        var dsGrid1 = pThis.gridArticleApp.getStore();
        dsGrid1.baseParams.searchType = 10;
        dsGrid1.baseParams.searchKey = '';
        
        dsGrid1.baseParams.searchPgPletId = pThis.pgPletId;
        dsGrid1.baseParams.pageId = pThis.pageId;
        dsGrid1.baseParams.groupId = pThis.groupId;
        dsGrid1.baseParams.counter = true;
        dsGrid1.baseParams.limit = pageSize;
        dsGrid1.baseParams.dir = 'desc';
        dsGrid1.baseParams.sort = 'id';
        dsGrid1.load({
          params: {
            start: 0
          }
        });
        pThis.winMore.show();
        
      }
    };
    if (pThis.showTools) {
      panelConf.tools = tools;
      panelConf.title = this.portletTitle;
    }
    pThis.panel = new Ext.PanelUF(panelConf);
    
    if (pThis.picPart) {
      pThis.panel.items.insert(0, pThis.picPart);
      pThis.panel.items.insert(1, pThis.gridPart);
    }
    else {
      pThis.panel.items.insert(0, pThis.gridPart);
    }
    
    function onOpenDetail(id, pubTime){
      window.open(context_g + "/html/portlet/article/articleDetail.jsp?articleId=" + id + "&pubTime=" + pubTime, 'maxwindow', "top=0,left=0,width=" + screen.availWidth + ",height=" + screen.availHeight + ",scrollbars=yes,toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    }
    
  },
  searchArticle: function(searchDs){
    var search = new ufgov.portal.portlet.ArticleSearch({
      columnStyle: false,
      hidePanelHeader: true,
      defaultCollapsedStatus: false,
      searchDs: searchDs
    });
    search.passParam({
      rowNum: this.rowNum,
      page_id: this.pageId,
      searchPgPletId: this.pgPletId
    });
    search.showPanel();
  },
  destroy: function(){
    if (this.panel) {
      MainPageIn.destroyPanel(this.panel);
      //this.panel.destroy();
      //this.panel = null;
    }
    if (this.winMore) {
      //this.winMore.destroy();
      //this.winMore = null;
    }
    if (this.winDetail) {
      //this.winDetail.destroy();
      //this.winDetail = null;
    }
    if (this.picPart) {
      //this.picPart.destroy();
      //this.picPart = null;
    }
    this.gridPart = null;
    this.gridAll = null;
    this.gridArticleApp = null;
  }
});




