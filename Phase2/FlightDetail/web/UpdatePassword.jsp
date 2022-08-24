<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/23/2022
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>
<%
    boolean dataValid = false ;
    String oldPassword = userBean.getUserPass() ;
    String newPassword = request.getParameter("new_password") ;
    out.println("new password: " + newPassword);
    if( newPassword != null && !newPassword.isEmpty())
        dataValid= true ;
%>

<c:if test="<%=dataValid%>" > <%---------- Update Password --%>
    <% userBean.setUserPass( newPassword ); %>
    <sql:update dataSource="${db}"
            sql="UPDATE users set user_pass='${userBean.userPass}'
            where ID = '${userBean.ID}' "/>
</c:if>
<c:if test="<%=!dataValid%>" > <%--------- Error --%>

    <c:out value="Please enter a valid password."/>
    <form method="get">
        <button type="submit" formaction="AdminPage.jsp">Ok</button>
    </form>
</c:if>
</body>
</html>
