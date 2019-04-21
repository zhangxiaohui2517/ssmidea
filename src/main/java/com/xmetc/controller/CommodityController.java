package com.xmetc.controller;

import com.xmetc.entity.Commodity;
import com.xmetc.entity.Productcate;
import com.xmetc.entity.Xpro;
import com.xmetc.service.CommodityService;
import com.xmetc.service.ProductcateService;
import com.xmetc.service.XproService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private ProductcateService productcateService;
    @Autowired
    private XproService xproService;

    //查找所有商品列表
    @RequestMapping("allcommodity")
    @ResponseBody
    public ModelAndView commodityList(){
        ModelAndView mav = new ModelAndView();


        //商品类别展示
        List<Productcate> plist = productcateService.getProAll();
        Map<Integer,List<Xpro>> pmap = new HashMap<>();
        for (Productcate p : plist) {
            List<Xpro> xList = xproService.getXproByPid(p.getPid());
            pmap.put(p.getPid(),xList);
        }
        mav.addObject("plist",plist);
        mav.addObject("pmap",pmap);
        List<Commodity> commoditylist = commodityService.getCommodityAll();
        mav.setViewName("commodity");
        mav.addObject("commoditylist",commoditylist);
        return mav;
    }

    //查找某一类别商品列表
    @RequestMapping("selectcommodity")
    @ResponseBody
    public ModelAndView selectcommodity(@Param("pid") String pid ){
        ModelAndView mav = new ModelAndView();


        //商品类别展示
        List<Productcate> plist = productcateService.getProAll();
        Map<Integer,List<Xpro>> pmap = new HashMap<>();
        for (Productcate p : plist) {
            List<Xpro> xList = xproService.getXproByPid(p.getPid());
            pmap.put(p.getPid(),xList);
        }
        mav.addObject("plist",plist);
        mav.addObject("pmap",pmap);
        List<Commodity> commoditylist = commodityService.findCommodityByPid(Integer.parseInt(pid));
        mav.setViewName("commodity");
        mav.addObject("commoditylist",commoditylist);
        return mav;
    }


    //搜索商品列表
    @RequestMapping("selectgoodbyname")
    @ResponseBody
    public ModelAndView selectgoodbyname(@Param("title") String title ){
        ModelAndView mav = new ModelAndView();


        //商品类别展示
        List<Productcate> plist = productcateService.getProAll();
        Map<Integer,List<Xpro>> pmap = new HashMap<>();
        for (Productcate p : plist) {
            List<Xpro> xList = xproService.getXproByPid(p.getPid());
            pmap.put(p.getPid(),xList);
        }
        mav.addObject("plist",plist);
        mav.addObject("pmap",pmap);
        List<Commodity> commoditylist = commodityService.getCommodityByName(title);
        mav.setViewName("commodity");
        mav.addObject("commoditylist",commoditylist);
        return mav;
    }




    //id查找商品
    @RequestMapping("findcommoditybycid")
    @ResponseBody
    public Commodity findCommodityByCid(@RequestBody int cid){
        Commodity commodity= commodityService.getCommodityByCid(cid);
        return commodity;
    }

    //商品名查找商品
    @RequestMapping("findorderbyname")
    @ResponseBody
    public List<Commodity> findCommodityByUid(@RequestBody String cname){
        List<Commodity> commoditylist= commodityService.getCommodityByName(cname);
        return commoditylist;
    }

    //添加商品
    @RequestMapping("addcommodity")
    @ResponseBody
    public String addCommodity(@RequestBody Commodity commodity) {
        int i = commodityService.doAddCommodity(commodity);
        return i!=0?"success":"error";
    }

    //删除商品
    @RequestMapping("deletecommodity")
    @ResponseBody
    public String deleteCommodity(@RequestBody int cid) {
        int i = commodityService.doDeleteCommodity(cid);
        return i!=0?"success":"error";
    }

    //修改商品
    @RequestMapping("updatecommodity")
    @ResponseBody
    public String updateCommodity(@RequestBody Commodity commodity) {
        int i = commodityService.doUpdateCommodity(commodity);
        return i!=0?"success":"error";
    }
}
