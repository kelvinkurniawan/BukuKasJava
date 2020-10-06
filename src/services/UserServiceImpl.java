/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.UserDao;
import models.User;

/**
 *
 * @author kelvi
 */
public class UserServiceImpl implements UserService{

    public final UserDao userDao;
    
    /**
     * Implementasi UserService
     * @param userDao 
     */
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
    
    /**
     * Overide getUserByUsername
     * @param username
     * @return userDao.getUserByUsername(username)
     */
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    /**
     * insert
     * @param user
     * @return userDao.insert(user)
     */
    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }
    
}
