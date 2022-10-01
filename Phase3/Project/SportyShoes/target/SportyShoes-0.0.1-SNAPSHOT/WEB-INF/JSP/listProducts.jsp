<%--
File: listProducts.jsp
--%>
<%@include file="DashboardHeader.jsp"%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
</head>
<body>

List Products
<%--<c:forEach var="product" items="${list}">
    ${product.description}, ${product.price}, ${product.dateAdded}<br>
</c:forEach>--%>
<c:set var="productId" value="${list[0].id}"/>

<%--===== Product Search ====--%>
<form>
<table>
    <thead>
        <tr>
            <td>ID</td><td>description</td><td>categeory</td><td>Season</td>
            <td>Brand</td><td>Color</td><td>price</td><td>since</td>
        </tr>
    </thead>
        <tr>
            <td><input name="product_id"/></td>
            <td><input name="product_description"></td>
            <td><input name="product_category"></td>
            <td><input name="product_season"></td>
            <td><input name="product_brand"></td>
            <td><input name="product_color"></td>
            <td><input name="product_price"></td>
            <td><input type="date" name="product_date_added" ></td>
            <td><button type="submit" formaction="searchProduct">Search</button></td>
        </tr>
</table>
</form>

<%--===== Product List (search result) ====--%>
<form method = "POST">
    <table><thead><tr><td>ID</td><td>description</td><td>categeory</td><td>Season</td><td>Brand</td><td>Color</td><td>Discount</td><td>price</td><td>since</td></tr></thead>
        <%--===== Add Product ====--%>
        <tr>
            <td>${product.id}</td>
            <td><input name="product_description" /></td>
            <td><input name="product_category" /></td>
            <td><input name="product_season" /></td>
            <td><input name="product_brand" ></td>
            <td><input name="product_color" /></td>
            <td><input name="product_discount" /></td>
            <td><input name="product_price" /></td>
            <td><input readonly name="product_date_added" value="<%=new Date()%>"></td>
            <td>
                <button type="submit" formaction="/addProduct"
                        name="product_i2d"
                        value="${product.id}">Create</button>
            </td>
            <td><button type="submit" formaction="addProductForm">Form</button></td>
        </tr>

        <c:forEach var="product" items="${list}">
            <tr>
                <td>${product.id}</td>
                <td><input name="product_description_${product.id}" value="${product.description}"/></td>
                <td><input name="product_category_${product.id}" value="${product.category}"/></td>
                <td><input name="product_season_${product.id}" value="${ product.season }"/></td>
                <td><input name="product_brand_${product.id}" value="${ product.brand }"/></td>
                <td><input name="product_color_${product.id}" value="${ product.color }"/></td>
                <td><input name="product_discount_${product.id}" value="${ product.discount }"/></td>
                <td><input name="product_price_${product.id}" value="${ product.price }"/></td>
                <td>
                    <fmt:formatDate type="date" value="${product.dateAdded}" var="fmtDate" pattern="yyyy-MM-dd"/>
                    <input readonly name="product_date_added_${product.id}" value="${fmtDate}">
                </td>
                <td><button type="submit" formaction="/updateProduct" name="product_id" value="${product.id}">Update</button> </td>
                <td><button type="submit" formaction="/deleteProduct" name="del_product_id" value="${product.id}">Delete</button> </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>

