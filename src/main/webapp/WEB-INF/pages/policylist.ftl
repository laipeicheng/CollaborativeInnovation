<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-信息咨讯</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<div class="layui-container container" style="margin-top: 65px">
    <div class="layui-row">
        <div class="layui-col-md12">
            <span class="">
                <a href="${base}/index">首页</a>
                &nbsp;>&nbsp;
                <a href="${base}/information">信息咨讯</a>
                &nbsp;>&nbsp;
                <a><cite>政策资讯</cite></a>
            </span>
            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div class="article-main">
                                <#list policyList! as policy>
                                    <div class="article-list">
                                        <ul>
                                            <h3>
                                                <a href="${base}/policy?policy.id=${policy.id}">${(policy.title)!}</a>
                                            </h3>
                                            <p class="autor">
                                                <span class="dtime f_l">${(policy.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
                                            </p>
                                        </ul>
                                    </div>
                                </#list>
                            <div id="page"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
<script>
    layui.use(['laypage'], function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page',
            count: ${(pages*10)!},
            theme: '#1E9FFF',
            curr: ${curPage!1},
            layout: ['prev', 'page', 'next'],
            jump: function (obj, first) {
                if (!first) {
                    location.href = "${base}/policylist?curPage=" + obj.curr;
                }
            }
        });
    });
</script>
</body>
</html>
