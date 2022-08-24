<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/24/2022
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flight Selection</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>

    <form action="FlightDetailSelect.jsp" method="get" name="flight_detail_select">
        <%--style="border: navajowhite; width: 3px; border-style: solid;" >--%>
        <h2>Select Flight</h2>
                <br>
              <jsp:text>
                  Flight details
                  ${selectionBean.ID}${selectedRecord.airlineName}
                  ${selectedRecord.departureCity}${selectedRecord.arrivalCity}
                  ${selectedRecord.requiredSeats}${selectedRecord.ticketPrice}
                  ${selectedRecord.travelDate}
              </jsp:text><br>
            <button name="first_record" style="nav-left: auto" > << </button>
            <button name="prev_record" style="nav-left: auto" > < </button>
            <button name="next_record" style="nav-right: auto"> > </button>
            <button name="last_record" style="nav-right: auto" > >> </button>
            <button name="select_record"  >Select</button>
    </form>
</body>
</html>
