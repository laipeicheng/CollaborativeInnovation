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
                <a><cite>信息咨讯</cite></a>
            </span>
            <hr class="layui-bg-gray">
            <div class="layui-row layui-col-space20">
                <div class="layui-col-md8">
                    <div class="layui-carousel" id="test1" lay-filter="test1">
                        <div carousel-item="">
                            <div style="background-color: red">条目1</div>
                            <div style="background-color: black">条目2</div>
                            <div style="background-color: blue">条目3</div>
                            <div style="background-color: green">条目4</div>
                            <div style="background-color: white">条目5</div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md4">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend><a href="${base}/newslist">新闻资讯</a></legend>
                    </fieldset>
                    <div class="layui-form">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                            </colgroup>
                            <tbody>
                            <#list newsList! as news>
                            <tr>
                                <td><a href="${base}/news?news.id=${(news.id)!}">${(news.title)!}</a></td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="layui-row layui-col-space20">
                <div class="layui-col-md6">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend><a href="${base}/needslist">需求资讯</a></legend>
                    </fieldset>
                    <div class="layui-form">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                            </colgroup>
                            <tbody>
                            <#list needsList! as needs>
                            <tr>
                                <td><a href="${base}/needs?needs.id=${(needs.id)!}">${(needs.title)!} (
                                <#switch (needs.status)>
                                    <#case 0>已结束<#break>
                                    <#case 1>进行中...<#break>
                                </#switch>)</a></td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="layui-col-md6">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend><a href="${base}/policylist">政策资讯</a></legend>
                    </fieldset>
                    <div class="layui-form">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                            </colgroup>
                            <tbody>
                            <#list policyList! as policy>
                            <tr>
                                <td><a href="${base}/policy?policy.id=${(policy.id)!}">${(policy.title)!}</a></td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
                ,form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1'
            ,arrow: 'always'
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                        ,key = othis.data('key')
                        ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };
    });
</script>
</body>
</html>
