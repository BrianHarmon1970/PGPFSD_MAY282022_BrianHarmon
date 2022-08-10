<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <jsp:useBean id="emp" class="jspbean.emp" scope="session" />
        <jsp:setProperty name="emp" property="*"/>

        <jsp:setProperty name="emp" property="name" value="BSH"/>
        <jsp:setProperty name="emp" property="password" value="ABC"/>
        <jsp:setProperty name="emp" property="email" value="harmon@mail.com"/>

        <p> Local Get </p>
        <jsp:getProperty name="emp" property="name"/>
        <jsp:getProperty name="emp" property="password"/>
        <jsp:getProperty name="emp" property="email"/>
    </body>
</html>
