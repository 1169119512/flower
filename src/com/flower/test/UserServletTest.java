package com.flower.test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class UserServletTest {

    @Test
    public void login() {
        System.out.println("这是login()方法调用了");
    }

    @Test
    public void regist() {
        System.out.println("这是regist()方法调用了");
    }

    @Test
    public void updateUser() {
        System.out.println("这是updateUser()方法调用了");
    }

    @Test
    public void updateUserPassword() {
        System.out.println("这是updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);

            method.invoke(new UserServletTest());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    }
