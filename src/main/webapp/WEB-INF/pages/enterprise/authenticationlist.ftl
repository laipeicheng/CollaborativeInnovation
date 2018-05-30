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
                <#list enterpriseList as enterprise>
                <tr>
                    <td><a href="${base}/enterprise/enterpriseinfo?enterprise.id=${(enterprise.id)!}">${(enterprise.name)!}</a></td>
                    <td><a href="${base}/auth/authenticate?enterprise.status=1&enterprise.id=${(enterprise.id)!}" class="layui-btn layui-btn-mini layui-btn-normal">认证通过</a><a href="${base}/auth/authenticate?enterprise.status=2&enterprise.id=${(enterprise.id)!}" class="layui-btn layui-btn-mini layui-btn-danger">认证不通过</a></td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="page"/>
            <script>
                layui.use(['laypage'], function () {
                    var laypage = layui.laypage;

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
                                location.href = "${base}/enterprise/authenticationlist?curPage=" + obj.curr;
                            }
                        }
                    });
                });
            </script>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>