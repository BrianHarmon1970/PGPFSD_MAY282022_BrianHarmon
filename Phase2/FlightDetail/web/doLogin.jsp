<%@ page import="com.harmonengineering.beans.UserBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <title>CheckLogin</title>
</head>
<body>
<%--
<sql:query var="count" dataSource="${db}" sql="SELECT COUNT(*) FROM users " />
users count: <c:out value="${count.rowsByIndex[0][0]}" />
--%>
<jsp:useBean id="customerBean"  class="com.harmonengineering.beans.CustomerBean" scope="session"  />
<jsp:useBean id="addressBean"  class="com.harmonengineering.beans.AddressBean" scope="session" />


<jsp:useBean id="userBean" class="com.harmonengineering.beans.UserBean" scope="session" />
<jsp:useBean id="reqUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />
<%--<jsp:useBean id="sqlUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />--%>

<%
    boolean loginSuccess = true ;
    String userName = (String)request.getParameter("user_name") ;
    String userPass = (String)request.getParameter("password" ) ;
    if ( userName == null  || userPass == null || userName.isEmpty() || userPass.isEmpty())
        loginSuccess = false ;

    // ==============================
    reqUserBean.setUserName( userName ) ;
    reqUserBean.setUserPass( userPass ) ;

%>

<sql:setDataSource var="dbSource"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/phase2"
                   user="root"
                   password="root" />
<c:set var="db" value="${dbSource}" scope="application"/>
<sql:query var="user" dataSource="${db}"
            sql="select ID, user_name, user_pass from users
                where user_name='${reqUserBean.userName}'
                and user_type='CUSTOMER'"/>

<jsp:setProperty name="userBean" property="userName" value="${user.rows[0].user_name}"/>
<jsp:setProperty name="userBean" property="userPass" value="${user.rows[0].user_pass}"/>
<jsp:setProperty name="userBean" property="ID" value="${user.rows[0].ID}"/>
<%
    String uName = userBean.getUserName() ;
    String uPass = userBean.getUserPass() ;
    if (!( uName == null || uPass == null || userName == null || userPass == null) )
    {
        if ( !userName.toLowerCase().equals( uName.toLowerCase() ) || !userPass.equals( uPass ) )
            loginSuccess = false ;
    } else loginSuccess = false ;
%>

SQL UserName: <c:out value="${userBean.userName}" /> <br>
SQL Password: <c:out value="${userBean.userPass}"/> <br>
login UserName: <%= userName == null ? "null" : userName %> <br>
login PassWord: <%= userPass == null ? "null" : userPass %> <br>
<br>
userBean UserName: <c:out value="${userBean.ID}" /> <br>
userBean UserName: <c:out value="${userBean.userName}" /> <br>
userBean Password: <c:out value="${userBean.userPass}"/> <br>
<br>
loginSuccess: <%= loginSuccess %> <br>
<c:if test= "<%= loginSuccess == true%>">
    <jsp:forward page="ConfirmCustomerRegister.jsp"/>
</c:if>
<jsp:forward page="RetryLogin.jsp" />

</body>
</html>
