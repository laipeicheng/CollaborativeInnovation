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
                        <legend><a href="#">新闻资讯</a></legend>
                    </fieldset>
                    <div class="layui-form">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <td>新闻1</td>
                            </tr>
                            <tr>
                                <td>新闻2</td>
                            </tr>
                            <tr>
                                <td>新闻3</td>
                            </tr>
                            <tr>
                                <td>新闻4</td>
                            </tr>
                            <tr>
                                <td>新闻5</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="layui-row layui-col-space20">
                <div class="layui-col-md6">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend><a href="#">需求资讯</a></legend>
                    </fieldset>
                    <div class="layui-form">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <td>需求1</td>
                            </tr>
                            <tr>
                                <td>需求2</td>
                            </tr>
                            <tr>
                                <td>需求3</td>
                            </tr>
                            <tr>
                                <td>需求4</td>
                            </tr>
                            <tr>
                                <td>需求5</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="layui-col-md6">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend><a href="#">政策</a></legend>
                    </fieldset>
                    <div class="layui-form">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <td>政策1</td>
                            </tr>
                            <tr>
                                <td>政策2</td>
                            </tr>
                            <tr>
                                <td>政策3</td>
                            </tr>
                            <tr>
                                <td>政策4</td>
                            </tr>
                            <tr>
                                <td>政策5</td>
                            </tr>
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
