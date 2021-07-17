<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<div>
    <h1>Product Management</h1>
    <h2>
        <a href="/officeProductSelector_war_exploded">Main page</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/officeProductSelector_war_exploded/main/list">List All Products</a>

        <a href="/officeProductSelector_war_exploded/logOut">Log out</a>
    </h2>
</div>
<div align="center">
    <c:if test="${product != null}">
    <form action="/officeProductSelector_war_exploded/main/admin/update" method="post" enctype="multipart/form-data">
        </c:if>
        <c:if test="${product == null}">
        <form action="/officeProductSelector_war_exploded/main/admin/insert" method="post" enctype="multipart/form-data">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${product != null}">
                            Edit Product
                        </c:if>
                        <c:if test="${product == null}">
                            Add New Product
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
                </c:if>
                <tr>
                    <th>Product Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${product.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Description: </th>
                    <td>
                        <input type="text" name="description" size="45"
                               value="<c:out value='${product.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Logo: </th>
                    <td>
                        <input type="file" name="file"/>
                        <c:if test="${product != null}"><input type="checkbox" name="doChange" value="yes">Звменить изорбражение?</c:if>

                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>