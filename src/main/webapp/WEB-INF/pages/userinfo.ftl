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
                        <form class="layui-form" lay-filter="upwd" method="post" action="${base}/user/updateinfo">
                            <div class="layui-form-item">
                                <label for="username" class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="username" name="user.username" autocomplete="off"
                                           class="layui-input" value="${(user.username)!}">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="realname" class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="user.realname" lay-verify="realname" autocomplete="off"
                                           value="${(user.realname)!}" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="phone" class="layui-form-label">手机</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="phone" name="user.phone" lay-verify="phone"
                                           autocomplete="off"
                                           value="${(user.phone)!}" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <input type="submit" class="layui-btn layui-btn-normal" lay-filter="*" value="修改"/>
                            </div>
                        </form>
                    </div>

                    <div class="layui-tab-item">
                        <form id="upwd" class="layui-form layui-form-pane" method="post"
                              action="${base}/user/updatepwd">
                            <div class="layui-form-item">
                                <input type="hidden" name="user.username" value="${(user.username)!}">
                                <label for="password" class="layui-form-label">当前密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="password" name="user.password" lay-verify="password"
                                           autocomplete="off" class="layui-input"/>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="newpass" class="layui-form-label">新密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="newpass" name="newpass" lay-verify="newpass"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="repass" class="layui-form-label">确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="repass" name="repass" lay-verify="repass"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <input type="submit" lay-submit class="layui-btn layui-btn-normal" value="修改"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form
                , layer = layui.layer;

        form.verify({
            password: function (value) {
                var verifyStr = "";
                $.ajax({
                    url: "${base}/verify/password",
                    type: "post",
                    async: false,
                    data: {
                        "username": "${(user.username)!}",
                        "password": value
                    },
                    success: function (json) {
                        verifyStr = json.verifyStr;
                    }
                });
                return verifyStr;
            },
            newpass: function (value) {
                if (value == "") {
                    return "请输入新密码"
                }
            },
            repass: function (value) {
                var pass = $('#newpass').val();
                if (value != pass) {
                    return "两次输入密码不一致";
                }
            },
        });
    });
</script>
<@common.footer />
</body>
</html>