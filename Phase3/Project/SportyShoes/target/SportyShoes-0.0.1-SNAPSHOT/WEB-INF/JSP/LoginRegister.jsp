<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/Register</title>
    <%@ include file="DashboardHeader.jsp"%>
</head>
<body>

    <h1>Login/Register</h1>
    <form>
        <label for="register_button">Don't have an account?:</label><br>
        <button id="register_button" type="submit" formaction="/RegisterUser" >New Customer</button>
<br><br>
        <label for="login_button">Login with existing account:</label><br>
        <button id="login_button" type="submit" formaction="/LoginUser" >Existing Customer</button>
    </form>


</body>
</html>
