<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="auto" content='spider'>
    <meta charset="UTF-8">
    <title>创新创业中心</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/index.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        figure{
            height: 328.8px;
        }
        a{
            text-decoration:none;
            color: #5e5e5e;
        }
    </style>
    <script>
        $(function (){
            $.ajax({
                "url":"index.do",
                "type":"POST",
                "async":"false",
                success:function (res){
                    const dbody=$("#body")
                    let arr=res.data.map(res=>{
                        return `<figure>
            <a href="item.jsp?id=\${res.ID}"><img src="image/\${res.img}" alt='\${res.title}'></a>
            <figcaption><strong class='title'>\${res.title}</strong></figcaption>
            <div>
                <em class='zan'>点赞数:\${res.zan}</em>
            </div>
        </figure>`
                    })
                    dbody.append(arr.join(''))
                },
                fail:function (e){
                    console.log(e)
                }
            })
        })
    </script>
</head>
<body>
<!--body,nav,section需要标题大纲，一般nav是用来存放一组导航链接的,section一般不用来定义样式所以，header里用div.每个页面只有一个h1方便搜索引擎搜索-->
<header id='header'>
    <div class='center'>
        <nav style='overflow:hidden;'>
            <!--为了大纲清晰，所以要加个标题-->
            <h2 class="none">网站导航</h2>
            <ul class="link">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="search.jsp" >活动查询</a></li>
                <li><a href="dynamic.jsp">创新创业</a></li>
                <li><a href="login.jsp" id="lo">登录</a></li>
            </ul>
        </nav>
    </div>
</header>
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active banner">
            <img src="image/bg1.jpg" alt="First slide">
        </div>
        <div class="item banner">
            <img src="image/bg2.jpg" alt="Second slide">
        </div>
        <div class="item banner">
            <img src="image/bg3.jpg" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span></a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;</a>
</div>
<%--<div id="banner"><img src="image/search.jpg" alt="背景" style="width: 100%"/></div>--%>
<div id="hd">
    <section class='center'>
        <h2>近期活动</h2>
        <p>本校活动、外校活动、创新创业、毕业季就职、大公司讯息、最新最快的活动讯息</p>
    </section>
    <div id="body">

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