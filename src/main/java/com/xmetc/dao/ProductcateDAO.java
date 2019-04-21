package com.xmetc.dao;

import com.xmetc.entity.Productcate;

import java.util.List;

public interface ProductcateDAO {

    int addPro(Productcate productcate);
    int updatePro(Productcate productcate);
    int deletePro(int pid);
    Productcate findProByid(int pid);
    Productcate findProByName(String pname);
    List<Productcate> findProAll();

}
