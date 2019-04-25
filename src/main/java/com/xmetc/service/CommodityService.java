package com.xmetc.service;

import com.xmetc.entity.Commodity;

import java.util.List;

public interface CommodityService {

    int doAddCommodity(Commodity commodity);
    int doUpdateCommodity(Commodity commodity);
    int doDeleteCommodity(int cid);
    Commodity getCommodityByCid(int cid);
    List<Commodity> getCommodityByName(int i,int j,String title);
    List<Commodity> getCommodityAll();
    List<Commodity> findCommodityByPid(int i,int j,int pid);
    int findNewCont(int pid,String cname);
    List<Commodity> getCommodityAll1(int i,int j);
    int findNewContByname(String cname);
    int findNewContByid(int pid);

}
