package daos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import utils.modules.DBConnection;
import utils.configs.TableConfig;

/**
 *
 * @author kelvi
 */
public class TransactionDao {
   
    DBConnection db = new DBConnection();
    
    public static ResultSet rs;
    public String Description;
    public String TransType;
    public int TransId;
    public int TotalTrans;
    public final int UserId;

    public TransactionDao(int UserId){
        this.UserId = UserId;
    }

    public ResultSet getTransactionByUser() throws SQLException{

        String sql = "Select * from tb_m_transaction where " + TableConfig.TRANSACTION_USERID  + " = '" + this.UserId + "'";

        return db.executeQuery(sql);
    }

    public ResultSet getTransactionByUserFiltered(String filter) throws SQLException{

        String sql = "Select * from tb_m_transaction where " + TableConfig.TRANSACTION_USERID  + " = '" + this.UserId + "' and " + TableConfig.TRANSACTION_TRANSTYPE + " = '" + filter + "'";

        return db.executeQuery(sql);

    }

    public boolean addTransaction() throws SQLException{

        String sql = "Insert into tb_m_transaction(" + TableConfig.TRANSACTION_TRANSTYPE + ", " + TableConfig.TRANSACTION_TOTALTRANS + ", " + TableConfig.TRANSACTION_USERID + ", " + TableConfig.TRANSACTION_DESCRIPTION + ") values ('" + TransType + "', '" + TotalTrans + "' , '" + UserId + "', '" + Description + "' )";
        
        return db.execute(sql);

    }

}