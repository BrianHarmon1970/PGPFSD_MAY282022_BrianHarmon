<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>

<%-- include modification from the form param data --%>
<jsp:setProperty name="customerBean" property="firstName" param="first_name" />
<jsp:setProperty name="customerBean" property="lastName" param="last_name" />
<jsp:setProperty name="customerBean" property="phoneNumber" param="phone_number" />
<jsp:setProperty name="customerBean" property="emailAddress" param="email_address" />

<jsp:setProperty name="addressBean" property="street1" param="street1" />
<jsp:setProperty name="addressBean" property="street2" param="street2" />
<jsp:setProperty name="addressBean" property="city" param="city" />
<jsp:setProperty name="addressBean" property="state" param="state" />
<jsp:setProperty name="addressBean" property="zipCode" param="zipcode" />

<sql:update  dataSource="${db}" sql="UPDATE customer
    set
    first_name='${customerBean.firstName}',
    last_name='${customerBean.lastName}',
    phone_number='${customerBean.phoneNumber}',
    email_address='${customerBean.emailAddress}'
    where
    ID = '${customerBean.ID}' and user_id = '${userBean.ID}' "/>
<sql:update  dataSource="${db}"  sql= "UPDATE address
        set
        street_1 = '${addressBean.street1}',
        street_2 = '${addressBean.street2}',
        city = '${addressBean.city}',
        state = '${addressBean.state}',
        zipcode = '${addressBean.zipCode}'
        where
        ID = '${addressBean.ID}' and customer_id='${customerBean.ID}' "/>

<jsp:forward page="ConfirmCustomerRegister.jsp"/>
</body>
</html>