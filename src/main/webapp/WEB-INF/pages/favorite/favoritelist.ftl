<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户中心</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <div>
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>文章收藏</legend>
                </fieldset>
                <table class="layui-table" lay-skin="line">
                    <colgroup>
                        <col width="240">
                        <col width="100">
                        <col width="100">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>作者</th>
                        <th>文章分类</th>
                        <th>发表时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                <#list articleList! as article>
                <tr>
                    <td><a href="${base}/article?article.articleid=${(article.articleid)!}">${(article.title)!}</a></td>
                    <td>${(article.author.realname)!}</td>
                    <td>${(article.articletype.articletypename)!}</td>
                    <td>${(article.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</td>
                    <td><a href="javascript:;" onclick="delFavorite(${(article.articleid)!})"
                           class="layui-btn layui-btn-mini layui-btn-danger">取消收藏</a>
                    </td>
                </tr>
                </#list>
                    </tbody>
                </table>
                <div id="favoritepage"/>
                <script>
                    layui.use(['layer', 'laypage'], function () {
                        var layer = layui.layer
                                , laypage = layui.laypage;

                        //只显示上一页、下一页
                        laypage.render({
                            elem: 'favoritepage'
                            , count: ${(pages*10)!}
                            , theme: '#1E9FFF'
                            , curr:${curPage!1}
                            //['count', 'prev', 'page', 'next', 'limit', 'skip']
                            , layout: ['prev', 'page', 'next']
                            , jump: function (obj, first) {
                                if (!first) {
                                    location.href = "${base}/favorite/favoritelist?websiteCurrPage=${websiteCurrPage!1}&curPage=" + obj.curr;
                                }
                            }
                        });
                    });

                    function delFavorite(articleid) {
                        layer.confirm('是否删除？', {
                            btn: ['是', '否'] //按钮
                        }, function () {
                            location.href = "${base}/favorite/favoritedel?websiteCurrPage=${websiteCurrPage!1}&curPage=${curPage!1}&articleid=" + articleid;
                        }, function () {

                        });
                    };
                </script>
            </div>
            <div>
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>网站</legend>
                </fieldset>
                <table class="layui-table" lay-skin="line">
                    <colgroup>
                        <col width="100">
                        <col>
                        <col width="200">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>网站</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list websiteList! as website>
                    <tr>
                        <td>${(website_index+1)!}</td>
                        <td><a href="${(website.url)!}">${(website.title)!}:${(website.url)!}</a>
                        </td>
                        <td><a href="${base}/favorite/favoritelist?websiteCurrPage=${websiteCurrPage!1}&curPage=${curPage!1}&website.id=${(website.id)!}"
                               class="layui-btn layui-btn-mini layui-btn-primary">编辑</a>
                            <a href="javascript:;" onclick="delWebsite(${(website.id)!})"
                               class="layui-btn layui-btn-mini layui-btn-danger">删除</a>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <button onclick="add();" class="layui-btn layui-btn-normal layui-btn-small" style="float: right">添加</button>
                <div id="websitepage"/>
                <script>
                    layui.use(['layer', 'laypage'], function () {
                        var layer = layui.layer
                                , laypage = layui.laypage;

                        //只显示上一页、下一页
                        laypage.render({
                            elem: 'websitepage'
                            , count: ${(websitePages*10)!}
                            , theme: '#1E9FFF'
                            , curr:${websiteCurrPage!1}
                            //['count', 'prev', 'page', 'next', 'limit', 'skip']
                            , layout: ['prev', 'page', 'next']
                            , jump: function (obj, first) {
                                if (!first) {
                                    location.href = "${base}/favorite/favoritelist?curPage=${curPage!1}&websiteCurrPage=" + obj.curr;
                                }
                            }
                        });
                    });

                    function delWebsite(id) {
                        layer.confirm('是否删除？', {
                            btn: ['是', '否'] //按钮
                        }, function () {
                            location.href = "${base}/favorite/websitedel?websiteCurrPage=${websiteCurrPage!1}&curPage=${curPage!1}&website.id=" + id;
                        }, function () {

                        });
                    };

                    function add() {
                        layer.open({
                            type: 1,
                            skin: 'layui-layer-rim', //加上边框
                            area: ['500px', '350px'], //宽高
                            content: "<div style='margin: 10px'>" +
                            "<form action='${base}/favorite/websiteadd' method='post' class='layui-form layui-form-pane'>\n" +
                            "    <#if website??><input type='hidden' name='website.id' value='${(website.id)!}'/>\n</#if>" +
                            "    <div class='layui-form-item'>\n" +
                            "        <label for='title' class='layui-form-label'>网站名称</label>\n" +
                            "        <div class='layui-input-block'>\n" +
                            "            <input type='text' class='layui-input' lay-verify='title' name='website.title' value='${(website.title)!}'/>\n" +
                            "        </div>\n" +
                            "    </div>\n" +
                            "    <div class='layui-form-item'>\n" +
                            "        <label for='url' class='layui-form-label'>URL</label>\n" +
                            "        <div class='layui-input-block'>\n" +
                            "            <input type='text' class='layui-input' lay-verify='url' name='website.url' value='${(website.url)!}'/>\n" +
                            "        </div>\n" +
                            "    </div>\n" +
                            "    <div class='layui-form-item'>\n" +
                            "        <label for='account' class='layui-form-label'>用户名</label>\n" +
                            "        <div class='layui-input-block'>\n" +
                            "            <input type='text' class='layui-input' lay-verify='account' name='website.account' value='${(website.account)!}'/>\n" +
                            "        </div>\n" +
                            "    </div>\n" +
                            "    <div class='layui-form-item'>\n" +
                            "        <label for='password' class='layui-form-label'>密码</label>\n" +
                            "        <div class='layui-input-block'>\n" +
                            "            <input type='text' class='layui-input' lay-verify='password' name='website.password' value='${(website.password)!}'/>\n" +
                            "        </div>\n" +
                            "    </div>\n" +
                            "    <div class='layui-form-item' style='float: right'>\n" +
                            "        <input type='submit' class='layui-btn layui-btn-normal layui-btn-small' lay-submit value='添加'>\n" +
                            "    </div>\n" +
                            "</form>\n" +
                            "</div>\n" +
                            "<script>\n" +
                            "   layui.use(['form', 'layer'], function() {\n" +
                            "       var form = layui.form\n" +
                            "           ,layer = layui.layer;\n" +
                            "       form.verify({\n" +
                            "           title:function(value) {\n" +
                            "               if(''==value){\n" +
                            "                   return '网站名称不能为空';\n" +
                            "               }\n" +
                            "           },\n" +
                            "           account:function(value) {\n" +
                            "               if(''==value){\n" +
                            "                   return '用户名不能为空';\n" +
                            "               }\n" +
                            "           },\n" +
                            "           password:function(value) {\n" +
                            "               if(''==value){\n" +
                            "                   return '密码不能为空';\n" +
                            "               }\n" +
                            "           }\n" +
                            "       });\n" +
                            "   });\n" +
                            "<\/script\>\n",
                            cancel: function(index, layero){
                                location.href="${base}/favorite/favoritelist?websiteCurrPage=${websiteCurrPage!1}&curPage=${curPage!1}";
                            }
                        });
                    }
                    <#if website??>
                        add();
                    </#if>
                </script>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>