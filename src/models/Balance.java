/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import modules.DBConnection;
import config.TableConfig;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kelvi
 */
public class Balance {
    public static ResultSet rs;
    private int Id;
    
    DBConnection db = new DBConnection();
    
    public Balance(String Id){
        this.Id = Integer.parseInt(Id);
    }
    
    public ResultSet getBalanceById() throws SQLException{
        String sql = "SELECT * from tb_m_balance where " + TableConfig._balance_userId + " =  '" + this.Id + "'";
        
        return db.executeQuery(sql);
    }
    
    public boolean addBalance(int newBalance) throws SQLException{
        String sql = "Insert into tb_m_balance(" + TableConfig._balance_balance + ") values ('" + newBalance + "')";
        
        return db.execute(sql);
    }
    
    public boolean updateBalance(int newBalance) throws SQLException{
        String sql = "Update tb_m_balance set " + TableConfig._balance_balance + " = '" + newBalance + "' where " + TableConfig._balance_userId + " = '" + this.Id + "'";
        
        return db.execute(sql);
    }
}
