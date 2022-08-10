<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:catch  var="Exception">
    <%--<sql:setDataSource var="db"
                       driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/ecommerce"
                       user="root"
                       password="root" />
                       --%>
        <sql:update dataSource="${db}" var="count" sql = "DELETE from eproduct where ID in(100,101,102,103,104,105,106)" />
        <jsp:forward page="sqlJSP_DisplayData.jsp"/>
    </c:catch>
    <c:if test="${Exception} != null" >
        Error: ${Exception}
    </c:if>
    <c:out value="${Exception}"/>
    <br><a href="sqlJSP.jsp">Home</a>
</body>
</html>