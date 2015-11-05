<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.jeefw.model.sys.Authority" %>
<%@ page import="java.util.*" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<DIV class="top-menu">
  <DIV class="container">
    <DIV class="row">
      <DIV class="col-sm-12">
        <A class="logo pull-left"  href="https://www.wegene.com/">
          <IMG width="162" src="${contextPath}/static/common/logo.png">
        </A>

        <!-- 用户栏 -->
        <DIV class="aw-user-nav active hidden-xs">
          <!-- 登陆&注册栏 -->
          <A href="${contextPath}/page/login">登录</A>
          /<A href="${contextPath}/page/register">注册</A>
          <!-- end 登陆&注册栏 -->
        </DIV><!-- end 用户栏 -->					 <!-- 搜索框 -->
        <DIV class="aw-search-box  hidden-xs hidden-sm">
          <FORM class="navbar-search" id="global_search_form" action=""  method="post">
            <DIV class="search-dropdown"><SPAN>报告  <i class="fa fa-chevron-down"></i></SPAN>
              <UL>
                <LI class="hide"><A data-search="gene" data-placeholder="搜索报告关键字">报告</A></LI>
                <LI><A data-search="" data-placeholder="搜索小组或讨论">社区</A></LI>
              </UL>
            </DIV>
            <INPUT  name="q" class="form-control search-query" id="aw-search-query" type="text"   placeholder="搜索报告关键字" value="" autocomplete="off">
                        <SPAN title="搜索" id="global_search_btns" onclick="$('#global_search_form').submit();">
                         <i class="fa fa-search"></i>
                        </SPAN>
          </FORM>
        </DIV>
        <!-- end 搜索框 -->

        <DIV class="aw-top-nav navbar">
          <DIV class="navbar-header">
            <BUTTON class="navbar-toggle pull-left">
              <SPAN class="icon-bar"></SPAN>
              <SPAN class="icon-bar"></SPAN>
              <SPAN class="icon-bar"></SPAN>
            </BUTTON>
          </DIV>
          <NAV class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <UL class="nav navbar-nav">
              <%
                List<Authority> authorityList = (List<Authority>)request.getAttribute("authorityList");
                for(Authority authority : authorityList){
                  if(authority.getParent().equals("false")){
              %>
              <LI><A href="<%=authority.getDataUrl()%>"><%=authority.getMenuName()%></A></LI>
              <%}else{%>
              <LI><SPAN><%=authority.getMenuName()%></SPAN>
                <DIV class="aw-dropdown dropdown-list pull-right">
                  <UL class="aw-dropdown-list">
                    <%for(Authority a : authority.getSubAuthorityList()){%>
                    <LI><A  href="<%=authority.getDataUrl()%>"><i class="<%=a.getMenuClass()%>"></i>&nbsp;&nbsp;&nbsp;<%=a.getMenuName()%></A></LI>
                    <%}%>
                  </UL>
                </DIV>
              </LI>
              <%}}%>
            </UL>
          </NAV>
        </DIV>
        <A  class="btn btn-gray btn-login pull-right visible-xs" href="https://www.wegene.com/account/login/">登录</A>
      </DIV>
    </DIV>
  </DIV>
</DIV>
