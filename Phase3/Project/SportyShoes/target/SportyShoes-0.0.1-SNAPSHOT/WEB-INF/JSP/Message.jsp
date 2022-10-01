<%@include file="DashboardHeader.jsp"%>
<%--
  File: Message.jsp
  User: black
  Date: 9/23/2022
  Time: 6:46 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message - <%= request.getAttribute("Message")%></title>
</head>
<body>
<%= request.getAttribute("Message")%>
</body>
</html>
