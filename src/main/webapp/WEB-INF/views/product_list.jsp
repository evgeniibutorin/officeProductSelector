
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <!-- JQuerry library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).on("click", "#show_all_products", function () {
            $("#for_product_list > tbody").remove();
            $.get("http://localhost:9090/criteriaDemo_war_exploded/course", function (responseJson) {
                var $tbody = $("<tbody>").appendTo($("#for_product_list"));
                $.each(responseJson, function (index, product) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(product.id))
                        .append($("<td>").text(product.productName))
                        .append($("<td>").text(product.cost));
                });
            });
        });
    </script>
    <title>All products</title>
</head>
<body>
<H2>Product list</H2>>
<button id="show_all_product" ,>Show all product</button><br/> <br/>

<h3>List of courses</h3>
<table id="for_product_list" cellpadding="5" cellspacing="5">
    <thead class="title">
    <tr class="title">
        <th class="title">id</th>
        <th class="title">Course</th>
        <th class="title">Cost</th>
    </tr>
    </thead>
</table>
</body>
</html>
