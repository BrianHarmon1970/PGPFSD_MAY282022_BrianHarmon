
<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/24/2022
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% out.print( new Date().toString() ) ; %>
<br><br>
UserName: <%= " " + request.getParameter("username") %>
</body>
</html>
