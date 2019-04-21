package com.xmetc;

import com.xmetc.entity.User;
import com.xmetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    private static UserService userService;



    public static void main(String[] args) {
//        User user= userService.getUserById(1);
//        System.out.println(user);

        try{
            ab();
        }catch (Exception e){
            System.out.println("2");
        }
        System.out.println("3");
    }

    private static void ab() throws Exception{
        try {
            throw new Exception();
        }finally {
            System.out.println("1");
        }
    }


}
