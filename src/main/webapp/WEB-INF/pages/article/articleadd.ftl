<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-文章管理 发布文章</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <div class="layui-tab layui-tab-brief" lay-filter="user">
                <ul class="layui-tab-title" id="LAY_mine">
                    <li class="layui-this" lay-id="info">发表文章</li>
                </ul>
                <div class="layui-tab-content" style="padding: 20px 0;">
                    <div class="layui-form layui-form-pane layui-tab-item layui-show">
                        <form class="layui-form" method="post" action="${base}/article/publish"
                              enctype="multipart/form-data">
                            <div class="layui-form-item">
                                <label for="title" class="layui-form-label">标题</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="title" name="article.title" autocomplete="off"
                                           class="layui-input" lay-verify="title"/>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="type" class="layui-form-label">分类</label>
                                <div class="layui-input-inline">
                                    <select id="type" name="article.articletype.articletypeid">
                                        <#list articletypeList as articletype>
                                            <option value="${(articletype.articletypeid)!}">${(articletype.articletypename)!}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label for="summary" class="layui-form-label">摘要</label>
                                <div class="layui-input-block">
                                    <textarea id="summary" name="article.summary"
                                              class="layui-textarea" lay-verify="summary"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label for="content" class="layui-form-label">正文</label>
                                <div class="layui-input-block">
                                    <div id="text"></div>
                                    <textarea id="content" name="article.content" class="layui-textarea" lay-verify="content" style="display: none;"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <input type="submit" id="submit" class="layui-btn layui-btn-normal" lay-submit
                                       value="发表"/>
                            </div>
                        </form>
                    </div>
                    <script>
                        var E = window.wangEditor;
                        var editor = new E('#text');
                        var content = $('#content');
                        editor.customConfig.onchange = function (html) {
                            // 监控变化，同步更新到 textarea
                            content.val(html);
                        };
                        editor.create();

                        layui.use(['form', 'layer'], function () {
                            var form = layui.form
                                    , layer = layui.layer;
                            form.verify({
                                title: function (value) {
                                    if ("" == value) {
                                        return "标题不能为空";
                                    }
                                },
                                summary: function (value) {
                                    if ("" == value) {
                                        return "摘要不能为空";
                                    }
                                },
                                content: function (value) {
                                    if ("" == value) {
                                        return "正文不能为空";
                                    }
                                }
                            });
                        });
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>