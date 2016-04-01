/**
 *
 */
ufgov.portal.FuncLink = function(){
    return {
        createNavigation: function(portalArray){
            var welcomeImg = 'html/themes/' + portalArray.theme_code + '/' + portalArray.welcome_img;
            if (Ext.isEmpty(welcomeImg)) {
                welcomeImg = 'html/themes/default/img/welcome.jpg';
            }
            var welcome = portalArray.welcome;
            if (welcome) {
                welcome = PF.replaceWithSysVariables(welcome, false);
            }
            var nav = new Ext.Panel({
                border: false,
                baseCls: 'nav-panel',
                applyTo: 'navigation',
                tbar: [{
                    text: welcome + "&nbsp;&nbsp;"
                }]
            });
            var funcLink = new Array();
            if (portalArray.func_link.indexOf('@') > 0) {
                funcLink = portalArray.func_link.split('@');
            }
            else {
                funcLink[0] = portalArray.func_link;
            }
            var funcJson = "";
            if (funcLink.length > 0) {
                funcJson = "[";
                for (var i = 0; i < funcLink.length; i++) {
                    var temp = funcLink[i].split(',');
                    if (temp[0] == 'system' && userId != 'sa') {
                        continue;
                    }
                    //debugger;
                    if (funcJson.length > 1) 
                        funcJson += ",";
                    if (temp.length > 2 && !Ext.isEmpty(temp[2])) {
                        funcJson += "{";
                        funcJson += "text:'<img src=\"" + "html/themes/" + portalArray.theme_code + "/" + temp[2] + "\" height=\"15\">',";
                        funcJson += "id: '" + temp[0] + "',";
                        funcJson += "handler: function(){var FuncLink = new ufgov.portal.FuncLink();FuncLink.doFuncLink('" + temp[0] + "');}";
                        funcJson += "}";
                    }
                    else {
                        funcJson += "{";
                        funcJson += "text:'" + temp[1] + "',";
                        funcJson += "id: '" + temp[0] + "',";
                        funcJson += "handler: function(){var FuncLink = new ufgov.portal.FuncLink();FuncLink.doFuncLink('" + temp[0] + "');}";
                        funcJson += "}"
                    }
                }
                funcJson += "]";
            }
            if (!Ext.isEmpty(funcJson)) {
                nav.getTopToolbar().add('->', Ext.util.JSON.decode(funcJson));
            }
            //var arVersion = navigator.appVersion.split("MSIE");
            //var version = parseFloat(arVersion[1]);
            //if ((version >= 5.5) && (version < 7)) {
            //    this.correctPNG4IE6();
           // }
            var store = new Ext.data.JsonStore({
                autoLoad: true,
                url: "getJsonData.action",
                baseParams: {
                    ruleID: 'portal-common.getGroup',
                    userId: document.getElementById('svUserId').getAttribute('value')
                },
                fields: [{
                    name: 'groupId',
                    mapping: 'groupid'
                }, {
                    name: 'groupName',
                    mapping: 'groupname'
                }, {
                    name: 'pageOrient',
                    mapping: 'pageorient'
                }]
            });
            this.userGroup = new Ext.form.ComboBox({
                store: store,
                id: 'userGroupCombo',
                displayField: 'groupName',
                valueField: 'groupId',
                hiddenName: 'groupId', //提交到后台的input的name
                typeAhead: true,
                mode: 'local', //'local'-本地数据；'remote'-远程数据
                forceSelection: true,
                triggerAction: 'all',
                editable: false,
                allowBlank: false,//不允许为空
                width: 120,
                height: 30,
                selectOnFocus: true
            });
            this.store = store;
            nav.getTopToolbar().add('->', this.userGroup);
        },
        doFuncLink: function(id){
            if (id == 'mainpage') {
            
            }
            else 
                if (id == 'relogin') {
                    this.relogin();
                }
                else 
                    if (id == 'global') {
                        this.setGlobal();
                    }
                    else 
                        if (id == 'myaccount') {
                            this.editMyAccount();
                        }
                        else 
                            if (id == 'modifypass') {
                                this.modifyPass();
                            }
                            else 
                                if (id == 'clientset') {
                                    this.gotoConfigPage();
                                }
                                else 
                                    if (id == 'system') {
                                        window.open("dispatcher.action?function=system", "new", "left=0px,top=0px,width=" + screen.availWidth + ",height=" + screen.availHeight + ",menubar=no,scrollbars=no,status=no,toolbar=no,resizable=no");
                                    }
        },
        setGlobal: function(){
            var win_edit = window.showModalDialog("/admin/dispatcher.action?function=global&token=" + token, window, "dialogHeight:590px;dialogWidth:585px;" +
            "resizable:no;help:no;status:no");
            if (win_edit) {
                PF.setCookie("showGlobal", "false");
                window.location.reload();
            }
        },
        relogin: function(){
            PF.setCookie("showGlobal", "true");
            Ext.Ajax.request({
                url: 'logout.action',
                success: function(){
                    window.location.href = "index.jsp";
                }
            })
        },
        editMyAccount: function(){
            var userProfile = new ufgov.portal.portlet.UserProfileEdit({
                userId: userId
            });
        },
        modifyPass: function(){
            window.open("/admin/dispatcher.action?function=passwd&METH=main&USERID=" + userId + "&token=" + token, "new", "left=" + (screen.availWidth - 450) / 2 + "px,top=" + (screen.availHeight - 400) / 2 + "px,width=450px,height=300px,menubar=no,scrollbars=no,status=no,toolbar=no,resizable=no");
        },
        gotoConfigPage: function(){
            window.open("/admin/clientconfig.jsp", null, "menubar=no,scrollbars=yes,status=yes,toolbar=no," +
            "resizable=yes,titlebar=no,scrollbars=yes,location=no," +
            "height=" +
            (screen.availHeight - 30) +
            ",width=" +
            (screen.availWidth - 10) +
            ",top=0,left=0");
        },
        correctPNG4IE6: function(){
            //获得全部图片
            var imgs = document.getElementsByTagName("IMG");
            for (var i = 0; i < imgs.length; i++) {
                var img = imgs[i];
                var imgName = img.src.toUpperCase();
                //操作PNG图片
                if (imgName.substring(imgName.length - 3, imgName.length) == "PNG") {
                    var imgID = (img.id) ? "id='" + img.id + "' " : "";
                    var imgClass = (img.className) ? "class='" + img.className + "' " : "";
                    var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' ";
                    var imgStyle = "display:inline-block;" + img.style.cssText;
                    if (img.align == "left") 
                        imgStyle = "float:left;" + imgStyle;
                    if (img.align == "right") 
                        imgStyle = "float:right;" + imgStyle;
                    if (img.parentElement.href) 
                        imgStyle = "cursor:hand;" + imgStyle;
                    
                    /**
                     * 对于隐藏层中的图片，或者其他原因导致图片尺寸无法获得
                     * 此时我们需要读取图片的真实大小
                     * 以免宽高都为0px而导致图片不显示
                     */
                    var imgTrueWidth = 0;
                    var imgTrueHeight = 0;
                    if (img.width == 0) {
                        var imgPng = new Image();
                        imgPng.src = img.src;
                        imgTrueWidth = imgPng.width;
                        imgTrueHeight = imgPng.height;
                    }
                    
                    //用<span>替换<img>标签
                    var strNewHTML = "<span " + imgID + imgClass + imgTitle + " style=\"";
                    strNewHTML = strNewHTML + "width:" + (img.width == 0 ? imgTrueWidth : img.width) + "px; height:";
                    strNewHTML = strNewHTML + (img.height == 0 ? imgTrueHeight : img.height) + "px;";
                    strNewHTML = strNewHTML + imgStyle + ";" + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader";
                    strNewHTML = strNewHTML + "(src='" + img.src + "', sizingMethod='scale');\"></span>";
                    
                    //执行替换
                    img.outerHTML = strNewHTML;
                    i = i - 1;
                }
            }
        }
    }
}
