package com.example.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonString;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用来处理文件上传的Servlet
 * @author youngoo
 */
@WebServlet(name = "FileUploadServlet", value = "/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageDir = request.getServletContext().getRealPath("image");
        File file = new File(imageDir);
        if (!file.exists()) {
            boolean b = file.mkdir();
        }
        Part image = request.getPart("file");
        UUID uuid = UUID.randomUUID();
        int i = image.getSubmittedFileName().indexOf(".");
        String filePath = imageDir +"\\" + uuid.toString() + image.getSubmittedFileName().substring(i);
        image.write(filePath);
        if (new File(filePath).exists()) {
            // 创建成功
            response.setContentType("application/json; charset=utf-8");
            Result<HashMap<String, String>> result = new Result<>();
            result.setCode(0);
            result.setMsg("成功");
            HashMap<String, String> data = new HashMap<>();
            data.put("src", filePath);
            result.setData(data);
            response.getWriter().println(JSON.toJSONString(result));
        }
    }
}