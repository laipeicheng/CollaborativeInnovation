<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-需求管理 发布需求</title>
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
                    <li class="layui-this" lay-id="info">发布需求</li>
                </ul>
                <div class="layui-tab-content" style="padding: 20px 0;">
                    <div class="layui-form layui-form-pane layui-tab-item layui-show">
                        <form class="layui-form" method="post" action="${base}/needs/publish"
                              enctype="multipart/form-data">
                            <div class="layui-form-item">
                                <label for="title" class="layui-form-label">标题</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="title" name="needs.title" autocomplete="off"
                                           class="layui-input" lay-verify="title"/>
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label for="summary" class="layui-form-label">详情</label>
                                <div class="layui-input-block">
                                    <textarea id="summary" name="needs.content"
                                              class="layui-textarea" lay-verify="content"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <input type="submit" id="submit" class="layui-btn layui-btn-normal" lay-submit
                                       value="发布"/>
                            </div>
                        </form>
                    </div>
                    <script>
                        layui.use(['form', 'layer'], function () {
                            var form = layui.form
                                    , layer = layui.layer;
                            form.verify({
                                title: function (value) {
                                    if ("" == value) {
                                        return "标题不能为空";
                                    }
                                },
                                content: function (value) {
                                    if ("" == value) {
                                        return "详情不能为空";
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