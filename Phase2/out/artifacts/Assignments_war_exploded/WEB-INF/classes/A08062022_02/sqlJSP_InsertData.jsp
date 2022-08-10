<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:catch  var="Exception">
    <sql:setDataSource var="db"
        driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecommerce"
                   user="root"
                   password="root" />
    <!-- // INSERT -->
    <sql:update dataSource="${db}" var="count"
        sql="INSERT INTO eproduct  (ID , name , price) values ( 100, 'Ibanez RG550', 800.00 )" />
    <sql:update dataSource="${db}" var='count'
        sql= "INSERT INTO eproduct (ID, name, price) values ( 101, 'Ibanez Jem',  2800.00 )" />
    <sql:update dataSource="${db}" var="result"
        sql= "INSERT INTO eproduct (ID, name, price) values ( 102, 'Ibanez Jem Jr. 2014', 600.00 )" />
    <sql:update dataSource="${db}" var="count"
        sql = "INSERT INTO eproduct (ID, name, price) values ( 103, 'Harmonez TMacPinkyBlack', 800.00 )" />
    <sql:update dataSource="${db}" var="count"
        sql= "INSERT INTO eproduct (ID, name, price) values ( 104, 'Corvette Stingray 1979' ,160000.00 )" />
    <sql:update dataSource="${db}" var="count"
        sql= "INSERT INTO eproduct (ID, name, price) values ( 105, '1978 Pontiac Trans Am', 67000.00 )" />
    <sql:update dataSource="${db}" var="count"
        sql= "INSERT INTO eproduct (ID, name, price) values ( 106, 'FakeItMaket Gibson SG', 100.00 )" />

    <jsp:forward page="sqlJSP_DisplayData.jsp"/>
</c:catch>
    <c:if test="${Exception} != null" >
        Error: ${Exception}
    </c:if>
    <c:out value="${Exception}"/>
    <br><a href="sqlJSP.jsp">Home</a>
</body>
</html>
