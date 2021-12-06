package com.example.servlet.dao;

import com.example.servlet.User;

public interface UserDao {
    int addUser(String username, String password, String birthday, String filePath);

    User findUser(String username, String password);
}
