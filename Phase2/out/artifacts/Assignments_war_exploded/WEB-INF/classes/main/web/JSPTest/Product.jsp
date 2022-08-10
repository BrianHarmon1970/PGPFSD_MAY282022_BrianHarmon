<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="product" class="jspbean.ProductBean" scope="session" />
<jsp:setProperty name="product" property="*"/>

<jsp:setProperty name="product" property="name" value="Fender USA Stratocaster"/>
<jsp:setProperty name="product" property="price" value="5000.00"/>
<jsp:setProperty name="product" property="ID" value="201"/>

<jsp:include page="emp.jsp"/>

<p>Forwarding..</p>
<jsp:forward page="forward.jsp"/>

</body>
</html>
