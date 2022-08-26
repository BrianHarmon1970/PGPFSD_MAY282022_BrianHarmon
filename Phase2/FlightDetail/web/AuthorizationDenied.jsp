<%--
  Created by IntelliJ IDEA.
  User: black
  Date: 8/24/2022
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization Denied</title>
</head>
<body>
<h2> A u t h o r i z a t i o n   ---    D e n i e d </h2>
<h3> We are sorry, your request for payment authorization has been denied. Please try with another payment method.</h3>
<form>
    <button type="submit" formaction="UserPaymentAuthorization.jsp" formmethod="get">Retry</button>
    <button type="submit" formaction="CancelBooking.jsp" formmethod="get">Cancel</button>
</form>
</form>

</body>
</html>
