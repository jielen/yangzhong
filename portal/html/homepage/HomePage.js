/**
 * @author hmgkevin
 */
ufgov.portal.HomePage = function(){
    return {
        initData: function(){
            var login = new ufgov.portal.portlet.LoginPortlet();
			this.loginPanel = new ufgov.portal.Portlet({
                autoHeight: true,
                width: 250,
                border: true,
                items: login.panel
            });
			var article = "ufgov.portal.portlet.ArticleApp";
			this.noticePanel = this.createPortletPanel('notice', article, "公告通知", "8");
			this.newsPanel = this.createPortletPanel("news", article, "新闻");
			this.workDynamicPanel = this.createPortletPanel("workDynamic", article, "工作动态", "8");
			this.linkPanel = this.createPortletPanel("link", "ufgov.portal.portlet.Link", "相关链接", "4", "250");
			
			this.createMainFrame();
        },
		createPortletPanel: function(portletId, portletClass, portletTitle, recordSize, panelWidth){
			//debugger;
			var portletClassName = eval(portletClass);
			try {
				var portletObj = new portletClassName();
				var portletParam = '{page_id: "homePage"';
				if (portletTitle) {
					portletParam += ', title: "' + portletTitle + '"';
				}
				if (portletId) {
					portletParam += ', portlet_id:"' + portletId + '"';
				}
				if (recordSize) {
					portletParam += ', record_size:"' + recordSize + '"';
				}
				if (panelWidth) {
					portletParam += ', panelWidth:' + panelWidth;
				}
				portletParam += '}'; 
				portletObj.passParam(Ext.util.JSON.decode(portletParam));
				var retPanel = new ufgov.portal.Portlet({
					autoHeight: true,
					border: true,
					items: portletObj.panel
				});
				portletObj = null;
				return retPanel;
			} 
			catch (e) {
				var portlet = new ufgov.portal.Portlet({
					border: true,
					autoHeight: true,
					title: portletTitle,
					html: '没有定义该频道js文件对应的类名，请在数据库中添加'
				});
				return portlet;
			}
		},
		createMainFrame: function(){
			this.pagePortletPanel = new ufgov.portal.Template({
				border: false,
				items: [{
					width: 250,
					style: "padding:0px 0px 0px 0px"
				},{
					columnWidth: 0.7,
					style: "padding:0px 10px 0px 10px"
				},{
					columnWidth: 0.3,
					style: "padding:0px 0px 0px 0px"
				}]
			});
			this.pageContPanel = new Ext.Panel({
				applyTo: 'mainFramePanel',
				id: 'pageContPanel',
				border: false,
				autoHeight: true,
				items: this.pagePortletPanel
			});
			this.showPortlet();
		},
		showPortlet: function(){
			var ppanel = this.pagePortletPanel;
			ppanel.items.itemAt(0).add(this.loginPanel);
			ppanel.items.itemAt(1).add(this.noticePanel);
			ppanel.items.itemAt(1).add(this.workDynamicPanel);
			ppanel.items.itemAt(2).add(this.newsPanel);
			ppanel.items.itemAt(0).add(this.linkPanel);
			ppanel.doLayout();
		}
    };
};
Ext.onReady(function(){
    var HomePage = new ufgov.portal.HomePage();
    HomePage.initData();
});
