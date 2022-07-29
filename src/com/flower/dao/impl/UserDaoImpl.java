package com.flower.dao.impl;


import com.flower.dao.BaseDao;
import com.flower.dao.UserDao;
import com.flower.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User querryUserByUserName(String username) {
        String sql = "SELECT id,username,password,email from t_user where username = ?";
        return querryForOne(User.class,sql,username);
    }

    @Override
    public User querryUserByUserNameAndPassword(String username, String password) {
        String sql = "SELECT id,username,password,email from t_user where username = ? AND password = ?";
        return querryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values (?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
