<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%--    Стили bootstrap--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <%--    jquery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <%--   Следующие две стили bootstrap--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <%--    Подключение иконочных шрифтов к примеру иконка "домой"--%>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <script type="text/javascript"
            src="http://localhost:9090/officeProductSelector_war_exploded/static/css/registration.js">
    </script>
    <title>Product</title>
    <link href="http://localhost:9090/officeProductSelector_war_exploded/static/css/radiostyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a href="#" class="navbar-brand"><img
                src="http://localhost:9090/officeProductSelector_war_exploded/static/css/lanit_logo.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <c:if test="${sessionScope.user.isAdmin()}">
                    <li class="nav-item">
                        <a href="/officeProductSelector_war_exploded/main/admin/new" class="nav-link">Добавить продукт</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a href="/officeProductSelector_war_exploded" class="nav-link">Главная страница</a>
                </li>
                <li class="nav-item">
                    <a href="/officeProductSelector_war_exploded/logOut" class="nav-link">Выйти</a>
                </li>
                <li class="nav-item">
                    <p class="nav-link user-name"> Пользователь: "${sessionScope.user.getName()}"</p>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div align="center">
    <h2 align="centre">Title</h2>
    <h3>
        <a href="/officeProductSelector_war_exploded">Main page</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/officeProductSelector_war_exploded/logOut">Log out</a>

    </h3>
    <h2 align="centre">
        <c:out value="${product.name}"/>
    </h2>
    <div>
        <c:if test="${product.logo != null}">
            <td><img style="display: block; width: 100px; height: 100px;" src='data:image/jpg;base64,${product.logo}'>
            </td>
        </c:if>
        <c:if test="${product.logo == null}">
            <td>Изображение <br> отсутсвует</td>
        </c:if>
    </div>
    <div>
        <p>Описание продукта</p><br>
        <p><c:out value="${product.description}" /></p>
        <div class="rating-area">
            <input type="radio" id="star-5" name="rating" value="5">
            <label for="star-5" title="Оценка «5»"></label>
            <input type="radio" id="star-4" name="rating" value="4">
            <label for="star-4" title="Оценка «4»"></label>
            <input type="radio" id="star-3" name="rating" value="3">
            <label for="star-3" title="Оценка «3»"></label>
            <input type="radio" id="star-2" name="rating" value="2">
            <label for="star-2" title="Оценка «2»"></label>
            <input type="radio" id="star-1" name="rating" value="1">
            <label for="star-1" title="Оценка «1»"></label>
        </div>
    </div>
    <div>
        <c:forEach var="comment" items="${product.comments}">
            <p><c:out value="${comment.comment}" /></p>
            <p><c:out value="${comment.user.name}" /></p>
        </c:forEach>
    </div>
    <form action="/officeProductSelector_war_exploded/main/comment" method="post">
        <c:if test="${product != null}">
            <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
        </c:if>
        <tr>
            <th>Comment: </th>
            <td>
                <input type="text" name="comment" size="45"/>
            </td>
            <td><input type="submit" value="Save" /></td>

        </tr>
    </form>
</div>
</body>
</html>
