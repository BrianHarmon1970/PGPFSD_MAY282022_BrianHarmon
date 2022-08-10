<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: black
  Date: 7/30/2022
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Final Record</h1>
<%! int math, chemistry, physics ; %>
<%! String strMath, strChemistry, strPhysics ; %>
<%

   strMath = request.getParameter("math_score" ) ;
   strChemistry = request.getParameter("chemistry_score") ;
   strPhysics = request.getParameter("physics_score") ;

   math = chemistry = physics = 0 ;
    if ( strMath != null && !strMath.isBlank()) math = Integer.parseInt( strMath ) ;
    if ( strChemistry != null && !strChemistry.isBlank()) chemistry = Integer.parseInt( strChemistry ) ;
    if ( strPhysics != null && !strPhysics.isBlank())  physics = Integer.parseInt( strPhysics ) ;
%>
Total marks of 10th: <%= request.getParameter("tenth_marks")   %> <br>
Total marks of 12th: <%= request.getParameter("twelfth_marks") %> <br><br>
Total marks of PCM: <%= (chemistry + math + physics)/3 %>

</body>
</html>
