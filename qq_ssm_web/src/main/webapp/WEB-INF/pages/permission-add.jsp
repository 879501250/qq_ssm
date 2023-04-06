<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/17
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>permission-add</title>
    <% pageContext.setAttribute("ctp",request.getContextPath());%>
</head>
<body>
<h2>添加权限<%=new Date()%></h2><hr/>
<form action="${ctp}/permissions/addPermission" method="post">
    URL：<input type="text" name="url"><br/>
    权限名：<input type="text" name="permissionName"><br/>
</select><br/>
    <input type="submit" value="提交">
    <a href="${ctp}/permissions/findAll?pageNum=1&pageSize=5">返回</a>
</form>
</body>
</html>
