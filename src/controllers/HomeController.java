/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.table.DefaultTableModel;
import services.TransactionService;
import services.TransactionServiceImpl;
import utils.modules.JdbcUtils;
import utils.modules.SessionManager;

/**
 *
 * @author kelvi
 */
public class HomeController {
    
    TransactionService transactionService; 
    BalanceController balanceController = new BalanceController();
    TransactionController transactionController = new TransactionController();
    
    int userId;
    
    /**
     * Fungsi control Home
     */
    public HomeController(){
        this.transactionService = new TransactionServiceImpl(JdbcUtils.getTransactionDao());
        this.userId = SessionManager.userId;
    }
    
    /**
     * Mendapatkan nilai balance
     * @return balanceController.getBalance()
     */
    public int getBalance(){
        return balanceController.getBalance();
    }
    
    /**
     * Mendapatkan nilai dari pemasukan
     * @return transactionController.getIncome()
     */
    public int getIncome(){
        return transactionController.getIncome();
    }
    
    /**
     * Mendapatkan nilai dari pengeluaran
     * @return transactionController.getOutcome()
     */
    public int getOutcome(){
        return transactionController.getOutcome();
    }
    
    /**
     * Mengecek user balance kosong atau tidak
     * @return return balanceController.checkUserBalance()
     */
    public boolean checkUserBalance(){
        return balanceController.checkUserBalance();
    }

    /**
     * Mendapatkan nilai saldo saat ini
     * @return this.getBalance() + this.getIncome() - this.getOutcome()
     */
    public int getCurrentlyBalance(){
        return this.getBalance() + this.getIncome() - this.getOutcome();
    }
    
    /**
     * fungsi untuk mencetak tabel
     * @return tableModel
     */
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
