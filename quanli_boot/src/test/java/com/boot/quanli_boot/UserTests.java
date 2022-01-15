package com.boot.quanli_boot;

import com.boot.pojos.User;
import com.boot.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTests {
    @Autowired
    private UserService userService;
    private final String username = "testusername";

    @Before
    void init(){

    }

    @Test
    @Order(1)
    void addUserTest(){
        User user = new User();
        user.setUsername(username);
        user.setPassword("testuserpassword");
        user.setHoten("testfullname");
        user.setEmail("test@gmail.com");
        user.setSdt("0123456789");
        Assertions.assertTrue(userService.addUser(user));
    }

    @Test
    @Order(2)
    void getUserTest(){
        List<User> userList = userService.getUsers(username);
        boolean test = userList.size() > 0;
        Assertions.assertTrue(test);
    }

    @Test
    @Order(3)
    void defaultUserRoleTest(){
        List<User> userList = userService.getUsers(username);
        User user = userList.get(0);
        Assertions.assertEquals("ROLE_USER", user.getUserRole());
    }

    @Test
    @Order(4)
    void getUserByIDTest(){
        User user = new User();
        user.setUsername("testusername2");
        user.setPassword("testuserpassword2");
        user.setHoten("testfullname2");
        user.setEmail("test2@gmail.com");
        user.setSdt("9876543120");
        userService.addUser(user);
        boolean test = userService.getAllUser().size() >= 1 + 1;
        Assertions.assertTrue(test);
    }

    @Test
    @Order(5)
    void updateUserTest(){
        List<User> userList = userService.getUsers(username);
        User user = userList.get(0);
        user.setHoten("updatedfullname");
        Assertions.assertTrue(userService.updateUser(user));
        user = userService.getUsers(username).get(0);
        Assertions.assertEquals("updatedfullname", user.getHoten());
    }


    @Test
    @Order(6)
    void deleteUserTest(){
        List<User> userList = userService.getAllUserByName(username);
        userList.forEach((User user) -> {
            Assertions.assertTrue(userService.delete(user.getId()));
        });
    }


}
