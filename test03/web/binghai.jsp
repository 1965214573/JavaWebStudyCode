<%@ page import="com.example.servlet.Binghai" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: youngoo
  Date: 2021/12/7
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>病虫害一览</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<div class="connoisseur">
    <div class="conform">
        <form>
            <!--<div class="cfD">-->
            <!--工作年限：<select><option>1年以内</option></select> 审核状态：<label><input-->
            <!--type="radio" checked="checked" name="styleshoice1" />&nbsp;未审核</label> <label><input-->
            <!--type="radio" name="styleshoice1" />&nbsp;已通过</label> <label class="lar"><input-->
            <!--type="radio" name="styleshoice1" />&nbsp;不通过</label> 推荐状态：<label><input-->
            <!--type="radio" checked="checked" name="styleshoice2" />&nbsp;是</label><label><input-->
            <!--type="radio" name="styleshoice2" />&nbsp;否</label>-->
            <!--</div>-->
            <div class="cfD">
                <form action="chonghai" method="post">
                    <input class="addUser" type="text" name="name" placeholder="输入病害名称" />
                    <input class="addUser" type="text" placeholder="输入病害症状" />
                    <input type="submit" value="搜索" class="button"/>
                </form>

                <a class="addA addA1" href="addbinghai.html">添加新病害+</a>
            </div>
        </form>
    </div>
    <!-- banner 表格 显示 -->
    <div class="conShow">
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td style="width: 220px" class="tdColor">名称</td>
                <td style="width: 400px" class="tdColor">主要危害</td>
                <td style="width: 220px" class="tdColor">发病规律</td>
                <td style="width: 170px" class="tdColor">操作</td>
            </tr>

            <c:if test="${binghaiList != null}">
                <c:forEach var="binghai" items="${binghaiList}">
                    <tr>
                        <td>${binghai.name}</td>
                        <td>${binghai.mainDamage}</td>
                        <td>${binghai.occurredLaw}</td>
                        <td>
                            <a href="binghaimsg.html">
                                <img class="operation" src="img/find.png">
                            </a>
                            <img class="operation delban" src="img/delete.png">
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${binghaiList == null}">
                <tr>
                    <td colspan='4'>暂无数据</td>
                </tr>
            </c:if>

        </table>
        <div class="paging">此处是分页</div>
    </div>
    <!-- banner 表格 显示 end-->
</div>
</body>
</html>
