package com.xmetc.controller;

import com.xmetc.entity.Order;
import com.xmetc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    //查找所有订单列表
    @RequestMapping("allorder")
    @ResponseBody
    public List<Order> proList(){
        List<Order> orderlist = orderService.getOrderAll();
        return orderlist;
    }

    //id查找订单
    @RequestMapping("findorderbyoid")
    @ResponseBody
    public Order findOrderByOid(@RequestBody int oid){
        Order order= orderService.getOrderByOid(oid);
        return order;
    }

    //用户id查找订单
    @RequestMapping("findorderbyuid")
    @ResponseBody
    public List<Order> findOrderByUid(@RequestBody int uid){
        List<Order> orderlist= orderService.getOrderByUid(uid);
        return orderlist;
    }

    //添加订单
    @RequestMapping("addorder")
    @ResponseBody
    public String addOrder(@RequestBody Order order) {
        int i = orderService.doAddOrder(order);
        return i!=0?"success":"error";
    }

    //删除订单
    @RequestMapping("deleteorder")
    @ResponseBody
    public String deleteOrder(@RequestBody int oid) {
        int i = orderService.doDeleteOrder(oid);
        return i!=0?"success":"error";
    }

    //修改订单
    @RequestMapping("updateorder")
    @ResponseBody
    public String updateOrder(@RequestBody Order order) {
        int i = orderService.doUpdateOrder(order);
        return i!=0?"success":"error";
    }
}
