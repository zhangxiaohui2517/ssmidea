package com.xmetc.service.impl;

import com.xmetc.dao.CommodityDAO;
import com.xmetc.entity.Commodity;
import com.xmetc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDAO commodityDAO;

    @Override
    public int doAddCommodity(Commodity commodity) {
        return commodityDAO.addCommodity(commodity);
    }

    @Override
    public int doUpdateCommodity(Commodity commodity) {
        return commodityDAO.updateCommodity(commodity);
    }

    @Override
    public int doDeleteCommodity(int cid) {
        return commodityDAO.deleteCommodity(cid);
    }

    @Override
    public Commodity getCommodityByCid(int cid) {
        return commodityDAO.findCommodityByOid(cid);
    }

    @Override
    public List<Commodity> getCommodityByName(String title) {
        return commodityDAO.findCommodityByName(title);
    }

    @Override
    public List<Commodity> getCommodityAll() {
        return commodityDAO.findCommodityAll();
    }

    @Override
    public List<Commodity> findCommodityByPid(int pid) {
        return commodityDAO.findCommodityByPid(pid);
    }
}
