package com.xmetc.service;

import com.xmetc.entity.Productcate;

import java.util.List;

public interface ProductcateService {
    List<Productcate> getProAll();
    int doAddPro(Productcate productcate);
    int doUpdateProById(Productcate productcate);
    int doDeleteProById(int pid);
    Productcate getProById(int pid);
    Productcate getProByName(String pname);
}
