
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
<jsp:useBean id="customerBean"  class="com.harmonengineering.beans.CustomerBean" scope="session"  />
<jsp:useBean id="addressBean"  class="com.harmonengineering.beans.AddressBean" scope="session" />
<jsp:useBean id="userBean" class="com.harmonengineering.beans.UserBean" scope="session"/>
--%>
<sql:query var="cr" dataSource="${db}"
           sql="SELECT ID, first_name, last_name, phone_number, email_address
                from customer
                where user_id='${userBean.ID}'  "/>
<%--<c:forEach item="item" var="${cr.rows}" > --%>
    <jsp:setProperty name="customerBean" property="ID" value="${cr.rows[0].ID}" />
    <jsp:setProperty name="customerBean" property="firstName" value="${cr.rows[0].first_name}"/>
    <jsp:setProperty name="customerBean" property="lastName" value="${cr.rows[0].last_name}"/>
    <jsp:setProperty name="customerBean" property="phoneNumber" value="${cr.rows[0].phone_number}"/>
    <jsp:setProperty name="customerBean" property="emailAddress" value="${cr.rows[0].email_address}"/>
<%--</c:forEach> --%>

<sql:query var="AddressResult" dataSource="${db}"
           sql="SELECT ID, street_1, street_2, city, state, zipcode
            from address where customer_id = '${customerBean.ID}' "/>
<c:forEach var="item" items="${AddressResult.rows}" >
    <jsp:setProperty name="addressBean" property="ID"   value="${item.ID}"/>
    <jsp:setProperty name="addressBean" property="street1" value="${item.street_1}"/>
    <jsp:setProperty name="addressBean" property="street2" value="${item.street_2}"/>
    <jsp:setProperty name="addressBean" property="city"    value="${item.city}"/>
    <jsp:setProperty name="addressBean" property="state"   value="${item.state}"/>
    <jsp:setProperty name="addressBean" property="zipCode"  value="${item.zipcode}"/>
</c:forEach>
