<%@ page import="com.harmonengineering.beans.UserBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <title>CheckLogin</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<%--
<sql:query var="count" dataSource="${db}" sql="SELECT COUNT(*) FROM users " />
users count: <c:out value="${count.rowsByIndex[0][0]}" />
--%>

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

<%--<sql:setDataSource var="dbSource"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/phase2"
                   user="root"
                   password="root" />
<c:set var="db" value="${dbSource}" scope="application"/>--%>
<sql:query var="user" dataSource="${db}"
            sql="select ID, user_name, user_pass, user_type from users
                where user_name='${reqUserBean.userName}'"/>

<jsp:setProperty name="userBean" property="userName" value="${user.rows[0].user_name}"/>
<jsp:setProperty name="userBean" property="userPass" value="${user.rows[0].user_pass}"/>
<jsp:setProperty name="userBean" property="userType" value="${user.rows[0].user_type}"/>
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
loginSuccess: <%= loginSuccess %> <br>
<c:if test= "<%= loginSuccess == true%>">
    <% if ( userBean.getUserType().equals("ADMIN")) {
        sessionBean.setVerifiedLogin(true) ;
        pageContext.forward("AdminPage.jsp");
    }
    %>
    <jsp:include page="LoadCustomerData.jsp"/>
    <jsp:forward page="LoggedIn.jsp"/>
</c:if>
<jsp:forward page="RetryLogin.jsp" />

</body>
</html>
