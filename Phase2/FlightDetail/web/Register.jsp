<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/15/2022
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .color-border
        {
            border-style: solid;
            border-color: cadetblue;
            border-width: 3px ;
            width: 40ch ;
        }
    </style>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="customerBean"  class="com.harmonengineering.beans.CustomerBean" scope="session"  />
<jsp:useBean id="addressBean"  class="com.harmonengineering.beans.AddressBean" scope="session" />



<div class="color-border">
    <h1>Register</h1>
    <form  action="doRegister.jsp" method="get">
        <label for="user_name">User Name (email address):</label><br>
        <input id="user_name" name="user_name"size="40" type="text"/><br>
        <br>
        <label for="password">Password:</label><br>
        <input id="password" name="password"size="40" type="password"/><br>
        <br>
        <label for="confirm_password">Confirm Password:</label><br>
        <input id="confirm_password" name="confirm_password" size="40" type="password"/><br>
        <br>
        <button type="submit" >Register</button>
    </form>
</div>
</body>
</html>
