/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.ResultSet;
import java.sql.SQLException;
import models.Users;

import modules.Encryption;
/**
 *
 * @author kelvi
 */
public class AuthenticationController {
    
    public static ResultSet rs;
    
    public boolean login(String username, String password) throws SQLException{
        Users users = new Users(null, null, null, username, password);
        
        rs = users.getUserByUsername();
        
        if(rs.next()){
          if(Encryption.getDecrypt(rs.getString("password")).equals(password)){
              return true;
          }else{
              return false;
          }
        }else{
            return false;
        }
        
    }
    
    public boolean register(String name, String email, String phone, String username, String password) throws SQLException{
        Users users = new Users(name, email, phone,  username, Encryption.getEncrypt(password));
        
        return users.addUser(); // set alert
    }
            
}