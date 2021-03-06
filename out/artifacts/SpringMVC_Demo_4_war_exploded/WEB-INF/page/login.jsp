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
    <title>${title}</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body><br/>
<div class="container">

    <div class="container">
        <div class="jumbotron">
            <h1>${message}</h1>
            <p>要想代码打得好，Hello World不可少</p>
        </div>
        <hr/>
        <div role="form" >
            <div class="row">
                <div class="col-md-8">
                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-3 control-label text-center">
                                <label for="input_account">用户名</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" id="input_account" value="${account_error}" name="input_account"
                                       placeholder="请输入登录账户" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-3 control-label text-center">
                                <label for="input_password">密码</label>
                            </div>
                            <div class="col-md-9">
                                <input type="password" id="input_password" value="${password_error}"
                                       name="input_password"
                                       placeholder="请输入密码" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-3">
                                <input type="submit"
                                       id="btn_submit"
<%--                                       formaction="sign_in"--%>
                                       class="btn btn-block"
                                       value="提交"/>
                            </div>
                            <div class="col-md-3">
                                <input type="reset" id="btn_reset" class="btn btn-block"/>
                            </div>
                            <div class="col-md-3">
                                <input type="submit"
                                       formaction="index"
                                       id="btn_welcome"
                                       class="btn btn-block"
                                       value="返回欢迎页"/>
                            </div>
                            <div class="col-md-3">
                                <input type="button"
                                       id="btn_github"
                                       class="btn btn-block"
                                       value="查看源码"
                                       onclick="window.location.href='http://github.com'"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            登录账密
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <th>账 号</th>
                                <th>密 码</th>
                                <th>权 限</th>
                                <tr>
                                    <td>admin</td>
                                    <td>admin</td>
                                    <td>普通用户</td>
                                </tr>
                                <tr>
                                    <td>root</td>
                                    <td>root</td>
                                    <td>管理员</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">

    document.onkeydown = function (e) {
        var clickEvent = e || window.event;
        if (clickEvent.keyCode == 13) {
            $('#btn_submit').click();
        }
    };

    $('#btn_submit').click(function () {
        var account = $('#input_account').val();
        var password = $('#input_password').val();

        alert("account = " + account + ", password = " + password);

        // 判断输入是否为空
        if (account == "" || account.length == 0) {
            alert("<div style='color: red;'>账号不能为空</div>");
            return;
        } else if (password == "" || password.length == 0) {
            alert("<div style='color: red;'>密码不能为空</div>");
            return;
        }

        var contextPath = '${pageContext.request.contextPath}';

        $('#btn_submit').attr("readonly", "readonly");
        $.ajax({
            type: 'POST',
            url: contextPath +'/sign_in',
            data: {
                "account": account,
                "password": password
            },
            datatype: "json",
            error: function(){
                $('#btn_submit').removeAttr("readonly");
                alert("<div style='color: red;'>登录失败</div>");
            },
            success: function(data){
                // var currentUser = data.data.currentUser;
                alert("login success");
                location.href = 'homepage';
            }
        });

    });

</script>

</html>
