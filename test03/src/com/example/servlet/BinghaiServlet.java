package com.example.servlet;

import com.example.jdbc.QueryRunner;
import com.example.jdbc.handler.BeanListHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author youngoo
 */
@WebServlet(name = "BinghaiServlet", value = "/chonghai")
public class BinghaiServlet extends HttpServlet {

    private final QueryRunner queryRunner = new QueryRunner();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = (String) request.getParameter("name");
        System.out.println(name);
        List<Binghai> binghaiList;
        if (name != null) {
            binghaiList = queryRunner.query("SELECT * FROM pest WHERE NAME LIKE(CONCAT(?, '%'))", new BeanListHandler<>(Binghai.class), name);
        } else {
            binghaiList = queryRunner.query("select * from pest", new BeanListHandler<>(Binghai.class));
        }
        request.setAttribute("binghaiList", binghaiList);
        request.getRequestDispatcher("./binghai.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
