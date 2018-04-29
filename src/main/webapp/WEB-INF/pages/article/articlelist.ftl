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
            <fieldset class="layui-elem-field layui-field-title">
                <legend>文章管理</legend>
            </fieldset>

            <button class="layui-btn layui-btn-small layui-btn-normal">发表文章</button>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>作者</th>
                    <th>文章分类</th>
                    <th>发表时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>标题一</td>
                    <td>用户01</td>
                    <td>分类一</td>
                    <td>2018-4-30 04:43:00</td>
                    <td><a href="#" class="layui-btn layui-btn-mini layui-btn-primary">编辑</a><a href="#" class="layui-btn layui-btn-mini layui-btn-danger">删除</a></td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>
<@common.footer />
</body>
</html>