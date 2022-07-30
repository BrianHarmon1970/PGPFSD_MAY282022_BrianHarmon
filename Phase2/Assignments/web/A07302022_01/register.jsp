<%@ include file="header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>
    </head>
    <body>
        <h2>Enter details below to register</h2>
        <br>
        <form action="verify.jsp" method="post">
               Username:<input type="text" name="username"/><br>
               Password:<input type="password" name="password"/><br>
                    Age:<input type="text" name="age"/><br>
                 Branch:<input type="text" name="branch"/><br>
            Author Card:<input type="text" name="AuthCard"/><br>

            <input type="submit" value="Register" />
        </form>
    </body>
</html>