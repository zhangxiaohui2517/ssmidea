package com.xmetc.dao;

import com.xmetc.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityDAO {
    int addCommodity(Commodity commodity);
    int updateCommodity(Commodity commodity);
    int deleteCommodity(int cid);
    Commodity findCommodityByOid(int cid);
    List<Commodity> findCommodityByName(int i,int j,@Param("title") String title);
    List<Commodity> findCommodityAll();
    List<Commodity> findCommodityByPid(int i,int j,@Param("xpid")int pid);
    int findNewCont(int pid,String cname);
    List<Commodity> getCommodityAll1(int i,int j);

    int findNewContByname(@Param("cname") String cname);
    int findNewContByid(@Param("xpid") int xpid);
}
