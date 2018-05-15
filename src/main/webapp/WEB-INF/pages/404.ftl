<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>404</title>
    <@common.link_and_script />
</head>
<body>
<@common.header />

<div class="layui-container container" style="margin-top: 65px">
    <div class="fly-none">
        <h2><i class="iconfont icon-404"></i></h2>
        <p>您访问的页面找不到！</p>
    </div>
</div>
<@common.footer />
</body>
</html>