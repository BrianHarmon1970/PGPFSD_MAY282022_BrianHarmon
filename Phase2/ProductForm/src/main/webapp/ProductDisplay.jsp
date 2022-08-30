<%--===================== File: ProductDisplay.jsp ====================================--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/30/2022
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowBean</title>
</head>
<body>
<h1> Product Entered..</h1>
<jsp:useBean id="EProductBean" class="com.ecommerce.EProduct" scope="session" />
Product ID: ${EProductBean.ID} <br>
Product Name: ${EProductBean.name} <br>
Product Price ${EProductBean.price} <br>
Date Added: ${EProductBean.dateAdded} <br>
<br>
<form method="get">
    <button type="submit" formaction="ProductForm.jsp">Return</button>
</form>
</body>
</html>
