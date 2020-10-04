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
import views.Home;

/**
 *
 * @author kelvi
 */
public class TransactionController {

    public String userId;
    public ResultSet rs;

    Transaction transaction = new Transaction(Integer.parseInt(userId));

    public void showTransactionOnHomescreen(){

        String[] columnNames = {"Tipe", "Nominal", "Keterangan", "Tanggal"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        try {

            rs = transaction.getTransactionByUser();

            while(rs.next()){
                String type = rs.getString("TransactionType");
                String nominal = rs.getString("Nominal");
                String desc = rs.getString("Description");
                String time = rs.getString("Time");

                String[] data = {type, nominal, desc, time};


                tableModel.addRow(data);
            }


            new Home().jTable1.setModel(tableModel);


        } catch (SQLException ex) {
           // Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}