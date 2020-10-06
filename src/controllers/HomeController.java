/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.table.DefaultTableModel;
import models.Transaction;
import services.TransactionService;
import services.TransactionServiceImpl;
import utils.modules.JdbcUtils;
import utils.modules.SessionManager;

/**
 *
 * @author kelvi
 */
public class HomeController {
    
    TransactionService transactionService ; 
    BalanceController balanceController = new BalanceController();
    TransactionController transactionController = new TransactionController();
    
    int userId;
    
    public HomeController(){
        this.transactionService = new TransactionServiceImpl(JdbcUtils.getTransactionDao());
        this.userId = SessionManager.userId;
    }
    
    public int getBalance(){
        return balanceController.getBalance();
    }
    
    public int getIncome(){
        return transactionController.getIncome();
    }
    
    public int getOutcome(){
        return transactionController.getOutcome();
    }
    
    public boolean checkUserBalance(){
        return balanceController.checkUserBalance();
    }

    public int getCurrentlyBalance(){
        return this.getBalance() + this.getIncome() - this.getOutcome();
    }
    
    public final DefaultTableModel generateTableModel(){

        int id = SessionManager.userId;
        
        String[] columnNames = {"Tipe", "Nominal", "Keterangan", "Tanggal"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        transactionService.getTransactionByUserId(userId).stream().map((transactionByUserId) -> {
            String type = transactionByUserId.getTransType();
            int nominal = transactionByUserId.getTotalTrans();
            String desc = transactionByUserId.getDescription();
            String time = transactionByUserId.getTime();
            Object[] data = {type, nominal, desc, time};
            return data;
        }).forEachOrdered((data) -> {
            tableModel.addRow(data);
        });
        
        return tableModel;
    }
    
}
