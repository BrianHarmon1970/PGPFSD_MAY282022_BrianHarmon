<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <sql:setDataSource var="db"
                   driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecommerce"
                   user="root"
                   password="root" /><html>

    <c:catch var="Exception">
    <!-- // UPDATE -->
        <sql:update dataSource="${db}" var="count"
                    sql = "UPDATE eproduct set name='Ibanez RG750', price=1200.00 where ID=100" />
        <!-- // DELETE-->
        <sql:update dataSource="${db}" var="count"
                    sql = "DELETE from eproduct where ID in(101,103)" />

    <jsp:forward page="sqlJSP_DisplayData.jsp" />
    </c:catch>
    <c:if test="${Exception} != null" >
        Error: ${Exception}
    </c:if>
        <c:out value="${Exception}"/>
</body>
</html>
