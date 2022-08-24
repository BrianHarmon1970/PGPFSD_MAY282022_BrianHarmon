<%@ page import="com.harmonengineering.beans.UserBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8"  %>

<html>
<head>
    <title>CheckLogin</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<%
    boolean RegisterSuccess = true ;
    String userName = request.getParameter("user_name") ;
    String userPass = request.getParameter("password" ) ;
    String confirmPass = request.getParameter("confirm_password" ) ;
    if ( !(userName == null  || userPass == null || confirmPass == null ||
            userName.isEmpty() || userPass.isEmpty() || confirmPass.isEmpty()))
    {
        if( !confirmPass.equals(userPass) )
        {
            RegisterSuccess = false ;
        }
    }else RegisterSuccess = false ;

    // ==============================
    reqUserBean.setUserName( userName ) ;
    reqUserBean.setUserPass( userPass ) ;
%>
RegisterSuccess: <%= RegisterSuccess %> <br>
<%--<sql:setDataSource var="dbSource"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/phase2"
                   user="root"
                   password="root" />
<c:set var="db" value="${dbSource}" scope="session"/>
--%>
<sql:query var="user" dataSource="${db}"
           sql="select  user_name, user_pass from users
                where user_name='${reqUserBean.userName}'
                and user_type='CUSTOMER'"/>

<jsp:setProperty name="userBean" property="userName" value="${user.rows[0].user_name}"/>
<jsp:setProperty name="userBean" property="userPass" value="${user.rows[0].user_pass}"/>
<%
    String uName = userBean.getUserName() ;
    String uPass = userBean.getUserPass() ;
    if (!( uName == null || uPass == null ||
        reqUserBean.getUserName() == null ||
        reqUserBean.getUserPass() == null) )
    {
        if ( reqUserBean.getUserName().toLowerCase().equals( uName.toLowerCase()) )
            RegisterSuccess = false ;// userName already exists!!
    } else RegisterSuccess = false ; // bad data
%>
<c:if test="<%= RegisterSuccess == true%>">
    <%-- OK to create the User now --%>
    <jsp:setProperty name="userBean" property="userName" value="${reqUserBean.userName}"/>
    <jsp:setProperty name="userBean" property="userPass" value="${reqUserBean.userPass}"/>
    user name: <c:out value="${reqUserBean.userName}"/>
    user pass: <c:out value="${reqUserBean.userPass}"/>
    userBean name: <c:out value="${userBean.userName}"/>
    userBean pass: <c:out value="${userBean.userPass}"/>
    <jsp:forward page="CreateUserData.jsp"/>
</c:if>
<%--<jsp:forward page="RetryLogin.jsp" />--%>
</body>
</html>
