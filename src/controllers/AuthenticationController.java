/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.SQLException;
import models.Users;
/**
 *
 * @author kelvi
 */
public class AuthenticationController {
    
    public void login(String username, String password) throws SQLException{
        Users users = new Users(null, null, username, password, null);
        
        if(users.getUserByUsername().next()){
          if(users.getUserByUsername().getString("password").equals(password)){
              // Login success
          }else{
              // Login error
          }
        }else{
            // Login error
        }
        
    }
    
    public void register(String name, String email, String username, String password, String phone) throws SQLException{
        Users users = new Users(name, email, username, password, phone);
        
        if(users.addUser()){
            // set alert
            System.out.println("User created!");
        }else{
            System.out.println("Something went wrong");
        }
    }
            
}
