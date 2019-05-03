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
            position: fixed;
            top: 25%;
            left: 25%;
            width: 55%;
            height: 55%;
            padding: 20px;
            border: 10px solid orange;
            background-color: white;
            z-index: 1002;
            overflow: auto;
        }


        #headimg {
            width: 160px;
            height: 160px;
            margin: 5px;
            margin-left: 10px;
        }

        #img {
            width: 162px;
            height: 162px;
            border: red solid 1px;
        }

        #showimg {
            width: 162px;
            height: 162px;
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

                    <a href="allcommodityadmin.do" class="active">商品管理</a>
                    <a href="orderinfoadmin.do">订单管理</a>
                </div>
            </div>
        </div>
    </div>
    <%--context end--%>
</div>
<div>
    <table class="table table-bordered">
        <tr class="danger">
            <td>图片</td>
            <td>商品名</td>
            <td>单价</td>
            <td><select class="form-control" id="selectId">
                <option value="0">-类别-</option>
                <c:forEach items="${xprolist}" var="xp">
                    <option value="${xp.xpid}">${xp.xpname}</option>
                </c:forEach>
            </select></td>
            <td>操作
                <button onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                    新增
                </button>
            </td>
        </tr>
        <c:forEach items="${commoditylist}" var="c">
            <tr class="success">
                <td><img style="width: 150px" src="<c:url value="/resources/static/img/${c.image}"/>" alt=""></td>
                <td>${c.cname}</td>
                <td>${c.price}</td>
                <td>${c.detail}</td>
                <td>
                    <button onclick="deletebyid(${c.cid})">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="light" class="white_content">
    <form id="form1" action="addcommodity.do" method="post" enctype="multipart/form-data"
          class="fh5co-form animate-box"
          data-animate-effect="fadeIn" style="margin-top: 0px">
        <h2>新增商品</h2>
        <div id="headimg">
            <div class="btn btn-success fileinput-button" id="head">
                <span id="span1">点击上传商品图片</span>  <img src="#" id="showimg"/>
                <input
                        type="file" id="book-file" onchange="show1(this)" name="pictureFile"/>
            </div>
        </div>
        <div class="form-group">
            <label for="cname" class="sr-only">商品名</label>
            <p>商品名：</p><input type="text" class="form-control" id="cname" placeholder="输入商品名" autocomplete="off"
                              name="cname">
        </div>
        <div class="form-group">
            <label for="price" class="sr-only">单价</label>
            <p>单价：</p><input type="text" class="form-control" id="price" placeholder="输入单价" autocomplete="off"
                             name="price">
        </div>
        <div class="form-group">
            <label for="price" class="sr-only">类别</label>
            <select class="form-control" id="selectIdadd" name="xpid">
                <option value="0">-类别-</option>
                <c:forEach items="${xprolist}" var="xp">
                    <option value="${xp.xpid}">${xp.xpname}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" value="添加" class="btn btn-primary">
        </div>
        <button class="layui-btn" type="button"
                onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
            取消
        </button>
    </form>
</div>
<div id="fade" class="black_overlay"></div>

<script type="text/javascript">

    function deletebyid(id) {
        var url = "deletecommodity.do?cid=" + id;
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

    var selectId = document.getElementById("selectId");//获取ID
    selectId.onchange = function ()//触发事件
    {
        var index = selectId.selectedIndex
        window.location = "http://localhost:8080/ssmidea/commodityadminbyid.do?xpid=" + index;
    }

    selectId[${selectid}].selected = true;//选中

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
