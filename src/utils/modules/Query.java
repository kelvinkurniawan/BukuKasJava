/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.modules;

import utils.configs.TableConfig;

/**
 *
 * @author kelvi
 */
public enum Query {
    QUERY_INSERT_USER("INSERT INTO " + TableConfig.TBL_USER + " (" + TableConfig.USER_NAME + ", " + TableConfig.USER_EMAIL + ", " + TableConfig.USER_USERNAME + ", " + TableConfig.USER_PASSWORD + ", " + TableConfig.USER_PHONE + ") VALUES (?, ?, ?, ?, ?)"),
    QUERY_SELECT_USER_BY_USERNAME("SELECT * FROM " + TableConfig.TBL_USER + " where " + TableConfig.USER_USERNAME + " = ?"),
    QUERY_SELECT_BALANCE_BY_USER_ID("SELECT * from " + TableConfig.TBL_BALANCE + " where " + TableConfig.BALANCE_USERID + " =  ?"),
    QUERY_INSERT_BALANCE("INSERT INTO " + TableConfig.TBL_BALANCE + " (" + TableConfig.BALANCE_BALANCE + ", " + TableConfig.BALANCE_USERID + ") VALUES (?, ?)"),
    QUERY_SELECT_TRANSACTION_BY_USER_ID("Select * from " + TableConfig.TBL_TRANSACTION + " where " + TableConfig.TRANSACTION_USERID  + " = ?"),
    QUERY_SELECT_TRANSACTION_BY_USER_ID_FILTERED("Select * from " + TableConfig.TBL_TRANSACTION + " where " + TableConfig.TRANSACTION_USERID  + " = ? and " + TableConfig.TRANSACTION_TRANSTYPE + " = ?"),
    QUERY_INSERT_TRANSACTION("Insert into " + TableConfig.TBL_TRANSACTION + " (" + TableConfig.TRANSACTION_TRANSTYPE + ", " + TableConfig.TRANSACTION_TOTALTRANS + ", " + TableConfig.TRANSACTION_USERID + ", " + TableConfig.TRANSACTION_DESCRIPTION + ") values (?, ?, ?, ?)");
    
    private final String displayQuery;
    
    Query(String displayQuery){
        this.displayQuery = displayQuery;
    }
    
    public String getDisplayQuery(){
        return displayQuery;
    }
}
