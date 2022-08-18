<%@ page import="com.harmonengineering.beans.SessionStatusBean" %><%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/15/2022
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/Register</title>
</head>
<body>
<jsp:useBean id="customerBean"  class="com.harmonengineering.beans.CustomerBean" scope="session"  />
<jsp:useBean id="addressBean"  class="com.harmonengineering.beans.AddressBean" scope="session" />


<%--
<% System.out.print( "LoginRegister.jsp " ) ; %>
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session"/>
<% sessionBean.setSessionState( SessionStatusBean.SessionState.Update ) ; %>
--%>

    <h1>Login/Register</h1>
    <form>

        <label for="register_button">Don't have an account?:</label><br>
        <button id="register_button" type="submit" formaction="Register.jsp" >New Customer</button>
<br><br>
        <label for="login_button">Login with existing account:</label><br>
        <button id="login_button" type="submit" formaction="UserLogin.jsp" >Existing Customer</button>
    </form>


<%--
<form><button type="submit" formaction="BookFlight.jsp" formmethod="get">Confirm</button></form>
--%>
</body>
</html>
