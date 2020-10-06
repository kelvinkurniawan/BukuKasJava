/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kelvi
 */
public class Balance {
    
    private int BalanceID;
    private int Balance;
    private int UserId;

    public Balance(int BalanceID, int Balance, int UserId) {
        this.BalanceID = BalanceID;
        this.Balance = Balance;
        this.UserId = UserId;
    }

    public Balance(int i, String balanceVal, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getBalanceID() {
        return BalanceID;
    }

    public int getBalance() {
        return Balance;
    }

    public int getUserId() {
        return UserId;
    }

    public void setBalanceID(int BalanceID) {
        this.BalanceID = BalanceID;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    
}
