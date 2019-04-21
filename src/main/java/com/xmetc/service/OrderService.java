package com.xmetc.service;

import com.xmetc.entity.Order;

import java.util.List;

public interface OrderService {

    int doAddOrder(Order order);
    int doUpdateOrder(Order order);
    int doDeleteOrder(int oid);
    Order getOrderByOid(int oid);
    List<Order> getOrderByUid(int uid);
    List<Order> getOrderAll();

}
