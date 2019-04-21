package com.xmetc.service.impl;

import com.xmetc.dao.UserDAO;
import com.xmetc.entity.User;
import com.xmetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getUserAll() {
        return userDAO.findUserAll();
    }

    @Override
    public int doAddUser(User user) {
        return userDAO.addUser(user);
    }


    @Override
    public int doUpdateUserById(User user) {
        return userDAO.updateUserById(user);
    }

    @Override
    public int doDeleteUserById(int id) {
        return userDAO.deleteUserById(id);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.findUserById(id);
    }

    @Override
    public User getUserByName(String username) {
        return  userDAO.findUserByName(username);
    }

    @Override
    public User getUserByNameAndPass(String username, String pass) {
        return userDAO.findUserByNameAndPass(username,pass);
    }
}
