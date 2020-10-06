/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.modules;

import daos.*;

/**
 *
 * @author kelvi
 */
public class JdbcUtils {
    private static UserDao userDao;
    private static BalanceDao balanceDao;
    private static TransactionDao transasactionDao;
    
    public static UserDao getUserDao(){
        if(userDao == null){
            userDao = new UserImpl(DBConnection.connect());
        }
        
        return userDao;
    }
    
    public static BalanceDao getBalanceDao(){
        if(balanceDao == null){
            balanceDao = new BalanceImpl(DBConnection.connect());
        }
        
        return balanceDao;
    }
    
    public static TransactionDao getTransactionDao(){
        if(transasactionDao == null){
            transasactionDao = new TransactionImpl(DBConnection.connect());
        }
        
        return transasactionDao;
    }
}
