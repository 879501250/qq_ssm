<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/16
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
    <% pageContext.setAttribute("ctp", request.getContextPath()); %>
</head>

<body>
<h2>登录<%=new Date()%>
</h2>
<form action="login" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="tom"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" value="123"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
