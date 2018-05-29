<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>协同创新-登录</title>
    <link rel="stylesheet" href="${base}/assets/layui/css/layui.css">
    <link rel="stylesheet" href="${base}/assets/css/style.css">
</head>
<body class="login-body body">

<div class="login-main">
    <header class="layui-elip">协同创新-登录</header>
    <form class="layui-form" action="${base}/user/login" method="post">
        <div class="layui-input-inline">
            <input type="text" name="user.username" lay-verify="username" placeholder="用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="user.password" lay-verify="password" placeholder="密码"
                   autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <input type="submit" class="layui-btn layui-btn-normal" lay-submit value="登录"/>
        </div>
        <hr/>
        <p><a href="${base}/register" class="fl">还没有账号？注册</a>
            <a href="${base}/forget" class="fr">忘记密码?</a></p>
    </form>
</div>

<script src="${base}/assets/layui/layui.js" ></script>
<script src="${base}/assets/js/jquery/jquery-2.1.4.min.js"></script>
<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form
                , layer = layui.layer;

        form.verify({
            username: function (value) {
                if ("" == value) {
                    return "用户名不能为空";
                }
            },
            password: function (value) {
                if ("" == value) {
                    return "密码不能为空";
                }
            }
        });
        <#if msg??>
            layer.msg("${(msg)!}");
        </#if>
    });
</script>
</body>
</html>