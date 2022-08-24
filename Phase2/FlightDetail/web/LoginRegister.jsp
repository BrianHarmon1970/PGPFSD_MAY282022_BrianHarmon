<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page import="com.harmonengineering.beans.StringBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/Register</title>
    <%@ include file="DashBoardHeader.jsp"%>
</head>
<body>
<jsp:useBean id="jspForward" class="com.harmonengineering.beans.StringBean"/>
<%
    if (sessionBean.isVerifiedLogin())
    {
         //jspForward.setStrBean( "<jsp:forward page=\"LoggedIn.jsp\"/>" ) ;
        //jspForward.setStrBean( "LoggedIn.jsp" ) ;

        pageContext.forward( "LoggedIn.jsp") ;
        //<jsp:forward page="'${ jspForward.strBean }'"/>
    }
%>


<%--<c:if test="${sessionBean.verifiedLogin} == true" >
    <jsp:forward page="LoggedIn.jsp"/>
</c:if>--%>
    <h1>Login/Register</h1>
    <form>
        <label for="register_button">Don't have an account?:</label><br>
        <button id="register_button" type="submit" formaction="Register.jsp" >New Customer</button>
<br><br>
        <label for="login_button">Login with existing account:</label><br>
        <button id="login_button" type="submit" formaction="UserLogin.jsp" >Existing Customer</button>
    </form>

<%--
<% System.out.print( "LoginRegister.jsp " ) ; %>
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
<form><button type="submit" formaction="BookFlight.jsp" formmethod="get">Confirm</button></form>
--%>

</body>
</html>
