<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<div>
    <h1>Product Management</h1>
    <h2>
        <a href="new">Add New Product</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Products</a>

    </h2>
</div>
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
                <c:if test="${product.logo != null}">
                    <td><img style="display: block; width: 100px; height: 100px;"  src='data:image/jpg;base64,${product.logo}'></td>
                </c:if>
                <c:if test="${product.logo == null}">
                    <td>Изображение <br> отсутсвует</td>
                </c:if>
               <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.description}" /></td>
                <td>
                    <a href="/officeProductSelector_war_exploded/main/edit?id=<c:out value='${product.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/officeProductSelector_war_exploded/main/delete?id=<c:out value='${product.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>