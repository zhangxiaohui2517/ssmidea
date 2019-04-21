package com.xmetc.controller;

import com.xmetc.entity.Commodity;
import com.xmetc.entity.Productcate;
import com.xmetc.entity.Xpro;
import com.xmetc.service.CommodityService;
import com.xmetc.service.ProductcateService;
import com.xmetc.service.XproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private ProductcateService productcateService;
    @Autowired
    private XproService xproService;
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("index")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        //商品类别展示
        List<Productcate> plist = productcateService.getProAll();
        Map<Integer,List<Xpro>> pmap = new HashMap<>();
        for (Productcate p : plist) {
            List<Xpro> xList = xproService.getXproByPid(p.getPid());
            pmap.put(p.getPid(),xList);
        }
        mav.addObject("plist",plist);
        mav.addObject("pmap",pmap);

        //商品必抢展示
        List<Commodity> commodityList = commodityService.getCommodityAll();
        Collections.shuffle(commodityList);
        mav.addObject("biqianglist",commodityList);

        return mav;
    }

}
