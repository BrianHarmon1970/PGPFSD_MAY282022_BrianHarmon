<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<h1>Payment</h1>
<% System.out.print( " Payment.jsp " ) ; %>
<%--%><jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
<form><button type="submit" formaction="BookFlight.jsp" formmethod="get">Confirm</button></form>
--%>
<sql:update dataSource="${db}"
            sql="UPDATE booking SET booking_status='BOOKING_STATUS_PAYMENTPENDING'
                WHERE ID='${bookingBean.ID}' "/>
<%--<jsp:setProperty name="sessionBean" property="sessionState" value="SessionState.Update"/>--%>
<%--<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ); %>--%>

<jsp:forward page="UserPaymentAuthorization.jsp"/>

</body>
</html>
