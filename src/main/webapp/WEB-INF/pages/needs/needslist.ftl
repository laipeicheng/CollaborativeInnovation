<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-需求管理</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>需求管理</legend>
            </fieldset>
            <@shiro.hasRole name="enterprise">
                <a href="${base}/needs/needsadd" class="layui-btn layui-btn-small layui-btn-normal">发布需求</a>
            </@shiro.hasRole>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="150">
                    <col width="100">
                    <col width="100">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>状态</th>
                    <th>发布者</th>
                    <th>发布时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list needsList! as needs>
                <tr>
                    <td><a href="${base}/needs?needs.id=${(needs.id)!}">${(needs.title)!}</a></td>
                    <td><#switch needs.status>
                            <#case 0>已结束<#break>
                            <#case 1>进行中<#break>
                    </#switch></td>
                    <td>${(needs.publisher.name)!}</td>
                    <td>${(needs.publishtime?string("yyyy-MM-dd HH:mm:SS"))!}</td>
                    <td>
                        <#if needs.status = 1>
                            <a href="${base}/needs/needsedit?needs.id=${(needs.id)!}"
                               class="layui-btn layui-btn-mini layui-btn-primary" disabled>编辑</a>
                            <a href="javascript:;" onclick="end(${(needs.id)!})"
                               class="layui-btn layui-btn-mini layui-btn-danger">结束需求</a>
                        </#if>
                        <@shiro.hasRole name="admin">
                            <a href="javascript:;" onclick="del(${(needs.id)!})"
                                class="layui-btn layui-btn-mini layui-btn-danger">删除</a>
                        </@shiro.hasRole>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="page"/>
            <script>
                layui.use(['layer', 'laypage'], function () {
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
                                location.href = "${base}/needs/needslist?curPage=" + obj.curr;
                            }
                        }
                    });

                });

                function end(newsid) {
                    layer.confirm('是否结束？', {
                        btn: ['是', '否'] //按钮
                    }, function () {
                        location.href = "${base}/needs/needsend?needs.id=" + newsid;
                    }, function () {

                    });
                }

                function end(newsid) {
                    layer.confirm('是否删除？', {
                        btn: ['是', '否'] //按钮
                    }, function () {
                        location.href = "${base}/needs/needsdel?needs.id=" + newsid;
                    }, function () {

                    });
                }

            </script>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>