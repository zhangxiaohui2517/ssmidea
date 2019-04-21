package com.xmetc.dao;

import com.xmetc.entity.Order;

import java.util.List;

public interface OrderDAO {

    int addOrder(Order order);
    int updateOrder(Order order);
    int deleteOrder(int oid);
    Order findOrderByOid(int oid);
    List<Order> findOrderByUid(int uid);
    List<Order> findOrderAll();
    int getMaxOid();

}
