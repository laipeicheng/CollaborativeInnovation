<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-信息咨讯 需求资讯 ${(news.title)!}</title>
<@common.link_and_script />
</head>
<body>
<@common.header />
<@common.recommend />
<div class="layui-container container" style="margin-top: 65px">
    <div class="layui-row layui-col-space20">
        <div class="layui-col-md12">
            <div>
            <span class="">
                <a href="${base}/index">首页</a>
                &nbsp;>&nbsp;
                <a href="${base}/information">信息咨讯</a>
                &nbsp;>&nbsp;
                <a href="${base}/newslist">新闻资讯</a>
                &nbsp;>&nbsp;
                <a><cite>${(news.title)!}</cite></a>
    	    </span>
                <hr class="layui-bg-gray">
                <div class="content" id="photos">
                    <h2 class="c_titile">${(news.title)!}</h2>
                    <p class="box_c">
                        <span class="d_time">发表时间：${(news.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
                    </p>
                    <div class="detail-body">
                    ${(news.content)!}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>
