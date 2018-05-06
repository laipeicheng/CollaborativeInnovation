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
                    <li class="layui-this" lay-id="info">个人资料</li>
                    <li lay-id="pass">密码</li>
                </ul>
                <div class="layui-tab-content" style="padding: 20px 0;">
                    <div class="layui-form layui-form-pane layui-tab-item layui-show">
                        <form class="layui-form" method="post" action="#">
                            <div class="layui-form-item">
                                <label for="username" class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="username" name="email" disabled autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="realname" class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="realname" lay-verify="required" autocomplete="off" value=""
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_city" class="layui-form-label">邮件</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_city" name="city" lay-verify="required" autocomplete="off"
                                           value="" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn layui-btn-normal" lay-filter="*" lay-submit>确认修改</button>
                            </div>
                        </form>
                    </div>

                    <div class="layui-form layui-form-pane layui-tab-item">
                        <form class="layui-form" method="post" action="#">
                            <div class="layui-form-item">
                                <label for="L_nowpass" class="layui-form-label">当前密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_nowpass" name="nowpass" lay-verify="required"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_pass" class="layui-form-label">新密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_pass" name="pass" lay-verify="required"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_repass" class="layui-form-label">确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_repass" name="repass" lay-verify="required"
                                           autocomplete="off" class="layui-input">
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