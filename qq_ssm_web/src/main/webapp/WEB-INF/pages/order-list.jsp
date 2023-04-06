<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/15
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>order-list</title>
    <% pageContext.setAttribute("ctp", request.getContextPath());%>
    <script type="text/javascript" src="${ctp}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<h2>这是所有的订单信息！<%=new Date() %><a href="${ctp}/">返回首页</a></h2>
<h2>${msg}</h2>
<table>
    <tr>
        <th>ID</th>
        <th>订单编号</th>
        <th>产品名称</th>
        <th>金额</th>
        <th>下单时间</th>
        <th>订单状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.orderNum}</td>
            <td>${order.product.productName}</td>
            <td>${order.product.productPrice}</td>
            <td>${order.orderTimeStr}</td>
            <td>${order.orderStatus==1?"已支付":"未支付"}</td>
            <td>
                <a href="#">产品</a>|
                <a href="${ctp}/orders/orderInfo?id=${order.id}">详情</a>|
                <a href="#">编辑</a>|
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
        <a href="${ctp}/orders/findAll?pageNum=1&pageSize=${pageInfo.pageSize}">首页</a>
    </li>
    <li style="float: left;padding: 2em;list-style: none">
        <a href="${ctp}/orders/findAll?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">
            上一页
        </a>
    </li>
    <c:forEach end="${pageInfo.pages}" var="num" begin="1">
        <li style="float: left;padding: 2em;list-style: none">
            <a href="${ctp}/orders/findAll?pageNum=${num}&pageSize=${pageInfo.pageSize}">
                第${num}页
            </a>
        </li>
    </c:forEach>
    <li style="float: left;padding: 2em;list-style: none">
        <a href="${ctp}/orders/findAll?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">
            下一页
        </a>
    </li>
    <li style="float: left;padding: 2em;list-style: none">
        <a href="${ctp}/orders/findAll?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">
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
        location.href = "${ctp}/orders/findAll?pageNum=1&pageSize=" + pageSize;
    }
</script>
</body>
</html>
