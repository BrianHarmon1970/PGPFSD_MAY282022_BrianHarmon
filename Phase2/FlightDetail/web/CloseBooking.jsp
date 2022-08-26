<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/15/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<% System.out.print( "ClostBooking.jsp" ) ; %>
<sql:update dataSource="${db}"
            sql="UPDATE booking SET booking_status='BOOKING_STATUS_BOOKEDFINAL'
            WHERE ID='${bookingBean.ID}'  "/>
<sql:update dataSource="${db}"
            sql="COMMIT"/>

<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
<jsp:forward page="PaymentConfirmation.jsp"/>
</body>
</html>
