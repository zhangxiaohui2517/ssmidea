package com.xmetc;

import com.xmetc.entity.User;
import com.xmetc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        Date date = new Date(1);

        User user = new User(0, "a1", "b1", "男", null
                , "13959251578", "1005084830@qq.com", null);
        int i=userService.doAddUser(user);
        System.out.println("插入了"+i+"条记录");

//        User user =null;
//        user=userService.getUserByName("test");
//        int i = user==null?0:1;
//        System.out.println("查找到了"+i+"条记录");
    }


    @Test
    public void testFindUserById() {
        User user = userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUserById() {
        Date date = new Date(1);

        User user = new User(2, "sb", "sb", "nv", date
                , "13959251578", "1005084830@qq.com", null);
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("sb2");
        user1.setHphoto("1.jpg");
        int i=userService.doUpdateUserById(user1);
        System.out.println("修改了"+i+"条记录");
    }

    @Test
    public void testDeleteUserById() {
        int i= userService.doDeleteUserById(3);
        System.out.println("删除了"+i+"条记录");
    }

    @Test
    public void testFindUser() {
        List<User> userList = userService.getUserAll();
        System.out.println(userList);
    }

}
