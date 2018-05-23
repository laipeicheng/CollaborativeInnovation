<#import "/WEB-INF/ftl/common.ftl" as common />
<#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] >
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>协同创新-信息咨讯 需求资讯 ${(needs.title)!}</title>
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
                <a href="${base}/needslist">需求资讯</a>
                &nbsp;>&nbsp;
                <a><cite>${(needs.title)!}</cite></a>
    	    </span>
                <hr class="layui-bg-gray">
                <div class="content" id="photos">
                    <h2 class="c_titile">${(needs.title)!}</h2>
                    <p class="box_c">
                        <span class="d_time">发表时间：${(needs.publishtime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
                    </p>
                    <div class="detail-body">
                        <p>联系人：${(needs.publisher.name)!}</p>
                        <p>联系地址：${(needs.publisher.address)!}</p>
                        <p>联系方式：${(needs.publisher.corporation.phone)!}</p>
                        <p>需求详情：${(needs.content)!}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@common.footer />
</body>
</html>
