<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/6/2022
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="name" value="${4000*4}"/>
    <p> value before removal = <c:out value="income"/> </p>
    <c:remove var="income" />
    <p> value ofter remove: <c:out var="income"</p>

</body>
</html>
