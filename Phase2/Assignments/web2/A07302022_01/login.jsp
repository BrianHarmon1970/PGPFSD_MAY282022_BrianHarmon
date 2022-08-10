<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Login</title>
</head>
<body>
<%@ include file="header.jsp" %>

<form action="dashboard.jsp" method="post">
    Username:<input type="text" name="username"/><br>
    Password:<input type="password" name="password"/><br>
    <input type="submit" value="Submit" />
    <input type="reset"  />
</form>
</body>
</html>

