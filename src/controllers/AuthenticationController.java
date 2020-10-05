/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.ResultSet;
import java.sql.SQLException;
import daos.UserImpl;

import utils.modules.Encryption;
import utils.modules.DBConnection;
import utils.modules.Routing;
import utils.modules.SessionManager;
/**
 *
 * @author kelvi
 */
public class AuthenticationController {
    
    public static ResultSet rs;
    
    DBConnection db = new DBConnection();
    
    
    public boolean login(String username, String password) throws SQLException{
        //UserImpl users = new UserImpl(null, null, null, username, password);
        
        if(username.equals("") || password.equals("")){
            return false;
        }
        
        //rs = users.getUserByUsername();
        
        if(rs.next()){
          if(Encryption.getDecrypt(rs.getString("password")).equals(password)){
              
              SessionManager.userId = rs.getInt("UserId");
              SessionManager.name = rs.getString("name");
              
              db.closeQuery();
              
              new Routing().displayHome();
              
              return true;
              
          }else{
              return false;
          }
        }else{
            return false;
        }
        
    }
    
    public boolean register(String name, String email, String phone, String username, String password) throws SQLException{       
        if(name.equals("") ||username.equals("") || password.equals("") || email.equals("") || phone.equals("")){
            return false;
        }
       // UserImpl users = new UserImpl(name, email, phone,  username, Encryption.getEncrypt(password));
        
        //return users.addUser();
        return true;
    }
            
}
