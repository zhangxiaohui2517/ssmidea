package com.xmetc.service;

import com.xmetc.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserAll();
    int doAddUser(User user);
    int doUpdateUserById(User user);
    int doDeleteUserById(int id);
    User getUserById(int id);
    User getUserByName(String username);
    User getUserByNameAndPass(String username,String pass);
}
