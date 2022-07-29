package com.flower.dao;

import com.flower.pojo.User;

public interface UserDao {

    public User querryUserByUserName(String username);

    public User querryUserByUserNameAndPassword(String username, String password);

    public int saveUser(User user);


}
