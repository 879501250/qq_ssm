<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/17
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>role-add-permission</title>
    <%pageContext.setAttribute("ctp", request.getContextPath());%>
    <script type="text/javascript" src="${ctp}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<h2>为角色添加权限<%=new Date() %>
</h2>
<hr/>
<table>
    <tr>
        <th><input type="checkbox"></th>
        <th>ID</th>
        <th>权限名称</th>
        <th>URL</th>
    </tr>
    <c:forEach items="${permissions}" var="permission">
        <tr>
            <td><input class="chk" type="checkbox" id="${permission.id}"></td>
            <td>${permission.id}</td>
            <td>${permission.permissionName}</td>
            <td>${permission.url}</td>
        </tr>
    </c:forEach>
</table>
<a href="${ctp}/roles/addPermissions?roleid=${roleid}&permissionid=" class="add" id="addPermissions">添加</a>
<a href="${ctp}/roles/findAll?pageNum=1&pageSize=5">返回</a>
<script>
    $(".add").click(function () {
        var a = document.getElementById("addPermissions");
        var chks = document.getElementsByClassName("chk");
        for (var i in chks) {
            if (chks[i].checked)
                a.href += chks[i].id + ',';
        }
    })
</script>
</body>
</html>
