/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Transaction;

/**
 *
 * @author kelvi
 */
public interface TransactionService {
    public Transaction getTransactionByUserId(int UserId);
    public Transaction getTransactionByUserIdFiltered(int UserId, String Filter);
    public boolean insert(Transaction transaction);
}
