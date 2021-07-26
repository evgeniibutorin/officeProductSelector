<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        body {
            background: url(http://localhost:9090/officeProductSelector_war_exploded/static/css/bg.jpg) no-repeat;
            background-size: 100%;
        }

        table {
            background: white;
        }
    </style>

    <title>Страница регистрации</title>
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
                    <a href="authorization" class="nav-link">Авторизация</a>
                </li>
                <li class="nav-item">
                    <a href="/officeProductSelector_war_exploded/main/pglist?currentPageFromVue=1" class="nav-link">Список
                        продуктов</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<c:if test="${hasBeenCreated.equals(true)}">
    <script type="text/javascript">alert("Пользователь с таким логином уже существует")</script>
</c:if>
<div align="center">
    <h2>Регистрация</h2>
    <form action="/officeProductSelector_war_exploded/registration" method="post" class="rf">
        <table border="1" cellpadding="5">
            <tr>
                <th>Имя:</th>
                <td>
                    <input type="text" name="name" size="45" class="rfield"/>
                </td>
            </tr>
            <tr>
                <th>Логин:</th>
                <td>
                    <input type="text" name="login" class="rfield" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Пароль:</th>
                <td>
                    <input type="text" name="password" size="45" class="rfield"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Зарегистрироваться" class="btn_submit" onclick="validAndSubmit()"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>