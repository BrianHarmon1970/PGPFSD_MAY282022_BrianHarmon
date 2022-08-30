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
  <button type="submit">Create Product</button>
  <button type="submit" formaction="listProducts">List Current Products</button><br><br>
</div>
</form>

</body>
</html>