package com.xmetc.controller;

import com.xmetc.entity.User;
import com.xmetc.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Length;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //查找所有用户
    @RequestMapping("alluser")
    @ResponseBody
    public List<User> userList() {
        List<User> userList = userService.getUserAll();
        System.out.println(userList);
        return userList;
    }

    //登录用户密码检测
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView checklogin(@Param("username") String username, @Param("password") String password, HttpSession session) {

        ModelAndView mav = null;
        User user = userService.getUserByNameAndPass(username, password);

        if (user ==null){
            mav = new ModelAndView("login");
            mav.addObject("rs","用户名或密码错误");
            return mav;
        }else {
            mav = new ModelAndView("redirect:index.do");
            session.setAttribute("userinfo",user);
            System.out.println("登录用户id"+user.getId());
            return mav;
        }

    }

    //退出登录
    @RequestMapping("loginout")
    @ResponseBody
    public int loginOut(HttpSession session) {
        User user = new User();
        session.setAttribute("userinfo",user);
        return 1;
    }

    //检测是否唯一
    @RequestMapping("checkname")
    @ResponseBody
    public int checkname(@RequestBody String username) {

        String username1 = username.substring(0,username.length()-1);
        System.out.println("检查用户名"+username1+"开始搜索");
        User user= userService.getUserByName(username1);
        System.out.println("检查结果"+user);
        return user==null?0:1;
    }


    //添加用户  注册用户
    @RequestMapping("register")
    @ResponseBody
    public int Register(@RequestBody User user) {

        System.out.println(user);

        return userService.doAddUser(user);
    }

    //删除用户
    @RequestMapping("deleteuser")
    @ResponseBody
    public String DeleteUser(@RequestBody int id) {
        int i = userService.doDeleteUserById(id);
        return i!=0?"success":"error";
    }

    //修改用户 修改个人信息
    @RequestMapping("updateuser")
    @ResponseBody
    public User ChangeUser(@RequestBody User user1) {
        int i = userService.doUpdateUserById(user1);
        return i!=0?user1:null;
    }





//    @RequestMapping("checklogin")
//    @ResponseBody
//    public User testheck(@RequestBody User user1) {
//        User user = userService.getUserByNameAndPass(user1.getUsername(), user1.getPassword());
//        System.out.println(user1.getUsername() + "," + user1.getPassword());
//        System.out.println("user="+user);
//        return user;
//    }
//
//    @RequestMapping("login1")
//    @ResponseBody
//    public User findStudent(int id) {
//        User user = userService.getUserById(id);
//        System.out.println(user);
//        return user;
//    }
//
//    @RequestMapping("login")
//    public String find(int id) {
//        //User user = userService.getUserById(id);
//        //System.out.println("运行后user="+user);
//        System.out.println("user="+userService.getUserAll());
//        return "all.jsp";
//    }
//
//
//    @RequestMapping("stu")
//    @ResponseBody
//    public ModelAndView findUserByNameAndPass(@Param("username") String username, @Param("password") String password) {
//        ModelAndView mav = new ModelAndView();
//        User user = userService.getUserByNameAndPass(username, password);
//        System.out.println(username + "," + password);
//        if (user != null) {
//            mav.setViewName("loginsuccess");
//            List<User> userList = userService.getUserAll();
//            mav.addObject("user", user);
//            mav.addObject("userList", userList);
//            return mav;
//        } else {
//            mav.setViewName("loginfail");
//            mav.addObject("user", user);
//            System.out.println(user);
//            return mav;
//        }
//    }
//
//    @RequestMapping("selectById")
//    public ModelAndView findUserById(int id) {
//        ModelAndView mav = new ModelAndView();
//        User user = userService.getUserById(id);
//        mav.setViewName("update");
//        mav.addObject("user", user);
//        System.out.println(user);
//        return mav;
//
//    }

//    @RequestMapping("login")
//    @ResponseBody
//    public ModelAndView checkUser(@RequestBody User user) {
//        ModelAndView mav = new ModelAndView();
//        User user1 = userService.getUserByNameAndPass(user.getUsername(),user.getPassword());
//        if (user1 != null) {
//            mav.setViewName("loginsuccess");
//            List<User> userList = userService.getUserAll();
//            mav.addObject("userList", userList);
//            return mav;
//        }
//        return null;
//
//    }

/*
    @RequestMapping("reg1")
    public String addUser1(HttpServletRequest request, User user, MultipartFile pictureFile) throws IOException {
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        //设置图片上传路径
        String url = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(url);
        //以绝对路径保存重名命后的图片
        pictureFile.transferTo(new File(url + "/" + name + "." + ext));
        //把图片存储路径保存到数据库
        user.setPhoto("upload/" + name + "." + ext);

        userService.doAddUser(user);
        //重定向到查询所有用户的Controller，测试图片回显
        return "login";

    }
*/
    @RequestMapping("updateuserinfo")
    public String update(HttpServletRequest request, User user, MultipartFile pictureFile,HttpSession session) throws IOException {

        if (pictureFile != null) {//使用UUID给图片重命名，并去掉四个“-”
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            //获取文件的扩展名
            String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
            //设置图片上传路径
            String url = request.getSession().getServletContext().getRealPath("/upload");
            System.out.println(url);
            //以绝对路径保存重名命后的图片
            pictureFile.transferTo(new File(url + "/" + name + "." + ext));
            //把图片存储路径保存到数据库
            User user1 = (User) session.getAttribute("userinfo");
            user.setId(user1.getId());
            user.setHphoto("upload/" + name + "." + ext);
        }

        int i = userService.doUpdateUserById(user);
        System.out.println(i);
        session.setAttribute("userinfo",user);
        return "user";


    }


}
