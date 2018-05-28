<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-文章管理</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>文章管理</legend>
            </fieldset>

            <form class="layui-form" method="get" action="${base}/article/articlelist">
                <a href="${base}/article/articleadd" class="layui-btn layui-btn-small layui-btn-normal">发表文章</a>
                <div class="layui-input-inline" style="margin-left: 290px">
                    <select name="articletypeid">
                        <option value="">全部</option>
                        <#list articletypeList! as articletype>
                            <option value="${(articletype.articletypeid)!}" <#if articletype.articletypeid==articletypeid!100>selected</#if>>${(articletype.articletypename)!}</option>
                        </#list>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="keyword" value="${(keyword)!}" placeholder="关键字"/>
                </div>
                <input type="submit" lay-submit class="layui-btn layui-btn-small layui-btn-normal" value="搜索" />
            </form>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="100">
                    <col width="100">
                    <col width="180">
                    <col width="150">
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
                <#list articleList as article>
                <tr>
                    <td><a href="${base}/article?article.articleid=${(article.articleid)!}">${(article.title)!}</a></td>
                    <td><#switch (article.author.role.roleid)!3>
                            <#case 3>
                                佚名
                                <#break>
                            <#case 2>
                                ${(article.author.realname)!}
                                <#break>
                            <#case 1>
                                ${(article.author.enterprise.name)!}
                                <#break>
                    </#switch></td>
                    <td>${(article.articletype.articletypename)!}</td>
                    <td>${(article.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</td>
                    <td><a href="${base}/article/articleedit?article.articleid=${(article.articleid)!}"
                           class="layui-btn layui-btn-mini layui-btn-primary">编辑</a><a
                            href="javascript:;" onclick="del(${(article.articleid)!})"
                            class="layui-btn layui-btn-mini layui-btn-danger">删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="page"/>
            <script>
                layui.use(['form', 'layer', 'laypage'], function () {
                    var layer = layui.layer
                            , form = layui.form
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
                                location.href = "${base}/article/articlelist?articletypeid=${(articletypeid)!}&keyword=${(keyword)!}&curPage=" + obj.curr;
                            }
                        }
                    });
                });

                function del(articleid) {
                    layer.confirm('是否删除？', {
                        btn: ['是', '否'] //按钮
                    }, function () {
                        location.href = "${base}/article/articledel?articletypeid=${(articletypeid)!}&keyword=${(keyword)!}&curPage=${(currPage)!}&article.articleid=" + articleid;
                    }, function () {

                    });
                };
            </script>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>