package com.example.servlet.service.impl;

import com.example.servlet.Result;
import com.example.servlet.User;
import com.example.servlet.dao.UserDao;
import com.example.servlet.dao.impl.UserDaoImpl;
import com.example.servlet.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youngoo
 * @date 2021/12/2 21:31
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(String username, String password, String birthday, String filePath) {
        int row = userDao.addUser(username, password, birthday, filePath);
        return row != 0;

    }

    @Override
    public Result<Map<String, User>> login(String username, String password) {

        User user = userDao.findUser(username, password);
        Result<Map<String, User>> userResult = new Result<>();
        if (user != null) {
            userResult.setCode(0);
            userResult.setMsg("成功");
            HashMap<String, User> userData = new HashMap<>();
            userData.put("userInfo", user);
            userResult.setData(userData);
        } else {
            userResult.setCode(1);
            userResult.setMsg("用户名或密码错误！");
        }
        return userResult;
    }
}
