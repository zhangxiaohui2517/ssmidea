package com.xmetc.controller;

import com.xmetc.entity.Commodity;
import com.xmetc.entity.Page;
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

import java.util.ArrayList;
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
    @RequestMapping("allcommodity1")
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
    public ModelAndView selectcommodity(@Param("pageNow") String pageNow,@Param("pid") String pid ){
        ModelAndView mav = new ModelAndView();

        mav.addObject("pppid",pid);
        //获取总页数
        int totalCount=(int)commodityService.findNewContByid(Integer.parseInt(pid));
        Page page=null;
        List<Commodity> commoditylist=new ArrayList<Commodity>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            commoditylist=commodityService.findCommodityByPid(page.getStartPos(),page.getPageSize(),Integer.parseInt(pid));
        }else {
            page=new Page(1, totalCount);
            commoditylist=commodityService.findCommodityByPid(page.getStartPos(),page.getPageSize(),Integer.parseInt(pid));
        }

        mav.addObject("commoditylist",commoditylist);
        mav.addObject("page",page);




        //商品类别展示
        List<Productcate> plist = productcateService.getProAll();
        Map<Integer,List<Xpro>> pmap = new HashMap<>();
        for (Productcate p : plist) {
            List<Xpro> xList = xproService.getXproByPid(p.getPid());
            pmap.put(p.getPid(),xList);
        }
        mav.addObject("plist",plist);
        mav.addObject("pmap",pmap);
        mav.setViewName("commodityid");

        return mav;
    }



//    //查找某一类别商品列表
//    @RequestMapping("selectcommodity")
//    @ResponseBody
//    public ModelAndView selectcommodity(@Param("pid") String pid ){
//        ModelAndView mav = new ModelAndView();
//
//
//        //商品类别展示
//        List<Productcate> plist = productcateService.getProAll();
//        Map<Integer,List<Xpro>> pmap = new HashMap<>();
//        for (Productcate p : plist) {
//            List<Xpro> xList = xproService.getXproByPid(p.getPid());
//            pmap.put(p.getPid(),xList);
//        }
//        mav.addObject("plist",plist);
//        mav.addObject("pmap",pmap);
//        List<Commodity> commoditylist = commodityService.findCommodityByPid(Integer.parseInt(pid));
//        mav.setViewName("commodity");
//        mav.addObject("commoditylist",commoditylist);
//        return mav;
//    }

    //搜索商品列表
    @RequestMapping("selectgoodbyname")
    @ResponseBody
    public ModelAndView selectgoodbyname(@Param("pageNow") String pageNow,@Param("title") String title ){
        ModelAndView mav = new ModelAndView();
        mav.addObject("title",title);

        //获取总页数
        int totalCount=(int)commodityService.findNewContByname(title);
        System.out.println("totalCount="+totalCount);
        Page page=null;
        List<Commodity> commoditylist=new ArrayList<Commodity>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            commoditylist=commodityService.getCommodityByName(page.getStartPos(),page.getPageSize(),title);
        }else {
            page=new Page(1, totalCount);
            commoditylist=commodityService.getCommodityByName(page.getStartPos(),page.getPageSize(),title);
        }

        mav.addObject("commoditylist",commoditylist);
        mav.addObject("page",page);




        //商品类别展示
        List<Productcate> plist = productcateService.getProAll();
        Map<Integer,List<Xpro>> pmap = new HashMap<>();
        for (Productcate p : plist) {
            List<Xpro> xList = xproService.getXproByPid(p.getPid());
            pmap.put(p.getPid(),xList);
        }
        mav.addObject("plist",plist);
        mav.addObject("pmap",pmap);
        mav.setViewName("commodityname");

        return mav;
    }



//
//    //搜索商品列表
//    @RequestMapping("selectgoodbyname")
//    @ResponseBody
//    public ModelAndView selectgoodbyname(@Param("title") String title ){
//        ModelAndView mav = new ModelAndView();
//        //商品类别展示
//        List<Productcate> plist = productcateService.getProAll();
//        Map<Integer,List<Xpro>> pmap = new HashMap<>();
//        for (Productcate p : plist) {
//            List<Xpro> xList = xproService.getXproByPid(p.getPid());
//            pmap.put(p.getPid(),xList);
//        }
//        mav.addObject("plist",plist);
//        mav.addObject("pmap",pmap);
//        System.out.println("title = [" + title + "]");
//        List<Commodity> commoditylist = commodityService.getCommodityByName(title);
//        System.out.println("commoditylist =" + commoditylist);
//        mav.addObject("commoditylist",commoditylist);
//        mav.setViewName("commodity");
//
//        return mav;
//    }

    //商品详情
    @RequestMapping("selectgoodbyid")
    @ResponseBody
    public ModelAndView selectgoodbyid(@Param("cid") String cid ){
        ModelAndView mav = new ModelAndView();
        Commodity commodity = commodityService.getCommodityByCid(Integer.parseInt(cid));
        mav.addObject("commodity",commodity);
        mav.setViewName("details");
        return mav;
    }


    //id查找商品
    @RequestMapping("findcommoditybycid")
    @ResponseBody
    public Commodity findCommodityByCid(@RequestBody int cid){
        Commodity commodity= commodityService.getCommodityByCid(cid);
        return commodity;
    }

//    //商品名查找商品
//    @RequestMapping("findorderbyname")
//    @ResponseBody
//    public List<Commodity> findCommodityByUid(@RequestBody String cname){
//        List<Commodity> commoditylist= commodityService.getCommodityByName(cname);
//        return commoditylist;
//    }

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


    //查找所有商品列表
    @RequestMapping("allcommodity")
    @ResponseBody
    public ModelAndView commodityList1(@Param("pageNow") String pageNow){
        ModelAndView mav = new ModelAndView();


        //获取总页数
        int totalCount=(int)commodityService.findNewCont(0,null);
        Page page=null;
        List<Commodity> commoditylist=new ArrayList<Commodity>();
        if (pageNow!=null) {
            page=new Page(Integer.parseInt(pageNow), totalCount);
            commoditylist=commodityService.getCommodityAll1(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            commoditylist=commodityService.getCommodityAll1(page.getStartPos(),page.getPageSize());
        }

        mav.addObject("commoditylist",commoditylist);
        mav.addObject("page",page);




        //商品类别展示
        List<Productcate> plist = productcateService.getProAll();
        Map<Integer,List<Xpro>> pmap = new HashMap<>();
        for (Productcate p : plist) {
            List<Xpro> xList = xproService.getXproByPid(p.getPid());
            pmap.put(p.getPid(),xList);
        }
        mav.addObject("plist",plist);
        mav.addObject("pmap",pmap);
        mav.setViewName("commodity");

        return mav;
    }
}
