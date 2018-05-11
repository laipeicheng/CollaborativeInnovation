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
    <header class="layui-elip">协同创新-登录</header>
    <form class="layui-form" action="${base}/user/login" method="post">
        <div class="layui-input-inline">
            <input type="text" name="user.username" required  lay-verify="username" placeholder="用户名" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="user.password" required  lay-verify="password" placeholder="密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn layui-btn-normal">登录</button>
        </div>
        <hr/>
        <p><a href="${base}/register" class="fl">还没有账号？注册</a>
    </form>
</div>

<script type="text/javascript" src="${base}/assets/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form', 'layer'], function () {

        // 操作对象
        var form = layui.form
            , layer = layui.layer
            , $ = layui.jquery;

        // 验证
        form.verify({
            username: function (value) {
                if (value == "") {
                    return "请输入用户名";
                }
            },
            password: function (value) {
                if (value == "") {
                    return "请输入密码";
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