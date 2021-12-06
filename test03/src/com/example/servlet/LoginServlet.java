package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author youngoo
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    /**
     * 记住密码的标志
     */
    final String REMEMBER_FLAG = "on";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String remember = request.getParameter("remember");
        
        // 验证码校验
        String code1 = (String) request.getSession().getAttribute("code");
        if (code1.equals(code)) {
            // 校验用户信息
            if ("admin".equals(username) && "123456".equals(password)) {
                // 校验成功
                if (REMEMBER_FLAG.equals(remember)) {
                    // 保存登录信息
                    Cookie username1 = new Cookie("username", username);
                    username1.setMaxAge(60 * 60 * 24 * 7);
                    Cookie password1 = new Cookie("password", password);
                    password1.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(username1);
                    response.addCookie(password1);
                } else {
                    // 清空cookies
                    Cookie username1 = new Cookie("username", null);
                    username1.setMaxAge(0);
                    Cookie password1 = new Cookie("password", null);
                    password1.setMaxAge(0);
                    response.addCookie(username1);
                    response.addCookie(password1);
                }
                // 保存用户信息到session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                response.sendRedirect("./indexPage");
            } else {
                // 转发到登录页面并提示错误信息
                request.setAttribute("msg", "账号或密码错误");
                request.getRequestDispatcher("./loginPage").forward(request, response);
            }
        } else {
            // 转发到登录页面并提示错误信息
            request.setAttribute("msg", "验证码有误");
            request.getRequestDispatcher("./loginPage").forward(request, response);
        }
    }
}
