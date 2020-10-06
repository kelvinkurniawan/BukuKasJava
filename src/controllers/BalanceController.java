/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Balance;
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
    
    /**
     * fungsi control balance
     */
    public BalanceController(){
        
        this.balanceService = new BalanceServiceImpl(JdbcUtils.getBalanceDao());
        this.userId = SessionManager.userId;
        
    }
    /**
     * Mendapatkan nilai dari Balance
     * @return int balance
     */
    public int getBalance(){
        if(!checkUserBalance()){
            return 0;
        }
        return balanceService.getBalanceByUserId(this.userId).getBalance();
        
    }
    
    /**
     * Mendapatkan saldo saat ini
     * @return currentlyBalance
     */
    public int currentlyBalance(){
        
        return getBalance() + transactionController.getIncome() - transactionController.getOutcome();
        
    }
    
    /**
     * mengecek apakah balance user kosong atau tidak
     * @return boolean checkUserBalance
     */
    public boolean checkUserBalance(){
        
        return balanceService.getBalanceByUserId(userId) != null;
    }
    
    /**
     * Fungsi untuk mengeset nilai Balance
     * @param newBalance
     * @return balanceService.insert(balance)
     */
    public boolean setBalance(String newBalance){
        
        Balance balance = new Balance(0, Integer.parseInt(newBalance), userId);
        
        return balanceService.insert(balance);
        
    }
    
}
