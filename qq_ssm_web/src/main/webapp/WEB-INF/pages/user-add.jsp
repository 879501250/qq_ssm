<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/16
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user-add</title>
    <% pageContext.setAttribute("ctp",request.getContextPath());%>
</head>
<body>
<h2>添加用户<%=new Date()%></h2><hr/>
<form action="${ctp}/users/addUser" method="post">
    用户名称：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    邮箱：<input type="text" name="email"><br/>
    联系电话：<input type="text" name="phoneNum"><br/>
    用户状态<select name="status">
    <option value="0">关闭</option>
    <option value="1">开启</option>
</select><br/>
    <input type="submit" value="提交">
    <a href="${ctp}/users/findAll?pageNum=1&pageSize=5">返回</a>
</form>
</body>
</html>
