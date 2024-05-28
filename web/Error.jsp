<%-- 
    Document   : Error
    Created on : 21/05/2024, 7:38:42 a.m.
    Author     : jodon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error page</title>
        <link rel="stylesheet" type="text/css" href="css/styles_error.css">
    </head>
    <body>
        <div class="container">
            <h1>error</h1>
            <p>Presione para iniciar sesión.</p>
            <form action="Error.jsp" method="post">
                <button class="button" type="submit">Iniciar Sesión</button>
            </form>
        </div>

        <% 
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            response.sendRedirect("index.jsp");
        }
        %>
    </body>
</html>
