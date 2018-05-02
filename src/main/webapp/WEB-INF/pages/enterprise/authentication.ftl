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
                    <li class="layui-this" lay-id="info">企业认证</li>
                </ul>
                <div class="layui-tab-content" style="padding: 20px 0;">
                    <div class="layui-form layui-form-pane layui-tab-item layui-show">
                        <form class="layui-form" method="post" action="#">
                            <div class="layui-form-item">
                                <label for="username" class="layui-form-label">企业名称</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="username" name="email" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="realname" class="layui-form-label">简介</label>
                                <div class="layui-input-block">
                                        <textarea id="summary" name="" lay-verify="required"
                                                  class="layui-textarea fly-editor"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="username" class="layui-form-label">联系地址</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="username" name="email" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="username" class="layui-form-label">联系人姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="username" name="email" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="username" class="layui-form-label">联系人电话</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="username" name="email" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn layui-btn-normal" lay-filter="*" lay-submit>确认修改</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>