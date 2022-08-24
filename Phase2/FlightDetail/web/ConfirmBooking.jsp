<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/18/2022
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Booking</title>
    <%@ include file="DashBoardHeader.jsp"%>
</head>
<body>

    bb reserved seats: "${bookingBean.reservedSeats}"<br>
    bb total_price: ${bookingBean.totalPrice}<br>

    <h2> You are selecting the following flights for purchase.</h2>
    <div><div>
    <h3> Customer: </h3>
    <c:out value="${customerBean.firstName}" />
    <c:out value="${customerBean.lastName}" /><br>
    <c:out value="${addressBean.street1}" /><br>
    <c:out value="${addressBean.street2}" /><br>
    <c:out value="${addressBean.city}" />,
    <c:out value=" ${addressBean.state}"/>.
    <c:out value=" ${addressBean.zipCode}"/><br>
    </div><div>
    <h3> Flight: </h3>
    <c:out value="${selectedRecord.airlineName}"/>
    <c:out value="  ${selectedRecord.departureCity}"/>
    <c:out value="  ${selectedRecord.arrivalCity}"/>
    <c:out value="  ${selectedRecord.travelDate}"/>
    <c:out value="  ${selectedRecord.ticketPrice}"/>
    </div></div>

    <h3> Total price of purchase:</h3>
    <h2>${bookingBean.reservedSeats} Tickets @$${selectedRecord.ticketPrice} = $${bookingBean.totalPrice}</h2>

    <form id="form_confirm_booking" method="get">
        <button type="submit" formaction="BookingConfirmed.jsp">Accept</button>
        <button type="submit" formaction="CancelBooking.jsp">Cancel</button>
    </form>
</body>
</html>
