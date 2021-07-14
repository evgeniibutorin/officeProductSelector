<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login page</title>
</head>
<body>
<div align="center">
<h2>Login page</h2>
<form action="/officeProductSelector_war_exploded/authorization" method="post">
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                Enter login and password
            </h2>
        </caption>
        <a href="registration">Регистрация</a>
        <br>
        <a href="main/list">Список продуктов</a>
        <br>
        <tr>
            <th>Login: </th>
            <td>
                <input type="text" name="login" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Password: </th>
            <td>
                <input type="text" name="password" size="45"/>
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