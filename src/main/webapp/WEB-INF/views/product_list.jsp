
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <!-- JQuerry library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>All products</title>
</head>
<body>
<H2>Product list</H2>
<h3>
    <a href="/officeProductSelector_war_exploded">Main page</a>
    &nbsp;&nbsp;&nbsp;
    <a href="/officeProductSelector_war_exploded/logOut">Log out</a>

</h3>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Products</h2></caption>
        <tr>
            <th>Image</th>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <c:choose>
                    <c:when test="${product.logo != null && product.logo!=''}">
                        <td><img style="display: block; width: 100px; height: 100px;"  src='data:image/jpg;base64,${product.logo}'></td>
                    </c:when>
                    <c:otherwise>
                        <td>??????????? <br> ??????????</td>
                    </c:otherwise>
                </c:choose>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.description}" /></td>
                <td>
                    <a href="/officeProductSelector_war_exploded/main/details?id=<c:out value='${product.id}' />">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
