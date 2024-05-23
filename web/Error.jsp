<%-- 
    Document   : Error
    Created on : 21/05/2024, 7:38:42 a. m.
    Author     : jodon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error page</title>
    </head>
    <body>
        <h1>error</h1>
        
        <!---->
        <% 
        response.sendRedirect("index.jsp");
        %>
    </body>
</html>
