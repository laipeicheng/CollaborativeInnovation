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
<@common.recommend />
<div class="layui-container container" style="margin-top: 65px">
    <div class="layui-row layui-col-space20">
        <div class="layui-col-md8">
            <div>
            <span class="">
                <a href="index">首页</a>
                &nbsp;>&nbsp;
                <a href="articlelist">知识库</a>
                &nbsp;>&nbsp;
                <a href="${base}/articlelist?articletypeid=${(article.articletype.articletypeid)!}">${(article.articletype.articletypename)!}</a>
                &nbsp;>&nbsp;
                <a><cite>${(article.title)!}</cite></a>
    	    </span>
                <hr class="layui-bg-gray">
                <div class="content" id="photos">
                    <h2 class="c_titile">${(article.title)!}</h2>
                    <p class="box_c"><span
                            class="d_time">发表时间：${(article.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</span><span>作者：${(article.author.realname)!}</span><span>浏览（${(article.pageview)!}）</span><span><a href="#">收藏</a></span>
                    </p>
                    <div class="detail-body">
                    ${(article.content)!}
                    </div>

                    <fieldset class="layui-elem-field layui-field-title" style="margin: 0px 0px; text-align: center;">
                        <legend>评论</legend>
                    </fieldset>
                    <div class="detail-box">
                        <ul class="jieda" id="jieda">
                            <#if article.replySet?size=0>
                                <li class="fly-none">没有任何回答</li>
                            <#else>
                                <#list replyList as reply>
                                <li class="jieda-daan">
                                <#--<a name="item-121212121212"></a>-->
                                    <div class="detail-about detail-about-reply">
                                        <a class="jie-user" href="">
                                            <cite>
                                                <i>${(reply.user.realname)!}</i>
                                                <#if reply.user.username=article.author.username><em>(作者)</em></#if>
                                                <#if ((reply.user.role.roleid)!)==0><em
                                                        style="color:#5FB878">(管理员)</em></#if>
                                                <em>${(reply.replytime)!}</em>
                                            </cite>
                                        </a>
                                    </div>
                                    <div class="detail-body jieda-body">
                                        <p>${(reply.replycontent)!}</p>
                                    </div>
                                    <div class="jieda-reply">
                                        <a>&nbsp;</a>
                                        <div class="jieda-admin">
                                            <#if article.author.username=(user.username)!||reply.user.username=(user.username)!||"admin"=(user.username)!>
                                                <span type="del"><a
                                                        href="${base}/delReply?reply.replyid=${reply.replyid}">删除</a></span></#if>
                                        </div>
                                    </div>
                                </li>
                                </#list>
                            </#if>
                        </ul>
                        <!--分页-->
                        <div id="page_reply"></div>
                        <script>
                            layui.use(['layer', 'laypage'], function () {
                                var layer = layui.layer
                                        , laypage = layui.laypage;

                                //只显示上一页、下一页
                                laypage.render({
                                    elem: 'page_reply'
                                    , count: ${(pages*10)!}
                                    , theme: '#1E9FFF'
                                    , curr:${curPage!1}
                                    //['count', 'prev', 'page', 'next', 'limit', 'skip']
                                    , layout: ['prev', 'page', 'next']
                                    , jump: function (obj, first) {
                                        if (!first) {
                                            location.href = "${base}/article?article.articleid=${article.articleid}&curPage=" + obj.curr;
                                        }
                                    }
                                });
                            });
                        </script>
                        <form action="reply?reply.article.articleid=${(article.articleid)!}" method="post">
                            <div class="layui-form layui-form-pane">
                                <div class="layui-form-item layui-form-text">
                                    <div class="layui-input-block">
                                        <textarea id="reply" name="reply.replycontent" lay-verify="required"
                                                  class="layui-textarea"></textarea>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <input type="submit" class="layui-btn layui-btn-normal" lay-filter="*" lay-submit
                                           value="回复"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="article-fenlei">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 38px">
                    <legend>文章分类</legend>
                </fieldset>
                <#if articletypeList?size!=0>
                    <#list articletypeList as articletype>
                        <#if articletype_index%3==0><br><br></#if>
                        <a href="${base}/articlelist?articletypeid=${(articletype.articletypeid)!}"
                           class="layui-btn layui-btn-primary">${(articletype.articletypename)!}</a>
                    </#list>
                </#if>
            </div>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px">
                <legend>文章推荐</legend>
            </fieldset>
            <div class="ms-top" style="padding-top: 20px">
                <ul class="hd" id="tab">
                    <li class="cur"><a>点击排行</a></li>
                    <li><a>最新评论</a></li>
                </ul>
            </div>
            <div class="ms-main">
                <div style="display: block;" class="bd bd-news">
                    <ul id="recommend">
                        <#list articleList as article>
                            <li>
                                <a href="${base}/article?article.articleid=${(article.articleid)!}">${(article.title)!}</a>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>
