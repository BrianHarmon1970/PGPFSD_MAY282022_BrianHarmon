<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page import="com.harmonengineering.beans.FlightDetailBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page import="com.harmonengineering.beans.StringBean" %>
<%@ page import="com.harmonengineering.beans.BookingBean" %>
<%@ page import="com.harmonengineering.beans.CardCredentials" %>
<%@ page import="com.harmonengineering.beans.PaymentAgentBean" %>
<%@page import="com.harmonengineering.beans.ResultSelectorBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.net.URL" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session" />
<jsp:useBean id="customerBean"  class="com.harmonengineering.beans.CustomerBean" scope="session"  />
<jsp:useBean id="addressBean"  class="com.harmonengineering.beans.AddressBean" scope="session" />
<jsp:useBean id="userBean" class="com.harmonengineering.beans.UserBean" scope="session"/>
<jsp:useBean id="bookingBean" scope="session" class="com.harmonengineering.beans.BookingBean"/>
<jsp:useBean id="criteriaBean" class="com.harmonengineering.beans.FlightDetailBean" scope="session"/>
<jsp:useBean id="selectionBean" class="com.harmonengineering.beans.FlightDetailBean" scope="session"  />
<jsp:useBean id="selectedRecord" class="com.harmonengineering.beans.FlightDetailBean" scope="session"/>

<%-- doLogin ripped --%>
<%--<jsp:useBean id="reqUserBean" class="com.harmonengineering.beans.UserBean" scope="session" /> --%>
<jsp:useBean id="sqlUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />

<%-- doRegister --%>
<jsp:useBean id="reqUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />
<%--<jsp:useBean id="sqlUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />--%>

<jsp:useBean id="paymentAgentBean" class="com.harmonengineering.beans.PaymentAgentBean" scope="session"/>
<jsp:useBean id="resultSelectorBean" class="com.harmonengineering.beans.ResultSelectorBean" scope="session" />

<%

    InputStream in = pageContext.getServletContext().getResourceAsStream("/WEB-INF/config.properties") ;
    Properties props = new Properties();
    props.load(in);
    pageContext.setAttribute( "dbConnectString", props.getProperty("url"));
    pageContext.setAttribute( "dbUserName", props.getProperty("userid"));
    pageContext.setAttribute( "dbPassword", props.getProperty("password"));
    pageContext.setAttribute( "dbDriverName", props.getProperty("driver")) ;
%>
<sql:setDataSource var="dbSource"
                   driver="${dbDriverName}"
                   url="${dbConnectString}"
                   user="${dbUserName}"
                   password="${dbPassword}"
                   scope="session" />
<c:set var="db" value="${dbSource}" scope="session"/>

<%! String sqlText ; %>
<%--
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


<div style="flow-from: left; border: blue; border-style: solid ">
<h1> &lt;&lt; flyaway - D A S  H  B  O  A R D - flyaway  &gt;&gt; </h1>


    <%
        if( sessionBean.isVerifiedLogin())
        {
            //System.out.print( "<<Admin Page Button>>") ;
            out.print(
                "<form method=\"get\">" +
                        "<button type=\"submit\" formaction=\"UserLogout.jsp\"> Logout </button></form>");
            out.print("Hello, " + userBean.getUserName());
            if( userBean.getUserType().equals("ADMIN"))
            {

                out.print(
                        "<form method =\"get\">" +
                                "<button type=\"submit\" formaction=\"AdminPage.jsp\">" +
                                "Admin Home </button></form>" ) ;
            }
        }
        else
            out.print(
                    "<form method=\"get\">" +
                            "<button type=\"submit\" formaction=\"UserLogin.jsp\">" +
                                    "Login </button></form>" ) ;

        if( (userBean.getUserType() == null ) || !userBean.getUserType().equals("ADMIN")) {
            out.print(
                    "<form method =\"get\">" +
                            "<button type=\"submit\" formaction=\"home.jsp\">" +
                            "Home </button></form>");
        }
        //FlightDetailBean bean = new FlightDetailBean() ;
        //bean.sprint( out ) ;
        userBean.sprint( out ) ;
        customerBean.sprint( out ) ;
        //criteriaBean.sprint( out);
        //selectionBean.sprint( out ) ;
        //selectedRecord.sprint( out ) ;


    %>


</div>
</body>
</html>
