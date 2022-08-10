<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>
    JSP XML Exercise
</title>
</head>
<body>

<h1>&lt;x:parse&gt; Demo</h1>

<%--<c.catch var="Exception" ></c.catch>--%>
<%--
<x:parse var="doc" xml="/A06082022/Citizens.xml"/> <%-- ${citizenXML}" />
<x:out select="$doc/citizens/citizen[1]/ssn" />
<x:out select="$doc/citizens/citizen[1]/firstname" />
<x:out select="$doc/citizens/citizen[1]/lastname" />
--%>

<x:parse var="doc" >
    Employees.xml
</x:parse>
<x:out select="$doc/Employees/Employee/name"/>

<%--
<c.if test="%{Exception} != null">
    Error: ${Excpetion}
</c.if>
--%>
</body>
</html>
