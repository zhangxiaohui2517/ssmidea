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

    <style>

        .black_overlay {
            display: none;
            position: fixed;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index: 1001;
            -moz-opacity: 0.8;
            opacity: .80;
            filter: alpha(opacity=88);
        }

        .white_content {
            display: none;
            position: absolute;
            top: 7%;
            left: 120%;
            width: 900px;
            height: 852px;
            padding: 20px;
            border: 10px solid beige;
            background-color: white;
            z-index: 1002;
            overflow-y: auto
        }


        #headimg {
            width: 160px;
            height: 160px;
            margin: 5px;
            margin-left: 10px;
            border-radius: 80px;
        }

        #img {
            width: 162px;
            height: 162px;
            border-radius: 80px;
            border: red solid 1px;
        }

        #showimg {
            width: 162px;
            height: 162px;
            border-radius: 80px;
            border: red solid 1px;
        }

        #update {
            display: none;
        }

        #head {
            position: relative;
            display: inline-block;
            overflow: hidden;
            padding: 0px;
            width: 160px;
            height: 160px;
            border-radius: 80px;
            border: red solid 1px;
            background: #4e4a4a
        }

        #head input {
            position: absolute;
            left: 0px;
            top: 0px;
            padding: 50px;
            opacity: 0;
            -ms-filter: 'alpha(opacity=0)';
        }

        #head span {
            position: absolute;
            left: 35px;
            top: 40px;
        }
    </style>

    <script type="text/javascript">
        var checknameV = false;
        var checkpassV = false;

        function check() {
            if (checknameV && checkpassV) {
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
                        checknameV = true
                    }
                }
            });
        }

        function checkpass() {
            var password = document.getElementById("password").value;
            var checkpassword = document.getElementById("re-password").value;
            if (password == checkpassword) {
                checkpassV = true
            } else {
                document.getElementById("passmsg").style.color = "red"
                document.getElementById("passmsg").innerHTML = "两次密码输入不一致";
                checkpassV = false
            }
        }

        function reg() {
            var username = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var user = {"username": username, "email": email, "password": password}
            $.ajax({
                async: true,  //异步加载
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                data: JSON.stringify(user), //参数
                type: "POST",
                url: "register.do",
                success: function (data) {
                    var numstr = data;
                    console.log("注册结果" + numstr)
                    if (numstr >= 1) {
                        alert("注册成功")
                        window.location = "login.jsp"
                    } else {
                        alert("注册失败")
                    }
                }
            });
        }

        function show1(f) {
            document.getElementById("span1").style.display = "none";
            var rd = new FileReader(); //创建文件读取对象
            var files = f.files[0]; //获取file组件中的文件
            rd.readAsDataURL(files); //文件读取装换为base64类型
            rd.onloadend = function (e) {
                //加载完毕之后获取结果赋值给img
                document.getElementById("showimg").src = this.result;
            }
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
                    console.log("注册结果" + numstr)
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
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="userinfolist.do">用户管理</a>

                    <a href="allcommodityadmin.do">商品管理</a>
                    <a href="orderinfoadmin.do" class="active">订单管理</a>
                </div>
            </div>
        </div>
    </div>
    <%--context end--%>
</div>
<div style="width: 100%;">
    <div>
        <form action="selectorderbyname.do" class="layui-form" novalidate>
            <input type="text" name="username" required lay-verify="required" autocomplete="off"
                   class="layui-input" placeholder="请输入需要的搜索的用户名" value="${selectusername}">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
        </form>
    </div>
    <div class="list-box" style="width: 100%;">
        <c:choose>
            <c:when test="${orders != null}">
                <c:forEach items="${orders}" var="o">
                    <c:set var="oid" value="${o.oid}"/>
                    <div class="order" style="margin: 10px;width: 100%;">
                        <table style="width: 100%;align-content: center;background: gray;color: white;font-size: 16px">
                            <tr>
                                <td>id:${o.oid}</td>
                                <td>用户：${orderusername[oid]}</td>
                                <td>订单生成日期：${o.createtime}</td>
                                <td>订单总金额：${o.payment}</td>
                            </tr>
                        </table>
                        <div>
                            <table style="border: 1px;width: 100%;align-content: center;background: #c0e2ef;color: white;font-size: 14px;padding: 2px">
                                <tr>
                                    <td>商品</td>
                                    <td></td>
                                    <td>单价</td>
                                    <td>数量</td>
                                    <td>总价</td>
                                </tr>
                                <c:forEach items="${orderinfos[oid]}" var="oi">

                                    <tr>
                                        <td><img style="width: 100px;height: 112px"
                                                 src="<c:url value="/resources/static/img/${oi.photo}"/>">
                                        </td>
                                        <td width="350px">${oi.cname}</td>
                                        <td>${oi.cprice}</td>
                                        <td>${oi.cnum}</td>
                                        <td>${oi.cnum *oi.cprice}</td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h3>无购物记录</h3>
            </c:otherwise>
        </c:choose>


    </div>
</div>

<script type="text/javascript">

    function deletebyid(id) {
        var url = "deleteuser.do?id=" + id;
        $.ajax({
            async: true,  //异步加载
            type: "GET",
            url: url,
            success: function (data) {
                var numstr = data;
                if (numstr = 1) {
                    window.location = window.location
                } else {
                    alert("删除失败")
                }
            }
        });
    }
</script>

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
