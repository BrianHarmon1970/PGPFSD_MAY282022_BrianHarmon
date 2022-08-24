<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<% System.out.print( "Loggedin.jsp " ) ; %>
<%
    if (sessionBean.getSessionState() == SessionStatusBean.SessionState.LoginRegister )
        sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ;
%>
<c:set var="sessionBean" property="userLoginName" value="${userBean.userName}"/>
<% sessionBean.setVerifiedLogin( true ) ; %>
<jsp:forward page="BookFlight.jsp"/>
</body>
</html>