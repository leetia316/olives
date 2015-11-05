<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
  <%@include file="common.jsp"%>

</head>
<body style="background:#f5f5f5;">


<div class="aw-register-box">
  <div class="mod-head">
    <a href=""><img width="97" src="${contextPath}/static/common/login_logo.png" alt=""></a>
    <h1 class="hidden-xs">注册新用户</h1>
  </div>

  <div class="mod-body">
    <form class="aw-register-form" action="" method="post" id="register_form">

      <ul>
        <li class="alert alert-danger hide error_message text-left">
          <i class="icon icon-delete"></i> <em></em>
        </li>
        <li>
          <input class="aw-register-name form-control" type="text" name="user_name" placeholder="用户名" tips="请输入用户名" errortips="用户名长度不符合" value="">
            <div id="errorName" class="errRom"> <span class="aw-reg-tips aw-reg-err"><i class="i-err">用户名已存在</i></span></div>
            <span class="aw-reg-tips aw-reg-right"><i class="aw-icon i-err"></i></span>
        </li>
        <li>
          <input class="aw-register-email form-control" type="text" placeholder="邮箱" name="email" tips="请输入电子邮件" value="" errortips="邮箱格式不正确">
          <span class="aw-reg-tips aw-reg-right"><i  class="aw-icon i-followed"></i></span></li>
        <li>
          <input class="aw-register-pwd form-control" type="password" name="password" placeholder="密码" tips="请输入密码" errortips="密码不符合规则">
          <span class="aw-reg-tips aw-reg-right"><i class="aw-icon i-followed"></i></span></li>

        <li>
          <input class="aw-register-mobile form-control" type="text" placeholder="手机号" name="mobile" id="mobile_number" tips="请输入手机号" value="" errortips="手机号格式不正确">

        </li>

        <li class="aw-register-verify clearfix">
          <input type="text" class="form-control pull-left" name="seccode_verify" placeholder="验证码" id="seccode_verify">

          <img id="captcha" onclick="" src="${contextPath}/static/common/8687.png">
        </li>



        <li class="last">
          <label><input type="checkbox" checked="checked" value="agree" name="agreement_chk"> 我同意</label> <a href="javascript:;" class="aw-agreement-btn">用户协议</a>
          <a href="https://www.wegene.com/account/login/" class="pull-right">已有账号?</a>
          <div class="aw-register-agreement hide">
            <div class="aw-register-agreement-txt" id="register_agreement">当您申请用户时，表示您已经同意遵守本规章。<br>
              欢迎您加入本站点参与交流和讨论，本站点为社区，为维护网上公共秩序和社会稳定，请您自觉遵守以下条款：<br>
              <br>
              一、不得利用本站危害国家安全、泄露国家秘密，不得侵犯国家社会集体的和公民的合法权益，不得利用本站制作、复制和传播下列信息：<br>
              　（一）煽动抗拒、破坏宪法和法律、行政法规实施的；<br>
              　（二）煽动颠覆国家政权，推翻社会主义制度的；<br>
              　（三）煽动分裂国家、破坏国家统一的；<br>
              　（四）煽动民族仇恨、民族歧视，破坏民族团结的；<br>
              　（五）捏造或者歪曲事实，散布谣言，扰乱社会秩序的；<br>
              　（六）宣扬封建迷信、淫秽、色情、赌博、暴力、凶杀、恐怖、教唆犯罪的；<br>
              　（七）公然侮辱他人或者捏造事实诽谤他人的，或者进行其他恶意攻击的；<br>
              　（八）损害国家机关信誉的；<br>
              　（九）其他违反宪法和法律行政法规的；<br>
              　（十）进行商业广告行为的。<br>
              <br>
              二、互相尊重，对自己的言论和行为负责。<br>
              三、禁止在申请用户时使用相关本站的词汇，或是带有侮辱、毁谤、造谣类的或是有其含义的各种语言进行注册用户，否则我们会将其删除。<br>
              四、禁止以任何方式对本站进行各种破坏行为。<br>
              五、如果您有违反国家相关法律法规的行为，本站概不负责，您的登录信息均被记录无疑，必要时，我们会向相关的国家管理部门提供此类信息。</div>
          </div>

        </li>
        <li class="clearfix">
          <button class="btn btn-normal btn-success btn-block" onclick="verify_register_form($('#register_form')); return false;">注册</button>
        </li>
      </ul>
    </form>
  </div>
  <div class="mod-footer"></div>
</div>

<script type="text/javascript">
  jQuery(".aw-agreement-btn").click(function(){
    if ($('.aw-register-agreement').is(':visible'))
    {
      $('.aw-register-agreement').hide();
    }
    else
    {
      $('.aw-register-agreement').show();
    }
  });

  function test(){
      alert();
      var _this = $("#user_name");
      jQuery("#user_name").css("display","block");
  }

  verify_register_form('#register_form');
  /* 注册页面验证 */
  function verify_register_form(element)
  {
    $(element).find('[type=text], [type=password]').on({
      focus : function()
      {
        if (typeof $(this).attr('tips') != 'undefined' && $(this).attr('tips') != '')
        {
          $(this).parent().append('<span class="aw-reg-tips">' + $(this).attr('tips') + '</span>');
        }
      },
      blur : function()
      {
        if ($(this).attr('tips') != '')
        {
          switch ($(this).attr('name'))
          {
            case 'user_name' :
              var _this = $(this);
              $(this).parent().find('.aw-reg-tips').detach();
              if ($(this).val().length >= 0 && $(this).val().length <=6)
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>' + $(this).attr('errortips') + '</span>');
                return;
              }
              if ($(this).val().length > 17)
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>' + $(this).attr('errortips') + '</span>');
                return;
              }
              else
              {
                  $.ajax({
                  type: 'get',
                  datatype : "json",
                  data : {
                    userName: $(this).val()
                  },
                  url: "${contextPath}/page/exist" ,
                  success: function(data){

                    if (data == "true")
                    {
                      test();
                    }
                    else
                    {
                        test();
                    }
                  } ,
                  error:function(data){
                  }
                });

              }
              return;

            case 'email' :
              $(this).parent().find('.aw-reg-tips').detach();
              var emailreg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
              if (!emailreg.test($(this).val()))
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>' + $(this).attr('errortips') + '</span>');
                return;
              }
              else
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-right"><i class="aw-icon i-followed"></i></span>');
              }
              return;

            case 'password' :
              $(this).parent().find('.aw-reg-tips').detach();
              if ($(this).val().length >= 0 && $(this).val().length < 6)
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>' + $(this).attr('errortips') + '</span>');
                return;
              }
              if ($(this).val().length > 17)
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>' + $(this).attr('errortips') + '</span>');
                return;
              }
              else
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-right"><i class="aw-icon i-followed"></i></span>');
              }
              return;

            case 'mobile' :
              $(this).parent().find('.aw-reg-tips').detach();
              var mobilereg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
              if (!mobilereg.test($(this).val()))
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>' + $(this).attr('errortips') + '</span>');
                return;
              }
              else
              {
                $(this).parent().find('.aw-reg-tips').detach();
                $(this).parent().append('<span class="aw-reg-tips aw-reg-right"><i class="aw-icon i-followed"></i></span>');
              }
              return;


          }
        }

      }
    });
  }

</script>

<!-- DO NOT REMOVE -->
<div id="aw-ajax-box" class="aw-ajax-box"></div>
<div class="aw-mask hide">
  <div class="bg"></div>
  <div class="img"></div>
  <i class="icon icon-delete"></i>
</div>

<!-- Escape time: 0.014202117919922 --><!-- / DO NOT REMOVE -->


</body></html>