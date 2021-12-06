package com.example.servlet.dao.impl;

import com.example.jdbc.QueryRunner;
import com.example.jdbc.handler.BeanHandler;
import com.example.servlet.User;
import com.example.servlet.dao.UserDao;

/**
 * @author youngoo
 * @date 2021/12/2 21:33
 */
public class UserDaoImpl implements UserDao {

    private final QueryRunner queryRunner = new QueryRunner();

    @Override
    public int addUser(String username, String password, String birthday, String filePath) {
        return (int) queryRunner.insert("insert into users values(null,?,?,?,?)", username, password, birthday, filePath);
    }

    @Override
    public User findUser(String username, String password) {

        return queryRunner.query("select * from users where username = ? and password = ?", new BeanHandler<>(User.class), username, password);
    }
}
