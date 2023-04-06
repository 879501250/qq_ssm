<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<% pageContext.setAttribute("ctp", request.getContextPath());%>
<body>
<h2>Hello World!<a href="${pageContext.request.contextPath}/logout">注销</a></h2>
<a href="${pageContext.request.contextPath}/findAll">查询所有产品信息</a><hr/>
<a href="${ctp}/orders/findAll?pageNum=1&pageSize=5">查询所有订单信息</a><hr/>
<a href="${ctp}/users/findAll?pageNum=1&pageSize=5">查询所有用户信息</a><hr/>
<a href="${ctp}/roles/findAll?pageNum=1&pageSize=5">查询所有角色信息</a><hr/>
<a href="${ctp}/permissions/findAll?pageNum=1&pageSize=5">查询所有权限信息</a>
<input type="text" id="laydate">
<script src="layui/laydate/laydate.js"></script>
<script>
    //执行一个laydate实例
    laydate.render({
        elem: '#laydate', //指定元素
        value: '1989-10-14', //赋初始值
        done: function (value) {
            console.log(value)
        }
    });
</script>
</body>
</html>
