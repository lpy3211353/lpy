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
    <link href="css/search.css" rel="stylesheet">
    <link href="css/sweetalert.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/search.js"></script>
    <script src="js/sweetalert.min.js"></script>

    <script>
        $(function (){
            $("#search").click(function (){
                let data=$("#msg").val()
                $.ajax({
                    "url":"search.do",
                    "dataType":"JSON",
                    "data":{msg:data},
                    "type":"POST",
                    success:function (res){
                        if (res.res==100){
                            const tbody = $("#searchList");
                            tbody.empty()
                            let arr=res.data.map(result=>{
                                return `<tr>
                               <td><a href="item.jsp?id=\${result.ID}">\${result.title}</a></td>
                               <td>\${result.date}</td>
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
                    <li class="active"><a href="#" >活动查询</a></li>
                    <li><a href="dynamic.jsp">创新创业</a></li>
                    <li><a href="login.jsp" id="lo">登录</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="row" style="margin-top: 60px">
        <div class="input-group col-lg-3" style="margin-left: 60px;float: left">
            <input type="text" class="form-control" id="msg" placeholder="请输入关键词">
            <span class="input-group-btn">
               <button class="btn btn-info btn-search" id="search">搜索</button>
            </span>
        </div>

        <div class="col-lg-6" style="background-color: white;float: right;margin-right: 60px;border-radius:20px;opacity: 0.8" id="result">
            <div class="panel-body">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                标题
                            </th>
                            <th>
                                时间
                            </th>
                        </tr>
                    </thead>
                    <tbody id="searchList">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>