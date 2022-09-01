<%--
  File: FindUser.jsp
  User: black
  Date: 8/31/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find User</title>
</head>
<body>
<h2>Find User</h2>
<form action="findUser" method="get">
  <label for="id_user_name">
    <input id="id_user_name" name="user_name">
  </label>
  <button type="submit">Find</button>
</form>

</body>
</html>
