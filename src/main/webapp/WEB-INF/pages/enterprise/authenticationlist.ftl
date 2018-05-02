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
                <legend>申请认证的企业</legend>
            </fieldset>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col width="300">
                </colgroup>
                <thead>
                <tr>
                    <th>企业名称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><a href="${base}/enterprise/enterpriseinfo">企业1</a></td>
                    <td><a href="#" class="layui-btn layui-btn-mini layui-btn-normal">认证通过</a><a href="#" class="layui-btn layui-btn-mini layui-btn-danger">认证不通过</a></td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>
<@common.footer />
</body>
</html>