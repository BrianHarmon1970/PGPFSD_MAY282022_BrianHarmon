<%--===================== File: ProductForm.jsp ====================================--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="DashboardHeader.jsp"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>New Product</title>
</head>
<body>

<form action="addProduct" method="get">
  <div style="border: solid black; width: 40ch; padding-left: 4ch">
    <h2> New Product </h2>
    <table><tr>
        <td><label for="id_product_name">Product name:</label></td>
        <td><input id="id_product_name" name="product_description"></td>
      </tr><tr>
        <td><label for="id_product_category">Product category:</label></td>
        <td><input id="id_product_category" name="product_category"></td>
      </tr><tr>
        <td><label for="id_product_season">Product season:</label></td>
        <td><input id="id_product_season" name="product_season"></td>
      </tr><tr>
        <td><label for="id_product_brand">Product brand:</label></td>
        <td><input id="id_product_brand" name="product_brand"></td>
      </tr><tr>
        <td><label for="id_product_color">Product color:</label></td>
        <td><input id="id_product_color" name="product_color"></td>
      </tr><tr>
        <td><label for="id_product_discount">Product discount:</label></td>
        <td><input id="id_product_discount" name="product_discount"></td>
      </tr><tr>
        <td><label for="id_product_price">Product price:</label></td>
        <td><input id="id_product_price" name="product_price"></td>
      </tr></table>
    <br>
    <button type="submit" formaction="addProduct" formmethod="POST">Create Product</button>
    <button type="submit" formaction="getProductList">List Current Products</button>
    <br><br>
  </div>
</form>

</body>
</html>