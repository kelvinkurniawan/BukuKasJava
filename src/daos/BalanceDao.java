/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Balance;

/**
 *
 * @author kelvi
 */
public interface BalanceDao {
    public Balance getBalanceByUserId(int UserId);
    public boolean insert(Balance balance);
}
