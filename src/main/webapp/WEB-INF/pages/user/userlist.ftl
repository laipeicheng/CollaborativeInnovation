<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-用户管理</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>用户管理</legend>
            </fieldset>
            <form class="layui-form" method="get" action="${base}/user/userlist">
                <div class="layui-input-inline" style="margin-left: 360px">
                    <select name="roleid">
                        <option value="">全部</option>
                        <option value="1" <#if 1==roleid!3>selected</#if>>企业用户</option>
                        <option value="2" <#if 2==roleid!3>selected</#if>>个人用户</option>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="keyword" value="${(keyword)!}" placeholder="关键字"/>
                </div>
                <input type="submit" class="layui-btn layui-btn-small layui-btn-normal" lay-submit value="搜索" />
            </form>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>真实姓名</th>
                    <th>手机号码</th>
                    <th>用户类型</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list userList as user>
                <tr>
                    <td>${(user.username)!}</td>
                    <td>${(user.realname)!}</td>
                    <td>${(user.phone)!}</td>
                    <td><#switch user.role.roleid!>
                        <#case 0>管理员<#break>
                        <#case 2>普通用户<#break>
                        <#case 1>企业用户<#break>
                    </#switch></td>
                    <td><a href="${base}/userinfo?user.username=${(user.username)!}"
                           class="layui-btn layui-btn-mini layui-btn-primary">编辑</a><a
                            href="javascript:;" onclick="del('${(user.username)!}');"
                            class="layui-btn layui-btn-mini layui-btn-danger">删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="page"/>
            <script>
                layui.use(['form', 'layer', 'laypage'], function () {
                    var layer = layui.layer
                            , laypage = layui.laypage;

                    //只显示上一页、下一页
                    laypage.render({
                        elem: 'page'
                        , count: ${(pages*10)!}
                        , theme: '#1E9FFF'
                        , curr:${curPage!1}
                        //['count', 'prev', 'page', 'next', 'limit', 'skip']
                        , layout: ['prev', 'page', 'next']
                        , jump: function (obj, first) {
                            if (!first) {
                                location.href = "${base}/user/userlist?roleid=${(roleid)!}&keyword=${(keyword)!}&curPage=" + obj.curr;
                            }
                        }
                    });
                });

                function del(username) {
                    layer.confirm('是否删除？', {
                        btn: ['是', '否'] //按钮
                    }, function () {
                        location.href="${base}/user/deluser?roleid=${(roleid)!}&keyword=${(keyword)!}&curPage=${(currPage)!}&user.username="+username;
                    }, function () {

                    });
                };
            </script>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>