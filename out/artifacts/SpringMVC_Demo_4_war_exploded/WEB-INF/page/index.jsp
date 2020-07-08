<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/1
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>登录界面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body><br/>
<div class="container">

    <div class="jumbotron">
        <h1>Welcome</h1>
        <p>点击下方按钮进入登录界面</p>
    </div>
    <hr/>
    <div class="row">
        <div class="form-group">
            <div class="col-md-12">
                <input type="button" value="进入登录界面"
                       class="btn btn-block" onclick="location.href='login'"/>
            </div>
        </div>
    </div>
    <br/>
    <div class="row">
        <form role="form">
            <input type="text" name="userName" placeholder="请输入姓名" class="form-control"/>
            <input class="btn btn-default" id="btn_say_hello"
                   type="submit" value="打招呼" formaction="hello"/>
            <input class="btn btn-default" id="btn_say_bye"
                   type="submit" value="说再见" formaction="bye"/>
        </form>
    </div>
</div>
</body>
</html>
