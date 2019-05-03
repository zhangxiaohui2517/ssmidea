package com.xmetc.service;

import com.xmetc.entity.Xpro;

import java.util.List;

public interface XproService {
    List<Xpro> getXproAll();
    int doAddXpro(Xpro xpro);
    int doUpdateXproById(Xpro xpro);
    int doDeleteXproById(int xpid);
    List<Xpro> getXproByPid(int pid);
    Xpro getXproByName(String pname);
    String getXproName(int xpid);
}
