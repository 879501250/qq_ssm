<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/11
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
    <% pageContext.setAttribute("ctp", request.getContextPath()); %> <!--设置项目路径-->
    <script type="text/javascript" src="${ctp}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<h2>这是所有的商品信息！<%=new Date() %><a href="${ctp}/">返回首页</a></h2>
<h2>${msg}</h2>
<button onclick="location.href='${pageContext.request.contextPath}/toProductPage'">
    添加商品
</button>
<table>
    <tr>
        <th>ID</th>
        <th>编号</th>
        <th>产品名称</th>
        <th>出发城市</th>
        <th>出发时间</th>
        <th>产品价格</th>
        <th>产品描述</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.productNum}</td>
            <td>${product.productName}</td>
            <td>${product.city.cname}</td>
            <td>${product.departureTimeStr}</td>
            <td>${product.productPrice}</td>
            <td>${product.productDesc}</td>
            <td>${product.productStatusStr}</td>
            <td>
                <a href="${pageContext.request.contextPath}/updateStatus/${product.id}">
                        ${product.productStatus==1?"关闭":"开启"}
                </a>|
                <a href="${pageContext.request.contextPath}/toProductPage?id=${product.id}">修改</a>|
                <a href="${ctp}/query?id=${product.id}" class="query">查询Json信息</a>|
                <a href="${ctp}/productRest/${product.id}" class="delbtn">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%-- 点击上方“删除”超链接通过js提交下方表单发送Rest风格的请求：根据id删除商品，发送了DELETE请求--%>
<form action="" method="post" id="deleteForm">
    <input type="hidden" value="DELETE" name="_method">
</form>
<div></div>
<script type="text/javascript">
    $(".query").click(function () {
        var href = this.href;
        alert(href);
        $.ajax({ //发送ajax查询该商品详细信息并在页面上打印
            url: href,
            type: "GET",
            success: function (data) {
                //将返回的json数据在页面显示
                var product = data.departureTimeStr + "-->" + data.city.cname +
                    "-->" + data.productDesc + "-->" + data.productName + "<br/>";
                $("div").append(product);
            }
        });
        //页面不进行跳转
        return false;
    });
    $(function () {
        $(".delbtn").click(function () {
            //1、改变表单的action指向，this指此时点击的超链接
            $("#deleteForm").attr("action", this.href);
            //2、提交表单（与点击submit按钮提交效果一样）
            $("#deleteForm").submit();
            return false;
        })
    })
</script>
</body>
</html>
