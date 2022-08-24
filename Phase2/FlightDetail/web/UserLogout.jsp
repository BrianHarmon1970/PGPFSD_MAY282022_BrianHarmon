<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/19/2022
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <%@ include file="DashBoardHeader.jsp" %>
</head>
<body>
    <%--"${ sessionBean.verifiedLogin = false }"--%>
    <% sessionBean.setVerifiedLogin(false);%>
    <jsp:setProperty name="userBean" property="userType" value=""/>
    <jsp:setProperty name="userBean" property="userPass" value=""/>
    <jsp:setProperty name="userBean" property="userName" value=""/>
    <jsp:setProperty name="userBean" property="ID" value=""/>

    <jsp:setProperty name="customerBean" property="phoneNumber" value=""/>
    <jsp:setProperty name="customerBean" property="emailAddress" value=""/>
    <jsp:setProperty name="customerBean" property="firstName" value=""/>
    <jsp:setProperty name="customerBean" property="lastName" value=""/>
    <jsp:setProperty name="customerBean" property="ID" value=""/>


    <jsp:setProperty name="addressBean" property="street1" value=""/>
    <jsp:setProperty name="addressBean" property="street2" value=""/>
    <jsp:setProperty name="addressBean" property="city" value=""/>
    <jsp:setProperty name="addressBean" property="state" value=""/>
    <jsp:setProperty name="addressBean" property="zipCode" value=""/>
    <jsp:setProperty name="addressBean" property="ID" value=""/>

    <jsp:forward page="BookFlight.jsp"/>
</body>
</html>
