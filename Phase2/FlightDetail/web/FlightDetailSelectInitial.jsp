<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
    <% %>
<h3>Data Set</h3>
<jsp:useBean id="bean" class="com.harmonengineering.beans.FlightDetailBean" scope="page" />
    <%! ArrayList<FlightDetailBean> queryResult = new ArrayList<FlightDetailBean>() ; %>

<sql:query var="result" dataSource="${db}" maxRows="10"
           sql="select airline, departure_city,
       arrival_city, available_seats,
       travel_date, ticket_price from VIEW_FDETAILS" />
<%--<c:forEach var="row" items="dsresult.rows" >--%>
<c:forEach var="row" items="${result.rows}">
    <jsp:setProperty name="bean" property="ID" value="${rows.ID}" />
    <jsp:setProperty name="bean" property="departureCity" value="${row.departure_city}" />
    <jsp:setProperty name="bean" property="arrivalCity" value="${row.arrival_city}" />
    <jsp:setProperty name="bean" property="requiredSeats" value="${row.available_seats}" />
    <jsp:setProperty name="bean" property="travelDate" value="${row.travel_date}" />
    <jsp:setProperty name="bean" property="ticketPrice" value="${row.ticket_price}" />
    <jsp:setProperty name="bean" property="airlineName" value="${row.airline}" />
        <% queryResult.add( new FlightDetailBean( bean )) ; %>
</c:forEach>
${selectedRecord}

<%
        resultSelectorBean.Initial(queryResult.size()-1, 0, 0 ) ;
        resultSelectorBean.setQueryResult( queryResult ) ;

        FlightDetailBean b ;
        Iterator i = queryResult.iterator() ;

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
</body>
</html>