/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.modules;

import views.*;

/**
 *
 * @author kelvi
 */
public class Routing {
    
    Home home = new Home();
    AddTransaction addTransaction = new AddTransaction();
    SetBalance setBalance = new SetBalance();
    
    Login login = new Login();
    Register register = new Register();
    
    public void displayHome(){
        home.setVisible(true);
    }
    
    public void displayAddTransaction(){
        addTransaction.setVisible(true);
    }
    
    public void displaySetBalance(){
        setBalance.setVisible(true);
    }
    
    public void displayLogin(){
        login.setVisible(true);
    }
    
    public void displayRegister(){
        register.setVisible(true);
    }
}
