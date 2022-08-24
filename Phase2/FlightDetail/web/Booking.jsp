<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
</head>
<body>
    <h1>Booking</h1>
    <% System.out.print( "Booking.jsp " ) ; %>
<%--
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
<form><button type="submit" formaction="BookFlight.jsp" formmethod="get">Confirm</button></form>
--%>
<jsp:forward page="ProcessUserBooking.jsp" />

</body>
</html>
