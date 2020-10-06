/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.SQLException;
import models.User;
import services.UserService;
import services.UserServiceImpl;

import utils.modules.Encryption;
import utils.modules.JdbcUtils;
import utils.modules.SessionManager;
import views.Home;
/**
 *
 * @author kelvi
 */
public class AuthenticationController {
    
    UserService userService;
    
    public AuthenticationController(){
        userService = new UserServiceImpl(JdbcUtils.getUserDao());
    }
 
    public boolean login(String username, String password){
        
        
        if(userService.getUserByUsername(username) != null){
            if(Encryption.getDecrypt(userService.getUserByUsername(username).getPassword()).equals(password)){

                System.out.println(SessionManager.userId);

                SessionManager.userId = userService.getUserByUsername(username).getUserId();
                SessionManager.name = userService.getUserByUsername(username).getName();
                
                new Home().setVisible(true);
                
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        
    }
    
    public boolean register(String name, String email, String phone, String username, String password){       
        
        User user = new User(0, name, email, username, Encryption.getEncrypt(password), phone);
        
        return userService.insert(user);
        
    }
            
}
