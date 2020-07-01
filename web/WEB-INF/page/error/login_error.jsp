<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/1
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">

    <div class="jumbotron">
        <h1>login_error</h1>
        <p>${error_msg}</p>
    </div>
    <input type="button" class="btn btn-primary" value="返回登录界面" onclick="location.href='login'"/>
</div>
</body>
</html>
