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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Transaction;
import utils.modules.DBConnection;
import utils.configs.TableConfig;
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
    public Transaction getTransactionByUserId(int UserId) {
        PreparedStatement prepareStatement = null;
        ResultSet executeQuery = null;
        Transaction transaction = null;
        
        try{
            prepareStatement = connection.prepareStatement(""+Query.QUERY_SELECT_TRANSACTION_BY_USER_ID);
            prepareStatement.setInt(1, UserId);
            executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                System.out.println(""+Query.QUERY_SELECT_TRANSACTION_BY_USER_ID);
                transaction = new Transaction(executeQuery.getInt("TransId"), executeQuery.getString("TransType"), executeQuery.getString("Description"), executeQuery.getInt("TotalTrans"), executeQuery.getString("Time"), executeQuery.getInt("UserId"));
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
        
        return transaction;
        
    }

    @Override
    public Transaction getTransactionByUserIdFiltered(int UserId, String Filter) {
                
        PreparedStatement prepareStatement = null;
        ResultSet executeQuery = null;
        Transaction transaction = null;
        
        try{
            prepareStatement = connection.prepareStatement(""+Query.QUERY_SELECT_TRANSACTION_BY_USER_ID_FILTERED);
            prepareStatement.setInt(1, UserId);
            prepareStatement.setString(1, Filter);
            executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                System.out.println(""+Query.QUERY_SELECT_TRANSACTION_BY_USER_ID_FILTERED);
                transaction = new Transaction(executeQuery.getInt("TransId"), executeQuery.getString("TransType"), executeQuery.getString("Description"), executeQuery.getInt("TotalTrans"), executeQuery.getString("Time"), executeQuery.getInt("UserId"));
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
        
        return transaction;
        
    }

    @Override
    public boolean insert(Transaction transaction) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(""+Query.QUERY_INSERT_USER);
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