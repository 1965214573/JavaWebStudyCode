package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.example.servlet.service.UserService;
import com.example.servlet.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author youngoo
 */
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String filePath = request.getParameter("filePath");
        String msg;
        if (userService.register(username, password, birthday, filePath)) {
            msg = "注册成功";
        } else {
            msg = "注册失败";
        }
        Result<Map> result = new Result<>();
        result.setCode(0);
        result.setMsg(msg);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(JSON.toJSONString(result));


    }
}
