/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Transaction;
import services.TransactionService;
import services.TransactionServiceImpl;
import utils.modules.JdbcUtils;
import utils.modules.SessionManager;

/**
 *
 * @author kelvi
 */
public class TransactionController {
    
    TransactionService transactionService; 
    int userId;
    
    public TransactionController(){
        this.transactionService = new TransactionServiceImpl(JdbcUtils.getTransactionDao());
        this.userId = SessionManager.userId;
    }
    
    public boolean addTransaction(int transTypeTemp, String totalTrans, String Description){
        String transType;
        
        if(transTypeTemp == 0){
            transType = "Income";
        }else{
            transType = "Outcome";
        }
        
        Transaction transaction = new Transaction(0, transType, Description, Integer.parseInt(totalTrans), null, userId);
        return transactionService.insert(transaction);
        
    }
    
    public int getIncome(){
        
        String filter = "Income";
        int result = 0;
        
        result = transactionService.getTransactionByUserIdFiltered(userId, filter).stream().map((transactionByUserIdFiltered) -> 
            transactionByUserIdFiltered.getTotalTrans()).reduce(result, Integer::sum);
        
        return result;
    }
    
    public int getOutcome(){
        
        String filter = "Outcome";
        int result = 0;
        
        result = transactionService.getTransactionByUserIdFiltered(userId, filter).stream().map((transactionByUserIdFiltered) -> 
            transactionByUserIdFiltered.getTotalTrans()).reduce(result, Integer::sum);
        
        return result;
    }
    
}