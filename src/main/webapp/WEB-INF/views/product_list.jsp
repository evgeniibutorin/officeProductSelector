<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <style>
        .main-div {
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
                <c:if test="${sessionScope.user.isAdmin()}">
                    <li class="nav-item">
                        <a href="/officeProductSelector_war_exploded/main/admin/new" class="nav-link">Добавить
                            помещение</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.user.isAdmin()}">
                    <li class="nav-item">
                        <a href="/officeProductSelector_war_exploded/main/admin/userList" class="nav-link">Список
                            пользователей</a>
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
    <caption><h2>Список недвижимости</h2></caption>
    <main class="m-3">
        <div class="row col-md-6">
            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>Планировка</th>
                    <th>Кадастровый №</th>
                    <th>Собственник</th>
                    <th>Адрес</th>
                    <th>Средняя оценка</th>
                    <th>Действия</th>
                </tr>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <c:choose>
                            <c:when test="${product.logo != null && product.logo!=''}">
                                <td><img style="display: block; width: 100px; height: 100px;"
                                         src='data:image/jpg;base64,${product.logo}'></td>
                            </c:when>
                            <c:otherwise>
                                <td>Планировка <br> отсутсвует</td>
                            </c:otherwise>
                        </c:choose>
                        <td><c:out value="${product.id}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.description}"/></td>
                        <td>
                            <c:if test="${product.totalMark != null}">
                                <c:out value="${product.totalMark}"/>
                            </c:if>
                            <c:if test="${product.totalMark == null}">
                                Нет оценок
                            </c:if>
                        </td>
                        <td>
                            <a href="/officeProductSelector_war_exploded/main/details?id=<c:out value='${product.id}' />">Подробно</a>
                            <br>

                            <c:if test="${sessionScope.user.isAdmin()}">
                                <a href="/officeProductSelector_war_exploded/main/admin/edit?id=<c:out value='${product.id}' />">Изменить</a>
                                <br>
                                <a href="/officeProductSelector_war_exploded/main/admin/delete?id=<c:out value='${product.id}' />">Удалить</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <nav aria-label="Navigation for products">
            <ul class="pagination">
                <c:if test="${currentPage != 1}">
                    <li class="page-item"><a class="page-link"
                                             href="/officeProductSelector_war_exploded/main/pglist?currentPageFromVue=${currentPage-1}">Previous</a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <li class="page-item active"><a class="page-link">
                                    ${i} <span class="sr-only">(current)</span></a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link"
                                                     href="/officeProductSelector_war_exploded/main/pglist?currentPageFromVue=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage lt noOfPages}">
                    <li class="page-item"><a class="page-link"
                                             href="/officeProductSelector_war_exploded/main/pglist?currentPageFromVue=${currentPage+1}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </main>
</div>
</body>
</html>
