<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.sql.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
<head>
    <Title> Test JSP    </Title>
</head>

<body>
<h1> TESTING... </h1>
// setting up a test bean to bypass direct to Booking page
<jsp:useBean id="criteriaBean" class="com.harmonengineering.beans.FlightDetailBean"
             scope="session"  />
<%
    criteriaBean.setAirlineName("Major Airline");
    criteriaBean.setDepartureCity("London" ) ;
    criteriaBean.setArrivalCity("Moscow") ;
    criteriaBean.setTravelDate( new Date(0) ) ;
    criteriaBean.setRequiredSeats( 6 ) ;
%>

<jsp:forward page="OpenBooking.jsp?selected_flight_record=3"/>

</body>
</html>
