<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户中心</title>
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
                        <form class="layui-form" method="post" action="#" enctype="multipart/form-data">
                            <div class="layui-form-item">
                                <label for="name" class="layui-form-label">标题</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="name" name="enterprise.name" autocomplete="off"
                                           class="layui-input" />
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="" class="layui-form-label">分类</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="sex" value="0" checked title="男">
                                    <input type="radio" name="sex" value="1" title="女">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="summary" class="layui-form-label">摘要</label>
                                <div class="layui-input-block">
                                        <textarea id="summary" name="enterprise.summary" lay-verify="required"
                                                  class="layui-textarea" ></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="summary" class="layui-form-label">正文</label>
                                <div class="layui-input-block">
                                        <textarea id="summary" name="enterprise.summary" lay-verify="required"
                                                  class="layui-textarea" ></textarea>
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <input type="submit" id="submit" class="layui-btn layui-btn-normal" lay-submit
                                       value="发表" />
                            </div>
                        </form>
                    </div>
                    <script>
                        function preview(file) {
                            var extIndex = file.value.lastIndexOf('.');
                            var ext = file.value.substring(extIndex+1);
                            if('jpg'==ext || 'png'== ext){

                            }else {
                                layer.msg("上传的必须为图片");
                                file.value="";
                            }
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