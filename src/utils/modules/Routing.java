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
    
    private final Home HOME_VIEW = new Home();
    private final AddTransaction ADD_TRANSACTION_VIEW = new AddTransaction();
    private final SetBalance SET_BALANCE_VIEW = new SetBalance();
    
    public Home homeView(){
        return HOME_VIEW;
    }
    
    public AddTransaction addTrasaction(){
        return ADD_TRANSACTION_VIEW;
    }
    
    public SetBalance setBalance(){
        return SET_BALANCE_VIEW;
    }
    
}
