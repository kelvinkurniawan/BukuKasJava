/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.User;

/**
 *
 * @author kelvi
 */
public interface UserDao {
    public boolean insert(User user);
    public User getUserByUsername(String username);
}
