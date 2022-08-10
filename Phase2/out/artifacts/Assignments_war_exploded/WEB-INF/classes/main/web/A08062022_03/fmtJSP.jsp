<%@page contentType ="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<%@page import="java.util.Date" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <style> p{ margin-left: 20px; }</style>
        <title>JSP FMT Exercise</title>
    </head>
    <body>

    <c:set var="date" value="<%= new java.util.Date()%>" />
    <fmt:formatDate type = "both" value = "${date}"/>
    <h2>Marks Sheet</h2>
        <h3 align="right"> Date: <c:out value="${date}"/></h3>
            <div style="border: solid #3E6B8A;">
                <c:set var="m1" value="85.034" />
                <c:set var="m2" value="83.245" />
                <c:set var="m3" value="95.932" />
                <c:set var="m4" value="98.99" />
                <c:set var="m5" value="92.392" />

                <h3><b>Marks</b></h3>
                <p>Marks 1: <fmt:formatNumber type="number" maxFractionDigits="2" value="${m1}"/> : 100</p>
                <p>Marks 2: <fmt:formatNumber type="number" maxFractionDigits="2" value="${m2}"/> : 100</p>
                <p>Marks 3: <fmt:formatNumber type="number" maxFractionDigits="2" value="${m3}"/> : 100</p>
                <p>Marks 4: <fmt:formatNumber type="number" maxFractionDigits="2" value="${m4}"/> : 100</p>
                <p>Marks 5: <fmt:formatNumber type="number" maxFractionDigits="2" value="${m5}"/> : 100</p>
            </div>
        <c:set var="mTotal" value="${m1+m2+m3+m4+m5}"/>
        <h3>Total Marks:&lt;<fmt:formatNumber type="number" maxFractionDigits="2" value="${mTotal}"/>&gt;</h3>
        <h3>Percentage: <fmt:formatNumber type="percent" maxFractionDigits="2" value="${mTotal/500}"/></h3>

        <div style="border: solid #3E6B8A;">
            <c:set var="Fees1" value="2350.29"/>
            <c:set var="Fees2" value="2475.90"/>
            <c:set var="Fees3" value="3209.34"/>
            <c:set var="Fees4" value="2800.00"/>

            <h3><b>Fees Paid by Semester</b></h3>
            <p style="margin-left: 10px">Semester 1:  <fmt:formatNumber type="currency" value="${Fees1}"/></p>
            <p style="margin-left: 10px">Semester 2:  <fmt:formatNumber type="currency" value="${Fees2}"/></p>
            <p style="margin-left: 10px">Semester 3:  <fmt:formatNumber type="currency" value="${Fees3}"/></p>
            <p style="margin-left: 10px">Semester 4:  <fmt:formatNumber type="currency" value="${Fees4}"/></p>
        </div>
        <h3><b>Total Paid Fees: <fmt:formatNumber type="currency" value="${Fees1+Fees2+Fees3+Fees4}"/></b></h3>
    </body>
</html>
