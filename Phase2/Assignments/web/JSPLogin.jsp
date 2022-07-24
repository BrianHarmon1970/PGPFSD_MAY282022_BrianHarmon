<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/24/2022
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Login</title>
</head>
<body>
    <%
        int a = 0 ;
        out.println( "The value of a incremented: " + a++ ) ;
    %>
    <%= a %>
    <%! int c=4, b = 6; %>
    the sum of a and b is <%= (a+b) %>
    <br><br>
    The Login Form:
    <form action="jspdate.jsp" method="post">
        Username:<input type="text" name="username"/><br>
        Password:<input type="password" name="password"/><br>
        <input type="submit" value="Submit" />
        <input type="reset"  />
    </form>
</body>
</html>
