
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <!-- JQuerry library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<%--    <script type="text/javascript">--%>
<%--        $(document).on("click", "#show_all_products", function () {--%>
<%--            $("#for_product_list > tbody").remove();--%>
<%--            $.get("http://localhost:9090/criteriaDemo_war_exploded/main/course", function (responseJson) {--%>
<%--                var $tbody = $("<tbody>").appendTo($("#for_product_list"));--%>
<%--                $.each(responseJson, function (index, product) {--%>
<%--                    $("<tr>").appendTo($tbody)--%>
<%--                        .append($("<td>").text(product.id))--%>
<%--                        .append($("<td>").text(product.productName))--%>
<%--                        .append($("<td>").text(product.cost));--%>
<%--                });--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>
    <title>All products</title>
</head>
<body>
<H2>Product list</H2>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Products</h2></caption>
        <tr>
            <th>Image</th>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <c:if test="${product.logo != null}">
                    <td><img style="display: block; width: 100px; height: 100px;"  src='data:image/jpg;base64,${product.logo}'></td>
                </c:if>
                <c:if test="${product.logo == null}">
                    <td>??????????? <br> ??????????</td>
                </c:if>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.description}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
