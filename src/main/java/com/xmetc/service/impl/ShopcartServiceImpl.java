package com.xmetc.service.impl;

import com.xmetc.dao.ShopcartDAO;
import com.xmetc.entity.Shopcart;
import com.xmetc.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopcartService")
public class ShopcartServiceImpl implements ShopcartService {
    @Autowired
    ShopcartDAO shopcartDAO;

    @Override
    public int addShopcart(int uid, int cid, int cnum) {
        return shopcartDAO.addShopcart(uid,cid,cnum);
    }

    @Override
    public int updateShopcartCnum(int sid, int cnum) {
        return shopcartDAO.updateShopcartCnum(sid,cnum);
    }

    @Override
    public int deleteShopcartById(int sid) {
        return shopcartDAO.deleteShopcartById(sid);
    }

    @Override
    public List<Shopcart> findShopcart(int uid) {
        return shopcartDAO.findShopcart(uid);
    }

    @Override
    public int deleteShopcartByUid(int uid) {
        return shopcartDAO.deleteShopcartByUid(uid);
    }
}
