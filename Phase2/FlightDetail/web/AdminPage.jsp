
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
    <h1> Admin </h1>
    <%--- Admin Password Change --%>
    <div style="border: black; border-style: solid; border-width: 3px;" >

    <form id="change_password" action="UpdatePassword.jsp" method="get" >
    <h2>Password Change</h2>
        <label for="new_password" >New Password:</label>
        <input id="new_password" name="new_password" type="password" size="40" >
        <button type="submit" name="change_password" >Change</button>
    </form></div>

    <h2>Bookings</h2>
    <sql:query dataSource="${db}" var="result"
               sql="SELECT creation_time, statechange_time, booking_status,
                    customer_id, flight_detail_id, seats_reserved, total_price
                    from booking" />
    <div>
        <table style="
        border-color: blue ;
        border-width: 3px ;
        border-style: solid;
        overflow-y: scroll;
        height: 25% ;">
            <thead><tr>
                <td>created</td><td>updated</td><td>status</td><td>customer</td>
                <td>flight detail</td><td>seats</td><td>price</td>
            </tr></thead>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.creation_time}"/></td>
                    <td><c:out value="${row.statechange_time}"/></td>
                    <td><c:out value="${row.booking_status}"/></td>
                    <td><c:out value="${row.customer_id}"/></td>
                    <td><c:out value="${row.flight_detail_id}"/></td>
                    <td><c:out value="${row.seats_reserved}"/></td>
                    <td><c:out value="${row.total_price}"/></td>
                </tr>

            </c:forEach>
        </table></div>


    <h2> Cities </h2>
    <sql:query dataSource="${db}" var="result"
               sql="select ID, city_name from city"/>

    <table style=" border-color:
        deepskyblue;
        border-width: 3px ;
        border-style: solid;" >
        <thead><tr><td>ID</td> <td>NAME</td></tr></thead>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.ID}"/></td>
                <td><c:out value="${row.city_name}"/></td>
            </tr>
        </c:forEach>
    </table>
<%-------- Airlines tabel listing -----%>
    <h2> Airlines </h2>
    <sql:query dataSource="${db}" var="result"
               sql="select ID, airline_name from airline"/>

    <table style=" border-color:
        deepskyblue;
        border-width: 3px ;
        border-style: solid;" >
        <thead><tr><td>ID</td> <td>NAME</td></tr></thead>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.ID}"/></td>
                <td><c:out value="${row.airline_name}"/></td>
            </tr>
        </c:forEach>
    </table>

    <%-- Flight details --%>
    <sql:query var="result" dataSource="${db}" maxRows="10"
               sql="select airline, departure_city,
       arrival_city, available_seats,
       travel_date, ticket_price from VIEW_FDETAILS" />

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
</body>
</html>
