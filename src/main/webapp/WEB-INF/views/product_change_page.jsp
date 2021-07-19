<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        body{
            background: url(http://localhost:9090/officeProductSelector_war_exploded/static/css/bg.jpg) no-repeat;
            background-size: 100%;
        }
        table{
            background: white;
        }
    </style>
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
    <title>Product Management</title>
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
                        <a href="/officeProductSelector_war_exploded/main/pglist?currentPageFromVue=1" class="nav-link">Список продуктов</a>
                    </li>
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
    <caption>
        <h2>
            <c:if test="${product != null}">
                Изменить данные
            </c:if>
            <c:if test="${product == null}">
                Добавить продукт
            </c:if>
        </h2>
    </caption>
    <c:if test="${product != null}">
    <form action="/officeProductSelector_war_exploded/main/admin/update" method="post" enctype="multipart/form-data">
        </c:if>
        <c:if test="${product == null}">
        <form action="/officeProductSelector_war_exploded/main/admin/insert" method="post" enctype="multipart/form-data">
            </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
                </c:if>
                <tr>
                    <th>Наименование продукта: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${product.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Описание продукта: </th>
                    <td>
                        <input type="text" name="description" size="45"
                               value="<c:out value='${product.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Изображение продукта: </th>
                    <td>
                        <input type="file" name="file"/>
                        <c:if test="${product != null}"><input type="checkbox" name="doChange" value="yes">Звменить изорбражение?</c:if>

                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Сохранить" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>