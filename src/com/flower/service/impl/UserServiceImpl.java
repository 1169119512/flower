package com.flower.service.impl;

import com.flower.dao.UserDao;
import com.flower.dao.impl.UserDaoImpl;
import com.flower.pojo.User;
import com.flower.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.querryUserByUserNameAndPassword(user.getUsername(),user.getPassword());
}

    @Override
    public boolean existsUsername(String username) {
        if(userDao.querryUserByUserName(username) != null){
            return true;
        }
        return false;
    }
}
