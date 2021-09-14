<%@ page import="com.example.entity.ResultInfo" %>
<%@ page import="com.example.dao.impl.InfoDaoImpl" %>
<%@ page import="com.example.entity.Msg" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List" %><%--
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
    <script src="js/item.js"></script>
    <script src="js/sweetalert.min.js"></script>
    <script>
        $(function (){
            var ID=GetQueryString("id")
            $.ajax({
                "url":"item.do",
                "dataType":"JSON",
                "type":"POST",
                "async":"false",
                "data":{ID:ID},
                success:function (res){
                    console.log(res)
                    if (res.res==0){
                        location.href="search.jsp"
                    }
                    if (res.data.length==0){
                        location.href="search.jsp"
                    }
                    $("#newsTitle").text(res.data[0].title)
                    $("#author").html("<strong>作者："+res.data[0].author+"</strong>")
                    $("#date").html("<strong>时间："+res.data[0].time+"</strong>")
                    $("#body").html(res.data[0].text)

                    const tbody = $("#tbody");
                    tbody.empty();
                    console.log(res.data[0])
                    if (res.data[0]==null){
                        location.href="search.jsp"
                    }
                    if (res.data.length==1){
                        let arr=`                        <tr>
                            <td>暂无评论哦</td>
                        </tr>`
                        tbody.append(arr)
                    }else{
                        let arr=res.data[1].map(result=>{
                            return `                        <tr>
                            <td>\${result.username}</td>
                        </tr>
                        <tr>
                            <td>\${result.text}</td>
                        </tr>
                        <tr>
                            <td>\${result.time}</td>
                        </tr>
                        <tr>
                            <td>点赞数:\${result.zan}</td>
                        </tr>
                        <tr>
                            <td>
                                &nbsp;
                            </td>
                        </tr>`
                        })
                        tbody.append(arr.join(''))
                    }
                }
            })
        })
    </script>
    <style>
        a{
            text-decoration:none;
            color: #5e5e5e;
        }
    </style>
</head>
<body style="background-color: #ede3e7">
    <header id='header'>
        <div class='center'>
            <nav style='overflow:hidden;'>
                <!--为了大纲清晰，所以要加个标题-->
                <h2 class="none ">网站导航</h2>
                <ul class="link">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="search.jsp" >活动查询</a></li>
                    <li><a href="dynamic.jsp">创新创业</a></li>
                    <li><a href="login.jsp" id="lo">登录</a></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="row clearfix" style="background-color: #ede3e7">
            <div class="col-md-6 column col-md-offset-3" style="background-color: white;margin-top: 60px;padding: 25px">
                <h3 class="text-center" id="newsTitle">
                    新闻标题
                </h3>
                <div class="row clearfix">
                    <div class="col-md-6" id="author">
                        作者
                    </div>
                    <div class="col-md-6" id="date">
                        时间
                    </div>
                    <div class="col-md-6" id="blank">
                        <br>
                    </div>
                </div>
                <div class="row clearfix" id="body">

                </div>
                <div class="row clearfix" style="margin-top: 20px">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <button type="button" class="btn btn-primary" id="delete" style="display: none"><span class="glyphicon glyphicon-remove-circle">删除</span></button>
                        </div>
                        <div class="col-md-4">
                            <button type="button" class="btn btn-primary" id="collect" style="margin-left: 5px;"><span class="glyphicon glyphicon-star-empty">收藏</span></button>
                        </div>
                        <div class="col-md-4">
                            <button type="button" class="btn btn-primary" id="zan" style="float: right"><span class="glyphicon glyphicon-thumbs-up">点赞</span></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row clearfix" style="background-color: #ede3e7">
            <div class="col-md-6 column col-md-offset-3" style="margin-top: 15px;background-color: white" id="comment">
                <table class="table" >
                    <caption>评论区</caption>
                    <tbody id="tbody">

                    </tbody>
                </table>
            </div>
            <div class="col-md-6 column col-md-offset-3" style="margin-top: 15px;background-color: white">
                <form role="form">
                    <div class="form-group">
                        <label>发表你的评论吧！</label>
                        <textarea class="form-control"  rows="3" cols="6" placeholder="未登录不可评论哦" name="msg" id="forthis"></textarea>
                        <button type="button" id="submit" class="btn btn-primary btn-lg btn-block">发表</button>
                    </div>
                </form>
            </div>
        </div>
    <footer id='foot' style="margin-top: 170px">
        <div class="top">
            <div class="block left ">
                <h2>相关链接</h2>
                <hr>
                <ul>
                    <li><a href="http://www.qncye.com/daxuesheng/">青年创业咨询</a></li>
                    <li><a href="https://www.lbzuo.com/">鹿豹座创业支持平台</a></li>
                    <li><a href="https://ggtw.glut.edu.cn/stzd1/zzjg3.htm">桂林理工大学双创中心</a></li>
                    <li><a href="http://www.cnmaker.org.cn/">创业中国</a></li>
                </ul>
            </div>
            <div class="block center ">
                <h2>相关链接</h2>
                <hr>
                <ul>
                    <li><a href="http://www.cnmaker.org.cn/">创客中国</a></li>
                    <li><a href="https://cy.ncss.cn/">全国大学生创业服务网</a></li>
                    <li><a href="https://www.glut.edu.cn/">桂林理工大学</a></li>
                    <li><a href="http://sc.ndrc.gov.cn/">国家创新创业信息网</a></li>
                </ul>
            </div>
            <div class="block right ">
                <h2>相关链接</h2>
                <hr>
                <ul>
                    <li><a href="https://dasai.lanqiao.cn/">蓝桥杯大赛官网</a></li>
                    <li><a href="https://www.csdn.net/">CSDN开发者社区</a></li>
                    <li><a href="https://www.nowcoder.com/">牛客网</a></li>
                    <li><a href="http://www.cnmaker.org.cn/">中国创业大学生帮扶基地</a></li>
                </ul>
            </div>
        </div>
    </footer>
</body>
</html>