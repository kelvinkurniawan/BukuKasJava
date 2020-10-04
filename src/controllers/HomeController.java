/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author kelvi
 */

import views.Home;

public class HomeController {
    
    public void displayHomeScreen(){
        new Home().setVisible(true);
    }
    
}
