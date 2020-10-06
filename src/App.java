/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import utils.modules.BCrypt;
import views.Login;

/**
 *
 * @author kelvi
 */
public class App {
  
    
    public static void main(String[] args) {
        
        
        new Login().setVisible(true);
        String  originalPassword = "password";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);

        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        System.out.println(matched);
        
    }
    
}
