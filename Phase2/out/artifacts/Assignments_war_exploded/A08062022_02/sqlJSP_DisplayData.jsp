<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%-- <sql:setDataSource var="db"
        driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/ecommerce"
                       user="root"
                       password="root" /><html>
--%>
    <c:catch var="Exception">
    <sql:query dataSource="${db}" var="result"
               sql="select ID, name, price, date_added from eproduct"/>

        <table style=" border-color:
        deepskyblue;
        border-width: 3px ;
        border-style: solid;" >
        <thead><tr><td>ID</td> <td>NAME</td><td>PRICE</td> <td>DATE_ADDED</td></tr></thead>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.ID}"/></td>
                <td><c:out value="${row.name}"/></td>
                <td><c:out value="${row.price}"/></td>
                <td><c:out value="${row.date_added}"/></td>
            </tr>
        </c:forEach>
    </table>
   </c:catch>
   <c:if test="${Exception} != null" >
           Error: ${Exception}

   </c:if>
    <c:out value="${Exception}"/>

    <br><a href="sqlJSP.jsp">Home</a>
</body>
</html>
