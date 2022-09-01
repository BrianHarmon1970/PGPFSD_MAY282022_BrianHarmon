<%--
  File: listUsers.jps
  User: black
  Date: 8/31/2022
  Time: 12:38 PM
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>List Products</title>
</head>
<body>
<h2>List Users</h2>
<c:forEach var="user" items="${list}">
  ${user.userName}, ${user.firstName}, ${user.lastName}<br>
</c:forEach>
  <form>
    <button type="submit" formaction="home">Home</button>
  </form>
</body>
</html>
