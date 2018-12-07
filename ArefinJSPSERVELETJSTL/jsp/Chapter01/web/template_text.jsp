<%-- 
    Document   : template_text
    Created on : Dec 7, 2018, 7:24:52 PM
    Author     : Safayat_Arefin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page import="com.apress.projsp.CalendarBean" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My JSP Example</title>
    </head>
    <body>
        <jsp:useBean id="cal" class="com.apress.projsp.CalendarBean"/>
        <c:set var="hour" value="${cal.hour}" scope="request" />
        
        <c:choose>
            <c:when test="${hour > 0 && hour <=11}">
                Good Morning!
            </c:when>
            <c:when test="${hour > 12 && hour <=17}">
                Good Afternoon!
            </c:when>
            <c:otherwise>
                Good Evening!
            </c:otherwise>
        </c:choose> 
    </body>
</html>
