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
    <form class="layui-form" action="register" method="post">
        <div class="layui-input-inline">
            <input type="text" name="username" required  lay-verify="username" placeholder="用户名" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" required  lay-verify="password" placeholder="密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn layui-btn-normal">注册</button>
        </div>
        <hr/>
        <p><a href="login" class="fl">已有账号，登录</a>
    </form>
</div>

<script type="text/javascript" src="${base}/assets/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form'], function () {
        var form    = layui.form
            ,$      = layui.jquery;

        // you code ...


    });
</script>
</body>
</html>