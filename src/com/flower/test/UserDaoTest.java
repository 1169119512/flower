package com.flower.test;

import com.flower.dao.UserDao;
import com.flower.dao.impl.UserDaoImpl;
import com.flower.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void querryUserByUserName() {
        if((userDao.querryUserByUserName("admin"))== null){
            System.out.println("用户名可用！");
        }
        else{
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void querryUserByUserNameAndPassword() {
        if(userDao.querryUserByUserNameAndPassword("admin","admin") == null){
            System.out.println("账号密码错误，登录失败");
        }
        else{
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"inmthera","123456","wjjwdsssj@qq.com")));

    }
}