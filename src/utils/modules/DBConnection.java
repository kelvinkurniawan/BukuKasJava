/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.modules;

import utils.configs.DBConfig;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kelvi
 */
public class DBConnection {
    
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;
    
    
    public void intialize(){
        try{
            
            Class.forName(DBConfig.JDBC_DRIVER);

            // buat koneksi ke database
            conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    public boolean execute(String sql) throws SQLException{   
        
        this.intialize();
        
        stmt = conn.createStatement();

        return stmt.execute(sql);
        
    }
    
    public ResultSet executeQuery(String sql) throws SQLException{   
        
        this.intialize();
        
        stmt = conn.createStatement();

        return stmt.executeQuery(sql);
        
    }
    
    public void closeQuery() throws SQLException{
        
        stmt.close();
        conn.close();
        
    }
    
}
