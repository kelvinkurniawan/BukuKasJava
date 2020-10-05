/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukukas;

import controllers.AuthenticationController;
import modules.Routing;

/**
 *
 * @author kelvi
 */
public class Main {
  
    
    public static void main(String[] args) {
        
//        DBConnection db = new DBConnection();
//        
//        rs = db.executeQuery("SELECT * from users");
//        
//        while(rs.next()){
//            System.out.println("User ID: " + rs.getInt("UserId"));
//            System.out.println("Nama: " + rs.getString("name"));
//            System.out.println("Email: " + rs.getString("email"));
//        }
//        
//        db.closeQuery();

        new Routing().displayLogin();
        
    }
    
}
