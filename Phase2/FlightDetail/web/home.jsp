<%@ page import="com.harmonengineering.beans.FlightDetailBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="DashBoardHeader.jsp"%>
    </head>
    <body>
    <jsp:forward page="FlightDetailQuery.jsp"></jsp:forward>
    <a href="test.jsp">test.jsp</a>
        <a href="FlightDetailQuery.jsp">Search for Flights</a>

   <%-- <%
        FlightDetailBean newBean = new FlightDetailBean() ;
        newBean.setAirlineName( "Hello." ) ;
        newBean.setArrivalCity( "Hello." ) ;
        newBean.sprint(out) ;
    %>--%>
    </body>
</html>

