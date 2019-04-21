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

    <!-- Modernizr JS -->
    <script src="<c:url value="/resources/static/js/modernizr-2.6.2.min.js"/>"></script>
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
                    <div class="login"><a href="shopcart.do">${userinfo.username}</a></div>,
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
<div class="content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="allcommodity.do" class="active">所有商品</a>
                    <a href="buytoday.html">今日团购</a>
                    <a href="information.html">母婴资讯</a>
                    <a href="about.html">关于我们</a>
                </div>
            </div>
        </div>
    </div>
    <div class="category-con">
        <div class="category-inner-con w1200">
            <div class="category-type">
                <h3>全部分类</h3>
            </div>
            <div class="category-tab-content">
                <div class="nav-con">
                    <ul class="normal-nav layui-clear">
                        <%--此处foreach 循环遍历--%>

                        <c:forEach items="${plist}" var="p">
                            <li class="nav-item">

                                <div class="title">${p.pname} </div>
                                <c:set var="pid" value="${p.pid}"/>
                                <p><c:forEach items="${pmap[pid]}" var="xp">
                                    <a href="selectcommodity.do?pid=${xp.xpid}">${xp.xpname}</a>
                                </c:forEach></p>

                            </li>

                        </c:forEach>


                    </ul>
                </div>
            </div>
        </div>
        <div class="category-banner">
            <div class="w1200">
                <img src="<c:url value="/resources/static/img/banner1.jpg"/>">
            </div>
        </div>
    </div>
    <div class="floors">
        <div class="sk">
            <div class="sk_inner w1200">
                <div class="sk_hd">
                    <a href="javascript:;">
                        <img src="<c:url value="/resources/static/img/s_img1.jpg"/>">
                    </a>
                </div>
                <div class="sk_bd">
                    <div class="layui-carousel" id="test1">
                        <div carousel-item>
                            <div class="item-box">
                                <%--此处foreach 循环遍历--%>

                                <c:forEach items="${biqianglist}" var="b" begin="0" end="3">
                                    <div class="item">
                                        <a href="javascript:;"><img
                                                src="<c:url value="/resources/static/img/${b.image}"/>"></a>
                                        <div class="title">${b.cname}</div>
                                        <div class="price">
                                            <span>￥${b.price}</span>
                                            <del>￥${b.price+20.00}</del>
                                        </div>

                                    </div>
                                </c:forEach>
                            </div>
                            <div class="item-box">
                                <c:forEach items="${biqianglist}" var="b" begin="4" end="7">
                                    <div class="item">
                                        <a href="javascript:;"><img
                                                src="<c:url value="/resources/static/img/${b.image}"/>"></a>
                                        <div class="title">${b.cname}</div>
                                        <div class="price">
                                            <span>￥${b.price}</span>
                                            <del>￥${b.price+20.00}</del>
                                        </div>

                                    </div>
                                </c:forEach>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--context end--%>

    <div class="product-list-box" id="product-list-box">
        <div class="product-list-cont w1200">
            <h4>更多推荐</h4>
            <div class="product-item-box layui-clear">
                <c:forEach items="${biqianglist}" var="b" begin="8">
                    <div class="list-item">
                        <a href="javascript:;"><img style="width: 160px;height: 180px"
                                                    src="<c:url value="/resources/static/img/${b.image}"/>"></a>
                        <p>${b.cname}</p>
                        <span>￥${b.price}</span>
                    </div>

                </c:forEach>

            </div>
        </div>
    </div>
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
