<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "s" uri = "http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <sql:sqlDataSource var="db"
                       Driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/ecommerce"
                user="root"
                pass="root" />
    <%-- <c.catch  var="Exception"> --%>
    // INSERT
    <sql:update dataSource="${db}" var="count">
        INSERT INTO eproduct ( ID , name , price) values ( 100, 'Ibanez RG550', 800.00 ) ;
    </sql:update>
    <sql:update dataSource="${db}" var='count'>
        INSERT INTO ecommerce.eproduct ID, name, price values ( 101, 'Ibanez Jem',  2800.00 ) ;
    </sql:update>
    <sql:update dataSource="${db}" var="result">
        INSERT INTO ecommerce.eproduct ID, name, price values ( 102, 'Ibanez Jem Jr. 2014', 600.00 ) ;
    </sql:update>
    <sql:update dataSource="${db}" var="count">
        INSERT INTO ecommerce.eproduct ID, name, price values ( 103, 'Harmonez TMacPinkyBlack', 800.00 ) ;
    </sql:update>
    <sql:update dataSource="${db}" var="count" >
        INSERT INTO ecommerce.eproduct name, price values ( 'Corvette Stingray 1979' ,160000.00 ) ;
    </sql:update>
    <sql:update dataSource="${db}" var="count" >
        INSERT INTO ecommerce.eproduct name, price values ( '1978 Pontiac Trans Am', 67_000.00 ) ;
    </sql:update>
    <sql:update dataSource="${db}" var="count">
        INSERT INTO ecommerce.eproduct name, price values ( 'FakeItMaket Gibson SG', 100.00 ) ;
    </sql:update>

    // UPDATE
    <sql:update dataSource="${db}" var="count">
        UPDATE eproduct set name='Ibanez RG750', price=1200.00 where ID=100" ;
    </sql:update>
    // DELETE
    <sql:update dataSource="${db}" var="count" >
        DELETE from ecommerce.eproduct where ID in(101,103) ;
    </sql:update>

    // HTML TABLE OUT
        <-- table row formout output records in HTML only rows between 101 and 104 ( inclusive )-->
    <sql:query dataSource="${db}" var="rs" rs="${result}"
        sql="select ID, name, price, date_added from ecommerce.eproduct" >
    </sql:query>

    <table>
        <thead><tr><td>ID</td> <td>NAME</td><td>PRICE</td> <td>DATE_ADDED</td></tr></thead>
    <c:forEach var="item" items="${result}">
        <tr>
            <td><c:out value="${item}.ID}"/></td>
            <td><c:out value="${item}.name}"/></td>
            <td><c:out value="${item}.price}"/></td>
            <td><c:out value="${item}.date_added}"/></td>
        </tr>
    </c:forEach>
    </table>
<--- delete 101 and 103 -->

    <%--
</c:catch>
    <c.if test="${Exception} != null" >
        Error: ${Exception}
    </c.if>
    <c.out>"${Exception}"</c.out>
        --%>
</body>
</html>
