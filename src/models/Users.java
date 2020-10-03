/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import modules.DBConnection;
import config.TableConfig;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kelvi
 */
public class Users {
    public static ResultSet rs;
    
    private String name;
    private String email;   
    private String username;
    private String password;
    private String phone;
    
    DBConnection db = new DBConnection();
    
    public Users(String name, String email, String username, String password, String phone){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
    
    public Users(){
        
    }
    
    public boolean addUser() throws SQLException{
        
        String sql = "INSERT INTO users ("+ TableConfig._user_name +", "+ TableConfig._user_email + ", "+ TableConfig._user_username +", "+ TableConfig._user_password +", "+ TableConfig._user_phone +") VALUES ('" + name + "', '" + email + "', '" + username + "', '" + password + "', '" + phone + "');";
    
        return db.execute(sql);
    
    }
    
    public ResultSet checkUser() throws SQLException{
        
        String sql = "SELECT * FROM users where "+ TableConfig._user_username + " = '" + name + "'";
        
        rs = db.executeQuery(sql);
        
        return rs;
        
    }
   

}
