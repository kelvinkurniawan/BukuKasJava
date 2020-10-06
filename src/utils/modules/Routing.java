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
    private static final Register REGISTER_VIEW = new Register();
    
    public static Home homeView(){
        return Routing.HOME_VIEW;
    }
    
    public static AddTransaction addTrasaction(){
        return Routing.ADD_TRANSACTION_VIEW;
    }
    
    public static SetBalance setBalance(){
        return Routing.SET_BALANCE_VIEW;
    }
    
    public static Login login(){
        return LOGIN_VIEW;
    }
    
    public static Register register(){
        return REGISTER_VIEW;
    }
}
