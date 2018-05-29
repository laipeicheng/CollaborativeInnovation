<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-搜索结果</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="margin-top: 65px">
    <div class="layui-row">
        <div class="layui-col-md12">
            <span class="">
                <a href="${base}/index">首页</a>
                &nbsp;>&nbsp;
                <a><cite>搜索结果</cite></a>
            </span>
            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <ul class="layui-tab-title">
                    <#list conditionList! as cdt>
                        <li class="<#if condition=cdt>layui-this</#if>">
                            <a href="${base}/search?condition=${(cdt)!}&searchKeyword=${(searchKeyword)!}">
                            <#switch cdt>
                                <#case "article">文章<#break>
                                <#case "news">新闻<#break>
                                <#case "needs">需求<#break>
                                <#case "policy">政策<#break>
                            </#switch></a>
                        </li>
                    </#list>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div class="article-main">
                                <#list resultList! as result>
                                    <div class="article-list">
                                        <ul>
                                            <h3>
                                                <a href="${base}/${(result.url)!}">${(result.title)!}</a>
                                            </h3>
                                            <p>${(result.summary)!}...</p>
                                            <p class="autor">
                                                <span class="dtime f_l">${(result.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
                                            </p>
                                        </ul>
                                    </div>
                                </#list>
                            <div id="page"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
<script>
    layui.use(['laypage'], function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page',
            count: ${(pages*10)!},
            theme: '#1E9FFF',
            curr: ${curPage!1},
            layout: ['prev', 'page', 'next'],
            jump: function (obj, first) {
                if (!first) {
                    location.href = "${base}/search?condition=${(condition)!}&searchKeyword=${(searchKeyword)!}&curPage=" + obj.curr;
                }
            }
        });
    });
</script>
</body>
</html>
