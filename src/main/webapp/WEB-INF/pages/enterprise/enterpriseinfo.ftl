<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-企业信息</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <div class="layui-tab layui-tab-brief" lay-filter="user">
                <ul class="layui-tab-title" id="LAY_mine">
                    <li class="layui-this" lay-id="info">企业资料</li>
                </ul>
                <div class="layui-tab-content" style="padding: 20px 0;">
                    <div class="layui-form layui-form-pane layui-tab-item layui-show">

                        <div class="layui-form-item">
                            <label for="name" class="layui-form-label">企业名称</label>
                            <div class="layui-input-inline">
                                <input type="text" id="name" value="${(enterprise.name)!}" disabled lay-verify="name" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="summary" class="layui-form-label">简介</label>
                            <div class="layui-input-block">
                                        <textarea id="summary" disabled lay-verify="summary" autocomplete="off"
                                                  class="layui-textarea">${(enterprise.summary)!}</textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="address" class="layui-form-label">地址</label>
                            <div class="layui-input-inline">
                                <input type="text" id="address" disabled value="${(enterprise.address)!}" lay-verify="address" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="dmeo1" class="layui-form-label">营业执照</label>
                            <div class="layui-input-block">
                                <img src="${base}/stream/license?enterpriseid=${(enterprise.id)!}" style="height: 425px;width: 800px;border: 1px solid darkgrey" id="demo1"/>
                            </div>
                        </div>
                            <@shiro.hasRole name="admin">
                                <div class="layui-form-item">
                                    <#switch enterprise.status>
                                        <#case 0>
                                            <a href="${base}/auth/authenticate?enterprise.status=1&enterprise.id=${(enterprise.id)!}" class="layui-btn layui-btn-normal">认证通过</a>
                                            <a href="${base}/auth/authenticate?enterprise.status=2&enterprise.id=${(enterprise.id)!}" class="layui-btn layui-btn-danger">认证不通过</a>
                                        <#break >
                                        <#case 1>
                                            <a href="${base}/auth/reauthenticate?enterprise.status=2&enterprise.id=${(enterprise.id)!}" class="layui-btn layui-btn-danger">重新认证</a>
                                        <#break>
                                    </#switch>
                                </div>
                            </@shiro.hasRole>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>