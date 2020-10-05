/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utils.modules.Routing;

/**
 *
 * @author kelvi
 */

import utils.modules.Routing;

public class HomeController {
    
    Routing route = new Routing();
    
    public void displayHome(){
        Routing.displayHome();
    }
        
    public void displayAddTransaction(){
        Routing.displayAddTransaction();
    }
    
    public void displaySetBalance(){
        Routing.displaySetBalance();
    }
}
