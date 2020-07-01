<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/1
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    domain.User currentUser = (domain.User) session.getAttribute("currentUser");
    if (null != currentUser) {
%>
<br/>
<div class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="location.href='homepage'" class="navbar-brand">测试页面</a>
        </div>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="#">页面1</a></li>
            <li><a href="#">页面2</a></li>
            <li><a href="#">页面3</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    你好，${userName}
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">个人中心</a></li>
                    <li><a href="#">功能1</a></li>
                    <li><a href="#">功能2</a></li>
                    <li class="divider"></li>
                    <li><a href="sign_out">退出登录</a></li>
                </ul>
            </li>
            <li><a href="#">上次登录：${userLastLogin}</a></li>
        </ul>

    </div>
</div>
<br/>
<%} %>