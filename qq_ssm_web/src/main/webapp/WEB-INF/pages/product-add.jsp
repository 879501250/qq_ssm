<%--
  Created by IntelliJ IDEA.
  User: 齐
  Date: 2020/12/12
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>product-add</title>
    <% pageContext.setAttribute("ctp", request.getContextPath());%>
    <script type="text/javascript" src="${ctp}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function formsub() {
            var href = document.getElementById("jsonForm").action;
            var data = JSON.stringify(getFormData("jsonForm"));
            $.ajax({
                url: href,
                type: "post",
                data: data,
                headers: {'Content-Type':'application/json; charset=utf8'}, //指定请求参数类型是json
                success:function() {
                    location.href="/qq_ssm_web/findAll"; //请求成功后跳转页面
                }
            });
        }
    </script>
</head>
<body>
<h1>
    <c:choose>
        <c:when test="${empty param.id}">
            添加新商品
        </c:when>
        <c:otherwise>
            修改商品
        </c:otherwise>
    </c:choose>
</h1>
<p>${msg}</p>
<hr/>
<c:choose>
    <c:when test="${empty msg}">
        <%--表单标签库:通过SpringMVC的表单标签可以将模型数据中的属性和HTML表单元素绑定
            以实现表单数据更便捷编辑和表单值的回显
            告诉表单标签从请求域中获取了一个product对象，封装给表单标签--%>
        <h2>利用表单标签完成Rest风格的操作</h2>
        <form:form action="${ctp}/productRest" modelAttribute="product" method="post">
            <%-- Rest风格的请求：根据是否传来id判断添加/修改商品，发送了POST/PUT请求--%>
            <input type="hidden" name="_method" value=
            <c:choose>
                <c:when test="${empty param.id}">
                    "POST"
                </c:when>
                <c:otherwise>"PUT"</c:otherwise>
            </c:choose> >
            <%--path必填，1)是原来input的name属性，2)自动回显隐含模型中某个对象对应的这个属性的值--%>
            <input type="hidden" name="id" value="${param.id}">
            <input type="hidden" name="departureTime" id="departureTime0" value="${product.departureTimeStr }">
            产品编号<form:input path="productNum"/><br/>
            产品名称<form:input path="productName"/><br/>
            <!--
            items="",指定要遍历的集合;自动遍历；遍历出的每一个元素是一个department对象
            itemLabel="属性名",指定属性遍历出的这个对象的哪个属性是作为option标签体的值
            itemValue="属性名",指定刚才遍历出来的这个对象的哪个属性是作为要提交的value值-->
            出发城市<form:select path="city.cid"
                             items="${citys}" itemLabel="cname" itemValue="cid"></form:select><br/>
            出发时间<input name="producttime" type="text" class="laydate" autocomplete="off"><br/>
            产品价格<form:input path="productPrice"/><br/>
            产品描述<form:input path="productDesc"/><br/>
            产品状态<form:radiobutton path="productStatus" value="1"/>开启
            <form:radiobutton path="productStatus" value="0"/>关闭<br/>
            <input type="submit" value="提交">
        </form:form>
        <hr/>
        <h2>利用普通表单发送json数据请求的操作</h2>
        <form action=
            <c:choose>
                <c:when test="${empty param.id}">
                    "${ctp}/productJson"
                </c:when>
                <c:otherwise>"${ctp}/productJson/${param.id}"</c:otherwise>
            </c:choose> method="post" id="jsonForm">
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" id="departureTime1" name="departureTime" value="${product.departureTimeStr }">
        产品编号<input value="${product.productNum}" type="text" name="productNum"><br/>
        产品名称<input value="${product.productName}" type="text" name="productName"><br/>
        出发城市<select name="city.cid">
        <c:forEach items="${citys}" var="city">
            <option value="${city.cid}"
                    <c:if test="${product.city.cid==city.cid}">selected="selected"</c:if>>
                    ${city.cname}
            </option>
        </c:forEach>
        </select><br/>
        出发时间<input type="text" name="producttime" class="laydate" autocomplete="off"><br/>
        产品价格<input value="${product.productPrice}" type="text" name="productPrice"><br/>
        产品描述<input value="${product.productDesc}" type="text" name="productDesc"><br/>
        产品状态<input type="radio" name="productStatus" value="1"
        <c:if test="${product.productStatus==1}">checked="checked"</c:if>>开启
        <input type="radio" name="productStatus" value="0"
               <c:if test="${product.productStatus==0}">checked="checked"</c:if>>关闭<br/>
        <input type="button" value="提交" id="subbtn" onclick="formsub()">
        </form>
        <hr/>
        <a href="findAll">返回</a>
    </c:when>
    <c:otherwise>
        <h3>${msg}</h3>
        <a href="findAll">我错了，这就回去！</a>
    </c:otherwise>
</c:choose>
<script src="layui/laydate/laydate.js"></script>
<script>
    var allDate = $(document).find('.laydate');
    //1)index - 选择器的 index 位置 2)el - 当前的元素（也可使用 "this" 选择器）
    allDate.each(function (index, el) {
        $(this).removeAttr("lay-key");
        laydate.render({
            elem: this, //指定元素,解决多次打开模态框闪退问题
            value: '${product.departureTimeStr }', //赋初始值
            trigger: 'click',
            ready: function (date) {
                $(".laydate").removeAttr("lay-key");
                $(this).attr("lay-key", "1");
            },
            done: function (value) {
                document.getElementById('departureTime' + index).value = value;
            }
        });
    });

    /**
     * 将表单数据封装为json
     * @param form
     * @returns
     */
    function conveterParamsToJson(paramsAndValues) {
        var jsonObj = {};
        var param = paramsAndValues.split("&");
        for ( var i = 0; param != null && i < param.length; i++) {
            var para = param[i].split("=");
            if(para[0].indexOf(".") != -1){
                var par = para[0].split(".");
                var city = {};
                city[par[1]] = para[1];
                jsonObj[par[0]] = city;
                continue;
            }
            if(para[1].indexOf("\"") != -1){
                para[1] = para[1].replace(/\"/g,"&#34;"); //将字符串中的双引号转化为实体编码
            }
            jsonObj[para[0]] = para[1];
        }
        return jsonObj;
    };
    function getFormData(form) {
        var formValues = $("#" + form).serialize();
        //关于jquery的serialize方法转换空格为+号的解决方法
        //要使用params = decodeURIComponent(data ,true)进行解码，不然中文数据会乱码。
        formValues = formValues.replace(/\+/g," ");   // g表示对整个字符串中符合条件的都进行替换
        var temp =  decodeURIComponent(formValues);
        temp = JSON.stringify(conveterParamsToJson(temp));
        temp =  decodeURIComponent(temp);
        temp = temp.replace(/\\/g,""); // 第一个\为转义字符
        //var temp = temp.replace(/"/g,"&#34;") // 第一个\为转义字符
        //parse用于将一个 JSON 字符串转换为对象
        var queryParam = typeof temp == 'string'?JSON.parse(temp):temp;
        return queryParam;
    };
</script>
</body>
</html>
