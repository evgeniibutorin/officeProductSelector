<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Страница регистрации</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://localhost:9090/officeProductSelector_war_exploded/static/css/registration.js">
    </script>
</head>
<body>

<div align="center">
    <h2>Login page</h2>

    <a href="authorization">Авторизация</a>
    <br>
    <a href="main/list">Список продуктов</a>
    <br>

    <form action="/officeProductSelector_war_exploded/registration" method="post" class="rf">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Registration page
                </h2>
            </caption>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45" class="rfield"/>
                </td>
            </tr>
            <tr>
                <th>Login: </th>
                <td>
                    <input type="text" name="login" class="rfield" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45" class="rfield"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" class="btn_submit" onclick="validAndSubmit()" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>