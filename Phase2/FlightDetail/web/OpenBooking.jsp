<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<jsp:useBean id="criteriaBean" scope="session" type="com.harmonengineering.beans.FlightDetailBean"/>
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
<jsp:useBean id="selectionBean" class="com.harmonengineering.beans.FlightDetailBean" scope="session"  />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


record number: <%=  request.getParameter( "selected_flight_record") %> (from form parameter)<br>
<c:set var="selectedRecordID" value="<%= request.getParameter( \"selected_flight_record\") %>" scope="session" />
set record number: ${selectedRecordID} (from set variable taken from form parameter) <br>
number of seats requested:  ${criteriaBean.requiredSeats} (from session criteriaBean) <br>


<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
<jsp:forward page="BookFlight.jsp"/>

</body>
</html>
