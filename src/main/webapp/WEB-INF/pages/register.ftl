<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="${base}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${base}/assets/css/style.css">
</head>
<body class="login-body body">

<div class="login-main">
    <header class="layui-elip">协同创新-注册</header>
    <form id="registerform" name="registerform" class="layui-form" action="${base}/user/register" method="post">
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="text" name="user.username" lay-verify="username" placeholder="用户名" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="text" name="user.realname" required lay-verify="realname" placeholder="姓名"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="password" id="password" name="user.password" lay-verify="password" placeholder="密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="password" name="" lay-verify="repassword" placeholder="确认密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="text" name="user.phone" lay-verify="phone" placeholder="手机号码" autocomplete="off"
                       class="layui-input" maxlength="11">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="text" name="user.email" lay-verify="email" placeholder="邮箱" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input type="submit" lay-submit class="layui-btn layui-btn-normal" value="注册"/>
            </div>
        </div>
        <hr/>
        <p><a href="${base}/login" class="fl">已有账号，登录</a>

    </form>
</div>

<script src="${base}/assets/layui/layui.js"></script>
<script src="${base}/assets/js/jquery/jquery-2.1.4.min.js"></script>
<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form
                , layer = layui.layer;

        form.verify({
            elem: 'registerform',
            username: function (value) {
                var verifyStr = "";
                $.ajax({
                    url: "${base}/verify/username",
                    type: "post",
                    async: false,
                    data: {
                        "username": value
                    },
                    success: function (json) {
                        verifyStr = json.verifyStr;
                    }
                });
                return verifyStr;
            },
            realname: function (value) {
                if (value == "") {
                    return "请输入姓名";
                }
            },
            password: function (value) {
                if (value == "") {
                    return "请输入密码";
                }
            },
            repassword: function (value) {
                var pass = $('#password').val();
                console.log(pass);
                console.log(value);
                if (value != pass) {
                    return "两次输入密码不一致";
                }
            },
        });
        <#if msg??>
            layer.msg("${(msg)!}");
        </#if>
    });
</script>
</body>
</html>