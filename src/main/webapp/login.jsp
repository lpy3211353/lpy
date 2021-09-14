<%--
  Created by IntelliJ IDEA.
  User: 93173
  Date: 2021/6/18
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="auto" content='spider'>
    <meta charset="UTF-8">
    <title>创新创业</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--界面文件-->
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sweetalert.css" rel="stylesheet">

    <!--js文件-->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/login.js"></script>
    <script src="js/sweetalert.min.js"></script>
</head>
<body style="background: url('image/background.jpg') no-repeat fixed center;background-size: cover;-webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;">
<div id="container">
    <header id='header'>
        <div class='center'>
            <nav style='overflow:hidden;'>
                <!--为了大纲清晰，所以要加个标题-->
                <h2 class="none ">网站导航</h2>
                <ul class="link">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="search.jsp" >活动查询</a></li>
                    <li><a href="dynamic.jsp">创新创业</a></li>
                    <li  class="active" ><a href="#" id="lo">登录</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="output" id="login_box">
        <div class="containerT">
            <h1 style="color: aliceblue;">用户登录</h1>
            <form class="form" id="login_form">
                <input type="text" placeholder="用户名" id="login_name" name="username">
                <input type="password" placeholder="密码" id="login_password" name="password">
                <button type="button" class="btn btn-default" id="login_btn" style="margin-top: 6px;">登录</button>
                <button type="button" class="btn btn-info" id="register_btn" style="margin-top: 6px;">注册</button>
                <div class="prompt"></div>
            </form>
        </div>
    </div>
    <div class="output" id="register_box" style="display: none">
        <div class="containerT">
            <h1 style="color: aliceblue;">用户注册</h1>
            <form class="form" id="register_form">
                <input type="text" placeholder="用户名" id="register_name" name="username">
                <input type="password" placeholder="密码" id="register_password" name="password">
                <input type="password" placeholder="密码" id="re_password" name="password">
                <button type="button" class="btn btn-info" id="register" style="margin-top: 6px;">注册</button>
                <button type="button" class="btn btn-default" id="backlogin" style="margin-top: 6px;">返回登陆</button>
                <div class="prompt"></div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="js/inspinia.js"></script>
</html>