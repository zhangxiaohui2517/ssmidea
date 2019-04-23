package com.xmetc.service;

import com.xmetc.entity.OrderInfo;
import com.xmetc.entity.OrderInfoUid;

import java.util.List;

public interface OrderInfoService {

    int addOrderInfo(OrderInfo orderInfo);
   // int updateOrderInfo(OrderInfo orderInfo);
    //int deleteOrderInfo(int oid);
    //OrderInfo findOrderInfoByOiid(int oid);
    List<OrderInfoUid> findOrderInfoAll(int oid);

}
