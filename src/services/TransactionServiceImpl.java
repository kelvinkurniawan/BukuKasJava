/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.TransactionDao;
import java.util.List;
import models.Transaction;

/**
 *
 * @author kelvi
 */
public class TransactionServiceImpl implements TransactionService{
    
    public TransactionDao transactionDao;
    
    /**
     * Implementasi Transaction Service
     * @param transactionDao 
     */
    public TransactionServiceImpl(TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }

    /**
     * Overide getTranscactionByUserId
     * @param UserId
     * @return transactionDao.getTransactionByUserId(UserId)
     */
    @Override
    public List<Transaction> getTransactionByUserId(int UserId) {
        return transactionDao.getTransactionByUserId(UserId);
    }

    /**
     * Overide getTransactionByUserIdFiltered
     * @param UserId
     * @param Filter
     * @return transactionDao.getTransactionByUserIdFiltered(UserId, Filter)
     */
    @Override
    public List<Transaction> getTransactionByUserIdFiltered(int UserId, String Filter) {
        return transactionDao.getTransactionByUserIdFiltered(UserId, Filter);
    }

    /**
     * Overide insert
     * @param transaction
     * @return transactionDao.insert(transaction)
     */
    @Override
    public boolean insert(Transaction transaction) {
        return transactionDao.insert(transaction);
    }
    
}
