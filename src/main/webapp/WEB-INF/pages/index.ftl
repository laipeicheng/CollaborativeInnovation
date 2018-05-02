<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-首页</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<@common.recommend />
<div class="layui-container container" style="margin-top: 65px">

    <div class="layui-row layui-col-space20">

        <div class="layui-col-md8">

            <div class="article-main">
                <h2 style="border-bottom: 4px solid gray">
                    最新文章
                </h2>
            <#list articleList as article>
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
                            <span class="lm">收藏（${(article.favoritecount)!}）</span>
                        </p>
                    </ul>
                </div>
            </#list>
            </div>
            <!--分页-->
            <div id="page"></div>
        </div>
        <div class="layui-col-md4" style="margin-top: 50px; margin-bottom: 50px">
            <!-- 登录框 -->
            <hr>
            <div class="layui-tab-content" style="padding: 0px 0;margin-top: 35px">
                <div class="layui-tab-item layui-show">
                <@shiro.guest>
                    <form class="layui-form" method="post" action="${base}/userlogin">
                        <div class="layui-form-pane">
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="user.username" lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="user.password" lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item" style="float: right;">
                            <a class="layui-btn layui-btn-small layui-btn-primary" href="${base}/register">注册</a>
                            <input type="submit" class="layui-btn layui-btn-small layui-btn-normal" lay-filter="*"
                                   lay-submit value="登录"/>
                        </div>
                    </form>
                </@shiro.guest>
                <@shiro.user>
                <div class="layui-form-pane">
                    <div class="layui-form-item">
                        <label class="layui-form-label">当前用户</label>
                        <div class="layui-input-inline">
                            <input type="text"  class="layui-input" disabled value="">
                        </div>
                    </div>
                </div>
                    <div class="layui-form-item" style="float: right;">
                        <a class="layui-btn layui-btn-small layui-btn-primary" href="${base}/usercenter">个人中心</a>
                        <a class="layui-btn layui-btn-small layui-btn-danger" href="${base}/logout" >注销</a>
                    </div>
                </@shiro.user>
                </div>
            </div>
            <hr>
            <!-- 选项卡 -->
            <div class="ms-top" style="padding-top: 20px">
                <ul class="hd" id="tab">
                    <li class="cur"><a>点击排行</a></li>
                    <li><a>收藏排行</a></li>
                    <li><a>最新评论</a></li>
                </ul>
            </div>
            <div class="ms-main" id="ms-main">
                <div style="display: block;" class="bd bd-news">
                    <ul>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
<br>
</body>
</html>
