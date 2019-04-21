package com.xmetc.controller;

import com.xmetc.entity.*;
import com.xmetc.service.CommodityService;
import com.xmetc.service.ProductcateService;
import com.xmetc.service.ShopcartService;
import com.xmetc.service.XproService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShopcartController {
    @Autowired
    private ShopcartService shopcartService;

    //查找购物车列表
    @RequestMapping("shopcart")
    @ResponseBody
    public ModelAndView shopcart(@Param("id") String id ){
        System.out.println("gouwu id :"+id);
        ModelAndView mav = new ModelAndView();
        List<Shopcart> shopcartlist = shopcartService.findShopcart(Integer.parseInt(id));
        double allprice = 0.00;
        for (Shopcart s:shopcartlist
             ) {
            allprice +=s.getCprice()*s.getCnum();
        }
        mav.addObject("shopcartlist",shopcartlist);
        mav.addObject("allprice",allprice);
        mav.setViewName("shopcart");

        return mav;
    }

    //修改数量
    @RequestMapping("changecnum")
    @ResponseBody
    public int changecnum(@Param("sid") String sid,@Param("cnum") String cnum ) {

        System.out.println("sid:"+sid+",cnum:"+cnum);
        int i = shopcartService.updateShopcartCnum(Integer.parseInt(sid),Integer.parseInt(cnum));
        System.out.println("i=" + i);
        return i;
    }

    //删除
    @RequestMapping("deleteshopcartbyid")
    @ResponseBody
    public int deleteshopcartbyid(@Param("sid") String sid) {


        int i = shopcartService.deleteShopcartById(Integer.parseInt(sid));
        System.out.println("i=" + i);
        return i;
    }

    //添加购物车
    @RequestMapping("addshopcart")
    @ResponseBody
    public int addshopcart(@Param("cid") String cid, @Param("cnum") String cnum, HttpSession session) {
        User user = (User) session.getAttribute("userinfo");
        int uid = user.getId();
        int i = shopcartService.addShopcart(uid,Integer.parseInt(cid),Integer.parseInt(cnum));
        System.out.println("i=" + i);
        return i;
    }


}
