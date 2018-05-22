<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-政策管理</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="padding-top:70px; margin-top: 55px">

    <div class="main fly-user-main layui-clear">
    <@common.left />

        <div class="fly-panel fly-panel-user">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>政策管理</legend>
            </fieldset>

            <a href="${base}/policy/policyadd" class="layui-btn layui-btn-small layui-btn-normal">发布政策</a>
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="300">
                    <col width="240">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>发布时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list policyList! as policy>
                    <tr>
                        <td><a href="${base}/policy?policy.id=${(policy.id)!}">${(policy.title)!}</a></td>

                        <td>${(policy.publishtime?string("yyyy-MM-dd HH:mm:SS"))!}</td>
                        <td><a href="${base}/policy/policyedit?policy.id=${(policy.id)!}" class="layui-btn layui-btn-mini layui-btn-primary">编辑</a>
                            <a href="javascript:;" onclick="del(${(policy.id)!})"
                                class="layui-btn layui-btn-mini layui-btn-danger">删除</a>
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
                                location.href = "${base}/policy/policylist?curPage=" + obj.curr;
                            }
                        }
                    });

                });
                function del(policyid) {
                    layer.confirm('是否删除？', {
                        btn: ['是', '否'] //按钮
                    }, function () {
                        location.href="${base}/policy/policydel?policy.id="+policyid;
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