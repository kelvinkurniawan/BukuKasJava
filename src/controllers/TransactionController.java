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
import daos.TransactionImpl;
import utils.modules.DBConnection;
import utils.modules.SessionManager;

/**
 *
 * @author kelvi
 */
public class TransactionController {

    public String userId;
    public ResultSet rs;
    
    DBConnection db = new DBConnection();
    //TransactionImpl transaction = new TransactionImpl(SessionManager.userId);
    
    public void addTransaction(int transTypeTemp, String totalTrans, String Description){
        String transType;
        
        if(transTypeTemp == 0){
            transType = "Income";
        }else{
            transType = "Outcome";
        }
        //  transaction.TransType = transType;
        //  transaction.TotalTrans = Integer.parseInt(totalTrans);
        //  transaction.Description = Description;
        //   transaction.addTransaction();
        
    }
    
    public int getIncome(){
        
        int result = 0;
        
        try {
           // rs = transaction.getTransactionByUserFiltered("Income");
            
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
           // rs = transaction.getTransactionByUserFiltered("Outcome");
            
            while(rs.next()){
                result += rs.getInt("TotalTrans");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
}