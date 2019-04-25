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
    public List<Commodity> getCommodityByName(int i,int j,String title) {
        return commodityDAO.findCommodityByName(i,j,title);
    }

    @Override
    public List<Commodity> getCommodityAll() {
        return commodityDAO.findCommodityAll();
    }

    @Override
    public List<Commodity> findCommodityByPid(int i,int j,int pid) {
        return commodityDAO.findCommodityByPid(i,j,pid);
    }

    @Override
    public int findNewCont(int pid, String cname) {
        return commodityDAO.findNewCont(pid,cname);
    }

    @Override
    public List<Commodity> getCommodityAll1(int i, int j) {
        return commodityDAO.getCommodityAll1(i,j);
    }

    @Override
    public int findNewContByname(String cname) {
        return commodityDAO.findNewContByname(cname);
    }

    @Override
    public int findNewContByid(int pid) {
        return commodityDAO.findNewContByid(pid);
    }
}
