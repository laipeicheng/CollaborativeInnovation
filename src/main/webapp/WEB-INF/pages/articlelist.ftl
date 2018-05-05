<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-资源共享</title>
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
                <a><cite>知识库</cite></a>
            </span>
            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <ul class="layui-tab-title">
                    <#if articletypeList?size!=0>
                        <#list articletypeList as articletype>
                            <li class="<#if articletypeid=articletype.articletypeid>layui-this</#if>"><a
                                    href="${base}/articlelist?articletypeid=${(articletype.articletypeid)!}">${(articletype.articletypename)!}</a>
                            </li>
                        </#list>
                    </#if>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div class="article-main">
                            <#if articleList?size!=0>
                                <#list articleList! as article>
                                    <div class="article-list">
                                        <ul>
                                            <h3>
                                                <a href="${base}/article?article.articleid=${article.articleid}">${(article.title)!}</a>
                                            </h3>
                                            <p>${(article.summary)!}...</p>
                                            <p class="autor">
                                                <span class="dtime f_l">${(article.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
                                                <span class="viewnum f_r">浏览（${(article.pageview)!}）</span>
                                                <span class="pingl f_r">评论（${(article.reviewcount)!}）</span>
                                            </p>
                                        </ul>
                                    </div>
                                </#list>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>
