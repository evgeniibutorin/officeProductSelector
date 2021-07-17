<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- JQuerry library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>All products</title>
</head>
<body>
<H2>Product list</H2>
<h3>
    <p>"${sessionScope.user.getName()}"</p>
    <p>"${sessionScope.user.getStatus()}"</p>
<c:if test="${sessionScope.user.isAdmin()}">
    <a href="/officeProductSelector_war_exploded/main/admin/new">Add New Product</a>
    <br>
</c:if>
    <a href="/officeProductSelector_war_exploded">Main page</a>
    <br>
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
                        <td>Изображение <br> отсутсвует</td>
                    </c:otherwise>
                </c:choose>
               <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.description}" /></td>
                <td>
                    <a href="/officeProductSelector_war_exploded/main/details?id=<c:out value='${product.id}' />">Details</a>

                    <c:if test="${sessionScope.user.isAdmin()}">
                    <a href="/officeProductSelector_war_exploded/main/admin/edit?id=<c:out value='${product.id}' />">Edit</a>

                    <a href="/officeProductSelector_war_exploded/main/admin/delete?id=<c:out value='${product.id}' />">Delete</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
