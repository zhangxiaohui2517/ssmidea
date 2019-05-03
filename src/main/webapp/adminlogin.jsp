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
    <script type="text/javascript" src="<c:url value="/resources/layui/layui.js"/>"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">

    <script type="text/javascript">
        function reg() {
            window.location="reg.jsp"
        }
    </script>
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

</head>

<body id="list-cont">

<%--context start--%>
<div class="content content-nav-base  login-content">

    <div class="login-bg">
        <div class="login-cont w1200">
            <div class="form-box">
                <form class="layui-form" action="adminlogin.do" method="post">
                    <legend>管理员登录</legend>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input type="text" name="username" id="username" lay-verify="required|username"
                                       placeholder="请输入用户名" autocomplete="off" class="layui-input" required>
                            </div>
                        </div>
                        <div class="layui-inline veri-code">
                            <div class="layui-input-inline">
                                <input id="pnum" type="password" name="password" lay-verify="required"
                                       placeholder="请输入密码" autocomplete="off" class="layui-input" required>
                            </div>
                        </div>
                        <span class="laytable-cell-space" style="color: red">${rs}</span>
                    </div>
                    <div class="layui-form-item login-btn">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="demo1" onclick="submit">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%--context end--%>

</div>



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
