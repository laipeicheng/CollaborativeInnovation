<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>404</title>

    <script src="../../assets/js/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="../../assets/layui/layui.js" type="text/javascript"></script>
    <script src="../../assets/js/index/index.js" type="text/javascript"></script>
    <script src="../../assets/js/index/freezeheader.js" type="text/javascript"></script>
    <script src="../../assets/layui/lay/modules/layer.js" type="text/javascript"></script>
    <script src="../../assets/js/index/sliders.js" type="text/javascript"></script>
    <script src="../../assets/js/index/html5.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../../assets/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="../../assets/layui/css/modules/layer/default/layer.css"/>
    <link rel="stylesheet" href="../../assets/css/global.css"/>
</head>
<body>
<div class="layui-header header" style="background-color: white">
    <div class="main" style="background-color: white">
        <ul class="layui-nav layui-nav-left" lay-filter="filter">

            <li class="layui-nav-item layui-this nav-left" pc>
                <a class="logo" href="index.html" title="Fly">logo</a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="filter" style="background-color: white">
            <!-- 搜索框 -->
            <form class="layui-form" method="post" action="#" style="margin-right: 200px; margin-top: 10px">
                <div class="layui-form-item">
                    <div class="layui-input-inline" width="60%">
                        <input type="text" name="title" lay-verify="required" placeholder="请输入关键字"
                               class="layui-input">
                    </div>
                    <input type="submit" class="layui-btn layui-btn-normal" lay-filter="*" lay-submit value="搜索"/>
                </div>
            </form>
        </ul>
    </div>
</div>
<div class="layui-header header" style="margin-top: 65px;background-color: #1E9FFF">
    <div class="main" style="background-color: #1E9FFF">
        <ul class="layui-nav layui-nav-left layui-bg-blue" lay-filter="filter">
            <li class="layui-nav-item layui-this nav-left" pc>
                <a href="index.html">首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="article.ftl">资源共享</a>
            </li>
            <li class="layui-nav-item">
                <a href="#">信息咨讯</a>
            </li>
            <li class="layui-nav-item">
                <a href="#">加入收藏</a>
            </li>
            <li class="layui-nav-item">
                <a href="#">关于我们</a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right layui-nav-right layui-bg-blue" lay-filter="filter">
            <li class="layui-nav-item">
                <a href="javascript:;">用户</a>
                <dl class="layui-nav-child">
                    <dd><a href="#">个人中心</a></dd>
                    <dd><a href="#">注销</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>

<div class="layui-container container">
    <div class="fly-none">
        <h2><i class="iconfont icon-404"></i></h2>
        <p>您访问的页面找不到！</p>
    </div>
</div>
<div class="footer">
    <hr>
    <p> 2017 &copy; layui框架</p>
</div>
</body>
</html>