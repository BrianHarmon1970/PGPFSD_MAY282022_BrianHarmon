<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="sessionBean" scope="session" class="com.harmonengineering.beans.SessionStatusBean"/>
<sql:update dataSource="${db}" sql="UPDATE booking SET booking_status='BOOKING_STATUS_RESERVED'"/>
<%--<jsp:setProperty name="sessionBean" property="sessionState" value="SessionState.Update"/>--%>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ); %>
<jsp:forward page="BookFlight.jsp"/>
</body>
</html>
