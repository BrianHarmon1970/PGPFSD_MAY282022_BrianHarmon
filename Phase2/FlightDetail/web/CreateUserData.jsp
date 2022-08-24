<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="DashBoardHeader.jsp"%>
</head>
<body>
<%--%>
userBean.ID is <c:out value="${userBean.ID}"/>.
userBean.name is <c:out value="${userBean.userName}"/>.
<%-- OK to create the User now --%>
<sql:update  dataSource="${db}"
             sql="INSERT INTO users (user_name, user_pass, user_type )
                    VALUES ( '${userBean.userName}',
                                '${userBean.userPass}',
                                'CUSTOMER') "/>
<sql:query var="user" dataSource="${db}"
           sql="select ID , user_type from users
                where user_name='${userBean.userName}'
                and user_type='CUSTOMER'"/>
<jsp:setProperty name="userBean" property="ID"       value="${user.rows[0].ID}"/>
<jsp:setProperty name="userBean" property="userType"       value="${user.rows[0].user_type}"/>

<sql:update dataSource="${db}" sql="INSERT INTO customer
        (first_name, last_name, phone_number, email_address, user_id )
        VALUES
        ( '0x0x0x0','0x0x0x0','0x0x0x0','0x0x0', '${userBean.ID}') "/>
<sql:query var="idc" dataSource="${db}"
           sql="SELECT ID FROM customer where user_id = '$(userBean.ID}' "/>
<jsp:setProperty name="customerBean" property="ID"       value="${idc.rows[0].ID}"/>

<sql:update dataSource="${db}" sql="INSERT INTO address
        (street_1, street_2, city, state, zipcode, customer_id )
        VALUES
        ( '0x0x0','0x0x0','0x0x0','0x0x0','0x0x0x0',(select customer.ID from customer
            where customer.user_id =
            ( select users.ID from users where users.user_name='${userBean.userName}'
                AND user_type = 'CUSTOMER' )))"/>
<sql:query var="ida" dataSource="${db}"
           sql="SELECT ID FROM address where customer_id = '$(customerBean.ID}' "/>
<jsp:setProperty name="addressBean" property="ID"       value="${ida.rows[0].ID}"/>


userBean.ID is <c:out value="${userBean.ID}"/>.
userBean.userType is <c:out value="${userBean.userType}"/>.

customer bean ID:<c:out value="${customerBean.ID}" /><br>
address bean ID: <c:out value="${addressBean.ID}" /><br>


<br>


address bean ID: <c:out value="${addressBean.ID}" /><br>
customer bean ID:<c:out value="${customerBean.ID}" /><br>

<%@include file="LoadCustomerData.jsp"%><%-- Perhaps not really necessary... redundant? --%>
<%-- no its not redundant... This is only user bean head data.. we need also to allocate and load
newly inserted data elements (customer name etc.. address) even if they are initially blank... B>S>H> --%>
<jsp:forward page="UpdateCustomerRegister.jsp"/>
</body>
</html>
