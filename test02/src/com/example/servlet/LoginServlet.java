package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.servlet.service.UserService;
import com.example.servlet.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * @author youngoo
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Result<Map<String, User>> result = userService.login(username, password);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(JSON.toJSONString(result));
    }
}
