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
    
    public BalanceServiceImpl(BalanceDao balanceDao){
        this.balanceDao = balanceDao;
    }
    
    @Override
    public Balance getBalanceByUserId(int UserId) {
       return balanceDao.getBalanceByUserId(UserId);
    }

    @Override
    public boolean insert(Balance balance) {
        return balanceDao.insert(balance);
    }
    
}
