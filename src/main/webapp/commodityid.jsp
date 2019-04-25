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
            <a href="index.do">首页</a>
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


<div class="content content-nav-base commodity-content">
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
    <div class="commod-cont-wrap">
        <div class="commod-cont w1200 layui-clear">
            <div class="left-nav">
                <div class="title">所有分类</div>

                <div class="list-box">
                    <c:forEach items="${plist}" var="p">
                        <c:set var="pid" value="${p.pid}"/>
                        <dl>
                            <dt>${p.pname}</dt>
                            <c:forEach items="${pmap[pid]}" var="xp">
                                <dd><a href="selectcommodity.do?pid=${xp.xpid}">${xp.xpname}</a></dd>
                            </c:forEach>
                        </dl>
                    </c:forEach>
                </div>

            </div>

            <div class="right-cont-wrap">
                <div class="right-cont">
                    <div class="cont-list layui-clear" id="list-cont">

                        <c:forEach items="${commoditylist}" var="b">
                            <div class="item">
                                <div class="img">
                                    <a href="selectgoodbyid.do?cid=${b.cid}"><img style="width: 160px;height: 180px"
                                                                                  src="<c:url value="/resources/static/img/${b.image}"/>"></a>
                                </div>
                                <div class="text">
                                    <p class="title">${b.cname}</p>
                                    <p class="price">
                                        <span class="pri">￥${b.price}</span>
                                    </p>
                                </div>

                            </div>

                        </c:forEach>


                    </div>
                    <div class="pager">
                        <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                        ${page.pageNow} 页</font> <a href="selectcommodity.do?pageNow=1&pid=${pppid}">首页</a>
                        <c:choose>
                            <c:when test="${page.pageNow - 1 > 0}">
                                <a href="selectcommodity.do?pageNow=${page.pageNow - 1}&pid=${pppid}">上一页</a>
                            </c:when>
                            <c:when test="${page.pageNow - 1 <= 0}">
                                <a href="selectcommodity.do?pageNow=1&pid=${pppid}">上一页</a>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${page.totalPageCount==0}">
                                <a href="selectcommodity.do?pageNow=${page.pageNow}&pid=${pppid}">下一页</a>
                            </c:when>
                            <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                                <a href="selectcommodity.do?pageNow=${page.pageNow + 1}&pid=${pppid}">下一页</a>
                            </c:when>
                            <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                                <a href="selectcommodity.do?pageNow=${page.totalPageCount}&pid=${pppid}">下一页</a>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${page.totalPageCount==0}">
                                <a href="selectcommodity.do?pageNow=${page.pageNow}&pid=${pppid}">尾页</a>
                            </c:when>
                            <c:otherwise>
                                <a href="selectcommodity.do?pageNow=${page.totalPageCount}&pid=${pppid}">尾页</a>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <!-- 模版引擎导入 -->
                    <!-- <script type="text/html" id="demo">
                      {{# layui.each(d.menu.milk.content,function(index,item){}}
                        <div class="item">
                          <div class="img">
                            <a href="javascript:;"><img src="{{item.img}}"></a>
                          </div>
                          <div class="text">
                            <p class="title"></p>
                            <p class="price">
                              <span class="pri">{{item.pri}}</span>
                              <span class="nub">{{item.nub}}</span>
                            </p>
                          </div>
                        </div>
                      {{# }); }}
                    </script> -->
                    <%--<div id="demo0" style="text-align: center;"></div>--%>
                </div>
            </div>
        </div>
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


<script>

    layui.config({
        base: '<c:url value="/resources/static/js/util/"/>'  //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm', 'laypage', 'jquery'], function () {
        var laypage = layui.laypage, $ = layui.$,
            mm = layui.mm;
        laypage.render({
            elem: 'demo0'
            , count: 1000 //数据总数
        });


        // 模版引擎导入
        //  var html = demo.innerHTML;
        //  var listCont = document.getElementById('list-cont');
        //  // console.log(layui.router("#/about.html"))
        // mm.request({
        //     url: '../json/commodity.json',
        //     success : function(res){
        //       console.log(res)
        //       listCont.innerHTML = mm.renderHtml(html,res)
        //     },
        //     error: function(res){
        //       console.log(res);
        //     }
        //   })

        $('.sort a').on('click', function () {
            $(this).addClass('active').siblings().removeClass('active');
        })
        $('.list-box dt').on('click', function () {
            if ($(this).attr('off')) {
                $(this).removeClass('active').siblings('dd').show()
                $(this).attr('off', '')
            } else {
                $(this).addClass('active').siblings('dd').hide()
                $(this).attr('off', true)
            }
        })

    });
</script>


</body>
</html>
