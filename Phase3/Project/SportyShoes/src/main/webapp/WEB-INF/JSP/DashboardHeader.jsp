<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<div style="flow-from: left; border: blue; border-style: solid ">
    <div><h2>&lt;&lt; SportyShoes - D A S  H  B  O  A R D - SportyShoes  &gt;&gt;</h2></b>
        <form method="GET">
            <button disabled type="submit" formaction="LoginUser">Login</button>
            <button disabled type="submit" formaction="RegisterUser"  >Register</button>
            <button type="submit" formaction="viewUsers">Users</button>
            <button type="submit" formaction="viewProducts">Product</button>
            <button type="submit" formaction="viewCatalog">Shop Catalog</button>
            <button type="submit" formaction="viewCart">Cart</button>
            <button type="submit" formaction="viewOrders" >Orders</button>
        </form>
    </div>
</div>
</body>
</html>
