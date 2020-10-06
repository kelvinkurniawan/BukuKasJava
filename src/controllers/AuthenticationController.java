/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.SQLException;
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
 
    public void login(String username, String password){
        
        
        if(userService.getUserByUsername(username) != null){
            if(Encryption.getDecrypt(userService.getUserByUsername(username).getPassword()).equals(password)){

                System.out.println(SessionManager.userId);

                SessionManager.userId = userService.getUserByUsername(username).getUserId();
                SessionManager.name = userService.getUserByUsername(username).getName();

                new Home().setVisible(true);
            }else{
                System.out.println("Wrong username or password");
            }
        }else{
            System.out.println("Wrong username or password");
        }
        
    }
    
    public void register(String name, String email, String phone, String username, String password) throws SQLException{       
        
    }
            
}
