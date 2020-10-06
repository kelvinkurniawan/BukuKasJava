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

import models.User;
import utils.modules.Query;

/**
 *
 * @author kelvi
 */
public class UserImpl implements UserDao{
    
    private final Connection connection;
    
    public UserImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean insert(User user) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(Query.QUERY_INSERT_USER.getDisplayQuery());
            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getEmail());
            prepareStatement.setString(3, user.getUsername());
            prepareStatement.setString(4, user.getPassword());            
            prepareStatement.setString(5, user.getPhone());

            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        
        PreparedStatement prepareStatement = null;
        ResultSet executeQuery = null;
        User user = null;
        
        try{
            prepareStatement = connection.prepareStatement(Query.QUERY_SELECT_USER_BY_USERNAME.getDisplayQuery());
            prepareStatement.setString(1, username);
            executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                
                //System.out.println(Query.QUERY_SELECT_USER_BY_USERNAME.getDisplayQuery());
                
                user = new User(executeQuery.getInt("UserId"), executeQuery.getString("Name"), executeQuery.getString("Email"), executeQuery.getString("Username"), executeQuery.getString("Password"), executeQuery.getString("Telephone"));
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
                //Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return user;
        
    }
    
}
