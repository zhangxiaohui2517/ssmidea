package com.xmetc.service.impl;

import com.xmetc.dao.ProductcateDAO;
import com.xmetc.entity.Productcate;
import com.xmetc.service.ProductcateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productcateService")
public class ProductcateServiceImpl implements ProductcateService {
    @Autowired
    private ProductcateDAO productcateDAO;

    @Override
    public List<Productcate> getProAll() {
        return productcateDAO.findProAll();
    }

    @Override
    public int doAddPro(Productcate productcate) {
        return productcateDAO.addPro(productcate);
    }

    @Override
    public int doUpdateProById(Productcate productcate) {
        return productcateDAO.updatePro(productcate);
    }

    @Override
    public int doDeleteProById(int pid) {
        return productcateDAO.deletePro(pid);
    }

    @Override
    public Productcate getProById(int pid) {
        return productcateDAO.findProByid(pid);
    }

    @Override
    public Productcate getProByName(String pname) {
        return productcateDAO.findProByName(pname);
    }
}
