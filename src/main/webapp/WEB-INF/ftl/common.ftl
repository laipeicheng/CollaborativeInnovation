<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<#macro link_and_script>
<script src="${base}/assets/js/jquery/jquery-2.1.4.min.js"></script>
<script src="${base}/assets/layui/layui.js"></script>
<script src="${base}/assets/js/index/index.js"></script>
<script src="${base}/assets/js/index/freezeheader.js"></script>
<script src="${base}/assets/layui/lay/modules/layer.js"></script>
<script src="${base}/assets/js/index/sliders.js"></script>
<script src="${base}/assets/js/index/html5.js"></script>
<script src="${base}/assets/js/index/wangEditor.min.js"></script>

<link rel="stylesheet" href="${base}/assets/layui/css/layui.css" media="all"/>
<link rel="stylesheet" href="${base}/assets/layui/css/modules/layer/default/layer.css"/>
<link rel="stylesheet" href="${base}/assets/css/global.css"/>
</#macro>

<#macro header>
<div class="layui-header header" style="background-color: white">
    <div class="main" style="background-color: white">
        <ul class="layui-nav" lay-filter="filter">

            <li class="layui-nav-item layui-this nav-left" pc>
                <a class="logo" href="${base}/index" title="Fly">logo</a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="filter" style="background-color: white">
            <!-- 搜索框 -->
            <form class="layui-form" method="get" action="${base}/search" style="margin-right: 200px; margin-top: 10px">
                <div class="layui-form-item">
                    <div class="layui-input-inline" width="60%">
                        <input type="text" name="searchKeyword" lay-verify="keyword" placeholder="关键字"
                               class="layui-input" value="${(searchKeyword)!}">
                    </div>
                    <input type="submit" class="layui-btn layui-btn-normal" lay-submit value="搜索"/>
                </div>
            </form>
            <script>
                layui.use(['form', 'layer'], function () {
                    var form = layui.form
                            , layer = layui.layer;
                    form.verify({
                        keyword: function (value) {
                            if ("" == value) {
                                return "关键字不能为空";
                            }
                        }
                    });
                });
            </script>
        </ul>
    </div>
</div>
<div class="layui-header header" style="margin-top: 65px;background-color: #1E9FFF">
    <div class="main" style="background-color: #1E9FFF">
        <ul class="layui-nav layui-bg-blue" lay-filter="filter">
            <li class="layui-nav-item nav-left" pc>
                <a href="${base}/index">首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="${base}/articlelist">知识库</a>
            </li>
            <li class="layui-nav-item">
                <a href="${base}/information">信息咨讯</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" onclick="addFavorite(location.href, document.title)">加入收藏</a>
            </li>
            <li class="layui-nav-item">
                <a href="${base}/about">关于我们</a>
            </li>
            <li class="layui-nav-item nav-right layui-layout-right">
                <a href="javascript:;">
                    <@shiro.guest>
                        游客
                    </@shiro.guest>
                    <@shiro.user>
                        ${(user.realname)!}
                    </@shiro.user>
                </a>
                <dl class="layui-nav-child">
                    <@shiro.guest>
                        <dd><a href="${base}/login">登录</a></dd>
                        <dd><a href="${base}/register">注册</a></dd>
                    </@shiro.guest>
                    <@shiro.user>
                        <dd><a href="${base}/userinfo">个人中心</a></dd>
                        <dd><a href="${base}/logout">注销</a></dd>
                    </@shiro.user>
                </dl>
            </li>
        </ul>
    </div>
</div>
<script>
    function addFavorite(url, title) {
        url = encodeURI(url);
        try {
            window.external.addFavorite(url, title);
        } catch (e) {
            try {
                window.sidebar.addPanel(title, url, "");
            } catch (e) {
                alert("加入收藏失败,请使用Ctrl+D进行添加,或手动在浏览器里进行设置.");
            }
        }
    }
</script>
</#macro>

<#macro recommend>
<script>
    $(function () {
        var oLi = $("#tab li");
        var oUl = $("#ms-main div");
        var sortBy = ["pageview", "recentReply"];
        for (var i = 0; i < oLi.length; i++) {
            oLi[i].index = i;
            oLi[i].onclick = function () {
                for (var n = 0; n < oLi.length; n++)
                    oLi[n].className = "";
                this.className = "cur";
                var data = {
                    "sortKey": sortBy[this.index]
                };
                $.ajax({
                    url: '${base}/recommend',
                    type: 'post',
                    data: data,
                    dataType: 'json',
                    success: function (json) {
                        console.log(json);
                        var articleList = json.articleList;
                        var htmlStr = " ";
                        $("#recommend").empty();
                        for (var i = 0; i < articleList.length; i++) {
                            htmlStr += "<li><a href='${base}/article?article.articleid=" + articleList[i].articleid + "'>" + articleList[i].title + "</a></li>";
                        }
                        $("#recommend").html(htmlStr);
                    }
                });
            }
        }
    });
</script>
</#macro>

<#macro left>
<ul class="layui-nav layui-nav-tree layui-bg-blue layui-inline">
    <@shiro.user>
        <li class="layui-nav-item"><a href="${base}/userinfo">账号</a></li>
        <li class="layui-nav-item"><a href="${base}/article/articlelist">文章管理</a></li>
    </@shiro.user>
    <@shiro.hasRole name="user">
        <li class="layui-nav-item"><a href="${base}/enterprise/authentication">企业认证</a></li>
    </@shiro.hasRole>
    <@shiro.hasRole name="enterprise">
        <li class="layui-nav-item"><a href="${base}/enterprise/enterpriseinfo">企业资料</a></li>
    </@shiro.hasRole>
    <@shiro.hasAnyRoles name="enterprise,admin">
        <li class="layui-nav-item"><a href="${base}/needs/needslist">需求管理</a></li>
    </@shiro.hasAnyRoles>
    <@shiro.hasRole name="admin">
        <li class="layui-nav-item"><a href="${base}/user/userlist">用户管理</a></li>
        <li class="layui-nav-item"><a href="${base}/enterprise/authenticationlist">认证管理</a></li>
        <li class="layui-nav-item"><a href="${base}/enterprise/enterpriselist">企业管理</a></li>
        <li class="layui-nav-item"><a href="${base}/news/newslist">新闻管理</a></li>
        <li class="layui-nav-item"><a href="${base}/policy/policylist">政策管理</a></li>
        <li class="layui-nav-item"><a href="${base}/setting/images">图片轮播</a></li>
        <li class="layui-nav-item"><a href="${base}/setting/about">关于我们</a></li>
    </@shiro.hasRole>
    <@shiro.user>
        <li class="layui-nav-item"><a href="${base}/favorite/favoritelist">收藏夹</a></li>
        <li class="layui-nav-item"><a href="${base}/logout">注销</a></li>
    </@shiro.user>
</ul>
</#macro>

<#macro footer>
<div class="footer">
    <hr>
    <p>@layui框架模板</p>
    <br>
</div>
</#macro>