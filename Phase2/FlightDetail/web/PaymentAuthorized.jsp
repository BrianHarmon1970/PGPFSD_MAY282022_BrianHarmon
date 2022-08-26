<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/25/2022
  Time: 12:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<%--<jsp:useBean id="sessionBean" scope="session" class="com.harmonengineering.beans.SessionStatusBean"/>--%>
<sql:update dataSource="${db}"
            sql="UPDATE booking SET booking_status='BOOKING_STATUS_PAYMENTAUTHORIZED'
            WHERE ID='${bookingBean.ID}'"/>
<%--<jsp:setProperty name="sessionBean" property="sessionState" value="SessionState.Update"/>--%>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ); %>
<jsp:forward page="BookFlight.jsp"/>

</body>
</html>
