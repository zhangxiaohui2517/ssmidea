package com.xmetc.service.impl;

import com.xmetc.dao.OrderInfoDAO;
import com.xmetc.entity.OrderInfo;
import com.xmetc.entity.OrderInfoUid;
import com.xmetc.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderInfoService")
public class OrderInfoImpl implements OrderInfoService {
    @Autowired
    private OrderInfoDAO orderInfoDAO;

    @Override
    public int addOrderInfo(OrderInfo orderInfo) {
        return orderInfoDAO.addOrderInfo(orderInfo);
    }

    @Override
    public List<OrderInfoUid> findOrderInfoAll(int oid) {
        return orderInfoDAO.findOrderInfoAll(oid);
    }

}
