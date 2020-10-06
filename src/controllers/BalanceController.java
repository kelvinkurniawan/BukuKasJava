/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import services.BalanceService;
import services.BalanceServiceImpl;
import utils.modules.JdbcUtils;
import utils.modules.SessionManager;

/**
 *
 * @author kelvi
 */
public class BalanceController {
    
    BalanceService balanceService;
    TransactionController transactionController;
    int userId;
    
    public BalanceController(){
        
        this.balanceService = new BalanceServiceImpl(JdbcUtils.getBalanceDao());
        this.userId = SessionManager.userId;
        
    }
    
    public int getBalance(){
        
        return balanceService.getBalanceByUserId(this.userId).getBalance();
        
    }
    
    public int currentlyBalance(){
        
        return getBalance() + transactionController.getIncome() - transactionController.getOutcome();
        
    }
    
    public boolean setBalance(String newBalance){
        return true;
    }
    
}
