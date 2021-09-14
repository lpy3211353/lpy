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
    <!--图标样式-->
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dynamic.css" rel="stylesheet">
    <link href="css/sweetalert.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/dynamic.js"></script>
    <script src="js/sweetalert.min.js"></script>
    <style>
        li a{
            color: #3170a7;
        }
    </style>
    <script>
        $(function (){
            //大赛资讯
            $("#dszx").click(function (){
                $.ajax({
                    "url":"dynamic.do",
                    "dataType":"JSON",
                    "data":{type:1},
                    "type":"POST",
                    success:function (res){
                        if (res.res==100){
                            $("#ttitle").html("大赛资讯")
                            const tbody = $("#tbody");
                            tbody.empty()
                            let arr=res.data.map(res=>{
                                return `                <tr>
                                <td><a href="item.jsp?id=\${res.ID}">\${res.title}</a></td>
                                <td>\${res.date}</td>
                                </tr>`
                            })
                           tbody.append(arr.join(''))
                        }else{
                            swal({
                                title:"错误",
                                type:"warning",
                                text:res.text,
                                confirmButtonColor: "#c04851"
                            })
                        }
                    }
                })
            })

            //双创动态
            $("#scdt").click(function (){
                $.ajax({
                    "url":"dynamic.do",
                    "dataType":"JSON",
                    "data":{type:2},
                    "type":"POST",
                    success:function (res){
                        if (res.res==100){
                            $("#ttitle").html("双创动态")
                            const tbody = $("#tbody");
                            tbody.empty()
                            let arr=res.data.map(res=>{
                                return `                <tr>
                                <td><a href="item.jsp?id=\${res.ID}">\${res.title}</a></td>
                                <td>\${res.date}</td>
                                </tr>`
                            })
                            tbody.append(arr.join(''))
                        }else{
                            swal({
                                title:"错误",
                                type:"warning",
                                text:res.text,
                                confirmButtonColor: "#c04851"
                            })
                        }
                    }
                })
            })

            //创客中心
            $("#ckzx").click(function (){
                $.ajax({
                    "url":"dynamic.do",
                    "dataType":"JSON",
                    "data":{type:3},
                    "type":"POST",
                    success:function (res){
                        if (res.res==100){
                            $("#ttitle").html("创客中心")
                            const tbody = $("#tbody");
                            tbody.empty()
                            let arr=res.data.map(res=>{
                                return `                <tr>
                                <td><a href="item.jsp?id=\${res.ID}">\${res.title}</a></td>
                                <td>\${res.date}</td>
                                </tr>`
                            })
                            tbody.append(arr.join(''))
                        }else{
                            swal({
                                title:"错误",
                                type:"warning",
                                text:res.text,
                                confirmButtonColor: "#c04851"
                            })
                        }
                    }
                })
            })
        })
    </script>
</head>
<body style="background: url('image/background.jpg') no-repeat fixed center;background-size: cover;-webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;">
<div id="container">
    <header id='header'>
        <div class='center'>
            <nav style='overflow:hidden;'>
                <!--为了大纲清晰，所以要加个标题-->
                <h2 class="none">网站导航</h2>
                <ul class="link">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="search.jsp" >活动查询</a></li>
                    <li class="active"><a href="#">创新创业</a></li>
                    <li><a href="login.jsp" id="lo">登录</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="row" style="margin-top: 30px;">
        <div class="col-lg-2 col-lg-offset-2">
            <ul class="nav nav-pills nav-stacked">
                <li style="margin-top: 5px;background-color: #ccccd6;border-radius: 5px" id="dszx"><a href="#">大赛资讯</a></li>
                <li style="margin-top: 5px;background-color: #ccccd6;border-radius: 5px" id="scdt"><a href="#">双创动态</a></li>
                <li style="margin-top: 5px;background-color: #ccccd6;border-radius: 5px" id="ckzx"><a href="#">创客中心</a></li>
            </ul>
        </div>
        <div class="col-lg-6" style="background-color: whitesmoke;border-radius: 5px">
            <table class="table">
                <thead>
                <tr>
                    <th style="color: #3170a7" id="ttitle">类型</th>
                    <th style="color: #3170a7">日期</th>
                </tr>
                </thead>
                <tbody id="tbody">

                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>