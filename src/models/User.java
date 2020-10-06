/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import services.UserService;

/**
 *
 * @author kelvi
 */
public class User {
    private int userId;
    private String name;
    private String email;   
    private String username;
    private String password;
    private String phone;

    public User(int userId, String name, String email, String username, String password, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public User(UserService userServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * fungsi get UserId from User
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
    /**
     * fungsi get Name from User
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * fungsi set value to Name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
   /**
    * fungsi get Email from user
    * @return email
    */ 
    public String getEmail() {
        return email;
    }
    /**
     * fungsi set value to Email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * fungsi get Username from User
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * fungsi set value to Username
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * fungsi get Password from User
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * fungsi set value to Password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * fungsi get Phone from User
     * @return phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * fungsi set value to Phone
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
