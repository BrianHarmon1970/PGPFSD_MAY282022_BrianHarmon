<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="DashBoardHeader.jsp"%>
<body>

<jsp:setProperty name="selectedRecord" property="ID" param="selected_flight_record"/>
<jsp:setProperty name="criteriaBean" property="ID" param="selected_flight_record"/>
<% if (
        !( userBean.getUserType() != null && userBean.getUserType().equals("ADMIN"))
    )
    sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ;
%>
<jsp:forward page="BookFlight.jsp"/>

</body>
</html>
