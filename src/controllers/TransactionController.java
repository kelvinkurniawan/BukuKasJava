/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.Transaction;
import modules.DBConnection;
import modules.SessionManager;

/**
 *
 * @author kelvi
 */
public class TransactionController {

    public String userId;
    public ResultSet rs;
    
    DBConnection db = new DBConnection();
    Transaction transaction = new Transaction(SessionManager.userId);
    
    public void addTransaction(int transTypeTemp, String totalTrans, String Description){
        String transType;
        
        if(transTypeTemp == 0){
            transType = "Income";
        }else{
            transType = "Outcome";
        }
        
        transaction.TransType = transType;
        transaction.TotalTrans = Integer.parseInt(totalTrans);
        transaction.Description = Description;
        
        try {
            transaction.addTransaction();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getIncome(){
        
        int result = 0;
        
        try {
            rs = transaction.getTransactionByUserFiltered("Income");
            
            while(rs.next()){
                result += rs.getInt("TotalTrans");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public int getOutcome(){
        int result = 0;
        
        try {
            rs = transaction.getTransactionByUserFiltered("Outcome");
            
            while(rs.next()){
                result += rs.getInt("TotalTrans");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    // Generate tabel
    public final DefaultTableModel generateTableModel(){

        String[] columnNames = {"Tipe", "Nominal", "Keterangan", "Tanggal"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        try {

            rs = transaction.getTransactionByUser();
            
            while(rs.next()){
                
                String type = rs.getString("TransType");
                String nominal = rs.getString("TotalTrans");
                String desc = rs.getString("Description");
                String time = rs.getString("Time");
                String[] data = {type, nominal, desc, time};

                tableModel.addRow(data);
            }
          
            db.closeQuery();

        } catch (SQLException ex) {
           // Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableModel;

    }
    
}