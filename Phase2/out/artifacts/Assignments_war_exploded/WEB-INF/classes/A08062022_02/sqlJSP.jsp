<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="dbSource"
                   driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecommerce"
                   user="root"
                   password="root" /><html>
<c:set var="db" value="${dbSource}" scope="session"/>

<a href="sqlJSP_InsertData.jsp">Create Dataset</a><br>
<a href="sqlJSP_UpdateData.jsp">Modify Dataset</a><br>
<a href="sqlJSP_DeleteData.jsp">Delete Dataset</a><br>
<a href="sqlJSP_DisplayData.jsp">Display Dataset</a><br>

</body>
</html>
