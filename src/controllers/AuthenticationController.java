/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import models.User;
import services.UserService;
import services.UserServiceImpl;
import utils.modules.BCrypt;

import utils.modules.Encryption;
import utils.modules.JdbcUtils;
import utils.modules.Mailer;
import utils.modules.SessionManager;
import views.Home;

/**
 *
 * @author kelvi
 */
public class AuthenticationController {

    UserService userService;
    /**
     * fungsi control untuk autentifikasi user
     */
    public AuthenticationController() {
        userService = new UserServiceImpl(JdbcUtils.getUserDao());
    }
    
    /**
     * fungsi memverifikasi username dan password untuk login
     * @param username
     * @param password
     * @return boolean login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException  {

        if (userService.getUserByUsername(username) != null) {
            if (BCrypt.checkpw(password, userService.getUserByUsername(username).getPassword())) {

                System.out.println(SessionManager.userId);

                SessionManager.userId = userService.getUserByUsername(username).getUserId();
                SessionManager.name = userService.getUserByUsername(username).getName();

                new Home().setVisible(true);

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    /**
     * fungsi untuk melakukan registrasi
     * @param name
     * @param email
     * @param phone
     * @param username
     * @param password
     * @return boolean register
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean register(String name, String email, String phone, String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

        User user = new User(0, name, email, username, BCrypt.hashpw(password, BCrypt.gensalt(12)), phone);

        if(userService.insert(user)){
            Mailer.sendMail(email, user);
            return true;
        }
        
        return false;

    }

}
