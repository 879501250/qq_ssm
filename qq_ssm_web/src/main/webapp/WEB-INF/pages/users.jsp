<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/16
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>users</title>
    <% pageContext.setAttribute("ctp",request.getContextPath());%>
    <script type="text/javascript" src="${ctp}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<h2>这是所有的用户信息！<%=new Date() %><a href="${ctp}/">返回首页</a></h2>
    <h2>${msg}</h2>
    <button onclick="location.href='${pageContext.request.contextPath}/users/toAddUser'">
        添加用户
    </button>
    <table>
        <tr>
            <th><input type="checkbox"></th>
            <th>ID</th>
            <th>用户名</th>
            <th>邮箱</th>
            <th>联系电话</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="user">
            <tr>
                <td><input type="checkbox"></td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.phoneNum}</td>
                <td>${user.statusStr}</td>
                <td>
                    <a href="${ctp}/users/findUserInfo?id=${user.id}" class="query">详情</a>|
                    <a href="${ctp}/users/toAddRole?id=${user.id}" class="delbtn">添加角色</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<hr/>
订单共${pageInfo.total}条数据，每页
<select id="pageSize" onchange="changePageSize()">
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
</select>条，共${pageInfo.pageNum}/${pageInfo.pages}页&nbsp;&nbsp;&nbsp;&nbsp;
<ul>
    <li style="float: left;padding: 2em;list-style: none">
        <a href="${ctp}/users/findAll?pageNum=1&pageSize=${pageInfo.pageSize}">首页</a>
    </li>
    <li style="float: left;padding: 2em;list-style: none">
        <a href="${ctp}/users/findAll?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">
            上一页
        </a>
    </li>
    <c:forEach end="${pageInfo.pages}" var="num" begin="1">
        <li style="float: left;padding: 2em;list-style: none">
            <a href="${ctp}/users/findAll?pageNum=${num}&pageSize=${pageInfo.pageSize}">
                第${num}页
            </a>
        </li>
    </c:forEach>
    <li style="float: left;padding: 2em;list-style: none">
        <a href="${ctp}/users/findAll?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">
            下一页
        </a>
    </li>
    <li style="float: left;padding: 2em;list-style: none">
        <a href="${ctp}/users/findAll?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">
            尾页
        </a>
    </li>
</ul>
<script type="text/javascript">
    $(function () {
        var pageSize = GetQueryString("pageSize");
        var obj = document.getElementById('pageSize');
        for (i = 0; i < obj.length; i++) {
            if (obj[i].value == pageSize)
                obj[i].selected = true;
        }
    });

    //采用正则表达式获取地址栏参数
    function GetQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null)
            return unescape(r[2]);
        return null;
    };

    function changePageSize() {
        //获取下拉列表选中的值
        var pageSize = $("#pageSize").val();
        //向服务器发送请求，改变每页显示的条数
        location.href = "${ctp}/users/findAll?pageNum=1&pageSize=" + pageSize;
    }
</script>
</body>
</html>

