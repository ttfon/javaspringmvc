/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service;

import java.util.List;

import com.boot.pojos.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author AD
 */
public interface UserService extends UserDetailsService{
    List<User> getUsers(String username);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean delete(int id);
    User getUserById(int id);
    List<User> getAllUser();
    void updateUserwAvatar(User user);
    List<User> getAllUserByName(String name);
    User getAllUserByus(String name);
    List<User> getAllUserTaiXe();
}
