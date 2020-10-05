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

import utils.modules.Routing;

public class HomeController extends Routing {
    
    Routing route = new Routing();
    
    @Override
    public void displayHome(){
        super.displayHome();
    }
        
    @Override
    public void displayAddTransaction(){
        super.displayAddTransaction();
    }
    
    @Override
    public void displaySetBalance(){
        super.displaySetBalance();
    }
}
