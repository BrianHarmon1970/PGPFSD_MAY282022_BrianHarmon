<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page import="com.harmonengineering.beans.FlightDetailBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="com.harmonengineering.beans.SessionStatusBean" %>
<%@ page import="com.harmonengineering.beans.StringBean" %>
<%@ page import="com.harmonengineering.beans.BookingBean" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="sessionBean" class="com.harmonengineering.beans.SessionStatusBean" scope="session" />
<jsp:useBean id="customerBean"  class="com.harmonengineering.beans.CustomerBean" scope="session"  />
<jsp:useBean id="addressBean"  class="com.harmonengineering.beans.AddressBean" scope="session" />
<jsp:useBean id="userBean" class="com.harmonengineering.beans.UserBean" scope="session"/>
<jsp:useBean id="bookingBean" scope="session" class="com.harmonengineering.beans.BookingBean"/>
<jsp:useBean id="criteriaBean" class="com.harmonengineering.beans.FlightDetailBean" scope="session"/>
<jsp:useBean id="selectionBean" class="com.harmonengineering.beans.FlightDetailBean" scope="session"  />
<jsp:useBean id="selectedRecord" class="com.harmonengineering.beans.FlightDetailBean" scope="session"/>

<%-- doLogin ripped --%>
<%--<jsp:useBean id="reqUserBean" class="com.harmonengineering.beans.UserBean" scope="session" /> --%>
<jsp:useBean id="sqlUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />

<%-- doRegister --%>
<jsp:useBean id="reqUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />
<%--<jsp:useBean id="sqlUserBean" class="com.harmonengineering.beans.UserBean" scope="session" />--%>


<sql:setDataSource var="dbSource"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/phase2"
                   user="root"
                   password="root"
                   scope="session" />
<c:set var="db" value="${dbSource}" scope="session"/>




<div style="flow-from: left; border: blue; border-style: solid ">
<h1> &lt;&lt; flyaway - D A S  H  B  O  A R D - flyaway  &gt;&gt; </h1>


    <%
        if( sessionBean.isVerifiedLogin())
        {
            System.out.print( "<<Admin Page Button>>") ;
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


        FlightDetailBean bean = new FlightDetailBean() ;
        //bean.sprint( out ) ;
        userBean.sprint( out ) ;
        customerBean.sprint( out ) ;
        //criteriaBean.sprint( out);
        //selectionBean.sprint( out ) ;
        //selectedRecord.sprint( out ) ;


    %>


</div>
</body>
</html>
