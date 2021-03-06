<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>贝贝商城</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/css/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/layui/css/layui.css"/>">


    <!-- <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'> -->
    <link rel="stylesheet" href="<c:url value="/resources/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/static/css/animate.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>">

    <!-- Modernizr JS -->
    <script src="<c:url value="/resources/static/js/modernizr-2.6.2.min.js"/>"></script>
    <!-- FOR IE9 below -->


    <script type="text/javascript" src="<c:url value="/resources/layui/layui.js"/>"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">

    <script type="text/javascript">
        function loginout() {
            $.ajax({
                async: true,  //异步加载
                type: "POST",
                url: "loginout.do",
                success: function (data) {
                    var numstr = data;
                    console.log("注册结果"+numstr)
                    if (numstr = 1) {
                        window.location = "index.do"

                    } else {
                        alert("注册失败")
                    }

                }
            });
        }
    </script>

    <script type="text/javascript">
        var checknameV = false;
        var checkpassV = false;
        function check() {
            if (checknameV && checkpassV){
                reg()
            } else {
                alert("请完善注册信息")
            }
        }
        function checkname() {
            var username = document.getElementById("name").value;
            $.ajax({
                async: true,  //异步加载
                data: username, //参数
                type: "POST",
                url: "checkname.do",
                success: function (data) {
                    var numstr = data;
                    if (numstr >= 1) {
                        document.getElementById("namemsg").style.color = "red"
                        document.getElementById("namemsg").innerHTML = "用户名已存在";
                        document.getElementById("btn").disabled = "disabled";
                        checknameV = false;
                    } else {
                        document.getElementById("namemsg").style.color = "green"
                        document.getElementById("namemsg").innerHTML = "用户名可用";
                        checknameV =true
                    }
                }
            });
        }
        function checkpass() {
            var password = document.getElementById("password").value;
            var checkpassword = document.getElementById("re-password").value;
            if (password == checkpassword){
                checkpassV = true
            } else {
                document.getElementById("passmsg").style.color = "red"
                document.getElementById("passmsg").innerHTML = "两次密码输入不一致";
                checkpassV =false
            }
        }
        function reg() {
            var username = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var user = {"username":username,"email":email,"password":password}
            $.ajax({
                async: true,  //异步加载
                contentType : "application/json;charset=utf-8",
                dataType: "json",
                data: JSON.stringify(user), //参数
                type: "POST",
                url: "register.do",
                success: function (data) {
                    var numstr = data;
                    console.log("注册结果"+numstr)
                    if (numstr >= 1) {
                        alert("注册成功")
                        window.location = "login.jsp"
                    } else {
                        alert("注册失败")
                    }
                }
            });
        }

    </script>

</head>

<body id="list-cont">

<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="index.do">首页</a>
        </p>
        <div class="sn-quick-menu">
            <c:choose>
                <c:when test="${userinfo.username ==null}">
                    <div class="login"><a href="login.jsp">登录</a></div>
                </c:when>
                <c:otherwise>
                    <div class="login"><a href="user.jsp">${userinfo.username}</a></div>,
                    <div class="login"><a href="javascript:loginout();">注销</a></div>
                    <div class="sp-cart"><a href="shopcart.do?id=${userinfo.id}">购物车</a></div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>


<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="index.do" title="母婴商城">
                    <img src="<c:url value="/resources/static/img/logo.png"/>">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="selectgoodbyname.do" class="layui-form" novalidate>
                    <input type="text" name="title" required lay-verify="required" autocomplete="off"
                           class="layui-input" placeholder="请输入需要的商品">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>

<%--context start--%>
<div class="content content-nav-base  login-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="allcommodity.do" class="active">所有商品</a>

                    <a href="information.html">母婴资讯</a>
                    <a href="about.html">关于我们</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="padding: 80px">
        <div class="col-md-4 col-md-offset-4">


            <!-- Start Sign In Form -->
            <form id="form1" onsubmit="return false" action="##" class="fh5co-form animate-box"
                  data-animate-effect="fadeIn">
                <h2>注册</h2>
                <div class="form-group">
                    <label for="name" class="sr-only">用户名</label>
                    <input type="text" class="form-control" id="name" placeholder="输入用户名" autocomplete="off"
                           name="username" onblur="checkname()">
                    <span id="namemsg" style="color:red"></span>
                </div>
                <div class="form-group">
                    <label for="email" class="sr-only">Email</label>
                    <input type="email" class="form-control" id="email" placeholder="输入Email" autocomplete="off"
                           name="email">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input type="password" class="form-control" id="password" placeholder="设置密码" autocomplete="off"
                           name="password">
                </div>
                <div class="form-group">
                    <label for="re-password" class="sr-only">确认密码</label>
                    <input type="password" class="form-control" id="re-password" placeholder="确认密码"
                           autocomplete="off" onblur="checkpass()">
                    <span id="passmsg" style="color:red"></span>
                </div>
                <div class="form-group">
                    <p>已有账号? <a href="login.jsp">点击登录</a></p>
                </div>
                <div class="form-group">
                    <input type="button" value="注册" onclick="check()" class="btn btn-primary">
                </div>
            </form>
            <!-- END Sign In Form -->

        </div>
    </div>

    <%--context end--%>

</div>

<div class="footer">
    <div class="ng-promise-box">
        <div class="ng-promise w1200">
            <p class="text">
                <a class="icon1" href="javascript:;">7天无理由退换货</a>
                <a class="icon2" href="javascript:;">满99元全场免邮</a>
                <a class="icon3" style="margin-right: 0" href="javascript:;">100%品质保证</a>
            </p>
        </div>
    </div>
    <div class="mod_help w1200">
        <p>
            <a href="javascript:;">关于我们</a>
            <span>|</span>
            <a href="javascript:;">帮助中心</a>
            <span>|</span>
            <a href="javascript:;">售后服务</a>
            <span>|</span>
            <a href="javascript:;">母婴资讯</a>
            <span>|</span>
            <a href="javascript:;">关于货源</a>
        </p>
        <p class="coty">母婴商城版权所有 &copy; zch <a href="#" target="_blank" title="zch">张小辉</a> - Collect from <a href="#"
                                                                                                              title="zch"
                                                                                                              target="_blank">2018-2019毕业设计</a>
        </p>
    </div>
</div>


<!-- jQuery -->
<script src="<c:url value="/resources/static/js/jquery.min.js"/>"></script>
<!-- Bootstrap -->
<script src="<c:url value="/resources/static/js/bootstrap.min.js"/>"></script>
<!-- Placeholder -->
<script src="<c:url value="/resources/static/js/jquery.placeholder.min.js"/>"></script>
<!-- Waypoints -->
<script src="<c:url value="/resources/static/js/jquery.waypoints.min.js"/>"></script>
<!-- Main JS -->
<script src="<c:url value="/resources/static/js/main.js"/>"></script>


<script type="text/javascript">

    layui.config({
        base: '<c:url value="/resources/static/js/util/"/>' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm', 'carousel'], function () {
        var carousel = layui.carousel,
            mm = layui.mm;
        var option = {
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , arrow: 'always'
            , height: '298'
            , indicator: 'none'
        }
        carousel.render(option);
        // 模版引擎导入
        // var ins = carousel.render(option);
        // var html = demo.innerHTML;
        // var listCont = document.getElementById('list-cont');
        // // console.log(layui.router("#/about.html"))
        //  mm.request({
        //    url: '../json/index.json',
        //    success : function(res){
        //      cons


    });
</script>
</body>
</html>
