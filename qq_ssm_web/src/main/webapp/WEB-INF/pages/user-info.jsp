<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/17
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user-info</title>
    <% pageContext.setAttribute("ctp",request.getContextPath());%>
</head>
<body>
<h2>用户管理<%=new Date() %><a href="${ctp}/users/findAll?pageNum=1&pageSize=5">返回</a></h2><hr/>
<table>
    <tr>
        <th>名称</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>
            <h4>${userinfo.username}</h4>
            <ul>
                <c:forEach items="${userinfo.roles}" var="role">
                    <li>
                        ${role.roleName}
                            <ul>
                                <c:forEach items="${role.permissions}" var="permission">
                                    <li>
                                            ${permission.permissionName}
                                    </li>
                                </c:forEach>
                            </ul>
                    </li>
                </c:forEach>
            </ul>
        </td>
        <td>
            <br/>
            <ul>
                <c:forEach items="${userinfo.roles}" var="role">
                    <li>
                            ${role.roleDesc}
                        <ul>
                            <c:forEach items="${role.permissions}" var="permission">
                                <li>
                                        ${permission.url}
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </td>
        <td>
            <br/>
            <ul>
                <c:forEach items="${userinfo.roles}" var="role">
                    <li>
                            <a href="${ctp}/users/delRole?userid=${userinfo.id}&roleid=${role.id}">删除</a>
                        <ul>
                            <c:forEach items="${role.permissions}" var="permission">
                                <li>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>
</body>
</html>
