<%@include file="DashboardHeader.jsp"%>
<%--
  File: CartView.jsp
  User: black
  Date: 9/23/2022
  Time: 11:10 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart View</title>
</head>
<body>
<h1>User Cart.</h1>
<table>
    <thead>
        <tr><td>Product No.</td><td>Product</td><td>Price</td><td>Quantity</td></tr>
    </thead>
    <c:forEach var="cartItem" items="${cartItems}">
        <tr>
        <td>${cartItem.product.id}</td><td>${cartItem.product.description}</td>
        <td>${cartItem.product.price}</td><td> ${cartItem.quantity}</td>
        </tr>
    </c:forEach>
</table>

<form method="get">
    <button type="submit" formaction="submitCart">Submit</button>
    <button type="submit" formaction="emptyCart">Empty</button>
</form>
</body>
</html>
