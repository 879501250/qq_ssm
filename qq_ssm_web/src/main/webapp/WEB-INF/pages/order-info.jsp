<%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/15
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>order-info</title>
    <% pageContext.setAttribute("ctp", request.getContextPath()); %>
</head>
<body>
<h2>订单管理<a href="${ctp}/orders/findAll?pageNum=1&pageSize=5">返回</a></h2>
<hr/>
<h4>订单信息</h4>
订单编号<input type="text" disabled="disabled" value="${order.orderNum}">
下单时间<input type="text" disabled="disabled" value="${order.orderTimeStr}">
路线名称<input type="text" disabled="disabled" value="${order.product.productName}">
出发城市<input type="text" disabled="disabled" value="${order.product.city.cname}">
出发时间<input type="text" disabled="disabled" value="${order.product.departureTimeStr}">
出游人数<input type="text" disabled="disabled" value="${order.peopleCount}">
其他信息<input type="text" disabled="disabled" value="${order.orderDesc}">
<hr/>
<h4>游客信息</h4>
<table>
    <tr>
        <th>人群</th>
        <th>姓名</th>
        <th>性别</th>
        <th>手机号码</th>
        <th>证件类型</th>
        <th>证件号码</th>
    </tr>
    <c:forEach items="${order.travellers}" var="traveller">
        <tr>
            <td>${traveller.travellerTypeStr}</td>
            <td>${traveller.name}</td>
            <td>${traveller.sex}</td>
            <td>${traveller.phoneNum}</td>
            <td>${traveller.credentialsTypeStr}</td>
            <td>${traveller.credentialsNum}</td>
        </tr>
    </c:forEach>
</table>
<hr/>
<h4>联系人信息</h4>
会员<input type="text" disabled="disabled" value="${order.member.nickname}">
联系人<input type="text" disabled="disabled" value="${order.member.name}">
手机号<input type="text" disabled="disabled" value="${order.member.phoneNum}">
邮箱<input type="text" disabled="disabled" value="${order.member.email}">
<hr/>
<h4>费用信息</h4>-${order.orderStatus==1?"已支付":"未支付"}
支付方式<input type="text" disabled="disabled" value="${order.payTypeStr}">
金额<input type="text" disabled="disabled" value="${order.product.productPrice}">
</body>
</html>
