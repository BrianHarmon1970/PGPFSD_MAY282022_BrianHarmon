<%@include file="DashboardHeader.jsp"%>
<%--
  File: ViewCatalog.jsp
  User: black
  Date: 9/23/2022
  Time: 11:31 AM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog View</title>
</head>
<body>
<h1>Catalog.</h1>
<form>
    <table><thead><td>ID</td><td>description</td><td>categeory</td><td>Season</td><td>Brand</td><td>Color</td><td>price</td><td>since</td></thead>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.description}</td>
            <td>${product.category}</td>
            <td>${ product.season }</td>
            <td>${ product.brand }</td>
            <td>${ product.color }</td>
            <td>${ product.price }</td>
            <td>${ product.dateAdded }</td>
            <td><button type="submit" formaction="/addCartItem" name="add_button" value="${product.id}">Add</button> </td>
        </tr>
    </c:forEach>
</table>
</form>

</body>
</html>
