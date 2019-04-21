package com.xmetc.controller;

import com.xmetc.entity.Productcate;
import com.xmetc.service.ProductcateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProducateController {
    @Autowired
    private ProductcateService productcateService;

    //查找所有商品类别列表
    @RequestMapping("allpro")
    @ResponseBody
    public List<Productcate> proList(){
        List<Productcate> prolist = productcateService.getProAll();
        return prolist;
    }

    //id查找商品类别
    @RequestMapping("findprobyid")
    @ResponseBody
    public Productcate findProById(@RequestBody int pid){
        Productcate productcate= productcateService.getProById(pid);
        return productcate;
    }

    //添加商品类别
    @RequestMapping("addpro")
    @ResponseBody
    public String addPro(@RequestBody Productcate productcate) {
        int i = productcateService.doAddPro(productcate);
        return i!=0?"success":"error";
    }

    //删除商品类别
    @RequestMapping("deletepro")
    @ResponseBody
    public String deletePro(@RequestBody int pid) {
        int i = productcateService.doDeleteProById(pid);
        return i!=0?"success":"error";
    }

    //修改商品类别
    @RequestMapping("updatepro")
    @ResponseBody
    public String updatePro(@RequestBody Productcate productcate) {
        int i = productcateService.doUpdateProById(productcate);
        return i!=0?"success":"error";
    }

    //test
    @RequestMapping("test")
    @ResponseBody
    public String test(@RequestBody Productcate productcate) {
        int i = productcateService.doUpdateProById(productcate);
        return i!=0?"success":"error";
    }
}
