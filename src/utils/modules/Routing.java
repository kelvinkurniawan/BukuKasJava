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
    
    private static final Home HOME_VIEW = new Home();
    private static final AddTransaction ADD_TRANSACTION_VIEW = new AddTransaction();
    private static final SetBalance SET_BALANCE_VIEW = new SetBalance();
    private static final Login LOGIN_VIEW = new Login();
    private static final Register REGISTER = new Register();
    
    public static void displayHome(){
        beforeDisplay();
        HOME_VIEW.setVisible(true);
    }
    
    public static void displayAddTransaction(){
        beforeDisplay();
        ADD_TRANSACTION_VIEW.setVisible(true);
    }
    
    public static void displaySetBalance(){
        beforeDisplay();
        SET_BALANCE_VIEW.setVisible(true);
    }
    
    public static void displayLogin(){
        beforeDisplay();
        LOGIN_VIEW.setVisible(true);
    }
    
    public static void displayRegister(){
        beforeDisplay();
        REGISTER.setVisible(true);
    }
    
    public static void beforeDisplay(){
        if(HOME_VIEW.isVisible())
            HOME_VIEW.setVisible(false);
        
        if(ADD_TRANSACTION_VIEW.isVisible())
            ADD_TRANSACTION_VIEW.setVisible(false);
        
        if(SET_BALANCE_VIEW.isVisible())
            SET_BALANCE_VIEW.setVisible(false);
        
        if(LOGIN_VIEW.isVisible())
            LOGIN_VIEW.setVisible(false);
        
        if(REGISTER.isVisible())
            REGISTER.setVisible(false);
    }
}
