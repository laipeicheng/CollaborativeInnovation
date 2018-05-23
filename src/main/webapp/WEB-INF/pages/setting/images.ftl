<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-网站设置 图片轮播</title>
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
                    <li class="layui-this" lay-id="info">图片轮播</li>
                </ul>
                <div class="layui-tab-content" style="padding: 20px 0;">
                    <div class="layui-form layui-form-pane layui-tab-item layui-show">
                        <form id="auth" class="layui-form" method="post" action="${base}/enterprise/auth" enctype="multipart/form-data">

                            <div class="layui-form-item">
                                <label for="test1" class="layui-form-label">图片</label>
                                <button id="test1" type="button" class="layui-input-inline layui-btn layui-btn-primary">
                                    选择图片
                                </button>
                            </div>
                            <div class="layui-form-item">
                                <label for="demo1" class="layui-form-label">预览</label>
                                <div class="layui-input-block">
                                    <img style="height: 425px;width: 800px;border: 1px solid darkgrey" id="demo1"/>
                                </div>
                            </div>
                            <div id="submit" class="layui-form-item">
                                <input type="submit" disabled class="layui-btn layui-btn-disabled" value="请求认证"/>
                            </div>
                        </form>
                    </div>
                    <script>
                        layui.use(['upload', 'form', 'layer'], function () {
                            var $ = layui.jquery
                                    , form = layui.form
                                    , layer = layui.layer
                                    , upload = layui.upload;

                            form.verify({
                                fileUrl: function (value) {
                                    if ("" == value) {
                                        return "图片未上传成功，请重新选择图片";
                                    }
                                },
                                name:function (value) {
                                    if ("" == value) {
                                        return "企业名不能为空";
                                    }
                                },
                                summary:function (value) {

                                },
                                address:function (value) {
                                    if ("" == value) {
                                        return "地址不能为空";
                                    }
                                }
                            });

                            //普通图片上传
                            var uploadInst = upload.render({
                                elem: '#test1'
                                , url: '${base}/upload/license'
                                , size: 1024
                                , exts: 'jpg|jpeg|png'
                                , before: function (obj) {
                                    //预读本地文件示例，不支持ie8
                                    obj.preview(function (index, file, result) {
                                        $('#demo1').attr('src', result); //图片链接（base64）
                                    });
                                }
                                , done: function (res) {
                                    if (res.uploadStatus) {
                                        $('#submit input').remove();
                                        $('#submit').append("<input type='submit' class='layui-btn layui-btn-normal' lay-submit value='请求认证' />");
                                        $('#fileUrl').val(res.fileUrl);
                                    }
                                    //上传成功
                                }
                                , error: function () {
                                    //uploadInst.upload();
                                }
                            });

                            <#switch (enterprise.status)!3>
                            <#case 2>layer.msg("认证未通过请重新提交认证申请");<#break>
                            </#switch>
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