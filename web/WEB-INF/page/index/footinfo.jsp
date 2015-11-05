<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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



<a class="aw-back-top hidden-xs" href="javascript:;" onclick="$.scrollTo(1, 600, {queue:true});">
  <i class="icon icon-up"></i>
</a>

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
