package com.xmetc.controller;

import com.xmetc.entity.Order;
import com.xmetc.entity.OrderInfo;
import com.xmetc.entity.Shopcart;
import com.xmetc.entity.User;
import com.xmetc.service.OrderInfoService;
import com.xmetc.service.OrderService;
import com.xmetc.service.ShopcartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopcartService shopcartService;
    @Autowired
    private OrderInfoService orderInfoService;

    //查找所有订单列表
    @RequestMapping("allorder")
    @ResponseBody
    public List<Order> proList() {
        List<Order> orderlist = orderService.getOrderAll();
        return orderlist;
    }

    //id查找订单
    @RequestMapping("findorderbyoid")
    @ResponseBody
    public Order findOrderByOid(@RequestBody int oid) {
        Order order = orderService.getOrderByOid(oid);
        return order;
    }

    //用户id查找订单
    @RequestMapping("findorderbyuid")
    @ResponseBody
    public List<Order> findOrderByUid(@RequestBody int uid) {
        List<Order> orderlist = orderService.getOrderByUid(uid);
        return orderlist;
    }

    //添加订单
    @RequestMapping("addorder")
    @ResponseBody
    public String addOrder(@Param("payment") String payment, HttpSession session) {
        boolean isInsert = false;

        double payment1 = Double.parseDouble(payment);
        int oid = orderService.getMaxOid() +1;
        User user = (User) session.getAttribute("userinfo");
        int uid = user.getId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());
        java.sql.Date createtime = null; //初始化date
        try {
            createtime = new java.sql.Date(df.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Order order = new Order();
        order.setOid(oid);
        order.setUid(uid);
        order.setPayment(payment1);
        order.setPaytype(1);
        order.setCreatetime((java.sql.Date) createtime);
        System.out.println("order" + order);
        int i = orderService.doAddOrder(order);
        int j = 0;
        List<Shopcart> shopcartlist = shopcartService.findShopcart(uid);
        for (Shopcart s: shopcartlist
             ) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOid(oid);
            orderInfo.setCid(s.getCid());
            orderInfo.setCnum(s.getCnum());
            System.out.println("orderInfo="+orderInfo);
            j+=orderInfoService.addOrderInfo(orderInfo);
        }

        if (i != 0 && j !=0){
            int k = shopcartService.deleteShopcartByUid(uid);
            isInsert = true;
            System.out.println("isInsert在if" + isInsert+"K="+k +";uid="+uid);
        }
        System.out.println("isInsert" + isInsert);
        return isInsert ? "success" : "error";
    }

    //删除订单
    @RequestMapping("deleteorder")
    @ResponseBody
    public String deleteOrder(@RequestBody int oid) {
        int i = orderService.doDeleteOrder(oid);
        return i != 0 ? "success" : "error";
    }

    //修改订单
    @RequestMapping("updateorder")
    @ResponseBody
    public String updateOrder(@RequestBody Order order) {
        int i = orderService.doUpdateOrder(order);
        return i != 0 ? "success" : "error";
    }
}
