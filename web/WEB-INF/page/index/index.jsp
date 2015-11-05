<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <%@include file="common.jsp"%>

</head>
<body>

<!-- begin top menu -->
<%@include file="menuinfo.jsp"%>
<!-- end top menu -->


<!--<div class="aw-email-verify">
    <div class="container text-center">
        你的邮箱 13643864527@139.COM 还未验证, <a onclick="AWS.ajax_request(G_BASE_URL + &#39;/account/ajax/send_valid_mail/&#39;);">点击这里重新发送验证邮件</a>
    </div>
</div>-->
<div id="banner_tabs" class="flexslider">
    <ul class="slides">
        <c:forEach items="${bannerList}" var="banner">
            <li>
                <a title="" target="_blank" href="#">
                    <img width="1920" height="482" alt="" style="background: url(${banner.bannerUrl}) no-repeat center;" src="${contextPath}/static/common/alpha.png">
                </a>
            </li>
        </c:forEach>

    </ul>
    <ul class="flex-direction-nav">
        <li><a class="flex-prev" href="javascript:;">Previous</a></li>
        <li><a class="flex-next" href="javascript:;">Next</a></li>
    </ul>
    <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
        <c:forEach items="${bannerList}" var="banner">
        <li><a>1</a></li>
        </c:forEach>
    </ol>
</div>
<script type="text/javascript">
    $(function() {
        var bannerSlider = new Slider($('#banner_tabs'), {
            time: 5000,
            delay: 400,
            event: 'hover',
            auto: true,
            mode: 'fade',
            controller: $('#bannerCtrl'),
            activeControllerCls: 'active'
        });
        $('#banner_tabs .flex-prev').click(function() {
            bannerSlider.prev()
        });
        $('#banner_tabs .flex-next').click(function() {
            bannerSlider.next()
        });
    })
</script>

<!-- banner -->
<div class="banner">
    <div class="container text-center">
        <div class="row">
            <div class="col-sm-12">
                <img src="${contextPath}/static/common/banner.png" src-retina="https://www.wegene.com/static/css/wegene/img/banner@2x.png" width="880">
                <h1>解读基因的秘密, 遇见未来的自己</h1>
                <h2><span class="color-blue">WeGene</span> 致力于消费级基因数据的解读与个性化健康服务。</h2>
            </div>
        </div>
    </div>
</div>
<!-- end banner -->

<!-- 祖源与疾病套组 -->
<div class="plan-parentage">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 hidden-xs">
                <img src-retina="https://www.wegene.com/static/css/wegene/img/banner-parentage@2x.png" src="${contextPath}/static/common/banner-parentage.png" width="720">
            </div>
            <div class="col-sm-4">
                <h2>WeGene 标准套组</h2>
                <h3><b>运动基因独立套件</b> + 祖源分析 + 健康风险 +<br>天赋特征 + 遗传性疾病 + 药物反应</h3>
                <p class="clearfix">
                    <!-- <b class="price">￥1,699</b> -->
                </p>
                <a class="btn btn-disabled btn-large"><i class="icon icon-cart"></i> 即将发售...</a>
            </div>
        </div>
    </div>
</div>
<!-- end 祖源与疾病套组 -->

<!-- 全基因组 -->
<div class="plan-genome">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <h2>全基因组</h2>
                <h3><b>运动基因独立套件</b> + 祖源分析 + 健康风险 +<br>天赋特征 + 遗传性疾病 + 药物反应</h3>
                <p class="clearfix">
                    <b class="price">￥9,999</b>
                </p>
                <a href="https://www.wegene.com/shop/item/4" class="btn btn-large"><i class="icon icon-cart"></i> 购买全基因组</a>
            </div>
            <div class="col-sm-8 hidden-xs">
                <img src="${contextPath}/static/common/banner-genome.png" src-retina="https://www.wegene.com/static/css/wegene/img/banner-genome@2x.png" width="750">
            </div>
        </div>
    </div>
</div>
<!-- end 全基因组 -->

<!-- 运动基因 -->
<div class="plan-sports">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 hidden-xs">
                <img src="${contextPath}/static/common/banner-sports-result.png" width="557">
            </div>
            <div class="col-sm-6">
                <h2>运动基因独立套件</h2>
                <h3>个性化的运动建议，结合推送与实时测量</h3>
                <p><span class="hidden-xs">运动基因开放平台，为智能手环、手表提供各种个性化<br>运动数据，针对性的运动指导与分析。</span><!-- <a href="">开放平台详情</a> --></p>
                <p class="clearfix price">
                    <b class="price">￥499</b>
                </p>
                <a href="https://www.wegene.com/shop/item/6" class="btn btn-primary btn-large"><i class="icon icon-cart"></i> 运动基因独立套件</a>
            </div>
        </div>
    </div>
</div>
<!-- end 运动基因 -->



<div class="index-product">
    <div class="container">
        <div class="col-sm-8 content hidden-xs">
            <p>立即购买</p>
            <div class="row">
                <div class="col-sm-5">
                    <img src="${contextPath}/static/common/product.png" width="300">
                </div>
                <div class="col-sm-7">
                    <ul>
                        <li>
                            <i class="icon icon-gene"></i>
                            <h4>WeGene 标准套组</h4>
                            <!-- <b class="price">￥1,699</b> -->
                        </li>
                        <li>
                            <i class="icon icon-hear"></i>
                            <h4>全基因组</h4>
                            <b class="price">￥9,999</b>
                        </li>
                        <li>
                            <i class="icon icon-run"></i>
                            <h4>运动基因独立套件</h4>
                            <b class="price">￥499</b>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-3 sidebar">
            <p>已有数据</p>
            <a href="https://www.wegene.com/start/" class="btn btn-large btn-primary"><i class="icon icon-bind"></i> 绑定 WeGene 检测套件</a>
            <a href="https://www.wegene.com/account/openid/_23andme/" class="btn btn-large btn-23andme"><i class="icon icon-23"></i> 导入 23andMe 数据</a>
        </div>
    </div>
</div>

<script>
    $(function ()
    {
        if (window.devicePixelRatio > 1)
        {
            $.each($('img'), function (i, e)
            {
                if ($(this).attr('src-retina') != '')
                {
                    $(this).attr('src', $(this).attr('src-retina'));
                }
            });
        }
    });
</script>

<%@include file="footinfo.jsp"%>
<!-- Escape time: 0.035480976104736 --><!-- / DO NOT REMOVE -->
</body></html>