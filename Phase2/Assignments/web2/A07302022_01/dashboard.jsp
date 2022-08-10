<%@include file="header.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Welcome to Login Page</h2>
<p> Welcome, <%= " " + request.getParameter("username")%></p>
<h3>Fill in details below:<h3>


<form action="final.jsp" method="post">
    10th marks :<input type="text" name="tenth_marks"/><br>
    12th marks :<input type="text" name="twelfth_marks"/><br>
    School Name:<input type="text" name="school_name"/><br>
    Math Grade:<input type="text" name="math_score"/><br>
    Chemistry Grade:<input type="text" name="chemistry_score"/><br>
    Physics Grade:<input type="text" name="physics_score"/><br>

    <input type="submit" value="Submit" />
    <input type="reset"  />
</form>
</body>
</html>
