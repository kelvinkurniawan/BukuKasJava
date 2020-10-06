/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
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
    
    TransactionService transactionService; 
    
    public HomeController(){
        transactionService = new TransactionServiceImpl(JdbcUtils.getTransactionDao());
    }
    
    public final DefaultTableModel generateTableModel(){

        int id = SessionManager.userId;
        
        String[] columnNames = {"Tipe", "Nominal", "Keterangan", "Tanggal"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        for (Transaction transactionByUserId : transactionService.getTransactionByUserId(id)) {
            
            String type = transactionByUserId.getTransType();
            int nominal = transactionByUserId.getTotalTrans();
            String desc = transactionByUserId.getDescription();
            String time = transactionByUserId.getTime();

            Object[] data = {type, nominal, desc, time};

            tableModel.addRow(data);
        }
          
        return tableModel;
    }
    
}
