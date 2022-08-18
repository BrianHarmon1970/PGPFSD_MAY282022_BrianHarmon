<%@ page import="com.harmonengineering.beans.UserBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8"  %>

<html>
<head>
    <title>CheckLogin</title>
</head>
<body>
<jsp:useBean id="customerBean"  class="com.harmonengineering.beans.CustomerBean" scope="session"  />
<jsp:useBean id="addressBean"  class="com.harmonengineering.beans.AddressBean" scope="session" />


<jsp:useBean id="reqUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />
<jsp:useBean id="sqlUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />

<%
    boolean RegisterSuccess = true ;
    String userName = (String)request.getParameter("user_name") ;
    String userPass = (String)request.getParameter("password" ) ;
    String confirmPass = request.getParameter("confirm_password" ) ;
    if ( !(userName == null  || userPass == null || confirmPass == null ||
            userName.isEmpty() || userPass.isEmpty() || confirmPass.isEmpty()))
    {
        if( !confirmPass.equals(userPass) )
        {
            RegisterSuccess = false ;
        }
    }    else RegisterSuccess = false ;

    // ==============================
    reqUserBean.setUserName( userName ) ;
    reqUserBean.setUserPass( userPass ) ;
%>
RegisterSuccess: <%= RegisterSuccess %> <br>
<sql:setDataSource var="dbSource"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/phase2"
                   user="root"
                   password="root" />
<c:set var="db" value="${dbSource}" scope="session"/>
<sql:query var="user" dataSource="${db}"
           sql="select user_name, user_pass from users
                where user_name='${reqUserBean.userName}'
                and user_type='CUSTOMER'"/>

<jsp:setProperty name="sqlUserBean" property="userName" value="${user.rows[0].user_name}"/>
<jsp:setProperty name="sqlUserBean" property="userPass" value="${user.rows[0].user_pass}"/>
<%
    String uName = sqlUserBean.getUserName() ;
    String uPass = sqlUserBean.getUserPass() ;
    if (!( uName == null || uPass == null ||
        reqUserBean.getUserName() == null ||
        reqUserBean.getUserPass() == null) )
    {
        if ( reqUserBean.getUserName().toLowerCase().equals( uName.toLowerCase() ) )
            RegisterSuccess = false ;// userName already exists!!
    } else RegisterSuccess = false ; // bad data
%>
<jsp:useBean id="userBean" scope="session" class="com.harmonengineering.beans.UserBean" />
<%--<jsp:setProperty name="userBean" property="ID" value="${reqUserBean.ID}"/>--%>
<jsp:setProperty name="userBean" property="userName" value="${reqUserBean.userName}"/>
<jsp:setProperty name="userBean" property="userPass" value="${reqUserBean.userPass}"/>
<%--<jsp:setProperty name="userBean" property="userType" value="${reqUserBean.userType}"/>--%>

SQL UserName: <c:out value="${sqlUserBean.userName}" /> <br>
SQL Password: <c:out value="${sqlUserBean.userPass}"/> <br>
login UserName: <%= userName == null ? "null" : userName %> <br>
login PassWord: <%= userPass == null ? "null" : userPass %> <br>
<br>
reqBean useName: ${reqUserBean.userName} <br>
reqBean password: ${reqUserBean.userPass} <br>
<br>
userBean UserName: <c:out value="${userBean.ID}" /> <br>
userBean UserName: <c:out value="${userBean.userName}" /> <br>
userBean Password: <c:out value="${userBean.userPass}"/> <br>

<br>
RegisterSuccess: <%= RegisterSuccess %> <br>


<c:if test="<%= RegisterSuccess == true%>">
    <%-- OK to create the User now --%>
    <%--<sql:update  dataSource="${db}"
                sql="INSERT INTO users (user_name, user_pass, user_type )
                    VALUES ( '${reqUserBean.userName}',
                                '${reqUserBean.userPass}',
                                'CUSTOMER') "/>
    <sql:update dataSource="${db}" sql="INSERT INTO customer
        (first_name, last_name, phone_number, email_address, user_id )
        VALUES
        ( '','','','', (select ID from users where user_name='${reqUserBean.userName}'))"/>
    <sql:update dataSource="${db}" sql="INSERT INTO address
        (street_1, street_2, city, state, zipcode, customer_id )
        VALUES
        ( '','','','','',(select ID from customer where user_id =
            ( select ID from users where user_name='${reqUserBean.userName}')))"/>--%>
    <%--<jsp:forward page="ConfirmCustomerRegister.jsp"/>--%>
  <%--<jsp:forward page="UpdateCustomerRegister.jsp"/>--%>
    <jsp:forward page="CreateUserData.jsp"/>
</c:if>
<%--<jsp:forward page="RetryLogin.jsp" />--%>
</body>
</html>
