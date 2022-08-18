<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Confirmation</title>
</head>
<body>
<h1>Payment Confirmation</h1>
<% System.out.print( " PaymentConfirmation.jsp " ) ; %>
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
<form><button type="submit" formaction="CloseBooking.jsp" formmethod="get">Confirm</button></form>
</body>
</html>
