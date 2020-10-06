/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import utils.modules.PrintPDF;
import views.Login;

/**
 *
 * @author kelvi
 */
public class App {
  
    
    public static void main(String[] args) {
        
        PrintPDF pdf = new PrintPDF();
        
        new Login().setVisible(true);
        
    }
    
}
