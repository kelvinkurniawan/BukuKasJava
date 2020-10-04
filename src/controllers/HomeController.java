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

import views.AddTransaction;
import views.Home;
import views.SetBalance;

public class HomeController {
    
    public void displayHomeScreen(){
        new Home().setVisible(true);
    }
        public void displayAddTransaction(){
        new AddTransaction().setVisible(true);
    }
    
    public void displaySetBalance(){
        new SetBalance().setVisible(true);
    }
}
