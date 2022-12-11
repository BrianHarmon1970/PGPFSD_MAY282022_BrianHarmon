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
    <title>Login</title>
    <%@include file="DashboardHeader.jsp"%>
</head>
<body>
<div class="color-border">
    <h1>Login</h1>
    <form  action="doLogin" method="get">
    <label for="user_name">User Name (email address):</label><br>
        <input id="user_name" name="user_name" size="40" type="text"/><br>
        <br>
        <label for="password">Password:</label><br>
        <input id="password" name="password" size="40" type="password"/><br>
        <br>
        <button type="submit" >Login</button>
    </form>
</div>
</body>
</html>
