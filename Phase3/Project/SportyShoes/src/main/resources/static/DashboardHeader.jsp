<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title> Dashboard </title>
</head>
<body>
<div style="flow-from: left; border: blue; border-style: solid ">
    <h1> &lt;&lt; SportyShoes - D A S  H  B  O  A R D - SportyShoes  &gt;&gt; </h1>


    <%/*
//        if( sessionBean.isVerifiedLogin())
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
        //FlightDetailBean bean = new FlightDetailBean() ;
        //bean.sprint( out ) ;
        userBean.sprint( out ) ;
        customerBean.sprint( out ) ;
        //criteriaBean.sprint( out);
        //selectionBean.sprint( out ) ;
        //selectedRecord.sprint( out ) ;


    */%>


</div>
</body>
</html>
