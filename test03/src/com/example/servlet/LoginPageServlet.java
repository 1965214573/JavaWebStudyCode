package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author youngoo
 */
@WebServlet(name = "LoginPageServlet", value = "/loginPage")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Cookie[] cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        String username = "";
        String password = "";
        String msg = (String) request.getAttribute("msg");
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            } else if ("password".equals(cookie.getName())) {
                password = cookie.getValue();
            }
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"content-type\" content='text/html;charset=utf-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>" + (msg == null ? "" : msg) + "</h3>");
        out.println("<form action='./login' method='post'>");
        out.println("用户名：<input type='text' name='username' autocomplete=\"off\" value='" + username +"'><br>");
        out.println("密码：<input type='password' name='password' value='" + password +"'><br>");
        out.println("验证码：<input type='text' name='code' autocomplete=\"off\" style='width=\"20px\"'><img src='./code' id='picCode' title='看不清？点击更换'><br>");
        out.println("记住密码一周：<input type='checkbox' name='remember' checked><br>");
        out.println(("<input type='submit' value='登录'>"));
        out.println("</form>");
        out.println("</body>");
        out.println("<script type=\"text/javascript\">\n" +
                "//图片的点击事件\n" +
                "document.getElementById(\"picCode\").onclick = function () {\n" +
                "    this.src = \"./code?n=\" + new Date().getTime();   //从服务器再次读取验证码\n" +
                "}\n" +
                "</script>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}