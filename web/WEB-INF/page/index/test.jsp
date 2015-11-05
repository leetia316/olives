<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html class="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="renderer" content="webkit">
    <title>WeGene个人遗传基因检测解读平台</title>
    <meta name="keywords" content="基因，基因检测，基因解读，基因测序，遗传基因，基因体检，基因与健康, 23andme">
    <meta name="description" content="WeGene是一个提供基因检测，遗传基因分析，基因解读的平台，分析包括祖源信息，遗传疾病，健康预测，运动天赋，营养吸收，药物吸收等内容。">
    <!--<base href="https://www.wegene.com/">--><base href="."><!--[if IE]></base><![endif]-->
    <link href="https://www.wegene.com/static/css/wegene/img/favicon.ico?v=20141212" rel="shortcut icon" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/common/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/common/icon.css">
    <link href="${contextPath}/static/common/common.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/static/common/link.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/static/common/style.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/static/common/wegene.css" rel="stylesheet" type="text/css">
    <script src="${contextPath}/static/common/hm.js"></script>
    <script src="${contextPath}/static/common/zh_CN.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/jquery.2.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/slider.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/jquery.form.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/plug-in_module.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/aws.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/aw_template.js" type="text/javascript"></script>
    <script src="${contextPath}/static/common/app.js" type="text/javascript"></script>
    <script type="text/javascript" src="${contextPath}/static/common/compatibility.js"></script>
    <!--[if lte IE 8]>
    <script type="text/javascript" src="https://www.wegene.com/static/js/respond.js"></script>
    <![endif]-->
    <style type="text/css">.fancybox-margin{margin-right:17px;}</style>
    <style>
        .flexslider {
            margin: 0px auto 20px;
            position: relative;
            width: 100%;
            height: 482px;
            overflow: hidden;
            zoom: 1;
        }

        .flexslider .slides li {
            width: 100%;
            height: 100%;
        }

        .flex-direction-nav a {
            width: 70px;
            height: 70px;
            line-height: 99em;
            overflow: hidden;
            margin: -35px 0 0;
            display: block;
            background: url(${contextPath}/static/common/ad_ctr.png) no-repeat;
            position: absolute;
            top: 50%;
            z-index: 10;
            cursor: pointer;
            opacity: 0;
            filter: alpha(opacity=0);
            -webkit-transition: all .3s ease;
            border-radius: 35px;
        }

        .flex-direction-nav .flex-next {
            background-position: 0 -70px;
            right: 0;
        }

        .flex-direction-nav .flex-prev {
            left: 0;
        }

        .flexslider:hover .flex-next {
            opacity: 0.8;
            filter: alpha(opacity=25);
        }

        .flexslider:hover .flex-prev {
            opacity: 0.8;
            filter: alpha(opacity=25);
        }

        .flexslider:hover .flex-next:hover,
        .flexslider:hover .flex-prev:hover {
            opacity: 1;
            filter: alpha(opacity=50);
        }

        .flex-control-nav {
            width: 100%;
            position: absolute;
            bottom: 10px;
            text-align: center;
        }

        .flex-control-nav li {
            margin: 0 2px;
            display: inline-block;
            zoom: 1;
            *display: inline;
        }

        .flex-control-paging li a {
            background: url(${contextPath}/static/common/dot.png) no-repeat 0 -16px;
            display: block;
            height: 16px;
            overflow: hidden;
            text-indent: -99em;
            width: 16px;
            cursor: pointer;
        }

        .flex-control-paging li a.flex-active,
        .flex-control-paging li.active a {
            background-position: 0 0;
        }

        .flexslider .slides a img {
            width: 100%;
            height: 482px;
            display: block;
        }
    </style>
</head>
<body>

<!--top menu -->
<div class="top-menu">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <a href="https://www.wegene.com/home/" class="logo pull-left">
                    <img src="${contextPath}/static/common/logo.png" width="162">
                </a>

                <!-- 用户栏 -->
                <div class="aw-user-nav  hidden-xs">
                    <!-- 登陆&注册栏 -->
                    <a href="https://www.wegene.com/home/" class="aw-user-nav-dropdown">
                        <img alt="zhou05" src="${contextPath}/static/common/avatar-mid-img.png">
                        <span class="aw-hide-txt">zhou05</span>
                        <!-- <span class="badge badge-important notifications_unread" style="display:none">0</span> -->
                        <span class="badge badge-important">1</span>
                    </a>
                    <div class="aw-dropdown dropdown-list pull-right">
                        <ul class="aw-dropdown-list">
                            <li><a href="https://www.wegene.com/notifications/">消息通知 <span class="badge badge-important notifications_unread" style="display:none">0</span></a></li>
                            <li><a href="https://www.wegene.com/report/">我的报告</a></li>
                            <li><a href="https://www.wegene.com/favorite/">我的收藏</a></li>
                            <li><a href="https://www.wegene.com/inbox/">我的私信<span class="badge badge-important hide" id="inbox_unread" style="display: inline;">1</span></a></li>
                            <li class="hidden-xs"><a href="https://www.wegene.com/account/setting/profile/">账号设置</a></li>
                            <li>
                                <a>切换报告</a>
                                <ol>
                                    <li>
                                        <a href="https://www.wegene.com/start/" class="color-blue">绑定检测套件</a>
                                    </li>
                                    <li>
                                        <a href="https://www.wegene.com/account/openid/_23andme/" class="color-blue">导入 23andMe 数据</a>
                                    </li>
                                </ol>
                            </li>
                            <li><a href="https://www.wegene.com/account/logout/">退出账户</a></li>
                        </ul>
                    </div>
                    <!-- end 登陆&注册栏 -->
                </div>
                <!-- end 用户栏 -->

                <!-- 搜索框 -->
                <div class="aw-search-box  hidden-xs hidden-sm">
                    <form class="navbar-search" action="https://www.wegene.com/search/gene/" id="global_search_form" method="post">
                        <div class="search-dropdown">
                            <span>报告 <i class="icon icon-down"></i></span>
                            <ul>
                                <li class="hide"><a data-placeholder="搜索报告关键字" data-search="gene">报告</a></li>
                                <li><a data-placeholder="搜索小组或讨论" data-search="">社区</a></li>
                            </ul>
                        </div>
                        <input class="form-control search-query" type="text" placeholder="搜索报告关键字" autocomplete="off" name="q" id="aw-search-query">
                        <span title="搜索" id="global_search_btns" onclick=""><i class="icon icon-search"></i></span>
                    </form>
                </div>
                <!-- end 搜索框 -->

                <div class="aw-top-nav navbar">
                    <div class="navbar-header">
                        <button class="navbar-toggle pull-left">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <nav role="navigation" class="collapse navbar-collapse bs-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="https://www.wegene.com/home/">我的基因</a></li>
                            <li><a class="visible-xs" href="https://www.wegene.com/progress/">绑定进程</a></li>
                            <li><a class="visible-xs" href="https://www.wegene.com/start/">绑定检测套件</a></li>
                            <li><a href="https://www.wegene.com/explore/">社区</a></li>
                            <li>
                                <span>购买</span>
                                <div class="aw-dropdown dropdown-list pull-right">
                                    <ul class="aw-dropdown-list">
                                        <li>
                                            <a href="https://www.wegene.com/shop/item/3">WeGene 标准套组</a>
                                        </li>
                                        <li>
                                            <a href="https://www.wegene.com/shop/item/6">运动基因独立套件</a>
                                        </li>
                                        <li>
                                            <a href="https://www.wegene.com/shop/item/4">全基因组</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li>
                                <a href="https://www.wegene.com/notifications/">通知<span class="badge badge-important notifications_unread" style="display: none;">0</span></a>
                            </li>
                            <li class="visible-xs"><a href="https://www.wegene.com/inbox/">私信<span class="badge badge-important hide" id="inbox_unread">0</span></a></li>
                            <li><a href="https://www.wegene.com/help/">帮助</a></li>
                            <li class="visible-xs"><a href="https://www.wegene.com/account/logout/">退出账户</a></li>
                        </ul>
                    </nav>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- end top menu -->


<!--<div class="aw-email-verify">
    <div class="container text-center">
        你的邮箱 13643864527@139.COM 还未验证, <a onclick="AWS.ajax_request(G_BASE_URL + &#39;/account/ajax/send_valid_mail/&#39;);">点击这里重新发送验证邮件</a>
    </div>
</div>-->
<div id="banner_tabs" class="flexslider">
    <ul class="slides">
        <li>
            <a title="" target="_blank" href="#">
                <img width="1920" height="482" alt="" style="background: url(${contextPath}/static/common/banner1.jpg) no-repeat center;" src="images/alpha.png">
            </a>
        </li>
        <li>
            <a title="" href="#">
                <img width="1920" height="482" alt="" style="background: url(${contextPath}/static/common/banner2.jpg) no-repeat center;" src="images/alpha.png">
            </a>
        </li>
        <li>
            <a title="" href="#">
                <img width="1920" height="482" alt="" style="background: url(${contextPath}/static/common/banner3.jpg) no-repeat center;" src="images/alpha.png">
            </a>
        </li>
    </ul>
    <ul class="flex-direction-nav">
        <li><a class="flex-prev" href="javascript:;">Previous</a></li>
        <li><a class="flex-next" href="javascript:;">Next</a></li>
    </ul>
    <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
        <li><a>1</a></li>
        <li><a>2</a></li>
        <li><a>2</a></li>
    </ol>
</div>

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
            <p>已有数据?</p>
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

<div class="footer">
    <div class="container text-center">
        <div class="row">
            <div class="col-sm-6 text-left text-color-999 copyright">
                <a href="https://www.wegene.com/page/about">关于我们</a> •
                <a href="https://www.wegene.com/page/about#联系我们">联系我们</a> •
                <a href="https://www.wegene.com/page/about#隐私保护">隐私保护</a> •
                <a href="https://www.wegene.com/career/" target="_blank">加入我们</a> •
                <a href="http://api.wegene.com/">开放平台</a>
                <br>
                Powered by WeGene © 2015 WeGene. All Rights Reserved
            </div>
            <div class="col-sm-6 text-right service">
                <i class="icon icon-service"></i> <span>客服 <b>4008-322-332</b></span>
            </div>
        </div>
    </div>
</div>



<a class="aw-back-top hidden-xs" href="javascript:;" onclick="$.scrollTo(1, 600, {queue:true});"><i class="icon icon-up"></i></a>

<script>
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
<!-- DO NOT REMOVE -->
<div id="aw-ajax-box" class="aw-ajax-box"></div>
<div style="display:none;" id="__crond"><img src="${contextPath}/static/common/1443169451" width="1" height="1"></div>

<div class="aw-mask hide">
    <div class="bg"></div>
    <div class="img"></div>
    <i class="icon icon-delete"></i>
</div>

<!-- Escape time: 0.035480976104736 --><!-- / DO NOT REMOVE -->
</body></html>