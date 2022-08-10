<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html >
<html>
    <head>
        <title> JSP XML Exercise </title>
    </head>
<body>

    <h1>&lt;x:parse&gt; Demo</h1>

    <c:import var="XML" url="/A08062022_01/Employees.xml" />
    <x:parse var="doc" xml="${XML}" />
    <c:set var="type" value="HR" />
    <ol>
        <li> Employee with ${type} dept. ...
        <x:forEach select="$doc/Employees/Employee" var="item" >
            <x:set var="current_row" select="$item"/>
            <x:if  select="$current_row/dept = $type " var="test" >
                <x:out select="$current_row/name" />
            </x:if>
        </x:forEach>
        </li>

        <li> Age of Employee named 'Vinay' ...
            <x:forEach select="$doc/Employees/Employee" var="item" >
                <x:set var="current_row" select="$item"/>
                <x:if  select="$current_row/name = 'Vinay'" >
                    <x:out select="$current_row/age" />
                </x:if>
            </x:forEach>
        </li>

        <li> HR or IT?
            <x:forEach select="$doc/Employees/Employee" var="item" >
                <br>
                <x:set var="current_row" select="$item"/>
                <x:choose>
                    <x:when select="$current_row/dept = 'HR' " >
                        <x:out select="$current_row/name"/>
                         Is in HR department
                    </x:when>
                    <x:when select="$current_row/dept = 'IT' " >
                        <x:out select="$current_row/name"/>
                        Is in IT department
                    </x:when>
                </x:choose>
            </x:forEach>
        </li>
        <li> Young?, or Have you been Experienced?
            <x:forEach select="$doc/Employees/Employee" var="item" >
                <br>
                <x:set var="current_row" select="$item"/>
                <x:choose>
                    <x:when select="$current_row/age < 30">
                        <x:out select="$current_row/name"/> is young.
                    </x:when>
                    <x:when select="$current_row/age >= 30 and $current_row/age <= 35">
                        <x:out select="$current_row/name"/> has been experienced.
                    </x:when>
                </x:choose>
            </x:forEach>
        </li>
        <li> Number[2], Number[3]...
            <br>
            Number[2]  Name/Department  <x:out select="$doc/Employees/Employee[2]/name"/>
            <x:out select="$doc/Employees/Employee[2]/dept"/><br>
            Number[3]  Name/Department <x:out select="$doc/Employees/Employee[3]/name"/>
            <x:out select="$doc/Employees/Employee[3]/dept"/><br>
        </li>
    </ol>
</body>
</html>
