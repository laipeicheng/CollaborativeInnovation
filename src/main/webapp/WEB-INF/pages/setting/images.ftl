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
                        <form id="main" class="layui-form" method="post" action="${base}/setting/updateimages">
                            <#list imageList! as image>
                                <div id="image${('${image}'?substring(0, '${image}'?last_index_of('.')))!}" class="layui-form-item">
                                    <label class="layui-form-label">图片</label>
                                    <div class='layui-input-inline'>
                                        <input type='text' disabled class='layui-input' value='${(image)!}'/>
                                        <input type='hidden' name='images' value='${(image)!}'/>
                                    </div>
                                    <div class='layui-form-mid'>
                                        <button class='layui-btn-mini layui-btn layui-btn-danger' onclick="del('${('${image}'?substring(0, '${image}'?last_index_of('.')))!}')">删除</button>
                                    </div>
                                </div>
                            </#list>
                            <div class="layui-form-item">
                                <label for="test" class="layui-form-label">图片</label>
                                <button id="test" type="button" class="layui-input-inline layui-btn layui-btn-primary">
                                    选择图片
                                </button>
                            </div>
                            <div class="layui-form-item">
                                <label for="demo1" class="layui-form-label">预览</label>
                                <div class="layui-input-block">
                                    <div class="layui-carousel" id="test1" lay-filter="test1">
                                        <div id="image" carousel-item="">
                                        <#list imageList! as image>
                                            <div id='preview${('${image}'?substring(0, '${image}'?last_index_of('.')))!}' style='background-color: white'>
                                                <img style='height: 100%;width: 100%' src='${base}/carousel/${(image)!}'/>
                                            </div>
                                        </#list>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="submit" class="layui-form-item">
                                <input type="submit" class="layui-btn layui-btn-normal" value="保存"/>
                            </div>
                        </form>
                    </div>
                    <script>
                        var ins;
                        layui.use(['upload', 'form', 'layer', 'carousel'], function () {
                            var $ = layui.jquery
                                    , form = layui.form
                                    , layer = layui.layer
                                    , upload = layui.upload
                                    , carousel = layui.carousel;

                            ins = carousel.render({
                                elem: '#test1'
                                , arrow: 'always'
                            });

                            //普通图片上传
                            upload.render({
                                elem: '#test'
                                , url: '${base}/upload/images'
                                , size: 1024
                                , exts: 'jpg|jpeg|png'
                                , before: function (obj) {
                                    //预读本地文件示例，不支持ie8
                                    obj.preview(function (index, file, result) {
                                        /*$('#image').prepend("<div id='preview"+index+"' style='background-color: white'><img style='height: 100%;width: 100%' src='"+result+"'/></div>");
                                        ins.reload();
                                        $('#main').prepend("" +
                                                "<div id='image"+index+"' class='layui-form-item'>\n" +
                                                "    <label class='layui-form-label'>图片</label>\n" +
                                                "    <div class='layui-input-inline'>\n" +
                                                "        <input type='text' disabled class='layui-input' value='"+file.name+"'/>\n" +
                                                "    </div>\n" +
                                                "    <div class='layui-form-mid'>\n" +
                                                "        <button class='layui-btn-mini layui-btn layui-btn-danger layui-btn-disabled' disabled onclick=\"del('"+index+"')\">删除</button>\n" +
                                                "    </div>\n" +
                                                "</div>");*/
                                    });
                                }
                                , done: function (res) {
                                    var fileUrl = (res.fileUrl).substring(0, (res.fileUrl).lastIndexOf("."));
                                    console.log(fileUrl);
                                    $('#image').prepend("" +
                                            "<div id='preview" + fileUrl + "' style='background-color: white'>" +
                                            "    <img style='height: 100%;width: 100%' src='${base}/carousel/" + res.fileUrl + "'/>" +
                                            "</div>");
                                    ins.reload();
                                    $('#main').prepend("" +
                                            "<div id='image" + fileUrl + "' class='layui-form-item'>\n" +
                                            "    <label class='layui-form-label'>图片</label>\n" +
                                            "    <div class='layui-input-inline'>\n" +
                                            "        <input type='text' disabled class='layui-input' value='" + res.fileFileName + "'/>\n" +
                                            "        <input type='hidden' name='images' value='" + res.fileUrl + "'/>\n" +
                                            "    </div>\n" +
                                            "    <div class='layui-form-mid'>\n" +
                                            "        <button class='layui-btn-mini layui-btn layui-btn-danger' onclick=\"del('" + fileUrl + "')\">删除</button>\n" +
                                            "    </div>\n" +
                                            "</div>");
                                }
                                , error: function () {
                                    //uploadInst.upload();
                                }
                            });
                        });

                        function del(index) {
                            $('#image' + index).remove();
                            $('#preview' + index).remove();
                            ins.reload();
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>