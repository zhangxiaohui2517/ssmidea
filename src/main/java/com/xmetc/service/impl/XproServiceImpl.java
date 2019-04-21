package com.xmetc.service.impl;

import com.xmetc.dao.XproDAO;
import com.xmetc.entity.Xpro;
import com.xmetc.service.XproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("xproService")
public class XproServiceImpl implements XproService {

    @Autowired
    private XproDAO xproDAO;

    @Override
    public List<Xpro> getXproAll() {
        return xproDAO.findXproAll();
    }

    @Override
    public int doAddXpro(Xpro xpro) {
        return xproDAO.addXpro(xpro);
    }

    @Override
    public int doUpdateXproById(Xpro xpro) {
        return xproDAO.updateXpro(xpro);
    }

    @Override
    public int doDeleteXproById(int xpid) {
        return xproDAO.deleteXpro(xpid);
    }

    @Override
    public List<Xpro> getXproByPid(int pid) {
        return xproDAO.findXproByPid(pid);
    }

    @Override
    public Xpro getXproByName(String pname) {
        return xproDAO.findXproByName(pname);
    }
}
