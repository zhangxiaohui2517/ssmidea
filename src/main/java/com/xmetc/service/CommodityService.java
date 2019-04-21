package com.xmetc.service;

import com.xmetc.entity.Commodity;

import java.util.List;

public interface CommodityService {

    int doAddCommodity(Commodity commodity);
    int doUpdateCommodity(Commodity commodity);
    int doDeleteCommodity(int cid);
    Commodity getCommodityByCid(int cid);
    List<Commodity> getCommodityByName(String title);
    List<Commodity> getCommodityAll();
    List<Commodity> findCommodityByPid(int pid);

}
