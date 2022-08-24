<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <jsp:useBean id="bookingBean" class="com.harmonengineering.beans.BookingBean" scope="session"/>
  <jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
  <% sessionBean.setSessionState( SessionStatusBean.SessionState.Reset ) ; %>
  <sql:update dataSource="${db}" sql="ROLLBACK "/>
  <sql:update dataSource="${db}"
              sql="UPDATE booking SET booking_status='BOOKING_STATUS_CANCELLED'
              WHERE ID='${bookingBean.ID}' "/>
  booking bean id: "${bookingBean.ID}"
  <jsp:forward page="BookFlight.jsp"/>
</body>
</html>
