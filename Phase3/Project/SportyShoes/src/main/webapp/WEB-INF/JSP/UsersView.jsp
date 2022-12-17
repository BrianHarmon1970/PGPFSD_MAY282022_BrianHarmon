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
  <title>User Admin</title>
</head>
<body>

<form action="searchUsers" method="get">
<table>
  <thead><tr>
    <td>ID</td>
    <td>userName</td>
    <td>firstName</td>
    <td>lastName</td>
  </tr></thead>
  <tr>
    <td><input id="id_user_id" name="user_id"></td>
    <td><input id="id_user_name" name="user_name"></td>
    <td><input id="id_first_name" name="first_name"></td>
    <td><input id="id_last_name" name="last_name"></td>
    <td><button type="submit">Find</button></td>
  </tr>
</table>
</form>
<h1>Users.</h1>

<form>
<table style="border: medium solid;align-items: center; ">
  <thead><tr>
    <td>userName</td>
    <td>firstName</td>
    <td>lastName</td>
    <td>emailAddress</td>
    <td>phoneNumber</td>
  </tr></thead>
  <c:forEach var="user" items="${list}">
    <tr>
      <c:if test="${user.userType == 'ADMIN'}">
        <td>${user.userName}</td>

        <tr><td>
          <label for="id_admin_password">Admin password:</label>
          <input id="id_admin_password" type="password" name="password" value="${user.userPass}">
          <input name="user_id" hidden value="${user.id}">
          <button type="submit" formmethod="get" formaction="updateUserPassword">Update</button>
        </td></tr>

      </c:if>
      <c:if test="${user.userType != 'ADMIN'}">
        <tr>
          <td>${user.userName}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.emailAddress}</td>
          <td>${user.phoneNumber}</td>
        </tr>
      </c:if>
  </c:forEach>
</table>
</form>

</body>
</html>
