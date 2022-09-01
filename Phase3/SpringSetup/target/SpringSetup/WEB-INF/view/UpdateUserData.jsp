<%--
File: UpdateUserData.jsp
  User: black
  Date: 8/31/2022
  Time: 3:28 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<jsp:useBean id="UserBean" class="com.ecommerce.entity.EUsers" scope="session"/>
    <h2>Update User</h2>


    <div id="id_user_data">
    <form action="userUpdate" method="get">
        <text>${UserBean.userName}</text><br>
        <label for="id_first_name" >First name:</label>
            <input id="id_first_name" name="first_name" value="${UserBean.firstName}"/><br>
        <label for="id_last_name" >Last name:</label>
            <input id="id_last_name" name="last_name" value="${UserBean.lastName}"/><br>
            <button type="submit">Update</button>
    </form>
    </div>
</body>
</html>
