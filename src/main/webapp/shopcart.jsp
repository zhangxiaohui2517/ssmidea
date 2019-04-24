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
        function deletebyid(id) {
            var url = "deleteshopcartbyid.do?sid=" + id;
            $.ajax({
                async: true,  //异步加载
                type: "GET",
                url: url,
                success: function (data) {
                    var numstr = data;
                    if (numstr = 1) {
                        window.location = window.location
                    } else {
                        alert("注册失败")
                    }

                }
            });

        }

        function chuangeNum(type, id, num) {
            var cnum = num


            if (cnum > 1 || !(type == 1 && cnum <= 1)) {
                if (type == 2) {
                    cnum = cnum + 1
                } else if (type == 1) {
                    cnum = cnum - 1
                }
                var url = "changecnum.do?sid=" + id + "&cnum=" + cnum;
                $.ajax({
                    async: true,  //异步加载
                    type: "GET",
                    url: url,
                    success: function (data) {
                        var numstr = data;
                        if (numstr = 1) {
                            window.location = window.location
                        } else {
                            alert("注册失败")
                        }

                    }
                });
            }
        }
    </script>


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
    </style>

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

<body>

<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="#">首页</a>
        </p>
        <div class="sn-quick-menu">
            <c:choose>
                <c:when test="${userinfo.username ==null}">
                    <div class="login"><a href="login.jsp">登录</a></div>
                </c:when>
                <c:otherwise>
                    <div class="login"><a href="user.jsp">${userinfo.username}</a></div>
                    ,
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
                <a href="#" title="母婴商城">
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


<div class="content content-nav-base shopcart-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="commodity.html" class="active">所有商品</a>
                    <a href="buytoday.html">今日团购</a>
                    <a href="information.html">母婴资讯</a>
                    <a href="about.html">关于我们</a>
                </div>
            </div>
        </div>
    </div>
    <div class="banner-bg w1200">
        <h3>我的购物车</h3>

    </div>
    <div class="cart w1200">
        <div class="cart-table-th">
            <div class="th th-chk">
                <div class="select-all">
                    <div class="cart-checkbox">

                    </div>
                    <label>&nbsp;&nbsp;</label>
                </div>
            </div>
            <div class="th th-item">
                <div class="th-inner">
                    商品
                </div>
            </div>
            <div class="th th-price">
                <div class="th-inner">
                    单价
                </div>
            </div>
            <div class="th th-amount">
                <div class="th-inner">
                    数量
                </div>
            </div>
            <div class="th th-sum">
                <div class="th-inner">
                    小计
                </div>
            </div>
            <div class="th th-op">
                <div class="th-inner">
                    操作
                </div>
            </div>
        </div>
        <div class="OrderList">
            <div class="order-content" id="list-cont">

                <c:choose>
                    <c:when test="${shopcartlist != null}">
                        <c:forEach items="${shopcartlist}" var="s">
                            <ul class="item-content layui-clear">
                                <li class="th th-chk">
                                    <div class="select-all">
                                        <div class="cart-checkbox">

                                        </div>
                                    </div>
                                </li>
                                <li class="th th-item">
                                    <div class="item-cont">
                                        <a href="javascript:;"><img src="../res/static/img/paging_img1.jpg" alt=""></a>
                                        <div class="text">
                                            <div class="title">${s.cname}</div>
                                        </div>
                                    </div>
                                </li>
                                <li class="th th-price">
                                    <span class="th-su">￥${s.cprice}</span>
                                </li>
                                <li class="th th-amount">
                                    <div class="box-btn layui-clear">
                                        <div class="layui-btn" onclick="chuangeNum('1',${s.id},${s.cnum})">-</div>
                                        <input int id="${s.id}" class="Quantity-input" type="" name="" value="${s.cnum}"
                                               disabled="disabled">
                                        <div class="layui-btn" onclick="chuangeNum('2',${s.id},${s.cnum})">+</div>
                                    </div>
                                </li>
                                <li class="th th-sum">
                                    <span>￥${s.cprice * s.cnum}</span>
                                </li>
                                <li class="th th-op">
                                    <span onclick="deletebyid(${s.id})">删除</span>
                                </li>
                            </ul>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h1>购物车无商品！</h1>
                    </c:otherwise>
                </c:choose>


            </div>
        </div>


        <!-- 模版导入数据 -->
        <!-- <script type="text/html" id="demo">
          {{# layui.each(d.infoList,function(index,item){}}
            <ul class="item-content layui-clear">
              <li class="th th-chk">
                <div class="select-all">
                  <div class="cart-checkbox">
                    <input class="CheckBoxShop check" id="" type="checkbox" num="all" name="select-all" value="true">
                  </div>
                </div>
              </li>
              <li class="th th-item">
                <div class="item-cont">
                  <a href="javascript:;"><img src="../res/static/img/paging_img1.jpg" alt=""></a>
                  <div class="text">
                    <div class="title">宝宝T恤棉质小衫</div>
                    <p><span>粉色</span>  <span>130</span>cm</p>
                  </div>
                </div>
              </li>
              <li class="th th-price">
                <span class="th-su">189.00</span>
              </li>
              <li class="th th-amount">
                <div class="box-btn layui-clear">
                  <div class="less layui-btn">-</div>
                  <input class="Quantity-input" type="" name="" value="1" disabled="disabled">
                  <div class="add layui-btn">+</div>
                </div>
              </li>
              <li class="th th-sum">
                <span class="sum">189.00</span>
              </li>
              <li class="th th-op">
                <span class="dele-btn">删除</span>
              </li>
            </ul>
          {{# });}}
        </script> -->


        <div class="FloatBarHolder layui-clear">
            <div class="th th-chk">
                <div class="select-all">
                    <div class="cart-checkbox">

                    </div>
                    <label>&nbsp;&nbsp;<span class="Selected-pieces"></span></label>
                </div>
            </div>
            <div class="th batch-deletion">

            </div>
            <div class="th Settlement">
                <button class="layui-btn"
                        onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                    结算
                </button>
            </div>
            <div class="th total">
                <p>应付：<span class="pieces-total">${allprice}</span></p>
            </div>
        </div>
    </div>
</div>

<div id="light" class="white_content">

    <h2>确认结算金额</h2>
    <h2>&nbsp;&nbsp;</h2>
    <input type="text" name="allprice1" id="allprice1" required lay-verify="required" autocomplete="off"
           class="layui-input" value="${allprice}" readonly="readonly">
    <h2 id="tishi" style="color: red">&nbsp;&nbsp;</h2>
    <input type="text" name="allprice2" id="allprice2" required lay-verify="required" autocomplete="off"
           class="layui-input" placeholder="${allprice}">
    <h2>&nbsp;&nbsp;</h2>
    <button class="layui-btn" onclick="jiesuan()">付款</button>&nbsp;&nbsp;<button class="layui-btn"
                                                                                 onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
    取消
</button>

</div>
<div id="fade" class="black_overlay"></div>

<script type="text/javascript">

    function jiesuan() {
        var allprice1 = document.getElementById("allprice1").value;
        var allprice2 = document.getElementById("allprice2").value;
        if (parseFloat(allprice1) != parseFloat(allprice2)) {
            document.getElementById("tishi").innerHTML = "请输入正确结算金额"
        } else {
            var url = "addorder.do?payment=" + allprice2
            $.ajax({
                async: true,  //异步加载
                type: "GET",
                url: url,
                success: function (data) {
                    var numstr = data;
                    if (numstr = 1) {
                        window.location = window.location
                    } else {
                        alert("支付失败")
                    }

                }
            });
        }
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
    }).use(['mm', 'jquery', 'element', 'car'], function () {
        var mm = layui.mm, $ = layui.$, element = layui.element, car = layui.car;

        // 模版导入数据
        // var html = demo.innerHTML,
        // listCont = document.getElementById('list-cont');
        // mm.request({
        //   url: '../json/shopcart.json',
        //   success : function(res){
        //     listCont.innerHTML = mm.renderHtml(html,res)
        //     element.render();
        //     car.init()
        //   },
        //   error: function(res){
        //     console.log(res);
        //   }
        // })
        //
        car.init()


    });
</script>
</body>
</html>