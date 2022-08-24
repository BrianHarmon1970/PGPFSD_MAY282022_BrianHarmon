<%@ page import="com.harmonengineering.beans.FlightDetailBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <jsp:useBean id="userBean"  class="com.harmonengineering.beans.UserBean" scope="session"/>
    <jsp:useBean id="customerBean" class="com.harmonengineering.beans.CustomerBean" scope="session"/>
    <jsp:useBean id="addressBean" class="com.harmonengineering.beans.AddressBean" scope="session" />

    <a href="test.jsp">test.jsp</a>
        <a href="FlightDetailQuery.jsp">Search for Flights</a>

    <%
        FlightDetailBean newBean = new FlightDetailBean() ;
        newBean.setAirlineName( "Hello." ) ;
        newBean.setArrivalCity( "Hello." ) ;
        newBean.sprint(out) ;
    %>
    </body>
</html>

