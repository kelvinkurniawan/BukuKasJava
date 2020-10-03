/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.Balance;

/**
 *
 * @author kelvi
 */
public class BalanceController {
    
    public static ResultSet rs;
    
    public String id;
    public boolean isExist = false;
    
    Balance balance = new Balance(id);
    
    public int getBalance() throws SQLException{
        
        rs = balance.getBalanceById();
        if(rs.next()){
            isExist = true;
            return rs.getInt("balance");
        }else{
            isExist = false;
            return 0;
        }
        
    }
    
    public void setBalance(String newBalance) throws SQLException{
        if(isExist){
            balance.updateBalance(Integer.parseInt(newBalance));
        }else{
            balance.addBalance(Integer.parseInt(newBalance));
        }
    }
    
}
