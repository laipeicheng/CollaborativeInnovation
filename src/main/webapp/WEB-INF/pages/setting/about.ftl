<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-网站设置 关于我们</title>
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
                    <li class="layui-this" lay-id="info">关于我们</li>
                </ul>
                <div class="layui-tab-content" style="padding: 20px 0;">
                    <div class="layui-form layui-form-pane layui-tab-item layui-show">
                        <form class="layui-form" method="post" action="${base}/setting/updateAbout"
                              enctype="multipart/form-data">
                            <div class="layui-form-item layui-form-text">
                                <label for="content" class="layui-form-label">正文</label>
                                <div class="layui-input-block">
                                    <div id="text"></div>
                                    <textarea id="content" name="aboutContent" class="layui-textarea" lay-verify="content" style="display: none;">${(aboutContent)!}</textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <input type="submit" id="submit" class="layui-btn layui-btn-normal" lay-submit
                                       value="修改"/>
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

                        editor.txt.html('${(aboutContent)!}');

                        layui.use(['form', 'layer'], function () {
                            var form = layui.form
                                    , layer = layui.layer;
                            form.verify({
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