package com.example.servlet.service;

import com.example.servlet.Result;
import com.example.servlet.User;

import java.util.Map;

public interface UserService {

    boolean register(String username, String password, String birthday, String filePath);

    Result<Map<String, User>> login(String username, String password);
}
