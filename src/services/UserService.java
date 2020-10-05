/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;

/**
 *
 * @author kelvi
 */
public interface UserService {
    
    public User getUserByUsername(String username);
    public boolean insert(User user);
    
}
