<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="flow-from: left; border: blue; border-style: solid ">
    <div><h2>&lt;&lt; SportyShoes - D A S  H  B  O  A R D - SportyShoes  &gt;&gt;</h2></b>
        <form method="GET">
            <button type="submit" formaction="LoginUser">Login</button>
            <button type="submit" formaction="RegisterUser">Register</button>
            <button type="submit" formaction="addProductForm">Product</button>
            <button type="submit" formaction="viewCart">Cart</button>
            <button type="submit" formaction="viewUsers">Users</button>
            <button type="submit" formaction="viewCatalog">Shop</button>
            <button type="submit" formaction="viewOrders">Orders</button>
        </form>
    </div>
    <%--<h4> <%= new Date().toString() %> </h4>--%>

    <%/*
        if( sessionBean.isVerifiedLogin())
        {
            //System.out.print( "<<Admin Page Button>>") ;
            out.print(
                    "<form method=\"get\">" +
                            "<button type=\"submit\" formaction=\"UserLogout.jsp\"> Logout </button></form>");
            out.print("Hello, " + userBean.getUserName());
            if( userBean.getUserType().equals("ADMIN"))
            {

                out.print(
                        "<form method =\"get\">" +
                                "<button type=\"submit\" formaction=\"AdminPage.jsp\">" +
                                "Admin Home </button></form>" ) ;
            }
        }
        else
            out.print(
                    "<form method=\"get\">" +
                            "<button type=\"submit\" formaction=\"UserLogin.jsp\">" +
                            "Login </button></form>" ) ;

        if( (userBean.getUserType() == null ) || !userBean.getUserType().equals("ADMIN")) {
            out.print(
                    "<form method =\"get\">" +
                            "<button type=\"submit\" formaction=\"home.jsp\">" +
                            "Home </button></form>");
        }

    */%>


</div>
</body>
</html>
