<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/17
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user-add-role</title>
    <%pageContext.setAttribute("ctp", request.getContextPath());%>
    <script type="text/javascript" src="${ctp}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<h2>为用户添加角色<%=new Date() %>
</h2>
<hr/>
<table>
    <tr>
        <th><input type="checkbox"></th>
        <th>ID</th>
        <th>角色名称</th>
        <th>描述</th>
    </tr>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td><input class="chk" type="checkbox" id="${role.id}"></td>
            <td>${role.id}</td>
            <td>${role.roleName}</td>
            <td>${role.roleDesc}</td>
        </tr>
    </c:forEach>
</table>
<a href="${ctp}/users/addRoles?userid=${userid}&roleid=" class="add" id="addRoles">添加</a>
<a href="${ctp}/users/findAll?pageNum=1&pageSize=5">返回</a>
<script>
    $(".add").click(function () {
        var a = document.getElementById("addRoles");
        var chks = document.getElementsByClassName("chk");
        for (var i in chks) {
            if (chks[i].checked)
                a.href += chks[i].id + ',';
        }
    })
</script>
</body>
</html>
