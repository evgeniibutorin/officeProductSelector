<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        body{
            background: url(http://localhost:9090/officeProductSelector_war_exploded/static/css/img.png) no-repeat;
            background-size: 100%;
        }
        table{
            background: white;
        }
    </style>

    <title>Login page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <%--    jquery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <%--   Следующие две стили bootstrap--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <%--    Подключение иконочных шрифтов к примеру иконка "домой"--%>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <script type="text/javascript" src="http://localhost:9090/officeProductSelector_war_exploded/static/css/registration.js">
    </script>
</head>
<body>
<nav class = "navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a href="#" class="navbar-brand"><img src="http://localhost:9090/officeProductSelector_war_exploded/static/css/lanit_logo.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="registration" class="nav-link">Регистрация</a>
                </li>
                <li class="nav-item">
                    <a href="/officeProductSelector_war_exploded/main/pglist?currentPageFromVue=1" class="nav-link">Список недвижимости</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div align="center" class="form">
<h2>Авторизация</h2>
<form action="/officeProductSelector_war_exploded/authorization" method="post">
    <table border="1" cellpadding="5">
        <tr>
            <th>Логин: </th>
            <td>
                <input type="text" name="login" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Порол: </th>
            <td>
                <input type="text" name="password" size="45"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Войти" />
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>