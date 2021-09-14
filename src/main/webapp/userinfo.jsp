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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sweetalert.css" rel="stylesheet">

    <!--js文件-->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/sweetalert.min.js"></script>
    <script src="js/userinfo.js"></script>


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no,viewport-fit=cover">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-transform">
    <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
    <meta name="theme-color" content="#0F7D00">
    <meta property="og:image" content="https://www.nange.cn/image/others/bingo.jpeg">
    <meta name="msapplication-TileColor" content="#0F7D00">
    <link rel="stylesheet" href="assets/css/main.css" />
    <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
    <style>
        li{
            list-style: none;
        }
        #main a{
            font-size: 17px;
            font-weight: bold;
        }
    </style>

    <script>
        $(window).load(
            function (){
                $.ajax({
                    "url":"user.do",
                    "type":"POST",
                    "dataType":"JSON",
                    "async": false,
                    "data":{type:2},
                    success:function (res){
                        const tbody=$("#tbody")
                        if(res.res==100){
                            let arr=res.data.map(res=>{
                                return `                <tr>
                                <td><a href="item.jsp?id=\${res.ID}">\${res.title}</a></td>
                                <td>\${res.date}</td>
                                </tr>`
                            })
                            tbody.append(arr.join(''))
                        }
                    }
                })
            }
        )
    </script>
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
    <!-- Wrapper -->
    <div id="wrapper">
        <!-- Main -->
        <section id="main">
            <header>
                <span class="avatar" id="head"><img src="image/head1.jpg" alt="" /></span>
                <h1 id="username"></h1>
                    <li id="update" data-toggle="modal" data-target="#myModal"><a>修改密码</a></li>
                    <li id="collect" data-toggle="modal" data-target="#myCollection"><a>我的收藏</a></li>
                    <li id="quit"><a>退出登录</a></li>
            </header>
            <footer>

            </footer>
        </section>
        <!-- Footer -->
        <footer id="footer">
            <ul class="copyright">
                <li> </li>
                <li> </li>
            </ul>
        </footer>
    </div>
    <script>
        if ('addEventListener' in window) {
            window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-preload\b/, ''); });
            document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
        }
    </script>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="oldpassword">旧密码</label>
                        <input type="text" class="form-control" id="oldpassword" placeholder="请输入旧密码">
                        <label for="newpassword">新密码</label>
                        <input type="text" class="form-control" id="newpassword" placeholder="请输入新密码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submit">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div class="modal fade" id="myCollection" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="ModalLabel">我的收藏</h4>
            </div>
            <div class="modal-body col-lg-12" id="showCollection">
                <table class="table">
                    <thead>
                    <tr>
                        <th style="color: #3170a7" id="ttitle">标题</th>
                        <th style="color: #3170a7">日期</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">

                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>