<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <Title> Test JSP    </Title>
    <%@ include file="DashBoardHeader.jsp"%>
</head>

<body>
    <h1>Flight Finder</h1>
    <form name="flight_search_criteria" action="FlightDetailResult.jsp" method="get">
        <label for="airline_name">Airline:</label><br>
            <input id="airline_name" type="text" name="airline_name" list="airline_list" ><br>
        <label for="departure_city">Departing from:</label><br>
            <input type="search" list="cities_list" name="departure_city" id="departure_city" ><br>
        <label for="arrival_city">Arriving at:</label><br>
            <input list="cities_list" id="arrival_city" name="arrival_city" ><br>
        <label for="required_seats" >Available Seats:</label><br>
            <input id="required_seats" name="required_seats" type="number"><br>
        <label for="travel_date">Date:</label><br>
            <input id="travel_date" name="travel_date" type="date" ><br>
        <button type="submit">Find It!</button>
    </form>


<c:catch var="Exception">
<%--    <h2> Cities </h2>
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
    --%>
    <%-- =============================================================--%>
    <%-- DATA SET FOR CITY SELECTION CRITERIA --%>
    <datalist id="cities_list" >
    <sql:query dataSource="${db}" var="result"
               sql="select ID, city_name from city"/>
        <c:forEach var="row" items="${result.rows}">
            <option value="${row.city_name}"></option>
        </c:forEach>
    </datalist>

    <%-- DATA SET FOR AIRLINT SELECTION CRITERIA --%>
    <sql:query dataSource="${db}" var="result"
               sql="select ID, airline_name from airline"/>
    <datalist id="airline_list" >
        <c:forEach var="row" items="${result.rows}">
            <option value="${row.airline_name}"></option>
        </c:forEach>
    </datalist>


    <%--================================================================--%>
</c:catch>
<c:if test="${Exception} != null" >
    Error: ${Exception}

</c:if>
<c:out value="${Exception}"/>
</body>
</html>