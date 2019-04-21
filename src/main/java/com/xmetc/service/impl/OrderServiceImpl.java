package com.xmetc.service.impl;

import com.xmetc.dao.OrderDAO;
import com.xmetc.entity.Order;
import com.xmetc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public int doAddOrder(Order order) {
        return orderDAO.addOrder(order);
    }

    @Override
    public int doUpdateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public int doDeleteOrder(int oid) {
        return orderDAO.deleteOrder(oid);
    }

    @Override
    public Order getOrderByOid(int oid) {
        return orderDAO.findOrderByOid(oid);
    }

    @Override
    public List<Order> getOrderByUid(int uid) {
        return orderDAO.findOrderByUid(uid);
    }

    @Override
    public List<Order> getOrderAll() {
        return orderDAO.findOrderAll();
    }
}
