<%@ page import="com.harmonengineering.beans.SessionStatusBean" %><%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/15/2022
  Time: 7:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
</head>
<body>
<h1>Booking</h1>
<% System.out.print( "Booking.jsp " ) ; %>
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
<form><button type="submit" formaction="BookFlight.jsp" formmethod="get">Confirm</button></form>


</body>
</html>
