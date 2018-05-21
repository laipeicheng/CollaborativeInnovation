<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-企业管理</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>企业管理</legend>
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
                <#list enterpriseList as enterprise>
                <tr>
                    <td><a href="${base}/enterprise/enterpriseinfo?enterprise.id=${(enterprise.id)!}">${(enterprise.name)!}</a></td>
                    <td><a href="${base}/auth/authenticate?enterprise.status=2&enterprise.id=${(enterprise.id)!}" class="layui-btn layui-btn-mini layui-btn-danger">重新认证</a></td>
                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</div>
<@common.footer />
</body>
</html>