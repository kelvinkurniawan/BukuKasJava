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
    /**
     * fungsi get BalanceId from Balance
     * @return BalanceId
     */
    public int getBalanceID() {
        return BalanceID;
    }

    /**
     * fungsi get Balance from Balance
     * @return Balance
     */
    public int getBalance() {
        return Balance;
    }

    /**
     * fungsi get UserId from Balance
     * @return userId
     */
    public int getUserId() {
        return UserId;
    }

    /**
     * fungsi set value to BalanceID
     * @param BalanceID 
     */
    public void setBalanceID(int BalanceID) {
        this.BalanceID = BalanceID;
    }

    /**
     * fungsi set value to Balance
     * @param Balance 
     */    
    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    /**
     * fungsi set value to UserId
     * @param userId 
     */    
    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    
}
