<%-- 
    Document   : logout
    Created on : Jan 11, 2019, 6:20:52 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            session.removeAttribute("loginUser");
        %>
        <a href="index.jsp">Login</a>
    </body>
</html>