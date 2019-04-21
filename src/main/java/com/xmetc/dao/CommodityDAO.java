package com.xmetc.dao;

import com.xmetc.entity.Commodity;

import java.util.List;

public interface CommodityDAO {
    int addCommodity(Commodity commodity);
    int updateCommodity(Commodity commodity);
    int deleteCommodity(int cid);
    Commodity findCommodityByOid(int cid);
    List<Commodity> findCommodityByName(String title);
    List<Commodity> findCommodityAll();
    List<Commodity> findCommodityByPid(int pid);

}
