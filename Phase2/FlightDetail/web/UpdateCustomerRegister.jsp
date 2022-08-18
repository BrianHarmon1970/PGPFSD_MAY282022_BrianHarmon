<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        label {
            min-width: 40ch ;
            width: 40ch ;
            text-align-all: right;
        }

    </style>
    <title>Title</title>

</head>
<body>
    <jsp:useBean id="userBean"  class="com.harmonengineering.beans.UserBean" scope="session"/>
    <jsp:useBean id="customerBean" class="com.harmonengineering.beans.CustomerBean" scope="session"/>
    <jsp:useBean id="addressBean" class="com.harmonengineering.beans.AddressBean" scope="session" />

    ubean ID:           <c:out value="${userBean.ID}"/> <br>
    cbean ID:    <c:out value="${customerBean.ID}"/><br>
    abean ID:      <c:out value="${addressBean.ID}"/><br>

    cbean firstName:    <c:out value="${customerBean.firstName}"/><br>
    abean zipcode:      <c:out value="${addressBean.zipCode}"/><br>
    <%--<%@ include file="LoadCustomerData.jsp" %>--%>
    <form id="profile_form" action="ConfirmCustomerRegister.jsp" method="get">
        <h3>Personal</h3>
        <label for="profile_form_firstname">First Name:</label><br>
        <input id="profile_form_firstname"   type="text" value="${customerBean.firstName}" name="first_name" /><br>
        <label for="profile_form_lastname">Last Name:</label><br>
        <input id="profile_form_lastname" type="text" value="${customerBean.lastName}" name="last_name" /><br>
        <label for="profile_form_phone">Phone Number:</label><br>
        <input id="profile_form_phone"  type="tel" value="${customerBean.phoneNumber}" name="phone_number" /><br>
        <label for="profile_form_email">Email Address:</label><br>
        <input id="profile_form_email" type="text" value="${customerBean.emailAddress}" name="email_address" /><br>

        <h3>Address</h3>
        <label for="profile_form_street1">Street 1:</label>
        <input id="profile_form_street1" type="text" value="${addressBean.street1}" name="street1" /><br>
        <label for="profile_form_street2">Street 2:</label>
        <input id="profile_form_street2" type="text" value="${addressBean.street2}" name="street2" /><br>
        <label for="profile_form_city">City:</label>
        <input id="profile_form_city" type="text" value="${addressBean.city}" name="city" /><br>
        <label for="profile_form_state">State:</label>
        <input id="profile_form_state" type="text" value="${addressBean.state}" name="state" /><br>
        <label for="profile_form_zipcode">Zipcode:</label>
        <input id="profile_form_zipcode" type="text" value="${addressBean.zipCode}" name="zipcode" /><br>
        <br>
        <button type="submit" formmethod="get" formaction="doUpdateCustomer.jsp">Update</button>
        <button type="submit" formmethod="get" formaction="ConfirmCustomerRegister.jsp">Cancel</button>
    </form>
</body>
</html>
