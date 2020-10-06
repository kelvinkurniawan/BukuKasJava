/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kelvi
 */
public class Transaction {
    private int transId;
    private String transType;
    private String description;
    private int totalTrans;
    private String time;
    private int userId;

    /**
     * Constraktor Transaction
     * @param transId
     * @param transType
     * @param description
     * @param totalTrans
     * @param time
     * @param userId 
     */
    public Transaction(int transId, String transType, String description, int totalTrans, String time, int userId) {
        this.transId = transId;
        this.transType = transType;
        this.description = description;
        this.totalTrans = totalTrans; 
        this.time = time;
        this.userId = userId;
    }
    /**
     * fungsi get TransId from Transaction
     * @return transaId
     */
    public int getTransId() {
        return transId;
    }
    /**
     * fungsi set value to transId
     * @param transId 
     */
    public void setTransId(int transId) {
        this.transId = transId;
    }
    /**
     * fungsi get TransType from Transaction
     * @return transType
     */
    public String getTransType() {
        return transType;
    }
    /**
     * fungsi set value to transType
     * @param transType 
     */

    public void setTransType(String transType) {
        this.transType = transType;
    }
    /**
     * fungsi get Description from Transaction
     * @return description
     */

    public String getDescription() {
        return description;
    }
    /**
     * fungsi set value to description
     * @param description 
     */

    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * fungsi get TotalTrans from Transaction
     * @return totalTrans
     */

    public int getTotalTrans() {
        return totalTrans;
    }
    /**
     * fungsi set value to totalTrans
     * @param totalTrans 
     */
    public void setTotalTrans(int totalTrans) {
        this.totalTrans = totalTrans;
    }
    /**
     * fungsi get time from Transaction
     * @return time
     */
    public String getTime() {
        return time;
    }
    /**
     * fungsi set value to setTime
     * @param time 
     */
    public void setTime(String time) {
        this.time = time;
    }
    /**
     * fungsi get UserId from Transaction
     * @return userId
     */
    public int getUserId() {
        return userId;
    }
    /**
     * fungsi set value to UserId
     * @param userId 
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
