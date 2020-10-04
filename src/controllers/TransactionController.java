/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import models.Transaction;
import modules.DBConnection;
import modules.SessionManager;
import views.Home;
import views.TambahTransaksi;

/**
 *
 * @author kelvi
 */
public class TransactionController {

    public String userId;
    public ResultSet rs;
    
    DBConnection db = new DBConnection();
    Transaction transaction = new Transaction(SessionManager.userId);
    
    public void displayAddTransaction(){
        new TambahTransaksi().setVisible(true);
    }
    
    
    // Generate tabel
    public final DefaultTableModel generateTableModel(){

        String[] columnNames = {"Tipe", "Nominal", "Keterangan", "Tanggal"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        try {

            rs = transaction.getTransactionByUser();

            
            while(rs.next()){
                
                System.out.println("test");
                
                System.out.println(rs.getString("TransType"));
                
                String type = rs.getString("TransType");
                String nominal = rs.getString("TotalTrans");
                String desc = rs.getString("Description");
                String time = rs.getString("Time");
                String[] data = {type, nominal, desc, time};

                tableModel.addRow(data);
            }
          
            db.closeQuery();

        } catch (SQLException ex) {
           // Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tableModel;

    }
    
}