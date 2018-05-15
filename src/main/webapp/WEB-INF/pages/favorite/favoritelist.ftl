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
            <fieldset class="layui-elem-field layui-field-title">
                <legend>文章收藏</legend>
            </fieldset>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="100">
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
                    <td><a href="javascript:;" onclick="del(${(article.articleid)!})"
                           class="layui-btn layui-btn-mini layui-btn-danger">删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="page"/>
            <script>
                layui.use(['layer', 'laypage'], function () {
                    var layer = layui.layer
                            , laypage = layui.laypage;

                    //只显示上一页、下一页
                    laypage.render({
                        elem: 'page'
                        , count: ${(pages*10)!}
                        , theme: '#1E9FFF'
                        , curr:${curPage!1}
                        //['count', 'prev', 'page', 'next', 'limit', 'skip']
                        , layout: ['prev', 'page', 'next']
                        , jump: function (obj, first) {
                            if (!first) {
                                location.href = "${base}/article/articlelist?curPage=" + obj.curr;
                            }
                        }
                    });
                });

                function del(articleid) {
                    layer.confirm('是否删除？', {
                        btn: ['是', '否'] //按钮
                    }, function () {
                        location.href = "${base}/article/articledel?article.articleid=" + articleid;
                    }, function () {

                    });
                };
            </script>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>网站</legend>
            </fieldset>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>网站名称</th>
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
                    <td><a href="${base}/article/articleedit?article.articleid=${(article.articleid)!}"
                           class="layui-btn layui-btn-mini layui-btn-primary">编辑</a>
                        <a href="javascript:;" onclick="del(${(article.articleid)!})"
                           class="layui-btn layui-btn-mini layui-btn-danger">删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>