<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<h1>&lt User Booking Process &gt</h1>
<body>

    userBean ID: ${userBean.ID}<br>
    customerBean ID:${customerBean.ID}<br>
    bookingBean ID: ${bookingBean.ID}<br>
    selectedRecord ID ${selectedRecord.ID}<br>
    selectedRecord ID (from param): "${selectedRecordId}"


<%--------------- Load user and flight detail -----------------------------%>
    <sql:query dataSource="${db}" var="rs"
               sql="SELECT ID, departure_city, arrival_city,
                airline, available_seats, ticket_price , travel_date
                from  view_fdetails
                where ID='${selectedRecord.ID}' "/>
    <jsp:setProperty name="selectedRecord" property="ID" value="${rs.rows[0].ID}" />
    <jsp:setProperty name="selectedRecord" property="departureCity" value="${rs.rows[0].departure_city}" />
    <jsp:setProperty name="selectedRecord" property="arrivalCity" value="${rs.rows[0].arrival_city}" />
    <jsp:setProperty name="selectedRecord" property="airlineName" value="${rs.rows[0].airline}" />
    <jsp:setProperty name="selectedRecord" property="requiredSeats" value="${rs.rows[0].available_seats}" />
    <jsp:setProperty name="selectedRecord" property="ticketPrice" value="${rs.rows[0].ticket_price}" />
    <jsp:setProperty name="selectedRecord" property="travelDate" value="${rs.rows[0].travel_date}" />
    <%--<sql:query var="user" dataSource="${db}"
               sql="select ID, user_name, user_pass from users
                where user_name='${reqUserBean.userName}'
                and user_type='CUSTOMER'"/>

    <jsp:setProperty name="userBean" property="userName" value="${user.rows[0].user_name}"/>
    <jsp:setProperty name="userBean" property="userPass" value="${user.rows[0].user_pass}"/>
    <jsp:setProperty name="userBean" property="ID" value="${user.rows[0].ID}"/>--%>
    <%--------------- Load user and flight detail -----------------------------%>
    <%-- record the booking --%>
    <sql:update dataSource="${db}"
                sql="INSERT INTO booking (customer_id, flight_detail_id, seats_reserved, total_price)
                VALUES
                ( '${customerBean.ID}',
                    '${selectedRecord.ID}',
                     '${criteriaBean.requiredSeats}',
                    (${criteriaBean.requiredSeats} * ${selectedRecord.ticketPrice}))
                "/>
    <sql:query var="id" dataSource="${db}"
               sql="SELECT max(ID) as ID from booking
                    where customer_id = '${customerBean.ID}'
                    and flight_detail_id = '${selectedRecord.ID}'"/>
    ID is "${id.rows[0].ID}"
    <jsp:setProperty name="bookingBean" property="ID" value="${id.rows[0].ID}" />

    <sql:query var="rs" dataSource="${db}"
               sql="SELECT ID, customer_id, flight_detail_id, seats_reserved, total_price
                from booking
                where ID = '${bookingBean.ID}' "/>

    <%--<jsp:setProperty name="bookingBean" property="ID" value="${rs.rows[0].ID}"/>--%>
    <jsp:setProperty name="bookingBean" property="customerID" value="${rs.rows[0].customer_id}"/>
    <jsp:setProperty name="bookingBean" property="reservedSeats" value="${rs.rows[0].seats_reserved}"/>
    <jsp:setProperty name="bookingBean" property="totalPrice" value="${rs.rows[0].total_price}"/>
    <jsp:setProperty name="bookingBean" property="flightDetailID" value="${rs.rows[0].flight_details_id}"/>

    bb reserved seats: "${bookingBean.reservedSeats}"<br>
    bb total_price: ${bookingBean.totalPrice}<br>
    sr seats: ${selectedRecord.requiredSeats} <br>

    <br>Bean ID: "${userBean.ID}"<br>
    customerBean ID:"${customerBean.ID}"<br>
    bookingBean ID: "${bookingBean.ID}"<br>
    selectedRecord ID "${selectedRecord.ID}"<br>
    selectedRecord ID (from param): "${selectedRecordId}"<br>

    <%-- Check that required number of seats is still available --%>
    <%-- begin transaction --%>
    <sql:update dataSource="${db}" sql="START TRANSACTION "/>
    <sql:query var="rs" dataSource="${db}" scope="session"
               sql="SELECT available_seats from flight_detail
        where ID='${selectedRecord.ID}' FOR UPDATE"/>
    sr seats: ${selectedRecord.requiredSeats} <br>
    <jsp:setProperty name="selectedRecord" property="requiredSeats"
                     param="${rs.rows[0].available_seats}"/>
    sr seats: ${selectedRecord.requiredSeats} <br>
    <c:if test="${  'selectedRecord.requiredSeats' >= 'bookingBean.reservedSeats'  }">
        <sql:update dataSource="${db}"
                    sql="UPDATE flight_detail
                            SET available_seats=
                                 '${selectedRecord.requiredSeats - bookingBean.reservedSeats}'
                                    where ID='${selectedRecord.ID}'"/>


        bookingBean ID: "${bookingBean.ID}"<br>
        bb customer_id: "${bookingBean.customerID}"<br>
        bb reserved seats: "${bookingBean.reservedSeats}"<br>
        bb total_price: ${bookingBean.totalPrice}<br>

        sr reserved seats: "${selectedRecord.requiredSeats}"<br>

        <jsp:forward page="ConfirmBooking.jsp"/>
        <%--<a href="ConfirmBooking.jsp">ConfirmBooking</a>--%>
    </c:if>
    <jsp:forward page="NotifyBookingNotAvailable.jsp"/>
</body>
</html>
