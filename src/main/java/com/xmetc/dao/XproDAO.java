package com.xmetc.dao;


import com.xmetc.entity.Xpro;

import java.util.List;

public interface XproDAO {

    int addXpro(Xpro xpro);
    int updateXpro(Xpro xpro);
    int deleteXpro(int xpid);
    List<Xpro> findXproByPid(int pid);
    Xpro findXproByName(String xpname);
    List<Xpro> findXproAll();

}
