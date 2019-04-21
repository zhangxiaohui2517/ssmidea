package com.xmetc.dao;

import com.xmetc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {

    int addUser(User user);
    int updateUserById(User user);
    int deleteUserById(int id);
    User findUserById(int id);
    User findUserByName(String username);
    User findUserByNameAndPass(String username,String pass);
    List<User> findUserAll();


}
