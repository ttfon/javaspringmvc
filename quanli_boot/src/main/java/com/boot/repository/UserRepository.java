/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.repository;

import com.boot.pojos.User;

import java.util.List;

/**
 *
 * @author AD
 */
public interface UserRepository {
    List<User> getUsers(String username);
    boolean addUser(User user);
    boolean delete(int id);
    User getUserById(int id);
    List<User> getAllUser();  
    boolean updateUser(User user);
    void updateUserwAvatar(User user);
    List<User> getAllUserByName(String name);
     User getAllUserByus(String name);
     List<User> getAllUserTaiXe();
   
}
