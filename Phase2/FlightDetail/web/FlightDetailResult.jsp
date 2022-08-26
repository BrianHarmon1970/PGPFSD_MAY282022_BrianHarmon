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
    <%@ include file="DashBoardHeader.jsp"%>
</head>
<body>
<% criteriaBean.setAirlineName( request.getParameter("airline_name")); %>
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
    <% criteriaBean.setTravelDate( request.getParameter("travel_date")); %>
<%--
 //   String str =request.getParameter("travel_date") ;
 //   if ( !str.isEmpty())
 //       criteriaBean.setTravelDate( Date.valueOf( str )) ;
 //   else criteriaBean.setTravelDate( new Date(0) ) ;

    <% criteriaBean.setAirlineName("") ;%>
    --%>

<h3>Data Set</h3>
<jsp:useBean id="bean" class="com.harmonengineering.beans.FlightDetailBean" scope="page" />
<%--
<%! ArrayList<FlightDetailBean> queryResult = new ArrayList<FlightDetailBean>() ; %>
<% resultSelectorBean.setQueryResult( queryResult ); %>
--%>
<h3>Result Set</h3>
<%--<c:set var="db" value="${dbSource}" scope="session"/>--%>
<%--
<%! String sqlText ; %>
--%>
<%
    sqlText = "select ID, airline, departure_city, " +
            " arrival_city, available_seats, " +
            " travel_date, ticket_price from VIEW_FDETAILS " ;
    sqlText += " WHERE '" + criteriaBean.getRequiredSeats() +"' <= available_seats" ;

    if ( !criteriaBean.getArrivalCity().isBlank() )
    { sqlText += " AND LOWER(arrival_city) = '" +
            criteriaBean.getArrivalCity().toLowerCase() +"'" ;  }

    if ( !criteriaBean.getDepartureCity().isBlank() )
    {        sqlText += " AND LOWER(departure_city) = '" +
            criteriaBean.getDepartureCity().toLowerCase() + "'" ;   }

    if ( !criteriaBean.getTravelDate().isBlank() )
    { sqlText += " AND STR_TO_DATE( travel_date, '%m-%d-%Y') = " +
        " STR_TO_DATE( '" +  criteriaBean.getTravelDate() + "' ,'%Y-%m-%d') " ;   }

    if ( !criteriaBean.getAirlineName().isBlank() )
    {  sqlText += " AND LOWER(airline) = '" +
            criteriaBean.getAirlineName().toLowerCase() + "'" ; }

    pageContext.setAttribute("sqlText" , sqlText ) ;

%>
${resultSelectorBean.sqlQueryText = sqlText}
<% resultSelectorBean.Reset(); %>
<sql:query var="result" dataSource="${db}" maxRows="100" sql="${resultSelectorBean.sqlQueryText}"  />
<c:forEach var="row" items="${result.rows}">
    <jsp:setProperty name="bean" property="ID" value="${row.ID}" />
    <jsp:setProperty name="bean" property="departureCity" value="${row.departure_city}" />
    <jsp:setProperty name="bean" property="arrivalCity" value="${row.arrival_city}" />
    <jsp:setProperty name="bean" property="requiredSeats" value="${row.available_seats}" />
    <jsp:setProperty name="bean" property="travelDate" value="${row.travel_date}" />
    <jsp:setProperty name="bean" property="ticketPrice" value="${row.ticket_price}" />
    <jsp:setProperty name="bean" property="airlineName" value="${row.airline}" />
    <% resultSelectorBean.add( new FlightDetailBean( bean )) ; %>
</c:forEach>
${selectedRecord}
sqlText: ${sqlText} <br>
<%
    //resultSelectorBean.Initial(queryResult.size()-1, 0, 0 ) ; self initialiized now
    //resultSelectorBean.setQueryResult( queryResult ) ;

    FlightDetailBean record ;
    if ( resultSelectorBean.size() > 0 )
         record = resultSelectorBean.getRecord();
    else record = new FlightDetailBean( ) ;

    selectedRecord.setID(record.getID());
    selectedRecord.setDepartureCity(record.getDepartureCity());
    selectedRecord.setArrivalCity(record.getArrivalCity());
    selectedRecord.setAirlineName(record.getAirlineName());
    selectedRecord.setRequiredSeats(record.getRequiredSeats());
    selectedRecord.setTicketPrice(record.getTicketPrice());
    selectedRecord.setTravelDate(record.getTravelDate());

    criteriaBean.setID( record.getID()) ;

%>
<jsp:forward page="FlightDetailSelect.jsp"/>
<%--
<sql:query var="result" dataSource="${db}" maxRows="10"
           sql="select airline, departure_city,
       arrival_city, available_seats,
       travel_date, ticket_price from VIEW_FDETAILS" />

<c:forEach var="row" items="${result.rows}">
    <jsp:setProperty name="bean" property="ID" value="${rows.ID}" />
    <jsp:setProperty name="bean" property="departureCity" value="${row.departure_city}" />
    <jsp:setProperty name="bean" property="arrivalCity" value="${row.arrival_city}" />
    <jsp:setProperty name="bean" property="requiredSeats" value="${row.available_seats}" />
    <jsp:setProperty name="bean" property="travelDate" value="${row.travel_date}" />
    <jsp:setProperty name="bean" property="ticketPrice" value="${row.ticket_price}" />
    <jsp:setProperty name="bean" property="airlineName" value="${row.airline}" />
    <% resultSelectorBean.add( new FlightDetailBean( bean )) ; %>
</c:forEach>
${selectedRecord}
-->
<%
    resultSelectorBean.Initial(queryResult.size()-1, 0, 0 ) ;
    //resultSelectorBean.setQueryResult( queryResult ) ;

    FlightDetailBean record = resultSelectorBean.getRecord() ;
    selectedRecord.setID( record.getID());
    selectedRecord.setDepartureCity( record.getDepartureCity()) ;
    selectedRecord.setArrivalCity( record.getArrivalCity()) ;
    selectedRecord.setAirlineName( record.getAirlineName()) ;
    selectedRecord.setRequiredSeats( record.getRequiredSeats()) ;
    selectedRecord.setTicketPrice( record.getTicketPrice()) ;
    selectedRecord.setTravelDate( record.getTravelDate()) ;

    FlightDetailBean b ;
    Iterator i = queryResult.iterator() ;
%>
<jsp:forward page="FlightDetailSelect.jsp"/>
<%--
<%
    out.print( queryResult.size() + " records in set." ) ;
    while( i.hasNext() )
    {
        b = (FlightDetailBean) i.next() ;
        //out.println( b ); ;
        out.println( b.getID() + "<br>" ) ;
        out.println( b.getRequiredSeats() + "<br>" ) ;
        out.println( b.getDepartureCity()+ "<br>"  ) ;
        out.println( b.getAirlineName()+ "<br>"  ) ;
        out.println( b.getArrivalCity()+ "<br>"  ) ;
        out.println( b.getTicketPrice() + "<br>" ); ;
        out.println( b.getTravelDate() + "<br>" ); ;
    }

%>
--%>
<%--<jsp:useBean id="bean" scope="page" class="com.harmonengineering.beans.FlightDetailBean" />
<%--<sql:setDataSource var="dbSource"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/phase2"
                   user="root"
                   password="root" />--%>
<%--<h1> TESTING... </h1>--%>
<%--
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
    <%--
        String str =request.getParameter("travel_date") ;
        if ( !str.isEmpty())
            criteriaBean.setTravelDate( Date.valueOf( str )) ;
        else criteriaBean.setTravelDate( new Date(0) ) ;  --%>
<%--    <% criteriaBean.setTravelDate( request.getParameter("travel_date")); %>
    <% criteriaBean.setAirlineName("") ;%>
<%--
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
--%>
<%--
<br>
<c:set var="criteriaBean" value="${criteriaBean}" scope="session" />
--%>
<%--${criteriaBean.arrivalCity}<br>
${criteriaBean.departureCity}<br>
${db}--%>
<%--
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
    <%--    </tr>
    </c:forEach>
</table>

--%>
<%--
<h3>Result Set</h3>
<c:set var="db" value="${dbSource}" scope="session"/>

        <sql:query var="result" dataSource="${db}" maxRows="100"
            sql="select ID, airline, departure_city,
       arrival_city, available_seats,
       travel_date, ticket_price from VIEW_FDETAILS
        where arrival_city = '${criteriaBean.arrivalCity}'
                                and departure_city='${criteriaBean.departureCity}'
                                    and '${criteriaBean.requiredSeats}' <= available_seats" />

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
<%--
<%
    out.print(" <h1> Hello " + criteriaBean.getDepartureCity()  + " </h1>") ;
    out.print( queryResult ) ;
    out.flush() ;
%>

<jsp:setProperty name="bean" property="ID" value="${dsresult.rows[1].ID}" />
<jsp:setProperty name="bean" property="departureCity" value="${dsresult.rows[1].departure_city}" />
<jsp:setProperty name="bean" property="arrivalCity" value="${dsresult.rows[1].arrival_city}" />
<jsp:setProperty name="bean" property="requiredSeats" value="${dsresult.rows[1].available_seats}" />
<jsp:setProperty name="bean" property="travelDate" value="${dsresult.rows[1].travel_date}" />
<jsp:setProperty name="bean" property="ticketPrice" value="${dsresult.rows[1].ticket_price}" />
<jsp:setProperty name="bean" property="airlineName" value="${dsresult.rows[5].airline}" />
<%
    FlightDetailBean b ;
    Iterator i = queryResult.iterator() ;

    while( i.hasNext() )
    {
        b = (FlightDetailBean) i.next() ;
        //out.println( b ); ;
        out.println( b.getID() + "<br>" ) ;
        out.println( b.getRequiredSeats() + "<br>" ) ;
        out.println( b.getDepartureCity()+ "<br>"  ) ;
        out.println( b.getAirlineName()+ "<br>"  ) ;
        out.println( b.getArrivalCity()+ "<br>"  ) ;
        out.println( b.getTicketPrice() + "<br>" ); ;
        out.println( b.getTravelDate() + "<br>" ); ;

    }
    //out.print( " <datalist id='flight_list' >"  ) ;
    %>
<%--
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
--%>
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