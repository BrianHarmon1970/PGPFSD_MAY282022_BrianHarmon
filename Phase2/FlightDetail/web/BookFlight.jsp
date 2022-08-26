<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="userBean"  class="com.harmonengineering.beans.UserBean" scope="session"/>
<jsp:useBean id="customerBean" class="com.harmonengineering.beans.CustomerBean" scope="session"/>
<jsp:useBean id="addressBean" class="com.harmonengineering.beans.AddressBean" scope="session" />

    <h1><<== Book Your Flight! ==>></h1>
    <jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
    <jsp:useBean id="selectionBean" class="com.harmonengineering.beans.FlightDetailBean" scope="session"  />

    <% System.out.print( "BookFlight.jsp " ) ; %>
    <c:if test="<%=sessionBean.getSessionState() == SessionStatusBean.SessionState.PaymentConfirmed %>" >
        <h3> program flow - Confirmation </h3>
        <%--
        <% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
        --%>
        <jsp:forward page="CloseBooking.jsp"/>

    </c:if>
    <c:if test="<%=sessionBean.getSessionState() == SessionStatusBean.SessionState.BookingConfirmed %>">

        <h3> program flow - Payment </h3>
        <% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
        <jsp:forward page="Payment.jsp"/>

    </c:if>
    <c:if test="<%=sessionBean.getSessionState()== SessionStatusBean.SessionState.LoginRegisterConfirmed %>">

        <h3> program flow - Booking </h3>
        <% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
        <jsp:forward page="Booking.jsp"/>

    </c:if>
    <c:if test="<%=sessionBean.getSessionState()== SessionStatusBean.SessionState.RecordSelected %>">
        <h3> program flow - Login/Register </h3>
        <% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
        <jsp:forward page="LoginRegister.jsp"/>

     </c:if>
    <c:if test="<%=sessionBean.getSessionState()== SessionStatusBean.SessionState.Final %>">
        <jsp:forward page="FlightDetailQuery.jsp"/>
    </c:if>
    <%--
    <% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
    <form><button type="submit" formaction="BookFlight.jsp" formmethod="get">Confirm</button></form>
    <jsp:forward page="BookFlight.jsp"/>
    --%>

</body>
</html>
