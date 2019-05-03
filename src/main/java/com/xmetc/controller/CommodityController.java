package com.xmetc.controller;

import com.xmetc.entity.Commodity;
import com.xmetc.entity.Page;
import com.xmetc.entity.Productcate;
import com.xmetc.entity.Xpro;
import com.xmetc.service.CommodityService;
import com.xmetc.service.ProductcateService;
import com.xmetc.service.XproService;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private ProductcateService productcateService;
    @Autowired
    private XproService xproService;

    //查找所有商品列表
    @RequestMapping("allcommodityadmin")
    @ResponseBody
    public ModelAndView commodityList(){
        ModelAndView mav = new ModelAndView();
        List<Xpro> xprolist = xproService.getXproAll();
        List<Commodity> commoditylist = commodityService.getCommodityAll();
        int selectid = 0;
        mav.setViewName("admincom");
        mav.addObject("commoditylist",commoditylist);
        mav.addObject("xprolist",xprolist);
        mav.addObject("selectid",selectid);
        return mav;
    }

    //查找所有商品列表
    @RequestMapping("commodityadminbyid")
    @ResponseBody
    public ModelAndView commodityadminbyid(@Param("xpid") String xpid){
        ModelAndView mav = new ModelAndView();
        List<Xpro> xprolist = xproService.getXproAll();
        List<Commodity> commoditylist = commodityService.findCommodityByPid(0,1000,Integer.parseInt(xpid));
        int selectid = Integer.parseInt(xpid);
        mav.setViewName("admincom");
        mav.addObject("commoditylist",commoditylist);
        mav.addObject("xprolist",xprolist);
        mav.addObject("selectid",selectid);
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

    //删除商品
    @RequestMapping("deletecommodity")
    @ResponseBody
    public int deleteCommodity(@Param("cid") int cid) {
        return commodityService.doDeleteCommodity(cid);
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


    //添加商品
    @RequestMapping("addcommodity")
    @ResponseBody
    public int update(HttpServletRequest request, Commodity commodity, MultipartFile pictureFile) throws IOException {
        System.out.println("commodity = [" + commodity + "]");
        if (pictureFile != null) {//使用UUID给图片重命名，并去掉四个“-”
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            //获取文件的扩展名
            String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
            //设置图片上传路径
            String url = request.getSession().getServletContext().getRealPath("/resources/static/img");
            System.out.println(url);
            //以绝对路径保存重名命后的图片
            pictureFile.transferTo(new File(url + "/" + name + "." + ext));
            //把图片存储路径保存到数据库
            commodity.setImage(name + "." + ext);
        }

        String detail =xproService.getXproName(commodity.getXpid());
        commodity.setDetail(detail);
        System.out.println("commodity = [" + commodity + "]");
        int i = commodityService.doAddCommodity(commodity);
        System.out.println(i);
        return i;
    }



}
