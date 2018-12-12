<%-- 
    Document   : complexBean
    Created on : Dec 12, 2018, 10:14:39 AM
    Author     : User
--%>
<jsp:useBean id="person" class="com.apress.projsp.Preson">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL and Complex JavaBeans</title>
        <style>
            body, td{
                font-family: verdana;
                font-size: 10pt;
            }
        </style>
    </head>
    <body>
        <h2>EL and Complex JavaBeans</h2>
        <table border="1">
            <tr>
                <td>${person.name}</td>
                <td>${person.age}</td>
                <td>${person.address.line1}</td>
                <td>${person.address.town}</td>
                
            </tr>
        </table>
    </body>
</html>
