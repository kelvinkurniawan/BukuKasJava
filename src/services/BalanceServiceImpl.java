/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.BalanceDao;
import models.Balance;

/**
 *
 * @author kelvi
 */
public class BalanceServiceImpl implements BalanceService{

    public final BalanceDao balanceDao;
    
    /**
     * Implementasi interface BalanceService
     * @param balanceDao 
     */
    public BalanceServiceImpl(BalanceDao balanceDao){
        this.balanceDao = balanceDao;
    }
    /**
     * Overide getBalanceByUserId
     * @param UserId
     * @return balanceDao.getBalanceByUserId(UserId)
     */
    @Override
    public Balance getBalanceByUserId(int UserId) {
       return balanceDao.getBalanceByUserId(UserId);
    }

    /**
     * Overide insert 
     * @param balance
     * @return balanceDao.insert(balance)
     */
    @Override
    public boolean insert(Balance balance) {
        return balanceDao.insert(balance);
    }
    
}
