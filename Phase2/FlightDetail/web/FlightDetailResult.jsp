<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<%@ page import="java.sql.Date" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.harmonengineering.beans.FlightDetailBean" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.swing.text.html.HTMLDocument" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>

<html>
<head>
    <Title> Test JSP    </Title>
</head>

<body>
<sql:setDataSource var="dbSource"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/phase2"
                   user="root"
                   password="root" />
<h1> TESTING... </h1>

<jsp:useBean id="criteriaBean" class="com.harmonengineering.beans.FlightDetailBean" scope="session"/>
    <% criteriaBean.setDepartureCity( request.getParameter("departure_city") ) ; %>
    <% criteriaBean.setArrivalCity( request.getParameter("arrival_city") ); %>
    <%  String p = request.getParameter( "required_seats" ) ;
        int v , default_value ; v = default_value = 1 ;
        if ( !p.isEmpty() )
        {
            try { v = Integer.parseInt( p ) ; }
            catch( NumberFormatException e ) { v = default_value ; }
        }
        criteriaBean.setRequiredSeats( v <= 0 ?  default_value : v ) ; %>
    <%
        String str =request.getParameter("travel_date") ;
        if ( !str.isEmpty())
            criteriaBean.setTravelDate( Date.valueOf( str )) ;
        else criteriaBean.setTravelDate( new Date(0) ) ;  %>
    <% criteriaBean.setAirlineName("") ;%>

Arrival City:    <%= request.getParameter("arrival_city") %><br>
Departure City:     <%= request.getParameter("departure_city") %><br>
Required Seats:    <%= request.getParameter("required_seats").toString() %><br>
Travel Date:    <%= request.getParameter("travel_date").toString() %><br>
<br>
Arrival City:      <%= criteriaBean.getArrivalCity() %><br>
Departure City:    <%= criteriaBean.getDepartureCity() %><br>
Required Seats:    <%= criteriaBean.getRequiredSeats() %><br>
Travel Date:    <%= (criteriaBean.getTravelDate()) %> -<br>
<br>
Arrival City:City: <%= request.getParameter("arrival_city") %>

<br>
<c:set var="criteriaBean" value="${criteriaBean}" scope="session" />
${criteriaBean.arrivalCity}<br>
${criteriaBean.departureCity}<br>
${db}

<h3>Data Set</h3>
<sql:query var="result" dataSource="${db}" maxRows="10"
           sql="select airline, departure_city,
       arrival_city, available_seats,
       travel_date, ticket_price from VIEW_FDETAILS" />

<table style=" border-color:
        deepskyblue;
        border-width: 3px ;
        border-style: solid;" >
    <thead><tr><td>AIRLINE</td> <td>DEPART</td><td>ARRIVE</td><td>SEATS AVAIL</td><td>DATE</td><td>PRICE</td></tr></thead>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.airline}"/></td>
            <td><c:out value="${row.departure_city}"/></td>
            <td><c:out value="${row.arrival_city}"/></td>
            <td><c:out value="${row.available_seats}"/></td>
            <td><c:out value="${row.travel_date}"/></td>
            <td><c:out value="${row.ticket_price}"/></td>
        </tr>
    </c:forEach>
</table>


<h3>Result Set</h3>
<c:set var="db" value="${dbSource}" scope="session"/>
<%! ArrayList<FlightDetailBean> queryResult = new ArrayList<FlightDetailBean>() ; %>
        <sql:query var="result" dataSource="${db}" maxRows="100"
            sql="select ID, airline, departure_city,
       arrival_city, available_seats,
       travel_date, ticket_price from VIEW_FDETAILS
        where arrival_city = '${criteriaBean.arrivalCity}'
                                and departure_city='${criteriaBean.departureCity}'
                                    and '${criteriaBean.requiredSeats}' <= available_seats" />
    <%! FlightDetailBean bean ; %>
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

                <%
                    bean = new FlightDetailBean() ;
                    //bean.setTravelDate( Date.valueOf("${row.travel_date}") ) ;
                    bean.setArrivalCity( "${row.arrival_city}" );
                    bean.setArrivalCity( "${row.departure_city}" );
                    bean.setArrivalCity( "${row.airline_name}" );
                    queryResult.add( bean ) ;
                %>
            </tr>

        </c:forEach>
</table></div>
<form action="FlightDetailQuery.jsp" method="get">
    <button type="submit" >Search</button>
</form>
<form action="home.jsp" method="get">
    <button type="submit" >Home</button>
</form>
<form action="OpenBooking.jsp" method="get">
     <var id="seats_selected" name="user_seats">${criteriaBean.requiredSeats}</var>
    <label for="selected_flight_record">Choose a flight number:</label><br>
    <input type="number" id="selected_flight_record" name="selected_flight_record">
    <button type="submit" >Book</button>
</form>

<%--============================================================================--%>
<%
    out.print(" <h1> Hello " + criteriaBean.getDepartureCity()  + " </h1>") ;
    out.print( queryResult ) ;
    out.flush() ;
%>

<%
    FlightDetailBean b ;
    Iterator i = queryResult.iterator() ;

    //out.print( " <datalist id='flight_list' >"  ) ;
    %>
<datalist id='flight_list' >
    <%
    while( i.hasNext() )
    {
         b = (FlightDetailBean) i.next() ;
        out.print( "<option value= " ) ;
        out.print( b.getAirlineName()  + " " + b.getDepartureCity() + " " + b.getArrivalCity() + ">" ) ;
    }
    out.print( "</datalist>") ;
%>
    <%--============================================================================--%>
<%--
<form action="BookFlight.jsp" method="get">
    <label for="selected_flight_record_ex">Choose a flight number:</label><br>
    <input list="flight_list" id="selected_flight_record_ex" name="selected_flight_record_ex">
    <button type="submit" >Book</button>
</form>
--%>
    </body>
</html>