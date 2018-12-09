<%-- 
    Document   : main
    Created on : Dec 9, 2018, 11:00:33 PM
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
        <%@page import="java.util.*,com.apress.projsp.store.*" %>
        <%
            HashMap products = (HashMap)application.getAttribute("products");
            
            //List the products, clickable to add to cart
            Iterator it = products.values().iterator();
            out.println("<table>");
            
            while(it.hasNext()){
                out.println("<tr>");
                Product product = (Product)it.next();
        %>
        
    <td>
        <a href="CartAction?add=true&id=<%=product.getId()%>"><%=product.getName()%></a>
    </td>
    <td>
        <%=product.getPrice()%>
    </td>
    </tr>
    <%}%>
    </table>
    </body>
</html>
