<%--
  File: confirmUserUpdate.jsp
  User: black
  Date: 8/31/2022
  Time: 7:40 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Updated</title>
</head>
<body>
<jsp:useBean id="UserBean" scope="session" class="com.ecommerce.entity.EUsers"/>
<h2>User Updated</h2>
<p>${UserBean.userName}</p>
<p>${UserBean.firstName} ${UserBean.lastName}</p>
<form>
    <button type="submit" formaction="home">Home</button>
</form>
</body>
</html>
