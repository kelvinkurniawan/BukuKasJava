/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Balance;
import utils.modules.Query;


/**
 *
 * @author kelvi
 */
public class BalanceImpl implements BalanceDao{
    
    private final Connection connection;
    
    public BalanceImpl(Connection connection){
        this.connection = connection;
    }


    @Override
    public Balance getBalanceByUserId(int UserId) {
                
        PreparedStatement prepareStatement = null;
        ResultSet executeQuery = null;
        Balance balance = null;
        
        try{
            prepareStatement = connection.prepareStatement(Query.QUERY_SELECT_BALANCE_BY_USER_ID.getDisplayQuery());
            prepareStatement.setInt(1, UserId);
            executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                System.out.println(Query.QUERY_SELECT_BALANCE_BY_USER_ID.getDisplayQuery());
                balance = new Balance(executeQuery.getInt("BalanceId"), executeQuery.getInt("Balance"), executeQuery.getInt("UserId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (executeQuery != null) {
                    executeQuery.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BalanceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return balance;
        
    }

    @Override
    public boolean insert(Balance balance) {        
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(Query.QUERY_INSERT_BALANCE.getDisplayQuery());
            prepareStatement.setInt(1, balance.getBalanceID());
            prepareStatement.setInt(2, balance.getBalance());
            prepareStatement.setInt(3, balance.getUserId());

            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BalanceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BalanceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

}
