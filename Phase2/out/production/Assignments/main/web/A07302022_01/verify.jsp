<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Verify</title>
    </head>
    <body>
        <h2> Welcome to Registration Page</h2>
        Welcome,  <%= " " + request.getParameter("username")  %><br>
        <br> Verify your details:<br>
        <br>
        Username: <%= " " + request.getParameter("username" ) %><br>
            password: <%= " " + request.getParameter("password" ) %><br>
            Age: <%= " " + request.getParameter("age" ) %><br>
            Branach: <%= " " + request.getParameter("branch" ) %><br>
            Auth Card: <%= " " + request.getParameter("AuthCard" ) %><br>
            <br>
        <form>
            <input formaction="dashboard.jsp" formmethod="get" type="submit" value="Verify">
        </form>
    </body>
</html>
