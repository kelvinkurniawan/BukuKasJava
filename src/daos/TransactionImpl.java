package daos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Transaction;
import utils.modules.Query;

/**
 *
 * @author kelvi
 */
public class TransactionImpl implements TransactionDao{    
    
    private final Connection connection;
    
    public TransactionImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Transaction> getTransactionByUserId(int UserId) {
        
        List<Transaction> transactions = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet executeQuery = null;
        Transaction transaction = null;
        
        try{
            prepareStatement = connection.prepareStatement(Query.QUERY_SELECT_TRANSACTION_BY_USER_ID.getDisplayQuery());
            prepareStatement.setInt(1, UserId);
            executeQuery = prepareStatement.executeQuery();
            while (executeQuery.next()) {
                System.out.println(Query.QUERY_SELECT_TRANSACTION_BY_USER_ID.getDisplayQuery());
                transaction = new Transaction(executeQuery.getInt("TransId"), executeQuery.getString("TransType"), executeQuery.getString("Description"), executeQuery.getInt("TotalTrans"), executeQuery.getString("Time"), executeQuery.getInt("UserId"));
                transactions.add(transaction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (executeQuery != null) {
                    executeQuery.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return transactions;
        
    }

    @Override
    public List<Transaction> getTransactionByUserIdFiltered(int UserId, String Filter) {
                
        List<Transaction> transactions = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet executeQuery = null;
        Transaction transaction = null;
        
        try{
            prepareStatement = connection.prepareStatement(Query.QUERY_SELECT_TRANSACTION_BY_USER_ID_FILTERED.getDisplayQuery());
            prepareStatement.setInt(1, UserId);
            prepareStatement.setString(2, Filter);
            executeQuery = prepareStatement.executeQuery();
            while (executeQuery.next()) {
                System.out.println(Query.QUERY_SELECT_TRANSACTION_BY_USER_ID_FILTERED.getDisplayQuery());
                transaction = new Transaction(executeQuery.getInt("TransId"), executeQuery.getString("TransType"), executeQuery.getString("Description"), executeQuery.getInt("TotalTrans"), executeQuery.getString("Time"), executeQuery.getInt("UserId"));
                transactions.add(transaction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (executeQuery != null) {
                    executeQuery.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return transactions;
        
    }

    @Override
    public boolean insert(Transaction transaction) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(Query.QUERY_INSERT_TRANSACTION.getDisplayQuery());
            prepareStatement.setString(1, transaction.getTransType());
            prepareStatement.setInt(2, transaction.getTotalTrans());
            prepareStatement.setInt(3, transaction.getUserId());
            prepareStatement.setString(4, transaction.getDescription());   

            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
   

}