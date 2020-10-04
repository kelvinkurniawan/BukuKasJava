/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import modules.DBConnection;
import config.TableConfig;

/**
 *
 * @author kelvi
 */
public class Transaction {
    private int TransId;
    private String TransType;
    private int TotalTrans;
    private String Description;
    private int UserId;
    
    DBConnection db = new DBConnection();
    
    public Transaction(int UserId){
        this.UserId = UserId;
    }
    
    public ResultSet getTransactionByUser() throws SQLException{
        
        String sql = "Select * from tb_m_transaction where " + TableConfig._transaction_userId  + " = '" + this.UserId + "'";
        
        return db.executeQuery(sql);
        
    }
    
    public ResultSet getTransactionByUserFiltered(String typeTrans) throws SQLException{
        
        String sql = "Select * from tb_m_transaction where " + TableConfig._transaction_userId  + " = '" + this.UserId + "' and " + TableConfig._transaction_transType + " = '" + TransType + "'";
        
        return db.executeQuery(sql);
        
    }
    
    public boolean addTransaction(){
        
        String sql = "Insert into tb_m_transaction(" + TableConfig._transaction_transType + ", " + TableConfig._transaction_totalTrans + ", " + TableConfig._transaction_userId + ") values ('" + TransType + "', '" + TotalTrans + "' , '" + UserId + "' )";
        
        return true;
        
    }
    
}
