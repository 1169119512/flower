package com.flower.test;

import com.flower.pojo.User;
import com.flower.service.UserService;
import com.flower.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"bbj666","wucaimanfu","xuyou@qq.com"));
        userService.registerUser(new User(null,"bbj1666","111wucaimanfu","xuyou11@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"bbj161166","111wucaimanfu","xuyou11@qq.com")));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("bbj61166"));
    }
}