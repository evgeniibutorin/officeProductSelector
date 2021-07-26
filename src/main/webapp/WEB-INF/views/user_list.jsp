<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <style>
        .main-div{
            background: white;
            margin-left: 20%;
            margin-right: 20%;
        }
    </style>

    <link rel="stylesheet" href="http://localhost:9090/officeProductSelector_war_exploded/static/css/list.css">
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

    <title>All products</title>
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
                <li class="nav-item">
                    <a href="/officeProductSelector_war_exploded/main/pglist?currentPageFromVue=1" class="nav-link">Список
                        продуктов</a>
                </li>
                <c:if test="${sessionScope.user.isAdmin()}">
                    <li class="nav-item">
                        <a href="/officeProductSelector_war_exploded/main/admin/new" class="nav-link">Добавить
                            продукт</a>
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

<div align="center" class="main-div">
    <caption><h2>Список пользователей</h2></caption>
    <main class="m-3">
        <div class="row col-md-6">

            <form method="get" name="find_user_by_name"
                  action="/officeProductSelector_war_exploded/main/admin/user/find">
                <input name="name" value="${name}" type="text" size="45" />
                <input value="Найти по имени" type="submit" />
            </form>


            <form action="/officeProductSelector_war_exploded/main/admin/userList" method="get"  >
                <input type="submit" value="Показать всех">
            </form>
            <br>
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Логин</th>
                    <th>Действия</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.login}"/></td>
                        <td>
                            <c:if test="${sessionScope.user.isAdmin()}">
                                <a href="/officeProductSelector_war_exploded/main/admin/user/delete?id=<c:out value='${user.id}' />">Удалить</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </main>
</div>
</body>
</html>
