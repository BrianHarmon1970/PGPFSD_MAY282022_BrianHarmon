<%--===================== File: ProductForm.jsp ====================================--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Product</title>
</head>
<body>

<form action="addProduct" method="get">
    <div style="border: solid black; width: 34ch; padding-left: 4ch">
        <h2> New Product </h2>
        <label for="id_product_name">Product name:</label>
        <input id="id_product_name" name="product_name"><br>
        <label for="id_product_price">Product price:</label>
        <input id="id_product_price" name="product_price"><br>
        <br><br>
        <%-- added for lesson 4 project - product data test --%>
        <button type="submit" formaction="ProductLoad.jsp">TestLoad(Jsp)</button>
        <button type="submit" formaction="datatest">TestLoad(Servlet)</button>
        <br><br>
</div>
</form>
<jsp:useBean id="EProductBean" class="com.ecommerce.EProduct" scope="session"/>
<jsp:setProperty name="EProductBean" property="dateAdded" value="<%=null%>"/>
<jsp:setProperty name="EProductBean" property="ID" value="0" />
<jsp:setProperty name="EProductBean" property="name" value="" />
<jsp:setProperty name="EProductBean"   property="price" value="<%=null%>"/>

</body>
</html>