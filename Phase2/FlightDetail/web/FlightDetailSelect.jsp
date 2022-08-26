
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid;
            border-color: blanchedalmond;
        }
    </style>
    <title>Flight Selection</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<form action="FlightDetailSelectUpdate.jsp" method="get" name="flight_detail_select"
    ><%--style="border: navajowhite; width: 3px; border-style: solid;" >--%>
    <h3>Select Flight</h3>
    ${resultSelectorBean.ndx+1}/${resultSelectorBean.max+1}
    <table>
        <thead><tr>
            <td>Airline</td><td>Departure</td><td>Arrival</td>
            <td>Seats</td><td>Price</td><td>Date</td>
        </tr></thead>
        <tr><td>${criteriaBean.airlineName}</td><td>${criteriaBean.departureCity}</td>
            <td>${criteriaBean.arrivalCity}</td><td>${criteriaBean.requiredSeats}</td>
            <td>${criteriaBean.ticketPrice}</td><td>${criteriaBean.travelDate}</td></tr>

        <tr><td>${selectedRecord.airlineName}</td><td>${selectedRecord.departureCity}</td>
            <td>${selectedRecord.arrivalCity}</td><td>${selectedRecord.requiredSeats}</td>
            <td>${selectedRecord.ticketPrice}</td><td>${selectedRecord.travelDate}</td></tr>
    </table>
    <button type="submit" id="first_record" name="nav" value="nav-first" style="nav-left: auto" > << </button>
    <button type="submit" id="prev_record" name="nav" value="nav-prev" style="nav-left: auto" > < </button>
    <button type="submit" id="select_record" disabled name="nav" value="nav-select" >Select</button>
    <button type="submit" id="next_record" name="nav" value="nav-next" style="nav-right: auto"> > </button>
    <button type="submit" id="last_record" name="nav" value="nav-last" style="nav-right: auto" > >> </button>

    <form  method="get">
        <button type="submit" formaction="FlightDetailQuery.jsp">Search</button>
        <button type="submit" formaction="home.jsp" >Home</button>
        <button type="submit"
            <c:if test="${selectedRecord.ID==0}">
                <c:out value="disabled='disabled'"/></c:if>
                    formaction="OpenBooking.jsp" >Book</button>
        <%--<label for="selected_flight_record">Choose a flight number:</label><br>
        <input type="number" id="selected_flight_record" name="selected_flight_record">--%>
    </form>
</form>
<h3>Result Set</h3>
<%--<c:set var="db" value="${dbSource}" scope="session"/>--%>
<%--<%! String sqlText ; %>
<%
    sqlText = "select ID, airline, departure_city, " +
            " arrival_city, available_seats, " +
            " travel_date, ticket_price from VIEW_FDETAILS " ;
    sqlText += " WHERE '" + criteriaBean.getRequiredSeats() +"' <= available_seats" ;
    if ( !criteriaBean.getArrivalCity().isBlank() )
    {
        sqlText += " AND arrival_city = '" + criteriaBean.getArrivalCity() +"'" ;
    }
    if ( !criteriaBean.getDepartureCity().isBlank() )
    {
        sqlText += " AND departure_city= '" +  criteriaBean.getDepartureCity() + "'" ;
    }
    //if ( !criteriaBean.getTravelDate().isBlank() )    {    }
    pageContext.setAttribute("sqlText" , sqlText ) ;
%>
--%>
<sql:query var="result" dataSource="${db}" maxRows="100" sql="${resultSelectorBean.sqlQueryText}"  />
<div style=" height: 25%">
    <table style="
        border-color: blue ;
        border-width: 3px ;
        border-style: solid;
        overflow-y: scroll;
        ">
        <thead><tr><td>ID</td><td>AIRLINE</td> <td>DEPART</td><td>ARRIVE</td><td>SEATS AVAIL</td><td>DATE</td><td>PRICE</td></tr></thead>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.ID}"/></td>
                <td><c:out value="${row.airline}"/></td>
                <td><c:out value="${row.departure_city}"/></td>
                <td><c:out value="${row.arrival_city}"/></td>
                <td><c:out value="${row.available_seats}"/></td>
                <td><c:out value="${row.travel_date}"/></td>
                <td><c:out value="${row.ticket_price}"/></td>
            </tr>
        </c:forEach>
    </table></div>
sqlText: ${sqlText} <br>

<h3>Data Set</h3>
<sql:query var="dsresult" dataSource="${db}" maxRows="10"
           sql="select airline, departure_city,
       arrival_city, available_seats,
       travel_date, ticket_price from VIEW_FDETAILS" />

<table style=" border-color:
        deepskyblue;
        border-width: 3px ;
        border-style: solid;" >
    <thead><tr><td>AIRLINE</td> <td>DEPART</td><td>ARRIVE</td><td>SEATS AVAIL</td><td>DATE</td><td>PRICE</td></tr></thead>
    <c:forEach var="row" items="${dsresult.rows}">
        <tr>
            <td><c:out value="${row.airline}"/></td>
            <td><c:out value="${row.departure_city}"/></td>
            <td><c:out value="${row.arrival_city}"/></td>
            <td><c:out value="${row.available_seats}"/></td>
            <td><c:out value="${row.travel_date}"/></td>
            <td><c:out value="${row.ticket_price}"/></td>
                <%--
                            <jsp:setProperty name="bean" property="ID" value="${row.ID}" />
                            <jsp:setProperty name="bean" property="departureCity" value="${row.departure_city}" />
                            <jsp:setProperty name="bean" property="arrivalCity" value="${row.arrival_city}" />
                            <jsp:setProperty name="bean" property="requiredSeats" value="${row.available_seats}" />
                            <jsp:setProperty name="bean" property="travelDate" value="${row.travel_date}" />
                            <jsp:setProperty name="bean" property="ticketPrice" value="${row.ticket_price}" />
                            <jsp:setProperty name="bean" property="airlineName" value="${row.airline}" />
                --%>

            <%
                //bean = new FlightDetailBean() ;
                //bean.setTravelDate( Date.valueOf("${row.travel_date}") ) ;
                //bean.setArrivalCity( "${row.arrival_city}" );
                //bean.setDepartureCity( "${row.departure_city}" );
                //bean.setAirlineName( "${row.airline_name}" );
                //bean.setTicketPrice( "${row.ticket_price}" );
                //bean.setRequiredSeats( "${row.available_seats}" );
                //queryResult.add( bean ) ;

                //bean = new FlightDetailBean() ;
                //bean.sprint( out ) ;
            %>
        </tr>
    </c:forEach>
</table>

</body>
</html>
