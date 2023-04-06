<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/17
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>role-add</title>
    <% pageContext.setAttribute("ctp",request.getContextPath());%>
</head>
<body>
<h2>添加角色<%=new Date()%></h2><hr/>
<form action="${ctp}/roles/addRole" method="post">
    角色名称：<input type="text" name="roleName"><br/>
    描述：<input type="text" name="roleDesc"><br/>
</select><br/>
    <input type="submit" value="提交">
    <a href="${ctp}/roles/findAll?pageNum=1&pageSize=5">返回</a>
</form>
</body>
</html>
