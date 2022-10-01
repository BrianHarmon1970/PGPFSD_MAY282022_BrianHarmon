<%@include file="DashboardHeader.jsp" %>
<%--
  File: OrdersView.jsp
  User: black
  Date: 9/23/2022
  Time: 11:48 AM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <style>
        table {
            border: medium solid;
            align-items: center;
        }
    </style>
</head>
<body>

<h2>Purchase Orders</h2>
<c:forEach var="order" items="${orderlist}">
    <table>
        <thead><tr>
            <td>OrderNo</td>
            <td>UID</td>
            <td>User</td>
            <td>Order Date</td>
        </tr></thead>
        <tr>
            <%--
            <td>${order.ID}</td>
            <td>${order.userId}</td>
            <td>${order.user.userName}</td>
            <td>${ order.orderDate }</td>
            --%>
                <td>${order.order.ID}</td>
                <td>${order.order.userId}</td>
                <td>${order.order.user.userName}</td>
                <td>${ order.order.orderDate }</td>
        </tr>
        <thead><tr>
                <td>OrderNo.</td>
                <td>PID</td>
                <td>Brand</td>
                <td>Product</td>
                <td>Price</td>
                <td>QTY</td>
                <td>Net Price</td>
        </tr></thead>
        <c:forEach var="item" items="${order.orderItems}">
            <tr>

                <td>${item.orderId}</td><td>${item.productId}</td>
                <td>${item.product.brand}</td><td>${item.product.description}</td>
                <td>${item.product.price}</td><td>${item.quantity}</td>
                <td>${ item.quantity * item.product.price }</td>
            </tr>
            <tr></tr>
    </c:forEach>
    </table><br>
</c:forEach>
</body>
</html>
