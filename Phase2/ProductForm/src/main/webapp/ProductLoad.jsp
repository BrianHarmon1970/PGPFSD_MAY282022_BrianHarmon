<%--===================== File: TestLoad.jsp ====================================--%>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.ecommerce.EProduct" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by
  User: black
  Date: 8/30/2022
  Time: 12:30 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="Validator" scope="page" class="com.harmonengineering.beans.ValidatorBean"/>
<jsp:useBean id="EProductBean" scope="session" class="com.ecommerce.EProduct" />
<jsp:setProperty name="EProductBean" property="ID" value="0" />
<jsp:setProperty name="EProductBean" property="name" param="product_name" />
<%--<jsp:setProperty name="EProductBean" property="price" param="<%= %>"/>--%>
<%

    String strPrice = request.getParameter("product_price") ;
    if ( Validator.isValidText(strPrice) && Validator.isValidNumber(strPrice))
            EProductBean.setPrice(BigDecimal.valueOf(Double.parseDouble(strPrice)));
%>
<jsp:setProperty name="EProductBean" property="dateAdded" value="<%= (new Date()) %>"/>

<jsp:forward page="ProductDisplay.jsp" />

</body>
</html>
