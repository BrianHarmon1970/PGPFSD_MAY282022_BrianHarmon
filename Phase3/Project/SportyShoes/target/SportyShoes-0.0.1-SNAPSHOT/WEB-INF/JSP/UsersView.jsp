<%--
  File: UsersView.jsp
  User: black
  Date: 9/23/2022
  Time: 11:23 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="DashboardHeader.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Users!!!</h1>
<c:forEach var="user" items="${list}">
  ${user.userName}, ${user.userType}<br>
</c:forEach>
<h2>Find User</h2>
<form action="findUser" method="get">
  <label for="id_user_name">
    <input id="id_user_name" name="user_name">
  </label>
  <button type="submit">Find</button>
</form>
</body>
</html>
