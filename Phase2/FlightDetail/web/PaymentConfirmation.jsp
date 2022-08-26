<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Confirmation</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<h1>Payment Confirmation</h1>
<% System.out.print( " PaymentConfirmation.jsp " ) ; %>
Thank you for your purchase. your confirmation number is ${bookingBean.ID}.
<form><button type="submit" formaction="home.jsp" formmethod="get">Home</button></form>
</body>
</html>
