<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: blue">Forwarded..</h1>
<p> -- employee -- </p>
<jsp:useBean id="emp" class="jspbean.emp" scope="session" />
<jsp:setProperty name="emp" property="*"/>

Username: <jsp:getProperty name="emp" property="name"/><br>
Password: <jsp:getProperty name="emp" property="password"/><br>
<%--
<jsp:getProperty name="emp" property="email"/>
--%>

<p> -- Product -- </p>
<jsp:useBean id="product" class="jspbean.ProductBean" scope="session" />

ID: <jsp:getProperty name="product" property="ID"/><br>
Name: <jsp:getProperty name="product" property="name"/><br>
Price: <jsp:getProperty name="product" property="price"/><br>

<p> employee email </p>
email: <jsp:getProperty name="emp" property="email"/>
</body>
</html>
