/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.modules;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import utils.configs.DBConfig;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author kelvi
 */
public class DBConnection {
    
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;
    
    
    private static Connection connection;
    
    /**
     * fungsi untuk membuat koneksi
     * @return connection
     */
    public static Connection connect() {
        if (connection == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setServerName(DBConfig.SERVER);
                dataSource.setPort(DBConfig.PORT);
                dataSource.setDatabaseName(DBConfig.DB_NAME);
                dataSource.setUser(DBConfig.USER);
                dataSource.setPassword(DBConfig.PASS);
                connection = dataSource.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
}
