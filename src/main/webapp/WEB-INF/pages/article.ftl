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
            <span class="layui-breadcrumb">
                <a href="index">首页</a>
                <a href="articlelist">资源共享</a>
                <a href="#">分类</a>
                <a><cite>${(article.title)!}</cite></a>
    	    </span>
                <hr class="layui-bg-gray">
                <div class="content" id="photos">
                    <h2 class="c_titile">${(article.title)!}</h2>
                    <p class="box_c"><span
                            class="d_time">发布时间：${(article.publishtime)!}</span><span>编辑：author</span><span>浏览（${(article.pageview)!}）</span>
                    </p>
                    <div class="detail-body">
                    ${(article.content)!}
                    </div>

                    <fieldset class="layui-elem-field layui-field-title" style="margin: 0px 0px; text-align: center;">
                        <legend>评论</legend>
                    </fieldset>
                    <div class="detail-box">
                        <ul class="jieda" id="jieda">

                            <li class="jieda-daan">
                                <a name="item-121212121212"></a>
                                <div class="detail-about detail-about-reply">
                                    <a class="jie-user" href="">
                                        <cite>
                                            <i>纸飞机</i>
                                            <em>(作者)</em>
                                            <em style="color:#5FB878">(管理员)</em>
                                            <em>3分钟前</em>
                                        </cite>
                                    </a>
                                </div>
                                <div class="detail-body jieda-body">
                                    <p>么么哒</p>
                                </div>
                                <div class="jieda-reply">
                                    <span class="jieda-zan zanok" type="zan"><i
                                            class="iconfont icon-zan"></i><em>12</em></span>
                                    <span type="reply"><i class="iconfont icon-svgmoban53"></i>回复</span>
                                    <div class="jieda-admin">
                                        <span type="edit">编辑</span>
                                        <span type="del">删除</span>
                                    </div>
                                </div>
                            </li>
                        <#--<li class="fly-none">没有任何回答</li>-->
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
                                    , count: 10
                                    //['count', 'prev', 'page', 'next', 'limit', 'skip']
                                    , layout: ['prev', 'page', 'next']
                                    , jump: function (obj, first) {
                                        if (!first) {
                                            layer.msg('第 ' + obj.curr + ' 页');
                                        }
                                    }
                                });
                            });
                        </script>
                        <form action="reply?reply.articleid=${(article.articleid)!}" method="post">
                            <div class="layui-form layui-form-pane">
                                <div class="layui-form-item layui-form-text">
                                    <div class="layui-input-block">
                                        <textarea id="reply" name="reply.replycontent" lay-verify="required"
                                                  class="layui-textarea"></textarea>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <input type="submit" class="layui-btn" lay-filter="*" lay-submit value="回复"/>
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
                <button class="layui-btn layui-btn-normal">分类一</button>
                <button class="layui-btn layui-btn-primary">分类二</button>
                <button class="layui-btn layui-btn-normal">分类三</button>
                <br/>
                <br/>
                <button class="layui-btn layui-btn-primary">分类四</button>
                <button class="layui-btn layui-btn-normal">分类五</button>
                <button class="layui-btn layui-btn-primary">分类六</button>
            </div>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px">
                <legend>文章推荐</legend>
            </fieldset>
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
</body>
</html>
