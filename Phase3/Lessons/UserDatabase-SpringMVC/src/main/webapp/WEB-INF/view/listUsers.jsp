<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
List Users
<c:forEach var="user" items="${list}">
  ${user.userName},${user.firstName},${user.lastName}
</c:forEach>
</body>
</html>
