<%--
  Created by IntelliJ IDEA.
  User: youngoo
  Date: 2021/12/6
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="./loginPage">点击登录</a>
  <a href="./chonghai">病害页面</a>
  <%
    request.setAttribute("test", "hello");
  %>
  <hr>
  el表达式测试
  <hr>
  ${test}
  </body>
</html>
